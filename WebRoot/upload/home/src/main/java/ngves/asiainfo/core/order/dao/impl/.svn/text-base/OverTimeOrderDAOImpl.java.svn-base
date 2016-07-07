package ngves.asiainfo.core.order.dao.impl;

import java.util.Map;

import ngves.asiainfo.core.common.bo.ExcelTaskEngine;
import ngves.asiainfo.core.common.ivalues.IExcelTaskValue;
import ngves.asiainfo.core.order.dao.interfaces.IOverTimeOrderDAO;

public class OverTimeOrderDAOImpl implements IOverTimeOrderDAO {

	public int countExcelTaskValues(String condtion,
			Map<String, String> parameter) throws Exception {
		int num  = ExcelTaskEngine.getBeansCount(condtion, parameter);
		return num;
	}

	public IExcelTaskValue[] queryExcelTaskValues(String condtion,
			Map<String, String> parameter,int startIndex,int endIndex) throws Exception {
		IExcelTaskValue[] values = ExcelTaskEngine.getBeans(null,condtion, parameter, startIndex, endIndex, false);
		return values;
	}

}
