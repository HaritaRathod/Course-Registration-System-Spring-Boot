package com.SpringBootProject.CourseManagementSystem.repository;

import com.SpringBootProject.CourseManagementSystem.entity.studentCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentCoursesRepository extends JpaRepository<studentCourses, Long> {
    @Query("SELECT sc FROM studentCourses sc WHERE sc.course.id = :courseId")
    List<studentCourses> findByCourseId(@Param("courseId") Long courseId);
}
