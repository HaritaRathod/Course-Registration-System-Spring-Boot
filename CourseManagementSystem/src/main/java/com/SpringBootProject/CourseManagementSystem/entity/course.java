package com.SpringBootProject.CourseManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "Courses")
public class course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer capacity;
    private Integer remainingSeats;
    private Integer credit;

    @ManyToOne
    @JsonIgnoreProperties({"semesterName", "startDate", "endDate"})
    private semester semester;

    @OneToOne
    @JsonIgnoreProperties({"name", "email", "password"})
    private professor professor;

    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private studentCourses studentCourses;

    // Default Constructor (required by JPA)
    public course() {
    }

    public course(String name, Integer capacity, Integer credit, professor professor, semester semester) {
        this.name = name;
        this.capacity = capacity;
        this.credit = credit;
        this.professor = professor;
        this.semester = semester;
        this.studentCourses = new studentCourses(this);
    }

    // Method to set studentCourses separately
    public void assignStudentCourses(studentCourses studentCourses) {
        this.studentCourses = studentCourses;
    }

    @JsonProperty("professorID")
    public Long getProfessorID() {
        return professor != null ? professor.getId() : null;
    }

    public void setProfessorID(Long professorID) {
        this.professor = new professor();
        this.professor.setId(professorID);
    }

    @JsonProperty("semesterID")
    public Long getSemesterID() {
        return semester != null ? semester.getId() : null;
    }

    public void setSemesterID(Long semesterID) {
        this.semester = new semester();
        this.semester.setId(semesterID);
    }

    public Long getId() {
        return id;
    }

    @JsonIgnore
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRemainingSeats() {
        return remainingSeats;
    }

    public void setRemainingSeats(int remainingSeats) {
        this.remainingSeats = remainingSeats;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public professor getProfessor() {
        return professor;
    }
}
