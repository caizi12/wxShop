package ngves.asiainfo.core.ware.dao.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.common.bo.BaseInfoSynBean;
import ngves.asiainfo.core.common.bo.BaseInfoSynEngine;
import ngves.asiainfo.core.common.bo.BusiInfoEngine;
import ngves.asiainfo.core.common.bo.SendPriceInfoEngine;
import ngves.asiainfo.core.common.ivalues.IBaseInfoSynValue;
import ngves.asiainfo.core.common.ivalues.ISendPriceInfoValue;
import ngves.asiainfo.core.common.model.SysPara;
import ngves.asiainfo.core.common.util.BusiInfoUtil;
import ngves.asiainfo.core.ware.WareConstant;
import ngves.asiainfo.core.ware.bo.LogisticIntegralOperatePlanBean;
import ngves.asiainfo.core.ware.bo.LogisticIntegralOperatePlanEngine;
import ngves.asiainfo.core.ware.bo.LogisticRuleBean;
import ngves.asiainfo.core.ware.bo.LogisticRuleEngine;
import ngves.asiainfo.core.ware.bo.LogisticRuleHouseRltBean;
import ngves.asiainfo.core.ware.bo.LogisticRuleHouseRltEngine;
import ngves.asiainfo.core.ware.bo.LogisticRulePriceRangeBean;
import ngves.asiainfo.core.ware.bo.LogisticRulePriceRangeEngine;
import ngves.asiainfo.core.ware.bo.QBOLogisticRuleHouseInfoEngine;
import ngves.asiainfo.core.ware.dao.interfaces.ILogisticRuleDAO;
import ngves.asiainfo.core.ware.ivalues.ILogisticIntegralOperatePlanValue;
import ngves.asiainfo.core.ware.ivalues.ILogisticRuleHouseRltValue;
import ngves.asiainfo.core.ware.ivalues.ILogisticRulePriceRangeValue;
import ngves.asiainfo.core.ware.ivalues.ILogisticRuleValue;
import ngves.asiainfo.core.ware.ivalues.IQBOLogisticRuleHouseInfoValue;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.util.criteria.Criteria;

@SuppressWarnings("unchecked")
public class LogisticRuleDAOImpl implements ILogisticRuleDAO {
	private static Log logger = LogFactory.getLog(LogisticRuleDAOImpl.class);

	public ILogisticRuleValue[] getRuleInfo(String condition, Map parameter, int startNum, int endNum) throws Exception {
		return LogisticRuleEngine.getBeans(null, condition, parameter,
				startNum, endNum, false);
	}

	public int getRuleInfo(String condition, Map parameter) throws Exception {
		return LogisticRuleEngine.getBeansCount(condition,parameter);
	}

	public ILogisticRuleValue getLogisticsRulesById(String ruleId) throws Exception {
		if (!StringUtil.isBlank(ruleId)) {
			return LogisticRuleEngine.getBean(Long.parseLong(ruleId));
		} else {
			return null;
		}
	}

	public void saveLogisticsRulesInfo(ILogisticRuleValue value) throws Exception {
		if (value.isNew()) {
			if(StringUtil.isBlank((value.getRuleId()+""))){
				value.setRuleId(LogisticRuleEngine.getNewId().longValue());
			}
		}
		LogisticRuleEngine.save(value);
	}

	public ILogisticRulePriceRangeValue[] getLogisticRulePriceRangeByRuleId(String ruleId) throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
    	HashMap<String, String> parameter = new HashMap<String, String>();
    	boolean isInsert = StringUtil.isBlank(ruleId);

    	if(isInsert){// 初始值时，和默认规则的阶梯价一样
    		// 默认积分换算规则id 是 -1
    		ruleId = WareConstant.LOGISTICS_RULE_DEFAULT_ID;
    	}
    	condition.append(" and ").append(ILogisticRulePriceRangeValue.S_RuleId).append(" in ( ")
    			 .append(ruleId).append(" ) ");
        condition.append(" order by  " + ILogisticRulePriceRangeValue.S_BeginAmount + " ASC ");
		//parameter.put(ILogisticRulePriceRangeValue.S_RuleId, ruleId+"");

		ILogisticRulePriceRangeValue[] detailValues = LogisticRulePriceRangeEngine.getBeans(condition.toString(),parameter);
        if(isInsert){//为了以后保存时，不去覆盖默认规则。而是新增一个新的规则。
            for(ILogisticRulePriceRangeValue value:detailValues){
                value.setRangeId(0);
                value.setRuleId(0);
            }
        }
    	return detailValues;
	}
	
	public List<Object> queryLogisticRuleName(String ruleId) throws Exception {
		LogisticRuleBean[] b = LogisticRuleEngine.getBeansFromSql("select rule_id, rule_name from logistic_rule where rule_state = 1 and rule_id = " + ruleId, null);
		ArrayList<Object> list = new ArrayList<Object>();
		SysPara sp = null;
		for (int i = 0; i < b.length; i++) {
			sp = new SysPara();
			sp.setText(b[i].getRuleName());
			sp.setValue(String.valueOf(b[i].getRuleId()));
			list.add(sp);
			sp = null;
		}
		return list;
	}
	
	public IQBOLogisticRuleHouseInfoValue[] queryWareHouses(String ruleId, int startNum, int endNum) throws Exception{
		StringBuffer condition = new StringBuffer(" 1=1 ");
    	HashMap<String, String> parameter = new HashMap<String, String>();
    	condition.append(" and ").append(IQBOLogisticRuleHouseInfoValue.S_RuleId).append(" = :").append(IQBOLogisticRuleHouseInfoValue.S_RuleId)
    		.append(" ORDER BY ").append(IQBOLogisticRuleHouseInfoValue.S_WarehouseId);
    	parameter.put(IQBOLogisticRuleHouseInfoValue.S_RuleId, ruleId+"");
		return QBOLogisticRuleHouseInfoEngine.getBeans(null, condition.toString(), parameter,
				startNum, endNum, false);
	}
	
	public int queryWareHousesCount(String ruleId) throws Exception{
		StringBuffer condition = new StringBuffer(" 1=1 ");
    	HashMap<String, String> parameter = new HashMap<String, String>();
    	condition.append(" and ").append(IQBOLogisticRuleHouseInfoValue.S_RuleId).append(" = :").append(IQBOLogisticRuleHouseInfoValue.S_RuleId);
    	parameter.put(IQBOLogisticRuleHouseInfoValue.S_RuleId, ruleId+"");
		return QBOLogisticRuleHouseInfoEngine.getBeansCount(condition.toString(),parameter);
	}
	
	public ILogisticRuleHouseRltValue[] getLogisticRuleHouserRltInfo(String ruleId) throws Exception{
		StringBuffer condition = new StringBuffer(" 1=1 ");
    	HashMap<String, String> parameter = new HashMap<String, String>();
    	condition.append(" and ").append(ILogisticRuleHouseRltValue.S_RuleId).append(" = :").append(ILogisticRuleHouseRltValue.S_RuleId);
    	parameter.put(ILogisticRuleHouseRltValue.S_RuleId, ruleId);
    	condition.append(" and ").append(ILogisticRuleHouseRltValue.S_ValidFlag).append(" = :").append(ILogisticRuleHouseRltValue.S_ValidFlag);
    	parameter.put(ILogisticRuleHouseRltValue.S_ValidFlag, WareConstant.LOGISTICS_RULES_STATUS_ON);
    	return LogisticRuleHouseRltEngine.getBeans(condition.toString(), parameter);
	}
	
	public String saveLogisticRule(ILogisticRuleValue[] rules, ILogisticRulePriceRangeValue[] ruleDetailsPriceRange,long StaffId,String ComType,long OrgId) throws Exception{
        long busiInfoId = BusiInfoEngine.getNewId().longValue();
        String ruleId = "";
        if(rules!=null){
        	ruleId = modifyConvertRule(busiInfoId,rules, StaffId, ComType, OrgId);
        }
        logger.info("save logistic rule , ruleId == " + ruleId);
        if(ruleDetailsPriceRange!=null){
        	if(!StringUtil.isBlank(ruleId)){
        		for (int i = 0; i < ruleDetailsPriceRange.length; i++) {
        			ruleDetailsPriceRange[i].setRuleId(Long.parseLong(ruleId));
        		}
        	}
        	saveRuleDetailPriceRange(busiInfoId,ruleDetailsPriceRange);
        }
        return ruleId;
	}
	public String modifyConvertRule(long busiInfoId, ILogisticRuleValue[] rules,long StaffId,String ComType,long OrgId) throws Exception {
    	for (int i = 0; i < rules.length; i++) {
			if(rules[i].isNew()){
                Criteria criteria = new Criteria();
                criteria.addEqual(ILogisticRuleValue.S_RuleState, "1");
                criteria.addEqual(ILogisticRuleValue.S_RuleName, rules[i].getRuleName());
                ILogisticRuleValue[] sameNamedRules = LogisticRuleEngine.getBeans(criteria);
                if(sameNamedRules.length > 0){
                    throw new Exception("NameDuplicate");
                }
                ILogisticRuleValue logisticRuleValue=new LogisticRuleBean();
                logisticRuleValue.setRuleId(LogisticRuleEngine.getNewId().longValue());
				rules[i].setRuleId(logisticRuleValue.getRuleId());
				logisticRuleValue.setRuleName(rules[i].getRuleName());			
				logisticRuleValue.setRuleState(WareConstant.LOGISTICS_RULES_STATUS_ON);
				logisticRuleValue.setCreateTime(DateTimeUtil.getDefaultSysDate());
				logisticRuleValue.setModifyTime(DateTimeUtil.getDefaultSysDate());
				logisticRuleValue.setOper(SessionManager.getUser().getID()+"");
				LogisticRuleEngine.save(logisticRuleValue);
				BusiInfoUtil.recordBusiInfo(busiInfoId + "", CoreConstant.SYS_PARA_BUSI_TYPE_LOGISTICTRULE_ADD, -1,
			                "新增物流费积分规则",CoreConstant.BUSI_INFO_OPT_TYPE_ADD,"规则ID："+rules[i].getRuleId()+";规则名称："+rules[i].getRuleName(),StaffId,ComType,OrgId);
				ILogisticRuleValue oldBean = new LogisticRuleBean();
				oldBean.setRuleName("");			
				oldBean.setRuleState("");
				//无意义 只为在第一次新增时也能写进日志(1900-01-01 00:00:00代表初始时间)
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = format.parse("1900-01-01 00:00:00");
				oldBean.setCreateTime(new Timestamp(date.getTime()));
				oldBean.setModifyTime(new Timestamp(date.getTime()));
				oldBean.setOper("");
				BusiInfoUtil.recordBusiDetail(busiInfoId + "", new Object[]{oldBean}, new Object[]{logisticRuleValue}, "RuleId");
				
			}else if(rules[i].isModified()){
				ILogisticRuleValue logisticRuleValue=LogisticRuleEngine.getBean(rules[i].getRuleId());
				ILogisticRuleValue oldBean = new LogisticRuleBean();
				oldBean.copy(logisticRuleValue);
                if(rules[i].isPropertyModified(ILogisticRuleValue.S_RuleName)){
                    Criteria criteria = new Criteria();
                    criteria.addEqual(ILogisticRuleValue.S_RuleState, "1");
                    criteria.addEqual(ILogisticRuleValue.S_RuleName, rules[i].getRuleName());
                    ILogisticRuleValue[] sameNamedRules = LogisticRuleEngine.getBeans(criteria);
                    if(sameNamedRules.length > 0){
                        throw new Exception("NameDuplicate");
                    }
                }
                logisticRuleValue.setRuleName(rules[i].getRuleName());
                logisticRuleValue.setRuleState(WareConstant.LOGISTICS_RULES_STATUS_ON);
                logisticRuleValue.setModifyTime(DateTimeUtil.getDefaultSysDate());
				LogisticRuleEngine.save(logisticRuleValue);
				 BusiInfoUtil.recordBusiInfo(busiInfoId + "", CoreConstant.SYS_PARA_BUSI_TYPE_LOGISTICTRULE_MODIFY, -1,
			                "修改物流费积分规则",CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,"规则ID："+rules[i].getRuleId()+";规则名称："+rules[i].getRuleName(),StaffId,ComType,OrgId);
				
		        BusiInfoUtil.recordBusiDetail(busiInfoId + "", new Object[]{oldBean}, new Object[]{logisticRuleValue}, "RuleId");
				
			}else{
				BusiInfoUtil.recordBusiInfo(busiInfoId + "", CoreConstant.SYS_PARA_BUSI_TYPE_LOGISTICTRULE_MODIFY, -1,
		                "修改物流费积分规则",CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,"规则ID："+rules[i].getRuleId()+";规则名称："+rules[i].getRuleName(),StaffId,ComType,OrgId);
			}
		}
        return rules[0].getRuleId()+"";
    }
	
	public void saveRuleDetailPriceRange(long busiInfoId, ILogisticRulePriceRangeValue[] logisticRulePriceRangeValues) throws Exception {
		logger.info(" saveRuleDetailPriceRange logisticRulePriceRangeValues.length == " + logisticRulePriceRangeValues.length);
        for (int i = 0; i < logisticRulePriceRangeValues.length; i++) {
        	if (logisticRulePriceRangeValues[i].isDeleted()) {
        		ILogisticRulePriceRangeValue ruleDetailPriceRange = LogisticRulePriceRangeEngine.getBean(logisticRulePriceRangeValues[i].getRangeId());
        		ILogisticRulePriceRangeValue oldBean = new LogisticRulePriceRangeBean();
        		oldBean.copy(ruleDetailPriceRange);
                long ruleRangeId = ruleDetailPriceRange.getRangeId();
                ruleDetailPriceRange.delete();
                //0  用来标识该条记录是新增的记录。
                if(0 != ruleRangeId){
                	LogisticRulePriceRangeEngine.save(ruleDetailPriceRange);
                }
                ILogisticRulePriceRangeValue newBean = new LogisticRulePriceRangeBean();
                BusiInfoUtil.recordBusiDetail(busiInfoId + "", new Object[]{oldBean}, new Object[]{newBean}, "RangeId");
            }else if (logisticRulePriceRangeValues[i].isNew() || logisticRulePriceRangeValues[i].getRangeId() == 0) {
            	ILogisticRulePriceRangeValue logisticRuleRange = new LogisticRulePriceRangeBean();
            	ILogisticRulePriceRangeValue oldBean = new LogisticRulePriceRangeBean();
            	logisticRuleRange.setRangeId(LogisticRulePriceRangeEngine.getNewId().longValue());
            	logisticRuleRange.setRuleId(logisticRulePriceRangeValues[i].getRuleId());
            	logisticRuleRange.setBeginAmount(logisticRulePriceRangeValues[i].getBeginAmount());
            	logisticRuleRange.setEndAmount(logisticRulePriceRangeValues[i].getEndAmount());
            	logisticRuleRange.setRuleValue(logisticRulePriceRangeValues[i].getRuleValue());
                logisticRuleRange.setUpdateStaffId(SessionManager.getUser().getID());
                logisticRuleRange.setUpdateDate(DateTimeUtil.getDefaultSysDate());
                logisticRuleRange.setStsToNew();
                LogisticRulePriceRangeEngine.save(logisticRuleRange);
                BusiInfoUtil.recordBusiDetail(busiInfoId + "", new Object[]{oldBean}, new Object[]{logisticRuleRange}, "RangeId");
            } else if (logisticRulePriceRangeValues[i].isModified()) {
            	ILogisticRulePriceRangeValue ruleDetailPriceRange = LogisticRulePriceRangeEngine.getBean(logisticRulePriceRangeValues[i].getRangeId());
            	ILogisticRulePriceRangeValue oldBean = new LogisticRulePriceRangeBean();
            	oldBean.copy(ruleDetailPriceRange);
            	ruleDetailPriceRange.setRuleId(logisticRulePriceRangeValues[i].getRuleId());
            	ruleDetailPriceRange.setBeginAmount(logisticRulePriceRangeValues[i].getBeginAmount());
            	ruleDetailPriceRange.setEndAmount(logisticRulePriceRangeValues[i].getEndAmount());
            	ruleDetailPriceRange.setRuleValue(logisticRulePriceRangeValues[i].getRuleValue());
                ruleDetailPriceRange.setUpdateStaffId(SessionManager.getUser().getID());
                ruleDetailPriceRange.setUpdateDate(DateTimeUtil.getDefaultSysDate());
                LogisticRulePriceRangeEngine.save(ruleDetailPriceRange);
                BusiInfoUtil.recordBusiDetail(busiInfoId + "", new Object[]{oldBean}, new Object[]{ruleDetailPriceRange}, "RangeId");
            }

        }
    }
	
	/**
	 * 借用LogisticRulePriceRangeEngine 获取sql语句计算出来的 最大物流费（仓储费+配送费）和 最小物流费
	 * 	仓储费取值规则：取仓库结算价*最高系数。最高系数 =1.5。
     * 	配送费取值规则：取客户选择的三级配送地址，配送商配送结算价的最高值
	 */
	public ILogisticRulePriceRangeValue getSumMaxLogisticPrice() throws Exception{
		StringBuffer sqlBuf = new StringBuffer();		
		sqlBuf.append(" SELECT (S.MIN_SEND_PRICE + 1.5 * WI.MIN_PACKAGE_FEE) BEGIN_AMOUNT, ");
		sqlBuf.append(" (S.MAX_SEND_PRICE + 1.5 * WI.MAX_PACKAGE_FEE) END_AMOUNT ");
		sqlBuf.append(" FROM (SELECT NVL(MAX(SEND_PRICE),0) MAX_SEND_PRICE, NVL(MIN(SEND_PRICE),0) MIN_SEND_PRICE, '1' PRICE_ID FROM SEND_PRICE_INFO ) S, ");
	    sqlBuf.append(" (SELECT NVL(MAX(PACKAGE_FEE),0) MAX_PACKAGE_FEE, NVL(MIN(PACKAGE_FEE),0) MIN_PACKAGE_FEE, '1' PRICE_ID FROM WAREHOUSE_INFO WHERE warehouse_state = 1) WI ");
	    sqlBuf.append(" WHERE S.PRICE_ID = WI.PRICE_ID ");
	 
		ILogisticRulePriceRangeValue[] values = LogisticRulePriceRangeEngine.getBeansFromSql(sqlBuf.toString(), null);
	    if(values.length >= 0)
	    	return values[0];
	    else return null;
	}
	
	/**
	 * 根据仓库id,获得想对应关系的物流积分规则
	 * @param wareHouseId
	 * @return
	 * @throws Exception
	 */
	public ILogisticRuleHouseRltValue[] queryRuleHouseRltInfo(String wareHouseId) throws Exception{
		StringBuffer condition = new StringBuffer(" 1=1 ");
    	HashMap<String, String> parameter = new HashMap<String, String>();
    	condition.append(" and ").append(ILogisticRuleHouseRltValue.S_WarehouseId).append(" in ( ").append(wareHouseId).append(" ) ");
    	condition.append(" and ").append(ILogisticRuleHouseRltValue.S_ValidFlag).append(" = :").append(ILogisticRuleHouseRltValue.S_ValidFlag);
    	parameter.put(ILogisticRuleHouseRltValue.S_ValidFlag, WareConstant.LOGISTICS_RULES_STATUS_ON);
    	ILogisticRuleHouseRltValue[] value =  LogisticRuleHouseRltEngine.getBeans(condition.toString(), parameter);
    	if(value.length > 0)
    		return value;
    	else return null;

	}
	
	/**
	 * 查询物流规则列表
	 * @param ruleName
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public ILogisticRuleValue[] queryLogisticRuleList() throws Exception{
		StringBuffer condition = new StringBuffer(" 1=1 ");
		condition.append(" AND RULE_STATE = " + WareConstant.LOGISTICS_RULES_STATUS_ON + " ORDER BY CREATE_TIME ");
		return LogisticRuleEngine.getBeans(condition.toString(), null);
	}
	
	public void saveRuleHouseRltInfo(ILogisticRuleHouseRltValue value,long StaffId,String ComType,long OrgId) throws Exception{
		ILogisticRuleHouseRltValue oldBean = new LogisticRuleHouseRltBean();
		long busiInfoId = BusiInfoEngine.getNewId().longValue();
		value.setUpdateTime(DateTimeUtil.getDefaultSysDate());
		if (value.isNew()) {
			value.setRltId(LogisticRuleHouseRltEngine.getNewId().longValue());
			value.setValidFlag(WareConstant.LOGISTICS_RULES_STATUS_ON);
			LogisticRuleHouseRltEngine.save(value);
			oldBean.setValidFlag("");
			BusiInfoUtil.recordBusiInfo(busiInfoId + "", CoreConstant.SYS_PARA_BUSI_TYPE_LOGISTICTRULE_BUNDLING, -1,
	                "物流费积分规则绑定",CoreConstant.BUSI_INFO_OPT_TYPE_ADD,"规则ID："+value.getRuleId()+";仓库ID："+value.getWarehouseId(),StaffId,ComType,OrgId);
		}else{
			oldBean = LogisticRuleHouseRltEngine.getBean(value.getRltId());//获取旧的绑定关系
			LogisticRuleHouseRltEngine.save(value);//保存新的关系值
			BusiInfoUtil.recordBusiInfo(busiInfoId + "", CoreConstant.SYS_PARA_BUSI_TYPE_LOGISTICTRULE_BUNDLING, -1,
	                "物流费积分规则绑定",CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,"规则ID："+value.getRuleId()+";仓库ID："+value.getWarehouseId(),StaffId,ComType,OrgId);
		}
		BusiInfoUtil.recordBusiDetail(busiInfoId + "", new Object[]{oldBean}, new Object[]{value}, "LogisticRuleHouseRltId");
	}
	
	/**
	 * 计算绑定物流费积分规则仓库的积分值
	 * type : 1,仓库信息包装费保存，传入一个wareHouseId,并且需要同步hp接口（包装费发生变化，配送商绑定的仓库的积分值发生变化）
	 *        2,仓库绑定配送省，传入一个wareHouseId
	 *        3,仓库绑定配送商，传入一个wareHouseId 
	 *        4,仓库绑定物流费规则，传入一个wareHouseId,一个ruleId,并且需要同步hp接口（规则发生变化，配送商绑定的仓库的积分值发生变化）
	 *        5,配送价发生变化，传入多个wareHouseId,一个partnerId
	 *        6,物流费规则修改，出入多个wareHouseId,一个ruleId,并且需要同步hp接口（规则值发生变化，配送商绑定的仓库的积分值发生变化）
	 *        7,仓库删除配送商，传入一个wareHouseId
	 */
	
	public void operateLogisticIntegral(Map<String,String> map,String type,long StaffId,String ComType,long OrgId) throws Exception {
		String wareHouseIds = "";
		String partnerIds = "";
		String ruleId = "";
		if(!StringUtil.isBlank(map.get("wareHouseIds"))){
			wareHouseIds = map.get("wareHouseIds");
		}
		if(!StringUtil.isBlank(map.get("partnerId"))){
			partnerIds = map.get("partnerId");
		}
		if(!StringUtil.isBlank(map.get("ruleId"))){
			ruleId = map.get("ruleId");
		}
		
		String[] houseIds = wareHouseIds.split(",");
		
		List<ILogisticIntegralOperatePlanValue> list = new ArrayList<ILogisticIntegralOperatePlanValue>();
		ILogisticIntegralOperatePlanValue planValue = null;
		for(int i = 0;i<houseIds.length;i++){
			planValue = new LogisticIntegralOperatePlanBean();
			planValue.setOperatePlanId(LogisticIntegralOperatePlanEngine.getNewId().longValue());//借用物流规则的id
			planValue.setOperatePlanState(WareConstant.SYS_PLAN_STATE_WAIT);
			planValue.setOperatePlanType(type);
			if(!StringUtil.isBlank(houseIds[i]))
				planValue.setWarehouseId(Long.parseLong(houseIds[i]));
			if(!StringUtil.isBlank(ruleId))
				planValue.setRuleId(Long.parseLong(ruleId));
			if(!StringUtil.isBlank(partnerIds))
				planValue.setPartnerId(Long.parseLong(partnerIds));
			planValue.setCreateTime(DateTimeUtil.getNowTimeStamp());
			planValue.setStaffId(StaffId);
			planValue.setComType(ComType);
			list.add(planValue);
		}
		ILogisticIntegralOperatePlanValue[] planValues = new LogisticIntegralOperatePlanBean[list.size()];
		planValues = list.toArray(planValues);
		LogisticIntegralOperatePlanEngine.saveBatch(planValues);
		
		/*
		 *由于在配送价发生改变时，在配送审核时，已经同步信息，因此这里不需要再次同步
		 *进行hp同步，是以配送商为单位的，因此只要配送商关联的仓库的包装费和绑定的规则发生变化时，就要
		 *重新计算积分，同步给hp 
		 */
		ArrayList<Long> sendPriceSyn = new ArrayList<Long>();
		if(WareConstant.LOGISTICS_RULES_OPERATE_TYPE1.equals(type) || WareConstant.LOGISTICS_RULES_OPERATE_TYPE4.equals(type) ||
				WareConstant.LOGISTICS_RULES_OPERATE_TYPE6.equals(type)){
			ISendPriceInfoValue[] sendPriceInfoValues = getSendPriceInfoValueByHouseIds(map.get("wareHouseIds"));
			long partnerId = 0;
			if(sendPriceInfoValues != null && sendPriceInfoValues.length != 0){
				for(ISendPriceInfoValue sendValue : sendPriceInfoValues){
					if(sendValue.getPartnerId() != 0 && partnerId != sendValue.getPartnerId()){
						sendPriceSyn.add(sendValue.getPartnerId());
						partnerId = sendValue.getPartnerId();
					}
				}
				// 插入同步信息(仓库信息的修改，只要涉及到配送价)
				if (sendPriceSyn.size() > 0) {
					IBaseInfoSynValue[] info = new BaseInfoSynBean[sendPriceSyn.size()];
					for (int i = 0; i < sendPriceSyn.size(); i++) {
						info[i] = new BaseInfoSynBean();
						info[i].setSynInfoType(WareConstant.SYS_PARA_SYN_TYPE_SEND_PRICE);
						info[i].setInfoId(sendPriceSyn.get(i));
						info[i].setStsToNew();
					}
					saveSynInfos(info);
				}
			}
		}
	}
	
	/**
	 * 根据houseIds ，查询在send_price_info 中是否有关联的配送商，
	 * 如果有，那么积分值变化，就要查询出合作商id，进行与hp的同步
	 * @param wareHouseIds
	 * @return
	 * @throws Exception
	 */
	public ISendPriceInfoValue[] getSendPriceInfoValueByHouseIds(String wareHouseIds) throws Exception{
		ISendPriceInfoValue[] values = null;
		if(!StringUtil.isBlank(wareHouseIds)){
			StringBuffer sqlBuf = new StringBuffer("");
			sqlBuf.append("SELECT DISTINCT SPI.PARTNER_ID FROM SEND_PRICE_INFO SPI WHERE SPI.WAREHOUSE_ID IN (").append(wareHouseIds).append(") ");
			values = SendPriceInfoEngine.getBeansFromSql(sqlBuf.toString(), null);
		}
		return values;
	}
	
	//同步信息
	public void saveSynInfos(IBaseInfoSynValue[] synInfos) throws Exception {
        for (IBaseInfoSynValue value : synInfos) {
            if (value.isNew()) {
                value.setSynId(BaseInfoSynEngine.getNewId().longValue());
                value.setSynCreateTime(BaseInfoSynEngine.getSysDate());
                value.setSynInfoState(WareConstant.SYS_PARA_SYN_STATE_WAIT);
            }
        }
        BaseInfoSynEngine.save(synInfos);
    }
	
	public ILogisticRulePriceRangeValue[] checkRulePriceFee(String packageFeeBusiIds,String busiSendPriceIds) throws Exception{
		StringBuffer strBuf = new StringBuffer("");
		//加0.01是因为必须得把修改的费用包括进去
		if(!StringUtil.isBlank(packageFeeBusiIds)){
			strBuf.setLength(0);
			strBuf.append(" SELECT r.range_id,r.rule_id,r.begin_amount,(s.fee+b.price+0.01) END_AMOUNT,r.rule_value,r.update_staff_id,r.update_date  ");
			strBuf.append(" FROM Logistic_Rule_Price_Range r, (SELECT MAX(NVL(end_amount,0)) amount,lrpr.rule_id FROM Logistic_Rule_Price_Range lrpr GROUP BY lrpr.rule_id ) l , ");
			strBuf.append(" (SELECT max(NVL(wi.package_fee,0))*1.5 fee FROM BUSI_warehouse_info wi where  wi.warehouse_state = 1 AND WI.BUSI_ID IN ( ").append(packageFeeBusiIds).append(" ) ) s , ");
			strBuf.append(" (SELECT MAX(NVL(busi.send_price,0)) price FROM send_price_info busi ) b ");
			strBuf.append(" WHERE r.rule_id = l.rule_id AND r.end_amount = amount AND l.amount <= (s.fee + b.price)   ");
		}else if(!StringUtil.isBlank(busiSendPriceIds)){
			strBuf.setLength(0);
			strBuf.append(" SELECT r.range_id,r.rule_id,r.begin_amount,(s.fee+b.price+0.01) END_AMOUNT,r.rule_value,r.update_staff_id,r.update_date  ");
			strBuf.append(" FROM Logistic_Rule_Price_Range r, (SELECT MAX(NVL(end_amount,0)) amount,lrpr.rule_id FROM Logistic_Rule_Price_Range lrpr GROUP BY lrpr.rule_id ) l , ");
			strBuf.append(" (SELECT max(NVL(wi.package_fee,0))*1.5 fee FROM warehouse_info wi where  wi.warehouse_state = 1 ) s , ");
			strBuf.append(" (SELECT MAX(NVL(busi.send_price,0)) price FROM busi_send_price_info busi WHERE busi.busi_id in ( ").append(busiSendPriceIds).append(" ) ) b ");
			strBuf.append(" WHERE r.rule_id = l.rule_id AND r.end_amount = amount AND l.amount <= (s.fee + b.price)   ");
		}
		ILogisticRulePriceRangeValue[] values = LogisticRulePriceRangeEngine.getBeansFromSql(strBuf.toString(), null);
		return values;
	}
	
	public void updateRuleRangePrice(String packageFee,String sendPrice,long StaffId,String ComType,long OrgId) throws Exception{
		ILogisticRulePriceRangeValue[] values = checkRulePriceFee(packageFee,sendPrice);		
		if(values != null && values.length > 0 && values[0].getRangeId() != 0 ){//如果物流费超过价格区间，需要将最大值修改成物流费计算的最大值
			logger.info("需要修改的物流费积分区间最大值的条数为"+values.length);
			for(ILogisticRulePriceRangeValue value : values){
				ILogisticRulePriceRangeValue ruleDetailPriceRange = LogisticRulePriceRangeEngine.getBean(value.getRangeId());
				ILogisticRuleValue logisticRuleBean = LogisticRuleEngine.getBean(value.getRuleId());
            	ILogisticRulePriceRangeValue oldBean = new LogisticRulePriceRangeBean();
            	oldBean.copy(ruleDetailPriceRange);
            	ruleDetailPriceRange.setRuleId(value.getRuleId());
            	ruleDetailPriceRange.setBeginAmount(value.getBeginAmount());
            	ruleDetailPriceRange.setEndAmount(value.getEndAmount());
            	ruleDetailPriceRange.setRuleValue(value.getRuleValue());
                ruleDetailPriceRange.setUpdateStaffId(SessionManager.getUser().getID());
                ruleDetailPriceRange.setUpdateDate(DateTimeUtil.getDefaultSysDate());
                LogisticRulePriceRangeEngine.save(ruleDetailPriceRange);
                
                long busiInfoId = BusiInfoEngine.getNewId().longValue();
                BusiInfoUtil.recordBusiInfo(busiInfoId + "", CoreConstant.SYS_PARA_BUSI_TYPE_LOGISTICTRULE_MODIFY, -1,
		                "修改物流费积分规则",CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,"规则ID："+logisticRuleBean.getRuleId()+";规则名称："+logisticRuleBean.getRuleName(),StaffId,ComType,OrgId);
			
                BusiInfoUtil.recordBusiDetail(busiInfoId + "", new Object[]{oldBean}, new Object[]{ruleDetailPriceRange}, "RuleId");
			}
		}
	}
	
	public ILogisticRuleHouseRltValue[] getRultHousesRltNotExists() throws Exception{
		StringBuffer strBuf = new StringBuffer("");
		strBuf.append(" SELECT DISTINCT WI.WAREHOUSE_ID FROM WAREHOUSE_INFO WI,WAREHOUSE_LOGISTIC_RLT WLR WHERE ");
		strBuf.append(" NOT EXISTS (SELECT 1 FROM LOGISTIC_RULE_HOUSE_RLT RLT  ");
		strBuf.append(" WHERE RLT.WAREHOUSE_ID = WI.WAREHOUSE_ID ) AND WI.WAREHOUSE_ID = WLR.WAREHOUSE_ID  AND WI.WAREHOUSE_STATE = '1' ");
		ILogisticRuleHouseRltValue[] values = LogisticRuleHouseRltEngine.getBeansFromSql(strBuf.toString(), null);
		
		return values;
	}
		
}
