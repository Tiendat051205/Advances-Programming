package com.hospital.thesis.service;

import com.hospital.thesis.Repository.UserRepository;
import com.hospital.thesis.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // =========================
    // Kiểm tra đăng nhập
    // =========================
    public User checkLogin(String userName, String password) {

        Optional<User> userOpt = userRepository.findByUserName(userName);

        if (userOpt.isPresent()) {

            User user = userOpt.get();

            // kiểm tra password
            if (user.getUserPassword().equals(password)) {

                // kiểm tra tài khoản còn hoạt động
                if (user.getIsActive()) {
                    return user;
                }
            }
        }

        return null;
    }
}