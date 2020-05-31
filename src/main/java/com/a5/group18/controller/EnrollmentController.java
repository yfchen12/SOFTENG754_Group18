package com.a5.group18.controller;

import com.a5.group18.enumerated.EnrollmentStatus;
import com.a5.group18.pojo.Enrollment;
import com.a5.group18.pojo.Student;
import com.a5.group18.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;

@Controller
public class EnrollmentController {
    @Autowired
    EnrollmentService enrollmentService;

    @GetMapping("/myEnrollment")
    public String listEnrollment(Model model) {
        List<Enrollment> enrollments = enrollmentService.findEnrollment();
        HashMap<String, Integer> placeInList = new HashMap<>();
        Student John = new Student();
        John.setUpi("jsm123");
        enrollmentService.findEnrollment().
                forEach(enrollment -> {
                    if (enrollment.getStatus().equals(EnrollmentStatus.WAITLISTED)) {
                        placeInList.put(enrollment.getCourse().getCourseNumber(), enrollment.getCourse().getWaitingList().indexOf(John));
                    }
                });
        model.addAttribute("enrollments", enrollments);
        model.addAttribute("waitlistPlace", placeInList);
        return "myEnrollment";
    }
}

