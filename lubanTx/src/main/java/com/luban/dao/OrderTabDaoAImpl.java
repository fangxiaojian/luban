package com.luban.dao;

import org.springframework.stereotype.Component;

/**
 * @author 小贱
 * @create 2020-10-26 20:43
 */
@Component
public class OrderTabDaoAImpl implements OrderTabDao {
    @Override
    public void query() {
        System.out.println("OrderTabDaoAImpl === query()");
    }
}
