package com.luban.factoryBeanAndBeanFactory.test;

import com.luban.factoryBeanAndBeanFactory.config.Spring;
import com.luban.factoryBeanAndBeanFactory.dao.DaoFactoryBean;
import com.luban.factoryBeanAndBeanFactory.dao.TempDaoFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 小贱
 * @create 2020-09-26 22:20
 */
public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Spring.class);

        // 得到的是当前对象指定的类的名字
        TempDaoFactoryBean tempDaoFactoryBean = (TempDaoFactoryBean) annotationConfigApplicationContext.getBean("daoFactoryBean");
        tempDaoFactoryBean.test();

        // &+类名  ==》 得到的是当前类
        DaoFactoryBean daoFactoryBean = (DaoFactoryBean) annotationConfigApplicationContext.getBean("daoFactoryBean");
        daoFactoryBean.testBean();
    }
}
