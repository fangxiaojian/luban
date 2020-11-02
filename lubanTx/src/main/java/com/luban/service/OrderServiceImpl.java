package com.luban.service;

import com.luban.dao.OrderTabDao;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @author 小贱
 * @create 2020-10-26 20:47
 */
@Service
public class OrderServiceImpl implements ApplicationContextAware {

    ApplicationContext applicationContext;

//    @Autowired
//    private OrderTabDao dao;


    public void query(String userName){
        OrderTabDao orderTabDao = null;
        if ("A".equals(userName)) {
            orderTabDao = (OrderTabDao) applicationContext.getBean("orderTabDaoAImpl");
        }else if ("B".equals(userName)){
            orderTabDao = (OrderTabDao) applicationContext.getBean("orderTabDaoBImpl");
        }
        orderTabDao.query();
        System.out.println("OrderServiceImpl === query()");
//        dao.query();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
