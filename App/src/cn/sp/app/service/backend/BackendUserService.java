package cn.sp.app.service.backend;
import cn.sp.app.entity.BackendUser;

public interface BackendUserService {
	/**
	 * 用户登录
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public BackendUser login(String userCode,String userPassword) throws Exception;
}
