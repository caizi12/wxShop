package ngves.asiainfo.core.order.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.common.ivalues.IExcelTaskValue;

public interface IOverTimeOrderDAO {
	/**
	 * 根据组拼的条件对excel任务进行查询
	 * 
	 * @param condtion
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public IExcelTaskValue[] queryExcelTaskValues(String condtion,
			Map<String, String> parameter,int startIndex,int endIndex) throws Exception;

	/**
	 * 根据组拼的条件查询excel任务记录数
	 * 
	 * @param condtion
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public int countExcelTaskValues(String condtion,
			Map<String, String> parameter) throws Exception;

}
