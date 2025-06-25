package com.SpringBootProject.CourseManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Student_Courses")
public class studentCourses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;
    private String courseProf;
    private Integer courseGrade;

    @OneToOne
    @JoinColumn(name = "course_id", unique = true)
    private course course;

    public studentCourses() {}

    public studentCourses(course course) {
        this.courseName = course.getName();
        this.courseGrade = course.getCredit();
        this.courseProf = course.getProfessor() != null ? course.getProfessor().getName() : "Unknown";
        this.course = course;
    }

    // Getters
    @JsonIgnore
    public Long getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseProf() {
        return courseProf;
    }

    public Integer getCourseGrade() {
        return courseGrade;
    }

    public Long getCourseId() {
        return course != null ? course.getId() : null;
    }

    public void setCourseGrade(Integer courseGrade) {
        this.courseGrade = courseGrade;
    }

    public void setCourseProf(String courseProf) {
        this.courseProf = courseProf;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}