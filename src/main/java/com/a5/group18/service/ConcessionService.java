package com.a5.group18.service;

import com.a5.group18.pojo.Concession;
import com.a5.group18.pojo.CourseConcession;
import com.a5.group18.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public List<Concession> findAll() {
        Student studentOne = new Student();
        studentOne.setUserName("John Smith");

        Student studentTwo = new Student();
        studentTwo.setUserName("John Snow");

        String concessionJustification = "Insert justification.";

        Concession concessionOne = new Concession(studentOne, "SOFTENG701", concessionJustification);
        Concession concessionTwo = new Concession(studentTwo, "SOFTENG702", concessionJustification);

        return Arrays.asList(concessionOne, concessionTwo);
    }

    public Concession findOne(){
        Student student = new Student();
        student.setUserName("John Smith");
        String concessionJustification = "Insert justification.";
        Concession concession = new Concession(student, "SOFTENG701", concessionJustification);

        return concession;
    }
}
