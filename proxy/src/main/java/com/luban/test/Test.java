package com.luban.test;

import com.luban.dao.UserDaoImpl;
import com.luban.proxy.UserDaoLogImpl;

/**
 * @author 小贱
 * @create 2020-09-23 21:01
 */
public class Test {

    /**
     * 正常访问
     * 直接调用方法
     * @param args
     */
    public static void main(String[] args) {
        UserDaoImpl dao = new UserDaoLogImpl();
        dao.query();
    }
}
