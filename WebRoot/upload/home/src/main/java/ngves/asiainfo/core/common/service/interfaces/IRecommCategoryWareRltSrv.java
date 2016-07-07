package ngves.asiainfo.core.common.service.interfaces;

import ngves.asiainfo.core.common.dao.interfaces.IRecommCategoryWareRltDAO;
import ngves.asiainfo.core.common.ivalues.IRecommCategoryWareRltValue;

public interface IRecommCategoryWareRltSrv {
	
	public void setRecommCategoryWareRltDAO(IRecommCategoryWareRltDAO recommCategoryWareRltDao) throws Exception;
	
	public IRecommCategoryWareRltValue[] getRecommCategoryWareRlt(long categoryId) throws Exception;
}
