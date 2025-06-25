package com.SpringBootProject.CourseManagementSystem.repository;

import com.SpringBootProject.CourseManagementSystem.entity.semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<semester, Long>{
}
