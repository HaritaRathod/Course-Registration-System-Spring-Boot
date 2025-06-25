package com.SpringBootProject.CourseManagementSystem.controller;

import com.SpringBootProject.CourseManagementSystem.dto.CourseListDTO;
import com.SpringBootProject.CourseManagementSystem.dto.CourseRequestFormDTO;
//import com.SpringBootProject.CourseManagementSystem.entity.CourseRequestForm;
//import com.SpringBootProject.CourseManagementSystem.entity.course;
import com.SpringBootProject.CourseManagementSystem.entity.student;
//import com.SpringBootProject.CourseManagementSystem.entity.studentCourses;
import com.SpringBootProject.CourseManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PutMapping("/update-student/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody student updatedStudent) {
        studentService.updateStudent(id, updatedStudent); // Delegate logic to the service layer
        return ResponseEntity.ok("Student updated successfully!");
    }

    @GetMapping("/get-course-list")
    public List<CourseListDTO> getAllCourses(){
        return studentService.getCourseList();
    }

    @GetMapping("/details/{id}")
    public student getDetails(@PathVariable("id") Long id){
        return studentService.getStudentDetails(id) ;
    }

    @PostMapping("/submit-course-form")
    public ResponseEntity<String> submitCourseForm(@RequestBody CourseRequestFormDTO formDTO) {
        studentService.submitCourseForm(formDTO);
        return ResponseEntity.ok("Course request form submitted successfully!");
    }
}
