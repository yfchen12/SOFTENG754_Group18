package com.a5.group18.controller;

import com.a5.group18.pojo.Course;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CourseInformationController {
    @ModelAttribute("course")
    public Course defaultInstance() {
        Course c = new Course();
        return c;
    }

    @GetMapping("/courseinformation")
    public String courseinformation(ModelAndView modelAndView, @ModelAttribute Course course) {
        return "courseinformation";
    }
}
