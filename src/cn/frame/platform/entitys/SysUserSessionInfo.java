package cn.frame.platform.entitys;
 

import java.util.List;


/**
 * 用户session信息
 * 
 * 用来存放当前登录用户的信息  
 * 
 * 
 */

public class SysUserSessionInfo  {

	/**
	 * 用户信息
	 */
	private SysUser sysUser;
   
	/**
	 * 用户菜单信息
	 */
    private List<SysMenu> userMenus;
   
	private SysUserSessionInfo() {}
    
	public static SysUserSessionInfo getInstance(){
		return new SysUserSessionInfo();
	}
	

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public List<SysMenu> getUserMenus() {
		return userMenus;
	}

	public void setUserMenus(List<SysMenu> userMenus) {
		this.userMenus = userMenus;
	}
   


}