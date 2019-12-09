package cn.sp.app.service.backend;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import cn.sp.app.dao.backenduser.BackendUserMapper;
import cn.sp.app.entity.BackendUser;

@Service
public class BackendUserServiceImpl implements BackendUserService {
	@Resource
	private BackendUserMapper mapper;
	
	@Override
	public BackendUser login(String userCode, String userPassword) throws Exception {
		// TODO Auto-generated method stub
		BackendUser user = null;
		user = mapper.getLoginUser(userCode);
		//匹配密码
		if(null != user){
			if(!user.getUserPassword().equals(userPassword))
				user = null;
		}
		return user;
	}

}
