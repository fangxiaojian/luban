package com.luban.factoryBeanAndBeanFactory.dao;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * 如果你的类实现了FactoryBean
 * 那么spring容器当中存在两个对象
 * 一个叫做 getObject() 返回对象
 * 还有一个是当前对象
 *
 * getObject 得到的对象存的是当前类指定的名字
 * 当前对象是 "&"+当前类的名字
 *
 * FactoryBean  --  spring service   createBean
 * BeanFactory  --  createBean
 *
 * @author 小贱
 * @create 2020-09-26 22:18
 */
@Component("daoFactoryBean")
public class DaoFactoryBean implements FactoryBean {

    public void testBean(){
        System.out.println("DaoFactoryBean  testBean");
    }


    @Override
    public Object getObject() throws Exception {
        return new TempDaoFactoryBean();
    }

    @Override
    public Class<?> getObjectType() {
        return TempDaoFactoryBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
