package ngves.asiainfo.core.order.ivalues;

import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;

public interface IBarCodeOrderFileValue extends DataStructInterface {

	public final static String S_BakCol = "BAK_COL";
	public final static String S_UserType = "USER_TYPE";
	public final static String S_OrderFileYear = "ORDER_FILE_YEAR";
	public final static String S_FileName = "FILE_NAME";
	public final static String S_SortNum = "SORT_NUM";
	public final static String S_CreateDate = "CREATE_DATE";
	public final static String S_BarcodeOrderFileId = "BARCODE_ORDER_FILE_ID";
	public final static String S_OrderFileSeason = "ORDER_FILE_SEASON";

	public String getBakCol();

	public String getUserType();

	public String getOrderFileYear();

	public String getFileName();

	public String getSortNum();

	public Timestamp getCreateDate();

	public long getBarcodeOrderFileId();

	public String getOrderFileSeason();

	public void setBakCol(String value);

	public void setUserType(String value);

	public void setOrderFileYear(String value);

	public void setFileName(String value);

	public void setSortNum(String value);

	public void setCreateDate(Timestamp value);

	public void setBarcodeOrderFileId(long value);

	public void setOrderFileSeason(String value);
}
