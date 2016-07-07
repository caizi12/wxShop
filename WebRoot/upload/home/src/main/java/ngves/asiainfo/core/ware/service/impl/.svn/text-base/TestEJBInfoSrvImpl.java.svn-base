/**
 * Copyright (c) 2011 asiainfo-linkage.com
 */
package ngves.asiainfo.core.ware.service.impl;

import ngves.asiainfo.core.ware.dao.interfaces.ITestEJBInfoDAO;
import ngves.asiainfo.core.ware.service.interfaces.ITestEJBInfoSrv;

/**
 * @author asiainfo
 *
 */
public class TestEJBInfoSrvImpl implements ITestEJBInfoSrv {

    private ITestEJBInfoDAO testEJBInfoDAO;
    public void setTestEJBInfoDAO(ITestEJBInfoDAO testEJBInfoDAO)  throws Exception{
        this.testEJBInfoDAO = testEJBInfoDAO;
    }



    public String getEJBServiceName() throws Exception {

		return testEJBInfoDAO.getEJBServiceName();
	}

}
