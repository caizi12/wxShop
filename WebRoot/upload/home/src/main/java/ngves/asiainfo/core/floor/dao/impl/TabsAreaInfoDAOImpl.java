package ngves.asiainfo.core.floor.dao.impl;
import java.util.HashMap;

import ngves.asiainfo.core.floor.bo.FloorSubKindEngine;
import ngves.asiainfo.core.floor.bo.TabsAreaInfoEngine;
import ngves.asiainfo.core.floor.dao.interfaces.ITabsAreaInfoDAO;
import ngves.asiainfo.core.floor.ivalues.IFloorSubKindValue;
import ngves.asiainfo.core.floor.ivalues.ITabsAreaInfoValue;
/**
 * 楼层页签区域信息维护接口实现
 * @author lzq
 *
 */
public class TabsAreaInfoDAOImpl implements ITabsAreaInfoDAO{

	/**
	 * 保存楼层页签区域信息
	 */
	public void saveTabsAreaInfo(ITabsAreaInfoValue tabsAreaInfoValue) throws Exception {
		TabsAreaInfoEngine.save(tabsAreaInfoValue);
		
	}
	/**
	 * 保存页签区域
	 */
	public void savTabsAreaInfos(ITabsAreaInfoValue[] tabsAreaInfoValues) throws Exception {
		TabsAreaInfoEngine.save(tabsAreaInfoValues);
		
	}

	/***
	 * 根据id查询楼层页签区域信息
	 */
	public ITabsAreaInfoValue queryTabsAreaInfoById(long tabsAreaId) throws Exception {
		return TabsAreaInfoEngine.getBean(tabsAreaId);
		
	}
	 /** 
	 * 根据页签区域id串查询页签区域信息
	 */
	public ITabsAreaInfoValue[] queryTabsAreaInfoByIds(String tabsAreaIds) throws Exception{
	String sql="select i.TABS_AREA_ID from TABS_AREA_INFO i where i.TABS_AREA_ID in("+tabsAreaIds+")";
	return TabsAreaInfoEngine.getBeansFromSql(sql, null);
	}

	 /** 
	 * 根据页签id查询页签区域信息
	 */
	public ITabsAreaInfoValue[] queryTabsAreaInfoByTabsId(long tabsId) throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		HashMap<String, String> parameter = new HashMap<String, String>();
		if (!"".equals(tabsId) && !"-1".equals(tabsId)) {
			condition.append(" and " + ITabsAreaInfoValue.S_TabsId + "=:tabsId");
			parameter.put("tabsId", Long.toString(tabsId));
		}
		condition.append(" ORDER BY to_number(AREA_SORT) asc");
		return TabsAreaInfoEngine.getBeans(condition.toString(), parameter);
	}
	/***
	 * 获取新标识
	 * @return
	 * @throws Exception
	 */
	public long getNewId() throws Exception{
		return TabsAreaInfoEngine.getNewId().longValue();
	}

}
