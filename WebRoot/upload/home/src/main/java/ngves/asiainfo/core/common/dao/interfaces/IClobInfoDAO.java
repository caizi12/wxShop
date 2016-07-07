/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.common.dao.interfaces;

/**
 * 对有clob字段的表clob_info进行操作的封装
 * @author wzg
 *
 */
public interface IClobInfoDAO {

	/**
	 * 保存内容到clob字段中
	 * @param id
	 * @param tableName
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public boolean saveClobInfo(long id, String tableName, String content) throws Exception;

	/**
	 * 读取clob字段的内容,如果没有对应的记录返回null
	 * @param id
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public String getContent(long id, String tableName) throws Exception;

	/**
	 * 删除CLOB信息
	 * @param id
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public boolean deleteClobInfo(long id, String tableName) throws Exception;
}
