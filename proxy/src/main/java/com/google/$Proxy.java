package com.google;
import com.luban.dao.XiaoJianUserDao;
import java.lang.reflect.Method;
import java.lang.Exception;
import com.luban.dao.CustomInvocationHandler;
public class $Proxy implements XiaoJianUserDao{
	private CustomInvocationHandler h;
	public $Proxy(CustomInvocationHandler h){
		this.h = h;
	}
	@Override
	public void query() throws Exception {
		Method method = Class.forName("com.luban.dao.XiaoJianUserDao").getDeclaredMethod("query");
		h.invoke(method);
	}
	@Override
	public java.lang.String query(String p0,int p) throws Exception {
		Object[] args = new Object[]{p0,p};
		Method method = Class.forName("com.luban.dao.XiaoJianUserDao").getMethod("query", String.class,int.class);
		return (java.lang.String)h.invoke(method, args);
	}
	@Override
	public java.lang.String query1(String p) throws Exception {
		Object[] args = new Object[]{p};
		Method method = Class.forName("com.luban.dao.XiaoJianUserDao").getMethod("query1", String.class);
		return (java.lang.String)h.invoke(method, args);
	}
}