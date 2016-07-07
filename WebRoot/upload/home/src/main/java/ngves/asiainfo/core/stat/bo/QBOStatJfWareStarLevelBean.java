package ngves.asiainfo.core.stat.bo;

import ngves.asiainfo.core.stat.ivalues.IQBOStatJfWareStarLevelValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

@SuppressWarnings("serial")
public class QBOStatJfWareStarLevelBean extends DataContainer implements DataContainerInterface,IQBOStatJfWareStarLevelValue{

  private static String  m_boName = "ngves.asiainfo.core.stat.bo.QBOStatJfWareStarLevel";



  public final static  String S_Zcount06 = "ZCOUNT06";
  public final static  String S_Zcount05 = "ZCOUNT05";
  public final static  String S_Zcount08 = "ZCOUNT08";
  public final static  String S_Zcount07 = "ZCOUNT07";
  public final static  String S_Zcount09 = "ZCOUNT09";
  public final static  String S_SmallKindName = "SMALL_KIND_NAME";
  public final static  String S_PartnerCode = "PARTNER_CODE";
  public final static  String S_FName = "F_NAME";
  public final static  String S_Count09 = "COUNT09";
  public final static  String S_Count08 = "COUNT08";
  public final static  String S_Count07 = "COUNT07";
  public final static  String S_Count06 = "COUNT06";
  public final static  String S_Count05 = "COUNT05";
  public final static  String S_PartnerName = "PARTNER_NAME";
  public final static  String S_Zcount13 = "ZCOUNT13";
  public final static  String S_StatStartTime = "STAT_START_TIME";
  public final static  String S_Zcount12 = "ZCOUNT12";
  public final static  String S_Zcount11 = "ZCOUNT11";
  public final static  String S_Zcount10 = "ZCOUNT10";
  public final static  String S_Zvalue06 = "ZVALUE06";
  public final static  String S_Zvalue05 = "ZVALUE05";
  public final static  String S_Zvalue08 = "ZVALUE08";
  public final static  String S_Zvalue07 = "ZVALUE07";
  public final static  String S_MiddleKindName = "MIDDLE_KIND_NAME";
  public final static  String S_StatJfWareStarlevelId = "STAT_JF_WARE_STARLEVEL_ID";
  public final static  String S_Zvalue09 = "ZVALUE09";
  public final static  String S_Value09 = "VALUE09";
  public final static  String S_Zrn10 = "ZRN10";
  public final static  String S_Zvalue12 = "ZVALUE12";
  public final static  String S_Value08 = "VALUE08";
  public final static  String S_Zrn11 = "ZRN11";
  public final static  String S_Zvalue13 = "ZVALUE13";
  public final static  String S_Value07 = "VALUE07";
  public final static  String S_Zrn12 = "ZRN12";
  public final static  String S_Zvalue10 = "ZVALUE10";
  public final static  String S_Zrn13 = "ZRN13";
  public final static  String S_Value06 = "VALUE06";
  public final static  String S_Zvalue11 = "ZVALUE11";
  public final static  String S_Value05 = "VALUE05";
  public final static  String S_WareCode = "WARE_CODE";
  public final static  String S_Cvalue = "CVALUE";
  public final static  String S_StatEndTime = "STAT_END_TIME";
  public final static  String S_FCode = "F_CODE";
  public final static  String S_Count10 = "COUNT10";
  public final static  String S_Count11 = "COUNT11";
  public final static  String S_WareName = "WARE_NAME";
  public final static  String S_BigKindName = "BIG_KIND_NAME";
  public final static  String S_Count13 = "COUNT13";
  public final static  String S_Value11 = "VALUE11";
  public final static  String S_Zrn08 = "ZRN08";
  public final static  String S_Count12 = "COUNT12";
  public final static  String S_Value10 = "VALUE10";
  public final static  String S_Zrn09 = "ZRN09";
  public final static  String S_Value13 = "VALUE13";
  public final static  String S_Zrn06 = "ZRN06";
  public final static  String S_Value12 = "VALUE12";
  public final static  String S_Zrn07 = "ZRN07";
  public final static  String S_Zrn05 = "ZRN05";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBOStatJfWareStarLevelBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("");
 }


  public void initZcount06(long value){
     this.initProperty(S_Zcount06,new Long(value));
  }
  public  void setZcount06(long value){
     this.set(S_Zcount06,new Long(value));
  }
  public  void setZcount06Null(){
     this.set(S_Zcount06,null);
  }

  public long getZcount06(){
        return DataType.getAsLong(this.get(S_Zcount06));
  
  }
  public long getZcount06InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Zcount06));
      }

  public void initZcount05(long value){
     this.initProperty(S_Zcount05,new Long(value));
  }
  public  void setZcount05(long value){
     this.set(S_Zcount05,new Long(value));
  }
  public  void setZcount05Null(){
     this.set(S_Zcount05,null);
  }

  public long getZcount05(){
        return DataType.getAsLong(this.get(S_Zcount05));
  
  }
  public long getZcount05InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Zcount05));
      }

  public void initZcount08(long value){
     this.initProperty(S_Zcount08,new Long(value));
  }
  public  void setZcount08(long value){
     this.set(S_Zcount08,new Long(value));
  }
  public  void setZcount08Null(){
     this.set(S_Zcount08,null);
  }

  public long getZcount08(){
        return DataType.getAsLong(this.get(S_Zcount08));
  
  }
  public long getZcount08InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Zcount08));
      }

  public void initZcount07(long value){
     this.initProperty(S_Zcount07,new Long(value));
  }
  public  void setZcount07(long value){
     this.set(S_Zcount07,new Long(value));
  }
  public  void setZcount07Null(){
     this.set(S_Zcount07,null);
  }

  public long getZcount07(){
        return DataType.getAsLong(this.get(S_Zcount07));
  
  }
  public long getZcount07InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Zcount07));
      }

  public void initZcount09(long value){
     this.initProperty(S_Zcount09,new Long(value));
  }
  public  void setZcount09(long value){
     this.set(S_Zcount09,new Long(value));
  }
  public  void setZcount09Null(){
     this.set(S_Zcount09,null);
  }

  public long getZcount09(){
        return DataType.getAsLong(this.get(S_Zcount09));
  
  }
  public long getZcount09InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Zcount09));
      }

  public void initSmallKindName(String value){
     this.initProperty(S_SmallKindName,value);
  }
  public  void setSmallKindName(String value){
     this.set(S_SmallKindName,value);
  }
  public  void setSmallKindNameNull(){
     this.set(S_SmallKindName,null);
  }

  public String getSmallKindName(){
       return DataType.getAsString(this.get(S_SmallKindName));
  
  }
  public String getSmallKindNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SmallKindName));
      }

  public void initPartnerCode(String value){
     this.initProperty(S_PartnerCode,value);
  }
  public  void setPartnerCode(String value){
     this.set(S_PartnerCode,value);
  }
  public  void setPartnerCodeNull(){
     this.set(S_PartnerCode,null);
  }

  public String getPartnerCode(){
       return DataType.getAsString(this.get(S_PartnerCode));
  
  }
  public String getPartnerCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PartnerCode));
      }

  public void initFName(String value){
     this.initProperty(S_FName,value);
  }
  public  void setFName(String value){
     this.set(S_FName,value);
  }
  public  void setFNameNull(){
     this.set(S_FName,null);
  }

  public String getFName(){
       return DataType.getAsString(this.get(S_FName));
  
  }
  public String getFNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FName));
      }

  public void initCount09(long value){
     this.initProperty(S_Count09,new Long(value));
  }
  public  void setCount09(long value){
     this.set(S_Count09,new Long(value));
  }
  public  void setCount09Null(){
     this.set(S_Count09,null);
  }

  public long getCount09(){
        return DataType.getAsLong(this.get(S_Count09));
  
  }
  public long getCount09InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Count09));
      }

  public void initCount08(long value){
     this.initProperty(S_Count08,new Long(value));
  }
  public  void setCount08(long value){
     this.set(S_Count08,new Long(value));
  }
  public  void setCount08Null(){
     this.set(S_Count08,null);
  }

  public long getCount08(){
        return DataType.getAsLong(this.get(S_Count08));
  
  }
  public long getCount08InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Count08));
      }

  public void initCount07(long value){
     this.initProperty(S_Count07,new Long(value));
  }
  public  void setCount07(long value){
     this.set(S_Count07,new Long(value));
  }
  public  void setCount07Null(){
     this.set(S_Count07,null);
  }

  public long getCount07(){
        return DataType.getAsLong(this.get(S_Count07));
  
  }
  public long getCount07InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Count07));
      }

  public void initCount06(long value){
     this.initProperty(S_Count06,new Long(value));
  }
  public  void setCount06(long value){
     this.set(S_Count06,new Long(value));
  }
  public  void setCount06Null(){
     this.set(S_Count06,null);
  }

  public long getCount06(){
        return DataType.getAsLong(this.get(S_Count06));
  
  }
  public long getCount06InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Count06));
      }

  public void initCount05(long value){
     this.initProperty(S_Count05,new Long(value));
  }
  public  void setCount05(long value){
     this.set(S_Count05,new Long(value));
  }
  public  void setCount05Null(){
     this.set(S_Count05,null);
  }

  public long getCount05(){
        return DataType.getAsLong(this.get(S_Count05));
  
  }
  public long getCount05InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Count05));
      }

  public void initPartnerName(String value){
     this.initProperty(S_PartnerName,value);
  }
  public  void setPartnerName(String value){
     this.set(S_PartnerName,value);
  }
  public  void setPartnerNameNull(){
     this.set(S_PartnerName,null);
  }

  public String getPartnerName(){
       return DataType.getAsString(this.get(S_PartnerName));
  
  }
  public String getPartnerNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PartnerName));
      }

  public void initZcount13(long value){
     this.initProperty(S_Zcount13,new Long(value));
  }
  public  void setZcount13(long value){
     this.set(S_Zcount13,new Long(value));
  }
  public  void setZcount13Null(){
     this.set(S_Zcount13,null);
  }

  public long getZcount13(){
        return DataType.getAsLong(this.get(S_Zcount13));
  
  }
  public long getZcount13InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Zcount13));
      }

  public void initStatStartTime(String value){
     this.initProperty(S_StatStartTime,value);
  }
  public  void setStatStartTime(String value){
     this.set(S_StatStartTime,value);
  }
  public  void setStatStartTimeNull(){
     this.set(S_StatStartTime,null);
  }

  public String getStatStartTime(){
       return DataType.getAsString(this.get(S_StatStartTime));
  
  }
  public String getStatStartTimeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_StatStartTime));
      }

  public void initZcount12(long value){
     this.initProperty(S_Zcount12,new Long(value));
  }
  public  void setZcount12(long value){
     this.set(S_Zcount12,new Long(value));
  }
  public  void setZcount12Null(){
     this.set(S_Zcount12,null);
  }

  public long getZcount12(){
        return DataType.getAsLong(this.get(S_Zcount12));
  
  }
  public long getZcount12InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Zcount12));
      }

  public void initZcount11(long value){
     this.initProperty(S_Zcount11,new Long(value));
  }
  public  void setZcount11(long value){
     this.set(S_Zcount11,new Long(value));
  }
  public  void setZcount11Null(){
     this.set(S_Zcount11,null);
  }

  public long getZcount11(){
        return DataType.getAsLong(this.get(S_Zcount11));
  
  }
  public long getZcount11InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Zcount11));
      }

  public void initZcount10(long value){
     this.initProperty(S_Zcount10,new Long(value));
  }
  public  void setZcount10(long value){
     this.set(S_Zcount10,new Long(value));
  }
  public  void setZcount10Null(){
     this.set(S_Zcount10,null);
  }

  public long getZcount10(){
        return DataType.getAsLong(this.get(S_Zcount10));
  
  }
  public long getZcount10InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Zcount10));
      }

  public void initZvalue06(float value){
     this.initProperty(S_Zvalue06,new Float(value));
  }
  public  void setZvalue06(float value){
     this.set(S_Zvalue06,new Float(value));
  }
  public  void setZvalue06Null(){
     this.set(S_Zvalue06,null);
  }

  public float getZvalue06(){
        return DataType.getAsFloat(this.get(S_Zvalue06));
  
  }
  public float getZvalue06InitialValue(){
        return DataType.getAsFloat(this.getOldObj(S_Zvalue06));
      }

  public void initZvalue05(float value){
     this.initProperty(S_Zvalue05,new Float(value));
  }
  public  void setZvalue05(float value){
     this.set(S_Zvalue05,new Float(value));
  }
  public  void setZvalue05Null(){
     this.set(S_Zvalue05,null);
  }

  public float getZvalue05(){
        return DataType.getAsFloat(this.get(S_Zvalue05));
  
  }
  public float getZvalue05InitialValue(){
        return DataType.getAsFloat(this.getOldObj(S_Zvalue05));
      }

  public void initZvalue08(float value){
     this.initProperty(S_Zvalue08,new Float(value));
  }
  public  void setZvalue08(float value){
     this.set(S_Zvalue08,new Float(value));
  }
  public  void setZvalue08Null(){
     this.set(S_Zvalue08,null);
  }

  public float getZvalue08(){
        return DataType.getAsFloat(this.get(S_Zvalue08));
  
  }
  public float getZvalue08InitialValue(){
        return DataType.getAsFloat(this.getOldObj(S_Zvalue08));
      }

  public void initZvalue07(float value){
     this.initProperty(S_Zvalue07,new Float(value));
  }
  public  void setZvalue07(float value){
     this.set(S_Zvalue07,new Float(value));
  }
  public  void setZvalue07Null(){
     this.set(S_Zvalue07,null);
  }

  public float getZvalue07(){
        return DataType.getAsFloat(this.get(S_Zvalue07));
  
  }
  public float getZvalue07InitialValue(){
        return DataType.getAsFloat(this.getOldObj(S_Zvalue07));
      }

  public void initMiddleKindName(String value){
     this.initProperty(S_MiddleKindName,value);
  }
  public  void setMiddleKindName(String value){
     this.set(S_MiddleKindName,value);
  }
  public  void setMiddleKindNameNull(){
     this.set(S_MiddleKindName,null);
  }

  public String getMiddleKindName(){
       return DataType.getAsString(this.get(S_MiddleKindName));
  
  }
  public String getMiddleKindNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MiddleKindName));
      }

  public void initStatJfWareStarlevelId(long value){
     this.initProperty(S_StatJfWareStarlevelId,new Long(value));
  }
  public  void setStatJfWareStarlevelId(long value){
     this.set(S_StatJfWareStarlevelId,new Long(value));
  }
  public  void setStatJfWareStarlevelIdNull(){
     this.set(S_StatJfWareStarlevelId,null);
  }

  public long getStatJfWareStarlevelId(){
        return DataType.getAsLong(this.get(S_StatJfWareStarlevelId));
  
  }
  public long getStatJfWareStarlevelIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_StatJfWareStarlevelId));
      }

  public void initZvalue09(float value){
     this.initProperty(S_Zvalue09,new Float(value));
  }
  public  void setZvalue09(float value){
     this.set(S_Zvalue09,new Float(value));
  }
  public  void setZvalue09Null(){
     this.set(S_Zvalue09,null);
  }

  public float getZvalue09(){
        return DataType.getAsFloat(this.get(S_Zvalue09));
  
  }
  public float getZvalue09InitialValue(){
        return DataType.getAsFloat(this.getOldObj(S_Zvalue09));
      }

  public void initValue09(float value){
     this.initProperty(S_Value09,new Float(value));
  }
  public  void setValue09(float value){
     this.set(S_Value09,new Float(value));
  }
  public  void setValue09Null(){
     this.set(S_Value09,null);
  }

  public float getValue09(){
        return DataType.getAsFloat(this.get(S_Value09));
  
  }
  public float getValue09InitialValue(){
        return DataType.getAsFloat(this.getOldObj(S_Value09));
      }

  public void initZrn10(long value){
     this.initProperty(S_Zrn10,new Long(value));
  }
  public  void setZrn10(long value){
     this.set(S_Zrn10,new Long(value));
  }
  public  void setZrn10Null(){
     this.set(S_Zrn10,null);
  }

  public long getZrn10(){
        return DataType.getAsLong(this.get(S_Zrn10));
  
  }
  public long getZrn10InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Zrn10));
      }

  public void initZvalue12(float value){
     this.initProperty(S_Zvalue12,new Float(value));
  }
  public  void setZvalue12(float value){
     this.set(S_Zvalue12,new Float(value));
  }
  public  void setZvalue12Null(){
     this.set(S_Zvalue12,null);
  }

  public float getZvalue12(){
        return DataType.getAsFloat(this.get(S_Zvalue12));
  
  }
  public float getZvalue12InitialValue(){
        return DataType.getAsFloat(this.getOldObj(S_Zvalue12));
      }

  public void initValue08(float value){
     this.initProperty(S_Value08,new Float(value));
  }
  public  void setValue08(float value){
     this.set(S_Value08,new Float(value));
  }
  public  void setValue08Null(){
     this.set(S_Value08,null);
  }

  public float getValue08(){
        return DataType.getAsFloat(this.get(S_Value08));
  
  }
  public float getValue08InitialValue(){
        return DataType.getAsFloat(this.getOldObj(S_Value08));
      }

  public void initZrn11(long value){
     this.initProperty(S_Zrn11,new Long(value));
  }
  public  void setZrn11(long value){
     this.set(S_Zrn11,new Long(value));
  }
  public  void setZrn11Null(){
     this.set(S_Zrn11,null);
  }

  public long getZrn11(){
        return DataType.getAsLong(this.get(S_Zrn11));
  
  }
  public long getZrn11InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Zrn11));
      }

  public void initZvalue13(float value){
     this.initProperty(S_Zvalue13,new Float(value));
  }
  public  void setZvalue13(float value){
     this.set(S_Zvalue13,new Float(value));
  }
  public  void setZvalue13Null(){
     this.set(S_Zvalue13,null);
  }

  public float getZvalue13(){
        return DataType.getAsFloat(this.get(S_Zvalue13));
  
  }
  public float getZvalue13InitialValue(){
        return DataType.getAsFloat(this.getOldObj(S_Zvalue13));
      }

  public void initValue07(float value){
     this.initProperty(S_Value07,new Float(value));
  }
  public  void setValue07(float value){
     this.set(S_Value07,new Float(value));
  }
  public  void setValue07Null(){
     this.set(S_Value07,null);
  }

  public float getValue07(){
        return DataType.getAsFloat(this.get(S_Value07));
  
  }
  public float getValue07InitialValue(){
        return DataType.getAsFloat(this.getOldObj(S_Value07));
      }

  public void initZrn12(long value){
     this.initProperty(S_Zrn12,new Long(value));
  }
  public  void setZrn12(long value){
     this.set(S_Zrn12,new Long(value));
  }
  public  void setZrn12Null(){
     this.set(S_Zrn12,null);
  }

  public long getZrn12(){
        return DataType.getAsLong(this.get(S_Zrn12));
  
  }
  public long getZrn12InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Zrn12));
      }

  public void initZvalue10(float value){
     this.initProperty(S_Zvalue10,new Float(value));
  }
  public  void setZvalue10(float value){
     this.set(S_Zvalue10,new Float(value));
  }
  public  void setZvalue10Null(){
     this.set(S_Zvalue10,null);
  }

  public float getZvalue10(){
        return DataType.getAsFloat(this.get(S_Zvalue10));
  
  }
  public float getZvalue10InitialValue(){
        return DataType.getAsFloat(this.getOldObj(S_Zvalue10));
      }

  public void initZrn13(long value){
     this.initProperty(S_Zrn13,new Long(value));
  }
  public  void setZrn13(long value){
     this.set(S_Zrn13,new Long(value));
  }
  public  void setZrn13Null(){
     this.set(S_Zrn13,null);
  }

  public long getZrn13(){
        return DataType.getAsLong(this.get(S_Zrn13));
  
  }
  public long getZrn13InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Zrn13));
      }

  public void initValue06(float value){
     this.initProperty(S_Value06,new Float(value));
  }
  public  void setValue06(float value){
     this.set(S_Value06,new Float(value));
  }
  public  void setValue06Null(){
     this.set(S_Value06,null);
  }

  public float getValue06(){
        return DataType.getAsFloat(this.get(S_Value06));
  
  }
  public float getValue06InitialValue(){
        return DataType.getAsFloat(this.getOldObj(S_Value06));
      }

  public void initZvalue11(float value){
     this.initProperty(S_Zvalue11,new Float(value));
  }
  public  void setZvalue11(float value){
     this.set(S_Zvalue11,new Float(value));
  }
  public  void setZvalue11Null(){
     this.set(S_Zvalue11,null);
  }

  public float getZvalue11(){
        return DataType.getAsFloat(this.get(S_Zvalue11));
  
  }
  public float getZvalue11InitialValue(){
        return DataType.getAsFloat(this.getOldObj(S_Zvalue11));
      }

  public void initValue05(float value){
     this.initProperty(S_Value05,new Float(value));
  }
  public  void setValue05(float value){
     this.set(S_Value05,new Float(value));
  }
  public  void setValue05Null(){
     this.set(S_Value05,null);
  }

  public float getValue05(){
        return DataType.getAsFloat(this.get(S_Value05));
  
  }
  public float getValue05InitialValue(){
        return DataType.getAsFloat(this.getOldObj(S_Value05));
      }

  public void initWareCode(String value){
     this.initProperty(S_WareCode,value);
  }
  public  void setWareCode(String value){
     this.set(S_WareCode,value);
  }
  public  void setWareCodeNull(){
     this.set(S_WareCode,null);
  }

  public String getWareCode(){
       return DataType.getAsString(this.get(S_WareCode));
  
  }
  public String getWareCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WareCode));
      }

  public void initCvalue(float value){
     this.initProperty(S_Cvalue,new Float(value));
  }
  public  void setCvalue(float value){
     this.set(S_Cvalue,new Float(value));
  }
  public  void setCvalueNull(){
     this.set(S_Cvalue,null);
  }

  public float getCvalue(){
        return DataType.getAsFloat(this.get(S_Cvalue));
  
  }
  public float getCvalueInitialValue(){
        return DataType.getAsFloat(this.getOldObj(S_Cvalue));
      }

  public void initStatEndTime(String value){
     this.initProperty(S_StatEndTime,value);
  }
  public  void setStatEndTime(String value){
     this.set(S_StatEndTime,value);
  }
  public  void setStatEndTimeNull(){
     this.set(S_StatEndTime,null);
  }

  public String getStatEndTime(){
       return DataType.getAsString(this.get(S_StatEndTime));
  
  }
  public String getStatEndTimeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_StatEndTime));
      }

  public void initFCode(String value){
     this.initProperty(S_FCode,value);
  }
  public  void setFCode(String value){
     this.set(S_FCode,value);
  }
  public  void setFCodeNull(){
     this.set(S_FCode,null);
  }

  public String getFCode(){
       return DataType.getAsString(this.get(S_FCode));
  
  }
  public String getFCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FCode));
      }

  public void initCount10(long value){
     this.initProperty(S_Count10,new Long(value));
  }
  public  void setCount10(long value){
     this.set(S_Count10,new Long(value));
  }
  public  void setCount10Null(){
     this.set(S_Count10,null);
  }

  public long getCount10(){
        return DataType.getAsLong(this.get(S_Count10));
  
  }
  public long getCount10InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Count10));
      }

  public void initCount11(long value){
     this.initProperty(S_Count11,new Long(value));
  }
  public  void setCount11(long value){
     this.set(S_Count11,new Long(value));
  }
  public  void setCount11Null(){
     this.set(S_Count11,null);
  }

  public long getCount11(){
        return DataType.getAsLong(this.get(S_Count11));
  
  }
  public long getCount11InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Count11));
      }

  public void initWareName(String value){
     this.initProperty(S_WareName,value);
  }
  public  void setWareName(String value){
     this.set(S_WareName,value);
  }
  public  void setWareNameNull(){
     this.set(S_WareName,null);
  }

  public String getWareName(){
       return DataType.getAsString(this.get(S_WareName));
  
  }
  public String getWareNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WareName));
      }

  public void initBigKindName(String value){
     this.initProperty(S_BigKindName,value);
  }
  public  void setBigKindName(String value){
     this.set(S_BigKindName,value);
  }
  public  void setBigKindNameNull(){
     this.set(S_BigKindName,null);
  }

  public String getBigKindName(){
       return DataType.getAsString(this.get(S_BigKindName));
  
  }
  public String getBigKindNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BigKindName));
      }

  public void initCount13(long value){
     this.initProperty(S_Count13,new Long(value));
  }
  public  void setCount13(long value){
     this.set(S_Count13,new Long(value));
  }
  public  void setCount13Null(){
     this.set(S_Count13,null);
  }

  public long getCount13(){
        return DataType.getAsLong(this.get(S_Count13));
  
  }
  public long getCount13InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Count13));
      }

  public void initValue11(float value){
     this.initProperty(S_Value11,new Float(value));
  }
  public  void setValue11(float value){
     this.set(S_Value11,new Float(value));
  }
  public  void setValue11Null(){
     this.set(S_Value11,null);
  }

  public float getValue11(){
        return DataType.getAsFloat(this.get(S_Value11));
  
  }
  public float getValue11InitialValue(){
        return DataType.getAsFloat(this.getOldObj(S_Value11));
      }

  public void initZrn08(long value){
     this.initProperty(S_Zrn08,new Long(value));
  }
  public  void setZrn08(long value){
     this.set(S_Zrn08,new Long(value));
  }
  public  void setZrn08Null(){
     this.set(S_Zrn08,null);
  }

  public long getZrn08(){
        return DataType.getAsLong(this.get(S_Zrn08));
  
  }
  public long getZrn08InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Zrn08));
      }

  public void initCount12(long value){
     this.initProperty(S_Count12,new Long(value));
  }
  public  void setCount12(long value){
     this.set(S_Count12,new Long(value));
  }
  public  void setCount12Null(){
     this.set(S_Count12,null);
  }

  public long getCount12(){
        return DataType.getAsLong(this.get(S_Count12));
  
  }
  public long getCount12InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Count12));
      }

  public void initValue10(float value){
     this.initProperty(S_Value10,new Float(value));
  }
  public  void setValue10(float value){
     this.set(S_Value10,new Float(value));
  }
  public  void setValue10Null(){
     this.set(S_Value10,null);
  }

  public float getValue10(){
        return DataType.getAsFloat(this.get(S_Value10));
  
  }
  public float getValue10InitialValue(){
        return DataType.getAsFloat(this.getOldObj(S_Value10));
      }

  public void initZrn09(long value){
     this.initProperty(S_Zrn09,new Long(value));
  }
  public  void setZrn09(long value){
     this.set(S_Zrn09,new Long(value));
  }
  public  void setZrn09Null(){
     this.set(S_Zrn09,null);
  }

  public long getZrn09(){
        return DataType.getAsLong(this.get(S_Zrn09));
  
  }
  public long getZrn09InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Zrn09));
      }

  public void initValue13(float value){
     this.initProperty(S_Value13,new Float(value));
  }
  public  void setValue13(float value){
     this.set(S_Value13,new Float(value));
  }
  public  void setValue13Null(){
     this.set(S_Value13,null);
  }

  public float getValue13(){
        return DataType.getAsFloat(this.get(S_Value13));
  
  }
  public float getValue13InitialValue(){
        return DataType.getAsFloat(this.getOldObj(S_Value13));
      }

  public void initZrn06(long value){
     this.initProperty(S_Zrn06,new Long(value));
  }
  public  void setZrn06(long value){
     this.set(S_Zrn06,new Long(value));
  }
  public  void setZrn06Null(){
     this.set(S_Zrn06,null);
  }

  public long getZrn06(){
        return DataType.getAsLong(this.get(S_Zrn06));
  
  }
  public long getZrn06InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Zrn06));
      }

  public void initValue12(float value){
     this.initProperty(S_Value12,new Float(value));
  }
  public  void setValue12(float value){
     this.set(S_Value12,new Float(value));
  }
  public  void setValue12Null(){
     this.set(S_Value12,null);
  }

  public float getValue12(){
        return DataType.getAsFloat(this.get(S_Value12));
  
  }
  public float getValue12InitialValue(){
        return DataType.getAsFloat(this.getOldObj(S_Value12));
      }

  public void initZrn07(long value){
     this.initProperty(S_Zrn07,new Long(value));
  }
  public  void setZrn07(long value){
     this.set(S_Zrn07,new Long(value));
  }
  public  void setZrn07Null(){
     this.set(S_Zrn07,null);
  }

  public long getZrn07(){
        return DataType.getAsLong(this.get(S_Zrn07));
  
  }
  public long getZrn07InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Zrn07));
      }

  public void initZrn05(long value){
     this.initProperty(S_Zrn05,new Long(value));
  }
  public  void setZrn05(long value){
     this.set(S_Zrn05,new Long(value));
  }
  public  void setZrn05Null(){
     this.set(S_Zrn05,null);
  }

  public long getZrn05(){
        return DataType.getAsLong(this.get(S_Zrn05));
  
  }
  public long getZrn05InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Zrn05));
      }


 
 }

