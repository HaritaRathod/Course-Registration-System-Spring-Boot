package com.SpringBootProject.CourseManagementSystem.repository;

import com.SpringBootProject.CourseManagementSystem.entity.student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<student, Long> {
}
