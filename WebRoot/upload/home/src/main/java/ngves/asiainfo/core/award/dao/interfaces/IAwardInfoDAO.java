package ngves.asiainfo.core.award.dao.interfaces;

import ngves.asiainfo.core.award.ivalues.IAwardInfoValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoValue;
/**
 * 抽奖管理
 * @author xj
 *
 */
public interface IAwardInfoDAO {
	/**
	 * @param tuanName
	 * @return 抽奖活动活动信息列表
	 */
	public IAwardInfoValue[] queryAwardInfo(String awardName, int startIndex, int endIndex) throws Exception;

	/**
	 *  
	 * @param AwardName
	 * @return 抽奖活动活动信息总数
	 */
	public int queryAwardInfoCount(String awardName)throws Exception;
	

	/**
	 * @author
	 * @date  保存抽奖活动信息，新增和修改都通过此函数进行
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public long saveAwardInfo(IAwardInfoValue value) throws Exception;
	/**
	 * 
	 * 
	 * @param AwardId
	 * @return 根据id返回抽奖活动信息
	 */
	public IAwardInfoValue queryAwardById(Long AwardId)throws Exception;
	
	/**
	 * 获取发布后并且正在进行的积分抽奖活动
	 * @return
	 * @throws Exception
	 */
	public IAwardInfoValue[] getPublishAwardValues() throws Exception;
	
	
	  /**
	    * 根据活动ID查询默认档礼品信息
	    * @param awardId
	    * @return
	    * @throws Exception
	    */
	public IWareInfoValue findLevelInfoByAwardId(Long awardId) throws Exception;
	
}
