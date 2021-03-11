package com.mangomanagement.demo.REST;

import com.mangomanagement.demo.Entity.User;
import com.mangomanagement.demo.Service.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/login")
public class LogInController {
    private final UserService userService;

    public LogInController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String logIn(@RequestBody User user) {
        User u = userService.findByAccount(user.getUserAccount());
        if (u == null) {
            return "the account does not exist.";
        } else if (u.getUserPassword() != user.getUserAccount()) {
            return "wrong password";
        } else {
            return "log in successfully.";
        }

    }
}
