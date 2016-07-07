package ngves.asiainfo.core.ware.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.ware.ivalues.*;

public class QBOPermissionRuleRltBean extends DataContainer implements DataContainerInterface,IQBOPermissionRuleRltValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.ware.bo.QBOPermissionRuleRlt";



  public final static  String S_WareCode = "WARE_CODE";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_ActionStartTime = "ACTION_START_TIME";
  public final static  String S_BindStatus = "BIND_STATUS";
  public final static  String S_PermissionId = "PERMISSION_ID";
  public final static  String S_ActionEndTime = "ACTION_END_TIME";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_WareBindRuleRltId = "WARE_BIND_RULE_RLT_ID";
  public final static  String S_WareId = "WARE_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBOPermissionRuleRltBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initWareCode(String value){
     this.initProperty(S_WareCode,value);
  }
  public  void setWareCode(String value){
     this.set(S_WareCode,value);
  }
  public  void setWareCodeNull(){
     this.set(S_WareCode,null);
  }

  public String getWareCode(){
       return DataType.getAsString(this.get(S_WareCode));
  
  }
  public String getWareCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WareCode));
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

  public void initActionStartTime(Timestamp value){
     this.initProperty(S_ActionStartTime,value);
  }
  public  void setActionStartTime(Timestamp value){
     this.set(S_ActionStartTime,value);
  }
  public  void setActionStartTimeNull(){
     this.set(S_ActionStartTime,null);
  }

  public Timestamp getActionStartTime(){
        return DataType.getAsDateTime(this.get(S_ActionStartTime));
  
  }
  public Timestamp getActionStartTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ActionStartTime));
      }

  public void initBindStatus(String value){
     this.initProperty(S_BindStatus,value);
  }
  public  void setBindStatus(String value){
     this.set(S_BindStatus,value);
  }
  public  void setBindStatusNull(){
     this.set(S_BindStatus,null);
  }

  public String getBindStatus(){
       return DataType.getAsString(this.get(S_BindStatus));
  
  }
  public String getBindStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BindStatus));
      }

  public void initPermissionId(long value){
     this.initProperty(S_PermissionId,new Long(value));
  }
  public  void setPermissionId(long value){
     this.set(S_PermissionId,new Long(value));
  }
  public  void setPermissionIdNull(){
     this.set(S_PermissionId,null);
  }

  public long getPermissionId(){
        return DataType.getAsLong(this.get(S_PermissionId));
  
  }
  public long getPermissionIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PermissionId));
      }

  public void initActionEndTime(Timestamp value){
     this.initProperty(S_ActionEndTime,value);
  }
  public  void setActionEndTime(Timestamp value){
     this.set(S_ActionEndTime,value);
  }
  public  void setActionEndTimeNull(){
     this.set(S_ActionEndTime,null);
  }

  public Timestamp getActionEndTime(){
        return DataType.getAsDateTime(this.get(S_ActionEndTime));
  
  }
  public Timestamp getActionEndTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ActionEndTime));
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

  public void initWareBindRuleRltId(long value){
     this.initProperty(S_WareBindRuleRltId,new Long(value));
  }
  public  void setWareBindRuleRltId(long value){
     this.set(S_WareBindRuleRltId,new Long(value));
  }
  public  void setWareBindRuleRltIdNull(){
     this.set(S_WareBindRuleRltId,null);
  }

  public long getWareBindRuleRltId(){
        return DataType.getAsLong(this.get(S_WareBindRuleRltId));
  
  }
  public long getWareBindRuleRltIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_WareBindRuleRltId));
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


 
 }

