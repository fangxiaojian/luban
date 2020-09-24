package com.luban.utils;

import com.luban.dao.CustomInvocationHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 小贱
 * @create 2020-09-24 22:04
 */
public class TestCustomHandler implements CustomInvocationHandler {

    Object target;

    public TestCustomHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Method method, Object[] args) {
        System.out.println("TestCustomHandler args-----");
        try {
            return method.invoke(target, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Object invoke(Method method) {
        System.out.println("TestCustomHandler -----");
        try {
            return method.invoke(target);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
