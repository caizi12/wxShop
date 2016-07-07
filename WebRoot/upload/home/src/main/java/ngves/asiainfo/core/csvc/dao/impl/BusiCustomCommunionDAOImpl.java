/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.common.bo.BusiCustomCommunionBean;
import ngves.asiainfo.core.common.bo.BusiCustomCommunionEngine;
import ngves.asiainfo.core.common.ivalues.IBusiCustomCommunionValue;
import ngves.asiainfo.core.csvc.CsvcConstant;
import ngves.asiainfo.core.csvc.dao.interfaces.IBusiCustomCommunionDAO;

/**
 * 客服交互流水表DAO层的默认实现类
 * 
 * @author ggs
 */
public class BusiCustomCommunionDAOImpl implements IBusiCustomCommunionDAO {

	private static final String GETWAITATTACHVALUES_SQL = IBusiCustomCommunionValue.S_BusiStatus + " =:"
			+ IBusiCustomCommunionValue.S_BusiStatus;
	
	public IBusiCustomCommunionValue[] getWaitAttachValues() throws Exception {
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put(IBusiCustomCommunionValue.S_BusiStatus, CsvcConstant.BUSI_STATUS_ACCEPT);
		return BusiCustomCommunionEngine.getBeans(GETWAITATTACHVALUES_SQL, parameter);
	}

	/**
	 * 保存(或更新)交互流水对象
	 * @param busiCustomCommunionValue
	 * @throws Exception
	 */
	public void saveBusiCustomCommunion(IBusiCustomCommunionValue busiCustomCommunionValue) throws Exception {

		if (busiCustomCommunionValue.isNew()) {
			busiCustomCommunionValue.setBusiId(BusiCustomCommunionEngine.getNewId().longValue());
		}
		BusiCustomCommunionEngine.save(busiCustomCommunionValue);
	}

	/**
	 * 发送保存交互流水对象
	 * @param busiCustomCommunionValue
	 * @throws Exception
	 */
	public void saveSendBusiCustomCommunion(String busiStatus, String actionType, long actionBusiId, String indictSeq)
			throws Exception {
		saveBusiCustomCommunion(busiStatus, actionType, actionBusiId, CsvcConstant.SYS_PARA_USER_HEAD,
				CsvcConstant.SYS_PARA_CUSTOM_FIRST_SERVICE, indictSeq);
	}

	/**
	 * 接受一级客服保存交互流水对象
	 * @param busiCustomCommunionValue
	 * @throws Exception
	 */
	public void saveAcceptBusiCustomCommunion(String busiStatus, String actionType, long actionBusiId, String indictSeq)
			throws Exception {
		saveBusiCustomCommunion(busiStatus, actionType, actionBusiId, CsvcConstant.SYS_PARA_CUSTOM_FIRST_SERVICE,
				CsvcConstant.SYS_PARA_USER_HEAD, indictSeq);
	}

	/**
	 * 重构抽象出来的代码
	 * @param busiStatus
	 * @param actionType
	 * @param actionBusiId
	 * @param sendUser
	 * @param acceptUser
	 * @throws Exception
	 */
	private void saveBusiCustomCommunion(String busiStatus, String actionType, long actionBusiId, String sendUser,
			String acceptUser, String indictSeq) throws Exception {
		IBusiCustomCommunionValue value = new BusiCustomCommunionBean();
		value.setSendUser(sendUser);
		value.setAcceptUser(acceptUser);
		value.setOptDate(new Timestamp(new Date().getTime()));
		value.setBusiStatus(busiStatus);
		value.setActionType(actionType);
		value.setActionBusiId(actionBusiId);
		value.setIndictseq(indictSeq);
		saveBusiCustomCommunion(value);
	}

	/**
	 * 根据传递参数条件,查询一级客服交互流水记录
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public IBusiCustomCommunionValue[] queryBusiCustomCommunion(String condition, Map<String, String> parameter)
			throws Exception {

		return BusiCustomCommunionEngine.getBeans(condition, parameter);
	}

}
