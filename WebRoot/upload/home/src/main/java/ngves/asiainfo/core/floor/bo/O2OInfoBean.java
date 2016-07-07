package ngves.asiainfo.core.floor.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.floor.ivalues.*;

public class O2OInfoBean extends DataContainer implements DataContainerInterface,IO2OInfoValue{

	/**
	 * 序列化
	 */
  private static final long serialVersionUID = 1L;
  private static String  m_boName = "ngves.asiainfo.core.floor.bo.O2OInfo";



  public final static  String S_O2oId = "O2O_ID";
  public final static  String S_O2oName = "O2O_NAME";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_O2oType = "O2O_TYPE";
  public final static  String S_O2oImgUrl = "O2O_IMG_URL";
  public final static  String S_O2oContent = "O2O_CONTENT";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_IsHomeShow = "IS_HOME_SHOW";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Sort = "SORT";

  public static ObjectType S_TYPE = null;
  static{
    try { 
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public O2OInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("�������������������ҵ���������");
 }


  public void initO2oId(long value){
     this.initProperty(S_O2oId,new Long(value));
  }
  public  void setO2oId(long value){
     this.set(S_O2oId,new Long(value));
  }
  public  void setO2oIdNull(){
     this.set(S_O2oId,null);
  }

  public long getO2oId(){
        return DataType.getAsLong(this.get(S_O2oId));
  
  }
  public long getO2oIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_O2oId));
      }

  public void initO2oName(String value){
     this.initProperty(S_O2oName,value);
  }
  public  void setO2oName(String value){
     this.set(S_O2oName,value);
  }
  public  void setO2oNameNull(){
     this.set(S_O2oName,null);
  }

  public String getO2oName(){
       return DataType.getAsString(this.get(S_O2oName));
  
  }
  public String getO2oNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_O2oName));
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

  public void initO2oType(String value){
     this.initProperty(S_O2oType,value);
  }
  public  void setO2oType(String value){
     this.set(S_O2oType,value);
  }
  public  void setO2oTypeNull(){
     this.set(S_O2oType,null);
  }

  public String getO2oType(){
       return DataType.getAsString(this.get(S_O2oType));
  
  }
  public String getO2oTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_O2oType));
      }

  public void initO2oImgUrl(String value){
     this.initProperty(S_O2oImgUrl,value);
  }
  public  void setO2oImgUrl(String value){
     this.set(S_O2oImgUrl,value);
  }
  public  void setO2oImgUrlNull(){
     this.set(S_O2oImgUrl,null);
  }

  public String getO2oImgUrl(){
       return DataType.getAsString(this.get(S_O2oImgUrl));
  
  }
  public String getO2oImgUrlInitialValue(){
        return DataType.getAsString(this.getOldObj(S_O2oImgUrl));
      }

  public void initO2oContent(String value){
     this.initProperty(S_O2oContent,value);
  }
  public  void setO2oContent(String value){
     this.set(S_O2oContent,value);
  }
  public  void setO2oContentNull(){
     this.set(S_O2oContent,null);
  }

  public String getO2oContent(){
       return DataType.getAsString(this.get(S_O2oContent));
  
  }
  public String getO2oContentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_O2oContent));
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

  public void initIsHomeShow(String value){
     this.initProperty(S_IsHomeShow,value);
  }
  public  void setIsHomeShow(String value){
     this.set(S_IsHomeShow,value);
  }
  public  void setIsHomeShowNull(){
     this.set(S_IsHomeShow,null);
  }

  public String getIsHomeShow(){
       return DataType.getAsString(this.get(S_IsHomeShow));
  
  }
  public String getIsHomeShowInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsHomeShow));
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

  public void initSort(String value){
     this.initProperty(S_Sort,value);
  }
  public  void setSort(String value){
     this.set(S_Sort,value);
  }
  public  void setSortNull(){
     this.set(S_Sort,null);
  }

  public String getSort(){
       return DataType.getAsString(this.get(S_Sort));
  
  }
  public String getSortInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Sort));
      }


 
 }

