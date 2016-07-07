package ngves.asiainfo.core.ware.util;

import java.sql.Timestamp;
import java.text.DecimalFormat;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.ware.WareConstant;
import ngves.asiainfo.core.ware.model.ValidateRuleValueToHP;
import ngves.asiainfo.interfaces.hp.bean.validateRuleIncSyn.in.ValidateRuleIncSynInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.validateRuleIncSyn.in.ValidateRuleIncSynInDisableInfo;
import ngves.asiainfo.interfaces.hp.bean.validateRuleIncSyn.in.ValidateRuleIncSynInExchangeItemInfo;
import ngves.asiainfo.interfaces.hp.bean.validateRuleIncSyn.in.ValidateRuleIncSynInExchangeItemList;
import ngves.asiainfo.interfaces.hp.bean.validateRuleIncSyn.in.ValidateRuleIncSynInOrderScopeList;
import ngves.asiainfo.interfaces.hp.bean.validateRuleIncSyn.in.ValidateRuleIncSynInProvinceInfo;
import ngves.asiainfo.interfaces.hp.bean.validateRuleIncSyn.in.ValidateRuleIncSynInProvinceList;
import ngves.asiainfo.interfaces.hp.bean.validateRuleIncSyn.in.ValidateRuleIncSynInRuleInfo;
import ngves.asiainfo.interfaces.hp.bean.validateRuleIncSyn.in.ValidateRuleIncSynInType3Info;
import ngves.asiainfo.interfaces.hp.bean.validateRuleIncSyn.in.ValidateRuleIncSynInType3List;
import ngves.asiainfo.interfaces.hp.bean.validateRuleIncSyn.in.ValidateRuleIncSynInVendorInfo;
import ngves.asiainfo.interfaces.hp.bean.validateRuleIncSyn.in.ValidateRuleIncSynInVendorList;
import ngves.asiainfo.interfaces.hp.bean.validateRuleIncSyn.out.ValidateRuleIncSynOutBizRegReq;
import ngves.asiainfo.interfaces.hp.realtime.ValidateRuleIncSynInter;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * synchronousValidateRuleToHP 当礼品绑定优惠规则后保存时，同步给HP
 * <p/>
 * <p/>
 * 工具类
 *
 * @author :shenfl@asiainfo-linkage.com
 * @date: 2011-11-14
 */
public class SynDataToHpUtil { 

    private static transient Log log = LogFactory.getLog(SynDataToHpUtil.class);
   /**
     * 同步校验规则给HP
     * 
     * @param value
     * @return
     * @throws Exception
     * @modify by shenfl 新增ActionID和ActionName字段 
     */
    public static String synchronousValidateRuleToHP(ValidateRuleValueToHP value) throws Exception {

        String retValue = "";
        String retMsg;
        ValidateRuleIncSynInBizRegReq in = ValidateRuleIncSynInter.getValidateRuleIncSynInter();
        ValidateRuleIncSynInDisableInfo disableInfo = null;
        ValidateRuleIncSynInOrderScopeList orderScopeList = null;
        ValidateRuleIncSynInRuleInfo ruleInfo = null;
        //类型信息
        in.setOptType(value.getOptType());
        //01新增；02修改 03：删除
        if(WareConstant.SYS_PERMISSION_HP_INTER_OPT_TYPE_DELETE.equals(value.getOptType()) ) {
        	disableInfo = in.addNewDisableInfo();
            disableInfo.setActionID(value.getPreActionID());
            disableInfo.setItemID(value.getPreItemID());
        }else{
        	if(WareConstant.SYS_PERMISSION_HP_INTER_OPT_TYPE_MODIFY.equals(value.getOptType()) ) {
        		 disableInfo = in.addNewDisableInfo();
                 disableInfo.setActionID(value.getPreActionID());
                 disableInfo.setItemID(value.getPreItemID());
        	}
        	ruleInfo = in.addNewRuleInfo();
	        //新增信息列表
	        ruleInfo.setActionID(value.getActionID());
	        ruleInfo.setActionName(value.getRuleName());
	        //关联规则对应的规则名称 2013-03-22
	        ruleInfo.setItemID(value.getItemID());
	        ruleInfo.setActionStartTime(value.getActionStartTime());
	        ruleInfo.setActionEndTime(value.getActionEndTime());
	        ruleInfo.setOrgID(value.getOrgID());
	        //ruleInfo.setOrderStatus(value.getOrderStatus());
	        // 订单类型
	        ruleInfo.setOrderType(value.getOrderStatus());
	        orderScopeList = ruleInfo.addNewOrderScopeList();
	        String[] orderScopes =value.getOrderScope().split(CoreConstant.STRING_SPLIT_COMMA);
	    
	        if(CoreConstant.ALL_ORDER_SCOPE.equals(value.getOrderStatus())){
	        	if(CoreConstant.SEL_ALL_ORDER_SCOPE.equals(value.getOrderScope())){
	        		orderScopeList.setOrderScopeArray(new String[]{"099"});
	        		//099
	        	}else{
	        	    orderScopeList.setOrderScopeArray(orderScopes);
	        	}
	        }else if(CoreConstant.VALID_ORDER_SCOPE.equals(value.getOrderStatus())){
	        	if(CoreConstant.SEL_VALID_ORDER_SCOPE.equals(value.getOrderScope())){
	        		orderScopeList.setOrderScopeArray(new String[]{"199"});
	        		//199
	        	}else{
	        	    orderScopeList.setOrderScopeArray(orderScopes);
	        	}
	        }
	        ruleInfo.setItemScope(value.getItemScope());
	        ruleInfo.setOrderNum(value.getOrderNum() + "");
	        ruleInfo.setOrderStartTime(value.getOrderStartTime());
	        ruleInfo.setOrderEndTime(value.getOrderEndTime());
	        //最大优惠次数	用户参与优惠的最大次数，无次数限制则默认值为：-1
	        
	        //混合支付
        	ruleInfo.setItemPayType(value.getPayType());
 	        ruleInfo.setActionPayPoint((int)value.getPayIntegral());
 	        double payCash=value.getPayCash()/100.00;
 	        DecimalFormat df = new DecimalFormat("0.00");
 	        ruleInfo.setActionPayCash(df.format(payCash));

	        if( 0 == value.getMaxTimes()){
	        	ruleInfo.setMaxTimes("-1");
	        }else{
	        	ruleInfo.setMaxTimes(String.valueOf(value.getMaxTimes()));
	        }
	        //该礼品总的最大兑换数量	无最大礼品数限制则默认值为：-1
	        if(0 == value.getMaxItemNum()){
	        	ruleInfo.setMaxItemNum("-1");
	        }else{
	        	ruleInfo.setMaxItemNum(String.valueOf(value.getMaxItemNum()));
	        }
	        
	        //支持优惠类型
	        //优惠类型已经取消 2 校验规则增量同步接口，删除SupportType节点。请知悉。// 婉颖
	
	        //in.setSupportType(value.getSupportType());
	        //支持品牌范围，转换成HP格式的代码
	       // String SEND_HP_USERBRAND = formatMobileBrandHPCood(value.getSupportBrand());
	        //所有数据，接口礼品都不进行转码
	        ruleInfo.setSupportBrand(value.getSupportBrand());
	        ruleInfo.setSupportStarLevel(value.getSupportStarLevel());
	       
	        //2012/09/12 新增节点 是否支持短信推广 
	        ruleInfo.setIsSpread(value.getIsSpread());
	        //2012/09/12 新增节点  优惠积分值
	        ruleInfo.setActionPoint(value.getActionPoint());
	        
	        if (!StringUtil.isBlank(value.getProvinceID())) {
	            // 获取对应的省列表 ,通过逗号获取所有支持的省份bj
	            String[] provinceIDs = value.getProvinceID().split(CoreConstant.STRING_SPLIT_COMMA);
	            ValidateRuleIncSynInProvinceInfo provinceInfo = ruleInfo.addNewProvinceInfo();
	            for (String provinceID : provinceIDs) {
	                ValidateRuleIncSynInProvinceList provinceList = provinceInfo.addNewProvinceList();
	                provinceList.setProvinceID(provinceID);
	
	            }
	        }
	        
	
	        if (!StringUtil.isBlank(value.getType3())) {
	            String[] type3s = value.getType3().split(CoreConstant.STRING_SPLIT_COMMA);
	            ValidateRuleIncSynInType3Info type3Info = ruleInfo.addNewType3Info();
	            for (String type3 : type3s) {
	                ValidateRuleIncSynInType3List type3List = type3Info.addNewType3List();
	                type3List.setType3(type3);
	            }
	        }
	
	        if (!StringUtil.isBlank(value.getVendorID())) {
	            String[] vendorIDs = value.getVendorID().split(CoreConstant.STRING_SPLIT_COMMA);
	            ValidateRuleIncSynInVendorInfo vendorInfo = ruleInfo.addNewVendorInfo();
	            for (String vendorID : vendorIDs) {
	                ValidateRuleIncSynInVendorList vendorList = vendorInfo.addNewVendorList();
	                vendorList.setVendorID(vendorID);
	            }
	        }
	        if (!StringUtil.isBlank(value.getExchangeItemID())) {
	            String[] exchangeItemIDs = value.getExchangeItemID().split(CoreConstant.STRING_SPLIT_COMMA);
	            ValidateRuleIncSynInExchangeItemInfo itemInfo = ruleInfo.addNewExchangeItemInfo();
	            for (String exchangeItemID : exchangeItemIDs) {
	                ValidateRuleIncSynInExchangeItemList itemList = itemInfo.addNewExchangeItemList();
	                itemList.setExchangeItemID(exchangeItemID);
	            }
	        }
        }

        ValidateRuleIncSynOutBizRegReq out = null;
        try {
            out = ValidateRuleIncSynInter.doBusi(in);
            retValue = out.getRejectReason();
            retMsg = out.getErrorMsg();
            log.debug("rejectReasion of HP==>" + retValue);
            log.debug("errorMsg of HP==>" + retMsg);
        } catch (Exception e) {
            log.error("Called ValidateRuleIncSynInter of HP error:" + e);
            throw new Exception("============ Called ValidateRuleIncSynInter of HP Exception!");
        }
        return retValue;
    }

    
   
    /**
     * 当前时间和开始时间相差的天数
     *
     * @param startTime 活动开始时间
     * @param endTime   活动结束时间
     * @param timeAsNow 系统时间
     * @return -1 默认不进行数据的同步操作
     * @throws Exception
     * @author:shenfl@asiainfo-linkage.com
     * @date: 2011-11-15
     */
    public static String validateRuleSynFlag(String startTime, String endTime, long timeAsNow) throws Exception {

        String flag = "-1";//默认数值
        Timestamp start_time = DateTimeUtil.stringToTimestamp(startTime, "yyyy-MM-dd HH:mm:ss");
        Timestamp end_time = DateTimeUtil.stringToTimestamp(endTime, "yyyy-MM-dd HH:mm:ss");
        // 当前时间在活动范围内
        if (timeAsNow >= start_time.getTime() && timeAsNow <= end_time.getTime()) {
            flag = formatDuring(timeAsNow - start_time.getTime());
        }
        return flag;
    }

    public static String formatDuring(long mss) {
        long days = mss / (1000 * 60 * 60 * 24);
        return days + "";
    }

    public static void main(String[] args) {
        String startTime = "";
        String endTime = "";
        startTime = "2011-11-25 00:00:00";
        endTime = "2011-12-14 23:59:59";

        try {

            String day = validateRuleSynFlag(startTime, endTime, System.currentTimeMillis());
            System.out.print("leftDay  = " + day);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

}
