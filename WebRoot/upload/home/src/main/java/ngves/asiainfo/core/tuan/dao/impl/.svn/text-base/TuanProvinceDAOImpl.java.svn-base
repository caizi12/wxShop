package ngves.asiainfo.core.tuan.dao.impl;

import java.util.HashMap;

import ngves.asiainfo.core.tuan.bo.TuanProvinceBean;
import ngves.asiainfo.core.tuan.bo.TuanProvinceEngine;
import ngves.asiainfo.core.tuan.dao.interfaces.ITuanProvinceDAO;
import ngves.asiainfo.core.tuan.ivalues.ITuanProvinceValue;

public class TuanProvinceDAOImpl implements ITuanProvinceDAO {

	public void addTuanProvince(ITuanProvinceValue[] value) throws Exception {
		long tuanProvinceId = 0L;
		for (int i = 0; i < value.length; i++) {
			tuanProvinceId = TuanProvinceEngine.getNewId().longValue();
			value[i].setTuanProvinceId(tuanProvinceId);
			// 将团购对应的省份信息设置为新状态
			value[i].setStsToNew();
		}
		TuanProvinceEngine.save(value);
	}

	public void deleteTuanProvinceById(String tuanId) throws Exception {
		HashMap<String, String> para = new HashMap<String, String>();
		String cond = ITuanProvinceValue.S_TuanId + " ='" + tuanId + "'";
		TuanProvinceBean[] beans = TuanProvinceEngine.getBeans(cond, para);
		if (null != beans) {
			for (int i = 0; i < beans.length; i++) {
				beans[i].delete();
			}
		}
		TuanProvinceEngine.save(beans);
	}

	public ITuanProvinceValue[] queryTuanProvinceById(String tuanId) throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		// modified by shenfl at 2011-07-18 修改条件
		condition.append(" and " + ITuanProvinceValue.S_TuanId).append(" = :").append(ITuanProvinceValue.S_TuanId);
		HashMap<String, String> para = new HashMap<String, String>();
		para.put(ITuanProvinceValue.S_TuanId, tuanId);
		ITuanProvinceValue[] values = TuanProvinceEngine.getBeans(condition.toString(), para);
		return values;
	}

}
