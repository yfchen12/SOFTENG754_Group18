package com.a5.group18.controller;

import com.a5.group18.pojo.Course;
import com.a5.group18.pojo.Teacher;
import com.a5.group18.service.CourseService;
import com.a5.group18.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class CourseInformationController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private TeacherService teacherService;

    @ModelAttribute("course")
    public Course defaultInstance() {
        return new Course();
    }

    @GetMapping("/courseinformations")
    public String courseinformations(Model modelAndView, @ModelAttribute Course course) {
        modelAndView.addAttribute("course", course);
        return "courseInformation";
    }

    @GetMapping("/courseinformation/{courseid}")
    public String courseinformation(@PathVariable("courseid") String courseid, Model modelAndView) {
        modelAndView.addAttribute("course", courseService.findByCourseNum(courseid));
        return "courseInformation";
    }

    @RequestMapping(value = "/download/{courseid}", method = RequestMethod.POST)
    @ResponseBody
    public void downloadPDFResource(HttpServletResponse response,
                                    @PathVariable("courseid") String fileName) {
        Course course = courseService.findByCourseNum(fileName);
        String dataDirectory = course.getFileUrl();
        Path file = Paths.get(dataDirectory);
        if (Files.exists(file)) {
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "attachment; filename=" + fileName + ".pdf");
            try {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @GetMapping("/teacher/{name}")
    public String teacher(@PathVariable("name") String name, Model model, RedirectAttributes ra) {
        Teacher teacher = teacherService.findByName(name);
        ra.addFlashAttribute("teacher", teacher);
        model.addAttribute("email", teacher.getEmail());
        model.addAttribute("Instructions", teacher.getInstructions());
        return "teacherProfile";
    }

    @GetMapping("/pre/{name}")
    public String pre(@PathVariable("name") String name, Model modelAndView, RedirectAttributes ra) {
        Course prec = courseService.findByCourseNum(name);
        ra.addFlashAttribute("course", prec);
        modelAndView.addAttribute("course", prec);
        return "courseInformation";
    }
}
