package com.luban.service;

import com.luban.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 小贱
 * @create 2020-10-17 16:12
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<Map<String, Object>> list(){
        /*
        通过 开启日志查看 sql 语句
        可以发现 一共 打印 4条 sql 语句
        证明 mybatis 一级缓存失效
        原因：sqlSession 交给 spring 管理，每次使用后都会被关闭

        在 UserMapper 中使用 @CacheNamespace （mybatis 包下的）
        注解可以开启 mybatis 的二级缓存

        二级缓存的缺点
            命名空间隔离
            正常来说
                使用 select 查询时 会先查看是否有缓存，有则使用缓存
                当调用 update、insert、delete 时会更新缓存
            但是 mybatis 二级缓存 会根据 类的全限定名 来定义
            即 "com.luban.dao.UserMapper"
            当 select，update 都在 同个类中进行时
            二级缓存将可以正常使用

            但是当 select、update在不同的类中调用时
            select 查询多次的结果将不会变化
            因为 update 只会更新 他所在类 的全限定名的缓存
            select 会一直去查询他所在 类的 缓存中的数据
         */
        userMapper.list();
        userMapper.list();
        userMapper.list();
        return userMapper.list();
    }
}
