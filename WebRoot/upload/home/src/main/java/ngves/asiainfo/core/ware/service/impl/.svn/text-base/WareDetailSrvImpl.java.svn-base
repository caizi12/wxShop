/**
 * Copyright (c) 2011 asiainfo-linkage.com
 */
package ngves.asiainfo.core.ware.service.impl;

import ngves.asiainfo.core.ware.dao.interfaces.IWareDetailDAO;
import ngves.asiainfo.core.ware.ivalues.IWareDescInfoValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoPortalIntegralValue;
import ngves.asiainfo.core.ware.ivalues.IWareIntegralInfoValue;
import ngves.asiainfo.core.ware.service.interfaces.IWareDetailSrv;

/**
 * @author asiainfo
 *
 */
public class WareDetailSrvImpl implements IWareDetailSrv {

    private IWareDetailDAO wareDetailDAO;
    
    public void setWareDetailDAO(IWareDetailDAO wareDetailDAO)  throws Exception{
        this.wareDetailDAO = wareDetailDAO;
    }

    /* (non-Javadoc)
     * @see ngves.asiainfo.core.ware.service.interfaces.IWareDetailSrv#getWareDescInfo(java.lang.String, java.lang.String)
     */
    public IWareDescInfoValue[] getWareDescInfo(String wareId, String descDefineId) throws Exception {
       return  this.wareDetailDAO.getWareDescInfo(wareId, descDefineId);
    }

    /* (non-Javadoc)
     * @see ngves.asiainfo.core.ware.service.interfaces.IWareDetailSrv#getWareIntegral(long)
     */
    public IWareIntegralInfoValue[] getWareIntegral(long ware_id) throws Exception {
        return this.wareDetailDAO.getWareIntegral(ware_id);
    }

	public IWareDescInfoValue[] getWareDescInfoValues(String wareId,
			String strDesDefineIds) throws Exception {
		return this.wareDetailDAO.getWareDescInfoValues(wareId, strDesDefineIds);
	}

	
	public IWareInfoPortalIntegralValue[] getWareIntergerByStar(String wareId,
			String starLevel, String channel) throws Exception {
		return this.wareDetailDAO.getWareIntergerByStar(wareId, starLevel, channel);
	}

	public IWareInfoPortalIntegralValue[] getWareStarInfo(String wareId,
			String channel) throws Exception {
		return this.wareDetailDAO.getWareStarInfo(wareId, channel);
	}
	
	/**
	 *  根据礼品Id获取礼品支持星级或品牌
	 * @param ware_id
	 * @return
	 * @throws Exception
	 */public String[] getWareSupportStarLevel(long ware_id) throws Exception {
		 return  this.wareDetailDAO.getWareSupportStarLevel(ware_id);
	 }

}
