package ngves.asiainfo.core.order.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.order.ivalues.*;

public class OrderUnfinishedTaskBean extends DataContainer implements DataContainerInterface,IOrderUnfinishedTaskValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.order.bo.OrderUnfinishedTask";



  public final static  String S_TaskState = "TASK_STATE";
  public final static  String S_IsCreateResult = "IS_CREATE_RESULT";
  public final static  String S_EndState = "END_STATE";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_Oper = "OPER";
  public final static  String S_FailFilePath = "FAIL_FILE_PATH";
  public final static  String S_OptId = "OPT_ID";
  public final static  String S_SecondTime = "SECOND_TIME";
  public final static  String S_ReTrialId = "RE_TRIAL_ID";
  public final static  String S_FailCounts = "FAIL_COUNTS";
  public final static  String S_BusinessType = "BUSINESS_TYPE";
  public final static  String S_FirstTime = "FIRST_TIME";
  public final static  String S_IsSettle = "IS_SETTLE";
  public final static  String S_NotExistsCounts = "NOT_EXISTS_COUNTS";
  public final static  String S_IsSend = "IS_SEND";
  public final static  String S_FirstTrialCode = "FIRST_TRIAL_CODE";
  public final static  String S_FirstTrialId = "FIRST_TRIAL_ID";
  public final static  String S_OrderType = "ORDER_TYPE";
  public final static  String S_ReTrialCode = "RE_TRIAL_CODE";
  public final static  String S_OptCode = "OPT_CODE";
  public final static  String S_SuccFilePath = "SUCC_FILE_PATH";
  public final static  String S_SuccCounts = "SUCC_COUNTS";
  public final static  String S_ManageState = "MANAGE_STATE";
  public final static  String S_FileNameSeq = "FILE_NAME_SEQ";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_DescInfo = "DESC_INFO";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_FileName = "FILE_NAME";
  public final static  String S_TaskId = "TASK_ID";
  public OrderUnfinishedTaskBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initTaskState(String value){
     this.initProperty(S_TaskState,value);
  }
  public  void setTaskState(String value){
     this.set(S_TaskState,value);
  }
  public  void setTaskStateNull(){
     this.set(S_TaskState,null);
  }

  public String getTaskState(){
       return DataType.getAsString(this.get(S_TaskState));
  
  }
  public String getTaskStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TaskState));
      }

  public void initIsCreateResult(String value){
     this.initProperty(S_IsCreateResult,value);
  }
  public  void setIsCreateResult(String value){
     this.set(S_IsCreateResult,value);
  }
  public  void setIsCreateResultNull(){
     this.set(S_IsCreateResult,null);
  }

  public String getIsCreateResult(){
       return DataType.getAsString(this.get(S_IsCreateResult));
  
  }
  public String getIsCreateResultInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsCreateResult));
      }

  public void initEndState(String value){
     this.initProperty(S_EndState,value);
  }
  public  void setEndState(String value){
     this.set(S_EndState,value);
  }
  public  void setEndStateNull(){
     this.set(S_EndState,null);
  }

  public String getEndState(){
       return DataType.getAsString(this.get(S_EndState));
  
  }
  public String getEndStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_EndState));
      }

  public void initCreateTime(Timestamp value){
     this.initProperty(S_CreateTime,value);
  }
  public  void setCreateTime(Timestamp value){
     this.set(S_CreateTime,value);
  }
  public  void setCreateTimeNull(){
     this.set(S_CreateTime,null);
  }

  public Timestamp getCreateTime(){
        return DataType.getAsDateTime(this.get(S_CreateTime));
  
  }
  public Timestamp getCreateTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CreateTime));
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

  public void initFailFilePath(String value){
     this.initProperty(S_FailFilePath,value);
  }
  public  void setFailFilePath(String value){
     this.set(S_FailFilePath,value);
  }
  public  void setFailFilePathNull(){
     this.set(S_FailFilePath,null);
  }

  public String getFailFilePath(){
       return DataType.getAsString(this.get(S_FailFilePath));
  
  }
  public String getFailFilePathInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FailFilePath));
      }

  public void initOptId(String value){
     this.initProperty(S_OptId,value);
  }
  public  void setOptId(String value){
     this.set(S_OptId,value);
  }
  public  void setOptIdNull(){
     this.set(S_OptId,null);
  }

  public String getOptId(){
       return DataType.getAsString(this.get(S_OptId));
  
  }
  public String getOptIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OptId));
      }

  public void initSecondTime(Timestamp value){
     this.initProperty(S_SecondTime,value);
  }
  public  void setSecondTime(Timestamp value){
     this.set(S_SecondTime,value);
  }
  public  void setSecondTimeNull(){
     this.set(S_SecondTime,null);
  }

  public Timestamp getSecondTime(){
        return DataType.getAsDateTime(this.get(S_SecondTime));
  
  }
  public Timestamp getSecondTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_SecondTime));
      }

  public void initReTrialId(String value){
     this.initProperty(S_ReTrialId,value);
  }
  public  void setReTrialId(String value){
     this.set(S_ReTrialId,value);
  }
  public  void setReTrialIdNull(){
     this.set(S_ReTrialId,null);
  }

  public String getReTrialId(){
       return DataType.getAsString(this.get(S_ReTrialId));
  
  }
  public String getReTrialIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ReTrialId));
      }

  public void initFailCounts(long value){
     this.initProperty(S_FailCounts,new Long(value));
  }
  public  void setFailCounts(long value){
     this.set(S_FailCounts,new Long(value));
  }
  public  void setFailCountsNull(){
     this.set(S_FailCounts,null);
  }

  public long getFailCounts(){
        return DataType.getAsLong(this.get(S_FailCounts));
  
  }
  public long getFailCountsInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_FailCounts));
      }

  public void initBusinessType(String value){
     this.initProperty(S_BusinessType,value);
  }
  public  void setBusinessType(String value){
     this.set(S_BusinessType,value);
  }
  public  void setBusinessTypeNull(){
     this.set(S_BusinessType,null);
  }

  public String getBusinessType(){
       return DataType.getAsString(this.get(S_BusinessType));
  
  }
  public String getBusinessTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BusinessType));
      }

  public void initFirstTime(Timestamp value){
     this.initProperty(S_FirstTime,value);
  }
  public  void setFirstTime(Timestamp value){
     this.set(S_FirstTime,value);
  }
  public  void setFirstTimeNull(){
     this.set(S_FirstTime,null);
  }

  public Timestamp getFirstTime(){
        return DataType.getAsDateTime(this.get(S_FirstTime));
  
  }
  public Timestamp getFirstTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_FirstTime));
      }

  public void initIsSettle(String value){
     this.initProperty(S_IsSettle,value);
  }
  public  void setIsSettle(String value){
     this.set(S_IsSettle,value);
  }
  public  void setIsSettleNull(){
     this.set(S_IsSettle,null);
  }

  public String getIsSettle(){
       return DataType.getAsString(this.get(S_IsSettle));
  
  }
  public String getIsSettleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsSettle));
      }

  public void initNotExistsCounts(long value){
     this.initProperty(S_NotExistsCounts,new Long(value));
  }
  public  void setNotExistsCounts(long value){
     this.set(S_NotExistsCounts,new Long(value));
  }
  public  void setNotExistsCountsNull(){
     this.set(S_NotExistsCounts,null);
  }

  public long getNotExistsCounts(){
        return DataType.getAsLong(this.get(S_NotExistsCounts));
  
  }
  public long getNotExistsCountsInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_NotExistsCounts));
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

  public void initFirstTrialCode(String value){
     this.initProperty(S_FirstTrialCode,value);
  }
  public  void setFirstTrialCode(String value){
     this.set(S_FirstTrialCode,value);
  }
  public  void setFirstTrialCodeNull(){
     this.set(S_FirstTrialCode,null);
  }

  public String getFirstTrialCode(){
       return DataType.getAsString(this.get(S_FirstTrialCode));
  
  }
  public String getFirstTrialCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FirstTrialCode));
      }

  public void initFirstTrialId(String value){
     this.initProperty(S_FirstTrialId,value);
  }
  public  void setFirstTrialId(String value){
     this.set(S_FirstTrialId,value);
  }
  public  void setFirstTrialIdNull(){
     this.set(S_FirstTrialId,null);
  }

  public String getFirstTrialId(){
       return DataType.getAsString(this.get(S_FirstTrialId));
  
  }
  public String getFirstTrialIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FirstTrialId));
      }

  public void initOrderType(String value){
     this.initProperty(S_OrderType,value);
  }
  public  void setOrderType(String value){
     this.set(S_OrderType,value);
  }
  public  void setOrderTypeNull(){
     this.set(S_OrderType,null);
  }

  public String getOrderType(){
       return DataType.getAsString(this.get(S_OrderType));
  
  }
  public String getOrderTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrderType));
      }

  public void initReTrialCode(String value){
     this.initProperty(S_ReTrialCode,value);
  }
  public  void setReTrialCode(String value){
     this.set(S_ReTrialCode,value);
  }
  public  void setReTrialCodeNull(){
     this.set(S_ReTrialCode,null);
  }

  public String getReTrialCode(){
       return DataType.getAsString(this.get(S_ReTrialCode));
  
  }
  public String getReTrialCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ReTrialCode));
      }

  public void initOptCode(String value){
     this.initProperty(S_OptCode,value);
  }
  public  void setOptCode(String value){
     this.set(S_OptCode,value);
  }
  public  void setOptCodeNull(){
     this.set(S_OptCode,null);
  }

  public String getOptCode(){
       return DataType.getAsString(this.get(S_OptCode));
  
  }
  public String getOptCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OptCode));
      }

  public void initSuccFilePath(String value){
     this.initProperty(S_SuccFilePath,value);
  }
  public  void setSuccFilePath(String value){
     this.set(S_SuccFilePath,value);
  }
  public  void setSuccFilePathNull(){
     this.set(S_SuccFilePath,null);
  }

  public String getSuccFilePath(){
       return DataType.getAsString(this.get(S_SuccFilePath));
  
  }
  public String getSuccFilePathInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SuccFilePath));
      }

  public void initSuccCounts(long value){
     this.initProperty(S_SuccCounts,new Long(value));
  }
  public  void setSuccCounts(long value){
     this.set(S_SuccCounts,new Long(value));
  }
  public  void setSuccCountsNull(){
     this.set(S_SuccCounts,null);
  }

  public long getSuccCounts(){
        return DataType.getAsLong(this.get(S_SuccCounts));
  
  }
  public long getSuccCountsInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SuccCounts));
      }

  public void initManageState(String value){
     this.initProperty(S_ManageState,value);
  }
  public  void setManageState(String value){
     this.set(S_ManageState,value);
  }
  public  void setManageStateNull(){
     this.set(S_ManageState,null);
  }

  public String getManageState(){
       return DataType.getAsString(this.get(S_ManageState));
  
  }
  public String getManageStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ManageState));
      }

  public void initFileNameSeq(String value){
     this.initProperty(S_FileNameSeq,value);
  }
  public  void setFileNameSeq(String value){
     this.set(S_FileNameSeq,value);
  }
  public  void setFileNameSeqNull(){
     this.set(S_FileNameSeq,null);
  }

  public String getFileNameSeq(){
       return DataType.getAsString(this.get(S_FileNameSeq));
  
  }
  public String getFileNameSeqInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FileNameSeq));
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

  public void initDescInfo(String value){
     this.initProperty(S_DescInfo,value);
  }
  public  void setDescInfo(String value){
     this.set(S_DescInfo,value);
  }
  public  void setDescInfoNull(){
     this.set(S_DescInfo,null);
  }

  public String getDescInfo(){
       return DataType.getAsString(this.get(S_DescInfo));
  
  }
  public String getDescInfoInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DescInfo));
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

  public void initFileName(String value){
     this.initProperty(S_FileName,value);
  }
  public  void setFileName(String value){
     this.set(S_FileName,value);
  }
  public  void setFileNameNull(){
     this.set(S_FileName,null);
  }

  public String getFileName(){
       return DataType.getAsString(this.get(S_FileName));
  
  }
  public String getFileNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FileName));
      }

  public void initTaskId(long value){
     this.initProperty(S_TaskId,new Long(value));
  }
  public  void setTaskId(long value){
     this.set(S_TaskId,new Long(value));
  }
  public  void setTaskIdNull(){
     this.set(S_TaskId,null);
  }

  public long getTaskId(){
        return DataType.getAsLong(this.get(S_TaskId));
  
  }
  public long getTaskIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TaskId));
      }


 
 }

