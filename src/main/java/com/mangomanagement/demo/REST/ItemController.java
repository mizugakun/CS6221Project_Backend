package com.mangomanagement.demo.REST;

import com.mangomanagement.demo.Entity.Item;
import com.mangomanagement.demo.Entity.StorageDetail;
import com.mangomanagement.demo.Entity.User;
import com.mangomanagement.demo.Service.ItemService;
import com.mangomanagement.demo.Service.StorageService;
import com.mangomanagement.demo.Service.UserService;
import com.mangomanagement.demo.ServiceImpl.UserServiceImpl;
import com.mangomanagement.demo.blo.StorageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    private final StorageService storageService;
    private final ItemService itemService;
    private final UserService userService;

    public ItemController(StorageService storageService, ItemService itemService, UserService userService)  {
        this.storageService = storageService;
        this.itemService = itemService;
        this.userService = userService;
    }

    @GetMapping("userStorage")
    public List<StorageInfo> findUserStorage(@RequestParam("userAccount") String userAccount) {
        User user = userService.findByAccount(userAccount);
        List<StorageDetail> list = storageService.findById(user.getUserId());
        List<StorageInfo> res = new ArrayList<>();

        for (StorageDetail detail : list) {
            Item item = itemService.findById(detail.getItemId());
            StorageInfo info = new StorageInfo(item.getItemId(), item.getItemName(), detail.getRemaining());
            res.add(info);
        }
        System.out.println("haha");

        return res;
    }
}
