package ngves.asiainfo.core.common.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.common.ivalues.*;

public class SaleObjInterestInfoBean extends DataContainer implements DataContainerInterface,ISaleObjInterestInfoValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 985278268519465379L;



private static String  m_boName = "ngves.asiainfo.core.common.bo.SaleObjInterestInfo";



  public final static  String S_SaleId = "SALE_ID";
  public final static  String S_ObjInterestId = "OBJ_INTEREST_ID";
  public final static  String S_InterestId = "INTEREST_ID";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_BakCol1 = "BAK_COL1";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public SaleObjInterestInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initSaleId(long value){
     this.initProperty(S_SaleId,new Long(value));
  }
  public  void setSaleId(long value){
     this.set(S_SaleId,new Long(value));
  }
  public  void setSaleIdNull(){
     this.set(S_SaleId,null);
  }

  public long getSaleId(){
        return DataType.getAsLong(this.get(S_SaleId));
  
  }
  public long getSaleIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SaleId));
      }

  public void initObjInterestId(long value){
     this.initProperty(S_ObjInterestId,new Long(value));
  }
  public  void setObjInterestId(long value){
     this.set(S_ObjInterestId,new Long(value));
  }
  public  void setObjInterestIdNull(){
     this.set(S_ObjInterestId,null);
  }

  public long getObjInterestId(){
        return DataType.getAsLong(this.get(S_ObjInterestId));
  
  }
  public long getObjInterestIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ObjInterestId));
      }

  public void initInterestId(String value){
     this.initProperty(S_InterestId,value);
  }
  public  void setInterestId(String value){
     this.set(S_InterestId,value);
  }
  public  void setInterestIdNull(){
     this.set(S_InterestId,null);
  }

  public String getInterestId(){
       return DataType.getAsString(this.get(S_InterestId));
  
  }
  public String getInterestIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_InterestId));
      }

  public void initBakCol2(String value){
     this.initProperty(S_BakCol2,value);
  }
  public  void setBakCol2(String value){
     this.set(S_BakCol2,value);
  }
  public  void setBakCol2Null(){
     this.set(S_BakCol2,null);
  }

  public String getBakCol2(){
       return DataType.getAsString(this.get(S_BakCol2));
  
  }
  public String getBakCol2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_BakCol2));
      }

  public void initBakCol1(long value){
     this.initProperty(S_BakCol1,new Long(value));
  }
  public  void setBakCol1(long value){
     this.set(S_BakCol1,new Long(value));
  }
  public  void setBakCol1Null(){
     this.set(S_BakCol1,null);
  }

  public long getBakCol1(){
        return DataType.getAsLong(this.get(S_BakCol1));
  
  }
  public long getBakCol1InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BakCol1));
      }


 
 }

