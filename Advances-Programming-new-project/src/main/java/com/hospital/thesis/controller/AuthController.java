package com.hospital.thesis.controller;

import com.hospital.thesis.entity.User;
import com.hospital.thesis.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/do-login")
    public String doLogin(@RequestParam String username,
                          @RequestParam String password,
                          HttpSession session,
                          Model model) {

        User user = userService.checkLogin(username, password);

        if (user == null) {
            model.addAttribute("error", "Sai tài khoản hoặc mật khẩu");
            return "login";
        }

        session.setAttribute("currentUser", user);

        switch (user.getUserRole()) {
            case student:
                return "redirect:/student/StudentPage";

            case lecturer:
                return "redirect:/lecturer/lecturePage";

            case admin:
                return "redirect:/admin/dashboard";

            default:
                return "redirect:/";
            }
    }
}