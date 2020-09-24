package com.luban.aspectj;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 小贱
 * @create 2020-06-08 18:58
 */
@Component
@Aspect
public class LubanAspectj {

    /**
     * 声明一个方法
     */
    @Pointcut("execution(* com.luban.dao.*.*(..))")
    public void pointCutExecution() {
        // 不打印
        System.out.println("pointCut");
    }

    @Pointcut("within(com.luban.dao.*)")
    public void pointCutWithin() {
        // 不打印
        System.out.println("pointCut");
    }

    /**
     * 通知
     * 通知到方法的前面去
     */
    @Before("pointCutExecution()")
    public void before() {
        System.out.println("beforeExecution pointCut()");
    }

    /**
     * 通知
     * 通知到方法的后面去
     */
    @After("pointCutExecution()")
    public void after() {
        System.out.println("afterExecution pointCut()");
    }

    /**
     * 有机会在该方法运行之前和之后进行工作，并确定何时，如何以及即使该方法实际上可以运行。
     * 如果需要以线程安全的方式（例如，启动和停止计时器）在方法执行之前和之后共享状态，则通常使用 around 通知。
     * 始终使用最不符合要求的通知形式（即，在通知可以使用 before，不要在通知使用 around）。
     */
//    @Around("pointCutExecution()")
//    public void around() {
//        System.out.println("around pointCut()");
//    }

    /**
     * 通知
     * 通知到方法的前面去
     */
    @Before("pointCutWithin()")
    public void beforeWithin() {
        System.out.println("beforeWithin pointCut()");
    }

    /**
     * 通知
     * 通知到方法的后面去
     */
    @After("pointCutWithin()")
    public void afterWithin() {
        System.out.println("afterWithin pointCut()");
    }
}
