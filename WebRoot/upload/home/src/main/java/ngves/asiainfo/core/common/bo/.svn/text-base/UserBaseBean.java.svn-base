package ngves.asiainfo.core.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.common.ivalues.*;

public class UserBaseBean extends DataContainer implements DataContainerInterface,IUserBaseValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 6198791839300259270L;



private static String  m_boName = "ngves.asiainfo.core.common.bo.UserBase";



  public final static  String S_SparePhone = "SPARE_PHONE";
  public final static  String S_UpdateDate = "UPDATE_DATE";
  public final static  String S_SparePhone2 = "SPARE_PHONE2";
  public final static  String S_SpareMail = "SPARE_MAIL";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_UserMobile = "USER_MOBILE";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_OftenMail = "OFTEN_MAIL";
  public final static  String S_Nickname = "NICKNAME";
  public final static  String S_Remark = "REMARK";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public UserBaseBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initSparePhone(String value){
     this.initProperty(S_SparePhone,value);
  }
  public  void setSparePhone(String value){
     this.set(S_SparePhone,value);
  }
  public  void setSparePhoneNull(){
     this.set(S_SparePhone,null);
  }

  public String getSparePhone(){
       return DataType.getAsString(this.get(S_SparePhone));
  
  }
  public String getSparePhoneInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SparePhone));
      }

  public void initUpdateDate(Timestamp value){
     this.initProperty(S_UpdateDate,value);
  }
  public  void setUpdateDate(Timestamp value){
     this.set(S_UpdateDate,value);
  }
  public  void setUpdateDateNull(){
     this.set(S_UpdateDate,null);
  }

  public Timestamp getUpdateDate(){
        return DataType.getAsDateTime(this.get(S_UpdateDate));
  
  }
  public Timestamp getUpdateDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_UpdateDate));
      }

  public void initSparePhone2(String value){
     this.initProperty(S_SparePhone2,value);
  }
  public  void setSparePhone2(String value){
     this.set(S_SparePhone2,value);
  }
  public  void setSparePhone2Null(){
     this.set(S_SparePhone2,null);
  }

  public String getSparePhone2(){
       return DataType.getAsString(this.get(S_SparePhone2));
  
  }
  public String getSparePhone2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_SparePhone2));
      }

  public void initSpareMail(String value){
     this.initProperty(S_SpareMail,value);
  }
  public  void setSpareMail(String value){
     this.set(S_SpareMail,value);
  }
  public  void setSpareMailNull(){
     this.set(S_SpareMail,null);
  }

  public String getSpareMail(){
       return DataType.getAsString(this.get(S_SpareMail));
  
  }
  public String getSpareMailInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SpareMail));
      }

  public void initBakCol2(String value){
     this.initProperty(S_BakCol2,value);
  }
  public  void setBakCol2(String value){
     this.set(S_BakCol2,value);
  }
  public  void setBakCol2Null(){
     this.set(S_BakCol2,null);
  }

  public String getBakCol2(){
       return DataType.getAsString(this.get(S_BakCol2));
  
  }
  public String getBakCol2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_BakCol2));
      }

  public void initUserMobile(long value){
     this.initProperty(S_UserMobile,new Long(value));
  }
  public  void setUserMobile(long value){
     this.set(S_UserMobile,new Long(value));
  }
  public  void setUserMobileNull(){
     this.set(S_UserMobile,null);
  }

  public long getUserMobile(){
        return DataType.getAsLong(this.get(S_UserMobile));
  
  }
  public long getUserMobileInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_UserMobile));
      }

  public void initBakCol3(String value){
     this.initProperty(S_BakCol3,value);
  }
  public  void setBakCol3(String value){
     this.set(S_BakCol3,value);
  }
  public  void setBakCol3Null(){
     this.set(S_BakCol3,null);
  }

  public String getBakCol3(){
       return DataType.getAsString(this.get(S_BakCol3));
  
  }
  public String getBakCol3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_BakCol3));
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

  public void initOftenMail(String value){
     this.initProperty(S_OftenMail,value);
  }
  public  void setOftenMail(String value){
     this.set(S_OftenMail,value);
  }
  public  void setOftenMailNull(){
     this.set(S_OftenMail,null);
  }

  public String getOftenMail(){
       return DataType.getAsString(this.get(S_OftenMail));
  
  }
  public String getOftenMailInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OftenMail));
      }

  public void initNickname(String value){
     this.initProperty(S_Nickname,value);
  }
  public  void setNickname(String value){
     this.set(S_Nickname,value);
  }
  public  void setNicknameNull(){
     this.set(S_Nickname,null);
  }

  public String getNickname(){
       return DataType.getAsString(this.get(S_Nickname));
  
  }
  public String getNicknameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Nickname));
      }

  public void initRemark(String value){
     this.initProperty(S_Remark,value);
  }
  public  void setRemark(String value){
     this.set(S_Remark,value);
  }
  public  void setRemarkNull(){
     this.set(S_Remark,null);
  }

  public String getRemark(){
       return DataType.getAsString(this.get(S_Remark));
  
  }
  public String getRemarkInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark));
      }


 
 }

