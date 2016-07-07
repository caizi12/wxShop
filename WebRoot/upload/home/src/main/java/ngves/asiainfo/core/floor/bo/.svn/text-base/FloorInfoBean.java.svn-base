package ngves.asiainfo.core.floor.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.floor.ivalues.*;

public class FloorInfoBean extends DataContainer implements DataContainerInterface,IFloorInfoValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private static String  m_boName = "ngves.asiainfo.core.floor.bo.FloorInfo";

  public final static  String S_AdImgHref = "AD_IMG_HREF";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_BakCol1 = "BAK_COL1";
  public final static  String S_TabsNum = "TABS_NUM";
  public final static  String S_FloorId = "FLOOR_ID";
  public final static  String S_IsShowSubKind = "IS_SHOW_SUB_KIND";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_FloorImgHref = "FLOOR_IMG_HREF";
  public final static  String S_FloorImgUrl = "FLOOR_IMG_URL";
  public final static  String S_AdImgUrl = "AD_IMG_URL";
  public final static  String S_IsContainAd = "IS_CONTAIN_AD";
  public final static  String S_FloorName = "FLOOR_NAME";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_FloorSort = "FLOOR_SORT";
  public final static  String S_IsHomeShow = "IS_HOME_SHOW";
  public final static  String S_AdBackColor = "AD_BACK_COLOR";
          
  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public FloorInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initAdImgHref(String value){
     this.initProperty(S_AdImgHref,value);
  }
  public  void setAdImgHref(String value){
     this.set(S_AdImgHref,value);
  }
  public  void setAdImgHrefNull(){
     this.set(S_AdImgHref,null);
  }

  public String getAdImgHref(){
       return DataType.getAsString(this.get(S_AdImgHref));
  
  }
  public String getAdImgHrefInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AdImgHref));
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

  public void initTabsNum(long value){
     this.initProperty(S_TabsNum,new Long(value));
  }
  public  void setTabsNum(long value){
     this.set(S_TabsNum,new Long(value));
  }
  public  void setTabsNumNull(){
     this.set(S_TabsNum,null);
  }

  public long getTabsNum(){
        return DataType.getAsLong(this.get(S_TabsNum));
  
  }
  public long getTabsNumInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TabsNum));
      }

  public void initFloorId(long value){
     this.initProperty(S_FloorId,new Long(value));
  }
  public  void setFloorId(long value){
     this.set(S_FloorId,new Long(value));
  }
  public  void setFloorIdNull(){
     this.set(S_FloorId,null);
  }

  public long getFloorId(){
        return DataType.getAsLong(this.get(S_FloorId));
  
  }
  public long getFloorIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_FloorId));
      }

  public void initIsShowSubKind(String value){
     this.initProperty(S_IsShowSubKind,value);
  }
  public  void setIsShowSubKind(String value){
     this.set(S_IsShowSubKind,value);
  }
  public  void setIsShowSubKindNull(){
     this.set(S_IsShowSubKind,null);
  }

  public String getIsShowSubKind(){
       return DataType.getAsString(this.get(S_IsShowSubKind));
  
  }
  public String getIsShowSubKindInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsShowSubKind));
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

  public void initFloorImgHref(String value){
     this.initProperty(S_FloorImgHref,value);
  }
  public  void setFloorImgHref(String value){
     this.set(S_FloorImgHref,value);
  }
  public  void setFloorImgHrefNull(){
     this.set(S_FloorImgHref,null);
  }

  public String getFloorImgHref(){
       return DataType.getAsString(this.get(S_FloorImgHref));
  
  }
  public String getFloorImgHrefInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FloorImgHref));
      }
 /****************************************/
  public void initAdBackColor(String value){
	     this.initProperty(S_AdBackColor,value);
	  }
	  public  void setAdBackColor(String value){
	     this.set(S_AdBackColor,value);
	  }
	  public  void setAdBackColorNull(){
	     this.set(S_AdBackColor,null);
	  }

	  public String getAdBackColor(){
	       return DataType.getAsString(this.get(S_AdBackColor));
	  
	  }
	  public String getAdBackColorInitialValue(){
	        return DataType.getAsString(this.getOldObj(S_AdBackColor));
	      }
  /***************************************/
  public void initFloorImgUrl(String value){
     this.initProperty(S_FloorImgUrl,value);
  }
  public  void setFloorImgUrl(String value){
     this.set(S_FloorImgUrl,value);
  }
  public  void setFloorImgUrlNull(){
     this.set(S_FloorImgUrl,null);
  }

  public String getFloorImgUrl(){
       return DataType.getAsString(this.get(S_FloorImgUrl));
  
  }
  public String getFloorImgUrlInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FloorImgUrl));
      }

  public void initAdImgUrl(String value){
     this.initProperty(S_AdImgUrl,value);
  }
  public  void setAdImgUrl(String value){
     this.set(S_AdImgUrl,value);
  }
  public  void setAdImgUrlNull(){
     this.set(S_AdImgUrl,null);
  }

  public String getAdImgUrl(){
       return DataType.getAsString(this.get(S_AdImgUrl));
  
  }
  public String getAdImgUrlInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AdImgUrl));
      }

  public void initIsContainAd(String value){
     this.initProperty(S_IsContainAd,value);
  }
  public  void setIsContainAd(String value){
     this.set(S_IsContainAd,value);
  }
  public  void setIsContainAdNull(){
     this.set(S_IsContainAd,null);
  }

  public String getIsContainAd(){
       return DataType.getAsString(this.get(S_IsContainAd));
  
  }
  public String getIsContainAdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsContainAd));
      }

  public void initFloorName(String value){
     this.initProperty(S_FloorName,value);
  }
  public  void setFloorName(String value){
     this.set(S_FloorName,value);
  }
  public  void setFloorNameNull(){
     this.set(S_FloorName,null);
  }

  public String getFloorName(){
       return DataType.getAsString(this.get(S_FloorName));
  
  }
  public String getFloorNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FloorName));
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

  public void initFloorSort(String value){
     this.initProperty(S_FloorSort,value);
  }
  public  void setFloorSort(String value){
     this.set(S_FloorSort,value);
  }
  public  void setFloorSortNull(){
     this.set(S_FloorSort,null);
  }

  public String getFloorSort(){
       return DataType.getAsString(this.get(S_FloorSort));
  
  }
  public String getFloorSortInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FloorSort));
      }

  public void initIsHomeShow(String value){
     this.initProperty(S_IsHomeShow,value);
  }
  public  void setIsHomeShow(String value){
     this.set(S_IsHomeShow,value);
  }
  public  void setIsHomeShowNull(){
     this.set(S_IsHomeShow,null);
  }

  public String getIsHomeShow(){
       return DataType.getAsString(this.get(S_IsHomeShow));
  
  }
  public String getIsHomeShowInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsHomeShow));
      }


 
 }

