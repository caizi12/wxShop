package ngves.asiainfo.core.tuan.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.tuan.ivalues.ITuanUserLogValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class TuanUserLogBean extends DataContainer implements DataContainerInterface,ITuanUserLogValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 5137377116531316427L;



private static String  m_boName = "ngves.asiainfo.core.tuan.bo.TuanUserLog";



  public final static  String S_TuanUserLogId = "TUAN_USER_LOG_ID";
  public final static  String S_CustomerBrand = "CUSTOMER_BRAND";
  public final static  String S_OrderNum = "ORDER_NUM";
  public final static  String S_ProvinceCode = "PROVINCE_CODE";
  public final static  String S_BakCok = "BAK_COK";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_MobileNumber = "MOBILE_NUMBER";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_TuanId = "TUAN_ID";
  public TuanUserLogBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initTuanUserLogId(long value){
     this.initProperty(S_TuanUserLogId,new Long(value));
  }
  public  void setTuanUserLogId(long value){
     this.set(S_TuanUserLogId,new Long(value));
  }
  public  void setTuanUserLogIdNull(){
     this.set(S_TuanUserLogId,null);
  }

  public long getTuanUserLogId(){
        return DataType.getAsLong(this.get(S_TuanUserLogId));
  
  }
  public long getTuanUserLogIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TuanUserLogId));
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

  public void initOrderNum(long value){
     this.initProperty(S_OrderNum,new Long(value));
  }
  public  void setOrderNum(long value){
     this.set(S_OrderNum,new Long(value));
  }
  public  void setOrderNumNull(){
     this.set(S_OrderNum,null);
  }

  public long getOrderNum(){
        return DataType.getAsLong(this.get(S_OrderNum));
  
  }
  public long getOrderNumInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OrderNum));
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

  public void initBakCok(String value){
     this.initProperty(S_BakCok,value);
  }
  public  void setBakCok(String value){
     this.set(S_BakCok,value);
  }
  public  void setBakCokNull(){
     this.set(S_BakCok,null);
  }

  public String getBakCok(){
       return DataType.getAsString(this.get(S_BakCok));
  
  }
  public String getBakCokInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BakCok));
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

  public void initCreateDate(Timestamp value){
     this.initProperty(S_CreateDate,value);
  }
  public  void setCreateDate(Timestamp value){
     this.set(S_CreateDate,value);
  }
  public  void setCreateDateNull(){
     this.set(S_CreateDate,null);
  }

  public Timestamp getCreateDate(){
        return DataType.getAsDateTime(this.get(S_CreateDate));
  
  }
  public Timestamp getCreateDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CreateDate));
      }

  public void initTuanId(long value){
     this.initProperty(S_TuanId,new Long(value));
  }
  public  void setTuanId(long value){
     this.set(S_TuanId,new Long(value));
  }
  public  void setTuanIdNull(){
     this.set(S_TuanId,null);
  }

  public long getTuanId(){
        return DataType.getAsLong(this.get(S_TuanId));
  
  }
  public long getTuanIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TuanId));
      }


 
 }

