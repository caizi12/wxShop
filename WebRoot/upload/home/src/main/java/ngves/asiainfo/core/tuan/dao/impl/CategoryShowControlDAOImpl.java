/**
 * Copyright (c) 2012 asiainfo.com
 */
package ngves.asiainfo.core.tuan.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.tuan.bo.CategoryShowControlEngine;
import ngves.asiainfo.core.tuan.dao.interfaces.ICategoryShowControlDAO;
import ngves.asiainfo.core.tuan.ivalues.ICategoryShowControlValue;
import ngves.asiainfo.util.StringUtil;

/**
 * 团购分类显示查询相关信息
 * 
 */
public class CategoryShowControlDAOImpl implements ICategoryShowControlDAO {

	public ICategoryShowControlValue getControlShowById(String showId) throws Exception {
		
		return CategoryShowControlEngine.getBean(Long.parseLong(showId));
	}

	//查询团购分类显示信息
	public ICategoryShowControlValue[] queryCategoryShowControl(String showName, String is_show, int startIndex, int endIndex)
			throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String, String> parameter = new HashMap<String, String>();
		if (!StringUtil.isBlank(showName)) {
			condition.append(" AND ");
			condition.append(ICategoryShowControlValue.S_ShowName + " LIKE :" + ICategoryShowControlValue.S_ShowName).append(" ");
			parameter.put(ICategoryShowControlValue.S_ShowName, "%" + showName + "%");
		}
		if (StringUtil.isNotNullValue(is_show)) {
			condition.append(" AND ").append(ICategoryShowControlValue.S_IsShow).append(" = :" + ICategoryShowControlValue.S_IsShow);
			parameter.put(ICategoryShowControlValue.S_IsShow, is_show);
		}

		return CategoryShowControlEngine.getBeans(condition.toString(), parameter);
	}

	//保存或更新信息
	public void saveOrUpdate(ICategoryShowControlValue value) throws Exception {
		if (value.isNew()) {
			value.setShowId(CategoryShowControlEngine.getNewId().longValue());
			CategoryShowControlEngine.save(value);
		}
		CategoryShowControlEngine.save(value);

	}
	
	

}
