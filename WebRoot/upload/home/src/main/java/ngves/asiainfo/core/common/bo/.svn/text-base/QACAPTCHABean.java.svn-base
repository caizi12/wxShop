package ngves.asiainfo.core.common.bo;

import ngves.asiainfo.core.common.ivalues.IQACAPTCHAValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class QACAPTCHABean extends DataContainer implements DataContainerInterface,IQACAPTCHAValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = -382615200464882474L;



private static String  m_boName = "ngves.asiainfo.core.common.bo.QACAPTCHA";



  public final static  String S_Answer = "ANSWER";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_Question = "QUESTION";
  public final static  String S_ValidFlag = "VALID_FLAG";
  public final static  String S_Id = "ID";
  public QACAPTCHABean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initAnswer(String value){
     this.initProperty(S_Answer,value);
  }
  public  void setAnswer(String value){
     this.set(S_Answer,value);
  }
  public  void setAnswerNull(){
     this.set(S_Answer,null);
  }

  public String getAnswer(){
       return DataType.getAsString(this.get(S_Answer));
  
  }
  public String getAnswerInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Answer));
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

  public void initQuestion(String value){
     this.initProperty(S_Question,value);
  }
  public  void setQuestion(String value){
     this.set(S_Question,value);
  }
  public  void setQuestionNull(){
     this.set(S_Question,null);
  }

  public String getQuestion(){
       return DataType.getAsString(this.get(S_Question));
  
  }
  public String getQuestionInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Question));
      }

  public void initValidFlag(String value){
     this.initProperty(S_ValidFlag,value);
  }
  public  void setValidFlag(String value){
     this.set(S_ValidFlag,value);
  }
  public  void setValidFlagNull(){
     this.set(S_ValidFlag,null);
  }

  public String getValidFlag(){
       return DataType.getAsString(this.get(S_ValidFlag));
  
  }
  public String getValidFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ValidFlag));
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

