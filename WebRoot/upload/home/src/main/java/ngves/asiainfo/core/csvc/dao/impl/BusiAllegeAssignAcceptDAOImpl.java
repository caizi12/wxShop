/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.dao.impl;

import ngves.asiainfo.core.common.bo.BusiAllegeAssignAcceptEngine;
import ngves.asiainfo.core.common.ivalues.IBusiAllegeAssignAcceptValue;
import ngves.asiainfo.core.csvc.dao.interfaces.IBusiAllegeAssignAcceptDAO;

import java.util.HashMap;
import java.util.Map;

/**
 * 投诉派发接收流水表DAO层的默认实现类
 * 
 * @author ggs
 */
public class BusiAllegeAssignAcceptDAOImpl implements IBusiAllegeAssignAcceptDAO {

	public void saveBusiAllegeAssignAccept(IBusiAllegeAssignAcceptValue busiAllegeAssignAcceptValue) throws Exception {
		
		if(busiAllegeAssignAcceptValue.isNew()){
			busiAllegeAssignAcceptValue.setBusiId(BusiAllegeAssignAcceptEngine.getNewId().longValue());
		}
		BusiAllegeAssignAcceptEngine.save(busiAllegeAssignAcceptValue);
	}

	public IBusiAllegeAssignAcceptValue get(long busiAllegeAssignAcceptId) throws Exception {
		return BusiAllegeAssignAcceptEngine.getBean(busiAllegeAssignAcceptId);
	}

    public IBusiAllegeAssignAcceptValue getByIndictSeq(String indictSeq) throws Exception {
        String condition = IBusiAllegeAssignAcceptValue.S_Indictseq  + "= :" + IBusiAllegeAssignAcceptValue.S_Indictseq;
        Map<String, String> params = new HashMap<String,String>();
        params.put(IBusiAllegeAssignAcceptValue.S_Indictseq, indictSeq);
        IBusiAllegeAssignAcceptValue[] values = BusiAllegeAssignAcceptEngine.getBeans(condition, params);
        if(values == null || values.length == 0){
            return null;
        }

        return values[0];
    }


}
