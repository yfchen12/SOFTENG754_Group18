package com.a5.group18.service;

import com.a5.group18.pojo.Teacher;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
public class TeacherService {
    Teacher teacher1 = new Teacher("Andy Jane","ady.jane@uoa.com","Come from England");
    Teacher teacher2 = new Teacher("John Walker","john.walker@uoa.com","Come from American");

    public List<Teacher> findAll() {
       List<Teacher> tels = Arrays.asList(teacher1, teacher2);
        return tels;
    }


    public Teacher findByName(String name){
        if (name.contains("Andy Jane")){
            return teacher1;
        }else if (name.contains("John Walker"))
        {
            return teacher2;
        }else{
            return teacher1;
        }
    }
}
