package com.a5.group18.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentConcessionController {

    @GetMapping("/concessioninfo")
    public String getConcessionInfo(Model model){
        return "concessionInfo";
    }
}
