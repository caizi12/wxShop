package ngves.asiainfo.core.floor.domain;

import java.sql.Timestamp;
import java.util.Date;

import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.floor.FloorConstant;
import ngves.asiainfo.core.floor.bo.NavbarKindInfoBean;
import ngves.asiainfo.core.floor.ivalues.INavbarKindInfoValue;
import ngves.asiainfo.core.floor.service.interfaces.INavbarKindInfoSrv;

import com.ai.appframe2.service.ServiceFactory;

public class NavbarKindInfoValue {
	  private  String kindName ;
	  private  String modifyDate ;
	  private  String navbarId ;
	  private  String bakCol1 ;
	  private  String createDate ;
	  private  String kindContent ;
	  private  String isContainSubKind ;
	  private  String kindIcon ;
	  private  String kindLevel ;
	  private  String status ;
	  private  String parentNavbar ;
	  private  String navbarKindId ;
	  private  String kindType ;
	  private  String IsHomeStatus ;		
	  private  String sort;
	  
	public NavbarKindInfoValue(){}

	public String getKindName() {
		return kindName;
	}

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

	public String getKindContent() {
		return kindContent;
	}

	public String getIsContainSubKind() {
		return isContainSubKind;
	}

	public String getKindIcon() {
		return kindIcon;
	}

	public String getKindLevel() {
		return kindLevel;
	}

	public String getStatus() {
		return status;
	}

	public String getParentNavbar() {
		return parentNavbar;
	}

	public String getNavbarKindId() {
		return navbarKindId;
	}

	public String getKindType() {
		return kindType;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
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

	public void setKindContent(String kindContent) {
		this.kindContent = kindContent;
	}

	public void setIsContainSubKind(String isContainSubKind) {
		this.isContainSubKind = isContainSubKind;
	}

	public void setKindIcon(String kindIcon) {
		this.kindIcon = kindIcon;
	}

	public void setKindLevel(String kindLevel) {
		this.kindLevel = kindLevel;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setParentNavbar(String parentNavbar) {
		this.parentNavbar = parentNavbar;
	}

	public void setNavbarKindId(String navbarKindId) {
		this.navbarKindId = navbarKindId;
	}

	public void setKindType(String kindType) {
		this.kindType = kindType;
	};
	
	public String getIsHomeStatus() {
		return IsHomeStatus;
	}

	public void setIsHomeStatus(String isHomeStatus) {
		IsHomeStatus = isHomeStatus;
	}
	
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public static void toBeans(NavbarKindInfoValue[] ab, INavbarKindInfoValue[] bwii, long navbarId){
        if(bwii==null)
            bwii=new INavbarKindInfoValue[ab.length];
        INavbarKindInfoSrv service = ((INavbarKindInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_NAVBARKIND_INFO_SRV));
        try{
       
        	for (int i=0;i<ab.length;i++){
        		bwii[i] = new NavbarKindInfoBean();
        		bwii[i].setNavbarId(navbarId);            
        		bwii[i].setNavbarKindId(service.getNewId());
        		bwii[i].setKindName(ab[i].getKindName());
        		bwii[i].setKindType(ab[i].getKindType());
        		bwii[i].setKindContent(ab[i].getKindContent());
        		bwii[i].setKindLevel(FloorConstant.NAVBAR_ONE_LEVEL);//1：一级类目        		2：二级类目        		3：三级类目
        		bwii[i].setIsContainSubKind(FloorConstant.NAVBAR_CONTAIN_SUBKIND);//0：无子类        		1：有子类
        		bwii[i].setStatus(FloorConstant.NAVBAR_DISENABLED);//0：未启用        		1：启用 
        		bwii[i].setIsHomeStatus(FloorConstant.NAVBAR_NOTHOME);//0：不在首页展示	1：不首页展示 
        		bwii[i].setCreateDate(new Timestamp(new Date().getTime()));	
        		bwii[i].setSort(1);//初始默认值
        }
        }catch(Exception e){
           
        }
    }
    
}
