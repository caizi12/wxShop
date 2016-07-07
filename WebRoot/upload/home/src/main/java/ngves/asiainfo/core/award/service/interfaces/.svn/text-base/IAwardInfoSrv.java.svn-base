package ngves.asiainfo.core.award.service.interfaces;



import java.util.Map;

import ngves.asiainfo.core.award.dao.interfaces.IAwardInfoDAO;
import ngves.asiainfo.core.award.dao.interfaces.IAwardLevelInfoDAO;
import ngves.asiainfo.core.award.ivalues.IAwardDescValue;
import ngves.asiainfo.core.award.ivalues.IAwardInfoValue;
import ngves.asiainfo.core.award.model.ClientAwardInfoViewModel;
import ngves.asiainfo.core.award.model.RoolAwardInfosViewModel;

/**
 * 抽奖活动信息管理
 * 
 * @author xj
 * 
 */
public interface IAwardInfoSrv {

	public void setAwardInfoDAO(IAwardInfoDAO awardInfoDAO) throws Exception;
	
	public void setAwardLevelInfoDAO(IAwardLevelInfoDAO awardLevelInfoDAO)throws Exception;

	/**
	 * @param AwardName
	 * @return 抽奖活动信息列表
	 * @throws Exception
	 */
	public IAwardInfoValue[] queryAwardInfo(String awardName, int startIndex,
			int endIndex) throws Exception;

	/**
	 * 
	 * @param awardName
	 * @return 抽奖活动信息总数
	 */
	public int queryAwardInfoCount(String awardName)throws Exception;

	/**
	 * 保存抽奖信息
	 * 
	 * @param value
	 *            抽奖信息
	 * @param staffId
	 *            操作人员Id
	 * @return
	 * @throws Exception
	 * @author xj
	 * @date 2014-07-3
	 */
	public long saveAwardInfo(IAwardInfoValue value, long staffId, String comType, long orgId) throws Exception;

	/**
	 * 根据抽奖Id 获得抽奖信息
	 * 
	 * @param AwardId
	 * @return
	 * @throws Exception
	 */
	public IAwardInfoValue getAwardInfoById(String awardId) throws Exception;



	/**
	 * 修改抽奖活动信息
	 * 
	 * @param value
	 * @throws Exception
	 */
	public long modifyAwardInfo(IAwardInfoValue value, long staffId, String comType, long orgId) throws Exception;
	
	/**
	 * 修改活动状态
	 * 
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public String modifyAwardinfoStatus(String status, Long AwardId)
			throws Exception;
	/**
	 * 删除活动
	 * @param awardId
	 * @throws Exception
	 */
	public String deleteAwardinfoByID(String awardId)throws Exception;
	/**
	 * 复制新活动
	 * @param awardId
	 * @return
	 * @throws Exception
	 */
	public String copyAwardByID(String awardId)throws Exception;
	
	
	/**
	 * 延期新活动
	 * @param awardId
	 * @return
	 * @throws Exception
	 */
	public String continueAward(String awardId, String endTime, String getStopTime)throws Exception;
	/**
	 * 查询中奖公告滚屏展示信息
	 * @return
	 * @throws Exception
	 */
	public RoolAwardInfosViewModel[] getRollAwardInfo()throws Exception;
	
	/**
	 * 重新从HP查询抽奖中奖滚屏数据放入缓存中
	 * @throws Exception
	 */
	public void rushRollAwardInfos()throws Exception;

	
	/**
	 * 根据导出条件对查询抽奖活动列表记录数
	 * @param awardId
	 * @param mobileNum
	 * @param proCode
	 * @param orderSeq
	 * @param startTime
	 * @param endtime
	 * @return
	 * @throws Exception
	 */
	public int countAwardOrderList(String awardId, String mobileNum, String proCode ,String awardResult, 
			String orderSeq, String startTime, String endtime ) throws Exception;
	
	public IAwardDescValue[] queryAwardOrderList(String awardId, String mobileNum, String proCode ,String awardResult, 
			String orderSeq, String startTime, String endtime ,int startNum, int endNum) throws Exception;
	/**
	 * 积分抽奖中奖名单导出
	 * @throws Exception
	 */
	public void recordAwardDescExportlog(String querystr, long staffId, String comType,long orgId) throws Exception;

    /**
     * 根据活动ID 和 中奖结果 返回中奖信息
     * @param mobileNum 用户手机号
     * @param awardId 抽奖活动ID
	 * @param timePrior 查询时间类型
     * @param lotteryResult 中奖结果 00全部  01未中奖  02已中奖 
     * @param OrgID 发起请求方标识(0001 积分平台;0004 WAP渠道;0006 手机客户端渠道)
     * @return
     */
    public ClientAwardInfoViewModel[] getClineAwardInfo(String mobileNum,String awardId,
    		String timePrior,String lotteryResult,String OrgID)throws Exception;
    
    
    public String stopAward(String awardId, long staffId, String comType,
			long orgId) throws Exception;
    /**
     * 改版后查询用户抽奖情况的的方法
     * @param mobileNum
     * @param awardId
     * @param timePrior
     * @param lotteryResult
     * @param OrgID
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
	public Map[] queryClientAwardInfo(String mobileNum,String awardId, String timePrior,String lotteryResult,String OrgID)throws Exception;
}
