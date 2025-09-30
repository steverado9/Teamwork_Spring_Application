package com.steverado9.Teamwork.controller;

import com.steverado9.Teamwork.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.dao.DataIntegrityViolationException;
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
    public String createUserForm(Model model, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        //not logged in, send to loggin page
        if (loggedInUser == null) {
            return "redirect:/api/v1/auth/sign_in";
        }

        if (!loggedInUser.getJobRole().equalsIgnoreCase("admin")) {
            return "redirect:/access_denied";
        }

        User user = new User();
        model.addAttribute("user", user);
        return "create_user";
    }

    @PostMapping("/api/v1/auth/create_user")
    public String saveUser(@ModelAttribute("user") User user, Model model, HttpSession session) {
        try {
            User loggedInUser = (User) session.getAttribute("loggedInUser");

            if (loggedInUser == null) {
                return "redirect:/api/v1/auth/sign_in";
            }

            if (loggedInUser.getJobRole().equalsIgnoreCase("admin")) {
                return "redirect:/access_denied";
            }

            userService.saveUser(user);
            return "redirect:/api/v1/auth/sign_in";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("errorMessage", "Email already exists!");
            return "/api/v1/auth/create_user";
        }
    }

    @GetMapping("/api/v1/auth/sign_in")
    public String signInForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "sign_in";
    }

    @PostMapping("/api/v1/auth/sign_in")
    public String getUser(@ModelAttribute("user") User user, Model model, HttpSession session) {
        //get a particular user using the email, return a user or null
        User existingUser = userService.getUserByEmail(user.getEmail());

        if(existingUser == null) {
            System.out.println("user does not exist");
            model.addAttribute("errorMessage", "invalid email and password");
            return "sign_in";
        }

        String existingPassword = existingUser.getPassword();
        if (!user.getPassword().equalsIgnoreCase(existingPassword)) {
            System.out.println("Incorrect password");
            model.addAttribute("errorMessage", "invalid email and password");
            return "sign_in";
        }

        //store the logged in(existing user) in session
        session.setAttribute("loggedInUser", existingUser);

        if (existingUser.getJobRole().equalsIgnoreCase("admin")) {
            return "feeds";
        }
        return "feedForEmployee";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); //clears everything in session
        return "redirect:/api/v1/auth/sign_in";
    }

    //page not found
    @GetMapping("/")
    public String home() {
        System.out.println("Home");
        return "redirect:/api/v1/auth/sign_in";
    }
}
