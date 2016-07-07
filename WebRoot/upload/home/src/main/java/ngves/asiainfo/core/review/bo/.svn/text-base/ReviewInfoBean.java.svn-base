package ngves.asiainfo.core.review.bo;

import java.util.Date;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.review.ivalues.*;

@SuppressWarnings("serial")
public class ReviewInfoBean extends DataContainer implements DataContainerInterface,IReviewInfoValue{

  private static String  m_boName = "ngves.asiainfo.core.review.bo.ReviewInfo";



  public final static  String S_ReviewId = "REVIEW_ID";
  public final static  String S_ReviewOpinion = "REVIEW_OPINION";
  public final static  String S_ExcelName = "EXCEL_NAME";
  public final static  String S_Bak1 = "BAK1";
  public final static  String S_ReviewPeople = "REVIEW_PEOPLE";
  public final static  String S_ReviewDescId = "REVIEW_DESC_ID";
  public final static  String S_ReviewTmie = "REVIEW_TMIE";
  public final static  String S_ReviewMonth = "REVIEW_MONTH";
  public final static  String S_Status = "STATUS";
  public final static  String S_CreateDate="CREATE_DATE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public ReviewInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initReviewId(long value){
     this.initProperty(S_ReviewId,new Long(value));
  }
  public  void setReviewId(long value){
     this.set(S_ReviewId,new Long(value));
  }
  public  void setReviewIdNull(){
     this.set(S_ReviewId,null);
  }

  public long getReviewId(){
        return DataType.getAsLong(this.get(S_ReviewId));
  
  }
  public long getReviewIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ReviewId));
      }

  public void initReviewOpinion(String value){
     this.initProperty(S_ReviewOpinion,value);
  }
  public  void setReviewOpinion(String value){
     this.set(S_ReviewOpinion,value);
  }
  public  void setReviewOpinionNull(){
     this.set(S_ReviewOpinion,null);
  }

  public String getReviewOpinion(){
       return DataType.getAsString(this.get(S_ReviewOpinion));
  
  }
  public String getReviewOpinionInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ReviewOpinion));
      }

  public void initExcelName(String value){
     this.initProperty(S_ExcelName,value);
  }
  public  void setExcelName(String value){
     this.set(S_ExcelName,value);
  }
  public  void setExcelNameNull(){
     this.set(S_ExcelName,null);
  }

  public String getExcelName(){
       return DataType.getAsString(this.get(S_ExcelName));
  
  }
  public String getExcelNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExcelName));
      }

  public void initBak1(String value){
     this.initProperty(S_Bak1,value);
  }
  public  void setBak1(String value){
     this.set(S_Bak1,value);
  }
  public  void setBak1Null(){
     this.set(S_Bak1,null);
  }

  public String getBak1(){
       return DataType.getAsString(this.get(S_Bak1));
  
  }
  public String getBak1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Bak1));
      }

  public void initReviewPeople(String value){
     this.initProperty(S_ReviewPeople,value);
  }
  public  void setReviewPeople(String value){
     this.set(S_ReviewPeople,value);
  }
  public  void setReviewPeopleNull(){
     this.set(S_ReviewPeople,null);
  }

  public String getReviewPeople(){
       return DataType.getAsString(this.get(S_ReviewPeople));
  
  }
  public String getReviewPeopleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ReviewPeople));
      }

  public void initReviewDescId(long value){
     this.initProperty(S_ReviewDescId,new Long(value));
  }
  public  void setReviewDescId(long value){
     this.set(S_ReviewDescId,new Long(value));
  }
  public  void setReviewDescIdNull(){
     this.set(S_ReviewDescId,null);
  }

  public long getReviewDescId(){
        return DataType.getAsLong(this.get(S_ReviewDescId));
  
  }
  public long getReviewDescIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ReviewDescId));
      }

  public void initReviewTmie(Date value){
     this.initProperty(S_ReviewTmie,value);
  }
  public  void setReviewTmie(Date value){
     this.set(S_ReviewTmie,value);
  }
  public  void setReviewTmieNull(){
     this.set(S_ReviewTmie,null);
  }

  public Date getReviewTmie(){
        return DataType.getAsDateTime(this.get(S_ReviewTmie));
  
  }
  public Date getReviewTmieInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ReviewTmie));
      }

  public void initReviewMonth(String value){
     this.initProperty(S_ReviewMonth,value);
  }
  public  void setReviewMonth(String value){
     this.set(S_ReviewMonth,value);
  }
  public  void setReviewMonthNull(){
     this.set(S_ReviewMonth,null);
  }

  public String getReviewMonth(){
        return DataType.getAsString(this.get(S_ReviewMonth));
  
  }
  public String getReviewMonthInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ReviewMonth));
      }

  public void initStatus(String value){
     this.initProperty(S_Status,value);
  }
  public  void setStatus(String value){
     this.set(S_Status,value);
  }
  public  void setStatusNull(){
     this.set(S_Status,null);
  }

  public String getStatus(){
       return DataType.getAsString(this.get(S_Status));
  
  }
  public String getStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Status));
      }

  public void initCreateDate(Date value){
	     this.initProperty(S_CreateDate,value);
	  }
	  public  void setCreateDate(Date value){
	     this.set(S_CreateDate,value);
	  }
	  public  void setCreateDateNull(){
	     this.set(S_CreateDate,null);
	  }

	  public Date getCreateDate(){
	        return DataType.getAsDate(this.get(S_CreateDate));
	  
	  }
	  public Date getCreateDateInitialValue(){
	        return DataType.getAsDate(this.getOldObj(S_CreateDate));
	      }
 
 }

