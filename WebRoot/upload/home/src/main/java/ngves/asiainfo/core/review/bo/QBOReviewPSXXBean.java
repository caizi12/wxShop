package ngves.asiainfo.core.review.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.review.ivalues.*;

@SuppressWarnings("serial")
public class QBOReviewPSXXBean extends DataContainer implements DataContainerInterface,IQBOReviewPSXXValue{

  private static String  m_boName = "ngves.asiainfo.core.review.bo.QBOReviewPSXX";



  public final static  String S_SendDays = "SEND_DAYS";
  public final static  String S_CountyName = "COUNTY_NAME";
  public final static  String S_WarehouseName = "WAREHOUSE_NAME";
  public final static  String S_CityName = "CITY_NAME";
  public final static  String S_SendPrice = "SEND_PRICE";
  public final static  String S_PartnerCode = "PARTNER_CODE";
  public final static  String S_ProvinceName = "PROVINCE_NAME";
  public final static  String S_PartnerName = "PARTNER_NAME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBOReviewPSXXBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initSendDays(long value){
     this.initProperty(S_SendDays,new Long(value));
  }
  public  void setSendDays(long value){
     this.set(S_SendDays,new Long(value));
  }
  public  void setSendDaysNull(){
     this.set(S_SendDays,null);
  }

  public long getSendDays(){
        return DataType.getAsLong(this.get(S_SendDays));
  
  }
  public long getSendDaysInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SendDays));
      }

  public void initCountyName(String value){
     this.initProperty(S_CountyName,value);
  }
  public  void setCountyName(String value){
     this.set(S_CountyName,value);
  }
  public  void setCountyNameNull(){
     this.set(S_CountyName,null);
  }

  public String getCountyName(){
       return DataType.getAsString(this.get(S_CountyName));
  
  }
  public String getCountyNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CountyName));
      }

  public void initWarehouseName(String value){
     this.initProperty(S_WarehouseName,value);
  }
  public  void setWarehouseName(String value){
     this.set(S_WarehouseName,value);
  }
  public  void setWarehouseNameNull(){
     this.set(S_WarehouseName,null);
  }

  public String getWarehouseName(){
       return DataType.getAsString(this.get(S_WarehouseName));
  
  }
  public String getWarehouseNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WarehouseName));
      }

  public void initCityName(String value){
     this.initProperty(S_CityName,value);
  }
  public  void setCityName(String value){
     this.set(S_CityName,value);
  }
  public  void setCityNameNull(){
     this.set(S_CityName,null);
  }

  public String getCityName(){
       return DataType.getAsString(this.get(S_CityName));
  
  }
  public String getCityNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CityName));
      }

  public void initSendPrice(String value){
     this.initProperty(S_SendPrice,value);
  }
  public  void setSendPrice(String value){
     this.set(S_SendPrice,value);
  }
  public  void setSendPriceNull(){
     this.set(S_SendPrice,null);
  }

  public String getSendPrice(){
        return DataType.getAsString(this.get(S_SendPrice));
  
  }
  public String getSendPriceInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SendPrice));
      }

  public void initPartnerCode(String value){
     this.initProperty(S_PartnerCode,value);
  }
  public  void setPartnerCode(String value){
     this.set(S_PartnerCode,value);
  }
  public  void setPartnerCodeNull(){
     this.set(S_PartnerCode,null);
  }

  public String getPartnerCode(){
       return DataType.getAsString(this.get(S_PartnerCode));
  
  }
  public String getPartnerCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PartnerCode));
      }

  public void initProvinceName(String value){
     this.initProperty(S_ProvinceName,value);
  }
  public  void setProvinceName(String value){
     this.set(S_ProvinceName,value);
  }
  public  void setProvinceNameNull(){
     this.set(S_ProvinceName,null);
  }

  public String getProvinceName(){
       return DataType.getAsString(this.get(S_ProvinceName));
  
  }
  public String getProvinceNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProvinceName));
      }

  public void initPartnerName(String value){
     this.initProperty(S_PartnerName,value);
  }
  public  void setPartnerName(String value){
     this.set(S_PartnerName,value);
  }
  public  void setPartnerNameNull(){
     this.set(S_PartnerName,null);
  }

  public String getPartnerName(){
       return DataType.getAsString(this.get(S_PartnerName));
  
  }
  public String getPartnerNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PartnerName));
      }


 
 }

