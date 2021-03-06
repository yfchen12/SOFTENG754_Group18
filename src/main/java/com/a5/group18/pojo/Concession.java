package com.a5.group18.pojo;


import com.a5.group18.enumerated.ConcessionReason;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Concession {
    private Student student;
    private String courseName;
    private String justification;
    private ConcessionReason reason;
    private String attachmentPath;
}
