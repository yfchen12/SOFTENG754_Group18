package com.a5.group18.service;

import com.a5.group18.pojo.Course;
import org.springframework.stereotype.Service;
import com.a5.group18.enumerated.EnrollmentStatus;
import com.a5.group18.pojo.Enrollment;
import com.a5.group18.pojo.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class EnrollmentService {
    CourseService courseService;
    ArrayList<Course> course;
    ArrayList<Enrollment> enrollments;

    public EnrollmentService() {
        courseService = new CourseService();
        course = new ArrayList<>(courseService.findAll());
        enrollments = addEnrollment();
    }

    public ArrayList<Enrollment> deleteEnrollment(Enrollment enrollment) {
        enrollments.remove(enrollment);
        return enrollments;
    }

    public ArrayList<Enrollment> addEnrollment() {
        Student John = new Student();
        Student allen = new Student();
        Student miranda = new Student();
        John.setUpi("sjohn799");
        Course se702 = course.get(1);
        addStudentToWaitingList(se702, allen);
        addStudentToWaitingList(se702, John);
        addStudentToWaitingList(se702, miranda);
        Enrollment enrollment701 = new Enrollment(John, course.get(0), EnrollmentStatus.ENROLLED);
        Enrollment enrollment702 = new Enrollment(John, se702, EnrollmentStatus.WAITLISTED);
        Enrollment enrollment703 = new Enrollment(John, course.get(2), EnrollmentStatus.CONCESSION_PENDING);
        Enrollment enrollment704 = new Enrollment(John, course.get(3), EnrollmentStatus.ENROLLED);

        return enrollments = new ArrayList<>(Arrays.asList(enrollment701, enrollment702, enrollment703, enrollment704));
    }

    public ArrayList<Enrollment> findEnrollment() {

        return enrollments;
    }

    public void addStudentToWaitingList(Course course, Student student) {

        course.getWaitingList().add(student);
    }

    public List<Course> findSoftengCoreCourse() {
        return Arrays.asList(course.get(0));

    }
}



