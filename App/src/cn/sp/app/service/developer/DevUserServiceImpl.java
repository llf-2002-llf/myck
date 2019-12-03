package cn.sp.app.service.developer;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import cn.sp.app.dao.devuser.DevUserDao;
import cn.sp.app.entity.DevUser;

@Service
public class DevUserServiceImpl implements DevUserService {
	@Resource
	private DevUserDao mapper;
	@Override
	public DevUser login(String devCode, String devPassword) throws Exception {
		DevUser user = null;
		user = mapper.getLoginUser(devCode);
		if(null != user){
			if(!user.getDevPassword().equals(devPassword))
				user = null;
		}
		return user;
	}

}
