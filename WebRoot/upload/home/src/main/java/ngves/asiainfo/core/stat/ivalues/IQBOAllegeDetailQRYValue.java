package ngves.asiainfo.core.stat.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IQBOAllegeDetailQRYValue extends DataStructInterface{

  public final static  String S_AllegeResp = "ALLEGE_RESP";
  public final static  String S_UserLevel = "USER_LEVEL";
  public final static  String S_BigKindName = "BIG_KIND_NAME";
  public final static  String S_SendProvince = "SEND_PROVINCE";
  public final static  String S_UserBrand = "USER_BRAND";
  public final static  String S_AllegeLevelName = "ALLEGE_LEVEL_NAME";
  public final static  String S_AllegeParentKind = "ALLEGE_PARENT_KIND";
  public final static  String S_RelateCcsName = "RELATE_CCS_NAME";
  public final static  String S_AcceptOpName = "ACCEPT_OP_NAME";
  public final static  String S_AcceptOpId = "ACCEPT_OP_ID";
  public final static  String S_AllegeRespName = "ALLEGE_RESP_NAME";
  public final static  String S_AllegeKindName = "ALLEGE_KIND_NAME";
  public final static  String S_AllegeName = "ALLEGE_NAME";
  public final static  String S_IndictStatusName = "INDICT_STATUS_NAME";
  public final static  String S_OldOrderId = "OLD_ORDER_ID";
  public final static  String S_OverTimeFlag = "OVER_TIME_FLAG";
  public final static  String S_ExgbackResp = "EXGBACK_RESP";
  public final static  String S_AcceptComType = "ACCEPT_COM_TYPE";
  public final static  String S_WareFirstKind = "WARE_FIRST_KIND";
  public final static  String S_WareKindParentId = "WARE_KIND_PARENT_ID";
  public final static  String S_ProvinceName = "PROVINCE_NAME";
  public final static  String S_RespOpName = "RESP_OP_NAME";
  public final static  String S_OldSuborderId = "OLD_SUBORDER_ID";
  public final static  String S_AcceptDesc = "ACCEPT_DESC";
  public final static  String S_RelateWlsName = "RELATE_WLS_NAME";
  public final static  String S_MobilePhoneNo = "MOBILE_PHONE_NO";
  public final static  String S_Indictseq = "INDICTSEQ";
  public final static  String S_RelatePostAddr = "RELATE_POST_ADDR";
  public final static  String S_WareKindId = "WARE_KIND_ID";
  public final static  String S_AllegeLevelId = "ALLEGE_LEVEL_ID";
  public final static  String S_KindName = "KIND_NAME";
  public final static  String S_AllegeStatus = "ALLEGE_STATUS";
  public final static  String S_RespOpId = "RESP_OP_ID";
  public final static  String S_AllegeKindId = "ALLEGE_KIND_ID";
  public final static  String S_ExchgChannelName = "EXCHG_CHANNEL_NAME";
  public final static  String S_CallingNum = "CALLING_NUM";
  public final static  String S_AllegeParentKindName = "ALLEGE_PARENT_KIND_NAME";
  public final static  String S_WareCode = "WARE_CODE";
  public final static  String S_AllegeStatusName = "ALLEGE_STATUS_NAME";
  public final static  String S_IndictStatus = "INDICT_STATUS";
  public final static  String S_ComTypeId = "COM_TYPE_ID";
  public final static  String S_RespPartnerTypeName = "RESP_PARTNER_TYPE_NAME";
  public final static  String S_RespPartnerId = "RESP_PARTNER_ID";
  public final static  String S_DealDesc = "DEAL_DESC";
  public final static  String S_AcceptDate = "ACCEPT_DATE";
  public final static  String S_RelateGysName = "RELATE_GYS_NAME";
  public final static  String S_WareFirstKindId = "WARE_FIRST_KIND_ID";
  public final static  String S_UserBrandCode = "USER_BRAND_CODE";
  public final static  String S_RespPartnerType = "RESP_PARTNER_TYPE";
  public final static  String S_AllegeLxMethod = "ALLEGE_LX_METHOD";
  public final static  String S_ExchgChannel = "EXCHG_CHANNEL";
  public final static  String S_OverTime = "OVER_TIME";
  public final static  String S_RespPartnerName = "RESP_PARTNER_NAME";
  public final static  String S_WareName = "WARE_NAME";
  public final static  String S_PartnerDeal = "PARTNER_DEAL";
  public final static  String S_ProvinceCode = "PROVINCE_CODE";
  public final static  String S_StatusTime = "STATUS_TIME";
  public final static  String S_AcceptTypeName = "ACCEPT_TYPE_NAME";

//增加礼品大类id和name
  public final static  String S_WareKindInfoId = "WARE_KIND_INFO_ID";
  public final static  String S_WareKindInfo = "WARE_KIND_INFO_NAME";

public long getWareKindInfoId();

public String getWareKindInfo();
	
public  void setWareKindInfoId(long value);
	
public  void setWareKindInfo(String value);

public String getAllegeResp();

public String getUserLevel();

public String getBigKindName();

public String getSendProvince();

public String getUserBrand();

public String getAllegeLevelName();

public String getAllegeParentKind();

public String getRelateCcsName();

public String getAcceptOpName();

public long getAcceptOpId();

public String getAllegeRespName();

public String getAllegeKindName();

public String getAllegeName();

public String getIndictStatusName();

public String getOldOrderId();

public String getOverTimeFlag();

public String getExgbackResp();

public String getAcceptComType();

public String getWareFirstKind();

public long getWareKindParentId();

public String getProvinceName();

public String getRespOpName();

public String getOldSuborderId();

public String getAcceptDesc();

public String getRelateWlsName();

public String getMobilePhoneNo();

public String getIndictseq();

public String getRelatePostAddr();

public long getWareKindId();

public String getAllegeLevelId();

public String getKindName();

public String getAllegeStatus();

public long getRespOpId();

public String getAllegeKindId();

public String getExchgChannelName();

public long getCallingNum();

public String getAllegeParentKindName();

public String getWareCode();

public String getAllegeStatusName();

public String getIndictStatus();

public String getComTypeId();

public String getRespPartnerTypeName();

public long getRespPartnerId();

public String getDealDesc();

public Timestamp getAcceptDate();

public String getRelateGysName();

public long getWareFirstKindId();

public String getUserBrandCode();

public String getRespPartnerType();

public String getAllegeLxMethod();

public String getExchgChannel();

public long getOverTime();

public String getRespPartnerName();

public String getWareName();

public String getPartnerDeal();

public String getProvinceCode();

public Timestamp getStatusTime();

public String getAcceptTypeName();


public  void setAllegeResp(String value);

public  void setUserLevel(String value);

public  void setBigKindName(String value);

public  void setSendProvince(String value);

public  void setUserBrand(String value);

public  void setAllegeLevelName(String value);

public  void setAllegeParentKind(String value);

public  void setRelateCcsName(String value);

public  void setAcceptOpName(String value);

public  void setAcceptOpId(long value);

public  void setAllegeRespName(String value);

public  void setAllegeKindName(String value);

public  void setAllegeName(String value);

public  void setIndictStatusName(String value);

public  void setOldOrderId(String value);

public  void setOverTimeFlag(String value);

public  void setExgbackResp(String value);

public  void setAcceptComType(String value);

public  void setWareFirstKind(String value);

public  void setWareKindParentId(long value);

public  void setProvinceName(String value);

public  void setRespOpName(String value);

public  void setOldSuborderId(String value);

public  void setAcceptDesc(String value);

public  void setRelateWlsName(String value);

public  void setMobilePhoneNo(String value);

public  void setIndictseq(String value);

public  void setRelatePostAddr(String value);

public  void setWareKindId(long value);

public  void setAllegeLevelId(String value);

public  void setKindName(String value);

public  void setAllegeStatus(String value);

public  void setRespOpId(long value);

public  void setAllegeKindId(String value);

public  void setExchgChannelName(String value);

public  void setCallingNum(long value);

public  void setAllegeParentKindName(String value);

public  void setWareCode(String value);

public  void setAllegeStatusName(String value);

public  void setIndictStatus(String value);

public  void setComTypeId(String value);

public  void setRespPartnerTypeName(String value);

public  void setRespPartnerId(long value);

public  void setDealDesc(String value);

public  void setAcceptDate(Timestamp value);

public  void setRelateGysName(String value);

public  void setWareFirstKindId(long value);

public  void setUserBrandCode(String value);

public  void setRespPartnerType(String value);

public  void setAllegeLxMethod(String value);

public  void setExchgChannel(String value);

public  void setOverTime(long value);

public  void setRespPartnerName(String value);

public  void setWareName(String value);

public  void setPartnerDeal(String value);

public  void setProvinceCode(String value);

public  void setStatusTime(Timestamp value);

public  void setAcceptTypeName(String value);
}
