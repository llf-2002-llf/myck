package cn.sp.app.service.developer;

import java.util.List;

import cn.sp.app.entity.AppInfo;

public interface AppInfoService {
	
	public boolean add(AppInfo appInfo) throws Exception;

	public boolean modify(AppInfo appInfo)throws Exception;
	
	public boolean deleteAppInfoById(Integer delId)throws Exception;
	
	public List<AppInfo> getAppInfoList(String querySoftwareName,Integer queryStatus,
								Integer queryCategoryLevel1,Integer queryCategoryLevel2,
								Integer queryCategoryLevel3,Integer queryFlatformId,
								Integer devId,Integer currentPageNo,Integer pageSize)throws Exception;
	
	public int getAppInfoCount(String querySoftwareName,Integer queryStatus,
							Integer queryCategoryLevel1,Integer queryCategoryLevel2,
							Integer queryCategoryLevel3,Integer queryFlatformId,Integer devId)throws Exception;

	public AppInfo getAppInfo(Integer id,String APKName)throws Exception;
	
	public boolean deleteAppLogo(Integer id)throws Exception;
	
	public boolean appsysdeleteAppById(Integer id)throws Exception;
	
	public boolean appsysUpdateSaleStatusByAppId(AppInfo appInfo) throws Exception;
}
