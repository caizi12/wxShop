package ngves.asiainfo.core.review.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.review.ivalues.*;

public class QBOReviewWLJFBDCKBean extends DataContainer implements DataContainerInterface,IQBOReviewWLJFBDCKValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = -4696017885713154843L;



private static String  m_boName = "ngves.asiainfo.core.review.bo.QBOReviewWLJFBDCK";



  public final static  String S_WarehouseType = "WAREHOUSE_TYPE";
  public final static  String S_WarehouseName = "WAREHOUSE_NAME";
  public final static  String S_RuleName = "RULE_NAME";
  public final static  String S_WarehouseCode = "WAREHOUSE_CODE";
  public final static  String S_PackageFee = "PACKAGE_FEE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBOReviewWLJFBDCKBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initWarehouseType(String value){
     this.initProperty(S_WarehouseType,value);
  }
  public  void setWarehouseType(String value){
     this.set(S_WarehouseType,value);
  }
  public  void setWarehouseTypeNull(){
     this.set(S_WarehouseType,null);
  }

  public String getWarehouseType(){
       return DataType.getAsString(this.get(S_WarehouseType));
  
  }
  public String getWarehouseTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WarehouseType));
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

  public void initRuleName(String value){
     this.initProperty(S_RuleName,value);
  }
  public  void setRuleName(String value){
     this.set(S_RuleName,value);
  }
  public  void setRuleNameNull(){
     this.set(S_RuleName,null);
  }

  public String getRuleName(){
       return DataType.getAsString(this.get(S_RuleName));
  
  }
  public String getRuleNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RuleName));
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

  public void initPackageFee(String value){
     this.initProperty(S_PackageFee,value);
  }
  public  void setPackageFee(String value){
     this.set(S_PackageFee,value);
  }
  public  void setPackageFeeNull(){
     this.set(S_PackageFee,null);
  }

  public String getPackageFee(){
        return DataType.getAsString(this.get(S_PackageFee));
  
  }
  public String getPackageFeeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PackageFee));
      }


 
 }

