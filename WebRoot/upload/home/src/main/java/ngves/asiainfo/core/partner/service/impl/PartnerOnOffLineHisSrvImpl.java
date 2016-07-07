package ngves.asiainfo.core.partner.service.impl;

import ngves.asiainfo.core.common.ivalues.IPartnerOnOffLineHisValue;
import ngves.asiainfo.core.partner.dao.interfaces.IPartnerOnOffLineHisDAO;
import ngves.asiainfo.core.partner.service.interfaces.IPartnerOnOffLineHisSrv;

public class PartnerOnOffLineHisSrvImpl implements IPartnerOnOffLineHisSrv {

	IPartnerOnOffLineHisDAO partnerOnOffLineHisDAO = null;

	public void setPartnerOnOffLineHisDAO(IPartnerOnOffLineHisDAO partnerOnOffLineHisDAO) throws Exception {
		this.partnerOnOffLineHisDAO = partnerOnOffLineHisDAO;
	}

	public IPartnerOnOffLineHisValue[] qryPartnerOnOffLine(String partnerId) throws Exception {
		return partnerOnOffLineHisDAO.qryPartnerOnOffLine(Long.valueOf(partnerId));
	}

}
