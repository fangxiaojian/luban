package com.luban.test;

import com.luban.app.Appconfig;
import com.luban.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 小贱
 * @create 2020-06-08 18:57
 */
public class TestAspectJ {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(Appconfig.class);
        IndexDao dao = annotationConfigApplicationContext.getBean(IndexDao.class);
        dao.query();
    }
}
