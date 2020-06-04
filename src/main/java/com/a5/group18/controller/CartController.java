package com.a5.group18.controller;

import com.a5.group18.enumerated.CStatus;
import com.a5.group18.enumerated.EnrollmentStatus;
import com.a5.group18.pojo.Course;
import com.a5.group18.pojo.Enrollment;
import com.a5.group18.pojo.Grade;
import com.a5.group18.pojo.Student;
import com.a5.group18.service.CourseService;
import com.a5.group18.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Tim Shi
 * @version 1.0
 */
@Controller
public class CartController {
    private ArrayList<Enrollment> enrollments;
    @Autowired
    CourseService courseService;
    @Autowired
    EnrollmentService enrollmentService;


    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("courses", courseService.findAll());
        model.addAttribute("course", new Course());
        return "cart";
    }

    @PostMapping("/cart")
    public String enrolInCourse(Model model, Course course, RedirectAttributes redirectAttributes) {
       // ArrayList<Enrollment> enrollments = enrollmentService.findEnrollment();
        List<Course> courseList = courseService.findAll();
        String courseNumber = course.getCourseNumber().trim();
        Course targetCourse = courseList.stream().filter(c->c.getCourseNumber().equals(courseNumber)).findFirst().orElse(null);
        List prereq = targetCourse.getPrerequisites();
        CStatus courseStatus = targetCourse.getCourseStatus();
        Boolean allPrereqSatisfy=false;
        if(prereq!=null){
            ArrayList<String> prerequisite =new ArrayList(Arrays.asList(prereq));
            for(String p : prerequisite){
                Grade grade = enrollmentService.findGrade().stream().filter(g->g.getCourseNum().equals(p)).findFirst().orElse(null);
                if(grade!=null&&grade.getGrade().compareGrade()==1){
                    allPrereqSatisfy=true;
                }
        }
        }
        Enrollment enrollment;
        String enrolResult;
        if(prereq==null||allPrereqSatisfy){
            if(courseStatus.equals(CStatus.AVAILABLE)){
                enrollment =new Enrollment(new Student(),targetCourse,EnrollmentStatus.ENROLLED);
                enrollmentService.addEnrollment(enrollment);
                enrolResult="SUCCESS";
                model.addAttribute("enrolResult", enrolResult);
                return "cart";
            } else if(courseStatus.equals(CStatus.NOT_AVAILABLE)){
                Student john =new Student();
                john.setUpi("sjohn799");
                enrollment =new Enrollment(john,targetCourse,EnrollmentStatus.WAITLISTED);
                enrolResult = "WAITLISTED";
                model.addAttribute("waitsize", targetCourse.getWaitingList().size());
                model.addAttribute("enrolResult", enrolResult);
                enrollmentService.addStudentToWaitingList(targetCourse,john);
                enrollmentService.addEnrollment(enrollment);
                return "cart";
            }else{
                enrolResult = "NOT_AVAILABLE";
                model.addAttribute("enrolResult", enrolResult);
                return "redirect:cart";
            } }else{
            enrolResult="CONCESSION_REQUIRED";
            model.addAttribute("enrolResult", enrolResult);
            return "redirect:concession";
        }

    }
}
