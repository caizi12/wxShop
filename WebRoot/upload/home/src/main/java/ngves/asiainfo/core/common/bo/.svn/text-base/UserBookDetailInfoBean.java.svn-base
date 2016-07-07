package ngves.asiainfo.core.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.common.ivalues.*;

public class UserBookDetailInfoBean extends DataContainer implements DataContainerInterface,IUserBookDetailInfoValue{
  
  private static final long serialVersionUID = 5475263970584855977L;	
	
  private static String  m_boName = "ngves.asiainfo.core.common.bo.UserBookDetailInfo";



  public final static  String S_BookStats = "BOOK_STATS";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_SendProvince = "SEND_PROVINCE";
  public final static  String S_FailReason = "FAIL_REASON";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_WareId = "WARE_ID";
  public final static  String S_MobilePhoneNo = "MOBILE_PHONE_NO";
  public final static  String S_IsSend = "IS_SEND";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_SendTime = "SEND_TIME";
  public final static  String S_BookDetailId = "BOOK_DETAIL_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public UserBookDetailInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initBookStats(String value){
     this.initProperty(S_BookStats,value);
  }
  public  void setBookStats(String value){
     this.set(S_BookStats,value);
  }
  public  void setBookStatsNull(){
     this.set(S_BookStats,null);
  }

  public String getBookStats(){
       return DataType.getAsString(this.get(S_BookStats));
  
  }
  public String getBookStatsInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BookStats));
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

  public void initSendProvince(String value){
     this.initProperty(S_SendProvince,value);
  }
  public  void setSendProvince(String value){
     this.set(S_SendProvince,value);
  }
  public  void setSendProvinceNull(){
     this.set(S_SendProvince,null);
  }

  public String getSendProvince(){
       return DataType.getAsString(this.get(S_SendProvince));
  
  }
  public String getSendProvinceInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SendProvince));
      }

  public void initFailReason(String value){
     this.initProperty(S_FailReason,value);
  }
  public  void setFailReason(String value){
     this.set(S_FailReason,value);
  }
  public  void setFailReasonNull(){
     this.set(S_FailReason,null);
  }

  public String getFailReason(){
       return DataType.getAsString(this.get(S_FailReason));
  
  }
  public String getFailReasonInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FailReason));
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

  public void initIsSend(String value){
     this.initProperty(S_IsSend,value);
  }
  public  void setIsSend(String value){
     this.set(S_IsSend,value);
  }
  public  void setIsSendNull(){
     this.set(S_IsSend,null);
  }

  public String getIsSend(){
       return DataType.getAsString(this.get(S_IsSend));
  
  }
  public String getIsSendInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsSend));
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

  public void initSendTime(Timestamp value){
     this.initProperty(S_SendTime,value);
  }
  public  void setSendTime(Timestamp value){
     this.set(S_SendTime,value);
  }
  public  void setSendTimeNull(){
     this.set(S_SendTime,null);
  }

  public Timestamp getSendTime(){
        return DataType.getAsDateTime(this.get(S_SendTime));
  
  }
  public Timestamp getSendTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_SendTime));
      }

  public void initBookDetailId(long value){
     this.initProperty(S_BookDetailId,new Long(value));
  }
  public  void setBookDetailId(long value){
     this.set(S_BookDetailId,new Long(value));
  }
  public  void setBookDetailIdNull(){
     this.set(S_BookDetailId,null);
  }

  public long getBookDetailId(){
        return DataType.getAsLong(this.get(S_BookDetailId));
  
  }
  public long getBookDetailIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BookDetailId));
      }


 
 }

