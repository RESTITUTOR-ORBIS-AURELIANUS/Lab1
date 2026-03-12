package com.quantdev.lab1.service;

import com.quantdev.lab1.entity.User;

public interface UserService {
    User getUserByuserName(String userName);

    int registerUser(User user);

    int checkIfUserExists(String userName);
}
