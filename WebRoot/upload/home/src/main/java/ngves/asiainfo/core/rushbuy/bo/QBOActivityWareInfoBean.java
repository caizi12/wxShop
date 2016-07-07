package ngves.asiainfo.core.rushbuy.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.rushbuy.ivalues.*;

public class QBOActivityWareInfoBean extends DataContainer implements
		DataContainerInterface, IQBOActivityWareInfoValue {

	private static final long serialVersionUID = -4332946063749955827L;

	private static String m_boName = "ngves.asiainfo.core.rushbuy.bo.QBOActivityWareInfo";

	public final static String S_WareStatus = "WARE_STATUS";
	public final static String S_WareName = "WARE_NAME";
	public final static String S_WareStorageType = "WARE_STORAGE_TYPE";
	public final static String S_WarehouseId = "WAREHOUSE_ID";
	public final static String S_WareCode = "WARE_CODE";
	public final static String S_ProvinceCode = "PROVINCE_CODE";
	public final static String S_WareId = "WARE_ID";
	public final static String S_DeliverType = "DELIVER_TYPE";
	public final static String S_Alias = "ALIAS";
	
	public final static String S_OriIntegral = "ORI_INTEGRAL";
	public final static String S_CurIntegral = "CUR_INTEGRAL";
	
	public final static String S_OriPayIntegral = "ORI_PAY_INTEGRAL";
	public final static String S_OriPayCash = "ORI_PAY_CASH";
	public final static String S_CurPayIntegral = "CUR_PAY_INTEGRAL";
	public final static String S_CurPayCash = "CUR_PAY_CASH";
	public final static String S_IsOnlinePay = "IS_ONLINE_PAY";
	public final static String S_IsOfflinePay = "IS_OFFLINE_PAY";
	public final static String S_WarePayType="WARE_PAY_TYPE";
	public final static String S_PayType="PAY_TYPE";
	public final static String S_PayDesc="PAY_DESC";
	public final static String S_PayTime="PAY_TIME";
	
	
	public static ObjectType S_TYPE = null;
	public final static String S_PackingList = "PACKING_LIST";
	public final static String S_SafeGuard = "SAFE_GUARD";
	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory()
					.getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public QBOActivityWareInfoBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initWareStatus(String value) {
		this.initProperty(S_WareStatus, value);
	}

	public void setWareStatus(String value) {
		this.set(S_WareStatus, value);
	}

	public void setWareStatusNull() {
		this.set(S_WareStatus, null);
	}

	public String getWareStatus() {
		return DataType.getAsString(this.get(S_WareStatus));

	}

	public String getWareStatusInitialValue() {
		return DataType.getAsString(this.getOldObj(S_WareStatus));
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

	public void initWareStorageType(String value) {
		this.initProperty(S_WareStorageType, value);
	}

	public void setWareStorageType(String value) {
		this.set(S_WareStorageType, value);
	}

	public void setWareStorageTypeNull() {
		this.set(S_WareStorageType, null);
	}

	public String getWareStorageType() {
		return DataType.getAsString(this.get(S_WareStorageType));

	}

	public String getWareStorageTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_WareStorageType));
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

	public void initWareCode(String value) {
		this.initProperty(S_WareCode, value);
	}

	public void setWareCode(String value) {
		this.set(S_WareCode, value);
	}

	public void setWareCodeNull() {
		this.set(S_WareCode, null);
	}

	public String getWareCode() {
		return DataType.getAsString(this.get(S_WareCode));

	}

	public String getWareCodeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_WareCode));
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

	public void initDeliverType(String value) {
		this.initProperty(S_DeliverType, value);
	}

	public void setDeliverType(String value) {
		this.set(S_DeliverType, value);
	}

	public void setDeliverTypeNull() {
		this.set(S_DeliverType, null);
	}

	public String getDeliverType() {
		return DataType.getAsString(this.get(S_DeliverType));

	}

	public String getDeliverTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_DeliverType));
	}

	public void initAlias(String value) {
		this.initProperty(S_Alias, value);
	}

	public void setAlias(String value) {
		this.set(S_Alias, value);
	}

	public void setAliasNull() {
		this.set(S_Alias, null);
	}

	public String getAlias() {
		return DataType.getAsString(this.get(S_Alias));
	}

	public String getAliasInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Alias));
	}

	public void initPackingList(String value) {
		this.initProperty(S_PackingList, value);
	}


	public void setPackingList(String value) {
		this.set(S_PackingList, value);
	}

	public void setPackingListNull() {
		this.set(S_PackingList, null);
	}

	public String getPackingList() {
		return DataType.getAsString(this.get(S_PackingList));

	}

	public String getPackingListInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PackingList));
	}
	
	public void initSafeGuard(String value) {
		this.initProperty(S_SafeGuard, value);
	}

	public void setSafeGuard(String value) {
		this.set(S_SafeGuard, value);
	}

	public void setSafeGuardNull() {
		this.set(S_SafeGuard, null);
	}

	public String getSafeGuard() {
		return DataType.getAsString(this.get(S_SafeGuard));

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

	public long getOrlPayCashInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_OriPayCash));
	}
	
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
	
	public void initIsOnlinePay(String value) {
		this.initProperty(S_IsOnlinePay, value);
	}

	public void setIsOnlinePay(String value) {
		this.set(S_IsOnlinePay, value);
	}

	public void setIsOnlinePayNull() {
		this.set(S_IsOnlinePay, null);
	}

	public String getIsOnlinePay() {
		return DataType.getAsString(this.get(S_IsOnlinePay));

	}

	public String getIsOnlinePayInitialValue() {
		return DataType.getAsString(this.getOldObj(S_IsOnlinePay));
	}
	
	public void initIsOfflinePay(String value) {
		this.initProperty(S_IsOfflinePay, value);
	}

	public void setIsOfflinePay(String value) {
		this.set(S_IsOfflinePay, value);
	}

	public void setIsOfflinePayNull() {
		this.set(S_IsOfflinePay, null);
	}

	public String getIsOfflinePay() {
		return DataType.getAsString(this.get(S_IsOfflinePay));

	}

	public String getIsOfflinePayInitialValue() {
		return DataType.getAsString(this.getOldObj(S_IsOfflinePay));
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
	
	public void initPayType(String value) {
		this.initProperty(S_PayType, value);
	}

	public void setPayType(String value) {
		this.set(S_PayType, value);
	}

	public void setPayTypeNull() {
		this.set(S_PayType, null);
	}

	public String getPayType() {
		return DataType.getAsString(this.get(S_PayType));

	}

	public String getPayTypeInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PayType));
	}
	
	public void initPayDesc(String value) {
		this.initProperty(S_PayDesc, value);
	}

	public void setPayDesc(String value) {
		this.set(S_PayDesc, value);
	}

	public void setPayDescNull() {
		this.set(S_PayDesc, null);
	}

	public String getPayDesc() {
		return DataType.getAsString(this.get(S_PayDesc));

	}

	public String getPayDescInitialValue() {
		return DataType.getAsString(this.getOldObj(S_PayDesc));
	}
	
	public void initPayTime(long value) {
		this.initProperty(S_PayTime, new Long(value));
	}

	public void setPayTime(long value) {
		this.set(S_PayTime, new Long(value));
	}

	public void setPayTimeNull() {
		this.set(S_PayTime, null);
	}

	public long getPayTime() {
		return DataType.getAsLong(this.get(S_PayTime));

	}

	public long getPayTimeInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_PayTime));
	}

}
