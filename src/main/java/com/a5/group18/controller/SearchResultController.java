package com.a5.group18.controller;


import com.a5.group18.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Tim Shi
 * @version 1.0
 */
@Controller
public class SearchResultController {
    @Autowired
    CourseService courseService;

    @GetMapping("/searchResult")
    public String searchResult(Model model) {
        model.addAttribute("courses", courseService.findAll());
        return "searchResult";
    }


}
