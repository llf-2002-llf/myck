package cn.sp.app.service.developer;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import cn.sp.app.dao.appinfo.AppInfoMapper;
import cn.sp.app.dao.appversion.AppVersionMapper;
import cn.sp.app.entity.AppInfo;
import cn.sp.app.entity.AppVersion;

@Service
public class AppInfoServiceImpl implements AppInfoService {
	@Resource
	private AppInfoMapper mapper;
	@Resource
	private AppVersionMapper appVersionMapper;
	
	@Override
	public boolean add(AppInfo appInfo) throws Exception {
		boolean flag = false;
		if(mapper.add(appInfo) > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean modify(AppInfo appInfo) throws Exception {
		boolean flag = false;
		if(mapper.modify(appInfo) > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deleteAppInfoById(Integer delId) throws Exception {
		boolean flag = false;
		if(mapper.deleteAppInfoById(delId) > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public AppInfo getAppInfo(Integer id,String APKName) throws Exception {
		return mapper.getAppInfo(id,APKName);
	}

	@Override
	public List<AppInfo> getAppInfoList(String querySoftwareName,
									Integer queryStatus, Integer queryCategoryLevel1,
									Integer queryCategoryLevel2, Integer queryCategoryLevel3,
									Integer queryFlatformId, Integer devId, Integer currentPageNo,
									Integer pageSize) throws Exception {
		return mapper.getAppInfoList(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId, (currentPageNo-1)*pageSize, pageSize);
	}

	@Override
	public int getAppInfoCount(String querySoftwareName, Integer queryStatus,
			Integer queryCategoryLevel1, Integer queryCategoryLevel2,
			Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId)
			throws Exception {
		return mapper.getAppInfoCount(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId,devId);
	}

	@Override
	public boolean deleteAppLogo(Integer id) throws Exception {
		boolean flag = false;
		if(mapper.deleteAppLogo(id) > 0){
			flag = true;
		}
		return flag;
	}
	
	@Override
	public boolean appsysdeleteAppById(Integer id) throws Exception {
		boolean flag = false;
		int versionCount = appVersionMapper.getVersionCountByAppId(id);
		List<AppVersion> appVersionList = null;
		if(versionCount > 0){
			appVersionList = appVersionMapper.getAppVersionList(id);
			for(AppVersion appVersion:appVersionList){
				if(appVersion.getApkLocPath() != null && !appVersion.getApkLocPath().equals("")){
					File file = new File(appVersion.getApkLocPath());
					if(file.exists()){
						if(!file.delete())
							throw new Exception();
					}
				}
			}			
			appVersionMapper.deleteVersionByAppId(id);
		}
		AppInfo appInfo = mapper.getAppInfo(id, null);
		if(appInfo.getLogoLocPath() != null && !appInfo.getLogoLocPath().equals("")){
			File file = new File(appInfo.getLogoLocPath());
			if(file.exists()){
				if(!file.delete())
					throw new Exception();
			}
		}
		if(mapper.deleteAppInfoById(id) > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean appsysUpdateSaleStatusByAppId(AppInfo appInfoObj) throws Exception {
		
		Integer operator = appInfoObj.getModifyBy();
		if(operator < 0 || appInfoObj.getId() < 0 ){
			throw new Exception();
		}
		
		AppInfo appInfo = mapper.getAppInfo(appInfoObj.getId(), null);
		if(null == appInfo){
			return false;
		}else{
			switch (appInfo.getStatus()) {
				case 2: 
					onSale(appInfo,operator,4,2);
					break;
				case 5:
					onSale(appInfo,operator,4,2);
					break;
				case 4:
					offSale(appInfo,operator,5);
					break;

			default:
				return false;
			}
		}
		return true;
	}
	
	private void onSale(AppInfo appInfo,Integer operator,Integer appInfStatus,Integer versionStatus) throws Exception{
		offSale(appInfo,operator,appInfStatus);
		setSaleSwitchToAppVersion(appInfo,operator,versionStatus);
	}
	
	private boolean offSale(AppInfo appInfo,Integer operator,Integer appInfStatus) throws Exception{
		AppInfo _appInfo = new AppInfo();
		_appInfo.setId(appInfo.getId());
		_appInfo.setStatus(appInfStatus);
		_appInfo.setModifyBy(operator);
		_appInfo.setOffSaleDate(new Date(System.currentTimeMillis()));
		mapper.modify(_appInfo);
		return true;
	}
	
	private boolean setSaleSwitchToAppVersion(AppInfo appInfo,Integer operator,Integer saleStatus) throws Exception{
		AppVersion appVersion = new AppVersion();
		appVersion.setId(appInfo.getVersionId());
		appVersion.setPublishStatus(saleStatus);
		appVersion.setModifyBy(operator);
		appVersion.setModifyDate(new Date(System.currentTimeMillis()));
		appVersionMapper.modify(appVersion);
		return false;
	}
	
}
