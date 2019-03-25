package com.fkit.service.Impl;

import com.fkit.mapper.UserMapper;
import com.fkit.model.User;
import com.fkit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> getAllUser() {

        List<User> allUser = userMapper.getAllUser();

        return allUser;
    }
}
