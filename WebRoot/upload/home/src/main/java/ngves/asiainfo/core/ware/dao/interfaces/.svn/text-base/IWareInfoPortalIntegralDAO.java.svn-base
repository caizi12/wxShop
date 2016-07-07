package ngves.asiainfo.core.ware.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.ware.ivalues.IWareInfoPortalIntegralValue;

/**
 * Ware_Info_Portal_Integral表DAO接口
 * @author 宋鲁振
 * 
 */
public interface IWareInfoPortalIntegralDAO {

	public IWareInfoPortalIntegralValue getWareInfoPortalIntegralValueById(long id) throws Exception;
	/**
	 * 根据礼品ID,星级,渠道获取礼品积分信息, 三个字段可为空
	 * 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public IWareInfoPortalIntegralValue[] getWareInfoPortalIntegralValue(String wareId, String starLevel, String channel) throws Exception;

	/**
	 * 根据条件，获取礼品积分信息分页
	 * 
	 * @param condition
	 * @param parameter
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IWareInfoPortalIntegralValue[] getWareInfoPortalIntegralValue(String condition, Map<String, String> parameter, int startIndex, int endIndex) throws Exception;

	/**
	 * 保存礼品积分数据，并返回ID
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public long saveWareInfoPortalIntegral(IWareInfoPortalIntegralValue value) throws Exception;

	/**
	 * 保存礼品统一积分数据到相应星级和相应渠道
	 * 
	 * 该方法默认会支持所有渠道 星级体系第一阶段渠道支持 后期界面支持为星级渠道分别设置积分后弃用
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public void saveWareInfoPortalIntegralForAllChannel(long wareId, String[] starLevels, String[] channels, Long oriIntegral, Long oriPayIntegral, Long oriPayCash, 
			Long curIntegral, Long curPayIntegral, Long curPayCash) throws Exception;
	
	/**
	 * 保存礼品积分数据数组
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public void saveWareInfoPortalIntegral(IWareInfoPortalIntegralValue[] values) throws Exception;
	
	public IWareInfoPortalIntegralValue[] getWareInfoPortalIntegralValue(String condition, Map<String, String> parameter) throws Exception;
	/**
	 * 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public IWareInfoPortalIntegralValue getMinIntegralValue( Map<String, String> parameter) throws Exception;

}
