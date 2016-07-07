package cn.frame.platform.sys.menu.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.frame.platform.common.base.BaseDaoTemplate;
import cn.frame.platform.entitys.SysMenu;
import cn.frame.platform.sys.menu.dao.SysMenuDao;


@Repository("sysMenuDao")
public class SysMenuDaoImpl implements SysMenuDao {
	
	@Autowired
	public BaseDaoTemplate baseDao;
 
	@SuppressWarnings("unchecked")
	public List<SysMenu> queryMenuList(Map<String,String> map) {
		List<SysMenu> list=  baseDao.getIbatisTemplate().queryForList("queryMenuList", map);
		return list;
	}
	
	public long insertSysMenu(SysMenu sysMenu) throws Exception {
		sysMenu.setCreateDate(new Date());
		sysMenu.setMenuId(baseDao.getColumnMaxValueForInt("sys_menu", "menu_id")+1);
		baseDao.getIbatisTemplate().insert("insertSysMenu", sysMenu);
		return sysMenu.getMenuId();
	}

	public int updateSysMenu(SysMenu sysMenu) throws SQLException {
		sysMenu.setUpdateDate(new Date());
		int rows = baseDao.getIbatisTemplate().update("updateSysMenu", sysMenu);
		return rows;
	}

	public int updateByPrimaryKeySelective(SysMenu record) throws SQLException {
		int rows = baseDao.getIbatisTemplate().update("sys_menu.updateByPrimaryKeySelective", record);
		return rows;
	}

	public SysMenu selectSysMenuById(String menuId) throws SQLException {
		SysMenu SysMenu = (SysMenu) baseDao.getIbatisTemplate().queryForObject("selectSysMenuById", menuId);
		return SysMenu;
	}

	public int deleteSysMenuById(String menuId) throws SQLException {
		int rows = baseDao.getIbatisTemplate().delete("deleteSysMenuById", menuId);
		return rows;
	}

}