package ngves.asiainfo.core.sendverifycode.bo;

import ngves.asiainfo.core.sendverifycode.ivalues.IConsumerCodeValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class ConsumerCodeBean extends DataContainer implements
			DataContainerInterface, IConsumerCodeValue{
	
	private static final long serialVersionUID = 1L;
	
	private static String m_boName = "ngves.asiainfo.core.sendverifycode.bo.ConsumerCode";
	
	
	public final static  String S_OrderID ="ORDER_ID";//大订单编号
	public final static  String S_SuborderID ="SUBORDER_ID";//子订单号	
	public final static  String S_OrderNum ="ORDER_NUM";//大订单编号
	public final static  String S_SuborderNum ="SUBORDER_NUM";//子订单号
	public final static  String S_Mobile ="MOBILE";//手机号
	public final static  String S_ItemID ="ITEM_ID";//礼品编码
	public final static  String S_ItemName ="ITEM_NAME";//礼品名称
	public final static  String S_VendorName="VENDOR_NAME";//礼品商名称
	public final static  String S_ConsumerCode ="CONSUMER_CODE";//串码
	public final static  String S_ValidateTime ="VALIDATE_TIME";//串码截止日期
	public final static  String S_RemaindDays ="REMAIND_DAYS";//剩余天数
	public final static  String S_Status ="STATUS";//串码状态
	public final static  String S_SendTime ="SEND_TIME";//最后一次发码时间
	public final static  String S_Sender ="SENDER";//最后一次发码操作人
	public final static  String S_SendNum="SEND_NUM";//发送次数
	public final static  String S_ConsumeOperator ="CONSUME_OPERATOR";//验码操作人
	public final static  String S_ShopCode ="SHOP_CODE";//验码门点商编码
	public final static  String S_ConsumeOptime ="CONSUME_OPTIME";//验码操作时间
	public final static  String S_BakCol ="BAK_COL";//备用字段1
	public final static  String S_BakCol2 ="BAK_COL2";//备用字段2
	
	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory()
					.getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public ConsumerCodeBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}
	public String getBakCol() {	
		return DataType.getAsString(this.get(S_BakCol));
	}

	public String getBakCol2() {
		return DataType.getAsString(this.get(S_BakCol2));
	}

	public String getConsumeOperator() {	
		return DataType.getAsString(this.get(S_ConsumeOperator));
	}

	public String getConsumeOptime() {
		return DataType.getAsString(this.get(S_ConsumeOptime));
	}

	public String getConsumerCode() {
		return DataType.getAsString(this.get(S_ConsumerCode));
	}

	public String getItemID() {
		return DataType.getAsString(this.get(S_ItemID));
	}

	public String getItemName() {
		return DataType.getAsString(this.get(S_ItemName));
	}

	public String getMobile() {
		return DataType.getAsString(this.get(S_Mobile));
	}

	public String getOrderID() {
		return DataType.getAsString(this.get(S_OrderID));
	}
	public String getOrderNum() {
		return DataType.getAsString(this.get(S_OrderNum));
	}
	public String getRemaindDays() {
		return DataType.getAsString(this.get(S_RemaindDays));
	}

	public String getSendNum() {
		return DataType.getAsString(this.get(S_SendNum));
	}

	public String getSendTime() {
		return DataType.getAsString(this.get(S_SendTime));
	}

	public String getSender() {
		return DataType.getAsString(this.get(S_Sender));
	}

	public String getShopCode() {
		return DataType.getAsString(this.get(S_ShopCode));
	}

	public String getStatus() {
		return DataType.getAsString(this.get(S_Status));
	}

	public String getSuborderID() {
		return DataType.getAsString(this.get(S_SuborderID));
	}
	public String getSuborderNum() {
		return DataType.getAsString(this.get(S_SuborderNum));
	}
	public String getValidateTime() {
		return DataType.getAsString(this.get(S_ValidateTime));
	}

	public String getVendorName() {
		return DataType.getAsString(this.get(S_VendorName));
	}

	public void setConsumeOperator(String value) {
		this.set(S_ConsumeOperator, value);
		
	}

	public void setConsumeOptime(String value) {
		this.set(S_ConsumeOptime, value);
		
	}

	public void setConsumerCode(String value) {
		this.set(S_ConsumerCode, value);
		
	}

	public void setItemID(String value) {
		this.set(S_ItemID, value);
		
	}

	public void setItemName(String value) {
		this.set(S_ItemName, value);
		
	}

	public void setMobile(String value) {
		this.set(S_Mobile, value);
		
	}

	public void setOrderID(String value) {
		this.set(S_OrderID, value);
		
	}
	public void setOrderNum(String value) {
		this.set(S_OrderNum, value);
		
	}
	public void setRemaindDays(String value) {
		this.set(S_RemaindDays, value);
		
	}

	public void setSendNum(String value) {
		this.set(S_SendNum, value);
		
	}

	public void setSendTime(String value) {
		this.set(S_SendTime, value);
		
	}

	public void setSender(String value) {
		this.set(S_Sender, value);
		
	}

	public void setShopCode(String value) {
		this.set(S_ShopCode, value);
		
	}

	public void setStatus(String value) {
		this.set(S_Status, value);
		
	}

	public void setSuborderID(String value) {
		this.set(S_SuborderID, value);
	}
	public void setSuborderNum(String value) {
		this.set(S_SuborderNum, value);
	}
	public void setValidateTime(String value) {
		this.set(S_ValidateTime, value);
	}

	public void setVendorName(String value) {
		this.set(S_VendorName, value);
	}
	public void setBakCol(String value) {
		this.set(S_BakCol, value);
	}

	public void setBakCol2(String value) {
		this.set(S_BakCol2, value);
	}
}
