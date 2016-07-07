package ngves.asiainfo.core.common.model;

import java.io.Serializable;

import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;


/**
 * 用户使用积分明细查询ResultList
 * */
public class UseResultListBean  implements Serializable{

	private static final long serialVersionUID = 1L;

	
	//发放时间
	public String useTime;

	//发放的积分值
	public String usePoint;

	//发放说明
	public String comments;
	
	//用户使用积分途径编码
	public String useWayCode;
	
	//用户使用积分途径描述
	public String useWayDesc;
	
	
	public String getUseWayCode() {
		return useWayCode;
	}

	public void setUseWayCode(String useWayCode) {
		this.useWayCode = useWayCode;
	}

	public String getUseWayDesc() {
		return useWayDesc;
	}

	public void setUseWayDesc(String useWayDesc) {
		this.useWayDesc = useWayDesc;
	}

	public String getUseTime() {
		return useTime;
	}

	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}

	public String getUsePoint() {
		return usePoint;
	}

	public void setUsePoint(String usePoint) {
		this.usePoint = usePoint;
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
		if(!StringUtil.isBlank(this.useTime)){
			this.useTime = DateTimeUtil.dateTrans(this.useTime);
		}
		
	}
	
	

}
