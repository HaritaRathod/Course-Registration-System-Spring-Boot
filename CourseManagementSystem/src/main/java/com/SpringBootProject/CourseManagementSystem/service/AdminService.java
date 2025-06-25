package com.SpringBootProject.CourseManagementSystem.service;

import com.SpringBootProject.CourseManagementSystem.dto.AddCourseDTO;
import com.SpringBootProject.CourseManagementSystem.entity.*;
import com.SpringBootProject.CourseManagementSystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AdminService {
    @Autowired
    private CourseRepository courseRepository ;

    @Autowired
    private ProfessorRepository professorRepository ;

    @Autowired
    private SemesterRepository semesterRepository ;

    @Autowired
    private StudentRepository studentRepository ;

    @Autowired
    private CourseRequestFormRepository courseRequestFormRepository ;

    @Autowired
    private CourseRequestCoursesRepository courseRequestCoursesRepository ;

    @Autowired
    private StudentCoursesRepository studentCoursesRepository ;

    @Autowired
    private JavaMailSender mailSender ;

    // adding
    public void addCourse(AddCourseDTO courseDTO) {
        professor professor = professorRepository.findById(courseDTO.getProfessorID())
                .orElseThrow(() -> new RuntimeException("Professor not found"));
        semester semester = semesterRepository.findById(courseDTO.getSemesterID())
                .orElseThrow(() -> new RuntimeException("Semester not found"));

        course newCourse = new course(courseDTO.getName(), courseDTO.getCapacity(), courseDTO.getCredit(), professor, semester);
        courseRepository.save(newCourse);
        studentCourses studentCoursesEntry = new studentCourses(newCourse);
        newCourse.assignStudentCourses(studentCoursesEntry); // Ensuring it's linked
        courseRepository.save(newCourse);
    }

    public professor addProfessor(professor professor) {
        return professorRepository.save(professor);
    }

    public semester addSemester(semester semester) {
        return semesterRepository.save(semester);
    }

    public student addStudent(student student) {
        return studentRepository.save(student);
    }

    //updating
    public void updateCourse(Long id, AddCourseDTO newCourseDetails) {
        course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id " + id));
        existingCourse.setName(newCourseDetails.getName());
        existingCourse.setCapacity(newCourseDetails.getCapacity());
        existingCourse.setRemainingSeats(newCourseDetails.getRemainingSeats());
        existingCourse.setProfessorID(newCourseDetails.getProfessorID());
        existingCourse.setSemesterID(newCourseDetails.getSemesterID());
        courseRepository.save(existingCourse);

        List<studentCourses> studentCoursesList = studentCoursesRepository.findByCourseId(id);
        for (studentCourses studentCourse : studentCoursesList) {
            studentCourse.setCourseName(newCourseDetails.getName());
            studentCourse.setCourseGrade(newCourseDetails.getCredit());
            studentCoursesRepository.save(studentCourse);
        }
    }

    public void updateSemester(Long id, semester newSemesterDetails) {
        semester existingSemester = semesterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Semester not found with id " + id)) ;
        existingSemester.setStartDate(newSemesterDetails.getStartDate());
        existingSemester.setEndDate(newSemesterDetails.getEndDate());
        semesterRepository.save(existingSemester) ;
    }

    // deleting
    public void deleteCourse(Long Id) {
        courseRepository.deleteById(Id);
    }

    public void deleteProfessor(Long Id) {
        professorRepository.deleteById(Id);
    }

    public void deleteStudent(Long Id) {
        studentRepository.deleteById(Id);
    }

    public String sendEmailNotification(){
        List<student> students = studentRepository.findAll() ;
        for(student s : students){
            sendEmail(s.getEmail(), "Course Registration", "Dear Student, please register for your course.") ;
        }
        return "Emails sent successfully!" ;
    }

    private void sendEmail(String to, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage() ;
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message) ;
    }

    public void assignCourses() {
        List<CourseRequestForm> forms = courseRequestFormRepository.findAll();

        forms.sort(Comparator.comparing(CourseRequestForm::getRequestedDate)); // First-come-first-serve basis

        for (CourseRequestForm form : forms) {
            student student = form.getStudent();
            List<Long> courseIds = form.getRequestedCourseIds();
            int priority = 1;

            for (Long courseId : courseIds) {
                course course = courseRepository.findById(courseId)
                        .orElseThrow(() -> new RuntimeException("Course not found with id " + courseId));

                if (course.getRemainingSeats() > 0) {
                    course.setRemainingSeats(course.getRemainingSeats() - 1); // Decrease seats
                    courseRepository.save(course);

                    CourseRequestCourses courseRequestCourses = new CourseRequestCourses(student, course, priority++);
                    courseRequestCoursesRepository.save(courseRequestCourses);

                    if (priority > 3) break; // Only assign 3 courses
                }
            }
        }
    }

    public void sendAssignedCoursesEmail() {
        List<CourseRequestCourses> assignedCourses = courseRequestCoursesRepository.findAll();

        Map<student, List<course>> studentCoursesMap = assignedCourses.stream()
                .collect(Collectors.groupingBy(CourseRequestCourses::getStudent,
                        Collectors.mapping(CourseRequestCourses::getCourse, Collectors.toList())));

        for (Map.Entry<student, List<course>> entry : studentCoursesMap.entrySet()) {
            student s = entry.getKey();
            List<course> courses = entry.getValue();

            StringBuilder courseDetails = new StringBuilder("You have been assigned the following courses:\n");
            for (course c : courses) {
                courseDetails.append("- ").append(c.getName()).append("\n");
            }

            sendEmail(s.getEmail(), "Assigned Courses", courseDetails.toString());
        }
    }

}

