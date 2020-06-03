package com.a5.group18.controller;

import com.a5.group18.pojo.ConcessionOpenDate;
import com.a5.group18.pojo.CourseConcession;
import com.a5.group18.service.ConcessionService;
import com.a5.group18.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class ManageConcessionController {
    @Autowired
    DateService dateService;;

    @Autowired
    ConcessionService concessionService;

    @GetMapping("/manageConcession")
    public String manageConcession(Model model) {
        ArrayList<ConcessionOpenDate> openDates = dateService.findConcessionOpenDates();
        ArrayList<CourseConcession> courseConcessions = concessionService.getCourseConcessions();

        model.addAttribute("concessionOpenDates", openDates);
        model.addAttribute("courseConcessions", courseConcessions);

        model.addAttribute("concessionOpenDate", new ConcessionOpenDate());
        return "manageConcession";
    }

    @PostMapping("/manageConcession")
    public String updateOpenDate(Model model, @ModelAttribute ConcessionOpenDate concessionOpenDate) {
        ArrayList<ConcessionOpenDate> openDates = dateService.findConcessionOpenDates();

        String openDateReceived = concessionOpenDate.getOpenDate();
        ArrayList<ConcessionOpenDate> updatedDates = dateService.updateConcessionOpenDate(openDateReceived);
        openDates = dateService.findConcessionOpenDates();

        model.addAttribute("concessionOpenDates", openDates);

        return "manageConcession";
    }
}


