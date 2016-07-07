package ngves.asiainfo.core.floor.dao.impl;

import java.sql.Timestamp;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import ngves.asiainfo.core.floor.FloorConstant;
import ngves.asiainfo.core.floor.bo.FloorInfoEngine;
import ngves.asiainfo.core.floor.bo.TabsInfoEngine;
import ngves.asiainfo.core.floor.dao.interfaces.IFloorInfoDAO;
import ngves.asiainfo.core.floor.ivalues.IFloorInfoValue;
import ngves.asiainfo.core.floor.ivalues.ITabsInfoValue;

public class FloorInfoDAOImpl implements IFloorInfoDAO {
	/**
	 * 保存楼层信息
	 */
	public long saveFloorInfo(IFloorInfoValue floorInfoValue) throws Exception {
		long floorId = 0L;
		if (floorInfoValue.isNew()) {
			floorId = FloorInfoEngine.getNewId().longValue();
			floorInfoValue.setFloorId(floorId);
			//新建的楼层默认首页不显示
			floorInfoValue.setIsHomeShow(FloorConstant.FLOOR_IS_NOT_HOME_SHOW);
			floorInfoValue.setCreateDate(new Timestamp(System.currentTimeMillis()));
		}else{
			floorInfoValue.setModifyDate(new Timestamp(System.currentTimeMillis()));
		}
		floorId = floorInfoValue.getFloorId();
		
		FloorInfoEngine.save(floorInfoValue);
		return floorId;
	}
	
	/**
	 * 删除楼层信息
	 */
	public void delFloorInfo(IFloorInfoValue floorInfoValue) throws Exception {
		FloorInfoEngine.save(floorInfoValue);
	}
     
	/***
	 * 根据楼层id查询楼层信息
	 */
	public IFloorInfoValue queryFloorInfoById(long floorId) throws Exception {
		return FloorInfoEngine.getBean(floorId);
	}
	
	/**
	 * 根据名称查询实例
	 */
	public IFloorInfoValue[] queryFloorsByName(String floorName) throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		HashMap<String, String> parameter = new HashMap<String, String>();
		if (StringUtils.isNotBlank(floorName)) {
			condition.append(" and " + IFloorInfoValue.S_FloorName +" like :floorName");
			parameter.put("floorName", "%"+floorName+"%");
		}
		condition.append(" ORDER BY to_number(FLOOR_SORT) asc");
		return FloorInfoEngine.getBeans(condition.toString(), parameter);
	}
    
	/**
	 * 根据楼层名称查询楼层信息
	 */
	public IFloorInfoValue[] queryFloorsByName(String floorName, int satarNum, int endNum) throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		HashMap<String, String> parameter = new HashMap<String, String>();
		if (StringUtils.isNotBlank(floorName)) {
			condition.append(" and " + IFloorInfoValue.S_FloorName +" like :floorName");
			parameter.put("floorName", "%"+floorName+"%");
		}
		condition.append(" ORDER BY to_number(FLOOR_SORT) asc");
		return FloorInfoEngine.getBeans(null, condition.toString(), parameter, satarNum, endNum, false);
		
	}
    /**
     * 根据楼层名称查询楼层结果总数
     */
	public int queryFloorsByNameCount(String floorName) throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		HashMap<String, String> parameter = new HashMap<String, String>();
		if (StringUtils.isNotBlank(floorName)) {
			condition.append(" and " + IFloorInfoValue.S_FloorName +" like :floorName");
			parameter.put("floorName", "%"+floorName+"%");
		}
		condition.append(" ORDER BY to_number(FLOOR_SORT) asc");
		return FloorInfoEngine.getBeansCount(condition.toString(), parameter);
	}
		
	/**
	 * 查询楼层关联内容（即页签表）
	 * @return
	 * @throws Exception 
	 */
	  public ITabsInfoValue[] queryTabsInfo() throws Exception {
	        String sql = "select TABS_ID , TABS_NAME from TABS_INFO";
	        return TabsInfoEngine.getBeansFromSql(sql, null);
	    }
    /****************************前台开始******************************************************************/
	  /***
	   * 前台楼层展示
	   */
		public IFloorInfoValue[] queryFloorInfosForFront() throws Exception {
		//String slq="select * from FLOOR_INFO f where f.IS_HOME_SHOW="+FloorConstant.FLOOR_IS_HOME_SHOW;
			String slq=" 1=1 and IS_HOME_SHOW="+FloorConstant.FLOOR_IS_HOME_SHOW+" ORDER BY to_number(FLOOR_SORT) asc";
			return FloorInfoEngine.getBeans(slq,null);
			
		} 
	/****************************前台结束*****************************************************************/
}
