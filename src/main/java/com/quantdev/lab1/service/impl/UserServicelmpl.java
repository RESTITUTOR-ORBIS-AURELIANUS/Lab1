package com.quantdev.lab1.service.impl;

import com.quantdev.lab1.entity.User;
import com.quantdev.lab1.mapper.UserMapper;
import com.quantdev.lab1.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServicelmpl implements UserService {
    private final UserMapper userMapper;
    public UserServicelmpl(UserMapper userMapper) {this.userMapper = userMapper;}
    @Override
    public User getUserByuserName(String userName){
        return userMapper.getUser(userName);
    }
    @Override
    public int registerUser(User user){
        userMapper.insertUser(user);
        return 1;
    }
    @Override
    public int checkIfUserExists(String userName){
        return userMapper.checkIsExisted(userName);
    }
}
