package ngves.asiainfo.core.floor.dao.impl;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import ngves.asiainfo.core.floor.bo.TabsInfoEngine;
import ngves.asiainfo.core.floor.dao.interfaces.ITabsInfoDAO;
import ngves.asiainfo.core.floor.ivalues.ITabsInfoValue;

public class TabsInfoDAOImpl implements ITabsInfoDAO {

	/**
	 * 保存楼层页签基本能信息
	 */
	public void saveTabsInfo(ITabsInfoValue tabsInfoValue) throws Exception {

		TabsInfoEngine.save(tabsInfoValue);

	}

	/**
	 * 批量保存
	 */
	public void saveTabsInfos(ITabsInfoValue[] tabsInfoValues) throws Exception {
		TabsInfoEngine.save(tabsInfoValues);
	}

	/**
	 * 根据id查页签基本能信息
	 */
	public ITabsInfoValue queryTabsInfoById(long tabsInfoId) throws Exception {
		return TabsInfoEngine.getBean(tabsInfoId);
	}
	/**
	 * 根据id查页签基本能信息
	 */
	public ITabsInfoValue[] queryTabsById(long tabsInfoId) throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		HashMap<String, String> parameter = new HashMap<String, String>();
			condition.append(" and " + ITabsInfoValue.S_TabsId + " = :tabsInfoId");
			parameter.put("tabsInfoId",tabsInfoId+"" );
		return TabsInfoEngine.getBeans(condition.toString(), parameter);

	}

	/**
	* 根据推荐名称模糊查询楼层默认推荐（页签表）
	*/
	public ITabsInfoValue[] queryTabsByName(String tabsName, int satarNum, int endNum) throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		HashMap<String, String> parameter = new HashMap<String, String>();
		if (StringUtils.isNotBlank(tabsName)) {
			condition.append(" and " + ITabsInfoValue.S_TabsName + " like :tabsName");
			parameter.put("tabsName", "%" + tabsName + "%");
		}
		return TabsInfoEngine.getBeans(null, condition.toString(), parameter, satarNum, endNum, false);

	}

	/**
	* 根据推荐名称模糊查询楼层默认推荐总数（页签表）
	*/
	public int queryTabsByNameCount(String tabsName) throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		HashMap<String, String> parameter = new HashMap<String, String>();
		if (StringUtils.isNotBlank(tabsName)) {
			condition.append(" and " + ITabsInfoValue.S_TabsName + " like :tabsName");
			parameter.put("tabsName", "%" + tabsName + "%");
		}
		return TabsInfoEngine.getBeansCount(condition.toString(), parameter);
	}
	/***
	 * 获取新标识
	 * @return
	 * @throws Exception
	 */
	public long getNewId() throws Exception{
		return TabsInfoEngine.getNewId().longValue();
	}

}
