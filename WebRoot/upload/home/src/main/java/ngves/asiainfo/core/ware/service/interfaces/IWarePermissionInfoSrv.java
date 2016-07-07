package ngves.asiainfo.core.ware.service.interfaces;

import ngves.asiainfo.core.ware.dao.interfaces.IWarePermissionInfoDAO;
import ngves.asiainfo.core.ware.ivalues.IPermissionInfoValue;
import ngves.asiainfo.core.ware.ivalues.IPermissionTypeInfoValue;
import ngves.asiainfo.core.ware.ivalues.IQBOPermissionInfoValue;
import ngves.asiainfo.core.ware.ivalues.IQBOPermissionRuleRltValue;
import ngves.asiainfo.core.ware.ivalues.IQBOPermissionWareRltValue;


/**
 * 积分优惠兑换资格校验基本信息服务类
 * @author asiainfo
 *
 */
public interface IWarePermissionInfoSrv {

	public void setWarePermissionInfoDAO(IWarePermissionInfoDAO warePermissionInfoDAO) throws Exception;
	
	public void  mixPayBind(String permissionId,String wareid) throws Exception;
	
	/**
	 * 新增优惠兑换资格的规则信息
	 * @param value			礼品规则校验信息表
	 * @param typeValues  	
	 * @param staffId 当前操作人ID
	 * @param comType 操作人公司类型
	 * @param orgId 组织ID
	 * @throws Exception
	 */
	public long saveWarePermissionInfoValue(IPermissionInfoValue value,IPermissionTypeInfoValue []typeValues,long staffId,String comType,long orgId)throws Exception;
	
	/**
	 * 更新优惠兑换资格的规则信息
	 * @param value			礼品规则校验信息表	
	 * @param typeValues	
	 * @throws Exception
	 */
	public long updateWarePermissionInfoValue(IPermissionInfoValue value,IPermissionTypeInfoValue []typeValues,long staffId,String comType,long orgId)throws Exception;
	
	/**
	 * 删除优惠兑换资格的规则信息
	 * @param warePermissionId  规则ID
	 * @throws Exception
	 */
	public void deleteWarePermissionInfoValue(long warePermissionId,long staffId,String comType,long orgId)throws Exception;
	
	
	
	//TODO  这里还缺少优惠资格兑换页面的查询方法。
	
	
	
	
	//优惠兑换资格规则绑定礼品信息的接口服务。
	//公共方法
	//1、新增礼品与规则的绑定关系。
	//2、删除礼品与规则的绑定关系。
	
	
	//私有方法 在实现类中
	//1、判断一个规则是否存在与礼品的绑定关系。
	//2、。。。

	
	

	/**
	 * 优惠兑换规则信息查询
	 * @param permissionName   规则名称
	 * @param wareGMEValue     优惠分值
	 * @param exchangeChannel  支持渠道
	 * @param mobileBrandCode  支持品牌
	 * @param itemScope        礼品范围
	 * @return
	 * @throws Exception 
	 */
	public IQBOPermissionInfoValue[] getPermissionRule(String permissionName,String wareGMEValue,
			String exchangeChannel,String mobileBrandCode,String itemScope,String orderStatus,String orderScope, int startNum, int endNum) throws Exception;
	
	
	
	/**
	 * 查询优惠规则基本信息
	 * 适用于优惠规则配置管理页面的查询功能
	 * @param ruleName
	 * @param wareGMEValue
	 * @param supportType
	 * @param exchangeChannel
	 * @param brandCode
	 * @param itemScope
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IQBOPermissionInfoValue[] queryPermissionInfoValues(String ruleName, String wareGMEValue,
			String supportType, String exchangeChannel, String brandCode, String itemScope,int startIndex,int endIndex) throws Exception;
	
	
	
	/**
	 * 根据规则ID，获得该规则对应的json格式信息
	 * @param permissionId
	 * @return
	 * @throws Exception
	 */
	public String getPermissionInfoJsonById(long permissionId)throws Exception;
	
	
	/**
	 * 根据输入的规则名称，判断数据库中是否存在相同名称的数据
	 * @param permissionRuleName
	 * @return  true：	存在数据
	 * 			false： 不存在相同数据
	 * @throws Exception
	 */
	public boolean isExistPermissionRuleName(String permissionRuleName)throws Exception;
	
	
	
	/**
	 * 查询优惠规则和礼品的绑定信息
	 * @param partner_id
	 * @param ware_brand_id
	 * @param ware_first_kind_id
	 * @param ware_kind_parent_id
	 * @param ware_kind_id
	 * @param beg_time
	 * @param end_time
	 * @param ware_status
	 * @param ware_name
	 * @param ware_code
	 * @param permissionId
	 * @param mobile_code 品牌编码
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IQBOPermissionWareRltValue [] queryPermissionWareRltValues(String partner_id, String ware_brand_id,String ware_first_kind_id, String ware_kind_parent_id, String ware_kind_id,String beg_time, String end_time, String ware_status, String ware_name, 
			String ware_code,String permissionId,String mobile_code,String province_code,String wareKindInfoId,int startIndex,int endIndex) throws Exception;
	
	/**
	 * 查询优惠规则和礼品的绑定信息数量
	 * @param partner_id
	 * @param ware_brand_id
	 * @param ware_first_kind_id
	 * @param ware_kind_parent_id
	 * @param ware_kind_id
	 * @param beg_time
	 * @param end_time
	 * @param ware_status
	 * @param ware_name
	 * @param ware_code
	 * @param permissionId
	 * @param mobile_code 品牌编码
	 * @return
	 * @throws Exception
	 */
	public int queryPermissionWareRltCount(String partner_id, String ware_brand_id,
			String ware_first_kind_id, String ware_kind_parent_id, String ware_kind_id,
			String beg_time, String end_time, String ware_status, String ware_name,
			String ware_code,String permissionId,String mobile_code,String province_code,String wareKindInfoId) throws Exception;
	
	/**
	 * 查询出所有的优惠规则信息的JSON字符串
	 * @return
	 * @throws Exception
	 */
	public IPermissionInfoValue [] queryAllPermissionInfoValues()throws Exception;
	
	
	/**
	 * 创建礼品与优惠规则的绑定关系
	 * @param permissionId  优惠规则的ID
	 * @param wareId		礼品ID
	 * @param startTime		规则生效开始时间
	 * @param endTime		规则生效结束时间
	 * @throws Exception
	 */
	public String createPermissionWareRlt(long permissionId,long wareId,String startTime,String endTime ,long staffId,String comType,long orgId)throws Exception;
	
	/**
	 * 更新礼品与优惠规则的绑定关系
	 * @param permissionId  优惠规则的ID
	 * @param wareId		礼品ID
	 * @param startTime		规则生效开始时间
	 * @param endTime		规则生效结束时间
	 * @param wareBindRuleRltId 优惠规则绑定关系的ID
	 * @throws Exception
	 */
	public String updatePermissionWareRlt(long permissionId,long wareId,String startTime,String endTime,long wareBindRuleRltId ,long staffId,String comType,long orgId)throws Exception;
	
	/**
	 * 根据规则ID，获得优惠规则的基本信息
	 * @param permissionId 优惠规则的ID
	 * @return
	 * @throws Exception
	 */
	public IPermissionInfoValue getPermissionInfoValueById(long permissionId)throws Exception;
	
	
	/**
	 * 根据ID，和TypeCode 获得需要的信息
	 * @param permissionId
	 * @param typeCode
	 * @return
	 * @throws Exception
	 */
	public IPermissionTypeInfoValue [] getPermissionTypeInfoValuesById(long permissionId , String typeCode)throws Exception;
	
	/**
	 * 解除绑定关系
	 * @param wareBindRultRltId
	 * @throws Exception
	 */
	public String unBindPermissionWareRlt(long wareBindRultRltId ,long staffId,String comType,long orgId)throws Exception;
	
	public boolean isRuleBindingWare(long ruleId) throws Exception;
	
	public IQBOPermissionRuleRltValue [] queryQBOPermissionRuleRlt(long permissionId) throws Exception;
	
	public int getPermissionRuleCount(String permissionName, String wareGMEValue,
			String exchangeChannel, String mobileBrandCode, String itemScope,String orderStatus,String orderScope) throws Exception;
	
}
