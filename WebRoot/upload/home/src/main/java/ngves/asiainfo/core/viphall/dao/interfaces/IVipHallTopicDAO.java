package ngves.asiainfo.core.viphall.dao.interfaces;

import ngves.asiainfo.core.viphall.ivalues.IQBOVipHallTopicInfoValue;
import ngves.asiainfo.core.viphall.ivalues.IQBOVipHallWareInfoValue;
import ngves.asiainfo.core.viphall.ivalues.IQBOVipWareDescValue;
import ngves.asiainfo.core.viphall.ivalues.IVipHallCountValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoParentValue;

public interface IVipHallTopicDAO {

	/**
	 * 查询全球通VIP贵宾厅专题 2013-2-25
	 * 
	 * @return
	 * @throws Exception
	 */
	public IQBOVipHallTopicInfoValue[] queryVipHallTopicInfo() throws Exception;

	/**
	 * 
	 * @param topicId
	 * @return
	 * @throws Exception
	 */
	public IQBOVipHallTopicInfoValue queryVipHallTopicInfoById(long topicId) throws Exception;

	/**
	 * 获取VIP贵宾厅类礼品对应的礼品信息
	 * 
	 * @param wareKindId
	 * @param province
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public IQBOVipHallWareInfoValue[] queryVipHallWareInfo(long wareKindId, String province, int startNum, int endNum)
			throws Exception;

	/**
	 * 获取VIP贵宾厅类礼品对应的省份信息
	 * 
	 * @param wareKindId
	 *            礼品小类标识
	 * @return
	 * @throws Exception
	 */
	public IVipHallCountValue queryViphallCountInfo(long wareKindId) throws Exception;
	
	
	/**
	 * 查询VIP是否允许兑换和截止日期是否到期
	 * @param wareId
	 * @return
	 * @throws Exception
	 */
	public IQBOVipWareDescValue[] queryVipWareDesc(long wareId) throws Exception;
	
	/**
	 * 根据礼品ID获取指定礼品信息
	 * 
	 * @param wareId
	 *            礼品ID
	 * @return
	 * @throws Exception
	 */
	public IWareInfoParentValue getWareInfoParent(String wareId) throws Exception;
	/**
	 * 根据子礼品Id获取父礼品ID
	 * @param  childWareId
	 * @return  pWareId
	 * @throws Exception
	 *
	 */
	public long findChildWareIdParentId(String childWareId)throws Exception;
}
