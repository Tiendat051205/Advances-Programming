package com.hospital.thesis.controller;

import com.hospital.thesis.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("currentUser");
        
        if (user == null || user.getRole() != User.Role.student) {
            return "redirect:/login";
        }
        
        model.addAttribute("user", user);
        return "student/dashboard";
    }
}