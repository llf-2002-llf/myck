package cn.sp.app.service;

import cn.sp.app.entity.Dev_user;

public interface Dev_userService {
	public Dev_user login(String devCode,String devPassword);
}
