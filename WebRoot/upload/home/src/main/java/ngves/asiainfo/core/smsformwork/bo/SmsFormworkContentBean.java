package ngves.asiainfo.core.smsformwork.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.smsformwork.ivalues.ISmsFormworkContentValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class SmsFormworkContentBean extends DataContainer implements DataContainerInterface,ISmsFormworkContentValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 8927862048953088747L;



private static String  m_boName = "ngves.asiainfo.core.smsformwork.bo.SmsFormworkContent";



  public final static  String S_IsStopped = "IS_STOPPED";
  public final static  String S_OperatorCode = "OPERATOR_CODE";
  public final static  String S_ContentId = "CONTENT_ID";
  public final static  String S_ContentInfo = "CONTENT_INFO";
  public final static  String S_ContentName = "CONTENT_NAME";
  public final static  String S_OperateTime = "OPERATE_TIME";
  public final static  String S_Oper = "OPER";
  public SmsFormworkContentBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initIsStopped(String value){
     this.initProperty(S_IsStopped,value);
  }
  public  void setIsStopped(String value){
     this.set(S_IsStopped,value);
  }
  public  void setIsStoppedNull(){
     this.set(S_IsStopped,null);
  }

  public String getIsStopped(){
       return DataType.getAsString(this.get(S_IsStopped));
  
  }
  public String getIsStoppedInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsStopped));
      }

  public void initOperatorCode(String value){
     this.initProperty(S_OperatorCode,value);
  }
  public  void setOperatorCode(String value){
     this.set(S_OperatorCode,value);
  }
  public  void setOperatorCodeNull(){
     this.set(S_OperatorCode,null);
  }

  public String getOperatorCode(){
       return DataType.getAsString(this.get(S_OperatorCode));
  
  }
  public String getOperatorCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OperatorCode));
      }

  public void initContentId(String value){
     this.initProperty(S_ContentId,value);
  }
  public  void setContentId(String value){
     this.set(S_ContentId,value);
  }
  public  void setContentIdNull(){
     this.set(S_ContentId,null);
  }

  public String getContentId(){
       return DataType.getAsString(this.get(S_ContentId));
  
  }
  public String getContentIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ContentId));
      }

  public void initContentInfo(String value){
     this.initProperty(S_ContentInfo,value);
  }
  public  void setContentInfo(String value){
     this.set(S_ContentInfo,value);
  }
  public  void setContentInfoNull(){
     this.set(S_ContentInfo,null);
  }

  public String getContentInfo(){
       return DataType.getAsString(this.get(S_ContentInfo));
  
  }
  public String getContentInfoInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ContentInfo));
      }

  public void initContentName(String value){
     this.initProperty(S_ContentName,value);
  }
  public  void setContentName(String value){
     this.set(S_ContentName,value);
  }
  public  void setContentNameNull(){
     this.set(S_ContentName,null);
  }

  public String getContentName(){
       return DataType.getAsString(this.get(S_ContentName));
  
  }
  public String getContentNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ContentName));
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


 
 }

