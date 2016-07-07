/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.dao.impl;

import java.util.Map;
import java.util.HashMap;
import ngves.asiainfo.core.common.bo.BusiAllegeCommentEngine;
import ngves.asiainfo.core.common.ivalues.IBusiAllegeCommentValue;
import ngves.asiainfo.core.csvc.dao.interfaces.IBusiAllegeCommentDAO;
import ngves.asiainfo.util.DateTimeUtil;

/**
 * 中途意见接受流水表DAO层的默认实现类
 * @author sxl
 *
 */
public class BusiAllegeCommentDAOImpl implements IBusiAllegeCommentDAO {

	/**
	 * 查询中途意见流水表状态为"附件接收完成"的投诉记录
	 */
	private static final String GET_FINISH_ATTACHVALUE_SQL = IBusiAllegeCommentValue.S_BusiStatus +" = :" + IBusiAllegeCommentValue.S_BusiStatus;
	
	
	public long saveBusiAllegeComment(IBusiAllegeCommentValue busiAllegeCommentAcceptValue) throws Exception {
		if (busiAllegeCommentAcceptValue.isNew()) {
			busiAllegeCommentAcceptValue.setBusiId(BusiAllegeCommentEngine.getNewId().longValue());
		}
		busiAllegeCommentAcceptValue.setCreateDate(DateTimeUtil.getNowTimeStamp());
		BusiAllegeCommentEngine.save(busiAllegeCommentAcceptValue);
		return busiAllegeCommentAcceptValue.getBusiId();
	}

	public IBusiAllegeCommentValue[] queryBusiAllegeComment(String condition,
			Map<String, String> parameter) throws Exception {
		
		return BusiAllegeCommentEngine.getBeans(condition, parameter);
	}

	public IBusiAllegeCommentValue[] getFinishAttachValues(String status) throws Exception {
		
		Map<String, String> param = new HashMap<String, String>();
		param.put(IBusiAllegeCommentValue.S_BusiStatus, status);
		
	    return BusiAllegeCommentEngine.getBeans(GET_FINISH_ATTACHVALUE_SQL, param);
	}

	public IBusiAllegeCommentValue get(long busiAllegeCommentAcceptId) throws Exception {
		return BusiAllegeCommentEngine.getBean(busiAllegeCommentAcceptId);
	}
	
	

}
