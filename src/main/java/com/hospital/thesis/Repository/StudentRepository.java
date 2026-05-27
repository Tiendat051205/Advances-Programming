package com.hospital.thesis.Repository;
import java.util.Optional;

import com.hospital.thesis.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findByUser_UserID(Integer userID);

}
