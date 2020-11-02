package com.luban.test;

import com.luban.app.AppConfig;
import com.luban.dao.OrderTabDao;
import com.luban.service.OrderServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 小贱
 * @create 2020-05-26 17:05
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        annotationConfigApplicationContext.getBean(OrderServiceImpl.class).query("A");
    }
}
