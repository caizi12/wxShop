package ngves.asiainfo.core.donated.model;

import java.io.Serializable;
import java.util.List;

/**
 * 捐赠活动同步HP的信息封装
 * @author liuyq7@asiainfo-linkage.com
 *
 */
public class DonatedInfoToHPValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String optType ;
	private String actionId;
	private String actionName;
	private String donatedType;
	private String optOrderType;
	private String actionStartTime;
	private String actionEndTime;
	
	private List<Object> provinceList;
	private List<Object> objectList;

	public String getOptType() {
		return optType;
	}

	public void setOptType(String optType) {
		this.optType = optType;
	}

	public String getActionId() {
		return actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getDonatedType() {
		return donatedType;
	}

	public void setDonatedType(String donatedType) {
		this.donatedType = donatedType;
	}

	public String getOptOrderType() {
		return optOrderType;
	}

	public void setOptOrderType(String optOrderType) {
		this.optOrderType = optOrderType;
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

	public List<Object> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<Object> provinceList) {
		this.provinceList = provinceList;
	}

	public List<Object> getObjectList() {
		return objectList;
	}

	public void setObjectList(List<Object> objectList) {
		this.objectList = objectList;
	}
	
	
	
	/*
	OptType	1	String	F2	操作类型	01新增；02修改；03删除
	ActionID	1	String	V(1,32)	活动ID	活动ID规则： 03+捐赠活动ID
	前台需要对ActionID进行归一化处理，确保ActionID的唯一性
	ActionName	1	String	V(1,256)	活动名称	
	DonateType	1	String	F2	捐赠类型	捐赠类型：00- 积分；01- 礼品； 02- 积分+礼品
	OptOrderType	1	String	F2	配送类型	配送类型：
	03-	实时配送。
	04-	活动结束后批量配送。
	ActionStartTime	1	String	F14	活动开始时间	
	ActionEndTime	1	String	F14	活动截止时间	
	ProvinceInfo	?	—	—	活动适用省份信息	
	ProvinceList	+	—	—	适用省份列表	
	ProvinceID	1	String	F3	省份编码	
	CityInfo	?	—	—	活动适用地市信息	
	CityList	+	—	—	适用地市列表	
	CityID	1	String	F3	地市编码	
	ObjectList	+	-	-	捐赠对象列表	
	ObjectID	1	String	V(1,32)	对象编码	
	ObjectName	1	String	V(1,256)	对象名称	
	ObjectLevel	1	String	F1	对象级别	为短信捐赠确定捐赠优先级：
	0到9共10个级别，0为最高级别，9为最低级别
	DelivInfo	?	-	-	配送信息	对于无配送地址的虚拟类礼品，该节点不存在
	CusName	1	String	V(0,64)	收货人姓名	
	DelivProvince	1	String	F3	配送省	配送省代码
	City	1	String	V(0,6)	地市	（编码）
	District	1	String	V(0,6)	区县	（编码）
	CusAdd	1	String	V(0,256)	送货地址	
	CusTel	1	String	V(0,60)	联系电话	
	CusAddCode	1	String	F(0,6)	邮政编码	
	DelivTimeRequest	1	String	F(0,2)	配送时间要求	01－仅上班时间送货 02－周末送货
	03－周一到周日都可以送货
	MaxItemNum	1	Num	V9.0	最高礼品数	-1表示无上限
	Max	1	Num	V9.0	捐赠积分上限	-1表示无上限
	MaxM	1	Num	V9.0	捐赠M值上限	-1表示无上限
	ItemInfo	1	—	—	捐赠礼品信息	
	ItemList	+	—	—	捐赠礼品列表	
	MaxItemNum	1	Num	V9.0	最多兑换礼品数	用户本次活动最多兑换礼品数,-1表示无捐赠礼品数限制
	ItemID	1	String	V(1,16)	礼品编码	
	 */
}
