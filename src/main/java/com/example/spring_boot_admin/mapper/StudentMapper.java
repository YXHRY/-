package com.example.spring_boot_admin.mapper;

import com.example.spring_boot_admin.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {
//    不需要mybatis文件夹下的全局配置文件和.xml文件了
    @Select("select * from  student where account=#{account}")
    public Student getStudent(String account);
    @Select("insert into student values(#{account},#{name},#{age})")
//    @Options(useGeneratedKeys=true,keyProperty="account")
    public void insert(Student stu);
}