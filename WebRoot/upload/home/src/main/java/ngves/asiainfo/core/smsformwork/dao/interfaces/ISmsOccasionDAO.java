package ngves.asiainfo.core.smsformwork.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.smsformwork.ivalues.ISmsOccasionInfoValue;
import ngves.asiainfo.core.smsformwork.ivalues.ISmsOccasionTypeInfoValue;


/**
 * 短信发送时机管理
 * @author yeqh
 * 2013-12-02
 */
public interface ISmsOccasionDAO {
	
	/**
	 * 保存修改后的发送时机信息
	 * @param values
	 * @throws Exception
	 */
	public void saveSmsOccasionInfo(ISmsOccasionInfoValue value) throws Exception;
	
	/**
	 * 根据条件查询发送时机信息列表
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ISmsOccasionInfoValue[] getSmsOccasionList(String condition, Map parameter, int startIndex, int endIndex) throws Exception;
	
	/**
	 * 根据条件查询发送时机信息列表数量
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public int getSmsOccasionInfoCount(String condition,Map parameter) throws Exception;
	
	/**
	 * 根据时机id 获取时机内容
	 * @param occasionId
	 * @return
	 * @throws Exception
	 */
	public ISmsOccasionInfoValue getSmsOccasionInfoById(String occasionId) throws Exception;
	
	/**
	 * 根据时机类型id 获取时机内容列表
	 * @param occasionTypeId
	 * @return
	 * @throws Exception
	 */
	public ISmsOccasionInfoValue[] getSmsOccasionInfoByTypeId(String occasionTypeId) throws Exception;
	
	
	/**
	 * 获取时机类型列表
	 * @return
	 * @throws Exception
	 */
	public ISmsOccasionTypeInfoValue[] getSmsOccionTypeList() throws Exception;
	
	
	/**
	 * 保存HP发送过来的发送时机信息
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
	 * 保存HP发送过来的发送时机分类信息
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
	
	/**
	 * 判断短信发送时机说明是否能修改
	 * 短信发送时机说明不能重复
	 * @param occasionDesc 短信发送时机说明
	 * @param occasionTypeId 短信发送时机类型
	 * @return
	 * @throws Exception
	 */
	public boolean isCanModifySmsOccasionInfo(String occasionDesc,String occasionTypeId)throws Exception;

}
