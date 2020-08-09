package com.luban.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * @author 小贱
 * @create 2020-05-25 15:09
 */
@Repository("dao1")
@Scope("prototype")
public class IndexDaoImpl1 implements IndexDao {

    private String str;

    @Override
    public void test() {
        System.out.println("str=" + this.str);
        System.out.println("impl1");
        System.out.println("dao1 = " + this.hashCode());
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
