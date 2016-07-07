/**
 * Copyright (c) 2011 asiainfo-linkage.com
 */
package ngves.asiainfo.core.check.service.interfaces;

import ngves.asiainfo.core.check.dao.interfaces.ICheckWareOnOrOffLineDAO;
import ngves.asiainfo.core.check.ivalues.IQBOCheckWareOnOrOffLineValue;

/**
 * @author shenfl
 * 礼品下线考核 业务逻辑 
 */
public interface ICheckWareOnOrOffLineSrv {

    /**
     * 注入DAO
     * @param checkOnOrOffLineDAO
     * @throws Exception
     */
    public void setCheckOnOrOffLineDAO(ICheckWareOnOrOffLineDAO checkOnOrOffLineDAO)  throws Exception;

    public IQBOCheckWareOnOrOffLineValue[] queryCheckWareOnOrOffLine(String startTime,String endTime) 
        throws Exception;
    
    /**
     * 分页考核下线礼品信息 
     * @param startTime
     * @param endTime
     * @param startIndex
     * @param endIndex
     * @return
     * @throws Exception
     */

    public IQBOCheckWareOnOrOffLineValue[] queryCheckWareOnOrOffLine(String startTime,String endTime,int startIndex ,int endIndex) 
        throws Exception;
   
    /**
     * 取得考核下线礼品的个数
     * @param startTime     开始时间 yyyy-MM-dd
     * @param endTime       结束时间 yyyy-MM-dd
     * @return
     * @throws Exception
     */
    public int queryCheckWareOnOrOffLineCount(String startTime,String endTime) 
        throws Exception ;
    
}
