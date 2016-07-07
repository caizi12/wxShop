package ngves.asiainfo.core.ua.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.ua.ivalues.*;

public class UserAgentAdapterBean extends DataContainer implements DataContainerInterface,IUserAgentAdapterValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = -5541406157472831057L;



private static String  m_boName = "ngves.asiainfo.core.ua.bo.UserAgentAdapter";



  public final static  String S_ColumnsNum = "COLUMNS_NUM";
  public final static  String S_ResolutionHeight = "RESOLUTION_HEIGHT";
  public final static  String S_WapSupport = "WAP_SUPPORT";
  public final static  String S_Priority = "PRIORITY";
  public final static  String S_ScreenWidth = "SCREEN_WIDTH";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_ResolutionWidth = "RESOLUTION_WIDTH";
  public final static  String S_WapVersion = "WAP_VERSION";
  public final static  String S_BrandName = "BRAND_NAME";
  public final static  String S_UpdateTime = "UPDATE_TIME";
  public final static  String S_RowsNum = "ROWS_NUM";
  public final static  String S_ForwardUrl = "FORWARD_URL";
  public final static  String S_MatchType = "MATCH_TYPE";
  public final static  String S_ScreenHeight = "SCREEN_HEIGHT";
  public final static  String S_UaCode = "UA_CODE";
  public final static  String S_ModelName = "MODEL_NAME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public UserAgentAdapterBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initColumnsNum(long value){
     this.initProperty(S_ColumnsNum,new Long(value));
  }
  public  void setColumnsNum(long value){
     this.set(S_ColumnsNum,new Long(value));
  }
  public  void setColumnsNumNull(){
     this.set(S_ColumnsNum,null);
  }

  public long getColumnsNum(){
        return DataType.getAsLong(this.get(S_ColumnsNum));
  
  }
  public long getColumnsNumInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ColumnsNum));
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

  public void initWapSupport(String value){
     this.initProperty(S_WapSupport,value);
  }
  public  void setWapSupport(String value){
     this.set(S_WapSupport,value);
  }
  public  void setWapSupportNull(){
     this.set(S_WapSupport,null);
  }

  public String getWapSupport(){
       return DataType.getAsString(this.get(S_WapSupport));
  
  }
  public String getWapSupportInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WapSupport));
      }

  public void initPriority(long value){
     this.initProperty(S_Priority,new Long(value));
  }
  public  void setPriority(long value){
     this.set(S_Priority,new Long(value));
  }
  public  void setPriorityNull(){
     this.set(S_Priority,null);
  }

  public long getPriority(){
        return DataType.getAsLong(this.get(S_Priority));
  
  }
  public long getPriorityInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Priority));
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

  public void initBrandName(String value){
     this.initProperty(S_BrandName,value);
  }
  public  void setBrandName(String value){
     this.set(S_BrandName,value);
  }
  public  void setBrandNameNull(){
     this.set(S_BrandName,null);
  }

  public String getBrandName(){
       return DataType.getAsString(this.get(S_BrandName));
  
  }
  public String getBrandNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BrandName));
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

  public void initRowsNum(long value){
     this.initProperty(S_RowsNum,new Long(value));
  }
  public  void setRowsNum(long value){
     this.set(S_RowsNum,new Long(value));
  }
  public  void setRowsNumNull(){
     this.set(S_RowsNum,null);
  }

  public long getRowsNum(){
        return DataType.getAsLong(this.get(S_RowsNum));
  
  }
  public long getRowsNumInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RowsNum));
      }

  public void initForwardUrl(String value){
     this.initProperty(S_ForwardUrl,value);
  }
  public  void setForwardUrl(String value){
     this.set(S_ForwardUrl,value);
  }
  public  void setForwardUrlNull(){
     this.set(S_ForwardUrl,null);
  }

  public String getForwardUrl(){
       return DataType.getAsString(this.get(S_ForwardUrl));
  
  }
  public String getForwardUrlInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ForwardUrl));
      }

  public void initMatchType(String value){
     this.initProperty(S_MatchType,value);
  }
  public  void setMatchType(String value){
     this.set(S_MatchType,value);
  }
  public  void setMatchTypeNull(){
     this.set(S_MatchType,null);
  }

  public String getMatchType(){
       return DataType.getAsString(this.get(S_MatchType));
  
  }
  public String getMatchTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MatchType));
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

  public void initModelName(String value){
     this.initProperty(S_ModelName,value);
  }
  public  void setModelName(String value){
     this.set(S_ModelName,value);
  }
  public  void setModelNameNull(){
     this.set(S_ModelName,null);
  }

  public String getModelName(){
       return DataType.getAsString(this.get(S_ModelName));
  
  }
  public String getModelNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ModelName));
      }


 
 }

