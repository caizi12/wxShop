/**
 * 
 */
package ngves.asiainfo.core.ware.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.ai.secframe.bo.orgmodel.SysStaffEngine;
import com.ai.secframe.ivalues.orgmodel.ISysStaffValue;

import ngves.asiainfo.core.ware.bo.WareUpDownHisEngine;
import ngves.asiainfo.core.ware.bo.WareUpDownPlanEngine;
import ngves.asiainfo.core.ware.bo.WareUpDownVersionEngine;
import ngves.asiainfo.core.ware.dao.interfaces.IWareStatusDAO;
import ngves.asiainfo.core.ware.ivalues.IWareUpDownHisValue;
import ngves.asiainfo.core.ware.ivalues.IWareUpDownPlanValue;
import ngves.asiainfo.core.ware.ivalues.IWareUpDownVersionValue;

/**
 * @author asiainfo
 *
 */
public class WareStatusDAOImpl implements IWareStatusDAO {

	/**
	 * 查询客服电话
	 */
	private final static String QUERY_STAFF = ISysStaffValue.S_StaffId + " = :" + ISysStaffValue.S_StaffId;
	
	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.ware.dao.interfaces.IWareStatusDAO#getWareUpDownVersion(java.lang.String, java.util.Map)
	 */
	public IWareUpDownVersionValue[] getWareUpDownVersionValue(String condition, Map<String, String> parameter) throws Exception {
		IWareUpDownVersionValue[] values = WareUpDownVersionEngine.getBeans(condition, parameter);
		return values;
	}

	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.ware.dao.interfaces.IWareStatusDAO#savePreOperLine(ngves.asiainfo.core.ware.ivalues.IWareUpDownPlanValue)
	 */
	public void saveWareUpDownPlanValue(IWareUpDownPlanValue value) throws Exception {
		WareUpDownPlanEngine.save(value);
	}

	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.ware.dao.interfaces.IWareStatusDAO#saveWareUpDownVersion(ngves.asiainfo.core.ware.ivalues.IWareUpDownVersionValue)
	 */
	public void saveWareUpDownVersionValue(IWareUpDownVersionValue value) throws Exception {
		WareUpDownVersionEngine.save(value);
	}

	public IWareUpDownPlanValue[] getWareUpDownPlanValue(String condition, Map<String, String> parameter) throws Exception {
		IWareUpDownPlanValue[] values = WareUpDownPlanEngine.getBeans(condition, parameter);
		return values;
	}

	public IWareUpDownPlanValue getWareUpDownPlanValueById(long id) throws Exception {
		IWareUpDownPlanValue value  = WareUpDownPlanEngine.getBean(id);
		return value;
	}

	public IWareUpDownVersionValue getWareUpDownVersionValueById(long id) throws Exception {
		IWareUpDownVersionValue value = WareUpDownVersionEngine.getBean(id);
		return value;
	}

	
	public void saveWareUpDownHisValue(IWareUpDownHisValue value) throws Exception {
		
		WareUpDownHisEngine.save(value);
	}
	
	/**
	 * 查询员工编号
	 * @param staffId
	 * @return
	 * @throws Exception
	 */
	public ISysStaffValue getSysStaffValue(String staffId) throws Exception {

		HashMap<String, String> map = new HashMap<String, String>();
		map.put(ISysStaffValue.S_StaffId, staffId);
		ISysStaffValue[] staffs = SysStaffEngine.getBeans(QUERY_STAFF, map);
		if (staffs != null && staffs.length != 0) {
			return staffs[0];
		}
		return null;
	}

}
