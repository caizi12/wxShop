package ngves.asiainfo.core.tuan.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.common.bo.BusiInfoEngine;
import ngves.asiainfo.core.common.util.BusiInfoUtil;
import ngves.asiainfo.core.tuan.bo.QBOTuanWareInfoEngine;
import ngves.asiainfo.core.tuan.bo.QBOTuanWareIntegralEngine;
import ngves.asiainfo.core.tuan.bo.TuanInfoEngine;
import ngves.asiainfo.core.tuan.bo.TuanWareRLTBean;
import ngves.asiainfo.core.tuan.bo.TuanWareRLTEngine;
import ngves.asiainfo.core.tuan.dao.interfaces.ITuanWareRLTDAO;
import ngves.asiainfo.core.tuan.ivalues.IQBOTuanWareInfoValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOTuanWareIntegralValue;
import ngves.asiainfo.core.tuan.ivalues.ITuanInfoValue;
import ngves.asiainfo.core.tuan.ivalues.ITuanWareRLTValue;
import ngves.asiainfo.core.ware.dao.interfaces.IActivityIntegralDAO;
import ngves.asiainfo.core.ware.ivalues.IActivityIntegralValue;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;

public class TuanWareRLTDAOImpl implements ITuanWareRLTDAO {
	private Log log = LogFactory.getLog(TuanWareRLTDAOImpl.class);
	
	public ITuanWareRLTValue getTuanWareRLTById(String tuanId) throws Exception {

		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String, String> parameter = new HashMap<String, String>();
		if (!StringUtil.isBlank(tuanId)) {
			condition.append(" and ").append(ITuanWareRLTValue.S_TuanId).append("=:").append("tuanId");
			parameter.put("tuanId", tuanId);
		}
		// 团购和礼品是一一对应关系
		TuanWareRLTBean[] tuanWareRlts = TuanWareRLTEngine.getBeans(condition.toString(), parameter);
		if (tuanWareRlts != null && tuanWareRlts.length > 0) {
			return tuanWareRlts[0];
		}
		return null;

	}
	
	/**
	 * 验证是否绑定短信模板
	 */
	public int tuanSmsTemp(String tuanId,String wareId) throws Exception{
		StringBuffer sql=new StringBuffer();
		sql.append(" SELECT SFWIR.RLT_ID TUAN_ID                   \n");
		sql.append("   FROM SMS_FORMWORK_WARE_INFO_RLT SFWIR       \n");
		sql.append("  WHERE SFWIR.ACTION_ID =" + tuanId + "        \n");
		sql.append("    AND SFWIR.ACTION_TYPE = '02'               \n");
		sql.append("    AND SFWIR.WARE_CODE =                      \n");
		sql.append("        (SELECT WI.WARE_CODE                   \n");
		sql.append("           FROM WARE_INFO WI                   \n");
		sql.append("          WHERE WI.WARE_ID =" + wareId + "  )  \n");
		TuanWareRLTBean[] tuanWareRlts=TuanWareRLTEngine.getBeansFromSql(sql.toString(), null);
		int count=tuanWareRlts.length;
		return count;
	}
	
	/**
	 * 验证此礼品是否已保存到TUAN_WARE_RLT
	 */
	public int isTuanWareRlt(String tuanId,String wareId) throws Exception{
		StringBuffer sql=new StringBuffer();
		sql.append("  SELECT TWR.TUAN_ID TUAN_ID                           \n");
		sql.append("    FROM TUAN_WARE_RLT TWR, WARE_INFO WI, TUAN_INFO TI \n");
		sql.append("   WHERE TWR.WARE_ID = WI.WARE_ID                      \n");
		sql.append("     AND TWR.TUAN_ID = TI.TUAN_ID                      \n");
		sql.append("     AND WI.WARE_ID =" + wareId + "                    \n");
		sql.append("     AND TI.TUAN_ID =" + tuanId + "                    \n");
		TuanWareRLTBean[] tuanWareRlts=TuanWareRLTEngine.getBeansFromSql(sql.toString(), null);
		int count=tuanWareRlts.length;
		return count;
	}

	public int countTuanWare(String condition, Map<String, String> parameter) throws Exception {
		return QBOTuanWareInfoEngine.getBeansCount(condition, parameter);
	}

	public IQBOTuanWareInfoValue[] queryTuanWare(String condition, Map<String, String> parameter, int startIndex,
			int endIndex) throws Exception {
		return QBOTuanWareInfoEngine.getBeans(null, condition, parameter, startIndex, endIndex, false);
	}

	public IQBOTuanWareIntegralValue[] queryTuanBindRelationInfo(String condition, Map<String, String> parameter)
			throws Exception {
		// 团购活动绑定的礼品信息查询
		IQBOTuanWareIntegralValue[] value = QBOTuanWareIntegralEngine.getBeans(condition, parameter);
		return value;
	}
	
	public long saveBindTuanWareInfo(ITuanWareRLTValue value) throws Exception {
        long tuanWareRltId = 0L; 
        // 新增数据
        if (value.isNew()) {
            log.debug("It is creating a new relation between group buy and ware.");
            tuanWareRltId = TuanWareRLTEngine.getNewId().longValue();
            value.setTuanWareRltId(tuanWareRltId);
            value.setStsToNew();
        }
        tuanWareRltId = value.getTuanWareRltId();
        TuanWareRLTEngine.save(value);
        return tuanWareRltId;
    }
    
	/**
	 * 保存团购并预览增加日志记录
	 */
	public long saveBindTuanWareInfo(Map<String,Object> in) throws Exception {
		ITuanWareRLTValue value = (ITuanWareRLTValue)in.get("tuanWareRLT");
    	long staffId = (Long)in.get("staffId");
    	String comType = (String)in.get("comType");
    	long orgId = (Long)in.get("orgId");
    	IActivityIntegralValue activityIntegral =(IActivityIntegralValue)in.get("activityIntegral");
		long tuanWareRltId = 0L;		
		
		ITuanInfoValue tuanInfoValue = queryTuanById(value.getTuanId());
	    
	    ITuanWareRLTValue oldValue = getTuanWareRLTById(String.valueOf(value.getTuanId()));
	    ITuanWareRLTValue oldBean = new TuanWareRLTBean();
	    if(null != oldValue){
	    	oldBean.copy(oldValue);
	    }
		// 新增数据
		if (value.isNew()) {
			log.debug("It is creating a new relation between group buy and ware.");
			tuanWareRltId = TuanWareRLTEngine.getNewId().longValue();
			value.setTuanWareRltId(tuanWareRltId);
			value.setStsToNew();
		}
		tuanWareRltId = value.getTuanWareRltId();
		TuanWareRLTEngine.save(value);
		
	   IActivityIntegralDAO activityIntegralDAO = (IActivityIntegralDAO) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_ACTIVITY_INTEGRAL_DAO);
	   activityIntegralDAO.saveActivityIntegralForAllChannel(activityIntegral);
		if(null != oldValue){
		    long busiInfoId = BusiInfoEngine.getNewId().longValue();
	        BusiInfoUtil.recordBusiInfo(busiInfoId + "", CoreConstant.SYS_PARA_BUSI_TYPE_TUAN_MODIFY, -1,
	                 "团购活动绑定礼品信息修改", CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY, "团购ID：" + value.getTuanId()
	                         + "；团购名称：" + tuanInfoValue.getName(),staffId,comType,orgId); 
	        BusiInfoUtil.recordBusiDetail(busiInfoId + "", new Object[]{oldBean}, new Object[]{value}, "TuanId");
		}
		return tuanWareRltId;
	}
    //根据团购id查询团购信息
	public ITuanInfoValue queryTuanById(long tuanId) {
        try {
            return TuanInfoEngine.getBean(tuanId);
        } catch (NumberFormatException e) {
            // e.printStackTrace();
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return null;

    }
	
	public void deleteBindTuanWareInfoById(String tuanId) throws Exception {

		ITuanWareRLTValue value = getTuanWareRLTById(tuanId);
		if (null != value) {
			value.delete();
			TuanWareRLTEngine.save(value);
		}
	}

	public long saveTuanWareInfoNoId(ITuanWareRLTValue value) throws Exception {
		long tuanWareRltId = 0L;
		tuanWareRltId = value.getTuanWareRltId();
		value.setStsToNew();
		TuanWareRLTEngine.save(value);
		return tuanWareRltId;
	}
	
	public ITuanInfoValue[] getCurTuanInfo(String condition, Map<String, String> parameter) throws Exception{
		
		return TuanInfoEngine.getBeans(condition, parameter);
	}

	public IQBOTuanWareInfoValue[] queryTuanWare(String condition, Map<String, String> parameter) throws Exception {
		return QBOTuanWareInfoEngine.getBeans(condition, parameter);
	}
}
