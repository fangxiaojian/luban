package com.luban.dao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author 小贱
 * @create 2020-10-17 16:11
 */
@CacheNamespace
public interface UserMapper {

    @Select("select * from user")
    List<Map<String, Object>> list();

}
