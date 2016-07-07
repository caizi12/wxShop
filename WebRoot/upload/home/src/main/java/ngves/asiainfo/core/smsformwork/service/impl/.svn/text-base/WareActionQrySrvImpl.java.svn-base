package ngves.asiainfo.core.smsformwork.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ngves.asiainfo.core.smsformwork.dao.interfaces.IWareActionQryDAO;
import ngves.asiainfo.core.smsformwork.ivalues.IQBOWareActionQryValue;
import ngves.asiainfo.core.smsformwork.service.interfaces.IWareActionQrySrv;

/**
 * 活动配置短信模板列表服务
 * @author liuyf
 *
 */
public class WareActionQrySrvImpl implements IWareActionQrySrv {

	private IWareActionQryDAO wareActionQryDAO;
	
	private static Log logger = LogFactory.getLog(WareActionQrySrvImpl.class);

	public IWareActionQryDAO getWareActionQryDAO() {
		return wareActionQryDAO;
	}

	public void setWareActionQryDAO(IWareActionQryDAO wareActionQryDAO) {
		this.wareActionQryDAO = wareActionQryDAO;
	}
	
	public IQBOWareActionQryValue[] getWareActionQryList(String activeKind,String activeName, String wareId,int startIndex, int endIndex) throws Exception{
		logger.debug("endIndex:"+endIndex);
		logger.debug("wareId:"+wareId);
		return wareActionQryDAO.getWareActionQryList(activeKind, activeName, wareId, startIndex, endIndex);
	}
	
	public int getWareActionQryCount(String activeKind,String activeName,String wareId)throws Exception{
		return wareActionQryDAO.getWareActionQryCount(activeKind, activeName, wareId);
	}
}
