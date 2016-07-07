package ngves.asiainfo.core.floor.dao.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import ngves.asiainfo.core.floor.bo.FloorTabsRltEngine;
import ngves.asiainfo.core.floor.dao.interfaces.IFloorTabsRltDAO;
import ngves.asiainfo.core.floor.ivalues.IFloorInfoValue;
import ngves.asiainfo.core.floor.ivalues.IFloorTabsRltValue;
import ngves.asiainfo.util.DateTimeUtil;

/**
 * 维护楼层绑定推荐页签信息
 * @author lzq
 *
 */
public class FloorTabsRltDAOImpl implements IFloorTabsRltDAO {

	/**
	 * 保存楼层推荐绑定
	 */
	public long saveFloorTabsRlt(IFloorTabsRltValue floorTabsRltValue) throws Exception {
		long floorTabsRltId = 0L;
		if (floorTabsRltValue.getFloorTabsRltId() != 0) {
			floorTabsRltValue.setStsToOld();
		}
		if (floorTabsRltValue.isNew()) {
			floorTabsRltId = FloorTabsRltEngine.getNewId().longValue();
			floorTabsRltValue.setFloorTabsRltId(floorTabsRltId);
			floorTabsRltValue.setCreateDate(new Timestamp(System.currentTimeMillis()));
		}
		floorTabsRltId = floorTabsRltValue.getFloorTabsRltId();
		floorTabsRltValue.setModifyDate(new Timestamp(System.currentTimeMillis()));
		floorTabsRltValue.setBeginTime(floorTabsRltValue.getBeginTime());
		floorTabsRltValue.setEndTime(floorTabsRltValue.getEndTime());
		floorTabsRltValue.setFloorTabsName(floorTabsRltValue.getFloorTabsName());
		floorTabsRltValue.setTabsId(floorTabsRltValue.getTabsId());
		FloorTabsRltEngine.save(floorTabsRltValue);
		return floorTabsRltId;
	}

	/**
	* 删除页签绑定关系 
	* @param floorTabsRltValue
	* @throws Exception
	*/
	public void delFloorTabsRlt(IFloorTabsRltValue floorTabsRltValue) throws Exception {
		FloorTabsRltEngine.save(floorTabsRltValue);
	}

	/**
	 * 批量删除楼层推荐绑定
	 * @param floorTabsRltValues
	 * @throws Exception
	 */
	public void saveBatchFloorTabsRlts(IFloorTabsRltValue[] floorTabsRltValues) throws Exception {
		FloorTabsRltEngine.saveBatch(floorTabsRltValues);
	}

	/**
	 * 根据id查询绑定页签绑定关系
	 * @param floorTabsId
	 * @return
	 * @throws Exception
	 */
	public IFloorTabsRltValue queryFloorTabsRltById(long floorTabsId) throws Exception {
		return FloorTabsRltEngine.getBean(floorTabsId);
	}

	/** 
	* 根据楼层id查询楼层绑定推荐
	*/
	public IFloorTabsRltValue[] queryFloorTabsByFloorId(long floorInfoId) throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		HashMap<String, String> parameter = new HashMap<String, String>();
		if (!"".equals(floorInfoId) && !"-1".equals(floorInfoId)) {
			condition.append(" and " + IFloorTabsRltValue.S_FloorId + "=:floorId");
			parameter.put("floorId", Long.toString(floorInfoId));
		}
		return FloorTabsRltEngine.getBeans(condition.toString(), parameter);
	}

	/**
	 * 查询同一个楼层内 开始结束时间有无冲突
	 * @param starDate开始时间 endDate 结束时间
	 * @return 时间有无冲突（有无交集）， 有交集返回true 无交集返回false
	 * @throws Exception
	 */
	public boolean isTimeConflict(Timestamp starDate, Timestamp endDate,String floorInfoId) throws Exception {
		String star=DateTimeUtil.timeStampToString(starDate, "yyyy-MM-dd HH:mm:ss");
		String end=DateTimeUtil.timeStampToString(endDate, "yyyy-MM-dd HH:mm:ss"); 
	 String sql = "select FLOOR_TABS_RLT_ID  from FLOOR_TABS_RLT f where f.FLOOR_ID='"+floorInfoId+"' and ((f.BEGIN_TIME>=to_date('"+star+"','yyyy-MM-dd HH24:mi:ss') and f.BEGIN_TIME<=to_date('"+end+"','yyyy-MM-dd HH24:mi:ss')) or (f.BEGIN_TIME<=to_date('"+star+"','yyyy-MM-dd HH24:mi:ss') and f.END_TIME>=to_date('"+end+"','yyyy-MM-dd HH24:mi:ss')) or (f.END_TIME>=to_date('"+star+"','yyyy-MM-dd HH24:mi:ss') and f.END_TIME<=to_date('"+end+"','yyyy-MM-dd HH24:mi:ss')))";                  
	 IFloorTabsRltValue[] values= FloorTabsRltEngine.getBeansFromSql(sql, null);
			if(values.length>0){
				return true;
			}else{
				return false ;
			}
		
	}
      /***
       * 前台门户楼层默认页签展示
       * 根据楼层id查询当前时间展示的默认页签
       */
	
	public IFloorTabsRltValue[] queryFloorTabsByFloorIdForFront(long floorInfoId) throws Exception {
		Timestamp currentTime= new Timestamp(System.currentTimeMillis());
		String currentDate=DateTimeUtil.timeStampToString(currentTime, "yyyy-MM-dd HH:mm:ss");
		String sql=" 1=1 and FLOOR_ID='"+floorInfoId+"'  and BEGIN_TIME<to_date('"+currentDate+"','yyyy-MM-dd HH24:mi:ss') and END_TIME>to_date('"+currentDate+"','yyyy-MM-dd HH24:mi:ss')";
		return FloorTabsRltEngine.getBeans(sql, null);
	}
	   /***
     * 前台门户所有楼层的默认页签
     * 根据展示的所有楼层查询当前时间展示的默认页签
     */
	
	public IFloorTabsRltValue[] queryFloorTabsByFloorIdsForFront(IFloorInfoValue[] floorInfoValues) throws Exception {
		StringBuffer condition = new StringBuffer(" ");
		Timestamp currentTime= new Timestamp(System.currentTimeMillis());
		String currentDate=DateTimeUtil.timeStampToString(currentTime, "yyyy-MM-dd HH:mm:ss");
		condition.append(" 1=1  and BEGIN_TIME<to_date('"+currentDate+"','yyyy-MM-dd HH24:mi:ss') and END_TIME>to_date('"+currentDate+"','yyyy-MM-dd HH24:mi:ss') and (FLOOR_ID=");
		for(IFloorInfoValue floorInfoValue:floorInfoValues){
			condition.append(" '"+floorInfoValue.getFloorId()+"' or i.FLOOR_ID=");
			}
		return FloorTabsRltEngine.getBeans(condition.substring(0, condition.lastIndexOf("or"))+")", null);
	}
}
