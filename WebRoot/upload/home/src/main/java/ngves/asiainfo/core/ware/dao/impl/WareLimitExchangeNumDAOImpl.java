
package ngves.asiainfo.core.ware.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import com.ai.appframe2.common.ServiceManager;
import ngves.asiainfo.core.ware.bo.PermissionInfoEngine;
import ngves.asiainfo.core.ware.bo.QBOLimitExchangeNumWareEngine;
import ngves.asiainfo.core.ware.bo.WareExchangeRuleRltBean;
import ngves.asiainfo.core.ware.bo.WareExchangeRuleRltEngine;
import ngves.asiainfo.core.ware.bo.WareLimitExchangeNumEngine;
import ngves.asiainfo.core.ware.dao.interfaces.IWareLimitExchangeNumDAO;
import ngves.asiainfo.core.ware.ivalues.IPermissionInfoValue;
import ngves.asiainfo.core.ware.ivalues.IQBOLimitExchangeNumWareValue;
import ngves.asiainfo.core.ware.ivalues.IWareExchangeRuleRltValue;
import ngves.asiainfo.core.ware.ivalues.IWareLimitExchangeNumValue;
import ngves.asiainfo.util.JDBCUtils;
import ngves.asiainfo.util.StringUtil;

/**
 * 礼品兑换数量限制
 * 2014-8-29
 * @author xj
 *
 */
public class WareLimitExchangeNumDAOImpl implements IWareLimitExchangeNumDAO {

	
	public IPermissionInfoValue getPermissionInfoById(long permissionId) throws Exception {
		return PermissionInfoEngine.getBean(permissionId);
	}

	public IWareLimitExchangeNumValue[] getLimitNumRule(String condition,Map<String, Object> parameter, int startNum, int endNum)
			throws Exception {		
		return WareLimitExchangeNumEngine.getBeans(null,condition, parameter, startNum, endNum, false);	
	}

	public int getLimitNumRuleCount(String condition,Map<String, Object> parameter) throws Exception {
		
		return WareLimitExchangeNumEngine.getBeansCount(condition, parameter);
	}

	public IWareLimitExchangeNumValue getLimitNumRuleInfoById(String wareLimitId)
			throws Exception {
		
		return WareLimitExchangeNumEngine.getBean(wareLimitId);
	}

	public String saveLimitNumRuleInfoValue(IWareLimitExchangeNumValue value)
			throws Exception {
		String limitId = "";
		if (value.isNew()) {
			if(StringUtils.isBlank(limitId)){
				limitId = JDBCUtils.getValueNewId();	
				value.setWareLimitId(limitId);
				WareLimitExchangeNumEngine.save(value);
			}				
		}else{
			limitId = value.getWareLimitId();
			WareLimitExchangeNumEngine.save(value);
		}		
		return limitId;
	}

	public IQBOLimitExchangeNumWareValue[] queryBindWareInfo(String condition,
			Map<String, Object> parameter, int startNum, int endNum)
			throws Exception {
		
		return QBOLimitExchangeNumWareEngine.getBeans(null,condition, parameter, startNum, endNum, false);	
	}

	public int queryBindWareInfoCount(String condition,
			Map<String, Object> parameter) throws Exception {
		
		return QBOLimitExchangeNumWareEngine.getBeansCount(condition, parameter);
	}

	public IWareExchangeRuleRltValue[] getLimitNumWareInfoValues(
			String wareLimitId, Long wareId) throws Exception {
		Map<String,Object>  map=new  HashMap<String,Object>();
		StringBuffer sql=new StringBuffer();		
		sql.append(" 1=1 ");
		if(StringUtils.isNotBlank(wareLimitId)){
			sql.append(" AND  ").append(IWareExchangeRuleRltValue.S_WareLimitrlueId).append(" =:").append(IWareExchangeRuleRltValue.S_WareLimitrlueId);
			map.put(IWareExchangeRuleRltValue.S_WareLimitrlueId, wareLimitId);
		}
		if(wareId>0l){
			sql.append(" AND  ").append(IWareExchangeRuleRltValue.S_WareId).append(" =:").append(IWareExchangeRuleRltValue.S_WareId);
			map.put(IWareExchangeRuleRltValue.S_WareId, wareId);
		}
		IWareExchangeRuleRltValue[]  values=WareExchangeRuleRltEngine.getBeans(sql.toString(), map);
		if(null!=values&&values.length>0){
			return values;
		}else{
			return null;
		}
		
	}

	public String saveLimitNumWareInfoValue(IWareExchangeRuleRltValue[] values)throws Exception {
		for(IWareExchangeRuleRltValue value:values){
			if(value.isNew()&&StringUtils.isBlank(value.getWareBindRuleRltId())){
				value.setWareBindRuleRltId(JDBCUtils.getValueNewId());				
			}
		}
		WareExchangeRuleRltEngine.save(values);
		return values[0].getWareLimitrlueId();
	}
	public boolean deleteBindWare(String wareBindRltIds) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE    WARE_EXCHANGE_RULE_RLT  SET IS_BIND=0                        \n");
		sql.append(" WHERE  WARE_BIND_RULE_RLT_ID  in "+wareBindRltIds+" \n");
		
		Connection conn = null;
		PreparedStatement psts = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			psts = conn.prepareStatement(sql.toString());
			// 执行更新操作
			int m=psts.executeUpdate();
			if(m>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (psts != null) {
				psts.close();
			}
			if (conn != null) {
				conn.close();
			}
		}              
		   return false;
	}
	
	
	public boolean isExistSameName(String limitName) throws Exception {
		// 1、利用限制名称 limitName 到数据库中查询数据
		StringBuffer sql = new StringBuffer(" 1=1 ");
		Map<String, String> para = new HashMap<String, String>();
		if (!StringUtil.isBlank(limitName)) {
			limitName = limitName.trim();
			sql.append(" and " + IWareLimitExchangeNumValue.S_LimitName).append(" =:").append(IWareLimitExchangeNumValue.S_LimitName).append(" ");
			para.put(IWareLimitExchangeNumValue.S_LimitName, limitName);
		}
		int num = WareLimitExchangeNumEngine.getBeansCount(sql.toString(), para);
		boolean isExistName = false;
		// 如果结果中元素的数量等于0
		if (0 == num){
			isExistName = true;
		}

		return isExistName;
	}

	public IWareExchangeRuleRltValue[] isEffectRuleAmongWare(IWareExchangeRuleRltValue value)
			throws Exception {
		StringBuffer sql=new StringBuffer("  SELECT * FROM WARE_EXCHANGE_RULE_RLT M  WHERE  M.IS_BIND = 1  AND M.IS_EFFECT = 1 " +
				" AND M.WARE_ID = :WARE_ID");
		Map<String,Object> parameter=new HashMap<String,Object>();
		parameter.put("WARE_ID", value.getWareId());		       
		IWareExchangeRuleRltValue[] wnb = WareExchangeRuleRltEngine.getBeansFromSql(sql.toString(), parameter);	
		return wnb;
	}

	public IWareExchangeRuleRltValue[] getWareExchangeRuleRltValue(
			String relationId,String isBind) throws Exception {
		StringBuffer sql=new StringBuffer("  SELECT * FROM WARE_EXCHANGE_RULE_RLT M  WHERE M.RELATION_ID = :relationId ");
		Map<String,Object> parameter=new HashMap<String,Object>();
		parameter.put("relationId", relationId);
		if(StringUtils.isNotBlank(isBind)){
			sql.append(" AND  M.IS_BIND=").append(IWareExchangeRuleRltValue.S_IsBind);
			parameter.put(IWareExchangeRuleRltValue.S_IsBind, isBind);
		}			       
		WareExchangeRuleRltBean[] wnb = WareExchangeRuleRltEngine.getBeansFromSql(sql.toString(), parameter);
		return wnb;
	}
}
