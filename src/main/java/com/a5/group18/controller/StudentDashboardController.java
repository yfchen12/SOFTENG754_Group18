package com.a5.group18.controller;

import com.a5.group18.pojo.ConcessionOpenDate;
import com.a5.group18.service.DateService;
import com.a5.group18.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Tim Shi
 * @version 1.0
 */
@Controller
public class StudentDashboardController {

    @Autowired
    UserService userService;

    @Autowired
    DateService dateService;

    @GetMapping("/studentDashboard")
    public String index(Model model) {
        model.addAttribute("userName", userService.getUserByUserName("John Smith").getUserName());
        model.addAttribute("enrollmentOpenDates", dateService.findEnrollmentOpenDates());
        model.addAttribute("enrollmentOpenDate", new ConcessionOpenDate());
        return "studentDashboard";
    }
}
