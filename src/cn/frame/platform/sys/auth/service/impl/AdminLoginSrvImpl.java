package cn.frame.platform.sys.auth.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.frame.platform.common.base.BaseDaoTemplate;
import cn.frame.platform.entitys.SysUser;
import cn.frame.platform.sys.auth.service.AdminLoginSrv;

@Service("adminLoginSrv")
public class AdminLoginSrvImpl  implements AdminLoginSrv{
	
	@Autowired
	public BaseDaoTemplate baseDao;
	
	public SysUser adminLogin(SysUser sysUser) {
		
		return this.getSysUser(sysUser);
	}
	
	/**
	 * 查询用户信息
	 * @param sysUser
	 * @return
	 */
	public SysUser getSysUser(SysUser sysUser){
		sysUser=(SysUser) baseDao.getIbatisTemplate().queryForObject("getSysUser",sysUser);
		return sysUser;
	}

}
