package com.SpringBootProject.CourseManagementSystem.entity;

import jakarta.persistence.*;

@Entity
public class CourseRequestCourses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private student student;

    @ManyToOne
    private course course;

    private int priority;

    // Default Constructor
    public CourseRequestCourses() {}

    // Constructor
    public CourseRequestCourses(student student, course course, int priority) {
        this.student = student;
        this.course = course;
        this.priority = priority;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public student getStudent() {
        return student;
    }

    public void setStudent(student student) {
        this.student = student;
    }

    public course getCourse() {
        return course;
    }

    public void setCourse(course course) {
        this.course = course;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
