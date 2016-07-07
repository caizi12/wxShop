package ngves.asiainfo.core.pricechange.dao.interfaces;

import java.util.List;

import ngves.asiainfo.core.pricechange.model.WarePriceRecordObject;

public interface IWarePriceChangeDAO {
	
	
	public String findBusiId() throws Exception;
	
	/**
	 * ==========================
	 * 礼品审核相关方法
	 * ==========================
	 */
	/**
	 * 根据业务标识查询礼品相关信息
	 * @return
	 * @throws Exception
	 */
	public WarePriceRecordObject findWarePriceRecordObjectByBusiId(String busiId) throws Exception;
	/**
	 * 根据当前业务标识获取上一条业务标识
	 * @param busiId
	 * @return
	 * @throws Exception
	 */
	public String findLastBusiId(String busiId) throws Exception;
	/**
	 * 是否为新增礼品，用于表示操作原因
	 * 当礼品标识在业务流水表中查出多条标识为礼品修改，仅一条就为礼品新增
	 * @param busiId
	 * @return
	 * @throws Exception
	 */
	public boolean isAdd(String busiId) throws Exception;
	
	/**
	 * 根据父礼品业务标识，获取子礼品业务标识
	 * @return
	 * @throws Exception
	 */
	public List<String> findCBusiIdIdByPBusiId(String p_busi_id)throws Exception;
	/**
	 * ==========================
	 * 礼品业务属性配置相关方法
	 * ==========================
	 */
	/**
	 * 根据礼品标识查询礼品相关信息
	 */
	public WarePriceRecordObject findWarePriceRecordObjectByWareId(String wareId) throws Exception;
	
	
	
	/**
	 * ==========================
	 * 礼品价格批量更新相关方法
	 * ==========================
	 */
	/**
	 * 根据礼品编码查询礼品标识
	 */
	public String findWareIdByWareCode(String wareCode) throws Exception;
	
	/**
	 * ==========================
	 * 定时读取文件数据入库
	 * ==========================
	 */
	
	public boolean saveInfoFromFiles(List<WarePriceRecordObject> datas) throws Exception;
}
