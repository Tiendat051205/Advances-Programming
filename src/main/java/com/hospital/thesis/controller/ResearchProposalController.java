package com.hospital.thesis.controller;

import com.hospital.thesis.entity.*;
import com.hospital.thesis.Repository.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/student")
public class ResearchProposalController {

    @Autowired
    private ResearchProposalRepository proposalRepository;
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private LecturerRepository lecturerRepository;
    
    @Autowired
    private AdminDepartmentRepository departmentRepository;

    @PostMapping("/submit-proposal")
    public String submitProposal(
            @RequestParam String maGiay,
            @RequestParam String tenDeTai,
            @RequestParam String loaiDeTai,
            @RequestParam String giangVien,
            @RequestParam String khoaPhong,
            @RequestParam String diaDiem,
            @RequestParam String doiTuong,
            @RequestParam String tgBatDau,
            @RequestParam String tgKetThuc,
            @RequestParam String ppNghienCuu,
            @RequestParam(required = false) String moTa,
            HttpSession session,
            Model model) {

        // Lấy user đang đăng nhập
        User currentUser = (User) session.getAttribute("currentUser");
        
        if (currentUser == null) {
            return "redirect:/login";
        }

        // Tìm Student từ UserID
        Student student = studentRepository.findByUser_UserID(currentUser.getUserID())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thông tin học viên"));

        // Tìm Lecturer theo tên (cần điều chỉnh theo database của bạn)
        Lecturer lecturer = lecturerRepository.findByFullNameContaining(giangVien)
                .stream().findFirst().orElse(null);

        // Lấy department mặc định (có thể cho phép chọn sau)
        AdminDepartment department = departmentRepository.findById(1).orElse(null);

        // Tạo ResearchProposal mới
        ResearchProposal proposal = new ResearchProposal();
        proposal.setStudent(student);
        proposal.setLecturer(lecturer);
        proposal.setDepartment(department);
        proposal.setTitle(tenDeTai);
        proposal.setObjective(moTa != null ? moTa : "");
        proposal.setResearchMethod(ppNghienCuu);
        proposal.setTargetGroup(doiTuong);
        proposal.setResearchType(loaiDeTai);
        proposal.setFacultyDepartment(khoaPhong);
        proposal.setResearchLocation(diaDiem);
        proposal.setStartDate(LocalDate.parse(tgBatDau));
        proposal.setEndDate(LocalDate.parse(tgKetThuc));
        proposal.setSubmittedAt(LocalDateTime.now());
        proposal.setProposalStatus(ResearchProposal.ProposalStatus.Pending);

        // Lưu vào database
        proposalRepository.save(proposal);

        model.addAttribute("success", "Gửi đề nghị thành công!");
        return "redirect:/student/page?success=true";
    }
}