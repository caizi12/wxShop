/**
 * 
 */
package ngves.asiainfo.core.ware.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.ware.ivalues.IPermissionInfoValue;
import ngves.asiainfo.core.ware.ivalues.IPermissionRuleRltValue;
import ngves.asiainfo.core.ware.ivalues.IPermissionTypeInfoValue;
import ngves.asiainfo.core.ware.ivalues.IQBOPermissionInfoValue;
import ngves.asiainfo.core.ware.ivalues.IQBOPermissionRuleRltValue;
import ngves.asiainfo.core.ware.ivalues.IQBOPermissionWareRltValue;

/**
 * @author asiainfo
 *
 */
public interface IWarePermissionInfoDAO {

	/**
	 * 保存积分优惠兑换资格校验基本信息
	 * @param values  对象数组
	 * @throws Exception
	 */
	public void savePermissionInfoValue(IPermissionInfoValue [] values)throws Exception;
	
	public void  mixPayBind(String permissionId,String wareid) throws Exception;
	
	/**
	 * 保存积分优惠兑换资格校验基本信息
	 * @param value 单个对象
	 * @throws Exception
	 */
	public long savePermissionInfoValue(IPermissionInfoValue  value)throws Exception;
	
	/**
	 * 根据ID获得积分优惠兑换资格校验基本信息
	 * @param permissionId
	 * @return
	 * @throws Exception
	 */
	public IPermissionInfoValue getPermissionInfoById(long permissionId)throws Exception;
	
	
	/**
	 * 根据查询条件获得积分优惠兑换资格校验基本信息
	 * @param condition
	 * @param parameters
	 * @return
	 * @throws Exception
	 */
	public IPermissionInfoValue[] getPermissionInfoValues(String condition,Map<String,String> parameters) throws Exception;
	
	/**
	 * 保存积分优惠兑换资格校验的类别信息
	 * @param values
	 * @throws Exception
	 */
	public void savePermissionTypeInfo(IPermissionTypeInfoValue [] values)throws Exception;
	
	/**
	 * 保存积分优惠兑换资格校验的类别信息
	 * @param values
	 * @throws Exception
	 */
	public void savePermissionTypeInfo(IPermissionTypeInfoValue value)throws Exception;
	
	/**
	 * 保存礼品与积分优惠兑换资格规则的绑定信息
	 * @param values
	 * @throws Exception
	 */
	public void saveWarePermissionRltValue(IPermissionRuleRltValue []values) throws Exception;
	
	/**
	 * 保存礼品与积分优惠兑换资格规则的绑定信息
	 * @param values
	 * @throws Exception
	 */
	public void saveWarePermissionRltValue(IPermissionRuleRltValue values) throws Exception;
	
	/**
	 * 查询礼品与积分优惠兑换资格规则的绑定信息
	 * @param condition
	 * @param parameters
	 * @return
	 * @throws Exception
	 */
	public IPermissionRuleRltValue[] getWarePermissionRltValues(String condition,Map<String,String> parameters)throws Exception;
	
	/**
	 * 查询礼品校验规则表信息
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public IPermissionTypeInfoValue[] getWarePermissionTypeValues(String condition,Map<String,String> parameter)throws Exception;

	public int getPermissionRuleCount(String condition, Map<String, String> parameter) throws Exception;
	/**
	 * @param string
	 * @param parameter
	 * @return
	 * @throws Exception 
	 */
	public IQBOPermissionInfoValue[] getPermissionRule(String string, Map<String, String> parameter, int startNum, int endNum) throws Exception;
	
	
	/**
	 * 根据规则ID，获得该规则下面，礼品规则校验表的信息
	 * @param permissionId
	 * @return
	 * @throws Exception
	 */
	public IPermissionTypeInfoValue[] getWarePermissionTypeValuesById(long permissionId)throws Exception;
	
	/**
	 * 查询优惠兑换资格配置页面的基本信息
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public IQBOPermissionInfoValue [] getQBOPermissionInfoValues(String condition,Map<String,String> parameter,int startIndex,int endIndex)throws Exception;
	
	
	/**
	 * 查询优惠规则与礼品的绑定信息
	 * @param condition
	 * @param parameter
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IQBOPermissionWareRltValue [] getQBOPermissionWareRltValues(String condition,Map<String,String> parameter,int startIndex,int endIndex)throws Exception;
	
	
	/**
	 * 查询优惠规则和礼品的绑定规则的数量信息
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public int getQBOPermissionWareRltCount(String condition,Map<String,String> parameter)throws Exception;
	
	
	/**
	 * 根据ID获得礼品与优惠规则的关系
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public IPermissionRuleRltValue getPermissionRuleRltValue(long id) throws Exception;

	/**
	 * @param string
	 * @param parameters
	 * @return
	 * @throws Exception 
	 */
	public IQBOPermissionRuleRltValue[] queryQBOPermissionRuleRlt(String string, Map<String, String> parameters) throws Exception;


}
