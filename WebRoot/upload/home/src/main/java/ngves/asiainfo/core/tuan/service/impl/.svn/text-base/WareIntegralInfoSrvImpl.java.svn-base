package ngves.asiainfo.core.tuan.service.impl;

import ngves.asiainfo.core.tuan.dao.interfaces.IWareIntegralInfoDAO;
import ngves.asiainfo.core.tuan.service.interfaces.IWareIntegralInfoSrv;
import ngves.asiainfo.core.ware.ivalues.IWareIntegralInfoValue;

/**
 * 业务逻辑实现类
 */
public class WareIntegralInfoSrvImpl implements IWareIntegralInfoSrv{

  private IWareIntegralInfoDAO wareIntegralInfoDAO;

	public void setWareIntegralInfoDAO(IWareIntegralInfoDAO wareIntegralInfoDAO) throws Exception{
		this.wareIntegralInfoDAO = wareIntegralInfoDAO;
	}

    public IWareIntegralInfoValue[] getBeans(Long wareId) throws Exception {
      return  wareIntegralInfoDAO.getBeans(wareId);
    }
    
}
