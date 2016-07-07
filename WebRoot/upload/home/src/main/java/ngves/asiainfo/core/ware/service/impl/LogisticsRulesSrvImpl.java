package ngves.asiainfo.core.ware.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.common.bo.BusiInfoEngine;
import ngves.asiainfo.core.common.util.BusiInfoUtil;
import ngves.asiainfo.core.ware.WareConstant;
import ngves.asiainfo.core.ware.dao.interfaces.ILogisticRuleDAO;
import ngves.asiainfo.core.ware.ivalues.ILogisticRuleHouseRltValue;
import ngves.asiainfo.core.ware.ivalues.ILogisticRulePriceRangeValue;
import ngves.asiainfo.core.ware.ivalues.ILogisticRuleValue;
import ngves.asiainfo.core.ware.ivalues.IQBOLogisticRuleHouseInfoValue;
import ngves.asiainfo.core.ware.service.interfaces.ILogisticsRulesSrv;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogisticsRulesSrvImpl implements ILogisticsRulesSrv {
	
	private static Log logger = LogFactory.getLog(LogisticsRulesSrvImpl.class);
	
	public ILogisticRuleDAO logisticRuleDAO;

	public ILogisticRuleDAO getLogisticRuleDAO() {
		return logisticRuleDAO;
	}

	public void setLogisticRuleDAO(ILogisticRuleDAO logisticRuleDAO) {
		this.logisticRuleDAO = logisticRuleDAO;
	}

	@SuppressWarnings("unchecked")
	public ILogisticRuleValue[] getRuleInfoList(String ruleName, int startNum, int endNum) throws Exception {
		logger.info("the getRuleInfoList's ruleName is" + ruleName);
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map parameter = new HashMap();
		if (!StringUtil.isBlank(ruleName)) {
			condition.append(" AND ").append(ILogisticRuleValue.S_RuleName).append(" LIKE :").append(ILogisticRuleValue.S_RuleName);
			parameter.put(ILogisticRuleValue.S_RuleName, "%"+ruleName+"%");
		}
		condition.append(" AND RULE_STATE = " + WareConstant.LOGISTICS_RULES_STATUS_ON + " ORDER BY CREATE_TIME ");
		
		ILogisticRuleValue[] value = logisticRuleDAO.getRuleInfo(condition.toString(), parameter, startNum, endNum);
		return fillHTMLOperationField(value);
	}

	@SuppressWarnings("unchecked")
	public int getRuleInfoListCount(String ruleName) throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map parameter = new HashMap();
		if (!StringUtil.isBlank(ruleName)) {
			condition.append(" AND ").append(ILogisticRuleValue.S_RuleName).append(" LIKE :").append(ILogisticRuleValue.S_RuleName);
			parameter.put(ILogisticRuleValue.S_RuleName, "%"+ruleName+"%");
		}
		condition.append(" AND RULE_STATE = " + WareConstant.LOGISTICS_RULES_STATUS_ON );
		
		int num = logisticRuleDAO.getRuleInfo(condition.toString(), parameter);
		return num;
	}
	
	/**
	 * 填充操作区域的html代码
	 * @param values
	 * @return
	 * @throws Exception 
	 */
	private ILogisticRuleValue[] fillHTMLOperationField(ILogisticRuleValue[] values) throws Exception {
		for (ILogisticRuleValue value : values) {
			//默认规则不能被删除
			if(WareConstant.LOGISTICS_RULE_DEFAULT_ID.equals(value.getRuleId()+"")){
				value.setOper("<a href=\"#\" onclick=\"javascript:indexControl('EDIT','" + value.getRuleId()
						+ "')\">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"#\" onclick=\"javascript:indexControl('SEEMORE','" + value.getRuleId()
						+ "')\">查看绑定仓库</a>");
			}else{
				value.setOper("<a href=\"#\" onclick=\"javascript:indexControl('EDIT','" + value.getRuleId() + "')\">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;" 
						+ "<a href=\"#\" onclick=\"javascript:indexControl('DELETE','" + value.getRuleId() + "')\">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;" 
						+ "<a href=\"#\" onclick=\"javascript:indexControl('SEEMORE','" + value.getRuleId()	+ "')\">查看绑定仓库</a>");
			}
		}
		return values;
	}
	
	public void delLogisticsRulesInfo(String ruleId,long StaffId,String ComType,long OrgId) throws Exception {
		
		if(WareConstant.LOGISTICS_RULE_DEFAULT_ID.equals(ruleId)){
			throw new Exception("DEFAULT_NOT_DELETE");
		}
		ILogisticRuleValue logisticRuleValue = this.logisticRuleDAO.getLogisticsRulesById(ruleId);
		long busiInfoId = BusiInfoEngine.getNewId().longValue();
		BusiInfoUtil.recordBusiInfo(busiInfoId + "", CoreConstant.SYS_PARA_BUSI_TYPE_LOGISTICTRULE_DELETE, -1,
                "删除物流费积分规则",CoreConstant.BUSI_INFO_OPT_TYPE_DELETE,"规则ID："+logisticRuleValue.getRuleId()+";规则名称："+logisticRuleValue.getRuleName(),StaffId,ComType,OrgId);
		if(logisticRuleValue != null){
			logisticRuleValue.setRuleState(WareConstant.LOGISTICS_RULES_STATUS_OFF);//代表已删除 
		}
		//logisticRuleValue.delete();
		this.logisticRuleDAO.saveLogisticsRulesInfo(logisticRuleValue);
	}
	
	public boolean isDeleteRule(String ruleId) throws Exception{
		if(WareConstant.LOGISTICS_RULE_DEFAULT_ID.equals(ruleId)){
			return false;
		}
		ILogisticRuleHouseRltValue[] logisticRuleHouseRltValue = logisticRuleDAO.getLogisticRuleHouserRltInfo(ruleId);
		if(logisticRuleHouseRltValue==null || logisticRuleHouseRltValue.length == 0 || logisticRuleHouseRltValue[0].getRltId() == 0){//没有绑定仓库，返回true，代表可以进行删除操作
			return true;
		}else{
			return false;
		}
	}
	
	public ILogisticRulePriceRangeValue[] getRangeInfoListByRuleId(String ruleId) throws Exception{
		return logisticRuleDAO.getLogisticRulePriceRangeByRuleId(ruleId);
	}
	
	public ILogisticRuleValue getRuleInfoByRuleId(String ruleId) throws Exception{
		return logisticRuleDAO.getLogisticsRulesById(ruleId);
	}

	public List<Object> queryLogisticRuleName(String ruleId) throws Exception{
		return logisticRuleDAO.queryLogisticRuleName(ruleId);
	}
	
	/**
	 * 根据物流费积分规则id查询绑定仓库信息
	 * @param ruleId
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public IQBOLogisticRuleHouseInfoValue[] queryWareHouses(String ruleId, int startNum, int endNum) throws Exception{
		return logisticRuleDAO.queryWareHouses(ruleId, startNum, endNum);
	}
	
	public int countWareHouses(String ruleId) throws Exception{
		return logisticRuleDAO.queryWareHousesCount(ruleId);
	}
	
	public String saveLogisticRule(ILogisticRuleValue[] rules, ILogisticRulePriceRangeValue[] ruleDetailsPriceRange,long StaffId,String ComType,long OrgId) throws Exception{
		ILogisticRulePriceRangeValue rangeValue = logisticRuleDAO.getSumMaxLogisticPrice();//获取物流费  = 仓储费+配送费  = 仓库结算价*最高系数（1.5）+ 配送商配送结算价的最高值
		String ruleId = "";
		String houseIds = "";
		if(rangeValue != null){
			//阶梯价格的区间值必须得覆盖数据库中所有的 物流费 ，才能进行保存
			logger.info("物流费积分规则 saveLogisticRule 获取物流费 min price ＝＝＝" + rangeValue.getBeginAmount());
			logger.info("物流费积分规则 saveLogisticRule 获取物流费 max price ＝＝＝" + rangeValue.getEndAmount());
			boolean minflag = false,maxflag = false;
			for(ILogisticRulePriceRangeValue value : ruleDetailsPriceRange){
				if(value.isDeleted()){//因为在修改时，会删除数据价格区间，这条数据不做校验
					continue;
				}
				if(value.getBeginAmount() <= rangeValue.getBeginAmount() ){
					minflag = true;
					break;
				}
			}
			for(ILogisticRulePriceRangeValue value : ruleDetailsPriceRange){
				if(value.isDeleted()){//因为在修改时，会删除数据价格区间，这条数据不做校验
					continue;
				}
				if(value.getEndAmount() > rangeValue.getEndAmount()){
					maxflag = true;
					break;
				}
			}
			if(maxflag && minflag){
				ruleId = logisticRuleDAO.saveLogisticRule(rules,ruleDetailsPriceRange, StaffId, ComType, OrgId);
			}else{
				throw new Exception("priceRange data error");
			}
		}else{
			ruleId = logisticRuleDAO.saveLogisticRule(rules,ruleDetailsPriceRange, StaffId, ComType, OrgId);
		}
		if(!StringUtil.isBlank(ruleId)){
			ILogisticRuleHouseRltValue[] logisticRuleHouseRltValue = logisticRuleDAO.getLogisticRuleHouserRltInfo(ruleId);
			houseIds = "";
			for(ILogisticRuleHouseRltValue value : logisticRuleHouseRltValue){
				houseIds += value.getWarehouseId()+",";
			}
			
			if(WareConstant.LOGISTICS_RULE_DEFAULT_ID.equals(ruleId)){//如果默认规则，需要修改没有绑定的仓库的物流规则积分值
				logisticRuleHouseRltValue = logisticRuleDAO.getRultHousesRltNotExists();
				for(ILogisticRuleHouseRltValue value : logisticRuleHouseRltValue){
					houseIds += value.getWarehouseId()+",";
				}
			}
			if(houseIds.length()>0){
				houseIds = houseIds.substring(0, houseIds.length()-1);
			}
			if(!StringUtil.isBlank(houseIds)){
				//6代表 物流费积分规则修改，触发物流费积分规则重新计算
				operateLogisticIntegral(houseIds,ruleId,WareConstant.LOGISTICS_RULES_OPERATE_TYPE6, StaffId, ComType, OrgId);
			}
		}
		return ruleId;
	}
	
	/**
	 * 根据仓库id,获得想对应关系的物流积分规则
	 * @param wareHouseId
	 * @return
	 * @throws Exception
	 */
	public ILogisticRuleHouseRltValue queryRuleHouseRltInfo(String wareHouseId) throws Exception{
		ILogisticRuleHouseRltValue[] value = logisticRuleDAO.queryRuleHouseRltInfo(wareHouseId);
		if(value != null && value.length > 0)
			return value[0];
		else 
			return null;
	}
	
	/**
	 * 查询物流规则列表
	 * @return
	 * @throws Exception
	 */
	public ILogisticRuleValue[] queryRuleInfoList() throws Exception{
		return logisticRuleDAO.queryLogisticRuleList();
	}
	
	public void saveRuleHouseRltInfo(ILogisticRuleHouseRltValue logisticRuleHouseRlt,long StaffId,String ComType,long OrgId) throws Exception{
		logisticRuleDAO.saveRuleHouseRltInfo(logisticRuleHouseRlt, StaffId, ComType, OrgId);
		//4代表 仓库绑定规则，触发物流费积分规则重新计算
		operateLogisticIntegral(logisticRuleHouseRlt.getWarehouseId()+"",logisticRuleHouseRlt.getRuleId()+"",WareConstant.LOGISTICS_RULES_OPERATE_TYPE4, StaffId, ComType, OrgId);
	}

	/**
	 * 此操作 仓库绑定规则，触发物流费积分规则重新计算
	 * @param wareHouseId
	 * @param ruleId
	 * @throws Exception
	 */
	public void operateLogisticIntegral(String wareHouseId,String ruleId,String type,long StaffId,String ComType,long OrgId) throws Exception{
		HashMap<String, String> parameter = new HashMap<String, String>();
		parameter.put("wareHouseIds", wareHouseId);
		parameter.put("ruleId", ruleId);
		logisticRuleDAO.operateLogisticIntegral(parameter,type, StaffId, ComType, OrgId);
	}
	
	public ILogisticRulePriceRangeValue[] checkRulePriceFee(String packageFeeBusiIds,String sendPriceBusiIds) throws Exception{
		ILogisticRulePriceRangeValue[] values = logisticRuleDAO.checkRulePriceFee(packageFeeBusiIds,sendPriceBusiIds);
		if(values != null && values.length > 0 && values[0].getRangeId() != 0 ){
			return values;
		}else{
			return null;
		}
	}

}
