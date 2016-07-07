package ngves.asiainfo.core.ware.model;

/**
 * 封装校验规则同步给HP的接口信息
 * @author shenfl@asiainfo-linkage.com
 * @date: 2011-11-14
 */
public class ValidateRuleValueToHP  {

    //操作类型 01新增；02修改；03删除
    private String optType;
    //删除或修改前ActionID:04+优惠活动ID
    private String preActionID;
    //删除或修改前ItemID
    private String preItemID;
    // 活动ID规则：04+优惠活动ID 前台需要对ActionID进行归一化处理，确保ActionID的唯一性
    private String actionID;
    //规则名称
    private String ruleName;
	//礼品ID	校验规则对应的礼品ID，不能重复
    private String itemID;
    //规则开始时间
    private String actionStartTime;
    //规则截止时间
    private String actionEndTime;
    //支持渠道范围	各渠道用逗号分隔（0001,0002,003,0004,0005）
    private String orgID;
    //订单范围	00-全部订单；01-有效订单
    private String orderStatus;
    //礼品范围	00-任意礼品；01-部分礼品
    private String itemScope;
    //满足条件数量	产生过的订单数量，如果无限制，默认为1
    private long orderNum;
    //订单开始时间
    private String orderStartTime;
    //订单截止时间
    private String orderEndTime;
    //最大优惠次数	用户参与优惠的最大次数，无次数限制则默认值为：-1
    private long maxTimes;
    //该礼品总的最大兑换数量	无最大礼品数限制则默认值为：-1
    private long maxItemNum;

    //省份编码，多个 使用豆号隔开，
    private String provinceID;
    //地市编码(现不使用 2012-7-30)
    private String cityID;
    //礼品小类编码   -如果规则与礼品小类无关，则该节点可不存在
    private String type3;
    //礼品商编码  -如果规则与礼品商无关，则该节点可不存在
    private String vendorID;
    //礼品编码   -如果无对应礼品信息，则该节点可不存在
    //参与优惠条件的已兑换礼品编码
    private String exchangeItemID;
    
    //支持优惠类型  00-仅支持普通兑换  01-支持优惠兑换及普通兑换  02-仅支持优惠兑换
    private String SupportType;
    //支持星级 各星级用逗号隔开
    private String supportStarLevel;
    
    public String getSupportStarLevel() {
		return supportStarLevel;
	}

	public void setSupportStarLevel(String supportStarLevel) {
		this.supportStarLevel = supportStarLevel;
	}

	//支持品牌范围，各品牌用逗号隔开(需先转换成HP所使用的code)
    private String SupportBrand;

    
    
    //是否支持优惠礼品短信推广  00 不支持 01 支持
    private String isSpread ;
    //优惠礼品的积分值
    private int actionPoint;
    
    //混合支付新增字段
	private String payType;
	private long payIntegral;
	private long payCash;
	// 订单范围
    private  String orderScope;

    public String getOrderScope() {
		return orderScope;
	}

	public void setOrderScope(String orderScope) {
		this.orderScope = orderScope;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public long getPayIntegral() {
		return payIntegral;
	}

	public void setPayIntegral(long payIntegral) {
		this.payIntegral = payIntegral;
	}

	public long getPayCash() {
		return payCash;
	}

	public void setPayCash(long payCash) {
		this.payCash = payCash;
	}

	public String getPreActionID() {
		return preActionID;
	}

	public void setPreActionID(String preActionID) {
		this.preActionID = preActionID;
	}

	public String getPreItemID() {
		return preItemID;
	}

	public void setPreItemID(String preItemID) {
		this.preItemID = preItemID;
	}

	/**
	 * @return the isSpread
	 */
	public String getIsSpread() {
		return isSpread;
	}

	/**
	 * @param isSpread the isSpread to set
	 */
	public void setIsSpread(String isSpread) {
		this.isSpread = isSpread;
	}

	/**
	 * @return the actionPoint
	 */
	public int getActionPoint() {
		return actionPoint;
	}

	/**
	 * @param actionPoint the actionPoint to set
	 */
	public void setActionPoint(int actionPoint) {
		this.actionPoint = actionPoint;
	}

	public String getSupportType() {
		return SupportType;
	}

	public void setSupportType(String supportType) {
		SupportType = supportType;
	}

	public String getSupportBrand() {
		return SupportBrand;
	}

	public void setSupportBrand(String supportBrand) {
		SupportBrand = supportBrand;
	}

	public String getOptType() {
        return optType;
    }

    public void setOptType(String optType) {
        this.optType = optType;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getActionStartTime() {
        return actionStartTime;
    }

    public void setActionStartTime(String actionStartTime) {
        this.actionStartTime = actionStartTime;
    }

    public String getActionEndTime() {
        return actionEndTime;
    }

    public void setActionEndTime(String actionEndTime) {
        this.actionEndTime = actionEndTime;
    }

    public String getOrgID() {
        return orgID;
    }

    public void setOrgID(String orgID) {
        this.orgID = orgID;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getItemScope() {
        return itemScope;
    }

    public void setItemScope(String itemScope) {
        this.itemScope = itemScope;
    }

    public long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(long orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderStartTime() {
        return orderStartTime;
    }

    public void setOrderStartTime(String orderStartTime) {
        this.orderStartTime = orderStartTime;
    }

    public String getOrderEndTime() {
        return orderEndTime;
    }

    public void setOrderEndTime(String orderEndTime) {
        this.orderEndTime = orderEndTime;
    }

    public long getMaxTimes() {
        return maxTimes;
    }

    public void setMaxTimes(long maxTimes) {
        this.maxTimes = maxTimes;
    }

    public long getMaxItemNum() {
        return maxItemNum;
    }

    public void setMaxItemNum(long maxItemNum) {
        this.maxItemNum = maxItemNum;
    }

    public String getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(String provinceID) {
        this.provinceID = provinceID;
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getType3() {
        return type3;
    }

    public void setType3(String type3) {
        this.type3 = type3;
    }

    public String getVendorID() {
        return vendorID;
    }

    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }

    public String getExchangeItemID() {
        return exchangeItemID;
    }

    public void setExchangeItemID(String exchangeItemID) {
        this.exchangeItemID = exchangeItemID;
    }
    public String getActionID() {
		return actionID;
	}

	public void setActionID(String actionID) {
		this.actionID = actionID;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
}
