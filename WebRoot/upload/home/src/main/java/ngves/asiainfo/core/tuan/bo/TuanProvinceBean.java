package ngves.asiainfo.core.tuan.bo;

import ngves.asiainfo.core.tuan.ivalues.ITuanProvinceValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class TuanProvinceBean extends DataContainer implements DataContainerInterface,ITuanProvinceValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 8674071428345209848L;



private static String  m_boName = "ngves.asiainfo.core.tuan.bo.TuanProvince";



  public final static  String S_BakCol = "BAK_COL";
  public final static  String S_TuanProvinceId = "TUAN_PROVINCE_ID";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_LimitProv = "LIMIT_PROV";
  public final static  String S_TuanId = "TUAN_ID";
  public TuanProvinceBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
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

  public void initTuanProvinceId(long value){
     this.initProperty(S_TuanProvinceId,new Long(value));
  }
  public  void setTuanProvinceId(long value){
     this.set(S_TuanProvinceId,new Long(value));
  }
  public  void setTuanProvinceIdNull(){
     this.set(S_TuanProvinceId,null);
  }

  public long getTuanProvinceId(){
        return DataType.getAsLong(this.get(S_TuanProvinceId));
  
  }
  public long getTuanProvinceIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TuanProvinceId));
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

  public void initLimitProv(String value){
     this.initProperty(S_LimitProv,value);
  }
  public  void setLimitProv(String value){
     this.set(S_LimitProv,value);
  }
  public  void setLimitProvNull(){
     this.set(S_LimitProv,null);
  }

  public String getLimitProv(){
       return DataType.getAsString(this.get(S_LimitProv));
  
  }
  public String getLimitProvInitialValue(){
        return DataType.getAsString(this.getOldObj(S_LimitProv));
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

