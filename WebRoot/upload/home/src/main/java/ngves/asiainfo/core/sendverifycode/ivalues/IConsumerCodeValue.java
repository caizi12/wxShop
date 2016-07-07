package ngves.asiainfo.core.sendverifycode.ivalues;

import com.ai.appframe2.common.DataStructInterface;

public interface IConsumerCodeValue extends DataStructInterface{
	
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
	
	public  String getOrderID();
	public  String getSuborderID();
	public  String getOrderNum();
	public  String getSuborderNum();
	public  String getMobile();
	public String  getItemID(); 
	public  String getItemName(); 
	public  String getVendorName(); 
	public  String getConsumerCode();
	public  String getValidateTime();
	public  String getRemaindDays();
	public  String getStatus();
	public  String getSendTime();
	public  String getSender();
	public  String getSendNum();
	public  String getConsumeOperator();
	public  String getShopCode();
	public  String getConsumeOptime();
	public  String getBakCol();
	public  String getBakCol2();
	
	public  void setOrderID(String value);
	public  void setSuborderID(String value);
	public  void setOrderNum(String value);
	public  void setSuborderNum(String value);
	public  void setMobile(String value);
	public  void setItemID(String value); 
	public  void setItemName(String value); 
	public  void setVendorName(String value); 
	public  void setConsumerCode(String value);
	public  void setValidateTime(String value);
	public  void setRemaindDays(String value);
	public  void setStatus(String value);
	public  void setSendTime(String value);
	public  void setSender(String value);
	public  void setSendNum(String value);	
	public  void setConsumeOperator(String value);
	public  void setShopCode(String value);
	public  void setConsumeOptime(String value);
	public  void setBakCol(String value);
	public  void setBakCol2(String value);
}
