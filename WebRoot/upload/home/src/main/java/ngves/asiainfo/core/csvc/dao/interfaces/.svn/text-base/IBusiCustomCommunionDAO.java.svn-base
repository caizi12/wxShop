/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.common.ivalues.IBusiCustomCommunionValue;


/**
 * 客服交互流水表DAO层
 * 
 * @author ggs
 */
public interface IBusiCustomCommunionDAO {
	
	/**
	 * 获取附件还没有下载的客户交互流水记录
	 * @return
	 * @throws Exception
	 */
	public IBusiCustomCommunionValue[] getWaitAttachValues() throws Exception;

	/**
	 * 保存交互流水对象
	 * @param busiCustomCommunionValue
	 * @throws Exception
	 */
	public void saveBusiCustomCommunion(IBusiCustomCommunionValue busiCustomCommunionValue) throws Exception;
	/**
	 * 发送保存交互流水对象
	 * @param busiCustomCommunionValue
	 * @throws Exception
	 */
	public void saveSendBusiCustomCommunion(String busiStatus,String actionType,long actionBusiId,String indictSeq) throws Exception;
	
	/**
	 * 接受一级客服保存交互流水对象
	 * @param busiCustomCommunionValue
	 * @throws Exception
	 */
	public void saveAcceptBusiCustomCommunion(String busiStatus, String actionType, long actionBusiId,String indictSeq) throws Exception;
	
	/**
	 * 根据传递参数条件,查询一级客服交互流水记录
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public IBusiCustomCommunionValue[] queryBusiCustomCommunion(String condition, Map<String,String> parameter) throws Exception;
}
