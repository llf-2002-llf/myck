package cn.sp.app.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sp.app.dao.Backend_userDao;
import cn.sp.app.entity.Backend_user;
import cn.sp.app.entity.Data_dictionary;
import cn.sp.app.service.Backend_userService;

@Service
public class Backend_userServiceImpl implements Backend_userService {

	@Resource
	private Backend_userDao bd;
	
	@Override
	public Backend_user login(String userCode, String userPassword,Data_dictionary dd) {
		return bd.login(userCode, userPassword, dd);
	}
}
