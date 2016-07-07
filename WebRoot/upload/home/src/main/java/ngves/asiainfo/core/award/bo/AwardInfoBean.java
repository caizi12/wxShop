package ngves.asiainfo.core.award.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.award.ivalues.*;

public class AwardInfoBean extends DataContainer implements
		DataContainerInterface, IAwardInfoValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.award.bo.AwardInfo";

	public final static String S_StopGetTime = "STOP_GET_TIME";
	public final static String S_BakCol2 = "BAK_COL2";
	public final static String S_ShowNotWin = "SHOW_NOT_WIN";
	public final static String S_MaxCount = "MAX_COUNT";
	public final static String S_StartTime = "START_TIME";
	public final static String S_Status = "STATUS";
	public final static String S_RecordStaff = "RECORD_STAFF";
	public final static String S_PublishDate = "PUBLISH_DATE";
	public final static String S_BaseIntegral = "BASE_INTEGRAL";
	public final static String S_PulishStaff = "PULISH_STAFF";
	public final static String S_AwardId = "AWARD_ID";
	public final static String S_AwardDesc = "AWARD_DESC";
	public final static String S_BakCol = "BAK_COL";
	public final static String S_ExchangeChannel = "EXCHANGE_CHANNEL";
	public final static String S_AwardName = "AWARD_NAME";
	public final static String S_ContainNotWin = "CONTAIN_NOT_WIN";
	public final static String S_CreateDate = "CREATE_DATE";
	public final static String S_EndTime = "END_TIME";
	public final static String S_Url = "URL";
	public final static String S_BaseWareId = "BASE_WARE_ID";
	public final static String S_OneMaxCount = "ONE_MAX_COUNT";
	public final static String S_NowCount = "NOW_COUNT";
	public final static  String S_MainPic = "MAIN_PIC";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory()
					.getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public AwardInfoBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initStopGetTime(Timestamp value) {
		this.initProperty(S_StopGetTime, value);
	}

	public void setStopGetTime(Timestamp value) {
		this.set(S_StopGetTime, value);
	}

	public void setStopGetTimeNull() {
		this.set(S_StopGetTime, null);
	}

	public Timestamp getStopGetTime() {
		return DataType.getAsDateTime(this.get(S_StopGetTime));

	}

	public Timestamp getStopGetTimeInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_StopGetTime));
	}

	public void initBakCol2(String value) {
		this.initProperty(S_BakCol2, value);
	}

	public void setBakCol2(String value) {
		this.set(S_BakCol2, value);
	}

	public void setBakCol2Null() {
		this.set(S_BakCol2, null);
	}

	public String getBakCol2() {
		return DataType.getAsString(this.get(S_BakCol2));

	}

	public String getBakCol2InitialValue() {
		return DataType.getAsString(this.getOldObj(S_BakCol2));
	}

	public void initShowNotWin(String value) {
		this.initProperty(S_ShowNotWin, value);
	}

	public void setShowNotWin(String value) {
		this.set(S_ShowNotWin, value);
	}

	public void setShowNotWinNull() {
		this.set(S_ShowNotWin, null);
	}

	public String getShowNotWin() {
		return DataType.getAsString(this.get(S_ShowNotWin));

	}

	public String getShowNotWinInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ShowNotWin));
	}

	public void initMaxCount(long value) {
		this.initProperty(S_MaxCount, new Long(value));
	}

	public void setMaxCount(long value) {
		this.set(S_MaxCount, new Long(value));
	}

	public void setMaxCountNull() {
		this.set(S_MaxCount, null);
	}

	public long getMaxCount() {
		return DataType.getAsLong(this.get(S_MaxCount));

	}

	public long getMaxCountInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_MaxCount));
	}

	public void initStartTime(Timestamp value) {
		this.initProperty(S_StartTime, value);
	}

	public void setStartTime(Timestamp value) {
		this.set(S_StartTime, value);
	}

	public void setStartTimeNull() {
		this.set(S_StartTime, null);
	}

	public Timestamp getStartTime() {
		return DataType.getAsDateTime(this.get(S_StartTime));

	}

	public Timestamp getStartTimeInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_StartTime));
	}

	public void initStatus(String value) {
		this.initProperty(S_Status, value);
	}

	public void setStatus(String value) {
		this.set(S_Status, value);
	}

	public void setStatusNull() {
		this.set(S_Status, null);
	}

	public String getStatus() {
		return DataType.getAsString(this.get(S_Status));

	}

	public String getStatusInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Status));
	}

	public void initRecordStaff(String value) {
		this.initProperty(S_RecordStaff, value);
	}

	public void setRecordStaff(String value) {
		this.set(S_RecordStaff, value);
	}

	public void setRecordStaffNull() {
		this.set(S_RecordStaff, null);
	}

	public String getRecordStaff() {
		return DataType.getAsString(this.get(S_RecordStaff));

	}

	public String getRecordStaffInitialValue() {
		return DataType.getAsString(this.getOldObj(S_RecordStaff));
	}

	public void initPublishDate(Timestamp value) {
		this.initProperty(S_PublishDate, value);
	}

	public void setPublishDate(Timestamp value) {
		this.set(S_PublishDate, value);
	}

	public void setPublishDateNull() {
		this.set(S_PublishDate, null);
	}

	public Timestamp getPublishDate() {
		return DataType.getAsDateTime(this.get(S_PublishDate));

	}

	public Timestamp getPublishDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_PublishDate));
	}

	public void initBaseIntegral(long value) {
		this.initProperty(S_BaseIntegral, new Long(value));
	}

	public void setBaseIntegral(long value) {
		this.set(S_BaseIntegral, new Long(value));
	}

	public void setBaseIntegralNull() {
		this.set(S_BaseIntegral, null);
	}

	public long getBaseIntegral() {
		return DataType.getAsLong(this.get(S_BaseIntegral));

	}

	public long getBaseIntegralInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_BaseIntegral));
	}

	public void initPulishStaff(String value) {
		this.initProperty(S_PulishStaff, value);
	}

	public void setPulishStaff(String value) {
		this.set(S_PulishStaff, value);
	}

	public void setPulishStaffNull() {
		this.set(S_PulishStaff, null);
	}

	public String getPulishStaff() {
		return DataType.getAsString(this.get(S_PulishStaff));

	}

	public String getPulishStaffInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PulishStaff));
	}

	public void initAwardId(long value) {
		this.initProperty(S_AwardId, new Long(value));
	}

	public void setAwardId(long value) {
		this.set(S_AwardId, new Long(value));
	}

	public void setAwardIdNull() {
		this.set(S_AwardId, null);
	}

	public long getAwardId() {
		return DataType.getAsLong(this.get(S_AwardId));

	}

	public long getAwardIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_AwardId));
	}

	public void initAwardDesc(String value) {
		this.initProperty(S_AwardDesc, value);
	}

	public void setAwardDesc(String value) {
		this.set(S_AwardDesc, value);
	}

	public void setAwardDescNull() {
		this.set(S_AwardDesc, null);
	}

	public String getAwardDesc() {
		return DataType.getAsString(this.get(S_AwardDesc));

	}

	public String getAwardDescInitialValue() {
		return DataType.getAsString(this.getOldObj(S_AwardDesc));
	}

	public void initBakCol(String value) {
		this.initProperty(S_BakCol, value);
	}

	public void setBakCol(String value) {
		this.set(S_BakCol, value);
	}

	public void setBakColNull() {
		this.set(S_BakCol, null);
	}

	public String getBakCol() {
		return DataType.getAsString(this.get(S_BakCol));

	}

	public String getBakColInitialValue() {
		return DataType.getAsString(this.getOldObj(S_BakCol));
	}

	public void initExchangeChannel(String value) {
		this.initProperty(S_ExchangeChannel, value);
	}

	public void setExchangeChannel(String value) {
		this.set(S_ExchangeChannel, value);
	}

	public void setExchangeChannelNull() {
		this.set(S_ExchangeChannel, null);
	}

	public String getExchangeChannel() {
		return DataType.getAsString(this.get(S_ExchangeChannel));

	}

	public String getExchangeChannelInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ExchangeChannel));
	}

	public void initAwardName(String value) {
		this.initProperty(S_AwardName, value);
	}

	public void setAwardName(String value) {
		this.set(S_AwardName, value);
	}

	public void setAwardNameNull() {
		this.set(S_AwardName, null);
	}

	public String getAwardName() {
		return DataType.getAsString(this.get(S_AwardName));

	}

	public String getAwardNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_AwardName));
	}

	public void initContainNotWin(String value) {
		this.initProperty(S_ContainNotWin, value);
	}

	public void setContainNotWin(String value) {
		this.set(S_ContainNotWin, value);
	}

	public void setContainNotWinNull() {
		this.set(S_ContainNotWin, null);
	}

	public String getContainNotWin() {
		return DataType.getAsString(this.get(S_ContainNotWin));

	}

	public String getContainNotWinInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ContainNotWin));
	}

	public void initCreateDate(Timestamp value) {
		this.initProperty(S_CreateDate, value);
	}

	public void setCreateDate(Timestamp value) {
		this.set(S_CreateDate, value);
	}

	public void setCreateDateNull() {
		this.set(S_CreateDate, null);
	}

	public Timestamp getCreateDate() {
		return DataType.getAsDateTime(this.get(S_CreateDate));

	}

	public Timestamp getCreateDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_CreateDate));
	}

	public void initEndTime(Timestamp value) {
		this.initProperty(S_EndTime, value);
	}

	public void setEndTime(Timestamp value) {
		this.set(S_EndTime, value);
	}

	public void setEndTimeNull() {
		this.set(S_EndTime, null);
	}

	public Timestamp getEndTime() {
		return DataType.getAsDateTime(this.get(S_EndTime));

	}

	public Timestamp getEndTimeInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_EndTime));
	}

	public void initUrl(String value) {
		this.initProperty(S_Url, value);
	}

	public void setUrl(String value) {
		this.set(S_Url, value);
	}

	public void setUrlNull() {
		this.set(S_Url, null);
	}

	public String getUrl() {
		return DataType.getAsString(this.get(S_Url));

	}

	public String getUrlInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Url));
	}

	public void initBaseWareId(long value) {
		this.initProperty(S_BaseWareId, new Long(value));
	}

	public void setBaseWareId(long value) {
		this.set(S_BaseWareId, new Long(value));
	}

	public void setBaseWareIdNull() {
		this.set(S_BaseWareId, null);
	}

	public long getBaseWareId() {
		return DataType.getAsLong(this.get(S_BaseWareId));

	}

	public long getBaseWareIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_BaseWareId));
	}

	public void initOneMaxCount(long value) {
		this.initProperty(S_OneMaxCount, new Long(value));
	}

	public void setOneMaxCount(long value) {
		this.set(S_OneMaxCount, new Long(value));
	}

	public void setOneMaxCountNull() {
		this.set(S_OneMaxCount, null);
	}

	public long getOneMaxCount() {
		return DataType.getAsLong(this.get(S_OneMaxCount));

	}

	public long getOneMaxCountInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_OneMaxCount));
	}

	public void initNowCount(long value) {
		this.initProperty(S_NowCount, new Long(value));
	}

	public void setNowCount(long value) {
		this.set(S_NowCount, new Long(value));
	}

	public void setNowCountNull() {
		this.set(S_NowCount, null);
	}

	public long getNowCount() {
		return DataType.getAsLong(this.get(S_NowCount));

	}

	public long getNowCountInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_NowCount));
	}
	
	
	public void initMainPic(String value) {
		this.initProperty(S_MainPic, value);
	}

	public void setMainPic(String value) {
		this.set(S_MainPic, value);
	}

	public void setMainPicNull() {
		this.set(S_MainPic, null);
	}

	public String getMainPic() {
		return DataType.getAsString(this.get(S_MainPic));

	}

	public String getMainPicInitialValue() {
		return DataType.getAsString(this.getOldObj(S_MainPic));
	}


}
