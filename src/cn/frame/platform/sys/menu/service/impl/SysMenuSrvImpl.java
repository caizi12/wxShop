package cn.frame.platform.sys.menu.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.frame.com.dao.DubboTestDao;
import cn.frame.platform.entitys.SysMenu;
import cn.frame.platform.sys.menu.dao.SysMenuDao;
import cn.frame.platform.sys.menu.service.SysMenuSrv;


@Service("sysMenuSrv")
public class SysMenuSrvImpl implements SysMenuSrv {
	
	@Autowired
	public SysMenuDao sysMenuDao;
	
	@Autowired
	public DubboTestDao dubboTestDao;
 
	public List<SysMenu> queryMenuList(Map<String,String> map) {
		return sysMenuDao.queryMenuList(map);
	}
  
	public long insertSysMenu(SysMenu sysMenu) throws Exception {
		return sysMenuDao.insertSysMenu(sysMenu);
	}

	public int updateSysMenu(SysMenu record) throws Exception {
		int rows = sysMenuDao.updateSysMenu(record);
		return rows;
	}

	public int updateByPrimaryKeySelective(SysMenu record) throws SQLException {
		int rows = sysMenuDao.updateByPrimaryKeySelective(record);
		return rows;
	}

	public SysMenu selectSysMenuById(String menuId) throws SQLException {
		SysMenu record = (SysMenu) sysMenuDao.selectSysMenuById(menuId);
		return record;
	}

	public int deleteSysMenuById(String menuId) throws SQLException {
		int rows = sysMenuDao.deleteSysMenuById(menuId);
		return rows;
	}

}