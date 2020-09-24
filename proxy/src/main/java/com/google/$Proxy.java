package com.google;
import com.luban.dao.UserDao;
public class $Proxy implements UserDao{
	private UserDao target;
	public $Proxy(UserDao target){
		this.target = target;
	}
	@Override
	public void query() {
		System.out.println(" log ");
		target.query();
	}
	@Override
	public void query(String p) {
		System.out.println(" log ");
		target.query(p);
	}
}