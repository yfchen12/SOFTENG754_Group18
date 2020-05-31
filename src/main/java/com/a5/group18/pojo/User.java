package com.a5.group18.pojo;

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
public class User {
    private String upi;
    private String userName;
    private String password;
}
