package com.example.studentapi.repository;

import com.example.studentapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByCourse(String course);

    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email, Long id);
}