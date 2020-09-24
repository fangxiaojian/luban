package com.google;
import com.luban.dao.XiaoJianUserDao;
public class $Proxy implements XiaoJianUserDao{
	private XiaoJianUserDao target;
	public $Proxy(XiaoJianUserDao target){
		this.target = target;
	}
	@Override
	public void query() {
		System.out.println(" log ");
		target.query();
	}
	@Override
	public java.lang.String query(String p) {
		System.out.println(" log ");
		return target.query(p);
	}
}