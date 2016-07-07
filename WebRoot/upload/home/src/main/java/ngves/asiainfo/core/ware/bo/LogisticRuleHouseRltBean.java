package ngves.asiainfo.core.ware.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.ware.ivalues.*;

@SuppressWarnings("serial")
public class LogisticRuleHouseRltBean extends DataContainer implements DataContainerInterface,ILogisticRuleHouseRltValue{

  private static String  m_boName = "ngves.asiainfo.core.ware.bo.LogisticRuleHouseRlt";



  public final static  String S_UpdateTime = "UPDATE_TIME";
  public final static  String S_RuleId = "RULE_ID";
  public final static  String S_WarehouseId = "WAREHOUSE_ID";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_ValidFlag = "VALID_FLAG";
  public final static  String S_RltId = "RLT_ID";
  public LogisticRuleHouseRltBean() throws AIException{
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

  public void initValidFlag(String value){
     this.initProperty(S_ValidFlag,value);
  }
  public  void setValidFlag(String value){
     this.set(S_ValidFlag,value);
  }
  public  void setValidFlagNull(){
     this.set(S_ValidFlag,null);
  }

  public String getValidFlag(){
       return DataType.getAsString(this.get(S_ValidFlag));
  
  }
  public String getValidFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ValidFlag));
      }

  public void initRltId(long value){
     this.initProperty(S_RltId,new Long(value));
  }
  public  void setRltId(long value){
     this.set(S_RltId,new Long(value));
  }
  public  void setRltIdNull(){
     this.set(S_RltId,null);
  }

  public long getRltId(){
        return DataType.getAsLong(this.get(S_RltId));
  
  }
  public long getRltIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RltId));
      }


 
 }

