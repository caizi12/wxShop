package ngves.asiainfo.core.comment.dao.interfaces;

import ngves.asiainfo.core.comment.ivalues.IFilterWordsInfoValue;
import java.util.Map;

public interface IFilterWordsInfoDAO {
	
	public IFilterWordsInfoValue[] queryFilterWordsInfo(String condition, Map<String, String> parameter)throws Exception;
	
	/**
	 * 用于分页的查询
	 * @param condition
	 * @param parameter
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IFilterWordsInfoValue[] queryFilterWordsInfo(
			String condition, Map<String, String> parameter,int startIndex,int endIndex)throws Exception;
	
	/**
	 * 查询过滤词总条数
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public int queryFilterInfoCount(String condition, Map<String, String> parameter)throws Exception;
	
	/**
	 * 根据过滤词ID查询出该对象
	 * @param _FilterWordId
	 * @return
	 * @throws Exception
	 */
	public IFilterWordsInfoValue getFilterWordsInfo(long _FilterWordId)throws Exception;
	
	/**
	 * 批量保存
	 * @param filterWordsInfoValue
	 * @throws Exception
	 */
	public void saveFilterWordsStatus(IFilterWordsInfoValue[] filterWordsInfoValue)throws Exception;
	
	/**
	 * 单个保存
	 * @param filterWordsInfoValue
	 * @throws Exception
	 */
	public void saveFilterWord(IFilterWordsInfoValue filterWordsInfoValue)throws Exception;
	
	/**
	 * 根据过滤词ID删除过滤词
	 * @param filterWordId
	 * @throws Exception
	 */
	public void deleteFilterWords(long filterWordId) throws Exception;
	
	
}
