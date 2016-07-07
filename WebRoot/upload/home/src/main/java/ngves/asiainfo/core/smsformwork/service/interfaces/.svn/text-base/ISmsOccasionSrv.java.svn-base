package ngves.asiainfo.core.smsformwork.service.interfaces;

import java.util.List;

import ngves.asiainfo.core.common.model.SysPara;
import ngves.asiainfo.core.smsformwork.dao.interfaces.ISmsOccasionDAO;
import ngves.asiainfo.core.smsformwork.ivalues.ISmsOccasionInfoValue;
import ngves.asiainfo.core.smsformwork.ivalues.ISmsOccasionTypeInfoValue;
import ngves.asiainfo.core.smsformwork.model.ResultBean;

/**
 * 短信发送时机管理
 * @author yeqh
 * 2013-12-02
 */
public interface ISmsOccasionSrv {
	
	public void setSmsOccasionDAO(ISmsOccasionDAO smsOccasionDAO) throws Exception;
	
	/**
	 * 通过发送时机标识保存发送时机信息到数据库中
	 * @param value
	 * @throws Exception
	 */
	public ResultBean saveSmsOccasionInfo(ISmsOccasionInfoValue value) throws Exception;
	
	/**
	 * 根据条件查询发送时机信息列表
	 * @param occasionDesc 发送时机说明
	 * @param orderStatus 订单状态
	 * @param occasionTypeId 发送时机类型
	 * @return
	 * @throws Exception
	 */
	public ISmsOccasionInfoValue[] getSmsOccasionList(String occasionDesc, String orderStatus, String occasionTypeId, int startIndex, int endIndex) throws Exception;
	
	/**
	 * 获取发送时机信息数量
	 * @param occasionDesc 发送时机名称
	 * @param orderStatus 订单状态
	 * @param occasionTypeId 发送时机类型
	 * @return
	 * @throws Exception
	 */
	public int getSmsOccasionListCount(String occasionDesc, String occasionTypeId, String orderStatus) throws Exception;
	
	/**
	 * 根据时机id 获取时机内容
	 * @param occasionId
	 * @return
	 * @throws Exception
	 */
	public ISmsOccasionInfoValue getSmsOccasionInfoById(String occasionId) throws Exception;
	
	/**
	 * 通过时机类型id获取发送时机信息列表Json
	 * @param occasionTypeId
	 * @return
	 * @throws Exception
	 */
	public String getSmsOccasionInfoJsonByTypeId(String occasionTypeId) throws Exception;
	
	/**
	 * 为JSON，获取所有时机类型list
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<SysPara> getSmsOccionTypeJson() throws Exception;

	
	/**
	 * 批量保存HP发送过来的发送时机信息
	 * @param smsOccasionInfo
	 * @throws Exception
	 */
	public void saveBatchSmsOccasionInfo(ISmsOccasionInfoValue[] smsOccasionInfo)throws Exception;
	
	/**
	 * 通过发送时机类型id查询发送时机类型信息
	 * @param occasionTypeId
	 * @return
	 * @throws Exception
	 */
	public ISmsOccasionTypeInfoValue getSmsOccasionTypeInfo(String occasionTypeId)throws Exception;
	
	/**
	 * 批量保存HP发送过来的发送时机分类信息
	 * @param smsOccasionTypeInfo
	 * @throws Exception
	 */
	public void saveBatchSmsOccasionTypeInfo(ISmsOccasionTypeInfoValue[] smsOccasionTypeInfo)throws Exception;
	
	/**
	 * 通过发送时机类型code查询发送时机类型信息
	 * @param occasionTypeId
	 * @return
	 * @throws Exception
	 */
	public ISmsOccasionTypeInfoValue getSmsOccasionTypeInfoByCode(String occasionTypeCode)throws Exception;

}
