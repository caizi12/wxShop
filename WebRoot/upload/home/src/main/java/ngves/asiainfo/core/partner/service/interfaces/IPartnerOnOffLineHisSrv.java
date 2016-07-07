package ngves.asiainfo.core.partner.service.interfaces;

import ngves.asiainfo.core.common.ivalues.IPartnerOnOffLineHisValue;
import ngves.asiainfo.core.partner.dao.interfaces.IPartnerOnOffLineHisDAO;

public interface IPartnerOnOffLineHisSrv {

	public void setPartnerOnOffLineHisDAO(IPartnerOnOffLineHisDAO partnerOnOffLineHisDAO) throws Exception;

	/**
	 * 根据合作商标识查询合作商上下线历史
	 * @param partnerId
	 * @return
	 * @throws Exception
	 */
	public IPartnerOnOffLineHisValue[] qryPartnerOnOffLine(String partnerId) throws Exception;
}
