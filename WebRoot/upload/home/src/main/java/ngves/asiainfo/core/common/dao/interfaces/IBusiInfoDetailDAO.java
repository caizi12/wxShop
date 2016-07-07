package ngves.asiainfo.core.common.dao.interfaces;

import ngves.asiainfo.core.common.ivalues.IBusiInfoDetailValue;


public interface IBusiInfoDetailDAO {
    /**
     * 保存一条业务详细信息
     * @param busiInfoDetail
     * @return
     * @throws Exception
     */
    public long saveBusiInfoDetail(IBusiInfoDetailValue busiInfoDetail) throws Exception;

    /**
     * 保存多个业务详细信息
     * @param busiInfoDetails
     * @throws Exception
     */
    public void saveBusiInfoDetails(IBusiInfoDetailValue[] busiInfoDetails) throws Exception;

    /**
     * 获取一条业务详细信息
     * @param subBusiId
     * @return
     * @throws Exception
     */
    public IBusiInfoDetailValue getBusiInfoDetail(long subBusiId) throws Exception;

    /**
     * 获取一组业务详细信息
     * @param busiId
     * @return
     * @throws Exception
     */
    public IBusiInfoDetailValue[] getBusiInfoDetails(long busiId) throws Exception;
}
