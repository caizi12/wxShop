package ngves.asiainfo.core.helpcenter.model;

import java.io.Serializable;
import ngves.asiainfo.core.helpcenter.ivalues.IHelpCenterinfoValue;
import ngves.asiainfo.util.DateTimeUtil;


/**
 * 
 * @author xj 创建时间：2014-6-8 上午11:23:29
 */
public class HelpCenterinfoModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3404924984871059853L;

	private String updateTime;
	private Long sortId;
	private String menuName;
	private Long parentHelpId;
	private Long helpCentreId;
	private String isShow;
	private String bakCol2;
	private String createTime;
	private String bakCol1;
	private String helpContent;
	
	public HelpCenterinfoModel copy(IHelpCenterinfoValue value){
		HelpCenterinfoModel model = new HelpCenterinfoModel();
		model.setBakCol1(value.getBakCol1());
		model.setBakCol2(value.getBakCol2());
		model.setCreateTime(DateTimeUtil.format(value.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
		model.setHelpCentreId(value.getHelpCentreId());
		model.setHelpContent(value.getHelpContent());
		model.setIsShow(value.getIsShow());
		model.setMenuName(value.getMenuName());
		model.setParentHelpId(value.getParentHelpId());
		model.setSortId(value.getSortId());
		if(null!=value.getUpdateTime()){
			model.setUpdateTime(DateTimeUtil.format(value.getUpdateTime(), "yyyy-MM-dd HH:mm:ss"));
		}
		return model;
	}
	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Long getSortId() {
		return sortId;
	}

	public void setSortId(Long sortId) {
		this.sortId = sortId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Long getParentHelpId() {
		return parentHelpId;
	}

	public void setParentHelpId(Long parentHelpId) {
		this.parentHelpId = parentHelpId;
	}

	public Long getHelpCentreId() {
		return helpCentreId;
	}

	public void setHelpCentreId(Long helpCentreId) {
		this.helpCentreId = helpCentreId;
	}

	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	public String getBakCol2() {
		return bakCol2;
	}

	public void setBakCol2(String bakCol2) {
		this.bakCol2 = bakCol2;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getBakCol1() {
		return bakCol1;
	}

	public void setBakCol1(String bakCol1) {
		this.bakCol1 = bakCol1;
	}

	public String getHelpContent() {
		return helpContent;
	}

	public void setHelpContent(String helpContent) {
		this.helpContent = helpContent;
	}

}
