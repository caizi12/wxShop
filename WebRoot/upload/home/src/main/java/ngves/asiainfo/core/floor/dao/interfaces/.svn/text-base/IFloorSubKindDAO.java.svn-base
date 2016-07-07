package ngves.asiainfo.core.floor.dao.interfaces;

import ngves.asiainfo.core.floor.ivalues.IFloorInfoValue;
import ngves.asiainfo.core.floor.ivalues.IFloorSubKindValue;

public interface IFloorSubKindDAO {
	/**
	 * 保存楼层子类目
	 * @param floorInfo
	 * @return
	 * @throws Exception
	 */
	public void saveFloorSubKind(IFloorSubKindValue floorSubKindValue) throws Exception;
    
	/**
	 * 删除楼层子类目
	 * @param floorSubKindValue
	 * @throws Exception
	 */
	public void delFloorSubKind(IFloorSubKindValue floorSubKindValue) throws Exception;
	
	/**
	 * 批量保存子类目
	 * @param floorTabsRltValues
	 * @throws Exception
	 */
	public void saveBatchFloorSubKinds(IFloorSubKindValue[] floorSubKindValues) throws Exception;
	/**
	 * 根据id查询楼层子目录
	 * @param floorId
	 * @return
	 * @throws Exception
	 */
	public IFloorSubKindValue queryFloorSubKindById(long floorSubId) throws Exception;
	
	 /** 
	 * 根据楼层id查询楼层子目录
	 */
	public IFloorSubKindValue[] queryFloorSubKindByFloorId(long floorInfoId) throws Exception;
	
	 /** 
	 * 根据子类目id串查询子类目
	 */
	public IFloorSubKindValue[] queryFloorSubKindByIds(String floorSubIds) throws Exception;
	 /** 
	 * 根据前台展示的楼层查询所有楼层下的子类目
	 */
	public IFloorSubKindValue[] queryFloorSubKindByFloorIds(IFloorInfoValue[] floorInfoValues) throws Exception;

	/***
	 * 获取新标识
	 * @return
	 * @throws Exception
	 */
	public long getNewId() throws Exception;

}
