package ngves.asiainfo.core.common.bo;

import ngves.asiainfo.core.common.ivalues.ISysUserInterestValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class SysUserInterestBean extends DataContainer implements DataContainerInterface,ISysUserInterestValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 5475263970584855977L;



private static String  m_boName = "ngves.asiainfo.core.common.bo.SysUserInterest";



  public final static  String S_InterestId = "INTEREST_ID";
  public final static  String S_InterestName = "INTEREST_NAME";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_InterestCode = "INTEREST_CODE";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_WareKindId = "WARE_KIND_ID";
  public final static  String S_InterestSeq = "INTEREST_SEQ";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public SysUserInterestBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initInterestId(long value){
     this.initProperty(S_InterestId,new Long(value));
  }
  public  void setInterestId(long value){
     this.set(S_InterestId,new Long(value));
  }
  public  void setInterestIdNull(){
     this.set(S_InterestId,null);
  }

  public long getInterestId(){
        return DataType.getAsLong(this.get(S_InterestId));
  
  }
  public long getInterestIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_InterestId));
      }

  public void initInterestName(String value){
     this.initProperty(S_InterestName,value);
  }
  public  void setInterestName(String value){
     this.set(S_InterestName,value);
  }
  public  void setInterestNameNull(){
     this.set(S_InterestName,null);
  }

  public String getInterestName(){
       return DataType.getAsString(this.get(S_InterestName));
  
  }
  public String getInterestNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_InterestName));
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

  public void initInterestCode(String value){
     this.initProperty(S_InterestCode,value);
  }
  public  void setInterestCode(String value){
     this.set(S_InterestCode,value);
  }
  public  void setInterestCodeNull(){
     this.set(S_InterestCode,null);
  }

  public String getInterestCode(){
       return DataType.getAsString(this.get(S_InterestCode));
  
  }
  public String getInterestCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_InterestCode));
      }

  public void initBakCol1(long value){
     this.initProperty(S_BakCol1,new Long(value));
  }
  public  void setBakCol1(long value){
     this.set(S_BakCol1,new Long(value));
  }
  public  void setBakCol1Null(){
     this.set(S_BakCol1,null);
  }

  public long getBakCol1(){
        return DataType.getAsLong(this.get(S_BakCol1));
  
  }
  public long getBakCol1InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BakCol1));
      }

  public void initWareKindId(long value){
     this.initProperty(S_WareKindId,new Long(value));
  }
  public  void setWareKindId(long value){
     this.set(S_WareKindId,new Long(value));
  }
  public  void setWareKindIdNull(){
     this.set(S_WareKindId,null);
  }

  public long getWareKindId(){
        return DataType.getAsLong(this.get(S_WareKindId));
  
  }
  public long getWareKindIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_WareKindId));
      }

  public void initInterestSeq(long value){
     this.initProperty(S_InterestSeq,new Long(value));
  }
  public  void setInterestSeq(long value){
     this.set(S_InterestSeq,new Long(value));
  }
  public  void setInterestSeqNull(){
     this.set(S_InterestSeq,null);
  }

  public long getInterestSeq(){
        return DataType.getAsLong(this.get(S_InterestSeq));
  
  }
  public long getInterestSeqInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_InterestSeq));
      }


 
 }

