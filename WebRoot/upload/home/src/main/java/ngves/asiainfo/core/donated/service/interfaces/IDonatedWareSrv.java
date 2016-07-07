package ngves.asiainfo.core.donated.service.interfaces;

import ngves.asiainfo.core.donated.dao.interfaces.IDonatedActivityDAO;
import ngves.asiainfo.core.donated.dao.interfaces.IDonatedObjectDAO;

/**
 * 积分捐赠活动中，活动与礼品之间的关系服务
 * @author liuyq7@asiainfo-linkage.com
 *
 */
public interface IDonatedWareSrv {
	
	public void setDonatedActivityDAO(IDonatedActivityDAO donatedActivityDAO) throws Exception;
	public void setDonatedObjectDAO(IDonatedObjectDAO donatedObjectDAO) throws Exception;

	/**
	 * 绑定积分捐赠礼品
	 * @param donatedActivityId  	积分捐赠活动ID
	 * @param wareIdArray			捐赠礼品ID数组，用','分割
	 * @throws Exception
	 */
	public void bindDonatedWareRltValue (long donatedActivityId,String wareIdArray) throws Exception; 
	
	/**
	 * 解除积分捐赠礼品的绑定信息
	 * @param donatedActivityId  	积分捐赠活动ID
	 * @param wareIdArray			要绑定的礼品ID数组，用','分割
	 * @return
	 * @throws Exception
	 */
	public void unbindDonatedWareRltValue (long donatedActivityId,String wareIdArray) throws Exception;
	
	//TODO 参数没有想清楚
	//public String saveDonatedWareRltValue()throws Exception;
	
	
	/**
	 * 保存捐赠礼品和捐赠对象的关系
	 * @param donatedActivityId			捐赠活动ID
	 * @param wareId					捐赠礼品ID
	 * @param objectIdArray				捐赠对象信息
	 * <pre>
	 * 捐赠对象信息这里采用字符串的格式：对象ID,对象ID...,对象ID
	 * 例如：1000000000000001,1000000000000002,1000000000000003,1000000000000004
	 * </pre>
	 * @return
	 * @throws Exception
	 */
	public String saveWareObjectRltValue(long donatedActivityId,long wareId,String objectIdArray)throws Exception;

}
