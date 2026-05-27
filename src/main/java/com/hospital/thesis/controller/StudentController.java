package com.hospital.thesis.controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.thesis.entity.Student;
import com.hospital.thesis.Repository.StudentRepository;
import com.hospital.thesis.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/page")
    public String studentPage(HttpSession session, Model model) {

        User user = (User) session.getAttribute("currentUser");

        // chưa đăng nhập
        if (user == null) {
            return "redirect:/login";
        }

        // không phải student
        if (user.getUserRole() != User.Role.student) {
            return "redirect:/login";
        }
        Student student = studentRepository.findByUser_UserID(user.getUserID()).orElse(null);
        model.addAttribute("user", user);
        model.addAttribute("student", student);

        return "student/StudentPage";
    }
}