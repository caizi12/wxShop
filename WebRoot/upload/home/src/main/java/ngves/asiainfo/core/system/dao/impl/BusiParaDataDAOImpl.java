package ngves.asiainfo.core.system.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.system.bo.BusiParaDataEngine;
import ngves.asiainfo.core.system.dao.interfaces.IBusiParaDataDAO;
import ngves.asiainfo.core.system.ivalues.IBusiParaDataValue;
import ngves.asiainfo.util.StringUtil;

public class BusiParaDataDAOImpl implements IBusiParaDataDAO{

	public IBusiParaDataValue[] queryBusiParaByCodeType(String paraCodeType) throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String, String> parameter = new HashMap<String, String>();
		
		if (!StringUtil.isBlank(paraCodeType)) {
			condition.append(" AND ");
			condition.append(IBusiParaDataValue.S_ParaCodeType + " LIKE :" + IBusiParaDataValue.S_ParaCodeType).append(" ");
			parameter.put(IBusiParaDataValue.S_ParaCodeType, "%"+paraCodeType+"%");
		}
		
		return BusiParaDataEngine.getBeans(condition.toString(), parameter);
	}

}
