package ngves.asiainfo.core.comment.dao.impl;

import ngves.asiainfo.core.comment.ivalues.IFilterWordsInfoValue;import java.util.Map;
import ngves.asiainfo.core.comment.bo.FilterWordsInfoEngine;
import ngves.asiainfo.core.comment.dao.interfaces.IFilterWordsInfoDAO;

public class FilterWordsInfoDAOImpl implements IFilterWordsInfoDAO{
	
	public IFilterWordsInfoValue[] queryFilterWordsInfo(String condition, Map<String, String> parameter) throws Exception {
		return FilterWordsInfoEngine.getBeans(condition, parameter);
	}
	
	//用于分页的查询
	public IFilterWordsInfoValue[] queryFilterWordsInfo (
			String condition, Map<String, String> parameter,int startIndex,int endIndex) throws Exception {
		
			return FilterWordsInfoEngine.getBeans(null, condition, parameter, startIndex, endIndex, false);
	}

	//查询过滤词总条数
	public int queryFilterInfoCount(String condition,
			Map<String, String> parameter) throws Exception {

			return FilterWordsInfoEngine.getBeansCount(condition, parameter);
	}

	//根据过滤词ID获得过滤词对象
	public IFilterWordsInfoValue getFilterWordsInfo(long _FilterWordId)
			throws Exception {
	
		return FilterWordsInfoEngine.getBean(_FilterWordId);
	}
	
	//批量保存
	public void saveFilterWordsStatus(IFilterWordsInfoValue[] filterWordsInfoValue)
			throws Exception {
		FilterWordsInfoEngine.save(filterWordsInfoValue);
		
	}

	//单个保存
	public void saveFilterWord(IFilterWordsInfoValue filterWordsInfoValue)
			throws Exception {
		long filterWordsId = FilterWordsInfoEngine.getNewId().longValue();
		filterWordsInfoValue.setFilterWordId(filterWordsId);
		FilterWordsInfoEngine.save(filterWordsInfoValue);
		
	}

	//根据ID删除
	public void deleteFilterWords(long filterWordId) throws Exception {
		
		IFilterWordsInfoValue value = getFilterWordsInfo(filterWordId);
		if(!value.isNew()){
			value.delete();
			FilterWordsInfoEngine.save(value);
		}
		
	}


}
