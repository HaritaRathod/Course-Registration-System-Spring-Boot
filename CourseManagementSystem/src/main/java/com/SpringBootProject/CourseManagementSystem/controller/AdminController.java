package com.SpringBootProject.CourseManagementSystem.controller;

import com.SpringBootProject.CourseManagementSystem.dto.AddCourseDTO;
import com.SpringBootProject.CourseManagementSystem.entity.course;
import com.SpringBootProject.CourseManagementSystem.entity.professor;
import com.SpringBootProject.CourseManagementSystem.entity.semester;
import com.SpringBootProject.CourseManagementSystem.entity.student;
import com.SpringBootProject.CourseManagementSystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/add-Course")
    public ResponseEntity<String> addCourse(@RequestBody AddCourseDTO courseDTO) {
        adminService.addCourse(courseDTO);
        return ResponseEntity.ok("Course added successfully!");
    }

    @PostMapping("/add-Professor")
    public professor addProfessor(@RequestBody professor professor) {
        return adminService.addProfessor(professor);
    }

    @PostMapping("/add-Semester")
    public semester addSemester(@RequestBody semester semester) {
        return adminService.addSemester(semester);
    }

    @PostMapping("/add-Student")
    public student addStudent(@RequestBody student student) {
        return adminService.addStudent(student);
    }

    @PutMapping("/update-course/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable Long id , @RequestBody AddCourseDTO updatedCourse){
        adminService.updateCourse(id, updatedCourse) ;
        return ResponseEntity.ok("Course updated successfully!");
    }

    @PutMapping("/update-semester/{id}")
    public ResponseEntity<String> updateSemester(@PathVariable Long id , @RequestBody semester updatedSemester){
        try{
            adminService.updateSemester(id, updatedSemester);
            return ResponseEntity.ok("Semester updated successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()) ;
        }
    }

    @DeleteMapping("/delete-student/{id}")
    public void deleteStudent(@RequestBody Long id){
        adminService.deleteStudent(id);
    }

    @DeleteMapping("/delete-professor/{id}")
    public void deleteProfessor(@RequestBody Long id){
        adminService.deleteProfessor(id);
    }

    @DeleteMapping("/delete-course/{id}")
    public void deleteCourse(@RequestBody Long id){
        adminService.deleteCourse(id);
    }

    @GetMapping("/send-mail-notification")
    public String sendEmailNotification(){
        return adminService.sendEmailNotification();
    }

    @PostMapping("/assign-course")
    public ResponseEntity<String> assignCourses() {
        adminService.assignCourses();
        return ResponseEntity.ok("Courses assigned successfully!");
    }

    @PostMapping("/send-course-assign-mail")
    public ResponseEntity<String> sendAssignedCoursesEmail() {
        adminService.sendAssignedCoursesEmail();
        return ResponseEntity.ok("Emails sent successfully!");
    }

}
