package com.luban.test;

import com.luban.app.AppConfig;
import com.luban.service.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring 4.X 版本使用 JCL 日志
 * @author 小贱
 * @create 2020-10-13 20:43
 */
public class Test {

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext annotationConfigApplicationContext =
//                new AnnotationConfigApplicationContext(AppConfig.class);
//        annotationConfigApplicationContext.start();
//        IndexService service = (IndexService) annotationConfigApplicationContext.getBean("indexService");
//        service.query();
        Logger logger = LoggerFactory.getLogger("spring");
        logger.info("spring");
    }
}
