package com.SpringBootProject.CourseManagementSystem.repository;

import com.SpringBootProject.CourseManagementSystem.entity.professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<professor, Long> {
}
