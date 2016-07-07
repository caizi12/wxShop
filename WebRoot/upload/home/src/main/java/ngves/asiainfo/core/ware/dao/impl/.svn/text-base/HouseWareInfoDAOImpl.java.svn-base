package ngves.asiainfo.core.ware.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.ai.appframe2.common.ServiceManager;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.ware.WareConstant;
import ngves.asiainfo.core.ware.bo.QBOHouseWareInfoEngine;
import ngves.asiainfo.core.ware.dao.interfaces.IHouseWareInfoDAO;
import ngves.asiainfo.core.ware.ivalues.IQBOHouseWareInfoValue;
import ngves.asiainfo.util.JDBCUtils;
import ngves.asiainfo.util.StringUtil;


/**
 * 正常品库存导出管理
 *  
 *
 */
public class HouseWareInfoDAOImpl implements IHouseWareInfoDAO {
	
	
	//正常品库存导出
	public IQBOHouseWareInfoValue[] getHouseWareInfo(String ware_code,
			String ware_name, String ware_status, String ware_kind,
			String ware_kind_parent, String ware_first_kind, String ware_brand,
			String provider_id, String storager_id, String warehouse_id,
			String warehouse_type, String provinceCode,String comType,String staffId,String ware_kind_info, int startNum, int endNum)
			throws Exception {

		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String, String> parameter = new HashMap<String, String>();

		if (!StringUtil.isBlank(ware_code) && !"-1".equals(ware_code)) {
			condition.append(" and " + IQBOHouseWareInfoValue.S_WareCode
					+ " like '%" + ware_code + "%'");
		}

		if (!StringUtil.isBlank(ware_name)) {
			condition.append(" and " + IQBOHouseWareInfoValue.S_WareName
					+ " like '%" + ware_name + "%'");
		}

		if (!"".equals(ware_status) && !"-1".equals(ware_status)) {
			condition.append(" and " + "WARE_STATUS_CODE"
					+ "=:wareStatus ");
			parameter.put("wareStatus", ware_status);
		}

		if (!"".equals(ware_kind) && !"-1".equals(ware_kind)) {
			condition.append(" and " + IQBOHouseWareInfoValue.S_WareKindId
					+ "=:wareKind ");
			parameter.put("wareKind", ware_kind);
		} else {// 没礼品小类信息采用默认小类查询，避免重复
			condition.append(" and " + IQBOHouseWareInfoValue.S_IsDefaultKind
					+ "=:defaultKind ");
			parameter.put("defaultKind", WareConstant.WARE_DEFAULT_KIND);
		}

		if (!"".equals(ware_kind_parent) && !"-1".equals(ware_kind_parent)) {
			condition.append(" and "
					+ IQBOHouseWareInfoValue.S_WareKindParentId
					+ "=:wareKindParent ");
			parameter.put("wareKindParent", ware_kind_parent);
		}

		if (!"".equals(ware_first_kind) && !"-1".equals(ware_first_kind)) {
			condition.append(" and " + IQBOHouseWareInfoValue.S_WareFirstKindId
					+ "=:wareFirstKind ");
			parameter.put("wareFirstKind", ware_first_kind);
		}

		if (!"".equals(ware_brand) && !"-1".equals(ware_brand)) {
			condition.append(" and " + IQBOHouseWareInfoValue.S_WareBrandId
					+ "=:wareBrandId ");
			parameter.put("wareBrandId", ware_brand);
		}

		if (!StringUtil.isBlank(provider_id) && !"-1".equals(provider_id)) {
			condition.append(" and " + IQBOHouseWareInfoValue.S_ProviderId
					+ "=:providerID ");
			parameter.put("providerID", provider_id);
		}

		if (!"".equals(storager_id) && !"-1".equals(storager_id)) {
			condition.append(" and " + IQBOHouseWareInfoValue.S_StoragerId
					+ "=:storagerID ");
			parameter.put("storagerID", storager_id);
		}
		if (!StringUtil.isBlank(ware_kind_info) && !"-1".equals(ware_kind_info)) {
			condition.append(" and " + IQBOHouseWareInfoValue.S_WareKindInfoId+ "=:ware_kind_info ");
			parameter.put("ware_kind_info", ware_kind_info);
		}
		// if (!"".equals(logistics_id) && !"-1".equals(logistics_id)) {
		// condition.append(" and " + IQBOHouseWareInfoValue.S_LogisticsId +
		// "=:logisticsID ");
		// parameter.put("logisticsID", logistics_id);
		// }

		if (!"".equals(warehouse_id) && !"-1".equals(warehouse_id)) {
			condition.append(" and " + IQBOHouseWareInfoValue.S_WarehouseId
					+ "=:warehouseID ");
			parameter.put("warehouseID", warehouse_id);
		}

		if (!"".equals(warehouse_type) && !"-1".equals(warehouse_type)) {
			condition.append(" and " + IQBOHouseWareInfoValue.S_WarehouseType
					+ "=:warehouseType ");
			parameter.put("warehouseType", warehouse_type);
		}

		// 根据角色判断是否省中心
		if (!StringUtil.isBlank(provinceCode)&& !"-1".equals(provinceCode)) {
			//省管理员
			if (CoreConstant.SYS_PARA_PARTNER_TYPE_MOBILE_PROVINCE.equals(comType)) {
				 if("00".equals(provinceCode)){//当管理员选择省份为总部即全网仓库则查配送到本省的库存，和原业务保持一致
					 //设置为本省
					String  userProvinceCode =this.getStaffProvince(staffId);
					condition.append(" AND " + IQBOHouseWareInfoValue.S_WarehouseId + " IN (SELECT DISTINCT WAREHOUSE_ID FROM WAREHOUSE_LOGISTIC_RLT ")
					.append("WHERE RLT_STATE='1' AND PROVINCE_CODE='").append(userProvinceCode).append("')");
					//查询全网仓库
					 condition.append(" AND " + IQBOHouseWareInfoValue.S_ProvinceCode + "=:provinceCode");
					 parameter.put("provinceCode", provinceCode);
					
				 }else{//查本省仓库的库存
					 condition.append(" AND " + IQBOHouseWareInfoValue.S_ProvinceCode + "=:provinceCode");
					 parameter.put("provinceCode", provinceCode);
				 }
			}else{
			   //查仓库所在省的库存
				 condition.append(" AND " + IQBOHouseWareInfoValue.S_ProvinceCode + "=:provinceCode");
				 parameter.put("provinceCode", provinceCode);
			}
		}
		IQBOHouseWareInfoValue[] qBOHouseWareInfoBean = QBOHouseWareInfoEngine.getBeans(null, condition.toString(),	parameter, startNum, endNum, false);
		return qBOHouseWareInfoBean;

	}

	public int getHouseWareInfoCount(String ware_code, String ware_name,
			String ware_status, String ware_kind, String ware_kind_parent,
			String ware_first_kind, String ware_brand, String provider_id,
			String storager_id, String warehouse_id, String warehouse_type,
			String provinceCode,String comType,String staffId,String ware_kind_info) throws Exception {

		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String, String> parameter = new HashMap<String, String>();

		if (!StringUtil.isBlank(ware_code)&& !"-1".equals(ware_code)) {
			condition.append(" and " + IQBOHouseWareInfoValue.S_WareCode
					+ " like '%" + ware_code + "%'");
		}

		if (!StringUtil.isBlank(ware_name)) {
			condition.append(" and " + IQBOHouseWareInfoValue.S_WareName
					+ " like '%" + ware_name + "%'");
		}

		if (!"".equals(ware_status) && !"-1".equals(ware_status)) {
			condition.append(" and " + "WARE_STATUS_CODE"
					+ "=:wareStatus ");
			parameter.put("wareStatus", ware_status);
		}

		if (!"".equals(ware_kind) && !"-1".equals(ware_kind)) {
			condition.append(" and " + IQBOHouseWareInfoValue.S_WareKindId
					+ "=:wareKind ");
			parameter.put("wareKind", ware_kind);
		} else {
			condition.append(" and " + IQBOHouseWareInfoValue.S_IsDefaultKind
					+ "=:defaultKind ");
			parameter.put("defaultKind", WareConstant.WARE_DEFAULT_KIND);
		}

		if (!"".equals(ware_kind_parent) && !"-1".equals(ware_kind_parent)) {
			condition.append(" and "
					+ IQBOHouseWareInfoValue.S_WareKindParentId
					+ "=:wareKindParent ");
			parameter.put("wareKindParent", ware_kind_parent);
		}

		if (!"".equals(ware_first_kind) && !"-1".equals(ware_first_kind)) {
			condition.append(" and " + IQBOHouseWareInfoValue.S_WareFirstKindId
					+ "=:wareFirstKind ");
			parameter.put("wareFirstKind", ware_first_kind);
		}

		if (!"".equals(ware_brand) && !"-1".equals(ware_brand)) {
			condition.append(" and " + IQBOHouseWareInfoValue.S_WareBrandId
					+ "=:wareBrandId ");
			parameter.put("wareBrandId", ware_brand);
		}

		if (!StringUtil.isBlank(provider_id) && !"-1".equals(provider_id)) {
			condition.append(" and " + IQBOHouseWareInfoValue.S_ProviderId
					+ "=:providerID ");
			parameter.put("providerID", provider_id);
		}
		if (!StringUtil.isBlank(ware_kind_info) && !"-1".equals(ware_kind_info)) {
			condition.append(" and " + IQBOHouseWareInfoValue.S_WareKindInfoId+ "=:ware_kind_info ");
			parameter.put("ware_kind_info", ware_kind_info);
		}
		if (!"".equals(storager_id) && !"-1".equals(storager_id)) {
			condition.append(" and " + IQBOHouseWareInfoValue.S_StoragerId
					+ "=:storagerID ");
			parameter.put("storagerID", storager_id);
		}

		// if (!"".equals(logistics_id) && !"-1".equals(logistics_id)) {
		// condition.append(" and " + IQBOHouseWareInfoValue.S_LogisticsId +
		// "=:logisticsID ");
		// parameter.put("logisticsID", logistics_id);
		// }

		if (!"".equals(warehouse_id) && !"-1".equals(warehouse_id)) {
			condition.append(" and " + IQBOHouseWareInfoValue.S_WarehouseId
					+ "=:warehouseID ");
			parameter.put("warehouseID", warehouse_id);
		}

		if (!"".equals(warehouse_type) && !"-1".equals(warehouse_type)) {
			condition.append(" and " + IQBOHouseWareInfoValue.S_WarehouseType
					+ "=:warehouseType ");
			parameter.put("warehouseType", warehouse_type);
		}
		// 根据用户的类型判断是否是省管理员查询
		if (!StringUtil.isBlank(provinceCode)&& !"-1".equals(provinceCode)) {
			//省管理员
			if (CoreConstant.SYS_PARA_PARTNER_TYPE_MOBILE_PROVINCE.equals(comType)) {
				 if("00".equals(provinceCode)){//当管理员选择省份为总部即全网仓库则查配送到本省的库存，和原业务保持一致
					 //设置为本省
					String userProvinceCode =this.getStaffProvince(staffId);
					condition.append(" AND " + IQBOHouseWareInfoValue.S_WarehouseId + " IN (SELECT DISTINCT WAREHOUSE_ID FROM WAREHOUSE_LOGISTIC_RLT ")
					.append("WHERE RLT_STATE='1' AND PROVINCE_CODE='").append(userProvinceCode).append("')");
					
					//查询全网仓库
					 condition.append(" AND " + IQBOHouseWareInfoValue.S_ProvinceCode + "=:provinceCode");
					 parameter.put("provinceCode", provinceCode);
					 
				 }else{//查本省仓库的库存
					 condition.append(" AND " + IQBOHouseWareInfoValue.S_ProvinceCode + "=:provinceCode");
					 parameter.put("provinceCode", provinceCode);
				 }
			}else{
			   //查仓库所在省的库存
				 condition.append(" AND " + IQBOHouseWareInfoValue.S_ProvinceCode + "=:provinceCode");
				 parameter.put("provinceCode", provinceCode);
			}
		}
		return QBOHouseWareInfoEngine.getBeansCount(condition.toString(),
				parameter);
	}
	
	/**
	 * 根据员工号查员工所在的省份
	 * @param staffId
	 * @return
	 * @throws Exception
	 */
	public String getStaffProvince(String staffId)  throws Exception{
		String querySql=" select po.province_code  from sys_staff_org_relat so,province_org_rlt po "+
	     " where so.organize_id=po.org_id and so.staff_id= ?";
		Connection conn = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		String provinceCode="";
		try {
			conn = ServiceManager.getSession().getConnection();
			ps = conn.prepareStatement(querySql.toString());
			ps.setLong(1, Long.valueOf(staffId));
			rs = ps.executeQuery();
			while (rs!=null&&rs.next()) {
				provinceCode=rs.getString("province_code");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			JDBCUtils.closeAll(conn, ps, rs);
		}
		return provinceCode;
	}
}
