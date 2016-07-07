package ngves.asiainfo.core.rushbuy.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.rushbuy.ivalues.IQBOActivityBindRelationValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

@SuppressWarnings("serial")
public class QBOActivityBindRelationBean extends DataContainer implements DataContainerInterface,IQBOActivityBindRelationValue{

  private static String  m_boName = "ngves.asiainfo.core.rushbuy.bo.QBOActivityBindRelation";



  public final static  String S_BaseMaxAmount = "BASE_MAX_AMOUNT";
  public final static  String S_OneMaxAmount = "ONE_MAX_AMOUNT";
  public final static  String S_GrantMaxAmount = "GRANT_MAX_AMOUNT";
  public final static  String S_OriIntegral = "ORI_INTEGRAL";
  public final static  String S_BindTime = "BIND_TIME";
  public final static  String S_WareName = "WARE_NAME";
  public final static  String S_ActivityId = "ACTIVITY_ID";
  public final static  String S_CurPayCash = "CUR_PAY_CASH";
  public final static  String S_ActivityName = "ACTIVITY_NAME";
  public final static  String S_OriPayCash = "ORI_PAY_CASH";
  public final static  String S_OriPayIntegral = "ORI_PAY_INTEGRAL";
  public final static  String S_WareId = "WARE_ID";
  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_CurIntegral = "CUR_INTEGRAL";
  public final static  String S_Sort = "SORT";
  public final static  String S_PayType = "PAY_TYPE";
  public final static  String S_WarePayType = "WARE_PAY_TYPE";
  public final static  String S_ActivityRelationId = "ACTIVITY_RELATION_ID";
  public final static  String S_CurPayIntegral = "CUR_PAY_INTEGRAL";
  public final static  String S_StarLevel = "STAR_LEVEL";
  public final static  String S_Channel = "CHANNEL";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBOActivityBindRelationBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initBaseMaxAmount(long value){
     this.initProperty(S_BaseMaxAmount,new Long(value));
  }
  public  void setBaseMaxAmount(long value){
     this.set(S_BaseMaxAmount,new Long(value));
  }
  public  void setBaseMaxAmountNull(){
     this.set(S_BaseMaxAmount,null);
  }

  public long getBaseMaxAmount(){
        return DataType.getAsLong(this.get(S_BaseMaxAmount));
  
  }
  public long getBaseMaxAmountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BaseMaxAmount));
      }

  public void initGrantMaxAmount(long value){
     this.initProperty(S_GrantMaxAmount,new Long(value));
  }
  public  void setGrantMaxAmount(long value){
     this.set(S_GrantMaxAmount,new Long(value));
  }
  public  void setGrantMaxAmountNull(){
     this.set(S_GrantMaxAmount,null);
  }

  public long getGrantMaxAmount(){
        return DataType.getAsLong(this.get(S_GrantMaxAmount));
  
  }
  public long getGrantMaxAmountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_GrantMaxAmount));
      }

  public void initOriIntegral(long value){
     this.initProperty(S_OriIntegral,new Long(value));
  }
  public  void setOriIntegral(long value){
     this.set(S_OriIntegral,new Long(value));
  }
  public  void setOriIntegralNull(){
     this.set(S_OriIntegral,null);
  }

  public long getOriIntegral(){
        return DataType.getAsLong(this.get(S_OriIntegral));
  
  }
  public long getOriIntegralInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OriIntegral));
      }

  public void initBindTime(Timestamp value){
     this.initProperty(S_BindTime,value);
  }
  public  void setBindTime(Timestamp value){
     this.set(S_BindTime,value);
  }
  public  void setBindTimeNull(){
     this.set(S_BindTime,null);
  }

  public Timestamp getBindTime(){
        return DataType.getAsDateTime(this.get(S_BindTime));
  
  }
  public Timestamp getBindTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_BindTime));
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

  public void initActivityId(long value){
     this.initProperty(S_ActivityId,new Long(value));
  }
  public  void setActivityId(long value){
     this.set(S_ActivityId,new Long(value));
  }
  public  void setActivityIdNull(){
     this.set(S_ActivityId,null);
  }

  public long getActivityId(){
        return DataType.getAsLong(this.get(S_ActivityId));
  
  }
  public long getActivityIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ActivityId));
      }

  public void initCurPayCash(long value){
     this.initProperty(S_CurPayCash,new Long(value));
  }
  public  void setCurPayCash(long value){
     this.set(S_CurPayCash,new Long(value));
  }
  public  void setCurPayCashNull(){
     this.set(S_CurPayCash,null);
  }

  public long getCurPayCash(){
        return DataType.getAsLong(this.get(S_CurPayCash));
  
  }
  public long getCurPayCashInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_CurPayCash));
      }

  public void initActivityName(String value){
     this.initProperty(S_ActivityName,value);
  }
  public  void setActivityName(String value){
     this.set(S_ActivityName,value);
  }
  public  void setActivityNameNull(){
     this.set(S_ActivityName,null);
  }

  public String getActivityName(){
       return DataType.getAsString(this.get(S_ActivityName));
  
  }
  public String getActivityNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ActivityName));
      }

  public void initOriPayCash(long value){
     this.initProperty(S_OriPayCash,new Long(value));
  }
  public  void setOriPayCash(long value){
     this.set(S_OriPayCash,new Long(value));
  }
  public  void setOriPayCashNull(){
     this.set(S_OriPayCash,null);
  }

  public long getOriPayCash(){
        return DataType.getAsLong(this.get(S_OriPayCash));
  
  }
  public long getOriPayCashInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OriPayCash));
      }

  public void initOriPayIntegral(long value){
     this.initProperty(S_OriPayIntegral,new Long(value));
  }
  public  void setOriPayIntegral(long value){
     this.set(S_OriPayIntegral,new Long(value));
  }
  public  void setOriPayIntegralNull(){
     this.set(S_OriPayIntegral,null);
  }

  public long getOriPayIntegral(){
        return DataType.getAsLong(this.get(S_OriPayIntegral));
  
  }
  public long getOriPayIntegralInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OriPayIntegral));
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

  public void initBakCol(String value){
     this.initProperty(S_BakCol,value);
  }
  public  void setBakCol(String value){
     this.set(S_BakCol,value);
  }
  public  void setBakColNull(){
     this.set(S_BakCol,null);
  }

  public String getBakCol(){
       return DataType.getAsString(this.get(S_BakCol));
  
  }
  public String getBakColInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BakCol));
      }

  public void initCurIntegral(long value){
     this.initProperty(S_CurIntegral,new Long(value));
  }
  public  void setCurIntegral(long value){
     this.set(S_CurIntegral,new Long(value));
  }
  public  void setCurIntegralNull(){
     this.set(S_CurIntegral,null);
  }

  public long getCurIntegral(){
        return DataType.getAsLong(this.get(S_CurIntegral));
  
  }
  public long getCurIntegralInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_CurIntegral));
      }

  public void initSort(long value){
     this.initProperty(S_Sort,new Long(value));
  }
  public  void setSort(long value){
     this.set(S_Sort,new Long(value));
  }
  public  void setSortNull(){
     this.set(S_Sort,null);
  }

  public long getSort(){
        return DataType.getAsLong(this.get(S_Sort));
  
  }
  public long getSortInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Sort));
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

  public void initWarePayType(String value){
     this.initProperty(S_WarePayType,value);
  }
  public  void setWarePayType(String value){
     this.set(S_WarePayType,value);
  }
  public  void setWarePayTypeNull(){
     this.set(S_WarePayType,null);
  }

  public String getWarePayType(){
       return DataType.getAsString(this.get(S_WarePayType));
  
  }
  public String getWarePayTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WarePayType));
      }

  public void initActivityRelationId(long value){
     this.initProperty(S_ActivityRelationId,new Long(value));
  }
  public  void setActivityRelationId(long value){
     this.set(S_ActivityRelationId,new Long(value));
  }
  public  void setActivityRelationIdNull(){
     this.set(S_ActivityRelationId,null);
  }

  public long getActivityRelationId(){
        return DataType.getAsLong(this.get(S_ActivityRelationId));
  
  }
  public long getActivityRelationIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ActivityRelationId));
      }

  public void initCurPayIntegral(long value){
     this.initProperty(S_CurPayIntegral,new Long(value));
  }
  public  void setCurPayIntegral(long value){
     this.set(S_CurPayIntegral,new Long(value));
  }
  public  void setCurPayIntegralNull(){
     this.set(S_CurPayIntegral,null);
  }

  public long getCurPayIntegral(){
        return DataType.getAsLong(this.get(S_CurPayIntegral));
  
  }
  public long getCurPayIntegralInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_CurPayIntegral));
      }
  
  
  
  public void initOneMaxAmount(long value){
	     this.initProperty(S_OneMaxAmount,new Long(value));
	  }
	  public  void setOneMaxAmount(long value){
	     this.set(S_OneMaxAmount,new Long(value));
	  }
	  public  void setOneMaxAmountNull(){
	     this.set(S_OneMaxAmount,null);
	  }

	  public long getOneMaxAmount(){
	        return DataType.getAsLong(this.get(S_OneMaxAmount));
	  
	  }
	  public long getOneMaxAmountInitialValue(){
	        return DataType.getAsLong(this.getOldObj(S_OneMaxAmount));
	      }

	  
	  public void initStarLevel(String value){
		     this.initProperty(S_StarLevel,value);
		  }
		  public  void setStarLevel(String value){
		     this.set(S_StarLevel,value);
		  }
		  public  void setStarLevelNull(){
		     this.set(S_StarLevel,null);
		  }

		  public String getStarLevel(){
		       return DataType.getAsString(this.get(S_StarLevel));
		  
		  }
		  public String getStarLevelInitialValue(){
		        return DataType.getAsString(this.getOldObj(S_StarLevel));
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


 
 }

