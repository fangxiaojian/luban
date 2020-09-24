package com.luban.proxy1;

import com.luban.dao.UserDao;
import com.luban.utils.Logger;

/**
 * 代理对象与目标对象实现同个接口
 *
 * @author 小贱
 * @create 2020-09-23 21:19
 */
public class UserDaoLog implements UserDao {

    UserDao dao;

    /**
     * 装饰者模式
     * @param dao
     */
    public UserDaoLog(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void query() {
        Logger.log("聚合的方式实现打印日志📝！！！");
        dao.query();
    }

    @Override
    public void query(String str) {

    }
}
