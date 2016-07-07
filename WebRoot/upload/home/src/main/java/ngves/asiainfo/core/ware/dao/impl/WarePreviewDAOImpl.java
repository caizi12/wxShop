/**
 * Copyright (c) 2010 asiainfo-linkage.com
 * 2010-10-26 下午01:43:20
 */
package ngves.asiainfo.core.ware.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.ware.bo.QBOBusiWareDescEngine;
import ngves.asiainfo.core.ware.bo.QBOBusiWareInfoEngine;
import ngves.asiainfo.core.ware.bo.QBOWareImageEngine;
import ngves.asiainfo.core.ware.dao.interfaces.IWarePreviewDAO;
import ngves.asiainfo.core.ware.ivalues.IQBOBusiWareDescValue;
import ngves.asiainfo.core.ware.ivalues.IQBOBusiWareInfoValue;
import ngves.asiainfo.core.ware.ivalues.IQBOWareImageValue;

/**
 * 礼品预览信息对象操作接口
 * 
 * @author huangsong
 */
public class WarePreviewDAOImpl implements IWarePreviewDAO {

	/**
	 * 根据要预览的礼品ID，获取礼品图片的sql，除了审核不通过的图片全部取出
	 */
	private static String SQL_WARE_PREVIEW_IMG = "select * from busi_file_info " +
			" where rlt_id = :ware_id and busi_id= :busi_id and BUSI_STATE not in ( '40' ) order by is_main_pic desc ";

	/**
	 * 获取待审核礼品礼品基本信息
	 * 
	 * @param busiId
	 * @return
	 * @throws Exception
	 */
	public IQBOBusiWareInfoValue getBusiWareInfo(long busiId) throws Exception {
		Map<String, Long> parameter = new HashMap<String, Long>();
		parameter.put("busi_id", busiId);
		IQBOBusiWareInfoValue[] values = QBOBusiWareInfoEngine.getBeans(null, parameter);
		return null != values && 1 <= values.length ? values[0] : null;
	}

	/**
	 * 根据要预览的礼品ID，获取礼品图片，第一个为礼品主图片
	 * 
	 * @param wareId
	 * @return
	 * @throws Exception
	 */
	public IQBOWareImageValue[] getWareImages(long wareId,long busiId) throws Exception {

		// 如果传入的礼品ID不大于0，则直接返回空；
		if (wareId <= 0) {
			return null;
		}
		Map<String, Long> parameter = new HashMap<String, Long>();
		parameter.put("ware_id", wareId);
		parameter.put("busi_id", busiId);
		return QBOWareImageEngine.getBeansFromSql(SQL_WARE_PREVIEW_IMG, parameter);
	}

	/**
	 * 获取某个待审核礼品的属性信息
	 * 
	 * @param busiId
	 * @return
	 * @throws Exception
	 */
	public IQBOBusiWareDescValue[] getBusiWareDesc(long busiId) throws Exception {
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put("busi_id", busiId+"");

		return QBOBusiWareDescEngine.getBeans(null, parameter);
	}

}
