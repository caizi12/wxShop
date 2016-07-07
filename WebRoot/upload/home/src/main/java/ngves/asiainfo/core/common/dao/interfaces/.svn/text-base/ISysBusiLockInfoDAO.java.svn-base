package ngves.asiainfo.core.common.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.common.ivalues.ISysBusiLockInfoValue;

public interface ISysBusiLockInfoDAO {

	/**
     * 添加加锁记录
     * @param value
     * @throws Exception
     */
    public void saveLockInfo(ISysBusiLockInfoValue value) throws Exception;
    
    
    /**
     * 添加加锁记录
     * @param value
     * @throws Exception
     */
    public void saveLockInfo(ISysBusiLockInfoValue[] value) throws Exception;
    
    
    
    /**
     * 查询加锁记录
     * @param lockCode
     * @param lockType
     * @return
     * @throws Exception
     */
    public ISysBusiLockInfoValue getSysBusiLockInfoValue(String lockType,String lockCode)throws Exception;
    
    
    /**
     * 查询加锁记录
     * @param condtion
     * @param parameter
     * @return
     * @throws Exception
     */
    public ISysBusiLockInfoValue[] getSysBusiLockInfoValues(String condtion,Map<String,String> parameter)throws Exception;

}
