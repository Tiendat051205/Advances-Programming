package com.hospital.thesis.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Research_Proposal")
public class ResearchProposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProposalID")
    private Integer proposalID;

    // =========================
    // Foreign Keys
    // =========================

    @ManyToOne
    @JoinColumn(name = "StudentID")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "LecturerID")
    private Lecturer lecturer;

    @ManyToOne
    @JoinColumn(name = "DepartmentID")
    private AdminDepartment department;

    // =========================
    // Proposal Info
    // =========================

    @Column(name = "Title")
    private String title;

    @Column(name = "Objective", columnDefinition = "TEXT")
    private String objective;

    @Column(name = "ResearchMethod", columnDefinition = "TEXT")
    private String researchMethod;

    @Column(name = "TargetGroup")
    private String targetGroup;

    @Column(name = "ResearchType")
    private String researchType;

    @Column(name = "FacultyDepartment")
    private String facultyDepartment;

    @Column(name = "ResearchLocation")
    private String researchLocation;

    @Column(name = "StartDate")
    private LocalDate startDate;

    @Column(name = "EndDate")
    private LocalDate endDate;

    @Column(name = "SubmittedAt")
    private LocalDateTime submittedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "ProposalStatus")
    private ProposalStatus proposalStatus;

    @Column(name = "ReviewNote", columnDefinition = "TEXT")
    private String reviewNote;

    // =========================
    // Enum
    // =========================

    public enum ProposalStatus {
        Pending,
        Approved,
        Rejected
    }

    // =========================
    // Getter & Setter
    // =========================

    public Integer getProposalID() {
        return proposalID;
    }

    public void setProposalID(Integer proposalID) {
        this.proposalID = proposalID;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public AdminDepartment getDepartment() {
        return department;
    }

    public void setDepartment(AdminDepartment department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getResearchMethod() {
        return researchMethod;
    }

    public void setResearchMethod(String researchMethod) {
        this.researchMethod = researchMethod;
    }

    public String getTargetGroup() {
        return targetGroup;
    }

    public void setTargetGroup(String targetGroup) {
        this.targetGroup = targetGroup;
    }

    public String getResearchType() {
        return researchType;
    }

    public void setResearchType(String researchType) {
        this.researchType = researchType;
    }

    public String getFacultyDepartment() {
        return facultyDepartment;
    }

    public void setFacultyDepartment(String facultyDepartment) {
        this.facultyDepartment = facultyDepartment;
    }

    public String getResearchLocation() {
        return researchLocation;
    }

    public void setResearchLocation(String researchLocation) {
        this.researchLocation = researchLocation;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    public ProposalStatus getProposalStatus() {
        return proposalStatus;
    }

    public void setProposalStatus(ProposalStatus proposalStatus) {
        this.proposalStatus = proposalStatus;
    }

    public String getReviewNote() {
        return reviewNote;
    }

    public void setReviewNote(String reviewNote) {
        this.reviewNote = reviewNote;
    }
}