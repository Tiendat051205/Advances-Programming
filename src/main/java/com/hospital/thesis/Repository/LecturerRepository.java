package com.hospital.thesis.Repository;
import java.util.List;

import com.hospital.thesis.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {
    List<Lecturer> findByFullNameContaining(String fullName);

}
