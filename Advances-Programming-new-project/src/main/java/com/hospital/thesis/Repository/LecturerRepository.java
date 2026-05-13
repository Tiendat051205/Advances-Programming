package com.hospital.thesis.Repository;

import com.hospital.thesis.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {
}