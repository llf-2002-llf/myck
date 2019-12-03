package cn.sp.app.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.sp.app.entity.DataDictionary;

public interface DataDictionaryDao {
	
	public List<DataDictionary> getDataDictionaryList(@Param("typeCode")String typeCode)throws Exception;
}
