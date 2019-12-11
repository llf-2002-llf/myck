package cn.sp.app.dao.backenduser;
import org.apache.ibatis.annotations.Param;

import cn.sp.app.entity.BackendUser;

public interface BackendUserMapper {

	public BackendUser getLoginUser(@Param("userCode")String userCode)throws Exception;

}
