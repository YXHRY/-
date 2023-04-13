package com.example.spring_boot_admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传测试
 */
@Slf4j
@Controller
public class FormTestController {
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    /**
     *
     * @param email
     * @param name
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("name") String name,
                         @RequestPart("headerImg") MultipartFile headerImg,//MultipartFile会自动封装上传过来的文件
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {//上传的内容可以是图片、文档、PPT等
        log.info("上传信息：email={},name={},headerImg={},photos={}"
                ,email,name,headerImg.getSize(),photos.length);
        if(!headerImg.isEmpty()){
            String originalFilename=headerImg.getOriginalFilename();
            headerImg.transferTo(new File("D:\\z\\"+originalFilename));
        }
        if(photos.length>0){
            for(MultipartFile photo:photos){
                if(!photo.isEmpty()){
                    String originalFilename=photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\z\\"+originalFilename));
                }
            }
        }
        return "/index.html";
    }
}
