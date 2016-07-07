package ngves.asiainfo.core.ware.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.ware.ivalues.IQBOWareImageValue;

public class QBOWareImageBean extends DataContainer implements DataContainerInterface, IQBOWareImageValue {

	private static final long serialVersionUID = 1233L;
	private static String m_boName = "ngves.asiainfo.core.ware.bo.QBOWareImage";

	public final static String S_FileName = "FILE_NAME";
	public final static String S_IsMainPic = "IS_MAIN_PIC";

	public QBOWareImageBean() throws AIException {
		super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initFileName(String value) {
		this.initProperty(S_FileName, value);
	}

	public void setFileName(String value) {
		this.set(S_FileName, value);
	}

	public void setFileNameNull() {
		this.set(S_FileName, null);
	}

	public String getFileName() {
		return DataType.getAsString(this.get(S_FileName));

	}

	public String getFileNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_FileName));
	}

	public void initIsMainPic(String value) {
		this.initProperty(S_IsMainPic, value);
	}

	public void setIsMainPic(String value) {
		this.set(S_IsMainPic, value);
	}

	public void setIsMainPicNull() {
		this.set(S_IsMainPic, null);
	}

	public String getIsMainPic() {
		return DataType.getAsString(this.get(S_IsMainPic));

	}

	public String getIsMainPicInitialValue() {
		return DataType.getAsString(this.getOldObj(S_IsMainPic));
	}

}
