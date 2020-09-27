package com.luban.factoryBeanAndBeanFactory.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 小贱
 * @create 2020-05-25 18:38
 */
@Configuration
//@ComponentScan(value = "com.luban", excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern={"com.luban.filter.*"})}) // 扫描包
@ComponentScan(value = "com.luban.factoryBeanAndBeanFactory") // 扫描包
public class Spring {

}
