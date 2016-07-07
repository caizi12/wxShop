package ngves.asiainfo.core.donated.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.donated.ivalues.IActivityObjectsRltValue;
import ngves.asiainfo.core.donated.ivalues.IActivityWareRltValue;
import ngves.asiainfo.core.donated.ivalues.IDonatedActivityValue;
import ngves.asiainfo.core.donated.ivalues.IDonatedPicValue;
import ngves.asiainfo.core.donated.ivalues.IQBODonatedObjectRltValue;
import ngves.asiainfo.core.donated.ivalues.IQBODonatedWareBindValue;
import ngves.asiainfo.core.donated.ivalues.IQBODonatedWareInfoValue;
import ngves.asiainfo.core.donated.ivalues.IQBOWareObjectRltValue;


public interface IDonatedActivityDAO {

	/**
	 * 保存积分捐赠基本信息
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public long saveDonatedActivity( IDonatedActivityValue value) throws Exception;
	
	
	/**
	 * 保存积分捐赠基本信息 （对象数组）
	 * @param value
	 * @throws Exception
	 */
	public void saveDonatedActivity(IDonatedActivityValue []value) throws Exception;
	
	/**
	 * 捐赠活动信息列表
	 * @param donotedActivityName 捐赠活动名
	 * @param startIndex 开始索引
	 * @param endIndex 结束索引
	 * @return 
	 * @author luohuan
	 */
	public IDonatedActivityValue[] queryDonotedActivity(String donotedActivityName, int startIndex, int endIndex)throws Exception;
	
	
	/**
	 * @author luohuaa
	 * @return 信息总条数
	 */
	public int queryDonotedActCount(String donotedActivityName)throws Exception;
	
	/**
	 * 积分捐赠活动中，保存捐赠活动图片信息
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public long saveDonatedPic(IDonatedPicValue value) throws Exception;
	
	/**
	 * 根据积分捐赠ID，获得积分捐赠的活动信息
	 * 如果没有找到活动，返回一个只有ID信息的空值
	 * @param donatedActivityId
	 * @return
	 * @throws Exception
	 */
	public IDonatedActivityValue getDonatedActivityById(long donatedActivityId) throws Exception;
	
	/**
	 * 根据条件，查询捐赠对象信息
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public IDonatedActivityValue [] getDonatedActivityValue(String condition,Map<String,String> parameter) throws Exception;
	
	
	/**
	 * 根据捐赠活动图片的ID，查找出对应的图片信息
	 * @param donatedPicId
	 * @return
	 * @throws Exception
	 */
	public IDonatedPicValue getDonatedPicValueById(long donatedPicId) throws Exception;
	
	
	/**
	 * 查询出积分捐赠活动与积分捐赠对象的关系信息
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public IQBODonatedObjectRltValue[] getDonatedObjectRltValue(String condition,Map<String,String> parameter) throws Exception;
	
	/**
	 * 保存积分捐赠活动与捐赠对象的关系 ACTIVITY_OBJECTS_RLT
	 * @param value  
	 * @return 返回对象的ID
	 * @throws Exception
	 */
	public long saveDonatedObjectRltValue(IActivityObjectsRltValue value) throws Exception;
	
	/**
	 * 保存积分捐赠活动与对象关系对象
	 * @param value
	 * @throws Exception
	 */
	public void saveDonatedObjectRltValue(IActivityObjectsRltValue[] value) throws Exception;
	
	
	/**
	 * 查询积分捐赠活动与积分捐赠对象关系信息
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public IActivityObjectsRltValue [] getActivityObjectsRltValue(String condition,Map<String,String> parameter) throws Exception;
	
	
	/**
	 * 查询支持捐赠类型的礼品，支持礼品编码和礼品名称的模糊查找
	 * @param  	condition  wareCode 礼品编码 和  wareName 礼品名称 组成的查询语句
	 * @param  	parameter
	 * @param 	startNum
	 * @param 	endNum
	 * @return
	 * @throws Exception
	 */
	
	public IQBODonatedWareInfoValue [] getDonatedWareInfoValue(String condition, Map<String, String> parameter, int startNum, int endNum) throws Exception;
	
	/**
	 * 查询支持捐赠类型的礼品数量，用于分页功能
	 * @param  	condition  wareCode 礼品编码 和  wareName 礼品名称 组成的查询语句
	 * @param  	parameter
	 * @return
	 * @throws Exception
	 */
	public int getDonatedWareInfoCount(String condition, Map<String, String> parameter) throws Exception;
	
	/**
	 * 根据条件，查询与捐赠活动绑定的礼品信息
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public IQBODonatedWareBindValue[] getDonatedWareBindValue(String condition, Map<String, String> parameter)throws Exception;
	

	/**
	 * 根据条件，查询对象和礼品关联表信息
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public IActivityWareRltValue[] getActivityWareRltValue(String condition,Map<String,String> parameter)throws Exception;
	
	
	/**
	 * 保存积分捐赠活动中，礼品和对象之间的关系
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public long saveActivityWareRltValue(IActivityWareRltValue value)throws Exception;
	
	/**
	 * 保存积分捐赠活动中，礼品和对象之间的关系
	 * @param value
	 * @throws Exception
	 */
	public void saveActivityWareRltValue(IActivityWareRltValue[] value)throws Exception;
	/**
	 * 根据条件，查询捐赠活动，捐赠对象，捐赠礼品的关系数据
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public IQBOWareObjectRltValue [] getWareObjectRltValue(String condition,Map<String,String> parameter)throws Exception;
	
}
