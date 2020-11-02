package com.luban.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author 小贱
 * @create 2020-10-26 20:33
 */
@Configuration
@ComponentScan(value = "com.luban")
@EnableAspectJAutoProxy
public class AppConfig {
}
