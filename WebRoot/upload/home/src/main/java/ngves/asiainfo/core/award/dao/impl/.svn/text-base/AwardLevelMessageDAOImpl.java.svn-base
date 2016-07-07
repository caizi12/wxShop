package ngves.asiainfo.core.award.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import ngves.asiainfo.core.award.bo.AwardLevelMessageEngine;
import ngves.asiainfo.core.award.dao.interfaces.IAwardLevelMessageDAO;
import ngves.asiainfo.core.award.ivalues.IAwardLevelMessageValue;

public class AwardLevelMessageDAOImpl implements IAwardLevelMessageDAO {

	public long addAwardLevelMessageInfos(IAwardLevelMessageValue[] values) throws Exception {
		long awardMessageId = -1;
		for(IAwardLevelMessageValue value : values){
			if (value.isNew()) {
				if(value.getAwardMessageId()==0l){
					awardMessageId=AwardLevelMessageEngine.getNewId().longValue();
					value.setAwardMessageId(awardMessageId);
				}
			}
		}
		AwardLevelMessageEngine.saveBatch(values);
		return awardMessageId;
	}

	public void deleteAwardLevelMessageInfos(String awardId) throws Exception {
		IAwardLevelMessageValue[] avalues = findMessageByAwardId(awardId);
		if (null != avalues&&avalues.length>0) {
			for(IAwardLevelMessageValue value:avalues){
				value.delete();
			}
			AwardLevelMessageEngine.saveBatch(avalues);
		}
		
	}

	public IAwardLevelMessageValue[] findMessageByAwardId(String awardId) throws Exception{
			StringBuffer sql = new StringBuffer();
			Map<String, Object> params = new HashMap<String, Object>();
			if (StringUtils.isNotBlank(awardId)) {
				sql.append(IAwardLevelMessageValue.S_AwardId).append(" =:").append(IAwardLevelMessageValue.S_AwardId).append(" ");
				params.put(IAwardLevelMessageValue.S_AwardId, Long.parseLong(awardId));
			}
			sql.append("order by  AWARD_MESSAGE_ID");
			return AwardLevelMessageEngine.getBeans(sql.toString(), params);
	}

	public IAwardLevelMessageValue[] findMessageByAwardId(Long awardId,String  wareCode,String status) throws Exception{
		StringBuffer sql = new StringBuffer();
		sql.append("1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (awardId>0l) {
			sql.append(" AND "+IAwardLevelMessageValue.S_AwardId).append(" =:").append(IAwardLevelMessageValue.S_AwardId).append(" ");
			params.put(IAwardLevelMessageValue.S_AwardId, awardId);
		}
		if (StringUtils.isNotBlank(wareCode)) {
			sql.append(" AND "+IAwardLevelMessageValue.S_WareCode).append(" =:").append(IAwardLevelMessageValue.S_WareCode).append(" ");
			params.put(IAwardLevelMessageValue.S_WareCode,wareCode);
		}
		if (StringUtils.isNotBlank(status)) {
			sql.append(" AND "+IAwardLevelMessageValue.S_Status).append(" =:").append(IAwardLevelMessageValue.S_Status).append(" ");
			params.put(IAwardLevelMessageValue.S_Status,status);
		}
		sql.append("order by  AWARD_MESSAGE_ID");
		return AwardLevelMessageEngine.getBeans(sql.toString(), params);
	}

	public IAwardLevelMessageValue getMessage(String messageId)
			throws Exception {		
		return AwardLevelMessageEngine.getBean(Long.parseLong(messageId));
	}

	public IAwardLevelMessageValue[] getMessagesByIds(String messageIds)
			throws Exception {
		
		String[] arrIds=messageIds.split(",");
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT *   FROM  AWARD_LEVEL_MESSAGE  WHERE AWARD_MESSAGE_ID  in (");
		for(int i=0;i<arrIds.length;i++){
			sql.append(Long.parseLong(arrIds[i])).append(",");
		}
		String beanSql=sql.substring(0, sql.length()-1)+")";
		
		return AwardLevelMessageEngine.getBeansFromSql(beanSql, null);
	}

	

}
