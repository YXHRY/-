package com.example.spring_boot_admin;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest//想使用springboot中的容器功能需要加上这个注解
@DisplayName("Junit5测试")
public class Junit5Test {
    @Test
    @Disabled//表示测试类或测试方法不执行
    void test2(){
        System.out.println("test2....");
    }
    @Test
    @Transactional//标注的测试方法在测试完后会自动回滚
    @DisplayName("测试displayName注解")
    void TestDisplayName(){
        System.out.println(1);
    }
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Test
    @Timeout(value=500,unit= TimeUnit.MILLISECONDS)//该方法如果超过500毫秒就是超时
    void testTimeout() throws InterruptedException {
        System.out.println(jdbcTemplate);
//    Thread.sleep(600);
    }
    @Test
    @RepeatedTest(5)
    void test3(){
        System.out.println(5);
    }
    @Test
    @DisplayName("测试简单断言")
    void testSimpleAssertions(){
        int cal = cal(2, 3);
       assertEquals(5,cal,"不相等");
        Object o1 = new Object();
        Object o2=new Object();
//        assertSame(o1,o2);
        assertArrayEquals(new int[]{2,2},new int[]{2,2});
        assertAll("test",
                ()->assertTrue(true&&true),
                ()->assertEquals(1,1));
    }
    int cal(int i,int j){
        return i+j;
    }
    @DisplayName("异常断言")
    @Test
    void testException(){
//        断定业务逻辑一定出现异常
        assertThrows(ArithmeticException.class,()->{
            int i=10/0;

        },"居然正确？");
    }
    @DisplayName("快速失败")
    @Test
    void testFail(){
        int i=2;
        if(i==2){
            fail("测试失败");
        }
    }
    @DisplayName("测试前置条件")
    @Test
    void testAssumptions(){
        Assumptions.assumeTrue(true,"结果不是true");
        System.out.println("1111111");
    }
    @BeforeEach
    void testBeforeEach(){
        System.out.println("<每个>测试方法运行<前>都会运行的代码......");
    }
    @AfterEach
    void testAfterEach(){
        System.out.println("<每个>测试方法运行<后>都会运行的代码......");
    }
    @BeforeAll
    static void  testBeforeAll(){
        System.out.println("<所有>测试方法运行<前>都会运行的代码......");
    }
    @AfterAll
   static void testAfterAll(){
        System.out.println("<所有>测试方法运行<后>都会运行的代码......");
    }
}
