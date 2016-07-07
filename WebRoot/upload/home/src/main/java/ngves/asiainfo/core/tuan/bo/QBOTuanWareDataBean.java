package ngves.asiainfo.core.tuan.bo;

import ngves.asiainfo.core.tuan.ivalues.IQBOTuanWareDataValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class QBOTuanWareDataBean extends DataContainer implements DataContainerInterface, IQBOTuanWareDataValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6182122670234372478L;

	private static String m_boName = "ngves.asiainfo.core.tuan.bo.QBOTuanWareData";

	public final static String S_KindName = "KIND_NAME";
	public final static String S_TuanSort = "TUAN_SORT";
	public final static String S_TuanName = "TUAN_NAME";
	public final static String S_TuanDiscount = "TUAN_DISCOUNT";
	public final static String S_TuanItemCount = "TUAN_ITEM_COUNT";
	public final static String S_TuanMainPic = "TUAN_MAIN_PIC";
	public final static String S_TuanUrl = "TUAN_URL";
	public final static String S_WareName = "WARE_NAME";
	public final static String S_TitleDesc = "TITLE_DESC";
	public final static String S_FileName = "FILE_NAME";
	public final static String S_WareId = "WARE_ID";
	public final static String S_WareKindId = "WARE_KIND_ID";
	public final static String S_OriIntegral = "ORI_INTEGRAL";
	public final static String S_CurIntegral = "CUR_INTEGRAL";
	public final static String S_TuanId = "TUAN_ID";
	public final static String S_TopFlag = "TOP_FLAG";
	public static ObjectType S_TYPE = null;
	public final static String S_OriPayCash = "ORI_PAY_CASH";
	public final static String S_OriPayIntegral = "ORI_PAY_INTEGRAL";
	public final static String S_TuanPayType = "TUAN_PAY_TYPE";
	public final static String S_WarePayType = "WARE_PAY_TYPE";
	public final static String S_RltPayType = "RLT_PAY_TYPE";
	public final static String S_CurPayCash = "CUR_PAY_CASH";
	public final static String S_CurPayIntegral = "CUR_PAY_INTEGRAL";
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public QBOTuanWareDataBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initKindName(String value) {
		this.initProperty(S_KindName, value);
	}

	public void setKindName(String value) {
		this.set(S_KindName, value);
	}

	public void setKindNameNull() {
		this.set(S_KindName, null);
	}

	public String getKindName() {
		return DataType.getAsString(this.get(S_KindName));

	}

	public String getKindNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_KindName));
	}

	public void initTuanSort(long value) {
		this.initProperty(S_TuanSort, new Long(value));
	}

	public void setTuanSort(long value) {
		this.set(S_TuanSort, new Long(value));
	}

	public void setTuanSortNull() {
		this.set(S_TuanSort, null);
	}

	public long getTuanSort() {
		return DataType.getAsLong(this.get(S_TuanSort));

	}

	public long getTuanSortInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_TuanSort));
	}

	public void initTuanName(String value) {
		this.initProperty(S_TuanName, value);
	}

	public void setTuanName(String value) {
		this.set(S_TuanName, value);
	}

	public void setTuanNameNull() {
		this.set(S_TuanName, null);
	}

	public String getTuanName() {
		return DataType.getAsString(this.get(S_TuanName));

	}

	public String getTuanNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_TuanName));
	}

	public void initTuanDiscount(long value) {
		this.initProperty(S_TuanDiscount, new Long(value));
	}

	public void setTuanDiscount(long value) {
		this.set(S_TuanDiscount, new Long(value));
	}

	public void setTuanDiscountNull() {
		this.set(S_TuanDiscount, null);
	}

	public long getTuanDiscount() {
		return DataType.getAsLong(this.get(S_TuanDiscount));

	}

	public long getTuanDiscountInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_TuanDiscount));
	}

	public void initTuanItemCount(long value) {
		this.initProperty(S_TuanItemCount, new Long(value));
	}

	public void setTuanItemCount(long value) {
		this.set(S_TuanItemCount, new Long(value));
	}

	public void setTuanItemCountNull() {
		this.set(S_TuanItemCount, null);
	}

	public long getTuanItemCount() {
		return DataType.getAsLong(this.get(S_TuanItemCount));

	}

	public long getTuanItemCountInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_TuanItemCount));
	}

	public void initTuanMainPic(String value) {
		this.initProperty(S_TuanMainPic, value);
	}

	public void setTuanMainPic(String value) {
		this.set(S_TuanMainPic, value);
	}

	public void setTuanMainPicNull() {
		this.set(S_TuanMainPic, null);
	}

	public String getTuanMainPic() {
		return DataType.getAsString(this.get(S_TuanMainPic));

	}

	public String getTuanMainPicInitialValue() {
		return DataType.getAsString(this.getOldObj(S_TuanMainPic));
	}

	public void initTuanUrl(String value) {
		this.initProperty(S_TuanUrl, value);
	}

	public void setTuanUrl(String value) {
		this.set(S_TuanUrl, value);
	}

	public void setTuanUrlNull() {
		this.set(S_TuanUrl, null);
	}

	public String getTuanUrl() {
		return DataType.getAsString(this.get(S_TuanUrl));

	}

	public String getTuanUrlInitialValue() {
		return DataType.getAsString(this.getOldObj(S_TuanUrl));
	}

	public void initWareName(String value) {
		this.initProperty(S_WareName, value);
	}

	public void setWareName(String value) {
		this.set(S_WareName, value);
	}

	public void setWareNameNull() {
		this.set(S_WareName, null);
	}

	public String getWareName() {
		return DataType.getAsString(this.get(S_WareName));

	}

	public String getWareNameInitialValue() {
		return DataType.getAsString(this.getOldObj(S_WareName));
	}

	public void initTitleDesc(String value) {
		this.initProperty(S_TitleDesc, value);
	}

	public void setTitleDesc(String value) {
		this.set(S_TitleDesc, value);
	}

	public void setTitleDescNull() {
		this.set(S_TitleDesc, null);
	}

	public String getTitleDesc() {
		return DataType.getAsString(this.get(S_TitleDesc));

	}

	public String getTitleDescInitialValue() {
		return DataType.getAsString(this.getOldObj(S_TitleDesc));
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

	public void initWareId(long value) {
		this.initProperty(S_WareId, new Long(value));
	}

	public void setWareId(long value) {
		this.set(S_WareId, new Long(value));
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

	public void initWareKindId(long value) {
		this.initProperty(S_WareKindId, new Long(value));
	}

	public void setWareKindId(long value) {
		this.set(S_WareKindId, new Long(value));
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

	public void initOriIntegral(long value) {
		this.initProperty(S_OriIntegral, new Long(value));
	}

	public void setOriIntegral(long value) {
		this.set(S_OriIntegral, new Long(value));
	}

	public void setOriIntegralNull() {
		this.set(S_OriIntegral, null);
	}

	public long getOriIntegral() {
		return DataType.getAsLong(this.get(S_OriIntegral));

	}

	public long getOriIntegralInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_OriIntegral));
	}

	public void initCurIntegral(long value) {
		this.initProperty(S_CurIntegral, new Long(value));
	}

	public void setCurIntegral(long value) {
		this.set(S_CurIntegral, new Long(value));
	}

	public void setCurIntegralNull() {
		this.set(S_CurIntegral, null);
	}

	public long getCurIntegral() {
		return DataType.getAsLong(this.get(S_CurIntegral));

	}

	public long getCurIntegralInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_CurIntegral));
	}

	public void initTuanId(long value) {
		this.initProperty(S_TuanId, new Long(value));
	}

	public void setTuanId(long value) {
		this.set(S_TuanId, new Long(value));
	}

	public void setTuanIdNull() {
		this.set(S_TuanId, null);
	}

	public long getTuanId() {
		return DataType.getAsLong(this.get(S_TuanId));

	}

	public long getTuanIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_TuanId));
	}

	public void initTopFlag(long value) {
		this.initProperty(S_TopFlag, new Long(value));
	}

	public void setTopFlag(long value) {
		this.set(S_TopFlag, new Long(value));
	}

	public void setTopFlagNull() {
		this.set(S_TopFlag, null);
	}

	public long getTopFlag() {
		return DataType.getAsLong(this.get(S_TopFlag));

	}

	public long getTopFlagInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_TopFlag));
	}
	
	public void initOriPayCash(long value) {
		this.initProperty(S_OriPayCash, new Long(value));
	}

	public void setOriPayCash(long value) {
		this.set(S_OriPayCash, new Long(value));
	}

	public void setOriPayCashNull() {
		this.set(S_OriPayCash, null);
	}

	public long getOriPayCash() {
		return DataType.getAsLong(this.get(S_OriPayCash));

	}

	public long getOriPayCashInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_OriPayCash));
	}
	
	public void initOriPayIntegral(long value) {
		this.initProperty(S_OriPayIntegral, new Long(value));
	}

	public void setOriPayIntegral(long value) {
		this.set(S_OriPayIntegral, new Long(value));
	}

	public void setOriPayIntegralNull() {
		this.set(S_OriPayIntegral, null);
	}

	public long getOriPayIntegral() {
		return DataType.getAsLong(this.get(S_OriPayIntegral));

	}

	public long getOriPayIntegralInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_OriPayIntegral));
	}
	public void initTuanPayType(long value) {
		this.initProperty(S_OriPayIntegral, new Long(value));
	}

	public void initCurPayCash(long value) {
		this.initProperty(S_CurPayCash, new Long(value));
	}

	public void setCurPayCash(long value) {
		this.set(S_CurPayCash, new Long(value));
	}

	public void setCurPayCashNull() {
		this.set(S_CurPayCash, null);
	}

	public long getCurPayCash() {
		return DataType.getAsLong(this.get(S_CurPayCash));

	}

	public long getCurPayCashInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_CurPayCash));
	}
	//

	public void initCurPayIntegral(long value) {
		this.initProperty(S_CurPayIntegral, new Long(value));
	}

	public void setCurPayIntegral(long value) {
		this.set(S_CurPayIntegral, new Long(value));
	}

	public void setCurPayIntegralNull() {
		this.set(S_CurPayIntegral, null);
	}

	public long getCurPayIntegral() {
		return DataType.getAsLong(this.get(S_CurPayIntegral));

	}

	public long getCurPayIntegralInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_CurPayIntegral));
	}

	public void initWarePayType(String value) {
		this.initProperty(S_WarePayType, value);
	}

	public void setWarePayType(String value) {
		this.set(S_WarePayType, value);
	}

	public void setWarePayTypeNull() {
		this.set(S_WarePayType, null);
	}

	public String getWarePayType() {
		return DataType.getAsString(this.get(S_WarePayType));

	}

	public String getWarePayTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_WarePayType));
	}

	public void initTuanPayType(String value) {
		this.initProperty(S_TuanPayType, value);
	}

	public void setTuanPayType(String value) {
		this.set(S_TuanPayType, value);
	}

	public void setTuanPayTypeNull() {
		this.set(S_TuanPayType, null);
	}

	public String getTuanPayType() {
		return DataType.getAsString(this.get(S_TuanPayType));

	}

	public String getTuanPayTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_TuanPayType));
	}

	public void initRltPayType(String value) {
		this.initProperty(S_RltPayType, value);
	}

	public void setRltPayType(String value) {
		this.set(S_RltPayType, value);
	}

	public void setRltPayTypeNull() {
		this.set(S_RltPayType, null);
	}

	public String getRltPayType() {
		return DataType.getAsString(this.get(S_RltPayType));

	}

	public String getRltPayTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_RltPayType));
	}
}
