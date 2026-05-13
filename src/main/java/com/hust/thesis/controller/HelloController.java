package com.hust.thesis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String sayHello() {
        return "Chào mừng bạn đến với hệ thống Quản lý Đề tài!";
    }
}