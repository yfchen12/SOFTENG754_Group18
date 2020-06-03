package com.a5.group18.controller;

import com.a5.group18.pojo.Course;
import com.a5.group18.pojo.Teacher;
import com.a5.group18.service.CourseService;
import com.a5.group18.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CourseInformationController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private TeacherService teacherService;
    @ModelAttribute("course")
    public Course defaultInstance() {
        Course c = new Course();
        return c;
    }

    @GetMapping("/courseinformation")
    public String courseinformation(ModelAndView modelAndView, @ModelAttribute Course course) {
        return "courseinformation";
    }
    @GetMapping("/courseinformation/{courseid}")
    public String courseinformation(@PathVariable("courseid") String courseid, Model modelAndView) {
        modelAndView.addAttribute("course", courseService.findByCourseNum(courseid));
        return "courseinformation";
    }
    @GetMapping("/teacher/{name}")
    public String teacher(@PathVariable("name") String name, Model model, RedirectAttributes ra) {
        Teacher teacher = teacherService.findByName(name);
        ra.addFlashAttribute("teacher",teacher);
        model.addAttribute("email",teacher.getEmail());
        model.addAttribute("Instructions",teacher.getInstructions());
        return "teacherProfile";
    }
}
