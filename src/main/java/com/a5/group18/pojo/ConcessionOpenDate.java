package com.a5.group18.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConcessionOpenDate {
    private String openDate;
    private String semester;

    public ConcessionOpenDate(String targetDate) {
    }
}
