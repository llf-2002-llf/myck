package cn.sp.app.service.developer;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sp.app.dao.appcategory.AppCategoryDao;
import cn.sp.app.entity.AppCategory;
@Service
public class AppCategoryServiceImpl implements AppCategoryService {

	@Resource
	private AppCategoryDao mapper;
	
	@Override
	public List<AppCategory> getAppCategoryListByParentId(Integer parentId)
			throws Exception {
		return mapper.getAppCategoryListByParentId(parentId);
	}

}
