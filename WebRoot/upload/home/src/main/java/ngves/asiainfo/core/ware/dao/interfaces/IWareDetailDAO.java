/**
 * Copyright (c) 2011 asiainfo-linkage.com
 */
package ngves.asiainfo.core.ware.dao.interfaces;

import ngves.asiainfo.core.ware.ivalues.IWareDescInfoValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoPortalIntegralValue;
import ngves.asiainfo.core.ware.ivalues.IWareIntegralInfoValue;


/**
 * @author asiainfo
 *
 */
public interface IWareDetailDAO {

    /**
     * 获取礼品的兑换积分
     * @param ware_id
     * @return
     * @throws Exception
     */
    public IWareIntegralInfoValue[] getWareIntegral(long ware_id) throws Exception;
    
    /**
     * 根据礼品编号和属性编号取得礼品属性信息
     * @param wareId
     * @param descDefineId
     * @return
     * @throws Exception
     */
    public IWareDescInfoValue[] getWareDescInfo(String wareId,String descDefineId) throws Exception;
    
    /**
     * 根据礼品ID和属性ID集合，一次性查出多条属性值。
     * @param wareId
     * @param strDesDefineIds 礼品属性ID字符串，eg:strDesDefineIds ="999999999999936,999999999999935";
     * @return
     * @throws Exception
     */
    public IWareDescInfoValue[] getWareDescInfoValues(String wareId,String strDesDefineIds) throws Exception;
    
    /**
     * 查询礼品所有渠道的客户星级积分信息（不包含全球通、动感地带、神州行）
     * @param wareId
     * @return
     * @throws Exception
     */
    public IWareIntegralInfoValue[] getUserStartValues(long ware_id) throws Exception;
    
    
    /**
     * 根据客户星级 和 兑换渠道 查询指定礼品的星级积分信息。
     * @param wareId
     * @param starLevel
     * @param channel
     * @return
     * @throws Exception
     */
    public IWareInfoPortalIntegralValue[] getWareIntergerByStar(String wareId,String starLevel,String channel) throws Exception;
    
    /**
     * 根据礼品ID和兑换渠道，获取该礼品支持的星级情况
     * @param wareId
     * @param channel
     * @return
     * @throws Exception
     */
    public IWareInfoPortalIntegralValue[] getWareStarInfo(String wareId,String channel) throws Exception;
    
    /**
	 * 根据礼品Id获取礼品支持星级或品牌
	 * @param ware_id
	 * @return
	 * @throws Exception
	 */
    public String[] getWareSupportStarLevel(long ware_id) throws Exception ;
}
