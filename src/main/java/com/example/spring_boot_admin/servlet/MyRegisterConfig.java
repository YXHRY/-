package com.example.spring_boot_admin.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Spring方式注入组件。@WebServlet等是原生注解方式注入
 */
//proxyBeanMethods = true保证依赖的组件始终是单实例的，防止组件冗余
@Configuration(proxyBeanMethods = true)
public class MyRegisterConfig  {
    @Bean
    public ServletRegistrationBean myServlet(){
        MyServlet servlet = new MyServlet();
        return new ServletRegistrationBean(servlet,"/myservlet");
    }
    @Bean
    public FilterRegistrationBean myFilter(){
        MyFilter filter = new MyFilter();
//        return new FilterRegistrationBean(filter,myServlet());
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(filter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/myservlet"));
        return filterRegistrationBean;

    }
    @Bean
    public ServletListenerRegistrationBean myListener(){
        MyServletContextListener listener = new MyServletContextListener();
        return new ServletListenerRegistrationBean(listener);
    }
}
