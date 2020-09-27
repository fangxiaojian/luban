package com.luban.xml.test;

import com.luban.xml.service.UserService;
import org.spring.util.BeanFactory;

/**
 * @author 小贱
 * @create 2020-09-26 13:20
 */
public class Test1 {
    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory("spring.xml");

        UserService service = (UserService) beanFactory.getBean("service");
        service.find();

    }
}
