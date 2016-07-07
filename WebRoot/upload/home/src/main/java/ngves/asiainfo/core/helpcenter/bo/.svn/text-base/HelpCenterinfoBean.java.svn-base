package ngves.asiainfo.core.helpcenter.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.helpcenter.ivalues.*;

public class HelpCenterinfoBean extends DataContainer implements DataContainerInterface,IHelpCenterinfoValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.helpcenter.bo.HelpCenterinfo";



  public final static  String S_UpdateTime = "UPDATE_TIME";
  public final static  String S_SortId = "SORT_ID";
  public final static  String S_MenuName = "MENU_NAME";
  public final static  String S_ParentHelpId = "PARENT_HELP_ID";
  public final static  String S_HelpCentreId = "HELP_CENTRE_ID";
  public final static  String S_IsShow = "IS_SHOW";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_HelpContent = "HELP_CONTENT";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public HelpCenterinfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此类对象不能装入容器");
 }


  public void initUpdateTime(Timestamp value){
     this.initProperty(S_UpdateTime,value);
  }
  public  void setUpdateTime(Timestamp value){
     this.set(S_UpdateTime,value);
  }
  public  void setUpdateTimeNull(){
     this.set(S_UpdateTime,null);
  }

  public Timestamp getUpdateTime(){
        return DataType.getAsDateTime(this.get(S_UpdateTime));
  
  }
  public Timestamp getUpdateTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_UpdateTime));
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

  public void initMenuName(String value){
     this.initProperty(S_MenuName,value);
  }
  public  void setMenuName(String value){
     this.set(S_MenuName,value);
  }
  public  void setMenuNameNull(){
     this.set(S_MenuName,null);
  }

  public String getMenuName(){
       return DataType.getAsString(this.get(S_MenuName));
  
  }
  public String getMenuNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MenuName));
      }

  public void initParentHelpId(long value){
     this.initProperty(S_ParentHelpId,new Long(value));
  }
  public  void setParentHelpId(long value){
     this.set(S_ParentHelpId,new Long(value));
  }
  public  void setParentHelpIdNull(){
     this.set(S_ParentHelpId,null);
  }

  public long getParentHelpId(){
        return DataType.getAsLong(this.get(S_ParentHelpId));
  
  }
  public long getParentHelpIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ParentHelpId));
      }

  public void initHelpCentreId(long value){
     this.initProperty(S_HelpCentreId,new Long(value));
  }
  public  void setHelpCentreId(long value){
     this.set(S_HelpCentreId,new Long(value));
  }
  public  void setHelpCentreIdNull(){
     this.set(S_HelpCentreId,null);
  }

  public long getHelpCentreId(){
        return DataType.getAsLong(this.get(S_HelpCentreId));
  
  }
  public long getHelpCentreIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_HelpCentreId));
      }

  public void initIsShow(String value){
     this.initProperty(S_IsShow,value);
  }
  public  void setIsShow(String value){
     this.set(S_IsShow,value);
  }
  public  void setIsShowNull(){
     this.set(S_IsShow,null);
  }

  public String getIsShow(){
       return DataType.getAsString(this.get(S_IsShow));
  
  }
  public String getIsShowInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsShow));
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

  public void initCreateTime(Timestamp value){
     this.initProperty(S_CreateTime,value);
  }
  public  void setCreateTime(Timestamp value){
     this.set(S_CreateTime,value);
  }
  public  void setCreateTimeNull(){
     this.set(S_CreateTime,null);
  }

  public Timestamp getCreateTime(){
        return DataType.getAsDateTime(this.get(S_CreateTime));
  
  }
  public Timestamp getCreateTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CreateTime));
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

  public void initHelpContent(String value){
     this.initProperty(S_HelpContent,value);
  }
  public  void setHelpContent(String value){
     this.set(S_HelpContent,value);
  }
  public  void setHelpContentNull(){
     this.set(S_HelpContent,null);
  }

  public String getHelpContent(){
       return DataType.getAsString(this.get(S_HelpContent));
  
  }
  public String getHelpContentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_HelpContent));
      }


 
 }

