package com.a5.group18.pojo;

import com.a5.group18.enumerated.EnrollmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {
    private Student student;
    private Course course;
    private EnrollmentStatus status;
}
