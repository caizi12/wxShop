package cn.frame.com.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.frame.com.dao.DubboTestDao;
import cn.frame.com.service.DubboTestSrv;
import cn.frame.platform.entitys.SysUser;
@Service("testSr")
public class DubboTestSrvImpl implements DubboTestSrv {

	@Autowired
	public DubboTestDao dubboTestDao;
	
	public String testOne(String str) {
		try {
			return dubboTestDao.testDubbo(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addUser(SysUser user) throws Exception {
			dubboTestDao.addUser(user);
			
			SysUser u=new SysUser();
			dubboTestDao.addUser(u);
		return true;
	}
	
	
}
