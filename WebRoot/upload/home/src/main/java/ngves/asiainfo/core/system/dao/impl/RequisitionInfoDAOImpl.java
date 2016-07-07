package ngves.asiainfo.core.system.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.common.bo.RequisitionInfoEngine;
import ngves.asiainfo.core.common.ivalues.IRequisitionInfoValue;
import ngves.asiainfo.core.system.dao.interfaces.IRequisitionInfoDAO;
import ngves.asiainfo.util.StringUtil;

public class RequisitionInfoDAOImpl implements IRequisitionInfoDAO {

    public IRequisitionInfoValue[] queryRequisitionInfo(String startTime, String endTime, String staffId)
            throws Exception {

        StringBuilder sb = new StringBuilder();
        Map<String, Object> map = new HashMap<String, Object>();

        if (!StringUtil.isBlank(staffId)) {
            if (-1 != Long.parseLong(staffId)) {
                sb.append(IRequisitionInfoValue.S_OriginateStaffId).append(
                        "=:" + IRequisitionInfoValue.S_OriginateStaffId);
                map.put(IRequisitionInfoValue.S_OriginateStaffId, Long.valueOf(staffId));
            }
        }

        if (null != startTime && 1 < startTime.length()) {
            if (1 < sb.length())
                sb.append(" and ");
            sb.append(IRequisitionInfoValue.S_OriginateTime).append(
                    " >=to_date('" + startTime + "','yyyy-mm-dd hh24:mi:ss')");
        }

        if (null != endTime && 1 < endTime.length()) {
            if (1 < sb.length())
                sb.append(" and ");
            sb.append(IRequisitionInfoValue.S_OriginateTime).append(
                    " <=to_date('" + endTime + "','yyyy-mm-dd hh24:mi:ss')");
        }

        if (1 < sb.length())
            sb.append(" order by ").append(IRequisitionInfoValue.S_OriginateTime).append(" desc");

        return RequisitionInfoEngine.getBeans(sb.toString(), map);
    }

    public void updateRequisitionInfo(IRequisitionInfoValue value) throws Exception {
        value.initProperty(IRequisitionInfoValue.S_RequisitionId, Long.valueOf(value.getRequisitionId()));
        RequisitionInfoEngine.save(value);
    }

    public long addRequisitionInfo(IRequisitionInfoValue value) throws Exception {
        value.setRequisitionId(RequisitionInfoEngine.getNewId().longValue());
        value.setOriginateTime(RequisitionInfoEngine.getSysDate());
        RequisitionInfoEngine.save(value);
        return value.getRequisitionId();

    }

}
