package ngves.asiainfo.core.common.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.common.ivalues.IRequisitionInfoValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

@SuppressWarnings("serial")
public class RequisitionInfoBean extends DataContainer implements DataContainerInterface,IRequisitionInfoValue{

  private static String  m_boName = "ngves.asiainfo.core.common.bo.RequisitionInfo";



  public final static  String S_OriginateStaffId = "ORIGINATE_STAFF_ID";
  public final static  String S_RequisitionTitle = "REQUISITION_TITLE";
  public final static  String S_OriginateTime = "ORIGINATE_TIME";
  public final static  String S_Note = "NOTE";
  public final static  String S_RequisitionId = "REQUISITION_ID";
  public final static  String S_ProvinceCode = "PROVINCE_CODE";
  public final static  String S_RequisitionDesc = "REQUISITION_DESC";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public RequisitionInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initOriginateStaffId(long value){
     this.initProperty(S_OriginateStaffId,Long.valueOf(value));
  }
  public  void setOriginateStaffId(long value){
     this.set(S_OriginateStaffId,Long.valueOf(value));
  }
  public  void setOriginateStaffIdNull(){
     this.set(S_OriginateStaffId,null);
  }

  public long getOriginateStaffId(){
        return DataType.getAsLong(this.get(S_OriginateStaffId));
  
  }
  public long getOriginateStaffIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OriginateStaffId));
      }

  public void initRequisitionTitle(String value){
     this.initProperty(S_RequisitionTitle,value);
  }
  public  void setRequisitionTitle(String value){
     this.set(S_RequisitionTitle,value);
  }
  public  void setRequisitionTitleNull(){
     this.set(S_RequisitionTitle,null);
  }

  public String getRequisitionTitle(){
       return DataType.getAsString(this.get(S_RequisitionTitle));
  
  }
  public String getRequisitionTitleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RequisitionTitle));
      }

  public void initOriginateTime(Timestamp value){
     this.initProperty(S_OriginateTime,value);
  }
  public  void setOriginateTime(Timestamp value){
     this.set(S_OriginateTime,value);
  }
  public  void setOriginateTimeNull(){
     this.set(S_OriginateTime,null);
  }

  public Timestamp getOriginateTime(){
        return DataType.getAsDateTime(this.get(S_OriginateTime));
  
  }
  public Timestamp getOriginateTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_OriginateTime));
      }

  public void initNote(String value){
     this.initProperty(S_Note,value);
  }
  public  void setNote(String value){
     this.set(S_Note,value);
  }
  public  void setNoteNull(){
     this.set(S_Note,null);
  }

  public String getNote(){
       return DataType.getAsString(this.get(S_Note));
  
  }
  public String getNoteInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Note));
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

  public void initRequisitionDesc(String value){
     this.initProperty(S_RequisitionDesc,value);
  }
  public  void setRequisitionDesc(String value){
     this.set(S_RequisitionDesc,value);
  }
  public  void setRequisitionDescNull(){
     this.set(S_RequisitionDesc,null);
  }

  public String getRequisitionDesc(){
       return DataType.getAsString(this.get(S_RequisitionDesc));
  
  }
  public String getRequisitionDescInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RequisitionDesc));
      }


 
 }

