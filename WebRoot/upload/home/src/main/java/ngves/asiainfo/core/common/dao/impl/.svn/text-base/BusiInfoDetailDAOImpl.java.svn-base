package ngves.asiainfo.core.common.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.common.bo.BusiInfoDetailEngine;
import ngves.asiainfo.core.common.dao.interfaces.IBusiInfoDetailDAO;
import ngves.asiainfo.core.common.ivalues.IBusiInfoDetailValue;

public class BusiInfoDetailDAOImpl implements IBusiInfoDetailDAO {

    public IBusiInfoDetailValue getBusiInfoDetail(long subBusiId) throws Exception {
        return BusiInfoDetailEngine.getBean(subBusiId);
    }

    @SuppressWarnings("unchecked")
    public IBusiInfoDetailValue[] getBusiInfoDetails(long busiId) throws Exception {
        StringBuffer condition = new StringBuffer();
        Map parameter = new HashMap();
        condition.append(IBusiInfoDetailValue.S_BusiId).append("=:").append(IBusiInfoDetailValue.S_BusiId);
        parameter.put(IBusiInfoDetailValue.S_BusiId, busiId);
        return BusiInfoDetailEngine.getBeans(condition.toString(), parameter);
    }

    public long saveBusiInfoDetail(IBusiInfoDetailValue busiInfoDetail) throws Exception {
        long subBusiId = 0;
        if (busiInfoDetail.isNew()) {
            busiInfoDetail.setDetailId(BusiInfoDetailEngine.getNewId().longValue());
        }
        subBusiId = busiInfoDetail.getDetailId();
        BusiInfoDetailEngine.save(busiInfoDetail);
        return subBusiId;
    }

    public void saveBusiInfoDetails(IBusiInfoDetailValue[] busiInfoDetails) throws Exception {
        for (int i = 0; i < busiInfoDetails.length; i++) {
            if (busiInfoDetails[i].isNew()) {
                busiInfoDetails[i].setDetailId(BusiInfoDetailEngine.getNewId().longValue());
            }
        }
        BusiInfoDetailEngine.save(busiInfoDetails);
    }

}
