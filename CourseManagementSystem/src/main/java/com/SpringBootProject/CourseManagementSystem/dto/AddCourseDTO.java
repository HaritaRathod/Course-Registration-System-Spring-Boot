package com.SpringBootProject.CourseManagementSystem.dto;

public class AddCourseDTO {
    private String name;
    private Integer capacity;
    private Integer remainingSeats;
    private Integer credit;
    private Long semesterID;
    private Long professorID;

    // Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getRemainingSeats() {
        return remainingSeats;
    }
    public void setRemainingSeats(Integer remainingSeats) {
        this.remainingSeats = remainingSeats;
    }

    public Integer getCredit() {
        return credit;
    }
    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Long getSemesterID() {
        return semesterID;
    }
    public void setSemesterID(Long semesterID) {
        this.semesterID = semesterID;
    }

    public Long getProfessorID() {
        return professorID;
    }
    public void setProfessorID(Long professorID) {
        this.professorID = professorID;
    }
}
