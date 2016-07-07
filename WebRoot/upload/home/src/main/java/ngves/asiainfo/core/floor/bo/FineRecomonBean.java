package ngves.asiainfo.core.floor.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.floor.ivalues.*;
   
public class FineRecomonBean extends DataContainer implements DataContainerInterface,IFineRecomonValue{

    /**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
  private static String  m_boName = "ngves.asiainfo.core.floor.bo.FineRecomon";



  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_FineRecomonId = "FINE_RECOMON_ID";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_RecomonImgUrl = "RECOMON_IMG_URL";
  public final static  String S_IsHomeShow = "IS_HOME_SHOW";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Sort = "SORT";
  public final static  String S_RecomonHref = "RECOMON_HREF";
  public final static  String S_RecomonName = "RECOMON_NAME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public FineRecomonBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("");
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

  public void initFineRecomonId(long value){
     this.initProperty(S_FineRecomonId,new Long(value));
  }
  public  void setFineRecomonId(long value){
     this.set(S_FineRecomonId,new Long(value));
  }
  public  void setFineRecomonIdNull(){
     this.set(S_FineRecomonId,null);
  }

  public long getFineRecomonId(){
        return DataType.getAsLong(this.get(S_FineRecomonId));
  
  }
  public long getFineRecomonIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_FineRecomonId));
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

  public void initRecomonImgUrl(String value){
     this.initProperty(S_RecomonImgUrl,value);
  }
  public  void setRecomonImgUrl(String value){
     this.set(S_RecomonImgUrl,value);
  }
  public  void setRecomonImgUrlNull(){
     this.set(S_RecomonImgUrl,null);
  }

  public String getRecomonImgUrl(){
       return DataType.getAsString(this.get(S_RecomonImgUrl));
  
  }
  public String getRecomonImgUrlInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RecomonImgUrl));
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

  public void initRecomonHref(String value){
     this.initProperty(S_RecomonHref,value);
  }
  public  void setRecomonHref(String value){
     this.set(S_RecomonHref,value);
  }
  public  void setRecomonHrefNull(){
     this.set(S_RecomonHref,null);
  }

  public String getRecomonHref(){
       return DataType.getAsString(this.get(S_RecomonHref));
  
  }
  public String getRecomonHrefInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RecomonHref));
      }

  public void initRecomonName(String value){
     this.initProperty(S_RecomonName,value);
  }
  public  void setRecomonName(String value){
     this.set(S_RecomonName,value);
  }
  public  void setRecomonNameNull(){
     this.set(S_RecomonName,null);
  }

  public String getRecomonName(){
       return DataType.getAsString(this.get(S_RecomonName));
  
  }
  public String getRecomonNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RecomonName));
      }


 
 }

