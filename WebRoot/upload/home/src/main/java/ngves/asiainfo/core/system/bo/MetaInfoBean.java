package ngves.asiainfo.core.system.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.system.ivalues.*;

public class MetaInfoBean extends DataContainer implements DataContainerInterface, IMetaInfoValue {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6760797891405046075L;

	private static String m_boName = "ngves.asiainfo.core.system.bo.MetaInfo";

    public final static String S_BakCol = "BAK_COL";
    public final static String S_MetaId = "META_ID";
    public final static String S_BakCol2 = "BAK_COL2";
    public final static String S_MetaDesc = "META_DESC";

    public static ObjectType S_TYPE = null;
    static {
        try {
            S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public MetaInfoBean() throws AIException {
        super(S_TYPE);
    }

    public static ObjectType getObjectTypeStatic() throws AIException {
        return S_TYPE;
    }

    public void setObjectType(ObjectType value) throws AIException {
        throw new AIException("此种数据容器不能重置业务对象类型");
    }

    public void initBakCol(String value) {
        this.initProperty(S_BakCol, value);
    }

    public void setBakCol(String value) {
        this.set(S_BakCol, value);
    }

    public void setBakColNull() {
        this.set(S_BakCol, null);
    }

    public String getBakCol() {
        return DataType.getAsString(this.get(S_BakCol));

    }

    public String getBakColInitialValue() {
        return DataType.getAsString(this.getOldObj(S_BakCol));
    }

    public void initMetaId(long value) {
        this.initProperty(S_MetaId, new Long(value));
    }

    public void setMetaId(long value) {
        this.set(S_MetaId, new Long(value));
    }

    public void setMetaIdNull() {
        this.set(S_MetaId, null);
    }

    public long getMetaId() {
        return DataType.getAsLong(this.get(S_MetaId));

    }

    public long getMetaIdInitialValue() {
        return DataType.getAsLong(this.getOldObj(S_MetaId));
    }

    public void initBakCol2(String value) {
        this.initProperty(S_BakCol2, value);
    }

    public void setBakCol2(String value) {
        this.set(S_BakCol2, value);
    }

    public void setBakCol2Null() {
        this.set(S_BakCol2, null);
    }

    public String getBakCol2() {
        return DataType.getAsString(this.get(S_BakCol2));

    }

    public String getBakCol2InitialValue() {
        return DataType.getAsString(this.getOldObj(S_BakCol2));
    }

    public void initMetaDesc(String value) {
        this.initProperty(S_MetaDesc, value);
    }

    public void setMetaDesc(String value) {
        this.set(S_MetaDesc, value);
    }

    public void setMetaDescNull() {
        this.set(S_MetaDesc, null);
    }

    public String getMetaDesc() {
        return DataType.getAsString(this.get(S_MetaDesc));

    }

    public String getMetaDescInitialValue() {
        return DataType.getAsString(this.getOldObj(S_MetaDesc));
    }

}
