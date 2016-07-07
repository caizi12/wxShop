package ngves.asiainfo.core.common.bo;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import ngves.asiainfo.core.common.ivalues.*;

public class QBORecommCategoryWareInfoBean extends DataContainer implements DataContainerInterface,
		IQBORecommCategoryWareInfoValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7480097662106846014L;

	private static String m_boName = "ngves.asiainfo.core.common.bo.QBORecommCategoryWareInfo";

	public final static String S_MCurValue = "M_CUR_VALUE";
	public final static String S_DeliverType = "DELIVER_TYPE";
	public final static String S_SortId = "SORT_ID";
	public final static String S_GOriValue = "G_ORI_VALUE";
	public final static String S_TopFlag = "TOP_FLAG";
	public final static String S_WareName = "WARE_NAME";
	public final static String S_WareId = "WARE_ID";
	public final static String S_MOriValue = "M_ORI_VALUE";
	public final static String S_FuncDesc = "FUNC_DESC";
	public final static String S_GCurValue = "G_CUR_VALUE";
	public final static String S_MainPicFile = "MAIN_PIC_FILE";
	public final static String S_CategoryId = "CATEGORY_ID";
	public final static String S_WareCode = "WARE_CODE";
	public final static  String S_Alias = "ALIAS";

	
	//添加神州行现积分和统一积分
	public final static String S_WareIntegralValue = "WARE_INTEGRAL_VALUE";
	public final static String S_ECurValue = "E_CUR_VALUE";

	// 团购支持搜索功能，添加兑换方式和活动ID at 2012-11-14 沈福利
	public final static String S_ExchangeMode = "EXCHANGE_MODE";
	public final static String S_ExchangeId = "EXCHANGE_ID";
	//混合支付需求新增字段
	public final static String S_PayType = "PAY_TYPE";
	public final static String S_OriPayCash = "ORI_PAY_CASH";
	public final static String S_OriPayIntegral = "ORI_PAY_INTEGRAL";
	public final static String S_CurPayCash = "CUR_PAY_CASH";
	public final static String S_CurPayIntegral = "CUR_PAY_INTEGRAL";
	public final static String S_Sale = "SALE";
	public static ObjectType   S_TYPE = null;

	static {
		try {
			S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public QBORecommCategoryWareInfoBean() throws AIException {
		super(S_TYPE);
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return S_TYPE;
	}

	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initMCurValue(long value) {
		this.initProperty(S_MCurValue, new Long(value));
	}

	public void setMCurValue(long value) {
		this.set(S_MCurValue, new Long(value));
	}

	public void setMCurValueNull() {
		this.set(S_MCurValue, null);
	}

	public long getMCurValue() {
		return DataType.getAsLong(this.get(S_MCurValue));

	}

	public long getMCurValueInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_MCurValue));
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

	public void initGOriValue(long value) {
		this.initProperty(S_GOriValue, new Long(value));
	}

	public void setGOriValue(long value) {
		this.set(S_GOriValue, new Long(value));
	}

	public void setGOriValueNull() {
		this.set(S_GOriValue, null);
	}

	public long getGOriValue() {
		return DataType.getAsLong(this.get(S_GOriValue));

	}

	public long getGOriValueInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_GOriValue));
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

	public void initMOriValue(long value) {
		this.initProperty(S_MOriValue, new Long(value));
	}

	public void setMOriValue(long value) {
		this.set(S_MOriValue, new Long(value));
	}

	public void setMOriValueNull() {
		this.set(S_MOriValue, null);
	}

	public long getMOriValue() {
		return DataType.getAsLong(this.get(S_MOriValue));

	}

	public long getMOriValueInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_MOriValue));
	}

	public void initFuncDesc(String value) {
		this.initProperty(S_FuncDesc, value);
	}

	public void setFuncDesc(String value) {
		this.set(S_FuncDesc, value);
	}

	public void setFuncDescNull() {
		this.set(S_FuncDesc, null);
	}

	public String getFuncDesc() {
		return DataType.getAsString(this.get(S_FuncDesc));

	}

	public String getFuncDescInitialValue() {
		return DataType.getAsString(this.getOldObj(S_FuncDesc));
	}

	public void initGCurValue(long value) {
		this.initProperty(S_GCurValue, new Long(value));
	}

	public void setGCurValue(long value) {
		this.set(S_GCurValue, new Long(value));
	}

	public void setGCurValueNull() {
		this.set(S_GCurValue, null);
	}

	public long getGCurValue() {
		return DataType.getAsLong(this.get(S_GCurValue));

	}

	public long getGCurValueInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_GCurValue));
	}

	public void initMainPicFile(String value) {
		this.initProperty(S_MainPicFile, value);
	}

	public void setMainPicFile(String value) {
		this.set(S_MainPicFile, value);
	}

	public void setMainPicFileNull() {
		this.set(S_MainPicFile, null);
	}

	public String getMainPicFile() {
		return DataType.getAsString(this.get(S_MainPicFile));

	}

	public String getMainPicFileInitialValue() {
		return DataType.getAsString(this.getOldObj(S_MainPicFile));
	}

	public void initCategoryId(long value) {
		this.initProperty(S_CategoryId, new Long(value));
	}

	public void setCategoryId(long value) {
		this.set(S_CategoryId, new Long(value));
	}

	public void setCategoryIdNull() {
		this.set(S_CategoryId, null);
	}

	public long getCategoryId() {
		return DataType.getAsLong(this.get(S_CategoryId));

	}

	public long getCategoryIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_CategoryId));
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
	
	 public void initAlias(String value){
	     this.initProperty(S_Alias,value);
	}
	public  void setAlias(String value){
	  this.set(S_Alias,value);
	}
	public  void setAliasNull(){
	  this.set(S_Alias,null);
	}
	
	public String getAlias(){
	    return DataType.getAsString(this.get(S_Alias));
	}
	public String getAliasInitialValue(){
	     return DataType.getAsString(this.getOldObj(S_Alias));
	}
	
	

	public void initWareIntegralValue(long value) {
		this.initProperty(S_WareIntegralValue, new Long(value));
	}

	public void setWareIntegralValue(long value) {
		this.set(S_WareIntegralValue, new Long(value));
	}

	public void setWareIntegralValueNull() {
		this.set(S_WareIntegralValue, null);
	}

	public long getWareIntegralValue() {
		return DataType.getAsLong(this.get(S_WareIntegralValue));

	}

	public long getWareIntegralValueInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_WareIntegralValue));
	}
	
	public void initECurValue(long value) {
		this.initProperty(S_ECurValue, new Long(value));
	}

	public void setECurValue(long value) {
		this.set(S_ECurValue, new Long(value));
	}

	public void setECurValueNull() {
		this.set(S_ECurValue, null);
	}

	public long getECurValue() {
		return DataType.getAsLong(this.get(S_ECurValue));

	}

	public long getECurValueInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_ECurValue));
	}
     
	
	public void initExchangeId(long value) {
		this.initProperty(S_ExchangeId, new Long(value));
	}
	public void setExchangeId(long value) {
		this.set(S_ExchangeId, new Long(value));
	}
	public void setExchangeIdNull() {
		this.set(S_ExchangeId, null);
	}
	public long getExchangeId() {
		return DataType.getAsLong(this.get(S_ExchangeId));

	}
	public long getExchangeIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_ExchangeId));
	}
	
	public void initExchangeMode(String value) {
		this.initProperty(S_ExchangeMode, new String(value));
	}

	public void setExchangeMode(String value) {
		this.set(S_ExchangeMode, new String(value));
	}

	public String getExchangeMode() {
		return DataType.getAsString(this.get(S_ExchangeMode));
	}

	public void setExchangeModeNull() {
		this.set(S_ExchangeMode, null);
	}

	public String getExchangeModeInitValue() {
		return DataType.getAsString(this.getOldObj(S_ExchangeMode));
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
	
	public void initSale(String value) {
		this.initProperty(S_Sale, value);
	}
	public void setSale(String value) {
		this.set(S_Sale, value);
	}
	public void setSaleNull() {
		this.set(S_Sale, null);
	}
	public String getSale() {
		return DataType.getAsString(this.get(S_Sale));
	}
	public String getSaleInitialValue() {
		return DataType.getAsString(this.getOldObj(S_Sale));
	}
	
}
