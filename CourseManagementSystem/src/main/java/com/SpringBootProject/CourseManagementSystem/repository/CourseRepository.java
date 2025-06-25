package com.SpringBootProject.CourseManagementSystem.repository;

import com.SpringBootProject.CourseManagementSystem.dto.ProfessorCourseSummaryDTO;
import com.SpringBootProject.CourseManagementSystem.entity.course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CourseRepository extends JpaRepository<course, Long> {
    @Query("SELECT new com.SpringBootProject.CourseManagementSystem.dto.ProfessorCourseSummaryDTO(c.name, c.credit) " +
            "FROM course c WHERE c.professor.id = :professorId")
    List<ProfessorCourseSummaryDTO> findCoursesByProfessorId(Long professorId);

}
