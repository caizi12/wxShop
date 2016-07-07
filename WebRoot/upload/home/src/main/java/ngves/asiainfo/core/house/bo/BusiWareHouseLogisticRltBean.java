package ngves.asiainfo.core.house.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.house.ivalues.IBusiWareHouseLogisticRltValue;


import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class BusiWareHouseLogisticRltBean extends DataContainer implements DataContainerInterface,
        IBusiWareHouseLogisticRltValue {

    /**
       * 
       */
    private static final long serialVersionUID = 1L;
    								  
    private static String m_boName = "ngves.asiainfo.core.house.bo.BusiWareHouseLogisticRlt";

    public final static String S_LogisticRltBegTime = "LOGISTIC_RLT_BEG_TIME";
    public final static String S_ProvinceRltBegTime = "PROVINCE_RLT_BEG_TIME";
    public final static String S_RltState = "RLT_STATE";
    public final static String S_LogisticRltEndTime = "LOGISTIC_RLT_END_TIME";
    public final static String S_WarehouseId = "WAREHOUSE_ID";
    public final static String S_Note = "NOTE";
    public final static String S_ProvinceRltEndTime = "PROVINCE_RLT_END_TIME";
    public final static String S_ProvinceCode = "PROVINCE_CODE";
    public final static String S_AllPercent = "ALL_PERCENT";
    public final static String S_WarehouseLogisticRltId = "WAREHOUSE_LOGISTIC_RLT_ID";
    public final static String S_PartnerId = "PARTNER_ID";
    public final static String S_PartnerState = "PARTNER_STATE";
    
    public final static  String S_BusiId = "BUSI_ID";
    public final static  String S_BusiStatus = "BUSI_STATUS";
    public final static  String S_Operator = "OPERATOR";
    public final static  String S_SynTime = "SYN_TIME";

    public BusiWareHouseLogisticRltBean() throws AIException {
        super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
    }

    public static ObjectType getObjectTypeStatic() throws AIException {
        return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }

    public void setObjectType(ObjectType value) throws AIException {
        throw new AIException("此种数据容器不能重置业务对象类型");
    }

    public void initLogisticRltBegTime(Timestamp value) {
        this.initProperty(S_LogisticRltBegTime, value);
    }

    public void setLogisticRltBegTime(Timestamp value) {
        this.set(S_LogisticRltBegTime, value);
    }

    public void setLogisticRltBegTimeNull() {
        this.set(S_LogisticRltBegTime, null);
    }

    public Timestamp getLogisticRltBegTime() {
        return DataType.getAsDateTime(this.get(S_LogisticRltBegTime));

    }

    public Timestamp getLogisticRltBegTimeInitialValue() {
        return DataType.getAsDateTime(this.getOldObj(S_LogisticRltBegTime));
    }

    public void initProvinceRltBegTime(Timestamp value) {
        this.initProperty(S_ProvinceRltBegTime, value);
    }

    public void setProvinceRltBegTime(Timestamp value) {
        this.set(S_ProvinceRltBegTime, value);
    }

    public void setProvinceRltBegTimeNull() {
        this.set(S_ProvinceRltBegTime, null);
    }

    public Timestamp getProvinceRltBegTime() {
        return DataType.getAsDateTime(this.get(S_ProvinceRltBegTime));

    }

    public Timestamp getProvinceRltBegTimeInitialValue() {
        return DataType.getAsDateTime(this.getOldObj(S_ProvinceRltBegTime));
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

    public void initLogisticRltEndTime(Timestamp value) {
        this.initProperty(S_LogisticRltEndTime, value);
    }

    public void setLogisticRltEndTime(Timestamp value) {
        this.set(S_LogisticRltEndTime, value);
    }

    public void setLogisticRltEndTimeNull() {
        this.set(S_LogisticRltEndTime, null);
    }

    public Timestamp getLogisticRltEndTime() {
        return DataType.getAsDateTime(this.get(S_LogisticRltEndTime));

    }

    public Timestamp getLogisticRltEndTimeInitialValue() {
        return DataType.getAsDateTime(this.getOldObj(S_LogisticRltEndTime));
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

    public void initNote(String value) {
        this.initProperty(S_Note, value);
    }

    public void setNote(String value) {
        this.set(S_Note, value);
    }

    public void setNoteNull() {
        this.set(S_Note, null);
    }

    public String getNote() {
        return DataType.getAsString(this.get(S_Note));

    }

    public String getNoteInitialValue() {
        return DataType.getAsString(this.getOldObj(S_Note));
    }

    public void initProvinceRltEndTime(Timestamp value) {
        this.initProperty(S_ProvinceRltEndTime, value);
    }

    public void setProvinceRltEndTime(Timestamp value) {
        this.set(S_ProvinceRltEndTime, value);
    }

    public void setProvinceRltEndTimeNull() {
        this.set(S_ProvinceRltEndTime, null);
    }

    public Timestamp getProvinceRltEndTime() {
        return DataType.getAsDateTime(this.get(S_ProvinceRltEndTime));

    }

    public Timestamp getProvinceRltEndTimeInitialValue() {
        return DataType.getAsDateTime(this.getOldObj(S_ProvinceRltEndTime));
    }

    public void initProvinceCode(String value) {
        this.initProperty(S_ProvinceCode, value);
    }

    public void setProvinceCode(String value) {
        this.set(S_ProvinceCode, value);
    }

    public void setProvinceCodeNull() {
        this.set(S_ProvinceCode, null);
    }

    public String getProvinceCode() {
        return DataType.getAsString(this.get(S_ProvinceCode));

    }

    public String getProvinceCodeInitialValue() {
        return DataType.getAsString(this.getOldObj(S_ProvinceCode));
    }

    public void initAllPercent(String value) {
        this.initProperty(S_AllPercent, value);
    }

    public void setAllPercent(String value) {
        this.set(S_AllPercent, value);
    }

    public void setAllPercentNull() {
        this.set(S_AllPercent, null);
    }

    public String getAllPercent() {
        return DataType.getAsString(this.get(S_AllPercent));

    }

    public String getAllPercentInitialValue() {
        return DataType.getAsString(this.getOldObj(S_AllPercent));
    }

    public void initWarehouseLogisticRltId(long value) {
        this.initProperty(S_WarehouseLogisticRltId, new Long(value));
    }

    public void setWarehouseLogisticRltId(long value) {
        this.set(S_WarehouseLogisticRltId, new Long(value));
    }

    public void setWarehouseLogisticRltIdNull() {
        this.set(S_WarehouseLogisticRltId, null);
    }

    public long getWarehouseLogisticRltId() {
        return DataType.getAsLong(this.get(S_WarehouseLogisticRltId));

    }

    public long getWarehouseLogisticRltIdInitialValue() {
        return DataType.getAsLong(this.getOldObj(S_WarehouseLogisticRltId));
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

    public void initPartnerState(String value) {
        this.initProperty(S_PartnerState, value);
    }

    public void setPartnerState(String value) {
        this.set(S_PartnerState, value);
    }

    public void setPartnerStateNull() {
        this.set(S_PartnerState, null);
    }

    public String getPartnerState() {
        return DataType.getAsString(this.get(S_PartnerState));

    }

    public String getPartnerStateInitialValue() {
        return DataType.getAsString(this.getOldObj(S_PartnerState));
    }
    

    public void initBusiStatus(String value) {
        this.initProperty(S_BusiStatus, value);
    }

    public void setBusiStatus(String value) {
        this.set(S_BusiStatus, value);
    }

    public void setBusiStatusNull() {
        this.set(S_BusiStatus, null);
    }

    public String getBusiStatus() {
        return DataType.getAsString(this.get(S_BusiStatus));

    }

    public String getBusiStatusInitialValue() {
        return DataType.getAsString(this.getOldObj(S_BusiStatus));
    }
    

    public void initBusiId(long value) {
        this.initProperty(S_BusiId, value);
    }

    public void setBusiId(long value) {
        this.set(S_BusiId, value);
    }

    public void setBusiIdNull() {
        this.set(S_BusiId, null);
    }

    public long getBusiId() {
        return DataType.getAsLong(this.get(S_BusiId));
    }

    public long getBusiIdInitialValue() {
        return DataType.getAsLong(this.getOldObj(S_BusiId));
    }

    
    public void initOperator(String value) {
        this.initProperty(S_Operator, value);
    }

    public void setOperator(String value) {
        this.set(S_Operator, value);
    }

    public void setOperatorNull() {
        this.set(S_Operator, null);
    }

    public String getOperator() {
        return DataType.getAsString(this.get(S_Operator));

    }

    public String getOperatorInitialValue() {
        return DataType.getAsString(this.getOldObj(S_Operator));
    }
    
    public void initSynTime(String value) {
        this.initProperty(S_SynTime, value);
    }

    public void setSynTime(String value) {
        this.set(S_SynTime, value);
    }

    public void setSynTimeNull() {
        this.set(S_SynTime, null);
    }

    public String getSynTime() {
        return DataType.getAsString(this.get(S_SynTime));
    }

    public String getSynTimeInitialValue() {
        return DataType.getAsString(this.getOldObj(S_SynTime));
    }
}
