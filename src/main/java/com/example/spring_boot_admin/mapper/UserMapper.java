package com.example.spring_boot_admin.mapper;

import com.example.spring_boot_admin.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public User getUser(String account);

}
