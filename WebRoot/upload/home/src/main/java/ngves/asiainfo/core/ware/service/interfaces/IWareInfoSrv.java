/**
 * Copyright (c) 2011 asiainfo-linkage.com
 */
package ngves.asiainfo.core.ware.service.interfaces;

import java.util.List;

import ngves.asiainfo.core.ware.dao.interfaces.IWareInfoDAO;
import ngves.asiainfo.core.ware.ivalues.IPermissionTypeInfoValue;
import ngves.asiainfo.core.ware.ivalues.IQBOPermissionWareValue;
import ngves.asiainfo.core.ware.ivalues.IQBOWareProvDeliverFeeValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoValue;
import ngves.asiainfo.core.ware.ivalues.IwareWeekRankValue;
import ngves.asiainfo.core.ware.model.PermissionWare;

/**
 * @author asiainfo
 *
 */
public interface IWareInfoSrv {
    
    public void setWareInfoDAO(IWareInfoDAO wareInfoDAO)  throws Exception;
    
    /**
     * 根据礼品标识查询礼品信息
     * @param id
     * @return
     * @throws Exception
     */
    public IWareInfoValue getBean(Long id) throws Exception;
    
    /**
     * 保存礼品信息
     * @param values
     * @throws Exception
     */
    public void saveWareInfo(IWareInfoValue  values)throws Exception;

    /**
     * 通过礼品编码查到礼品
     * @param wareCode
     * @return
     * @throws Exception
     */
    public IWareInfoValue getByWareCode(String wareCode) throws Exception;
    
    /**
     * 保存礼品信息,注意只是修改制定的礼品信息属性
     * @param wareInfoValue
     * @throws Exception
     */
    public void saveWareInfoValue(IWareInfoValue wareInfoValue) throws Exception;
    
    /*****************************0积分订单成功页面开始***********************************/
      /**
       * 获取所有当前有效过则下优惠的礼品
       * @return
       * @throws Exception
       */
      public IQBOPermissionWareValue[] getAllPermissionWare(String channel) throws Exception; 
      
      /**
       * 
       * @param permissionId 根据规则ID获取合作商、礼品小类、特殊礼品列表
       * @param permissionCode type_name=00填写礼品小类编码； type_name=01填写礼品商编码； type_name=02填写礼品编码， type_name=03,存放省编码
       * @return
       * @throws Exception
       */
      public IPermissionTypeInfoValue[] getPermissionTypeInfos(long permissionId,String permissionCode ) throws Exception;
      
      
      public  List<String> getWareInfoPortalByPermissionId(List<String> partnerCodeList,
              List<String> wareKindCodeList, List<String> wareCodeList,String channel) throws Exception;
      public List<PermissionWare> getPermissionWareList(long permissionId,String channel) throws Exception;
      
      public boolean isPermissionWare(long wareId) throws Exception;
      /**
       * @param wareId
       * @return
       */
      /*****************************0积分订单成功页面结束***********************************/
      
      
      /**
       * 根据礼品标识串（wareIds）查询各个礼品的31个省份的运费信息
       * @param wareIds 礼品id串
       * @return
       * @throws Exception
       * @author yeqh
       * 2013-11-04
       */
      public IQBOWareProvDeliverFeeValue[] getWareProvDeliverFeeById(String wareIds) throws Exception;


	  	/**
	  	 * 查询礼品前七天的兑换数据
	  	 * @return
	  	 * @throws Exception
	  	 */
	  	public IwareWeekRankValue[] getWareWeekRankValue() throws Exception;
	  	
	    /**
	     * 通过礼品编码查到礼品
	     * @param wareCode 是一个礼品code编码串
	     * @return
	     * @throws Exception
	     */
	    public IWareInfoValue[] getByWareCodes(String wareCodes) throws Exception;
        /**通过礼品编码，O2O专区ID，和O2O专区和礼品关系 查询当前O2O专区下排序的礼品信息*/
	    public IWareInfoValue[] getWareInfoByO2oId(String wareCodes,String o2oId) throws Exception;
}
