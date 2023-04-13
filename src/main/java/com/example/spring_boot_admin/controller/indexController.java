package com.example.spring_boot_admin.controller;

import com.example.spring_boot_admin.bean.Student;
import com.example.spring_boot_admin.bean.User;
import com.example.spring_boot_admin.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
@Slf4j
@Controller
public class indexController {
   @GetMapping(value={"/","/login"})
    public String loginPage(){
      return "login";

    }
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
       log.info("main");
            if(!StringUtils.isEmpty(user.getAccount())&&!StringUtils.isEmpty(user.getPassword()))
            {
                session.setAttribute("loginUser",user);
                //防止表单重复提交的最好方式：重定向
                return "redirect:/index.html";
            }else{
                model.addAttribute("msg","账号密码错误");
                return "login";
            }
    }
    @GetMapping("/index.html")
    public String indexPage(HttpSession session,Model model){
       /*是否登录，拦截器，过滤器*/
        Object user = session.getAttribute("loginUser");
            if(user!=null){
                return "index";
            }else{
                model.addAttribute("msg","请登录！");
                return "login";
            }

    }

    @Resource
    JdbcTemplate jdbcTemplate;
//   @Autowired
//    UserService userService;
   @ResponseBody//表明要返回json数据，而不是跳转页面
   @GetMapping("/user")
    public User getByAcc(@RequestParam("account")String account){
//        return userService.getUserByAcc(account);
       return null;
    }
    @Autowired
    StudentService studentService;
   @ResponseBody//表明要返回json数据，而不是跳转页面
   @GetMapping("/student")
    public Student getStuByAcc(@RequestParam("account")String account){
        return studentService.getStuByAcc(account);
//       return new User(account,"ss");
    }
   @ResponseBody//表明要返回json数据，而不是跳转页面
   @PostMapping("/student")
    public Student insertStu(
            @RequestParam("account")String account,
            @RequestParam("name")String name,
            @RequestParam("age")String age
            ){
        studentService.insertStu(new Student(account,name,age));
        return new Student(account,name,age);
//       return new User(account,"ss");
    }
}
