//package com.SpringBootProject.CourseManagementSystem.dto;
//
//public class ProfessorCourseSummaryDTO {
//}
package com.SpringBootProject.CourseManagementSystem.dto;

public class ProfessorCourseSummaryDTO {
    private String courseName;
    private Integer courseCredit;

    public ProfessorCourseSummaryDTO(String courseName, Integer courseCredit) {
        this.courseName = courseName;
        this.courseCredit = courseCredit;
    }

    public String getCourseName() {
        return courseName;
    }

    public Integer getCourseCredit() {
        return courseCredit;
    }
}
