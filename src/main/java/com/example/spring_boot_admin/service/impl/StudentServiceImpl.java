package com.example.spring_boot_admin.service.impl;

import com.example.spring_boot_admin.bean.Student;
import com.example.spring_boot_admin.mapper.StudentMapper;
import com.example.spring_boot_admin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    public Student getStuByAcc(String account){
        return studentMapper.getStudent(account);
    }
    public void insertStu(Student stu){
         studentMapper.insert(stu);
    }
}
