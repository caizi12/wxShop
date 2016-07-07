package ngves.asiainfo.core.common.service.interfaces;

import ngves.asiainfo.core.common.dao.interfaces.IBusiInfoDAO;
import ngves.asiainfo.core.common.ivalues.IBusiInfoValue;
import ngves.asiainfo.core.common.model.InterLogInfo;


public interface IBusiInfoSrv {
    public long saveBusinessInfo(IBusiInfoValue busiInfo) throws Exception;

    public IBusiInfoValue[] getBusinessInfos(long busiId) throws Exception;

    public void setBusiInfoDAO(IBusiInfoDAO busiInfodao) throws Exception;
    
    public void saveBusinessInfos(IBusiInfoValue[] busiInfo) throws Exception;
    
    public long recordRequestInterLog(InterLogInfo  loginfo)throws Exception;
    
    public long recordResponseInterLog(InterLogInfo  loginfo)throws Exception;
}

