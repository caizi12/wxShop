package ngves.asiainfo.core.smsformwork.service.interfaces;

import ngves.asiainfo.core.smsformwork.dao.interfaces.IWareActionQryDAO;
import ngves.asiainfo.core.smsformwork.ivalues.IQBOWareActionQryValue;

public interface IWareActionQrySrv {

	public void setWareActionQryDAO(IWareActionQryDAO wareActionQryDAO);
	
	public IQBOWareActionQryValue[] getWareActionQryList(String activeKind,String activeName,String wareId, int startIndex, int endIndex) throws Exception;
	
	public int getWareActionQryCount(String activeKind,String activeName,String wareId)throws Exception;
}
