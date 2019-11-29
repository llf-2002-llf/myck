package cn.sp.app.service;

import java.util.List;
import cn.sp.app.entity.App_info;

public interface App_infoService {
	
	/**
	 * 新增app
	 * @param appInfo
	 * @return
	 * @throws Exception
	 */
	public boolean add(App_info appInfo) throws Exception;
	/**
	 * 修改app信息
	 * @param appInfo
	 * @return
	 * @throws Exception
	 */
	public boolean modify(App_info appInfo)throws Exception;
	
	/**
	 * 根据appId删除app应用
	 * @param delId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteAppInfoById(Integer delId)throws Exception;
	
	/**
	 * 根据条件查询出app列表
	 * @param querySoftwareName
	 * @param queryStatus
	 * @param queryCategoryLevel1
	 * @param queryCategoryLevel2
	 * @param queryCategoryLevel3
	 * @param queryFlatformId
	 * @param devId
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<App_info> getAppInfoList(String querySoftwareName,Integer queryStatus,
								Integer queryCategoryLevel1,Integer queryCategoryLevel2,
								Integer queryCategoryLevel3,Integer queryFlatformId,
								Integer devId,Integer currentPageNo,Integer pageSize)throws Exception;
	
	/**
	 * 根据条件查询appInfo表记录数
	 * @param querySoftwareName
	 * @param queryStatus
	 * @param queryCategoryLevel1
	 * @param queryCategoryLevel2
	 * @param queryCategoryLevel3
	 * @param queryFlatformId
	 * @param devId
	 * @return
	 * @throws Exception
	 */
	public int getAppInfoCount(String querySoftwareName,Integer queryStatus,
							Integer queryCategoryLevel1,Integer queryCategoryLevel2,
							Integer queryCategoryLevel3,Integer queryFlatformId,Integer devId)throws Exception;
	/**
	 * 根据id、apkName查找appInfo
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public App_info getAppInfo(Integer id,String APKName)throws Exception;
	
	/**
	 * 删除logo图片
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean deleteAppLogo(Integer id)throws Exception;
	
	/**
	 * 通过appId删除app应用(app_info、app_version)
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean appsysdeleteAppById(Integer id)throws Exception;
	
	
	/**
	 * update Sale Status By AppId and Operator
	 * @param appId
	 * @return
	 * @throws Exception
	 */
	public boolean appsysUpdateSaleStatusByAppId(App_info appInfo) throws Exception;
}