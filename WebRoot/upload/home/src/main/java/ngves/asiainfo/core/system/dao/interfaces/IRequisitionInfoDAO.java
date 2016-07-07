package ngves.asiainfo.core.system.dao.interfaces;

import ngves.asiainfo.core.common.ivalues.IRequisitionInfoValue;
/**
 * TODO 如果修改通知模块是，要删除mgt的这个DAO和实现和BEAN文件进行合并
 * @author wzg
 *
 */
public interface IRequisitionInfoDAO {
    /**
     * 通知单管理时，根据查询时间得到通知单信息
     * 
     * @param startTime
     * @param endTime
     * @param staffId
     * @return
     */
    public IRequisitionInfoValue[] queryRequisitionInfo(String startTime, String endTime, String staffId)
            throws Exception;

    /**
     * 更改通知单信息
     * 
     * @param value
     * @throws Exception
     */
    public void updateRequisitionInfo(IRequisitionInfoValue value) throws Exception;

    /**
     * 新插入通知单信息
     * 
     * @param value
     */
    public long addRequisitionInfo(IRequisitionInfoValue value) throws Exception;
}
