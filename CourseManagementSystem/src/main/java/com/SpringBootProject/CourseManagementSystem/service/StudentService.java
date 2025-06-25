package com.SpringBootProject.CourseManagementSystem.service;

import com.SpringBootProject.CourseManagementSystem.dto.CourseListDTO;
import com.SpringBootProject.CourseManagementSystem.dto.CourseRequestFormDTO;
import com.SpringBootProject.CourseManagementSystem.entity.CourseRequestForm;
import com.SpringBootProject.CourseManagementSystem.entity.course;
import com.SpringBootProject.CourseManagementSystem.entity.student;
import com.SpringBootProject.CourseManagementSystem.repository.CourseRequestFormRepository;
import com.SpringBootProject.CourseManagementSystem.repository.StudentRepository;
import com.SpringBootProject.CourseManagementSystem.repository.CourseRepository;
//import com.SpringBootProject.CourseManagementSystem.entity.studentCourses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository ;

    @Autowired
    private CourseRepository courseRepository ;

    @Autowired
    private CourseRequestFormRepository courseRequestFormRepository ;

    public void updateStudent(Long id, student updatedStudent) {
        // Find the student by ID
        student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        // Update the student's details
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setPassword(updatedStudent.getPassword());

        // Save the updated student
        studentRepository.save(existingStudent);
    }

    public student getStudentDetails(Long id){
        student detStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        return detStudent ;
    }

    public List<CourseListDTO> getCourseList() {
        List<course> courses = courseRepository.findAll();
        return courses.stream()
                .map(c -> new CourseListDTO(c.getName(), c.getId(), c.getProfessor().getName(), c.getCredit()))
                .collect(Collectors.toList());
    }

    public void submitCourseForm(CourseRequestFormDTO formDTO) {
        student student = studentRepository.findById(formDTO.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found with id " + formDTO.getStudentId()));

        CourseRequestForm requestForm = new CourseRequestForm(
                student,
                formDTO.getRequestedCourseIds(),
                formDTO.getRequestedDate()
        );

        courseRequestFormRepository.save(requestForm);
    }

}
