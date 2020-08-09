package com.luban.test;

import com.luban.service.IndexService;
import com.luban.service.IndexService0;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 小贱
 * @create 2020-05-25 15:13
 */
public class TestXML {
    public static void main(String[] args) {
        // 获取xml配置文件
        ClassPathXmlApplicationContext classPathXmlApplicationContext
                = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IndexService0 service = (IndexService0) classPathXmlApplicationContext.getBean("service0");
        service.service();
    }
}
