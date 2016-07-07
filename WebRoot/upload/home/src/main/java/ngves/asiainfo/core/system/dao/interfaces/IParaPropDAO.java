/**
 * Copyright (c) 2011 asiainfo.com
 */
package ngves.asiainfo.core.system.dao.interfaces;

import ngves.asiainfo.core.system.ivalues.IParaPropValue;

/**
 * 配置属性接口
 * @author songluzhen
 *
 */
public interface IParaPropDAO {

	/**
	 * 获取配置属性表中的属性值
	 * @param key
	 * @return
	 * @throws Exception
	 */
    public IParaPropValue[] queryParaPropByKey(String key) throws Exception;
    
}
