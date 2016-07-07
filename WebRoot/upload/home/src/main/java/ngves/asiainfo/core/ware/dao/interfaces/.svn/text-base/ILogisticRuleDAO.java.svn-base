package ngves.asiainfo.core.ware.dao.interfaces;

import java.util.List;
import java.util.Map;

import ngves.asiainfo.core.ware.ivalues.ILogisticRuleHouseRltValue;
import ngves.asiainfo.core.ware.ivalues.ILogisticRulePriceRangeValue;
import ngves.asiainfo.core.ware.ivalues.ILogisticRuleValue;
import ngves.asiainfo.core.ware.ivalues.IQBOLogisticRuleHouseInfoValue;

@SuppressWarnings("unchecked")
public interface ILogisticRuleDAO {
	
	public ILogisticRuleValue[] getRuleInfo(String condition,Map parameter,int startNum,int endNum) throws Exception;
	
	public int getRuleInfo(String condition,Map parameter) throws Exception;
	
	public ILogisticRuleValue getLogisticsRulesById(String ruleId) throws Exception;
	
	public void saveLogisticsRulesInfo(ILogisticRuleValue logisticRuleValue) throws Exception;
	
	public ILogisticRulePriceRangeValue[] getLogisticRulePriceRangeByRuleId(String ruleId) throws Exception;
	
	public List<Object> queryLogisticRuleName(String ruleId) throws Exception;
	
	/**
	 * 根据物流费积分规则id查询绑定仓库
	 * @param ruleId
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public IQBOLogisticRuleHouseInfoValue[] queryWareHouses(String ruleId, int startNum, int endNum) throws Exception;
	
	public int queryWareHousesCount(String ruleId) throws Exception;
	
	/**
	 * 根据物流规则id，查询出生效的已绑定的仓库信息
	 * @param ruleId
	 * @return
	 * @throws Exception
	 */
	public ILogisticRuleHouseRltValue[] getLogisticRuleHouserRltInfo(String ruleId) throws Exception;
	
	/**
	 * 保存物流费积分规则
	 * @param rules
	 * @param ruleDetailsPriceRange
	 * @return
	 * @throws Exception
	 */
	public String saveLogisticRule(ILogisticRuleValue[] rules, ILogisticRulePriceRangeValue[] ruleDetailsPriceRange,long StaffId,String ComType,long OrgId) throws Exception;
	
	/**
	 * 最大物流费积分值（仓储费+配送费） 和 最小物流费积分值<br>  
	 * 	仓储费取值规则：取仓库结算价*最高系数。最高系数 =1.5。<br>  
	 *      配送费取值规则：取客户选择的三级配送地址，配送商配送结算价的最高值 <br>  
	 * @return
	 * @throws Exception
	 */
	public ILogisticRulePriceRangeValue getSumMaxLogisticPrice() throws Exception;

	/**
	 * 根据仓库id,获得想对应关系的物流积分规则
	 * @param wareHouseId
	 * @return
	 * @throws Exception
	 */
	public ILogisticRuleHouseRltValue[] queryRuleHouseRltInfo(String wareHouseId) throws Exception;
	
	/**
	 * 查询物流规则列表
	 * @param ruleName
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public ILogisticRuleValue[] queryLogisticRuleList() throws Exception;
	
	/**
	 * 保存仓库与物流费规则信息
	 * @param logisticRuleHouseRlt
	 * @throws Exception
	 */
	public void saveRuleHouseRltInfo(ILogisticRuleHouseRltValue logisticRuleHouseRlt,long StaffId,String ComType,long OrgId) throws Exception;
	
	/**
	 * 计算绑定物流费积分规则仓库的积分值 ，同步到Logistic_Integral_Info<br>  
	 * type : <br>
	 * 		  1,仓库信息包装费保存，传入一个wareHouseId<br>  
	 *        2,仓库绑定配送商，传入一个wareHouseId<br>  
	 *        3,仓库绑定物流费规则，传入一个wareHouseId<br>  
	 *        4,配送价发生变化，传入多个wareHouseId,一个partnerId <br>   
	 */
	public void operateLogisticIntegral(Map<String,String> map,String type,long StaffId,String ComType,long OrgId) throws Exception ;
//	public void operateLogisticIntegral(Map<String, String> parameter) throws Exception;
	/**
	 * 根据sql 语句查询，校验是否有不符合物流费的规则，如果有，则返回true
	 */
	public ILogisticRulePriceRangeValue[] checkRulePriceFee(String packageFeeBusiIds,String sendPriceBusiIds) throws Exception;
	
	/**
	 * 更新物流费价格区间，根据包装费，和配送价
	 * @param packageFee
	 * @param sendPrice
	 * @throws Exception
	 */
	public void updateRuleRangePrice(String packageFee,String sendPrice,long StaffId,String ComType,long OrgId) throws Exception;
	
	/**
	 * 获取没有绑定规则的仓库id信息
	 * @return
	 * @throws Exception
	 */
	public ILogisticRuleHouseRltValue[] getRultHousesRltNotExists() throws Exception;
}
