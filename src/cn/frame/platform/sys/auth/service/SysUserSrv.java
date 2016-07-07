package cn.frame.platform.sys.auth.service;

import java.util.List;
import java.util.Map;

import cn.frame.platform.common.base.DataGridModel;
import cn.frame.platform.entitys.SysUser;

 /**
  * 系统用户管理
  * @date 2012-08-23 20:59:00
  * @author llliang
  *
  */
public interface SysUserSrv {
	public SysUser getSysUser(SysUser sysUser);
	public int queryCountSysUser(Map<String, Object> userMap);
	public DataGridModel querySysUserData(DataGridModel dataGrid);
	public boolean addSysUser(SysUser sysUser);
	public int updateSysUser(SysUser sysUser);
	public int batchDelSysUser(List<String> userId)  throws Exception;
	public int changeSysUserPwd(SysUser sysUser);
}
