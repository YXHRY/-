package com.example.spring_boot_admin.service.impl;

import com.example.spring_boot_admin.bean.User;
import com.example.spring_boot_admin.mapper.UserMapper;
import com.example.spring_boot_admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//注入到容器里面
//@Service
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    public User getUserByAcc(String account){

        return userMapper.getUser(account);
    }
}
