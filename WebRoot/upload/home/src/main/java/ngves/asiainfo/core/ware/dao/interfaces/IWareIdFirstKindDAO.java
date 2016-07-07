package ngves.asiainfo.core.ware.dao.interfaces;

import ngves.asiainfo.core.ware.ivalues.IQBOWareIdFirstKindValue;
/**
 * 类别和firstkind映射关系
 *
 */
public interface IWareIdFirstKindDAO {

	public IQBOWareIdFirstKindValue getWareIdFirstKindByWareId(long wareId) throws Exception;
	
	public IQBOWareIdFirstKindValue[] getWareIdFirstKind() throws Exception;
}
