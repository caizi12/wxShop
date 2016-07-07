package ngves.asiainfo.core.ticket.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.ticket.ivalues.*;

public class TicketThirdInfoBean extends DataContainer implements DataContainerInterface,ITicketThirdInfoValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = -7554666456708625173L;



private static String  m_boName = "ngves.asiainfo.core.ticket.bo.TicketThirdInfo";



  public final static  String S_TicketPrice = "TICKET_PRICE";
  public final static  String S_MovieName = "MOVIE_NAME";
  public final static  String S_LockEndTime = "LOCK_END_TIME";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_MobileNum = "MOBILE_NUM";
  public final static  String S_PWareCode = "P_WARE_CODE";
  public final static  String S_SeatNumList = "SEAT_NUM_LIST";
  public final static  String S_LockPeriod = "LOCK_PERIOD";
  public final static  String S_Md5Code = "MD5_CODE";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_TicketThirdId = "TICKET_THIRD_ID";
  public final static  String S_WareId = "WARE_ID";
  public final static  String S_TicketNum = "TICKET_NUM";
  public final static  String S_SequenceNum = "SEQUENCE_NUM";
  public final static  String S_ShowTime = "SHOW_TIME";
  public final static  String S_TicketMainKey = "TICKET_MAIN_KEY";

  public final static String S_TicketStartTime = "TICKET_START_TIME";
  
  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public TicketThirdInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initTicketPrice(String value){
     this.initProperty(S_TicketPrice,value);
  }
  public  void setTicketPrice(String value){
     this.set(S_TicketPrice,value);
  }
  public  void setTicketPriceNull(){
     this.set(S_TicketPrice,null);
  }

  public String getTicketPrice(){
       return DataType.getAsString(this.get(S_TicketPrice));
  
  }
  public String getTicketPriceInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TicketPrice));
      }

  public void initMovieName(String value){
     this.initProperty(S_MovieName,value);
  }
  public  void setMovieName(String value){
     this.set(S_MovieName,value);
  }
  public  void setMovieNameNull(){
     this.set(S_MovieName,null);
  }

  public String getMovieName(){
       return DataType.getAsString(this.get(S_MovieName));
  
  }
  public String getMovieNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MovieName));
      }

  public void initLockEndTime(Timestamp value){
     this.initProperty(S_LockEndTime,value);
  }
  public  void setLockEndTime(Timestamp value){
     this.set(S_LockEndTime,value);
  }
  public  void setLockEndTimeNull(){
     this.set(S_LockEndTime,null);
  }

  public Timestamp getLockEndTime(){
        return DataType.getAsDateTime(this.get(S_LockEndTime));
  
  }
  public Timestamp getLockEndTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_LockEndTime));
      }

  public void initBakCol1(String value){
     this.initProperty(S_BakCol1,value);
  }
  public  void setBakCol1(String value){
     this.set(S_BakCol1,value);
  }
  public  void setBakCol1Null(){
     this.set(S_BakCol1,null);
  }

  public String getBakCol1(){
       return DataType.getAsString(this.get(S_BakCol1));
  
  }
  public String getBakCol1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_BakCol1));
      }

  public void initMobileNum(String value){
     this.initProperty(S_MobileNum,value);
  }
  public  void setMobileNum(String value){
     this.set(S_MobileNum,value);
  }
  public  void setMobileNumNull(){
     this.set(S_MobileNum,null);
  }

  public String getMobileNum(){
       return DataType.getAsString(this.get(S_MobileNum));
  
  }
  public String getMobileNumInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MobileNum));
      }

  public void initPWareCode(String value){
     this.initProperty(S_PWareCode,value);
  }
  public  void setPWareCode(String value){
     this.set(S_PWareCode,value);
  }
  public  void setPWareCodeNull(){
     this.set(S_PWareCode,null);
  }

  public String getPWareCode(){
       return DataType.getAsString(this.get(S_PWareCode));
  
  }
  public String getPWareCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PWareCode));
      }

  public void initSeatNumList(String value){
     this.initProperty(S_SeatNumList,value);
  }
  public  void setSeatNumList(String value){
     this.set(S_SeatNumList,value);
  }
  public  void setSeatNumListNull(){
     this.set(S_SeatNumList,null);
  }

  public String getSeatNumList(){
       return DataType.getAsString(this.get(S_SeatNumList));
  
  }
  public String getSeatNumListInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SeatNumList));
      }

  public void initLockPeriod(long value){
     this.initProperty(S_LockPeriod,new Long(value));
  }
  public  void setLockPeriod(long value){
     this.set(S_LockPeriod,new Long(value));
  }
  public  void setLockPeriodNull(){
     this.set(S_LockPeriod,null);
  }

  public long getLockPeriod(){
        return DataType.getAsLong(this.get(S_LockPeriod));
  
  }
  public long getLockPeriodInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_LockPeriod));
      }

  public void initMd5Code(String value){
     this.initProperty(S_Md5Code,value);
  }
  public  void setMd5Code(String value){
     this.set(S_Md5Code,value);
  }
  public  void setMd5CodeNull(){
     this.set(S_Md5Code,null);
  }

  public String getMd5Code(){
       return DataType.getAsString(this.get(S_Md5Code));
  
  }
  public String getMd5CodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Md5Code));
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

  public void initTicketThirdId(long value){
     this.initProperty(S_TicketThirdId,new Long(value));
  }
  public  void setTicketThirdId(long value){
     this.set(S_TicketThirdId,new Long(value));
  }
  public  void setTicketThirdIdNull(){
     this.set(S_TicketThirdId,null);
  }

  public long getTicketThirdId(){
        return DataType.getAsLong(this.get(S_TicketThirdId));
  
  }
  public long getTicketThirdIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TicketThirdId));
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

  public void initTicketNum(long value){
     this.initProperty(S_TicketNum,new Long(value));
  }
  public  void setTicketNum(long value){
     this.set(S_TicketNum,new Long(value));
  }
  public  void setTicketNumNull(){
     this.set(S_TicketNum,null);
  }

  public long getTicketNum(){
        return DataType.getAsLong(this.get(S_TicketNum));
  
  }
  public long getTicketNumInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TicketNum));
      }

  public void initSequenceNum(String value){
     this.initProperty(S_SequenceNum,value);
  }
  public  void setSequenceNum(String value){
     this.set(S_SequenceNum,value);
  }
  public  void setSequenceNumNull(){
     this.set(S_SequenceNum,null);
  }

  public String getSequenceNum(){
       return DataType.getAsString(this.get(S_SequenceNum));
  
  }
  public String getSequenceNumInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SequenceNum));
      }

  public void initShowTime(String value){
     this.initProperty(S_ShowTime,value);
  }
  public  void setShowTime(String value){
     this.set(S_ShowTime,value);
  }
  public  void setShowTimeNull(){
     this.set(S_ShowTime,null);
  }

  public String getShowTime(){
       return DataType.getAsString(this.get(S_ShowTime));
  
  }
  public String getShowTimeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ShowTime));
      }

  public void initTicketMainKey(String value){
     this.initProperty(S_TicketMainKey,value);
  }
  public  void setTicketMainKey(String value){
     this.set(S_TicketMainKey,value);
  }
  public  void setTicketMainKeyNull(){
     this.set(S_TicketMainKey,null);
  }

  public String getTicketMainKey(){
       return DataType.getAsString(this.get(S_TicketMainKey));
  
  }
  public String getTicketMainKeyInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TicketMainKey));
      }

  public void initTicketStartTime(Timestamp value){
	     this.initProperty(S_TicketStartTime,value);
	  }
	  public  void setTicketStartTime(Timestamp value){
	     this.set(S_TicketStartTime,value);
	  }
	  public  void setTicketStartTimeNull(){
	     this.set(S_TicketStartTime,null);
	  }

	  public Timestamp getTicketStartTime(){
	        return DataType.getAsDateTime(this.get(S_TicketStartTime));
	  
	  }
	  public Timestamp getTicketStartTimeInitialValue(){
	        return DataType.getAsDateTime(this.getOldObj(S_TicketStartTime));
	      }

 
 }

