package com.luban.util;

import com.luban.anno.Entity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 小贱
 * @create 2020-05-26 17:06
 */
public class CommUtil {

    /**
     * 通过一个对象构建一条查询的sql语句
     * @param object
     */
    public static String buildQuerySqlForEntity(Object object) throws Exception {

        Class clazz = object.getClass();

        String sql = "";

        // 1. 判断是否加了这个注解
        if (clazz.isAnnotationPresent(Entity.class)) {
            // 2. 得到注解
            Entity entity = (Entity) clazz.getDeclaredAnnotation(Entity.class);
            // 3. 调用方法
            String value = entity.value();
            sql = "select * from " + value;
        }

        // 获取所有的方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        String methodName = "";
        boolean isWhere = true;
        // 遍历方法
        for (Method method : declaredMethods) {
            // 找到 get的方法
            if (method.getName().contains("get")) {
                Object o = method.invoke(object);
                // 根据 get方法获取属性名
                methodName = method.getName().substring(3,4).toLowerCase() + method.getName().substring(4);
                if (o != null && isWhere) {
                    isWhere = false;
                    sql = sql + " where " + methodName + "='" + o + "'";
                }else if (o != null) {
                    sql = sql + " and " + methodName + "='" + o + "'";
                }
            }
        }
        // select * from city where id='1' and name='test'


        return sql;
    }
}
