package cn.sp.app.service.developer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sp.app.dao.DataDictionaryDao;
import cn.sp.app.entity.DataDictionary;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
	
	@Resource
	private DataDictionaryDao mapper;
	
	@Override
	public List<DataDictionary> getDataDictionaryList(String typeCode)
			throws Exception {
		return mapper.getDataDictionaryList(typeCode);
	}

}
