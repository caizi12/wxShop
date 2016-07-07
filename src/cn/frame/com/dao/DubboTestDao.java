package cn.frame.com.dao;

import java.sql.SQLException;

import cn.frame.platform.entitys.SysUser;

public interface DubboTestDao  {
	public String testDubbo(String str) throws Exception ;
	public boolean addUser(SysUser user) throws Exception;
}
