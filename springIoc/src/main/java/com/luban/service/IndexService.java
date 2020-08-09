package com.luban.service;

import com.luban.dao.IndexDao;
import com.luban.dao.IndexDaoImpl1;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 小贱
 * @create 2020-05-25 15:10
 */
@Service("service")
public class IndexService  implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    /**
     * 注入的两种方式
     * 构造方法和set
     * @param dao
     */
//    public IndexService(IndexDao dao){
//        this.dao = dao;
//    }
    public void setDao(IndexDao dao) {
        this.dao0 = dao;
    }


//    @Resource
    private IndexDao dao0;

    public void service(){
        dao0 = (IndexDaoImpl1) applicationContext.getBean("dao1");

        dao0.test();
        System.out.println("service = " + this.hashCode());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
