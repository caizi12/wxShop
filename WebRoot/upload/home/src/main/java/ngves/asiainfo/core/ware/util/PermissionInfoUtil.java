package ngves.asiainfo.core.ware.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.common.util.AiHpInterUtil;
import ngves.asiainfo.core.ware.bo.WareDescInfoEngine;
import ngves.asiainfo.core.ware.bo.WareInfoEngine;
import ngves.asiainfo.core.ware.exception.WarePermissionHPInterException;
import ngves.asiainfo.core.ware.ivalues.IPermissionInfoValue;
import ngves.asiainfo.core.ware.ivalues.IPermissionTypeInfoValue;
import ngves.asiainfo.core.ware.ivalues.IWareDescInfoValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoValue;
import ngves.asiainfo.core.ware.model.ValidateRuleValueToHP;
import ngves.asiainfo.core.ware.service.interfaces.IWareInfoSrv;
import ngves.asiainfo.core.ware.service.interfaces.IWarePermissionInfoSrv;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;

/**
 * 
 * @author shenfl
 * @description:绑定规则同步HP的业务逻辑
 *   1、操作类型为新增时,只传操作类型值和RuleInfo的内容
     2、操作类型为修改时,操作类型值、DisableInfo值和RuleInfo值均需存在
     3、操作类型为删除时,只传操作类型值和DisableInfo
 *
 */
public class PermissionInfoUtil {

    private static transient Log log = LogFactory.getLog(PermissionInfoUtil.class);
	/**
	 * 新增规则同步HP
	 * @param permissionId
	 * @param wareId
	 * @param startTime
	 * @param endTime
	 * @param optType	操作规则类型01新增；02修改 03：删除
	 * @return
	 * @throws Exception
	 */
	public static String createPermissionWareRlt(long permissionId, long wareId, String startTime, String endTime,
			String optType) throws Exception {
		
		String retVal = "";
		try {
			IPermissionInfoValue infoValue =getPermissionInfo(permissionId);
			ValidateRuleValueToHP value = new ValidateRuleValueToHP();
			value.setOptType(optType);
			value.setActionID(CoreConstant.ORDER_ZERO_ACTION_TYPE + permissionId);
			value.setRuleName(infoValue.getPermissionName());
			// mobile 需要转码
			value.setSupportBrand(AiHpInterUtil.formatMobileBrandHPCood(infoValue.getMobileBrandCode()));
			value.setSupportStarLevel(AiHpInterUtil.formatStarLevelHPCood(infoValue.getMobileBrandCode()));
			value.setItemID(getItemID(wareId));
			value.setActionStartTime(convertTimestampToStr(DateTimeUtil.stringToTimestamp(startTime,
					"yyyy-MM-dd HH:mm:ss")));
			value.setActionEndTime(convertTimestampToStr(DateTimeUtil.stringToTimestamp(endTime,
					"yyyy-MM-dd HH:mm:ss")));
			value.setOrgID(AiHpInterUtil.supportTypeConverter(infoValue.getExchangeChannel()));
			value.setOrderStatus(infoValue.getOrderStatus());
			value.setItemScope(infoValue.getItemScope());
			value.setOrderNum(infoValue.getOrderNum());
			log.info("infoValue.getMaxItemNum() === " + infoValue.getMaxItemNum());
			log.info("infoValue.getMaxTimes()===" + infoValue.getMaxTimes());
			value.setMaxItemNum(infoValue.getMaxItemNum());
			value.setMaxTimes(infoValue.getMaxTimes());
			value.setOrderStartTime(convertTimestampToStr(infoValue.getOrderStartTime()));
			value.setOrderEndTime(convertTimestampToStr(infoValue.getOrderEndTime()));
			value.setOrderStatus(infoValue.getOrderStatus());
			value.setIsSpread(getIsSpreadHPValue(infoValue.getIsSpread()));
			value.setActionPoint((int) infoValue.getWareGmeValue());
			value.setProvinceID(AiHpInterUtil.getHPProvinceCodeByAICode(getCodesById(permissionId, "03")));
			value.setExchangeItemID(getCodesById(permissionId, "02"));
			value.setVendorID(getCodesById(permissionId, "01"));
			value.setType3(getCodesById(permissionId, "00"));
			value.setPayType(inerPayType(queryMixOfPayType(infoValue.getPayType(), wareId), wareId));
			value.setPayCash(infoValue.getPayCash());
			value.setPayIntegral(infoValue.getPayIntegral());
			value.setOrderScope(infoValue.getOrderScope());
			// 同步给HP
			retVal = SynDataToHpUtil.synchronousValidateRuleToHP(value);
		} catch (Exception e) {
			log.error("优惠规则同步HP的时候，调用HP接口出错了..." + e.getMessage(), e);
			throw e;
		}
		return retVal;
	}
	
	/**
	 * 查询优惠和礼品支付方式的交集
	 * @param permissionPayType 优惠表存的支付方式
	 * @param wareId 
	 * @return
	 * @throws Exception
	 */
	public static String queryMixOfPayType(String permissionPayType,long wareId)throws Exception {
		IWareInfoValue wareInfo=WareInfoEngine.getBean(wareId);
		String warePayType=wareInfo.getPayType();
		String ret="";
		if (permissionPayType.indexOf("01")>=0&&warePayType.indexOf("01")>=0) {
			ret="01";
		}
		if (permissionPayType.indexOf("02")>=0&&warePayType.indexOf("02")>=0) {
			ret="02";
		}
		if (permissionPayType.indexOf("01,02")>=0&&warePayType.indexOf("01,02")>=0) {
			ret="01,02";
		}
		return ret;
	}
	
	/**
	 * 查询优惠活动绑定的礼品 的接口要求的支付方式
	 * @param mixPayType 优惠表和礼品表支付方式的交集：01代表全积分 ， 02代表积分+现金
	 * @param wareId 
	 * @return 返回接口要求的支付方式 01混合支付线上支付，02混合支付线下支付，03全积分支付
	 * @throws Exception
	 */
	public static String inerPayType(String mixPayType,long wareId) throws Exception {

		StringBuffer ret=new StringBuffer();
		StringBuffer cond  =  new StringBuffer(" 1=1 ");
		Map<String,String> para = new HashMap<String,String>();
		cond.append(" and ").append(IWareDescInfoValue.S_WareId).append("=:").append(IWareDescInfoValue.S_WareId);
		para.put(IWareDescInfoValue.S_WareId, String.valueOf(wareId));
		cond.append(" and ").append(IWareDescInfoValue.S_DescDefineId).append("=:").append(IWareDescInfoValue.S_DescDefineId);
		if (mixPayType.matches(".*"+CoreConstant.PAY_TYPE_INTEGRAL_CASH)){
			//02或01,02情况
			
			//只02情况
			//是否支持在线支付
			para.put(IWareDescInfoValue.S_DescDefineId, CoreConstant.IS_ONLINE_PAYMENT);
			IWareDescInfoValue[] WareDescInfoBeans=WareDescInfoEngine.getBeans(cond.toString(), para);
			String wareDescValue=WareDescInfoBeans[0].getWareDescValue();
			if (CoreConstant.IS_ONLINE_PAY_Y.equals(wareDescValue)) {
				//支持在线支付
				ret.append(CoreConstant.PAY_TYPE_HP_ONLINE);
			} 
			//是否支持线下支付
			para.put(IWareDescInfoValue.S_DescDefineId, CoreConstant.IS_OFFLINE_PAYMENT);
			WareDescInfoBeans=WareDescInfoEngine.getBeans(cond.toString(), para);
			wareDescValue=WareDescInfoBeans[0].getWareDescValue();
			if (CoreConstant.IS_OFFLINE_PAY_Y.equals(wareDescValue)) {
				//支持线下支付
				ret.append(","+CoreConstant.PAY_TYPE_HP_OFFLINE);
			} 
			
			//01,02情况
			if (mixPayType.matches(CoreConstant.PAY_TYPE_INTEGRAL+","+CoreConstant.PAY_TYPE_INTEGRAL_CASH)) {
				ret.append(","+CoreConstant.PAY_TYPE_HP_INTEGRAL);
			}
		} else if(mixPayType.matches("^"+CoreConstant.PAY_TYPE_INTEGRAL+"$")) {
			//其他情况，即 01情况
			ret.append(CoreConstant.PAY_TYPE_HP_INTEGRAL);
		}
		return ret.toString().replaceFirst("^,", "");
	}
	
	/**
	 * 删除规则同步HP
	 * 
	 * @param prePermissionId
	 *            规则标识
	 * @param wareId
	 *            规则绑定礼品标识
	 * @return
	 * @throws Exception
	 */
	public static String unBindPerimissionWareRlt(long prePermissionId, long preWareId, String optType) throws Exception {

		String retVal = "";
		try {
			ValidateRuleValueToHP value = new ValidateRuleValueToHP();
			value.setOptType(optType);
			value.setPreActionID(CoreConstant.ORDER_ZERO_ACTION_TYPE+prePermissionId);
			value.setPreItemID(getItemID(preWareId));
			retVal = SynDataToHpUtil.synchronousValidateRuleToHP(value);
		} catch (Exception e) {
			log.error("优惠规则同步HP的时候，调用HP接口出错了..." + e.getMessage(), e);
			throw e;
		}
		return retVal;
	}
	/**
	 * 修改规则同步HP
	 * @param permissionId
	 * @param wareId
	 * @param startTime
	 * @param endTime
	 * @param optType
	 * @param prePermissionId
	 * @param preWareId
	 * @return
	 * @throws Exception
	 */
	public static String updatePermissionWareRlt(long permissionId, long wareId, String startTime, String endTime,String optType,long prePermissionId, long preWareId) throws Exception{
		

		String retVal = "";
		try {
			IPermissionInfoValue infoValue =getPermissionInfo(permissionId);
			ValidateRuleValueToHP value = new ValidateRuleValueToHP();
			value.setOptType(optType);
			
			value.setPreActionID(CoreConstant.ORDER_ZERO_ACTION_TYPE+prePermissionId);
			value.setPreItemID(getItemID(preWareId));
			
			value.setActionID(CoreConstant.ORDER_ZERO_ACTION_TYPE + permissionId);
			value.setRuleName(infoValue.getPermissionName());
			// mobile 需要转码
			value.setSupportBrand(AiHpInterUtil.formatMobileBrandHPCood(infoValue.getMobileBrandCode()));
			value.setSupportStarLevel(AiHpInterUtil.formatStarLevelHPCood(infoValue.getMobileBrandCode()));
			value.setItemID(getItemID(wareId));
			value.setActionStartTime(convertTimestampToStr(DateTimeUtil.stringToTimestamp(startTime,
					"yyyy-MM-dd HH:mm:ss")));
			value.setActionEndTime(convertTimestampToStr(DateTimeUtil.stringToTimestamp(endTime,
					"yyyy-MM-dd HH:mm:ss")));
			value.setOrgID(AiHpInterUtil.supportTypeConverter(infoValue.getExchangeChannel()));
			value.setOrderStatus(infoValue.getOrderStatus());
			value.setItemScope(infoValue.getItemScope());
			value.setOrderNum(infoValue.getOrderNum());
			log.info("infoValue.getMaxItemNum() === " + infoValue.getMaxItemNum());
			log.info("infoValue.getMaxTimes()===" + infoValue.getMaxTimes());
			value.setMaxItemNum(infoValue.getMaxItemNum());
			value.setMaxTimes(infoValue.getMaxTimes());
			value.setOrderStartTime(convertTimestampToStr(infoValue.getOrderStartTime()));
			value.setOrderEndTime(convertTimestampToStr(infoValue.getOrderEndTime()));
			value.setOrderStatus(infoValue.getOrderStatus());
			value.setIsSpread(getIsSpreadHPValue(infoValue.getIsSpread()));
			value.setActionPoint((int) infoValue.getWareGmeValue());
			value.setProvinceID(AiHpInterUtil.getHPProvinceCodeByAICode(getCodesById(permissionId, "03")));
			value.setExchangeItemID(getCodesById(permissionId, "02"));
			value.setVendorID(getCodesById(permissionId, "01"));
			value.setType3(getCodesById(permissionId, "00"));
			value.setOrderScope(infoValue.getOrderScope());
			value.setPayType(inerPayType(queryMixOfPayType(infoValue.getPayType(), wareId), wareId));
			value.setPayCash(infoValue.getPayCash());
			value.setPayIntegral(infoValue.getPayIntegral());
			
			// 同步给HP
			retVal = SynDataToHpUtil.synchronousValidateRuleToHP(value);
		} catch (Exception e) {
			log.error("优惠规则同步HP的时候，调用HP接口出错了..." + e.getMessage(), e);
			throw e;
		}
		return retVal;
	}
	/**
	 * 获取传递HP的编码
	 * 
	 * @param wareId
	 * @return
	 * @throws Exception
	 */
	public static String getItemID(long wareId) throws Exception {
		IWareInfoSrv wareInfoSrv = (IWareInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_WARE_INFO);
		// 根据ID，获得礼品信息
		IWareInfoValue wareValue = wareInfoSrv.getBean(wareId);
		// 肯定能取到一个礼品的实体bean，但是如果没有记录，就没有礼品编码
		if (null == wareValue || StringUtil.isBlank(wareValue.getWareCode())) {
			throw new WarePermissionHPInterException(" the wareId " + wareId + " not exists the items in ware_info..");
		}
		return wareValue.getWareCode();
	}
	/**
	 * 根据规则标识获取规则信息
	 * @param permissionId
	 * @return
	 * @throws Exception
	 */
	public static IPermissionInfoValue getPermissionInfo(long permissionId) throws Exception {
		IWarePermissionInfoSrv service = (IWarePermissionInfoSrv) ServiceFactory
				.getService(CoreSrvContstant.SERVICE_CORE_SYS_PERMISSION_RULE_SRV);
		IPermissionInfoValue infoValue = service.getPermissionInfoValueById(permissionId);
		return infoValue;
	}
	/**
	 * 搜程序没有用
	 * @param permissionId
	 * @param wareId
	 * @param startTime
	 * @param endTime
	 * @param optType
	 * @param wareBindRuleRltId
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public static String synPermissionRuleToHp(long permissionId, long wareId, String startTime, String endTime,String optType,long wareBindRuleRltId) throws Exception{
		IWarePermissionInfoSrv service  = (IWarePermissionInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_SYS_PERMISSION_RULE_SRV);
		IWareInfoSrv wareInfoSrv = (IWareInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_WARE_INFO);
		//根据ID，获得礼品信息
		IWareInfoValue wareValue  = wareInfoSrv.getBean(wareId);
		
		//肯定能取到一个礼品的实体bean？但是如果没有记录，就没有礼品编码
		if(null == wareValue || StringUtil.isBlank(wareValue.getWareCode())){
			throw new WarePermissionHPInterException(" the wareId "+wareId +" not exists the items in ware_info..");
		}
		String retVal  ="";
		try {
			IPermissionInfoValue infoValue = service.getPermissionInfoValueById(permissionId);
			
			
			  ValidateRuleValueToHP value = new ValidateRuleValueToHP();
			  value.setOptType(optType);
			
			  value.setActionID(CoreConstant.ORDER_ZERO_ACTION_TYPE+wareBindRuleRltId );
			  value.setRuleName(infoValue.getPermissionName());
			 
			  //mobile 需要转码
			  value.setSupportBrand(AiHpInterUtil.formatMobileBrandHPCood(infoValue.getMobileBrandCode()));
			  value.setSupportStarLevel(AiHpInterUtil.formatStarLevelHPCood(infoValue.getMobileBrandCode()));
			  value.setItemID(wareValue.getWareCode());
			  //DateTimeUtil.stringToTimestamp(orderStartTime, "yyyy-MM-dd HH:mm:ss")
			  value.setActionStartTime(convertTimestampToStr(DateTimeUtil.stringToTimestamp(startTime, "yyyy-MM-dd HH:mm:ss")));
			  value.setActionEndTime(convertTimestampToStr(DateTimeUtil.stringToTimestamp(endTime, "yyyy-MM-dd HH:mm:ss")));
			  value.setOrgID(AiHpInterUtil.supportTypeConverter(infoValue.getExchangeChannel()));
			  value.setOrderStatus(infoValue.getOrderStatus());
			  value.setItemScope(infoValue.getItemScope());
			  value.setOrderNum(infoValue.getOrderNum());
			  log.info("infoValue.getMaxItemNum() === "+infoValue.getMaxItemNum());
			  log.info("infoValue.getMaxTimes()==="+infoValue.getMaxTimes());
			  value.setMaxItemNum(infoValue.getMaxItemNum());
			  value.setMaxTimes(infoValue.getMaxTimes());
			  
			  value.setOrderStartTime(convertTimestampToStr(infoValue.getOrderStartTime()));
			  value.setOrderEndTime(convertTimestampToStr(infoValue.getOrderEndTime()));
			  
			  value.setPayType(inerPayType(queryMixOfPayType(infoValue.getPayType(), wareId), wareId));
			  value.setPayCash(infoValue.getPayCash());
			  value.setPayIntegral(infoValue.getPayIntegral());
			  
			  value.setOrderStatus(infoValue.getOrderStatus());
			  value.setOrderScope(infoValue.getOrderScope());
			  //====================================================================
			  // 满足复杂资格判定的优惠礼品短信推广需求开发   2012/09/11  liuyq
			  //同步的时候，对于是否支持优惠礼品的短信推广  00 不支持  01 支持
			  // 数据库中存储为   1 是    ； 0 否
			  //那么 1 转成01    0 转成 00
			  
			  value.setIsSpread(getIsSpreadHPValue(infoValue.getIsSpread()));
			  //优惠礼品的积分值   这里long -->> int 强转型
			  value.setActionPoint((int)infoValue.getWareGmeValue());
			  //====================================================================
			  //适用省份
			  
			  //适用礼品小类
			  
			  //适用礼品商
			  
			  //适用特殊礼品
			  //省编码需要转码 
			  value.setProvinceID(AiHpInterUtil.getHPProvinceCodeByAICode(getCodesById(permissionId,"03")));
			  value.setExchangeItemID(getCodesById(permissionId,"02"));
			  value.setVendorID(getCodesById(permissionId,"01"));
			  value.setType3(getCodesById(permissionId,"00"));

			  //同步给HP
			  retVal = SynDataToHpUtil.synchronousValidateRuleToHP(value);
		} catch (Exception e) {
			log.error("优惠规则同步HP的时候，调用HP接口出错了..."+e.getMessage(),e);
			throw e;
		}
		return retVal;
	}
	
	
	/**
	 * 根据AI方面的isSpread 是否支持优惠礼品短信推广 转换成为HP方的数值
	 * @param aiIsSpreadValue
	 * 
	 * @return
	 */
	private static String getIsSpreadHPValue(String aiIsSpreadValue){
		//默认是不支持？ 这点需求没有提
		String hpIsSpreadValue = "00";
		
		if("1".equals(aiIsSpreadValue)){
			hpIsSpreadValue = "01";
		}else if("0".equals(aiIsSpreadValue)){
			hpIsSpreadValue  = "00";
		}
		return hpIsSpreadValue;
	}
	public static String getCodesById(long permissionId,String typeCode)throws Exception{
		String retVal = null;
		StringBuffer buffer = new StringBuffer();
		IWarePermissionInfoSrv service  = (IWarePermissionInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_SYS_PERMISSION_RULE_SRV);
		IPermissionTypeInfoValue []values = service.getPermissionTypeInfoValuesById(permissionId, typeCode);
		
		if(null != values && values.length > 0 ){
			int i=0;
			for(i=0;i<values.length;i++){
				buffer.append(values[i].getPermissionCode()+",");
			}
			if(0!=i){
				retVal = buffer.substring(0,buffer.length()-1);
			}
		}
		return retVal;
	}
	
	
	
	/**
	 * 将Timestamp 时间转换成为字符串
	 * 例如：2011-8-31 12:51:36 转换成为20110831125136
	 * @param time
	 * @return
	 */
	public static String convertTimestampToStr(Timestamp time){
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return df.format(time);
	}
}
