package com.zhongkexinli.cloud.secrity.controller;

public class BaseController {
	
	public static final int LOGIN_UID = 0;
	public static final String USER_NAME = "admin";
	
	public Integer getLoginId() {
		//fixed me
		return LOGIN_UID;
	}

	public String getUserName() {
		return USER_NAME;
	}
}
