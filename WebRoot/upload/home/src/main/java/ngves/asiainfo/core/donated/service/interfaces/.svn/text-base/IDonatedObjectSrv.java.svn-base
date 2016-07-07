package ngves.asiainfo.core.donated.service.interfaces;

import ngves.asiainfo.core.donated.dao.interfaces.IDonatedObjectDAO;
import ngves.asiainfo.core.donated.ivalues.IDistributionInfoValue;
import ngves.asiainfo.core.donated.ivalues.IDonatedActivityValue;
import ngves.asiainfo.core.donated.ivalues.IDonatedObjectsValue;
import ngves.asiainfo.core.donated.ivalues.IQBODonatedObjectRltValue;

public interface IDonatedObjectSrv {
	
	public void setDonatedObjectDAO(IDonatedObjectDAO donatedObjectDAO) throws Exception;
	/**
	 * by gk 
	 * @param objectName
	 * @param $STARTROWINDEX
	 * @param $ENDROWINDEX
	 * @return 捐赠对象管理的信息列表
	 * @throws Exception
	 */

	public IDonatedObjectsValue[] queryObjectInfo(String objectName, int startIndex, int endIndex) throws Exception;

/**
 *  
 *  by gk
 *  
 * @param objectName
 * @return  捐赠对象管理的信息总数
 * @throws Exception
 */
    public int queryObjectInfoCount(String objectName)throws Exception;
    
    /**
     * 保存捐赠对象
     * @param donatedObjectsValue
     * @throws Exception
     */
    public String saveDonatedObject(IDonatedObjectsValue donatedObjectsValue) throws Exception;
    
    /**
     * 保存捐赠对象地址信息
     * @param donatedObjectsValue
     * @throws Exception
     */
    public String saveDistrictInfo(IDistributionInfoValue distributionInfoValue) throws Exception;
    
    /**
     * 保存捐赠对象描述信息
     * @param donatedObjectsValue
     * @throws Exception
     */
    public boolean saveDonatedObjDesc(String objId, String tableName, String desc) throws Exception;
    
    /**
     * 获取所有捐赠对象
     * @return
     * @throws Exception
     */
    public IDonatedObjectsValue[] getAllIDonatedObjectsValue()throws Exception;

    
    
    /**
	 * 对捐赠对象进行停用启用操作
	 * @param  partnerId
	 * @throws Exception
	 */
	public void setObject(String objectId) throws Exception;
	
	
	/**
	 * 根据ObjectId来查询判定是否存在活动引用，如果存在引用需要返还活动状态
	 * @param objectId
	 * @throws Exception
	 */
	public IDonatedActivityValue queryActiveObjectRlt(String objectId) throws Exception;
	
	/**
	 * 通过id获取捐赠对象信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public IDonatedObjectsValue queryObjectInfoById(long id) throws Exception;
	
	/**
	 * 通过捐赠活动id，查询出所有与捐赠活动绑定的捐赠对象信息
	 * @param donatedActivityId 捐赠活动id
	 * @return
	 * @throws Exception
	 */
	public IQBODonatedObjectRltValue[] queryAllObjectInfo(String donatedActivityId) throws Exception;
	
	/**
	 * 通过对象id获取对象描述
	 * @param objId
	 * @return
	 * @throws Exception
	 */
	public String getDonatedDesc(long objId) throws Exception;

	
}
