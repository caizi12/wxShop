/**
 * Copyright (c) 2011 asiainfo.com
 */
package ngves.asiainfo.core.system.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.system.bo.ShowControlEngine;
import ngves.asiainfo.core.system.dao.interfaces.IShowControlDAO;
import ngves.asiainfo.core.system.ivalues.IShowControlValue;
import ngves.asiainfo.util.StringUtil;

/**
 * 置灰状态控制
 * @author ggs
 */
public class ShowControlDAOImpl implements IShowControlDAO {

	public IShowControlValue[] queryShowControl(String showName, String isGrey, int startIndex, int endIndex)
			throws Exception {

		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String, String> parameter = new HashMap<String, String>();
		if (!StringUtil.isBlank(showName)) {
			condition.append(" AND ");
			condition.append(IShowControlValue.S_ShowName + " LIKE :" + IShowControlValue.S_ShowName).append(" ");
			parameter.put(IShowControlValue.S_ShowName, "%" + showName + "%");
		}
		if (StringUtil.isNotNullValue(isGrey)) {
			condition.append(" AND ").append(IShowControlValue.S_IsGrey).append(" = :" + IShowControlValue.S_IsGrey);
			parameter.put(IShowControlValue.S_IsGrey, isGrey);
		}

		return ShowControlEngine.getBeans(condition.toString(), parameter);
	}

	public IShowControlValue getControlShowById(String showId) throws Exception {

		return ShowControlEngine.getBean(Long.parseLong(showId));
	}

	public void saveOrUpdate(IShowControlValue value) throws Exception {

		if (value.isNew()) {
			value.setShowId(ShowControlEngine.getNewId().longValue());
			ShowControlEngine.save(value);
		}
		ShowControlEngine.save(value);
	}

}
