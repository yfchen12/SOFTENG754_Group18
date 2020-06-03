package com.a5.group18.pojo;

import com.a5.group18.enumerated.CourseValueType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseValue {
    CourseValueType courseValueType;
    String lastCheckTime;

    List<String> companies;
}
