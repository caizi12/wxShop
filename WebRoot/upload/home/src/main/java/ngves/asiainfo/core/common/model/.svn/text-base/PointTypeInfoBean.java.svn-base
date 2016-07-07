package ngves.asiainfo.core.common.model;

import java.io.Serializable;

import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;


/**
 * 用户查询积分明细PointTypeInfo
 * */
public class PointTypeInfoBean  implements Serializable{

	private static final long serialVersionUID = 1L;

	
	//用户积分类型
	public String pointType;

	//该类型总积分值
	public String pointSum;

	//有效期到期时间
	public String validateTime;

	public String getPointType() {
		return pointType;
	}

	public void setPointType(String pointType) {
		this.pointType = pointType;
	}

	public String getPointSum() {
		return pointSum;
	}

	public void setPointSum(String pointSum) {
		this.pointSum = pointSum;
	}

	public String getValidateTime() {
		return validateTime;
	}

	public void setValidateTime(String validateTime) {
		this.validateTime = validateTime;
	}

	
	/**
	 * 设置用户展示信息
	 */
	public void setPointTypeInfoView() {
		
		//格式化时间
		if(!StringUtil.isBlank(this.validateTime)){
			this.validateTime = DateTimeUtil.dateTrans(this.validateTime);
		}
		
	}
	
	

}
