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
    public String doLogin(@RequestParam String userName,
                          @RequestParam String password,
                          HttpSession session,
                          Model model) {

        User user = userService.checkLogin(userName, password);

        if (user == null) {
            model.addAttribute("error", "Sai tài khoản hoặc mật khẩu");
            return "login";
        }
        if (user.getIsActive() == null || !user.getIsActive()) {
            model.addAttribute("error", "Tài khoản của bạn đã bị khóa!");
            return "login";
        }

        // ✅ Kiểm tra role có null không
        if (user.getUserRole() == null) {
            model.addAttribute("error", "Cấu hình tài khoản không hợp lệ!");
            return "login";
        }

        session.setAttribute("currentUser", user);
        model.addAttribute("user", user);

        switch (user.getUserRole()) {
            case student:
                return "redirect:/student/page";

            case lecturer:
                return "redirect:/lecturer/page";

            case admin:
                return "redirect:/admin/dashboard";

            default:
                return "redirect:/";
            }
    }
}