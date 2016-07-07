package ngves.asiainfo.core.tuan.bo;

import ngves.asiainfo.core.tuan.ivalues.IJfinterOrdersInfoValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class JfinterOrdersInfoBean extends DataContainer implements DataContainerInterface,IJfinterOrdersInfoValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.tuan.bo.JfinterOrdersInfo";



  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_ItemCount = "ITEM_COUNT";
  public final static  String S_JfinterOrdersInfoId = "JFINTER_ORDERS_INFO_ID";
  public final static  String S_TuanId = "TUAN_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public JfinterOrdersInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
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

  public void initItemCount(long value){
     this.initProperty(S_ItemCount,new Long(value));
  }
  public  void setItemCount(long value){
     this.set(S_ItemCount,new Long(value));
  }
  public  void setItemCountNull(){
     this.set(S_ItemCount,null);
  }

  public long getItemCount(){
        return DataType.getAsLong(this.get(S_ItemCount));
  
  }
  public long getItemCountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ItemCount));
      }

  public void initJfinterOrdersInfoId(long value){
     this.initProperty(S_JfinterOrdersInfoId,new Long(value));
  }
  public  void setJfinterOrdersInfoId(long value){
     this.set(S_JfinterOrdersInfoId,new Long(value));
  }
  public  void setJfinterOrdersInfoIdNull(){
     this.set(S_JfinterOrdersInfoId,null);
  }

  public long getJfinterOrdersInfoId(){
        return DataType.getAsLong(this.get(S_JfinterOrdersInfoId));
  
  }
  public long getJfinterOrdersInfoIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_JfinterOrdersInfoId));
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


 
 }

