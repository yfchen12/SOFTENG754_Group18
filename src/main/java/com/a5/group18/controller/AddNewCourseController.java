package com.a5.group18.controller;

import com.a5.group18.pojo.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller


public class AddNewCourseController {
    @ModelAttribute("course")
    public Course defaultInstance() {

        return new Course();
    }

    @GetMapping("/addNewCourse")
    public String addNewCourse(Model model) {
        model.addAttribute("course", new Course());
        return "addNewCourse";
    }

    @PostMapping("/addNewCourse")
    public String addNewCourse(ModelAndView modelAndView, Course course, RedirectAttributes ra, BindingResult bindingResult) {
        modelAndView.addObject("course", course);
        modelAndView.setViewName("redirect:courseinformations");
        ra.addFlashAttribute("course", course);
        return "redirect:courseinformations";
    }

}