package ngves.asiainfo.core.helpcenter.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ai.appframe2.common.ServiceManager;
import ngves.asiainfo.core.helpcenter.bo.HelpCenterinfoBean;
import ngves.asiainfo.core.helpcenter.bo.HelpCenterinfoEngine;
import ngves.asiainfo.core.helpcenter.dao.interfaces.IHelpCenterInfoDAO;
import ngves.asiainfo.core.helpcenter.ivalues.IHelpCenterinfoValue;


public class HelpCenterInfoDAOImpl implements IHelpCenterInfoDAO {

	public IHelpCenterinfoValue[] getAllHelpCenterinfoValues() throws Exception {
		return HelpCenterinfoEngine.getBeans(null, null);
	}

	public IHelpCenterinfoValue[] queryHelpCenterInfo(int startIndex,
			int endIndex) throws Exception {
		StringBuffer sql = new StringBuffer();
		Map<String, String> params = new HashMap<String, String>();

		try {
			sql.append(" order by SORT_ID,MENU_NAME ASC");
			return HelpCenterinfoEngine.getBeans(null, sql.toString(), params,
					startIndex, endIndex, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int queryHelpCenterInfoCount() throws Exception {
		StringBuffer sql = new StringBuffer();
		Map<String, String> params = new HashMap<String, String>();

		try {
			return HelpCenterinfoEngine.getBeansCount(sql.toString(), params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public IHelpCenterinfoValue queryHelpCenterinfoById(long id)
			throws Exception {
		return HelpCenterinfoEngine.getBean(id);
	}

	public String saveHelpCenterinfo(IHelpCenterinfoValue helpCenterinfoValue)
			throws Exception {
		String id = "";
		if (helpCenterinfoValue.isNew()) {
			id = HelpCenterinfoEngine.getNewId().toString();
			helpCenterinfoValue.setHelpCentreId(Long.parseLong(id));
		}
		HelpCenterinfoEngine.save(helpCenterinfoValue);
		return id;
	}

	public String updateHelpCenterInfo(IHelpCenterinfoValue helpCenterinfoValue)
			throws Exception {
		Long id=helpCenterinfoValue.getHelpCentreId();
		HelpCenterinfoEngine.save(helpCenterinfoValue);
		return  id.toString();
	}

	/**
	 * 查询父菜单下面的所有子菜单
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<IHelpCenterinfoValue> queryHelpCenterinfoByParentId(Long parentId) throws Exception{	
		StringBuffer sql = new StringBuffer();
		Map<String,Object> parameterMap=new HashMap<String,Object>();
		sql.append(HelpCenterinfoBean.S_ParentHelpId).append("=:").append(HelpCenterinfoBean.S_ParentHelpId).append(" ");
		parameterMap.put(HelpCenterinfoBean.S_ParentHelpId, parentId);
		IHelpCenterinfoValue[] helpCenterinfoValue=HelpCenterinfoEngine.getBeans(sql.toString(), parameterMap);             
		return Arrays.asList(helpCenterinfoValue);
	}
	/**
	 * 删除菜单信息
	 */
	public String deleteHelpCenterinfo(Long helpCenterId)throws Exception {
		
		StringBuffer sql = new StringBuffer();
		sql.append("  DELETE  FROM  HELP_CENTRE_INFO                        \n");
		sql.append("  WHERE PARENT_HELP_ID = ?    OR     HELP_CENTRE_ID=?   \n");
		
		Connection conn = null;
		PreparedStatement psts = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			psts = conn.prepareStatement(sql.toString());
			psts.setLong(1, helpCenterId);
			psts.setLong(2, helpCenterId);
			// 执行更新操作
			int m=psts.executeUpdate();
			if(m>0){
				return "1111";
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (psts != null) {
				psts.close();
			}
			if (conn != null) {
				conn.close();
			}
		}              
		   return "0000";
	}
	
	/**
	 * 按顺序查出在门户展示的父菜单，子菜单帮助信息
	 * para isShow 为true时只查询门户展示的信息，false时查询所有信息
	 * @return
	 * @throws Exception
	 */
	public List<IHelpCenterinfoValue> queryHelpCenterinfoForPortal(boolean isShow) throws Exception{
		StringBuffer sql = new StringBuffer();
		sql.append("  SELECT *                                          \n");
		sql.append("    FROM HELP_CENTRE_INFO                           \n");
		if(isShow){
		sql.append("   WHERE IS_SHOW = 1                                \n");
		}
		sql.append("   START WITH PARENT_HELP_ID = '0'                  \n");
		sql.append("  CONNECT BY PRIOR HELP_CENTRE_ID = PARENT_HELP_ID  \n");
		sql.append("   ORDER SIBLINGS BY SORT_ID,MENU_NAME              \n");
		IHelpCenterinfoValue[] helpCenterinfoValue=HelpCenterinfoEngine.getBeansFromSql(sql.toString(), null);              
		return Arrays.asList(helpCenterinfoValue);
	}
}
