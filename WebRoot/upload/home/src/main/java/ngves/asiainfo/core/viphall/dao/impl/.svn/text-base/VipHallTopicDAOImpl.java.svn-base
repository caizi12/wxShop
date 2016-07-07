package ngves.asiainfo.core.viphall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ngves.asiainfo.core.viphall.bo.QBOVipHallTopicInfoEngine;
import ngves.asiainfo.core.viphall.bo.QBOVipHallWareInfoBean;
import ngves.asiainfo.core.viphall.bo.QBOVipWareDescEngine;
import ngves.asiainfo.core.viphall.bo.VipHallCountEngine;
import ngves.asiainfo.core.viphall.dao.interfaces.IVipHallTopicDAO;
import ngves.asiainfo.core.viphall.ivalues.IQBOVipHallTopicInfoValue;
import ngves.asiainfo.core.viphall.ivalues.IQBOVipHallWareInfoValue;
import ngves.asiainfo.core.viphall.ivalues.IQBOVipWareDescValue;
import ngves.asiainfo.core.viphall.ivalues.IVipHallCountValue;
import ngves.asiainfo.core.ware.bo.WareInfoParentEngine;
import ngves.asiainfo.core.ware.bo.WarePCRltEngine;
import ngves.asiainfo.core.ware.ivalues.IWareInfoParentValue;
import ngves.asiainfo.core.ware.ivalues.IWarePCRltValue;
import ngves.asiainfo.util.StringUtil;
import oracle.sql.CLOB;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.ServiceManager;

public class VipHallTopicDAOImpl implements IVipHallTopicDAO {

	private static transient Log logger = LogFactory.getLog(VipHallTopicDAOImpl.class);

	public IQBOVipHallTopicInfoValue[] queryVipHallTopicInfo() throws Exception {
		return QBOVipHallTopicInfoEngine.getBeans(null, null);
	}

	public IQBOVipHallTopicInfoValue queryVipHallTopicInfoById(long topicId) throws Exception {
		Map<String, Long> param = new HashMap<String, Long>();
		param.put("topic_id", topicId);
		IQBOVipHallTopicInfoValue[] topicValue = QBOVipHallTopicInfoEngine.getBeans(null, param);
		return topicValue.length >= 1 ? topicValue[0] : null;
	}

	public IVipHallCountValue queryViphallCountInfo(long wareKindId) throws Exception {

		return VipHallCountEngine.getBean(wareKindId);
	}

	public IQBOVipHallWareInfoValue[] queryVipHallWareInfo(long wareKindId, String province, int startNum, int endNum)
			throws Exception {
		// 拼接执行的SQL语句
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT T2.WARE_ID,T2.WARE_NAME ,T2.IS_ONLINE,T2.FILE_NAME,T2.PROV_CODE,T2.CITY_CODE,");
		buffer.append(" T2.CITY_NAME,T2.WARE_KIND_ID,T2.DESC_DEFINE_WARE_VALUE,T2.CONTENT,T2.WARE_DIS_VALUE  ");
		buffer.append("FROM (SELECT ROWNUM RN, T1.*");
		buffer.append("     FROM (SELECT VI.*, VPV.WARE_DIS_VALUE");
		buffer.append("         FROM VIPHALL_INFO VI, VIPHALL_PC_VALUE VPV");
		buffer.append("       WHERE VI.WARE_ID = VPV.WARE_ID");
		if (!StringUtil.isBlank(province) && !"showAll".equals(province)) {
			buffer.append("         AND VI.PROV_CODE = '").append(province).append("'");
		}
		buffer.append("        AND VI.WARE_KIND_ID = ").append(wareKindId);
		buffer.append("      ORDER BY VI.WARE_NAME) T1");
		buffer.append(" WHERE ROWNUM <= ").append(endNum);
		buffer.append(") T2");
		buffer.append(" WHERE T2.RN >").append(startNum);
		logger.info("queryVipHallWareInfo=>>" + buffer.toString());
		long s1 = System.currentTimeMillis();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		IQBOVipHallWareInfoValue value = null;
		List<IQBOVipHallWareInfoValue> list = new ArrayList<IQBOVipHallWareInfoValue>();
		try {
			conn = ServiceManager.getSession().getConnection();
			pstmt = conn.prepareStatement(buffer.toString());
			rs = pstmt.executeQuery();
			if (rs != null) {

				while (rs.next()) {
					value = new QBOVipHallWareInfoBean();
					// 基本信息
					long wareId = 0;
					// 打折信息
					String wareDisValue = "";
					String wareName = "";
					String isOnline = "";
					String fileName = "";
					String provCode = "";
					String cityCode = "";
					String cityName = "";
					String descDefineWareValue = "";
					wareId = rs.getLong("WARE_ID");
					wareName = rs.getString("WARE_NAME");
					isOnline = rs.getString("IS_ONLINE");
					fileName = rs.getString("FILE_NAME");
					provCode = rs.getString("PROV_CODE");
					cityCode = rs.getString("CITY_CODE");
					cityName = rs.getString("CITY_NAME");
					// 属性信息
					CLOB clob = (CLOB) rs.getClob("CONTENT");
					char[] content = new char[(int) clob.length()];
					clob.getChars(1L, (int) clob.length(), content);
					
					descDefineWareValue = new String(content);
					wareDisValue = rs.getString("WARE_DIS_VALUE");
					value.setWareId(wareId);
					value.setWareName(wareName);
					value.setIsOnline(isOnline);
					value.setFileName(fileName);
					value.setProvCode(provCode);
					value.setCityCode(cityCode);
					value.setCityName(cityName);
					value.setDescDefineWareValue(descDefineWareValue);
					value.setWareDisValue(wareDisValue);
					list.add(value);
				}
				return list.toArray(new QBOVipHallWareInfoBean[list.size()]);
			}
			return null;
		} catch (Exception e) {
			logger.error(" queryVipHallWareInfo is exception..", e);
			throw e;
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
			logger.info(" getContent execute by wareKindId:= " + wareKindId + " is cost :="
					+ (System.currentTimeMillis() - s1));
		}
	}

	public IQBOVipWareDescValue[] queryVipWareDesc(long wareId) throws Exception {
		// 如果传入的礼品ID不大于0，则直接返回空；
		if (wareId <= 0) {
			return null;
		}
		Map<String, String> param = new HashMap<String, String>();
		param.put("wareId", String.valueOf(wareId));
		return QBOVipWareDescEngine.getBeans(null, param);
	}

	/**
	 * 根据礼品ID获取指定礼品信息
	 * 
	 * @param wareId
	 *            礼品ID
	 * @return
	 * @throws Exception
	 */
	public IWareInfoParentValue getWareInfoParent(String wareId) throws Exception {
		String condition = IWareInfoParentValue.S_WareId + "=:" + IWareInfoParentValue.S_WareId;
		Map<String, String> param = new HashMap<String, String>();
		param.put(IWareInfoParentValue.S_WareId, wareId);
		IWareInfoParentValue[] IWareInfoParents = WareInfoParentEngine.getBeans(condition, param);
		if (IWareInfoParents != null && IWareInfoParents.length > 0) {
			return IWareInfoParents[0];
		} else {
			return null;
		}
	}

	/**
	 * 根据子礼品Id获取父礼品ID
	 * 
	 * @param childWareId
	 * @return pWareId
	 * @throws Exception
	 * 
	 */
	public long findChildWareIdParentId(String childWareId) throws Exception {
		Map<String, String> parameter = new HashMap<String, String>();
		String sql = IWarePCRltValue.S_CWareId + "=:" + IWarePCRltValue.S_CWareId;
		parameter.put(IWarePCRltValue.S_CWareId, childWareId);
		IWarePCRltValue[] ipv = WarePCRltEngine.getBeans(sql, parameter);
		if (ipv.length != 0 && null != ipv) {
			return ipv[0].getPWareId();
		}
		return 0;
	}
}
