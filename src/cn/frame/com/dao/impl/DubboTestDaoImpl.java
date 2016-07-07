package cn.frame.com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import cn.frame.com.dao.DubboTestDao;
import cn.frame.platform.entitys.SysUser;


@Repository
public class DubboTestDaoImpl  implements DubboTestDao{

	@Autowired
    public SqlMapClientTemplate ibatisTemplate;

	public String testDubbo(String str) throws Exception {
		List list=ibatisTemplate.getSqlMapClient().queryForList("getSysUser");
		return str+" I'm Dao, length:"+list.size();
	}

	public boolean addUser(SysUser user) throws Exception{
		ibatisTemplate.getSqlMapClient().insert("addSysUser",user);
		return true;
	}
}
