package ngves.asiainfo.core.common.util;

import java.sql.Timestamp;

import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.common.bo.BusiInfoBean;
import ngves.asiainfo.core.common.bo.BusiInfoEngine;
import ngves.asiainfo.core.common.ivalues.IBusiInfoDetailValue;
import ngves.asiainfo.core.common.ivalues.IBusiInfoValue;
import ngves.asiainfo.core.common.model.InterLogInfo;
import ngves.asiainfo.core.common.service.interfaces.IBusiInfoDetailSrv;
import ngves.asiainfo.core.common.service.interfaces.IBusiInfoSrv;
import ngves.asiainfo.core.tuan.exception.MgtException;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;

/**
 * @author douxf2
 * 
 */
public class BusiInfoUtil {

    /**
     * 保存busiInfoDetail对象
     * @param busiInfoDetail
     * @return sxl
     * @throws Exception
     */
    public static long recordBusiDetail(IBusiInfoDetailValue busiInfoDetail) throws Exception {
        IBusiInfoDetailSrv busiDetailSrv = (IBusiInfoDetailSrv) ServiceFactory
                .getService(CoreSrvContstant.SERVICE_MGT_COMMON_BUSI_DETAIL);
        return busiDetailSrv.saveBusiInfoDetail(busiInfoDetail);
    }
	/**
	 * 记录详细业务流水，适合纵表发生变化时。两个数组必须为IVlues类型的对象，数组长度应一致 field必须是IValue类型对象中S_开头的字符串
	 * 
	 * @param busiId
	 * @param oldValues
	 * @param newValues
	 * @param field
	 * @return
	 * @throws Exception
	 */
	public static long recordBusiDetail(String busiId, Object[] oldValues, Object[] newValues, String field)
			throws Exception {
	    IBusiInfoDetailSrv busiDetailSrv = (IBusiInfoDetailSrv) ServiceFactory
				.getService(CoreSrvContstant.SERVICE_MGT_COMMON_BUSI_DETAIL);
		return busiDetailSrv.recordBusiInfoDetails(busiId, oldValues, newValues, field);
	}

	
	/**
     * 记录日志业务记录  新增两个字段
     * @param busiId
     * @param busiTypeId
     * @param staffId
     * @param note
     * @param opt_type
     * @param opt_obj
     * @return
     * @throws Exception
     */
    public static long recordBusiInfo(String busiId, String busiTypeId, long staffId, String note, String opt_type, String opt_obj,long StaffId,String ComType,long OrgId) throws Exception {
        if (!StringUtil.isBlank(busiId)) {
            try {
                Long.parseLong(busiId);
            } catch (Exception e) {
                throw new MgtException("the Busi Id is not long type!");
            }
        }
        IBusiInfoValue businessinfo = new BusiInfoBean();
        if (!StringUtil.isBlank(busiId)) {
            businessinfo.setBusiId(Long.parseLong(busiId));
        }
        Timestamp nowTime = BusiInfoEngine.getSysDate();
        businessinfo.setBusiDate(nowTime);
        if (staffId != -1)
            businessinfo.setBusiStaffId(staffId);
        else
            businessinfo.setBusiStaffId(StaffId);
        businessinfo.setBusiComType(ComType);
        businessinfo.setBusiComId(OrgId);
        if (!StringUtil.isBlank(busiTypeId)) {
            try {
                businessinfo.setBusiTypeId(busiTypeId);
            } catch (Exception e) {

            }
        }
        if (!StringUtil.isBlank(note)) {
            //modify wzg 对note进行长度判断
            if (MAX_NOTE_LENGTH >= note.length()) {
                //如果备注长度小于等于最大值,不用截取
                businessinfo.setNote(note);
            } else {
                //如果备注长度大于最大值,截取并进行日志警告记录
                businessinfo.setNote(note.substring(0, MAX_NOTE_LENGTH));
                log.warn(" The Note is Extend max-length , busiTypeId := " + busiTypeId + " staffId := " + staffId
                        + " note := " + note);
            }
        }
        businessinfo.setStsToNew();
        businessinfo.setOptType(opt_type);
        businessinfo.setOptObj(opt_obj);
        IBusiInfoSrv busiSrv = (IBusiInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_MGT_BUSI_INFO);

        return busiSrv.saveBusinessInfo(businessinfo);
    }


	/**
	 * 定义备注的最大字符长度为1800,如果超过该长度进行截取
	 */
	private static transient int MAX_NOTE_LENGTH = 1800;

	private static transient Log log = LogFactory.getLog(BusiInfoUtil.class);
	
	//li new 
	public static long recordBusiDetailForAwardLevel(String busiId, Object[] oldValues, Object[] newValues, String field)
	throws Exception {
       IBusiInfoDetailSrv busiDetailSrv = (IBusiInfoDetailSrv) ServiceFactory
		.getService(CoreSrvContstant.SERVICE_MGT_COMMON_BUSI_DETAIL);
       return busiDetailSrv.recordBusiInfoDetailsForAwardLevel(busiId, oldValues, newValues, field);
     }
	//li new 
	
	/**
	 * 比较两个ivalue对象是否相同，不相同就返回true，相同返回false
	 */
	public static boolean compareValue(Object oldObj, Object newObj, String fieldValueName) throws Exception {
		IBusiInfoDetailSrv busiDetailSrv = (IBusiInfoDetailSrv) ServiceFactory
				.getService(CoreSrvContstant.SERVICE_MGT_COMMON_BUSI_DETAIL);
		return busiDetailSrv.compareIValue(oldObj, newObj, fieldValueName);
	}
	
	
	/**
     * 记录日志业务记录(批量新增操作)
     * @param busiId
     * @param busiTypeId
     * @param staffId
     * @param note
     * @param opt_type
     * @param opt_obj
     * @return
     * @throws Exception
     */
    public static void  recordBusiInfoBatch(String busiTypeId, long staffId, String note, String opt_type, String[] optobjArr,long StaffId,String ComType,long OrgId) throws Exception {
        IBusiInfoValue[] businessinfoArr = new BusiInfoBean[optobjArr.length];       
        IBusiInfoValue businessinfo=null;          
        for(int i=0;i<optobjArr.length;i++){
        	businessinfo=new BusiInfoBean(); 
        	Timestamp nowTime = BusiInfoEngine.getSysDate();
            businessinfo.setBusiDate(nowTime);                  
            businessinfo.setBusiStaffId(StaffId);
            businessinfo.setBusiComType(ComType);
            businessinfo.setBusiComId(OrgId);            
            businessinfo.setBusiTypeId(busiTypeId);          
            businessinfo.setNote(note);             
	         businessinfo.setStsToNew();
	         businessinfo.setOptType(opt_type);
	    	 businessinfo.setOptObj(optobjArr[i]);
	    	 businessinfoArr[i]=businessinfo;
        }       
        IBusiInfoSrv busiSrv = (IBusiInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_MGT_BUSI_INFO);
        busiSrv.saveBusinessInfos(businessinfoArr);
    }
    /**
     * 记录第三方发起的请求日志
     */
    public static long recordRequestInterLog(InterLogInfo info) throws Exception{
    	 IBusiInfoSrv busiSrv = (IBusiInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_MGT_BUSI_INFO);
    	 return busiSrv.recordRequestInterLog(info);
    	 
    }
    /**
     * 记录记录第三方响应日志
     * @param info
     * @return
     * @throws Exception
     */
    public static long recordResponseInterLog(InterLogInfo info) throws Exception{
   	 IBusiInfoSrv busiSrv = (IBusiInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_MGT_BUSI_INFO);
   	 return busiSrv.recordResponseInterLog(info);
   	 
   }

}
