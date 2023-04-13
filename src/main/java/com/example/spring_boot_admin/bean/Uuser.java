package com.example.spring_boot_admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("uuser")//对应数据库中的uuser表
public class Uuser {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField(exist=false)//代表这个属性在表中不存在
    private String dd;
}
