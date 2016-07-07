/**
 * Copyright (c) 2011 asiainfo.com
 */
package ngves.asiainfo.core.system.service.impl;

import ngves.asiainfo.core.system.dao.interfaces.IParaPropDAO;
import ngves.asiainfo.core.system.ivalues.IParaPropValue;
import ngves.asiainfo.core.system.service.interfaces.IParaPropSrv;
/**
 * 配置属性
 * @author songluzhen
 */
public class ParaPropSrvImpl implements IParaPropSrv {

	private IParaPropDAO paraPropDAO;

	public IParaPropDAO getParaPropDAO() {
		return paraPropDAO;
	}

	public void setParaPropDAO(IParaPropDAO paraPropDAO) {
		this.paraPropDAO = paraPropDAO;
	}

	public IParaPropValue queryParaPropByKey(String key)
			throws Exception {
		IParaPropValue value = null;
		IParaPropValue[] values = paraPropDAO.queryParaPropByKey(key);
		if(values.length>0){
			value = values[0];
		}
		return value;
	}
}
