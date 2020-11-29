package com.rambo.plugin.common;

public interface StatusCode {
	
	//成功
	public static final int SUCCESS = 20000;
	
	//失败
	public static final int FAIL = 20001;
	
	//用户名或密码错误
	public static final int LOGINFAIL = 20002;
	
	//权限不足
	public static final int ACCESSFAIL = 20003;
	
	//远程调用失败
	public static final int REMOTEFAIL = 20004;
	
	//重复操作
	public static final int REPFAIL = 20005;
	
}

