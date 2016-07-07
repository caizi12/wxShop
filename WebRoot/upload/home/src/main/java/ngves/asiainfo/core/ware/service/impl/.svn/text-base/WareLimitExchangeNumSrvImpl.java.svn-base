package ngves.asiainfo.core.ware.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.common.bo.BusiInfoEngine;
import ngves.asiainfo.core.common.util.AiHpInterUtil;
import ngves.asiainfo.core.common.util.BusiInfoUtil;
import ngves.asiainfo.core.ware.WareConstant;
import ngves.asiainfo.core.ware.WareParamConstant;
import ngves.asiainfo.core.ware.dao.interfaces.IWareLimitExchangeNumDAO;
import ngves.asiainfo.core.ware.ivalues.IQBOLimitExchangeNumWareValue;
import ngves.asiainfo.core.ware.ivalues.IWareExchangeRuleRltValue;
import ngves.asiainfo.core.ware.ivalues.IWareLimitExchangeNumValue;
import ngves.asiainfo.core.ware.service.interfaces.IWareLimitExchangeNumSrv;
import ngves.asiainfo.core.ware.util.WareCommonUtil;
import ngves.asiainfo.interfaces.InterConstant;
import ngves.asiainfo.interfaces.hp.ProvinceUtil;
import ngves.asiainfo.interfaces.hp.bean.synWareExchangeLimitConfig.in.SynWareExchangeLimitConfigInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.synWareExchangeLimitConfig.in.SynWareExchangeLimitConfigInItemIDList;
import ngves.asiainfo.interfaces.hp.bean.synWareExchangeLimitConfig.in.SynWareExchangeLimitConfigInRelationList;
import ngves.asiainfo.interfaces.hp.bean.synWareExchangeLimitConfig.out.SynWareExchangeLimitConfigOutBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.synWareExchangeLimitConfig.out.SynWareExchangeLimitConfigOutErrorDetail;
import ngves.asiainfo.interfaces.hp.bean.synWareExchangeRule.in.SynWareExchangeRuleInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.synWareExchangeRule.in.SynWareExchangeRuleInCityList;
import ngves.asiainfo.interfaces.hp.bean.synWareExchangeRule.in.SynWareExchangeRuleInItemCountList;
import ngves.asiainfo.interfaces.hp.bean.synWareExchangeRule.in.SynWareExchangeRuleInOrgIDList;
import ngves.asiainfo.interfaces.hp.bean.synWareExchangeRule.in.SynWareExchangeRuleInProvinceList;
import ngves.asiainfo.interfaces.hp.bean.synWareExchangeRule.in.SynWareExchangeRuleInRuleList;
import ngves.asiainfo.interfaces.hp.bean.synWareExchangeRule.out.SynWareExchangeRuleOutBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.synWareExchangeRule.out.SynWareExchangeRuleOutErrorDetail;
import ngves.asiainfo.interfaces.hp.realtime.SynWareExchangeLimitConfigInter;
import ngves.asiainfo.interfaces.hp.realtime.SynWareExchangeLimitRuleInter;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.JDBCUtils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WareLimitExchangeNumSrvImpl implements IWareLimitExchangeNumSrv {
	
	private static Log log = LogFactory.getLog(WareLimitExchangeNumSrvImpl.class);

	private IWareLimitExchangeNumDAO wareLimitExchangeNumDAO;
	
	public void setWareLimitExchangeNumDAO(IWareLimitExchangeNumDAO wareLimitExchangeNumDAO) throws Exception {
		this.wareLimitExchangeNumDAO=wareLimitExchangeNumDAO;
	}

	public IWareLimitExchangeNumValue[] getLimitNumRule(String limitName,String exchangeCycle,int startNum, int endNum)
			throws Exception {
		Map<String,Object>  map=new HashMap<String,Object>();
		StringBuffer  sql=new StringBuffer();
		sql.append(" 1=1 ");
		getLimitNumRuleSql(limitName, exchangeCycle, map, sql);
		sql.append("  ORDER  BY  WARE_LIMIT_ID  DESC ");
		IWareLimitExchangeNumValue[] values=wareLimitExchangeNumDAO.getLimitNumRule(sql.toString(),map, startNum, endNum);
		return fillHTMLOperationField(values);
	}

	public int getLimitNumRuleCount(String limitName,String exchangeCycle) throws Exception {
		Map<String,Object>  map=new HashMap<String,Object>();
		StringBuffer  sql=new StringBuffer();
		sql.append(" 1=1 ");
		getLimitNumRuleSql(limitName, exchangeCycle, map, sql);
		return wareLimitExchangeNumDAO.getLimitNumRuleCount(sql.toString(),map);
	}

	private void getLimitNumRuleSql(String limitName, String exchangeCycle,
			Map<String, Object> map, StringBuffer sql) {
		if(StringUtils.isNotBlank(limitName)){
			sql.append(" AND "+IWareLimitExchangeNumValue.S_LimitName).append(" LIKE :").append(IWareLimitExchangeNumValue.S_LimitName);
			map.put(IWareLimitExchangeNumValue.S_LimitName,"%"+limitName+"%");
		}
		if(StringUtils.isNotBlank(exchangeCycle)){
			if(!exchangeCycle.equals(WareConstant.QUERY_CONDITION_NO_VALUE)){
				sql.append(" AND "+IWareLimitExchangeNumValue.S_LimitExchangeCycle).append("  LIKE :").append(IWareLimitExchangeNumValue.S_LimitExchangeCycle);
				map.put(IWareLimitExchangeNumValue.S_LimitExchangeCycle,"%"+exchangeCycle+"%");
			}
		}
	}
	public IWareLimitExchangeNumValue getLimitNumRuleInfoById(String wareLimitId)
			throws Exception {
		IWareLimitExchangeNumValue  value=null;
		if(StringUtils.isNotBlank(wareLimitId)){
			value=wareLimitExchangeNumDAO.getLimitNumRuleInfoById(wareLimitId);	
		}
		return value;
		
	}

	public String saveLimitNumRuleInfoValue(IWareLimitExchangeNumValue value,Map<String,Object> userMap)
			throws Exception {
		String limitId=wareLimitExchangeNumDAO.saveLimitNumRuleInfoValue(value);
		if(StringUtils.isBlank(limitId)){
		    throw new Exception("保存失败");
		}
			IWareLimitExchangeNumValue[] valueArr={value};
			SynWareExchangeRuleOutBizRegReq out=getSynWareLimitRuleBizRegReq(valueArr,userMap.get(WareParamConstant.MGT_USER_CODE).toString());	
			if(!(InterConstant.SUCC.equals(out.getRejectReason()))){
				throw new Exception(out.getErrorMsg());
			}else{
				SynWareExchangeRuleOutErrorDetail[] errorDetailArray=out.getErrorDetailArray();
				if(null!=errorDetailArray&&errorDetailArray.length>0){
					StringBuffer errorMsg=new StringBuffer();
					for(SynWareExchangeRuleOutErrorDetail error:errorDetailArray){
						errorMsg.append("规则ID："+error.getRuleID()+","+error.getErrorMsg()+";");
					}
					throw new Exception(errorMsg.toString());
				}
			}
			long busiInfoId = BusiInfoEngine.getNewId().longValue();
			BusiInfoUtil.recordBusiInfo(busiInfoId + "", CoreConstant.SYS_PARA_BUSI_TYPE_LIMITNUM_ADD, -1,
	                "新增配置兑换",CoreConstant.BUSI_INFO_OPT_TYPE_ADD,"限制ID："+limitId,
	                Long.parseLong(userMap.get(WareParamConstant.MGT_USER_STAFF_ID).toString()),
	                userMap.get(WareParamConstant.MGT_USER_COM_TYPE).toString(),
	                Long.parseLong(userMap.get(WareParamConstant.MGT_USER_ORG_ID).toString()));
		
		return limitId;
	}	
	/**
     *  增加兑换数量限制规则链接的模板
     */
    public static final String MODIFY_LIMITRULE_INFO_LINK = "<a href=\"javascript:editLimitRuleInfo('%s')\">编辑"+ "</a>";
    public static final String UPDATE_EFFECT_INFO_LINK = "<a href=\"javascript:updateEffect('%s')\">生效"+ "</a>";
    public static final String UPDATE_UNEFFECT_INFO_LINK = "<a href=\"javascript:updateUnEffect('%s')\">失效"+ "</a>";    
	/**
	 * @param values
	 * @throws Exception 
	 */
	private IWareLimitExchangeNumValue[] fillHTMLOperationField(IWareLimitExchangeNumValue[] values) throws Exception {
		String viewValue="";	
		StringBuffer sb=null;		
		for(IWareLimitExchangeNumValue value: values){
			sb = new StringBuffer();
			sb.append(String.format(MODIFY_LIMITRULE_INFO_LINK, value.getWareLimitId()));			
			value.setBakCol(sb.toString());
			if(WareParamConstant.LAST_DAY_YES.equals(value.getLastDay())){
				value.setLastDay("允许");
			}else{
				value.setLastDay("不允许");
			}
			if(WareParamConstant.HAS_COUNT_LIMIT.equals(value.getIsLimitNum())){
				value.setIsLimitNum("是");
			}else{
				value.setIsLimitNum("否");
			}
			//限制兑换渠道
			viewValue = WareCommonUtil.getViewNameByCode(value.getLimitExchangeChannel(), "SYS_PARA_DATA", "PARA_CODE", "PARA_NAME", ",", "、","PARA_TYPE_ID=1001");
			value.setLimitExchangeChannel(viewValue);
			//限制兑换周期
			viewValue = WareCommonUtil.getViewNameByCode(value.getLimitExchangeCycle(), "SYS_PARA_DATA", "PARA_CODE", "PARA_NAME", ",", "、","PARA_TYPE_ID=900000000000023");
			value.setLimitExchangeCycle(viewValue);
			
        }
        return values;
    }

	public IQBOLimitExchangeNumWareValue[] queryBindWareInfo(String wareLimitId,
			int startIndex, int endIndex) throws Exception {
		Map<String,Object>  map=new HashMap<String,Object>();
		StringBuffer  sql=new StringBuffer();
		sql.append(" 1=1");
		
		sql.append(" AND "+IQBOLimitExchangeNumWareValue.S_WareLimitId).append(" =:").append(IQBOLimitExchangeNumWareValue.S_WareLimitId);
		map.put(IQBOLimitExchangeNumWareValue.S_WareLimitId, wareLimitId);
		
		IQBOLimitExchangeNumWareValue[] values = wareLimitExchangeNumDAO.queryBindWareInfo(sql.toString(),map, startIndex, endIndex);
		if(null!=values&&values.length>0){
			values = fillBindWareOperatorHtml(values);
		}		
		return values;
	}

	public int queryBindWareInfoCount(String wareLimitId) throws Exception {
		Map<String,Object>  map=new HashMap<String,Object>();
		StringBuffer  sql=new StringBuffer();
		sql.append(" 1=1 ");
		
		sql.append(" AND "+IQBOLimitExchangeNumWareValue.S_WareLimitId).append(" =:").append(IQBOLimitExchangeNumWareValue.S_WareLimitId);
		map.put(IQBOLimitExchangeNumWareValue.S_WareLimitId, wareLimitId);
		
		return wareLimitExchangeNumDAO.queryBindWareInfoCount(sql.toString(),map);
	}

	public IQBOLimitExchangeNumWareValue[] getBindWareInfoList(String partnerId, String lstWareFirstKind,
			String lstWareParentKind, String lstWareKind, String wareName,String wareCode, String limitExchangeCycle,
			String isEffect,String provinceCode,String wareKindInfoId,int startIndex, int endIndex) throws Exception {
		
		Map<String,Object>  map=new HashMap<String,Object>();
		StringBuffer  sql=new StringBuffer();
		sql.append(" 1=1 ");
		
		getBindWareinfoSql(partnerId, lstWareFirstKind, lstWareParentKind,
				lstWareKind, wareName, wareCode, limitExchangeCycle, isEffect,
				provinceCode,wareKindInfoId, map, sql);
		//sql.append("  order by  EFFECT_STARTTIME  asc,WARE_LIMIT_ID desc");
		IQBOLimitExchangeNumWareValue[] values = wareLimitExchangeNumDAO.queryBindWareInfo(sql.toString(),map, startIndex, endIndex);
		values = fillBindWareOperatorHtml(values);
		return values;
	}

	private void getBindWareinfoSql(String partnerId, String lstWareFirstKind,
			String lstWareParentKind, String lstWareKind, String wareName,
			String wareCode, String limitExchangeCycle, String isEffect,
			String provinceCode,String wareKindInfoId, Map<String, Object> map, StringBuffer sql) {
		if(!StringUtils.isBlank(partnerId) && !CommnConstant.QRY_OPTION_ALL.equals(partnerId)){
			sql.append(" AND "+IQBOLimitExchangeNumWareValue.S_PartnerId).append(" =:").append(IQBOLimitExchangeNumWareValue.S_PartnerId);
			map.put(IQBOLimitExchangeNumWareValue.S_PartnerId, partnerId);
		}
		
		if(!StringUtils.isBlank(lstWareFirstKind) && !CommnConstant.QRY_OPTION_ALL.equals(lstWareFirstKind)){
			sql.append(" AND "+IQBOLimitExchangeNumWareValue.S_WareFirstKindId).append(" =:").append(IQBOLimitExchangeNumWareValue.S_WareFirstKindId);
			map.put(IQBOLimitExchangeNumWareValue.S_WareFirstKindId, lstWareFirstKind);
		}
		
		if(!StringUtils.isBlank(lstWareParentKind) && !CommnConstant.QRY_OPTION_ALL.equals(lstWareParentKind)){
			sql.append(" AND "+IQBOLimitExchangeNumWareValue.S_WareKindParentId).append(" =:").append(IQBOLimitExchangeNumWareValue.S_WareKindParentId);
			map.put(IQBOLimitExchangeNumWareValue.S_WareKindParentId, lstWareParentKind);
		}
		
		if(!StringUtils.isBlank(lstWareKind) && !CommnConstant.QRY_OPTION_ALL.equals(lstWareKind)){
			sql.append(" AND "+IQBOLimitExchangeNumWareValue.S_WareKindId).append(" =:").append(IQBOLimitExchangeNumWareValue.S_WareKindId);
			map.put(IQBOLimitExchangeNumWareValue.S_WareKindId, lstWareKind);
		}
		
		if(!StringUtils.isBlank(wareName)){
			sql.append(" AND "+IQBOLimitExchangeNumWareValue.S_WareName).append(" LIKE :").append(IQBOLimitExchangeNumWareValue.S_WareName);
			map.put(IQBOLimitExchangeNumWareValue.S_WareName, "%"+wareName+"%");
		}
		
		if(!StringUtils.isBlank(wareCode)){
			sql.append(" AND "+IQBOLimitExchangeNumWareValue.S_WareCode).append(" =:").append(IQBOLimitExchangeNumWareValue.S_WareCode);
			map.put(IQBOLimitExchangeNumWareValue.S_WareCode, wareCode);
		}
		if(!StringUtils.isBlank(limitExchangeCycle) && !CommnConstant.QRY_OPTION_ALL.equals(limitExchangeCycle)){
			sql.append(" AND "+IQBOLimitExchangeNumWareValue.S_LimitExchangeCycle).append(" LIKE :").append(IQBOLimitExchangeNumWareValue.S_LimitExchangeCycle);
			map.put(IQBOLimitExchangeNumWareValue.S_LimitExchangeCycle, "%"+limitExchangeCycle+"%");
		}
		
		if(!StringUtils.isBlank(isEffect) && !CommnConstant.QRY_OPTION_ALL.equals(isEffect)){
			sql.append(" AND "+IQBOLimitExchangeNumWareValue.S_IsEffect).append(" =:").append(IQBOLimitExchangeNumWareValue.S_IsEffect);
			map.put(IQBOLimitExchangeNumWareValue.S_IsEffect, isEffect);
		}
		if(!StringUtils.isBlank(wareKindInfoId) && !CommnConstant.QRY_OPTION_ALL.equals(wareKindInfoId)){
			sql.append(" AND "+IQBOLimitExchangeNumWareValue.S_WareKindInfoId).append(" =:").append(IQBOLimitExchangeNumWareValue.S_WareKindInfoId);
			map.put(IQBOLimitExchangeNumWareValue.S_WareKindInfoId, wareKindInfoId);
		}
		//省网礼品商登录时，只查询本省的礼品
		if(!StringUtils.isBlank(provinceCode)&&!provinceCode.equals("00")){
			sql.append(" AND "+IQBOLimitExchangeNumWareValue.S_ProvinceCode).append(" =:").append(IQBOLimitExchangeNumWareValue.S_ProvinceCode);
			map.put(IQBOLimitExchangeNumWareValue.S_ProvinceCode, provinceCode);
		}
	}

	private IQBOLimitExchangeNumWareValue[] fillBindWareOperatorHtml(IQBOLimitExchangeNumWareValue[] values) throws Exception {
		
		for(IQBOLimitExchangeNumWareValue value: values){
			
			//是否生效
			String isEffectName = WareCommonUtil.getViewNameByCode(value.getIsEffect(), "SYS_PARA_DATA", "PARA_CODE", "PARA_NAME", ",", "、","PARA_TYPE_ID=114");
			value.setIsEffect(isEffectName);
			//礼品状态
			String wareStatusName = WareCommonUtil.getViewNameByCode(value.getWareStatus(), "SYS_PARA_DATA", "PARA_CODE", "PARA_NAME", ",", "、","PARA_TYPE_ID=20");
			value.setWareStatus(wareStatusName);
			//限制兑换渠道
			String limitExchangeName = WareCommonUtil.getViewNameByCode(value.getLimitExchangeChannel(), "SYS_PARA_DATA", "PARA_CODE", "PARA_NAME", ",", "、","PARA_TYPE_ID=1001");
			value.setLimitExchangeChannel(limitExchangeName);
			//限制兑换周期
			String limitCycleName = WareCommonUtil.getViewNameByCode(value.getLimitExchangeCycle(), "SYS_PARA_DATA", "PARA_CODE", "PARA_NAME", ",", "、","PARA_TYPE_ID=900000000000023");
			value.setLimitExchangeCycle(limitCycleName);
		}
		return values;
	}
    
	public int getBindWareInfoListCount(String partnerId, String lstWareFirstKind,String lstWareParentKind, 
			String lstWareKind, String wareName,String wareCode, String limitExchangeCycle, String isEffect,String provinceCode,String wareKindInfoId)
			throws Exception {
		
		Map<String,Object>  map=new HashMap<String,Object>();
		StringBuffer  sql=new StringBuffer();
		sql.append(" 1=1 ");		
		getBindWareinfoSql(partnerId, lstWareFirstKind, lstWareParentKind,
				lstWareKind, wareName, wareCode, limitExchangeCycle, isEffect,
				provinceCode,wareKindInfoId, map, sql);
		return wareLimitExchangeNumDAO.queryBindWareInfoCount(sql.toString(),map);
	}

    //修改规则信息
	public String modifyLimitNumRuleInfoValue(IWareLimitExchangeNumValue value,Map<String,Object> userMap)
			throws Exception {		
		IWareLimitExchangeNumValue oldValue=this.getLimitNumRuleInfoById(value.getWareLimitId());
		//比较有没有修改,返回false，表示没有修改值
		if(!BusiInfoUtil.compareValue(oldValue, value, null)){
			return WareParamConstant.BASE_INFO_NOT_MODIFY;
		}
		boolean  flag=true;
		oldValue.setLimitName(value.getLimitName());
		//排除limitName,比较有没有修改，决定是否同步HP，当相同则不同步
		if(!BusiInfoUtil.compareValue(oldValue, value, null)){
			flag=false;
		}
		oldValue.setIsLimitNum(value.getIsLimitNum());	
		if(WareParamConstant.HAS_COUNT_LIMIT.equals(value.getIsLimitNum())){
			oldValue.setLimitExchangeCycle(value.getLimitExchangeCycle());
			oldValue.setLimitnumDay(value.getLimitnumDay());				
			oldValue.setLimitnumMonth(value.getLimitnumMonth());			
			oldValue.setLimitnumYear(value.getLimitnumYear());	
		    oldValue.setLimitNum(value.getLimitNum());					
		}else{
			oldValue.setLimitExchangeCycle("");
			oldValue.setLimitnumDay(0l);				
			oldValue.setLimitnumMonth(0l);			
			oldValue.setLimitnumYear(0l);	
			oldValue.setLimitNum(0l);
		}
		oldValue.setLimitExchangeChannel(value.getLimitExchangeChannel());			
		oldValue.setLastDay(value.getLastDay());						
		oldValue.setProviceCode(value.getProviceCode());			
		String limitId=wareLimitExchangeNumDAO.saveLimitNumRuleInfoValue(oldValue);
		
		//保存数据库成功，并且已经修改接口中的字段才同步给HP
		if(StringUtils.isNotBlank(limitId)&&flag){	
			IWareLimitExchangeNumValue[] valueArr={oldValue};
			SynWareExchangeRuleOutBizRegReq out=getSynWareLimitRuleBizRegReq(valueArr,userMap.get(WareParamConstant.MGT_USER_CODE).toString());		
			if(!InterConstant.SUCC.equals(out.getRejectReason())){
				throw new Exception(out.getErrorMsg());
			}else{
				SynWareExchangeRuleOutErrorDetail[] errorDetailArray=out.getErrorDetailArray();
				if(null!=errorDetailArray&&errorDetailArray.length>0){
					StringBuffer errorMsg=new StringBuffer();
					for(SynWareExchangeRuleOutErrorDetail error:errorDetailArray){
						errorMsg.append("规则ID："+error.getRuleID()+","+error.getErrorMsg()+";");
					}
					throw new Exception(errorMsg.toString());
				}
			}
		}	
		// 记录日志
		long busiInfoId = BusiInfoEngine.getNewId().longValue();
		BusiInfoUtil.recordBusiInfo(busiInfoId + "", CoreConstant.SYS_PARA_BUSI_TYPE_LIMITNUM_MODIFY, -1, "修改兑换限制",
				CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY, "限制ID：" + limitId, Long.parseLong(userMap.get(WareParamConstant.MGT_USER_STAFF_ID).toString()),
                userMap.get(WareParamConstant.MGT_USER_COM_TYPE).toString(),
                Long.parseLong(userMap.get(WareParamConstant.MGT_USER_ORG_ID).toString()));		
		BusiInfoUtil.recordBusiDetail(busiInfoId + "", new Object[] {oldValue}, new Object[] {value},
				"wareLimitId");		
		return limitId;
	}
    @Deprecated
	public String updateEffect(IWareLimitExchangeNumValue value,Map<String,Object> userMap)
			throws Exception {
		
		String limitId="";	
		//得到修改之前的对象
		IWareLimitExchangeNumValue oldValue=wareLimitExchangeNumDAO.getLimitNumRuleInfoById(value.getWareLimitId());
		limitId=wareLimitExchangeNumDAO.saveLimitNumRuleInfoValue(value);
		//记录日志 
		long busiInfoId = BusiInfoEngine.getNewId().longValue();
		BusiInfoUtil.recordBusiInfo(busiInfoId + "", CoreConstant.SYS_PARA_BUSI_TYPE_LIMITNUM_MODIFY, -1, "修改兑换限制",
				CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY_KIND, "限制ID：" + limitId, Long.parseLong(userMap.get(WareParamConstant.MGT_USER_STAFF_ID).toString()),
                userMap.get(WareParamConstant.MGT_USER_COM_TYPE).toString(),
                Long.parseLong(userMap.get(WareParamConstant.MGT_USER_ORG_ID).toString()));
		BusiInfoUtil.recordBusiDetail(busiInfoId + "", new Object[] {oldValue}, new Object[] {value},
				"wareLimitId");
		return limitId;
	}
	
		//绑定礼品绑定关系	
		public String saveLimitNumWareInfoValue(IWareExchangeRuleRltValue[] values,Map<String,Object> userMap) throws Exception {
			IWareExchangeRuleRltValue[] wareBindValues=null;
			String[] optobjArr=new String[values.length];
			String relationId=JDBCUtils.getValueNewId();
				for(int  i=0;i<values.length;i++){
					values[i].setRelationId(relationId);
					values[i].setIsBind(WareParamConstant.WARE_LIMIT_BIND);	
					optobjArr[i]="关系id："+relationId+",礼品id:"+values[i].getWareId();			
					if(WareParamConstant.WARE_LIMIT_NUM_UNEFFECT.equals(values[0].getIsEffect())){
						continue;
					}
					wareBindValues=wareLimitExchangeNumDAO.isEffectRuleAmongWare(values[i]);
					if(null==wareBindValues||wareBindValues.length<=0){
						continue;
					}
					for(IWareExchangeRuleRltValue  wareBindValue  :wareBindValues){
						if(wareBindValue.getEffectStarttime().getTime()>=values[i].getEffectStarttime().getTime()
								&&wareBindValue.getEffectStarttime().getTime()<=values[i].getEffectEndtime().getTime()){
							throw  new Exception("礼品编码:"+values[i].getWareCode()+",同时间段内存在冲突的生效规则");									
						}else if(wareBindValue.getEffectEndtime().getTime()>=values[i].getEffectStarttime().getTime()
								&&wareBindValue.getEffectEndtime().getTime()<=values[i].getEffectEndtime().getTime()){
							throw  new Exception("礼品编码:"+values[i].getWareCode()+",同时间段内存在冲突的生效规则");			
						}else if(values[i].getEffectStarttime().getTime()>=wareBindValue.getEffectStarttime().getTime()&&
								values[i].getEffectEndtime().getTime()<=wareBindValue.getEffectEndtime().getTime()){
									throw  new Exception("礼品编码:"+values[i].getWareCode()+",同时间段内存在冲突的生效规则");
					    }
					}																									
			}			
			    String limitId=wareLimitExchangeNumDAO.saveLimitNumWareInfoValue(values);
				if(StringUtils.isBlank(limitId)){
					throw  new Exception("绑定失败");
				}
				//同步hp
				Map<String,Object> countMap=new HashMap<String,Object>();
				countMap.put("code", userMap.get("code"));
				List<Map<String,Object>> relationList=new ArrayList<Map<String,Object>>();
				Map<String,Object> relationMap=new HashMap<String,Object>();
				relationMap.put("RelationID", values[0].getRelationId());
				StringBuffer wareCode=new StringBuffer();
				for(IWareExchangeRuleRltValue value:values){	
					wareCode=wareCode.append(value.getWareCode()+",");
				}
				relationMap.put("ItemID", wareCode);
				relationMap.put("RuleID", values[0].getWareLimitrlueId());
				relationMap.put("Enable", values[0].getIsEffect());
				relationMap.put("StartTime", values[0].getEffectStarttime());
				relationMap.put("EndTime", values[0].getEffectEndtime());
				relationList.add(relationMap);
				countMap.put("relationList", relationList);
				SynWareExchangeLimitConfigOutBizRegReq out=getSynWareLimitConfigBizRegReq(countMap);
				if(!(InterConstant.SUCC.equals(out.getRejectReason()))){
					throw new Exception(out.getErrorMsg());
				}else{
					SynWareExchangeLimitConfigOutErrorDetail[]  errorDetailArray=out.getErrorDetailArray();
					if(null!=errorDetailArray&&errorDetailArray.length>0){
						StringBuffer errorMsg=new StringBuffer();
						for(SynWareExchangeLimitConfigOutErrorDetail error:errorDetailArray){
							errorMsg.append("关系ID:"+error.getRelationID()+","+error.getErrorMsg()+";");
						}
						throw new Exception(errorMsg.toString());
					}					
				}
						    
				//记录日志(批量新增)
					BusiInfoUtil.recordBusiInfoBatch(CoreConstant.SYS_PARA_BUSI_TYPE_LIMITNUM_BIND, -1,
			                "绑定兑换限制",CoreConstant.BUSI_INFO_OPT_TYPE_ADD,optobjArr,Long.parseLong(userMap.get(WareParamConstant.MGT_USER_STAFF_ID).toString()),
			                userMap.get(WareParamConstant.MGT_USER_COM_TYPE).toString(),
			                Long.parseLong(userMap.get(WareParamConstant.MGT_USER_ORG_ID).toString()));				
			return limitId;
		}

		public IWareExchangeRuleRltValue[] queryBindWareInfos(String wareLimitId)throws Exception{
			return wareLimitExchangeNumDAO.getLimitNumWareInfoValues(wareLimitId,0l);
		}
		
		public boolean isExistSameName(String limitName) throws Exception {		
			return wareLimitExchangeNumDAO.isExistSameName(limitName);
		}		
		//4.2.2. 兑换限制规则增量同步接口
		protected SynWareExchangeRuleOutBizRegReq getSynWareLimitRuleBizRegReq(IWareLimitExchangeNumValue[] valueArr,String code) throws Exception{							
			SynWareExchangeRuleInBizRegReq in = SynWareExchangeLimitRuleInter.getWareExchangeRuleBean();
			in.setAmount(valueArr.length);
			in.setOperator(code);
			in.setOperateTime(DateTimeUtil.dateToString(new Date(),CommnConstant.DATETIME_HP_FORMAT));
			SynWareExchangeRuleInRuleList  ruleList=null;
			SynWareExchangeRuleInProvinceList provinceList=null;
			SynWareExchangeRuleInCityList cityList=null;
			SynWareExchangeRuleInItemCountList itemCountList=null;
			SynWareExchangeRuleInOrgIDList  orgList=null;
			String[] proCityCode=null;
			String[] cityCode=null;
			String[] exchangeCycle=null;
			String[]  exchangeChannel=null;
			boolean flag=false;
			for(IWareLimitExchangeNumValue value:valueArr){
				ruleList=in.addNewRuleList();
				ruleList.setRuleID(value.getWareLimitId());				
				flag=hasAllProCityInfo(value.getProviceCode());
				log.info("是否全选----"+flag);
				if(flag){
					provinceList=ruleList.addNewProvinceList();
					provinceList.setProvince(WareParamConstant.ALL_PRO_CITY);
					cityList=provinceList.addNewCityList();
					cityList.setCity(WareParamConstant.ALL_PRO_CITY);
				}else{
					proCityCode=value.getProviceCode().split("@");
					for(int i=0;i<proCityCode.length;i++){
						cityCode=proCityCode[i].split(",");
						provinceList=ruleList.addNewProvinceList();
						provinceList.setProvince(ProvinceUtil.toHpProvince(cityCode[0]));						
						for(int j=1;j<cityCode.length;j++){
							cityList=provinceList.addNewCityList();
							cityList.setCity(cityCode[j]);
						}
					}
				}
				
				ruleList.setHasCountLimit(value.getIsLimitNum());
				if(WareParamConstant.HAS_COUNT_LIMIT.equals(value.getIsLimitNum())){
					exchangeCycle=value.getLimitExchangeCycle().split(",");
					for(String cycle:exchangeCycle){
						itemCountList=ruleList.addNewItemCountList();
						itemCountList.setTimeRequest(cycle);
						if("0".equals(cycle)){
							itemCountList.setItemCount((int)value.getLimitnumDay());
						}else if("1".equals(cycle)){
							itemCountList.setItemCount((int)value.getLimitnumMonth());
						}else if("2".equals(cycle)){
							itemCountList.setItemCount((int)value.getLimitnumYear());
						}else if("3".equals(cycle)){
							itemCountList.setItemCount((int)value.getLimitNum());
						}
					}
					
				}				
				ruleList.setLastDay(value.getLastDay());
				exchangeChannel=value.getLimitExchangeChannel().split(",");
				for(String channel:exchangeChannel){
					orgList=ruleList.addNewOrgIDList();
					orgList.setOrgID(AiHpInterUtil.supportTypeConverter(channel));
				}
			}
			return SynWareExchangeLimitRuleInter.doBusi(in);
		}
		//检验是否是全选  true 是全选，false否
		private boolean hasAllProCityInfo(String proCityCode){
			String[] proArr=proCityCode.split("@");
			String[] cityCodeArr=null;			
			if(proArr.length<31){
				return false;
			}
			boolean flag=true;
			for(int i=0;i<proArr.length;i++){
				cityCodeArr=proArr[i].split(",");
				if(cityCodeArr.length>2||!WareParamConstant.ALL_PRO_CITY.equals(cityCodeArr[1].trim())){
					flag=false;
					break;
				}
			}
			return flag;
			
		}
		
		//4.2.5.礼品兑换限制配置增量同步接口（新增）
		
		@SuppressWarnings("unchecked")
		protected SynWareExchangeLimitConfigOutBizRegReq getSynWareLimitConfigBizRegReq(Map<String,Object> map) throws Exception{
			SynWareExchangeLimitConfigInBizRegReq in=SynWareExchangeLimitConfigInter.getWareExchangeLimitConfigBean();
			List<Map<String,Object>> relationList=new ArrayList<Map<String,Object>>();
			relationList=(List<Map<String, Object>>)map.get("relationList");
			in.setAmount(relationList.size());
			in.setOperator(map.get("code").toString());
			in.setOperateTime(DateTimeUtil.dateToString(new Date(),CommnConstant.DATETIME_HP_FORMAT));	
			SynWareExchangeLimitConfigInRelationList synRelationList=null; 
			Map<String,Object> relationMap=new HashMap<String, Object>();
			String[] wareCodeArr=null;
			SynWareExchangeLimitConfigInItemIDList itemIdList=null;
			String startTime="";
			String endTime="";
			for(int i=0;i<relationList.size();i++){
				synRelationList=in.addNewRelationList();	
				relationMap=relationList.get(i);
				synRelationList.setRelationID(relationMap.get("RelationID").toString());
				if(relationMap.containsKey("ItemID")){
					wareCodeArr=relationMap.get("ItemID").toString().split(",");
					for(String wareCode:wareCodeArr){
						itemIdList=synRelationList.addNewItemIDList();
						itemIdList.setItemID(wareCode);
					}
				}
				synRelationList.setRuleID(relationMap.get("RuleID").toString());
				synRelationList.setEnable(relationMap.get("Enable").toString());
				startTime=relationMap.get("StartTime").toString();
				Date d=DateTimeUtil.stringToDate(startTime, CommnConstant.DATETIME_JAVA_FORMAT);
				synRelationList.setStartTime(DateTimeUtil.dateToString(d,CommnConstant.DATETIME_HP_FORMAT));
				endTime=relationMap.get("EndTime").toString();
				d=DateTimeUtil.stringToDate(endTime,CommnConstant.DATETIME_JAVA_FORMAT);
				synRelationList.setEndTime(DateTimeUtil.dateToString(d,CommnConstant.DATETIME_HP_FORMAT));
			}
			return SynWareExchangeLimitConfigInter.doBusi(in);
		
		}
        //解除绑定
		public boolean unBindWareLimit(Map<String, Object> map) throws Exception {
			String bindRuleRltIds=map.get("bindRuleRltIds").toString();
			String relationIds=map.get("relationIds").toString();
			bindRuleRltIds="("+bindRuleRltIds+")";
			String [] relationIdArr=relationIds.split(",");
			IWareExchangeRuleRltValue[] values=null;
			boolean falg=wareLimitExchangeNumDAO.deleteBindWare(bindRuleRltIds);
			if(!falg){
				return false;
			}
			//同步hp
			Map<String,Object> countMap=new HashMap<String,Object>();			
			countMap.put("code", map.get(WareParamConstant.MGT_USER_CODE));
			List<Map<String,Object>> relationList=new ArrayList<Map<String,Object>>();
			Map<String,Object> synRelationMap=null;
			StringBuffer wareCode=null;				
			Map<String,Object>  relationMap=new HashMap<String,Object>();
			for(String relationId:relationIdArr){
				relationMap.put(relationId, relationId);
			}
			for(String key:relationMap.keySet()){
					values=wareLimitExchangeNumDAO.getWareExchangeRuleRltValue(relationMap.get(key).toString(),"");
					synRelationMap=new HashMap<String,Object>();
					if(null==values||values.length<=0){
						continue;
					}
					wareCode=new StringBuffer();
					 for(IWareExchangeRuleRltValue value:values){
						    if(WareParamConstant.WARE_LIMIT_BIND.equals(value.getIsBind()))
					    	wareCode=wareCode.append(value.getWareCode()+",");
					    }
						synRelationMap.put("RelationID",key);
						if(StringUtils.isNotBlank(wareCode.toString())){
							synRelationMap.put("ItemID", wareCode.toString());
						}							
						synRelationMap.put("RuleID", values[0].getWareLimitrlueId());
						synRelationMap.put("Enable", values[0].getIsEffect());
						synRelationMap.put("StartTime",values[0].getEffectStarttime());
						synRelationMap.put("EndTime", values[0].getEffectEndtime());
					
					relationList.add(synRelationMap);				   
			 }											
			countMap.put("relationList", relationList);
			SynWareExchangeLimitConfigOutBizRegReq out=getSynWareLimitConfigBizRegReq(countMap);
			if(!(InterConstant.SUCC.equals(out.getRejectReason()))){
				throw new Exception(out.getErrorMsg());
			}else{
				SynWareExchangeLimitConfigOutErrorDetail[]  errorDetailArray=out.getErrorDetailArray();
				if(null!=errorDetailArray&&errorDetailArray.length>0){
					StringBuffer errorMsg=new StringBuffer();
					for(SynWareExchangeLimitConfigOutErrorDetail error:errorDetailArray){
						errorMsg.append("关系ID:"+error.getRelationID()+","+error.getErrorMsg()+";");
					}
					throw new Exception(errorMsg.toString());
				}
			}
			
			String[] wareIds=map.get("wareIds").toString().split(",");
			String[] optobjArr=new String[relationIdArr.length];
		    for(int i=0;i<relationIdArr.length;i++){
		    	optobjArr[i]="关系id："+relationIdArr[i]+",礼品id:"+wareIds;
		    }			
			//记录日志(批量新增)
			BusiInfoUtil.recordBusiInfoBatch(CoreConstant.SYS_PARA_BUSI_TYPE_LIMITNUM_BIND, -1,
	                "取消绑定兑换限制",CoreConstant.BUSI_INFO_OPT_TYPE_DELETE,optobjArr,Long.parseLong(map.get(WareParamConstant.MGT_USER_STAFF_ID).toString()),
	                map.get(WareParamConstant.MGT_USER_COM_TYPE).toString(),
	                Long.parseLong(map.get(WareParamConstant.MGT_USER_ORG_ID).toString()));
			return true;
		}
		
}
