package ngves.asiainfo.core.ua.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.ua.ivalues.*;

public class UserAgentBean extends DataContainer implements DataContainerInterface,IUserAgentValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = -1147210914148331974L;



private static String  m_boName = "ngves.asiainfo.core.ua.bo.UserAgent";



  public final static  String S_ResolutionHeight = "RESOLUTION_HEIGHT";
  public final static  String S_Os = "OS";
  public final static  String S_Brand = "BRAND";
  public final static  String S_ScreenWidth = "SCREEN_WIDTH";
  public final static  String S_RowsCount = "ROWS_COUNT";
  public final static  String S_ResolutionWidth = "RESOLUTION_WIDTH";
  public final static  String S_WapVersion = "WAP_VERSION";
  public final static  String S_UaStr = "UA_STR";
  public final static  String S_AppearDate = "APPEAR_DATE";
  public final static  String S_ForwardAddress = "FORWARD_ADDRESS";
  public final static  String S_PhoneModel = "PHONE_MODEL";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_MatchedRule = "MATCHED_RULE";
  public final static  String S_UaCode = "UA_CODE";
  public final static  String S_ScreenHeight = "SCREEN_HEIGHT";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_ColumnsCount = "COLUMNS_COUNT";
  public final static  String S_VisitedCount = "VISITED_COUNT";
  public final static  String S_Id = "ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public UserAgentBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initResolutionHeight(long value){
     this.initProperty(S_ResolutionHeight,new Long(value));
  }
  public  void setResolutionHeight(long value){
     this.set(S_ResolutionHeight,new Long(value));
  }
  public  void setResolutionHeightNull(){
     this.set(S_ResolutionHeight,null);
  }

  public long getResolutionHeight(){
        return DataType.getAsLong(this.get(S_ResolutionHeight));
  
  }
  public long getResolutionHeightInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ResolutionHeight));
      }

  public void initOs(String value){
     this.initProperty(S_Os,value);
  }
  public  void setOs(String value){
     this.set(S_Os,value);
  }
  public  void setOsNull(){
     this.set(S_Os,null);
  }

  public String getOs(){
       return DataType.getAsString(this.get(S_Os));
  
  }
  public String getOsInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Os));
      }

  public void initBrand(String value){
     this.initProperty(S_Brand,value);
  }
  public  void setBrand(String value){
     this.set(S_Brand,value);
  }
  public  void setBrandNull(){
     this.set(S_Brand,null);
  }

  public String getBrand(){
       return DataType.getAsString(this.get(S_Brand));
  
  }
  public String getBrandInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Brand));
      }

  public void initScreenWidth(long value){
     this.initProperty(S_ScreenWidth,new Long(value));
  }
  public  void setScreenWidth(long value){
     this.set(S_ScreenWidth,new Long(value));
  }
  public  void setScreenWidthNull(){
     this.set(S_ScreenWidth,null);
  }

  public long getScreenWidth(){
        return DataType.getAsLong(this.get(S_ScreenWidth));
  
  }
  public long getScreenWidthInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ScreenWidth));
      }

  public void initRowsCount(long value){
     this.initProperty(S_RowsCount,new Long(value));
  }
  public  void setRowsCount(long value){
     this.set(S_RowsCount,new Long(value));
  }
  public  void setRowsCountNull(){
     this.set(S_RowsCount,null);
  }

  public long getRowsCount(){
        return DataType.getAsLong(this.get(S_RowsCount));
  
  }
  public long getRowsCountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RowsCount));
      }

  public void initResolutionWidth(long value){
     this.initProperty(S_ResolutionWidth,new Long(value));
  }
  public  void setResolutionWidth(long value){
     this.set(S_ResolutionWidth,new Long(value));
  }
  public  void setResolutionWidthNull(){
     this.set(S_ResolutionWidth,null);
  }

  public long getResolutionWidth(){
        return DataType.getAsLong(this.get(S_ResolutionWidth));
  
  }
  public long getResolutionWidthInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ResolutionWidth));
      }

  public void initWapVersion(String value){
     this.initProperty(S_WapVersion,value);
  }
  public  void setWapVersion(String value){
     this.set(S_WapVersion,value);
  }
  public  void setWapVersionNull(){
     this.set(S_WapVersion,null);
  }

  public String getWapVersion(){
       return DataType.getAsString(this.get(S_WapVersion));
  
  }
  public String getWapVersionInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WapVersion));
      }

  public void initUaStr(String value){
     this.initProperty(S_UaStr,value);
  }
  public  void setUaStr(String value){
     this.set(S_UaStr,value);
  }
  public  void setUaStrNull(){
     this.set(S_UaStr,null);
  }

  public String getUaStr(){
       return DataType.getAsString(this.get(S_UaStr));
  
  }
  public String getUaStrInitialValue(){
        return DataType.getAsString(this.getOldObj(S_UaStr));
      }

  public void initAppearDate(Timestamp value){
     this.initProperty(S_AppearDate,value);
  }
  public  void setAppearDate(Timestamp value){
     this.set(S_AppearDate,value);
  }
  public  void setAppearDateNull(){
     this.set(S_AppearDate,null);
  }

  public Timestamp getAppearDate(){
        return DataType.getAsDateTime(this.get(S_AppearDate));
  
  }
  public Timestamp getAppearDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_AppearDate));
      }

  public void initForwardAddress(String value){
     this.initProperty(S_ForwardAddress,value);
  }
  public  void setForwardAddress(String value){
     this.set(S_ForwardAddress,value);
  }
  public  void setForwardAddressNull(){
     this.set(S_ForwardAddress,null);
  }

  public String getForwardAddress(){
       return DataType.getAsString(this.get(S_ForwardAddress));
  
  }
  public String getForwardAddressInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ForwardAddress));
      }

  public void initPhoneModel(String value){
     this.initProperty(S_PhoneModel,value);
  }
  public  void setPhoneModel(String value){
     this.set(S_PhoneModel,value);
  }
  public  void setPhoneModelNull(){
     this.set(S_PhoneModel,null);
  }

  public String getPhoneModel(){
       return DataType.getAsString(this.get(S_PhoneModel));
  
  }
  public String getPhoneModelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PhoneModel));
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

  public void initMatchedRule(String value){
     this.initProperty(S_MatchedRule,value);
  }
  public  void setMatchedRule(String value){
     this.set(S_MatchedRule,value);
  }
  public  void setMatchedRuleNull(){
     this.set(S_MatchedRule,null);
  }

  public String getMatchedRule(){
       return DataType.getAsString(this.get(S_MatchedRule));
  
  }
  public String getMatchedRuleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MatchedRule));
      }

  public void initUaCode(String value){
     this.initProperty(S_UaCode,value);
  }
  public  void setUaCode(String value){
     this.set(S_UaCode,value);
  }
  public  void setUaCodeNull(){
     this.set(S_UaCode,null);
  }

  public String getUaCode(){
       return DataType.getAsString(this.get(S_UaCode));
  
  }
  public String getUaCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_UaCode));
      }

  public void initScreenHeight(long value){
     this.initProperty(S_ScreenHeight,new Long(value));
  }
  public  void setScreenHeight(long value){
     this.set(S_ScreenHeight,new Long(value));
  }
  public  void setScreenHeightNull(){
     this.set(S_ScreenHeight,null);
  }

  public long getScreenHeight(){
        return DataType.getAsLong(this.get(S_ScreenHeight));
  
  }
  public long getScreenHeightInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ScreenHeight));
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

  public void initColumnsCount(long value){
     this.initProperty(S_ColumnsCount,new Long(value));
  }
  public  void setColumnsCount(long value){
     this.set(S_ColumnsCount,new Long(value));
  }
  public  void setColumnsCountNull(){
     this.set(S_ColumnsCount,null);
  }

  public long getColumnsCount(){
        return DataType.getAsLong(this.get(S_ColumnsCount));
  
  }
  public long getColumnsCountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ColumnsCount));
      }

  public void initVisitedCount(long value){
     this.initProperty(S_VisitedCount,new Long(value));
  }
  public  void setVisitedCount(long value){
     this.set(S_VisitedCount,new Long(value));
  }
  public  void setVisitedCountNull(){
     this.set(S_VisitedCount,null);
  }

  public long getVisitedCount(){
        return DataType.getAsLong(this.get(S_VisitedCount));
  
  }
  public long getVisitedCountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_VisitedCount));
      }

  public void initId(long value){
     this.initProperty(S_Id,new Long(value));
  }
  public  void setId(long value){
     this.set(S_Id,new Long(value));
  }
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public long getId(){
        return DataType.getAsLong(this.get(S_Id));
  
  }
  public long getIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Id));
      }


 
 }

