package com.mangomanagement.demo.REST;

import com.mangomanagement.demo.Entity.User;
import com.mangomanagement.demo.Service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("getInfo")
    public User getUserInfo(@RequestParam("userAccount") String userAccount) {
        return userService.findByAccount(userAccount);
    }

    @PostMapping("editPurchaseDate")
    public String updatePurchaseDate(@RequestParam("userAccount") String userAccount, @RequestParam("date") int date) {
        if (date < 0 || date > 7) {
            throw new RuntimeException("The week day is out of bound. Please insert a number within 0 to 6");
        }

        User user = userService.findByAccount(userAccount);
        user.setPurchaseWeekDay(date);
        userService.save(user);
        return "update purchase date to " + date;
    }
}
