package ngves.asiainfo.core.review.bo;

import ngves.asiainfo.core.review.ivalues.IQBOReviewJSXXWLSValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class QBOReviewJSXXWLSBean extends DataContainer implements DataContainerInterface,IQBOReviewJSXXWLSValue{

	private static final long serialVersionUID = 4838571471216841560L;



private static String  m_boName = "ngves.asiainfo.core.review.bo.QBOReviewJSXXWLS";



  public final static  String S_PartnerName = "PARTNER_NAME";
  public final static  String S_PartnerCode = "PARTNER_CODE";
  public final static  String S_SuitRate = "SUIT_RATE";
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
  public QBOReviewJSXXWLSBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
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

