package ngves.asiainfo.core.award.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

import com.ai.appframe2.common.ServiceManager;

import ngves.asiainfo.CommnException;
import ngves.asiainfo.core.award.bo.AwardLevelInfoEngine;
import ngves.asiainfo.core.award.bo.QBOAwardLevelRLTWareEngine;
import ngves.asiainfo.core.award.bo.QBOWareQueryInfoEngine;
import ngves.asiainfo.core.award.dao.interfaces.IAwardLevelInfoDAO;
import ngves.asiainfo.core.award.ivalues.IAwardLevelInfoValue;
import ngves.asiainfo.core.award.ivalues.IQBOAwardLevelRLTWareValue;
import ngves.asiainfo.core.award.ivalues.IQBOWareQueryInfoValue;
import ngves.asiainfo.core.ware.bo.WareInfoBean;
import ngves.asiainfo.core.ware.bo.WareInfoEngine;
import ngves.asiainfo.core.ware.bo.WareInfoPortalEngine;
import ngves.asiainfo.core.ware.ivalues.IWareInfoPortalValue;
import ngves.asiainfo.util.StringUtil;

public class AwardLevelInfoDAOImpl implements IAwardLevelInfoDAO {

	public long addAwardLevelInfos(IAwardLevelInfoValue[] awardLevelInfoValues)
			throws Exception {
		long awardLevelId = -1;
		for (IAwardLevelInfoValue value : awardLevelInfoValues) {
			if (value.isNew()) {
				if (value.getAwardLevelId() == 0l) {
					awardLevelId = AwardLevelInfoEngine.getNewId().longValue();
					value.setAwardLevelId(awardLevelId);
				}
			}
		}
		AwardLevelInfoEngine.saveBatch(awardLevelInfoValues);
		return awardLevelId;
	}

	public int countWareInfosByWareName(String awardId,String wareName) throws Exception {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("awardId", Long.parseLong(awardId));
		if (!StringUtil.isBlank(wareName)) {
			wareName = wareName.trim();
			sql.append(IQBOWareQueryInfoValue.S_WareName).append(" LIKE :")
					.append(IQBOWareQueryInfoValue.S_WareName).append(" ");
			params.put(IQBOWareQueryInfoValue.S_WareName, "%" + wareName + "%");
		}
		try {
			return QBOWareQueryInfoEngine.getBeansCount(sql.toString(), params);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public IQBOWareQueryInfoValue[] findAllWareInfosByWareName(String awardId,String wareName,
			int startIndex, int endIndex) throws Exception {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("awardId", Long.parseLong(awardId));
		if (!StringUtil.isBlank(wareName)) {
			wareName = wareName.trim();
			sql.append(IQBOWareQueryInfoValue.S_WareName).append(" LIKE :")
					.append(IQBOWareQueryInfoValue.S_WareName).append(" ");
			params.put(IQBOWareQueryInfoValue.S_WareName, "%" + wareName + "%");
		}
		try {
			return QBOWareQueryInfoEngine.getBeans(null, sql.toString(),
					params, startIndex, endIndex, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public IAwardLevelInfoValue[] findByAwardId(Long awardId) throws Exception {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> params = new HashMap<String, Object>();
		if (awardId > 0l) {
			sql.append(IAwardLevelInfoValue.S_AwardId).append(" =:").append(
					IAwardLevelInfoValue.S_AwardId).append(" ");
			params.put(IAwardLevelInfoValue.S_AwardId, awardId);
		}
		return AwardLevelInfoEngine.getBeans(sql.toString(), params);
	}

	public void deleteAwardLevelInfos(String awardId) throws Exception {
		IAwardLevelInfoValue[] avalues = findByAwardId(Long.parseLong(awardId));
		if (null != avalues && avalues.length > 0) {
			for (IAwardLevelInfoValue value : avalues) {
				value.delete();
			}
			AwardLevelInfoEngine.saveBatch(avalues);
		}
	}

	public long updateAwardLevelInfos(
			IAwardLevelInfoValue[] awardLevelInfoValues) throws Exception {
		AwardLevelInfoEngine.saveBatch(awardLevelInfoValues);
		return awardLevelInfoValues[0].getAwardId();
	}

	public IQBOAwardLevelRLTWareValue[] findAllLevelInfosByAwardId(
			String awardId) throws Exception {

		StringBuffer sql = new StringBuffer();
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(awardId)) {
			sql.append(IQBOAwardLevelRLTWareValue.S_AwardId).append(" =:")
					.append(IQBOAwardLevelRLTWareValue.S_AwardId).append(" ");
			params.put(IQBOAwardLevelRLTWareValue.S_AwardId, Long
					.parseLong(awardId));
		}
		sql.append("ORDER BY  LEVEL_SORT  ASC");
		return QBOAwardLevelRLTWareEngine.getBeans(sql.toString(), params);
	}


	public IWareInfoPortalValue[] getShowLevelAwardById(String awardId)
			throws Exception {
		if(!StringUtil.isBlank(awardId)){
			StringBuffer sql = new StringBuffer().append(
			" select wip.*                              		").append(
			"  from ware_info_portal wip, award_level_info ali  ").append(
			" where ali.ware_id = wip.ware_id                   ").append(
			"   and ali.is_show_ware = '1'                 		").append(
			"   and ali.award_id = ").append(awardId).append(
			"  order by ali.level_sort                         	");
			
			return WareInfoPortalEngine.getBeansFromSql(sql.toString(), null);
		}else{
			return null;
		}
		
	}

	public long getHouseWareCountByWareId(Long wareId) throws Exception {
		long wareHouseCount = 0l;
		WareInfoBean wareInfo = WareInfoEngine.getBean(wareId);
		try {
			if(StringUtils.isBlank(wareInfo.getWareStorageType())){
				return 0l;
			}
			//0  大区仓 
			if(wareInfo.getWareStorageType().equals("0")){
				String sql1=QUERY_AWARD_WARE__HOUSE_DQ;
				wareHouseCount = getHouseCount(sql1,wareId,0);
				
			}
			//1中心仓
			if(wareInfo.getWareStorageType().equals("1")){
				String sql2=QUERY_AWARD_WARE__HOUSE_ZX;
				wareHouseCount = getHouseCount(sql2,wareId,wareInfo.getWarehouseId());
				
			}
			//2 虚拟仓
			if(wareInfo.getWareStorageType().equals("2")){
				String sql3=QUERY_AWARD_WARE__HOUSE_XN;
				wareHouseCount = getHouseCount(sql3,wareId,wareInfo.getWarehouseId());
				//System.out.println("可兑换数量"+wareHouseCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return wareHouseCount;
	}
	/*
	 * 获取数据库连接
	 * 
	 * @return
	 * @throws CommnException
	 */
	private static Connection getDBConnection() throws CommnException {
		Connection conn = null;
		try {
			conn = ServiceManager.getSession().getConnection();
		} catch (Exception e) {
			throw new CommnException("can not gain db connection", e);
		}
		return conn;
	}
	/**
	 * 关闭数据库连接
	 * 
	 * @param conn
	 * @throws CommnException
	 */
	private static void closeDBConnetion(Connection conn) throws CommnException {
		try {
			if (null != conn)
				conn.close();
		} catch (Exception e) {
			try {
				if (null != conn)
					conn.close();
			} catch (Exception ex) {
				throw new CommnException("can not close db connection", ex);
			}
		}
	}

	/**
	 * 
	 * @param sql sql语句
	 * @param waraId 礼品id
	 * @param wareStorageType 仓库类型
	 * @return 库存量
	 * @throws Exception
	 */
	public static long getHouseCount(String sql,long wareId,long wareHouseId) throws Exception{
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		long wareHouseCount = 0;
		try {
			conn = getDBConnection(); //数据库连接
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, wareId);
			if(wareHouseId>0){
				psmt.setLong(2, wareHouseId);
			}			
			rs = psmt.executeQuery();
			if (null != rs) {
				while (rs.next()) {
					wareHouseCount = rs.getLong(1);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {//处理连接关闭
				if (null != psmt) {
					psmt.close();
				}
				closeDBConnetion(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return wareHouseCount;
	}	
	
	public IAwardLevelInfoValue queryWareName(String wareCode) throws Exception {
		StringBuffer cond = new StringBuffer();
		Map<String, String> params = new HashMap<String, String>();
		cond.append(" 1=1");
		if (!StringUtil.isBlank(wareCode)) {
			wareCode = wareCode.trim();
			cond.append(" AND " + IAwardLevelInfoValue.S_WareNickname).append(
					" = ").append(IAwardLevelInfoValue.S_WareNickname);

		}
		params.put(IAwardLevelInfoValue.S_WareNickname, wareCode);
		IAwardLevelInfoValue[] awardLevelInfoValue = AwardLevelInfoEngine
				.getBeans(cond.toString(), params);
		return awardLevelInfoValue[0];		
	}
	
	/**
	 * 大区仓库存SQL
	 */
	private static final String QUERY_AWARD_WARE__HOUSE_DQ=" SELECT SUM(HWI.CONVERTIBLE_AMOUNT) CONVERTIBLE_AMOUNT"+
	                                  "  FROM WAREHOUSE_LOGISTIC_RLT WLR, (SELECT * FROM HOUSE_WARE_INFO   WHERE "+
                                      "  WARE_ID = ?) HWI, WAREHOUSE_INFO B  WHERE WLR.WAREHOUSE_ID = HWI.WAREHOUSE_ID "+
                                      "  AND HWI.WAREHOUSE_ID = B.WAREHOUSE_ID AND WLR.RLT_STATE = '1'  AND B.WAREHOUSE_TYPE = '0'"+
                                      "  AND B.WAREHOUSE_STATE = '1'";


	/**
	 * 中心仓库存SQL
	 */
	private static final String QUERY_AWARD_WARE__HOUSE_ZX="SELECT SUM(HWI.CONVERTIBLE_AMOUNT) /nvl(count(HWI.Convertible_Amount), 1) CONVERTIBLE_AMOUNT  " +
			                                                "FROM WAREHOUSE_LOGISTIC_RLT WLR, (SELECT * FROM HOUSE_WARE_INFO  WHERE "+
                                                            "    WARE_ID = ?  AND WAREHOUSE_ID = ?) HWI,  WAREHOUSE_INFO B "+
												            "   WHERE WLR.WAREHOUSE_ID = HWI.WAREHOUSE_ID "+
												            "   AND HWI.WAREHOUSE_ID = B.WAREHOUSE_ID "+
												            "   AND WLR.RLT_STATE = '1' "+
												            "   AND B.WAREHOUSE_TYPE = '1'"+
												            "   AND B.WAREHOUSE_STATE = '1' ";
	
	
	/**
	 * 虚拟仓库存SQL
	 */
	private static final String QUERY_AWARD_WARE__HOUSE_XN="SELECT SUM(HWI.CONVERTIBLE_AMOUNT) /nvl(count(HWI.Convertible_Amount), 1) CONVERTIBLE_AMOUNT  " +
			                                                "FROM WAREHOUSE_LOGISTIC_RLT WLR, (SELECT * FROM HOUSE_WARE_INFO  WHERE  "+
                                                            "   WARE_ID = ?  AND WAREHOUSE_ID = ?) HWI,  WAREHOUSE_INFO B "+
												            "   WHERE WLR.WAREHOUSE_ID = HWI.WAREHOUSE_ID "+
												            "   AND HWI.WAREHOUSE_ID = B.WAREHOUSE_ID "+
												            "   AND WLR.RLT_STATE = '1' "+
												            "   AND B.WAREHOUSE_TYPE = '2'"+
												            "   AND B.WAREHOUSE_STATE = '1' ";
}
