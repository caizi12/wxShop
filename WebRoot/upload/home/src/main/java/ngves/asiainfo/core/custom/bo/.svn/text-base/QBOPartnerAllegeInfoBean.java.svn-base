package ngves.asiainfo.core.custom.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.custom.ivalues.*;

public class QBOPartnerAllegeInfoBean extends DataContainer implements DataContainerInterface,
		IQBOPartnerAllegeInfoValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.custom.bo.QBOPartnerAllegeInfo";

	public final static String S_DealTpId = "DEAL_TP_ID";
	public final static String S_AllegeRespType = "ALLEGE_RESP_TYPE";
	public final static String S_OldOrderId = "OLD_ORDER_ID";
	public final static String S_ComTypeId = "COM_TYPE_ID";
	public final static String S_WareId = "WARE_ID";
	public final static String S_ExchgChannel = "EXCHG_CHANNEL";
	public final static String S_RespPartnerType = "RESP_PARTNER_TYPE";
	public final static String S_Indictseq = "INDICTSEQ";
	public final static String S_SendCity = "SEND_CITY";
	public final static String S_UserLevel = "USER_LEVEL";
	public final static String S_EndOpId = "END_OP_ID";
	public final static String S_ProcessTime = "PROCESS_TIME";
	public final static String S_CallingNum = "CALLING_NUM";
	public final static String S_ProvinceCode = "PROVINCE_CODE";
	public final static String S_RelateCcsId = "RELATE_CCS_ID";
	public final static String S_BakCol3 = "BAK_COL3";
	public final static String S_RespOpId = "RESP_OP_ID";
	public final static String S_BakCol2 = "BAK_COL2";
	public final static String S_BakCol1 = "BAK_COL1";
	public final static String S_DealDesc = "DEAL_DESC";
	public final static String S_UserProvince = "USER_PROVINCE";
	public final static String S_UserBrand = "USER_BRAND";
	public final static String S_UrgentName = "URGENT_NAME";
	public final static String S_AllegeId = "ALLEGE_ID";
	public final static String S_OverTime = "OVER_TIME";
	public final static String S_AllegeLxMethod = "ALLEGE_LX_METHOD";
	public final static String S_AllegeKindId = "ALLEGE_KIND_ID";
	public final static String S_RelatePostAddr = "RELATE_POST_ADDR";
	public final static String S_AllegeStatus = "ALLEGE_STATUS";
	public final static String S_RelateStoreId = "RELATE_STORE_ID";
	public final static String S_ExgbackWareFlag = "EXGBACK_WARE_FLAG";
	public final static String S_ContentTpId = "CONTENT_TP_ID";
	public final static String S_AcceptDesc = "ACCEPT_DESC";
	public final static String S_IndictStatus = "INDICT_STATUS";
	public final static String S_EmailAddr = "EMAIL_ADDR";
	public final static String S_AcceptDate = "ACCEPT_DATE";
	public final static String S_StatusTime = "STATUS_TIME";
	public final static String S_ExgbackOrderId = "EXGBACK_ORDER_ID";
	public final static String S_MobilePhoneNo = "MOBILE_PHONE_NO";
	public final static String S_AcceptOpId = "ACCEPT_OP_ID";
	public final static String S_OldSuborderId = "OLD_SUBORDER_ID";
	public final static String S_AllegeNote = "ALLEGE_NOTE";
	public final static String S_WareCode = "WARE_CODE";
	public final static String S_ExgbackOverTime = "EXGBACK_OVER_TIME";
	public final static String S_WareName = "WARE_NAME";
	public final static String S_AllegeResp = "ALLEGE_RESP";
	public final static String S_RespPartnerId = "RESP_PARTNER_ID";
	public final static String S_AllegeLevelId = "ALLEGE_LEVEL_ID";
	public final static String S_AcceptTypeId = "ACCEPT_TYPE_ID";
	public final static String S_AllegeParentKind = "ALLEGE_PARENT_KIND";
	public final static String S_ExgbackResp = "EXGBACK_RESP";
	public final static String S_RelateWlsId = "RELATE_WLS_ID";
	public final static String S_SendProvince = "SEND_PROVINCE";
	public final static String S_AllegeName = "ALLEGE_NAME";
	public final static String S_RelateGysId = "RELATE_GYS_ID";
	public final static String S_Curresp = "CURRESP";

	public QBOPartnerAllegeInfoBean() throws AIException {
		super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initDealTpId(long value) {
		this.initProperty(S_DealTpId, new Long(value));
	}

	public void setDealTpId(long value) {
		this.set(S_DealTpId, new Long(value));
	}

	public void setDealTpIdNull() {
		this.set(S_DealTpId, null);
	}

	public long getDealTpId() {
		return DataType.getAsLong(this.get(S_DealTpId));

	}

	public long getDealTpIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_DealTpId));
	}

	public void initAllegeRespType(String value) {
		this.initProperty(S_AllegeRespType, value);
	}

	public void setAllegeRespType(String value) {
		this.set(S_AllegeRespType, value);
	}

	public void setAllegeRespTypeNull() {
		this.set(S_AllegeRespType, null);
	}

	public String getAllegeRespType() {
		return DataType.getAsString(this.get(S_AllegeRespType));

	}

	public String getAllegeRespTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_AllegeRespType));
	}

	public void initOldOrderId(String value) {
		this.initProperty(S_OldOrderId, value);
	}

	public void setOldOrderId(String value) {
		this.set(S_OldOrderId, value);
	}

	public void setOldOrderIdNull() {
		this.set(S_OldOrderId, null);
	}

	public String getOldOrderId() {
		return DataType.getAsString(this.get(S_OldOrderId));

	}

	public String getOldOrderIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_OldOrderId));
	}

	public void initComTypeId(String value) {
		this.initProperty(S_ComTypeId, value);
	}

	public void setComTypeId(String value) {
		this.set(S_ComTypeId, value);
	}

	public void setComTypeIdNull() {
		this.set(S_ComTypeId, null);
	}

	public String getComTypeId() {
		return DataType.getAsString(this.get(S_ComTypeId));

	}

	public String getComTypeIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ComTypeId));
	}

	public void initWareId(long value) {
		this.initProperty(S_WareId, new Long(value));
	}

	public void setWareId(long value) {
		this.set(S_WareId, new Long(value));
	}

	public void setWareIdNull() {
		this.set(S_WareId, null);
	}

	public long getWareId() {
		return DataType.getAsLong(this.get(S_WareId));

	}

	public long getWareIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_WareId));
	}

	public void initExchgChannel(String value) {
		this.initProperty(S_ExchgChannel, value);
	}

	public void setExchgChannel(String value) {
		this.set(S_ExchgChannel, value);
	}

	public void setExchgChannelNull() {
		this.set(S_ExchgChannel, null);
	}

	public String getExchgChannel() {
		return DataType.getAsString(this.get(S_ExchgChannel));

	}

	public String getExchgChannelInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ExchgChannel));
	}

	public void initRespPartnerType(String value) {
		this.initProperty(S_RespPartnerType, value);
	}

	public void setRespPartnerType(String value) {
		this.set(S_RespPartnerType, value);
	}

	public void setRespPartnerTypeNull() {
		this.set(S_RespPartnerType, null);
	}

	public String getRespPartnerType() {
		return DataType.getAsString(this.get(S_RespPartnerType));

	}

	public String getRespPartnerTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_RespPartnerType));
	}

	public void initIndictseq(String value) {
		this.initProperty(S_Indictseq, value);
	}

	public void setIndictseq(String value) {
		this.set(S_Indictseq, value);
	}

	public void setIndictseqNull() {
		this.set(S_Indictseq, null);
	}

	public String getIndictseq() {
		return DataType.getAsString(this.get(S_Indictseq));

	}

	public String getIndictseqInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Indictseq));
	}

	public void initSendCity(String value) {
		this.initProperty(S_SendCity, value);
	}

	public void setSendCity(String value) {
		this.set(S_SendCity, value);
	}

	public void setSendCityNull() {
		this.set(S_SendCity, null);
	}

	public String getSendCity() {
		return DataType.getAsString(this.get(S_SendCity));

	}

	public String getSendCityInitialValue() {
		return DataType.getAsString(this.getOldObj(S_SendCity));
	}

	public void initUserLevel(String value) {
		this.initProperty(S_UserLevel, value);
	}

	public void setUserLevel(String value) {
		this.set(S_UserLevel, value);
	}

	public void setUserLevelNull() {
		this.set(S_UserLevel, null);
	}

	public String getUserLevel() {
		return DataType.getAsString(this.get(S_UserLevel));

	}

	public String getUserLevelInitialValue() {
		return DataType.getAsString(this.getOldObj(S_UserLevel));
	}

	public void initEndOpId(long value) {
		this.initProperty(S_EndOpId, new Long(value));
	}

	public void setEndOpId(long value) {
		this.set(S_EndOpId, new Long(value));
	}

	public void setEndOpIdNull() {
		this.set(S_EndOpId, null);
	}

	public long getEndOpId() {
		return DataType.getAsLong(this.get(S_EndOpId));

	}

	public long getEndOpIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_EndOpId));
	}

	public void initProcessTime(long value) {
		this.initProperty(S_ProcessTime, new Long(value));
	}

	public void setProcessTime(long value) {
		this.set(S_ProcessTime, new Long(value));
	}

	public void setProcessTimeNull() {
		this.set(S_ProcessTime, null);
	}

	public long getProcessTime() {
		return DataType.getAsLong(this.get(S_ProcessTime));

	}

	public long getProcessTimeInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_ProcessTime));
	}

	public void initCallingNum(long value) {
		this.initProperty(S_CallingNum, new Long(value));
	}

	public void setCallingNum(long value) {
		this.set(S_CallingNum, new Long(value));
	}

	public void setCallingNumNull() {
		this.set(S_CallingNum, null);
	}

	public long getCallingNum() {
		return DataType.getAsLong(this.get(S_CallingNum));

	}

	public long getCallingNumInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_CallingNum));
	}

	public void initProvinceCode(String value) {
		this.initProperty(S_ProvinceCode, value);
	}

	public void setProvinceCode(String value) {
		this.set(S_ProvinceCode, value);
	}

	public void setProvinceCodeNull() {
		this.set(S_ProvinceCode, null);
	}

	public String getProvinceCode() {
		return DataType.getAsString(this.get(S_ProvinceCode));

	}

	public String getProvinceCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ProvinceCode));
	}

	public void initRelateCcsId(long value) {
		this.initProperty(S_RelateCcsId, new Long(value));
	}

	public void setRelateCcsId(long value) {
		this.set(S_RelateCcsId, new Long(value));
	}

	public void setRelateCcsIdNull() {
		this.set(S_RelateCcsId, null);
	}

	public long getRelateCcsId() {
		return DataType.getAsLong(this.get(S_RelateCcsId));

	}

	public long getRelateCcsIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_RelateCcsId));
	}

	public void initBakCol3(String value) {
		this.initProperty(S_BakCol3, value);
	}

	public void setBakCol3(String value) {
		this.set(S_BakCol3, value);
	}

	public void setBakCol3Null() {
		this.set(S_BakCol3, null);
	}

	public String getBakCol3() {
		return DataType.getAsString(this.get(S_BakCol3));

	}

	public String getBakCol3InitialValue() {
		return DataType.getAsString(this.getOldObj(S_BakCol3));
	}

	public void initRespOpId(long value) {
		this.initProperty(S_RespOpId, new Long(value));
	}

	public void setRespOpId(long value) {
		this.set(S_RespOpId, new Long(value));
	}

	public void setRespOpIdNull() {
		this.set(S_RespOpId, null);
	}

	public long getRespOpId() {
		return DataType.getAsLong(this.get(S_RespOpId));

	}

	public long getRespOpIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_RespOpId));
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

	public void initBakCol1(long value) {
		this.initProperty(S_BakCol1, new Long(value));
	}

	public void setBakCol1(long value) {
		this.set(S_BakCol1, new Long(value));
	}

	public void setBakCol1Null() {
		this.set(S_BakCol1, null);
	}

	public long getBakCol1() {
		return DataType.getAsLong(this.get(S_BakCol1));

	}

	public long getBakCol1InitialValue() {
		return DataType.getAsLong(this.getOldObj(S_BakCol1));
	}

	public void initDealDesc(String value) {
		this.initProperty(S_DealDesc, value);
	}

	public void setDealDesc(String value) {
		this.set(S_DealDesc, value);
	}

	public void setDealDescNull() {
		this.set(S_DealDesc, null);
	}

	public String getDealDesc() {
		return DataType.getAsString(this.get(S_DealDesc));

	}

	public String getDealDescInitialValue() {
		return DataType.getAsString(this.getOldObj(S_DealDesc));
	}

	public void initUserProvince(String value) {
		this.initProperty(S_UserProvince, value);
	}

	public void setUserProvince(String value) {
		this.set(S_UserProvince, value);
	}

	public void setUserProvinceNull() {
		this.set(S_UserProvince, null);
	}

	public String getUserProvince() {
		return DataType.getAsString(this.get(S_UserProvince));

	}

	public String getUserProvinceInitialValue() {
		return DataType.getAsString(this.getOldObj(S_UserProvince));
	}

	public void initUserBrand(String value) {
		this.initProperty(S_UserBrand, value);
	}

	public void setUserBrand(String value) {
		this.set(S_UserBrand, value);
	}

	public void setUserBrandNull() {
		this.set(S_UserBrand, null);
	}

	public String getUserBrand() {
		return DataType.getAsString(this.get(S_UserBrand));

	}

	public String getUserBrandInitialValue() {
		return DataType.getAsString(this.getOldObj(S_UserBrand));
	}

	public void initUrgentName(String value) {
		this.initProperty(S_UrgentName, value);
	}

	public void setUrgentName(String value) {
		this.set(S_UrgentName, value);
	}

	public void setUrgentNameNull() {
		this.set(S_UrgentName, null);
	}

	public String getUrgentName() {
		return DataType.getAsString(this.get(S_UrgentName));

	}

	public String getUrgentNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_UrgentName));
	}

	public void initAllegeId(long value) {
		this.initProperty(S_AllegeId, new Long(value));
	}

	public void setAllegeId(long value) {
		this.set(S_AllegeId, new Long(value));
	}

	public void setAllegeIdNull() {
		this.set(S_AllegeId, null);
	}

	public long getAllegeId() {
		return DataType.getAsLong(this.get(S_AllegeId));

	}

	public long getAllegeIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_AllegeId));
	}

	public void initOverTime(long value) {
		this.initProperty(S_OverTime, new Long(value));
	}

	public void setOverTime(long value) {
		this.set(S_OverTime, new Long(value));
	}

	public void setOverTimeNull() {
		this.set(S_OverTime, null);
	}

	public long getOverTime() {
		return DataType.getAsLong(this.get(S_OverTime));

	}

	public long getOverTimeInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_OverTime));
	}

	public void initAllegeLxMethod(String value) {
		this.initProperty(S_AllegeLxMethod, value);
	}

	public void setAllegeLxMethod(String value) {
		this.set(S_AllegeLxMethod, value);
	}

	public void setAllegeLxMethodNull() {
		this.set(S_AllegeLxMethod, null);
	}

	public String getAllegeLxMethod() {
		return DataType.getAsString(this.get(S_AllegeLxMethod));

	}

	public String getAllegeLxMethodInitialValue() {
		return DataType.getAsString(this.getOldObj(S_AllegeLxMethod));
	}

	public void initAllegeKindId(String value) {
		this.initProperty(S_AllegeKindId, value);
	}

	public void setAllegeKindId(String value) {
		this.set(S_AllegeKindId, value);
	}

	public void setAllegeKindIdNull() {
		this.set(S_AllegeKindId, null);
	}

	public String getAllegeKindId() {
		return DataType.getAsString(this.get(S_AllegeKindId));

	}

	public String getAllegeKindIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_AllegeKindId));
	}

	public void initRelatePostAddr(String value) {
		this.initProperty(S_RelatePostAddr, value);
	}

	public void setRelatePostAddr(String value) {
		this.set(S_RelatePostAddr, value);
	}

	public void setRelatePostAddrNull() {
		this.set(S_RelatePostAddr, null);
	}

	public String getRelatePostAddr() {
		return DataType.getAsString(this.get(S_RelatePostAddr));

	}

	public String getRelatePostAddrInitialValue() {
		return DataType.getAsString(this.getOldObj(S_RelatePostAddr));
	}

	public void initAllegeStatus(String value) {
		this.initProperty(S_AllegeStatus, value);
	}

	public void setAllegeStatus(String value) {
		this.set(S_AllegeStatus, value);
	}

	public void setAllegeStatusNull() {
		this.set(S_AllegeStatus, null);
	}

	public String getAllegeStatus() {
		return DataType.getAsString(this.get(S_AllegeStatus));

	}

	public String getAllegeStatusInitialValue() {
		return DataType.getAsString(this.getOldObj(S_AllegeStatus));
	}

	public void initRelateStoreId(long value) {
		this.initProperty(S_RelateStoreId, new Long(value));
	}

	public void setRelateStoreId(long value) {
		this.set(S_RelateStoreId, new Long(value));
	}

	public void setRelateStoreIdNull() {
		this.set(S_RelateStoreId, null);
	}

	public long getRelateStoreId() {
		return DataType.getAsLong(this.get(S_RelateStoreId));

	}

	public long getRelateStoreIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_RelateStoreId));
	}

	public void initExgbackWareFlag(String value) {
		this.initProperty(S_ExgbackWareFlag, value);
	}

	public void setExgbackWareFlag(String value) {
		this.set(S_ExgbackWareFlag, value);
	}

	public void setExgbackWareFlagNull() {
		this.set(S_ExgbackWareFlag, null);
	}

	public String getExgbackWareFlag() {
		return DataType.getAsString(this.get(S_ExgbackWareFlag));

	}

	public String getExgbackWareFlagInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ExgbackWareFlag));
	}

	public void initContentTpId(long value) {
		this.initProperty(S_ContentTpId, new Long(value));
	}

	public void setContentTpId(long value) {
		this.set(S_ContentTpId, new Long(value));
	}

	public void setContentTpIdNull() {
		this.set(S_ContentTpId, null);
	}

	public long getContentTpId() {
		return DataType.getAsLong(this.get(S_ContentTpId));

	}

	public long getContentTpIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_ContentTpId));
	}

	public void initAcceptDesc(String value) {
		this.initProperty(S_AcceptDesc, value);
	}

	public void setAcceptDesc(String value) {
		this.set(S_AcceptDesc, value);
	}

	public void setAcceptDescNull() {
		this.set(S_AcceptDesc, null);
	}

	public String getAcceptDesc() {
		return DataType.getAsString(this.get(S_AcceptDesc));

	}

	public String getAcceptDescInitialValue() {
		return DataType.getAsString(this.getOldObj(S_AcceptDesc));
	}

	public void initIndictStatus(String value) {
		this.initProperty(S_IndictStatus, value);
	}

	public void setIndictStatus(String value) {
		this.set(S_IndictStatus, value);
	}

	public void setIndictStatusNull() {
		this.set(S_IndictStatus, null);
	}

	public String getIndictStatus() {
		return DataType.getAsString(this.get(S_IndictStatus));

	}

	public String getIndictStatusInitialValue() {
		return DataType.getAsString(this.getOldObj(S_IndictStatus));
	}

	public void initEmailAddr(String value) {
		this.initProperty(S_EmailAddr, value);
	}

	public void setEmailAddr(String value) {
		this.set(S_EmailAddr, value);
	}

	public void setEmailAddrNull() {
		this.set(S_EmailAddr, null);
	}

	public String getEmailAddr() {
		return DataType.getAsString(this.get(S_EmailAddr));

	}

	public String getEmailAddrInitialValue() {
		return DataType.getAsString(this.getOldObj(S_EmailAddr));
	}

	public void initAcceptDate(Timestamp value) {
		this.initProperty(S_AcceptDate, value);
	}

	public void setAcceptDate(Timestamp value) {
		this.set(S_AcceptDate, value);
	}

	public void setAcceptDateNull() {
		this.set(S_AcceptDate, null);
	}

	public Timestamp getAcceptDate() {
		return DataType.getAsDateTime(this.get(S_AcceptDate));

	}

	public Timestamp getAcceptDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_AcceptDate));
	}

	public void initStatusTime(Timestamp value) {
		this.initProperty(S_StatusTime, value);
	}

	public void setStatusTime(Timestamp value) {
		this.set(S_StatusTime, value);
	}

	public void setStatusTimeNull() {
		this.set(S_StatusTime, null);
	}

	public Timestamp getStatusTime() {
		return DataType.getAsDateTime(this.get(S_StatusTime));

	}

	public Timestamp getStatusTimeInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_StatusTime));
	}

	public void initExgbackOrderId(String value) {
		this.initProperty(S_ExgbackOrderId, value);
	}

	public void setExgbackOrderId(String value) {
		this.set(S_ExgbackOrderId, value);
	}

	public void setExgbackOrderIdNull() {
		this.set(S_ExgbackOrderId, null);
	}

	public String getExgbackOrderId() {
		return DataType.getAsString(this.get(S_ExgbackOrderId));

	}

	public String getExgbackOrderIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ExgbackOrderId));
	}

	public void initMobilePhoneNo(String value) {
		this.initProperty(S_MobilePhoneNo, value);
	}

	public void setMobilePhoneNo(String value) {
		this.set(S_MobilePhoneNo, value);
	}

	public void setMobilePhoneNoNull() {
		this.set(S_MobilePhoneNo, null);
	}

	public String getMobilePhoneNo() {
		return DataType.getAsString(this.get(S_MobilePhoneNo));

	}

	public String getMobilePhoneNoInitialValue() {
		return DataType.getAsString(this.getOldObj(S_MobilePhoneNo));
	}

	public void initAcceptOpId(long value) {
		this.initProperty(S_AcceptOpId, new Long(value));
	}

	public void setAcceptOpId(long value) {
		this.set(S_AcceptOpId, new Long(value));
	}

	public void setAcceptOpIdNull() {
		this.set(S_AcceptOpId, null);
	}

	public long getAcceptOpId() {
		return DataType.getAsLong(this.get(S_AcceptOpId));

	}

	public long getAcceptOpIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_AcceptOpId));
	}

	public void initOldSuborderId(String value) {
		this.initProperty(S_OldSuborderId, value);
	}

	public void setOldSuborderId(String value) {
		this.set(S_OldSuborderId, value);
	}

	public void setOldSuborderIdNull() {
		this.set(S_OldSuborderId, null);
	}

	public String getOldSuborderId() {
		return DataType.getAsString(this.get(S_OldSuborderId));

	}

	public String getOldSuborderIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_OldSuborderId));
	}

	public void initAllegeNote(String value) {
		this.initProperty(S_AllegeNote, value);
	}

	public void setAllegeNote(String value) {
		this.set(S_AllegeNote, value);
	}

	public void setAllegeNoteNull() {
		this.set(S_AllegeNote, null);
	}

	public String getAllegeNote() {
		return DataType.getAsString(this.get(S_AllegeNote));

	}

	public String getAllegeNoteInitialValue() {
		return DataType.getAsString(this.getOldObj(S_AllegeNote));
	}

	public void initWareCode(String value) {
		this.initProperty(S_WareCode, value);
	}

	public void setWareCode(String value) {
		this.set(S_WareCode, value);
	}

	public void setWareCodeNull() {
		this.set(S_WareCode, null);
	}

	public String getWareCode() {
		return DataType.getAsString(this.get(S_WareCode));

	}

	public String getWareCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_WareCode));
	}

	public void initExgbackOverTime(Timestamp value) {
		this.initProperty(S_ExgbackOverTime, value);
	}

	public void setExgbackOverTime(Timestamp value) {
		this.set(S_ExgbackOverTime, value);
	}

	public void setExgbackOverTimeNull() {
		this.set(S_ExgbackOverTime, null);
	}

	public Timestamp getExgbackOverTime() {
		return DataType.getAsDateTime(this.get(S_ExgbackOverTime));

	}

	public Timestamp getExgbackOverTimeInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_ExgbackOverTime));
	}

	public void initWareName(String value) {
		this.initProperty(S_WareName, value);
	}

	public void setWareName(String value) {
		this.set(S_WareName, value);
	}

	public void setWareNameNull() {
		this.set(S_WareName, null);
	}

	public String getWareName() {
		return DataType.getAsString(this.get(S_WareName));

	}

	public String getWareNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_WareName));
	}

	public void initAllegeResp(String value) {
		this.initProperty(S_AllegeResp, value);
	}

	public void setAllegeResp(String value) {
		this.set(S_AllegeResp, value);
	}

	public void setAllegeRespNull() {
		this.set(S_AllegeResp, null);
	}

	public String getAllegeResp() {
		return DataType.getAsString(this.get(S_AllegeResp));

	}

	public String getAllegeRespInitialValue() {
		return DataType.getAsString(this.getOldObj(S_AllegeResp));
	}

	public void initRespPartnerId(long value) {
		this.initProperty(S_RespPartnerId, new Long(value));
	}

	public void setRespPartnerId(long value) {
		this.set(S_RespPartnerId, new Long(value));
	}

	public void setRespPartnerIdNull() {
		this.set(S_RespPartnerId, null);
	}

	public long getRespPartnerId() {
		return DataType.getAsLong(this.get(S_RespPartnerId));

	}

	public long getRespPartnerIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_RespPartnerId));
	}

	public void initAllegeLevelId(String value) {
		this.initProperty(S_AllegeLevelId, value);
	}

	public void setAllegeLevelId(String value) {
		this.set(S_AllegeLevelId, value);
	}

	public void setAllegeLevelIdNull() {
		this.set(S_AllegeLevelId, null);
	}

	public String getAllegeLevelId() {
		return DataType.getAsString(this.get(S_AllegeLevelId));

	}

	public String getAllegeLevelIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_AllegeLevelId));
	}

	public void initAcceptTypeId(String value) {
		this.initProperty(S_AcceptTypeId, value);
	}

	public void setAcceptTypeId(String value) {
		this.set(S_AcceptTypeId, value);
	}

	public void setAcceptTypeIdNull() {
		this.set(S_AcceptTypeId, null);
	}

	public String getAcceptTypeId() {
		return DataType.getAsString(this.get(S_AcceptTypeId));

	}

	public String getAcceptTypeIdInitialValue() {
		return DataType.getAsString(this.getOldObj(S_AcceptTypeId));
	}

	public void initAllegeParentKind(String value) {
		this.initProperty(S_AllegeParentKind, value);
	}

	public void setAllegeParentKind(String value) {
		this.set(S_AllegeParentKind, value);
	}

	public void setAllegeParentKindNull() {
		this.set(S_AllegeParentKind, null);
	}

	public String getAllegeParentKind() {
		return DataType.getAsString(this.get(S_AllegeParentKind));

	}

	public String getAllegeParentKindInitialValue() {
		return DataType.getAsString(this.getOldObj(S_AllegeParentKind));
	}

	public void initExgbackResp(String value) {
		this.initProperty(S_ExgbackResp, value);
	}

	public void setExgbackResp(String value) {
		this.set(S_ExgbackResp, value);
	}

	public void setExgbackRespNull() {
		this.set(S_ExgbackResp, null);
	}

	public String getExgbackResp() {
		return DataType.getAsString(this.get(S_ExgbackResp));

	}

	public String getExgbackRespInitialValue() {
		return DataType.getAsString(this.getOldObj(S_ExgbackResp));
	}

	public void initRelateWlsId(long value) {
		this.initProperty(S_RelateWlsId, new Long(value));
	}

	public void setRelateWlsId(long value) {
		this.set(S_RelateWlsId, new Long(value));
	}

	public void setRelateWlsIdNull() {
		this.set(S_RelateWlsId, null);
	}

	public long getRelateWlsId() {
		return DataType.getAsLong(this.get(S_RelateWlsId));

	}

	public long getRelateWlsIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_RelateWlsId));
	}

	public void initSendProvince(String value) {
		this.initProperty(S_SendProvince, value);
	}

	public void setSendProvince(String value) {
		this.set(S_SendProvince, value);
	}

	public void setSendProvinceNull() {
		this.set(S_SendProvince, null);
	}

	public String getSendProvince() {
		return DataType.getAsString(this.get(S_SendProvince));

	}

	public String getSendProvinceInitialValue() {
		return DataType.getAsString(this.getOldObj(S_SendProvince));
	}

	public void initAllegeName(String value) {
		this.initProperty(S_AllegeName, value);
	}

	public void setAllegeName(String value) {
		this.set(S_AllegeName, value);
	}

	public void setAllegeNameNull() {
		this.set(S_AllegeName, null);
	}

	public String getAllegeName() {
		return DataType.getAsString(this.get(S_AllegeName));

	}

	public String getAllegeNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_AllegeName));
	}

	public void initRelateGysId(long value) {
		this.initProperty(S_RelateGysId, new Long(value));
	}

	public void setRelateGysId(long value) {
		this.set(S_RelateGysId, new Long(value));
	}

	public void setRelateGysIdNull() {
		this.set(S_RelateGysId, null);
	}

	public long getRelateGysId() {
		return DataType.getAsLong(this.get(S_RelateGysId));

	}

	public long getRelateGysIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_RelateGysId));
	}

	public void initCurresp(long value) {
		this.initProperty(S_Curresp, new Long(value));
	}

	public void setCurresp(long value) {
		this.set(S_Curresp, new Long(value));
	}

	public void setCurrespNull() {
		this.set(S_Curresp, null);
	}

	public long getCurresp() {
		return DataType.getAsLong(this.get(S_Curresp));

	}

	public long getCurrespInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_Curresp));
	}

}
