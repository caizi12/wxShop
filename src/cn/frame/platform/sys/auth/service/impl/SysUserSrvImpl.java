package cn.frame.platform.sys.auth.service.impl;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.stereotype.Service;

import cn.frame.platform.common.base.BaseDaoTemplate;
import cn.frame.platform.common.base.DataGridModel;
import cn.frame.platform.entitys.SysUser;
import cn.frame.platform.sys.auth.service.SysUserSrv;

import com.ibatis.sqlmap.client.SqlMapExecutor;

/**
 * 系统用户管理
 * 
 * @date 2012-09-23 14:21:45
 * @author llliang
 * 
 */
@Service("sysUserSrv")
public class SysUserSrvImpl implements SysUserSrv {
	
	@Autowired
	public BaseDaoTemplate baseDao;

	public SysUser adminLogin(SysUser sysUser) {
		return this.getSysUser(sysUser);
	}

	/**
	 * 获取用户信息
	 * 
	 * @param sysUser
	 * @return
	 */
	public SysUser getSysUser(SysUser sysUser) {
		sysUser = (SysUser) baseDao.getIbatisTemplate().queryForObject("getSysUser", sysUser);
		return sysUser;
	}

	/**
	 * 查询系统用户总数
	 * 
	 */
	@SuppressWarnings("unchecked")
	public int queryCountSysUser(Map<String, Object> userMap) {
		return baseDao.getQueryCount("querySysUser", userMap);
	}

	/**
	 * 查询系统用户
	 */
	public DataGridModel querySysUserData(DataGridModel dataGrid) {
		return baseDao.queryForPageDataGrid("querySysUser", dataGrid);
	}

	/**
	 * 添加用户
	 */
	public boolean addSysUser(SysUser sysUser) {
		sysUser.setUserId(String.valueOf(baseDao.getColumnMaxValueForInt("SYS_USER", "USER_ID") + 1));
		sysUser.setErrLoginCount(0);
		baseDao.getIbatisTemplate().insert("addSysUser", sysUser);
		return true;
	}

	/**
	 * 批量删除用户
	 */
	@SuppressWarnings("unchecked")
	public int batchDelSysUser(final List<String> list) throws Exception {
		if (list != null) {
			baseDao.getIbatisTemplate().execute(new SqlMapClientCallback() {
				public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
					executor.startBatch();
					for (int i = 0, n = list.size(); i < n; i++) {
						executor.delete("batchDelSysUser", list.get(i));
					}
					executor.executeBatch();
					return null;
				}
			});
		}
		int i = 0;
		return i;
	}

	/**
	 * 修改用户信息
	 */
	public int updateSysUser(SysUser sysUser) {
		return baseDao.getIbatisTemplate().update("updateSysUser", sysUser);
	}
	
	/**
	 * 修改用户密码
	 * @param sysUser
	 * @return
	 */
	public int changeSysUserPwd(SysUser sysUser) {
		return baseDao.getIbatisTemplate().update("changeSysUserPwd", sysUser);
	}
}
