package com.a5.group18.controller;

import com.a5.group18.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Tim Shi
 * @version 1.0
 */
@Controller
public class StudentDashboardController {

    @Autowired
    UserService userService;

    @GetMapping("/studentDashboard")
    public String index(Model model) {

        model.addAttribute("userName", userService.getUserByUserName("John Smith").getUserName());
        return "studentDashboard";
    }
}
