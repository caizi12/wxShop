package ngves.asiainfo.core.floor.domain;

import java.sql.Timestamp;
import java.util.Date;
import ngves.asiainfo.core.floor.ivalues.ITabsInfoValue;
import ngves.asiainfo.core.floor.service.interfaces.IFloorInfoSrv;

import com.ai.appframe2.service.ServiceFactory;

public class TabsInfoValue {
	private String tabsId;
	private String tabsName;
	private String tabsTemplate;
    public TabsInfoValue(){
    }
	public String getTabsId() {
		return tabsId;
	}
	public void setTabsId(String tabsId) {
		this.tabsId = tabsId;
	}
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
	};
	public void toBean(ITabsInfoValue value) throws Exception {
		IFloorInfoSrv service = (IFloorInfoSrv) ServiceFactory.getService("ngves.asiainfo.core.floor.FloorInfoService");
		   value.setTabsId(service.getTabsInfoNewId());
		   value.setCreatDate(new Timestamp(new Date().getTime()));
		   value.setTabsName(this.getTabsName());
		   value.setTabsTemplate(this.getTabsTemplate());
		
	}

}
