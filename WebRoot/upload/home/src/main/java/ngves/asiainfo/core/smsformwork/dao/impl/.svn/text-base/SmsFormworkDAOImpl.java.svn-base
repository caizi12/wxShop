package ngves.asiainfo.core.smsformwork.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.smsformwork.SmsFormworkConstant;
import ngves.asiainfo.core.smsformwork.bo.BusiSmsFormworkEngine;
import ngves.asiainfo.core.smsformwork.bo.BusiSmsFormworkOccasionRltEngine;
import ngves.asiainfo.core.smsformwork.bo.BusiSmsFormworkWareInfoRltEngine;
import ngves.asiainfo.core.smsformwork.bo.SmsFormworkContentEngine;
import ngves.asiainfo.core.smsformwork.bo.SmsFormworkEngine;
import ngves.asiainfo.core.smsformwork.bo.SmsFormworkOccasionRltEngine;
import ngves.asiainfo.core.smsformwork.bo.SmsFormworkWareInfoRltEngine;
import ngves.asiainfo.core.smsformwork.dao.interfaces.ISmsFormworkDAO;
import ngves.asiainfo.core.smsformwork.ivalues.IBusiSmsFormworkOccasionRltValue;
import ngves.asiainfo.core.smsformwork.ivalues.IBusiSmsFormworkValue;
import ngves.asiainfo.core.smsformwork.ivalues.IBusiSmsFormworkWareInfoRltValue;
import ngves.asiainfo.core.smsformwork.ivalues.ISmsFormworkContentValue;
import ngves.asiainfo.core.smsformwork.ivalues.ISmsFormworkOccasionRltValue;
import ngves.asiainfo.core.smsformwork.ivalues.ISmsFormworkValue;
import ngves.asiainfo.core.smsformwork.ivalues.ISmsFormworkWareInfoRltValue;
import ngves.asiainfo.core.ware.bo.WareInfoEngine;
import ngves.asiainfo.core.ware.ivalues.IWareInfoValue;
import ngves.asiainfo.util.JDBCUtils;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.lang.StringUtils;

/**   
 * @author Fsr   
 * @version 1.0
 * 创建时间：2013-12-3 下午01:29:19  
 * 类说明 
 */
public class SmsFormworkDAOImpl implements ISmsFormworkDAO {

	public ISmsFormworkValue[] qrySmsFormworkList(String condition, Map<String,String> parameter, int startNum, int endNum)
			throws Exception {
		return SmsFormworkEngine.getBeans(null, condition, parameter,startNum, endNum, false);
	}

	public int qrySmsFormworkListCount(String condition, Map<String,String> parameter) throws Exception {
		return SmsFormworkEngine.getBeansCount(condition, parameter);
	}
	
	public ISmsFormworkWareInfoRltValue[] qryFormworkWareinfoRltList(String formworkId) throws Exception{
		StringBuffer sqlBuf = new StringBuffer();
		Map<String,String> parameter = new HashMap<String,String>();
		sqlBuf.append(" 1 = 1 ");
		if(!StringUtils.isBlank(formworkId)){
			sqlBuf.append(" AND ").append(ISmsFormworkWareInfoRltValue.S_FormworkId).append(" = :").append(ISmsFormworkWareInfoRltValue.S_FormworkId);
			parameter.put(ISmsFormworkWareInfoRltValue.S_FormworkId, formworkId);
		}
		return SmsFormworkWareInfoRltEngine.getBeans(sqlBuf.toString(), parameter);
	}
	
	public ISmsFormworkValue qryFormworkById(String formworkId) throws Exception{
		return SmsFormworkEngine.getBean(formworkId);
	}
	
	public ISmsFormworkValue[] qrySmsFormworkInfo(String formworkId) throws Exception{
		StringBuffer sqlBuf = new StringBuffer();
		Map<String,String> parameter = new HashMap<String,String>();
		sqlBuf.append(" 1 = 1 ");
		if(!StringUtils.isBlank(formworkId)){
			sqlBuf.append(" AND ").append(ISmsFormworkValue.S_FormworkId).append(" = :").append(ISmsFormworkValue.S_FormworkId);
			parameter.put(ISmsFormworkValue.S_FormworkId, formworkId);
		}
		sqlBuf.append(" AND ").append( ISmsFormworkValue.S_IsStopped).append(" = ").append(SmsFormworkConstant.SMS_FORMWORK_STATUS_USE);
		return SmsFormworkEngine.getBeans(sqlBuf.toString(), parameter);
	}
	
	public void saveSmsFormworkInfo(ISmsFormworkValue value) throws Exception{
		if (value.isNew()) {
			if(StringUtil.isBlank((value.getFormworkId()))){
				value.setFormworkId(JDBCUtils.getValueNewId());
			}
		}
		SmsFormworkEngine.save(value);
	}
	
	public void savaBusiSmsFormworkInfo(IBusiSmsFormworkValue[] values) throws Exception{
		BusiSmsFormworkEngine.saveBatch(values);
	}
	
	public void saveFormworkWareRlt(ISmsFormworkWareInfoRltValue[] values) throws Exception{
		for(ISmsFormworkWareInfoRltValue value : values){
			if (value.isNew()) {
				if(StringUtil.isBlank((value.getRltId()))){
					value.setRltId(JDBCUtils.getValueNewId());
				}
			}
		}
		SmsFormworkWareInfoRltEngine.saveBatch(values);
	}
	
	public void saveFormOccRlt(ISmsFormworkOccasionRltValue[] rltValues) throws Exception{
		for(ISmsFormworkOccasionRltValue value : rltValues){
			if (value.isNew()) {
				if(StringUtil.isBlank((value.getRltId()))){
					value.setRltId(JDBCUtils.getValueNewId());
				}
			}
		}
		SmsFormworkOccasionRltEngine.saveBatch(rltValues);
	}
	
	public void savaBusiFormOccRlt(IBusiSmsFormworkOccasionRltValue[] busiRltValues) throws Exception{
		BusiSmsFormworkOccasionRltEngine.saveBatch(busiRltValues);
	}
	
	public ISmsFormworkOccasionRltValue[] qryFormworkOccasionRltInfo(String formworkId,String occasionTypeId) throws Exception{
		StringBuffer sqlBuf = new StringBuffer();
		Map<String,String> parameter = new HashMap<String,String>();
		sqlBuf.append(" 1 = 1 ");
		if(!StringUtils.isBlank(formworkId)){
			sqlBuf.append(" AND ").append(ISmsFormworkOccasionRltValue.S_FormworkId).append(" = :").append(ISmsFormworkOccasionRltValue.S_FormworkId);
			parameter.put(ISmsFormworkOccasionRltValue.S_FormworkId, formworkId);
		}
		if(!StringUtils.isBlank(occasionTypeId)){
			sqlBuf.append(" AND ").append(ISmsFormworkOccasionRltValue.S_OccasionTypeId).append(" = :").append(ISmsFormworkOccasionRltValue.S_OccasionTypeId);
			parameter.put(ISmsFormworkOccasionRltValue.S_OccasionTypeId, occasionTypeId);
		}
		return SmsFormworkOccasionRltEngine.getBeans(sqlBuf.toString(), parameter);
	}
	
	public ISmsFormworkOccasionRltValue qryFormworkOccasionRltInfo(String rltId) throws Exception{
		return SmsFormworkOccasionRltEngine.getBean(rltId);
	}
	
	public ISmsFormworkWareInfoRltValue[] qryFormworkWareRlt(String wareCode,String actionId,String actionType) throws Exception{
		StringBuffer sqlBuf = new StringBuffer();
		Map<String,String> parameter = new HashMap<String,String>();
		sqlBuf.append(" 1 = 1 ");
		if(!StringUtils.isBlank(wareCode)){
			sqlBuf.append(" AND ").append(ISmsFormworkWareInfoRltValue.S_WareCode).append(" = :").append(ISmsFormworkWareInfoRltValue.S_WareCode);
			parameter.put(ISmsFormworkWareInfoRltValue.S_WareCode, wareCode);
		}
		if(!StringUtils.isBlank(actionId)){
			sqlBuf.append(" AND ").append(ISmsFormworkWareInfoRltValue.S_ActionId).append(" = :").append(ISmsFormworkWareInfoRltValue.S_ActionId);
			parameter.put(ISmsFormworkWareInfoRltValue.S_ActionId, actionId);
		}
		if(!StringUtils.isBlank(actionType)){
			sqlBuf.append(" AND ").append(ISmsFormworkWareInfoRltValue.S_ActionType).append(" = :").append(ISmsFormworkWareInfoRltValue.S_ActionType);
			parameter.put(ISmsFormworkWareInfoRltValue.S_ActionType, actionType);
		}
		return SmsFormworkWareInfoRltEngine.getBeans(sqlBuf.toString(), parameter);
	}
	
	public void saveBusiFormworkWareRlt(IBusiSmsFormworkWareInfoRltValue[] busiRltValues) throws Exception{
		BusiSmsFormworkWareInfoRltEngine.saveBatch(busiRltValues);
	}
	
	public IWareInfoValue[] qryCWareInfosById(String wareCode) throws Exception{
		StringBuffer sqlBuf = new StringBuffer();
		Map<String,String> parameter = new HashMap<String,String>();
		sqlBuf.append(" SELECT WARE_CODE FROM WARE_INFO WHERE WARE_ID IN ");
		sqlBuf.append(" (SELECT C_WARE_ID  FROM WARE_PC_RLT WHERE P_WARE_ID IN  ");
		sqlBuf.append(" (SELECT WPR.P_WARE_ID FROM WARE_INFO WI, WARE_PC_RLT WPR  ");
		sqlBuf.append(" WHERE WPR.C_WARE_ID = WI.WARE_ID ");
		if(!StringUtils.isBlank(wareCode)){
			sqlBuf.append(" AND WI.").append(IWareInfoValue.S_WareCode).append(" = :").append(IWareInfoValue.S_WareCode);
			parameter.put(IWareInfoValue.S_WareCode, wareCode);
		}
		sqlBuf.append(" )) ");
		return WareInfoEngine.getBeansFromSql(sqlBuf.toString(), parameter);
	}
	
	public ISmsFormworkContentValue[] qryTempContent(String contentId) throws Exception{
		Map<String,String> parameter = new HashMap<String,String>();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		if(!StringUtil.isBlank(contentId)){
			condition.append(" AND ").append(ISmsFormworkContentValue.S_ContentId).append(" = :").append(ISmsFormworkContentValue.S_ContentId);
			parameter.put(ISmsFormworkContentValue.S_ContentId, contentId);
		}
		//查询出来的模板内容不包含被“删除”的记录 03表示删除
		condition.append(" AND IS_STOPPED <> '03'");
		return SmsFormworkContentEngine.getBeans(condition.toString(), parameter);
	}

}
