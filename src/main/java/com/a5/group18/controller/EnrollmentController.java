package com.a5.group18.controller;

import com.a5.group18.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnrollmentController {
    @Autowired
    EnrollmentService enrollmentService;

    @GetMapping("/myEnrollment")
    public String listEnrollment(Model model){
        model.addAttribute("enrollments", enrollmentService.findEnrollment());
        return "myEnrollment";
    }
}

