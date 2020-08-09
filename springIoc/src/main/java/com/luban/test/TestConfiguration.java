package com.luban.test;

import com.luban.config.Spring;
import com.luban.filter.FilterService;
import com.luban.service.IndexService;
import com.luban.service.IndexService0;
import com.luban.service.IndexService1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 小贱
 * @create 2020-05-25 18:39
 */
public class TestConfiguration {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(Spring.class);
//        IndexService service = (IndexService) annotationConfigApplicationContext.getBean("service");
//        service.service();
//        IndexService1 service1 = (IndexService1) annotationConfigApplicationContext.getBean("service1");
//        service1.service();
        IndexService0 service = (IndexService0) annotationConfigApplicationContext.getBean("service0");
        service.service();

        IndexService0 service1 = (IndexService0) annotationConfigApplicationContext.getBean("service0");
        service1.service();

        FilterService service2 = (FilterService) annotationConfigApplicationContext.getBean("filterService");
        service2.service();
    }
}
