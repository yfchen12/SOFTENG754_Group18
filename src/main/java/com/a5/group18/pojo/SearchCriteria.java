package com.a5.group18.pojo;


import com.a5.group18.enumerated.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tim Shi
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria {
    private Subject subject;
    private String courseNbr;
    private String courseTitle;
    private Status status;
    private CourseCareer courseCareer;

    private String classNbr;
    private int point;
    private CourseComponent courseCop;
    private Campus campus;

}
