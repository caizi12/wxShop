package ngves.asiainfo.core.common.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.common.ivalues.*;

@SuppressWarnings("serial")
public class NorExcelClauseBean extends DataContainer implements DataContainerInterface,INorExcelClauseValue{

  private static String  m_boName = "ngves.asiainfo.core.common.bo.NorExcelClause";



  public final static  String S_NorExcelClauseId = "NOR_EXCEL_CLAUSE_ID";
  public final static  String S_ClauseValue = "CLAUSE_VALUE";
  public final static  String S_SortId = "SORT_ID";
  public final static  String S_ExcelTaskId = "EXCEL_TASK_ID";
  public final static  String S_ClauseViewName = "CLAUSE_VIEW_NAME";
  public final static  String S_ClauseMethod = "CLAUSE_METHOD";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_ClauseTransformValue = "CLAUSE_TRANSFORM_VALUE";
  public final static  String S_ClauseName = "CLAUSE_NAME"; 

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public NorExcelClauseBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("setObjectType error");
 }


  public void initNorExcelClauseId(long value){
     this.initProperty(S_NorExcelClauseId,new Long(value));
  }
  public  void setNorExcelClauseId(long value){
     this.set(S_NorExcelClauseId,new Long(value));
  }
  public  void setNorExcelClauseIdNull(){
     this.set(S_NorExcelClauseId,null);
  }

  public long getNorExcelClauseId(){
        return DataType.getAsLong(this.get(S_NorExcelClauseId));
  
  }
  public long getNorExcelClauseIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_NorExcelClauseId));
      }

  public void initClauseValue(String value){
     this.initProperty(S_ClauseValue,value);
  }
  public  void setClauseValue(String value){
     this.set(S_ClauseValue,value);
  }
  public  void setClauseValueNull(){
     this.set(S_ClauseValue,null);
  }

  public String getClauseValue(){
       return DataType.getAsString(this.get(S_ClauseValue));
  
  }
  public String getClauseValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ClauseValue));
      }

  public void initSortId(long value){
     this.initProperty(S_SortId,new Long(value));
  }
  public  void setSortId(long value){
     this.set(S_SortId,new Long(value));
  }
  public  void setSortIdNull(){
     this.set(S_SortId,null);
  }

  public long getSortId(){
        return DataType.getAsLong(this.get(S_SortId));
  
  }
  public long getSortIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SortId));
      }

  public void initExcelTaskId(String value){
     this.initProperty(S_ExcelTaskId,value);
  }
  public  void setExcelTaskId(String value){
     this.set(S_ExcelTaskId,value);
  }
  public  void setExcelTaskIdNull(){
     this.set(S_ExcelTaskId,null);
  }

  public String getExcelTaskId(){
       return DataType.getAsString(this.get(S_ExcelTaskId));
  
  }
  public String getExcelTaskIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExcelTaskId));
      }

  public void initClauseViewName(String value){
     this.initProperty(S_ClauseViewName,value);
  }
  public  void setClauseViewName(String value){
     this.set(S_ClauseViewName,value);
  }
  public  void setClauseViewNameNull(){
     this.set(S_ClauseViewName,null);
  }

  public String getClauseViewName(){
       return DataType.getAsString(this.get(S_ClauseViewName));
  
  }
  public String getClauseViewNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ClauseViewName));
      }

  public void initClauseMethod(String value){
     this.initProperty(S_ClauseMethod,value);
  }
  public  void setClauseMethod(String value){
     this.set(S_ClauseMethod,value);
  }
  public  void setClauseMethodNull(){
     this.set(S_ClauseMethod,null);
  }

  public String getClauseMethod(){
       return DataType.getAsString(this.get(S_ClauseMethod));
  
  }
  public String getClauseMethodInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ClauseMethod));
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

  public void initClauseTransformValue(String value){
     this.initProperty(S_ClauseTransformValue,value);
  }
  public  void setClauseTransformValue(String value){
     this.set(S_ClauseTransformValue,value);
  }
  public  void setClauseTransformValueNull(){
     this.set(S_ClauseTransformValue,null);
  }

  public String getClauseTransformValue(){
       return DataType.getAsString(this.get(S_ClauseTransformValue));
  
  }
  public String getClauseTransformValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ClauseTransformValue));
      }

  public void initClauseName(String value){
     this.initProperty(S_ClauseName,value);
  }
  public  void setClauseName(String value){
     this.set(S_ClauseName,value);
  }
  public  void setClauseNameNull(){
     this.set(S_ClauseName,null);
  }

  public String getClauseName(){
       return DataType.getAsString(this.get(S_ClauseName));
  
  }
  public String getClauseNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ClauseName));
      }


 
 }

