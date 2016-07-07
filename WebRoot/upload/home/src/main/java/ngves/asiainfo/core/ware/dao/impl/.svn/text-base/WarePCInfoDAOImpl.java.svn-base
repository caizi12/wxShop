package ngves.asiainfo.core.ware.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.ware.bo.BusiWareInfoParentEngine;
import ngves.asiainfo.core.ware.bo.QBOAllWareInfoChildEngine;
import ngves.asiainfo.core.ware.bo.QBOWareChildInfoEngine;
import ngves.asiainfo.core.ware.bo.QBOWareParentInfoEngine;
import ngves.asiainfo.core.ware.bo.WareInfoEngine;
import ngves.asiainfo.core.ware.bo.WareInfoParentEngine;
import ngves.asiainfo.core.ware.bo.WarePCRltEngine;
import ngves.asiainfo.core.ware.dao.interfaces.IWarePCInfoDAO;
import ngves.asiainfo.core.ware.ivalues.IBusiWareInfoParentValue;
import ngves.asiainfo.core.ware.ivalues.IQBOAllWareInfoChildValue;
import ngves.asiainfo.core.ware.ivalues.IQBOWareChildInfoValue;
import ngves.asiainfo.core.ware.ivalues.IQBOWareParentInfoValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoParentValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoValue;
import ngves.asiainfo.core.ware.ivalues.IWarePCRltValue;

public class WarePCInfoDAOImpl implements IWarePCInfoDAO {

	public IWareInfoParentValue getWareInfoParentById(long id) throws Exception {
		IWareInfoParentValue value = WareInfoParentEngine.getBean(id);
		return value;
	}

	public IWareInfoParentValue[] getWareInfoParentValue(String condition, Map<String, String> parameter)
			throws Exception {
		IWareInfoParentValue[] value = WareInfoParentEngine.getBeans(condition, parameter);
		return value;
	}

	public IWareInfoParentValue[] getWareInfoParentValue(String condition, Map<String, String> parameter,
			int startIndex, int endIndex) throws Exception {
		IWareInfoParentValue[] values = WareInfoParentEngine.getBeans(null, condition, parameter, startIndex, endIndex,
				false);
		return values;
	}

	public IWarePCRltValue[] getWarePCRltValue(String condition, Map<String, String> parameter) throws Exception {
		IWarePCRltValue[] values = WarePCRltEngine.getBeans(condition, parameter);
		return values;
	}
	
	public IWarePCRltValue[] getWarePCRltValue(String condition, Map<String, String> parameter,
			int startIndex, int endIndex) throws Exception {
		IWarePCRltValue[] values = WarePCRltEngine.getBeans(null, condition, parameter, startIndex, endIndex,
				false);
		return values;
	}

	public IWarePCRltValue getWarePCRltValueById(long id) throws Exception {
		IWarePCRltValue value = WarePCRltEngine.getBean(id);
		return value;
	}
	
	
	public IQBOWareChildInfoValue[] getWareChildInfoValue(String condition,Map<String,String> parameter,int startIndex,int endIndex) throws Exception {
		return QBOWareChildInfoEngine.getBeans(null, condition, parameter, startIndex, endIndex, false);
	}
	
	public int getWareChildInfoValueCount(String condition,Map<String,String> parameter) throws Exception {
		return QBOWareChildInfoEngine.getBeansCount(condition.toString(), parameter);
	}

	public long saveWareInfoParentValue(IWareInfoParentValue value) throws Exception {
		WareInfoParentEngine.save(value);
		return value.getWareId();
	}

	public void saveWareInfoParentValue(IWareInfoParentValue[] value) throws Exception {
		WareInfoParentEngine.save(value);
	}

	public long saveWarePCInfo(IWarePCRltValue value) throws Exception {
		WarePCRltEngine.save(value);
		return value.getWarePcRltId();
	}

	@SuppressWarnings("unchecked")
	public void saveWarePCInfo(IWarePCRltValue[] values) throws Exception {
		String cond = null;
		HashMap map = null;
		for(int i=0; i<values.length; i++){
			//如果是表中已存在这条关系数据，更新
			cond = " p_ware_id= :p_ware_id and c_ware_id = :c_ware_id";
			map = new HashMap();
			map.put("p_ware_id", values[i].getPWareId());
			map.put("c_ware_id", values[i].getCWareId());
			IWarePCRltValue[] oldValues = WarePCRltEngine.getBeans(cond, map);
			if (oldValues != null && oldValues.length > 0) {
				values[i] = oldValues[0];
			}else{
				values[i].setWarePcRltId(WarePCRltEngine.getNewId().longValue());
			}			
		}
		WarePCRltEngine.save(values);
	}

	public IQBOWareParentInfoValue[] getQBOWarePCInfoValue(String condition, Map<String, String> parameter,
			int startNum, int endNum) throws Exception {
		IQBOWareParentInfoValue[] values = QBOWareParentInfoEngine.getBeans(null, condition, parameter, startNum,
				endNum, false);
		return values;
	}

	public int getWareInfoParentValueCount(String condition, Map<String, String> parameter) throws Exception {
		int itemsNum = QBOWareParentInfoEngine.getBeansCount(condition, parameter);
		return itemsNum;
	}

	public IBusiWareInfoParentValue[] getBusiWareInfoParentValue(String condition, Map<String, String> parameter)
			throws Exception {
		IBusiWareInfoParentValue[] values = BusiWareInfoParentEngine.getBeans(condition, parameter);
		return values;
	}

	public IBusiWareInfoParentValue getBusiWareInfoParentValueById(long id) throws Exception {
		IBusiWareInfoParentValue value = BusiWareInfoParentEngine.getBean(id);
		return value;
	}

	public long saveBusiWareInfoParentValue(IBusiWareInfoParentValue value) throws Exception {
		BusiWareInfoParentEngine.save(value);
		return value.getBusiId();
	}

	public void saveBusiWareInfoParentValue(IBusiWareInfoParentValue[] value) throws Exception {
		BusiWareInfoParentEngine.save(value);
	}

	public IWareInfoValue[] getWareInfoValue(String condition, Map<String, String> parameter) throws Exception {
		IWareInfoValue[] value = WareInfoEngine.getBeans(condition,parameter);
		return value;
	}
	
	public IWareInfoValue[] getChildWareInfo(long wareParentId) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("select wi.*");  
		sql.append(" from ware_info wi, ware_pc_rlt wpr ");
		sql.append(" where wpr.p_ware_id = ");
		sql.append(String.valueOf(wareParentId));
		sql.append(" and wpr.c_ware_id = wi.ware_id");  
		return WareInfoEngine.getBeansFromSql(sql.toString(), null);
	}

	public IQBOAllWareInfoChildValue[] queryAllWareInfoChild(String condition, Map<String, String> parameter,
			int startNum, int endNum) throws Exception {
		StringBuffer con = new StringBuffer(condition);
		con.append(" and ").append(IQBOAllWareInfoChildValue.S_Channel).append("= :").append(IQBOAllWareInfoChildValue.S_Channel);
		parameter.put(IQBOAllWareInfoChildValue.S_Channel, CommnConstant.EXGCHANNEL_WEB);
		IQBOAllWareInfoChildValue[] values = QBOAllWareInfoChildEngine.getBeans(null, con.toString(), parameter, startNum,
				endNum, false);
		return values;
	}
	
	public int getWareInfoChildValueCount(String condition, Map<String, String> parameter) throws Exception {
		StringBuffer con = new StringBuffer(condition);
		con.append(" and ").append(IQBOAllWareInfoChildValue.S_Channel).append("= :").append(IQBOAllWareInfoChildValue.S_Channel);
		parameter.put(IQBOAllWareInfoChildValue.S_Channel, CommnConstant.EXGCHANNEL_WEB);
		int itemsNum = QBOAllWareInfoChildEngine.getBeansCount(con.toString(), parameter);
		return itemsNum;
	}

	public IWarePCRltValue[] getParentIdFindChildWareInfo(long wareParentId) throws Exception {
		Map<String, String> parameter = new HashMap<String, String>();
		StringBuffer condition = new StringBuffer(" 1=1 ");
		condition.append(" and ").append(IWarePCRltValue.S_PWareId).append("= :").append(IWarePCRltValue.S_PWareId);
		parameter.put(IWarePCRltValue.S_PWareId, String.valueOf(wareParentId));
		return WarePCRltEngine.getBeans(condition.toString(), parameter);
	}
	
	public IWarePCRltValue[] getParentPCInfoByChildId(long wareChildId)throws Exception{
		Map<String, String> parameter = new HashMap<String, String>();
		StringBuffer condition = new StringBuffer(" 1=1 ");
		condition.append(" and ").append(IWarePCRltValue.S_CWareId).append("= :").append(IWarePCRltValue.S_CWareId);
		parameter.put(IWarePCRltValue.S_CWareId, String.valueOf(wareChildId));
		return WarePCRltEngine.getBeans(condition.toString(), parameter);
	}
}
