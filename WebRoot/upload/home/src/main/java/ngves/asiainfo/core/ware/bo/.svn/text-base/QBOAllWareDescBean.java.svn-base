package ngves.asiainfo.core.ware.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.ware.ivalues.*;

public class QBOAllWareDescBean extends DataContainer implements DataContainerInterface,IQBOAllWareDescValue{

  
  private static final long serialVersionUID = 1278198041912960868L;



   private static String  m_boName = "ngves.asiainfo.core.ware.bo.QBOAllWareDesc";

  public final static  String S_DeliverType = "DELIVER_TYPE";
  public final static  String S_WarehouseName = "WAREHOUSE_NAME";
  public final static  String S_WareKindParentId = "WARE_KIND_PARENT_ID";
  public final static  String S_ValidDatetime = "VALID_DATETIME";
  public final static  String S_IsVipPrice = "IS_VIP_PRICE";
  public final static  String S_DrillIntegral = "DRILL_INTEGRAL";
  public final static  String S_ProvCode = "PROV_CODE";
  public final static  String S_CloseDate = "CLOSE_DATE";
  public final static  String S_ExchangeType = "EXCHANGE_TYPE";
  public final static  String S_OpenDate = "OPEN_DATE";
  public final static  String S_PartnerName = "PARTNER_NAME";
  public final static  String S_IsShowSmsmsg = "IS_SHOW_SMSMSG";
  public final static  String S_WareBrandName = "WARE_BRAND_NAME";
  public final static  String S_WareNameParent = "WARE_NAME_PARENT";
  public final static  String S_MarketPrice = "MARKET_PRICE";
  public final static  String S_Note = "NOTE";
  public final static  String S_MobileBrand = "MOBILE_BRAND";
  public final static  String S_IsTwoCode = "IS_TWO_CODE";
  public final static  String S_WareFirstKindId = "WARE_FIRST_KIND_ID";
  public final static  String S_GoldIntegral = "GOLD_INTEGRAL";
  public final static  String S_ValidDay = "VALID_DAY";
  public final static  String S_WareStatus = "WARE_STATUS";
  public final static  String S_PaidPrice = "PAID_PRICE";
  public final static  String S_WareCodeParent = "WARE_CODE_PARENT";
  public final static  String S_WillValid = "WILL_VALID";
  public final static  String S_WareKindId = "WARE_KIND_ID";
  public final static  String S_StatusCause = "STATUS_CAUSE";
  public final static  String S_IsShowDeliverMsg = "IS_SHOW_DELIVER_MSG";
  public final static  String S_SendCodeType = "SEND_CODE_TYPE";
  public final static  String S_IsPreferential = "IS_PREFERENTIAL";
  public final static  String S_TenderNum = "TENDER_NUM";
  public final static  String S_TwoCountPrice = "TWO_COUNT_PRICE";
  public final static  String S_WillOutTime = "WILL_OUT_TIME";
  public final static  String S_CountValue = "COUNT_VALUE";
  public final static  String S_WareType = "WARE_TYPE";
  public final static  String S_WareStorageType = "WARE_STORAGE_TYPE";
  public final static  String S_DeliverMsg = "DELIVER_MSG";
  public final static  String S_WareCode = "WARE_CODE";
  public final static  String S_PartnerId = "PARTNER_ID";
  public final static  String S_TwoOrderStatus = "TWO_ORDER_STATUS";
  public final static  String S_ValidType = "VALID_TYPE";
  public final static  String S_BrandId = "BRAND_ID";
  public final static  String S_WareName = "WARE_NAME";
  public final static  String S_WareIntegralValue = "WARE_INTEGRAL_VALUE";
  public final static  String S_SiliverIntegral = "SILIVER_INTEGRAL";
  public final static  String S_ExchangeChannel = "EXCHANGE_CHANNEL";
  public final static  String S_IsSearch = "IS_SEARCH";
  public final static  String S_IsShowBuyNum = "IS_SHOW_BUY_NUM";
  public final static  String S_SmsCode = "SMS_CODE";
  public final static  String S_KindName = "KIND_NAME";
  public final static  String S_ExchangePrice = "EXCHANGE_PRICE";
  public final static  String S_ValidPeriod = "VALID_PERIOD";
  public final static  String S_PayType = "PAY_TYPE"; 
  public final static  String S_PayCash = "PAY_CASH"; 
  public final static  String S_PayIntegral = "PAY_INTEGRAL";
  public final static  String S_PayGoldIntegral="PAY_GOLD_INTEGRAL";
  public final static  String S_PayGoldCash="PAY_GOLD_CASH";
  public final static  String S_PaySiliverIntegral="PAY_SILIVER_INTEGRAL";
  public final static  String S_PaySiliverCash="PAY_SILIVER_CASH";
  public final static  String S_PayDrillIntegral="PAY_DRILL_INTEGRAL";
  public final static  String S_PayDrillCash="PAY_DRILL_CASH";
  public final static  String S_SupportLottery = "SUPPORT_LOTTERY";
  
//增加礼品大类id和name
  public final static  String S_WareKindInfo = "WARE_KIND_INFO_ID";
//  public final static  String S_WareKindInfoName = "WARE_KIND_INFO_NAME";
	 

  public void initWareKindInfo(long value){
	  this.initProperty(S_WareKindInfo,new Long(value));
  }
  public  void setWareKindInfo(long value){
	  this.set(S_WareKindInfo,new Long(value));
  }
  public  void setWareKindInfoNull(){
	  this.set(S_WareKindInfo,null);
  }

  public long getWareKindInfo(){
	  return DataType.getAsLong(this.get(S_WareKindInfo));
  }
  public long getWareKindInfoInitialValue(){
	  return DataType.getAsLong(this.getOldObj(S_WareKindInfo));
  }

  
  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBOAllWareDescBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initDeliverType(String value){
     this.initProperty(S_DeliverType,value);
  }
  public  void setDeliverType(String value){
     this.set(S_DeliverType,value);
  }
  public  void setDeliverTypeNull(){
     this.set(S_DeliverType,null);
  }

  public String getDeliverType(){
       return DataType.getAsString(this.get(S_DeliverType));
  
  }
  public String getDeliverTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DeliverType));
      }

  public void initWarehouseName(String value){
     this.initProperty(S_WarehouseName,value);
  }
  public  void setWarehouseName(String value){
     this.set(S_WarehouseName,value);
  }
  public  void setWarehouseNameNull(){
     this.set(S_WarehouseName,null);
  }

  public String getWarehouseName(){
       return DataType.getAsString(this.get(S_WarehouseName));
  
  }
  public String getWarehouseNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WarehouseName));
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

  public void initValidDatetime(String value){
     this.initProperty(S_ValidDatetime,value);
  }
  public  void setValidDatetime(String value){
     this.set(S_ValidDatetime,value);
  }
  public  void setValidDatetimeNull(){
     this.set(S_ValidDatetime,null);
  }

  public String getValidDatetime(){
       return DataType.getAsString(this.get(S_ValidDatetime));
  
  }
  public String getValidDatetimeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ValidDatetime));
      }

  public void initIsVipPrice(String value){
     this.initProperty(S_IsVipPrice,value);
  }
  public  void setIsVipPrice(String value){
     this.set(S_IsVipPrice,value);
  }
  public  void setIsVipPriceNull(){
     this.set(S_IsVipPrice,null);
  }

  public String getIsVipPrice(){
       return DataType.getAsString(this.get(S_IsVipPrice));
  
  }
  public String getIsVipPriceInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsVipPrice));
      }

  public void initDrillIntegral(String value){
     this.initProperty(S_DrillIntegral,value);
  }
  public  void setDrillIntegral(String value){
     this.set(S_DrillIntegral,value);
  }
  public  void setDrillIntegralNull(){
     this.set(S_DrillIntegral,null);
  }

  public String getDrillIntegral(){
       return DataType.getAsString(this.get(S_DrillIntegral));
  
  }
  public String getDrillIntegralInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DrillIntegral));
      }

  public void initProvCode(String value){
     this.initProperty(S_ProvCode,value);
  }
  public  void setProvCode(String value){
     this.set(S_ProvCode,value);
  }
  public  void setProvCodeNull(){
     this.set(S_ProvCode,null);
  }

  public String getProvCode(){
       return DataType.getAsString(this.get(S_ProvCode));
  
  }
  public String getProvCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProvCode));
      }

  public void initCloseDate(String value){
     this.initProperty(S_CloseDate,value);
  }
  public  void setCloseDate(String value){
     this.set(S_CloseDate,value);
  }
  public  void setCloseDateNull(){
     this.set(S_CloseDate,null);
  }

  public String getCloseDate(){
       return DataType.getAsString(this.get(S_CloseDate));
  
  }
  public String getCloseDateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CloseDate));
      }

  public void initExchangeType(String value){
     this.initProperty(S_ExchangeType,value);
  }
  public  void setExchangeType(String value){
     this.set(S_ExchangeType,value);
  }
  public  void setExchangeTypeNull(){
     this.set(S_ExchangeType,null);
  }

  public String getExchangeType(){
       return DataType.getAsString(this.get(S_ExchangeType));
  
  }
  public String getExchangeTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExchangeType));
      }

  public void initOpenDate(String value){
     this.initProperty(S_OpenDate,value);
  }
  public  void setOpenDate(String value){
     this.set(S_OpenDate,value);
  }
  public  void setOpenDateNull(){
     this.set(S_OpenDate,null);
  }

  public String getOpenDate(){
       return DataType.getAsString(this.get(S_OpenDate));
  
  }
  public String getOpenDateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OpenDate));
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

  public void initIsShowSmsmsg(String value){
     this.initProperty(S_IsShowSmsmsg,value);
  }
  public  void setIsShowSmsmsg(String value){
     this.set(S_IsShowSmsmsg,value);
  }
  public  void setIsShowSmsmsgNull(){
     this.set(S_IsShowSmsmsg,null);
  }

  public String getIsShowSmsmsg(){
       return DataType.getAsString(this.get(S_IsShowSmsmsg));
  
  }
  public String getIsShowSmsmsgInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsShowSmsmsg));
      }

  public void initWareBrandName(String value){
     this.initProperty(S_WareBrandName,value);
  }
  public  void setWareBrandName(String value){
     this.set(S_WareBrandName,value);
  }
  public  void setWareBrandNameNull(){
     this.set(S_WareBrandName,null);
  }

  public String getWareBrandName(){
       return DataType.getAsString(this.get(S_WareBrandName));
  
  }
  public String getWareBrandNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WareBrandName));
      }

  public void initWareNameParent(String value){
     this.initProperty(S_WareNameParent,value);
  }
  public  void setWareNameParent(String value){
     this.set(S_WareNameParent,value);
  }
  public  void setWareNameParentNull(){
     this.set(S_WareNameParent,null);
  }

  public String getWareNameParent(){
       return DataType.getAsString(this.get(S_WareNameParent));
  
  }
  public String getWareNameParentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WareNameParent));
      }

  public void initMarketPrice(String value){
     this.initProperty(S_MarketPrice,value);
  }
  public  void setMarketPrice(String value){
     this.set(S_MarketPrice,value);
  }
  public  void setMarketPriceNull(){
     this.set(S_MarketPrice,null);
  }

  public String getMarketPrice(){
       return DataType.getAsString(this.get(S_MarketPrice));
  
  }
  public String getMarketPriceInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MarketPrice));
      }

  public void initNote(String value){
     this.initProperty(S_Note,value);
  }
  public  void setNote(String value){
     this.set(S_Note,value);
  }
  public  void setNoteNull(){
     this.set(S_Note,null);
  }

  public String getNote(){
       return DataType.getAsString(this.get(S_Note));
  
  }
  public String getNoteInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Note));
      }

  public void initMobileBrand(String value){
     this.initProperty(S_MobileBrand,value);
  }
  public  void setMobileBrand(String value){
     this.set(S_MobileBrand,value);
  }
  public  void setMobileBrandNull(){
     this.set(S_MobileBrand,null);
  }

  public String getMobileBrand(){
       return DataType.getAsString(this.get(S_MobileBrand));
  
  }
  public String getMobileBrandInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MobileBrand));
      }

  public void initIsTwoCode(String value){
     this.initProperty(S_IsTwoCode,value);
  }
  public  void setIsTwoCode(String value){
     this.set(S_IsTwoCode,value);
  }
  public  void setIsTwoCodeNull(){
     this.set(S_IsTwoCode,null);
  }

  public String getIsTwoCode(){
       return DataType.getAsString(this.get(S_IsTwoCode));
  
  }
  public String getIsTwoCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsTwoCode));
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

  public void initGoldIntegral(String value){
     this.initProperty(S_GoldIntegral,value);
  }
  public  void setGoldIntegral(String value){
     this.set(S_GoldIntegral,value);
  }
  public  void setGoldIntegralNull(){
     this.set(S_GoldIntegral,null);
  }

  public String getGoldIntegral(){
       return DataType.getAsString(this.get(S_GoldIntegral));
  
  }
  public String getGoldIntegralInitialValue(){
        return DataType.getAsString(this.getOldObj(S_GoldIntegral));
      }

  public void initValidDay(String value){
     this.initProperty(S_ValidDay,value);
  }
  public  void setValidDay(String value){
     this.set(S_ValidDay,value);
  }
  public  void setValidDayNull(){
     this.set(S_ValidDay,null);
  }

  public String getValidDay(){
       return DataType.getAsString(this.get(S_ValidDay));
  
  }
  public String getValidDayInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ValidDay));
      }

  public void initWareStatus(String value){
     this.initProperty(S_WareStatus,value);
  }
  public  void setWareStatus(String value){
     this.set(S_WareStatus,value);
  }
  public  void setWareStatusNull(){
     this.set(S_WareStatus,null);
  }

  public String getWareStatus(){
       return DataType.getAsString(this.get(S_WareStatus));
  
  }
  public String getWareStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WareStatus));
      }

  public void initPaidPrice(String value){
     this.initProperty(S_PaidPrice,value);
  }
  public  void setPaidPrice(String value){
     this.set(S_PaidPrice,value);
  }
  public  void setPaidPriceNull(){
     this.set(S_PaidPrice,null);
  }

  public String getPaidPrice(){
       return DataType.getAsString(this.get(S_PaidPrice));
  
  }
  public String getPaidPriceInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PaidPrice));
      }

  public void initWareCodeParent(String value){
     this.initProperty(S_WareCodeParent,value);
  }
  public  void setWareCodeParent(String value){
     this.set(S_WareCodeParent,value);
  }
  public  void setWareCodeParentNull(){
     this.set(S_WareCodeParent,null);
  }

  public String getWareCodeParent(){
       return DataType.getAsString(this.get(S_WareCodeParent));
  
  }
  public String getWareCodeParentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WareCodeParent));
      }

  public void initWillValid(String value){
     this.initProperty(S_WillValid,value);
  }
  public  void setWillValid(String value){
     this.set(S_WillValid,value);
  }
  public  void setWillValidNull(){
     this.set(S_WillValid,null);
  }

  public String getWillValid(){
       return DataType.getAsString(this.get(S_WillValid));
  
  }
  public String getWillValidInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WillValid));
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

  public void initStatusCause(String value){
     this.initProperty(S_StatusCause,value);
  }
  public  void setStatusCause(String value){
     this.set(S_StatusCause,value);
  }
  public  void setStatusCauseNull(){
     this.set(S_StatusCause,null);
  }

  public String getStatusCause(){
       return DataType.getAsString(this.get(S_StatusCause));
  
  }
  public String getStatusCauseInitialValue(){
        return DataType.getAsString(this.getOldObj(S_StatusCause));
      }

  public void initIsShowDeliverMsg(String value){
     this.initProperty(S_IsShowDeliverMsg,value);
  }
  public  void setIsShowDeliverMsg(String value){
     this.set(S_IsShowDeliverMsg,value);
  }
  public  void setIsShowDeliverMsgNull(){
     this.set(S_IsShowDeliverMsg,null);
  }

  public String getIsShowDeliverMsg(){
       return DataType.getAsString(this.get(S_IsShowDeliverMsg));
  
  }
  public String getIsShowDeliverMsgInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsShowDeliverMsg));
      }

  public void initSendCodeType(String value){
     this.initProperty(S_SendCodeType,value);
  }
  public  void setSendCodeType(String value){
     this.set(S_SendCodeType,value);
  }
  public  void setSendCodeTypeNull(){
     this.set(S_SendCodeType,null);
  }

  public String getSendCodeType(){
       return DataType.getAsString(this.get(S_SendCodeType));
  
  }
  public String getSendCodeTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SendCodeType));
      }

  public void initIsPreferential(String value){
     this.initProperty(S_IsPreferential,value);
  }
  public  void setIsPreferential(String value){
     this.set(S_IsPreferential,value);
  }
  public  void setIsPreferentialNull(){
     this.set(S_IsPreferential,null);
  }

  public String getIsPreferential(){
       return DataType.getAsString(this.get(S_IsPreferential));
  
  }
  public String getIsPreferentialInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsPreferential));
      }

  public void initTenderNum(String value){
     this.initProperty(S_TenderNum,value);
  }
  public  void setTenderNum(String value){
     this.set(S_TenderNum,value);
  }
  public  void setTenderNumNull(){
     this.set(S_TenderNum,null);
  }

  public String getTenderNum(){
       return DataType.getAsString(this.get(S_TenderNum));
  
  }
  public String getTenderNumInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TenderNum));
      }

  public void initTwoCountPrice(String value){
     this.initProperty(S_TwoCountPrice,value);
  }
  public  void setTwoCountPrice(String value){
     this.set(S_TwoCountPrice,value);
  }
  public  void setTwoCountPriceNull(){
     this.set(S_TwoCountPrice,null);
  }

  public String getTwoCountPrice(){
       return DataType.getAsString(this.get(S_TwoCountPrice));
  
  }
  public String getTwoCountPriceInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TwoCountPrice));
      }

  public void initWillOutTime(String value){
     this.initProperty(S_WillOutTime,value);
  }
  public  void setWillOutTime(String value){
     this.set(S_WillOutTime,value);
  }
  public  void setWillOutTimeNull(){
     this.set(S_WillOutTime,null);
  }

  public String getWillOutTime(){
       return DataType.getAsString(this.get(S_WillOutTime));
  
  }
  public String getWillOutTimeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WillOutTime));
      }

  public void initCountValue(String value){
     this.initProperty(S_CountValue,value);
  }
  public  void setCountValue(String value){
     this.set(S_CountValue,value);
  }
  public  void setCountValueNull(){
     this.set(S_CountValue,null);
  }

  public String getCountValue(){
       return DataType.getAsString(this.get(S_CountValue));
  
  }
  public String getCountValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CountValue));
      }

  public void initWareType(long value){
     this.initProperty(S_WareType,new Long(value));
  }
  public  void setWareType(long value){
     this.set(S_WareType,new Long(value));
  }
  public  void setWareTypeNull(){
     this.set(S_WareType,null);
  }

  public long getWareType(){
        return DataType.getAsLong(this.get(S_WareType));
  
  }
  public long getWareTypeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_WareType));
      }

  public void initWareStorageType(String value){
     this.initProperty(S_WareStorageType,value);
  }
  public  void setWareStorageType(String value){
     this.set(S_WareStorageType,value);
  }
  public  void setWareStorageTypeNull(){
     this.set(S_WareStorageType,null);
  }

  public String getWareStorageType(){
       return DataType.getAsString(this.get(S_WareStorageType));
  
  }
  public String getWareStorageTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WareStorageType));
      }

  public void initDeliverMsg(String value){
     this.initProperty(S_DeliverMsg,value);
  }
  public  void setDeliverMsg(String value){
     this.set(S_DeliverMsg,value);
  }
  public  void setDeliverMsgNull(){
     this.set(S_DeliverMsg,null);
  }

  public String getDeliverMsg(){
       return DataType.getAsString(this.get(S_DeliverMsg));
  
  }
  public String getDeliverMsgInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DeliverMsg));
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

  public void initPartnerId(long value){
     this.initProperty(S_PartnerId,new Long(value));
  }
  public  void setPartnerId(long value){
     this.set(S_PartnerId,new Long(value));
  }
  public  void setPartnerIdNull(){
     this.set(S_PartnerId,null);
  }

  public long getPartnerId(){
        return DataType.getAsLong(this.get(S_PartnerId));
  
  }
  public long getPartnerIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PartnerId));
      }

  public void initTwoOrderStatus(String value){
     this.initProperty(S_TwoOrderStatus,value);
  }
  public  void setTwoOrderStatus(String value){
     this.set(S_TwoOrderStatus,value);
  }
  public  void setTwoOrderStatusNull(){
     this.set(S_TwoOrderStatus,null);
  }

  public String getTwoOrderStatus(){
       return DataType.getAsString(this.get(S_TwoOrderStatus));
  
  }
  public String getTwoOrderStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TwoOrderStatus));
      }

  public void initValidType(String value){
     this.initProperty(S_ValidType,value);
  }
  public  void setValidType(String value){
     this.set(S_ValidType,value);
  }
  public  void setValidTypeNull(){
     this.set(S_ValidType,null);
  }

  public String getValidType(){
       return DataType.getAsString(this.get(S_ValidType));
  
  }
  public String getValidTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ValidType));
      }

  public void initBrandId(long value){
     this.initProperty(S_BrandId,new Long(value));
  }
  public  void setBrandId(long value){
     this.set(S_BrandId,new Long(value));
  }
  public  void setBrandIdNull(){
     this.set(S_BrandId,null);
  }

  public long getBrandId(){
        return DataType.getAsLong(this.get(S_BrandId));
  
  }
  public long getBrandIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BrandId));
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

  public void initWareIntegralValue(String value){
     this.initProperty(S_WareIntegralValue,value);
  }
  public  void setWareIntegralValue(String value){
     this.set(S_WareIntegralValue,value);
  }
  public  void setWareIntegralValueNull(){
     this.set(S_WareIntegralValue,null);
  }

  public String getWareIntegralValue(){
       return DataType.getAsString(this.get(S_WareIntegralValue));
  
  }
  public String getWareIntegralValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WareIntegralValue));
      }

  public void initSiliverIntegral(String value){
     this.initProperty(S_SiliverIntegral,value);
  }
  public  void setSiliverIntegral(String value){
     this.set(S_SiliverIntegral,value);
  }
  public  void setSiliverIntegralNull(){
     this.set(S_SiliverIntegral,null);
  }

  public String getSiliverIntegral(){
       return DataType.getAsString(this.get(S_SiliverIntegral));
  
  }
  public String getSiliverIntegralInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SiliverIntegral));
      }

  public void initExchangeChannel(String value){
     this.initProperty(S_ExchangeChannel,value);
  }
  public  void setExchangeChannel(String value){
     this.set(S_ExchangeChannel,value);
  }
  public  void setExchangeChannelNull(){
     this.set(S_ExchangeChannel,null);
  }

  public String getExchangeChannel(){
       return DataType.getAsString(this.get(S_ExchangeChannel));
  
  }
  public String getExchangeChannelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExchangeChannel));
      }

  public void initIsSearch(String value){
     this.initProperty(S_IsSearch,value);
  }
  public  void setIsSearch(String value){
     this.set(S_IsSearch,value);
  }
  public  void setIsSearchNull(){
     this.set(S_IsSearch,null);
  }

  public String getIsSearch(){
       return DataType.getAsString(this.get(S_IsSearch));
  
  }
  public String getIsSearchInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsSearch));
      }

  public void initIsShowBuyNum(String value){
     this.initProperty(S_IsShowBuyNum,value);
  }
  public  void setIsShowBuyNum(String value){
     this.set(S_IsShowBuyNum,value);
  }
  public  void setIsShowBuyNumNull(){
     this.set(S_IsShowBuyNum,null);
  }

  public String getIsShowBuyNum(){
       return DataType.getAsString(this.get(S_IsShowBuyNum));
  
  }
  public String getIsShowBuyNumInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsShowBuyNum));
      }

  public void initSmsCode(String value){
     this.initProperty(S_SmsCode,value);
  }
  public  void setSmsCode(String value){
     this.set(S_SmsCode,value);
  }
  public  void setSmsCodeNull(){
     this.set(S_SmsCode,null);
  }

  public String getSmsCode(){
       return DataType.getAsString(this.get(S_SmsCode));
  
  }
  public String getSmsCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SmsCode));
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

  public void initExchangePrice(String value){
     this.initProperty(S_ExchangePrice,value);
  }
  public  void setExchangePrice(String value){
     this.set(S_ExchangePrice,value);
  }
  public  void setExchangePriceNull(){
     this.set(S_ExchangePrice,null);
  }

  public String getExchangePrice(){
       return DataType.getAsString(this.get(S_ExchangePrice));
  
  }
  public String getExchangePriceInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExchangePrice));
      }

  public void initValidPeriod(String value){
     this.initProperty(S_ValidPeriod,value);
  }
  public  void setValidPeriod(String value){
     this.set(S_ValidPeriod,value);
  }
  public  void setValidPeriodNull(){
     this.set(S_ValidPeriod,null);
  }

  public String getValidPeriod(){
       return DataType.getAsString(this.get(S_ValidPeriod));
  
  }
  public String getValidPeriodInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ValidPeriod));
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
  
  public void initPayAll(String value){
     this.initProperty(S_PayCash,value);
  }
  public  void setPayCash(String value){
     this.set(S_PayCash,value);
  }
  public  void setPayAllNull(){
     this.set(S_PayCash,null);
  }

  public String getPayCash(){
     return DataType.getAsString(this.get(S_PayCash));

  }
  public String getPayAllInitialValue(){
     return DataType.getAsString(this.getOldObj(S_PayCash));
  } 
  public void initPayIntegral(String value){
     this.initProperty(S_PayIntegral,value);
  }
  public  void setPayIntegral(String value){
     this.set(S_PayIntegral,value);
  }
  public  void setPayIntegralNull(){
     this.set(S_PayIntegral,null);
  }

  public String getPayIntegral(){
     return DataType.getAsString(this.get(S_PayIntegral));

  }
  public String getPayIntegralInitialValue(){
     return DataType.getAsString(this.getOldObj(S_PayIntegral));
  }  
  
  public void initPayGoldIntegral(String value){
     this.initProperty(S_PayGoldIntegral,value);
  }
  public  void setPayGoldIntegral(String value){
     this.set(S_PayGoldIntegral,value);
  }
  public  void setPayGoldIntegralNull(){
     this.set(S_PayGoldIntegral,null);
  }

  public String getPayGoldIntegral(){
     return DataType.getAsString(this.get(S_PayGoldIntegral));

  }
  public String getPayGoldIntegralInitialValue(){
     return DataType.getAsString(this.getOldObj(S_PayGoldIntegral));
  }
  
  public void initPayGoldCash(String value){
     this.initProperty(S_PayGoldCash,value);
  }
  public  void setPayGoldCash(String value){
     this.set(S_PayGoldCash,value);
  }
  public  void setPayGoldCashNull(){
     this.set(S_PayGoldCash,null);
  }

  public String getPayGoldCash(){
     return DataType.getAsString(this.get(S_PayGoldCash));

  }
  public String getPayGoldCashInitialValue(){
     return DataType.getAsString(this.getOldObj(S_PayGoldCash));
  }
  
  public void initPaySiliverIntegral(String value){
     this.initProperty(S_PaySiliverIntegral,value);
  }
  public  void setPaySiliverIntegral(String value){
     this.set(S_PaySiliverIntegral,value);
  }
  public  void setPaySiliverIntegralNull(){
     this.set(S_PaySiliverIntegral,null);
  }

  public String getPaySiliverIntegral(){
     return DataType.getAsString(this.get(S_PaySiliverIntegral));

  }
  public String getPaySiliverIntegralInitialValue(){
     return DataType.getAsString(this.getOldObj(S_PaySiliverIntegral));
  }

  public void initPaySiliverCash(String value){
     this.initProperty(S_PaySiliverCash,value);
  }
  public  void setPaySiliverCash(String value){
     this.set(S_PaySiliverCash,value);
  }
  public  void setPaySiliverCashNull(){
     this.set(S_PaySiliverCash,null);
  }

  public String getPaySiliverCash(){
     return DataType.getAsString(this.get(S_PaySiliverCash));

  }
  public String getPaySiliverCashInitialValue(){
     return DataType.getAsString(this.getOldObj(S_PaySiliverCash));
  }
  
  public void initPayDrillIntegral(String value){
	     this.initProperty(S_PayDrillIntegral,value);
  }
  public  void setPayDrillIntegral(String value){
     this.set(S_PayDrillIntegral,value);
  }
  public  void setPayDrillIntegralNull(){
     this.set(S_PayDrillIntegral,null);
  }

  public String getPayDrillIntegral(){
     return DataType.getAsString(this.get(S_PayDrillIntegral));

  }
  public String getPayDrillIntegralInitialValue(){
     return DataType.getAsString(this.getOldObj(S_PayDrillIntegral));
  }
  
  public void initPayDrillCash(String value){
	 this.initProperty(S_PayDrillCash,value);
  }
  public  void setPayDrillCash(String value){
	 this.set(S_PayDrillCash,value);
  }
  public  void setPayDrillCashNull(){
	 this.set(S_PayDrillCash,null);
  }
  public String getPayDrillCash(){
	 return DataType.getAsString(this.get(S_PayDrillCash));
  }
  public String getPayDrillCashInitialValue(){
	 return DataType.getAsString(this.getOldObj(S_PayDrillCash));
  }
  
  
  public void initSupportLottery(String value){
		 this.initProperty(S_SupportLottery,value);
	  }
	  public  void setSupportLottery(String value){
		 this.set(S_SupportLottery,value);
	  }
	  public  void setSupportLotteryNull(){
		 this.set(S_SupportLottery,null);
	  }
	  public String getSupportLottery(){
		 return DataType.getAsString(this.get(S_SupportLottery));
	  }
	  public String getSupportLotteryInitialValue(){
		 return DataType.getAsString(this.getOldObj(S_SupportLottery));
	  }
	  
	  
	  public void initNoLevel(String value){
		     this.initProperty(S_NoLevel,new String(value));
		  }
		  public  void setNoLevel(String value){
		     this.set(S_NoLevel,new String(value));
		  }
		  public  void setNoLevelNull(){
		     this.set(S_NoLevel,null);
		  }

		  public String getNoLevel(){
		        return DataType.getAsString(this.get(S_NoLevel));
		  
		  }
		  public String getNoLevelInitialValue(){
		        return DataType.getAsString(this.getOldObj(S_NoLevel));
		      }
	  public void initStandardStar(String value){
		     this.initProperty(S_StandardStar,new String(value));
		  }
		  public  void setStandardStar(String value){
		     this.set(S_StandardStar,new String(value));
		  }
		  public  void setStandardStarNull(){
		     this.set(S_StandardStar,null);
		  }

		  public String getStandardStar(){
		        return DataType.getAsString(this.get(S_StandardStar));
		  
		  }
		  public String getStandardStarInitialValue(){
		        return DataType.getAsString(this.getOldObj(S_StandardStar));
		      }

		  public void initOneStar(String value){
		     this.initProperty(S_OneStar,new String(value));
		  }
		  public  void setOneStar(String value){
		     this.set(S_OneStar,new String(value));
		  }
		  public  void setOneStarNull(){
		     this.set(S_OneStar,null);
		  }

		  public String getOneStar(){
		        return DataType.getAsString(this.get(S_OneStar));
		  
		  }
		  public String getOneStarInitialValue(){
		        return DataType.getAsString(this.getOldObj(S_OneStar));
		  }
		  public void initTwoStar(String value){
			  this.initProperty(S_TwoStar,new String(value));
		  }
		  public  void setTwoStar(String value){
			  this.set(S_TwoStar,new String(value));
		  }
		  public  void setTwoStarNull(){
			  this.set(S_TwoStar,null);
		  }
		  
		  public String getTwoStar(){
			  return DataType.getAsString(this.get(S_TwoStar));
			  
		  }
		  public String getTwoStarInitialValue(){
			  return DataType.getAsString(this.getOldObj(S_TwoStar));
		  }
		  public void initThreeStar(String value){
			  this.initProperty(S_ThreeStar,new String(value));
		  }
		  public  void setThreeStar(String value){
			  this.set(S_ThreeStar,new String(value));
		  }
		  public  void setThreeStarNull(){
			  this.set(S_ThreeStar,null);
		  }
		  
		  public String getThreeStar(){
			  return DataType.getAsString(this.get(S_ThreeStar));
			  
		  }
		  public String getThreeStarInitialValue(){
			  return DataType.getAsString(this.getOldObj(S_ThreeStar));
		  }
		  public void initFourStar(String value){
			  this.initProperty(S_FourStar,new String(value));
		  }
		  public  void setFourStar(String value){
			  this.set(S_FourStar,new String(value));
		  }
		  public  void setFourStarNull(){
			  this.set(S_FourStar,null);
		  }
		  
		  public String getFourStar(){
			  return DataType.getAsString(this.get(S_FourStar));
			  
		  }
		  public String getFourStarInitialValue(){
			  return DataType.getAsString(this.getOldObj(S_FourStar));
		  }
		  public void initFiveStar(String value){
			  this.initProperty(S_FiveStar,new String(value));
		  }
		  public  void setFiveStar(String value){
			  this.set(S_FiveStar,new String(value));
		  }
		  public  void setFiveStarNull(){
			  this.set(S_FiveStar,null);
		  }
		  
		  public String getFiveStar(){
			  return DataType.getAsString(this.get(S_FiveStar));
			  
		  }
		  public String getFiveStarInitialValue(){
			  return DataType.getAsString(this.getOldObj(S_FiveStar));
		  }
		  public void initFiveStarGold(String value){
			  this.initProperty(S_FiveStarGold,new String(value));
		  }
		  public  void setFiveStarGold(String value){
			  this.set(S_FiveStarGold,new String(value));
		  }
		  public  void setFiveStarGoldNull(){
			  this.set(S_FiveStarGold,null);
		  }
		  
		  public String getFiveStarGold(){
			  return DataType.getAsString(this.get(S_FiveStarGold));
			  
		  }
		  public String getFiveStarGoldInitialValue(){
			  return DataType.getAsString(this.getOldObj(S_FiveStarGold));
		  }
		  public void initFiveStarDiamond(String value){
			  this.initProperty(S_FiveStarDiamond,new String(value));
		  }
		  public  void setFiveStarDiamond(String value){
			  this.set(S_FiveStarDiamond,new String(value));
		  }
		  public  void setFiveStarDiamondNull(){
			  this.set(S_FiveStarDiamond,null);
		  }
		  
		  public String getFiveStarDiamond(){
			  return DataType.getAsString(this.get(S_FiveStarDiamond));
			  
		  }
		  public String getFiveStarDiamondInitialValue(){
			  return DataType.getAsString(this.getOldObj(S_FiveStarDiamond));
		  }
		  
		  public void initChannel(String value){
			     this.initProperty(S_Channel,value);
			  }
			  public  void setChannel(String value){
			     this.set(S_Channel,value);
			  }
			  public  void setChannelNull(){
			     this.set(S_Channel,null);
			  }

			  public String getChannel(){
			       return DataType.getAsString(this.get(S_Channel));
			  
			  }
			  public String getChannelInitialValue(){
			        return DataType.getAsString(this.getOldObj(S_Channel));
			      }
			  
			  
			  
			  
			  
			  
		
			  public void initFiveDiamondCurPayIntegral(String value){
				     this.initProperty(S_FiveDiamondCurPayIntegral,value);
				  }
				  public  void setFiveDiamondCurPayIntegral(String value){
				     this.set(S_FiveDiamondCurPayIntegral,value);
				  }
				  public  void setFiveDiamondCurPayIntegralNull(){
				     this.set(S_FiveDiamondCurPayIntegral,null);
				  }

				  public String getFiveDiamondCurPayIntegral(){
				     return DataType.getAsString(this.get(S_FiveDiamondCurPayIntegral));

				  }
				  public String getFiveDiamondCurPayIntegralInitialValue(){
				     return DataType.getAsString(this.getOldObj(S_FiveDiamondCurPayIntegral));
				  }

				  public void initFiveDiamondCurPayCash(String value){
				     this.initProperty(S_FiveDiamondCurPayCash,value);
				  }
				  public  void setFiveDiamondCurPayCash(String value){
				     this.set(S_FiveDiamondCurPayCash,value);
				  }
				  public  void setFiveDiamondCurPayCashNull(){
				     this.set(S_FiveDiamondCurPayCash,null);
				  }

				  public String getFiveDiamondCurPayCash(){
				     return DataType.getAsString(this.get(S_FiveDiamondCurPayCash));

				  }
				  public String getFiveDiamondCurPayCashInitialValue(){
				     return DataType.getAsString(this.getOldObj(S_FiveDiamondCurPayCash));
				  }
				  
				  
				  
				  
				  public void initFiveGoldCurPayIntegral(String value){
					  this.initProperty(S_FiveGoldCurPayIntegral,value);
				  }
				  public  void setFiveGoldCurPayIntegral(String value){
					  this.set(S_FiveGoldCurPayIntegral,value);
				  }
				  public  void setFiveGoldCurPayIntegralNull(){
					  this.set(S_FiveGoldCurPayIntegral,null);
				  }
				  
				  public String getFiveGoldCurPayIntegral(){
					  return DataType.getAsString(this.get(S_FiveGoldCurPayIntegral));
					  
				  }
				  public String getFiveGoldCurPayIntegralInitialValue(){
					  return DataType.getAsString(this.getOldObj(S_FiveGoldCurPayIntegral));
				  }
				  
				  
				  public void initFiveGoldCurPayCash(String value){
					  this.initProperty(S_FiveGoldCurPayCash,value);
				  }
				  public  void setFiveGoldCurPayCash(String value){
					  this.set(S_FiveGoldCurPayCash,value);
				  }
				  public  void setFiveGoldCurPayCashNull(){
					  this.set(S_FiveGoldCurPayCash,null);
				  }
				  
				  public String getFiveGoldCurPayCash(){
					  return DataType.getAsString(this.get(S_FiveGoldCurPayCash));
					  
				  }
				  public String getFiveGoldCurPayCashInitialValue(){
					  return DataType.getAsString(this.getOldObj(S_FiveGoldCurPayCash));
				  }
				  
				  public void initFiveCurPayIntegral(String value){
					  this.initProperty(S_FiveCurPayIntegral,value);
				  }
				  public  void setFiveCurPayIntegral(String value){
					  this.set(S_FiveCurPayIntegral,value);
				  }
				  public  void setFiveCurPayIntegralNull(){
					  this.set(S_FiveCurPayIntegral,null);
				  }
				  
				  public String getFiveCurPayIntegral(){
					  return DataType.getAsString(this.get(S_FiveCurPayIntegral));
					  
				  }
				  public String getFiveCurPayIntegralInitialValue(){
					  return DataType.getAsString(this.getOldObj(S_FiveCurPayIntegral));
				  }
				  
				  public void initFiveCurPayCash(String value){
					  this.initProperty(S_FiveCurPayCash,value);
				  }
				  public  void setFiveCurPayCash(String value){
					  this.set(S_FiveCurPayCash,value);
				  }
				  public  void setFiveCurPayCashNull(){
					  this.set(S_FiveCurPayCash,null);
				  }
				  
				  public String getFiveCurPayCash(){
					  return DataType.getAsString(this.get(S_FiveCurPayCash));
					  
				  }
				  public String getFiveCurPayCashInitialValue(){
					  return DataType.getAsString(this.getOldObj(S_FiveCurPayCash));
				  }
				  public void initFourCurPayIntegral(String value){
					  this.initProperty(S_FourCurPayIntegral,value);
				  }
				  public  void setFourCurPayIntegral(String value){
					  this.set(S_FourCurPayIntegral,value);
				  }
				  public  void setFourCurPayIntegralNull(){
					  this.set(S_FourCurPayIntegral,null);
				  }
				  
				  public String getFourCurPayIntegral(){
					  return DataType.getAsString(this.get(S_FourCurPayIntegral));
					  
				  }
				  public String getFourCurPayIntegralInitialValue(){
					  return DataType.getAsString(this.getOldObj(S_FourCurPayIntegral));
				  }
				  
				  public void initFourCurPayCash(String value){
					  this.initProperty(S_FourCurPayCash,value);
				  }
				  public  void setFourCurPayCash(String value){
					  this.set(S_FourCurPayCash,value);
				  }
				  public  void setFourCurPayCashNull(){
					  this.set(S_FourCurPayCash,null);
				  }
				  
				  public String getFourCurPayCash(){
					  return DataType.getAsString(this.get(S_FourCurPayCash));
					  
				  }
				  public String getFourCurPayCashInitialValue(){
					  return DataType.getAsString(this.getOldObj(S_FourCurPayCash));
				  }
				  public void initThreeCurPayIntegral(String value){
					  this.initProperty(S_ThreeCurPayIntegral,value);
				  }
				  public  void setThreeCurPayIntegral(String value){
					  this.set(S_ThreeCurPayIntegral,value);
				  }
				  public  void setThreeCurPayIntegralNull(){
					  this.set(S_ThreeCurPayIntegral,null);
				  }
				  
				  public String getThreeCurPayIntegral(){
					  return DataType.getAsString(this.get(S_ThreeCurPayIntegral));
					  
				  }
				  public String getThreeCurPayIntegralInitialValue(){
					  return DataType.getAsString(this.getOldObj(S_ThreeCurPayIntegral));
				  }
				  
				  public void initThreeCurPayCash(String value){
					  this.initProperty(S_ThreeCurPayCash,value);
				  }
				  public  void setThreeCurPayCash(String value){
					  this.set(S_ThreeCurPayCash,value);
				  }
				  public  void setThreeCurPayCashNull(){
					  this.set(S_ThreeCurPayCash,null);
				  }
				  
				  public String getThreeCurPayCash(){
					  return DataType.getAsString(this.get(S_ThreeCurPayCash));
					  
				  }
				  public String getThreeCurPayCashInitialValue(){
					  return DataType.getAsString(this.getOldObj(S_ThreeCurPayCash));
				  }
				  
				  public void initTwoCurPayIntegral(String value){
					  this.initProperty(S_TwoCurPayIntegral,value);
				  }
				  public  void setTwoCurPayIntegral(String value){
					  this.set(S_TwoCurPayIntegral,value);
				  }
				  public  void setTwoCurPayIntegralNull(){
					  this.set(S_TwoCurPayIntegral,null);
				  }
				  
				  public String getTwoCurPayIntegral(){
					  return DataType.getAsString(this.get(S_TwoCurPayIntegral));
					  
				  }
				  public String getTwoCurPayIntegralInitialValue(){
					  return DataType.getAsString(this.getOldObj(S_TwoCurPayIntegral));
				  }
				  
				  public void initTwoCurPayCash(String value){
					  this.initProperty(S_TwoCurPayCash,value);
				  }
				  public  void setTwoCurPayCash(String value){
					  this.set(S_TwoCurPayCash,value);
				  }
				  public  void setTwoCurPayCashNull(){
					  this.set(S_TwoCurPayCash,null);
				  }
				  
				  public String getTwoCurPayCash(){
					  return DataType.getAsString(this.get(S_TwoCurPayCash));
					  
				  }
				  public String getTwoCurPayCashInitialValue(){
					  return DataType.getAsString(this.getOldObj(S_TwoCurPayCash));
				  }
				  
				  
				  public void initOneCurPayIntegral(String value){
					  this.initProperty(S_FiveDiamondCurPayIntegral,value);
				  }
				  public  void setOneCurPayIntegral(String value){
					  this.set(S_OneCurPayIntegral,value);
				  }
				  public  void setOneCurPayIntegralNull(){
					  this.set(S_OneCurPayIntegral,null);
				  }
				  
				  public String getOneCurPayIntegral(){
					  return DataType.getAsString(this.get(S_OneCurPayIntegral));
					  
				  }
				  public String getOneCurPayIntegralInitialValue(){
					  return DataType.getAsString(this.getOldObj(S_OneCurPayIntegral));
				  }
				  
				  public void initOneCurPayCash(String value){
					  this.initProperty(S_OneCurPayCash,value);
				  }
				  public  void setOneCurPayCash(String value){
					  this.set(S_OneCurPayCash,value);
				  }
				  public  void setOneCurPayCashNull(){
					  this.set(S_OneCurPayCash,null);
				  }
				  
				  public String getOneCurPayCash(){
					  return DataType.getAsString(this.get(S_OneCurPayCash));
					  
				  }
				  public String getOneCurPayCashInitialValue(){
					  return DataType.getAsString(this.getOldObj(S_OneCurPayCash));
				  }
				  
				  public void initStandardCurPayIntegral(String value){
					  this.initProperty(S_StandardCurPayIntegral,value);
				  }
				  public  void setStandardCurPayIntegral(String value){
					  this.set(S_StandardCurPayIntegral,value);
				  }
				  public  void setStandardCurPayIntegralNull(){
					  this.set(S_StandardCurPayIntegral,null);
				  }
				  
				  public String getStandardCurPayIntegral(){
					  return DataType.getAsString(this.get(S_StandardCurPayIntegral));
					  
				  }
				  public String getStandardCurPayIntegralInitialValue(){
					  return DataType.getAsString(this.getOldObj(S_StandardCurPayIntegral));
				  }
				  
				  public void initStandardCurPayCash(String value){
					  this.initProperty(S_StandardCurPayCash,value);
				  }
				  public  void setStandardCurPayCash(String value){
					  this.set(S_StandardCurPayCash,value);
				  }
				  public  void setStandardCurPayCashNull(){
					  this.set(S_StandardCurPayCash,null);
				  }
				  
				  public String getStandardCurPayCash(){
					  return DataType.getAsString(this.get(S_StandardCurPayCash));
					  
				  }
				  public String getStandardCurPayCashInitialValue(){
					  return DataType.getAsString(this.getOldObj(S_StandardCurPayCash));
				  }
				  
				  public void initNolevelCurPayIntegral(String value){
					  this.initProperty(S_NolevelCurPayIntegral,value);
				  }
				  public  void setNolevelCurPayIntegral(String value){
					  this.set(S_NolevelCurPayIntegral,value);
				  }
				  public  void setNolevelCurPayIntegralNull(){
					  this.set(S_NolevelCurPayIntegral,null);
				  }
				  
				  public String getNolevelCurPayIntegral(){
					  return DataType.getAsString(this.get(S_NolevelCurPayIntegral));
					  
				  }
				  public String getNolevelCurPayIntegralInitialValue(){
					  return DataType.getAsString(this.getOldObj(S_NolevelCurPayIntegral));
				  }
				  
				  public void initNolevelCurPayCash(String value){
					  this.initProperty(S_NolevelCurPayCash,value);
				  }
				  public  void setNolevelCurPayCash(String value){
					  this.set(S_NolevelCurPayCash,value);
				  }
				  public  void setNolevelCurPayCashNull(){
					  this.set(S_NolevelCurPayCash,null);
				  }
				  
				  public String getNolevelCurPayCash(){
					  return DataType.getAsString(this.get(S_NolevelCurPayCash));
					  
				  }
				  public String getNolevelCurPayCashInitialValue(){
					  return DataType.getAsString(this.getOldObj(S_NolevelCurPayCash));
				  }
		  
}

