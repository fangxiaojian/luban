package com.luban.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 小贱
 * @create 2020-09-24 21:14
 */
public class LubanInvocationHandler implements InvocationHandler {

    Object target;

    public LubanInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy  代理对象， 看不到的对象
     * @param method  目标对象的方法， 被代理的对象
     * @param args    目标方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK Proxy");
        return method.invoke(target, args);
    }
}
