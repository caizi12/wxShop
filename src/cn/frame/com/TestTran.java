package cn.frame.com;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.frame.com.service.DubboTestSrv;
import cn.frame.platform.entitys.SysUser;

public class TestTran {

	@Test
	public void test() {
		BeanFactory factory = new FileSystemXmlApplicationContext("E:/workspace/myFrame/WebRoot/WEB-INF/spring/applicationContext.xml");
		DubboTestSrv srv = (DubboTestSrv) factory.getBean("testSr");

		SysUser user=new SysUser();
		user.setUserId("11");
		user.setUserName("zhang san");
		user.setInvalidDate(new Date());
		user.setMaxLoginCount(0);
		user.setErrLoginCount(1);
		
		try {
			srv.addUser(user); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
