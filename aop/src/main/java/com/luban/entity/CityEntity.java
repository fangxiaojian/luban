package com.luban.entity;

import com.luban.anno.Entity;

/**
 * @author 小贱
 * @create 2020-05-26 17:04
 */
@Entity(value = "city", name = "cityEntity")
public class CityEntity {
    private String id;
    private String name;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
