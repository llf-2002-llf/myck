package cn.sp.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sp.app.dao.Data_dictionaryDao;
import cn.sp.app.entity.Data_dictionary;
import cn.sp.app.service.Data_dictionaryService;

@Service
public class Data_dictionaryServiceImpl implements Data_dictionaryService {

	@Resource
	private Data_dictionaryDao dd;
	
	@Override
	public List<Data_dictionary> getAll() {
		return dd.getAll();
	}
}
