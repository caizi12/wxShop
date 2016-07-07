package ngves.asiainfo.core.order.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.order.ivalues.IBarCodeOrderFileValue;

public interface IBarCodeFileDownLoadDAO {

	/**
	 * 分页查询 二维码订单文件信息
	 * 
	 * @param conditon
	 *            查询条件
	 * @param parameter
	 *            条件对应的参数
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IBarCodeOrderFileValue[] getBarCodeFileList(String conditon, Map<String, String> parameter, int startIndex,
			int endIndex) throws Exception;

	/**
	 * 取得二维码订单文件信息的记录数
	 * 
	 * @param conditon
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public int countBarCodeFileList(String conditon, Map<String, String> parameter) throws Exception;

	/**
	 * 二维码订单文件信息入库
	 * @param value 文件信息
	 * @throws Exception
	 */
	public void saveBarCodeFileInfo(IBarCodeOrderFileValue value) throws Exception;

}
