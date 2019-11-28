package cn.sp.app.service;

import cn.sp.app.entity.Backend_user;
import cn.sp.app.entity.Data_dictionary;

public interface Backend_userService {
	public Backend_user login(String userCode,String userPassword,Data_dictionary dd);
}
