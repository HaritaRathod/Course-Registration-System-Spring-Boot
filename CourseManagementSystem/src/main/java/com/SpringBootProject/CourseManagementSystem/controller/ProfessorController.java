package com.SpringBootProject.CourseManagementSystem.controller;

import com.SpringBootProject.CourseManagementSystem.dto.ProfessorCourseSummaryDTO;
//import com.SpringBootProject.CourseManagementSystem.entity.student;
import com.SpringBootProject.CourseManagementSystem.service.ProfessorService ;
import com.SpringBootProject.CourseManagementSystem.entity.professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorService professorService ;

    @PutMapping("/update-professor/{id}")
    public ResponseEntity<String> updateProfessor(@PathVariable Long id, @RequestBody professor updatedProfessor) {
        professorService.updateProfessor(id, updatedProfessor); // Delegate logic to the service layer
        return ResponseEntity.ok("Professor updated successfully!");
    }

    @GetMapping("/details-prof/{id}")
    public professor getProfDetails(@PathVariable("id") Long id){
        return professorService.getProfessorDetails(id) ;
    }

    @GetMapping("/course-professor/{id}")
    public List<ProfessorCourseSummaryDTO> getCoursesByProfessorId(@PathVariable("id") Long professorId) {
        return professorService.getCoursesByProfessorId(professorId);
    }
}
