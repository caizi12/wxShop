package ngves.asiainfo.core.viphall.service.impl;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.common.dao.interfaces.IClobInfoDAO;
import ngves.asiainfo.core.viphall.dao.interfaces.IVipHallTopicDAO;
import ngves.asiainfo.core.viphall.ivalues.IQBOVipHallTopicInfoValue;
import ngves.asiainfo.core.viphall.ivalues.IQBOVipHallWareInfoValue;
import ngves.asiainfo.core.viphall.ivalues.IQBOVipWareDescValue;
import ngves.asiainfo.core.viphall.ivalues.IVipHallCountValue;
import ngves.asiainfo.core.viphall.service.interfaces.IVipHallTopicSrv;
import ngves.asiainfo.core.ware.ivalues.IWareInfoParentValue;

public class VipHallTopicSrvImp implements IVipHallTopicSrv {

	private IVipHallTopicDAO vipHallTopicDAO;
	private IClobInfoDAO clobInfoDAO;

	public void setVipHallTopicDAO(IVipHallTopicDAO vipHallTopicDAO) throws Exception {
		this.vipHallTopicDAO = vipHallTopicDAO;
	}

	public void setClobInfoDAO(IClobInfoDAO clobInfoDAO) throws Exception {
		this.clobInfoDAO = clobInfoDAO;
	}

	public IQBOVipHallTopicInfoValue[] queryVipHallTopicInfo() throws Exception {

		IQBOVipHallTopicInfoValue[] vipHallTopicInfo = vipHallTopicDAO.queryVipHallTopicInfo();
		if (vipHallTopicInfo != null && vipHallTopicInfo.length > 0) {
			String richTextContent = "";
			for (IQBOVipHallTopicInfoValue value : vipHallTopicInfo) {
				richTextContent = clobInfoDAO.getContent(value.getTopicId(), CoreConstant.VIP_HALL_TOPIC_TABLE_NAME);
				value.setTopicDescription(richTextContent);
			}
		}
		return vipHallTopicInfo;
	}

	public IQBOVipHallTopicInfoValue queryVipHallTopicInfoById(long topicId) throws Exception {

		IQBOVipHallTopicInfoValue vipHallTopicInfo = vipHallTopicDAO.queryVipHallTopicInfoById(topicId);
		if (vipHallTopicInfo != null) {
			String richTextContent = clobInfoDAO.getContent(vipHallTopicInfo.getTopicId(),
					CoreConstant.VIP_HALL_TOPIC_TABLE_NAME);
			vipHallTopicInfo.setTopicDescription(richTextContent);
		}
		return vipHallTopicInfo;
	}

	public IVipHallCountValue queryViphallCountInfo(long wareKindId) throws Exception {
		return vipHallTopicDAO.queryViphallCountInfo(wareKindId);
	}

	public IQBOVipHallWareInfoValue[] queryVipHallWareInfo(long wareKindId, String province, int startNum, int endNum)
			throws Exception {
		return vipHallTopicDAO.queryVipHallWareInfo(wareKindId, province, startNum, endNum);
	}
	
	public IQBOVipWareDescValue[] queryVipWareDesc(long wareId) throws Exception{
		return vipHallTopicDAO.queryVipWareDesc(wareId);
	}
	/**
	 * 根据礼品ID获取指定礼品信息
	 * 
	 * @param wareId
	 *            礼品ID
	 * @return
	 * @throws Exception
	 */
	public IWareInfoParentValue getWareInfoParent(String wareId) throws Exception {
		return vipHallTopicDAO.getWareInfoParent(wareId);
	}
	/**
	 * 根据子礼品Id获取父礼品ID
	 * @param  childWareId
	 * @return  pWareId
	 * @throws Exception
	 *
	 */
	public long findChildWareIdParentId(String childWareId)throws Exception{
		return vipHallTopicDAO.findChildWareIdParentId(childWareId);
	}
}
