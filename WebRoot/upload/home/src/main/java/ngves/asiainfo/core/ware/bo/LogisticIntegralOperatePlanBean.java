package ngves.asiainfo.core.ware.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.ware.ivalues.ILogisticIntegralOperatePlanValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class LogisticIntegralOperatePlanBean extends DataContainer implements DataContainerInterface,ILogisticIntegralOperatePlanValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.ware.bo.LogisticIntegralOperatePlan";


  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_WarehouseId = "WAREHOUSE_ID";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_OperatePlanType = "OPERATE_PLAN_TYPE";
  public final static  String S_ComType = "COM_TYPE";
  public final static  String S_PartnerId = "PARTNER_ID";
  public final static  String S_ModifyTime = "MODIFY_TIME";
  public final static  String S_OperatePlanState = "OPERATE_PLAN_STATE";
  public final static  String S_OperatePlanId = "OPERATE_PLAN_ID";
  public final static  String S_RuleId = "RULE_ID";
  public LogisticIntegralOperatePlanBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
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

  public void initWarehouseId(long value){
     this.initProperty(S_WarehouseId,new Long(value));
  }
  public  void setWarehouseId(long value){
     this.set(S_WarehouseId,new Long(value));
  }
  public  void setWarehouseIdNull(){
     this.set(S_WarehouseId,null);
  }

  public long getWarehouseId(){
        return DataType.getAsLong(this.get(S_WarehouseId));
  
  }
  public long getWarehouseIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_WarehouseId));
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

  public void initOperatePlanType(String value){
     this.initProperty(S_OperatePlanType,value);
  }
  public  void setOperatePlanType(String value){
     this.set(S_OperatePlanType,value);
  }
  public  void setOperatePlanTypeNull(){
     this.set(S_OperatePlanType,null);
  }

  public String getOperatePlanType(){
       return DataType.getAsString(this.get(S_OperatePlanType));
  
  }
  public String getOperatePlanTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OperatePlanType));
      }

  public void initComType(String value){
     this.initProperty(S_ComType,value);
  }
  public  void setComType(String value){
     this.set(S_ComType,value);
  }
  public  void setComTypeNull(){
     this.set(S_ComType,null);
  }

  public String getComType(){
       return DataType.getAsString(this.get(S_ComType));
  
  }
  public String getComTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ComType));
      }

  public void initPartnerId(long value){
     this.initProperty(S_PartnerId,new Long(value));
  }
  public  void setPartnerId(long value){
     this.set(S_PartnerId,new Long(value));
  }
  public  void setPartnerIdNull(){
     this.set(S_PartnerId,null);
  }

  public long getPartnerId(){
        return DataType.getAsLong(this.get(S_PartnerId));
  
  }
  public long getPartnerIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PartnerId));
      }

  public void initModifyTime(Timestamp value){
     this.initProperty(S_ModifyTime,value);
  }
  public  void setModifyTime(Timestamp value){
     this.set(S_ModifyTime,value);
  }
  public  void setModifyTimeNull(){
     this.set(S_ModifyTime,null);
  }

  public Timestamp getModifyTime(){
        return DataType.getAsDateTime(this.get(S_ModifyTime));
  
  }
  public Timestamp getModifyTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ModifyTime));
      }

  public void initOperatePlanState(String value){
     this.initProperty(S_OperatePlanState,value);
  }
  public  void setOperatePlanState(String value){
     this.set(S_OperatePlanState,value);
  }
  public  void setOperatePlanStateNull(){
     this.set(S_OperatePlanState,null);
  }

  public String getOperatePlanState(){
       return DataType.getAsString(this.get(S_OperatePlanState));
  
  }
  public String getOperatePlanStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OperatePlanState));
      }

  public void initOperatePlanId(long value){
     this.initProperty(S_OperatePlanId,new Long(value));
  }
  public  void setOperatePlanId(long value){
     this.set(S_OperatePlanId,new Long(value));
  }
  public  void setOperatePlanIdNull(){
     this.set(S_OperatePlanId,null);
  }

  public long getOperatePlanId(){
        return DataType.getAsLong(this.get(S_OperatePlanId));
  
  }
  public long getOperatePlanIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OperatePlanId));
      }
  public void initRuleId(long value){
	     this.initProperty(S_RuleId,new Long(value));
	  }
  public  void setRuleId(long value){
     this.set(S_RuleId,new Long(value));
  }
  public  void setRuleIdNull(){
     this.set(S_RuleId,null);
  }

  public long getRuleId(){
        return DataType.getAsLong(this.get(S_RuleId));
  
  }
  public long getRuleIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RuleId));
      }

 
 }

