package ngves.asiainfo.core.common.ivalues;

import com.ai.appframe2.common.DataStructInterface;

public interface IQBORecommCategoryWareInfoValue extends DataStructInterface {

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
	public final static String S_Alias = "ALIAS";

	// 添加神州行现积分和统一积分
	public final static String S_WareIntegralValue = "WARE_INTEGRAL_VALUE";
	public final static String S_ECurValue = "E_CUR_VALUE";

	// 团购支持搜索功能，添加兑换方式和活动ID at 2012-11-14 沈福利
	public final static String S_ExchangeMode = "EXCHANGE_MODE";
	public final static String S_ExchangeId = "EXCHANGE_ID";
	// 混合支付需求新增字段
	public final static String S_PayType = "PAY_TYPE";
	public final static String S_OriPayCash = "ORI_PAY_CASH";
	public final static String S_OriPayIntegral = "ORI_PAY_INTEGRAL";
	public final static String S_CurPayCash = "CUR_PAY_CASH";
	public final static String S_CurPayIntegral = "CUR_PAY_INTEGRAL";
	public final static String S_Sale = "SALE";
	
	public String getSale();

	public void setSale(String value);

	public long getOriPayCash();

	public void setOriPayCash(long value);

	public long getOriPayIntegral();

	public void setOriPayIntegral(long value);

	public long getCurPayCash();

	public void setCurPayCash(long value);

	public long getCurPayIntegral();

	public void setCurPayIntegral(long value);

	public String getPayType();

	public void setPayType(String value);

	public String getExchangeMode();

	public void setExchangeMode(String value);

	public long getExchangeId();

	public void setExchangeId(long value);

	public long getWareIntegralValue();

	public void setWareIntegralValue(long value);

	public long getECurValue();

	public void setECurValue(long value);

	public long getMCurValue();

	public String getDeliverType();

	public long getSortId();

	public long getGOriValue();

	public long getTopFlag();

	public String getWareName();

	public long getWareId();

	public long getMOriValue();

	public String getFuncDesc();

	public long getGCurValue();

	public String getMainPicFile();

	public long getCategoryId();

	public String getWareCode();

	public void setMCurValue(long value);

	public void setDeliverType(String value);

	public void setSortId(long value);

	public void setGOriValue(long value);

	public void setTopFlag(long value);

	public void setWareName(String value);

	public void setWareId(long value);

	public void setMOriValue(long value);

	public void setFuncDesc(String value);

	public void setGCurValue(long value);

	public void setMainPicFile(String value);

	public void setCategoryId(long value);

	public void setWareCode(String value);

	public void setAlias(String value);

	public String getAlias();
}
