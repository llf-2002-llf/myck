package cn.sp.app.service.developer;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sp.app.dao.appcategory.AppCategoryMapper;
import cn.sp.app.entity.AppCategory;
@Service
public class AppCategoryServiceImpl implements AppCategoryService {

	@Resource
	private AppCategoryMapper mapper;
	
	@Override
	public List<AppCategory> getAppCategoryListByParentId(Integer parentId)
			throws Exception {
		// TODO Auto-generated method stub
		return mapper.getAppCategoryListByParentId(parentId);
	}

}
