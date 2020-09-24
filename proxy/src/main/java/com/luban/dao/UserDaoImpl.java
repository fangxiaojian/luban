package com.luban.dao;

import com.luban.utils.Logger;

/**
 * @author 小贱
 * @create 2020-09-23 21:00
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void query(){
//        Logger.log("打破封装性，不建议怎么记录日志📝");
        System.out.println("假装查询数据库！！！");
    }

    @Override
    public void query(String str) {
        System.out.println(str);
    }
}
