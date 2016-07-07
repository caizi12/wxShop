package ngves.asiainfo.core.rushbuy.model;

public class ActivityWareInfo {
	
	private String wareId;
	
	private String wareNowAmount;

    private String activityUserLogId;
    
    private String isCanBuy;
    
    

	public String getIsCanBuy() {
		return isCanBuy;
	}

	public void setIsCanBuy(String isCanBuy) {
		this.isCanBuy = isCanBuy;
	}

	public String getActivityUserLogId() {
        return activityUserLogId;
    }

    public void setActivityUserLogId(String activityUserLogId) {
        this.activityUserLogId = activityUserLogId;
    }

    public String getWareId() {
		return wareId;
	}

	public void setWareId(String wareId) {
		this.wareId = wareId;
	}

	public String getWareNowAmount() {
		return wareNowAmount;
	}

	public void setWareNowAmount(String wareNowAmount) {
		this.wareNowAmount = wareNowAmount;
	}

}
