package ngves.asiainfo.core.award.bo;

import ngves.asiainfo.core.award.ivalues.IAwardDescValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class AwardDescBean extends DataContainer implements
			DataContainerInterface, IAwardDescValue{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static String m_boName = "ngves.asiainfo.core.award.bo.AwardDesc";
	
	public final static  String S_AwardID ="AWARD_ID";//活动ID
	public final static  String S_Actionname ="ACTION_NAME";//活动名称
	public final static  String S_OrderID ="ORDER_ID";//抽奖订单号
	public final static  String S_PreOprTime ="PROOPR_TIME";//抽奖时间
	public final static  String S_LotteryPoint ="LOTTERY_POINT";//参与分值
	public final static  String S_LotteryResult ="LOTTERY_RESULT";//是否中奖
	public final static  String S_GiftOrderID ="GIFT_ORDERID";//中奖订单号
	public final static  String S_GiftWinTime ="GIFT_WIN_TIME";//中奖时间
	public final static  String S_GiftItemID ="GIFT_ITEMID";//中奖礼品编码
	public final static  String S_GiftItemName ="GIFT_ITEMNAME";//中奖礼品名称
	public final static  String S_ReceiveStatus ="RECRIVE_STATUS";//领取状态
	public final static  String S_ActionEndTime ="ACTION_END_TIME";//活动截止日期
	public final static  String S_LengthenTime ="LENG_THEN_TIME";//领奖截止日期
	
	
	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory()
					.getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public AwardDescBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}
	
	public String getAwardID() {
		return DataType.getAsString(this.get(S_AwardID));
	}
	
	public  String getActionname(){
		return DataType.getAsString(this.get(S_Actionname));
	}
	public  String getOrderID(){
		return DataType.getAsString(this.get(S_OrderID));
	}
	public String getPreOprTime(){
		return DataType.getAsString(this.get(S_PreOprTime));
	}
	public  String getLotteryPoint(){
		return DataType.getAsString(this.get(S_LotteryPoint));
	} 
	public  String getLotteryResult(){
		return DataType.getAsString(this.get(S_LotteryResult));
	} 
	public  String getGiftOrderID(){
		return DataType.getAsString(this.get(S_GiftOrderID));
	}
	public  String getGiftWinTime(){
		return DataType.getAsString(this.get(S_GiftWinTime));
	}
	public  String getGiftItemID(){
		return DataType.getAsString(this.get(S_GiftItemID));
	}
	public  String getGiftItemName(){
		return DataType.getAsString(this.get(S_GiftItemName));
	}
	public  String getReceiveStatus(){
		return DataType.getAsString(this.get(S_ReceiveStatus));
	}
	public  String getActionEndTime(){
		return DataType.getAsString(this.get(S_ActionEndTime));
	}
	public  String getLengthenTime(){
		return DataType.getAsString(this.get(S_LengthenTime));
	}
	
	public  void setActionname(String value){
		this.set(S_Actionname, value);
	}
	public  void setOrderID(String value){
		this.set(S_OrderID, value);
	}
	public  void setPreOprTime(String value){
		this.set(S_PreOprTime, value);
	} 
	public  void setLotteryPoint(String value){
		this.set(S_LotteryPoint, value);
	} 
	public  void setLotteryResult(String value){
		this.set(S_LotteryResult, value);
	} 
	public  void setGiftOrderID(String value){
		this.set(S_GiftOrderID, value);
	}
	public  void setGiftWinTime(String value){
		this.set(S_GiftWinTime, value);
	}
	public  void setGiftItemID(String value){
		this.set(S_GiftItemID, value);
	}
	public  void setGiftItemName(String value){
		this.set(S_GiftItemName, value);
	}
	public  void setReceiveStatus(String value){
		this.set(S_ReceiveStatus, value);
	}
	public  void setActionEndTime(String value){
		this.set(S_ActionEndTime, value);
	}
	public  void setLengthenTime(String value){
		this.set(S_LengthenTime, value);
	}

	public void setAwardID(String value) {
		this.set(S_AwardID, value);
	}

	

}
