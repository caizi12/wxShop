package ngves.asiainfo.core.review.bo;

import ngves.asiainfo.core.review.ivalues.IWareKindRltValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class WareKindRltBean extends DataContainer implements DataContainerInterface, IWareKindRltValue {

    /**
     * 
     */
    private static final long serialVersionUID = 8018015044379536334L;

    private static String m_boName = "ngves.asiainfo.core.review.bo.WareKindRlt";

    public final static String S_WareId = "WARE_ID";
    public final static String S_WareKindRltId = "WARE_KIND_RLT_ID";
    public final static String S_IsDefaultKind = "IS_DEFAULT_KIND";
    public final static String S_WareKindId = "WARE_KIND_ID";

    public WareKindRltBean() throws AIException {
        super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
    }

    public static ObjectType getObjectTypeStatic() throws AIException {
        return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }

    @Override
    public void setObjectType(ObjectType value) throws AIException {
        throw new AIException("此种数据容器不能重置业务对象类型");
    }

    public void initWareId(long value) {
        this.initProperty(S_WareId, Long.valueOf(value));
    }

    public void setWareId(long value) {
        this.set(S_WareId, Long.valueOf(value));
    }

    public void setWareIdNull() {
        this.set(S_WareId, null);
    }

    public long getWareId() {
        return DataType.getAsLong(this.get(S_WareId));

    }

    public long getWareIdInitialValue() {
        return DataType.getAsLong(this.getOldObj(S_WareId));
    }

    public void initWareKindRltId(long value) {
        this.initProperty(S_WareKindRltId, Long.valueOf(value));
    }

    public void setWareKindRltId(long value) {
        this.set(S_WareKindRltId, Long.valueOf(value));
    }

    public void setWareKindRltIdNull() {
        this.set(S_WareKindRltId, null);
    }

    public long getWareKindRltId() {
        return DataType.getAsLong(this.get(S_WareKindRltId));

    }

    public long getWareKindRltIdInitialValue() {
        return DataType.getAsLong(this.getOldObj(S_WareKindRltId));
    }

    public void initIsDefaultKind(String value) {
        this.initProperty(S_IsDefaultKind, value);
    }

    public void setIsDefaultKind(String value) {
        this.set(S_IsDefaultKind, value);
    }

    public void setIsDefaultKindNull() {
        this.set(S_IsDefaultKind, null);
    }

    public String getIsDefaultKind() {
        return DataType.getAsString(this.get(S_IsDefaultKind));

    }

    public String getIsDefaultKindInitialValue() {
        return DataType.getAsString(this.getOldObj(S_IsDefaultKind));
    }

    public void initWareKindId(long value) {
        this.initProperty(S_WareKindId, Long.valueOf(value));
    }

    public void setWareKindId(long value) {
        this.set(S_WareKindId, Long.valueOf(value));
    }

    public void setWareKindIdNull() {
        this.set(S_WareKindId, null);
    }

    public long getWareKindId() {
        return DataType.getAsLong(this.get(S_WareKindId));

    }

    public long getWareKindIdInitialValue() {
        return DataType.getAsLong(this.getOldObj(S_WareKindId));
    }

    public long getId() {
        return getWareKindRltId();
    }

    public void setId(long id) {
        setWareKindRltId(id);
    }

}
