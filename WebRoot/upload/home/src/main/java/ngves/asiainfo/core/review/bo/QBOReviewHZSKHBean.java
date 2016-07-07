package ngves.asiainfo.core.review.bo;

import ngves.asiainfo.core.review.ivalues.IQBOReviewHZSKHValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class QBOReviewHZSKHBean extends DataContainer implements DataContainerInterface,IQBOReviewHZSKHValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 6242740528057985708L;



private static String  m_boName = "ngves.asiainfo.core.review.bo.QBOReviewHZSKH";



  public final static  String S_State = "STATE";
  public final static  String S_Name = "NAME";
  public final static  String S_ExamType = "EXAM_TYPE";
  public final static  String S_ValidDate = "VALID_DATE";
  public final static  String S_UpdateDate = "UPDATE_DATE";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Code = "CODE";
  public QBOReviewHZSKHBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initState(String value){
     this.initProperty(S_State,value);
  }
  public  void setState(String value){
     this.set(S_State,value);
  }
  public  void setStateNull(){
     this.set(S_State,null);
  }

  public String getState(){
       return DataType.getAsString(this.get(S_State));
  
  }
  public String getStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_State));
      }

  public void initName(String value){
     this.initProperty(S_Name,value);
  }
  public  void setName(String value){
     this.set(S_Name,value);
  }
  public  void setNameNull(){
     this.set(S_Name,null);
  }

  public String getName(){
       return DataType.getAsString(this.get(S_Name));
  
  }
  public String getNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Name));
      }

  public void initExamType(String value){
     this.initProperty(S_ExamType,value);
  }
  public  void setExamType(String value){
     this.set(S_ExamType,value);
  }
  public  void setExamTypeNull(){
     this.set(S_ExamType,null);
  }

  public String getExamType(){
       return DataType.getAsString(this.get(S_ExamType));
  
  }
  public String getExamTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExamType));
      }

  public void initValidDate(String value){
     this.initProperty(S_ValidDate,value);
  }
  public  void setValidDate(String value){
     this.set(S_ValidDate,value);
  }
  public  void setValidDateNull(){
     this.set(S_ValidDate,null);
  }

  public String getValidDate(){
       return DataType.getAsString(this.get(S_ValidDate));
  
  }
  public String getValidDateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ValidDate));
      }

  public void initUpdateDate(String value){
     this.initProperty(S_UpdateDate,value);
  }
  public  void setUpdateDate(String value){
     this.set(S_UpdateDate,value);
  }
  public  void setUpdateDateNull(){
     this.set(S_UpdateDate,null);
  }

  public String getUpdateDate(){
       return DataType.getAsString(this.get(S_UpdateDate));
  
  }
  public String getUpdateDateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_UpdateDate));
      }

  public void initCreateDate(String value){
     this.initProperty(S_CreateDate,value);
  }
  public  void setCreateDate(String value){
     this.set(S_CreateDate,value);
  }
  public  void setCreateDateNull(){
     this.set(S_CreateDate,null);
  }

  public String getCreateDate(){
       return DataType.getAsString(this.get(S_CreateDate));
  
  }
  public String getCreateDateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CreateDate));
      }

  public void initCode(String value){
     this.initProperty(S_Code,value);
  }
  public  void setCode(String value){
     this.set(S_Code,value);
  }
  public  void setCodeNull(){
     this.set(S_Code,null);
  }

  public String getCode(){
       return DataType.getAsString(this.get(S_Code));
  
  }
  public String getCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Code));
      }


 
 }

