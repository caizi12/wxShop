package ngves.asiainfo.core.review.bo;

import ngves.asiainfo.core.review.ivalues.IQBOReviewJSXXLPValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class QBOReviewJSXXLPBean extends DataContainer implements DataContainerInterface,IQBOReviewJSXXLPValue{

  
	private static final long serialVersionUID = 9145930439264616578L;



private static String  m_boName = "ngves.asiainfo.core.review.bo.QBOReviewJSXXLP";



  public final static  String S_SuitRate = "SUIT_RATE";
  public final static  String S_PartnerName = "PARTNER_NAME";
  public final static  String S_WareName = "WARE_NAME";
  public final static  String S_FName = "F_NAME";
  public final static  String S_WareCode = "WARE_CODE";
  public final static  String S_PartnerCode = "PARTNER_CODE";
  public final static  String S_Value = "VALUE";
  public final static  String S_Name = "NAME";
  public final static  String S_IsSeparate = "IS_SEPARATE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBOReviewJSXXLPBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initSuitRate(String value){
     this.initProperty(S_SuitRate,value);
  }
  public  void setSuitRate(String value){
     this.set(S_SuitRate,value);
  }
  public  void setSuitRateNull(){
     this.set(S_SuitRate,null);
  }

  public String getSuitRate(){
       return DataType.getAsString(this.get(S_SuitRate));
  
  }
  public String getSuitRateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SuitRate));
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

  public void initFName(String value){
     this.initProperty(S_FName,value);
  }
  public  void setFName(String value){
     this.set(S_FName,value);
  }
  public  void setFNameNull(){
     this.set(S_FName,null);
  }

  public String getFName(){
       return DataType.getAsString(this.get(S_FName));
  
  }
  public String getFNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FName));
      }

  public void initWareCode(String value){
     this.initProperty(S_WareCode,value);
  }
  public  void setWareCode(String value){
     this.set(S_WareCode,value);
  }
  public  void setWareCodeNull(){
     this.set(S_WareCode,null);
  }

  public String getWareCode(){
       return DataType.getAsString(this.get(S_WareCode));
  
  }
  public String getWareCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WareCode));
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

  public void initValue(String value){
     this.initProperty(S_Value,value);
  }
  public  void setValue(String value){
     this.set(S_Value,value);
  }
  public  void setValueNull(){
     this.set(S_Value,null);
  }

  public String getValue(){
        return DataType.getAsString(this.get(S_Value));
  
  }
  public String getValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Value));
      }

  public void initName(String value){
     this.initProperty(S_Name,value);
  }
  public  void setName(String value){
     this.set(S_Name,value);
  }
  public  void setNameNull(){
     this.set(S_Name,null);
  }

  public String getName(){
       return DataType.getAsString(this.get(S_Name));
  
  }
  public String getNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Name));
      }

  public void initIsSeparate(String value){
     this.initProperty(S_IsSeparate,value);
  }
  public  void setIsSeparate(String value){
     this.set(S_IsSeparate,value);
  }
  public  void setIsSeparateNull(){
     this.set(S_IsSeparate,null);
  }

  public String getIsSeparate(){
       return DataType.getAsString(this.get(S_IsSeparate));
  
  }
  public String getIsSeparateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsSeparate));
      }


 
 }

