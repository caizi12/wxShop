package ngves.asiainfo.core.ware.model;

import java.io.Serializable;

import com.google.gson.Gson;
/**
 * 封装优惠规则信息页面的VO
 * @author asiainfo
 *
 */
public class PermissionInfoVOBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//优惠规则的基本信息
	private long permissionId         ;
	private String permissionName       =	null;
	private String optType              =	null;
	private String exchangeChannel      =	null;
	private String supportType          =	null;
	private String orderStatus          =	null;
	private String itemScope            =	null;
	private long orderNum             ;
	private String orderStartTime       =	null;
	private String orderEndTime         =	null;
	private long maxTimes             ;
	private long maxItemNum          ;
	private String createTime           =	null;
	private String mobileBrandCode      =	null;
	private long wareGmeValue        ;
	
	//规则适用省份/规则适用礼品小类/规则适用礼品商/规则适用特殊礼品的真实编码
	private String ruleProvince			=	null;
	private String ruleSubKind			=	null;
	private String rulePartnerCode		=	null;
	private String ruleWareCode			=	null;
	
	//四个编码的展示值
	private String ruleProvinceView		=	null;
	private String ruleSubKindView		=	null;
	private String rulePartnerCodeView	=	null;
	private String ruleWareCodeView		=	null;
	
	
	// added by 满足复杂资格判定的优惠礼品短信推广 2012/09/11 
	//是否支持优惠礼品短信推广
	private String isSpread = null;
	
	//混合支付新增字段
	private String payType;
	private long payIntegral;
	private long payCash;
	private String orderScope;
	private String orderScopeView;
	
	public String getOrderScope() {
		return orderScope;
	}

	public void setOrderScope(String orderScope) {
		this.orderScope = orderScope;
	}

	public String getOrderScopeView() {
		return orderScopeView;
	}

	public void setOrderScopeView(String orderScopeView) {
		this.orderScopeView = orderScopeView;
	}
	public String getPayType() {
		return payType;
	}




	public void setPayType(String payType) {
		this.payType = payType;
	}




	public long getPayIntegral() {
		return payIntegral;
	}




	public void setPayIntegral(long payIntegral) {
		this.payIntegral = payIntegral;
	}




	public long getPayCash() {
		return payCash;
	}




	public void setPayCash(long payCash) {
		this.payCash = payCash;
	}




	/**
	 * @return the isSpread
	 */
	public String getIsSpread() {
		return isSpread;
	}




	/**
	 * @param isSpread the isSpread to set
	 */
	public void setIsSpread(String isSpread) {
		this.isSpread = isSpread;
	}




	/**
	 * 转成JSON格式的数据
	 * @param value
	 * @return
	 */
	public String toJson(){
		Gson gson = new Gson();

		//System.out.println("json is ====>>>" + gson.toJson(this));
		return gson.toJson(this);
	}




	/**
	 * @return the permissionId
	 */
	public long getPermissionId() {
		return permissionId;
	}




	/**
	 * @param permissionId the permissionId to set
	 */
	public void setPermissionId(long permissionId) {
		this.permissionId = permissionId;
	}




	/**
	 * @return the permissionName
	 */
	public String getPermissionName() {
		return permissionName;
	}




	/**
	 * @param permissionName the permissionName to set
	 */
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}




	/**
	 * @return the optType
	 */
	public String getOptType() {
		return optType;
	}




	/**
	 * @param optType the optType to set
	 */
	public void setOptType(String optType) {
		this.optType = optType;
	}




	/**
	 * @return the exchangeChannel
	 */
	public String getExchangeChannel() {
		return exchangeChannel;
	}




	/**
	 * @param exchangeChannel the exchangeChannel to set
	 */
	public void setExchangeChannel(String exchangeChannel) {
		this.exchangeChannel = exchangeChannel;
	}




	/**
	 * @return the supportType
	 */
	public String getSupportType() {
		return supportType;
	}




	/**
	 * @param supportType the supportType to set
	 */
	public void setSupportType(String supportType) {
		this.supportType = supportType;
	}




	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}




	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}




	/**
	 * @return the itemScope
	 */
	public String getItemScope() {
		return itemScope;
	}




	/**
	 * @param itemScope the itemScope to set
	 */
	public void setItemScope(String itemScope) {
		this.itemScope = itemScope;
	}




	



	/**
	 * @return the orderNum
	 */
	public long getOrderNum() {
		return orderNum;
	}




	/**
	 * @param orderNum the orderNum to set
	 */
	public void setOrderNum(long orderNum) {
		this.orderNum = orderNum;
	}




	/**
	 * @return the orderStartTime
	 */
	public String getOrderStartTime() {
		return orderStartTime;
	}




	/**
	 * @param orderStartTime the orderStartTime to set
	 */
	public void setOrderStartTime(String orderStartTime) {
		this.orderStartTime = orderStartTime;
	}




	/**
	 * @return the orderEndTime
	 */
	public String getOrderEndTime() {
		return orderEndTime;
	}




	/**
	 * @param orderEndTime the orderEndTime to set
	 */
	public void setOrderEndTime(String orderEndTime) {
		this.orderEndTime = orderEndTime;
	}




	/**
	 * @return the maxTimes
	 */
	public long getMaxTimes() {
		return maxTimes;
	}




	/**
	 * @param maxTimes the maxTimes to set
	 */
	public void setMaxTimes(long maxTimes) {
		this.maxTimes = maxTimes;
	}




	/**
	 * @return the maxItemNum
	 */
	public long getMaxItemNum() {
		return maxItemNum;
	}




	/**
	 * @param maxItemNum the maxItemNum to set
	 */
	public void setMaxItemNum(long maxItemNum) {
		this.maxItemNum = maxItemNum;
	}




	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}




	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}




	/**
	 * @return the mobileBrandCode
	 */
	public String getMobileBrandCode() {
		return mobileBrandCode;
	}




	/**
	 * @param mobileBrandCode the mobileBrandCode to set
	 */
	public void setMobileBrandCode(String mobileBrandCode) {
		this.mobileBrandCode = mobileBrandCode;
	}




	/**
	 * @return the wareGmeValue
	 */
	public long getWareGmeValue() {
		return wareGmeValue;
	}




	/**
	 * @param wareGmeValue the wareGmeValue to set
	 */
	public void setWareGmeValue(long wareGmeValue) {
		this.wareGmeValue = wareGmeValue;
	}




	/**
	 * @return the ruleProvince
	 */
	public String getRuleProvince() {
		return ruleProvince;
	}




	/**
	 * @param ruleProvince the ruleProvince to set
	 */
	public void setRuleProvince(String ruleProvince) {
		this.ruleProvince = ruleProvince;
	}




	/**
	 * @return the ruleSubKind
	 */
	public String getRuleSubKind() {
		return ruleSubKind;
	}




	/**
	 * @param ruleSubKind the ruleSubKind to set
	 */
	public void setRuleSubKind(String ruleSubKind) {
		this.ruleSubKind = ruleSubKind;
	}




	/**
	 * @return the rulePartnerCode
	 */
	public String getRulePartnerCode() {
		return rulePartnerCode;
	}




	/**
	 * @param rulePartnerCode the rulePartnerCode to set
	 */
	public void setRulePartnerCode(String rulePartnerCode) {
		this.rulePartnerCode = rulePartnerCode;
	}




	/**
	 * @return the ruleWareCode
	 */
	public String getRuleWareCode() {
		return ruleWareCode;
	}




	/**
	 * @param ruleWareCode the ruleWareCode to set
	 */
	public void setRuleWareCode(String ruleWareCode) {
		this.ruleWareCode = ruleWareCode;
	}




	/**
	 * @return the ruleProvinceView
	 */
	public String getRuleProvinceView() {
		return ruleProvinceView;
	}




	/**
	 * @param ruleProvinceView the ruleProvinceView to set
	 */
	public void setRuleProvinceView(String ruleProvinceView) {
		this.ruleProvinceView = ruleProvinceView;
	}




	/**
	 * @return the ruleSubKindView
	 */
	public String getRuleSubKindView() {
		return ruleSubKindView;
	}




	/**
	 * @param ruleSubKindView the ruleSubKindView to set
	 */
	public void setRuleSubKindView(String ruleSubKindView) {
		this.ruleSubKindView = ruleSubKindView;
	}




	/**
	 * @return the rulePartnerCodeView
	 */
	public String getRulePartnerCodeView() {
		return rulePartnerCodeView;
	}




	/**
	 * @param rulePartnerCodeView the rulePartnerCodeView to set
	 */
	public void setRulePartnerCodeView(String rulePartnerCodeView) {
		this.rulePartnerCodeView = rulePartnerCodeView;
	}




	/**
	 * @return the ruleWareCodeView
	 */
	public String getRuleWareCodeView() {
		return ruleWareCodeView;
	}




	/**
	 * @param ruleWareCodeView the ruleWareCodeView to set
	 */
	public void setRuleWareCodeView(String ruleWareCodeView) {
		this.ruleWareCodeView = ruleWareCodeView;
	}
	

}
