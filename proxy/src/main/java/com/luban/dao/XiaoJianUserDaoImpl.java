package com.luban.dao;

/**
 * @author 小贱
 * @create 2020-09-23 21:00
 */
public class XiaoJianUserDaoImpl implements XiaoJianUserDao {

    @Override
    public void query() throws Exception{
//        Logger.log("打破封装性，不建议怎么记录日志📝");
        System.out.println("假装查询数据库！！！");
    }

    @Override
    public String query1(String str) throws Exception{
        return str;
    }

    @Override
    public String query(String str, int nums) throws Exception {
        System.out.println("str:" + str + "   nums: " + nums);
        return str;
    }
}
