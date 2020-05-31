package com.a5.group18.service;

import com.a5.group18.pojo.Course;
import org.springframework.stereotype.Service;
import com.a5.group18.enumerated.EnrollmentStatus;
import com.a5.group18.pojo.Enrollment;
import com.a5.group18.pojo.Student;

import java.util.Arrays;
import java.util.List;


    @Service
    public class EnrollmentService {
        CourseService courseService = new CourseService();

        public List<Enrollment> findEnrollment(){

            List<Course> course = courseService.findAll();
            Student John = new Student();
            Student allen = new Student();
            Student miranda = new Student();
            John.setUpi("jsm123");
            Course se702 = course.get(1);
            addStudentToWaitingList(se702, allen);
            addStudentToWaitingList(se702, John);
            addStudentToWaitingList(se702, miranda);
            Enrollment enrollment701 = new Enrollment(John,course.get(0),EnrollmentStatus.ENROLLED);
            Enrollment enrollment702 = new Enrollment(John,se702,EnrollmentStatus.WAITLISTED);
            Enrollment enrollment703 = new Enrollment(John,course.get(2),EnrollmentStatus.CONCESSION_PENDING);

            return Arrays.asList(enrollment701,enrollment702,enrollment703);
        }
        public void addStudentToWaitingList(Course course, Student student){

            course.getWaitingList().add(student);
        }
    }



