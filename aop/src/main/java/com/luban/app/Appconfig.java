package com.luban.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author 小贱
 * @create 2020-06-08 18:55
 */
@Configuration
@ComponentScan("com")
@EnableAspectJAutoProxy
public class Appconfig {
}
