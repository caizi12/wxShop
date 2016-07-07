package ngves.asiainfo.core.tuan.bo;

import ngves.asiainfo.core.tuan.ivalues.IQBOPreOrdersInfoValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class QBOPreOrdersInfoBean extends DataContainer implements DataContainerInterface,IQBOPreOrdersInfoValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.tuan.bo.QBOPreOrdersInfo";



  public final static  String S_Itemcount = "ITEMCOUNT";
  public final static  String S_Actionid = "ACTIONID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBOPreOrdersInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initItemcount(long value){
     this.initProperty(S_Itemcount,new Long(value));
  }
  public  void setItemcount(long value){
     this.set(S_Itemcount,new Long(value));
  }
  public  void setItemcountNull(){
     this.set(S_Itemcount,null);
  }

  public long getItemcount(){
        return DataType.getAsLong(this.get(S_Itemcount));
  
  }
  public long getItemcountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Itemcount));
      }

  public void initActionid(String value){
     this.initProperty(S_Actionid,value);
  }
  public  void setActionid(String value){
     this.set(S_Actionid,value);
  }
  public  void setActionidNull(){
     this.set(S_Actionid,null);
  }

  public String getActionid(){
       return DataType.getAsString(this.get(S_Actionid));
  
  }
  public String getActionidInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Actionid));
      }


 
 }

