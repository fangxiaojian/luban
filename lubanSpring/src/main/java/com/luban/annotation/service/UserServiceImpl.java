package com.luban.annotation.service;

import com.luban.annotation.ano.Luban;
import com.luban.annotation.dao.UserDao;

/**
 * @author 小贱
 * @create 2020-09-26 13:19
 */
@Luban("userServiceImpl")
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
