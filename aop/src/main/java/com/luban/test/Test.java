package com.luban.test;

import com.luban.entity.CityEntity;
import com.luban.util.CommUtil;

import java.lang.reflect.InvocationTargetException;

/**
 * @author 小贱
 * @create 2020-05-26 17:05
 */
public class Test {

    public static void main(String[] args) {
        CityEntity cityEntity = new CityEntity();
        cityEntity.setId("1");
        cityEntity.setName("test");
        String sql = null;
        try {
            sql = CommUtil.buildQuerySqlForEntity(cityEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // select * from city where id='1' and name='test'
        System.out.println(sql);
    }
}
