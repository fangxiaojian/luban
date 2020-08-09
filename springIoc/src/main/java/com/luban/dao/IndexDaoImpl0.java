package com.luban.dao;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * @author 小贱
 * @create 2020-05-25 15:09
 */
@Repository("dao000")
public class IndexDaoImpl0 implements IndexDao, InitializingBean {

    public IndexDaoImpl0(){
        System.out.println("IndexDaoImpl0Constructor构造方法");
    }

    private String str;

    @Override
    public void test() {
        System.out.println("impl0");
        System.out.println("dao0 = " + this.hashCode());
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("IndexDaoImpl0init初始化");
    }
}
