/**
 * 积分捐赠基本信息服务层接口
 */
package ngves.asiainfo.core.donated.service.interfaces;

import ngves.asiainfo.core.common.dao.interfaces.IClobInfoDAO;
import ngves.asiainfo.core.donated.dao.interfaces.IDonatedActivityDAO;
import ngves.asiainfo.core.donated.ivalues.IDonatedActivityValue;
import ngves.asiainfo.core.donated.ivalues.IDonatedPicValue;
import ngves.asiainfo.core.donated.ivalues.IQBODonatedObjectRltValue;
import ngves.asiainfo.core.donated.ivalues.IQBODonatedWareBindValue;
import ngves.asiainfo.core.donated.ivalues.IQBODonatedWareInfoValue;

/**
 * @author liuyq7@asiainfo-linkage.com
 * 
 */
public interface IDonatedActivitySrv {

	public void setClobInfoDAO(IClobInfoDAO clobInfoDAO) throws Exception;

	public void setDonatedActivityDAO(IDonatedActivityDAO donatedActivityDAO) throws Exception;

	/**
	 * 根据捐赠活动ID，获得捐赠活动的基本信息 如果没有值，返回空(null)
	 * 
	 * @param donatedId
	 *            捐赠活动ID
	 * @return
	 * @throws Exception
	 */
	public IDonatedActivityValue getDonatedActivityById(String donatedId) throws Exception;

	/**
	 * 保存捐赠活动信息，只用于新增
	 * 
	 * @param value
	 * @return 返回appVersion DONATED_ACTIVITY 表中防止并发的字段
	 * @throws Exception
	 */
	public long saveNewDonatedActivity(IDonatedActivityValue value) throws Exception;

	/**
	 * 保存捐赠活动信息，用于更新
	 * 
	 * @param value
	 * @return 返回appVersion
	 *         <p>
	 *         DONATED_ACTIVITY 表中防止并发的字段
	 *         </p>
	 *         当前数据项的版本
	 * @throws Exception
	 */
	public long updateDonatedActivity(IDonatedActivityValue value) throws Exception;

	/**
	 * By luohuan
	 * 
	 * @param donotedActivityName
	 * @return 捐赠活动信息列表
	 * @throws Exception
	 */
	public IDonatedActivityValue[] queryDonotedActivity(String donotedActivityName, int startIndex, int endIndex)
			throws Exception;

	/**
	 * By luohuan
	 * 
	 * @param donotedActivityName
	 * @return 捐赠活动信息总条数
	 * @throws Exception
	 */
	public int queryDonotedActCount(String donotedActivityName) throws Exception;

	/**
	 * 积分捐赠活动中，保存积分活动捐赠图片信息。
	 * 
	 * @param value
	 * @return 积分捐赠活动图片信息的ID
	 * @throws Exception
	 */
	public long saveDonatedPic(IDonatedPicValue value) throws Exception;

	/**
	 * 积分捐赠活动中，更新积分捐赠活动的图片信息。
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public long updateDonatedPic(IDonatedPicValue value) throws Exception;

	/**
	 * 删除一个捐赠活动
	 * 
	 * @throws Exception
	 */
	public void delDonatedActy(String donatedId) throws Exception;

	/**
	 * 提前结束捐赠活动
	 */
	public void earlyStopDonated(String donatedId) throws Exception;

	/**
	 * 根据捐赠活动名称，判断是否存在有相同的捐赠名称的活动 如果有 返回 true 如果没有 返回 false
	 * 
	 * @param donatedActivityName
	 *            捐赠活动名称
	 * @return
	 * @throws Exception
	 */
	public boolean isExistSameName(String donatedActivityName) throws Exception;
	
	
	/**
	 * 根据捐赠活动图片ID获得捐赠活动图片的信息
	 * @param donatedPicId  捐赠活动图片ID，由于这个是jsp页面中直接调用的，所以这里并没有采用long 传值，而是采用String 
	 * @return 
	 * @throws Exception
	 */
	public IDonatedPicValue getDonatedPicById(String donatedPicId) throws Exception;
	
	/**
	 * 根据积分捐赠活动ID，查询出和积分捐赠活动绑定的捐赠对象信息
	 * @param donatedActivityId
	 * @return
	 * @throws Exception
	 */
	public IQBODonatedObjectRltValue []queryDonatedObjectInfo(String donatedActivityId) throws Exception;
	
	
	/**
	 * 保存积分捐赠活动与对象关系信息
	 * @param donatedActivityId  	积分捐赠活动ID
	 * @param objectIdArray			捐赠对象ID数组，用','分割
	 * @throws Exception
	 */
	public String saveDonatedObjectRltValue (long donatedActivityId,String objectIdArray) throws Exception;
	
	/**
	 * 更新积分捐赠活动与对象的关系
	 * @param value
	 * @return  返回各条记录中的appVersion 字段 order by object_sort asc 从小到大 利用英文半角逗号','分割
	 * @throws Exception
	 */
	public String updateDonatedObjectRltValue(IQBODonatedObjectRltValue [] value) throws Exception;
	
	/**
	 * 利用ID，删除捐赠活动与对象的绑定关系
	 * @param idArray
	 * @return
	 * @throws Exception
	 */
	public void deleteDonatedObjectRltValue(String idArray)throws Exception;
	
	
	/**
	 * 查询支持捐赠类型的礼品，支持礼品编码和礼品名称的模糊查找
	 * @param wareCode 礼品编码
	 * @param wareName 礼品名称
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IQBODonatedWareInfoValue [] getDonatedWareInfoValue(String wareCode,String wareName, int startIndex, int endIndex) throws Exception;
	
	/**
	 * 查询支持捐赠类型的礼品数量，用于分页功能
	 * @param wareCode 礼品编码
	 * @param wareName 礼品名称
	 * @return
	 * @throws Exception
	 */
	public int getDonatedWareInfoCount(String wareCode,String wareName) throws Exception;
	
	
	/**
	 * 根据积分捐赠活动ID 查询到与该活动相互关联礼品的信息
	 * @param donatedActivityId
	 * @return
	 * @throws Exception
	 */
	public IQBODonatedWareBindValue []queryDonatedWareRltInfo(String donatedActivityId) throws Exception;
	
	/**
	 * 根据礼品ID 和捐赠活动ID 查询出所有捐赠对象的ID信息，用','(英文半角逗号)分割
	 * @param donatedWareId  捐赠礼品
	 * @param donatedActivityId 捐赠活动ID
	 * @return 字符串  例如：0001,0002,0005,3232,2322,3333
	 * @throws Exception
	 */
	public String getWareBindObjectId(long donatedWareId,long donatedActivityId)throws Exception;
	
	/**
	 * 根据捐赠活动的ID，如果该捐赠活动的状态为“未发布”，那么将状态设置为“已发布”
	 * @param donatedActivityId
	 * @throws MgtDonatedException 包括，活动不存在，活动状态不正确
	 */
	public void publishDonatedActivity(long donatedActivityId) throws Exception;
	
	
	/**
	 * 保存礼品与积分捐赠活动绑定信息
	 * @param value 礼品信息
	 * @param donatedActivityId 捐赠活动ID
	 * @throws Exception
	 */
	public void saveDonatedWareRltInfo(IQBODonatedWareBindValue [] value,long donatedActivityId) throws Exception;

}
