package com.example.spring_boot_admin.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
//@WebServlet(urlPatterns ={"/myservlet"} )//还需要开启扫描，在SpringBootAdminApplication类中
public class MyServlet extends HttpServlet {
    @Override
    public void destroy() {
        log.info("MyServlet-------销毁");
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log.info("MyServlet----init---");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("MyServlet----------doGet-------");
        super.doGet(req, resp);
    }
}
