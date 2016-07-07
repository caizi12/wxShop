package ngves.asiainfo.core.floor.dao.interfaces;

import ngves.asiainfo.core.floor.ivalues.IFloorInfoValue;
import ngves.asiainfo.core.floor.ivalues.ITabsInfoValue;

/***
 * 楼层对象操作接口
 * @author lizq
 *
 */
public interface IFloorInfoDAO {

	/**
	 * 保存楼层
	 * @param floorInfo
	 * @return
	 * @throws Exception
	 */
	public long saveFloorInfo(IFloorInfoValue floorInfoValue) throws Exception;
    
	/**
	 * 删除楼层
	 * @param floorInfoValue
	 * @throws Exception
	 */
	public void delFloorInfo(IFloorInfoValue floorInfoValue) throws Exception;
	
	
	/**
	 * 根据楼层id查询楼层实例
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
	public IFloorInfoValue[] queryFloorsByName(String floorName) throws Exception;

	
	/**
	 * 根据名称查询楼层（分页）
	 * @param floorName
	 * @param satarNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public IFloorInfoValue[] queryFloorsByName(String floorName, int satarNum, int endNum) throws Exception;

	/**
	 * 根据名称查询结果总数
	 * @param floorName
	 * @return
	 * @throws Exception
	 */
	public int queryFloorsByNameCount(String floorName) throws Exception;
	/**
	 * 查询楼层关联内容（即页签表）
	 * @return
	 * @throws Exception 
	 */
	  public ITabsInfoValue[] queryTabsInfo() throws Exception;
	  /***
	   * 前台楼层展示
	   */
	 public IFloorInfoValue[] queryFloorInfosForFront() throws Exception;
}
