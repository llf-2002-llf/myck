package cn.sp.app.service.developer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sp.app.dao.appinfo.AppInfoDao;
import cn.sp.app.dao.appversion.AppVersionDao;
import cn.sp.app.entity.AppVersion;
@Service
public class AppVersionServiceImpl implements AppVersionService {
	
	@Resource
	private  AppVersionDao mapper;
	@Resource
	private AppInfoDao appInfoMapper;
	
	@Override
	public List<AppVersion> getAppVersionList(Integer appId) throws Exception {
		return mapper.getAppVersionList(appId);
	}

	@Override
	public boolean appsysadd(AppVersion appVersion) throws Exception {
		boolean flag = false;
		Integer versionId = null;
		if(mapper.add(appVersion) > 0){
			versionId = appVersion.getId();
			flag = true;
		}
		if(appInfoMapper.updateVersionId(versionId, appVersion.getAppId()) > 0 && flag){
			flag = true;
		}
		return flag;
	}
	@Override
	public AppVersion getAppVersionById(Integer id) throws Exception {
		return mapper.getAppVersionById(id);
	}
	@Override
	public boolean modify(AppVersion appVersion) throws Exception {
		boolean flag = false;
		if(mapper.modify(appVersion) > 0){
			flag = true;
		}
		return flag;
	}
	@Override
	public boolean deleteApkFile(Integer id) throws Exception {
		boolean flag = false;
		if(mapper.deleteApkFile(id) > 0){
			flag = true;
		}
		return flag;
	}

}
