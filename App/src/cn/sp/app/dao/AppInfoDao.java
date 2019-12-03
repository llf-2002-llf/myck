package cn.sp.app.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.sp.app.entity.AppInfo;

public interface AppInfoDao {
	
	public int add(AppInfo appInfo) throws Exception;
	
	public int modify(AppInfo appInfo)throws Exception;
	
	public int deleteAppInfoById(@Param(value="id")Integer delId)throws Exception;
	
	public List<AppInfo> getAppInfoList(@Param(value="softwareName")String querySoftwareName,
										@Param(value="status")Integer queryStatus,
										@Param(value="categoryLevel1")Integer queryCategoryLevel1,
										@Param(value="categoryLevel2")Integer queryCategoryLevel2,
										@Param(value="categoryLevel3")Integer queryCategoryLevel3,
										@Param(value="flatformId")Integer queryFlatformId,
										@Param(value="devId")Integer devId,
										@Param(value="from")Integer currentPageNo,
										@Param(value="pageSize")Integer pageSize)throws Exception;
	
	public int getAppInfoCount(@Param(value="softwareName")String querySoftwareName,
							   @Param(value="status")Integer queryStatus,
							   @Param(value="categoryLevel1")Integer queryCategoryLevel1,
							   @Param(value="categoryLevel2")Integer queryCategoryLevel2,
							   @Param(value="categoryLevel3")Integer queryCategoryLevel3,
							   @Param(value="flatformId")Integer queryFlatformId,
							   @Param(value="devId")Integer devId)throws Exception;
	
	public AppInfo getAppInfo(@Param(value="id")Integer id,@Param(value="APKName")String APKName)throws Exception;

	public int deleteAppLogo(@Param(value="id")Integer id)throws Exception;
	
	public int updateVersionId(@Param(value="versionId")Integer versionId,@Param(value="id")Integer appId)throws Exception;
	
	public int updateSaleStatusByAppId(@Param(value="id")Integer appId) throws Exception;

	public int updateSatus(@Param(value="status")Integer status,@Param(value="id")Integer id)throws Exception;

}
