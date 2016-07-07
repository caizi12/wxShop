package ngves.asiainfo.core.ware.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.ware.ivalues.*;

public class QBOWareIdFirstKindBean extends DataContainer implements DataContainerInterface,IQBOWareIdFirstKindValue{

  /**
     * 
     */
    private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.ware.bo.QBOWareIdFirstKind";



  public final static  String S_WareFirstKindId = "ware_first_kind_id";
  public final static  String S_WareId = "WARE_ID";
  public QBOWareIdFirstKindBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("");
 }


  public void initWareFirstKindId(long value){
     this.initProperty(S_WareFirstKindId,new Long(value));
  }
  public  void setWareFirstKindId(long value){
     this.set(S_WareFirstKindId,new Long(value));
  }
  public  void setWareFirstKindIdNull(){
     this.set(S_WareFirstKindId,null);
  }

  public long getWareFirstKindId(){
        return DataType.getAsLong(this.get(S_WareFirstKindId));
  
  }
  public long getWareFirstKindIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_WareFirstKindId));
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

