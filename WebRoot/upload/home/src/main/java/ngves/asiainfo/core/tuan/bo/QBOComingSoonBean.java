package ngves.asiainfo.core.tuan.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.tuan.ivalues.IQBOComingSoonValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class QBOComingSoonBean extends DataContainer implements DataContainerInterface,IQBOComingSoonValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 5178930273533156500L;



private static String  m_boName = "ngves.asiainfo.core.tuan.bo.QBOComingSoon";



  public final static  String S_MainPic = "MAIN_PIC";
  public final static  String S_WareName = "WARE_NAME";
  public final static  String S_Url = "URL";
  public final static  String S_Name = "NAME";
  public final static  String S_Discount = "DISCOUNT";
  public final static  String S_TuanId = "TUAN_ID";
  public final static  String S_StartTime = "START_TIME";
  public final static  String S_EndTime = "END_TIME";
  public final static  String S_OriIntegral = "ORI_INTEGRAL";
  public final static  String S_CurIntegral = "CUR_INTEGRAL";
  public final static  String S_TopFlag = "TOP_FLAG";
  
  //混合支付
  public final static String S_PayType = "PAY_TYPE";//tuan_info pay_type
	public final static String S_OriPayIntegral = "ORI_PAY_INTEGRAL";
	public final static String S_OriPayCash = "ORI_PAY_CASH";
	public final static String S_CurPayIntegral = "CUR_PAY_INTEGRAL";
	public final static String S_CurPayCash = "CUR_PAY_CASH";
	public final static String S_WarePayType = "WARE_PAY_TYPE";
	
	public final static String S_Channel = "CHANNEL";
	public final static String S_StarLevel = "STAR_LEVEL";
	
	public void initPayType(String value){
		this.initProperty(S_PayType, value);
	}
	public void setPayType(String value){
		this.set(S_PayType, value);
	}
	public void setPayTypeNull(){
		this.set(S_PayType, null);
	}
    public String getPayType(){
    	return DataType.getAsString(this.get(S_PayType));
    }
    public String getPayTypeInitialValue(){
    	return DataType.getAsString(this.getOldObj(S_PayType));
    }
	public void initWarePayType(String value){
		this.initProperty(S_WarePayType, value);
	}
	public void setWarePayType(String value){
		this.set(S_WarePayType, value);
	}
	public void setWarePayTypeNull(){
		this.set(S_WarePayType, null);
	}
    public String getWarePayType(){
    	return DataType.getAsString(this.get(S_WarePayType));
    }
    public String getWarePayTypeInitialValue(){
    	return DataType.getAsString(this.getOldObj(S_WarePayType));
    }
    
    public void initOriPayIntegral(long value){
    	this.initProperty(S_OriPayIntegral, new Long(value));
    }
    public void setOriPayIntegral(long value){
    	this.set(S_OriPayIntegral, new Long(value));
    }
    public void setOriPayIntegralNull(){
    	this.set(S_OriPayIntegral, null);
    }
    public long getOriPayIntegral(){
    	return DataType.getAsLong(this.get(S_OriPayIntegral));
    }
    public long getOriPayIntegralInitialValue(){
    	return DataType.getAsLong(this.getOldObj(S_OriPayIntegral));
    }
    
    public void initOriPayCash(long value){
    	this.initProperty(S_OriPayCash, new Long(value));
    }
    public void setOriPayCash(long value){
    	this.set(S_OriPayCash, new Long(value));
    }
    public void setOriPayCashNull(){
    	this.set(S_OriPayCash, null);
    }
    public long getOriPayCash(){
    	return DataType.getAsLong(this.get(S_OriPayCash));
    }
    public long getOriPayCashInitialValue(){
    	return DataType.getAsLong(this.getOldObj(S_OriPayCash));
    }
    
    public void initCurPayIntegral(long value){
    	this.initProperty(S_CurPayIntegral, new Long(value));
    }
    public void setCurPayIntegral(long value){
    	this.set(S_CurPayIntegral, new Long(value));
    }
    public void setCurPayIntegralNull(){
    	this.set(S_CurPayIntegral, null);
    }
    public long getCurPayIntegral(){
    	return DataType.getAsLong(this.get(S_CurPayIntegral));
    }
    public long getCurPayIntegralInitialValue(){
    	return DataType.getAsLong(this.getOldObj(S_CurPayIntegral));
    }
    
    public void initCurPayCash(long value){
    	this.initProperty(S_CurPayCash, new Long(value));
    }
    public void setCurPayCash(long value){
    	this.set(S_CurPayCash, new Long(value));
    }
    public void setCurPayCashNull(){
    	this.set(S_CurPayCash, null);
    }
    public long getCurPayCash(){
    	return DataType.getAsLong(this.get(S_CurPayCash));
    }
    public long getCurPayCashInitialValue(){
    	return DataType.getAsLong(this.getOldObj(S_CurPayCash));
    }
    
  public QBOComingSoonBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
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

  public void initDiscount(long value){
     this.initProperty(S_Discount,new Long(value));
  }
  public  void setDiscount(long value){
     this.set(S_Discount,new Long(value));
  }
  public  void setDiscountNull(){
     this.set(S_Discount,null);
  }

  public long getDiscount(){
        return DataType.getAsLong(this.get(S_Discount));
  
  }
  public long getDiscountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Discount));
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
  
	public void initOriIntegral(long value) {
		this.initProperty(S_OriIntegral, new Long(value));
	}

	public void setOriIntegral(long value) {
		this.set(S_OriIntegral, new Long(value));
	}

	public void setOriIntegralNull() {
		this.set(S_OriIntegral, null);
	}

	public long getOriIntegral() {
		return DataType.getAsLong(this.get(S_OriIntegral));

	}

	public long getOriIntegralInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_OriIntegral));
	}
	
	
	public void initCurIntegral(long value) {
		this.initProperty(S_CurIntegral, new Long(value));
	}

	public void setCurIntegral(long value) {
		this.set(S_CurIntegral, new Long(value));
	}

	public void setCurIntegralNull() {
		this.set(S_CurIntegral, null);
	}

	public long getCurIntegral() {
		return DataType.getAsLong(this.get(S_CurIntegral));

	}

	public long getCurIntegralInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_CurIntegral));
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
	
	public void initChannel(String value) {
		this.initProperty(S_Channel, value);
	}

	public void setChannel(String value) {
		this.set(S_Channel, value);
	}

	public void setChannelNull() {
		this.set(S_Channel, null);
	}

	public String getChannel() {
		return DataType.getAsString(this.get(S_Channel));

	}
	public String getChannelInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Channel));
	}

	
	
	public void initStarLevel(String value) {
		this.initProperty(S_StarLevel, value);
	}

	public void setStarLevel(String value) {
		this.set(S_StarLevel, value);
	}

	public void setStarLevelNull() {
		this.set(S_StarLevel, null);
	}

	public String getStarLevel() {
		return DataType.getAsString(this.get(S_StarLevel));

	}
	public String getStarLevelInitialValue() {
		return DataType.getAsString(this.getOldObj(S_StarLevel));
	}
	
  
 }



