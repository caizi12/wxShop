/**
 * 
 */
package ngves.asiainfo.core.ware.service.impl;

import ngves.asiainfo.core.ware.dao.interfaces.IWareIdFirstKindDAO;
import ngves.asiainfo.core.ware.ivalues.IQBOWareIdFirstKindValue;
import ngves.asiainfo.core.ware.service.interfaces.IWareIdFirstKindSrv;
/**
 * @author 宋鲁振
 *
 */
public class WareIdFirstKindSrvImpl implements IWareIdFirstKindSrv {
	private IWareIdFirstKindDAO wareIdFirstKindDAO;

	public void setWareIdFirstKindDAO(IWareIdFirstKindDAO wareIdFirstKindDAO) {
		this.wareIdFirstKindDAO = wareIdFirstKindDAO;
	}

    public IQBOWareIdFirstKindValue[] getWareIdFirstKindInfos() throws Exception {
        IQBOWareIdFirstKindValue[] value = wareIdFirstKindDAO.getWareIdFirstKind();
        return value;
    }
    
    public IQBOWareIdFirstKindValue getWareIdFirstKindInfoById(long wareId) throws Exception {
        IQBOWareIdFirstKindValue value = wareIdFirstKindDAO.getWareIdFirstKindByWareId(wareId);
        return value;
    }

}
