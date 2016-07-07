/**
 * Copyright (c) 2011 asiainfo-linkage.com
 */
package ngves.asiainfo.core.ware.dao.interfaces;

import java.util.List;
import java.util.Map;

import ngves.asiainfo.core.ware.ivalues.IPermissionTypeInfoValue;
import ngves.asiainfo.core.ware.ivalues.IQBOAllWareKindInfoValue;
import ngves.asiainfo.core.ware.ivalues.IQBOPermissionWareValue;
import ngves.asiainfo.core.ware.ivalues.IQBOWareProvDeliverFeeValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoPortalValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoValue;
import ngves.asiainfo.core.ware.ivalues.IwareWeekRankValue;
import ngves.asiainfo.core.ware.model.PermissionWare;

/**
 * @author asiainfo
 *
 */
public interface IWareInfoDAO {
	
	/**
	 * 根据礼品标识串（wareIds）查询各个礼品的31个省份的运费信息
	 * @param wareIds
	 * @return
	 * @throws Exception
	 */
	public IQBOWareProvDeliverFeeValue[] getWareProvDeliverFeeById(String wareIds) throws Exception;

    /**
     * 根据礼品标识查询礼品信息
     * @param id
     * @return
     * @throws Exception
     */
    public IWareInfoValue getBean(Long id) throws Exception;
    
    /**
     * 保存wareInfoValue对象
     * @param wareInfoValue
     * @throws Exception
     */
    public void saveWareInfoBean(IWareInfoValue wareInfoValue) throws Exception;
    
    /**
     * 根据礼品ID获取wareInfoValue对象
     * @param id
     * @return
     * @throws Exception
     */
    public IWareInfoValue getWareInfoValueById(long id) throws Exception;
    
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
    /*****************************0积分订单成功页面结束***********************************/
    
    /**
     * 查询礼品信息
     */
    public IWareInfoValue[] getInfoValue(String condition, Map<String, String> parameter) throws Exception;
  
    
    /**
	 * 取得所有礼品的分类信息
	 * @return
	 * @throws Exception
	 */
	public IQBOAllWareKindInfoValue[] getAllWareKindInfo() throws Exception;
	
	
	/**
	 * 根据礼品ID取得礼品的分类信息
	 * @param wareId
	 * @return
	 * @throws Exception
	 */
	public IQBOAllWareKindInfoValue[] getWareKindInfo(String wareId) throws Exception;
	
	
	/**
	 * 计算每个礼品对应的省份的积分数值分成4步：
	 * 1. 所有满足条件的礼品
	 * 2. 不满足条件的礼品
	 * 3. 条件1 和 条件2 相加
	 * 如果SELECT * FROM ware_info_portal wip WHERE wip.ware_storage_type IS NULL;可以查询出数据，则为脏数据，该数据不考虑。
	 */
	public IQBOWareProvDeliverFeeValue[] getWareProvDeliverFee() throws Exception;
	
	/**
	 * 获取礼品的所有省份运费串
	 * @param wareId
	 * @return
	 * @throws Exception
	 */
	public IQBOWareProvDeliverFeeValue getWareProvDeliverFeeById(long wareId) throws Exception;
	
	/**
	 * 获取ware_info_portal表所有礼品信息
	 * @return
	 * @throws Exception
	 */
	public IWareInfoPortalValue[] getAllWareInfoPortal() throws Exception;
	
	/**
	 * 获取单个礼品信息
	 * @param wareId
	 * @return
	 * @throws Exception
	 */
	public IWareInfoPortalValue getWareInfoPortal(long wareId) throws Exception;
	
	/**
	 * 查询礼品前七天的兑换数据
	 * @return
	 * @throws Exception
	 */
	public IwareWeekRankValue[] getWareWeekRankValue() throws Exception;
	
	/**
	 * 获取所有子礼品 
	 * @param childWareId 父礼品Ware Id
	 * @return
	 * @throws Exception
	 */
	public IWareInfoPortalValue[] qryAllCWarePortalInfosByPId(String parentWareId) throws Exception;
	
	 /**
     * 通过礼品编码查到礼品
     * @param wareCode 是一个礼品code编码串
     * @return
     * @throws Exception
     */
    public IWareInfoValue[] getByWareCodes(String wareCodes) throws Exception;
     
	 /**
     * 通过礼品编码 ，O2OID 查到礼品，主要是完成排序
     * @param wareCode 是一个礼品code编码串,o2oId 是O2O专区ID 
     * @return
     * @throws Exception
     */
    public IWareInfoValue[] getWareInfoByO2oId(String wareCodes,String o2oId) throws Exception;
}




