package ngves.asiainfo.core.order.dao.impl;

import java.util.Map;

import ngves.asiainfo.core.order.bo.BarCodeOrderFileEngine;
import ngves.asiainfo.core.order.dao.interfaces.IBarCodeFileDownLoadDAO;
import ngves.asiainfo.core.order.ivalues.IBarCodeOrderFileValue;

public class BarCodeFileDownLoadDAOImpl implements IBarCodeFileDownLoadDAO {

	public int countBarCodeFileList(String conditon, Map<String, String> parameter) throws Exception {
		return BarCodeOrderFileEngine.getBeansCount(conditon, parameter);
	}

	public IBarCodeOrderFileValue[] getBarCodeFileList(String conditon, Map<String, String> parameter, int startIndex,
			int endIndex) throws Exception {
		return BarCodeOrderFileEngine.getBeans(null, conditon, parameter, startIndex, endIndex, false);
	}

	public void saveBarCodeFileInfo(IBarCodeOrderFileValue value) throws Exception {
		BarCodeOrderFileEngine.save(value);
	}

}
