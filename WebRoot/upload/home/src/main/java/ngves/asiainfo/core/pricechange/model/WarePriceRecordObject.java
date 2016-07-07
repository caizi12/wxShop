package ngves.asiainfo.core.pricechange.model;

import java.io.Serializable;
/**
 * 礼品价格变化记录对象
 * @author WL
 *
 */
public class WarePriceRecordObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1073039035309046264L;
	/**
	 * 
	 */
	/**
	 * 业务标识
	 */
	private long busiId;

	/**
	 * 业务标识
	 */
	private String busiTypeId;
	/**
	 * 礼品ID
	 */
	private long wareId;
	/**
	 * 市场价
	 */
	private long marketPrice;
	/**
	 * 结算价
	 */
	private long countValue;
	/**
	 * 礼品统一积分值
	 */
	private long wareIntegralValue;
	/**
	 * 混合支付的积分值
	 */
	private long payIntegralValue;
	
	/**
	 * 混合支付的现金值
	 * 数据库中以*100的方式存入的。因此在现实时，需要除以100
	 */
	private long payCashValue;

	/**
	 * 修改前
	 */
	private long beginValue;
	
	/**
	 * 修改后
	 */
	private long afterValue;
	
	/**
	 * @return the beginValue
	 */
	public long getBeginValue() {
		return beginValue;
	}
	/**
	 * @param beginValue the beginValue to set
	 */
	public void setBeginValue(long beginValue) {
		this.beginValue = beginValue;
	}
	/**
	 * @return the afterValue
	 */
	public long getAfterValue() {
		return afterValue;
	}
	/**
	 * 
	 * @param afterValue the afterValue to set
	 */
	public void setAfterValue(long afterValue) {
		this.afterValue = afterValue;
	}
	/**
	 * @param serialVersionUID the serialVersionUID to set
	 */

	/**
	 * 操作人标识
	 */
	private long operateId;
	
	/**
	 * 审核人标识
	 */
	private long check_id;
	/**
	 * 操作原因（所属模块）
	    00：礼品新增
		01：礼品修改
		02：礼品批量更新
		04：礼品业务属性配置
		05：礼品积分换算规则
	 */
	private String operateCause;
	/**
	 * 操作时间
	 */
	private String operateDate;
	
	/**
	 * 审核时间
	 */
	private String checkDate;

	/**
	 * @return the checkDate
	 */
	public String getCheckDate() {
		if(this.checkDate == null ){
			this.checkDate = "";
		}
		return checkDate;
	}
	/**
	 * @param checkDate the checkDate to set
	 */
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	public long getBusiId() {
		return busiId;
	}
	public void setBusiId(long busiId) {
		this.busiId = busiId;
	}
	public long getWareId() {
		return wareId;
	}
	public void setWareId(long wareId) {
		this.wareId = wareId;
	}
	public long getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(long marketPrice) {
		this.marketPrice = marketPrice;
	}
	public long getCountValue() {
		return countValue;
	}
	public void setCountValue(long countValue) {
		this.countValue = countValue;
	}
	public long getWareIntegralValue() {
		return wareIntegralValue;
	}
	public void setWareIntegralValue(long wareIntegralValue) {
		this.wareIntegralValue = wareIntegralValue;
	}
	public long getPayIntegralValue(){
		return payIntegralValue;
	}
	public void setPayIntegralValue(long payIntegralValue){
		this.payIntegralValue = payIntegralValue;
	}
	public long getPayCashValue() {
		return payCashValue;
	}
	public void setPayCashValue(long payCashValue) {
		this.payCashValue = payCashValue;
	}
	public long getOperateId() {
		return operateId;
	}
	public void setOperateId(long operateId) {
		this.operateId = operateId;
	}
	public long getCheck_id() {
		return check_id;
	}
	public void setCheck_id(long check_id) {
		this.check_id = check_id;
	}
	public String getOperateCause() {
		return operateCause;
	}
	public void setOperateCause(String operateCause) {
		this.operateCause = operateCause;
	}
	public String getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * @return the busiTypeId
	 */
	public String getBusiTypeId() {
		return busiTypeId;
	}
	/**
	 * @param busiTypeId the busiTypeId to set
	 */
	public void setBusiTypeId(String busiTypeId) {
		this.busiTypeId = busiTypeId;
	}

	/**
	 * @param busiId
	 * @param wareId
	 * @param marketPrice
	 * @param countValue
	 * @param wareIntegralValue
	 * @param operateId
	 * @param check_id
	 * @param operateCause
	 * @param operateDate
	 */
	public WarePriceRecordObject(long busiId, long wareId, long marketPrice, long countValue,
			long wareIntegralValue,long payIntegralValue, long operateId, long check_id, String operateCause, String operateDate) {
		super();
		this.busiId = busiId;
		this.wareId = wareId;
		this.marketPrice = marketPrice;
		this.countValue = countValue;
		this.wareIntegralValue = wareIntegralValue;
		this.payIntegralValue = payIntegralValue;
		this.operateId = operateId;
		this.check_id = check_id;
		this.operateCause = operateCause;
		this.operateDate = operateDate;
	}
	public WarePriceRecordObject(){
	}
}
