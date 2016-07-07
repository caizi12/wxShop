package ngves.asiainfo.core.floor.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.ai.appframe2.service.ServiceFactory;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.common.util.BusiInfoUtil;
import ngves.asiainfo.core.floor.FloorConstant;
import ngves.asiainfo.core.floor.dao.interfaces.INavbarInfoDAO;
import ngves.asiainfo.core.floor.ivalues.INavbarInfoValue;
import ngves.asiainfo.core.floor.ivalues.INavbarKindInfoValue;
import ngves.asiainfo.core.floor.service.interfaces.INavbarInfoSrv;
import ngves.asiainfo.core.floor.service.interfaces.INavbarKindInfoSrv;

public class NavbarInfoSrvImpl implements INavbarInfoSrv {

	private INavbarInfoDAO navbarInfoDAO;
	String field = "ModifyDate,NavbarId,BakCol1,BakCol2,BakCol3,BakCol4,CreateDate,Sort,NavbarName";
	
	public void setNavbarInfoDAO(INavbarInfoDAO navbarInfoDAO) {
		this.navbarInfoDAO = navbarInfoDAO;
	}

	public INavbarInfoValue[] queryNavbarInfoList(Map<String, Object> param) throws Exception {
		return navbarInfoDAO.queryNavbarInfoList( param);
	}
	
	/**
	 * 批量保存
	 * @throws Exception
	 */
	public void saveNavbarInfos(INavbarInfoValue[] values,INavbarInfoValue[] oldvalue,String type,long staffId,String comType,long orgId) throws Exception {
		navbarInfoDAO.saveNavbarInfos(values);
		long busiId = BusiInfoUtil.recordBusiInfo(null, FloorConstant.SYS_BUSI_TYPE_NAVIGATION_SAVE,
				-1, type, CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY, type, staffId, comType, orgId);
		BusiInfoUtil.recordBusiDetail(busiId+"", new Object[]{oldvalue}, new Object[]{values}, field);
		
	}
	/**
	 * 保存
	 * @throws Exception
	 */
	public void saveNavbarInfo(INavbarInfoValue value,INavbarInfoValue oldvalue,String type,long staffId,String comType,long orgId) throws Exception {
		navbarInfoDAO.saveNavbarInfo(value);
		long busiId = BusiInfoUtil.recordBusiInfo(null, FloorConstant.SYS_BUSI_TYPE_NAVIGATION_SAVE,
				-1, type, CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY, type, staffId, comType, orgId);
		if(null!=oldvalue){			
			BusiInfoUtil.recordBusiDetail(busiId+"", new Object[]{oldvalue}, new Object[]{value}, field);
		}
	}

	/**
	 * 获取数据，并拼上一二三级类目信息
	 * @throws Exception
	 */
	public INavbarInfoValue[] queryNavbarInfoListForPage(String navbarName,int $STARTROWINDEX, int $ENDROWINDEX) throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("navbarName", navbarName);
		INavbarInfoValue[] iNavbarInfoValues = navbarInfoDAO.queryNavbarInfoListForPage(map, $STARTROWINDEX, $ENDROWINDEX);
		INavbarKindInfoSrv navbarKindInfoSrv = (INavbarKindInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_NAVBARKIND_INFO_SRV);
		
		for (int i = 0; i < iNavbarInfoValues.length; i++) {
			StringBuffer oneName = new StringBuffer();
			StringBuffer twoName = new StringBuffer();
			StringBuffer threeName = new StringBuffer();
			INavbarKindInfoValue[] iNavbarKindInfoValues = navbarKindInfoSrv.getNavbarKindInfoValueBynavbarId(iNavbarInfoValues[i].getNavbarId());
			for (int j = 0; j < iNavbarKindInfoValues.length; j++) {
				if(iNavbarKindInfoValues[j].getKindLevel().equalsIgnoreCase("1")){
					oneName.append(iNavbarKindInfoValues[j].getKindName()).append("、");
				}else if(iNavbarKindInfoValues[j].getKindLevel().equalsIgnoreCase("2")){
					twoName.append(iNavbarKindInfoValues[j].getKindName()).append("、");
				}else if(iNavbarKindInfoValues[j].getKindLevel().equalsIgnoreCase("3")){
					threeName.append(iNavbarKindInfoValues[j].getKindName()).append("、");
				}
			}
			iNavbarInfoValues[i].setBakCol2(oneName.toString().length()>0?oneName.toString().substring(0, oneName.toString().length()-1):oneName.toString());
			iNavbarInfoValues[i].setBakCol3(twoName.toString().length()>0?twoName.toString().substring(0, twoName.toString().length()-1):twoName.toString());
			iNavbarInfoValues[i].setBakCol4(threeName.toString().length()>0?threeName.toString().substring(0, threeName.toString().length()-1):threeName.toString());
		} 
		return iNavbarInfoValues;
	}
	/**
	 * 获取个数
	 * @throws Exception
	 */
	public int queryNavbarInfoCount(String navbarName) throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("navbarName", navbarName);
		return navbarInfoDAO.queryNavbarInfoCount(map);
	}
	/**
	 * 获取序列
	 * @throws Exception
	 */
	public long getNewId() throws Exception{ 
		return navbarInfoDAO.getNewId();
	}
	
	/**
	 * 根据navbar_id查询信息
	 * @throws Exception
	 */
	public INavbarInfoValue getNavbarInfoValueBynavbarId(long navbard) throws Exception {
		return navbarInfoDAO.getNavbarInfoValueBynavbarId(navbard);
	}
}
