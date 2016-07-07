package ngves.asiainfo.core.sms.dao.interfaces;

import java.util.Map;
import ngves.asiainfo.core.sms.ivalues.IBusiSmsAuditValue;

public interface IBusiSmsDAO {
	/**
	 * 短信审核流水信息保存
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public void saveBusiSmsValue(IBusiSmsAuditValue value) throws Exception;

	/**
	 * 短信审核流水信息批量保存
	 * 
	 * @param values
	 * @return
	 * @throws Exception
	 */
	public void saveBusiSmsValues(IBusiSmsAuditValue[] values) throws Exception;

	/**
	 * 获取短信审核流水信息列表
	 * 
	 * @param condition
	 * @param parameter
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public IBusiSmsAuditValue[] getBusiSmsValues(String condition,
			Map parameter, int startIndex, int endIndex) throws Exception;

	/**
	 * 获取短信审核流水信息列表(不进行分页)
	 * 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public IBusiSmsAuditValue[] getBusiSmsValues(String condition, Map parameter)
			throws Exception;

	/**
	 * 获取短信审核流水信息列表行数
	 * 
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public int getBusiSmsValuesCount(String condition, Map parameter)
			throws Exception;

	/**
	 * 获取短信审核流水详细信息
	 * 
	 * @param busiSmsId
	 * @return
	 * @throws Exception
	 */
	public IBusiSmsAuditValue getBusiSmsValueById(String busiSmsId)
			throws Exception;
}
