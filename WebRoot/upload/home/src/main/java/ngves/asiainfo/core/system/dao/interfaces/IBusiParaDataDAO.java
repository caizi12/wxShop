package ngves.asiainfo.core.system.dao.interfaces;

import ngves.asiainfo.core.system.ivalues.IBusiParaDataValue;

public interface IBusiParaDataDAO {
	
	/**
	 * 
	 * 通过表名查找和此表相关的所有字段
	 * @param ParaCodeType 表名
	 * @return
	 * @throws Exception
	 */
	public IBusiParaDataValue[] queryBusiParaByCodeType(String ParaCodeType)throws Exception;
	
}
