/**
 * Copyright (c) 2011 asiainfo.com
 */
package ngves.asiainfo.core.system.dao.impl;

import java.util.HashMap;
import java.util.Map;
import ngves.asiainfo.core.system.bo.ParaPropEngine;
import ngves.asiainfo.core.system.dao.interfaces.IParaPropDAO;
import ngves.asiainfo.core.system.ivalues.IParaPropValue;

/**
 * 配置属性
 * 
 * @author songluzhen
 */
public class ParaPropDAOImpl implements IParaPropDAO {
	
	public IParaPropValue[] queryParaPropByKey(String key) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuffer condition = new StringBuffer(" 1=1 ");
		condition.append(" and " + IParaPropValue.S_ParaKey + " = :"
				+ IParaPropValue.S_ParaKey);
		map.put(IParaPropValue.S_ParaKey, key);
		return ParaPropEngine.getBeans(condition.toString(), map);
	}
}
