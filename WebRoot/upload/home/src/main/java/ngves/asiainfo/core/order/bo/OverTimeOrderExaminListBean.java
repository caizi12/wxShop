package ngves.asiainfo.core.order.bo;

import ngves.asiainfo.core.order.ivalues.IOverTimeOrderExaminListValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class OverTimeOrderExaminListBean extends DataContainer implements DataContainerInterface,IOverTimeOrderExaminListValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.order.bo.OverTimeOrderExaminList";



  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_OrderType = "ORDER_TYPE";
  public final static  String S_SubOrderSeq = "SUB_ORDER_SEQ";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_OutDays = "OUT_DAYS";
  public final static  String S_ReceName = "RECE_NAME";
  public final static  String S_UserBrand = "USER_BRAND";
  public final static  String S_OrderSeq = "ORDER_SEQ";
  public final static  String S_Status = "STATUS";
  public final static  String S_UserMobNum = "USER_MOB_NUM";
  public final static  String S_SenderName = "SENDER_NAME";
  public final static  String S_MobNum = "MOB_NUM";
  public OverTimeOrderExaminListBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initBakCol3(String value){
     this.initProperty(S_BakCol3,value);
  }
  public  void setBakCol3(String value){
     this.set(S_BakCol3,value);
  }
  public  void setBakCol3Null(){
     this.set(S_BakCol3,null);
  }

  public String getBakCol3(){
       return DataType.getAsString(this.get(S_BakCol3));
  
  }
  public String getBakCol3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_BakCol3));
      }

  public void initOrderType(String value){
     this.initProperty(S_OrderType,value);
  }
  public  void setOrderType(String value){
     this.set(S_OrderType,value);
  }
  public  void setOrderTypeNull(){
     this.set(S_OrderType,null);
  }

  public String getOrderType(){
       return DataType.getAsString(this.get(S_OrderType));
  
  }
  public String getOrderTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrderType));
      }

  public void initSubOrderSeq(String value){
     this.initProperty(S_SubOrderSeq,value);
  }
  public  void setSubOrderSeq(String value){
     this.set(S_SubOrderSeq,value);
  }
  public  void setSubOrderSeqNull(){
     this.set(S_SubOrderSeq,null);
  }

  public String getSubOrderSeq(){
       return DataType.getAsString(this.get(S_SubOrderSeq));
  
  }
  public String getSubOrderSeqInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SubOrderSeq));
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

  public void initOutDays(String value){
     this.initProperty(S_OutDays,value);
  }
  public  void setOutDays(String value){
     this.set(S_OutDays,value);
  }
  public  void setOutDaysNull(){
     this.set(S_OutDays,null);
  }

  public String getOutDays(){
       return DataType.getAsString(this.get(S_OutDays));
  
  }
  public String getOutDaysInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OutDays));
      }

  public void initReceName(String value){
     this.initProperty(S_ReceName,value);
  }
  public  void setReceName(String value){
     this.set(S_ReceName,value);
  }
  public  void setReceNameNull(){
     this.set(S_ReceName,null);
  }

  public String getReceName(){
       return DataType.getAsString(this.get(S_ReceName));
  
  }
  public String getReceNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ReceName));
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

  public void initOrderSeq(String value){
     this.initProperty(S_OrderSeq,value);
  }
  public  void setOrderSeq(String value){
     this.set(S_OrderSeq,value);
  }
  public  void setOrderSeqNull(){
     this.set(S_OrderSeq,null);
  }

  public String getOrderSeq(){
       return DataType.getAsString(this.get(S_OrderSeq));
  
  }
  public String getOrderSeqInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrderSeq));
      }

  public void initStatus(String value){
     this.initProperty(S_Status,value);
  }
  public  void setStatus(String value){
     this.set(S_Status,value);
  }
  public  void setStatusNull(){
     this.set(S_Status,null);
  }

  public String getStatus(){
       return DataType.getAsString(this.get(S_Status));
  
  }
  public String getStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Status));
      }

  public void initUserMobNum(String value){
     this.initProperty(S_UserMobNum,value);
  }
  public  void setUserMobNum(String value){
     this.set(S_UserMobNum,value);
  }
  public  void setUserMobNumNull(){
     this.set(S_UserMobNum,null);
  }

  public String getUserMobNum(){
       return DataType.getAsString(this.get(S_UserMobNum));
  
  }
  public String getUserMobNumInitialValue(){
        return DataType.getAsString(this.getOldObj(S_UserMobNum));
      }

  public void initSenderName(String value){
     this.initProperty(S_SenderName,value);
  }
  public  void setSenderName(String value){
     this.set(S_SenderName,value);
  }
  public  void setSenderNameNull(){
     this.set(S_SenderName,null);
  }

  public String getSenderName(){
       return DataType.getAsString(this.get(S_SenderName));
  
  }
  public String getSenderNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SenderName));
      }

  public void initMobNum(String value){
     this.initProperty(S_MobNum,value);
  }
  public  void setMobNum(String value){
     this.set(S_MobNum,value);
  }
  public  void setMobNumNull(){
     this.set(S_MobNum,null);
  }

  public String getMobNum(){
       return DataType.getAsString(this.get(S_MobNum));
  
  }
  public String getMobNumInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MobNum));
      }


 
 }

