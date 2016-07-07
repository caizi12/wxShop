package ngves.asiainfo.core.system.service.interfaces;

import java.util.Map;

import ngves.asiainfo.core.system.dao.interfaces.IBusiParaDataDAO;

public interface IBusiParaDataSrv {
	
	/**
	 * DAO接口注入
	 * @param busiParaDataDAO
	 */
	public void setBusiParaDataDAO(IBusiParaDataDAO busiParaDataDAO);
	
	/**
	 * 通过表名查找和此表相关的所有字段
	 * @param paraCodeType 表名
	 * @return
	 */
	public Map<String,String> queryBusiParaByCodeType(String paraCodeType);

}
