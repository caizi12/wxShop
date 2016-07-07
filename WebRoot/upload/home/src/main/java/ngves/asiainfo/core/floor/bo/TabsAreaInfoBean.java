package ngves.asiainfo.core.floor.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.floor.ivalues.*;

public class TabsAreaInfoBean extends DataContainer implements DataContainerInterface,ITabsAreaInfoValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



private static String  m_boName = "ngves.asiainfo.core.floor.bo.TabsAreaInfo";



  public final static  String S_AreaContentType = "AREA_CONTENT_TYPE";
  public final static  String S_AreaSort = "AREA_SORT";
  public final static  String S_TabsAreaId = "TABS_AREA_ID";
  public final static  String S_AreaImgUrl = "AREA_IMG_URL";
  public final static  String S_AreaContent = "AREA_CONTENT";
  public final static  String S_TabsId = "TABS_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public TabsAreaInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("");
 }


  public void initAreaContentType(long value){
     this.initProperty(S_AreaContentType,new Long(value));
  }
  public  void setAreaContentType(long value){
     this.set(S_AreaContentType,new Long(value));
  }
  public  void setAreaContentTypeNull(){
     this.set(S_AreaContentType,null);
  }

  public long getAreaContentType(){
        return DataType.getAsLong(this.get(S_AreaContentType));
  
  }
  public long getAreaContentTypeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AreaContentType));
      }

  public void initAreaSort(String value){
     this.initProperty(S_AreaSort,value);
  }
  public  void setAreaSort(String value){
     this.set(S_AreaSort,value);
  }
  public  void setAreaSortNull(){
     this.set(S_AreaSort,null);
  }

  public String getAreaSort(){
       return DataType.getAsString(this.get(S_AreaSort));
  
  }
  public String getAreaSortInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AreaSort));
      }

  public void initTabsAreaId(long value){
     this.initProperty(S_TabsAreaId,new Long(value));
  }
  public  void setTabsAreaId(long value){
     this.set(S_TabsAreaId,new Long(value));
  }
  public  void setTabsAreaIdNull(){
     this.set(S_TabsAreaId,null);
  }

  public long getTabsAreaId(){
        return DataType.getAsLong(this.get(S_TabsAreaId));
  
  }
  public long getTabsAreaIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TabsAreaId));
      }

  public void initAreaImgUrl(String value){
     this.initProperty(S_AreaImgUrl,value);
  }
  public  void setAreaImgUrl(String value){
     this.set(S_AreaImgUrl,value);
  }
  public  void setAreaImgUrlNull(){
     this.set(S_AreaImgUrl,null);
  }

  public String getAreaImgUrl(){
       return DataType.getAsString(this.get(S_AreaImgUrl));
  
  }
  public String getAreaImgUrlInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AreaImgUrl));
      }

  public void initAreaContent(String value){
     this.initProperty(S_AreaContent,value);
  }
  public  void setAreaContent(String value){
     this.set(S_AreaContent,value);
  }
  public  void setAreaContentNull(){
     this.set(S_AreaContent,null);
  }

  public String getAreaContent(){
       return DataType.getAsString(this.get(S_AreaContent));
  
  }
  public String getAreaContentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AreaContent));
      }

  public void initTabsId(long value){
     this.initProperty(S_TabsId,new Long(value));
  }
  public  void setTabsId(long value){
     this.set(S_TabsId,new Long(value));
  }
  public  void setTabsIdNull(){
     this.set(S_TabsId,null);
  }

  public long getTabsId(){
        return DataType.getAsLong(this.get(S_TabsId));
  
  }
  public long getTabsIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TabsId));
      }


 
 }

