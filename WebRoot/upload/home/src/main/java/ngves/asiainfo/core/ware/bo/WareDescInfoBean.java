package ngves.asiainfo.core.ware.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.*;
import ngves.asiainfo.core.ware.ivalues.IWareDescInfoValue;

public class WareDescInfoBean extends DataContainer implements DataContainerInterface,IWareDescInfoValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = -5331774873186859206L;



private static String  m_boName = "ngves.asiainfo.core.ware.bo.WareDescInfo";



  public final static  String S_IsGroupFlag = "IS_GROUP_FLAG";
  public final static  String S_SortId = "SORT_ID";
  public final static  String S_DescDefineId = "DESC_DEFINE_ID";
  public final static  String S_WareDescId = "WARE_DESC_ID";
  public final static  String S_AppVersion = "APP_VERSION";
  public final static  String S_WareDescValue = "WARE_DESC_VALUE";
  public final static  String S_WareId = "WARE_ID";
  public WareDescInfoBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initIsGroupFlag(String value){
     this.initProperty(S_IsGroupFlag,value);
  }
  public  void setIsGroupFlag(String value){
     this.set(S_IsGroupFlag,value);
  }
  public  void setIsGroupFlagNull(){
     this.set(S_IsGroupFlag,null);
  }

  public String getIsGroupFlag(){
       return DataType.getAsString(this.get(S_IsGroupFlag));
  
  }
  public String getIsGroupFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsGroupFlag));
      }

  public void initSortId(long value){
     this.initProperty(S_SortId,new Long(value));
  }
  public  void setSortId(long value){
     this.set(S_SortId,new Long(value));
  }
  public  void setSortIdNull(){
     this.set(S_SortId,null);
  }

  public long getSortId(){
        return DataType.getAsLong(this.get(S_SortId));
  
  }
  public long getSortIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SortId));
      }

  public void initDescDefineId(long value){
     this.initProperty(S_DescDefineId,new Long(value));
  }
  public  void setDescDefineId(long value){
     this.set(S_DescDefineId,new Long(value));
  }
  public  void setDescDefineIdNull(){
     this.set(S_DescDefineId,null);
  }

  public long getDescDefineId(){
        return DataType.getAsLong(this.get(S_DescDefineId));
  
  }
  public long getDescDefineIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_DescDefineId));
      }

  public void initWareDescId(long value){
     this.initProperty(S_WareDescId,new Long(value));
  }
  public  void setWareDescId(long value){
     this.set(S_WareDescId,new Long(value));
  }
  public  void setWareDescIdNull(){
     this.set(S_WareDescId,null);
  }

  public long getWareDescId(){
        return DataType.getAsLong(this.get(S_WareDescId));
  
  }
  public long getWareDescIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_WareDescId));
      }

  public void initAppVersion(long value){
     this.initProperty(S_AppVersion,new Long(value));
  }
  public  void setAppVersion(long value){
     this.set(S_AppVersion,new Long(value));
  }
  public  void setAppVersionNull(){
     this.set(S_AppVersion,null);
  }

  public long getAppVersion(){
        return DataType.getAsLong(this.get(S_AppVersion));
  
  }
  public long getAppVersionInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AppVersion));
      }

  public void initWareDescValue(String value){
     this.initProperty(S_WareDescValue,value);
  }
  public  void setWareDescValue(String value){
     this.set(S_WareDescValue,value);
  }
  public  void setWareDescValueNull(){
     this.set(S_WareDescValue,null);
  }

  public String getWareDescValue(){
       return DataType.getAsString(this.get(S_WareDescValue));
  
  }
  public String getWareDescValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WareDescValue));
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

