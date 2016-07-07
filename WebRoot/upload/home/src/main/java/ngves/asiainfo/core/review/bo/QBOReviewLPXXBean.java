package ngves.asiainfo.core.review.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.review.ivalues.*;

@SuppressWarnings("serial")
public class QBOReviewLPXXBean extends DataContainer implements DataContainerInterface,IQBOReviewLPXXValue{

  private static String  m_boName = "ngves.asiainfo.core.review.bo.QBOReviewLPXX";



  public final static  String S_PriorityOnline = "PRIORITY_ONLINE";
  public final static  String S_WareName = "WARE_NAME";
  public final static  String S_BigKindName = "BIG_KIND_NAME";
  public final static  String S_MarketPrice = "MARKET_PRICE";
  public final static  String S_WareIntegralValue = "WARE_INTEGRAL_VALUE";
  public final static  String S_WareId = "WARE_ID";
  public final static  String S_FName = "F_NAME";
  public final static  String S_PartnerCode = "PARTNER_CODE";
  public final static  String S_CountValue = "COUNT_VALUE";
  public final static  String S_PartnerName = "PARTNER_NAME";
  public final static  String S_PriorityOffline = "PRIORITY_OFFLINE";
  public final static  String S_KindName = "KIND_NAME";
  public final static  String S_WareCode = "WARE_CODE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBOReviewLPXXBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
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

  public void initWareIntegralValue(long value){
     this.initProperty(S_WareIntegralValue,new Long(value));
  }
  public  void setWareIntegralValue(long value){
     this.set(S_WareIntegralValue,new Long(value));
  }
  public  void setWareIntegralValueNull(){
     this.set(S_WareIntegralValue,null);
  }

  public long getWareIntegralValue(){
        return DataType.getAsLong(this.get(S_WareIntegralValue));
  
  }
  public long getWareIntegralValueInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_WareIntegralValue));
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
  public void initPriorityOffline(String value){
		this.initProperty(S_PriorityOffline,value);
	}
	public  void setPriorityOffline(String value){
		this.set(S_PriorityOffline,value);
	}
	public  void setPriorityOfflineNull(){
		this.set(S_PriorityOffline,null);
	}

	public String getPriorityOffline(){
		return DataType.getAsString(this.get(S_PriorityOffline));

	}
	public String getPriorityOfflineInitialValue(){
		return DataType.getAsString(this.getOldObj(S_PriorityOffline));
	}
	public void initPriorityOnline(String value){
		this.initProperty(S_PriorityOnline,value);
	}
	public  void setPriorityOnline(String value){
		this.set(S_PriorityOnline,value);
	}
	public  void setPriorityOnlineNull(){
		this.set(S_PriorityOnline,null);
	}

	public String getPriorityOnline(){
		return DataType.getAsString(this.get(S_PriorityOnline));

	}
	public String getPriorityOnlineInitialValue(){
		return DataType.getAsString(this.getOldObj(S_PriorityOnline));
	}
 
 }

