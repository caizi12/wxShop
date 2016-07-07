package ngves.asiainfo.core.ware.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.ware.ivalues.*;

public class QBOMonitorWareBean extends DataContainer implements DataContainerInterface,IQBOMonitorWareValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1877505143395448882L;



private static String  m_boName = "ngves.asiainfo.core.ware.bo.QBOMonitorWare";



  public final static  String S_PartnerName = "PARTNER_NAME";
  public final static  String S_KindName = "KIND_NAME";
  public final static  String S_JobTaskId = "JOB_TASK_ID";
  public final static  String S_WareStatus = "WARE_STATUS";
  public final static  String S_WareName = "WARE_NAME";
  public final static  String S_WareCode = "WARE_CODE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBOMonitorWareBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initPartnerName(String value){
     this.initProperty(S_PartnerName,value);
  }
  public  void setPartnerName(String value){
     this.set(S_PartnerName,value);
  }
  public  void setPartnerNameNull(){
     this.set(S_PartnerName,null);
  }

  public String getPartnerName(){
       return DataType.getAsString(this.get(S_PartnerName));
  
  }
  public String getPartnerNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PartnerName));
      }

  public void initKindName(String value){
     this.initProperty(S_KindName,value);
  }
  public  void setKindName(String value){
     this.set(S_KindName,value);
  }
  public  void setKindNameNull(){
     this.set(S_KindName,null);
  }

  public String getKindName(){
       return DataType.getAsString(this.get(S_KindName));
  
  }
  public String getKindNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_KindName));
      }

  public void initJobTaskId(long value){
     this.initProperty(S_JobTaskId,new Long(value));
  }
  public  void setJobTaskId(long value){
     this.set(S_JobTaskId,new Long(value));
  }
  public  void setJobTaskIdNull(){
     this.set(S_JobTaskId,null);
  }

  public long getJobTaskId(){
        return DataType.getAsLong(this.get(S_JobTaskId));
  
  }
  public long getJobTaskIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_JobTaskId));
      }

  public void initWareStatus(String value){
     this.initProperty(S_WareStatus,value);
  }
  public  void setWareStatus(String value){
     this.set(S_WareStatus,value);
  }
  public  void setWareStatusNull(){
     this.set(S_WareStatus,null);
  }

  public String getWareStatus(){
       return DataType.getAsString(this.get(S_WareStatus));
  
  }
  public String getWareStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WareStatus));
      }

  public void initWareName(String value){
     this.initProperty(S_WareName,value);
  }
  public  void setWareName(String value){
     this.set(S_WareName,value);
  }
  public  void setWareNameNull(){
     this.set(S_WareName,null);
  }

  public String getWareName(){
       return DataType.getAsString(this.get(S_WareName));
  
  }
  public String getWareNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WareName));
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


 
 }

