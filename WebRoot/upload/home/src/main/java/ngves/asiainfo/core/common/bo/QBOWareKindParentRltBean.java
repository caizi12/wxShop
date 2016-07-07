package ngves.asiainfo.core.common.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.common.ivalues.*;

public class QBOWareKindParentRltBean extends DataContainer implements DataContainerInterface,IQBOWareKindParentRltValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = -1362581271407265548L;



private static String  m_boName = "ngves.asiainfo.core.common.bo.QBOWareKindParentRlt";



  public final static  String S_WareKindParentId = "WARE_KIND_PARENT_ID";
  public final static  String S_SortId = "SORT_ID";
  public final static  String S_IsIndexNavView = "IS_INDEX_NAV_VIEW";
  public final static  String S_ShowChannelMid = "SHOW_CHANNEL_MID";
  public final static  String S_BigKindName = "BIG_KIND_NAME";
  public final static  String S_BigKindState = "BIG_KIND_STATE";
  public final static  String S_ShowShortId = "SHOW_SHORT_ID";
  public final static  String S_BigKindCode = "BIG_KIND_CODE";
  public final static  String S_WareFirstKindId = "WARE_FIRST_KIND_ID";
  public final static  String S_WareFirstKindRltId = "WARE_FIRST_KIND_RLT_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBOWareKindParentRltBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
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

  public void initSortId(long value){
     this.initProperty(S_SortId,new Long(value));
  }
  public  void setSortId(long value){
     this.set(S_SortId,new Long(value));
  }
  public  void setSortIdNull(){
     this.set(S_SortId,null);
  }

  public long getSortId(){
        return DataType.getAsLong(this.get(S_SortId));
  
  }
  public long getSortIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SortId));
      }

  public void initIsIndexNavView(String value){
     this.initProperty(S_IsIndexNavView,value);
  }
  public  void setIsIndexNavView(String value){
     this.set(S_IsIndexNavView,value);
  }
  public  void setIsIndexNavViewNull(){
     this.set(S_IsIndexNavView,null);
  }

  public String getIsIndexNavView(){
       return DataType.getAsString(this.get(S_IsIndexNavView));
  
  }
  public String getIsIndexNavViewInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsIndexNavView));
      }

  public void initShowChannelMid(String value){
     this.initProperty(S_ShowChannelMid,value);
  }
  public  void setShowChannelMid(String value){
     this.set(S_ShowChannelMid,value);
  }
  public  void setShowChannelMidNull(){
     this.set(S_ShowChannelMid,null);
  }

  public String getShowChannelMid(){
       return DataType.getAsString(this.get(S_ShowChannelMid));
  
  }
  public String getShowChannelMidInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ShowChannelMid));
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

  public void initBigKindState(String value){
     this.initProperty(S_BigKindState,value);
  }
  public  void setBigKindState(String value){
     this.set(S_BigKindState,value);
  }
  public  void setBigKindStateNull(){
     this.set(S_BigKindState,null);
  }

  public String getBigKindState(){
       return DataType.getAsString(this.get(S_BigKindState));
  
  }
  public String getBigKindStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BigKindState));
      }

  public void initShowShortId(long value){
     this.initProperty(S_ShowShortId,new Long(value));
  }
  public  void setShowShortId(long value){
     this.set(S_ShowShortId,new Long(value));
  }
  public  void setShowShortIdNull(){
     this.set(S_ShowShortId,null);
  }

  public long getShowShortId(){
        return DataType.getAsLong(this.get(S_ShowShortId));
  
  }
  public long getShowShortIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ShowShortId));
      }

  public void initBigKindCode(String value){
     this.initProperty(S_BigKindCode,value);
  }
  public  void setBigKindCode(String value){
     this.set(S_BigKindCode,value);
  }
  public  void setBigKindCodeNull(){
     this.set(S_BigKindCode,null);
  }

  public String getBigKindCode(){
       return DataType.getAsString(this.get(S_BigKindCode));
  
  }
  public String getBigKindCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BigKindCode));
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

  
  public void initWareFirstKindRltId(long value){
	     this.initProperty(S_WareFirstKindRltId,new Long(value));
	  }
	  public  void setWareFirstKindRltId(long value){
	     this.set(S_WareFirstKindRltId,new Long(value));
	  }
	  public  void setWareFirstKindRltIdNull(){
	     this.set(S_WareFirstKindRltId,null);
	  }

	  public long getWareFirstKindRltId(){
	        return DataType.getAsLong(this.get(S_WareFirstKindRltId));
	  
	  }
	  public long getWareFirstKindRltIdInitialValue(){
	        return DataType.getAsLong(this.getOldObj(S_WareFirstKindRltId));
	      }

 
 }

