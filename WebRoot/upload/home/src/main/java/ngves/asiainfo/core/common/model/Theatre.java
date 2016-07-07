package ngves.asiainfo.core.common.model;

/**
 * 剧场类
 * @author WL
 *
 */
public class Theatre   implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String theatreId;
	private String useClass; 		  // 对应样式
	private String theatreCode;		 //  剧场code 对应子礼品code
	private boolean isShow = true;  //   是否显示 默认显示:true
	private int storage;		  //库存量
	private String descValue;		 //组合查询对应文本信息
	
	//神州行添加 统一积分字段和神州行现积分
	private String ware_integral_value;
	private String e_cur_value;
	
	public String getWare_integral_value() {
		if (this.ware_integral_value == null || "".equals(this.ware_integral_value)) {
			this.ware_integral_value = "0";
		}
		return ware_integral_value;
	}

	public void setWare_integral_value(String ware_integral_value) {
		this.ware_integral_value = ware_integral_value;
	}

	public String getE_cur_value() {
		if (this.e_cur_value == null || "".equals(this.e_cur_value)) {
			this.e_cur_value = "0";
		}
		return e_cur_value;
	}
	public void setE_cur_value(String e_cur_value) {
		this.e_cur_value = e_cur_value;
	}
	private String g_cur_value;  //全球通现兑换积分(折扣值)
	private String m_cur_value; //动感地带现兑换M值(折扣值)

	private String locationName;
	private String priceInfo;
	
	private long maxCurIntegeral;//三品牌现兑换分最大值（折扣值）
	private long oriPayIntegral;//混合积分的原积分值
	private String oriPayCash;//混合积分的原现金值
	private long curPayIntegral;//混合积分的现积分值
	private String curPayCash;//混合积分的现现金值
	
	private String payType;//支付类型
	
	private String isOnlinePay ;//是否支持线上支付
	private String isOfflinePay;//是否支持线下支付
	private String offlineDesc;//线下描述
	
	private String onlyMobileBrand;//仅支持品牌
	
	public String getIsOnlinePay() {
		return isOnlinePay;
	}

	public void setIsOnlinePay(String isOnlinePay) {
		this.isOnlinePay = isOnlinePay;
	}

	public String getIsOfflinePay() {
		return isOfflinePay;
	}

	public void setIsOfflinePay(String isOfflinePay) {
		this.isOfflinePay = isOfflinePay;
	}

	public String getOfflineDesc() {
		return offlineDesc;
	}

	public void setOfflineDesc(String offlineDesc) {
		this.offlineDesc = offlineDesc;
	}
	
	
	public String getOnlyMobileBrand() {
		return onlyMobileBrand;
	}

	public void setOnlyMobileBrand(String onlyMobileBrand) {
		this.onlyMobileBrand = onlyMobileBrand;
	}

	public long getOriPayIntegral() {
		return oriPayIntegral;
	}

	public void setOriPayIntegral(long oriPayIntegral) {
		this.oriPayIntegral = oriPayIntegral;
	}

	public String getOriPayCash() {
		return oriPayCash;
	}

	public void setOriPayCash(String oriPayCash) {
		this.oriPayCash = oriPayCash;
	}

	public long getCurPayIntegral() {
		return curPayIntegral;
	}

	public void setCurPayIntegral(long curPayIntegral) {
		this.curPayIntegral = curPayIntegral;
	}

	public String getCurPayCash() {
		return curPayCash;
	}

	public void setCurPayCash(String curPayCash) {
		this.curPayCash = curPayCash;
	}

	public long getMaxCurIntegeral() {
		return maxCurIntegeral;
	}

	public void setMaxCurIntegeral(long maxCurIntegeral) {
		this.maxCurIntegeral = maxCurIntegeral;
	}
	
	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getPriceInfo() {
		return priceInfo;
	}
	public void setPriceInfo(String priceInfo) {
		this.priceInfo = priceInfo;
	}
	public String getG_cur_value() {
		if(this.g_cur_value == null){
			this.g_cur_value = "0";
		}
		return g_cur_value;
	}
	public void setG_cur_value(String gCurValue) {
		g_cur_value = gCurValue;
	}
	public String getM_cur_value() {
		if(this.m_cur_value == null){
			this.m_cur_value = "0";
		}
		return m_cur_value;
	}
	public void setM_cur_value(String mCurValue) {
		m_cur_value = mCurValue;
	}
	
	
	
	public String getDescValue() {
		return descValue;
	}
	public void setDescValue(String descValue) {
		this.descValue = descValue;
	}
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public String getUseClass() {
		return useClass;
	}
	public void setUseClass(String useClass) {
		this.useClass = useClass;
	}
	public String getTheatreCode() {
		return theatreCode;
	}
	public void setTheatreCode(String theatreCode) {
		this.theatreCode = theatreCode;
	}
	public boolean isShow() {
		return isShow;
	}
	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}
	public String getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}
}
