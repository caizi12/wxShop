package ngves.asiainfo.core.floor.dao.impl;

import java.util.Map;

import ngves.asiainfo.core.floor.bo.NavbarInfoEngine;
import ngves.asiainfo.core.floor.dao.interfaces.INavbarInfoDAO;
import ngves.asiainfo.core.floor.ivalues.INavbarInfoValue;
import ngves.asiainfo.core.floor.ivalues.INavbarKindInfoValue;

import org.apache.commons.lang.StringUtils;

public class NavbarInfoDAOImpl implements INavbarInfoDAO {

	public INavbarInfoValue[] queryNavbarInfoList(Map<String, Object> param) throws Exception {
		return NavbarInfoEngine.getBeans(null, param);
	}

	public void saveNavbarInfos(INavbarInfoValue[] values) throws Exception {
		 NavbarInfoEngine.save(values);
	}
	
	public void saveNavbarInfo(INavbarInfoValue value) throws Exception {
		 NavbarInfoEngine.save(value);
	}
	
	/**
	 * 管理平台查询分页使用
	 */
	public INavbarInfoValue[] queryNavbarInfoListForPage(Map<String, Object> param,int startNum,int endNum) throws Exception {
		StringBuffer sb=new StringBuffer(" 1=1 ");
		if(StringUtils.isNotBlank((String)param.get("navbarName"))){
			sb.append(" and "+INavbarInfoValue.S_NavbarName+" like '%"+(String)param.get("navbarName")+"%'");
		}
		sb.append(" order by "+INavbarInfoValue.S_Sort);
		return NavbarInfoEngine.getBeans(null, sb.toString(), param, startNum, endNum, false);
	}
	/**
	 * 管理平台查询总条数使用
	 */
	public int queryNavbarInfoCount(Map<String, Object> param) throws Exception {
		StringBuffer sb=new StringBuffer(" 1=1 ");
		if(StringUtils.isNotBlank((String)param.get("navbarName"))){
			sb.append(" and "+INavbarInfoValue.S_NavbarName+" like '%"+(String)param.get("navbarName")+"%'");
		}
		return NavbarInfoEngine.getBeansCount(sb.toString(), param);
	}
	
	/**
	 * 提供给门户，app，触屏版使用
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public INavbarInfoValue[] queryNavbarKindListForPortal(Map<String, Object> param) throws Exception {
		StringBuffer sb=new StringBuffer(" 1=1 ");
		if(StringUtils.isNotBlank((String)param.get("navbarName"))){
			sb.append(" and "+INavbarInfoValue.S_NavbarName+" like '%"+(String)param.get("navbarName")+"%'");
		}
		param.put("status", "1");
		sb.append(" and "+INavbarKindInfoValue.S_Status+" =:status");
		
		return NavbarInfoEngine.getBeans(sb.toString(), param);
	}
	
	public long getNewId() throws Exception{ 
		return NavbarInfoEngine.getNewId().longValue();
	}
	
	/**
	 * 根据navbar_id查询信息
	 * @throws Exception
	 */
	public INavbarInfoValue getNavbarInfoValueBynavbarId(long navbard) throws Exception {
		return NavbarInfoEngine.getBean(navbard);
	}
}

