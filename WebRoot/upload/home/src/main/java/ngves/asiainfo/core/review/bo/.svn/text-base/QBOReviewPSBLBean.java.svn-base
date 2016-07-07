package ngves.asiainfo.core.review.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.review.ivalues.*;

@SuppressWarnings("serial")
public class QBOReviewPSBLBean extends DataContainer implements DataContainerInterface,IQBOReviewPSBLValue{

  private static String  m_boName = "ngves.asiainfo.core.review.bo.QBOReviewPSBL";



  public final static  String S_WarehouseState = "WAREHOUSE_STATE";
  public final static  String S_PartnerName = "PARTNER_NAME";
  public final static  String S_WarehouseName = "WAREHOUSE_NAME";
  public final static  String S_AllPercent = "ALL_PERCENT";
  public final static  String S_ProvinceName = "PROVINCE_NAME";
  public final static  String S_CurStatus = "CUR_STATUS";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBOReviewPSBLBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initWarehouseState(String value){
     this.initProperty(S_WarehouseState,value);
  }
  public  void setWarehouseState(String value){
     this.set(S_WarehouseState,value);
  }
  public  void setWarehouseStateNull(){
     this.set(S_WarehouseState,null);
  }

  public String getWarehouseState(){
       return DataType.getAsString(this.get(S_WarehouseState));
  
  }
  public String getWarehouseStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WarehouseState));
      }

  public void initPartnerName(String value){
     this.initProperty(S_PartnerName,value);
  }
  public  void setPartnerName(String value){
     this.set(S_PartnerName,value);
  }
  public  void setPartnerNameNull(){
     this.set(S_PartnerName,null);
  }

  public String getPartnerName(){
       return DataType.getAsString(this.get(S_PartnerName));
  
  }
  public String getPartnerNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PartnerName));
      }

  public void initWarehouseName(String value){
     this.initProperty(S_WarehouseName,value);
  }
  public  void setWarehouseName(String value){
     this.set(S_WarehouseName,value);
  }
  public  void setWarehouseNameNull(){
     this.set(S_WarehouseName,null);
  }

  public String getWarehouseName(){
       return DataType.getAsString(this.get(S_WarehouseName));
  
  }
  public String getWarehouseNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WarehouseName));
      }

  public void initAllPercent(String value){
     this.initProperty(S_AllPercent,value);
  }
  public  void setAllPercent(String value){
     this.set(S_AllPercent,value);
  }
  public  void setAllPercentNull(){
     this.set(S_AllPercent,null);
  }

  public String getAllPercent(){
       return DataType.getAsString(this.get(S_AllPercent));
  
  }
  public String getAllPercentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AllPercent));
      }

  public void initProvinceName(String value){
     this.initProperty(S_ProvinceName,value);
  }
  public  void setProvinceName(String value){
     this.set(S_ProvinceName,value);
  }
  public  void setProvinceNameNull(){
     this.set(S_ProvinceName,null);
  }

  public String getProvinceName(){
       return DataType.getAsString(this.get(S_ProvinceName));
  
  }
  public String getProvinceNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProvinceName));
      }

  public void initCurStatus(String value){
     this.initProperty(S_CurStatus,value);
  }
  public  void setCurStatus(String value){
     this.set(S_CurStatus,value);
  }
  public  void setCurStatusNull(){
     this.set(S_CurStatus,null);
  }

  public String getCurStatus(){
       return DataType.getAsString(this.get(S_CurStatus));
  
  }
  public String getCurStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CurStatus));
      }


 
 }

