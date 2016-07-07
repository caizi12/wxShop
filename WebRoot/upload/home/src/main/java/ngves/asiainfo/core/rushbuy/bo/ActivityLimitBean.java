package ngves.asiainfo.core.rushbuy.bo;

import java.sql.*;
import ngves.asiainfo.core.rushbuy.ivalues.IActivityLimitValue;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

public class ActivityLimitBean extends DataContainer implements DataContainerInterface,IActivityLimitValue{

	private static final long serialVersionUID = -5254547766342163156L;



private static String  m_boName = "ngves.asiainfo.core.rushbuy.bo.ActivityLimit";



  public final static  String S_ActivityEndTime = "ACTIVITY_END_TIME";
  public final static  String S_BgPic = "BG_PIC";
  public final static  String S_AlGroupId = "AL_GROUP_ID";
  public final static  String S_ActivityId = "ACTIVITY_ID";
  public final static  String S_BgColor = "BG_COLOR";
  public final static  String S_AppVersion = "APP_VERSION";
  public final static  String S_ActivityStartTime = "ACTIVITY_START_TIME";
  public final static  String S_ActivityQuestion = "ACTIVITY_QUESTION";
  public final static  String S_ActivityPublicTime = "ACTIVITY_PUBLIC_TIME";
  public final static  String S_ActivityRule = "ACTIVITY_RULE";
  public final static  String S_MainPic = "MAIN_PIC";
  public final static  String S_ActivityState = "ACTIVITY_STATE";
  public final static  String S_ActivityPublicPartner = "ACTIVITY_PUBLIC_PARTNER";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_ActivityUrl = "ACTIVITY_URL";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_ActivityName = "ACTIVITY_NAME";
  public final static  String S_ActivityRecordPartner = "ACTIVITY_RECORD_PARTNER";
  public final static  String S_IsView = "IS_VIEW";
  public final static  String S_ActivityRecordTime = "ACTIVITY_RECORD_TIME";
  public final static String S_ActivityAction = "ACTIVITY_ACTION";
  public final static String S_WareBind = "WARE_BIND";
  public final static String S_PayType = "PAY_TYPE";
  public final static String S_PayTime = "PAY_TIME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public ActivityLimitBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initActivityEndTime(Timestamp value){
     this.initProperty(S_ActivityEndTime,value);
  }
  public  void setActivityEndTime(Timestamp value){
     this.set(S_ActivityEndTime,value);
  }
  public  void setActivityEndTimeNull(){
     this.set(S_ActivityEndTime,null);
  }

  public Timestamp getActivityEndTime(){
        return DataType.getAsDateTime(this.get(S_ActivityEndTime));

  }
  public Timestamp getActivityEndTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ActivityEndTime));
      }

  public void initBgPic(String value){
     this.initProperty(S_BgPic,value);
  }
  public  void setBgPic(String value){
     this.set(S_BgPic,value);
  }
  public  void setBgPicNull(){
     this.set(S_BgPic,null);
  }

  public String getBgPic(){
       return DataType.getAsString(this.get(S_BgPic));

  }
  public String getBgPicInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BgPic));
      }

  public void initAlGroupId(long value){
     this.initProperty(S_AlGroupId,new Long(value));
  }
  public  void setAlGroupId(long value){
     this.set(S_AlGroupId,new Long(value));
  }
  public  void setAlGroupIdNull(){
     this.set(S_AlGroupId,null);
  }

  public long getAlGroupId(){
        return DataType.getAsLong(this.get(S_AlGroupId));

  }
  public long getAlGroupIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AlGroupId));
      }

  public void initActivityId(long value){
     this.initProperty(S_ActivityId,new Long(value));
  }
  public  void setActivityId(long value){
     this.set(S_ActivityId,new Long(value));
  }
  public  void setActivityIdNull(){
     this.set(S_ActivityId,null);
  }

  public long getActivityId(){
        return DataType.getAsLong(this.get(S_ActivityId));

  }
  public long getActivityIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ActivityId));
      }

  public void initBgColor(String value){
     this.initProperty(S_BgColor,value);
  }
  public  void setBgColor(String value){
     this.set(S_BgColor,value);
  }
  public  void setBgColorNull(){
     this.set(S_BgColor,null);
  }

  public String getBgColor(){
       return DataType.getAsString(this.get(S_BgColor));

  }
  public String getBgColorInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BgColor));
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

  public void initActivityStartTime(Timestamp value){
     this.initProperty(S_ActivityStartTime,value);
  }
  public  void setActivityStartTime(Timestamp value){
     this.set(S_ActivityStartTime,value);
  }
  public  void setActivityStartTimeNull(){
     this.set(S_ActivityStartTime,null);
  }

  public Timestamp getActivityStartTime(){
        return DataType.getAsDateTime(this.get(S_ActivityStartTime));

  }
  public Timestamp getActivityStartTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ActivityStartTime));
      }

  public void initActivityQuestion(String value){
     this.initProperty(S_ActivityQuestion,value);
  }
  public  void setActivityQuestion(String value){
     this.set(S_ActivityQuestion,value);
  }
  public  void setActivityQuestionNull(){
     this.set(S_ActivityQuestion,null);
  }

  public String getActivityQuestion(){
       return DataType.getAsString(this.get(S_ActivityQuestion));

  }
  public String getActivityQuestionInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ActivityQuestion));
      }

  public void initActivityPublicTime(Timestamp value){
     this.initProperty(S_ActivityPublicTime,value);
  }
  public  void setActivityPublicTime(Timestamp value){
     this.set(S_ActivityPublicTime,value);
  }
  public  void setActivityPublicTimeNull(){
     this.set(S_ActivityPublicTime,null);
  }

  public Timestamp getActivityPublicTime(){
        return DataType.getAsDateTime(this.get(S_ActivityPublicTime));

  }
  public Timestamp getActivityPublicTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ActivityPublicTime));
      }

  public void initActivityRule(String value){
     this.initProperty(S_ActivityRule,value);
  }
  public  void setActivityRule(String value){
     this.set(S_ActivityRule,value);
  }
  public  void setActivityRuleNull(){
     this.set(S_ActivityRule,null);
  }

  public String getActivityRule(){
       return DataType.getAsString(this.get(S_ActivityRule));

  }
  public String getActivityRuleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ActivityRule));
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

  public void initActivityState(String value){
     this.initProperty(S_ActivityState,value);
  }
  public  void setActivityState(String value){
     this.set(S_ActivityState,value);
  }
  public  void setActivityStateNull(){
     this.set(S_ActivityState,null);
  }

  public String getActivityState(){
       return DataType.getAsString(this.get(S_ActivityState));

  }
  public String getActivityStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ActivityState));
      }
  public void initActivityAction(String value) {
		this.initProperty(S_ActivityAction, value);
	}

	public void setActivityAction(String value) {
		this.set(S_ActivityAction, value);
	}

	public void setActivityActionNull() {
		this.set(S_ActivityAction, null);
	}

	public String getActivityAction() {
		return DataType.getAsString(this.get(S_ActivityAction));

	}

	public String getActivityActionInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ActivityAction));
	}
  public void initActivityPublicPartner(String value){
     this.initProperty(S_ActivityPublicPartner,value);
  }
  public  void setActivityPublicPartner(String value){
     this.set(S_ActivityPublicPartner,value);
  }
  public  void setActivityPublicPartnerNull(){
     this.set(S_ActivityPublicPartner,null);
  }

  public String getActivityPublicPartner(){
       return DataType.getAsString(this.get(S_ActivityPublicPartner));

  }
  public String getActivityPublicPartnerInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ActivityPublicPartner));
      }
    public void initWareBind(String value) {
            this.initProperty(S_WareBind, value);
        }

        public void setWareBind(String value) {
            this.set(S_WareBind, value);
        }

        public void setWareBindNull() {
            this.set(S_WareBind, null);
        }

        public String getWareBind() {
            return DataType.getAsString(this.get(S_WareBind));

        }

        public String getWareBindInitialValue() {
            return DataType.getAsString(this.getOldObj(S_WareBind));
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
 public void initActivityResult(String value) {
		this.initProperty(S_ActivityResult, value);
	}

	public void setActivityResult(String value) {
		this.set(S_ActivityResult, value);
	}

	public void setActivityResultNull() {
		this.set(S_ActivityResult, null);
	}

	public String getActivityResult() {
		return DataType.getAsString(this.get(S_ActivityResult));

	}

	public String getActivityResultInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ActivityResult));
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

  public void initActivityUrl(String value){
     this.initProperty(S_ActivityUrl,value);
  }
  public  void setActivityUrl(String value){
     this.set(S_ActivityUrl,value);
  }
  public  void setActivityUrlNull(){
     this.set(S_ActivityUrl,null);
  }

  public String getActivityUrl(){
       return DataType.getAsString(this.get(S_ActivityUrl));

  }
  public String getActivityUrlInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ActivityUrl));
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

  public void initActivityName(String value){
     this.initProperty(S_ActivityName,value);
  }
  public  void setActivityName(String value){
     this.set(S_ActivityName,value);
  }
  public  void setActivityNameNull(){
     this.set(S_ActivityName,null);
  }

  public String getActivityName(){
       return DataType.getAsString(this.get(S_ActivityName));

  }
  public String getActivityNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ActivityName));
      }

  public void initActivityRecordPartner(String value){
     this.initProperty(S_ActivityRecordPartner,value);
  }
  public  void setActivityRecordPartner(String value){
     this.set(S_ActivityRecordPartner,value);
  }
  public  void setActivityRecordPartnerNull(){
     this.set(S_ActivityRecordPartner,null);
  }

  public String getActivityRecordPartner(){
       return DataType.getAsString(this.get(S_ActivityRecordPartner));

  }
  public String getActivityRecordPartnerInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ActivityRecordPartner));
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

  public void initActivityRecordTime(Timestamp value){
     this.initProperty(S_ActivityRecordTime,value);
  }
  public  void setActivityRecordTime(Timestamp value){
     this.set(S_ActivityRecordTime,value);
  }

    public boolean isView() {
        return getIsView() == null || !getIsView().trim().equals("0");
    }

    public  void setActivityRecordTimeNull(){
     this.set(S_ActivityRecordTime,null);
  }

  public Timestamp getActivityRecordTime(){
        return DataType.getAsDateTime(this.get(S_ActivityRecordTime));

  }
  public Timestamp getActivityRecordTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ActivityRecordTime));
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

	  public void initPayTime(String value){
		     this.initProperty(S_PayTime,value);
		  }
		  public  void setPayTime(String value){
		     this.set(S_PayTime,value);
		  }
		  public  void setPayTimeNull(){
		     this.set(S_PayTime,null);
		  }

		  public String getPayTime(){
		       return DataType.getAsString(this.get(S_PayTime));

		  }
		  public String getPayTimeInitialValue(){
		        return DataType.getAsString(this.getOldObj(S_PayTime));
	  }


 }
