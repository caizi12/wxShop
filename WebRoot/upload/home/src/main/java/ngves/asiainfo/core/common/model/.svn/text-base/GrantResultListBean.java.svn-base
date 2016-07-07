package ngves.asiainfo.core.common.model;

import java.io.Serializable;
import java.util.Iterator;

import ngves.asiainfo.core.ware.WareConstant;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;


/**
 * 用户发放积分明细查询ResultList
 * */
public class GrantResultListBean  implements Serializable{

	private static final long serialVersionUID = 1L;

	
	//发放时间
	public String releaseTime;

	//发放的积分类型
	public String releasePointType;

	//发放的积分值
	public String releasePoint;

	//有效期到期时间
	public String validateTime;
	
	//发放说明
	public String comments;
	
	
	
	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getReleasePointType() {
		return releasePointType;
	}

	public void setReleasePointType(String releasePointType) {
		this.releasePointType = releasePointType;
	}

	public String getReleasePoint() {
		return releasePoint;
	}

	public void setReleasePoint(String releasePoint) {
		this.releasePoint = releasePoint;
	}

	public String getValidateTime() {
		return validateTime;
	}

	public void setValidateTime(String validateTime) {
		this.validateTime = validateTime;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}


	/**
	 * 设置用户展示信息
	 */
	public void setPointTypeInfoView() {
		
		//格式化时间
		if(!StringUtil.isBlank(this.releaseTime)){
			this.releaseTime = DateTimeUtil.dateTrans(this.releaseTime);
		}
		if(!StringUtil.isBlank(this.validateTime)){
			this.validateTime = DateTimeUtil.dateTrans(this.validateTime);
		}
		
		//用户状态
		Iterator<String> iterator = WareConstant.POINT_QUERY_TYPE_MAP.keySet().iterator();
		while(iterator.hasNext()) {
			if(this.releasePointType.equals((String)iterator.next())) {
				this.releasePointType = WareConstant.POINT_QUERY_TYPE_MAP.get(this.releasePointType);
				break;
			}
			
		}
	}
	
	

}
