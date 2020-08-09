package com.luban.aspectj;

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

    @Pointcut("execution(* com.luban.dao.*.*(..))") // 添加切入点
    public void pointCut() {
        System.out.println("pointCut"); // 不打印
    }

    /**
     * 通知
     * location
     * login
     */

    @Before("pointCut()") // 通知到方法的前面去
    public void bdfore() {
        System.out.println("before pointCut()");
    }
}
