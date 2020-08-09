package com.luban.service;

import com.luban.dao.IndexDao;
import com.luban.dao.IndexDaoImpl1;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author 小贱
 * @create 2020-05-25 20:45
 */
@Service("service0")
@Scope("prototype")
public class IndexService0 implements InitializingBean, DisposableBean {
    public IndexService0() {
        System.out.println("IndexService0Constructor构造方法");
    }

    @Resource
    private IndexDao dao000;

    public void setDao01(IndexDao dao) {
        this.dao000 = dao;
    }

    public void service(){
        dao000.test();
        System.out.println("service = " + this.hashCode());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("serviceInit初始化");
    }

    @PostConstruct
    public void init(){
        System.out.println("自定义初始化方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("serviceDestroy销毁");
    }
}
