package com.a5.group18.controller;

import com.a5.group18.service.ConcessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProcessConcessionController {
    @Autowired
    ConcessionService concessionService;

    @GetMapping("/processConcession")
    public String processConcession(Model model) {
        model.addAttribute("concessionApplication", concessionService.findOne());
        return "processConcession";
    }
}
