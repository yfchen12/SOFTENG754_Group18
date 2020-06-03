package com.a5.group18.controller;

import com.a5.group18.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeacherProfileController {
    @Autowired
    TeacherService teacherService;
    @GetMapping("/teacherProfile")
    public String teacher(Model model) {

        return "teacherProfile";
    }

}
