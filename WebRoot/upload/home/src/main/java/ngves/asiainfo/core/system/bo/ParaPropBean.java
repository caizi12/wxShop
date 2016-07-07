package ngves.asiainfo.core.system.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.system.ivalues.IParaPropValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class ParaPropBean extends DataContainer implements DataContainerInterface,IParaPropValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 2863670302862560668L;



private static String  m_boName = "ngves.asiainfo.core.system.bo.ParaProp";



  public final static  String S_ParaKey = "PARA_KEY";
  public final static  String S_Id = "ID";
  public final static  String S_ParaCreateDate = "PARA_CREATE_DATE";
  public final static  String S_ParaValu = "PARA_VALU";
  public final static  String S_ParaDesc = "PARA_DESC";
  public final static  String S_ParaModifyDate = "PARA_MODIFY_DATE";
  public ParaPropBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("");
 }


  public void initParaKey(String value){
     this.initProperty(S_ParaKey,value);
  }
  public  void setParaKey(String value){
     this.set(S_ParaKey,value);
  }
  public  void setParaKeyNull(){
     this.set(S_ParaKey,null);
  }

  public String getParaKey(){
       return DataType.getAsString(this.get(S_ParaKey));
  
  }
  public String getParaKeyInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ParaKey));
      }

  public void initId(String value){
     this.initProperty(S_Id,value);
  }
  public  void setId(String value){
     this.set(S_Id,value);
  }
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public String getId(){
       return DataType.getAsString(this.get(S_Id));
  
  }
  public String getIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Id));
      }

  public void initParaCreateDate(Timestamp value){
     this.initProperty(S_ParaCreateDate,value);
  }
  public  void setParaCreateDate(Timestamp value){
     this.set(S_ParaCreateDate,value);
  }
  public  void setParaCreateDateNull(){
     this.set(S_ParaCreateDate,null);
  }

  public Timestamp getParaCreateDate(){
        return DataType.getAsDateTime(this.get(S_ParaCreateDate));
  
  }
  public Timestamp getParaCreateDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ParaCreateDate));
      }

  public void initParaValu(String value){
     this.initProperty(S_ParaValu,value);
  }
  public  void setParaValu(String value){
     this.set(S_ParaValu,value);
  }
  public  void setParaValuNull(){
     this.set(S_ParaValu,null);
  }

  public String getParaValu(){
       return DataType.getAsString(this.get(S_ParaValu));
  
  }
  public String getParaValuInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ParaValu));
      }

  public void initParaDesc(String value){
     this.initProperty(S_ParaDesc,value);
  }
  public  void setParaDesc(String value){
     this.set(S_ParaDesc,value);
  }
  public  void setParaDescNull(){
     this.set(S_ParaDesc,null);
  }

  public String getParaDesc(){
       return DataType.getAsString(this.get(S_ParaDesc));
  
  }
  public String getParaDescInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ParaDesc));
      }

  public void initParaModifyDate(Timestamp value){
     this.initProperty(S_ParaModifyDate,value);
  }
  public  void setParaModifyDate(Timestamp value){
     this.set(S_ParaModifyDate,value);
  }
  public  void setParaModifyDateNull(){
     this.set(S_ParaModifyDate,null);
  }

  public Timestamp getParaModifyDate(){
        return DataType.getAsDateTime(this.get(S_ParaModifyDate));
  
  }
  public Timestamp getParaModifyDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ParaModifyDate));
      }


 
 }

