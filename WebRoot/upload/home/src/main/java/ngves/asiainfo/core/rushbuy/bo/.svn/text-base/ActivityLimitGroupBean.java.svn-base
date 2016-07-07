package ngves.asiainfo.core.rushbuy.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.rushbuy.ivalues.*;

public class ActivityLimitGroupBean extends DataContainer implements DataContainerInterface,IActivityLimitGroupValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 2235985057661621028L;



private static String  m_boName = "ngves.asiainfo.core.rushbuy.bo.ActivityLimitGroup";



  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_AlGroupTitle = "AL_GROUP_TITLE";
  public final static  String S_AlGroupId = "AL_GROUP_ID";
  public final static  String S_AlGroupCreate = "AL_GROUP_CREATE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public ActivityLimitGroupBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initBakCol(String value){
     this.initProperty(S_BakCol,value);
  }
  public  void setBakCol(String value){
     this.set(S_BakCol,value);
  }
  public  void setBakColNull(){
     this.set(S_BakCol,null);
  }

  public String getBakCol(){
       return DataType.getAsString(this.get(S_BakCol));
  
  }
  public String getBakColInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BakCol));
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

  public void initAlGroupTitle(String value){
     this.initProperty(S_AlGroupTitle,value);
  }
  public  void setAlGroupTitle(String value){
     this.set(S_AlGroupTitle,value);
  }
  public  void setAlGroupTitleNull(){
     this.set(S_AlGroupTitle,null);
  }

  public String getAlGroupTitle(){
       return DataType.getAsString(this.get(S_AlGroupTitle));
  
  }
  public String getAlGroupTitleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AlGroupTitle));
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

  public void initAlGroupCreate(Timestamp value){
     this.initProperty(S_AlGroupCreate,value);
  }
  public  void setAlGroupCreate(Timestamp value){
     this.set(S_AlGroupCreate,value);
  }
  public  void setAlGroupCreateNull(){
     this.set(S_AlGroupCreate,null);
  }

  public Timestamp getAlGroupCreate(){
        return DataType.getAsDateTime(this.get(S_AlGroupCreate));
  
  }
  public Timestamp getAlGroupCreateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_AlGroupCreate));
      }


 
 }

