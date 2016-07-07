package ngves.asiainfo.core.floor.service.interfaces;

import ngves.asiainfo.core.floor.dao.interfaces.IFloorInfoDAO;
import ngves.asiainfo.core.floor.dao.interfaces.IFloorSubKindDAO;
import ngves.asiainfo.core.floor.dao.interfaces.IFloorTabsRltDAO;
import ngves.asiainfo.core.floor.dao.interfaces.ITabsAreaInfoDAO;
import ngves.asiainfo.core.floor.dao.interfaces.ITabsInfoDAO;
import ngves.asiainfo.core.floor.domain.TabsInfoForFront;
import ngves.asiainfo.core.floor.ivalues.IFloorInfoValue;
import ngves.asiainfo.core.floor.ivalues.IFloorSubKindValue;
import ngves.asiainfo.core.floor.ivalues.IFloorTabsRltValue;
import ngves.asiainfo.core.floor.ivalues.ITabsAreaInfoValue;
import ngves.asiainfo.core.floor.ivalues.ITabsInfoValue;

/**
 * 楼层处理服务接口
 * @author lizq
 */
public interface IFloorInfoSrv {
	public void setFloorInfoDAO(IFloorInfoDAO floorInfoDAO) throws Exception;

	public void setFloorSubKindDAO(IFloorSubKindDAO floorSubKindDAO) throws Exception;

	public void setFloorTabsRltDAO(IFloorTabsRltDAO floorTabsRltDAO) throws Exception;

	public void setTabsAreaInfoDAO(ITabsAreaInfoDAO tabsAreaInfoDAO) throws Exception;

	public void setTabsInfoDAO(ITabsInfoDAO tabsInfoDAO) throws Exception;

	/***
	 * 新增楼层基本信息
	 */
	public long saveFloorInfo(IFloorInfoValue floorInfoValue,String subKindJSON,long staffId, String comType, long orgId) throws Exception ;

	/**
	* 删除楼层 
	* @param floorInfoValue
	* @throws Exception
	*/
	public void delFloorInfo(IFloorInfoValue floorInfoValue,long staffId, String comType, long orgId) throws Exception;

	/**
	 * 修改楼层(维护楼层广告)
	 * @param floorInfoValue
	 * @throws Exception
	 */
	public long modifyFloorInfo(IFloorInfoValue floorInfoValue,IFloorInfoValue oldValue,long staffId, String comType, long orgId) throws Exception;
	/**
	 * 修改楼层基本信息
	 */
	public long modifyFloorInfo(IFloorInfoValue floorInfoValue,String subKindJSON,String floorInfoId,String delSubKindIds,long staffId, String comType, long orgId) throws Exception;
	/***
	 * 处理楼层关联中类
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void saveFloorSubKind(String subKindJSON,String floorInfoId,String delSubKindIds,long staffId, String comType, long orgId) throws Exception;

	/**
	 * 根据id查询楼层
	 * @param floorId
	 * @return
	 * @throws Exception
	 */
	public IFloorInfoValue queryFloorInfoById(long floorId) throws Exception;

	/**
	* 根据名称查询楼层
	* @param floorName
	* @return
	* @throws Exception
	*/
	public IFloorInfoValue[] queryFloorInfosByName(String floorName) throws Exception;

	/**
	 * 根据名称查询楼层（分页）
	 * @param floorName
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public IFloorInfoValue[] queryFloorInfosByName(String floorName, int startNum, int endNum) throws Exception;

	/**
	* 根据名称查询楼层结果总数
	* @param floorName
	* @return
	* @throws Exception
	*/
	public int queryFloorInfoByNameCount(String floorName) throws Exception;

	/**
	 * 修改楼层是否在首页展示（当前显示的点击置为不显示，反之亦然）
	 * @param floorId
	 * @throws Exception
	 */
	public void modifyIsHomeShow(String floorId,long staffId, String comType, long orgId) throws Exception;

	/**
	 * 保存楼层绑定推荐（默认页签设置）
	 * @param floorTabsRltValue
	 * @return
	 * @throws Exception
	 */
	public long saveFloorTabsRlt(IFloorTabsRltValue floorTabsRltValue,long staffId, String comType, long orgId) throws Exception;

	/**
	* 删除页签绑定关系 
	* @param floorInfoValue
	* @throws Exception
	*/
	public void delFloorTabsRlt(IFloorTabsRltValue floorTabsRltValue,long staffId, String comType, long orgId) throws Exception;

	/**
	 * 根据id查询绑定页签绑定关系
	 * @param floorTabsId
	 * @return
	 * @throws Exception
	 */
	public IFloorTabsRltValue queryFloorTabsRltById(long floorTabsId) throws Exception;

	/**
	 * 根据楼层id查询楼层绑定推荐
	 * @param floorId
	 * @return
	 * @throws Exception
	 */
	public IFloorTabsRltValue[] queryFloorTabsByFloorId(long floorId) throws Exception;

	/**
	 * 查询楼层关联内容（即页签表）
	 * @return
	 * @throws Exception 
	 */
	public ITabsInfoValue[] queryTabsInfo() throws Exception;

	/**
	 * 保存楼层子类目
	 * @param floorSubKindValue
	 * @return
	 * @throws Exception
	 */
	//public long saveFloorSubKind(IFloorSubKindValue floorSubKindValue) throws Exception;

	/***
	 * 批量保存子类目
	 * @param floorSubKindValue
	 * @throws Exception
	 */
	public void saveBatchFloorSubKinds(IFloorSubKindValue[] floorSubKindValue) throws Exception;

	/***
	 * 根据id批量删除子类目
	 * @param ids 标识
	 * @throws Exception
	 */
	public void delFloorSubKinds(String floorSubIds,long staffId, String comType, long orgId) throws Exception;

	/**
	* 根据标识查询楼层绑定子类目
	*/
	public IFloorSubKindValue queryFloorSubKindById(long floorSubId) throws Exception;

	/**
	* 根据楼层Id查询楼层绑定子类目
	*/
	public IFloorSubKindValue[] queryFloorSubKindByFloorId(long floorInfoId) throws Exception;

	 /** 
	 * 根据前台展示的楼层查询所有楼层下的子类目
	 */
	public IFloorSubKindValue[] queryFloorSubKindByFloorIds(IFloorInfoValue[] floorInfoValues) throws Exception;
	/***
	 * 获取新标识
	 * @return 楼层子类目id
	 * @throws Exception
	 */
	public long getSubKindNewId() throws Exception;
	/***
	 * 保存页签
	 * @param tabsInfoValue
	 * @return
	 * @throws Exception
	 */
	public long saveTabsInfo(String tabsInfo,String tabsAreaJson,String delTabsAreaIds,long staffId, String comType, long orgId)throws Exception;
	/***
	 * 删除页签
	 * @param tabsInfoValue
	 * @return
	 * @throws Exception
	 */
	public void delTabsInfo(ITabsInfoValue tabsInfoValue,long staffId, String comType, long orgId)throws Exception; 
	/***
	 * 根据标识查询楼层默认推荐（页签表）
	 * @param tabsInfoId
	 * @return
	 * @throws Exception
	 */
	public ITabsInfoValue queryTabsInfoByTabsId(long tabsInfoId)throws Exception;
	/**
	 * 根据id查页签基本能信息
	 */
	public ITabsInfoValue[] queryTabsById(long tabsInfoId) throws Exception;
	/**
	 * 根据推荐名称模糊查询楼层默认推荐（页签表）
	 */
	public ITabsInfoValue[] queryTabsInfoByName(String tabsName, int satarNum, int endNum) throws Exception;

	/**
	* 根据推荐名称模糊查询楼层默认推荐总数（页签表）
	*/
	public int queryTabsInfoByNameCount(String tabsName) throws Exception;
	/***
	 * 获取新标识
	 * @return 页签表
	 * @throws Exception
	 */
	public long getTabsInfoNewId() throws Exception;
	
	/***
	 * 保存页签区域信息
	 * @param tabsInfoValue
	 * @return
	 * @throws Exception
	 */
	public long saveTabsAreaInfo(ITabsAreaInfoValue tabsAreaInfoValue)throws Exception;
	/***
	 * 批量保存页签区域信息
	 * @param tabsInfoValue
	 * @return
	 * @throws Exception
	 */
	public void saveTabsAreaInfos(ITabsAreaInfoValue[] tabsAreaInfoValue)throws Exception;
	/***
	 * 批量删除页签区域信息
	 * @param tabsInfoValue
	 * @return
	 * @throws Exception
	 */
	public void delTabsAreaInfos(ITabsAreaInfoValue[] tabsAreaInfoValues,long staffId, String comType, long orgId)throws Exception; 
	/**
	 * 根据id查询页签区域信息
	 * @param tabsId
	 * @return
	 * @throws Exception
	 */
	public ITabsAreaInfoValue queryTabsAreaInfoById(long tabsAreaId) throws Exception;
	/***
	 * 根据id批量页签区域
	 * @param ids 标识
	 * @throws Exception
	 */
	public void delTabsAreaInfosByIds(String tabsAreaIds,long staffId, String comType, long orgId) throws Exception;
	/**
	 * 根据页签id查询页签区域信息
	 * @param tabsId
	 * @return
	 * @throws Exception
	 */
	public ITabsAreaInfoValue[] queryTabsAreaInfoByTabsId(long tabsId) throws Exception;
	/***
	 * 获取新标识
	 * @return 页签区域表
	 * @throws Exception
	 */
	public long getTabsAreaInfoNewId() throws Exception;
	
/**********************************门户改版开始******************************************************/
	/***
	 * 前台楼层展示
	 */
	public IFloorInfoValue[] queryFloorInfosForFront() throws Exception;
	/***
	 * 前台楼层默认页签展示（当前时间展示的默认页签）
	 */
	public TabsInfoForFront queryFloorTabsForFront(long floorInfoId) throws Exception;

/**********************************门户改版结束******************************************************/
}
