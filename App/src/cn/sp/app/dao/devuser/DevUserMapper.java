package cn.sp.app.dao.devuser;

import org.apache.ibatis.annotations.Param;

import cn.sp.app.entity.DevUser;

public interface DevUserMapper {
	
	public DevUser getLoginUser(@Param("devCode")String devCode)throws Exception;

}
