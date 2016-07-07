package ngves.asiainfo.core.mobile.service.interfaces;

import java.util.List;
import java.util.Map;

import ngves.asiainfo.core.mobile.dao.interfaces.IMobileFloorManageDAO;
import ngves.asiainfo.core.mobile.ivalues.IMobileFloorInfoValue;
import ngves.asiainfo.core.mobile.ivalues.IMobileFloorRltValue;
import ngves.asiainfo.core.mobile.model.RecommendFloorInfo;

/**
 * 触屏版首页楼层推荐管理服务层
 * @author yeqh
 * 2014-12-28
 */
public interface IMobileFloorManageSrv {
	
	public void setMobileFloorManageDAO(IMobileFloorManageDAO mobileFloorManageDAO) throws Exception; 
	
	
	/**
	 * 根据楼层名称查询楼层信息
	 * 如果为空查询所有未被删除的楼层信息
	 * @throws Exception
	 */
	public IMobileFloorInfoValue[] getMobileFloorInfo(String floorName, int $STARTROWINDEX, int $ENDROWINDEX) throws Exception;
	
	/**
	 * 根据楼层名称查询楼层信息
	 * @throws Exception
	 */
	public IMobileFloorInfoValue[] getMobileFloorInfoByFloorName(String floorName) throws Exception;
	
	/**
	 * 通过floorId查询楼层信息
	 * @throws Exception
	 */
	public IMobileFloorInfoValue getMobileFloorInfoByFloorId(String floorId) throws Exception;
	
	/**
	 * 通过floorRLTId查询楼层绑定规则信息
	 * @throws Exception
	 */
	public IMobileFloorRltValue getFloorRltInfoByFloorId(String floorRltId) throws Exception;
	
	/**
	 * 保存楼层信息
	 * @param floorId
	 * @param floorName
	 * @param retMapRltInfo
	 * @throws Exception
	 */
	public void saveMobileFloorInfo(String floorId, String floorName, Map<String, String> retMapRltInfo, long staffId, String comType, long orgId) throws Exception;
	
	/**
	 * 保存楼层信息
	 * @throws Exception
	 */
	public void saveMobileFloorInfo(IMobileFloorInfoValue floorInfoValue) throws Exception;
	
	
	/**
	 * 根据楼层名称查询楼层信息数量
	 * 如果为空查询所有未被删除的楼层信息数量
	 * @throws Exception
	 */
	public int getMobileFloorInfoCount(String floorName) throws Exception;
	
	
	/**
	 * 通过楼层id获得绑定的楼层关系信息
	 * @param floorId
	 * @return
	 * @throws Exception
	 */
	public IMobileFloorRltValue[] getFloorRltByFloorId(String floorId) throws Exception; 
	
	
	/**
	 * 批量保存楼层关系信息
	 * @param floorRltValues
	 * @throws Exception
	 */
	public void saveBatchMobileFloorRlt(IMobileFloorRltValue[] floorRltValues) throws Exception;
	
	
	/**
	 * 删除楼层信息
	 * @param floorId
	 * @throws Exception
	 */
	public void deleteFloorInfo(String floorId, long staffId, String comType, long orgId)throws Exception; 
	
	
	/**
	 * 停启用首页展示楼层信息操作
	 * @param floorId
	 * @throws Exception
	 */
	public void showFloorInfo(String floorId)throws Exception; 
	
	
	/**
	 * 获取触屏版首页展示的所有楼层完整信息
	 * @param showChannel 支持展示渠道
	 * @return
	 * @throws Exception
	 */
	public List<RecommendFloorInfo> getMobileFloorInfos(String showChannel)throws Exception;
	
	
	/**
	 * 获取首页展示的所有楼层基本信息
	 * @param showChannel 支持展示渠道
	 * @return
	 * @throws Exception
	 */
	public IMobileFloorInfoValue[] getFloorInfoByShowChannel(String showChannel)throws Exception;
	
	
	/**
	 * 预览首页展示需要展示的楼层信息
	 * @param floorId 预览附加的楼层
	 * @return
	 * @throws Exception
	 */
	public IMobileFloorInfoValue[] getPreviewFloorInfo(String floorId)throws Exception;
	
	/**
	 * 预览触屏版首页展示的所有楼层信息
	 * @param floorId 预览附加的楼层
	 * @return
	 * @throws Exception
	 */
	public List<RecommendFloorInfo> getPreviewMobileFloorInfos(String floorId)throws Exception;

}
