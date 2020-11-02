package com.luban.app;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 小贱
 * @create 2020-10-26 20:33
 */
@Component
@Aspect
public class AspectLuban {

    @Pointcut("execution(* com.luban.dao.*.*(..))")
    public void pointCut(){
        System.out.println("AspectLuban === pointCut()");
    }
    

    @Before("pointCut()")
    public void before(){
        System.out.println("AspectLuban === before()");
    }
}
