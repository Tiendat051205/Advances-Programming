package com.hospital.thesis.controller;

import com.hospital.thesis.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lecturer")
public class LecturerController {

    @GetMapping("/page")
    public String lecturerPage(HttpSession session, Model model) {

        User user = (User) session.getAttribute("currentUser");

        // chưa đăng nhập
        if (user == null) {
            return "redirect:/login";
        }

        // không phải lecturer
        if (user.getUserRole() != User.Role.lecturer) {
            return "redirect:/login";
        }

        model.addAttribute("user", user);

        return "lecturer/lecturePage";
    }
}