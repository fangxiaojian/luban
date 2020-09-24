package com.luban.proxy;

import com.luban.dao.UserDaoImpl;
import com.luban.utils.Logger;

/**
 * @author 小贱
 * @create 2020-09-23 21:09
 */
public class UserDaoLogImpl extends UserDaoImpl {
    @Override
    public void query() {
        Logger.log("通过继承加强类的功能！！");
        super.query();
    }
}
