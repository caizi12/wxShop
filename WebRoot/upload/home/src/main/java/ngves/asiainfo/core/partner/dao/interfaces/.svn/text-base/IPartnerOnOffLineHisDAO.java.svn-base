package ngves.asiainfo.core.partner.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.common.ivalues.IPartnerOnOffLineHisValue;

public interface IPartnerOnOffLineHisDAO {

	/**
	 * 保存合作商上、下线历史
	 * @param partnerOnOff
	 * @throws Exception
	 */
	public void savePartnerOnOffHis(IPartnerOnOffLineHisValue partnerOnOff) throws Exception;

	/**
	 * 根据查询条件查询合作商上线先历史
	 * @param condition
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public IPartnerOnOffLineHisValue[] qryPartnerOnOffLine(String condition, Map param) throws Exception;

	/**
	 * 根据合作商标识查询合作商上下线历史
	 * @param partnerId
	 * @return
	 * @throws Exception
	 */
	public IPartnerOnOffLineHisValue[] qryPartnerOnOffLine(long partnerId) throws Exception;

	/**
	 * 根据合作商编码查询合作商上下线历史
	 * @param partnerCode
	 * @return
	 * @throws Exception
	 */
	public IPartnerOnOffLineHisValue[] qryPartnerOnOffLine(String partnerCode) throws Exception;
}
