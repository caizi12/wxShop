package ngves.asiainfo.core.ware.service.impl;

import ngves.asiainfo.core.ware.dao.interfaces.IWareDescInfoDAO;
import ngves.asiainfo.core.ware.ivalues.IWareDescInfoValue;
import ngves.asiainfo.core.ware.service.interfaces.IWareDescInfoSrv;

public class WareDescInfoSrvImpl implements IWareDescInfoSrv {

    private IWareDescInfoDAO wareDescInfoDAO;

    public void setWareDescInfoDAO(IWareDescInfoDAO wareDescInfoDAO) throws  Exception {
        this.wareDescInfoDAO = wareDescInfoDAO;
    }

    /**
     * result: 1 设置VIP积分  0不设置VIP积分
     * @param wareId
     * @param wareDescDefineId
     * @return
     * @throws Exception
     */
    public String getWareDescValueByWareIdAndDescDefineId(String wareId, String wareDescDefineId) throws Exception {

        return this.wareDescInfoDAO.getWareDescValueByWareIdAndDescDefineId(wareId,wareDescDefineId);
    }

	public IWareDescInfoValue[] queryWareIdsDescInfo(String wareIds, String wareDescDefineId) throws Exception {
		
		return wareDescInfoDAO.queryWareIdsDescInfo(wareIds, wareDescDefineId);
	}
    
}
