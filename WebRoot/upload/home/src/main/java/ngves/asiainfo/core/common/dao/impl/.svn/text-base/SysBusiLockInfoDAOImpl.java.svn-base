/**
 * 
 */
package ngves.asiainfo.core.common.dao.impl;

import java.util.Map;

import ngves.asiainfo.core.common.bo.SysBusiLockInfoBean;
import ngves.asiainfo.core.common.bo.SysBusiLockInfoEngine;
import ngves.asiainfo.core.common.dao.interfaces.ISysBusiLockInfoDAO;
import ngves.asiainfo.core.common.ivalues.ISysBusiLockInfoValue;

/**
 * @author admin
 * 
 */
public class SysBusiLockInfoDAOImpl implements ISysBusiLockInfoDAO {

	public ISysBusiLockInfoValue getSysBusiLockInfoValue(String lockType,String lockCode)
			throws Exception {
		SysBusiLockInfoBean value = SysBusiLockInfoEngine.getBean(lockType,lockCode);
		return value;
	}

	public ISysBusiLockInfoValue[] getSysBusiLockInfoValues(String condtion, Map<String, String> parameter)
			throws Exception {
		SysBusiLockInfoBean[] value = SysBusiLockInfoEngine.getBeans(condtion, parameter);
		return value;
	}

	public void saveLockInfo(ISysBusiLockInfoValue value) throws Exception {
		SysBusiLockInfoEngine.save(value);

	}

	public void saveLockInfo(ISysBusiLockInfoValue[] values) throws Exception {
		if (null != values) {
			for (ISysBusiLockInfoValue value : values) {
				value.setStsToNew();
			}
			SysBusiLockInfoEngine.save(values);
		}
	}

}
