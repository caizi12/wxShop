package ngves.asiainfo.core.ware.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.ware.ivalues.*;

public class WareMonitorRecordBean extends DataContainer implements DataContainerInterface,IWareMonitorRecordValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 7328675835730525284L;



private static String  m_boName = "ngves.asiainfo.core.ware.bo.WareMonitorRecord";



  public final static  String S_OperatorId = "OPERATOR_ID";
  public final static  String S_OperateDesc = "OPERATE_DESC";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_WareMonitorRecordId = "WARE_MONITOR_RECORD_ID";
  public final static  String S_OperateType = "OPERATE_TYPE";
  public final static  String S_OperateTime = "OPERATE_TIME";
  public WareMonitorRecordBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initOperatorId(long value){
     this.initProperty(S_OperatorId,new Long(value));
  }
  public  void setOperatorId(long value){
     this.set(S_OperatorId,new Long(value));
  }
  public  void setOperatorIdNull(){
     this.set(S_OperatorId,null);
  }

  public long getOperatorId(){
        return DataType.getAsLong(this.get(S_OperatorId));
  
  }
  public long getOperatorIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OperatorId));
      }

  public void initOperateDesc(String value){
     this.initProperty(S_OperateDesc,value);
  }
  public  void setOperateDesc(String value){
     this.set(S_OperateDesc,value);
  }
  public  void setOperateDescNull(){
     this.set(S_OperateDesc,null);
  }

  public String getOperateDesc(){
       return DataType.getAsString(this.get(S_OperateDesc));
  
  }
  public String getOperateDescInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OperateDesc));
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

  public void initWareMonitorRecordId(long value){
     this.initProperty(S_WareMonitorRecordId,new Long(value));
  }
  public  void setWareMonitorRecordId(long value){
     this.set(S_WareMonitorRecordId,new Long(value));
  }
  public  void setWareMonitorRecordIdNull(){
     this.set(S_WareMonitorRecordId,null);
  }

  public long getWareMonitorRecordId(){
        return DataType.getAsLong(this.get(S_WareMonitorRecordId));
  
  }
  public long getWareMonitorRecordIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_WareMonitorRecordId));
      }

  public void initOperateType(String value){
     this.initProperty(S_OperateType,value);
  }
  public  void setOperateType(String value){
     this.set(S_OperateType,value);
  }
  public  void setOperateTypeNull(){
     this.set(S_OperateType,null);
  }

  public String getOperateType(){
       return DataType.getAsString(this.get(S_OperateType));
  
  }
  public String getOperateTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OperateType));
      }

  public void initOperateTime(Timestamp value){
     this.initProperty(S_OperateTime,value);
  }
  public  void setOperateTime(Timestamp value){
     this.set(S_OperateTime,value);
  }
  public  void setOperateTimeNull(){
     this.set(S_OperateTime,null);
  }

  public Timestamp getOperateTime(){
        return DataType.getAsDateTime(this.get(S_OperateTime));
  
  }
  public Timestamp getOperateTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_OperateTime));
      }


 
 }

