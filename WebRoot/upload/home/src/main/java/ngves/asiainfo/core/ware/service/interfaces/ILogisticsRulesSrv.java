package ngves.asiainfo.core.ware.service.interfaces;

import java.util.List;

import ngves.asiainfo.core.ware.dao.interfaces.ILogisticRuleDAO;
import ngves.asiainfo.core.ware.ivalues.ILogisticRuleHouseRltValue;
import ngves.asiainfo.core.ware.ivalues.ILogisticRulePriceRangeValue;
import ngves.asiainfo.core.ware.ivalues.ILogisticRuleValue;
import ngves.asiainfo.core.ware.ivalues.IQBOLogisticRuleHouseInfoValue;

public interface ILogisticsRulesSrv {
	
	/**
	 * 根据规则名称查询物流规则列表
	 * @param ruleName
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public ILogisticRuleValue[] getRuleInfoList(String ruleName,int startNum, int endNum) throws Exception;
	
	/**
	 * 返回规则列表数量
	 * @param ruleName
	 * @return 
	 */
	public int getRuleInfoListCount(String ruleName) throws Exception;
	
	/**
	 * 根据规则id查询相对应的规则信息
	 * @param ruleId
	 * @return
	 * @throws Exception
	 */
	public ILogisticRuleValue getRuleInfoByRuleId(String ruleId) throws Exception;
	
	public void setLogisticRuleDAO(ILogisticRuleDAO logisticRuleDAO);
	
	/**
	 * 根据规则id删除物流规格
	 * @param ruleId
	 * @throws Exception
	 */
	public void delLogisticsRulesInfo(String ruleId,long StaffId,String ComType,long OrgId) throws Exception;
	
	/**
	 * 校验是否绑定仓库，如果绑定仓库，不能删除规则
	 * @param ruleId
	 * @return
	 * @throws Exception
	 */
	public boolean isDeleteRule(String ruleId) throws Exception;
	
	/**
	 * 根据规则id获得相对应的价格区间信息
	 * @param ruleId
	 * @return
	 * @throws Exception
	 */
	public ILogisticRulePriceRangeValue[] getRangeInfoListByRuleId(String ruleId) throws Exception;
	
	/**
	 * 查询物流费积分规则名称列表
	 * @return
	 * @throws Exception
	 */
	public List<Object> queryLogisticRuleName(String ruleId) throws Exception;
	
	/**
	 * 根据物流费积分规则id查询绑定仓库信息
	 * @param ruleId
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public IQBOLogisticRuleHouseInfoValue[] queryWareHouses(String ruleId, int startNum, int endNum) throws Exception;
	
	public int countWareHouses(String ruleId) throws Exception;
	
	/**
	 * 保存物流费规则信息以及区间价格
	 * @param rules
	 * @param ruleDetailsPriceRange
	 * @return
	 * @throws Exception 
	 */
	public String saveLogisticRule(ILogisticRuleValue[] rules, ILogisticRulePriceRangeValue[] ruleDetailsPriceRange,long StaffId,String ComType,long OrgId) throws Exception;
	
	/**
	 * 根据仓库id,获得想对应关系的物流积分规则
	 * @param wareHouseId
	 * @return
	 * @throws Exception
	 */
	public ILogisticRuleHouseRltValue queryRuleHouseRltInfo(String wareHouseId) throws Exception;
	
	/**
	 * 查询物流规则列表
	 * @param ruleName
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public ILogisticRuleValue[] queryRuleInfoList() throws Exception; 
	
	/**
	 * 保存仓库与物流费规则信息
	 * @param logisticRuleHouseRlt
	 * @throws Exception
	 */
	public void saveRuleHouseRltInfo(ILogisticRuleHouseRltValue logisticRuleHouseRlt,long StaffId,String ComType,long OrgId) throws Exception;
	
	/**
	 * 校验，传入的包装费或配送费是否超过物流费积分规则的价格区间
	 * @param packageFee
	 * @param sendPricess
	 * @return
	 * @throws Exception
	 */
	public ILogisticRulePriceRangeValue[] checkRulePriceFee(String packageFeeBusiIds,String sendPriceBusiIds) throws Exception;
	
}
