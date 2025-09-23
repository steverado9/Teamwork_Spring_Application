package com.steverado9.Teamwork.controller;

import ch.qos.logback.core.model.Model;
import com.steverado9.Teamwork.entity.User;
import com.steverado9.Teamwork.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping("api/v1/auth/create_user")
    public String createUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "create_user";
    }
}
