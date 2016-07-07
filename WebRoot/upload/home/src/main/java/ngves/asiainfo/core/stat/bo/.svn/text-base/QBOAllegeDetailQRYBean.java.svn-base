package ngves.asiainfo.core.stat.bo;

import java.sql.*;

import ngves.asiainfo.core.stat.ivalues.IQBOAllegeDetailQRYValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;


public class QBOAllegeDetailQRYBean extends DataContainer implements DataContainerInterface,IQBOAllegeDetailQRYValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.stat.bo.QBOAllegeDetailQRY";



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
	 

  public void initWareKindInfoId(long value){
	  this.initProperty(S_WareKindInfoId,new Long(value));
  }
  public  void setWareKindInfoId(long value){
	  this.set(S_WareKindInfoId,new Long(value));
  }
  public  void setWareKindInfoIdNull(){
	  this.set(S_WareKindInfoId,null);
  }

  public long getWareKindInfoId(){
	  return DataType.getAsLong(this.get(S_WareKindInfoId));
  }
  public long getWareKindInfoIdInitialValue(){
	  return DataType.getAsLong(this.getOldObj(S_WareKindInfoId));
  }

  public void initWareKindInfo(String value){
	  this.initProperty(S_WareKindInfo,value);
  }
  public  void setWareKindInfo(String value){
	  this.set(S_WareKindInfo,value);
  }
  public  void setWareKindInfoNull(){
	  this.set(S_WareKindInfo,null);
  }

  public String getWareKindInfo(){
	  return DataType.getAsString(this.get(S_WareKindInfo));
  }
  public String getWareKindInfoInitialValue(){
	  return DataType.getAsString(this.getOldObj(S_WareKindInfo));
  }
  
  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBOAllegeDetailQRYBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initAllegeResp(String value){
     this.initProperty(S_AllegeResp,value);
  }
  public  void setAllegeResp(String value){
     this.set(S_AllegeResp,value);
  }
  public  void setAllegeRespNull(){
     this.set(S_AllegeResp,null);
  }

  public String getAllegeResp(){
       return DataType.getAsString(this.get(S_AllegeResp));
  
  }
  public String getAllegeRespInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AllegeResp));
      }

  public void initUserLevel(String value){
     this.initProperty(S_UserLevel,value);
  }
  public  void setUserLevel(String value){
     this.set(S_UserLevel,value);
  }
  public  void setUserLevelNull(){
     this.set(S_UserLevel,null);
  }

  public String getUserLevel(){
       return DataType.getAsString(this.get(S_UserLevel));
  
  }
  public String getUserLevelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_UserLevel));
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

  public void initSendProvince(String value){
     this.initProperty(S_SendProvince,value);
  }
  public  void setSendProvince(String value){
     this.set(S_SendProvince,value);
  }
  public  void setSendProvinceNull(){
     this.set(S_SendProvince,null);
  }

  public String getSendProvince(){
       return DataType.getAsString(this.get(S_SendProvince));
  
  }
  public String getSendProvinceInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SendProvince));
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

  public void initAllegeLevelName(String value){
     this.initProperty(S_AllegeLevelName,value);
  }
  public  void setAllegeLevelName(String value){
     this.set(S_AllegeLevelName,value);
  }
  public  void setAllegeLevelNameNull(){
     this.set(S_AllegeLevelName,null);
  }

  public String getAllegeLevelName(){
       return DataType.getAsString(this.get(S_AllegeLevelName));
  
  }
  public String getAllegeLevelNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AllegeLevelName));
      }

  public void initAllegeParentKind(String value){
     this.initProperty(S_AllegeParentKind,value);
  }
  public  void setAllegeParentKind(String value){
     this.set(S_AllegeParentKind,value);
  }
  public  void setAllegeParentKindNull(){
     this.set(S_AllegeParentKind,null);
  }

  public String getAllegeParentKind(){
       return DataType.getAsString(this.get(S_AllegeParentKind));
  
  }
  public String getAllegeParentKindInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AllegeParentKind));
      }

  public void initRelateCcsName(String value){
     this.initProperty(S_RelateCcsName,value);
  }
  public  void setRelateCcsName(String value){
     this.set(S_RelateCcsName,value);
  }
  public  void setRelateCcsNameNull(){
     this.set(S_RelateCcsName,null);
  }

  public String getRelateCcsName(){
       return DataType.getAsString(this.get(S_RelateCcsName));
  
  }
  public String getRelateCcsNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RelateCcsName));
      }

  public void initAcceptOpName(String value){
     this.initProperty(S_AcceptOpName,value);
  }
  public  void setAcceptOpName(String value){
     this.set(S_AcceptOpName,value);
  }
  public  void setAcceptOpNameNull(){
     this.set(S_AcceptOpName,null);
  }

  public String getAcceptOpName(){
       return DataType.getAsString(this.get(S_AcceptOpName));
  
  }
  public String getAcceptOpNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AcceptOpName));
      }

  public void initAcceptOpId(long value){
     this.initProperty(S_AcceptOpId,new Long(value));
  }
  public  void setAcceptOpId(long value){
     this.set(S_AcceptOpId,new Long(value));
  }
  public  void setAcceptOpIdNull(){
     this.set(S_AcceptOpId,null);
  }

  public long getAcceptOpId(){
        return DataType.getAsLong(this.get(S_AcceptOpId));
  
  }
  public long getAcceptOpIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AcceptOpId));
      }

  public void initAllegeRespName(String value){
     this.initProperty(S_AllegeRespName,value);
  }
  public  void setAllegeRespName(String value){
     this.set(S_AllegeRespName,value);
  }
  public  void setAllegeRespNameNull(){
     this.set(S_AllegeRespName,null);
  }

  public String getAllegeRespName(){
       return DataType.getAsString(this.get(S_AllegeRespName));
  
  }
  public String getAllegeRespNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AllegeRespName));
      }

  public void initAllegeKindName(String value){
     this.initProperty(S_AllegeKindName,value);
  }
  public  void setAllegeKindName(String value){
     this.set(S_AllegeKindName,value);
  }
  public  void setAllegeKindNameNull(){
     this.set(S_AllegeKindName,null);
  }

  public String getAllegeKindName(){
       return DataType.getAsString(this.get(S_AllegeKindName));
  
  }
  public String getAllegeKindNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AllegeKindName));
      }

  public void initAllegeName(String value){
     this.initProperty(S_AllegeName,value);
  }
  public  void setAllegeName(String value){
     this.set(S_AllegeName,value);
  }
  public  void setAllegeNameNull(){
     this.set(S_AllegeName,null);
  }

  public String getAllegeName(){
       return DataType.getAsString(this.get(S_AllegeName));
  
  }
  public String getAllegeNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AllegeName));
      }

  public void initIndictStatusName(String value){
     this.initProperty(S_IndictStatusName,value);
  }
  public  void setIndictStatusName(String value){
     this.set(S_IndictStatusName,value);
  }
  public  void setIndictStatusNameNull(){
     this.set(S_IndictStatusName,null);
  }

  public String getIndictStatusName(){
       return DataType.getAsString(this.get(S_IndictStatusName));
  
  }
  public String getIndictStatusNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IndictStatusName));
      }

  public void initOldOrderId(String value){
     this.initProperty(S_OldOrderId,value);
  }
  public  void setOldOrderId(String value){
     this.set(S_OldOrderId,value);
  }
  public  void setOldOrderIdNull(){
     this.set(S_OldOrderId,null);
  }

  public String getOldOrderId(){
       return DataType.getAsString(this.get(S_OldOrderId));
  
  }
  public String getOldOrderIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OldOrderId));
      }

  public void initOverTimeFlag(String value){
     this.initProperty(S_OverTimeFlag,value);
  }
  public  void setOverTimeFlag(String value){
     this.set(S_OverTimeFlag,value);
  }
  public  void setOverTimeFlagNull(){
     this.set(S_OverTimeFlag,null);
  }

  public String getOverTimeFlag(){
       return DataType.getAsString(this.get(S_OverTimeFlag));
  
  }
  public String getOverTimeFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OverTimeFlag));
      }

  public void initExgbackResp(String value){
     this.initProperty(S_ExgbackResp,value);
  }
  public  void setExgbackResp(String value){
     this.set(S_ExgbackResp,value);
  }
  public  void setExgbackRespNull(){
     this.set(S_ExgbackResp,null);
  }

  public String getExgbackResp(){
       return DataType.getAsString(this.get(S_ExgbackResp));
  
  }
  public String getExgbackRespInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExgbackResp));
      }

  public void initAcceptComType(String value){
     this.initProperty(S_AcceptComType,value);
  }
  public  void setAcceptComType(String value){
     this.set(S_AcceptComType,value);
  }
  public  void setAcceptComTypeNull(){
     this.set(S_AcceptComType,null);
  }

  public String getAcceptComType(){
       return DataType.getAsString(this.get(S_AcceptComType));
  
  }
  public String getAcceptComTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AcceptComType));
      }

  public void initWareFirstKind(String value){
     this.initProperty(S_WareFirstKind,value);
  }
  public  void setWareFirstKind(String value){
     this.set(S_WareFirstKind,value);
  }
  public  void setWareFirstKindNull(){
     this.set(S_WareFirstKind,null);
  }

  public String getWareFirstKind(){
       return DataType.getAsString(this.get(S_WareFirstKind));
  
  }
  public String getWareFirstKindInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WareFirstKind));
      }

  public void initWareKindParentId(long value){
     this.initProperty(S_WareKindParentId,new Long(value));
  }
  public  void setWareKindParentId(long value){
     this.set(S_WareKindParentId,new Long(value));
  }
  public  void setWareKindParentIdNull(){
     this.set(S_WareKindParentId,null);
  }

  public long getWareKindParentId(){
        return DataType.getAsLong(this.get(S_WareKindParentId));
  
  }
  public long getWareKindParentIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_WareKindParentId));
      }

  public void initProvinceName(String value){
     this.initProperty(S_ProvinceName,value);
  }
  public  void setProvinceName(String value){
     this.set(S_ProvinceName,value);
  }
  public  void setProvinceNameNull(){
     this.set(S_ProvinceName,null);
  }

  public String getProvinceName(){
       return DataType.getAsString(this.get(S_ProvinceName));
  
  }
  public String getProvinceNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProvinceName));
      }

  public void initRespOpName(String value){
     this.initProperty(S_RespOpName,value);
  }
  public  void setRespOpName(String value){
     this.set(S_RespOpName,value);
  }
  public  void setRespOpNameNull(){
     this.set(S_RespOpName,null);
  }

  public String getRespOpName(){
       return DataType.getAsString(this.get(S_RespOpName));
  
  }
  public String getRespOpNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RespOpName));
      }

  public void initOldSuborderId(String value){
     this.initProperty(S_OldSuborderId,value);
  }
  public  void setOldSuborderId(String value){
     this.set(S_OldSuborderId,value);
  }
  public  void setOldSuborderIdNull(){
     this.set(S_OldSuborderId,null);
  }

  public String getOldSuborderId(){
       return DataType.getAsString(this.get(S_OldSuborderId));
  
  }
  public String getOldSuborderIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OldSuborderId));
      }

  public void initAcceptDesc(String value){
     this.initProperty(S_AcceptDesc,value);
  }
  public  void setAcceptDesc(String value){
     this.set(S_AcceptDesc,value);
  }
  public  void setAcceptDescNull(){
     this.set(S_AcceptDesc,null);
  }

  public String getAcceptDesc(){
       return DataType.getAsString(this.get(S_AcceptDesc));
  
  }
  public String getAcceptDescInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AcceptDesc));
      }

  public void initRelateWlsName(String value){
     this.initProperty(S_RelateWlsName,value);
  }
  public  void setRelateWlsName(String value){
     this.set(S_RelateWlsName,value);
  }
  public  void setRelateWlsNameNull(){
     this.set(S_RelateWlsName,null);
  }

  public String getRelateWlsName(){
       return DataType.getAsString(this.get(S_RelateWlsName));
  
  }
  public String getRelateWlsNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RelateWlsName));
      }

  public void initMobilePhoneNo(String value){
     this.initProperty(S_MobilePhoneNo,value);
  }
  public  void setMobilePhoneNo(String value){
     this.set(S_MobilePhoneNo,value);
  }
  public  void setMobilePhoneNoNull(){
     this.set(S_MobilePhoneNo,null);
  }

  public String getMobilePhoneNo(){
       return DataType.getAsString(this.get(S_MobilePhoneNo));
  
  }
  public String getMobilePhoneNoInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MobilePhoneNo));
      }

  public void initIndictseq(String value){
     this.initProperty(S_Indictseq,value);
  }
  public  void setIndictseq(String value){
     this.set(S_Indictseq,value);
  }
  public  void setIndictseqNull(){
     this.set(S_Indictseq,null);
  }

  public String getIndictseq(){
       return DataType.getAsString(this.get(S_Indictseq));
  
  }
  public String getIndictseqInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Indictseq));
      }

  public void initRelatePostAddr(String value){
     this.initProperty(S_RelatePostAddr,value);
  }
  public  void setRelatePostAddr(String value){
     this.set(S_RelatePostAddr,value);
  }
  public  void setRelatePostAddrNull(){
     this.set(S_RelatePostAddr,null);
  }

  public String getRelatePostAddr(){
       return DataType.getAsString(this.get(S_RelatePostAddr));
  
  }
  public String getRelatePostAddrInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RelatePostAddr));
      }

  public void initWareKindId(long value){
     this.initProperty(S_WareKindId,new Long(value));
  }
  public  void setWareKindId(long value){
     this.set(S_WareKindId,new Long(value));
  }
  public  void setWareKindIdNull(){
     this.set(S_WareKindId,null);
  }

  public long getWareKindId(){
        return DataType.getAsLong(this.get(S_WareKindId));
  
  }
  public long getWareKindIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_WareKindId));
      }

  public void initAllegeLevelId(String value){
     this.initProperty(S_AllegeLevelId,value);
  }
  public  void setAllegeLevelId(String value){
     this.set(S_AllegeLevelId,value);
  }
  public  void setAllegeLevelIdNull(){
     this.set(S_AllegeLevelId,null);
  }

  public String getAllegeLevelId(){
       return DataType.getAsString(this.get(S_AllegeLevelId));
  
  }
  public String getAllegeLevelIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AllegeLevelId));
      }

  public void initKindName(String value){
     this.initProperty(S_KindName,value);
  }
  public  void setKindName(String value){
     this.set(S_KindName,value);
  }
  public  void setKindNameNull(){
     this.set(S_KindName,null);
  }

  public String getKindName(){
       return DataType.getAsString(this.get(S_KindName));
  
  }
  public String getKindNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_KindName));
      }

  public void initAllegeStatus(String value){
     this.initProperty(S_AllegeStatus,value);
  }
  public  void setAllegeStatus(String value){
     this.set(S_AllegeStatus,value);
  }
  public  void setAllegeStatusNull(){
     this.set(S_AllegeStatus,null);
  }

  public String getAllegeStatus(){
       return DataType.getAsString(this.get(S_AllegeStatus));
  
  }
  public String getAllegeStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AllegeStatus));
      }

  public void initRespOpId(long value){
     this.initProperty(S_RespOpId,new Long(value));
  }
  public  void setRespOpId(long value){
     this.set(S_RespOpId,new Long(value));
  }
  public  void setRespOpIdNull(){
     this.set(S_RespOpId,null);
  }

  public long getRespOpId(){
        return DataType.getAsLong(this.get(S_RespOpId));
  
  }
  public long getRespOpIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RespOpId));
      }

  public void initAllegeKindId(String value){
     this.initProperty(S_AllegeKindId,value);
  }
  public  void setAllegeKindId(String value){
     this.set(S_AllegeKindId,value);
  }
  public  void setAllegeKindIdNull(){
     this.set(S_AllegeKindId,null);
  }

  public String getAllegeKindId(){
       return DataType.getAsString(this.get(S_AllegeKindId));
  
  }
  public String getAllegeKindIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AllegeKindId));
      }

  public void initExchgChannelName(String value){
     this.initProperty(S_ExchgChannelName,value);
  }
  public  void setExchgChannelName(String value){
     this.set(S_ExchgChannelName,value);
  }
  public  void setExchgChannelNameNull(){
     this.set(S_ExchgChannelName,null);
  }

  public String getExchgChannelName(){
       return DataType.getAsString(this.get(S_ExchgChannelName));
  
  }
  public String getExchgChannelNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExchgChannelName));
      }

  public void initCallingNum(long value){
     this.initProperty(S_CallingNum,new Long(value));
  }
  public  void setCallingNum(long value){
     this.set(S_CallingNum,new Long(value));
  }
  public  void setCallingNumNull(){
     this.set(S_CallingNum,null);
  }

  public long getCallingNum(){
        return DataType.getAsLong(this.get(S_CallingNum));
  
  }
  public long getCallingNumInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_CallingNum));
      }

  public void initAllegeParentKindName(String value){
     this.initProperty(S_AllegeParentKindName,value);
  }
  public  void setAllegeParentKindName(String value){
     this.set(S_AllegeParentKindName,value);
  }
  public  void setAllegeParentKindNameNull(){
     this.set(S_AllegeParentKindName,null);
  }

  public String getAllegeParentKindName(){
       return DataType.getAsString(this.get(S_AllegeParentKindName));
  
  }
  public String getAllegeParentKindNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AllegeParentKindName));
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

  public void initAllegeStatusName(String value){
     this.initProperty(S_AllegeStatusName,value);
  }
  public  void setAllegeStatusName(String value){
     this.set(S_AllegeStatusName,value);
  }
  public  void setAllegeStatusNameNull(){
     this.set(S_AllegeStatusName,null);
  }

  public String getAllegeStatusName(){
       return DataType.getAsString(this.get(S_AllegeStatusName));
  
  }
  public String getAllegeStatusNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AllegeStatusName));
      }

  public void initIndictStatus(String value){
     this.initProperty(S_IndictStatus,value);
  }
  public  void setIndictStatus(String value){
     this.set(S_IndictStatus,value);
  }
  public  void setIndictStatusNull(){
     this.set(S_IndictStatus,null);
  }

  public String getIndictStatus(){
       return DataType.getAsString(this.get(S_IndictStatus));
  
  }
  public String getIndictStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IndictStatus));
      }

  public void initComTypeId(String value){
     this.initProperty(S_ComTypeId,value);
  }
  public  void setComTypeId(String value){
     this.set(S_ComTypeId,value);
  }
  public  void setComTypeIdNull(){
     this.set(S_ComTypeId,null);
  }

  public String getComTypeId(){
       return DataType.getAsString(this.get(S_ComTypeId));
  
  }
  public String getComTypeIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ComTypeId));
      }

  public void initRespPartnerTypeName(String value){
     this.initProperty(S_RespPartnerTypeName,value);
  }
  public  void setRespPartnerTypeName(String value){
     this.set(S_RespPartnerTypeName,value);
  }
  public  void setRespPartnerTypeNameNull(){
     this.set(S_RespPartnerTypeName,null);
  }

  public String getRespPartnerTypeName(){
       return DataType.getAsString(this.get(S_RespPartnerTypeName));
  
  }
  public String getRespPartnerTypeNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RespPartnerTypeName));
      }

  public void initRespPartnerId(long value){
     this.initProperty(S_RespPartnerId,new Long(value));
  }
  public  void setRespPartnerId(long value){
     this.set(S_RespPartnerId,new Long(value));
  }
  public  void setRespPartnerIdNull(){
     this.set(S_RespPartnerId,null);
  }

  public long getRespPartnerId(){
        return DataType.getAsLong(this.get(S_RespPartnerId));
  
  }
  public long getRespPartnerIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RespPartnerId));
      }

  public void initDealDesc(String value){
     this.initProperty(S_DealDesc,value);
  }
  public  void setDealDesc(String value){
     this.set(S_DealDesc,value);
  }
  public  void setDealDescNull(){
     this.set(S_DealDesc,null);
  }

  public String getDealDesc(){
       return DataType.getAsString(this.get(S_DealDesc));
  
  }
  public String getDealDescInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DealDesc));
      }

  public void initAcceptDate(Timestamp value){
     this.initProperty(S_AcceptDate,value);
  }
  public  void setAcceptDate(Timestamp value){
     this.set(S_AcceptDate,value);
  }
  public  void setAcceptDateNull(){
     this.set(S_AcceptDate,null);
  }

  public Timestamp getAcceptDate(){
        return DataType.getAsDateTime(this.get(S_AcceptDate));
  
  }
  public Timestamp getAcceptDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_AcceptDate));
      }

  public void initRelateGysName(String value){
     this.initProperty(S_RelateGysName,value);
  }
  public  void setRelateGysName(String value){
     this.set(S_RelateGysName,value);
  }
  public  void setRelateGysNameNull(){
     this.set(S_RelateGysName,null);
  }

  public String getRelateGysName(){
       return DataType.getAsString(this.get(S_RelateGysName));
  
  }
  public String getRelateGysNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RelateGysName));
      }

  public void initWareFirstKindId(long value){
     this.initProperty(S_WareFirstKindId,new Long(value));
  }
  public  void setWareFirstKindId(long value){
     this.set(S_WareFirstKindId,new Long(value));
  }
  public  void setWareFirstKindIdNull(){
     this.set(S_WareFirstKindId,null);
  }

  public long getWareFirstKindId(){
        return DataType.getAsLong(this.get(S_WareFirstKindId));
  
  }
  public long getWareFirstKindIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_WareFirstKindId));
      }

  public void initUserBrandCode(String value){
     this.initProperty(S_UserBrandCode,value);
  }
  public  void setUserBrandCode(String value){
     this.set(S_UserBrandCode,value);
  }
  public  void setUserBrandCodeNull(){
     this.set(S_UserBrandCode,null);
  }

  public String getUserBrandCode(){
       return DataType.getAsString(this.get(S_UserBrandCode));
  
  }
  public String getUserBrandCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_UserBrandCode));
      }

  public void initRespPartnerType(String value){
     this.initProperty(S_RespPartnerType,value);
  }
  public  void setRespPartnerType(String value){
     this.set(S_RespPartnerType,value);
  }
  public  void setRespPartnerTypeNull(){
     this.set(S_RespPartnerType,null);
  }

  public String getRespPartnerType(){
       return DataType.getAsString(this.get(S_RespPartnerType));
  
  }
  public String getRespPartnerTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RespPartnerType));
      }

  public void initAllegeLxMethod(String value){
     this.initProperty(S_AllegeLxMethod,value);
  }
  public  void setAllegeLxMethod(String value){
     this.set(S_AllegeLxMethod,value);
  }
  public  void setAllegeLxMethodNull(){
     this.set(S_AllegeLxMethod,null);
  }

  public String getAllegeLxMethod(){
       return DataType.getAsString(this.get(S_AllegeLxMethod));
  
  }
  public String getAllegeLxMethodInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AllegeLxMethod));
      }

  public void initExchgChannel(String value){
     this.initProperty(S_ExchgChannel,value);
  }
  public  void setExchgChannel(String value){
     this.set(S_ExchgChannel,value);
  }
  public  void setExchgChannelNull(){
     this.set(S_ExchgChannel,null);
  }

  public String getExchgChannel(){
       return DataType.getAsString(this.get(S_ExchgChannel));
  
  }
  public String getExchgChannelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExchgChannel));
      }

  public void initOverTime(long value){
     this.initProperty(S_OverTime,new Long(value));
  }
  public  void setOverTime(long value){
     this.set(S_OverTime,new Long(value));
  }
  public  void setOverTimeNull(){
     this.set(S_OverTime,null);
  }

  public long getOverTime(){
        return DataType.getAsLong(this.get(S_OverTime));
  
  }
  public long getOverTimeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OverTime));
      }

  public void initRespPartnerName(String value){
     this.initProperty(S_RespPartnerName,value);
  }
  public  void setRespPartnerName(String value){
     this.set(S_RespPartnerName,value);
  }
  public  void setRespPartnerNameNull(){
     this.set(S_RespPartnerName,null);
  }

  public String getRespPartnerName(){
       return DataType.getAsString(this.get(S_RespPartnerName));
  
  }
  public String getRespPartnerNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RespPartnerName));
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

  public void initPartnerDeal(String value){
     this.initProperty(S_PartnerDeal,value);
  }
  public  void setPartnerDeal(String value){
     this.set(S_PartnerDeal,value);
  }
  public  void setPartnerDealNull(){
     this.set(S_PartnerDeal,null);
  }

  public String getPartnerDeal(){
       return DataType.getAsString(this.get(S_PartnerDeal));
  
  }
  public String getPartnerDealInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PartnerDeal));
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

  public void initStatusTime(Timestamp value){
     this.initProperty(S_StatusTime,value);
  }
  public  void setStatusTime(Timestamp value){
     this.set(S_StatusTime,value);
  }
  public  void setStatusTimeNull(){
     this.set(S_StatusTime,null);
  }

  public Timestamp getStatusTime(){
        return DataType.getAsDateTime(this.get(S_StatusTime));
  
  }
  public Timestamp getStatusTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_StatusTime));
      }

  public void initAcceptTypeName(String value){
     this.initProperty(S_AcceptTypeName,value);
  }
  public  void setAcceptTypeName(String value){
     this.set(S_AcceptTypeName,value);
  }
  public  void setAcceptTypeNameNull(){
     this.set(S_AcceptTypeName,null);
  }

  public String getAcceptTypeName(){
       return DataType.getAsString(this.get(S_AcceptTypeName));
  
  }
  public String getAcceptTypeNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AcceptTypeName));
      }


 
 }

