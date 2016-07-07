package ngves.asiainfo.core.floor.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.floor.ivalues.*;

public class FloorTabsRltBean extends DataContainer implements DataContainerInterface,IFloorTabsRltValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.floor.bo.FloorTabsRlt";



  public final static  String S_Tempattr = "TempAttr";
  public final static  String S_BeginTime = "BEGIN_TIME";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_FloorTabsName = "FLOOR_TABS_NAME";
  public final static  String S_FloorId = "FLOOR_ID";
  public final static  String S_FloorTabsRltId = "FLOOR_TABS_RLT_ID";
  public final static  String S_EndTime = "END_TIME";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_TabsId = "TABS_ID";
  public final static  String S_ModifyDate = "MODIFY_DATE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public FloorTabsRltBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("");
 }


  public void initTempattr(String value){
     this.initProperty(S_Tempattr,value);
  }
  public  void setTempattr(String value){
     this.set(S_Tempattr,value);
  }
  public  void setTempattrNull(){
     this.set(S_Tempattr,null);
  }

  public String getTempattr(){
       return DataType.getAsString(this.get(S_Tempattr));
  
  }
  public String getTempattrInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Tempattr));
      }

  public void initBeginTime(Timestamp value){
     this.initProperty(S_BeginTime,value);
  }
  public  void setBeginTime(Timestamp value){
     this.set(S_BeginTime,value);
  }
  public  void setBeginTimeNull(){
     this.set(S_BeginTime,null);
  }

  public Timestamp getBeginTime(){
        return DataType.getAsDateTime(this.get(S_BeginTime));
  
  }
  public Timestamp getBeginTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_BeginTime));
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

  public void initFloorTabsName(String value){
     this.initProperty(S_FloorTabsName,value);
  }
  public  void setFloorTabsName(String value){
     this.set(S_FloorTabsName,value);
  }
  public  void setFloorTabsNameNull(){
     this.set(S_FloorTabsName,null);
  }

  public String getFloorTabsName(){
       return DataType.getAsString(this.get(S_FloorTabsName));
  
  }
  public String getFloorTabsNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FloorTabsName));
      }

  public void initFloorId(long value){
     this.initProperty(S_FloorId,new Long(value));
  }
  public  void setFloorId(long value){
     this.set(S_FloorId,new Long(value));
  }
  public  void setFloorIdNull(){
     this.set(S_FloorId,null);
  }

  public long getFloorId(){
        return DataType.getAsLong(this.get(S_FloorId));
  
  }
  public long getFloorIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_FloorId));
      }

  public void initFloorTabsRltId(long value){
     this.initProperty(S_FloorTabsRltId,new Long(value));
  }
  public  void setFloorTabsRltId(long value){
     this.set(S_FloorTabsRltId,new Long(value));
  }
  public  void setFloorTabsRltIdNull(){
     this.set(S_FloorTabsRltId,null);
  }

  public long getFloorTabsRltId(){
        return DataType.getAsLong(this.get(S_FloorTabsRltId));
  
  }
  public long getFloorTabsRltIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_FloorTabsRltId));
      }

  public void initEndTime(Timestamp value){
     this.initProperty(S_EndTime,value);
  }
  public  void setEndTime(Timestamp value){
     this.set(S_EndTime,value);
  }
  public  void setEndTimeNull(){
     this.set(S_EndTime,null);
  }

  public Timestamp getEndTime(){
        return DataType.getAsDateTime(this.get(S_EndTime));
  
  }
  public Timestamp getEndTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_EndTime));
      }

  public void initCreateDate(Timestamp value){
     this.initProperty(S_CreateDate,value);
  }
  public  void setCreateDate(Timestamp value){
     this.set(S_CreateDate,value);
  }
  public  void setCreateDateNull(){
     this.set(S_CreateDate,null);
  }

  public Timestamp getCreateDate(){
        return DataType.getAsDateTime(this.get(S_CreateDate));
  
  }
  public Timestamp getCreateDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CreateDate));
      }

  public void initTabsId(long value){
     this.initProperty(S_TabsId,new Long(value));
  }
  public  void setTabsId(long value){
     this.set(S_TabsId,new Long(value));
  }
  public  void setTabsIdNull(){
     this.set(S_TabsId,null);
  }

  public long getTabsId(){
        return DataType.getAsLong(this.get(S_TabsId));
  
  }
  public long getTabsIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TabsId));
      }

  public void initModifyDate(Timestamp value){
     this.initProperty(S_ModifyDate,value);
  }
  public  void setModifyDate(Timestamp value){
     this.set(S_ModifyDate,value);
  }
  public  void setModifyDateNull(){
     this.set(S_ModifyDate,null);
  }

  public Timestamp getModifyDate(){
        return DataType.getAsDateTime(this.get(S_ModifyDate));
  
  }
  public Timestamp getModifyDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ModifyDate));
      }


 
 }

