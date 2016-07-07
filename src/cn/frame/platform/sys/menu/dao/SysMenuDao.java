package cn.frame.platform.sys.menu.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.frame.platform.entitys.SysMenu;

public interface SysMenuDao {
	
	public List<SysMenu> queryMenuList(Map<String,String> map) ;
	
	public long insertSysMenu(SysMenu sysMenu) throws Exception;

	public int updateSysMenu(SysMenu sysMenu) throws SQLException;

	public int updateByPrimaryKeySelective(SysMenu sysMenu) throws SQLException;

	public SysMenu selectSysMenuById(String menuId) throws SQLException;

	public int deleteSysMenuById(String menuId) throws SQLException;


}