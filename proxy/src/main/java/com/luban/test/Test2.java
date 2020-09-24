package com.luban.test;

import com.luban.dao.UserDao;
import com.luban.dao.UserDaoImpl;
import com.luban.dao.XiaoJianUserDao;
import com.luban.dao.XiaoJianUserDaoImpl;
import com.luban.proxy1.UserDaoLog;
import com.luban.utils.ProxyUtil;

/**
 * @author 小贱
 * @create 2020-09-23 21:01
 */
public class Test2 {

    public static void main(String[] args) {
//        UserDao proxy = (UserDao) ProxyUtil.newInstance(new UserDaoImpl());
//        proxy.query();
//        proxy.query("xiaojian");

        XiaoJianUserDao dao = (XiaoJianUserDao) ProxyUtil.newInstance(new XiaoJianUserDaoImpl());
        dao.query();
        System.out.println(dao.query("xiaojian"));
    }
}
