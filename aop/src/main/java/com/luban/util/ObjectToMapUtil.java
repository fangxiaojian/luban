package com.luban.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 小贱
 * @create 2020-07-07 21:14
 */
public class ObjectToMapUtil {

    /**
     * 将对象包装成 key-value 的键值对
     * key 为 对象字段名
     * value 为 对象字段值
     * 需要有get方法
     * @param object
     * @return
     */
    public static Map<String, Object> toInfoMap(Object object) {
        Map<String, Object> infoMap = new HashMap<>();

        Class<?> clazz = object.getClass();

        // 获取所有的方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        String methodName = "";
        // 遍历方法
        for (Method method : declaredMethods) {
            // 找到 get的方法
            if (method.getName().contains("get")) {
                try {
                    // 获得属性值
                    Object o = method.invoke(object);

                    // 根据 get方法获取属性名
                    methodName = method.getName().substring(3,4).toLowerCase() + method.getName().substring(4);
                    if (o != null) {
                        infoMap.put(methodName, o);
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        return infoMap;
    }

}
