package ngves.asiainfo.core.rushbuy.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.rushbuy.ivalues.*;

public class QBOFinishedActivityLimitGroupBean extends DataContainer implements DataContainerInterface,IQBOFinishedActivityLimitGroupValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = -204661827469402383L;



private static String  m_boName = "ngves.asiainfo.core.rushbuy.bo.QBOFinishedActivityLimitGroup";



  public final static  String S_Title = "TITLE";
  public final static  String S_EndTime = "END_TIME";
  public final static  String S_StartTime = "START_TIME";
  public final static  String S_AlGroupId = "AL_GROUP_ID";
  public final static  String S_Url = "URL";
  public final static  String S_ActivityId = "ACTIVITY_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBOFinishedActivityLimitGroupBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initTitle(String value){
     this.initProperty(S_Title,value);
  }
  public  void setTitle(String value){
     this.set(S_Title,value);
  }
  public  void setTitleNull(){
     this.set(S_Title,null);
  }

  public String getTitle(){
       return DataType.getAsString(this.get(S_Title));
  
  }
  public String getTitleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Title));
      }

  public void initEndTime(Timestamp value){
     this.initProperty(S_EndTime,value);
  }
  public  void setEndTime(Timestamp value){
     this.set(S_EndTime,value);
  }
  public  void setEndTimeNull(){
     this.set(S_EndTime,null);
  }

  public Timestamp getEndTime(){
        return DataType.getAsDateTime(this.get(S_EndTime));
  
  }
  public Timestamp getEndTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_EndTime));
      }

  public void initStartTime(Timestamp value){
     this.initProperty(S_StartTime,value);
  }
  public  void setStartTime(Timestamp value){
     this.set(S_StartTime,value);
  }
  public  void setStartTimeNull(){
     this.set(S_StartTime,null);
  }

  public Timestamp getStartTime(){
        return DataType.getAsDateTime(this.get(S_StartTime));
  
  }
  public Timestamp getStartTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_StartTime));
      }

  public void initAlGroupId(long value){
     this.initProperty(S_AlGroupId,new Long(value));
  }
  public  void setAlGroupId(long value){
     this.set(S_AlGroupId,new Long(value));
  }
  public  void setAlGroupIdNull(){
     this.set(S_AlGroupId,null);
  }

  public long getAlGroupId(){
        return DataType.getAsLong(this.get(S_AlGroupId));
  
  }
  public long getAlGroupIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AlGroupId));
      }

  public void initUrl(String value){
     this.initProperty(S_Url,value);
  }
  public  void setUrl(String value){
     this.set(S_Url,value);
  }
  public  void setUrlNull(){
     this.set(S_Url,null);
  }

  public String getUrl(){
       return DataType.getAsString(this.get(S_Url));
  
  }
  public String getUrlInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Url));
      }

  public void initActivityId(long value){
     this.initProperty(S_ActivityId,new Long(value));
  }
  public  void setActivityId(long value){
     this.set(S_ActivityId,new Long(value));
  }
  public  void setActivityIdNull(){
     this.set(S_ActivityId,null);
  }

  public long getActivityId(){
        return DataType.getAsLong(this.get(S_ActivityId));
  
  }
  public long getActivityIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ActivityId));
      }


 
 }

