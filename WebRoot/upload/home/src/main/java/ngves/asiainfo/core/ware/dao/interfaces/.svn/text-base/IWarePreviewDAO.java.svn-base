/**
 * Copyright (c) 2010 asiainfo-linkage.com
 * 2010-10-26 下午01:42:51
 */
package ngves.asiainfo.core.ware.dao.interfaces;

import ngves.asiainfo.core.ware.ivalues.IQBOBusiWareDescValue;
import ngves.asiainfo.core.ware.ivalues.IQBOBusiWareInfoValue;
import ngves.asiainfo.core.ware.ivalues.IQBOWareImageValue;

/**
 * 礼品预览信息对象操作接口
 * 
 * @author huangsong
 */
public interface IWarePreviewDAO {

	/**
	 * 获取待审核礼品礼品基本信息
	 * 
	 * @param busiId
	 * @return
	 * @throws Exception
	 */
	public IQBOBusiWareInfoValue getBusiWareInfo(long busiId) throws Exception;

	/**
	 * 根据要预览的礼品ID，获取礼品图片，第一个为礼品主图片
	 * 
	 * @param wareId
	 * @return
	 * @throws Exception
	 */
	public IQBOWareImageValue[] getWareImages(long wareId,long busiId) throws Exception;

	/**
	 * 获取某个待审核礼品的属性信息
	 * 
	 * @param busiId
	 * @return
	 * @throws Exception
	 */
	public IQBOBusiWareDescValue[] getBusiWareDesc(long busiId) throws Exception;
}
