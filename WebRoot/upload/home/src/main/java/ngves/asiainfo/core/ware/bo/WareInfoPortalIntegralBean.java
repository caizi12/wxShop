package ngves.asiainfo.core.ware.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.ware.ivalues.*;

@SuppressWarnings("serial")
public class WareInfoPortalIntegralBean extends DataContainer implements DataContainerInterface,IWareInfoPortalIntegralValue{

  private static String  m_boName = "ngves.asiainfo.core.ware.bo.WareInfoPortalIntegral";



  public final static  String S_Channel = "CHANNEL";
  public final static  String S_CurIntegral = "CUR_INTEGRAL";
  public final static  String S_OriIntegral = "ORI_INTEGRAL";
  public final static  String S_StarLevel = "STAR_LEVEL";
  public final static  String S_Id = "ID";
  public final static  String S_CurPayCash = "CUR_PAY_CASH";
  public final static  String S_OriPayCash = "ORI_PAY_CASH";
  public final static  String S_OriPayIntegral = "ORI_PAY_INTEGRAL";
  public final static  String S_CurPayIntegral = "CUR_PAY_INTEGRAL";
  public final static  String S_WareId = "WARE_ID";
  public WareInfoPortalIntegralBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("");
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

  public void initId(long value){
     this.initProperty(S_Id,new Long(value));
  }
  public  void setId(long value){
     this.set(S_Id,new Long(value));
  }
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public long getId(){
        return DataType.getAsLong(this.get(S_Id));
  
  }
  public long getIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Id));
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


 
 }

