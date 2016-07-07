package ngves.asiainfo.core.award.dao.impl;

import java.util.HashMap;
import java.util.Map;
import ngves.asiainfo.core.award.AwardConstant;
import ngves.asiainfo.core.award.bo.AwardInfoEngine;
import ngves.asiainfo.core.award.dao.interfaces.IAwardInfoDAO;
import ngves.asiainfo.core.award.ivalues.IAwardInfoValue;
import ngves.asiainfo.core.ware.bo.WareInfoEngine;
import ngves.asiainfo.core.ware.ivalues.IWareInfoValue;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AwardInfoDAOImpl implements IAwardInfoDAO {

	@SuppressWarnings("unused")
	private static transient Log log = LogFactory.getLog(AwardInfoDAOImpl.class);
	
	public IAwardInfoValue[] queryAwardInfo(String AwardName, int startIndex, int endIndex) throws Exception {		
			StringBuffer sql = new StringBuffer();
			Map<String, String> params = new HashMap<String, String>();
			sql.append(" 1=1");
			if (!StringUtil.isBlank(AwardName)) {
				AwardName = AwardName.trim();
				sql.append("  AND "+IAwardInfoValue.S_AwardName).append(" LIKE :").append(IAwardInfoValue.S_AwardName);
				
			}
			sql.append(" AND " +IAwardInfoValue.S_Status+" <> "+AwardConstant.ACTIVITY_DELETE);
			params.put(IAwardInfoValue.S_AwardName, "%" + AwardName + "%");
			sql.append(" ORDER BY START_TIME DESC");
			return AwardInfoEngine.getBeans(null, sql.toString(), params, startIndex, endIndex, false);		
	}

	public int queryAwardInfoCount(String AwardName)throws Exception {
		StringBuffer sql = new StringBuffer();
		Map<String, String> params = new HashMap<String, String>();
		sql.append(" 1=1");
		if (!StringUtil.isBlank(AwardName)) {
			AwardName = AwardName.trim();
			sql.append("  AND "+IAwardInfoValue.S_AwardName).append(" LIKE :").append(IAwardInfoValue.S_AwardName).append(" ");
			params.put(IAwardInfoValue.S_AwardName, "%" + AwardName + "%");
		}
		sql.append(" AND "+IAwardInfoValue.S_Status+" <> "+AwardConstant.ACTIVITY_DELETE);		
		return AwardInfoEngine.getBeansCount(sql.toString(), params);		
	}

	public IAwardInfoValue queryAwardById(Long AwardId) throws Exception {		
			return AwardInfoEngine.getBean(AwardId);
	}

	public long saveAwardInfo(IAwardInfoValue value) throws Exception {
		long AwardId = 0L;
		AwardId = value.getAwardId();
		AwardInfoEngine.save(value);
		return AwardId;
	}

	public IAwardInfoValue[] getPublishAwardValues() throws Exception {
			StringBuffer sql = new StringBuffer();
			sql.append(" 1=1");
			sql.append(" AND " +IAwardInfoValue.S_Status +" IN ('1','2') ");
			sql.append(" AND SYSDATE >= " +IAwardInfoValue.S_StartTime);
			//结束时间比当前时间早6分钟(6/24*60)
			sql.append(" AND SYSDATE-1/240 <= " +IAwardInfoValue.S_EndTime);
			return AwardInfoEngine.getBeans(sql.toString(), null);
	}

	public IWareInfoValue findLevelInfoByAwardId(Long awardId)throws Exception {		
		StringBuffer sql = new StringBuffer();
		sql.append("select  *  from  ware_info  w  where  w.ware_id in(SELECT  A.WARE_ID "+
                   "FROM AWARD_LEVEL_INFO  A  WHERE   A.AWARD_ID="+awardId+"  AND  A.IS_DEFAULT_LEVEL='1')");
		IWareInfoValue[] value=WareInfoEngine.getBeansFromSql(sql.toString(), null);
		if(null!=value&&value.length>0){
			return value[0];	
		}else{
			return null;
		}
			
	}
}
