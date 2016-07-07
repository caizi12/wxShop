package ngves.asiainfo.core.ware.service.impl;


import ngves.asiainfo.core.ware.dao.interfaces.IWarePicSynDAO;
import ngves.asiainfo.core.ware.ivalues.IWarePicSynValue;
import ngves.asiainfo.core.ware.service.interfaces.IWarePicSynSrv;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WarePicSynSrvImpl implements IWarePicSynSrv {

	private static Log log = LogFactory.getLog(WarePicSynSrvImpl.class);

	private IWarePicSynDAO warePicSynDAO;

	
	public void setWarePicSynDAO(IWarePicSynDAO warePicSynDAO) throws Exception {
		this.warePicSynDAO = warePicSynDAO;
	}


	public IWarePicSynValue getWarePicSynById(long warePicSynId)
			throws Exception {
		return warePicSynDAO.getWarePicSynById(warePicSynId);
	}


	public IWarePicSynValue[] getWarePicSynValue() throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
	
		condition.append(" AND ").append(IWarePicSynValue.S_Status).append("='0' ");
		log.info("The method getWarePicSynValue is running...");
		return warePicSynDAO.getWarePicSynValue(condition.toString(), null);
	}


	public long saveWarePicSynValue(IWarePicSynValue value) throws Exception {
		
		return warePicSynDAO.saveWarePicSynValue(value);
	}

}
