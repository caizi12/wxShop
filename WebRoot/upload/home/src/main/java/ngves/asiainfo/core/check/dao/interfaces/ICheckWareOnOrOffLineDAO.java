/**
 * Copyright (c) 2011 asiainfo-linkage.com
 */
package ngves.asiainfo.core.check.dao.interfaces;


import java.util.Map;

import ngves.asiainfo.core.check.ivalues.IQBOCheckWareOnOrOffLineValue;


/**
 * @author shenfl
 * 礼品考核下线
 */
public interface ICheckWareOnOrOffLineDAO {

    
    /**
     * 查询考核下线礼品
     * @param condition
     * @param map
     * @return
     * @throws Exception
     */
    public IQBOCheckWareOnOrOffLineValue[] queryCheckWareOnOrOffLine(String condition,Map<String,String> map) throws Exception;
    
    /**
     * 分页查询考核下线礼品
     * @param condition
     * @param param       存放开始时间和结束时间参数
     * @param startIndex
     * @param endIndex
     * @return
     * @throws Exception
     */
    public IQBOCheckWareOnOrOffLineValue[] queryCheckWareOnOrOffLine(String condition, Map<String,String> param, int startIndex, int endIndex)
        throws Exception ;
   
    /**
     * 取得礼品考核下线的个数
     * @param condition
     * @param param
     * @return
     * @throws Exception
     */
    public int queryCheckWareOnOrOffLineCount(String condition, Map<String,String> param) throws Exception ;

}
