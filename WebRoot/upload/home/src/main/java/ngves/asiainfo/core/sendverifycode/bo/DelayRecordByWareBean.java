package ngves.asiainfo.core.sendverifycode.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.sendverifycode.ivalues.*;

public class DelayRecordByWareBean extends DataContainer implements DataContainerInterface,IDelayRecordByWareValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1125861876456690565L;



private static String  m_boName = "ngves.asiainfo.core.sendverifycode.bo.DelayRecordByWare";



  public final static  String S_Days = "DAYS";
  public final static  String S_ExtendType = "EXTEND_TYPE";
  public final static  String S_OrderNum = "ORDER_NUM";
  public final static  String S_Comments = "COMMENTS";
  public final static  String S_Opera = "OPERA";
  public final static  String S_OrdOprEtime = "ORD_OPR_ETIME";
  public final static  String S_ItemId = "ITEM_ID";
  public final static  String S_OrdOprStime = "ORD_OPR_STIME";
  public final static  String S_OperateTime = "OPERATE_TIME";
  public final static  String S_ValidateStime = "VALIDATE_STIME";
  public final static  String S_ValidateEtime = "VALIDATE_ETIME";
  public final static  String S_ItemExtendId = "ITEM_EXTEND_ID";
  public final static  String S_NewValidateTime = "NEW_VALIDATE_TIME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public DelayRecordByWareBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("The data container cannot reset the business object type!");
 }


  public void initDays(long value){
     this.initProperty(S_Days,new Long(value));
  }
  public  void setDays(long value){
     this.set(S_Days,new Long(value));
  }
  public  void setDaysNull(){
     this.set(S_Days,null);
  }

  public long getDays(){
       return DataType.getAsLong(this.get(S_Days));
  
  }
  public long getDaysInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Days));
      }

  public void initExtendType(String value){
     this.initProperty(S_ExtendType,value);
  }
  public  void setExtendType(String value){
     this.set(S_ExtendType,value);
  }
  public  void setExtendTypeNull(){
     this.set(S_ExtendType,null);
  }

  public String getExtendType(){
       return DataType.getAsString(this.get(S_ExtendType));
  
  }
  public String getExtendTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExtendType));
      }

  public void initOrderNum(long value){
     this.initProperty(S_OrderNum,new Long(value));
  }
  public  void setOrderNum(long value){
     this.set(S_OrderNum,new Long(value));
  }
  public  void setOrderNumNull(){
     this.set(S_OrderNum,null);
  }

  public long getOrderNum(){
       return DataType.getAsLong(this.get(S_OrderNum));
  
  }
  public long getOrderNumInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OrderNum));
      }

  public void initComments(String value){
     this.initProperty(S_Comments,value);
  }
  public  void setComments(String value){
     this.set(S_Comments,value);
  }
  public  void setCommentsNull(){
     this.set(S_Comments,null);
  }

  public String getComments(){
       return DataType.getAsString(this.get(S_Comments));
  
  }
  public String getCommentsInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Comments));
      }

  public void initOpera(String value){
     this.initProperty(S_Opera,value);
  }
  public  void setOpera(String value){
     this.set(S_Opera,value);
  }
  public  void setOperaNull(){
     this.set(S_Opera,null);
  }

  public String getOpera(){
       return DataType.getAsString(this.get(S_Opera));
  
  }
  public String getOperaInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Opera));
      }

  public void initOrdOprEtime(String value){
     this.initProperty(S_OrdOprEtime,value);
  }
  public  void setOrdOprEtime(String value){
     this.set(S_OrdOprEtime,value);
  }
  public  void setOrdOprEtimeNull(){
     this.set(S_OrdOprEtime,null);
  }

  public String getOrdOprEtime(){
       return DataType.getAsString(this.get(S_OrdOprEtime));
  
  }
  public String getOrdOprEtimeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrdOprEtime));
      }

  public void initItemId(String value){
     this.initProperty(S_ItemId,value);
  }
  public  void setItemId(String value){
     this.set(S_ItemId,value);
  }
  public  void setItemIdNull(){
     this.set(S_ItemId,null);
  }

  public String getItemId(){
       return DataType.getAsString(this.get(S_ItemId));
  
  }
  public String getItemIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ItemId));
      }

  public void initOrdOprStime(String value){
     this.initProperty(S_OrdOprStime,value);
  }
  public  void setOrdOprStime(String value){
     this.set(S_OrdOprStime,value);
  }
  public  void setOrdOprStimeNull(){
     this.set(S_OrdOprStime,null);
  }

  public String getOrdOprStime(){
       return DataType.getAsString(this.get(S_OrdOprStime));
  
  }
  public String getOrdOprStimeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrdOprStime));
      }

  public void initOperateTime(String value){
     this.initProperty(S_OperateTime,value);
  }
  public  void setOperateTime(String value){
     this.set(S_OperateTime,value);
  }
  public  void setOperateTimeNull(){
     this.set(S_OperateTime,null);
  }

  public String getOperateTime(){
       return DataType.getAsString(this.get(S_OperateTime));
  
  }
  public String getOperateTimeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OperateTime));
      }

  public void initValidateStime(String value){
     this.initProperty(S_ValidateStime,value);
  }
  public  void setValidateStime(String value){
     this.set(S_ValidateStime,value);
  }
  public  void setValidateStimeNull(){
     this.set(S_ValidateStime,null);
  }

  public String getValidateStime(){
       return DataType.getAsString(this.get(S_ValidateStime));
  
  }
  public String getValidateStimeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ValidateStime));
      }

  public void initValidateEtime(String value){
     this.initProperty(S_ValidateEtime,value);
  }
  public  void setValidateEtime(String value){
     this.set(S_ValidateEtime,value);
  }
  public  void setValidateEtimeNull(){
     this.set(S_ValidateEtime,null);
  }

  public String getValidateEtime(){
       return DataType.getAsString(this.get(S_ValidateEtime));
  
  }
  public String getValidateEtimeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ValidateEtime));
      }

  public void initItemExtendId(String value){
     this.initProperty(S_ItemExtendId,value);
  }
  public  void setItemExtendId(String value){
     this.set(S_ItemExtendId,value);
  }
  public  void setItemExtendIdNull(){
     this.set(S_ItemExtendId,null);
  }

  public String getItemExtendId(){
       return DataType.getAsString(this.get(S_ItemExtendId));
  
  }
  public String getItemExtendIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ItemExtendId));
      }

  public void initNewValidateTime(String value){
     this.initProperty(S_NewValidateTime,value);
  }
  public  void setNewValidateTime(String value){
     this.set(S_NewValidateTime,value);
  }
  public  void setNewValidateTimeNull(){
     this.set(S_NewValidateTime,null);
  }

  public String getNewValidateTime(){
       return DataType.getAsString(this.get(S_NewValidateTime));
  
  }
  public String getNewValidateTimeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_NewValidateTime));
      }


 
 }

