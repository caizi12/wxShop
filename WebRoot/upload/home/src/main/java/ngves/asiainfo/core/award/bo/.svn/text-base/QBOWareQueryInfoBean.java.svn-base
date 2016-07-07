package ngves.asiainfo.core.award.bo;


import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.award.ivalues.*;

public class QBOWareQueryInfoBean extends DataContainer implements DataContainerInterface,IQBOWareQueryInfoValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.award.bo.QBOWareQueryInfo";



  public final static  String S_WareName = "WARE_NAME";
  public final static  String S_WareStatus = "WARE_STATUS";
  public final static  String S_WareId = "WARE_ID";
  public final static  String S_WareCode = "WARE_CODE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBOWareQueryInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("[错误]根据主键查询出现一条以上记录");
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

