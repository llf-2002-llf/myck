package cn.sp.app.dao;

import org.apache.ibatis.annotations.Param;

import cn.sp.app.entity.Dev_user;

public interface Dev_userDao {
	public Dev_user login(@Param("devCode") String devCode,
						  @Param("devPassword") String devPassword);
}
