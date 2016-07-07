package ngves.asiainfo.core.system.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.system.ivalues.*;

public class NavigationInfoBean extends DataContainer implements DataContainerInterface, INavigationInfoValue {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7242947595896118186L;

	private static String m_boName = "ngves.asiainfo.core.system.bo.NavigationInfo";

    public final static String S_SortId = "SORT_ID";
    public final static String S_BakCol = "BAK_COL";
    public final static String S_BakCol2 = "BAK_COL2";
    public final static String S_NavId = "NAV_ID";
    public final static String S_NavDesc = "NAV_DESC";
    public final static String S_NavUri = "NAV_URI";

    public static ObjectType S_TYPE = null;
    static {
        try {
            S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public NavigationInfoBean() throws AIException {
        super(S_TYPE);
    }

    public static ObjectType getObjectTypeStatic() throws AIException {
        return S_TYPE;
    }

    public void setObjectType(ObjectType value) throws AIException {
        throw new AIException("此种数据容器不能重置业务对象类型");
    }

    public void initSortId(long value) {
        this.initProperty(S_SortId, new Long(value));
    }

    public void setSortId(long value) {
        this.set(S_SortId, new Long(value));
    }

    public void setSortIdNull() {
        this.set(S_SortId, null);
    }

    public long getSortId() {
        return DataType.getAsLong(this.get(S_SortId));

    }

    public long getSortIdInitialValue() {
        return DataType.getAsLong(this.getOldObj(S_SortId));
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

    public void initNavId(long value) {
        this.initProperty(S_NavId, new Long(value));
    }

    public void setNavId(long value) {
        this.set(S_NavId, new Long(value));
    }

    public void setNavIdNull() {
        this.set(S_NavId, null);
    }

    public long getNavId() {
        return DataType.getAsLong(this.get(S_NavId));

    }

    public long getNavIdInitialValue() {
        return DataType.getAsLong(this.getOldObj(S_NavId));
    }

    public void initNavDesc(String value) {
        this.initProperty(S_NavDesc, value);
    }

    public void setNavDesc(String value) {
        this.set(S_NavDesc, value);
    }

    public void setNavDescNull() {
        this.set(S_NavDesc, null);
    }

    public String getNavDesc() {
        return DataType.getAsString(this.get(S_NavDesc));

    }

    public String getNavDescInitialValue() {
        return DataType.getAsString(this.getOldObj(S_NavDesc));
    }

    public void initNavUri(String value) {
        this.initProperty(S_NavUri, value);
    }

    public void setNavUri(String value) {
        this.set(S_NavUri, value);
    }

    public void setNavUriNull() {
        this.set(S_NavUri, null);
    }

    public String getNavUri() {
        return DataType.getAsString(this.get(S_NavUri));

    }

    public String getNavUriInitialValue() {
        return DataType.getAsString(this.getOldObj(S_NavUri));
    }

}
