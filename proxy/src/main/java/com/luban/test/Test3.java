package com.luban.test;

import com.luban.dao.XiaoJianUserDao;
import com.luban.dao.XiaoJianUserDaoImpl;
import com.luban.utils.LubanInvocationHandler;
import com.luban.utils.ProxyMethod;
import com.luban.utils.ProxyUtil;
import com.luban.utils.TestCustomHandler;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.lang.reflect.Proxy;

/**
 * @author 小贱
 * @create 2020-09-24 21:10
 */
public class Test3 {

    public static void main(String[] args) throws Exception {

        XiaoJianUserDao dao = (XiaoJianUserDao) ProxyUtil.newInstance(XiaoJianUserDao.class, new TestCustomHandler(new XiaoJianUserDaoImpl()));
        dao.query();
        System.out.println(dao.query1("xiaojian"));
        System.out.println(dao.query("xiaojian", 10));

//        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy1", new Class[]{XiaoJianUserDao.class});
//        File file = new File("/Users/xiaojian/IDEAWorkspace/luban/proxy/src/main/java/com/google/$Proxy1.class");
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        try {
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            fileOutputStream.write(bytes);
//            fileOutputStream.flush();
//            fileOutputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        XiaoJianUserDao jdkProxy = (XiaoJianUserDao) Proxy.newProxyInstance(Test3.class.getClassLoader(),
                                                                            new Class[]{XiaoJianUserDao.class},
                                                                            new LubanInvocationHandler(new XiaoJianUserDaoImpl()));

        // jdkProxy 调用方法  是通过 InvocationHandler.invoke() 方法实现的
        jdkProxy.query();
        System.out.println(jdkProxy.query1("xiaojian"));
    }
}
