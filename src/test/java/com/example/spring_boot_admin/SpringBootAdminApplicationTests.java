package com.example.spring_boot_admin;


import com.example.spring_boot_admin.bean.Uuser;
import com.example.spring_boot_admin.mapper.UuserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
//@RunWith(SpringRunner.class)
class SpringBootAdminApplicationTests {
    @Resource
    JdbcTemplate jdbcTemplate;
    @Test
    void contextLoads() {
        Integer num = jdbcTemplate.queryForObject("select count(*) from user", Integer.class);
        System.out.println(num);
        log.info("user表中共有记录：{}条",num);
//        jdbcTemplate.queryForList("select * from user");
    }
    @Autowired
    UuserMapper uuserMapper;
    @Test
    void testUuserMapper(){
        Uuser uuser = uuserMapper.selectById(1);
        log.info("{}",uuser);
    }



}
