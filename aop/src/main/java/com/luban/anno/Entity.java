package com.luban.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 小贱
 * @create 2020-05-26 20:10
 */
//type--类  FIELD--属性  METHOD--方法
@Target(ElementType.TYPE) // 表示@Entity注解只能出现在类上面
//这个类存在哪里，class及source都会被jvm忽略
// class--存在class编译期中  source--存在源码中  RUNTIME--存在运行期中
@Retention(RetentionPolicy.RUNTIME)
public @interface Entity {

    public String value() default "";

    public String name() default "";

}
