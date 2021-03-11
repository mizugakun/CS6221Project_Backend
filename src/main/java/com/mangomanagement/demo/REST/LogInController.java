package com.mangomanagement.demo.REST;

import com.mangomanagement.demo.Entity.User;
import com.mangomanagement.demo.Service.UserService;
import com.mangomanagement.demo.blo.UserLogIn;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/login")
public class LogInController {
    private final UserService userService;

    public LogInController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String logIn(@RequestBody UserLogIn logInString) {

        String account = logInString.getAccount();
        String password = logInString.getPassword();

        User u = userService.findByAccount(account);
        if (u == null) {
            return "the account does not exist.";
        } else if (!u.getUserPassword().equals(password)) {
            return "wrong password";
        } else {
            return "log in successfully.";
        }
    }
}
