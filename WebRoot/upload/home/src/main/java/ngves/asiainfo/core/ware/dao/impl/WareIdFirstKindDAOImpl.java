package ngves.asiainfo.core.ware.dao.impl;

import java.util.HashMap;
import java.util.Map;
import ngves.asiainfo.core.ware.bo.QBOWareIdFirstKindEngine;
import ngves.asiainfo.core.ware.dao.interfaces.IWareIdFirstKindDAO;
import ngves.asiainfo.core.ware.ivalues.IQBOWareIdFirstKindValue;

/**
 * Activity_Integral表DAO层类
 * @author 宋鲁振
 * 
 */
public class WareIdFirstKindDAOImpl implements IWareIdFirstKindDAO {

    @Override
    public IQBOWareIdFirstKindValue[] getWareIdFirstKind() throws Exception {
        return QBOWareIdFirstKindEngine.getBeans(null, null);
    }

    @Override
    public IQBOWareIdFirstKindValue getWareIdFirstKindByWareId(long wareId) throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append(" ware_id=:wareId ");
        
        Map<String, Long> parameter = new HashMap<String, Long>();
        parameter.put("wareId", wareId);
        
        IQBOWareIdFirstKindValue[] wareKinds = QBOWareIdFirstKindEngine.getBeans(sb.toString(), parameter); 
        if(wareKinds!= null&&wareKinds.length>0){
            return wareKinds[0];
        }
        return null;
    }

	
	

}
