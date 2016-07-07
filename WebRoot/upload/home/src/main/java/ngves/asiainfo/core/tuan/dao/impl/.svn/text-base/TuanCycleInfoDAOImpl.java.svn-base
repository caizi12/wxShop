package ngves.asiainfo.core.tuan.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.tuan.bo.TuanCycleInfoBean;
import ngves.asiainfo.core.tuan.bo.TuanCycleInfoEngine;
import ngves.asiainfo.core.tuan.dao.interfaces.ITuanCycleInfoDAO;
import ngves.asiainfo.core.tuan.ivalues.ITuanCycleInfoValue;

public class TuanCycleInfoDAOImpl implements ITuanCycleInfoDAO {

	public ITuanCycleInfoValue getTuanCycleInfo(String showType, String groupCode) throws Exception {
		ITuanCycleInfoValue[] result = new TuanCycleInfoBean[1];

		StringBuffer cond = new StringBuffer();
		Map<String, String> map = new HashMap<String, String>();
		cond.append(ITuanCycleInfoValue.S_ShowType).append("= :").append(ITuanCycleInfoValue.S_ShowType)
				.append(" and ").append(ITuanCycleInfoValue.S_GroupCode).append("= :").append(
						ITuanCycleInfoValue.S_GroupCode);
		map.put(ITuanCycleInfoValue.S_ShowType, showType);
		map.put(ITuanCycleInfoValue.S_GroupCode, groupCode);
		result = TuanCycleInfoEngine.getBeans(cond.toString(), map);
		if (result.length <= 0)
			return new TuanCycleInfoBean();
		return result[0];
	}

	public void updateTuanCycleInfo(ITuanCycleInfoValue value) throws Exception {
		TuanCycleInfoEngine.save(value);
	}
}
