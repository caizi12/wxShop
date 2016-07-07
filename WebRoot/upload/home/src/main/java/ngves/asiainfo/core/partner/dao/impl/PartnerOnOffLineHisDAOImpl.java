package ngves.asiainfo.core.partner.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.common.bo.PartnerOnOffLineHisEngine;
import ngves.asiainfo.core.common.ivalues.IPartnerOnOffLineHisValue;
import ngves.asiainfo.core.partner.dao.interfaces.IPartnerOnOffLineHisDAO;
import ngves.asiainfo.util.StringUtil;

public class PartnerOnOffLineHisDAOImpl implements IPartnerOnOffLineHisDAO {

	@SuppressWarnings("unchecked")
	public IPartnerOnOffLineHisValue[] qryPartnerOnOffLine(String condition, Map param) throws Exception {
		return PartnerOnOffLineHisEngine.getBeans(condition, param);
	}

	public IPartnerOnOffLineHisValue[] qryPartnerOnOffLine(long partnerId) throws Exception {
		IPartnerOnOffLineHisValue[] result = {};
		if (partnerId > 0) {
			String condition = IPartnerOnOffLineHisValue.S_PartnerId + " =:" + IPartnerOnOffLineHisValue.S_PartnerId;
			Map<String, Long> param = new HashMap<String, Long>();
			param.put(IPartnerOnOffLineHisValue.S_PartnerId, partnerId);
			result = PartnerOnOffLineHisEngine.getBeans(condition, param);
		}
		return result;
	}

	public IPartnerOnOffLineHisValue[] qryPartnerOnOffLine(String partnerCode) throws Exception {
		IPartnerOnOffLineHisValue[] result = {};
		if (!StringUtil.isBlank(partnerCode)) {
			String condition = IPartnerOnOffLineHisValue.S_PartnerCode + " =:"
					+ IPartnerOnOffLineHisValue.S_PartnerCode;
			Map<String, String> param = new HashMap<String, String>();
			param.put(IPartnerOnOffLineHisValue.S_PartnerCode, partnerCode);
			result = PartnerOnOffLineHisEngine.getBeans(condition, param);
		}
		return result;
	}

	public void savePartnerOnOffHis(IPartnerOnOffLineHisValue partnerOnOff) throws Exception {
		if (null != partnerOnOff) {
			if (partnerOnOff.getHisId() <= 0) {
				partnerOnOff.setHisId(PartnerOnOffLineHisEngine.getNewId().longValue());
			}
			PartnerOnOffLineHisEngine.save(partnerOnOff);
		}
	}

}
