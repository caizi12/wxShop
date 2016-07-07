package ngves.asiainfo.core.floor.dao.interfaces;

import java.sql.Timestamp;

import ngves.asiainfo.core.floor.ivalues.IFloorInfoValue;
import ngves.asiainfo.core.floor.ivalues.IFloorTabsRltValue;

/**
 * 维护楼层绑定推荐页签信息
 * @author lzq
 *
 */
public interface IFloorTabsRltDAO {
	/**
	 * 保存楼层绑定推荐(默认页签设置)
	 * @param floorTabsRltValue
	 * @return
	 * @throws Exception
	 */
	public long saveFloorTabsRlt(IFloorTabsRltValue floorTabsRltValue) throws Exception;
	/**
	 * 批量删除楼层推荐绑定
	 * @param floorTabsRltValues
	 * @throws Exception
	 */
	public void saveBatchFloorTabsRlts(IFloorTabsRltValue[] floorTabsRltValues) throws Exception;
	/**
	* 删除页签绑定关系 
	* @param floorInfoValue
	* @throws Exception
	*/
	public void delFloorTabsRlt(IFloorTabsRltValue floorTabsRltValue) throws Exception;
	/**
	 * 根据id查询页签绑定关系
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
	 * 查询同一个楼层内 开始结束时间有无冲突
	 * @param starDate开始时间 endDate 结束时间
	 * @return 时间有无冲突（有无交集）， 有交集返回true 无交集返回true
	 * @throws Exception
	 */
	public boolean  isTimeConflict(Timestamp starDate,Timestamp endDate,String floorInfoId) throws Exception;

	   /***
     * 前台门户楼层默认页签展示
     * 根据楼层id查询当前时间展示的默认页签
     */
	
	public IFloorTabsRltValue[] queryFloorTabsByFloorIdForFront(long floorInfoId) throws Exception ;
	   /***
     * 前台门户所有楼层的默认页签
     * 根据展示的所有楼层查询当前时间展示的默认页签
     */
	
	public IFloorTabsRltValue[] queryFloorTabsByFloorIdsForFront(IFloorInfoValue[] floorInfoValues) throws Exception;
}
