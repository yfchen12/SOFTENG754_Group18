package com.a5.group18.pojo;

import com.a5.group18.enumerated.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private String courseNumber;
    private String courseTitle;
    private String courseOutline;
    private String courseValue;
    private String prerequisites;
    private List<Teacher> teachTeam;
    private int capacity;

    private Subject subject;
    private Status status;
    private CourseCareer courseCareer;

    private String classNbr;
    private int point;
    private CourseComponent courseCop;
    private Campus campus;

}