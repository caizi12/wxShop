package ngves.asiainfo.core.common.model;

import java.io.Serializable;
import java.util.Iterator;

import ngves.asiainfo.core.ware.WareConstant;

/**
 * v1.5.6中3.1.2积分查询接口返回对象
 * */
public class PointQueryInfoBean  implements Serializable{

	private static final long serialVersionUID = 1L;

	
	//手机号码
	public String mobileNum;

	//用户品牌
	public String userBrand;

	//客户级别
	public String userLevel;
	
	//用户星级
	public String starLevel;
	
	//用户可使用积分时间
	public String validateStartTime;
	
	//用户总积分
	public String totalPoint;

	//客户状态
	public String userStatus;
	
	//客户省份
	public String userProvince;
	
	//客户可用积分余额
	public String userScore;

	//查询是否成功
	public String isSuccess;
	
	//错误信息
	public String errorMsg;
	
	//返回报文
	public String returnXml;
	
	//用户可用积分类型明细信息
	public PointTypeInfoBean[] pointTypeInfo;
	
	//拼接好的可用积分HTML格式的Tr
	public String pointTypeHtmlTr;

	
	public String getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(String totalPoint) {
		this.totalPoint = totalPoint;
	}

	public String getStarLevel() {
		return starLevel;
	}

	public void setStarLevel(String starLevel) {
		this.starLevel = starLevel;
	}

	public String getValidateStartTime() {
		return validateStartTime;
	}

	public void setValidateStartTime(String validateStartTime) {
		this.validateStartTime = validateStartTime;
	}


	public String getUserBrand() {
		return userBrand;
	}

	public void setUserBrand(String userBrand) {
		this.userBrand = userBrand;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}


	
	public String getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	
	public String getReturnXml() {
		return returnXml;
	}

	public void setReturnXml(String returnXml) {
		this.returnXml = returnXml;
	}

	public String getUserProvince() {
		return userProvince;
	}

	public void setUserProvince(String userProvince) {
		this.userProvince = userProvince;
	}

	public String getUserScore() {
		return userScore;
	}

	public void setUserScore(String userScore) {
		this.userScore = userScore;
	}

	
	public PointTypeInfoBean[] getPointTypeInfo() {
		return pointTypeInfo;
	}

	public void setPointTypeInfo(PointTypeInfoBean[] pointTypeInfo) {
		this.pointTypeInfo = pointTypeInfo;
	}
	

	public String getPointTypeHtmlTr() {
		return pointTypeHtmlTr;
	}

	public void setPointTypeHtmlTr(String pointTypeHtmlTr) {
		this.pointTypeHtmlTr = pointTypeHtmlTr;
	}
	public void setStarLevelValue(String star){
		if(WareConstant.STAR_LEVEL_UNRATED.equals(star)){
			//未评级
			this.starLevel = WareConstant.STAR_LEVEL_UNRATED_VIEW;
		}else if(WareConstant.STAR_LEVEL_TOBE.equals(star)){
			//准星
			this.starLevel = WareConstant.STAR_LEVEL_TOBE_VIEW;
		}else if(WareConstant.STAR_LEVEL_ONE.equals(star)){
			//一星
			this.starLevel = WareConstant.STAR_LEVEL_ONE_VIEW;
		}else if(WareConstant.STAR_LEVEL_TWO.equals(star)){
			//二星
			this.starLevel = WareConstant.STAR_LEVEL_TWO_VIEW;
		}else if(WareConstant.STAR_LEVEL_THREE.equals(star)){
			//三星
			this.starLevel = WareConstant.STAR_LEVEL_THREE_VIEW;
		}else if(WareConstant.STAR_LEVEL_FOUR.equals(star)){
			//四星
			this.starLevel = WareConstant.STAR_LEVEL_FOUR_VIEW;
		}else if(WareConstant.STAR_LEVEL_FIVE.equals(star)){
			//五星
			this.starLevel = WareConstant.STAR_LEVEL_FIVE_VIEW;
		}else if(WareConstant.STAR_LEVEL_FIVE_GOLD.equals(star)){
			//五星金
			this.starLevel = WareConstant.STAR_LEVEL_FIVE_GOLD_VIEW;
		}else if(WareConstant.STAR_LEVEL_FIVE_DIAMOND.equals(star)){
			//五星金
			this.starLevel = WareConstant.STAR_LEVEL_FIVE_DIAMOND_VIEW;
		}
	}
	public void setUserBrandValue(String brand){
		//品牌设置
		if(brand.equals(WareConstant.POINT_QUERY_BRAND_MZONE)) {
			//动感地带
			this.userBrand = WareConstant.MOBILE_BRAND_MZONE_VIEW;
		} else if(brand.equals(WareConstant.POINT_QUERY_BRAND_QQT)) {
			//全球通
			this.userBrand = WareConstant.MOBILE_BRAND_GOTONE_VIEW;
		} else if(brand.equals(WareConstant.POINT_QUERY_BRAND_EASYOWN)){
			//神州行
			this.userBrand = WareConstant.MOBILE_BRAND_EASYOWN_VIEW;
		}
	}
	/**
	 * 设置用户展示信息
	 */
	public void setPointQueryInfoView() {
		
		
		
		//用户等级设置
		Iterator<String> iterator = WareConstant.POINT_QUERY_LEVEL_MAP.keySet().iterator();
		while(iterator.hasNext()) {
			if(this.userLevel.equals((String)iterator.next())) {
				this.userLevel = WareConstant.POINT_QUERY_LEVEL_MAP.get(this.userLevel);
				break;
			}
		}
		iterator = null;
		
		//用户状态
		iterator = WareConstant.POINT_QUERY_STATUS_MAP.keySet().iterator();
		while(iterator.hasNext()) {
			if(this.userStatus.equals((String)iterator.next())) {
				this.userStatus = WareConstant.POINT_QUERY_STATUS_MAP.get(this.userStatus);
				break;
			}
			
		}
		
	}
	
	
	

}
