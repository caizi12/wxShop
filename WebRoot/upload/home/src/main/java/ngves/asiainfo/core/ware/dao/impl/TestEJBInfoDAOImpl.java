/**
 * Copyright (c) 2011 asiainfo-linkage.com
 */
package ngves.asiainfo.core.ware.dao.impl;

import java.net.InetAddress;

import ngves.asiainfo.core.ware.dao.interfaces.ITestEJBInfoDAO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * @author asiainfo
 *
 */
public class TestEJBInfoDAOImpl implements ITestEJBInfoDAO {
	
	private static transient Log log = LogFactory.getLog(TestEJBInfoDAOImpl.class); 

	
	public String getEJBServiceName() throws Exception {
		String result ="";
		Thread current = Thread.currentThread();
		result+=" The methood getEJBServiceName>>>   ThreadId:" + current.getId() +"______ThreadName:" + current.getName();
		
		InetAddress myIPaddress=null;
		myIPaddress=InetAddress.getLocalHost();
		
		result+="______Host EJBServiceName/IP:"+ myIPaddress+"____HostName:"+myIPaddress.getHostName();
		
		System.out.println("Your host ______EJBServiceName IP is: " + myIPaddress);
		log.info("Your host ______EJBServiceName/IP is: " + myIPaddress);
		
		return result;
	}
	
	
}
