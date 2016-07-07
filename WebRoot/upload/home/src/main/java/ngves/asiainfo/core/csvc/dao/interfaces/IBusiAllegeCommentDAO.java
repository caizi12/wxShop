/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.common.ivalues.IBusiAllegeCommentValue;

/**
 * 中途意见接受流水表DAO层
 * @author sxl
 *
 */
public interface IBusiAllegeCommentDAO {
	
	/**
	 * 保存中途意见接收对象
	 * @param busiAllegeCommentAcceptValue
	 * @return
	 * @throws Exception
	 */
	public long saveBusiAllegeComment(IBusiAllegeCommentValue busiAllegeCommentAcceptValue) throws Exception;


	/**
	 * 根据传递参数条件,查询中途意见记录
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public IBusiAllegeCommentValue[] queryBusiAllegeComment(String condition, Map<String,String> parameter) throws Exception;
	/**
	 * 提供查询投诉再处理流水表状态为"附件接收完成"的投诉记录
	 * @return
	 * @throws Exception
	 */
	public IBusiAllegeCommentValue[] getFinishAttachValues(String status) throws Exception;
	
	/**
	 * 通过主键标识获取对象
	 * @param busiAllegeCommentAcceptId
	 * @return
	 * @throws Exception
	 */
	public IBusiAllegeCommentValue get(long busiAllegeCommentAcceptId) throws Exception;
	
}
