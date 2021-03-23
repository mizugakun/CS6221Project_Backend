package com.mangomanagement.demo.REST;

import com.mangomanagement.demo.Entity.User;
import com.mangomanagement.demo.Service.UserService;
import com.mangomanagement.demo.blo.UserSignUp;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/signup")
public class SignUpController {

    private final UserService userService;

    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String singUp(@RequestBody User user){
        userService.save(user);
        return "You have successful SignUp!";
    }
}
