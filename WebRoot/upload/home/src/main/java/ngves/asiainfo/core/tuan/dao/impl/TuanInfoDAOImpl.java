package ngves.asiainfo.core.tuan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.CommnException;
import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.common.bo.UpdateNotifyInfoEngine;
import ngves.asiainfo.core.common.ivalues.IUpdateNotifyInfoValue;
import ngves.asiainfo.core.tuan.TuanConstant;
import ngves.asiainfo.core.tuan.bo.QBOComingSoonEngine;
import ngves.asiainfo.core.tuan.bo.QBOReviewEngine;
import ngves.asiainfo.core.tuan.bo.QBOTodayCommendEngine;
import ngves.asiainfo.core.tuan.bo.QBOTuanOrderEngine;
import ngves.asiainfo.core.tuan.bo.TuanInfoEngine;
import ngves.asiainfo.core.tuan.bo.TuanUserLogEngine;
import ngves.asiainfo.core.tuan.dao.interfaces.ITuanInfoDAO;
import ngves.asiainfo.core.tuan.exception.MgtTuanException;
import ngves.asiainfo.core.tuan.ivalues.IQBOComingSoonValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOReviewValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOTodayCommendValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOTuanOrderValue;
import ngves.asiainfo.core.tuan.ivalues.ITuanInfoValue;
import ngves.asiainfo.core.tuan.ivalues.ITuanProvinceValue;
import ngves.asiainfo.core.tuan.ivalues.ITuanUserLogValue;
import ngves.asiainfo.core.ware.bo.WareInfoBean;
import ngves.asiainfo.core.ware.bo.WareInfoEngine;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.ServiceManager;

public class TuanInfoDAOImpl implements ITuanInfoDAO {

	private static transient Log log = LogFactory.getLog(TuanInfoDAOImpl.class);
	
	public ITuanInfoValue[] queryTuanInfo(String tuanName, int startIndex, int endIndex) {
		StringBuffer sql = new StringBuffer();
		Map<String, String> params = new HashMap<String, String>();

		if (!StringUtil.isBlank(tuanName)) {
			tuanName = tuanName.trim();
			sql.append(ITuanInfoValue.S_Name).append(" LIKE :").append(ITuanInfoValue.S_Name).append(" ");
			params.put(ITuanInfoValue.S_Name, "%" + tuanName + "%");
		}
		try {
			sql.append(" order by CREATE_DATE DESC");
			return TuanInfoEngine.getBeans(null, sql.toString(), params, startIndex, endIndex, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int queryTuanInfoCount(String tuanName) {
		StringBuffer sql = new StringBuffer();
		Map<String, String> params = new HashMap<String, String>();

		if (!StringUtil.isBlank(tuanName)) {
			tuanName = tuanName.trim();
			sql.append(ITuanInfoValue.S_Name).append(" LIKE :").append(ITuanInfoValue.S_Name).append(" ");
			params.put(ITuanInfoValue.S_Name, "%" + tuanName + "%");
		}
		try {
			return TuanInfoEngine.getBeansCount(sql.toString(), params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ITuanInfoValue queryTuanById(String tuanId) {
		try {
			return TuanInfoEngine.getBean(Long.parseLong(tuanId));
		} catch (NumberFormatException e) {
			// e.printStackTrace();
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return null;

	}
	
	public long queryTuanHouseWareCount(String tuanId){
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		long wareHouseCount = 0;
		
		try {
			conn = getDBConnection(); //数据库连接
			psmt = conn.prepareStatement(QUERY_TUAN_WARE__HOUSE_INFO);
			psmt.setString(1, tuanId);
			psmt.setString(2, tuanId);
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

	
	public long  getTuanHouseWareCount(String tuanId,String wareId) throws Exception {
		WareInfoBean wareInfo = WareInfoEngine.getBean(Long.parseLong(wareId));

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		long wareHouseCount = 0;
		String condition = "";
		try {
		//默认为大区仓SQL
		condition = QUERY_TUAN_WARE__HOUSE_DQ;
		conn = getDBConnection(); //数据库连接
		psmt = conn.prepareStatement(condition);
		psmt.setString(1, wareId);
		psmt.setString(2, tuanId);
		
		if(log.isInfoEnabled()) {
			log.info("QUERY_TUAN_WARE__HOUSE_DQ =>> " + QUERY_TUAN_WARE__HOUSE_DQ);
		}
		// 如果为虚拟仓，中心仓礼品，那么只可能对应一个仓库，执行下面的SQL查询语句
		if (null != wareInfo.getWareStorageType()
				&& ("1".equals(wareInfo.getWareStorageType()) || "2"
						.equals(wareInfo.getWareStorageType()))) {
			condition = QUERY_TUAN_WARE__HOUSE_XNZX;
			if(log.isInfoEnabled()) {
				log.info("QUERY_TUAN_WARE__HOUSE_XNZX =>> " + QUERY_TUAN_WARE__HOUSE_XNZX);
			}
			psmt = conn.prepareStatement(condition);
			psmt.setString(1, wareId);
			psmt.setLong(2, wareInfo.getWarehouseId());
			psmt.setString(3, tuanId);
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
	public ITuanProvinceValue[] getTuanProvinceValueById(String tuanId) throws Exception {
		return null;
	}

	public long saveTuanInfo(ITuanInfoValue value) throws Exception {
		long tuanId = 0L;
		tuanId = value.getTuanId();
		TuanInfoEngine.save(value);
		return tuanId;
	}

	public boolean isExistSameName(String tuanName) throws Exception {
		// 1、利用团购名称 tuanName 到数据库中查询数据
		StringBuffer sql = new StringBuffer(" 1=1 ");
		Map<String, String> para = new HashMap<String, String>();
		if (!StringUtil.isBlank(tuanName)) {
			tuanName = tuanName.trim();
			sql.append(" and " + ITuanInfoValue.S_Name).append(" =:").append(ITuanInfoValue.S_Name).append(" ");
			para.put(ITuanInfoValue.S_Name, tuanName);
		}
		int num = TuanInfoEngine.getBeansCount(sql.toString(), para);
		// 2、如果查询出来的结果集数量等于0 那么不存在相同名称的记录
		// 如果结果集中元素的数量大于0 ，那么数据库中存在相同名称的记录项；
		// 同时，如果数量不等于1，那么证明数据库中已经存在相同名称的记录项,
		// 本条记录不能添加到数据库，同时抛出异常信息

		boolean isExistName = true;
		// 如果结果中元素的数量等于0
		if (0 == num) {
			isExistName = false;
			// 数量大于1 这怎么可能？ 万一有人直接向数据表中插入数据怎么办？
		} else if (1 != num) {
			throw new MgtTuanException("");
		}

		return isExistName;
	}

	public IQBOTodayCommendValue[] getTodayCommend(int startNum, int endNum) throws Exception {
		IQBOTodayCommendValue[] tc = QBOTodayCommendEngine.getBeans(null, startNum, endNum, false);
		return tc;
	}

	public int getTodayCommendCount(int startNum, int endNum) throws Exception {
		int tc = QBOTodayCommendEngine.getBeansCount(null, null);
		return tc;
	}
	
	public IQBOComingSoonValue[] getComingSoon(int startNum, int endNum) throws Exception {
		IQBOComingSoonValue[] cs = QBOComingSoonEngine.getBeans(null, startNum, endNum, false);
		return cs;
	}
	
	public int getComingSoonCount(int startNum, int endNum) throws Exception {
		int cs = QBOComingSoonEngine.getBeansCount(null, null);
		return cs;
	}

	public IQBOReviewValue[] getReview(int startNum, int endNum) throws Exception {
		return QBOReviewEngine.getBeans(null, startNum, endNum, false);
	}
	
	public IQBOTodayCommendValue[] getTodayTuan(String topFlag, int startNum, int endNum) throws Exception{
		StringBuffer sql = new StringBuffer();
		Map<String, String> params = new HashMap<String, String>();
		if (!StringUtil.isBlank(topFlag)) {
			topFlag = topFlag.trim();
			sql.append(IQBOTodayCommendValue.S_TopFlag + " = :" + IQBOTodayCommendValue.S_TopFlag);
		    params.put(IQBOTodayCommendValue.S_TopFlag, topFlag);
		    return QBOTodayCommendEngine.getBeans(null, sql.toString(), params, startNum, endNum, false);
		}else{
			return null;
		}
	}
	
	public int getReviewCount(int startNum, int endNum) throws Exception {
		return QBOReviewEngine.getBeansCount(null, null);
	}
	
	public int getTuanInfoCount(String groupCode) throws Exception {
		int count = 0;
		// 00、今日推荐 
		// 01、下期预告 
		// 02、精彩回顾
		if(CoreConstant.ACTIVITY_TUAN_GROUP_TODATY_RECOMMEND.equals(groupCode)){
			count = getTodayCommendCount(-1, -1);
		} else if(CoreConstant.ACTIVITY_TUAN_GROUP_NEXT_ISSUE.equals(groupCode)){
			count = getComingSoonCount(-1, -1);
		} else if(CoreConstant.ACTIVITY_TUAN_GROUP_OLD_TIMEY.equals(groupCode)) {
			count = getReviewCount(-1, -1);
		}
		return count;
	}
	
	/**
	 * 更新团购信息-显示精彩回顾
	 */
	private static final String UPDATE_TUAN_INFO = "UPDATE TUAN_INFO SET STATUS='2'  WHERE TUAN_ID=?";

	/**
	 * 更新团购信息，显示精彩回顾
	 * 
	 * @author:shenfl@asiainfo-linkage.com
	 * @param tuanId
	 * @throws Exception
	 */
	public void updateTuanInfoToEnd(String tuanId) throws Exception {
		// 获取当前当前团购的结束时间
		// 获取当前当前团购的结束时间
		Connection conn = null;
		PreparedStatement psts = null;
		try {
			conn = ServiceManager.getSession().getConnection();
			psts = conn.prepareStatement(UPDATE_TUAN_INFO);
			psts.setString(1, tuanId);
			// 执行更新操作
			psts.executeUpdate();
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
	}

	/**
	 * 获取处于开始抢兑的活动ID列表(开始时间<=当前时间<=结束时间)
	 */
	private static final String GETTUANUSERLOGINFO_SQL = ITuanInfoValue.S_StartTime + " <= SYSDATE AND "
			+ ITuanInfoValue.S_EndTime + " >= SYSDATE AND " + ITuanInfoValue.S_Status + " = :"
			+ ITuanInfoValue.S_Status;

	/**
	 * 取得所有已经兑换的信息 (已经发布&&开始时间<=当前时间<结束时间)
	 * 
	 * @return
	 * @throws Exception
	 */
	public ITuanInfoValue[] getStartTuanIds() throws Exception {

		Map<String, String> param = new HashMap<String, String>();
		// 当前状态已经发布
		param.put(ITuanInfoValue.S_Status, TuanConstant.TUAN_STATUS_PUBLISH);
		return TuanInfoEngine.getBeans(new String[] { ITuanInfoValue.S_TuanId }, GETTUANUSERLOGINFO_SQL, param, -1, -1,
				false);
	}


	
   private static final String GETALL_TUAN_INFO_SQL = ITuanInfoValue.S_EndTime + " >= SYSDATE AND "
			+ ITuanInfoValue.S_StartTime + " <=SYSDATE  AND "
			+ ITuanInfoValue.S_Status + " = :" + ITuanInfoValue.S_Status + " order by "
			+ ITuanInfoValue.S_StartTime;
    /**
     * 取得所有的团购信息-商城公告显示
     */
    public ITuanInfoValue[] getITuanInfoValues() throws Exception{
        Map<String, String> param = new HashMap<String, String>();
		param.put(ITuanInfoValue.S_Status, TuanConstant.TUAN_STATUS_PUBLISH);
		return TuanInfoEngine.getBeans(GETALL_TUAN_INFO_SQL, param);
    }

	@SuppressWarnings("unchecked")
	public int countTuanUserLog(String tuanId) throws Exception {
		StringBuffer cond = new StringBuffer();
		Map map = new HashMap();
		cond.append(ITuanUserLogValue.S_TuanId)
			.append("= :")
			.append(ITuanUserLogValue.S_TuanId);
		map.put(ITuanUserLogValue.S_TuanId, tuanId);
		return TuanUserLogEngine.getBeansCount(cond.toString(), map);
	}
	
	@SuppressWarnings("unchecked")
	public IQBOTuanOrderValue[] queryTuanUserLog(String tuanId, int startIndex, 
			int endIndex) throws Exception {
		StringBuffer sb = new StringBuffer();
		Map para = new HashMap();
		sb.append(IQBOTuanOrderValue.S_TuanId)
			.append("= :")
			.append(IQBOTuanOrderValue.S_TuanId);
		para.put(IQBOTuanOrderValue.S_TuanId, tuanId);
		return QBOTuanOrderEngine.getBeans(null, sb.toString(), para, startIndex, endIndex, false);
		
		
	}
	
	
	private static final String QUERY_TUAN_WARE__HOUSE_INFO="SELECT H.CONVERTIBLE_AMOUNT FROM HOUSE_WARE_INFO H " +
			"WHERE H.WARE_ID = ( SELECT C.WARE_ID FROM TUAN_WARE_RLT C WHERE C.TUAN_ID = ? )" +
			"AND H.WAREHOUSE_ID = (SELECT A.WAREHOUSE_ID " +
								"FROM WARE_INFO A, TUAN_WARE_RLT B WHERE A.WARE_ID = B.WARE_ID " +
								"AND B.TUAN_ID = ? ) ";
	
	
	
	/**
	 * 大区仓库存SQL
	 */
	private static final String QUERY_TUAN_WARE__HOUSE_DQ="select sum(HWI.Convertible_Amount) Convertible_Amount " +
															  " FROM WAREHOUSE_LOGISTIC_RLT WLR, " +
															  "  (SELECT * " +
															  "      FROM HOUSE_WARE_INFO " +
															  "      WHERE CONVERTIBLE_AMOUNT > WARN_AMOUNT " +
															  "         AND WARE_ID = ?) HWI " +
															  " WHERE WLR.WAREHOUSE_ID = HWI.WAREHOUSE_ID " +
															  " AND WLR.RLT_STATE = '1' " +
															  " AND WLR.Province_Code not in( " +
															  "     select tp.limit_prov from tuan_province tp where tp.tuan_id = ? " +
															  " ) ";


	/**
	 * 虚拟仓和中心仓库存SQL
	 */
	private static final String QUERY_TUAN_WARE__HOUSE_XNZX="select sum(HWI.Convertible_Amount)/nvl(count(HWI.Convertible_Amount),1) Convertible_Amount "+
															  " FROM WAREHOUSE_LOGISTIC_RLT WLR, "+
															  "     (SELECT * "+
															  "        FROM HOUSE_WARE_INFO "+
															  "       WHERE CONVERTIBLE_AMOUNT > WARN_AMOUNT "+
															  "         AND WARE_ID = ? "+
															  "         AND WAREHOUSE_ID = ? ) HWI "+
															  "  WHERE WLR.WAREHOUSE_ID = HWI.WAREHOUSE_ID "+
															  " AND WLR.RLT_STATE = '1' "+
															  " AND WLR.Province_Code not in( "+
															  "     select tp.limit_prov from tuan_province tp where tp.tuan_id = ? "+
															  " )  ";

	/**
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
	 * 团购绑定礼品后发布，将礼品id更新到update_notify_info表中标识为待同步
	 * @param notifyInfos
	 * @throws Exception
	 */
	public void saveNotifyInfo(IUpdateNotifyInfoValue[] notifyInfos) throws Exception {
		for (IUpdateNotifyInfoValue value : notifyInfos) {
	    	if (value.isNew()) {
	    		value.setNotifyInfoId(UpdateNotifyInfoEngine.getNewId().longValue());
	    		value.setCreateTime(UpdateNotifyInfoEngine.getSysDate());
	    		value.setStatus(CommnConstant.SYS_NOTIFY_STATE_WAIT);
	        }
    	}
    	UpdateNotifyInfoEngine.save(notifyInfos);
	}
	/*********************省网礼品支持团购*******************************/
    // 合并成都操作QBO
	public IQBOTodayCommendValue[] getTodayCommend(int startNum, int endNum,String provinceCode,String channel, String userStarLevel) throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
	     Map<String, String> parameter = new HashMap<String, String>();
	     
		if(!StringUtil.isBlank(provinceCode) && !"00".equals(provinceCode)){
			condition.append("  and (province_code='00' or province_code='"+provinceCode+"')");
		}else{
			condition.append(" and province_code='00' ");
		}
		if(!StringUtil.isBlank(channel)){
			condition.append(" and channel = '"+channel+"'   ");
		}
		if(!StringUtil.isBlank(userStarLevel)){
			condition.append(" and star_level = '"+userStarLevel+"'  ");
		}
		return QBOTodayCommendEngine.getBeans(null, condition.toString(), parameter,startNum,endNum,false);
	}
	
	public IQBOComingSoonValue[] getComingSoon(int startNum, int endNum,String provinceCode,String channel, String userStarLevel) throws Exception {
		StringBuffer sql=new StringBuffer("select ti.tuan_id,ti.name, sfi.file_name main_pic, ti.url, ti.start_time, ti.end_time,ti.top_flag, ")
                      .append(" twr.discount,ai.ori_integral, ai.cur_integral, wi.ware_name, ")
                      .append("  nvl(ai.ori_pay_integral,0) ori_pay_integral, nvl(ai.ori_pay_cash,0) ori_pay_cash, ")
                      .append("  nvl(ai.cur_pay_integral,0) cur_pay_integral, nvl(ai.cur_pay_cash,0) cur_pay_cash, ti.pay_type,wi.pay_type,twr.ware_pay_type ")
                      .append(" from tuan_info ti, tuan_ware_rlt twr, ware_info_portal wi, sys_file_info sfi, activity_integral ai  ")
                      .append("  where ti.is_view ='1' and ti.status = '1' and wi.is_html_channel = '1' and ti.tuan_id = twr.tuan_id and twr.ware_id = wi.ware_id")
                      .append("   and ai.ware_id = twr.ware_id and ai.activity_id = twr.tuan_id  and ai.activity_type ='02' ");
              		if(!StringUtil.isBlank(channel)){
            			sql.append(" and ai.channel = '"+channel+"'   ");
            		}
            		if(!StringUtil.isBlank(userStarLevel)){
            			sql.append(" and ai.star_level = '"+userStarLevel+"'  ");
            		}
            		sql.append("   and sfi.rlt_id = wi.ware_id and sfi.is_main_pic = '1' and sfi.file_state in('3','4') and sfi.file_type = '0' ")
                      .append("   and ti.START_TIME > sysdate");
		if(!StringUtil.isBlank(provinceCode)){
			sql.append("  and (wi.province_code='00'or wi.province_code='"+provinceCode+"')");
		}else{
			sql.append(" and wi.province_code='00'");
		}
		sql.append("  order by ti.tuan_sort,ti.start_time,ti.tuan_id desc ");
		IQBOComingSoonValue[] cs = QBOComingSoonEngine.getBeansFromSql(sql.toString(),null);
		return cs;
		/*
		StringBuffer condition = new StringBuffer(" 1=1 ");
	     Map<String, String> parameter = new HashMap<String, String>();
	     
		if(!StringUtil.isBlank(provinceCode) && !"00".equals(provinceCode)){
			condition.append("  and province_code='00' or province_code='"+provinceCode+"'");
		}else{
			condition.append(" and province_code='00' ");
		}
		return QBOComingSoonEngine.getBeans(null, condition.toString(), parameter,startNum,endNum,false);*/
	}
	public IQBOReviewValue[] getReview(int startNum, int endNum,String provinceCode) throws Exception {
		StringBuffer sql = new StringBuffer(" select ti.tuan_id,ti.name, sfi.file_name main_pic, ti.url, twr.discount, wi.ware_name, ti.start_time, ti.end_time,ti.top_flag  ")
                          .append("  from tuan_info ti, tuan_ware_rlt twr, ware_info_portal wi, sys_file_info sfi ")
                          .append(" where ti.is_view = '1' and ti.status <> '0' and wi.is_html_channel = '1' and ti.tuan_id = twr.tuan_id and twr.ware_id = wi.ware_id ")
                          .append("  and sfi.rlt_id = wi.ware_id and sfi.is_main_pic = '1' and sfi.file_state in('3','4') and sfi.file_type = '0'")
                          .append(" and sysdate > ti.end_time ");
		if(!StringUtil.isBlank(provinceCode)){
			sql.append("  and (wi.province_code='00'or wi.province_code='"+provinceCode+"')");
		}else{
			sql.append(" and wi.province_code='00'");
		}
		sql.append("   order by ti.end_time desc,ti.tuan_id desc ");
		return QBOReviewEngine.getBeansFromSql(sql.toString(), null);
	}
	
}
