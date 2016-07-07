package ngves.asiainfo.core.sendverifycode.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.sendverifycode.ivalues.*;

public class QBOStaffOrgRelatNameBean extends DataContainer implements
		DataContainerInterface, IQBOStaffOrgRelatNameValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String m_boName = "ngves.asiainfo.core.sendverifycode.bo.QBOStaffOrgRelatName";

	public final static String S_FkOrgName = "FK_ORG_NAME";
	public final static String S_OrganizeId = "ORGANIZE_ID";

	public static ObjectType S_TYPE = null;
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory()
					.getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public QBOStaffOrgRelatNameBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException(
				"The data container cannot reset the business object type!");
	}

	public void initFkOrgName(String value) {
		this.initProperty(S_FkOrgName, value);
	}

	public void setFkOrgName(String value) {
		this.set(S_FkOrgName, value);
	}

	public void setFkOrgNameNull() {
		this.set(S_FkOrgName, null);
	}

	public String getFkOrgName() {
		return DataType.getAsString(this.get(S_FkOrgName));

	}

	public String getFkOrgNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_FkOrgName));
	}

	public void initOrganizeId(long value) {
		this.initProperty(S_OrganizeId, new Long(value));
	}

	public void setOrganizeId(long value) {
		this.set(S_OrganizeId, new Long(value));
	}

	public void setOrganizeIdNull() {
		this.set(S_OrganizeId, null);
	}

	public long getOrganizeId() {
		return DataType.getAsLong(this.get(S_OrganizeId));

	}

	public long getOrganizeIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_OrganizeId));
	}

}
