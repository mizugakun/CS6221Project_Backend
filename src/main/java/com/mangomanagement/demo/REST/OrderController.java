package com.mangomanagement.demo.REST;

import com.mangomanagement.demo.Entity.*;
import com.mangomanagement.demo.Service.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
            storage.setPurchaseFrequency(new BigDecimal(0));
            storage.setPurchaseFrequency_User(new BigDecimal(0));
        }
        storage.setRemaining(storage.getRemaining() + number);
        storageService.save(storage);

        return "shop successfully.";

    }
}
