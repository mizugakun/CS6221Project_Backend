package com.mangomanagement.demo.REST;

import com.mangomanagement.demo.Entity.*;
import com.mangomanagement.demo.Service.*;
import com.mangomanagement.demo.blo.StorageInfo;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    final private UserService userService;
    final private OrderService orderService;
    final private ItemService itemService;
    final private OrderDetailService orderDetailService;
    final private StorageService storageService;

    public OrderController(UserService userService, OrderService orderService, ItemService itemService,
                           OrderDetailService orderDetailService, StorageService storageService) {
        this.userService = userService;
        this.orderService = orderService;
        this.itemService = itemService;
        this.orderDetailService = orderDetailService;
        this.storageService = storageService;
    }

    @PostMapping("shop")
    public String shopOneItem(@RequestParam("userAccount") String userAccount, @RequestParam("itemName") String ItemName, @RequestParam("number") Integer number) {
        User user = userService.findByAccount(userAccount);
        Item item = itemService.findByName(ItemName);

        OrderHistory history = new OrderHistory();
        Integer id = orderService.lastId() + 1;
        history.setUserId(user.getUserId());
        history.setOrderId(id);
        history.setOrderDate(LocalDateTime.now());
        orderService.save(history);

        OrderDetail detail = new OrderDetail();
        detail.setOrderId(id);
        detail.setItemId(item.getItemId());
        detail.setAmount(number);
        orderDetailService.save(detail);

        StorageDetail storage;
        try {
            storage = storageService.findStorage(user.getUserId(), item.getItemId());
        } catch (Exception ex) {
            storage = new StorageDetail();
            storage.setUserId(user.getUserId());
            storage.setItemId(item.getItemId());
            storage.setRemaining(0);
            storage.setPurchaseFrequency(0.0);
            storage.setPurchaseFrequency_User(0.0);
        }
        storage.setRemaining(storage.getRemaining() + number);
        storageService.save(storage);

        updatePurchaseFrequency(user.getUserId(), item.getItemId());
        return "shop successfully.";
    }

    @GetMapping("purchaseReminding")
    public List<StorageInfo> remindUser(@RequestParam("userAccount") String userAccount) {
        User user = userService.findByAccount(userAccount);
        List<StorageDetail> details = storageService.findStorageList(user.getUserId());
        List<StorageInfo> res = new ArrayList<>();

        for (StorageDetail detail : details) {
            double purchaseFrequency = detail.getPurchaseFrequency_User() == 0.0 ?
                    detail.getPurchaseFrequency() : detail.getPurchaseFrequency_User();

            // if purchasing frequency larger than remaining, then no need to buy
            if (detail.getRemaining() >= purchaseFrequency) { continue;}

            // otherwise alert user
            res.add(new StorageInfo(detail.getItemId(),
                                    itemService.findById(detail.getItemId()).getItemName(),
                                    detail.getRemaining(),
                                    purchaseFrequency));
        }

        return res;
    }

    private void updatePurchaseFrequency(Integer userId, Integer itemId) {
        List<OrderHistory> orderHistories = orderService.findByUserId(userId);
        List<Integer> ids = new ArrayList<>();
        for (OrderHistory h : orderHistories) {
            ids.add(h.getOrderId());
        }
        List<OrderDetail> details = orderDetailService.findByOrderAndItem(ids, itemId);

        // get first date of buying the item and summing up the total number of the items
        LocalDateTime beginning = null;
        LocalDateTime ending = null;
        double amount = 0;

        int len = details.size();
        for (int i = 0 ; i < len; i++) {
            OrderDetail detail = details.get(i);
            if (i != len - 1) {
                amount += detail.getAmount();
            }

            LocalDateTime date = orderService.findByOrderId(detail.getOrderId()).getOrderDate();
            beginning = beginning == null ? date : beginning;
            ending = date;
        }

        // calculate the frequency
        long days = calculatePeriod(beginning, ending);
        double frequency = getFrequency(amount, days);

        StorageDetail detail = storageService.findStorage(userId, itemId);
        detail.setPurchaseFrequency(frequency);
        storageService.save(detail);
    }

    private double getFrequency(double amount, long days) {
        double frequency = 0.0;
        if (days != 0) {
            frequency = (amount / days) * 7;
        }
        return frequency;
    }

    private long calculatePeriod(LocalDateTime beginning, LocalDateTime ending) {
        Duration d = Duration.between(beginning, ending);
        return d.toDays();
    }

}
