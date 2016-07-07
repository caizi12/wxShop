package ngves.asiainfo.core.review.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.review.ivalues.*;

@SuppressWarnings("serial")
public class ReviewStaffRltBean extends DataContainer implements DataContainerInterface,IReviewStaffRltValue{

  private static String  m_boName = "ngves.asiainfo.core.review.bo.ReviewStaffRlt";



  public final static  String S_Bak1 = "BAK1";
  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_ReviewStaffId = "REVIEW_STAFF_ID";
  public final static  String S_ReviewDescId = "REVIEW_DESC_ID";
  public final static  String S_UpdateDate = "UPDATE_DATE";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Status = "STATUS";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public ReviewStaffRltBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initBak1(String value){
     this.initProperty(S_Bak1,value);
  }
  public  void setBak1(String value){
     this.set(S_Bak1,value);
  }
  public  void setBak1Null(){
     this.set(S_Bak1,null);
  }

  public String getBak1(){
       return DataType.getAsString(this.get(S_Bak1));
  
  }
  public String getBak1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Bak1));
      }

  public void initStaffId(long value){
     this.initProperty(S_StaffId,new Long(value));
  }
  public  void setStaffId(long value){
     this.set(S_StaffId,new Long(value));
  }
  public  void setStaffIdNull(){
     this.set(S_StaffId,null);
  }

  public long getStaffId(){
        return DataType.getAsLong(this.get(S_StaffId));
  
  }
  public long getStaffIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_StaffId));
      }

  public void initReviewStaffId(long value){
     this.initProperty(S_ReviewStaffId,new Long(value));
  }
  public  void setReviewStaffId(long value){
     this.set(S_ReviewStaffId,new Long(value));
  }
  public  void setReviewStaffIdNull(){
     this.set(S_ReviewStaffId,null);
  }

  public long getReviewStaffId(){
        return DataType.getAsLong(this.get(S_ReviewStaffId));
  
  }
  public long getReviewStaffIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ReviewStaffId));
      }

  public void initReviewDescId(long value){
     this.initProperty(S_ReviewDescId,new Long(value));
  }
  public  void setReviewDescId(long value){
     this.set(S_ReviewDescId,new Long(value));
  }
  public  void setReviewDescIdNull(){
     this.set(S_ReviewDescId,null);
  }

  public long getReviewDescId(){
        return DataType.getAsLong(this.get(S_ReviewDescId));
  
  }
  public long getReviewDescIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ReviewDescId));
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

  public void initStatus(String value){
     this.initProperty(S_Status,value);
  }
  public  void setStatus(String value){
     this.set(S_Status,value);
  }
  public  void setStatusNull(){
     this.set(S_Status,null);
  }

  public String getStatus(){
       return DataType.getAsString(this.get(S_Status));
  
  }
  public String getStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Status));
      }


 
 }

