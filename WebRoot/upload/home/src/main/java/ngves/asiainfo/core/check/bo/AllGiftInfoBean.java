package ngves.asiainfo.core.check.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.check.ivalues.*;

public class AllGiftInfoBean extends DataContainer implements DataContainerInterface,IAllGiftInfoValue{

	/**
     * 
     */
  private static final long serialVersionUID = 104444L;
	
  private static String  m_boName = "ngves.asiainfo.core.check.bo.AllGiftInfo";



  public final static  String S_IsDctsl = "IS_DCTSL";
  public final static  String S_BigKindName = "BIG_KIND_NAME";
  public final static  String S_IsLbdhje = "IS_LBDHJE";
  public final static  String S_IsDcdhl = "IS_DCDHL";
  public final static  String S_MidKindName = "MID_KIND_NAME";
  public final static  String S_PartnerName = "PARTNER_NAME";
  public final static  String S_AvgBigCt = "AVG_BIG_CT";
  public final static  String S_StartTime = "START_TIME";
  public final static  String S_WareCode = "WARE_CODE";
  public final static  String S_BalFee = "BAL_FEE";
  public final static  String S_PartnerCode = "PARTNER_CODE";
  public final static  String S_AllwaFee = "ALLWA_FEE";
  public final static  String S_AvgSmlCt = "AVG_SML_CT";
  public final static  String S_AvgDsc = "AVG_DSC";
  public final static  String S_IsLbdhl = "IS_LBDHL";
  public final static  String S_TsRate = "TS_RATE";
  public final static  String S_Wamount = "WAMOUNT";
  public final static  String S_WareStatus = "WARE_STATUS";
  public final static  String S_StatusCause = "STATUS_CAUSE";
  public final static  String S_MartFee = "MART_FEE";
  public final static  String S_AvgAllCt = "AVG_ALL_CT";
  public final static  String S_FeeDc = "FEE_DC";
  public final static  String S_AvgMidCt = "AVG_MID_CT";
  public final static  String S_TsCount = "TS_COUNT";
  public final static  String S_IsLbtsl = "IS_LBTSL";
  public final static  String S_EndTime = "END_TIME";
  public final static  String S_WareName = "WARE_NAME";
  public final static  String S_SmlKindName = "SML_KIND_NAME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public AllGiftInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initIsDctsl(String value){
     this.initProperty(S_IsDctsl,value);
  }
  public  void setIsDctsl(String value){
     this.set(S_IsDctsl,value);
  }
  public  void setIsDctslNull(){
     this.set(S_IsDctsl,null);
  }

  public String getIsDctsl(){
       return DataType.getAsString(this.get(S_IsDctsl));
  
  }
  public String getIsDctslInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsDctsl));
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

  public void initIsLbdhje(String value){
     this.initProperty(S_IsLbdhje,value);
  }
  public  void setIsLbdhje(String value){
     this.set(S_IsLbdhje,value);
  }
  public  void setIsLbdhjeNull(){
     this.set(S_IsLbdhje,null);
  }

  public String getIsLbdhje(){
       return DataType.getAsString(this.get(S_IsLbdhje));
  
  }
  public String getIsLbdhjeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsLbdhje));
      }

  public void initIsDcdhl(String value){
     this.initProperty(S_IsDcdhl,value);
  }
  public  void setIsDcdhl(String value){
     this.set(S_IsDcdhl,value);
  }
  public  void setIsDcdhlNull(){
     this.set(S_IsDcdhl,null);
  }

  public String getIsDcdhl(){
       return DataType.getAsString(this.get(S_IsDcdhl));
  
  }
  public String getIsDcdhlInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsDcdhl));
      }

  public void initMidKindName(String value){
     this.initProperty(S_MidKindName,value);
  }
  public  void setMidKindName(String value){
     this.set(S_MidKindName,value);
  }
  public  void setMidKindNameNull(){
     this.set(S_MidKindName,null);
  }

  public String getMidKindName(){
       return DataType.getAsString(this.get(S_MidKindName));
  
  }
  public String getMidKindNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MidKindName));
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

  public void initAvgBigCt(long value){
     this.initProperty(S_AvgBigCt,new Long(value));
  }
  public  void setAvgBigCt(long value){
     this.set(S_AvgBigCt,new Long(value));
  }
  public  void setAvgBigCtNull(){
     this.set(S_AvgBigCt,null);
  }

  public long getAvgBigCt(){
        return DataType.getAsLong(this.get(S_AvgBigCt));
  
  }
  public long getAvgBigCtInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AvgBigCt));
      }

  public void initStartTime(String value){
     this.initProperty(S_StartTime,value);
  }
  public  void setStartTime(String value){
     this.set(S_StartTime,value);
  }
  public  void setStartTimeNull(){
     this.set(S_StartTime,null);
  }

  public String getStartTime(){
       return DataType.getAsString(this.get(S_StartTime));
  
  }
  public String getStartTimeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_StartTime));
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

  public void initBalFee(long value){
     this.initProperty(S_BalFee,new Double(value));
  }
  public  void setBalFee(double value){
     this.set(S_BalFee,new Double(value));
  }
  public  void setBalFeeNull(){
     this.set(S_BalFee,null);
  }

  public double getBalFee(){
        return DataType.getAsDouble(this.get(S_BalFee));
  
  }
  public double getBalFeeInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_BalFee));
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

  public void initAllwaFee(long value){
     this.initProperty(S_AllwaFee,new Long(value));
  }
  public  void setAllwaFee(long value){
     this.set(S_AllwaFee,new Long(value));
  }
  public  void setAllwaFeeNull(){
     this.set(S_AllwaFee,null);
  }

  public long getAllwaFee(){
        return DataType.getAsLong(this.get(S_AllwaFee));
  
  }
  public long getAllwaFeeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AllwaFee));
      }

  public void initAvgSmlCt(long value){
     this.initProperty(S_AvgSmlCt,new Long(value));
  }
  public  void setAvgSmlCt(long value){
     this.set(S_AvgSmlCt,new Long(value));
  }
  public  void setAvgSmlCtNull(){
     this.set(S_AvgSmlCt,null);
  }

  public long getAvgSmlCt(){
        return DataType.getAsLong(this.get(S_AvgSmlCt));
  
  }
  public long getAvgSmlCtInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AvgSmlCt));
      }

  public void initAvgDsc(String value){
     this.initProperty(S_AvgDsc,value);
  }
  public  void setAvgDsc(String value){
     this.set(S_AvgDsc,value);
  }
  public  void setAvgDscNull(){
     this.set(S_AvgDsc,null);
  }

  public String getAvgDsc(){
       return DataType.getAsString(this.get(S_AvgDsc));
  
  }
  public String getAvgDscInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AvgDsc));
      }

  public void initIsLbdhl(String value){
     this.initProperty(S_IsLbdhl,value);
  }
  public  void setIsLbdhl(String value){
     this.set(S_IsLbdhl,value);
  }
  public  void setIsLbdhlNull(){
     this.set(S_IsLbdhl,null);
  }

  public String getIsLbdhl(){
       return DataType.getAsString(this.get(S_IsLbdhl));
  
  }
  public String getIsLbdhlInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsLbdhl));
      }

  public void initTsRate(long value){
     this.initProperty(S_TsRate,new Double(value));
  }
  public  void setTsRate(double value){
     this.set(S_TsRate,new Double(value));
  }
  public  void setTsRateNull(){
     this.set(S_TsRate,null);
  }

  public double getTsRate(){
        return DataType.getAsDouble(this.get(S_TsRate));
  
  }
  public double getTsRateInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_TsRate));
      }

  public void initWamount(long value){
     this.initProperty(S_Wamount,new Long(value));
  }
  public  void setWamount(long value){
     this.set(S_Wamount,new Long(value));
  }
  public  void setWamountNull(){
     this.set(S_Wamount,null);
  }

  public long getWamount(){
        return DataType.getAsLong(this.get(S_Wamount));
  
  }
  public long getWamountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Wamount));
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

  public void initMartFee(long value){
     this.initProperty(S_MartFee,new Double(value));
  }
  public  void setMartFee(double value){
     this.set(S_MartFee,new Double(value));
  }
  public  void setMartFeeNull(){
     this.set(S_MartFee,null);
  }

  public double getMartFee(){
        return DataType.getAsDouble(this.get(S_MartFee));
  
  }
  public double getMartFeeInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_MartFee));
      }

  public void initAvgAllCt(long value){
     this.initProperty(S_AvgAllCt,new Long(value));
  }
  public  void setAvgAllCt(long value){
     this.set(S_AvgAllCt,new Long(value));
  }
  public  void setAvgAllCtNull(){
     this.set(S_AvgAllCt,null);
  }

  public long getAvgAllCt(){
        return DataType.getAsLong(this.get(S_AvgAllCt));
  
  }
  public long getAvgAllCtInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AvgAllCt));
      }

  public void initFeeDc(String value){
     this.initProperty(S_FeeDc,value);
  }
  public  void setFeeDc(String value){
     this.set(S_FeeDc,value);
  }
  public  void setFeeDcNull(){
     this.set(S_FeeDc,null);
  }

  public String getFeeDc(){
       return DataType.getAsString(this.get(S_FeeDc));
  
  }
  public String getFeeDcInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FeeDc));
      }

  public void initAvgMidCt(long value){
     this.initProperty(S_AvgMidCt,new Long(value));
  }
  public  void setAvgMidCt(long value){
     this.set(S_AvgMidCt,new Long(value));
  }
  public  void setAvgMidCtNull(){
     this.set(S_AvgMidCt,null);
  }

  public long getAvgMidCt(){
        return DataType.getAsLong(this.get(S_AvgMidCt));
  
  }
  public long getAvgMidCtInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AvgMidCt));
      }

  public void initTsCount(long value){
     this.initProperty(S_TsCount,new Long(value));
  }
  public  void setTsCount(long value){
     this.set(S_TsCount,new Long(value));
  }
  public  void setTsCountNull(){
     this.set(S_TsCount,null);
  }

  public long getTsCount(){
        return DataType.getAsLong(this.get(S_TsCount));
  
  }
  public long getTsCountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TsCount));
      }

  public void initIsLbtsl(String value){
     this.initProperty(S_IsLbtsl,value);
  }
  public  void setIsLbtsl(String value){
     this.set(S_IsLbtsl,value);
  }
  public  void setIsLbtslNull(){
     this.set(S_IsLbtsl,null);
  }

  public String getIsLbtsl(){
       return DataType.getAsString(this.get(S_IsLbtsl));
  
  }
  public String getIsLbtslInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsLbtsl));
      }

  public void initEndTime(String value){
     this.initProperty(S_EndTime,value);
  }
  public  void setEndTime(String value){
     this.set(S_EndTime,value);
  }
  public  void setEndTimeNull(){
     this.set(S_EndTime,null);
  }

  public String getEndTime(){
       return DataType.getAsString(this.get(S_EndTime));
  
  }
  public String getEndTimeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_EndTime));
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

  public void initSmlKindName(String value){
     this.initProperty(S_SmlKindName,value);
  }
  public  void setSmlKindName(String value){
     this.set(S_SmlKindName,value);
  }
  public  void setSmlKindNameNull(){
     this.set(S_SmlKindName,null);
  }

  public String getSmlKindName(){
       return DataType.getAsString(this.get(S_SmlKindName));
  
  }
  public String getSmlKindNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SmlKindName));
      }


 
 }

