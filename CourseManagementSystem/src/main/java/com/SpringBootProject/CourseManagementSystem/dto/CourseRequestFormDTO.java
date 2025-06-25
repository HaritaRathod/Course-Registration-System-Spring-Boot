package com.SpringBootProject.CourseManagementSystem.dto;

import java.time.LocalDateTime;
import java.util.List;

public class CourseRequestFormDTO {

    private List<Long> requestedCourseIds;
    private LocalDateTime requestedDate;
    private Long studentId;

    // Getters and Setters
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

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
