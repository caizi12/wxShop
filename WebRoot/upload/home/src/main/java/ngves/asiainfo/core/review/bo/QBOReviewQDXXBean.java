package ngves.asiainfo.core.review.bo;

import ngves.asiainfo.core.review.ivalues.IQBOReviewQDXXValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class QBOReviewQDXXBean extends DataContainer implements DataContainerInterface,IQBOReviewQDXXValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.review.bo.QBOReviewQDXX";



  public final static  String S_ActivityEndTime = "ACTIVITY_END_TIME";
  public final static  String S_OriPayCash = "ORI_PAY_CASH";
  public final static  String S_WareName = "WARE_NAME";
  public final static  String S_OneMaxAmount = "ONE_MAX_AMOUNT";
  public final static  String S_GrantMaxAmount = "GRANT_MAX_AMOUNT";
  public final static  String S_Channel = "CHANNEL";
  public final static  String S_ActivityName = "ACTIVITY_NAME";
  public final static  String S_ActivityStartTime = "ACTIVITY_START_TIME";
  public final static  String S_CurPayIntegral = "CUR_PAY_INTEGRAL";
  public final static  String S_WareIntegralValue = "WARE_INTEGRAL_VALUE";
  public final static  String S_CurPayCash = "CUR_PAY_CASH";

  
  public final static  String S_CurIntegral = "CUR_INTEGRAL";
  public final static  String S_OriPayIntegrale = "ori_pay_integral";
  
  
  public void initCurIntegral(long value){
	  this.initProperty(S_CurIntegral,new Long(value));
  }
  public  void setCurIntegral(long value){
	  this.set(S_CurIntegral,new Long(value));
  }
  public  void setCurIntegralNull(){
	  this.set(S_CurIntegral,null);
  }
  public long getCurIntegral(){
	  return DataType.getAsLong(this.get(S_CurIntegral));
  }
  public long getCurIntegralInitialValue(){
	  return DataType.getAsLong(this.getOldObj(S_CurIntegral));
  }
  
  public void initOriPayIntegrale(long value){
	  this.initProperty(S_OriPayIntegrale,new Long(value));
  }
  public  void setOriPayIntegrale(long value){
	  this.set(S_OriPayIntegrale,new Long(value));
  }
  public  void setOriPayIntegraleNull(){
	  this.set(S_OriPayIntegrale,null);
  }
  public long getOriPayIntegrale(){
	  return DataType.getAsLong(this.get(S_OriPayIntegrale));
  }
  public long getOriPayIntegraleInitialValue(){
	  return DataType.getAsLong(this.getOldObj(S_OriPayIntegrale));
  }
  
  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBOReviewQDXXBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
	 throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initActivityEndTime(String value){
     this.initProperty(S_ActivityEndTime,value);
  }
  public  void setActivityEndTime(String value){
     this.set(S_ActivityEndTime,value);
  }
  public  void setActivityEndTimeNull(){
     this.set(S_ActivityEndTime,null);
  }

  public String getActivityEndTime(){
       return DataType.getAsString(this.get(S_ActivityEndTime));
  
  }
  public String getActivityEndTimeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ActivityEndTime));
      }

  public void initOriPayCash(long value){
     this.initProperty(S_OriPayCash,new Long(value));
  }
  public  void setOriPayCash(long value){
     this.set(S_OriPayCash,new Long(value));
  }
  public  void setOriPayCashNull(){
     this.set(S_OriPayCash,null);
  }

  public long getOriPayCash(){
        return DataType.getAsLong(this.get(S_OriPayCash));
  
  }
  public long getOriPayCashInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OriPayCash));
      }



  public void initWareName(String value){
     this.initProperty(S_WareName,value);
  }
  public  void setWareName(String value){
     this.set(S_WareName,value);
  }
  public  void setWareNameNull(){
     this.set(S_WareName,null);
  }

  public String getWareName(){
       return DataType.getAsString(this.get(S_WareName));
  
  }
  public String getWareNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WareName));
      }

  public void initOneMaxAmount(long value){
     this.initProperty(S_OneMaxAmount,new Long(value));
  }
  public  void setOneMaxAmount(long value){
     this.set(S_OneMaxAmount,new Long(value));
  }
  public  void setOneMaxAmountNull(){
     this.set(S_OneMaxAmount,null);
  }

  public long getOneMaxAmount(){
        return DataType.getAsLong(this.get(S_OneMaxAmount));
  
  }
  public long getOneMaxAmountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OneMaxAmount));
      }

  public void initGrantMaxAmount(long value){
     this.initProperty(S_GrantMaxAmount,new Long(value));
  }
  public  void setGrantMaxAmount(long value){
     this.set(S_GrantMaxAmount,new Long(value));
  }
  public  void setGrantMaxAmountNull(){
     this.set(S_GrantMaxAmount,null);
  }

  public long getGrantMaxAmount(){
        return DataType.getAsLong(this.get(S_GrantMaxAmount));
  
  }
  public long getGrantMaxAmountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_GrantMaxAmount));
      }

  public void initChannel(String value){
     this.initProperty(S_Channel,value);
  }
  public  void setChannel(String value){
     this.set(S_Channel,value);
  }
  public  void setChannelNull(){
     this.set(S_Channel,null);
  }

  public String getChannel(){
       return DataType.getAsString(this.get(S_Channel));
  
  }
  public String getChannelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Channel));
      }

  public void initActivityName(String value){
     this.initProperty(S_ActivityName,value);
  }
  public  void setActivityName(String value){
     this.set(S_ActivityName,value);
  }
  public  void setActivityNameNull(){
     this.set(S_ActivityName,null);
  }

  public String getActivityName(){
       return DataType.getAsString(this.get(S_ActivityName));
  
  }
  public String getActivityNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ActivityName));
      }

  public void initActivityStartTime(String value){
     this.initProperty(S_ActivityStartTime,value);
  }
  public  void setActivityStartTime(String value){
     this.set(S_ActivityStartTime,value);
  }
  public  void setActivityStartTimeNull(){
     this.set(S_ActivityStartTime,null);
  }

  public String getActivityStartTime(){
       return DataType.getAsString(this.get(S_ActivityStartTime));
  
  }
  public String getActivityStartTimeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ActivityStartTime));
      }

  public void initCurPayIntegral(long value){
     this.initProperty(S_CurPayIntegral,new Long(value));
  }
  public  void setCurPayIntegral(long value){
     this.set(S_CurPayIntegral,new Long(value));
  }
  public  void setCurPayIntegralNull(){
     this.set(S_CurPayIntegral,null);
  }

  public long getCurPayIntegral(){
        return DataType.getAsLong(this.get(S_CurPayIntegral));
  
  }
  public long getCurPayIntegralInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_CurPayIntegral));
      }

  public void initWareIntegralValue(long value){
     this.initProperty(S_WareIntegralValue,new Long(value));
  }
  public  void setWareIntegralValue(long value){
     this.set(S_WareIntegralValue,new Long(value));
  }
  public  void setWareIntegralValueNull(){
     this.set(S_WareIntegralValue,null);
  }

  public long getWareIntegralValue(){
        return DataType.getAsLong(this.get(S_WareIntegralValue));
  
  }
  public long getWareIntegralValueInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_WareIntegralValue));
      }

  public void initCurPayCash(long value){
     this.initProperty(S_CurPayCash,new Long(value));
  }
  public  void setCurPayCash(long value){
     this.set(S_CurPayCash,new Long(value));
  }
  public  void setCurPayCashNull(){
     this.set(S_CurPayCash,null);
  }

  public long getCurPayCash(){
        return DataType.getAsLong(this.get(S_CurPayCash));
  
  }
  public long getCurPayCashInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_CurPayCash));
      }


 
 }

