/**
 * Copyright (c) 2011 asiainfo-linkage.com
 */
package ngves.asiainfo.core.check.dao.impl;

import java.util.Map;

import ngves.asiainfo.core.check.bo.QBOCheckWareOnOrOffLineEngine;
import ngves.asiainfo.core.check.dao.interfaces.ICheckWareOnOrOffLineDAO;
import ngves.asiainfo.core.check.ivalues.IQBOCheckWareOnOrOffLineValue;

/**
 * @author shenfl
 *
 */
public class CheckWareOnOrOffLineDAOImpl implements ICheckWareOnOrOffLineDAO {


    /* (non-Javadoc)
     * @see ngves.asiainfo.mgt.check.dao.interfaces.ICheckWareOnOrOffLineDAO#queryCheckWareOnOrOffLine(java.lang.String, java.util.Map)
     */
    public IQBOCheckWareOnOrOffLineValue[] queryCheckWareOnOrOffLine(String condition, Map<String,String> map) throws Exception {
        return QBOCheckWareOnOrOffLineEngine.getBeans(condition, map);
    }


    public IQBOCheckWareOnOrOffLineValue[] queryCheckWareOnOrOffLine(String condition, Map<String,String> param, int startIndex,
            int endIndex) throws Exception {
        return QBOCheckWareOnOrOffLineEngine.getBeans(null,condition, param, startIndex, endIndex,false);
    }


    public int queryCheckWareOnOrOffLineCount(String condition, Map<String,String> param) throws Exception {
        return QBOCheckWareOnOrOffLineEngine.getBeansCount(condition, param);
    }



}
