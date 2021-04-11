package com.mangomanagement.demo.REST;

import com.mangomanagement.demo.Entity.Item;
import com.mangomanagement.demo.Entity.StorageDetail;
import com.mangomanagement.demo.Entity.User;
import com.mangomanagement.demo.Service.ItemService;
import com.mangomanagement.demo.Service.StorageService;
import com.mangomanagement.demo.Service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/storage")
public class StorageController {
    private final StorageService storageService;
    private final ItemService itemService;
    private final UserService userService;
    public StorageController(StorageService storageService, ItemService itemService, UserService userService)  {
        this.storageService = storageService;
        this.itemService = itemService;
        this.userService = userService;
    }


    @PostMapping("EditStorageRemaining")
    public String editStorage(@RequestParam("userAccount") String userAccount,
                              @RequestParam("remaining") Integer remaining,
                              @RequestParam("itemName") String itemName)
    {
        User user = userService.findByAccount(userAccount);
        Item item = itemService.findByName(itemName);
        StorageDetail detail = storageService.findStorage(user.getUserId(), item.getItemId());
        detail.setRemaining(remaining);
        storageService.save(detail);
        return "update successfully.";
    }

    @PostMapping("updateConsumption")
    public String updateConsumption(@RequestParam("userAccount") String userAccount,
                                    @RequestParam("itemName") String itemName,
                                    @RequestParam("quantity") double quantity)
    {
        User user = userService.findByAccount(userAccount);
        Item item = itemService.findByName(itemName);
        StorageDetail detail;
        try {
            detail = storageService.findStorage(user.getUserId(), item.getItemId());
        } catch (Exception ex) {
            return "you don't have this item in your storage.";
        }
        detail.setPurchaseFrequency_User(quantity);
        storageService.save(detail);
        return "update successfully.";
    }
}
