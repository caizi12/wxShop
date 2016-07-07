package ngves.asiainfo.core.rushbuy.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.rushbuy.ivalues.*;

public class WareKindBrandInfoBean extends DataContainer implements DataContainerInterface,IWareKindBrandInfoValue{

    private static final long serialVersionUID = 7482072764492318793L;



private static String  m_boName = "ngves.asiainfo.core.rushbuy.bo.WareKindBrandInfo";



  public final static  String S_WareBrandId = "WARE_BRAND_ID";
  public final static  String S_WareBrandName = "WARE_BRAND_NAME";
  public final static  String S_WareId = "WARE_ID";
  public final static  String S_WareKindId = "WARE_KIND_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public WareKindBrandInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
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

  public void initWareKindId(long value){
     this.initProperty(S_WareKindId,new Long(value));
  }
  public  void setWareKindId(long value){
     this.set(S_WareKindId,new Long(value));
  }
  public  void setWareKindIdNull(){
     this.set(S_WareKindId,null);
  }

  public long getWareKindId(){
        return DataType.getAsLong(this.get(S_WareKindId));
  
  }
  public long getWareKindIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_WareKindId));
      }


 
 }

