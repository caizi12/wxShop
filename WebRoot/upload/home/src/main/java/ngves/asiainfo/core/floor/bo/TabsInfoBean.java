package ngves.asiainfo.core.floor.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.floor.ivalues.*;

public class TabsInfoBean extends DataContainer implements DataContainerInterface,ITabsInfoValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.floor.bo.TabsInfo";



  public final static  String S_TabsTemplate = "TABS_TEMPLATE";
  public final static  String S_ModityDate = "MODITY_DATE";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_CreatDate = "CREAT_DATE";
  public final static  String S_TabsName = "TABS_NAME";
  public final static  String S_TabsId = "TABS_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public TabsInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("");
 }


  public void initTabsTemplate(String value){
     this.initProperty(S_TabsTemplate,value);
  }
  public  void setTabsTemplate(String value){
     this.set(S_TabsTemplate,value);
  }
  public  void setTabsTemplateNull(){
     this.set(S_TabsTemplate,null);
  }

  public String getTabsTemplate(){
       return DataType.getAsString(this.get(S_TabsTemplate));
  
  }
  public String getTabsTemplateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TabsTemplate));
      }

  public void initModityDate(Timestamp value){
     this.initProperty(S_ModityDate,value);
  }
  public  void setModityDate(Timestamp value){
     this.set(S_ModityDate,value);
  }
  public  void setModityDateNull(){
     this.set(S_ModityDate,null);
  }

  public Timestamp getModityDate(){
        return DataType.getAsDateTime(this.get(S_ModityDate));
  
  }
  public Timestamp getModityDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ModityDate));
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

  public void initCreatDate(Timestamp value){
     this.initProperty(S_CreatDate,value);
  }
  public  void setCreatDate(Timestamp value){
     this.set(S_CreatDate,value);
  }
  public  void setCreatDateNull(){
     this.set(S_CreatDate,null);
  }

  public Timestamp getCreatDate(){
        return DataType.getAsDateTime(this.get(S_CreatDate));
  
  }
  public Timestamp getCreatDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CreatDate));
      }

  public void initTabsName(String value){
     this.initProperty(S_TabsName,value);
  }
  public  void setTabsName(String value){
     this.set(S_TabsName,value);
  }
  public  void setTabsNameNull(){
     this.set(S_TabsName,null);
  }

  public String getTabsName(){
       return DataType.getAsString(this.get(S_TabsName));
  
  }
  public String getTabsNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TabsName));
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


 
 }

