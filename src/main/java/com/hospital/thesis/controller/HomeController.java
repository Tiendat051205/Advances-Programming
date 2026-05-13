package com.hospital.thesis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /**
     * Trang chủ
     * URL: http://localhost:8080/
     */
    @GetMapping("/")
    public String home() {
        return "home";
    }

    /**
     * Trang đăng nhập
     * URL: http://localhost:8080/login
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * Trang đăng ký
     * URL: http://localhost:8080/register
     */
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * Dashboard học viên
     * URL: http://localhost:8080/student/dashboard
     */
    @GetMapping("/student/dashboard")
    public String studentDashboard() {
        return "student/dashboard";
    }

    /**
     * Dashboard giảng viên
     * URL: http://localhost:8080/lecturer/dashboard
     */
    @GetMapping("/lecturer/dashboard")
    public String lecturerDashboard() {
        return "lecturer/dashboard";
    }

    /**
     * Dashboard admin
     * URL: http://localhost:8080/admin/dashboard
     */
    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin/dashboard";
    }
}
