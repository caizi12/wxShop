package cn.frame.platform.sys.menu.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.frame.platform.entitys.SysMenu;

public interface SysMenuSrv {
	
	public List<SysMenu> queryMenuList(Map<String,String> map) ;
	
	public long insertSysMenu(SysMenu record) throws Exception;

	public int updateSysMenu(SysMenu record) throws Exception;

	public int updateByPrimaryKeySelective(SysMenu record) throws SQLException;

	public SysMenu selectSysMenuById(String menuId) throws SQLException;

	public int deleteSysMenuById(String menuId) throws SQLException;


}