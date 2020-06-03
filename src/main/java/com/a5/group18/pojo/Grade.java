package com.a5.group18.pojo;

import com.a5.group18.enumerated.Grades;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
    private String upi;
    private String courseNum;
    private Grades Grade;
}
