/**
 * Copyright (c) 2011 asiainfo-linkage.com
 */
package ngves.asiainfo.core.check.service.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.check.dao.interfaces.ICheckWareOnOrOffLineDAO;
import ngves.asiainfo.core.check.ivalues.IQBOCheckWareOnOrOffLineValue;
import ngves.asiainfo.core.check.service.interfaces.ICheckWareOnOrOffLineSrv;

/**
 * @author shenfl
 *
 */
public class CheckWareOnOrOffLineSrvImpl implements ICheckWareOnOrOffLineSrv {
    


    private ICheckWareOnOrOffLineDAO checkOnOrOffLineDAO;
    
    
    public void setCheckOnOrOffLineDAO(ICheckWareOnOrOffLineDAO checkOnOrOffLineDAO)  throws Exception {
        this.checkOnOrOffLineDAO = checkOnOrOffLineDAO;
    }

    /* (non-Javadoc)
     * @see ngves.asiainfo.mgt.check.service.interfaces.ICheckWareOnOrOffLineSrv#queryCheckWareOnOrOffLine(java.lang.String, java.lang.String)
     */
    public IQBOCheckWareOnOrOffLineValue[] queryCheckWareOnOrOffLine(String startTime, String endTime) throws Exception {
        Map<String,String> map = new HashMap<String,String>();
        map.put("startTime", startTime);
        map.put("endTime",endTime);
        return this.checkOnOrOffLineDAO.queryCheckWareOnOrOffLine(null, map);
    }

    /* (non-Javadoc)
     * @see ngves.asiainfo.mgt.check.service.interfaces.ICheckWareOnOrOffLineSrv#queryCheckWareOnOrOffLine(java.lang.String, java.lang.String, int, int)
     */
    public IQBOCheckWareOnOrOffLineValue[] queryCheckWareOnOrOffLine(String startTime, String endTime, int startIndex,
            int endIndex) throws Exception {
        Map<String,String> paramter = new HashMap<String,String>();
        paramter.put("startTime",startTime);
        paramter.put("endTime", endTime);
        return this.checkOnOrOffLineDAO.queryCheckWareOnOrOffLine(null, paramter, startIndex, endIndex);
    }

    /* (non-Javadoc)
     * @see ngves.asiainfo.mgt.check.service.interfaces.ICheckWareOnOrOffLineSrv#queryCheckWareOnOrOffLineCount(java.lang.String, java.lang.String)
     */
    public int queryCheckWareOnOrOffLineCount(String startTime, String endTime) throws Exception {
        Map<String,String> parameter = new HashMap<String,String>();
        parameter.put("startTime", startTime);
        parameter.put("endTime",endTime);
        return this.checkOnOrOffLineDAO.queryCheckWareOnOrOffLineCount(null, parameter);
    }

}
