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

}