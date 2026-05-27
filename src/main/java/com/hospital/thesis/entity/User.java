package com.hospital.thesis.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Integer userID;

    @Column(name = "UserName", unique = true, nullable = false)
    private String userName;

    @Column(name = "UserPassword", nullable = false)
    private String userPassword;

    @Enumerated(EnumType.STRING)
    @Column(name = "UserRole")
    private Role userRole;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @Column(name = "IsActive")
    private Boolean isActive;

    public enum Role {
        student,
        lecturer,
        admin
    }

    // Getter & Setter

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }
}