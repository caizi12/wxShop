package ngves.asiainfo.core.common.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.common.ivalues.*;

public class RecommCategoryWareRltBean extends DataContainer implements DataContainerInterface,IRecommCategoryWareRltValue{

  private static String  m_boName = "ngves.asiainfo.core.common.bo.RecommCategoryWareRlt";

  private static final long serialVersionUID = 3527506545051626685L;

  public final static  String S_SortId = "SORT_ID";
  public final static  String S_CategoryId = "CATEGORY_ID";
  public final static  String S_CategoryWareRltId = "CATEGORY_WARE_RLT_ID";
  public final static  String S_TopFlag = "TOP_FLAG";
  public final static  String S_WareId = "WARE_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public RecommCategoryWareRltBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
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

  public void initCategoryId(long value){
     this.initProperty(S_CategoryId,new Long(value));
  }
  public  void setCategoryId(long value){
     this.set(S_CategoryId,new Long(value));
  }
  public  void setCategoryIdNull(){
     this.set(S_CategoryId,null);
  }

  public long getCategoryId(){
        return DataType.getAsLong(this.get(S_CategoryId));
  
  }
  public long getCategoryIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_CategoryId));
      }

  public void initCategoryWareRltId(long value){
     this.initProperty(S_CategoryWareRltId,new Long(value));
  }
  public  void setCategoryWareRltId(long value){
     this.set(S_CategoryWareRltId,new Long(value));
  }
  public  void setCategoryWareRltIdNull(){
     this.set(S_CategoryWareRltId,null);
  }

  public long getCategoryWareRltId(){
        return DataType.getAsLong(this.get(S_CategoryWareRltId));
  
  }
  public long getCategoryWareRltIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_CategoryWareRltId));
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

