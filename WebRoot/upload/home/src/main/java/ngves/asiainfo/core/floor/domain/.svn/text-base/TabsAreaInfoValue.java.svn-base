package ngves.asiainfo.core.floor.domain;

import java.io.Serializable;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.common.bo.BusiInfoEngine;
import ngves.asiainfo.core.common.util.BusiInfoUtil;
import ngves.asiainfo.core.floor.FloorConstant;
import ngves.asiainfo.core.floor.bo.TabsAreaInfoBean;
import ngves.asiainfo.core.floor.ivalues.ITabsAreaInfoValue;
import ngves.asiainfo.core.floor.service.interfaces.IFloorInfoSrv;

import com.ai.appframe2.service.ServiceFactory;

public class TabsAreaInfoValue implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tabsAreaId;
	private String tabsId;
	private String areaSort;
	private String areaContentType;
	private String areaContent;
	private String areaImgUrl;
    private static String tabsAreaFileId="AreaContentType,AreaSort,TabsAreaId,AreaImgUrl,AreaContent,TabsId";
	public TabsAreaInfoValue() {

	}

	public String getTabsAreaId() {
		return tabsAreaId;
	}

	public void setTabsAreaId(String tabsAreaId) {
		this.tabsAreaId = tabsAreaId;
	}

	public String getTabsId() {
		return tabsId;
	}

	public void setTabsId(String tabsId) {
		this.tabsId = tabsId;
	}

	public String getAreaSort() {
		return areaSort;
	}

	public void setAreaSort(String areaSort) {
		this.areaSort = areaSort;
	}

	public String getAreaContentType() {
		return areaContentType;
	}

	public void setAreaContentType(String areaContentType) {
		this.areaContentType = areaContentType;
	}

	public String getAreaContent() {
		return areaContent;
	}

	public void setAreaContent(String areaContent) {
		this.areaContent = areaContent;
	}

	public String getAreaImgUrl() {
		return areaImgUrl;
	}

	public void setAreaImgUrl(String areaImgUrl) {
		this.areaImgUrl = areaImgUrl;
	}

	public static void toBeans(TabsAreaInfoValue[] value, ITabsAreaInfoValue[] ivalue, long tabsId,long staffId, String comType, long orgId) {
		if (ivalue == null)
			ivalue = new ITabsAreaInfoValue[value.length];
		IFloorInfoSrv service = (IFloorInfoSrv) ServiceFactory.getService("ngves.asiainfo.core.floor.FloorInfoService");
		try {
			for (int i = 0; i < value.length; i++) {
				if ("0" == value[i].getTabsAreaId()||null==value[i].getTabsAreaId()||"".equals(value[i].getTabsAreaId())) {//新增
					ivalue[i] = new TabsAreaInfoBean();
					ivalue[i].setTabsAreaId(service.getTabsAreaInfoNewId());
					ivalue[i].setAreaSort(value[i].getAreaSort());
					ivalue[i].setAreaContent(value[i].getAreaContent());
					ivalue[i].setAreaContentType(Long.valueOf(value[i].getAreaContentType()).longValue());
					ivalue[i].setAreaImgUrl(value[i].getAreaImgUrl());
					ivalue[i].setTabsId(tabsId);
					//记录业务日志信息
					  long busiInfoId = BusiInfoEngine.getNewId().longValue();
					  BusiInfoUtil.recordBusiInfo(busiInfoId + "", FloorConstant.SYS_PARA_BUSI_TYPE_WEB_FLOOR_TAB_AREA_CREATE, -1,
					       "新增默认页签区域信息",CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,"新增的默认页签区域ID："+ivalue[i].getTabsAreaId(), staffId, comType, orgId); 
				} else {//修改
					ivalue[i] = service.queryTabsAreaInfoById(Long.valueOf(value[i].getTabsAreaId()).longValue());
					ITabsAreaInfoValue oldValue=new TabsAreaInfoBean();
					oldValue.copy(ivalue[i]);
					ivalue[i].setAreaSort(value[i].getAreaSort());
					ivalue[i].setAreaContent(value[i].getAreaContent());
					ivalue[i].setAreaContentType(Long.valueOf(value[i].getAreaContentType()).longValue());
					ivalue[i].setAreaImgUrl(value[i].getAreaImgUrl());
					ivalue[i].setTabsId(tabsId);
					//记录业务日志基本信息
					  long busiInfoId = BusiInfoEngine.getNewId().longValue();
					  BusiInfoUtil.recordBusiInfo(busiInfoId + "", FloorConstant.SYS_PARA_BUSI_TYPE_WEB_FLOOR_TAB_AREA_MODIFY, -1,
					       "修改默认页签区域信息",CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,"修改的默认页签区域ID：："+ivalue[i].getTabsAreaId(), staffId, comType, orgId); 
					  //记录业务日志详细信息
						if(null!=oldValue){			
							BusiInfoUtil.recordBusiDetail(busiInfoId+"", new Object[]{oldValue}, new Object[]{ivalue[i]}, tabsAreaFileId);
						}
				}
				
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}