package ngves.asiainfo.core.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.common.ivalues.*;

public class StorageWarehouseRltBean extends DataContainer implements DataContainerInterface, IStorageWarehouseRltValue {

    /**
       * 
       */
    private static final long serialVersionUID = 1L;

    private static String m_boName = "ngves.asiainfo.core.common.bo.StorageWarehouseRlt";

    public final static String S_StorageWarehouseRltId = "STORAGE_WAREHOUSE_RLT_ID";
    public final static String S_RltState = "RLT_STATE";
    public final static String S_EndTime = "END_TIME";
    public final static String S_WarehouseId = "WAREHOUSE_ID";
    public final static String S_BegTime = "BEG_TIME";
    public final static String S_PartnerId = "PARTNER_ID";

    public StorageWarehouseRltBean() throws AIException {
        super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
    }

    public static ObjectType getObjectTypeStatic() throws AIException {
        return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }

    public void setObjectType(ObjectType value) throws AIException {
        throw new AIException("此种数据容器不能重置业务对象类型");
    }

    public void initStorageWarehouseRltId(long value) {
        this.initProperty(S_StorageWarehouseRltId, new Long(value));
    }

    public void setStorageWarehouseRltId(long value) {
        this.set(S_StorageWarehouseRltId, new Long(value));
    }

    public void setStorageWarehouseRltIdNull() {
        this.set(S_StorageWarehouseRltId, null);
    }

    public long getStorageWarehouseRltId() {
        return DataType.getAsLong(this.get(S_StorageWarehouseRltId));

    }

    public long getStorageWarehouseRltIdInitialValue() {
        return DataType.getAsLong(this.getOldObj(S_StorageWarehouseRltId));
    }

    public void initRltState(String value) {
        this.initProperty(S_RltState, value);
    }

    public void setRltState(String value) {
        this.set(S_RltState, value);
    }

    public void setRltStateNull() {
        this.set(S_RltState, null);
    }

    public String getRltState() {
        return DataType.getAsString(this.get(S_RltState));

    }

    public String getRltStateInitialValue() {
        return DataType.getAsString(this.getOldObj(S_RltState));
    }

    public void initEndTime(Timestamp value) {
        this.initProperty(S_EndTime, value);
    }

    public void setEndTime(Timestamp value) {
        this.set(S_EndTime, value);
    }

    public void setEndTimeNull() {
        this.set(S_EndTime, null);
    }

    public Timestamp getEndTime() {
        return DataType.getAsDateTime(this.get(S_EndTime));

    }

    public Timestamp getEndTimeInitialValue() {
        return DataType.getAsDateTime(this.getOldObj(S_EndTime));
    }

    public void initWarehouseId(long value) {
        this.initProperty(S_WarehouseId, new Long(value));
    }

    public void setWarehouseId(long value) {
        this.set(S_WarehouseId, new Long(value));
    }

    public void setWarehouseIdNull() {
        this.set(S_WarehouseId, null);
    }

    public long getWarehouseId() {
        return DataType.getAsLong(this.get(S_WarehouseId));

    }

    public long getWarehouseIdInitialValue() {
        return DataType.getAsLong(this.getOldObj(S_WarehouseId));
    }

    public void initBegTime(Timestamp value) {
        this.initProperty(S_BegTime, value);
    }

    public void setBegTime(Timestamp value) {
        this.set(S_BegTime, value);
    }

    public void setBegTimeNull() {
        this.set(S_BegTime, null);
    }

    public Timestamp getBegTime() {
        return DataType.getAsDateTime(this.get(S_BegTime));

    }

    public Timestamp getBegTimeInitialValue() {
        return DataType.getAsDateTime(this.getOldObj(S_BegTime));
    }

    public void initPartnerId(long value) {
        this.initProperty(S_PartnerId, new Long(value));
    }

    public void setPartnerId(long value) {
        this.set(S_PartnerId, new Long(value));
    }

    public void setPartnerIdNull() {
        this.set(S_PartnerId, null);
    }

    public long getPartnerId() {
        return DataType.getAsLong(this.get(S_PartnerId));

    }

    public long getPartnerIdInitialValue() {
        return DataType.getAsLong(this.getOldObj(S_PartnerId));
    }

}
