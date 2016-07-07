package ngves.asiainfo.core.tuan.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.tuan.ivalues.*;

public class TuanInfoBean extends DataContainer implements DataContainerInterface,ITuanInfoValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 5022051279543198849L;



private static String  m_boName = "ngves.asiainfo.core.tuan.bo.TuanInfo";



  public final static  String S_PublishDate = "PUBLISH_DATE";
  public final static  String S_IsOrderMulti = "IS_ORDER_MULTI";
  public final static  String S_AppVersion = "APP_VERSION";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_MaxCount = "MAX_COUNT";
  public final static  String S_MinCount = "MIN_COUNT";
  public final static  String S_OneMaxCount = "ONE_MAX_COUNT";
  public final static  String S_MainPic = "MAIN_PIC";
  public final static  String S_IsAllProv = "IS_ALL_PROV";
  public final static  String S_EndTime = "END_TIME";
  public final static  String S_Status = "STATUS";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_StartTime = "START_TIME";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_TitleDesc = "TITLE_DESC";
  public final static  String S_Url = "URL";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_Name = "NAME";
  public final static  String S_PublishStaff = "PUBLISH_STAFF";
  public final static  String S_IsView = "IS_VIEW";
  public final static  String S_RecordStaff = "RECORD_STAFF";
  public final static  String S_TuanId = "TUAN_ID";
  public final static  String S_TopFlag = "TOP_FLAG";
  
  // 增加团购排序字段
  public final static  String S_TuanSort = "TUAN_SORT";
  
  //新增活动支付方式和活动支付时长
  public final static String S_PayType="PAY_TYPE";
  public final static String S_PayTime="PAY_TIME";
  
  public TuanInfoBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initPublishDate(Timestamp value){
     this.initProperty(S_PublishDate,value);
  }
  public  void setPublishDate(Timestamp value){
     this.set(S_PublishDate,value);
  }
  public  void setPublishDateNull(){
     this.set(S_PublishDate,null);
  }

  public Timestamp getPublishDate(){
        return DataType.getAsDateTime(this.get(S_PublishDate));
  
  }
  public Timestamp getPublishDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_PublishDate));
      }

  public void initIsOrderMulti(String value){
     this.initProperty(S_IsOrderMulti,value);
  }
  public  void setIsOrderMulti(String value){
     this.set(S_IsOrderMulti,value);
  }
  public  void setIsOrderMultiNull(){
     this.set(S_IsOrderMulti,null);
  }

  public String getIsOrderMulti(){
       return DataType.getAsString(this.get(S_IsOrderMulti));
  
  }
  public String getIsOrderMultiInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsOrderMulti));
      }

  public void initAppVersion(long value){
     this.initProperty(S_AppVersion,new Long(value));
  }
  public  void setAppVersion(long value){
     this.set(S_AppVersion,new Long(value));
  }
  public  void setAppVersionNull(){
     this.set(S_AppVersion,null);
  }

  public long getAppVersion(){
        return DataType.getAsLong(this.get(S_AppVersion));
  
  }
  public long getAppVersionInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AppVersion));
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

  public void initMaxCount(long value){
     this.initProperty(S_MaxCount,new Long(value));
  }
  public  void setMaxCount(long value){
     this.set(S_MaxCount,new Long(value));
  }
  public  void setMaxCountNull(){
     this.set(S_MaxCount,null);
  }

  public long getMaxCount(){
        return DataType.getAsLong(this.get(S_MaxCount));
  
  }
  public long getMaxCountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_MaxCount));
      }

  public void initMinCount(long value){
     this.initProperty(S_MinCount,new Long(value));
  }
  public  void setMinCount(long value){
     this.set(S_MinCount,new Long(value));
  }
  public  void setMinCountNull(){
     this.set(S_MinCount,null);
  }

  public long getMinCount(){
        return DataType.getAsLong(this.get(S_MinCount));
  
  }
  public long getMinCountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_MinCount));
      }

  public void initOneMaxCount(long value){
     this.initProperty(S_OneMaxCount,new Long(value));
  }
  public  void setOneMaxCount(long value){
     this.set(S_OneMaxCount,new Long(value));
  }
  public  void setOneMaxCountNull(){
     this.set(S_OneMaxCount,null);
  }

  public long getOneMaxCount(){
        return DataType.getAsLong(this.get(S_OneMaxCount));
  
  }
  public long getOneMaxCountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OneMaxCount));
      }

  public void initMainPic(String value){
     this.initProperty(S_MainPic,value);
  }
  public  void setMainPic(String value){
     this.set(S_MainPic,value);
  }
  public  void setMainPicNull(){
     this.set(S_MainPic,null);
  }

  public String getMainPic(){
       return DataType.getAsString(this.get(S_MainPic));
  
  }
  public String getMainPicInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MainPic));
      }

  public void initIsAllProv(String value){
     this.initProperty(S_IsAllProv,value);
  }
  public  void setIsAllProv(String value){
     this.set(S_IsAllProv,value);
  }
  public  void setIsAllProvNull(){
     this.set(S_IsAllProv,null);
  }

  public String getIsAllProv(){
       return DataType.getAsString(this.get(S_IsAllProv));
  
  }
  public String getIsAllProvInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsAllProv));
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

  public void initStatus(String value){
     this.initProperty(S_Status,value);
  }
  public  void setStatus(String value){
     this.set(S_Status,value);
  }
  public  void setStatusNull(){
     this.set(S_Status,null);
  }

  public String getStatus(){
       return DataType.getAsString(this.get(S_Status));
  
  }
  public String getStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Status));
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

  public void initStartTime(Timestamp value){
     this.initProperty(S_StartTime,value);
  }
  public  void setStartTime(Timestamp value){
     this.set(S_StartTime,value);
  }
  public  void setStartTimeNull(){
     this.set(S_StartTime,null);
  }

  public Timestamp getStartTime(){
        return DataType.getAsDateTime(this.get(S_StartTime));
  
  }
  public Timestamp getStartTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_StartTime));
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

  public void initTitleDesc(String value){
     this.initProperty(S_TitleDesc,value);
  }
  public  void setTitleDesc(String value){
     this.set(S_TitleDesc,value);
  }
  public  void setTitleDescNull(){
     this.set(S_TitleDesc,null);
  }

  public String getTitleDesc(){
       return DataType.getAsString(this.get(S_TitleDesc));
  
  }
  public String getTitleDescInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TitleDesc));
      }

  public void initUrl(String value){
     this.initProperty(S_Url,value);
  }
  public  void setUrl(String value){
     this.set(S_Url,value);
  }
  public  void setUrlNull(){
     this.set(S_Url,null);
  }

  public String getUrl(){
       return DataType.getAsString(this.get(S_Url));
  
  }
  public String getUrlInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Url));
      }

  public void initBakCol3(String value){
     this.initProperty(S_BakCol3,value);
  }
  public  void setBakCol3(String value){
     this.set(S_BakCol3,value);
  }
  public  void setBakCol3Null(){
     this.set(S_BakCol3,null);
  }

  public String getBakCol3(){
       return DataType.getAsString(this.get(S_BakCol3));
  
  }
  public String getBakCol3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_BakCol3));
      }

  public void initName(String value){
     this.initProperty(S_Name,value);
  }
  public  void setName(String value){
     this.set(S_Name,value);
  }
  public  void setNameNull(){
     this.set(S_Name,null);
  }

  public String getName(){
       return DataType.getAsString(this.get(S_Name));
  
  }
  public String getNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Name));
      }

  public void initPublishStaff(String value){
     this.initProperty(S_PublishStaff,value);
  }
  public  void setPublishStaff(String value){
     this.set(S_PublishStaff,value);
  }
  public  void setPublishStaffNull(){
     this.set(S_PublishStaff,null);
  }

  public String getPublishStaff(){
       return DataType.getAsString(this.get(S_PublishStaff));
  
  }
  public String getPublishStaffInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PublishStaff));
      }

  public void initIsView(String value){
     this.initProperty(S_IsView,value);
  }
  public  void setIsView(String value){
     this.set(S_IsView,value);
  }
  public  void setIsViewNull(){
     this.set(S_IsView,null);
  }

  public String getIsView(){
       return DataType.getAsString(this.get(S_IsView));
  
  }
  public String getIsViewInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsView));
      }

  public void initRecordStaff(String value){
     this.initProperty(S_RecordStaff,value);
  }
  public  void setRecordStaff(String value){
     this.set(S_RecordStaff,value);
  }
  public  void setRecordStaffNull(){
     this.set(S_RecordStaff,null);
  }

  public String getRecordStaff(){
       return DataType.getAsString(this.get(S_RecordStaff));
  
  }
  public String getRecordStaffInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RecordStaff));
      }

  public void initTuanId(long value){
     this.initProperty(S_TuanId,new Long(value));
  }
  public  void setTuanId(long value){
     this.set(S_TuanId,new Long(value));
  }
  public  void setTuanIdNull(){
     this.set(S_TuanId,null);
  }

  public long getTuanId(){
        return DataType.getAsLong(this.get(S_TuanId));
  
  }
  public long getTuanIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TuanId));
      }


  public void initTuanSort(long value){
	     this.initProperty(S_TuanSort,new Long(value));
	  }
	  public  void setTuanSort(long value){
	     this.set(S_TuanSort,new Long(value));
	  }
	  public  void setTuanSortNull(){
	     this.set(S_TuanSort,null);
	  }

	  public long getTuanSort(){
	        return DataType.getAsLong(this.get(S_TuanSort));
	  
	  }
	  public long getTuanSortInitialValue(){
	        return DataType.getAsLong(this.getOldObj(S_TuanSort));
	      }
	  
	  public void initTopFlag(long value){
	     this.initProperty(S_TopFlag,new Long(value));
	  }
	  public  void setTopFlag(long value){
	     this.set(S_TopFlag,new Long(value));
	  }
	  public  void setTopFlagNull(){
	     this.set(S_TopFlag,null);
	  }

	  public long getTopFlag(){
	        return DataType.getAsLong(this.get(S_TopFlag));
	  
	  }
	  public long getTopFlagInitialValue(){
	        return DataType.getAsLong(this.getOldObj(S_TopFlag));
	      }
	  public void initPayType(String value){
		     this.initProperty(S_PayType,value);
	  }
	  public  void setPayType(String value){
	     this.set(S_PayType,value);
	  }
	  public  void setPayTypeNull(){
	     this.set(S_PayType,null);
	  }

	  public String getPayType(){
	       return DataType.getAsString(this.get(S_PayType));
	  }
	  public String getPayTypeInitialValue(){
	        return DataType.getAsString(this.getOldObj(S_PayType));
	      }
	  public void initPayTime(long value){
		     this.initProperty(S_PayTime,new Long(value));
		  }
		  public  void setPayTime(long value){
		     this.set(S_PayTime,new Long(value));
		  }
		  public  void setPayTimeNull(){
		     this.set(S_PayTime,null);
		  }

		  public long getPayTime(){
		        return DataType.getAsLong(this.get(S_PayTime));
		  
		  }
		  public long getPayTimeInitialValue(){
		        return DataType.getAsLong(this.getOldObj(S_PayTime));
		      }


 }

