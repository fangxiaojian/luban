package com.luban.test;

import com.luban.entity.CityEntity;
import com.luban.util.ObjectToMapUtil;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 小贱
 * @create 2020-07-07 21:21
 */
public class TestToMapUtil {

    public static void main(String[] args) {
        CityEntity cityEntity = new CityEntity();
        cityEntity.setId("1");
        cityEntity.setName("test");
        Map<String, Object> map = ObjectToMapUtil.toInfoMap(cityEntity);
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + " : " + map.get(key));
        }
    }
}
