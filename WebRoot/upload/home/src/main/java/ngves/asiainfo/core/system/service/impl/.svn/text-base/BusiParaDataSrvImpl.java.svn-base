package ngves.asiainfo.core.system.service.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.system.dao.interfaces.IBusiParaDataDAO;
import ngves.asiainfo.core.system.ivalues.IBusiParaDataValue;
import ngves.asiainfo.core.system.service.interfaces.IBusiParaDataSrv;

public class BusiParaDataSrvImpl implements IBusiParaDataSrv{

	private IBusiParaDataDAO busiParaDataDAO = null;
	
	public IBusiParaDataDAO getBusiParaDataDAO() {
		return busiParaDataDAO;
	}

	public void setBusiParaDataDAO(IBusiParaDataDAO busiParaDataDAO) {
		this.busiParaDataDAO = busiParaDataDAO;
	}
	
	public Map<String, String> queryBusiParaByCodeType(String paraCodeType) {
		Map<String, String> map = new HashMap<String,String>();
		try {
			IBusiParaDataValue[] busiParaDataValues = this.busiParaDataDAO.queryBusiParaByCodeType(paraCodeType);
			for (IBusiParaDataValue busiParaDataValue : busiParaDataValues) {
				//全部大写存入map中
				map.put(busiParaDataValue.getParaCode().trim().toUpperCase(), busiParaDataValue.getParaName().trim());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
