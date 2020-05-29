package com.a5.group18.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Tim Shi
 * @version 1.0
 */
@Controller
public class SearchCourseController {

    @GetMapping("/searchCourse")
    public String search() {
        return "searchCourse";
    }

}
