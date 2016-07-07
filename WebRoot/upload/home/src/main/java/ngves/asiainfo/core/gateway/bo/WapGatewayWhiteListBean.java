package ngves.asiainfo.core.gateway.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.gateway.ivalues.*;

public class WapGatewayWhiteListBean extends DataContainer implements DataContainerInterface,IWapGatewayWhiteListValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = -8089951273128866422L;



private static String  m_boName = "ngves.asiainfo.core.gateway.bo.WapGatewayWhiteList";



  public final static  String S_GatewayName = "GATEWAY_NAME";
  public final static  String S_EquipmentManufacturer = "EQUIPMENT_MANUFACTURER";
  public final static  String S_ProvinceCode = "PROVINCE_CODE";
  public final static  String S_Ip = "IP";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public WapGatewayWhiteListBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initGatewayName(String value){
     this.initProperty(S_GatewayName,value);
  }
  public  void setGatewayName(String value){
     this.set(S_GatewayName,value);
  }
  public  void setGatewayNameNull(){
     this.set(S_GatewayName,null);
  }

  public String getGatewayName(){
       return DataType.getAsString(this.get(S_GatewayName));
  
  }
  public String getGatewayNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_GatewayName));
      }

  public void initEquipmentManufacturer(String value){
     this.initProperty(S_EquipmentManufacturer,value);
  }
  public  void setEquipmentManufacturer(String value){
     this.set(S_EquipmentManufacturer,value);
  }
  public  void setEquipmentManufacturerNull(){
     this.set(S_EquipmentManufacturer,null);
  }

  public String getEquipmentManufacturer(){
       return DataType.getAsString(this.get(S_EquipmentManufacturer));
  
  }
  public String getEquipmentManufacturerInitialValue(){
        return DataType.getAsString(this.getOldObj(S_EquipmentManufacturer));
      }

  public void initProvinceCode(String value){
     this.initProperty(S_ProvinceCode,value);
  }
  public  void setProvinceCode(String value){
     this.set(S_ProvinceCode,value);
  }
  public  void setProvinceCodeNull(){
     this.set(S_ProvinceCode,null);
  }

  public String getProvinceCode(){
       return DataType.getAsString(this.get(S_ProvinceCode));
  
  }
  public String getProvinceCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProvinceCode));
      }

  public void initIp(String value){
     this.initProperty(S_Ip,value);
  }
  public  void setIp(String value){
     this.set(S_Ip,value);
  }
  public  void setIpNull(){
     this.set(S_Ip,null);
  }

  public String getIp(){
       return DataType.getAsString(this.get(S_Ip));
  
  }
  public String getIpInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ip));
      }


 
 }

