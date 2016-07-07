package ngves.asiainfo.core.floor.domain;

import java.sql.Timestamp;
import java.util.Date;

import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.floor.ivalues.INavbarInfoValue;
import ngves.asiainfo.core.floor.service.interfaces.INavbarInfoSrv;

import com.ai.appframe2.service.ServiceFactory;

public class NavbarInfoValue {

	private  String modifyDate;
	private  String navbarId;
	private  String bakCol1;
	private  String createDate;
	private  String sort;
	private  String navbarName;
	private  String bakCol2;
	private  String bakCol3;
	private  String bakCol4;
	
	public String getBakCol2() {
		return bakCol2;
	}

	public String getBakCol3() {
		return bakCol3;
	}

	public String getBakCol4() {
		return bakCol4;
	}

	public void setBakCol2(String bakCol2) {
		this.bakCol2 = bakCol2;
	}

	public void setBakCol3(String bakCol3) {
		this.bakCol3 = bakCol3;
	}

	public void setBakCol4(String bakCol4) {
		this.bakCol4 = bakCol4;
	}

	public NavbarInfoValue(){}

	public String getModifyDate() {
		return modifyDate;
	}

	public String getNavbarId() {
		return navbarId;
	}

	public String getBakCol1() {
		return bakCol1;
	}

	public String getCreateDate() {
		return createDate;
	}

	public String getSort() {
		return sort;
	}

	public String getNavbarName() {
		return navbarName;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public void setNavbarId(String navbarId) {
		this.navbarId = navbarId;
	}

	public void setBakCol1(String bakCol1) {
		this.bakCol1 = bakCol1;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public void setNavbarName(String navbarName) {
		this.navbarName = navbarName;
	};
	
	public void toBean(INavbarInfoValue iNavbarInfoBean) throws Exception {
		INavbarInfoSrv service = ((INavbarInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_NAVBAR_INFO_SRV));
		iNavbarInfoBean.setNavbarId(service.getNewId());
		iNavbarInfoBean.setNavbarName(this.getNavbarName());
		iNavbarInfoBean.setSort(Long.valueOf(this.getSort()));
		iNavbarInfoBean.setCreateDate(new Timestamp(new Date().getTime()));		
	}
	
}
