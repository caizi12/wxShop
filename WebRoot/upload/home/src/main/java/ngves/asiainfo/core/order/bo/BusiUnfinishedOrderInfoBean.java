package ngves.asiainfo.core.order.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.order.ivalues.*;

public class BusiUnfinishedOrderInfoBean extends DataContainer implements DataContainerInterface,IBusiUnfinishedOrderInfoValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.order.bo.BusiUnfinishedOrderInfo";



  public final static  String S_BusiId = "BUSI_ID";
  public final static  String S_OrderType = "ORDER_TYPE";
  public final static  String S_EndState = "END_STATE";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_OperTime = "OPER_TIME";
  public final static  String S_OptId = "OPT_ID";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_BusinessType = "BUSINESS_TYPE";
  public final static  String S_DescInfo = "DESC_INFO";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_IsSettle = "IS_SETTLE";
  public final static  String S_TaskId = "TASK_ID";
  public final static  String S_IsSend = "IS_SEND";
  public final static  String S_IsFileChange = "IS_FILE_CHANGE";
  public BusiUnfinishedOrderInfoBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initBusiId(long value){
     this.initProperty(S_BusiId,new Long(value));
  }
  public  void setBusiId(long value){
     this.set(S_BusiId,new Long(value));
  }
  public  void setBusiIdNull(){
     this.set(S_BusiId,null);
  }

  public long getBusiId(){
        return DataType.getAsLong(this.get(S_BusiId));
  
  }
  public long getBusiIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BusiId));
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

  public void initOperTime(Timestamp value){
     this.initProperty(S_OperTime,value);
  }
  public  void setOperTime(Timestamp value){
     this.set(S_OperTime,value);
  }
  public  void setOperTimeNull(){
     this.set(S_OperTime,null);
  }

  public Timestamp getOperTime(){
        return DataType.getAsDateTime(this.get(S_OperTime));
  
  }
  public Timestamp getOperTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_OperTime));
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

  public void initTaskId(String value){
     this.initProperty(S_TaskId,value);
  }
  public  void setTaskId(String value){
     this.set(S_TaskId,value);
  }
  public  void setTaskIdNull(){
     this.set(S_TaskId,null);
  }

  public String getTaskId(){
       return DataType.getAsString(this.get(S_TaskId));
  
  }
  public String getTaskIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TaskId));
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

  public void initIsFileChange(String value){
     this.initProperty(S_IsFileChange,value);
  }
  public  void setIsFileChange(String value){
     this.set(S_IsFileChange,value);
  }
  public  void setIsFileChangeNull(){
     this.set(S_IsFileChange,null);
  }

  public String getIsFileChange(){
       return DataType.getAsString(this.get(S_IsFileChange));
  
  }
  public String getIsFileChangeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsFileChange));
      }


 
 }

