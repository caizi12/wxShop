package ngves.asiainfo.core.donated.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.donated.ivalues.IDistributionInfoValue;
import ngves.asiainfo.core.donated.ivalues.IDonatedActivityValue;
import ngves.asiainfo.core.donated.ivalues.IDonatedObjectsValue;
import ngves.asiainfo.core.donated.ivalues.IQBODonatedObjectRltValue;

public interface IDonatedObjectDAO {
	/**
	 * by gk
	 * 
	 * @param objectName
	 * @param startIndex
	 * @param endIndex
	 * @return 捐赠对象管理列表
	 * @throws Exception
	 */
	public IDonatedObjectsValue[] queryObjectInfo(String objectName, int startIndex, int endIndex) throws Exception;

	/**
	 * by gk
	 * 
	 * @param objectName
	 * @return 捐赠对象管理的信息总数
	 * @throws Exception
	 */
	public int queryObjectInfoCount(String objectName) throws Exception;

	/**
	 * by gk 查询捐赠对象
	 * 
	 * @param string
	 * @param parameter
	 * @param string2
	 * @return
	 * @throws Exception
	 */
	public IDonatedObjectsValue[] queryObjects(String condition, Map<String, String> parameter) throws Exception;

	/**
	 * 更新对象信息
	 * 
	 * @param donatedObjectInfoTemp
	 * @throws Exception
	 */
	public void updateObject(IDonatedObjectsValue donatedObjectInfoTemp) throws Exception;

	/**
	 * 根据对象Id查询对应的活动
	 * 
	 * @param condition
	 * @param parameter
	 * @return
	 */
	public IDonatedActivityValue queryActives(String condition, Map<String, String> parameter) throws Exception;

	/**
	 * 保存捐赠对象
	 * 
	 * @param donatedObjectsValue
	 * @throws Exception
	 */
	public String saveDonatedObject(IDonatedObjectsValue donatedObjectsValue) throws Exception;

	/**
	 * 保存捐赠对象地址信息
	 * 
	 * @param donatedObjectsValue
	 * @throws Exception
	 */
	public String saveDistrictInfo(IDistributionInfoValue distributionInfoValue) throws Exception;

	/**
	 * 获取所有捐赠对象
	 * 
	 * @return
	 * @throws Exception
	 */
	public IDonatedObjectsValue[] getAllIDonatedObjectsValue() throws Exception;

	/**
	 * 通过id获取捐赠对象信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public IDonatedObjectsValue queryObjectInfoById(long id) throws Exception;

	/**
	 * 根据条件，查询出符合要求的捐赠对象信息
	 * @param conditon
	 * @param parameter
	 * @return  捐赠对象与捐赠活动的关系数组
	 * @throws Exception
	 */
	public IQBODonatedObjectRltValue[] getDonatedObjectRltInfo(String conditon, Map<String, String> parameter)
			throws Exception;

}
