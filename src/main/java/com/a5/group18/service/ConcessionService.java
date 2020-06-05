package com.a5.group18.service;

import com.a5.group18.enumerated.ConcessionReason;
import com.a5.group18.pojo.Concession;
import com.a5.group18.pojo.CourseConcession;
import com.a5.group18.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ConcessionService {
    private ArrayList<CourseConcession> courseConcessionList;
    private ArrayList<Concession> johnConcession;

    public ConcessionService() {
        courseConcessionList = addCourseConcessions();
        johnConcession = findConcession();
    }

    private ArrayList<CourseConcession> addCourseConcessions() {
        CourseConcession courseOne = new CourseConcession();
        courseOne.setCourseName("SOFTENG701");
        courseOne.setConcessionCriteria("2 years Java experience");

        CourseConcession courseTwo = new CourseConcession();
        courseTwo.setCourseName("SOFTENG702");
        courseTwo.setConcessionCriteria("10 years Java experience");

        return new ArrayList<>(Arrays.asList(courseOne, courseTwo));
    }

    public ArrayList<CourseConcession> getCourseConcessions() {
        return courseConcessionList;
    }

    public List<Concession> findAll() {
        Student studentOne = new Student();
        studentOne.setUserName("John Smith");

        Student studentTwo = new Student();
        studentTwo.setUserName("John Snow");

        String concessionJustification = "Insert justification.";

        Concession concessionOne = new Concession(studentOne, "SOFTENG701", concessionJustification, null, null);
        Concession concessionTwo = new Concession(studentTwo, "SOFTENG702", concessionJustification, null, null);

        return Arrays.asList(concessionOne, concessionTwo);
    }

    public Concession findOne() {
        Student student = new Student();
        student.setUserName("John Smith");
        String concessionJustification = "Insert justification.";

        return new Concession(student, "SOFTENG701", concessionJustification, null, null);
    }

    public void submitConcession(Concession newConcession) {

        johnConcession.add(newConcession);
    }

    public List<Concession> listConcession() {
        return johnConcession;
    }

    public ArrayList<Concession> findConcession() {
        johnConcession = new ArrayList<>();
        Student john = new Student();
        john.setUpi("sjohn799");
        Concession concession = new Concession(john, "SOFTENG702", null, ConcessionReason.ENROLLED_IN_EQUIVALENT_COURSE, null);
        return new ArrayList(Collections.singletonList(concession));
    }
}
