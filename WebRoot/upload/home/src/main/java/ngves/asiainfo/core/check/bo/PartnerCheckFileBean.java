package ngves.asiainfo.core.check.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.check.ivalues.*;

public class PartnerCheckFileBean extends DataContainer implements DataContainerInterface,IPartnerCheckFileValue{

	/**
     * 
     */
    private static final long serialVersionUID = 10L;
    
  private static String  m_boName = "ngves.asiainfo.core.check.bo.PartnerCheckFile";



  public final static  String S_FileStatus = "FILE_STATUS";
  public final static  String S_UpdateStaffId = "UPDATE_STAFF_ID";
  public final static  String S_BakCol2 = "BAK_COL2";
  public final static  String S_ProvinceCode = "PROVINCE_CODE";
  public final static  String S_BakCol3 = "BAK_COL3";
  public final static  String S_FileName = "FILE_NAME";
  public final static  String S_CheckFileTypeId = "CHECK_FILE_TYPE_ID";
  public final static  String S_FileDate = "FILE_DATE";
  public final static  String S_DiskFileName = "DISK_FILE_NAME";
  public final static  String S_FileId = "FILE_ID";
  public PartnerCheckFileBean() throws AIException{
      super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
  }


 public static ObjectType getObjectTypeStatic() throws AIException{
   return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("此种数据容器不能重置业务对象类型");
 }


  public void initFileStatus(String value){
     this.initProperty(S_FileStatus,value);
  }
  public  void setFileStatus(String value){
     this.set(S_FileStatus,value);
  }
  public  void setFileStatusNull(){
     this.set(S_FileStatus,null);
  }

  public String getFileStatus(){
       return DataType.getAsString(this.get(S_FileStatus));
  
  }
  public String getFileStatusInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FileStatus));
      }

  public void initUpdateStaffId(long value){
     this.initProperty(S_UpdateStaffId,new Long(value));
  }
  public  void setUpdateStaffId(long value){
     this.set(S_UpdateStaffId,new Long(value));
  }
  public  void setUpdateStaffIdNull(){
     this.set(S_UpdateStaffId,null);
  }

  public long getUpdateStaffId(){
        return DataType.getAsLong(this.get(S_UpdateStaffId));
  
  }
  public long getUpdateStaffIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_UpdateStaffId));
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

  public void initProvinceCode(String value){
     this.initProperty(S_ProvinceCode,value);
  }
  public  void setProvinceCode(String value){
     this.set(S_ProvinceCode,value);
  }
  public  void setProvinceCodeNull(){
     this.set(S_ProvinceCode,null);
  }

  public String getProvinceCode(){
       return DataType.getAsString(this.get(S_ProvinceCode));
  
  }
  public String getProvinceCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProvinceCode));
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

  public void initFileName(String value){
     this.initProperty(S_FileName,value);
  }
  public  void setFileName(String value){
     this.set(S_FileName,value);
  }
  public  void setFileNameNull(){
     this.set(S_FileName,null);
  }

  public String getFileName(){
       return DataType.getAsString(this.get(S_FileName));
  
  }
  public String getFileNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FileName));
      }

  public void initCheckFileTypeId(String value){
     this.initProperty(S_CheckFileTypeId,value);
  }
  public  void setCheckFileTypeId(String value){
     this.set(S_CheckFileTypeId,value);
  }
  public  void setCheckFileTypeIdNull(){
     this.set(S_CheckFileTypeId,null);
  }

  public String getCheckFileTypeId(){
       return DataType.getAsString(this.get(S_CheckFileTypeId));
  
  }
  public String getCheckFileTypeIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CheckFileTypeId));
      }

  public void initFileDate(Timestamp value){
     this.initProperty(S_FileDate,value);
  }
  public  void setFileDate(Timestamp value){
     this.set(S_FileDate,value);
  }
  public  void setFileDateNull(){
     this.set(S_FileDate,null);
  }

  public Timestamp getFileDate(){
        return DataType.getAsDateTime(this.get(S_FileDate));
  
  }
  public Timestamp getFileDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_FileDate));
      }

  public void initDiskFileName(String value){
     this.initProperty(S_DiskFileName,value);
  }
  public  void setDiskFileName(String value){
     this.set(S_DiskFileName,value);
  }
  public  void setDiskFileNameNull(){
     this.set(S_DiskFileName,null);
  }

  public String getDiskFileName(){
       return DataType.getAsString(this.get(S_DiskFileName));
  
  }
  public String getDiskFileNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DiskFileName));
      }

  public void initFileId(long value){
     this.initProperty(S_FileId,new Long(value));
  }
  public  void setFileId(long value){
     this.set(S_FileId,new Long(value));
  }
  public  void setFileIdNull(){
     this.set(S_FileId,null);
  }

  public long getFileId(){
        return DataType.getAsLong(this.get(S_FileId));
  
  }
  public long getFileIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_FileId));
      }


 
 }

