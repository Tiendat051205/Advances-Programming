package com.hospital.thesis.Repository;

import com.hospital.thesis.entity.AdminDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDepartmentRepository extends JpaRepository<AdminDepartment, Integer> {
}