package com.a5.group18.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Tim Shi
 * @version 1.0
 */
@Controller
public class StudentDashboardController {
    @GetMapping("/studentDashboard")
    public String index(ModelAndView modelAndView) {
        return "studentDashboard";
    }
}
