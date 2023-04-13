package com.example.spring_boot_admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.spring_boot_admin.bean.Uuser;
import com.example.spring_boot_admin.mapper.UuserMapper;
import com.example.spring_boot_admin.service.UuserService;
import org.springframework.stereotype.Service;

@Service
public class UuserServiceImpl extends ServiceImpl<UuserMapper, Uuser> implements UuserService {

}
