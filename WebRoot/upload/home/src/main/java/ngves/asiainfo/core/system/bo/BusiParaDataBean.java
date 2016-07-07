package ngves.asiainfo.core.system.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.system.ivalues.*;

public class BusiParaDataBean extends DataContainer implements DataContainerInterface,IBusiParaDataValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1609727879339967605L;



private static String  m_boName = "ngves.asiainfo.core.system.bo.BusiParaData";



  public final static  String S_ParaCode = "PARA_CODE";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_ParaId = "PARA_ID";
  public final static  String S_ParaName = "PARA_NAME";
  public final static  String S_ParaTypeId = "PARA_TYPE_ID";
  public final static  String S_ParaCodeType = "PARA_CODE_TYPE";
  public BusiParaDataBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initParaCode(String value){
     this.initProperty(S_ParaCode,value);
  }
  public  void setParaCode(String value){
     this.set(S_ParaCode,value);
  }
  public  void setParaCodeNull(){
     this.set(S_ParaCode,null);
  }

  public String getParaCode(){
       return DataType.getAsString(this.get(S_ParaCode));
  
  }
  public String getParaCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ParaCode));
      }

  public void initBakCol(String value){
     this.initProperty(S_BakCol,value);
  }
  public  void setBakCol(String value){
     this.set(S_BakCol,value);
  }
  public  void setBakColNull(){
     this.set(S_BakCol,null);
  }

  public String getBakCol(){
       return DataType.getAsString(this.get(S_BakCol));
  
  }
  public String getBakColInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BakCol));
      }

  public void initParaId(long value){
     this.initProperty(S_ParaId,new Long(value));
  }
  public  void setParaId(long value){
     this.set(S_ParaId,new Long(value));
  }
  public  void setParaIdNull(){
     this.set(S_ParaId,null);
  }

  public long getParaId(){
        return DataType.getAsLong(this.get(S_ParaId));
  
  }
  public long getParaIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ParaId));
      }

  public void initParaName(String value){
     this.initProperty(S_ParaName,value);
  }
  public  void setParaName(String value){
     this.set(S_ParaName,value);
  }
  public  void setParaNameNull(){
     this.set(S_ParaName,null);
  }

  public String getParaName(){
       return DataType.getAsString(this.get(S_ParaName));
  
  }
  public String getParaNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ParaName));
      }

  public void initParaTypeId(long value){
     this.initProperty(S_ParaTypeId,new Long(value));
  }
  public  void setParaTypeId(long value){
     this.set(S_ParaTypeId,new Long(value));
  }
  public  void setParaTypeIdNull(){
     this.set(S_ParaTypeId,null);
  }

  public long getParaTypeId(){
        return DataType.getAsLong(this.get(S_ParaTypeId));
  
  }
  public long getParaTypeIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ParaTypeId));
      }

  public void initParaCodeType(String value){
     this.initProperty(S_ParaCodeType,value);
  }
  public  void setParaCodeType(String value){
     this.set(S_ParaCodeType,value);
  }
  public  void setParaCodeTypeNull(){
     this.set(S_ParaCodeType,null);
  }

  public String getParaCodeType(){
       return DataType.getAsString(this.get(S_ParaCodeType));
  
  }
  public String getParaCodeTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ParaCodeType));
      }


 
 }

