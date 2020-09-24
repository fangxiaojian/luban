package com.luban.dao;

import java.lang.reflect.Method;

/**
 * @author 小贱
 * @create 2020-09-24 22:02
 */
public interface CustomInvocationHandler {

    Object invoke(Method method);
    Object invoke(Method method, Object[] args);

}
