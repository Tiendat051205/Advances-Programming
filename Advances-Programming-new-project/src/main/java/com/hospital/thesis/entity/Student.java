package com.hospital.thesis.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StudentID")
    private Integer studentID;

    @OneToOne
    @JoinColumn(name = "UserID")
    private User user;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "StudentYear")
    private Integer studentYear;

    @Column(name = "Faculty")
    private String faculty;

    @Column(name = "University")
    private String university;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "DateOfBirth")
    private LocalDate dateOfBirth;

    @Column(name = "Address")
    private String address;
}