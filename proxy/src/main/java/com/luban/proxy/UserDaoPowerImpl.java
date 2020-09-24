package com.luban.proxy;

import com.luban.dao.UserDaoImpl;
import com.luban.utils.Logger;

/**
 * @author 小贱
 * @create 2020-09-23 21:09
 */
public class UserDaoPowerImpl extends UserDaoImpl {
    @Override
    public void query() {
        Logger.log("power  假装进行权限验证！！");
        super.query();
    }
}
