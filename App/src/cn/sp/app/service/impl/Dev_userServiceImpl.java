package cn.sp.app.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sp.app.dao.Dev_userDao;
import cn.sp.app.entity.Dev_user;
import cn.sp.app.service.Dev_userService;

@Service
public class Dev_userServiceImpl implements Dev_userService {
	
	@Resource
	private Dev_userDao dd;

	@Override
	public Dev_user login(String devCode, String devPassword) {
		return dd.login(devCode, devPassword);
	}
	
}
