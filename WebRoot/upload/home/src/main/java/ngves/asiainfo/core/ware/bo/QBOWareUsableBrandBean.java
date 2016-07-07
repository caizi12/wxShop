package ngves.asiainfo.core.ware.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.ware.ivalues.*;

public class QBOWareUsableBrandBean extends DataContainer implements DataContainerInterface,IQBOWareUsableBrandValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1196222364789208094L;



private static String  m_boName = "ngves.asiainfo.core.ware.bo.QBOWareUsableBrand";



  public final static  String S_WareBrandName = "WARE_BRAND_NAME";
  public final static  String S_ValidDate = "VALID_DATE";
  public final static  String S_WareBrandId = "WARE_BRAND_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBOWareUsableBrandBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initWareBrandName(String value){
     this.initProperty(S_WareBrandName,value);
  }
  public  void setWareBrandName(String value){
     this.set(S_WareBrandName,value);
  }
  public  void setWareBrandNameNull(){
     this.set(S_WareBrandName,null);
  }

  public String getWareBrandName(){
       return DataType.getAsString(this.get(S_WareBrandName));
  
  }
  public String getWareBrandNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WareBrandName));
      }

  public void initValidDate(Timestamp value){
     this.initProperty(S_ValidDate,value);
  }
  public  void setValidDate(Timestamp value){
     this.set(S_ValidDate,value);
  }
  public  void setValidDateNull(){
     this.set(S_ValidDate,null);
  }

  public Timestamp getValidDate(){
        return DataType.getAsDateTime(this.get(S_ValidDate));
  
  }
  public Timestamp getValidDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ValidDate));
      }

  public void initWareBrandId(long value){
     this.initProperty(S_WareBrandId,new Long(value));
  }
  public  void setWareBrandId(long value){
     this.set(S_WareBrandId,new Long(value));
  }
  public  void setWareBrandIdNull(){
     this.set(S_WareBrandId,null);
  }

  public long getWareBrandId(){
        return DataType.getAsLong(this.get(S_WareBrandId));
  
  }
  public long getWareBrandIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_WareBrandId));
      }


 
 }

