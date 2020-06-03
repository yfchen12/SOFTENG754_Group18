package com.a5.group18.service;

import com.a5.group18.pojo.CourseConcession;
import com.a5.group18.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class ConcessionService {
    private ArrayList<CourseConcession> courseConcessionList;

    public ConcessionService(){
        courseConcessionList = addCourseConcessions();
    }

    private ArrayList<CourseConcession> addCourseConcessions(){
        CourseConcession courseOne = new CourseConcession();
        courseOne.setCourseName("SOFTENG701");
        courseOne.setConcessionCriteria("2 years Java experience");

        CourseConcession courseTwo = new CourseConcession();
        courseTwo.setCourseName("SOFTENG702");
        courseTwo.setConcessionCriteria("10 years Java experience");

        return new ArrayList<CourseConcession>(Arrays.asList(courseOne, courseTwo));
    }

    public ArrayList<CourseConcession> getCourseConcessions(){
        return courseConcessionList;
    }
}
