package ngves.asiainfo.core.order.bo;

import ngves.asiainfo.core.order.ivalues.IQBOWareHouseDeliverFeeValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class QBOWareHouseDeliverFeeBean extends DataContainer implements DataContainerInterface,IQBOWareHouseDeliverFeeValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.order.bo.QBOWareHouseDeliverFee";



  public final static  String S_IntegralValue = "INTEGRAL_VALUE";
  public final static  String S_WarehouseCode = "WAREHOUSE_CODE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBOWareHouseDeliverFeeBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initIntegralValue(long value){
     this.initProperty(S_IntegralValue,new Long(value));
  }
  public  void setIntegralValue(long value){
     this.set(S_IntegralValue,new Long(value));
  }
  public  void setIntegralValueNull(){
     this.set(S_IntegralValue,null);
  }

  public long getIntegralValue(){
        return DataType.getAsLong(this.get(S_IntegralValue));
  
  }
  public long getIntegralValueInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_IntegralValue));
      }

  public void initWarehouseCode(String value){
     this.initProperty(S_WarehouseCode,value);
  }
  public  void setWarehouseCode(String value){
     this.set(S_WarehouseCode,value);
  }
  public  void setWarehouseCodeNull(){
     this.set(S_WarehouseCode,null);
  }

  public String getWarehouseCode(){
       return DataType.getAsString(this.get(S_WarehouseCode));
  
  }
  public String getWarehouseCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WarehouseCode));
      }


 
 }

