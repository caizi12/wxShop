package ngves.asiainfo.core.check.dao.impl;

import ngves.asiainfo.core.check.bo.PartnerCheckFileEngine;
import ngves.asiainfo.core.check.dao.interfaces.IPartnerCheckFileDAO;
import ngves.asiainfo.core.check.ivalues.IPartnerCheckFileValue;

public class PartnerCheckFileDAOImpl implements IPartnerCheckFileDAO {
	
	 /**
     * 保存PartnerCheckFile的信息
     * @param value
     * @throws Exception
     */
	public void savePartnerCheckFile(IPartnerCheckFileValue value)
			throws Exception {
		value.setFileId(PartnerCheckFileEngine.getNewId().longValue());
		PartnerCheckFileEngine.save(value);
	}

}
