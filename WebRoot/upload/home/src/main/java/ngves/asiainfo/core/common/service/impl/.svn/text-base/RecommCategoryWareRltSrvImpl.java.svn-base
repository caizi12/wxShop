package ngves.asiainfo.core.common.service.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.common.dao.interfaces.IRecommCategoryWareRltDAO;
import ngves.asiainfo.core.common.ivalues.IRecommCategoryWareRltValue;
import ngves.asiainfo.core.common.service.interfaces.IRecommCategoryWareRltSrv;

public class RecommCategoryWareRltSrvImpl implements IRecommCategoryWareRltSrv{
	private IRecommCategoryWareRltDAO recommCategoryWareRltDao;

    public void setRecommCategoryWareRltDAO(IRecommCategoryWareRltDAO recommCategoryWareRltDao) throws Exception {
        this.recommCategoryWareRltDao = recommCategoryWareRltDao;
    }
	
	public IRecommCategoryWareRltValue[] getRecommCategoryWareRlt(long categoryId)
			throws Exception {
		String condition = IRecommCategoryWareRltValue.S_CategoryId + " =:"+IRecommCategoryWareRltValue.S_CategoryId;
		Map<String,Long> parameter = new HashMap<String,Long>();
        parameter.put(IRecommCategoryWareRltValue.S_CategoryId,categoryId);
		return recommCategoryWareRltDao.getRecommCategoryWareRlt(condition, parameter);
	}

}