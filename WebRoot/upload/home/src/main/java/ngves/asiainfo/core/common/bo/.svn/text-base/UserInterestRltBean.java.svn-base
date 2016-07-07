package ngves.asiainfo.core.common.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.common.ivalues.*;

public class UserInterestRltBean extends DataContainer implements DataContainerInterface,IUserInterestRltValue{
  
  private static final long serialVersionUID = 3388924734943969861L;	
	
  private static String  m_boName = "ngves.asiainfo.core.common.bo.UserInterestRlt";



  public final static  String S_SaleMailStatus = "SALE_MAIL_STATUS";
  public final static  String S_SaleSmsStatus = "SALE_SMS_STATUS";
  public final static  String S_InterestId = "INTEREST_ID";
  public final static  String S_InterestCode = "INTEREST_CODE";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_MobilePhoneNo = "MOBILE_PHONE_NO";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public UserInterestRltBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initSaleMailStatus(String value){
     this.initProperty(S_SaleMailStatus,value);
  }
  public  void setSaleMailStatus(String value){
     this.set(S_SaleMailStatus,value);
  }
  public  void setSaleMailStatusNull(){
     this.set(S_SaleMailStatus,null);
  }

  public String getSaleMailStatus(){
       return DataType.getAsString(this.get(S_SaleMailStatus));
  
  }
  public String getSaleMailStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleMailStatus));
      }

  public void initSaleSmsStatus(String value){
     this.initProperty(S_SaleSmsStatus,value);
  }
  public  void setSaleSmsStatus(String value){
     this.set(S_SaleSmsStatus,value);
  }
  public  void setSaleSmsStatusNull(){
     this.set(S_SaleSmsStatus,null);
  }

  public String getSaleSmsStatus(){
       return DataType.getAsString(this.get(S_SaleSmsStatus));
  
  }
  public String getSaleSmsStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleSmsStatus));
      }

  public void initInterestId(long value){
     this.initProperty(S_InterestId,new Long(value));
  }
  public  void setInterestId(long value){
     this.set(S_InterestId,new Long(value));
  }
  public  void setInterestIdNull(){
     this.set(S_InterestId,null);
  }

  public long getInterestId(){
        return DataType.getAsLong(this.get(S_InterestId));
  
  }
  public long getInterestIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_InterestId));
      }

  public void initInterestCode(String value){
     this.initProperty(S_InterestCode,value);
  }
  public  void setInterestCode(String value){
     this.set(S_InterestCode,value);
  }
  public  void setInterestCodeNull(){
     this.set(S_InterestCode,null);
  }

  public String getInterestCode(){
       return DataType.getAsString(this.get(S_InterestCode));
  
  }
  public String getInterestCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_InterestCode));
      }

  public void initBakCol1(String value){
     this.initProperty(S_BakCol1,value);
  }
  public  void setBakCol1(String value){
     this.set(S_BakCol1,value);
  }
  public  void setBakCol1Null(){
     this.set(S_BakCol1,null);
  }

  public String getBakCol1(){
       return DataType.getAsString(this.get(S_BakCol1));
  
  }
  public String getBakCol1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_BakCol1));
      }

  public void initMobilePhoneNo(String value){
     this.initProperty(S_MobilePhoneNo,value);
  }
  public  void setMobilePhoneNo(String value){
     this.set(S_MobilePhoneNo,value);
  }
  public  void setMobilePhoneNoNull(){
     this.set(S_MobilePhoneNo,null);
  }

  public String getMobilePhoneNo(){
       return DataType.getAsString(this.get(S_MobilePhoneNo));
  
  }
  public String getMobilePhoneNoInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MobilePhoneNo));
      }


 
 }

