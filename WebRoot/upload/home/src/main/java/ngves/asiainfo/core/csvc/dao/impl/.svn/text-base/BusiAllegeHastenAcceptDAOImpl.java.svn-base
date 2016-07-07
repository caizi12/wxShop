/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.dao.impl;
import ngves.asiainfo.core.common.bo.BusiAllegeHastenAcceptEngine;
import ngves.asiainfo.core.common.ivalues.IBusiAllegeHastenAcceptValue;
import ngves.asiainfo.core.csvc.dao.interfaces.IBusiAllegeHastenAcceptDAO;

/**
 * 投诉催办接受流水表DAO层默认实现类
 * @author sxl
 *
 */
public class BusiAllegeHastenAcceptDAOImpl implements IBusiAllegeHastenAcceptDAO {

	
	/**
	 * 保存投诉催办
	 * @param allegeHastenValue
	 * @return
	 */
	public void saveAllegeHasten(IBusiAllegeHastenAcceptValue allegeHastenValue) throws Exception {

		if (allegeHastenValue.isNew()) {
			allegeHastenValue.setBusiId(BusiAllegeHastenAcceptEngine.getNewId().longValue());
		}
		BusiAllegeHastenAcceptEngine.save(allegeHastenValue);
	}

	public Long saveAllegeHastenReturnId(IBusiAllegeHastenAcceptValue allegeHastenValue) throws Exception {

		long Id = 0L;
		if (allegeHastenValue.isNew()) {
			Id = BusiAllegeHastenAcceptEngine.getNewId().longValue();
			allegeHastenValue.setBusiId(Id);
		}
		BusiAllegeHastenAcceptEngine.save(allegeHastenValue);
		return allegeHastenValue.getBusiId();
	}
	
	public IBusiAllegeHastenAcceptValue get(long busiId) throws Exception{
	    return BusiAllegeHastenAcceptEngine.getBean(busiId);
	}

}
