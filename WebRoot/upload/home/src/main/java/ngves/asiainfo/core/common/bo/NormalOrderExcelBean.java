package ngves.asiainfo.core.common.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.common.ivalues.*;

@SuppressWarnings("serial")
public class NormalOrderExcelBean extends DataContainer implements DataContainerInterface,INormalOrderExcelValue{

  private static String  m_boName = "ngves.asiainfo.core.common.bo.NormalOrderExcel";



  public final static  String S_NorOrderExcelId = "NOR_ORDER_EXCEL_ID";
  public final static  String S_NorColumnGet = "NOR_COLUMN_GET";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_FontColor = "FONT_COLOR";
  public final static  String S_NorMapGet = "NOR_MAP_GET";
  public final static  String S_ColumnDesc = "COLUMN_DESC";
  public final static  String S_NorListGet = "NOR_LIST_GET";
  public final static  String S_AdaptType = "ADAPT_TYPE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public NormalOrderExcelBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("error");
 }


  public void initNorOrderExcelId(long value){
     this.initProperty(S_NorOrderExcelId,new Long(value));
  }
  public  void setNorOrderExcelId(long value){
     this.set(S_NorOrderExcelId,new Long(value));
  }
  public  void setNorOrderExcelIdNull(){
     this.set(S_NorOrderExcelId,null);
  }

  public long getNorOrderExcelId(){
        return DataType.getAsLong(this.get(S_NorOrderExcelId));
  
  }
  public long getNorOrderExcelIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_NorOrderExcelId));
      }

  public void initNorColumnGet(String value){
     this.initProperty(S_NorColumnGet,value);
  }
  public  void setNorColumnGet(String value){
     this.set(S_NorColumnGet,value);
  }
  public  void setNorColumnGetNull(){
     this.set(S_NorColumnGet,null);
  }

  public String getNorColumnGet(){
       return DataType.getAsString(this.get(S_NorColumnGet));
  
  }
  public String getNorColumnGetInitialValue(){
        return DataType.getAsString(this.getOldObj(S_NorColumnGet));
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

  public void initFontColor(long value){
     this.initProperty(S_FontColor,new Long(value));
  }
  public  void setFontColor(long value){
     this.set(S_FontColor,new Long(value));
  }
  public  void setFontColorNull(){
     this.set(S_FontColor,null);
  }

  public long getFontColor(){
        return DataType.getAsLong(this.get(S_FontColor));
  
  }
  public long getFontColorInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_FontColor));
      }

  public void initNorMapGet(String value){
     this.initProperty(S_NorMapGet,value);
  }
  public  void setNorMapGet(String value){
     this.set(S_NorMapGet,value);
  }
  public  void setNorMapGetNull(){
     this.set(S_NorMapGet,null);
  }

  public String getNorMapGet(){
       return DataType.getAsString(this.get(S_NorMapGet));
  
  }
  public String getNorMapGetInitialValue(){
        return DataType.getAsString(this.getOldObj(S_NorMapGet));
      }

  public void initColumnDesc(String value){
     this.initProperty(S_ColumnDesc,value);
  }
  public  void setColumnDesc(String value){
     this.set(S_ColumnDesc,value);
  }
  public  void setColumnDescNull(){
     this.set(S_ColumnDesc,null);
  }

  public String getColumnDesc(){
       return DataType.getAsString(this.get(S_ColumnDesc));
  
  }
  public String getColumnDescInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ColumnDesc));
      }

  public void initNorListGet(String value){
     this.initProperty(S_NorListGet,value);
  }
  public  void setNorListGet(String value){
     this.set(S_NorListGet,value);
  }
  public  void setNorListGetNull(){
     this.set(S_NorListGet,null);
  }

  public String getNorListGet(){
       return DataType.getAsString(this.get(S_NorListGet));
  
  }
  public String getNorListGetInitialValue(){
        return DataType.getAsString(this.getOldObj(S_NorListGet));
      }

  public void initAdaptType(String value){
     this.initProperty(S_AdaptType,value);
  }
  public  void setAdaptType(String value){
     this.set(S_AdaptType,value);
  }
  public  void setAdaptTypeNull(){
     this.set(S_AdaptType,null);
  }

  public String getAdaptType(){
       return DataType.getAsString(this.get(S_AdaptType));
  
  }
  public String getAdaptTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AdaptType));
      }


 
 }

