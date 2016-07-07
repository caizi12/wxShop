package ngves.asiainfo.core.floor.bo;



import java.sql.Timestamp;

import ngves.asiainfo.core.floor.ivalues.INavbarInfoValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;



public class NavbarInfoBean extends DataContainer implements DataContainerInterface,INavbarInfoValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.floor.bo.NavbarInfo";



  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_NavbarId = "NAVBAR_ID";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_BakCol4 = "BAK_COL4";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Sort = "SORT";
  public final static  String S_NavbarName = "NAVBAR_NAME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public NavbarInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("�������������������ҵ���������");
 }


  public void initModifyDate(Timestamp value){
     this.initProperty(S_ModifyDate,value);
  }
  public  void setModifyDate(Timestamp value){
     this.set(S_ModifyDate,value);
  }
  public  void setModifyDateNull(){
     this.set(S_ModifyDate,null);
  }

  public Timestamp getModifyDate(){
        return DataType.getAsDateTime(this.get(S_ModifyDate));
  
  }
  public Timestamp getModifyDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ModifyDate));
      }

  public void initNavbarId(long value){
     this.initProperty(S_NavbarId,new Long(value));
  }
  public  void setNavbarId(long value){
     this.set(S_NavbarId,new Long(value));
  }
  public  void setNavbarIdNull(){
     this.set(S_NavbarId,null);
  }

  public long getNavbarId(){
        return DataType.getAsLong(this.get(S_NavbarId));
  
  }
  public long getNavbarIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_NavbarId));
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

  public void initCreateDate(Timestamp value){
     this.initProperty(S_CreateDate,value);
  }
  public  void setCreateDate(Timestamp value){
     this.set(S_CreateDate,value);
  }
  public  void setCreateDateNull(){
     this.set(S_CreateDate,null);
  }

  public Timestamp getCreateDate(){
        return DataType.getAsDateTime(this.get(S_CreateDate));
  
  }
  public Timestamp getCreateDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CreateDate));
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

  public void initNavbarName(String value){
     this.initProperty(S_NavbarName,value);
  }
  public  void setNavbarName(String value){
     this.set(S_NavbarName,value);
  }
  public  void setNavbarNameNull(){
     this.set(S_NavbarName,null);
  }

  public String getNavbarName(){
       return DataType.getAsString(this.get(S_NavbarName));
  
  }
  public String getNavbarNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_NavbarName));
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
		  
		  
		  
		  public void initBakCol4(String value){
			     this.initProperty(S_BakCol4,value);
			  }
			  public  void setBakCol4(String value){
			     this.set(S_BakCol4,value);
			  }
			  public  void setBakCol4Null(){
			     this.set(S_BakCol4,null);
			  }

			  public String getBakCol4(){
			       return DataType.getAsString(this.get(S_BakCol4));
			  
			  }
			  public String getBakCol4InitialValue(){
			        return DataType.getAsString(this.getOldObj(S_BakCol4));
			      }

 
 }

