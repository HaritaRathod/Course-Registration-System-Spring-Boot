package com.SpringBootProject.CourseManagementSystem.dto;

public class CourseListDTO {
    private String courseName;
    private Long courseId;
    private String courseProf;
    private Integer courseGrade;

    public CourseListDTO(String courseName, Long courseId, String courseProf, Integer courseGrade) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.courseProf = courseProf;
        this.courseGrade = courseGrade;
    }

    // Getters and Setters
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Long getCourseId() {
        return courseId;
    }
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseProf() {
        return courseProf;
    }
    public void setCourseProf(String courseProf) {
        this.courseProf = courseProf;
    }

    public Integer getCourseGrade() {
        return courseGrade;
    }
    public void setCourseGrade(Integer courseGrade) {
        this.courseGrade = courseGrade;
    }
}
