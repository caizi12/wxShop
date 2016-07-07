package ngves.asiainfo.core.ware.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ngves.asiainfo.core.ware.ivalues.IQBOAllWareDescValue;
import ngves.asiainfo.core.ware.dao.interfaces.WareExportDAO;
import ngves.asiainfo.core.ware.service.interfaces.IWareExportSrv;
import ngves.asiainfo.util.StringUtil;

@SuppressWarnings("unchecked")
public class WareExportSrvImpl implements IWareExportSrv {

	protected int ROWS_NUM_ZERO = 0;

	private WareExportDAO wareExportDAO = null;

	public void setWareExportDAO(WareExportDAO wareExportDAO) throws Exception {
		this.wareExportDAO = wareExportDAO;
	}

	public int countNewQueryWareInfo(String lstBrand, String lstProvinceCode, String lstSupplier, String lstWareFirstKind, String lstWareKind,
			String lstWareParentKind, String lstWareStatus, String staffId, String warecode, String warename, String comType, String queryStaffId,String wareKindInfoId)
			throws Exception {

		List result = processNewCondition(lstBrand, lstProvinceCode, lstSupplier, lstWareFirstKind, lstWareKind, lstWareParentKind, lstWareStatus, staffId,
				warecode, warename, comType, queryStaffId,wareKindInfoId);

		// List newResult2 = addCondUser(result, userBrand, userLevel);

		int num = wareExportDAO.countWareInfos((String) result.get(0), (Map) result.get(1));
		return num;
	}

	public IQBOAllWareDescValue[] getNewQueryWareInfo(String lstBrand, String lstProvinceCode, String lstSupplier, String lstWareFirstKind, String lstWareKind,
			String lstWareParentKind, String lstWareStatus, String StaffId, String warecode, String warename, String comType, String queryStaffId,String wareKindInfoId,
			int startIndex, int endIndex) throws Exception {

		List result = processNewCondition(lstBrand, lstProvinceCode, lstSupplier, lstWareFirstKind, lstWareKind, lstWareParentKind, lstWareStatus, StaffId,
				warecode, warename, comType, queryStaffId,wareKindInfoId);
		// List result = null;//TODO
		// List newResult2 = addCondUser(result, userBrand, userLevel);

		String cond = result.get(0) + "";
		result.set(0, cond);
		IQBOAllWareDescValue[] allWareDescs = wareExportDAO.queryWareInfos((String) result.get(0), (Map) result.get(1), startIndex, endIndex);

		return allWareDescs;
	}

	/**
	 * “咨询投诉查询”功能专用条件拼装方法 （2010-12-27）
	 */
	private List processNewCondition(String lstBrand, String lstProvinceCode, String lstSupplier, String lstWareFirstKind, String lstWareKind,
			String lstWareParentKind, String lstWareStatus, String StaffId, String warecode, String warename, String comType, String queryStaffId,String wareKindInfoId) {
		List result = new ArrayList();
		StringBuffer condition = new StringBuffer(" 1=1");
		Map<String, String> parameter = new HashMap<String, String>();


	 if (!StringUtil.isBlank(lstSupplier)&&!"-1".equals(lstSupplier)) {
		condition.append(" AND ").append(IQBOAllWareDescValue.S_PartnerId).append("=:").append(IQBOAllWareDescValue.S_PartnerId);
		parameter.put(IQBOAllWareDescValue.S_PartnerId, lstSupplier);
		} 
		 
		 if (!StringUtil.isBlank(lstBrand)&&!"-1".equals(lstBrand)) {
				condition.append(" AND ").append(IQBOAllWareDescValue.S_BrandId).append("=:").append(IQBOAllWareDescValue.S_BrandId);
				parameter.put(IQBOAllWareDescValue.S_BrandId, lstBrand);
				}
		 
		 if (!StringUtil.isBlank(lstProvinceCode)&&!"-1".equals(lstProvinceCode)) {
				condition.append(" AND ").append(IQBOAllWareDescValue.S_ProvCode).append("=:").append(IQBOAllWareDescValue.S_ProvCode);
				parameter.put(IQBOAllWareDescValue.S_ProvCode, lstProvinceCode);
				}
		 
		 if (!StringUtil.isBlank(lstWareFirstKind)&&!"-1".equals(lstWareFirstKind)) {
				condition.append(" AND ").append(IQBOAllWareDescValue.S_WareFirstKindId).append("=:").append(IQBOAllWareDescValue.S_WareFirstKindId);
				parameter.put(IQBOAllWareDescValue.S_WareFirstKindId, lstWareFirstKind);
				}
		 
		 if (!StringUtil.isBlank(lstWareKind)&&!"-1".equals(lstWareKind)) {
				condition.append(" AND ").append(IQBOAllWareDescValue.S_WareKindId).append("=:").append(IQBOAllWareDescValue.S_WareKindId);
				parameter.put(IQBOAllWareDescValue.S_WareKindId, lstWareKind);
				}
		 
		 if (!StringUtil.isBlank(lstWareParentKind)&&!"-1".equals(lstWareParentKind)) {
				condition.append(" AND ").append(IQBOAllWareDescValue.S_WareKindParentId).append("=:").append(IQBOAllWareDescValue.S_WareKindParentId);
				parameter.put(IQBOAllWareDescValue.S_WareKindParentId, lstWareParentKind);
				}
		 
		 if (!StringUtil.isBlank(lstWareStatus)&&!"-1".equals(lstWareStatus)) {
			 
			
			 condition.append(" and " + IQBOAllWareDescValue.S_WareStatus + " in ( " + lstWareStatus + " )");
		        	
		        
				}
		  

		 if (!StringUtil.isBlank(warecode)) {
				condition.append(" AND ").append(IQBOAllWareDescValue.S_WareCode).append(" like :wareCode");
				parameter.put("wareCode", "%" + warecode + "%");
				}
		 
		 
		 if (!StringUtil.isBlank(warename)) {
				condition.append(" AND ").append(IQBOAllWareDescValue.S_WareName).append(" like :wareName");
				parameter.put("wareName", "%"+warename+"%");
				}
		if (!StringUtil.isBlank(wareKindInfoId)&&!"-1".equals(wareKindInfoId)) {
				condition.append(" AND ").append(IQBOAllWareDescValue.S_WareKindInfo).append("=:").append(IQBOAllWareDescValue.S_WareKindInfo);
				parameter.put(IQBOAllWareDescValue.S_WareKindInfo, wareKindInfoId);
		} 


		result.add(condition.toString());
		result.add(parameter);
		System.out.println(condition.toString() + parameter);
		return result;
	}

}
