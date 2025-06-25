package com.SpringBootProject.CourseManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Student")
public class student extends Person {

    @ElementCollection
    private List<Long> courseIDs = new ArrayList<>();

    public List<Long> getCourseIDs() {
        return courseIDs;
    }

    @JsonIgnore
    public void setCourseIDs(List<Long> courseIDs) {
        this.courseIDs = courseIDs;
    }
}
