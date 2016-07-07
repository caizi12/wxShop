package ngves.asiainfo.core.order.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.order.ivalues.*;

public class NOtPayOrderBean extends DataContainer implements DataContainerInterface,INOtPayOrderValue{

  /**
	 * 
	 */
	private static final long serialVersionUID = 6630066904804588488L;



private static String  m_boName = "ngves.asiainfo.core.order.bo.NOtPayOrder";



  public final static  String S_MobNum = "MOB_NUM";
  public final static  String S_BusiMobNum = "BUSI_MOB_NUM";
  public final static  String S_UserLocalProvince = "USER_LOCAL_PROVINCE";
  public final static  String S_PackageNum = "PACKAGE_NUM";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_UserBrand = "USER_BRAND";
  public final static  String S_OrderSeq = "ORDER_SEQ";
  public final static  String S_PayType = "PAY_TYPE";
  public final static  String S_OrdOprTime = "ORD_OPR_TIME";
  public final static  String S_PayPoint = "PAY_POINT";
  public final static  String S_PayStatus = "PAY_STATUS";
  public final static  String S_Ware = "WARE";
  public final static  String S_PayCash = "PAY_CASH";
  public final static  String S_WareType = "WARE_TYPE";
  public final static  String S_Opera = "OPERA";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public NOtPayOrderBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initMobNum(String value){
     this.initProperty(S_MobNum,value);
  }
  public  void setMobNum(String value){
     this.set(S_MobNum,value);
  }
  public  void setMobNumNull(){
     this.set(S_MobNum,null);
  }

  public String getMobNum(){
       return DataType.getAsString(this.get(S_MobNum));
  
  }
  public String getMobNumInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MobNum));
      }

  public void initBusiMobNum(String value){
     this.initProperty(S_BusiMobNum,value);
  }
  public  void setBusiMobNum(String value){
     this.set(S_BusiMobNum,value);
  }
  public  void setBusiMobNumNull(){
     this.set(S_BusiMobNum,null);
  }

  public String getBusiMobNum(){
       return DataType.getAsString(this.get(S_BusiMobNum));
  
  }
  public String getBusiMobNumInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BusiMobNum));
      }

  public void initUserLocalProvince(String value){
     this.initProperty(S_UserLocalProvince,value);
  }
  public  void setUserLocalProvince(String value){
     this.set(S_UserLocalProvince,value);
  }
  public  void setUserLocalProvinceNull(){
     this.set(S_UserLocalProvince,null);
  }

  public String getUserLocalProvince(){
       return DataType.getAsString(this.get(S_UserLocalProvince));
  
  }
  public String getUserLocalProvinceInitialValue(){
        return DataType.getAsString(this.getOldObj(S_UserLocalProvince));
      }

  public void initPackageNum(String value){
     this.initProperty(S_PackageNum,value);
  }
  public  void setPackageNum(String value){
     this.set(S_PackageNum,value);
  }
  public  void setPackageNumNull(){
     this.set(S_PackageNum,null);
  }

  public String getPackageNum(){
       return DataType.getAsString(this.get(S_PackageNum));
  
  }
  public String getPackageNumInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PackageNum));
      }

  public void initOrgId(String value){
     this.initProperty(S_OrgId,value);
  }
  public  void setOrgId(String value){
     this.set(S_OrgId,value);
  }
  public  void setOrgIdNull(){
     this.set(S_OrgId,null);
  }

  public String getOrgId(){
       return DataType.getAsString(this.get(S_OrgId));
  
  }
  public String getOrgIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrgId));
      }

  public void initUserBrand(String value){
     this.initProperty(S_UserBrand,value);
  }
  public  void setUserBrand(String value){
     this.set(S_UserBrand,value);
  }
  public  void setUserBrandNull(){
     this.set(S_UserBrand,null);
  }

  public String getUserBrand(){
       return DataType.getAsString(this.get(S_UserBrand));
  
  }
  public String getUserBrandInitialValue(){
        return DataType.getAsString(this.getOldObj(S_UserBrand));
      }

  public void initOrderSeq(String value){
     this.initProperty(S_OrderSeq,value);
  }
  public  void setOrderSeq(String value){
     this.set(S_OrderSeq,value);
  }
  public  void setOrderSeqNull(){
     this.set(S_OrderSeq,null);
  }

  public String getOrderSeq(){
       return DataType.getAsString(this.get(S_OrderSeq));
  
  }
  public String getOrderSeqInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrderSeq));
      }

  public void initPayType(String value){
     this.initProperty(S_PayType,value);
  }
  public  void setPayType(String value){
     this.set(S_PayType,value);
  }
  public  void setPayTypeNull(){
     this.set(S_PayType,null);
  }

  public String getPayType(){
       return DataType.getAsString(this.get(S_PayType));
  
  }
  public String getPayTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PayType));
      }

  public void initOrdOprTime(String value){
     this.initProperty(S_OrdOprTime,value);
  }
  public  void setOrdOprTime(String value){
     this.set(S_OrdOprTime,value);
  }
  public  void setOrdOprTimeNull(){
     this.set(S_OrdOprTime,null);
  }

  public String getOrdOprTime(){
       return DataType.getAsString(this.get(S_OrdOprTime));
  
  }
  public String getOrdOprTimeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrdOprTime));
      }

  public void initPayPoint(String value){
     this.initProperty(S_PayPoint,value);
  }
  public  void setPayPoint(String value){
     this.set(S_PayPoint,value);
  }
  public  void setPayPointNull(){
     this.set(S_PayPoint,null);
  }

  public String getPayPoint(){
       return DataType.getAsString(this.get(S_PayPoint));
  
  }
  public String getPayPointInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PayPoint));
      }

  public void initPayStatus(String value){
     this.initProperty(S_PayStatus,value);
  }
  public  void setPayStatus(String value){
     this.set(S_PayStatus,value);
  }
  public  void setPayStatusNull(){
     this.set(S_PayStatus,null);
  }

  public String getPayStatus(){
       return DataType.getAsString(this.get(S_PayStatus));
  
  }
  public String getPayStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PayStatus));
      }

  public void initWare(String value){
     this.initProperty(S_Ware,value);
  }
  public  void setWare(String value){
     this.set(S_Ware,value);
  }
  public  void setWareNull(){
     this.set(S_Ware,null);
  }

  public String getWare(){
       return DataType.getAsString(this.get(S_Ware));
  
  }
  public String getWareInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ware));
      }

  public void initPayCash(String value){
     this.initProperty(S_PayCash,value);
  }
  public  void setPayCash(String value){
     this.set(S_PayCash,value);
  }
  public  void setPayCashNull(){
     this.set(S_PayCash,null);
  }

  public String getPayCash(){
       return DataType.getAsString(this.get(S_PayCash));
  
  }
  public String getPayCashInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PayCash));
      }

  public void initWareType(String value){
     this.initProperty(S_WareType,value);
  }
  public  void setWareType(String value){
     this.set(S_WareType,value);
  }
  public  void setWareTypeNull(){
     this.set(S_WareType,null);
  }

  public String getWareType(){
       return DataType.getAsString(this.get(S_WareType));
  
  }
  public String getWareTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WareType));
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


 
 }

