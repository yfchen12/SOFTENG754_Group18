package com.a5.group18.service;

import com.a5.group18.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @author Tim Shi
 * @version 1.0
 */
@Component
public class UserService {

    public User getUserByUserName(String userName) {
        return new User("sjohn799", userName, "123");
    }
}
