package cn.sp.app.dao;
import org.apache.ibatis.annotations.Param;
import cn.sp.app.entity.BackendUser;

public interface BackendUserDao {

	/**
	 * 通过userCode获取User
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public BackendUser getLoginUser(@Param("userCode")String userCode)throws Exception;

}
