package com.luban.test;

import com.luban.dao.XiaoJianUserDao;
import com.luban.dao.XiaoJianUserDaoImpl;
import com.luban.utils.LubanInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @author 小贱
 * @create 2020-09-24 21:10
 */
public class Test3 {

    public static void main(String[] args) {
        XiaoJianUserDao jdkProxy = (XiaoJianUserDao) Proxy.newProxyInstance(Test3.class.getClassLoader(),
                                                                            new Class[]{XiaoJianUserDao.class},
                                                                            new LubanInvocationHandler(new XiaoJianUserDaoImpl()));

        // jdkProxy 调用方法  是通过 InvocationHandler.invoke() 方法实现的
        jdkProxy.query();
        System.out.println(jdkProxy.query("xiaojian"));
    }
}
