package ngves.asiainfo.core.sms.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.sms.ivalues.*;

public class SmsTaskBean extends DataContainer implements DataContainerInterface,ISmsTaskValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = -4790174239737457155L;



private static String  m_boName = "ngves.asiainfo.core.sms.bo.SmsTask";



  public final static  String S_NosendCount = "NOSEND_COUNT";
  public final static  String S_DupliFilePath = "DUPLI_FILE_PATH";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_FailCount = "FAIL_COUNT";
  public final static  String S_DupliCount = "DUPLI_COUNT";
  public final static  String S_ErrorCount = "ERROR_COUNT";
  public final static  String S_FailFilePath = "FAIL_FILE_PATH";
  public final static  String S_SuccCount = "SUCC_COUNT";
  public final static  String S_ErrorFilePath = "ERROR_FILE_PATH";
  public final static  String S_Status = "STATUS";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_NoCount = "NO_COUNT";
  public final static  String S_Opera = "OPERA";
  public final static  String S_IsQuartz = "IS_QUARTZ";
  public final static  String S_SmsId = "SMS_ID";
  public final static  String S_ProvCode = "PROV_CODE";
  public final static  String S_Id = "ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public SmsTaskBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initNosendCount(long value){
     this.initProperty(S_NosendCount,new Long(value));
  }
  public  void setNosendCount(long value){
     this.set(S_NosendCount,new Long(value));
  }
  public  void setNosendCountNull(){
     this.set(S_NosendCount,null);
  }

  public long getNosendCount(){
        return DataType.getAsLong(this.get(S_NosendCount));
  
  }
  public long getNosendCountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_NosendCount));
      }

  public void initDupliFilePath(String value){
     this.initProperty(S_DupliFilePath,value);
  }
  public  void setDupliFilePath(String value){
     this.set(S_DupliFilePath,value);
  }
  public  void setDupliFilePathNull(){
     this.set(S_DupliFilePath,null);
  }

  public String getDupliFilePath(){
       return DataType.getAsString(this.get(S_DupliFilePath));
  
  }
  public String getDupliFilePathInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DupliFilePath));
      }

  public void initBakCol1(String value){
     this.initProperty(S_BakCol1,value);
  }
  public  void setBakCol1(String value){
     this.set(S_BakCol1,value);
  }
  public  void setBakCol1Null(){
     this.set(S_BakCol1,null);
  }

  public String getBakCol1(){
       return DataType.getAsString(this.get(S_BakCol1));
  
  }
  public String getBakCol1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_BakCol1));
      }

  public void initFailCount(long value){
     this.initProperty(S_FailCount,new Long(value));
  }
  public  void setFailCount(long value){
     this.set(S_FailCount,new Long(value));
  }
  public  void setFailCountNull(){
     this.set(S_FailCount,null);
  }

  public long getFailCount(){
        return DataType.getAsLong(this.get(S_FailCount));
  
  }
  public long getFailCountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_FailCount));
      }

  public void initDupliCount(long value){
     this.initProperty(S_DupliCount,new Long(value));
  }
  public  void setDupliCount(long value){
     this.set(S_DupliCount,new Long(value));
  }
  public  void setDupliCountNull(){
     this.set(S_DupliCount,null);
  }

  public long getDupliCount(){
        return DataType.getAsLong(this.get(S_DupliCount));
  
  }
  public long getDupliCountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_DupliCount));
      }

  public void initErrorCount(long value){
     this.initProperty(S_ErrorCount,new Long(value));
  }
  public  void setErrorCount(long value){
     this.set(S_ErrorCount,new Long(value));
  }
  public  void setErrorCountNull(){
     this.set(S_ErrorCount,null);
  }

  public long getErrorCount(){
        return DataType.getAsLong(this.get(S_ErrorCount));
  
  }
  public long getErrorCountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ErrorCount));
      }

  public void initFailFilePath(String value){
     this.initProperty(S_FailFilePath,value);
  }
  public  void setFailFilePath(String value){
     this.set(S_FailFilePath,value);
  }
  public  void setFailFilePathNull(){
     this.set(S_FailFilePath,null);
  }

  public String getFailFilePath(){
       return DataType.getAsString(this.get(S_FailFilePath));
  
  }
  public String getFailFilePathInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FailFilePath));
      }

  public void initSuccCount(long value){
     this.initProperty(S_SuccCount,new Long(value));
  }
  public  void setSuccCount(long value){
     this.set(S_SuccCount,new Long(value));
  }
  public  void setSuccCountNull(){
     this.set(S_SuccCount,null);
  }

  public long getSuccCount(){
        return DataType.getAsLong(this.get(S_SuccCount));
  
  }
  public long getSuccCountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SuccCount));
      }

  public void initErrorFilePath(String value){
     this.initProperty(S_ErrorFilePath,value);
  }
  public  void setErrorFilePath(String value){
     this.set(S_ErrorFilePath,value);
  }
  public  void setErrorFilePathNull(){
     this.set(S_ErrorFilePath,null);
  }

  public String getErrorFilePath(){
       return DataType.getAsString(this.get(S_ErrorFilePath));
  
  }
  public String getErrorFilePathInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ErrorFilePath));
      }

  public void initStatus(String value){
     this.initProperty(S_Status,value);
  }
  public  void setStatus(String value){
     this.set(S_Status,value);
  }
  public  void setStatusNull(){
     this.set(S_Status,null);
  }

  public String getStatus(){
       return DataType.getAsString(this.get(S_Status));
  
  }
  public String getStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Status));
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

  public void initBakCol3(String value){
     this.initProperty(S_BakCol3,value);
  }
  public  void setBakCol3(String value){
     this.set(S_BakCol3,value);
  }
  public  void setBakCol3Null(){
     this.set(S_BakCol3,null);
  }

  public String getBakCol3(){
       return DataType.getAsString(this.get(S_BakCol3));
  
  }
  public String getBakCol3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_BakCol3));
      }

  public void initNoCount(long value){
     this.initProperty(S_NoCount,new Long(value));
  }
  public  void setNoCount(long value){
     this.set(S_NoCount,new Long(value));
  }
  public  void setNoCountNull(){
     this.set(S_NoCount,null);
  }

  public long getNoCount(){
        return DataType.getAsLong(this.get(S_NoCount));
  
  }
  public long getNoCountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_NoCount));
      }

  public void initOpera(String value){
     this.initProperty(S_Opera,value);
  }
  public  void setOpera(String value){
     this.set(S_Opera,value);
  }
  public  void setOperaNull(){
     this.set(S_Opera,null);
  }

  public String getOpera(){
       return DataType.getAsString(this.get(S_Opera));
  
  }
  public String getOperaInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Opera));
      }

  public void initIsQuartz(String value){
     this.initProperty(S_IsQuartz,value);
  }
  public  void setIsQuartz(String value){
     this.set(S_IsQuartz,value);
  }
  public  void setIsQuartzNull(){
     this.set(S_IsQuartz,null);
  }

  public String getIsQuartz(){
       return DataType.getAsString(this.get(S_IsQuartz));
  
  }
  public String getIsQuartzInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsQuartz));
      }

  public void initSmsId(long value){
     this.initProperty(S_SmsId,new Long(value));
  }
  public  void setSmsId(long value){
     this.set(S_SmsId,new Long(value));
  }
  public  void setSmsIdNull(){
     this.set(S_SmsId,null);
  }

  public long getSmsId(){
        return DataType.getAsLong(this.get(S_SmsId));
  
  }
  public long getSmsIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SmsId));
      }

  public void initProvCode(String value){
     this.initProperty(S_ProvCode,value);
  }
  public  void setProvCode(String value){
     this.set(S_ProvCode,value);
  }
  public  void setProvCodeNull(){
     this.set(S_ProvCode,null);
  }

  public String getProvCode(){
       return DataType.getAsString(this.get(S_ProvCode));
  
  }
  public String getProvCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProvCode));
      }

  public void initId(long value){
     this.initProperty(S_Id,new Long(value));
  }
  public  void setId(long value){
     this.set(S_Id,new Long(value));
  }
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public long getId(){
        return DataType.getAsLong(this.get(S_Id));
  
  }
  public long getIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Id));
      }


 
 }

