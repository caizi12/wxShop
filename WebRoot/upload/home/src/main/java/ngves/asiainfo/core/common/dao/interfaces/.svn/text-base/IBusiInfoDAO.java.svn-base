package ngves.asiainfo.core.common.dao.interfaces;

import ngves.asiainfo.core.common.ivalues.IBusiInfoValue;
import ngves.asiainfo.core.common.model.InterLogInfo;


public interface IBusiInfoDAO {
    /**
     * 增加一条业务记录
     * @param busiInfo
     * @return
     * @throws Exception
     */
    public long saveBusinessInfo(IBusiInfoValue busiInfo) throws Exception;

    public IBusiInfoValue[] getBusinessInfo(IBusiInfoValue busiInfo) throws Exception;

    public IBusiInfoValue[] getBusinessInfos(long businessid) throws Exception;

    public void saveBusinessInfos(IBusiInfoValue[] busiInfos) throws Exception;
    
	public long recordRequestInterLog(InterLogInfo loginfo) throws Exception;
	
	public long recordResponseInterLog(InterLogInfo loginfo) throws Exception;
}

