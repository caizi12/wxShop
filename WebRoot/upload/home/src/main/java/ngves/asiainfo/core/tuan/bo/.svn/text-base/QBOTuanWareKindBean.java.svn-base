package ngves.asiainfo.core.tuan.bo;

import ngves.asiainfo.core.tuan.ivalues.IQBOTuanWareKindValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class QBOTuanWareKindBean extends DataContainer implements DataContainerInterface,IQBOTuanWareKindValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 3745730042500857663L;



private static String  m_boName = "ngves.asiainfo.core.tuan.bo.QBOTuanWareKind";



  public final static  String S_KindName = "KIND_NAME";
  public final static  String S_WareKindId = "WARE_KIND_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBOTuanWareKindBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
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

