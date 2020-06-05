package com.a5.group18.controller;

import com.a5.group18.enumerated.ConcessionReason;
import com.a5.group18.pojo.Concession;
import com.a5.group18.service.ConcessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class ConcessionController {

    @Autowired
    ConcessionService concessionService;

    private String courseNum;

    @GetMapping("/concessionSubmit/{courseNumber}")
    public String getConcessionPage(Model model, @PathVariable("courseNumber") String courseNumber) {
        List<ConcessionReason> reasons = Arrays.asList(ConcessionReason.ENROLLED_IN_EQUIVALENT_COURSE, ConcessionReason.HAVE_SIMILAR_EXPERIENCE);
        model.addAttribute("reasons", reasons);
        model.addAttribute("courseName", courseNumber);
        courseNum = courseNumber;
        model.addAttribute("concession", new Concession());
        return "concessionSubmit";
    }

    @PostMapping("/concessionSubmit")
    public String concessionSubmit(Concession concession) {
        concession.setCourseName(courseNum);
        concessionService.submitConcession(concession);
        return "redirect:myConcession";
    }

    @GetMapping("/myConcession")
    public String myConcession(Model model) {

        model.addAttribute("concessionList", concessionService.listConcession());
        return "myConcession";
    }
}
