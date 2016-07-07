package ngves.asiainfo.core.comment.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.comment.dao.interfaces.IFilterWordsInfoDAO;
import ngves.asiainfo.core.comment.ivalues.IFilterWordsInfoValue;
import ngves.asiainfo.core.comment.service.interfaces.IFilterWordsInfoSrv;
import ngves.asiainfo.util.StringUtil;

public class FilterWordsInfoSrvImpl implements IFilterWordsInfoSrv{

	private IFilterWordsInfoDAO filterWordsInfoDao;
	private static Log logger =LogFactory.getLog(FilterWordsInfoSrvImpl.class);
	
	public void setFilterWordsInfoDAO(IFilterWordsInfoDAO filterWordsInfoDAO) {
		this.filterWordsInfoDao =filterWordsInfoDAO;
		
	}
	/**
	 * 用于分页查询过滤词列表
	 */
	public IFilterWordsInfoValue[] queryFilterWordsInfo(
			String filterWord,String filterWordStatus, String startTime, String endTime, int startIndex, int endIndex) throws Exception {			
			logger.info("FilterWordsInfoSrvImpl-->queryFilterWordsInfo is running");

			StringBuffer condition = new StringBuffer();
			Map<String, String> parameter = new HashMap<String, String>();
			condition.append("1=1");
			if (!StringUtil.isBlank(filterWord)) {
				filterWord = filterWord.replace("_", "%\\_%");
				condition.append(" AND ").append(IFilterWordsInfoValue.S_FilterWord).append(" like :").append(
						IFilterWordsInfoValue.S_FilterWord).append(" escape '\\'");
				parameter.put(IFilterWordsInfoValue.S_FilterWord, filterWord);

			}
			if (!StringUtil.isBlank(filterWordStatus)) {
				condition.append(" AND ").append(IFilterWordsInfoValue.S_FilterWordStatus).append("= :").append(
						IFilterWordsInfoValue.S_FilterWordStatus);
				parameter.put(IFilterWordsInfoValue.S_FilterWordStatus, filterWordStatus);

			}
			if (!StringUtil.isBlank(startTime)) {
				condition.append(" AND ").append(IFilterWordsInfoValue.S_UpdateTime).append(
						">=to_date(:startTime ,'yyyy-mm-dd hh24:mi:ss')");
				parameter.put("startTime", startTime + " 00:00:00");
			}
			if (!StringUtil.isBlank(endTime)) {
				condition.append(" AND ").append(IFilterWordsInfoValue.S_UpdateTime).append(
						"<=to_date(:endTime ,'yyyy-mm-dd hh24:mi:ss')");
				parameter.put("endTime", endTime + " 23:59:59");
			}
			condition.append(" ORDER BY ").append(IFilterWordsInfoValue.S_UpdateTime).append(" DESC");
			
			return filterWordsInfoDao.queryFilterWordsInfo(condition.toString(), parameter,startIndex, endIndex);
			
	}


	/**
	 * 查询过滤词的总条数
	 */
	public int queryFilterInfoCount(String filterWord,String filterWordStatus, String startTime,
			String endTime) throws Exception {
		
		StringBuffer condition = new StringBuffer();
		Map<String, String> parameter = new HashMap<String, String>();
		condition.append("1=1");
		if (!StringUtil.isBlank(filterWord)) {
			filterWord = filterWord.replace("_", "%\\_%");
			condition.append(" AND ").append(IFilterWordsInfoValue.S_FilterWord).append(" like :").append(
					IFilterWordsInfoValue.S_FilterWord).append(" escape '\\'");
			parameter.put(IFilterWordsInfoValue.S_FilterWord, filterWord);

		}
		if (!StringUtil.isBlank(filterWordStatus)) {
			condition.append(" AND ").append(IFilterWordsInfoValue.S_FilterWordStatus).append("= :").append(
					IFilterWordsInfoValue.S_FilterWordStatus);
			parameter.put(IFilterWordsInfoValue.S_FilterWordStatus, filterWordStatus);

		}
		if (!StringUtil.isBlank(startTime)) {
			condition.append(" AND ").append(IFilterWordsInfoValue.S_UpdateTime).append(
					">=to_date(:startTime ,'yyyy-mm-dd hh24:mi:ss')");
			parameter.put("startTime", startTime + " 00:00:00");
		}
		if (!StringUtil.isBlank(endTime)) {
			condition.append(" AND ").append(IFilterWordsInfoValue.S_UpdateTime).append(
					"<=to_date(:endTime ,'yyyy-mm-dd hh24:mi:ss')");
			parameter.put("endTime", endTime + " 23:59:59");
		}
		condition.append(" ORDER BY ").append(IFilterWordsInfoValue.S_UpdateTime).append(" DESC");

		return filterWordsInfoDao.queryFilterInfoCount(condition.toString(), parameter);

	}



	/**
	 * 根据过滤词ID获取该对象
	 */
	public IFilterWordsInfoValue getFilterWordsInfo(long _FilterWordId)
			throws Exception {
	
		return filterWordsInfoDao.getFilterWordsInfo(_FilterWordId);
	}
	/**
	 * 批量保存
	 */
	public void saveFilterWordsStatus(
			IFilterWordsInfoValue[] filterWordsInfoValue) throws Exception {
		filterWordsInfoDao.saveFilterWordsStatus(filterWordsInfoValue);
		
	}
	
	/**
	 * 单个保存
	 */
	public void saveFilterWord(IFilterWordsInfoValue filterWordsInfoValue)
			throws Exception {
		filterWordsInfoDao.saveFilterWord(filterWordsInfoValue);
		
	}
	/**
	 * 根据ID删除对象
	 */
	public void deleteFilterWords(long filterWordId) throws Exception {
		filterWordsInfoDao.deleteFilterWords(filterWordId);
		
	}
	
	/**
	 * 根据过滤词查询对象
	 */
	public IFilterWordsInfoValue[] queryFilterWordByName(String filterWord) throws Exception {
		logger.info("FilterWordsInfoSrvImpl-->queryFilterWordsInfo is running");
		StringBuffer condition = new StringBuffer();
		Map<String, String> parameter = new HashMap<String, String>();
		condition.append("1=1");
		if (filterWord != null && !filterWord.equals("")) {

			condition.append(" AND ").append(IFilterWordsInfoValue.S_FilterWord).append("= :").append(
					IFilterWordsInfoValue.S_FilterWord);
			parameter.put(IFilterWordsInfoValue.S_FilterWord, filterWord);

		}
		
		return filterWordsInfoDao.queryFilterWordsInfo(condition.toString(), parameter);
	}
	
	/**
	 * 查询生效的过滤词
	 */
	public IFilterWordsInfoValue[] getFilterWordsInfo() throws Exception {
		logger.info("FilterWordsInfoSrvImpl-->queryFilterWordsInfo is running");
		
		StringBuffer condition = new StringBuffer();
		Map<String, String> parameter = new HashMap<String, String>();
		condition.append("1=1");
		condition.append(" AND ").append(IFilterWordsInfoValue.S_FilterWordStatus).append("=1");
		
		return filterWordsInfoDao.queryFilterWordsInfo(condition.toString(), parameter);
			

	}
	
	
	
}
