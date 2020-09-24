package com.luban.test;

import com.luban.dao.UserDao;
import com.luban.dao.UserDaoImpl;
import com.luban.proxy.UserDaoLogImpl;
import com.luban.proxy1.UserDaoLog;

/**
 * @author 小贱
 * @create 2020-09-23 21:01
 */
public class Test1 {

    public static void main(String[] args) {
        UserDao target = new UserDaoImpl();
        UserDao proxy = new UserDaoLog(target);
        proxy.query();
    }
}
