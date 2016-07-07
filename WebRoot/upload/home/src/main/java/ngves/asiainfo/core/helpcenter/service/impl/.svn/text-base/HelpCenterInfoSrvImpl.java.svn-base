package ngves.asiainfo.core.helpcenter.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.common.bo.BusiInfoEngine;
import ngves.asiainfo.core.common.dao.interfaces.IClobInfoDAO;
import ngves.asiainfo.core.common.util.BusiInfoUtil;
import ngves.asiainfo.core.helpcenter.HelpCenterConstant;
import ngves.asiainfo.core.helpcenter.bo.HelpCenterinfoBean;
import ngves.asiainfo.core.helpcenter.dao.interfaces.IHelpCenterInfoDAO;
import ngves.asiainfo.core.helpcenter.ivalues.IHelpCenterinfoValue;
import ngves.asiainfo.core.helpcenter.service.interfaces.IHelpCenterInfoSrv;

import org.apache.commons.lang.StringUtils;

import com.ai.appframe2.service.ServiceFactory;

public class HelpCenterInfoSrvImpl implements IHelpCenterInfoSrv {

	private IHelpCenterInfoDAO helpCenterInfoDAO;

	public void setHelpCenterInfoDAO(IHelpCenterInfoDAO helpCenterInfoDAO) throws Exception {
		this.helpCenterInfoDAO = helpCenterInfoDAO;
	}

	public IHelpCenterinfoValue[] getAllIDonatedObjectsValue() throws Exception {
		return helpCenterInfoDAO.getAllHelpCenterinfoValues();
	}

	public IHelpCenterinfoValue queryHelpCenterinfoById(String helpId) throws Exception {
		IHelpCenterinfoValue helpValue = helpCenterInfoDAO.queryHelpCenterinfoById(Long.parseLong(helpId));
		
		// 如果不是父菜单，查询页面信息
		if (helpValue.getParentHelpId() != 0l) {
			IClobInfoDAO clobInfoDAO = (IClobInfoDAO) ServiceFactory.getService("ngves.asiainfo.core.clobInfoDAO");
			String desc=clobInfoDAO.getContent(Long.parseLong(helpId),HelpCenterConstant.TABLE_HELP_CENTRE_INFO);
			if(StringUtils.isNotBlank(desc)){
				helpValue.setHelpContent(desc);
			}
		}
		return helpValue;
	}

	public int queryHelpCenterinfoCount() throws Exception {
		return helpCenterInfoDAO.queryHelpCenterInfoCount();
	}

	public IHelpCenterinfoValue[] queryObjectInfo(int startIndex, int endIndex) throws Exception {
		return helpCenterInfoDAO.queryHelpCenterInfo(startIndex, endIndex);
	}

	public String saveHelpCenterinfo(IHelpCenterinfoValue helpCenterinfoValue,long StaffId,String ComType,long OrgId) throws Exception {
		String id = helpCenterInfoDAO.saveHelpCenterinfo(helpCenterinfoValue);
		// 保存成功
		if (StringUtils.isNotBlank(id)) {				
			//记录日志
			long busiInfoId = BusiInfoEngine.getNewId().longValue();
			BusiInfoUtil.recordBusiInfo(busiInfoId + "", CoreConstant.SYS_PARA_BUSI_TYPE_HELPCENTERINFO_ADD, -1,
	                "新增",CoreConstant.BUSI_INFO_OPT_TYPE_ADD,"规则ID："+id+";规则名称："+helpCenterinfoValue.getMenuName(),StaffId,ComType,OrgId);
		}
		return id;
	}

	public boolean saveHelpCenterinfoDesc(String objId, String tableName, String desc) throws Exception {
		IClobInfoDAO clobInfoDAO = (IClobInfoDAO) ServiceFactory.getService("ngves.asiainfo.core.clobInfoDAO");
		boolean flag = clobInfoDAO.saveClobInfo(Long.parseLong(objId), tableName, desc);
		return flag;
	}

	public String getHelpCenterinfoDesc(long objId) throws Exception {
		IClobInfoDAO clobInfoDAO = (IClobInfoDAO) ServiceFactory.getService("ngves.asiainfo.core.clobInfoDAO");
		return clobInfoDAO.getContent(objId, HelpCenterConstant.TABLE_HELP_CENTRE_INFO);
	}

	public String updateHelpCenterinfoDesc(IHelpCenterinfoValue helpCenterinfoValue,long StaffId,String ComType,long OrgId) throws Exception {
		Long id = helpCenterinfoValue.getHelpCentreId();
		IHelpCenterinfoValue oldhelpCenterinfoValue = helpCenterInfoDAO.queryHelpCenterinfoById(id);
		if (null==oldhelpCenterinfoValue.getMenuName()||StringUtils.isBlank(oldhelpCenterinfoValue.getMenuName())){
			return "2222";
		}
		IHelpCenterinfoValue oldValue = new HelpCenterinfoBean();
		oldValue.copy(oldhelpCenterinfoValue);

		oldhelpCenterinfoValue.setIsShow(helpCenterinfoValue.getIsShow());
		oldhelpCenterinfoValue.setMenuName(helpCenterinfoValue.getMenuName());
		// oldhelpCenterinfoValue.setParentHelpId(helpCenterinfoValue.getParentHelpId());
		oldhelpCenterinfoValue.setSortId(helpCenterinfoValue.getSortId());
		oldhelpCenterinfoValue.setUpdateTime(new Timestamp(new Date().getTime()));
		String value = helpCenterInfoDAO.updateHelpCenterInfo(oldhelpCenterinfoValue);

		// 记录日志
		long busiInfoId = BusiInfoEngine.getNewId().longValue();
		BusiInfoUtil.recordBusiInfo(busiInfoId + "", CoreConstant.SYS_PARA_BUSI_TYPE_HELPCENTERINFO_MODIFY, -1, "修改",
				CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY_KIND, "规则ID：" + id + ";规则名称：" + helpCenterinfoValue.getMenuName(), StaffId,
				ComType, OrgId);
		BusiInfoUtil.recordBusiDetail(busiInfoId + "", new Object[] { oldValue }, new Object[] { oldhelpCenterinfoValue },
				"HelpCentreId");
		
		return value;
	}

	public String deleteHelpCenterinfo(Long helpCenterId,String hasChild,long StaffId,String ComType,long OrgId) throws Exception{
		List<IHelpCenterinfoValue>   helpCenterinfoChildValues=null;
		IHelpCenterinfoValue helpCenterinfoValue=helpCenterInfoDAO.queryHelpCenterinfoById(helpCenterId);
		if (null==helpCenterinfoValue.getMenuName()||StringUtils.isBlank(helpCenterinfoValue.getMenuName())){
			return "2222";
		}
		//父菜单下面有子菜单
		if(hasChild.equals("2")){
			helpCenterinfoChildValues=helpCenterInfoDAO.queryHelpCenterinfoByParentId(helpCenterId);
		}
		String flag = helpCenterInfoDAO.deleteHelpCenterinfo(helpCenterId);
		
		/**
		 * 删除成功，缓存数据从数据库中更新
		 */
		if (StringUtils.isNotBlank(flag)&&flag.equals("1111")) {
			//删除子菜单对应在clob_info表里面的内容
			if(helpCenterinfoValue.getParentHelpId()!=0l){
				IClobInfoDAO clobInfoDAO = (IClobInfoDAO) ServiceFactory.getService("ngves.asiainfo.core.clobInfoDAO");
				clobInfoDAO.deleteClobInfo(helpCenterinfoValue.getHelpCentreId(), HelpCenterConstant.TABLE_HELP_CENTRE_INFO);
			}else{
				if(null!=helpCenterinfoChildValues&&!helpCenterinfoChildValues.isEmpty()){
					IClobInfoDAO clobInfoDAO = (IClobInfoDAO) ServiceFactory.getService("ngves.asiainfo.core.clobInfoDAO");
					for(IHelpCenterinfoValue helpchild:helpCenterinfoChildValues){
						clobInfoDAO.deleteClobInfo(helpchild.getHelpCentreId(), HelpCenterConstant.TABLE_HELP_CENTRE_INFO);
					}
				}
			}
			
			//记录日志
			long busiInfoId = BusiInfoEngine.getNewId().longValue();
			BusiInfoUtil.recordBusiInfo(busiInfoId + "", CoreConstant.SYS_PARA_BUSI_TYPE_HELPCENTERINFO_DELETE, -1,
	                "删除",CoreConstant.BUSI_INFO_OPT_TYPE_DELETE,"规则ID："+helpCenterId+";规则名称："+helpCenterinfoValue.getMenuName(),StaffId,ComType,OrgId);
		}
		return flag;
	}

	/**
	 * 按顺序查出在门户展示的父菜单，子菜单帮助信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<IHelpCenterinfoValue> queryHelpCenterinfoForPortal() throws Exception {
		return helpCenterInfoDAO.queryHelpCenterinfoForPortal(true);
	}

	public List<IHelpCenterinfoValue> queryHelpCenterinfoByParentId(
			Long parentId) throws Exception {
		return helpCenterInfoDAO.queryHelpCenterinfoByParentId(parentId);
	}
	
	/**
	 * 按顺序查出在管理平台展示的父菜单，子菜单帮助信息
	 * @return
	 * @throws Exception
	 */
	public List<IHelpCenterinfoValue> queryHelpCenterinfoForMgt()
			throws Exception {
		return helpCenterInfoDAO.queryHelpCenterinfoForPortal(false);
	}
	
}
