package com.SpringBootProject.CourseManagementSystem.service;

import com.SpringBootProject.CourseManagementSystem.dto.ProfessorCourseSummaryDTO;
import com.SpringBootProject.CourseManagementSystem.entity.professor ;
import com.SpringBootProject.CourseManagementSystem.entity.student;
import com.SpringBootProject.CourseManagementSystem.repository.CourseRepository;
import com.SpringBootProject.CourseManagementSystem.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository ;

    @Autowired
    private CourseRepository courseRepository ;

    public void updateProfessor(Long id, professor newProfessorDetails) {
        professor existingProfessor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor not found with id " + id));
        existingProfessor.setName(newProfessorDetails.getName());
        existingProfessor.setEmail(newProfessorDetails.getEmail());
        existingProfessor.setPassword(newProfessorDetails.getPassword());
        professorRepository.save(existingProfessor);
    }

    public professor getProfessorDetails(Long id){
        professor detProfessor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor not found with id: " + id));
        return detProfessor ;
    }

    public List<ProfessorCourseSummaryDTO> getCoursesByProfessorId(Long professorId) {
        return courseRepository.findCoursesByProfessorId(professorId);
    }
}
