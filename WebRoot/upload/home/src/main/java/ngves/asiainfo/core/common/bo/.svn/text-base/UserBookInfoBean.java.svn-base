package ngves.asiainfo.core.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.common.ivalues.*;

public class UserBookInfoBean extends DataContainer implements DataContainerInterface,IUserBookInfoValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 3388924734943969861L;



private static String  m_boName = "ngves.asiainfo.core.common.bo.UserBookInfo";



  public final static  String S_BookTime = "BOOK_TIME";
  public final static  String S_SendDate = "SEND_DATE";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_UserBookId = "USER_BOOK_ID";
  public final static  String S_InfoCode = "INFO_CODE";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_MobilePhoneNo = "MOBILE_PHONE_NO";
  public final static  String S_BookStatus = "BOOK_STATUS";
  public final static  String S_RebookTime = "REBOOK_TIME";
  public final static  String S_Oper = "OPER";
  public final static  String S_UserId = "USER_ID";
  public final static  String S_UserRole = "USER_ROLE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public UserBookInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initBookTime(Timestamp value){
     this.initProperty(S_BookTime,value);
  }
  public  void setBookTime(Timestamp value){
     this.set(S_BookTime,value);
  }
  public  void setBookTimeNull(){
     this.set(S_BookTime,null);
  }

  public Timestamp getBookTime(){
        return DataType.getAsDateTime(this.get(S_BookTime));
  
  }
  public Timestamp getBookTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_BookTime));
      }

  public void initSendDate(String value){
     this.initProperty(S_SendDate,value);
  }
  public  void setSendDate(String value){
     this.set(S_SendDate,value);
  }
  public  void setSendDateNull(){
     this.set(S_SendDate,null);
  }

  public String getSendDate(){
       return DataType.getAsString(this.get(S_SendDate));
  
  }
  public String getSendDateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SendDate));
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

  public void initUserBookId(long value){
     this.initProperty(S_UserBookId,new Long(value));
  }
  public  void setUserBookId(long value){
     this.set(S_UserBookId,new Long(value));
  }
  public  void setUserBookIdNull(){
     this.set(S_UserBookId,null);
  }

  public long getUserBookId(){
        return DataType.getAsLong(this.get(S_UserBookId));
  
  }
  public long getUserBookIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_UserBookId));
      }

  public void initInfoCode(String value){
     this.initProperty(S_InfoCode,value);
  }
  public  void setInfoCode(String value){
     this.set(S_InfoCode,value);
  }
  public  void setInfoCodeNull(){
     this.set(S_InfoCode,null);
  }

  public String getInfoCode(){
       return DataType.getAsString(this.get(S_InfoCode));
  
  }
  public String getInfoCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_InfoCode));
      }

  public void initBakCol1(long value){
     this.initProperty(S_BakCol1,new Long(value));
  }
  public  void setBakCol1(long value){
     this.set(S_BakCol1,new Long(value));
  }
  public  void setBakCol1Null(){
     this.set(S_BakCol1,null);
  }

  public long getBakCol1(){
        return DataType.getAsLong(this.get(S_BakCol1));
  
  }
  public long getBakCol1InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BakCol1));
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

  public void initBookStatus(String value){
     this.initProperty(S_BookStatus,value);
  }
  public  void setBookStatus(String value){
     this.set(S_BookStatus,value);
  }
  public  void setBookStatusNull(){
     this.set(S_BookStatus,null);
  }

  public String getBookStatus(){
       return DataType.getAsString(this.get(S_BookStatus));
  
  }
  public String getBookStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BookStatus));
      }

  public void initRebookTime(Timestamp value){
     this.initProperty(S_RebookTime,value);
  }
  public  void setRebookTime(Timestamp value){
     this.set(S_RebookTime,value);
  }
  public  void setRebookTimeNull(){
     this.set(S_RebookTime,null);
  }

  public Timestamp getRebookTime(){
        return DataType.getAsDateTime(this.get(S_RebookTime));
  
  }
  public Timestamp getRebookTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_RebookTime));
      }
  
  public void initOper(String value){
	     this.initProperty(S_Oper,value);
  }
  public  void setOper(String value){
     this.set(S_Oper,value);
  }
  public  void setOperNull(){
     this.set(S_Oper,null);
  }

  public String getOper(){
       return DataType.getAsString(this.get(S_Oper));
  
  }
  public String getOperInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Oper));
  }
  public void initUserId(String value){
	     this.initProperty(S_UserId,value);
  }
  public  void setUserId(String value){
     this.set(S_UserId,value);
  }
  public  void setUserIdNull(){
     this.set(S_UserId,null);
  }

  public String getUserId(){
       return DataType.getAsString(this.get(S_UserId));
  
  }
  public String getUserIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_UserId));
  }
  public void initUserRole(String value){
	     this.initProperty(S_UserRole,value);
  }
  public  void setUserRole(String value){
     this.set(S_UserRole,value);
  }
  public  void setUserRoleNull(){
     this.set(S_UserRole,null);
  }

  public String getUserRole(){
       return DataType.getAsString(this.get(S_UserRole));
  
  }
  public String getUserRoleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_UserRole));
      }

 }

