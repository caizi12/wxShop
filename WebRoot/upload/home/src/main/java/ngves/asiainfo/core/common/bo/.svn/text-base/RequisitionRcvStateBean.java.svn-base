package ngves.asiainfo.core.common.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.common.ivalues.IRequisitionRcvStateValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class RequisitionRcvStateBean extends DataContainer implements DataContainerInterface,IRequisitionRcvStateValue{

  /**
     * 
     */
    private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.common.bo.RequisitionRcvState";



  public final static  String S_AnswerContent = "ANSWER_CONTENT";
  public final static  String S_RequisitionRcvId = "REQUISITION_RCV_ID";
  public final static  String S_RequisitionStatus = "REQUISITION_STATUS";
  public final static  String S_RequisitionId = "REQUISITION_ID";
  public final static  String S_AnswerDate = "ANSWER_DATE";
  public final static  String S_BrowseDate = "BROWSE_DATE";
  public final static  String S_RcvStaffId = "RCV_STAFF_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public RequisitionRcvStateBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initAnswerContent(String value){
     this.initProperty(S_AnswerContent,value);
  }
  public  void setAnswerContent(String value){
     this.set(S_AnswerContent,value);
  }
  public  void setAnswerContentNull(){
     this.set(S_AnswerContent,null);
  }

  public String getAnswerContent(){
       return DataType.getAsString(this.get(S_AnswerContent));
  
  }
  public String getAnswerContentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AnswerContent));
      }

  public void initRequisitionRcvId(long value){
     this.initProperty(S_RequisitionRcvId,Long.valueOf(value));
  }
  public  void setRequisitionRcvId(long value){
     this.set(S_RequisitionRcvId,Long.valueOf(value));
  }
  public  void setRequisitionRcvIdNull(){
     this.set(S_RequisitionRcvId,null);
  }

  public long getRequisitionRcvId(){
        return DataType.getAsLong(this.get(S_RequisitionRcvId));
  
  }
  public long getRequisitionRcvIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RequisitionRcvId));
      }

  public void initRequisitionStatus(String value){
     this.initProperty(S_RequisitionStatus,value);
  }
  public  void setRequisitionStatus(String value){
     this.set(S_RequisitionStatus,value);
  }
  public  void setRequisitionStatusNull(){
     this.set(S_RequisitionStatus,null);
  }

  public String getRequisitionStatus(){
       return DataType.getAsString(this.get(S_RequisitionStatus));
  
  }
  public String getRequisitionStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RequisitionStatus));
      }

  public void initRequisitionId(long value){
     this.initProperty(S_RequisitionId,Long.valueOf(value));
  }
  public  void setRequisitionId(long value){
     this.set(S_RequisitionId,Long.valueOf(value));
  }
  public  void setRequisitionIdNull(){
     this.set(S_RequisitionId,null);
  }

  public long getRequisitionId(){
        return DataType.getAsLong(this.get(S_RequisitionId));
  
  }
  public long getRequisitionIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RequisitionId));
      }

  public void initAnswerDate(Timestamp value){
     this.initProperty(S_AnswerDate,value);
  }
  public  void setAnswerDate(Timestamp value){
     this.set(S_AnswerDate,value);
  }
  public  void setAnswerDateNull(){
     this.set(S_AnswerDate,null);
  }

  public Timestamp getAnswerDate(){
        return DataType.getAsDateTime(this.get(S_AnswerDate));
  
  }
  public Timestamp getAnswerDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_AnswerDate));
      }

  public void initBrowseDate(Timestamp value){
     this.initProperty(S_BrowseDate,value);
  }
  public  void setBrowseDate(Timestamp value){
     this.set(S_BrowseDate,value);
  }
  public  void setBrowseDateNull(){
     this.set(S_BrowseDate,null);
  }

  public Timestamp getBrowseDate(){
        return DataType.getAsDateTime(this.get(S_BrowseDate));
  
  }
  public Timestamp getBrowseDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_BrowseDate));
      }

  public void initRcvStaffId(long value){
     this.initProperty(S_RcvStaffId,Long.valueOf(value));
  }
  public  void setRcvStaffId(long value){
     this.set(S_RcvStaffId,Long.valueOf(value));
  }
  public  void setRcvStaffIdNull(){
     this.set(S_RcvStaffId,null);
  }

  public long getRcvStaffId(){
        return DataType.getAsLong(this.get(S_RcvStaffId));
  
  }
  public long getRcvStaffIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RcvStaffId));
      }


 
 }

