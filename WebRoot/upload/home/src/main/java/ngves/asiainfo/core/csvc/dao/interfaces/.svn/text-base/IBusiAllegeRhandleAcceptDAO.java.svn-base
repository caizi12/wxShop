/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.dao.interfaces;

import ngves.asiainfo.core.common.ivalues.IBusiAllegeRHandleAcceptValue;

/**
 * 投诉再处理接收流水表DAO层
 * @author sxl
 *
 */
public interface IBusiAllegeRhandleAcceptDAO {
	
	/**
	 * 保存投诉再处理到接受流水表
	 * @param busiAllegeRhandleAcceptValue
	 * @throws Exception
	 */
	public void saveBusiAllegeRhandleAccept(IBusiAllegeRHandleAcceptValue busiAllegeRhandleAcceptValue) throws Exception;
	
	/**
	 * 提供查询投诉再处理流水表状态为"附件接收完成"的投诉记录
	 * @return
	 * @throws Exception
	 */
	public IBusiAllegeRHandleAcceptValue[] getFinishRehandleAllege(String busiStatus) throws Exception;
	
	/**
	 * 通过主键表示获取对象
	 * @param busiAllegeRhandleAcceptId
	 * @return
	 * @throws Exception
	 */
	public IBusiAllegeRHandleAcceptValue get(long busiAllegeRhandleAcceptId ) throws Exception;
	
}
