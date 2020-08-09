package com.luban.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author 小贱
 * @create 2020-05-25 18:38
 */
@Configuration
//@ComponentScan(value = "com.luban", excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern={"com.luban.filter.*"})}) // 扫描包
@ComponentScan(value = "com.luban") // 扫描包
@ImportResource("classpath:spring.xml") // 引入xml配置
public class Spring {

    @Bean
    @Autowired
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/luban");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        return dataSource;
    }
}
