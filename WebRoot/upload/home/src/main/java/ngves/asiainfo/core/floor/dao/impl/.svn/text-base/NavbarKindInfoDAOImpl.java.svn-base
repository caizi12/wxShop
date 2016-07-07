package ngves.asiainfo.core.floor.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.floor.bo.NavbarKindInfoEngine;
import ngves.asiainfo.core.floor.dao.interfaces.INavbarKindInfoDAO;
import ngves.asiainfo.core.floor.ivalues.INavbarKindInfoValue;

import org.apache.commons.lang.StringUtils;

public class NavbarKindInfoDAOImpl implements INavbarKindInfoDAO {

	public INavbarKindInfoValue[] queryNavbarKindInfoList(Map<String, Object> param) throws Exception {
		return NavbarKindInfoEngine.getBeans(null, param);
	}

	public void saveNavbarKindInfos(INavbarKindInfoValue[] values) throws Exception {
		 NavbarKindInfoEngine.save(values);
	}
	
	public void saveNavbarKindInfo(INavbarKindInfoValue value) throws Exception {
		 NavbarKindInfoEngine.save(value);
	}
	
	/**
	 * 管理平台查询分页使用
	 */
	public INavbarKindInfoValue[] queryNavbarKindInfoListForPage(Map<String, Object> param,int startNum,int endNum) throws Exception {
		StringBuffer sb=new StringBuffer(" 1=1 ");
		if(StringUtils.isNotBlank((String)param.get("kindName"))){
			sb.append(" and "+INavbarKindInfoValue.S_KindName+" like '%:kindName%'");
		}
		return NavbarKindInfoEngine.getBeans(null, sb.toString(), param, startNum, endNum, false);
	}
	/**
	 * 管理平台查询总条数使用
	 */
	public int queryNavbarKindInfoCount(Map<String, Object> param) throws Exception {
		StringBuffer sb=new StringBuffer(" 1=1 ");
		if(StringUtils.isNotBlank((String)param.get("kindName"))){
			sb.append(" and "+INavbarKindInfoValue.S_KindName+" like '%:kindName%'");
		}
		return NavbarKindInfoEngine.getBeansCount(sb.toString(), param);
	}
	
	/**
	 * 提供给门户，app，触屏版使用
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public INavbarKindInfoValue[] queryNavbarKindListForPortal(Map<String, Object> param) throws Exception {
		StringBuffer sb=new StringBuffer(" 1=1 ");
		if(StringUtils.isNotBlank((String)param.get("kindName"))){
			sb.append(" and "+INavbarKindInfoValue.S_KindName+" like '%:kindName%'");
		}
		param.put("status", "1");
		sb.append(" and "+INavbarKindInfoValue.S_Status+" =:status");
		
		return NavbarKindInfoEngine.getBeans(sb.toString(), param);
	}
	
	public long getNewId() throws Exception{ 
		return NavbarKindInfoEngine.getNewId().longValue();
	}
	
	/**
	 * 根据navbar_id查询信息
	 * @throws Exception
	 */
	public INavbarKindInfoValue[] getNavbarKindInfoValueBynavbarId(long navbard) throws Exception {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		
		condition.append(" AND ").append(INavbarKindInfoValue.S_NavbarId).append(" = :").append(INavbarKindInfoValue.S_NavbarId);;
		parameter.put(INavbarKindInfoValue.S_NavbarId, navbard);
		condition.append(" order by "+INavbarKindInfoValue.S_Sort);
		return NavbarKindInfoEngine.getBeans(condition.toString(), parameter);
		
	}
	
	/**
	 * 根据navbar_kind_id查询信息
	 * @throws Exception
	 */
	public INavbarKindInfoValue getNavbarKindInfoValueBynavbarKindId(long navbardkind) throws Exception {
		return NavbarKindInfoEngine.getBean(navbardkind);
	}
	
	/**
	 * 根据parent_navbar查询信息
	 * @throws Exception
	 */
	public INavbarKindInfoValue[] getNavbarKindInfoValueByparentNavbar(long parentnavbar) throws Exception{
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		
		condition.append(" AND ").append(INavbarKindInfoValue.S_ParentNavbar).append(" = :").append(INavbarKindInfoValue.S_ParentNavbar);;
		parameter.put(INavbarKindInfoValue.S_ParentNavbar, parentnavbar);
		
		condition.append(" order by "+INavbarKindInfoValue.S_Sort);
		
		return NavbarKindInfoEngine.getBeans(condition.toString(), parameter);
	}
	/**
	 * 获取一级类目信息FORAPP
	 * @throws Exception
	 */
	public INavbarKindInfoValue[] getOneNavbarKindInfoForApp() throws Exception {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		String kindlevel = "1";
		String sort = "1";
		condition.append(" AND ").append(INavbarKindInfoValue.S_KindLevel).append(" = :").append(INavbarKindInfoValue.S_KindLevel);
		condition.append(" AND ").append(INavbarKindInfoValue.S_Status).append(" = :").append(INavbarKindInfoValue.S_Status);
		parameter.put(INavbarKindInfoValue.S_KindLevel, kindlevel);
		parameter.put(INavbarKindInfoValue.S_Status, sort);
		
		return NavbarKindInfoEngine.getBeans(condition.toString(), parameter);
	}
	
	/**
	 * 根据parent_navbar查询信息
	 * @throws Exception
	 */
	public INavbarKindInfoValue[] getValueByparentNavbarForApp(long parentnavbar) throws Exception{
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		
		condition.append(" AND ").append(INavbarKindInfoValue.S_ParentNavbar).append(" = :").append(INavbarKindInfoValue.S_ParentNavbar);
		parameter.put(INavbarKindInfoValue.S_ParentNavbar, parentnavbar);
		
		condition.append(" AND ").append(INavbarKindInfoValue.S_Status).append(" = :").append(INavbarKindInfoValue.S_Status);
		parameter.put(INavbarKindInfoValue.S_Status, "1");
		condition.append(" order by "+INavbarKindInfoValue.S_Sort);
		
		return NavbarKindInfoEngine.getBeans(condition.toString(), parameter);
	}
	/**
	 * 获取一级类目信息FORWEB
	 * @throws Exception
	 */
	public INavbarKindInfoValue[] getOneNavbarKindInfoForWeb(boolean bIshome) throws Exception {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		String kindlevel = "1";
		String status = "1";
		String ishome = "1";
		condition.append(" AND ").append(INavbarKindInfoValue.S_KindLevel).append(" = :").append(INavbarKindInfoValue.S_KindLevel);
		condition.append(" AND ").append(INavbarKindInfoValue.S_Status).append(" = :").append(INavbarKindInfoValue.S_Status);
		if(bIshome){
			condition.append(" AND ").append(INavbarKindInfoValue.S_IsHomeStatus).append(" = :").append(INavbarKindInfoValue.S_IsHomeStatus);
		}
		condition.append(" order by "+INavbarKindInfoValue.S_Sort).append(",").append(INavbarKindInfoValue.S_NavbarId).append(",").append(INavbarKindInfoValue.S_NavbarKindId);
		parameter.put(INavbarKindInfoValue.S_KindLevel, kindlevel);
		parameter.put(INavbarKindInfoValue.S_Status, status);
		parameter.put(INavbarKindInfoValue.S_IsHomeStatus, ishome);
		
		return NavbarKindInfoEngine.getBeans(condition.toString(), parameter);
	}
	/**
	 * 根据parent_navbar查询信息
	 * @throws Exception
	 */
	public INavbarKindInfoValue[] getValueByparentNavbarForWeb(long parentnavbar,boolean bIshome) throws Exception{
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		
		condition.append(" AND ").append(INavbarKindInfoValue.S_ParentNavbar).append(" = :").append(INavbarKindInfoValue.S_ParentNavbar);;
		parameter.put(INavbarKindInfoValue.S_ParentNavbar, parentnavbar);
		
		condition.append(" AND ").append(INavbarKindInfoValue.S_Status).append(" = :").append(INavbarKindInfoValue.S_Status);;
		parameter.put(INavbarKindInfoValue.S_Status, "1");
		
		if(bIshome){
			condition.append(" AND ").append(INavbarKindInfoValue.S_IsHomeStatus).append(" = :").append(INavbarKindInfoValue.S_IsHomeStatus);
			parameter.put(INavbarKindInfoValue.S_IsHomeStatus, "1");
		}
		condition.append(" order by "+INavbarKindInfoValue.S_Sort);
		return NavbarKindInfoEngine.getBeans(condition.toString(), parameter);
	}
}
