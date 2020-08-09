package com.luban.service;

import com.luban.dao.IndexDao;
import com.luban.dao.IndexDaoImpl1;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @author 小贱
 * @create 2020-05-25 15:10
 */
@Service("service1")
public abstract class IndexService1{

    @Lookup("dao1")
    public abstract IndexDao getDao();

    private IndexDao dao0;

    public void service(){
        dao0 = getDao();

        dao0.test();
        System.out.println("service = " + this.hashCode());
    }

}
