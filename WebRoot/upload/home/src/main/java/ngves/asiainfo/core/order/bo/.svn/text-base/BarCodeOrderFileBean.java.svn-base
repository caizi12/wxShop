package ngves.asiainfo.core.order.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.order.ivalues.IBarCodeOrderFileValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class BarCodeOrderFileBean extends DataContainer implements DataContainerInterface, IBarCodeOrderFileValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3088204029113324377L;

	private static String m_boName = "ngves.asiainfo.core.order.bo.BarCodeOrderFile";

	public final static String S_BakCol = "BAK_COL";
	public final static String S_UserType = "USER_TYPE";
	public final static String S_OrderFileYear = "ORDER_FILE_YEAR";
	public final static String S_FileName = "FILE_NAME";
	public final static String S_SortNum = "SORT_NUM";
	public final static String S_CreateDate = "CREATE_DATE";
	public final static String S_BarcodeOrderFileId = "BARCODE_ORDER_FILE_ID";
	public final static String S_OrderFileSeason = "ORDER_FILE_SEASON";

	public BarCodeOrderFileBean() throws AIException {
		super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
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

	public void initUserType(String value) {
		this.initProperty(S_UserType, value);
	}

	public void setUserType(String value) {
		this.set(S_UserType, value);
	}

	public void setUserTypeNull() {
		this.set(S_UserType, null);
	}

	public String getUserType() {
		return DataType.getAsString(this.get(S_UserType));

	}

	public String getUserTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_UserType));
	}

	public void initOrderFileYear(String value) {
		this.initProperty(S_OrderFileYear, value);
	}

	public void setOrderFileYear(String value) {
		this.set(S_OrderFileYear, value);
	}

	public void setOrderFileYearNull() {
		this.set(S_OrderFileYear, null);
	}

	public String getOrderFileYear() {
		return DataType.getAsString(this.get(S_OrderFileYear));

	}

	public String getOrderFileYearInitialValue() {
		return DataType.getAsString(this.getOldObj(S_OrderFileYear));
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

	public void initSortNum(String value) {
		this.initProperty(S_SortNum, value);
	}

	public void setSortNum(String value) {
		this.set(S_SortNum, value);
	}

	public void setSortNumNull() {
		this.set(S_SortNum, null);
	}

	public String getSortNum() {
		return DataType.getAsString(this.get(S_SortNum));

	}

	public String getSortNumInitialValue() {
		return DataType.getAsString(this.getOldObj(S_SortNum));
	}

	public void initCreateDate(Timestamp value) {
		this.initProperty(S_CreateDate, value);
	}

	public void setCreateDate(Timestamp value) {
		this.set(S_CreateDate, value);
	}

	public void setCreateDateNull() {
		this.set(S_CreateDate, null);
	}

	public Timestamp getCreateDate() {
		return DataType.getAsDateTime(this.get(S_CreateDate));

	}

	public Timestamp getCreateDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_CreateDate));
	}

	public void initBarcodeOrderFileId(long value) {
		this.initProperty(S_BarcodeOrderFileId, new Long(value));
	}

	public void setBarcodeOrderFileId(long value) {
		this.set(S_BarcodeOrderFileId, new Long(value));
	}

	public void setBarcodeOrderFileIdNull() {
		this.set(S_BarcodeOrderFileId, null);
	}

	public long getBarcodeOrderFileId() {
		return DataType.getAsLong(this.get(S_BarcodeOrderFileId));

	}

	public long getBarcodeOrderFileIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_BarcodeOrderFileId));
	}

	public void initOrderFileSeason(String value) {
		this.initProperty(S_OrderFileSeason, value);
	}

	public void setOrderFileSeason(String value) {
		this.set(S_OrderFileSeason, value);
	}

	public void setOrderFileSeasonNull() {
		this.set(S_OrderFileSeason, null);
	}

	public String getOrderFileSeason() {
		return DataType.getAsString(this.get(S_OrderFileSeason));

	}

	public String getOrderFileSeasonInitialValue() {
		return DataType.getAsString(this.getOldObj(S_OrderFileSeason));
	}

}
