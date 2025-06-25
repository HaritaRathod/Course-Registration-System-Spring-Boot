package com.SpringBootProject.CourseManagementSystem.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class CourseRequestForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private student student;

    @ElementCollection
    private List<Long> requestedCourseIds;

    private LocalDateTime requestedDate;

    // Default Constructor
    public CourseRequestForm() {}

    // Constructor
    public CourseRequestForm(student student, List<Long> requestedCourseIds, LocalDateTime requestedDate) {
        this.student = student;
        this.requestedCourseIds = requestedCourseIds;
        this.requestedDate = requestedDate;
    }

    public Long getId() {
        return id;
    }

    public student getStudent() {
        return student;
    }

    public void setStudent(student student) {
        this.student = student;
    }

    public List<Long> getRequestedCourseIds() {
        return requestedCourseIds;
    }

    public void setRequestedCourseIds(List<Long> requestedCourseIds) {
        this.requestedCourseIds = requestedCourseIds;
    }

    public LocalDateTime getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(LocalDateTime requestedDate) {
        this.requestedDate = requestedDate;
    }
}
