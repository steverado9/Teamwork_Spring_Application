package com.steverado9.Teamwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.steverado9.Teamwork.entity.User;
import com.steverado9.Teamwork.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping("/api/v1/auth/create_user")
    public String createUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "create_user";
    }

    @GetMapping("/api/v1/auth/sign_in")
    public String signInForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "sign_in";
    }
}
