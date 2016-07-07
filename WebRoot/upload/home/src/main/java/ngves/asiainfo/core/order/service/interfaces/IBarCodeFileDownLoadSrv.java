package ngves.asiainfo.core.order.service.interfaces;

import ngves.asiainfo.core.order.dao.interfaces.IBarCodeFileDownLoadDAO;
import ngves.asiainfo.core.order.ivalues.IBarCodeOrderFileValue;

public interface IBarCodeFileDownLoadSrv {

	public void setBarCodeFileDAO(IBarCodeFileDownLoadDAO barCodeFileDAO)
			throws Exception;

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

	public IBarCodeOrderFileValue[] getBarCodeOrderByDate(String orderFileYear,
			String orderFileSeason, int startIndex, int endIndex)
			throws Exception;

	/**
	 * 取得二维码订单文件信息的记录数
	 * 
	 * @param conditon
	 * @param parameter
	 * @return
	 * @throws Exception
	 */

	public int countBarCodeOrder(String orderFileYear, String orderFileSeason)
			throws Exception;

}
