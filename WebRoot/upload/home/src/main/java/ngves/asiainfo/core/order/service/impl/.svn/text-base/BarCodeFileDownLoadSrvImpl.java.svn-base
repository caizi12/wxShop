package ngves.asiainfo.core.order.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.order.dao.interfaces.IBarCodeFileDownLoadDAO;
import ngves.asiainfo.core.order.ivalues.IBarCodeOrderFileValue;
import ngves.asiainfo.core.order.service.interfaces.IBarCodeFileDownLoadSrv;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BarCodeFileDownLoadSrvImpl implements IBarCodeFileDownLoadSrv {
	private static transient Log logger = LogFactory
			.getLog(BarCodeFileDownLoadSrvImpl.class);
	private IBarCodeFileDownLoadDAO barCodeFileDAO;

	public void setBarCodeFileDAO(IBarCodeFileDownLoadDAO barCodeFileDAO)
			throws Exception {
		this.barCodeFileDAO = barCodeFileDAO;
	}

	public IBarCodeOrderFileValue[] getBarCodeOrderByDate(String orderFileYear,
			String orderFileSeason, int startIndex, int endIndex)
			throws Exception {
		logger.info("query: the year is " + orderFileYear + ",the season is "
				+ orderFileSeason);
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String, String> parameter = new HashMap<String, String>();
		// 年份不为空，添加对应的条件
		if (!StringUtil.isBlank(orderFileYear)) {

			condition.append(" and " + IBarCodeOrderFileValue.S_OrderFileYear
					+ "=:orderFileYear");
			parameter.put("orderFileYear", orderFileYear);
		}
		if (!CoreConstant.ALL_SEASON.equals(orderFileSeason)) {
			condition.append(" and " + IBarCodeOrderFileValue.S_OrderFileSeason
					+ "=:orderFileSeason");
			parameter.put("orderFileSeason", orderFileSeason);
		}
		condition.append(" order by order_file_season desc,sort_num asc ");
		// 取得二维码订单文件列表
		IBarCodeOrderFileValue[] values = this.barCodeFileDAO
				.getBarCodeFileList(condition.toString(), parameter,
						startIndex, endIndex);
		return fillHTMLOperationField(values);

	}

	/**
	 * 向文件名字后面添加超链接操作
	 * 
	 * @throws UnsupportedEncodingException
	 */
	private IBarCodeOrderFileValue[] fillHTMLOperationField(
			IBarCodeOrderFileValue[] groups)
			throws UnsupportedEncodingException {
		for (IBarCodeOrderFileValue group : groups) {
			if (!"".equals(group.getOrderFileSeason())
					|| null != group.getOrderFileSeason()) {
				if (CoreConstant.ONE_SEASON.equals(group.getOrderFileSeason())) {
					group.setOrderFileSeason("一季度");
				}
				if (CoreConstant.TWO_SEASON.equals(group.getOrderFileSeason())) {
					group.setOrderFileSeason("二季度");
				}
				if (CoreConstant.THIRD_SEASON
						.equals(group.getOrderFileSeason())) {
					group.setOrderFileSeason("三季度");
				}
				if (CoreConstant.FOUR_SEASON.equals(group.getOrderFileSeason())) {
					group.setOrderFileSeason("四季度");
				}
			}
			String fileName = group.getFileName();
			String DispalyfileName = "";
			String tmpFileName = fileName.substring(
					fileName.lastIndexOf("/") + 1, fileName.length());
			if (tmpFileName.indexOf(CoreConstant.BARCODE_FILE_PREFIX) > -1) {
				DispalyfileName = CommnConstant.BARCODE_REPLACE
						+ tmpFileName.substring(
								tmpFileName.indexOf("BASE_") + 5, tmpFileName
										.length());
			} else {
				DispalyfileName = CommnConstant.BARCODE_REPLACE + tmpFileName;
			}
			StringBuffer sb = new StringBuffer();
			sb.append("<a href='javascript:indexControl(\"" + tmpFileName
					+ "\")'>" + DispalyfileName + "</a>");
			group.setFileName(sb.toString());
		}
		return groups;
	}

	public int countBarCodeOrder(String orderFileYear, String orderFileSeason)
			throws Exception {
		logger.info("count: the year is " + orderFileYear + ",the season is "
				+ orderFileSeason);
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String, String> parameter = new HashMap<String, String>();
		// 年份不为空，添加对应的条件
		if (!StringUtil.isBlank(orderFileYear)) {

			condition.append(" and " + IBarCodeOrderFileValue.S_OrderFileYear
					+ "=:orderFileYear");
			parameter.put("orderFileYear", orderFileYear);
		}
		if (!CoreConstant.ALL_SEASON.equals(orderFileSeason)) {
			condition.append(" and " + IBarCodeOrderFileValue.S_OrderFileSeason
					+ "=:orderFileSeason");
			parameter.put("orderFileSeason", orderFileSeason);
		}
		return this.barCodeFileDAO.countBarCodeFileList(condition.toString(),
				parameter);
	}

}
