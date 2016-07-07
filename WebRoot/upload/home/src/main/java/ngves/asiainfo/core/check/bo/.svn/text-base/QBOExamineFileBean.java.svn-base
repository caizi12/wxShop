package ngves.asiainfo.core.check.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.check.ivalues.*;

public class QBOExamineFileBean extends DataContainer implements DataContainerInterface,IQBOExamineFileValue{

	
	/**
	 * 
	 */
  private static final long serialVersionUID = 1000L;
    
  private static String  m_boName = "ngves.asiainfo.core.check.bo.QBOExamineFile";



  public final static  String S_UpdateTime = "UPDATE_TIME";
  public final static  String S_ExamineFileId = "EXAMINE_FILE_ID";
  public final static  String S_ExamineMonth = "EXAMINE_MONTH";
  public final static  String S_ExamineFileName = "EXAMINE_FILE_NAME";
     public final static  String S_PartnerType = "PARTNER_TYPE";
  public QBOExamineFileBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initUpdateTime(Timestamp value){
     this.initProperty(S_UpdateTime,value);
  }
  public  void setUpdateTime(Timestamp value){
     this.set(S_UpdateTime,value);
  }
  public  void setUpdateTimeNull(){
     this.set(S_UpdateTime,null);
  }

  public Timestamp getUpdateTime(){
        return DataType.getAsDateTime(this.get(S_UpdateTime));
  
  }
  public Timestamp getUpdateTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_UpdateTime));
      }

  public void initExamineFileId(long value){
     this.initProperty(S_ExamineFileId,new Long(value));
  }
  public  void setExamineFileId(long value){
     this.set(S_ExamineFileId,new Long(value));
  }
  public  void setExamineFileIdNull(){
     this.set(S_ExamineFileId,null);
  }

  public long getExamineFileId(){
        return DataType.getAsLong(this.get(S_ExamineFileId));
  
  }
  public long getExamineFileIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ExamineFileId));
      }

  public void initExamineMonth(String value){
     this.initProperty(S_ExamineMonth,value);
  }
  public  void setExamineMonth(String value){
     this.set(S_ExamineMonth,value);
  }
  public  void setExamineMonthNull(){
     this.set(S_ExamineMonth,null);
  }

  public String getExamineMonth(){
       return DataType.getAsString(this.get(S_ExamineMonth));
  
  }
  public String getExamineMonthInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExamineMonth));
      }

  public void initExamineFileName(String value){
     this.initProperty(S_ExamineFileName,value);
  }
  public  void setExamineFileName(String value){
     this.set(S_ExamineFileName,value);
  }
  public  void setExamineFileNameNull(){
     this.set(S_ExamineFileName,null);
  }

  public String getExamineFileName(){
       return DataType.getAsString(this.get(S_ExamineFileName));
  
  }
  public String getExamineFileNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExamineFileName));
      }


    //增加合作商类型
  public void initPartnerType(String value){
     this.initProperty(S_PartnerType,value);
  }
  public  void setPartnerType(String value){
     this.set(S_PartnerType,value);
  }
  public  void setPartnerTypeNull(){
     this.set(S_PartnerType,null);
  }

  public String getPartnerType(){
       return DataType.getAsString(this.get(S_PartnerType));

  }
  public String getPartnerTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PartnerType));
      }
 
 }

