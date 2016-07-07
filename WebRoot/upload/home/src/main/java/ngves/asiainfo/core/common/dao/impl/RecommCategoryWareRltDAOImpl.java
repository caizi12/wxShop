package ngves.asiainfo.core.common.dao.impl;

import java.util.Map;
import ngves.asiainfo.core.common.bo.RecommCategoryWareRltEngine;
import ngves.asiainfo.core.common.dao.interfaces.IRecommCategoryWareRltDAO;
import ngves.asiainfo.core.common.ivalues.IRecommCategoryWareRltValue;

/**
 * 获取推荐记录
 * @author 宋鲁振
 *
 */
public class RecommCategoryWareRltDAOImpl implements IRecommCategoryWareRltDAO {

	public IRecommCategoryWareRltValue getRecommCategoryInfoValue(long categoryId) throws Exception {
		return RecommCategoryWareRltEngine.getBean(categoryId);
	}
	
	public IRecommCategoryWareRltValue[] getRecommCategoryWareRlt(String condition, Map<String, Long> parameter) throws Exception {
		return RecommCategoryWareRltEngine.getBeans(condition, parameter);
	}

}
