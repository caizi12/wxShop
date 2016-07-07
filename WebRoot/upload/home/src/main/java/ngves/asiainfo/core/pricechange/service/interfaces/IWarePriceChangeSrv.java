package ngves.asiainfo.core.pricechange.service.interfaces;

import java.util.List;

import ngves.asiainfo.core.pricechange.dao.interfaces.IWarePriceChangeDAO;
import ngves.asiainfo.core.pricechange.model.WarePriceRecordObject;
public interface IWarePriceChangeSrv {
	public void setWarePriceChangeDAO(IWarePriceChangeDAO warePriceChangeDAO);
	
	public String findBusiId() throws Exception;
	/**
	 * 根据业务标识查询礼品相关信息
	 * @param busiId
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
	 * 根据父礼品业务标识，获取子礼品业务标识
	 * @return
	 * @throws Exception
	 */
	public String[] findCBusiIdIdByPBusiId(String p_busi_id) throws Exception;
	/**
	 * 根据礼品标识查询礼品相关信息
	 * @param moduleName 操作原因
	 * @param wareId 礼品名称
	 * @return
	 * @throws Exception
	 */
	public WarePriceRecordObject findWarePriceRecordObjectByWareId(String operateCause,String wareId) throws Exception;
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
