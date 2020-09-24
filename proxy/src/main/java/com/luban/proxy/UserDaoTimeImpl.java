package com.luban.proxy;

import com.luban.dao.UserDaoImpl;
import com.luban.utils.Logger;

/**
 * @author 小贱
 * @create 2020-09-23 21:09
 */
public class UserDaoTimeImpl extends UserDaoImpl {
    @Override
    public void query() {
        Logger.log("开始时间");
        super.query();
        Logger.log("结束时间");
    }
}
