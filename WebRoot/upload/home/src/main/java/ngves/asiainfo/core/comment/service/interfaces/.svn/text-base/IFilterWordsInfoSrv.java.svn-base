package ngves.asiainfo.core.comment.service.interfaces;

import ngves.asiainfo.core.comment.dao.interfaces.IFilterWordsInfoDAO;
import ngves.asiainfo.core.comment.ivalues.IFilterWordsInfoValue;

public interface IFilterWordsInfoSrv {
	public void setFilterWordsInfoDAO(IFilterWordsInfoDAO filterWordsInfoDAO);
	
	/**
	 * 过滤词信息列表
	 * @param filterWordStatus  过滤词状态
	 * @param startTime 
	 * @param endTime
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IFilterWordsInfoValue[] queryFilterWordsInfo(
			String filterWord,String filterWordStatus,String startTime, String endTime, int startIndex, int endIndex) throws Exception;
	
	/**
	 * 过滤词信息总条数
	 * @param filterWordStatus
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	public int queryFilterInfoCount(String filterWord,String filterWordStatus,String startTime, String endTime)throws Exception;
	
	/**
	 * 根据过滤词ID获取该对象
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
	
	/**
	 * 根据过虑词名查询对象
	 * @param filterWord
	 * @return
	 * @throws Exception
	 */
	public IFilterWordsInfoValue[]  queryFilterWordByName(String filterWord) throws Exception;
	
	/**
	 * 查询生效的过滤词
	 * @return
	 * @throws Exception
	 */
	public IFilterWordsInfoValue[] getFilterWordsInfo()throws Exception;


}
