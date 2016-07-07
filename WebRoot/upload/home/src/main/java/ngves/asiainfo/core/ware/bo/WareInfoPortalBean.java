package ngves.asiainfo.core.ware.bo;

import java.sql.Timestamp;

import ngves.asiainfo.core.ware.ivalues.IWareInfoPortalValue;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;

public class WareInfoPortalBean extends DataContainer implements DataContainerInterface, IWareInfoPortalValue {

	private static final long serialVersionUID = -1446234075749800563L;

	private static String m_boName = "ngves.asiainfo.core.ware.bo.WareInfoPortal";

	public final static String S_WareBrandId = "WARE_BRAND_ID";
	public final static String S_OpenDate = "OPEN_DATE";
	public final static String S_WareStorageType = "WARE_STORAGE_TYPE";
	public final static String S_WarehouseId = "WAREHOUSE_ID";
	public final static String S_BakCol1 = "BAK_COL1";
	public final static String S_Discount = "DISCOUNT";
	public final static String S_IsHtmlChannel = "IS_HTML_CHANNEL";
	public final static String S_SearchHot = "SEARCH_HOT";
	public final static String S_MainPicFile = "MAIN_PIC_FILE";
	public final static String S_MarketPrice = "MARKET_PRICE";
	public final static String S_WareCode = "WARE_CODE";
	public final static String S_WareId = "WARE_ID";
	public final static String S_DeliverType = "DELIVER_TYPE";
	public final static String S_WareStatus = "WARE_STATUS";
	public final static String S_StatusCause = "STATUS_CAUSE";
	public final static String S_CommentCount = "COMMENT_COUNT";
	public final static String S_SaleAmount = "SALE_AMOUNT";
	public final static String S_FuncDesc = "FUNC_DESC";
	public final static String S_WareName = "WARE_NAME";
	public final static String S_BakCol2 = "BAK_COL2";
	public final static String S_ProvinceCode = "PROVINCE_CODE";
	public final static String S_BakCol3 = "BAK_COL3";
	public final static String S_IsWapChannel = "IS_WAP_CHANNEL";
	public final static String S_IsClientChannel = "IS_CLIENT_CHANNEL";
	public final static String S_IsMobileChannel = "IS_MOBILE_CHANNEL";
	public final static String S_ShopPrice = "SHOP_PRICE";
	public final static String S_CommentValue = "COMMENT_VALUE";
	public final static String S_Alias = "ALIAS";
	public final static String S_KeyWords = "KEYWORDS";
	//新增两个字段  清单和售后保障
	public final static String S_PackingList = "PACKING_LIST";
	public final static String S_SafeGuard = "SAFE_GUARD";
	//新增一个字段  映射编码
	public final static String S_MappingCode = "MAPPING_CODE";
	
	// 添加统一积分 神州行字段
	public final static String S_WareIntegralValue = "WARE_INTEGRAL_VALUE";
	// 添加自有业务转赠字段
	public final static String S_ISALLOWDONATION = "IS_ALLOW_DONATION";

	// 添加is_rearch，用于前台搜索判断 AT 2011-07-13
	public final static String S_IsSearch = "IS_SEARCH";
	public final static String S_IsExchangePermission = "IS_EXCHANGE_PERMISSION";// ;is_exchange_permission
	// 添加wareType
	public final static String S_WareType = "WARE_TYPE";

	// 团购支持搜索功能，添加兑换方式和活动ID at 2012-11-14 沈福利
	public final static String S_ExchangeMode = "EXCHANGE_MODE";
	public final static String S_ExchangeId = "EXCHANGE_ID";
	
	
	
	//混合支付
    public final static String S_PayType = "PAY_TYPE";
	public final static String S_OriPayIntegral = "ORI_PAY_INTEGRAL";
	public final static String S_OriPayCash = "ORI_PAY_CASH";
	public final static String S_IsOnlinePay = "IS_ONLINE_PAY";
	public final static String S_IsOfflinePay = "IS_OFFLINE_PAY";
	public final static String S_OfflineDesc = "OFFLINE_DESC";
	public final static String S_Sale = "SALE";
	
	public void initPayType(String value){
		this.initProperty(S_PayType, value);
	}
	public void setPayType(String value){
		this.set(S_PayType, value);
	}
	public void setPayTypeNull(){
		this.set(S_PayType, null);
	}
    public String getPayType(){
    	return DataType.getAsString(this.get(S_PayType));
    }
    public String getPayTypeInitialValue(){
    	return DataType.getAsString(this.getOldObj(S_PayType));
    }
    
    public void initSale(String value){
        this.initProperty(S_Sale, value);
    }
    public void setSale(String value){
        this.set(S_Sale, value);
    }
    public void setSaleNull(){
        this.set(S_Sale, null);
    }
    public String getSale(){
        return DataType.getAsString(this.get(S_Sale));
    }
    public String getSaleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Sale));
    }
    
    public void initOriPayIntegral(long value){
    	this.initProperty(S_OriPayIntegral, new Long(value));
    }
    public void setOriPayIntegral(long value){
    	this.set(S_OriPayIntegral, new Long(value));
    }
    public void setOriPayIntegralNull(){
    	this.set(S_OriPayIntegral, null);
    }
    public long getOriPayIntegral(){
    	return DataType.getAsLong(this.get(S_OriPayIntegral));
    }
    public long getOriPayIntegralInitialValue(){
    	return DataType.getAsLong(this.getOldObj(S_OriPayIntegral));
    }
    
    public void initOriPayCash(long value){
    	this.initProperty(S_OriPayCash, new Long(value));
    }
    public void setOriPayCash(long value){
    	this.set(S_OriPayCash, new Long(value));
    }
    public void setOriPayCashNull(){
    	this.set(S_OriPayCash, null);
    }
    public long getOriPayCash(){
    	return DataType.getAsLong(this.get(S_OriPayCash));
    }
    public long getOriPayCashInitialValue(){
    	return DataType.getAsLong(this.getOldObj(S_OriPayCash));
    }
    
    
    public void initIsOnlinePay(String value){
    	this.initProperty(S_IsOnlinePay, value);
    }
    public void setIsOnlinePay(String value){
    	this.set(S_IsOnlinePay, value);
    }
    public void setIsOnlinePayNull(){
    	this.set(S_IsOnlinePay, null);
    }
    public String getIsOnlinePay(){
    	return DataType.getAsString(this.get(S_IsOnlinePay));
    }
    public String getIsOnlinePayInitialValue(){
    	return DataType.getAsString(this.getOldObj(S_IsOnlinePay));
    }
    
    
    public void initIsOfflinePay(String value){
    	this.initProperty(S_IsOfflinePay, value);
    }
    public void setIsOfflinePay(String value){
    	this.set(S_IsOfflinePay, value);
    }
    public void setIsOfflinePayNull(){
    	this.set(S_IsOfflinePay, null);
    }
    public String getIsOfflinePay(){
    	return DataType.getAsString(this.get(S_IsOfflinePay));
    }
    public String getIsOfflinePayInitialValue(){
    	return DataType.getAsString(this.getOldObj(S_IsOfflinePay));
    }
    
    public void initOfflineDesc(String value){
    	this.initProperty(S_OfflineDesc, value);
    }
    public void setOfflineDesc(String value){
    	this.set(S_OfflineDesc, value);
    }
    public void setOfflineDescNull(){
    	this.set(S_OfflineDesc, null);
    }
    public String getOfflineDesc(){
    	return DataType.getAsString(this.get(S_OfflineDesc));
    }
    public String getOfflineDescInitialValue(){
    	return DataType.getAsString(this.getOldObj(S_OfflineDesc));
    }
	
	
	
	
	
	
	public void initWareType(long value) {
		this.initProperty(S_WareType, new Long(value));
	}

	public void setWareType(long value) {
		this.set(S_WareType, new Long(value));
	}

	public void setWareTypeNull() {
		this.set(S_WareType, null);
	}

	public long getWareType() {
		return DataType.getAsLong(this.get(S_WareType));

	}

	public long getWareTypeInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_WareType));
	}

	public void initIsExchangePermission(String value) {
		this.initProperty(S_IsExchangePermission, value);
	}

	public void setIsExchangePermission(String value) {
		this.set(S_IsExchangePermission, value);
	}

	public void setIsExchangePermissionNull() {
		this.set(S_IsExchangePermission, null);
	}

	public String getIsExchangePermission() {
		return DataType.getAsString(this.get(S_IsExchangePermission));

	}

	public String getIsExchangePermissionInitialValue() {
		return DataType.getAsString(this.getOldObj(S_IsExchangePermission));
	}

	public void initIsSearch(String value) {
		this.initProperty(S_IsSearch, value);
	}

	public void setIsSearch(String value) {
		this.set(S_IsSearch, value);
	}

	public void setIsSearchNull() {
		this.set(S_IsSearch, null);
	}

	public String getIsSearch() {
		return DataType.getAsString(this.get(S_IsSearch));

	}

	public String getIsSearchInitialValue() {
		return DataType.getAsString(this.getOldObj(S_IsSearch));
	}

	public WareInfoPortalBean() throws AIException {
		super(ServiceManager.getObjectTypeFactory().getInstance(m_boName));
	}

	public static ObjectType getObjectTypeStatic() throws AIException {
		return ServiceManager.getObjectTypeFactory().getInstance(m_boName);
	}

	@Override
	public void setObjectType(ObjectType value) throws AIException {
		throw new AIException("此种数据容器不能重置业务对象类型");
	}

	public void initWareBrandId(long value) {
		this.initProperty(S_WareBrandId, new Long(value));
	}

	public void setWareBrandId(long value) {
		this.set(S_WareBrandId, new Long(value));
	}

	public void setWareBrandIdNull() {
		this.set(S_WareBrandId, null);
	}

	public long getWareBrandId() {
		return DataType.getAsLong(this.get(S_WareBrandId));

	}

	public long getWareBrandIdInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_WareBrandId));
	}

	public void initOpenDate(Timestamp value) {
		this.initProperty(S_OpenDate, value);
	}

	public void setOpenDate(Timestamp value) {
		this.set(S_OpenDate, value);
	}

	public void setOpenDateNull() {
		this.set(S_OpenDate, null);
	}

	public Timestamp getOpenDate() {
		return DataType.getAsDateTime(this.get(S_OpenDate));

	}

	public Timestamp getOpenDateInitialValue() {
		return DataType.getAsDateTime(this.getOldObj(S_OpenDate));
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

	public void initBakCol1(String value) {
		this.initProperty(S_BakCol1, value);
	}

	public void setBakCol1(String value) {
		this.set(S_BakCol1, value);
	}

	public void setBakCol1Null() {
		this.set(S_BakCol1, null);
	}

	public String getBakCol1() {
		return DataType.getAsString(this.get(S_BakCol1));

	}

	public String getBakCol1InitialValue() {
		return DataType.getAsString(this.getOldObj(S_BakCol1));
	}

	public void initDiscount(float value) {
		this.initProperty(S_Discount, new Float(value));
	}

	public void setDiscount(float value) {
		this.set(S_Discount, new Float(value));
	}

	public void setDiscountNull() {
		this.set(S_Discount, null);
	}

	public float getDiscount() {
		return DataType.getAsFloat(this.get(S_Discount));

	}

	public float getDiscountInitialValue() {
		return DataType.getAsFloat(this.getOldObj(S_Discount));
	}

	public void initIsHtmlChannel(String value) {
		this.initProperty(S_IsHtmlChannel, value);
	}

	public void setIsHtmlChannel(String value) {
		this.set(S_IsHtmlChannel, value);
	}

	public void setIsHtmlChannelNull() {
		this.set(S_IsHtmlChannel, null);
	}

	public String getIsHtmlChannel() {
		return DataType.getAsString(this.get(S_IsHtmlChannel));

	}

	public String getIsHtmlChannelInitialValue() {
		return DataType.getAsString(this.getOldObj(S_IsHtmlChannel));
	}

	public void initSearchHot(String value) {
		this.initProperty(S_SearchHot, value);
	}

	public void setSearchHot(String value) {
		this.set(S_SearchHot, value);
	}

	public void setSearchHotNull() {
		this.set(S_SearchHot, null);
	}

	public String getSearchHot() {
		return DataType.getAsString(this.get(S_SearchHot));

	}

	public String getSearchHotInitialValue() {
		return DataType.getAsString(this.getOldObj(S_SearchHot));
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

	public void initMarketPrice(long value) {
		this.initProperty(S_MarketPrice, new Long(value));
	}

	public void setMarketPrice(long value) {
		this.set(S_MarketPrice, new Long(value));
	}

	public void setMarketPriceNull() {
		this.set(S_MarketPrice, null);
	}

	public long getMarketPrice() {
		return DataType.getAsLong(this.get(S_MarketPrice));

	}

	public long getMarketPriceInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_MarketPrice));
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

	public void initStatusCause(String value) {
		this.initProperty(S_StatusCause, value);
	}

	public void setStatusCause(String value) {
		this.set(S_StatusCause, value);
	}

	public void setStatusCauseNull() {
		this.set(S_StatusCause, null);
	}

	public String getStatusCause() {
		return DataType.getAsString(this.get(S_StatusCause));

	}

	public String getStatusCauseInitialValue() {
		return DataType.getAsString(this.getOldObj(S_StatusCause));
	}

	public void initCommentCount(long value) {
		this.initProperty(S_CommentCount, new Long(value));
	}

	public void setCommentCount(long value) {
		this.set(S_CommentCount, new Long(value));
	}

	public void setCommentCountNull() {
		this.set(S_CommentCount, null);
	}

	public long getCommentCount() {
		return DataType.getAsLong(this.get(S_CommentCount));

	}

	public long getCommentCountInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_CommentCount));
	}

	public void initSaleAmount(long value) {
		this.initProperty(S_SaleAmount, new Long(value));
	}

	public void setSaleAmount(long value) {
		this.set(S_SaleAmount, new Long(value));
	}

	public void setSaleAmountNull() {
		this.set(S_SaleAmount, null);
	}

	public long getSaleAmount() {
		return DataType.getAsLong(this.get(S_SaleAmount));

	}

	public long getSaleAmountInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_SaleAmount));
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

	public void initBakCol3(String value) {
		this.initProperty(S_BakCol3, value);
	}

	public void setBakCol3(String value) {
		this.set(S_BakCol3, value);
	}

	public void setBakCol3Null() {
		this.set(S_BakCol3, null);
	}

	public String getBakCol3() {
		return DataType.getAsString(this.get(S_BakCol3));

	}

	public String getBakCol3InitialValue() {
		return DataType.getAsString(this.getOldObj(S_BakCol3));
	}

	public void initIsWapChannel(String value) {
		this.initProperty(S_IsWapChannel, value);
	}

	public void setIsWapChannel(String value) {
		this.set(S_IsWapChannel, value);
	}

	public void setIsWapChannelNull() {
		this.set(S_IsWapChannel, null);
	}

	public String getIsWapChannel() {
		return DataType.getAsString(this.get(S_IsWapChannel));

	}

	public String getIsWapChannelInitialValue() {
		return DataType.getAsString(this.getOldObj(S_IsWapChannel));
	}
	
	public void initIsClientChannel(String value) {
        this.initProperty(S_IsClientChannel, value);
    }

    public void setIsClientChannel(String value) {
        this.set(S_IsClientChannel, value);
    }

    public void setIsClientChannelNull() {
        this.set(S_IsClientChannel, null);
    }

    public String getIsClientChannel() {
        return DataType.getAsString(this.get(S_IsClientChannel));

    }

    public String getIsClientChannelInitialValue() {
        return DataType.getAsString(this.getOldObj(S_IsClientChannel));
    }
    
    public void initIsMobileChannel(String value) {
        this.initProperty(S_IsMobileChannel, value);
    }

    public void setIsMobileChannel(String value) {
        this.set(S_IsMobileChannel, value);
    }

    public void setIsMobileChannelNull() {
        this.set(S_IsMobileChannel, null);
    }

    public String getIsMobileChannel() {
        return DataType.getAsString(this.get(S_IsMobileChannel));

    }

    public String getIsMobileChannelInitialValue() {
        return DataType.getAsString(this.getOldObj(S_IsMobileChannel));
    }

	public void initShopPrice(long value) {
		this.initProperty(S_ShopPrice, new Long(value));
	}

	public void setShopPrice(long value) {
		this.set(S_ShopPrice, new Long(value));
	}

	public void setShopPriceNull() {
		this.set(S_ShopPrice, null);
	}

	public long getShopPrice() {
		return DataType.getAsLong(this.get(S_ShopPrice));

	}

	public long getShopPriceInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_ShopPrice));
	}

	public void initCommentValue(long value) {
		this.initProperty(S_CommentValue, new Long(value));
	}

	public void setCommentValue(long value) {
		this.set(S_CommentValue, new Long(value));
	}

	public void setCommentValueNull() {
		this.set(S_CommentValue, null);
	}

	public long getCommentValue() {
		return DataType.getAsLong(this.get(S_CommentValue));

	}

	public long getCommentValueInitialValue() {
		return DataType.getAsLong(this.getOldObj(S_CommentValue));
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

	public void initKeyWords(String value) {
		this.initProperty(S_KeyWords, value);
	}

	public void setKeyWords(String value) {
		this.set(S_KeyWords, value);
	}

	public void setKeyWordsNull() {
		this.set(S_KeyWords, null);
	}

	public String getKeyWords() {
		return DataType.getAsString(this.get(S_KeyWords));
	}
	
	public String getKeyWordsInitialValue() {
		return DataType.getAsString(this.getOldObj(S_KeyWords));
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

	public String getSafeGuardInitialValue() {
		return DataType.getAsString(this.getOldObj(S_SafeGuard));
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

	public void initIsAllowDonation(String value) {
		this.initProperty(S_ISALLOWDONATION, new String(value));
	}

	public void setIsAllowDonation(String value) {
		this.set(S_ISALLOWDONATION, new String(value));
	}

	public String getIsAllowDonation() {
		return DataType.getAsString(this.get(S_ISALLOWDONATION));
	}

	public void setIsAllowDonationNull() {
		this.set(S_ISALLOWDONATION, null);
	}

	public String getIsAllowDonationInitValue() {
		return DataType.getAsString(this.getOldObj(S_ISALLOWDONATION));
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
	//为新增字段“MAPPING_CODE”实现5个方法
	public String getMappingCodeInitValue(){
		return DataType.getAsString(this.getOldObj(S_MappingCode));
	}
	
	public void setMappingCodeNull(){
		this.set(S_MappingCode, null);
	}
	
	public void initMappingCode(String value){
		this.initProperty(S_MappingCode, new String(value));
	}
	
	public String getMappingCode() {
		return DataType.getAsString(this.get(S_MappingCode));
	}

	public void setMappingCode(String value) {
		this.set(S_MappingCode, new String(value));
	}
}
