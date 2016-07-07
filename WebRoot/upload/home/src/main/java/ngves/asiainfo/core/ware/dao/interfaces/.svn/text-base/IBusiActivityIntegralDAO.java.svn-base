package ngves.asiainfo.core.ware.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.ware.ivalues.IBusiActivityIntegralValue;

/**
 * Busi_Activity_Integral活动积分流水表接口类
 * @author 宋鲁振
 * 
 */
public interface IBusiActivityIntegralDAO {

	public IBusiActivityIntegralValue getBusiActivityIntegralValueById(long id) throws Exception;
	/**
	 * 根据活动礼品ID,活动类型, 活动id,星级,渠道获取礼品积分信息, 三个字段可为空
	 * 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public IBusiActivityIntegralValue[] getBusiActivityIntegralValue(long wareId, long activityType, long activityID, String starLevel, String channel) throws Exception;

	/**
	 * 根据条件，获取活动礼品积分信息分页
	 * 
	 * @param condition
	 * @param parameter
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IBusiActivityIntegralValue[] getBusiActivityIntegralValue(String condition, Map<String, String> parameter, int startIndex, int endIndex) throws Exception;

	/**
	 * 保存活动礼品积分数据，并返回ID
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public long saveBusiActivityIntegral(IBusiActivityIntegralValue value) throws Exception;

	/**
	 * 保存活动礼品统一积分数据到相应星级和相应渠道
	 * 
	 * 该方法默认会支持所有渠道 星级体系第一阶段渠道支持 后期界面支持为星级渠道分别设置积分后弃用
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public void saveBusiActivityIntegralForAllChannel(long wareId, String activityType, long activityID, String[] starLevels, String[] channels, Long oriIntegral, Long oriPayIntegral, Long oriPayCash, 
			Long curIntegral, Long curPayIntegral, Long curPayCash) throws Exception;
	
	/**
	 * 保存活动礼品积分数据数组
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public void saveBusiActivityIntegral(IBusiActivityIntegralValue[] values) throws Exception;

	/**
	 * 获得活动礼品积分数据总条数
	 * 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public int getBusiActivityIntegralCount(String condition, Map<String, String> parameter) throws Exception;
	
	public IBusiActivityIntegralValue[] getBusiActivityIntegralValue(String condition, Map<String, String> parameter) throws Exception;

}