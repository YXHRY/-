package com.example.spring_boot_admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.spring_boot_admin.bean.User;
import com.example.spring_boot_admin.bean.Uuser;
import com.example.spring_boot_admin.service.UuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {
  @GetMapping("/basic_table")
public String basic_table(){
    return "table/basic_table";
}
@Autowired
UuserService uuserService;
  @GetMapping("/dynamic_table")
public String dynamic_table(@RequestParam(value="pn",defaultValue = "1")Integer pn ,Model model){
//      List<User> users = Arrays.asList(
//              new User("123456", "123"),
//              new User("1234567", "123"),
//              new User("12345678", "123")
//      );
//      model.addAttribute("users",users);
      List<Uuser> list = uuserService.list();
//      model.addAttribute("uusers",list);
      Page<Uuser> page = new Page<>(pn, 2);
      uuserService.page(page,null);
      model.addAttribute("page",page);
      List<Uuser> records = page.getRecords();
      return "table/dynamic_table";
}
@GetMapping("/user/delete/{id}")
public String deleteUuser(@PathVariable("id") Long id){
    uuserService.removeById(id);
    return "redirect:/dynamic_table";
}
  @GetMapping("/responsive_table")
public String responsive_table(){
    return "table/responsive_table";
}
  @GetMapping("/pricing_table")
public String pricing_table(){
    return "table/pricing_table";
}
  @GetMapping("/editable_table")
public String editable_table(){
    return "table/editable_table";
}
}
