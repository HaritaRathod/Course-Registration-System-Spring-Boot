package com.SpringBootProject.CourseManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Semester")
public class semester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String semesterName ;
    private String startDate ;
    private String endDate ;

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }
    //    @OneToMany(mappedBy = "semester", cascade = CascadeType.ALL)
//    private List<course> coursesOfferedInS = new ArrayList<>();

    public Long getId() {
        return id;
    }

    @JsonIgnore
    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

//    public List<course> getCoursesOfferedInS() {
//        return coursesOfferedInS;
//    }
//
//    public void setCoursesOfferedInS(List<course> coursesOfferedInS) {
//        this.coursesOfferedInS = coursesOfferedInS;
//    }
}
