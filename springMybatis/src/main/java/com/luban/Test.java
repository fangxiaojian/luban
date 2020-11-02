package com.luban;

import com.luban.app.AppConfig;
import com.luban.log.LubanLog;
import com.luban.service.UserService;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 小贱
 * @create 2020-10-17 16:28
 */
public class Test {
    public static void main(String[] args) {
//        LogFactory.useLog4JLogging();
//        LogFactory.useSlf4jLogging();
        // 扩展 Mybatis，使用 JUL 打印日志
        LogFactory.useCustomLogging(LubanLog.class);
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = annotationConfigApplicationContext.getBean(UserService.class);
        System.out.println(userService.list());
    }
}
