package ngves.asiainfo.core.floor.domain;

import java.io.Serializable;
import java.util.List;

//import ngves.asiainfo.core.floor.ivalues.ITabsAreaInfoValue;

public class TabsInfoForFront implements Serializable{
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 public String floorId;//楼层id
	public String tabsName;//楼层默认页签名字
     public String tabsTemplate;//默认页签模板
     public String tabsId;//默认页签id
   //public List<ITabsAreaInfoValue> tabsAreaInfoList;//页签区域信息
     public List<TabsAreaInfoForFront> tabsAreaInfoList;
	public String getTabsName() {
		return tabsName;
	}
	public void setTabsName(String tabsName) {
		this.tabsName = tabsName;
	}
	public String getTabsTemplate() {
		return tabsTemplate;
	}
	public void setTabsTemplate(String tabsTemplate) {
		this.tabsTemplate = tabsTemplate;
	}
	public List<TabsAreaInfoForFront> getTabsAreaInfoList() {
		return tabsAreaInfoList;
	}
	public void setTabsAreaInfoList(List<TabsAreaInfoForFront> tabsAreaInfoList) {
		this.tabsAreaInfoList = tabsAreaInfoList;
	}
	public String getTabsId() {
		return tabsId;
	}
	public void setTabsId(String tabsId) {
		this.tabsId = tabsId;
	}
	public String getFloorId() {
		return floorId;
	}
	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	
//	public List<ITabsAreaInfoValue> getTabsAreaInfoList() {
//		return tabsAreaInfoList;
//	}
//	public void setTabsAreaInfoList(List<ITabsAreaInfoValue> tabsAreaInfoList) {
//		this.tabsAreaInfoList = tabsAreaInfoList;
//	}
     
}
