package cn.sp.app.dao.appcategory;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.sp.app.entity.AppCategory;

public interface AppCategoryMapper {
	
	public List<AppCategory> getAppCategoryListByParentId(@Param("parentId")Integer parentId)throws Exception;
}
