package com.mangomanagement.demo.REST;

import com.mangomanagement.demo.Entity.Item;
import com.mangomanagement.demo.Entity.StorageDetail;
import com.mangomanagement.demo.Entity.User;
import com.mangomanagement.demo.Service.ItemService;
import com.mangomanagement.demo.Service.StorageService;
import com.mangomanagement.demo.Service.UserService;
import com.mangomanagement.demo.blo.StorageInfo;
import org.springframework.web.bind.annotation.*;

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
        List<StorageDetail> list = storageService.findStorageList(user.getUserId());
        List<StorageInfo> res = new ArrayList<>();

        for (StorageDetail detail : list) {
            Item item = itemService.findById(detail.getItemId());
            StorageInfo info = new StorageInfo(item.getItemId(), item.getItemName(), detail.getRemaining());
            res.add(info);
        }
        System.out.println("haha");

        return res;
    }

    @PostMapping("addNewItem")
    public void addItem(@RequestBody Item item) {
        itemService.save(item);
    }

    @PostMapping("addNewItemIntoStorage")
    public String addNewItem(@RequestParam("userAccount") String userAccount, @RequestParam("number") Integer number, @RequestBody Item item) {

        String log = "";
        // check whether there is a same item in the item table
        Item oldItem = itemService.findByName(item.getItemName());

        if (oldItem != null) {
            log += ("add item " + "\n" +  item.toString() + "\n");
            String str = "Item is already existed.\n";
            System.out.print(str);
            log += (oldItem.toString() + "\n");
            log += str;
        } else {
            addItem(item);
            oldItem = itemService.findByName(item.getItemName());
        }

        User user = userService.findByAccount(userAccount);
        StorageDetail storageDetail = storageService.findStorage(user.getUserId(), oldItem.getItemId());

        // check whether the item has been already in user's storage.
        if (storageDetail != null) {
            String str = "You already have this item in your storage\n";
            System.out.print(str);
            log += (str + storageDetail.toString() + "\n");
            storageDetail.setRemaining(number);
        } else {
            storageDetail = new StorageDetail();
            storageDetail.setItemId(oldItem.getItemId());
            storageDetail.setRemaining(number);
            storageDetail.setUserId(user.getUserId());
        }
        storageService.save(storageDetail);

        if (log.length() != 0) {
            return log;
        } else {
            return "Update item and storage successfully.";
        }
    }
}