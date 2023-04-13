package com.example.spring_boot_admin.service;

import com.example.spring_boot_admin.bean.Student;

public interface StudentService {
    Student getStuByAcc(String account);

    void insertStu(Student student);
}
