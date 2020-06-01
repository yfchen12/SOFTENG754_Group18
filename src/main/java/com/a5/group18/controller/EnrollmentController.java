package com.a5.group18.controller;

import com.a5.group18.enumerated.EnrollmentStatus;
import com.a5.group18.pojo.Course;
import com.a5.group18.pojo.Enrollment;
import com.a5.group18.pojo.Student;
import com.a5.group18.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;


@Controller
public class EnrollmentController {
    @Autowired
    EnrollmentService enrollmentService;
    HashMap<String, Integer> placeInList;

    @GetMapping("/myEnrollment")
    public String listEnrollment(Model model) {
        ArrayList<Enrollment> enrollments = enrollmentService.findEnrollment();
        placeInList = new HashMap<>();
        Student John = new Student();
        John.setUpi("sjohn799");
        enrollmentService.findEnrollment().
                forEach(enrollment -> {
                    if (enrollment.getStatus().equals(EnrollmentStatus.WAITLISTED)) {
                        placeInList.put(enrollment.getCourse().getCourseNumber(), enrollment.getCourse().getWaitingList().indexOf(John));
                    }
                });
        model.addAttribute("enrollments", enrollments);
        model.addAttribute("waitlistPlace", placeInList);
        model.addAttribute("course", new Course());
        return "myEnrollment";
    }


    @PostMapping("/myEnrollment")
    public String dropCourse(Model model, @ModelAttribute Course course) {
        ArrayList<Enrollment> enrollments = enrollmentService.findEnrollment();
        String courseNumber = course.getCourseNumber();
        Enrollment targetEnrollment = enrollments.stream().filter(enrollment -> enrollment.getCourse().getCourseNumber().equals(courseNumber)).findFirst().orElse(null);
        Course targetCourse = targetEnrollment.getCourse();
        if(!enrollmentService.findSoftengCoreCourse().contains(targetCourse)){
            enrollments = enrollmentService.deleteEnrollment(targetEnrollment);
            model.addAttribute("result", true);
        }else{

            model.addAttribute("result", false);
            model.addAttribute("reason", targetCourse.getCourseNumber()+" can not be dropped because it is a compulsory course.");
        }
        model.addAttribute("enrollments", enrollments);
        model.addAttribute("waitlistPlace", placeInList);
        return "myEnrollment";
    }
}

