package cn.sp.app.dao;

import org.apache.ibatis.annotations.Param;

import cn.sp.app.entity.Backend_user;
import cn.sp.app.entity.Data_dictionary;

public interface Backend_userDao {
	public Backend_user login(@Param("userCode") String userCode,
			  			      @Param("userPassword") String userPassword,Data_dictionary dd);
}
