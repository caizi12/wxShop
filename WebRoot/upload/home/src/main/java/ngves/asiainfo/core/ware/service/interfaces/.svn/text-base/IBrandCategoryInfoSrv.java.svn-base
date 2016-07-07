package ngves.asiainfo.core.ware.service.interfaces;

import ngves.asiainfo.core.ware.dao.interfaces.IBrandCategoryInfoDAO;
import ngves.asiainfo.core.ware.ivalues.IBrandCategoryInfoValue;

public interface IBrandCategoryInfoSrv {

	
	public void setBrandCategoryInfoDAO(IBrandCategoryInfoDAO brandCategoryInfoDAO) throws Exception;
	
	
	public IBrandCategoryInfoValue getBrandCategoryValueById(long id)throws Exception;

	/**
	 * @param value
	 * @param staffId
	 * @param comType
	 * @param orgId
	 * @param spellLength 
	 * @param isSpell
	 * @param cycleNum 轮转个数
	 */
	public void saveBrandCategoryInfo(IBrandCategoryInfoValue value, long staffId, String comType, long orgId,String isSpell, String spellLength, String cycleNum ) throws Exception;
	
}
