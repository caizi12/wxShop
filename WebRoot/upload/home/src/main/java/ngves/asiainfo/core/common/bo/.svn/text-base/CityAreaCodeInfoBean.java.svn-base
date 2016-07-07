package ngves.asiainfo.core.common.bo;

import ngves.asiainfo.core.common.ivalues.ICityAreaCodeInfoValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

@SuppressWarnings("serial")
public class CityAreaCodeInfoBean extends DataContainer implements DataContainerInterface,ICityAreaCodeInfoValue{

  private static String  m_boName = "ngves.asiainfo.core.common.bo.CityAreaCodeInfo";



  public final static  String S_ProvinceHpCode = "PROVINCE_HP_CODE";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_CityHpName = "CITY_HP_NAME";
  public final static  String S_CityAreaCodeId = "CITY_AREA_CODE_ID";
  public final static  String S_ProvinceCode = "PROVINCE_CODE";
  public final static  String S_CityAreaCode = "CITY_AREA_CODE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public CityAreaCodeInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("");
 }


  public void initProvinceHpCode(String value){
     this.initProperty(S_ProvinceHpCode,value);
  }
  public  void setProvinceHpCode(String value){
     this.set(S_ProvinceHpCode,value);
  }
  public  void setProvinceHpCodeNull(){
     this.set(S_ProvinceHpCode,null);
  }

  public String getProvinceHpCode(){
       return DataType.getAsString(this.get(S_ProvinceHpCode));
  
  }
  public String getProvinceHpCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProvinceHpCode));
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

  public void initCityHpName(String value){
     this.initProperty(S_CityHpName,value);
  }
  public  void setCityHpName(String value){
     this.set(S_CityHpName,value);
  }
  public  void setCityHpNameNull(){
     this.set(S_CityHpName,null);
  }

  public String getCityHpName(){
       return DataType.getAsString(this.get(S_CityHpName));
  
  }
  public String getCityHpNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CityHpName));
      }

  public void initCityAreaCodeId(long value){
     this.initProperty(S_CityAreaCodeId,new Long(value));
  }
  public  void setCityAreaCodeId(long value){
     this.set(S_CityAreaCodeId,new Long(value));
  }
  public  void setCityAreaCodeIdNull(){
     this.set(S_CityAreaCodeId,null);
  }

  public long getCityAreaCodeId(){
        return DataType.getAsLong(this.get(S_CityAreaCodeId));
  
  }
  public long getCityAreaCodeIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_CityAreaCodeId));
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

  public void initCityAreaCode(String value){
     this.initProperty(S_CityAreaCode,value);
  }
  public  void setCityAreaCode(String value){
     this.set(S_CityAreaCode,value);
  }
  public  void setCityAreaCodeNull(){
     this.set(S_CityAreaCode,null);
  }

  public String getCityAreaCode(){
       return DataType.getAsString(this.get(S_CityAreaCode));
  
  }
  public String getCityAreaCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CityAreaCode));
      }


 
 }

