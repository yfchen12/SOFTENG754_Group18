package com.a5.group18.service;


import com.a5.group18.enumerated.*;
import com.a5.group18.pojo.Course;
import com.a5.group18.pojo.Student;
import com.a5.group18.pojo.Teacher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tim Shi
 * @version 1.0
 */
@Component
public class CourseService {

    public List<Course> findAll() {
        Teacher teacher1 = new Teacher("Andy Jane","ady.jane@uoa.com","Come from England");
        Teacher teacher2 = new Teacher("John Walker","john.walker@uoa.com","Come from American");
        List<String> prerequisite = Arrays.asList("SOFTENG101");
        List<Teacher> tels = Arrays.asList(teacher1, teacher2);
        Course course = new Course("SOFTENG701", "Advanced Software Development",
                "Course Outline", "Course Value", prerequisite, tels,

                20, Subject.ACADENG, CStatus.AVAILABLE, CourseCareer.CONTINUING_EDUCATION, "Class1",
                15, CourseComponent.CLINIC, Campus.EPSOM,null,"");
        Course course2 = new Course("SOFTENG702", "Computer Science",
                "Course Outline", "Course Value", prerequisite, tels,
                20, Subject.ACADENG, CStatus.AVAILABLE, CourseCareer.CONTINUING_EDUCATION, "Class2",
                15, CourseComponent.CLINIC, Campus.CITY,new ArrayList<Student>(),"");
        Course course3 = new Course("SOFTENG703", "OOP Development",
                "Course Outline", "Course Value", prerequisite, tels,
                20, Subject.ACADENG, CStatus.AVAILABLE, CourseCareer.CONTINUING_EDUCATION, "Class3",
                15, CourseComponent.LABORATORY, Campus.GRAFTON,null,"");
        Course course4 = new Course("SOFTENG704", "Software Engineering Method",
                "Course Outline", "Course Value", prerequisite, tels,
                20, Subject.ACADENG, CStatus.AVAILABLE, CourseCareer.CONTINUING_EDUCATION, "Class3",
                15, CourseComponent.LABORATORY, Campus.CITY, null, "");

        return Arrays.asList(course, course2, course3, course4);
    }

    public Course findByCourseNum(final String coursNum){
        List<String> prerequisite = Arrays.asList("SOFTENG101");
        Teacher teacher1 = new Teacher("Andy Jane","ady.jane@uoa.com","Come from England");
        Teacher teacher2 = new Teacher("John Walker","john.walker@uoa.com","Come from American");
        List<Teacher> tels = Arrays.asList(teacher1, teacher2);
        Course course = new Course("SOFTENG701", "Advanced Software Development",
                "Course Outline", "Course Value", prerequisite, tels,
                20, Subject.ACADENG, CStatus.AVAILABLE, CourseCareer.CONTINUING_EDUCATION, "Class1",
                15, CourseComponent.CLINIC, Campus.EPSOM,null,"");
        Course course2 = new Course("SOFTENG702", "Computer Science",
                "Course Outline", "Course Value", prerequisite, tels,
                20, Subject.ACADENG, CStatus.AVAILABLE, CourseCareer.CONTINUING_EDUCATION, "Class2",
                15, CourseComponent.CLINIC, Campus.CITY,null,"");
        Course course3 = new Course("SOFTENG703", "OOP Development",
                "Course Outline", "Course Value", prerequisite, tels,
                20, Subject.ACADENG, CStatus.AVAILABLE, CourseCareer.CONTINUING_EDUCATION, "Class3",
                15, CourseComponent.LABORATORY, Campus.GRAFTON,null,"");
        if (coursNum.contains("SOFTENG701"))
            return course;
        else if (coursNum.contains("SOFTENG702"))
            return course2;
        else if (coursNum.contains("SOFTENG703"))
            return course3;
        else if (coursNum.contains("SOFTENG101"))
            return new Course("SOFTENG101", "Software Development",
                    "Course Outline", "Course Value", null, tels,
                    20, Subject.ACADENG, CStatus.AVAILABLE, CourseCareer.CONTINUING_EDUCATION, "Class1",
                    15, CourseComponent.LABORATORY, Campus.GRAFTON,null,"");
        else
            return new Course();

    }

}
