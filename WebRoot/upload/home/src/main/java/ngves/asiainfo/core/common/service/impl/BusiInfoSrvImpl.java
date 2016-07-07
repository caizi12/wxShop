package ngves.asiainfo.core.common.service.impl;

import ngves.asiainfo.core.common.dao.interfaces.IBusiInfoDAO;
import ngves.asiainfo.core.common.ivalues.IBusiInfoValue;
import ngves.asiainfo.core.common.model.InterLogInfo;
import ngves.asiainfo.core.common.service.interfaces.IBusiInfoSrv;

public class BusiInfoSrvImpl implements IBusiInfoSrv {

    private IBusiInfoDAO busiInfodao;

    public void setBusiInfoDAO(IBusiInfoDAO businessinfodao) throws Exception {
        this.busiInfodao = businessinfodao;
    }

    public long saveBusinessInfo(IBusiInfoValue businessinfo) throws Exception {
        return busiInfodao.saveBusinessInfo(businessinfo);
    }

    public IBusiInfoValue[] getBusinessInfos(long businessid) throws Exception {
        return busiInfodao.getBusinessInfos(businessid);
    }

	public void saveBusinessInfos(IBusiInfoValue[] busiInfos) throws Exception {
		
		 busiInfodao.saveBusinessInfos(busiInfos);
	}

	public long recordRequestInterLog(InterLogInfo loginfo) throws Exception {
		return busiInfodao.recordRequestInterLog(loginfo);
	}
	
	public long recordResponseInterLog(InterLogInfo loginfo) throws Exception{
		return busiInfodao.recordResponseInterLog(loginfo);
	}

}
