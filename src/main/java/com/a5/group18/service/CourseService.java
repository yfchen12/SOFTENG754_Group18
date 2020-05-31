package com.a5.group18.service;


import com.a5.group18.enumerated.*;
import com.a5.group18.pojo.Course;
import com.a5.group18.pojo.Teacher;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author Tim Shi
 * @version 1.0
 */
@Component
public class CourseService {

    public List<Course> findAll() {
        Teacher teacher1 = new Teacher("ady.jane@uoa.com");
        Teacher teacher2 = new Teacher("john.walker@uoa.com");
        List<Teacher> tels = Arrays.asList(teacher1, teacher2);
        Course course = new Course("SOFTENG701", "Advanced Software Development",
                "Course Outline", "Course Value", "Prerequisite", tels,
                20, Subject.ACADENG, CStatus.AVAILABLE, CourseCareer.CONTINUING_EDUCATION, "Class1",
                15, CourseComponent.CLINIC, Campus.EPSOM,"");
        Course course2 = new Course("SOFTENG702", "Computer Science",
                "Course Outline", "Course Value", "Prerequisite", tels,
                20, Subject.ACADENG, CStatus.AVAILABLE, CourseCareer.CONTINUING_EDUCATION, "Class2",
                15, CourseComponent.CLINIC, Campus.CITY,"");
        Course course3 = new Course("SOFTENG703", "OOP Development",
                "Course Outline", "Course Value", "Prerequisite", tels,
                20, Subject.ACADENG, CStatus.AVAILABLE, CourseCareer.CONTINUING_EDUCATION, "Class3",
                15, CourseComponent.LABORATORY, Campus.GRAFTON,"");

        return Arrays.asList(course, course2, course3);
    }

}
