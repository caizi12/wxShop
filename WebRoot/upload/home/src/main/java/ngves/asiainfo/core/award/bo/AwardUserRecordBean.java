package ngves.asiainfo.core.award.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.award.ivalues.*;

public class AwardUserRecordBean extends DataContainer implements DataContainerInterface,IAwardUserRecordValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.award.bo.AwardUserRecord";



  public final static  String S_MobileNum = "MOBILE_NUM";
  public final static  String S_LevelSort = "LEVEL_SORT";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_AwardUserRecordId = "AWARD_USER_RECORD_ID";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_UserBrand = "USER_BRAND";
  public final static  String S_ProvinceCode = "PROVINCE_CODE";
  public final static  String S_AwardLevelId = "AWARD_LEVEL_ID";
  public final static  String S_WareId = "WARE_ID";
  public final static  String S_AwardId = "AWARD_ID";
  public final static  String S_AwardType = "AWARD_TYPE";
  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public AwardUserRecordBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initMobileNum(String value){
     this.initProperty(S_MobileNum,value);
  }
  public  void setMobileNum(String value){
     this.set(S_MobileNum,value);
  }
  public  void setMobileNumNull(){
     this.set(S_MobileNum,null);
  }

  public String getMobileNum(){
       return DataType.getAsString(this.get(S_MobileNum));
  
  }
  public String getMobileNumInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MobileNum));
      }

  public void initLevelSort(long value){
     this.initProperty(S_LevelSort,new Long(value));
  }
  public  void setLevelSort(long value){
     this.set(S_LevelSort,new Long(value));
  }
  public  void setLevelSortNull(){
     this.set(S_LevelSort,null);
  }

  public long getLevelSort(){
        return DataType.getAsLong(this.get(S_LevelSort));
  
  }
  public long getLevelSortInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_LevelSort));
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

  public void initAwardUserRecordId(long value){
     this.initProperty(S_AwardUserRecordId,new Long(value));
  }
  public  void setAwardUserRecordId(long value){
     this.set(S_AwardUserRecordId,new Long(value));
  }
  public  void setAwardUserRecordIdNull(){
     this.set(S_AwardUserRecordId,null);
  }

  public long getAwardUserRecordId(){
        return DataType.getAsLong(this.get(S_AwardUserRecordId));
  
  }
  public long getAwardUserRecordIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AwardUserRecordId));
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

  public void initUserBrand(String value){
     this.initProperty(S_UserBrand,value);
  }
  public  void setUserBrand(String value){
     this.set(S_UserBrand,value);
  }
  public  void setUserBrandNull(){
     this.set(S_UserBrand,null);
  }

  public String getUserBrand(){
       return DataType.getAsString(this.get(S_UserBrand));
  
  }
  public String getUserBrandInitialValue(){
        return DataType.getAsString(this.getOldObj(S_UserBrand));
      }

  public void initProvinceCode(String value){
     this.initProperty(S_ProvinceCode,value);
  }
  public  void setProvinceCode(String value){
     this.set(S_ProvinceCode,value);
  }
  public  void setProvinceCodeNull(){
     this.set(S_ProvinceCode,null);
  }

  public String getProvinceCode(){
       return DataType.getAsString(this.get(S_ProvinceCode));
  
  }
  public String getProvinceCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProvinceCode));
      }

  public void initAwardLevelId(long value){
     this.initProperty(S_AwardLevelId,new Long(value));
  }
  public  void setAwardLevelId(long value){
     this.set(S_AwardLevelId,new Long(value));
  }
  public  void setAwardLevelIdNull(){
     this.set(S_AwardLevelId,null);
  }

  public long getAwardLevelId(){
        return DataType.getAsLong(this.get(S_AwardLevelId));
  
  }
  public long getAwardLevelIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AwardLevelId));
      }

  public void initWareId(long value){
     this.initProperty(S_WareId,new Long(value));
  }
  public  void setWareId(long value){
     this.set(S_WareId,new Long(value));
  }
  public  void setWareIdNull(){
     this.set(S_WareId,null);
  }

  public long getWareId(){
        return DataType.getAsLong(this.get(S_WareId));
  
  }
  public long getWareIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_WareId));
      }

  public void initAwardId(long value){
     this.initProperty(S_AwardId,new Long(value));
  }
  public  void setAwardId(long value){
     this.set(S_AwardId,new Long(value));
  }
  public  void setAwardIdNull(){
     this.set(S_AwardId,null);
  }

  public long getAwardId(){
        return DataType.getAsLong(this.get(S_AwardId));
  
  }
  public long getAwardIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AwardId));
      }


  public void initAwardType(String value){
	     this.initProperty(S_AwardType,value);
	  }
	  public  void setAwardType(String value){
	     this.set(S_AwardType,value);
	  }
	  public  void setAwardTypeNull(){
	     this.set(S_AwardType,null);
	  }

	  public String getAwardType(){
	       return DataType.getAsString(this.get(S_AwardType));
	  
	  }
	  public String getAwardTypeInitialValue(){
	        return DataType.getAsString(this.getOldObj(S_AwardType));
	      }
  
  
 
 }

