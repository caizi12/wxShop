package ngves.asiainfo.core.floor.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import com.ai.appframe2.util.StringUtils;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.common.util.BusiInfoUtil;
import ngves.asiainfo.core.floor.FloorConstant;
import ngves.asiainfo.core.floor.dao.interfaces.INavbarKindInfoDAO;
import ngves.asiainfo.core.floor.ivalues.INavbarKindInfoValue;
import ngves.asiainfo.core.floor.service.interfaces.INavbarKindInfoSrv;
import ngves.asiainfo.util.CommonParaUtil;

public class NavbarKindInfoSrvImpl implements INavbarKindInfoSrv {

	private INavbarKindInfoDAO navbarKindInfoDAO;	  
	String field = "KindName,ModifyDate,NavbarId,BakCol1,CreateDate,KindContent,IsContainSubKind,KindIcon,KindLevel,Status,ParentNavbar,NavbarKindId,KindType,IsHomeStatus,Sort";
	public void setNavbarKindInfoDAO(INavbarKindInfoDAO navbarKindInfoDAO) {
		this.navbarKindInfoDAO = navbarKindInfoDAO;
	}

	public INavbarKindInfoValue[] queryNavbarKindInfoList(Map<String, Object> param) throws Exception {
		return navbarKindInfoDAO.queryNavbarKindInfoList( param);
	}
	
	/**
	 * 批量保存
	 * @throws Exception
	 */
	public void saveNavbarKindInfos(INavbarKindInfoValue[] values,INavbarKindInfoValue[] oldvalues,INavbarKindInfoValue[] newvalues,String type,long staffId,String comType,long orgId) throws Exception {
		navbarKindInfoDAO.saveNavbarKindInfos(values);
		long busiId = BusiInfoUtil.recordBusiInfo(null, FloorConstant.SYS_BUSI_TYPE_NAVIGATION_SAVE,
				-1, type, CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY, type, staffId, comType, orgId);
		if(null != oldvalues && null != newvalues){
			for (int i = 0; i < newvalues.length; i++) {			
				BusiInfoUtil.recordBusiDetail(busiId+"", new Object[]{oldvalues[i]}, new Object[]{newvalues[i]}, field);
			}
		}		
	}
	/**
	 * 保存
	 * @throws Exception
	 */
	public void saveNavbarKindInfo(INavbarKindInfoValue value,INavbarKindInfoValue oldvalue,String type,long staffId,String comType,long orgId) throws Exception {
		navbarKindInfoDAO.saveNavbarKindInfo(value);
		long busiId = BusiInfoUtil.recordBusiInfo(null, FloorConstant.SYS_BUSI_TYPE_NAVIGATION_SAVE,
				-1, type, CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY, type, staffId, comType, orgId);
		if(null!=oldvalue){			
			BusiInfoUtil.recordBusiDetail(busiId+"", new Object[]{oldvalue}, new Object[]{value}, field);
		}
	}
	/**
	 * 获取单页数据
	 * @throws Exception
	 */
	public INavbarKindInfoValue[] queryNavbarKindInfoListForPage(String kindName,int $STARTROWINDEX, int $ENDROWINDEX) throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("kindName", kindName);
		return navbarKindInfoDAO.queryNavbarKindInfoListForPage(map, $STARTROWINDEX, $ENDROWINDEX);
	}
	/**
	 * 获取个数
	 * @throws Exception
	 */
	public int queryNavbarKindInfoCount(String kindName) throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		return navbarKindInfoDAO.queryNavbarKindInfoCount(map);
	}
	/**
	 * 获取序列
	 * @throws Exception
	 */
	public long getNewId() throws Exception{ 
		return navbarKindInfoDAO.getNewId();
	}
	/**
	 * 根据navbar_id查询信息
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public INavbarKindInfoValue[] getNavbarKindInfoValueBynavbarId(long navbard) throws Exception {
		INavbarKindInfoValue[] aluers = navbarKindInfoDAO.getNavbarKindInfoValueBynavbarId(navbard);
		
		//按等级、sort排序
		ArrayList<INavbarKindInfoValue> iNavbarKindInfovalues = new ArrayList<INavbarKindInfoValue>();
		ArrayList<INavbarKindInfoValue> oneList = new ArrayList<INavbarKindInfoValue>();
		ArrayList<INavbarKindInfoValue> twoList = new ArrayList<INavbarKindInfoValue>();

		for (int i = 0; i < aluers.length; i++) {//先排一级
			if (FloorConstant.NAVBAR_ONE_LEVEL.equalsIgnoreCase(aluers[i].getKindLevel())) {
				iNavbarKindInfovalues.add(aluers[i]);
				oneList.add(aluers[i]);
			}
		}
		//一级再按navbar_kind_id排序
		Collections.sort(iNavbarKindInfovalues, new SortByNavbarKindId());
		Collections.sort(oneList, new SortByNavbarKindId());		
		
		int index = 0;
		for (int i = 0; i < oneList.size(); i++) {//
			index++;
			for (int j = 0; j < aluers.length; j++) {//再排二级
				if (aluers[j].getParentNavbar()==oneList.get(i).getNavbarKindId()
						&& FloorConstant.NAVBAR_TWO_LEVEL.equalsIgnoreCase(aluers[j].getKindLevel())) {
					iNavbarKindInfovalues.add(index, aluers[j]);
					index++;
					twoList.add(aluers[j]);
				}
			}
		}
		index = 0;
		for (int i = 0; i < twoList.size(); i++) {//
			index++;
			for (int j = 0; j < aluers.length; j++) {//再排三级
				if (aluers[j].getParentNavbar()==twoList.get(i).getNavbarKindId()
						&& FloorConstant.NAVBAR_THREE_LEVEL.equalsIgnoreCase(aluers[j].getKindLevel())) {
					iNavbarKindInfovalues.add(index, aluers[j]);
					if(!StringUtils.isEmptyString(aluers[j].getKindIcon())){
						aluers[j].setKindIcon(CommonParaUtil.getPara(FloorConstant.PORTAL_HOME_PIC_PATH)+aluers[j].getKindIcon());
					}
					index++;
				}
			}
		}
		
		return (INavbarKindInfoValue[]) iNavbarKindInfovalues.toArray(new INavbarKindInfoValue[0]);
		
	}
	/**
	 * 根据navbar_kind_id查询信息
	 * @throws Exception
	 */
	public INavbarKindInfoValue getNavbarKindInfoValueBynavbarKindId(long navbardkind) throws Exception {
		INavbarKindInfoValue value = navbarKindInfoDAO.getNavbarKindInfoValueBynavbarKindId(navbardkind);
		if(FloorConstant.NAVBAR_THREE_LEVEL.equalsIgnoreCase(value.getKindLevel()) && !StringUtils.isEmptyString(value.getKindIcon())){
			value.setKindIcon(CommonParaUtil.getPara(FloorConstant.PORTAL_HOME_PIC_PATH)+value.getKindIcon());
		}
		return value;
	}
	
	/**
	 * 根据parent_navbar查询信息
	 * @throws Exception
	 */
	public INavbarKindInfoValue[] getNavbarKindInfoValueByparentNavbar(long parentNavbar) throws Exception {
		INavbarKindInfoValue[] values = navbarKindInfoDAO.getNavbarKindInfoValueByparentNavbar(parentNavbar);
		for (int i = 0; i < values.length; i++) {
			if(FloorConstant.NAVBAR_THREE_LEVEL.equalsIgnoreCase(values[i].getKindLevel()) && !StringUtils.isEmptyString(values[i].getKindIcon())){
				values[i].setKindIcon(CommonParaUtil.getPara(FloorConstant.PORTAL_HOME_PIC_PATH)+values[i].getKindIcon());
			}
		}
		return values;
	}
	
	
	/**
	 * 获取一级类目信息FORAPP
	 * @throws Exception
	 */
	public INavbarKindInfoValue[] getOneNavbarKindInfoForApp() throws Exception {
		INavbarKindInfoValue[] values = navbarKindInfoDAO.getOneNavbarKindInfoForApp();
		for (int i = 0; i < values.length; i++) {
			if(FloorConstant.NAVBAR_THREE_LEVEL.equalsIgnoreCase(values[i].getKindLevel()) && !StringUtils.isEmptyString(values[i].getKindIcon())){
				values[i].setKindIcon(CommonParaUtil.getPara(FloorConstant.PORTAL_HOME_PIC_PATH)+values[i].getKindIcon());
			}
		}
		return values;
	}
	
	/**
	 * 根据parent_navbar查询信息FORAPP
	 * @throws Exception
	 */
	public INavbarKindInfoValue[] getValueByparentNavbarForApp(long parentNavbar) throws Exception {
		INavbarKindInfoValue[] values = navbarKindInfoDAO.getValueByparentNavbarForApp(parentNavbar);
		for (int i = 0; i < values.length; i++) {
			if(FloorConstant.NAVBAR_THREE_LEVEL.equalsIgnoreCase(values[i].getKindLevel()) && !StringUtils.isEmptyString(values[i].getKindIcon())){
				values[i].setKindIcon(CommonParaUtil.getPara(FloorConstant.PORTAL_HOME_PIC_PATH)+values[i].getKindIcon());
			}
		}
		return values;
	}
	/**
	 * 获取一级类目信息FORWEB
	 * @throws Exception
	 */
	public INavbarKindInfoValue[] getOneNavbarKindInfoForWeb(boolean bIshome) throws Exception {
		INavbarKindInfoValue[] values = navbarKindInfoDAO.getOneNavbarKindInfoForWeb(bIshome);
		for (int i = 0; i < values.length; i++) {
			if(FloorConstant.NAVBAR_THREE_LEVEL.equalsIgnoreCase(values[i].getKindLevel()) && !StringUtils.isEmptyString(values[i].getKindIcon())){
				values[i].setKindIcon(CommonParaUtil.getPara(FloorConstant.PORTAL_HOME_PIC_PATH)+values[i].getKindIcon());
			}
		}
		return values;
	}
	
	/**
	 * 根据parent_navbar查询信息FORWeb
	 * @throws Exception
	 */
	public INavbarKindInfoValue[] getValueByparentNavbarForWeb(long parentNavbar,boolean bIshome) throws Exception {
		INavbarKindInfoValue[] values = navbarKindInfoDAO.getValueByparentNavbarForWeb(parentNavbar,bIshome);
		for (int i = 0; i < values.length; i++) {
			if(FloorConstant.NAVBAR_THREE_LEVEL.equalsIgnoreCase(values[i].getKindLevel()) && !StringUtils.isEmptyString(values[i].getKindIcon())){
				values[i].setKindIcon(CommonParaUtil.getPara(FloorConstant.PORTAL_HOME_PIC_PATH)+values[i].getKindIcon());
			}
		}
		return values;
	}
}

@SuppressWarnings("unchecked")
class SortByNavbarKindId implements Comparator {
	 public int compare(Object o1, Object o2) {
		 INavbarKindInfoValue s1 = (INavbarKindInfoValue) o1;
		 INavbarKindInfoValue s2 = (INavbarKindInfoValue) o2;
		 if (s1.getNavbarKindId() > s2.getNavbarKindId())
			 return 1;
		 return 0;
	 }
}