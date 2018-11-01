package com.frsp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:spring/spring-*.xml"})
@WebAppConfiguration(value = "src/main/webapp")
public class BaseTest {

    @Test
    public void test(){
        System.out.println("Hello test");
    }
}
