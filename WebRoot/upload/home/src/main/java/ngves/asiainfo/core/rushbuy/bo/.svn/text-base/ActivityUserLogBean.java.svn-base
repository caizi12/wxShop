package ngves.asiainfo.core.rushbuy.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.rushbuy.ivalues.*;

public class ActivityUserLogBean extends DataContainer implements DataContainerInterface,IActivityUserLogValue{

    private static final long serialVersionUID = 970512815902289055L;



private static String  m_boName = "ngves.asiainfo.core.rushbuy.bo.ActivityUserLog";



  public final static  String S_CustomerBrand = "CUSTOMER_BRAND";
  public final static  String S_ActivityAwardUserId = "ACTIVITY_AWARD_USER_ID";
  public final static  String S_AwardTime = "AWARD_TIME";
  public final static  String S_ExchangeTime = "EXCHANGE_TIME";
  public final static  String S_ProvinceCode = "PROVINCE_CODE";
  public final static  String S_CancelTime = "CANCEL_TIME";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_ActivityId = "ACTIVITY_ID";
  public final static  String S_MobileNumber = "MOBILE_NUMBER";
  public final static  String S_WareId = "WARE_ID";
  public final static  String S_AwardState = "AWARD_STATE";
  //添加用户支付方式  --混合支付下单
  public final static  String S_UserPayType="USER_PAY_TYPE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public ActivityUserLogBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initCustomerBrand(String value){
     this.initProperty(S_CustomerBrand,value);
  }
  public  void setCustomerBrand(String value){
     this.set(S_CustomerBrand,value);
  }
  public  void setCustomerBrandNull(){
     this.set(S_CustomerBrand,null);
  }

  public String getCustomerBrand(){
       return DataType.getAsString(this.get(S_CustomerBrand));
  
  }
  public String getCustomerBrandInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CustomerBrand));
      }

  public void initActivityAwardUserId(long value){
     this.initProperty(S_ActivityAwardUserId,new Long(value));
  }
  public  void setActivityAwardUserId(long value){
     this.set(S_ActivityAwardUserId,new Long(value));
  }
  public  void setActivityAwardUserIdNull(){
     this.set(S_ActivityAwardUserId,null);
  }

  public long getActivityAwardUserId(){
        return DataType.getAsLong(this.get(S_ActivityAwardUserId));
  
  }
  public long getActivityAwardUserIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ActivityAwardUserId));
      }

  public void initAwardTime(Timestamp value){
     this.initProperty(S_AwardTime,value);
  }
  public  void setAwardTime(Timestamp value){
     this.set(S_AwardTime,value);
  }
  public  void setAwardTimeNull(){
     this.set(S_AwardTime,null);
  }

  public Timestamp getAwardTime(){
        return DataType.getAsDateTime(this.get(S_AwardTime));
  
  }
  public Timestamp getAwardTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_AwardTime));
      }

  public void initExchangeTime(Timestamp value){
     this.initProperty(S_ExchangeTime,value);
  }
  public  void setExchangeTime(Timestamp value){
     this.set(S_ExchangeTime,value);
  }
  public  void setExchangeTimeNull(){
     this.set(S_ExchangeTime,null);
  }

  public Timestamp getExchangeTime(){
        return DataType.getAsDateTime(this.get(S_ExchangeTime));
  
  }
  public Timestamp getExchangeTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ExchangeTime));
      }

  public void initProvinceCode(String value){
     this.initProperty(S_ProvinceCode,value);
  }
  public  void setProvinceCode(String value){
     this.set(S_ProvinceCode,value);
  }
  public  void setProvinceCodeNull(){
     this.set(S_ProvinceCode,null);
  }

  public String getProvinceCode(){
       return DataType.getAsString(this.get(S_ProvinceCode));
  
  }
  public String getProvinceCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProvinceCode));
      }

  public void initCancelTime(Timestamp value){
     this.initProperty(S_CancelTime,value);
  }
  public  void setCancelTime(Timestamp value){
     this.set(S_CancelTime,value);
  }
  public  void setCancelTimeNull(){
     this.set(S_CancelTime,null);
  }

  public Timestamp getCancelTime(){
        return DataType.getAsDateTime(this.get(S_CancelTime));
  
  }
  public Timestamp getCancelTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CancelTime));
      }

  public void initOrderId(String value){
     this.initProperty(S_OrderId,value);
  }
  public  void setOrderId(String value){
     this.set(S_OrderId,value);
  }
  public  void setOrderIdNull(){
     this.set(S_OrderId,null);
  }

  public String getOrderId(){
       return DataType.getAsString(this.get(S_OrderId));
  
  }
  public String getOrderIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrderId));
      }

  public void initActivityId(long value){
     this.initProperty(S_ActivityId,new Long(value));
  }
  public  void setActivityId(long value){
     this.set(S_ActivityId,new Long(value));
  }
  public  void setActivityIdNull(){
     this.set(S_ActivityId,null);
  }

  public long getActivityId(){
        return DataType.getAsLong(this.get(S_ActivityId));
  
  }
  public long getActivityIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ActivityId));
      }

  public void initMobileNumber(String value){
     this.initProperty(S_MobileNumber,value);
  }
  public  void setMobileNumber(String value){
     this.set(S_MobileNumber,value);
  }
  public  void setMobileNumberNull(){
     this.set(S_MobileNumber,null);
  }

  public String getMobileNumber(){
       return DataType.getAsString(this.get(S_MobileNumber));
  
  }
  public String getMobileNumberInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MobileNumber));
      }

  public void initWareId(long value){
     this.initProperty(S_WareId,new Long(value));
  }
  public  void setWareId(long value){
     this.set(S_WareId,new Long(value));
  }
  public  void setWareIdNull(){
     this.set(S_WareId,null);
  }

  public long getWareId(){
        return DataType.getAsLong(this.get(S_WareId));
  
  }
  public long getWareIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_WareId));
      }

  public void initAwardState(String value){
     this.initProperty(S_AwardState,value);
  }
  public  void setAwardState(String value){
     this.set(S_AwardState,value);
  }
  public  void setAwardStateNull(){
     this.set(S_AwardState,null);
  }

  public String getAwardState(){
       return DataType.getAsString(this.get(S_AwardState));
  
  }
  public String getAwardStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AwardState));
  }
  
  public void initUserPayType(String value){
	     this.initProperty(S_UserPayType,value);
  }
  public  void setUserPayType(String value){
     this.set(S_UserPayType,value);
  }
  public  void setUserPayTypeNull(){
     this.set(S_UserPayType,null);
  }

  public String getUserPayType(){
       return DataType.getAsString(this.get(S_UserPayType));
  
  }
  public String getUserPayTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_UserPayType));
  }

 
 }

