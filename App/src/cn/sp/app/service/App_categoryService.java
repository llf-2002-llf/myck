package cn.sp.app.service;

import java.util.List;
import cn.sp.app.entity.App_category;

public interface App_categoryService {
	/**
	 * 根据父节点parentId获取相应的分类列表
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<App_category> getAppCategoryListByParentId(Integer parentId)throws Exception;
}
