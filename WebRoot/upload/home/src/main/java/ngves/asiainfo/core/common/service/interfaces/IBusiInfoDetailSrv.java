package ngves.asiainfo.core.common.service.interfaces;

import java.util.Map;

import ngves.asiainfo.core.common.dao.interfaces.IBusiInfoDetailDAO;
import ngves.asiainfo.core.common.ivalues.IBusiInfoDetailValue;

public interface IBusiInfoDetailSrv {
    public void setBusiInfoDetailDAO(IBusiInfoDetailDAO busiInfoDetailDAO) throws Exception;

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

    /**
     * 根据对象的前后字段值变化，记录业务流水,长度一样
     * @param busiId
     * @param oldValues
     * @param newValues
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public long recordBusiInfoDetails(String busiId, Map oldValues, Map newValues) throws Exception;

    /**
     * 根据对象的前后字段值变化，记录业务流水,长度一样
     * @param busiId
     * @param oldValues
     * @param newValues
     * @param fieldName
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public long recordBusiInfoDetails(String busiId, Map oldValues, Map newValues, String fieldName) throws Exception;

    /**
     * 根据对象的前后字段值变化，记录业务流水
     * 要求对象数组必须一一对应，不能错位。长度一样
     * @param busiId
     * @param oldValues
     * @param newValues
     * @return
     * @throws Exception
     */
    public long recordBusiInfoDetails(String busiId, Object[] oldValues, Object[] newValues) throws Exception;

    /**
     * 根据对象的前后字段值变化，记录业务流水
     * 要求对象数组必须一一对应，不能错位。长度一样
     * 对于纵表，需要指定 fieldName,该字段标识纵表属性值
     * @param busiId
     * @param oldValues
     * @param newValues
     * @param fieldName
     * @return
     * @throws Exception
     */
    public long recordBusiInfoDetails(String busiId, Object[] oldValues, Object[] newValues, String fieldName)
            throws Exception;
    
    
    /**
     *  AwardLevelInfo记录日志时，比对是否修改需要屏蔽一些字段。
     * @param busiId
     * @param oldValues
     * @param newValues
     * @param fieldName
     * @return
     * @throws Exception
     */
    public long recordBusiInfoDetailsForAwardLevel(String busiId, Object[] oldValues, Object[] newValues, String fieldName)
    throws Exception;
    
    /**
     * 比较两个object对象是否相同
     * @param oldObj
     * @param newObj
     * @param fieldValueName
     * @return
     * @throws Exception
     */
    public boolean compareIValue(Object oldObj, Object newObj, String fieldValueName) throws Exception;
    
    
    /**
     * 比较两个object对象是否相同，忽略其S_AwardLevelId属性的异同
     * @param oldObj
     * @param newObj
     * @param fieldValueName
     * @return
     * @throws Exception
     */
    public boolean compareValueIgnoreAwardLevelId(Object oldObj, Object newObj, String fieldValueName) throws Exception;
}
