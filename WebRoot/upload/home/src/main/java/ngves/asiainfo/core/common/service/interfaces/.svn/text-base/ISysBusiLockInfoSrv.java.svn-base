package ngves.asiainfo.core.common.service.interfaces;

import ngves.asiainfo.core.common.dao.interfaces.ISysBusiLockInfoDAO;
import ngves.asiainfo.core.common.ivalues.ISysBusiLockInfoValue;

public interface ISysBusiLockInfoSrv {

	public void setSysBusiLockInfoDAO(ISysBusiLockInfoDAO sysBusiLockInfoDAO);
	 /**
     * 取得加锁记录
     * @param lockCode
     * @param lockType
     * @return
     * @throws Exception
     */
    public ISysBusiLockInfoValue getLockInfo(String lockCode, String lockType) throws Exception;
    
    
    /**
     * 加锁单个业务
     * @param busiLockId
     * @param busiType
     * @return
     * @throws Exception
     */
    public boolean gainBusiLock(String busiLockId, String busiType,long staffId) throws Exception;
    
    
    /**
     * 解除某个业务锁
     * @param busiLockId
     * @param busiType
     * @return
     * @throws Exception
     */
    public boolean releaseBusiLock(String busiLockId, String busiType)  throws  Exception;
    
    
    
}
