package ngves.asiainfo.core.ware.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.ware.ivalues.*;

public class QBOMergeWareInfoCheckBean extends DataContainer implements DataContainerInterface,IQBOMergeWareInfoCheckValue{

	private static final long serialVersionUID = -14082454487935448L;



private static String  m_boName = "ngves.asiainfo.core.ware.bo.QBOMergeWareInfoCheck";



  public final static  String S_WareBrandId = "WARE_BRAND_ID";
  public final static  String S_KindName = "KIND_NAME";
  public final static  String S_LastUpdateStaffId = "LAST_UPDATE_STAFF_ID";
  public final static  String S_WareStorageType = "WARE_STORAGE_TYPE";
  public final static  String S_WarehouseId = "WAREHOUSE_ID";
  public final static  String S_CheckTime = "CHECK_TIME";
  public final static  String S_FName = "F_NAME";
  public final static  String S_BigKindName = "BIG_KIND_NAME";
  public final static  String S_Dblink = "DBLINK";
  public final static  String S_CheckDesc = "CHECK_DESC";
  public final static  String S_BusiState = "BUSI_STATE";
  public final static  String S_PartnerName = "PARTNER_NAME";
  public final static  String S_CountType = "COUNT_TYPE";
  public final static  String S_MarketPrice = "MARKET_PRICE";
  public final static  String S_Note = "NOTE";
  public final static  String S_WareCode = "WARE_CODE";
  public final static  String S_PartnerCode = "PARTNER_CODE";
  public final static  String S_WareId = "WARE_ID";
  public final static  String S_DeliverType = "DELIVER_TYPE";
  public final static  String S_Dblink1 = "DBLINK1";
  public final static  String S_BusiWareId = "BUSI_WARE_ID";
  public final static  String S_WareFirstKindId = "WARE_FIRST_KIND_ID";
  public final static  String S_AmendsFee = "AMENDS_FEE";
  public final static  String S_Partner = "PARTNER";
  public final static  String S_BusiId = "BUSI_ID";
  public final static  String S_LastUpdateDate = "LAST_UPDATE_DATE";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_ValidWareNum = "VALID_WARE_NUM";
  public final static  String S_WareKindParentId = "WARE_KIND_PARENT_ID";
  public final static  String S_CountValue = "COUNT_VALUE";
  public final static  String S_FuncDesc = "FUNC_DESC";
  public final static  String S_WareName = "WARE_NAME";
  public final static  String S_ProvinceCode = "PROVINCE_CODE";
  public final static  String S_WareType = "WARE_TYPE";
  public final static  String S_IsDefaultKind = "IS_DEFAULT_KIND";
  public final static  String S_WareKindId = "WARE_KIND_ID";
  public final static  String S_ShopPrice = "SHOP_PRICE";
  public final static  String S_CheckComType = "CHECK_COM_TYPE";
  public final static  String S_WareKindInfoId = "WARE_KIND_INFO_ID";
  public final static  String S_WareKindInfoName = "WARE_KIND_INFO_NAME";
	 

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

	public void initWareKindInfoName(String value){
		this.initProperty(S_WareKindInfoName,value);
	}
	public  void setWareKindInfoName(String value){
		this.set(S_WareKindInfoName,value);
	}
	public  void setWareKindInfoNameNull(){
	     this.set(S_WareKindInfoName,null);
	}

	public String getWareKindInfoName(){
		return DataType.getAsString(this.get(S_WareKindInfoName));
	}
	public String getWareKindInfoNameInitialValue(){
		return DataType.getAsString(this.getOldObj(S_WareKindInfoName));
	}
  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBOMergeWareInfoCheckBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
	 throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initWareBrandId(long value){
     this.initProperty(S_WareBrandId,new Long(value));
  }
  public  void setWareBrandId(long value){
     this.set(S_WareBrandId,new Long(value));
  }
  public  void setWareBrandIdNull(){
     this.set(S_WareBrandId,null);
  }

  public long getWareBrandId(){
        return DataType.getAsLong(this.get(S_WareBrandId));
  
  }
  public long getWareBrandIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_WareBrandId));
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

  public void initLastUpdateStaffId(long value){
     this.initProperty(S_LastUpdateStaffId,new Long(value));
  }
  public  void setLastUpdateStaffId(long value){
     this.set(S_LastUpdateStaffId,new Long(value));
  }
  public  void setLastUpdateStaffIdNull(){
     this.set(S_LastUpdateStaffId,null);
  }

  public long getLastUpdateStaffId(){
        return DataType.getAsLong(this.get(S_LastUpdateStaffId));
  
  }
  public long getLastUpdateStaffIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_LastUpdateStaffId));
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

  public void initWarehouseId(long value){
     this.initProperty(S_WarehouseId,new Long(value));
  }
  public  void setWarehouseId(long value){
     this.set(S_WarehouseId,new Long(value));
  }
  public  void setWarehouseIdNull(){
     this.set(S_WarehouseId,null);
  }

  public long getWarehouseId(){
        return DataType.getAsLong(this.get(S_WarehouseId));
  
  }
  public long getWarehouseIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_WarehouseId));
      }

  public void initCheckTime(String value){
     this.initProperty(S_CheckTime,value);
  }
  public  void setCheckTime(String value){
     this.set(S_CheckTime,value);
  }
  public  void setCheckTimeNull(){
     this.set(S_CheckTime,null);
  }

  public String getCheckTime(){
       return DataType.getAsString(this.get(S_CheckTime));
  
  }
  public String getCheckTimeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CheckTime));
      }

  public void initFName(String value){
     this.initProperty(S_FName,value);
  }
  public  void setFName(String value){
     this.set(S_FName,value);
  }
  public  void setFNameNull(){
     this.set(S_FName,null);
  }

  public String getFName(){
       return DataType.getAsString(this.get(S_FName));
  
  }
  public String getFNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FName));
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

  public void initDblink(String value){
     this.initProperty(S_Dblink,value);
  }
  public  void setDblink(String value){
     this.set(S_Dblink,value);
  }
  public  void setDblinkNull(){
     this.set(S_Dblink,null);
  }

  public String getDblink(){
       return DataType.getAsString(this.get(S_Dblink));
  
  }
  public String getDblinkInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Dblink));
      }

  public void initCheckDesc(String value){
     this.initProperty(S_CheckDesc,value);
  }
  public  void setCheckDesc(String value){
     this.set(S_CheckDesc,value);
  }
  public  void setCheckDescNull(){
     this.set(S_CheckDesc,null);
  }

  public String getCheckDesc(){
       return DataType.getAsString(this.get(S_CheckDesc));
  
  }
  public String getCheckDescInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CheckDesc));
      }

  public void initBusiState(String value){
     this.initProperty(S_BusiState,value);
  }
  public  void setBusiState(String value){
     this.set(S_BusiState,value);
  }
  public  void setBusiStateNull(){
     this.set(S_BusiState,null);
  }

  public String getBusiState(){
       return DataType.getAsString(this.get(S_BusiState));
  
  }
  public String getBusiStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BusiState));
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

  public void initCountType(String value){
     this.initProperty(S_CountType,value);
  }
  public  void setCountType(String value){
     this.set(S_CountType,value);
  }
  public  void setCountTypeNull(){
     this.set(S_CountType,null);
  }

  public String getCountType(){
       return DataType.getAsString(this.get(S_CountType));
  
  }
  public String getCountTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CountType));
      }

  public void initMarketPrice(long value){
     this.initProperty(S_MarketPrice,new Long(value));
  }
  public  void setMarketPrice(long value){
     this.set(S_MarketPrice,new Long(value));
  }
  public  void setMarketPriceNull(){
     this.set(S_MarketPrice,null);
  }

  public long getMarketPrice(){
        return DataType.getAsLong(this.get(S_MarketPrice));
  
  }
  public long getMarketPriceInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_MarketPrice));
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

  public void initWareId(long value){
     this.initProperty(S_WareId,new Long(value));
  }
  public  void setWareId(long value){
     this.set(S_WareId,new Long(value));
  }
  public  void setWareIdNull(){
     this.set(S_WareId,null);
  }

  public long getWareId(){
        return DataType.getAsLong(this.get(S_WareId));
  
  }
  public long getWareIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_WareId));
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

  public void initDblink1(String value){
     this.initProperty(S_Dblink1,value);
  }
  public  void setDblink1(String value){
     this.set(S_Dblink1,value);
  }
  public  void setDblink1Null(){
     this.set(S_Dblink1,null);
  }

  public String getDblink1(){
       return DataType.getAsString(this.get(S_Dblink1));
  
  }
  public String getDblink1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Dblink1));
      }

  public void initBusiWareId(long value){
     this.initProperty(S_BusiWareId,new Long(value));
  }
  public  void setBusiWareId(long value){
     this.set(S_BusiWareId,new Long(value));
  }
  public  void setBusiWareIdNull(){
     this.set(S_BusiWareId,null);
  }

  public long getBusiWareId(){
        return DataType.getAsLong(this.get(S_BusiWareId));
  
  }
  public long getBusiWareIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BusiWareId));
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

  public void initAmendsFee(long value){
     this.initProperty(S_AmendsFee,new Long(value));
  }
  public  void setAmendsFee(long value){
     this.set(S_AmendsFee,new Long(value));
  }
  public  void setAmendsFeeNull(){
     this.set(S_AmendsFee,null);
  }

  public long getAmendsFee(){
        return DataType.getAsLong(this.get(S_AmendsFee));
  
  }
  public long getAmendsFeeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AmendsFee));
      }

  public void initPartner(long value){
     this.initProperty(S_Partner,new Long(value));
  }
  public  void setPartner(long value){
     this.set(S_Partner,new Long(value));
  }
  public  void setPartnerNull(){
     this.set(S_Partner,null);
  }

  public long getPartner(){
        return DataType.getAsLong(this.get(S_Partner));
  
  }
  public long getPartnerInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Partner));
      }

  public void initBusiId(long value){
     this.initProperty(S_BusiId,new Long(value));
  }
  public  void setBusiId(long value){
     this.set(S_BusiId,new Long(value));
  }
  public  void setBusiIdNull(){
     this.set(S_BusiId,null);
  }

  public long getBusiId(){
        return DataType.getAsLong(this.get(S_BusiId));
  
  }
  public long getBusiIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BusiId));
      }

  public void initLastUpdateDate(Timestamp value){
     this.initProperty(S_LastUpdateDate,value);
  }
  public  void setLastUpdateDate(Timestamp value){
     this.set(S_LastUpdateDate,value);
  }
  public  void setLastUpdateDateNull(){
     this.set(S_LastUpdateDate,null);
  }

  public Timestamp getLastUpdateDate(){
        return DataType.getAsDateTime(this.get(S_LastUpdateDate));
  
  }
  public Timestamp getLastUpdateDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_LastUpdateDate));
      }

  public void initStaffName(String value){
     this.initProperty(S_StaffName,value);
  }
  public  void setStaffName(String value){
     this.set(S_StaffName,value);
  }
  public  void setStaffNameNull(){
     this.set(S_StaffName,null);
  }

  public String getStaffName(){
       return DataType.getAsString(this.get(S_StaffName));
  
  }
  public String getStaffNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_StaffName));
      }

  public void initValidWareNum(long value){
     this.initProperty(S_ValidWareNum,new Long(value));
  }
  public  void setValidWareNum(long value){
     this.set(S_ValidWareNum,new Long(value));
  }
  public  void setValidWareNumNull(){
     this.set(S_ValidWareNum,null);
  }

  public long getValidWareNum(){
        return DataType.getAsLong(this.get(S_ValidWareNum));
  
  }
  public long getValidWareNumInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ValidWareNum));
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

  public void initCountValue(long value){
     this.initProperty(S_CountValue,new Long(value));
  }
  public  void setCountValue(long value){
     this.set(S_CountValue,new Long(value));
  }
  public  void setCountValueNull(){
     this.set(S_CountValue,null);
  }

  public long getCountValue(){
        return DataType.getAsLong(this.get(S_CountValue));
  
  }
  public long getCountValueInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_CountValue));
      }

  public void initFuncDesc(String value){
     this.initProperty(S_FuncDesc,value);
  }
  public  void setFuncDesc(String value){
     this.set(S_FuncDesc,value);
  }
  public  void setFuncDescNull(){
     this.set(S_FuncDesc,null);
  }

  public String getFuncDesc(){
       return DataType.getAsString(this.get(S_FuncDesc));
  
  }
  public String getFuncDescInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FuncDesc));
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

  public void initIsDefaultKind(String value){
     this.initProperty(S_IsDefaultKind,value);
  }
  public  void setIsDefaultKind(String value){
     this.set(S_IsDefaultKind,value);
  }
  public  void setIsDefaultKindNull(){
     this.set(S_IsDefaultKind,null);
  }

  public String getIsDefaultKind(){
       return DataType.getAsString(this.get(S_IsDefaultKind));
  
  }
  public String getIsDefaultKindInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsDefaultKind));
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

  public void initShopPrice(long value){
     this.initProperty(S_ShopPrice,new Long(value));
  }
  public  void setShopPrice(long value){
     this.set(S_ShopPrice,new Long(value));
  }
  public  void setShopPriceNull(){
     this.set(S_ShopPrice,null);
  }

  public long getShopPrice(){
        return DataType.getAsLong(this.get(S_ShopPrice));
  
  }
  public long getShopPriceInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ShopPrice));
      }

  public void initCheckComType(String value){
     this.initProperty(S_CheckComType,value);
  }
  public  void setCheckComType(String value){
     this.set(S_CheckComType,value);
  }
  public  void setCheckComTypeNull(){
     this.set(S_CheckComType,null);
  }

  public String getCheckComType(){
       return DataType.getAsString(this.get(S_CheckComType));
  
  }
  public String getCheckComTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CheckComType));
      }


 
 }

