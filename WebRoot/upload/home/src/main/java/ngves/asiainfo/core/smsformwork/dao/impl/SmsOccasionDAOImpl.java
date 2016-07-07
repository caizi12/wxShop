package ngves.asiainfo.core.smsformwork.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.smsformwork.bo.SmsOccasionInfoEngine;
import ngves.asiainfo.core.smsformwork.bo.SmsOccasionTypeInfoEngine;
import ngves.asiainfo.core.smsformwork.dao.interfaces.ISmsOccasionDAO;
import ngves.asiainfo.core.smsformwork.ivalues.ISmsOccasionInfoValue;
import ngves.asiainfo.core.smsformwork.ivalues.ISmsOccasionTypeInfoValue;
import ngves.asiainfo.util.JDBCUtils;
import ngves.asiainfo.util.StringUtil;

/**
 * 短信发送时机管理
 * @author yeqh
 * 2013-12-02
 */


public class SmsOccasionDAOImpl implements ISmsOccasionDAO {
	
	/**
	 * 根据条件查询发送时机信息列表
	 * @param values
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ISmsOccasionInfoValue[] getSmsOccasionList(String condition, Map parameter, int startIndex, int endIndex) throws Exception {
		return SmsOccasionInfoEngine.getBeans(null, condition, parameter, startIndex, endIndex, false);
	}

	/**
	 * 保存修改后的发送时机信息
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public void saveSmsOccasionInfo(ISmsOccasionInfoValue value) throws Exception {
		if(value.isNew()){
			value.setOccasionId(JDBCUtils.getValueNewId());
		}
		SmsOccasionInfoEngine.save(value);
	}
	
	/**
	 * 根据条件查询发送时机信息列表数量
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public int getSmsOccasionInfoCount(String condition,Map parameter) throws Exception {
		return SmsOccasionInfoEngine.getBeansCount(condition,parameter);
	}

	/**
	 * 根据发送时机id获取发送时机信息
	 */
	public ISmsOccasionInfoValue getSmsOccasionInfoById(String occasionId) throws Exception{
		return SmsOccasionInfoEngine.getBean(occasionId);
	}
	
	public ISmsOccasionInfoValue[] getSmsOccasionInfoByTypeId(String occasionTypeId) throws Exception{
		Map<String,String> parameter = new HashMap<String,String>();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		if(!StringUtil.isBlank(occasionTypeId)){
			condition.append(" AND ").append(ISmsOccasionInfoValue.S_OccasionTypeId).append("= :").append(ISmsOccasionInfoValue.S_OccasionTypeId);
			parameter.put(ISmsOccasionInfoValue.S_OccasionTypeId, occasionTypeId);
		}
		return SmsOccasionInfoEngine.getBeans(condition.toString(),parameter);
	}
	
	/**
	 * 查询所有发送时机分类信息
	 */
	public ISmsOccasionTypeInfoValue[] getSmsOccionTypeList() throws Exception{
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		condition.append(" ORDER BY occasion_type_id ");
		return SmsOccasionTypeInfoEngine.getBeans(condition.toString(), null);
	}

	/**
	 * 批量保存HP发送过来的发送时机信息
	 * @param smsOccasionInfo
	 * @throws Exception
	 */
	public void saveBatchSmsOccasionInfo(ISmsOccasionInfoValue[] values) throws Exception {
		for(ISmsOccasionInfoValue value : values){
			if (value.isNew()) {
				if(StringUtil.isBlank((value.getOccasionId()))){
					value.setOccasionId(JDBCUtils.getValueNewId());
				}
			}
		}
		SmsOccasionInfoEngine.saveBatch(values);
	}
	
	/**
	 * 批量保存HP发送过来的发送时机分类信息
	 * @param smsOccasionTypeInfo
	 * @throws Exception
	 */
	public void saveBatchSmsOccasionTypeInfo(ISmsOccasionTypeInfoValue[] values)throws Exception{
		for(ISmsOccasionTypeInfoValue value : values){
			if(value.isNew()){
				if(StringUtil.isBlank(value.getOccasionTypeId())){
					value.setOccasionTypeId(JDBCUtils.getValueNewId());
				}
			}
		}
		SmsOccasionTypeInfoEngine.saveBatch(values);
	}

	
	/**
	 * 通过发送时机类型id查询发送时机类型信息
	 * @param occasionTypeId
	 * @return
	 * @throws Exception
	 */
	public ISmsOccasionTypeInfoValue getSmsOccasionTypeInfo(String occasionTypeId)throws Exception{
		return SmsOccasionTypeInfoEngine.getBean(occasionTypeId);
	}
	
	/**
	 * 通过发送时机类型code查询发送时机类型信息
	 * @param occasionTypeCode 发送时机类型code
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ISmsOccasionTypeInfoValue getSmsOccasionTypeInfoByCode(String occasionTypeCode)throws Exception{
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1=1 \n");
		if(!StringUtil.isBlank(occasionTypeCode)){
			condition.append(" AND ").append(ISmsOccasionTypeInfoValue.S_OccasionTypeCode).append(" = :").append(ISmsOccasionTypeInfoValue.S_OccasionTypeCode);
			parameter.put(ISmsOccasionTypeInfoValue.S_OccasionTypeCode, occasionTypeCode);
		}
		ISmsOccasionTypeInfoValue[] value = SmsOccasionTypeInfoEngine.getBeans(condition.toString(), parameter);
		return value[0];
	}
	
	/**
	 * 判断短信发送时机说明是否能修改
	 * 短信发送时机说明不能重复
	 * @param occasionDesc 短信发送时机说明
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public boolean isCanModifySmsOccasionInfo(String occasionDesc,String occasionTypeId)throws Exception {
		if(StringUtil.isBlank(occasionDesc) || StringUtil.isBlank(occasionTypeId)){
			throw new Exception("modify smsFormworkContent failure");
		}
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1=1 \n");
		if(!StringUtil.isBlank(occasionDesc)){
			condition.append(" AND ").append(ISmsOccasionInfoValue.S_OccasionName).append(" = :").append(ISmsOccasionInfoValue.S_OccasionName);
			condition.append(" AND ").append(ISmsOccasionInfoValue.S_OccasionTypeId).append(" = :").append(ISmsOccasionInfoValue.S_OccasionTypeId);
			parameter.put(ISmsOccasionInfoValue.S_OccasionName, occasionDesc);
			parameter.put(ISmsOccasionInfoValue.S_OccasionTypeId, occasionTypeId);
		}
		ISmsOccasionInfoValue[] SmsOccasionInfos= SmsOccasionInfoEngine.getBeans(condition.toString(), parameter);
		if(SmsOccasionInfos != null && SmsOccasionInfos.length>0){
			return false;
		}
		return true;
	}
}
