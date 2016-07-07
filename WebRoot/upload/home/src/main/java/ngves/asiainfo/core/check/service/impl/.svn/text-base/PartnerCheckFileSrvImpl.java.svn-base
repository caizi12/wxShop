package ngves.asiainfo.core.check.service.impl;

import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.check.dao.interfaces.IPartnerCheckFileDAO;
import ngves.asiainfo.core.check.ivalues.IPartnerCheckFileValue;
import ngves.asiainfo.core.check.service.interfaces.IPartnerCheckFileSrv;

import com.ai.appframe2.service.ServiceFactory;

/**
 * 合作商考核service Impl
 * @author chenzhd
 *
 */
public class PartnerCheckFileSrvImpl implements IPartnerCheckFileSrv {

	public void savePartnerCheckFileInfo(IPartnerCheckFileValue value)
			throws Exception {
		IPartnerCheckFileDAO partnerCheckFile = (IPartnerCheckFileDAO) ServiceFactory
		.getService(CoreSrvContstant.SERVICE_CORE_CHECK_PARTNERCHECK_DAO);
		partnerCheckFile.savePartnerCheckFile(value);

	}

}
