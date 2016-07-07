package ngves.asiainfo.core.ware.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.ware.bo.WareDescInfoBean;
import ngves.asiainfo.core.ware.bo.WareDescInfoEngine;
import ngves.asiainfo.core.ware.dao.interfaces.IWareDescInfoDAO;
import ngves.asiainfo.core.ware.ivalues.IWareDescInfoValue;

public class WareDescInfoDAOImpl implements IWareDescInfoDAO {

	public String getWareDescValueByWareIdAndDescDefineId(String wareId, String wareDescDefineId) throws Exception {
		StringBuffer condition = new StringBuffer();
		Map<String, String> parameter = new HashMap<String, String>();
		condition.append(IWareDescInfoValue.S_WareId).append("= :").append("wareId").append("  and  ").append(
				IWareDescInfoValue.S_DescDefineId).append("= :").append("wareDescDefineId");
		// 设置对应的参数
		parameter.put("wareId", wareId);
		parameter.put("wareDescDefineId", wareDescDefineId);
		WareDescInfoBean[] descs = WareDescInfoEngine.getBeans(condition.toString(), parameter);
		if (descs != null && descs.length == 1) {
			// 结果是1 表示是VIP积分，0 标识不是VIP积分
			return descs[0].getWareDescValue();
		}
		return null;
	}

	public IWareDescInfoValue[] queryWareIdsDescInfo(String wareIds, String wareDescDefineId) throws Exception {
		StringBuffer condition = new StringBuffer();
		Map<String, String> parameter = new HashMap<String, String>();		
		
		condition.append(IWareDescInfoValue.S_WareId).append("  in(").append(wareIds+") ");
		condition.append("  and  "+IWareDescInfoValue.S_DescDefineId).append("= :").append("wareDescDefineId");
		// 设置对应的参数
		parameter.put("wareDescDefineId", wareDescDefineId);
		
		return  WareDescInfoEngine.getBeans(condition.toString(), parameter);

	}


}
