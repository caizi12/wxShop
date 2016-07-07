package ngves.asiainfo.core.floor.dao.impl;

import java.util.HashMap;

import ngves.asiainfo.core.floor.bo.FloorSubKindEngine;
import ngves.asiainfo.core.floor.dao.interfaces.IFloorSubKindDAO;
import ngves.asiainfo.core.floor.ivalues.IFloorInfoValue;
import ngves.asiainfo.core.floor.ivalues.IFloorSubKindValue;
/**
 * 维护楼层子类目
 * @author lzq
 *
 */
public class FloorSubKindDAOImpl implements IFloorSubKindDAO{

	/**
	 * 保存楼层子类目
	 */
	public void saveFloorSubKind(IFloorSubKindValue floorSubKindValue) throws Exception {
		FloorSubKindEngine.save(floorSubKindValue);
		
	}
	
	/**
	 * 删除楼层子类目
	 */
	public void delFloorSubKind(IFloorSubKindValue floorSubKindValue) throws Exception {
		FloorSubKindEngine.save(floorSubKindValue);
	}
     
	/**
	 * 批量保存子类目
	 * @param floorTabsRltValues
	 * @throws Exception
	 */
	public void saveBatchFloorSubKinds(IFloorSubKindValue[] floorSubKindValues) throws Exception{
		FloorSubKindEngine.saveBatch(floorSubKindValues);
	}
	/***
	 * 根据id查询楼层子类目
	 */
	public IFloorSubKindValue queryFloorSubKindById(long floorSubId) throws Exception {
		return FloorSubKindEngine.getBean(floorSubId);
	}
	
	 /** 
	 * 根据楼层id查询楼层子类目
	 */
	public IFloorSubKindValue[] queryFloorSubKindByFloorId(long floorInfoId) throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		HashMap<String, String> parameter = new HashMap<String, String>();
		if (!"".equals(floorInfoId) && !"-1".equals(floorInfoId)) {
			condition.append(" and " + IFloorSubKindValue.S_FloorId + "=:floorId");
			parameter.put("floorId", Long.toString(floorInfoId));
		}
		return FloorSubKindEngine.getBeans(condition.toString(), parameter);
	}
	 /** 
	 * 根据子类目id串查询子类目
	 */
	public IFloorSubKindValue[] queryFloorSubKindByIds(String floorSubIds) throws Exception{
	String sql="select * from FLOOR_SUB_KIND i where i.FLOOR_SUB_ID in("+floorSubIds+")";
	return FloorSubKindEngine.getBeansFromSql(sql, null);
	}
	 /** 
	 * 根据前台展示的楼层查询所有楼层下的子类目
	 */
	public IFloorSubKindValue[] queryFloorSubKindByFloorIds(IFloorInfoValue[] floorInfoValues) throws Exception {
		StringBuffer condition = new StringBuffer(" ");
		if (null!=floorInfoValues&&0!=floorInfoValues.length) {
			condition.append("select * from FLOOR_SUB_KIND i where 1=1 and i.FLOOR_ID=");
			for(IFloorInfoValue floorInfoValue:floorInfoValues){
			condition.append(" '"+floorInfoValue.getFloorId()+"' or i.FLOOR_ID=");
			}
		}
		return FloorSubKindEngine.getBeansFromSql(condition.substring(0, condition.lastIndexOf("or")), null);
	}
	/***
	 * 获取新标识
	 * @return
	 * @throws Exception
	 */
	public long getNewId() throws Exception{ 
		return FloorSubKindEngine.getNewId().longValue();
	}
	
}
