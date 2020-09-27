package com.luban.xml.service;

import com.luban.xml.dao.UserDao;

/**
 * @author 小贱
 * @create 2020-09-26 13:19
 */
public class UserServiceImpl implements UserService {

    UserDao dao;

    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    public UserServiceImpl() {
    }

    @Override
    public void find() {
        System.out.println("UserService");
        dao.query();
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }
}
