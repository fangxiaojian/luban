package com.luban.annotation.util;

import com.luban.annotation.ano.Luban;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author 小贱
 * @create 2020-09-27 12:55
 */
public class AnnotationConfigAplicationContext {

    public void scan(String basePackage) {
        // 如何得到 Class.forName("com.luban.annotation.service.UserServiceImpl");
        // 项目的根路径
        String rootPath = this.getClass().getResource("/").getPath();
        String basePackagePath = basePackage.replace(".", "//");
        File file = new File(rootPath + "/" + basePackagePath);

        String[] names = file.list();
        for (String className : names) {
            String name = className.replace(".class", "");
            try {
                Class<?> clazz = Class.forName(basePackage + "." + name);
                // 判断是否是属于 @service
                if (clazz.isAnnotationPresent(Luban.class)){
                    Luban luban = clazz.getAnnotation(Luban.class);
                    System.out.println(luban.value());
                    System.out.println(clazz.newInstance());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
