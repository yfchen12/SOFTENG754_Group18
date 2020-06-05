package com.a5.group18.controller;

import com.a5.group18.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class CourseManageController {
    @Autowired
    CourseService courseService;

    @GetMapping("/coursemanage")
    public String coursemanage(Model model) {
        model.addAttribute("courses", courseService.findAll());
        return "courseManage";
    }

    @RequestMapping("/courseEdit/{courseid}")
    public String courseEdit(@PathVariable("courseid") String courseid, Model model, RedirectAttributes ra) {
        model.addAttribute("course", courseService.findByCourseNum(courseid));
        ra.addFlashAttribute("course", courseService.findByCourseNum(courseid));
        return "courseEdit";
    }

    @RequestMapping(value = "/update/{courseid}", method = POST)
    public String update(@PathVariable("courseid") String courseid, Model model, RedirectAttributes ra) {
        model.addAttribute("course", courseService.findByCourseNum(courseid));
        ra.addFlashAttribute("course", courseService.findByCourseNum(courseid));
        return "courseInformation";

    }
}
