/**
 * @date:2012-9-14
 *
 * Copyright 2012 asiainfo-linkage, Inc. All rights reserved. 
 * @author:shenfl
 */
package ngves.asiainfo.core.tuan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.tuan.bo.QBOComingSoonEngine;
import ngves.asiainfo.core.tuan.bo.QBOReviewEngine;
import ngves.asiainfo.core.tuan.bo.QBOTodayCommendEngine;
import ngves.asiainfo.core.tuan.bo.QBOTuanWareDataEngine;
import ngves.asiainfo.core.tuan.bo.QBOTuanWareKindEngine;
import ngves.asiainfo.core.tuan.dao.interfaces.ITuanWareDataDAO;
import ngves.asiainfo.core.tuan.ivalues.IQBOComingSoonValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOReviewValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOTodayCommendValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOTuanWareDataValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOTuanWareKindValue;
import ngves.asiainfo.core.ware.WareParamConstant;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.util.StringUtils;

public class TuanWareDataDAOImpl implements ITuanWareDataDAO {

	private static final Log logger = LogFactory.getLog(TuanWareDataDAOImpl.class);

	private static final String TUAN_COMMON_CONDITION = "select ti.tuan_id, ti.top_flag,       "
		+ "       ti.name tuan_name,                                                  "
		+ "       ti.title_desc,                                                      "
		+ "       ti.main_pic tuan_main_pic,                                          "
		+ "       ti.url tuan_url,                                                    "
		+ "       ti.tuan_sort,                                                       "
		+ "       twr.discount tuan_discount,                                         "
		+ "       nvl(tab0.itemcount, 0) tuan_item_count,                             "
		+ "       wip.ware_id,                                                        "
		+ "       wip.ware_name,                                                      "
		+ "       ai.ori_integral,                                                    "
		+ "       ai.cur_integral,                                                    "
		+ "       sfi.file_name,                                                      "
		+ "       wk.ware_kind_id,                                                    "
		+ "       wk.kind_name,                                                       "	
		+ "       ti.pay_type as tuan_pay_type,                                       "
		+ "       wip.pay_type as ware_pay_type,                                      "
		+ "       twr.ware_pay_type as rlt_pay_type,                                  "
		+ "       ai.cur_pay_cash,                                                    "
		+ "       ai.cur_pay_integral,                                                "
		+ "       ai.ori_pay_cash,                                                    "
		+ "       ai.ori_pay_integral                                                 "		
		+ "  from tuan_info ti,                                                       "
		+ "       tuan_ware_rlt twr,                                                  "
		+ "       ware_info_portal wip,                                               "
		+ "       sys_file_info sfi,                                                  "
		+ "       ware_kind wk,                                                       "
		+ "       ware_kind_rlt wkr,                                                  "
		+ "       activity_integral ai,                                                  "
		+ "       (select t.tuan_id actionid,t.item_count itemcount                   " 
		+ "          from jfinter_orders_info t  ) tab0                               "
		+ " where ti.status = '1'                                                     "
		+ "   and ti.tuan_id = twr.tuan_id                                            "
		+ "   and twr.ware_id = wip.ware_id                                           "
		+ "   and tab0.actionid(+) = ti.tuan_id                                       "
		+ "   and sfi.rlt_id = wip.ware_id                                            "
		+ "   and sfi.is_main_pic = '1'                                               "
		+ "   and sfi.file_state in ('3', '4')                                        "
		+ "   and sfi.file_type = '0'                                                 "
		+ "   and wip.ware_id = wkr.ware_id                                           "
		+ "   and wkr.ware_kind_id = wk.ware_kind_id                                  "
		+ "   and twr.ware_id = ai.ware_id  and ai.activity_id=twr.tuan_id            "
		+ "   and ai.activity_type = '02'                                             "
		+ "   and wkr.is_default_kind = '1'                                           ";
	

	/**
	 * 拼接SQL
	 * 
	 * @param groupType
	 * @param kindID
	 * @param sortType
	 * @param userBrand
	 * @param offset
	 * @param sb
	 */
	private void convertQueryCondtion(String groupType, String kindID, String sortType, String sortWay,
			 StringBuffer sb, Map<String, String> parameter) {

		if (!StringUtil.isBlank(groupType)) {
			if (WareParamConstant.TUAN_TYPE_NOW.equals(groupType)) {
				sb.append(" and sysdate between  ti.start_time  and ti.end_time ");
			} else if (WareParamConstant.TUAN_TYPE_FUTURE.equals(groupType)) {
				sb.append(" and sysdate < ti.start_time  ");
			} else {
				sb.append(" and sysdate>ti.end_time ");
			}
		}
		if (!StringUtil.isBlank(kindID) && !WareParamConstant.TUAN_WARE_ID_ALL.equals(kindID)) {

			sb.append(" and wk.ware_kind_id = :kindID");
			parameter.put("kindID", kindID);
		}
		if (!StringUtil.isBlank(sortType)) {
			if (WareParamConstant.SORT_TYPE_DEFAULT.equals(sortType)) {
				sb.append("  order by  ti.tuan_sort,ti.start_time,ti.tuan_id desc ");
			} else if (WareParamConstant.SORT_TYPE_DISCOUNT.equals(sortType)) {
				sortWay = WareParamConstant.SORT_WAY_DIGITAL.equals(sortWay) ? "ASC" : "DESC";
				sb.append("  order by twr.discount ").append(sortWay).append(" ,ti.tuan_sort ,ti.tuan_id desc ");
 
			} else if (WareParamConstant.SORT_TYPE_SCORE.equals(sortType)) {
				sortWay = WareParamConstant.SORT_WAY_DIGITAL.equals(sortWay) ? "ASC" : "DESC";
				sb.append("  order by ai.cur_integral ").append(sortWay).append(" ,ti.tuan_sort ,ti.tuan_id desc ");
				
			} else {
				sortWay = WareParamConstant.SORT_WAY_DIGITAL.equals(sortWay) ? "DESC" : "ASC";
				sb.append(" order by tuan_item_count  " + sortWay + " ,ti.tuan_sort ,ti.tuan_id desc ");
			}
		}
	}

	public IQBOTuanWareDataValue[] getAllTuanWare(String groupType, String kindID, String sortType, String sortWay,
			String starLevel,String provinceCode,String channel) throws Exception {
		StringBuffer sb = new StringBuffer(TUAN_COMMON_CONDITION);
		Map<String, String> parameter = new HashMap<String, String>();
		if(StringUtil.isBlank(provinceCode)){
			sb.append("  and wip.province_code='00'      ");
		}else{
			sb.append("  and (wip.province_code='00' or wip.province_code='"+provinceCode+"') ");
		}
		
		if(!StringUtil.isBlank(channel)){
			if(CommnConstant.EXGCHANNEL_WEB.equals(channel)){
				sb.append(" and wip.is_html_channel = '1' ");
			}
			sb.append(" and ai.channel = :channel ");
			parameter.put("channel", channel);
		}
		if(!StringUtil.isBlank(starLevel)){
			sb.append(" and ai.star_level = :starLevel ");
			parameter.put("starLevel", starLevel);
		}
		
		convertQueryCondtion(groupType, kindID, sortType, sortWay, sb, parameter);
		logger.info("the method getAllTuanWare from class TuanWareDataDAOImpl,sb.toString==>>" + sb.toString());
		return QBOTuanWareDataEngine.getBeansFromSql(sb.toString(), parameter);
	}
	/**
	 * 注意：数据连接使用完后关闭conn
	 */
	public int getCountByBeanSql(String beanSql, Map<String, String> map) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		int result = 0;
		try {
			conn = ServiceManager.getSession().getConnection();
			String strSql = "select count(1) from (" + beanSql + ")";
			String parameterNames[] = StringUtils.getParamFromString(strSql, ":", " ");
			List<String> tempList = new ArrayList<String>();
			for (int i = 0; map != null && parameterNames != null && i < parameterNames.length; i++)
				if (map.containsKey(parameterNames[i]))
					tempList.add(parameterNames[i]);
			parameterNames = (String[]) tempList.toArray(new String[0]);
			strSql = StringUtils.replaceParamString(strSql, parameterNames, "?", ":", " ");
			String tableParameterNames[] = StringUtils.getParamFromString(strSql, "{", "}");
			if (tableParameterNames != null && tableParameterNames.length > 0) {
				if (map == null)
					throw new AIException("SQL\u8BED\u53E5\u7F3A\u4E4F\u8868\u540D\u53C2\u6570\uFF01");
				for (int i = 0; i < tableParameterNames.length; i++) {
					String actual_table_name = (String) map.get(tableParameterNames[i].trim());
					if (actual_table_name == null)
						throw new AIException("SQL\u8BED\u53E5\u7F3A\u4E4F\u8868\u540D\u53C2\u6570");
					strSql = StringUtils.replaceParamString(strSql, "{" + tableParameterNames[i].trim() + "}",
							actual_table_name);
				}
			}
			stmt = conn.prepareStatement(strSql);
			for (int i = 0; parameterNames != null && i < parameterNames.length; i++) {
				DataType.setPrepareStatementParameter(stmt, i + 1, "Object", map.get(parameterNames[i]));
			}
			set = stmt.executeQuery();
			result = 0;
			if (set.next()) {
				result = set.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("getCountByBeanSql from the class TuanWareDataDAOImpl is occurred",e);
		} finally {
			if (set != null) {
				set.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return result;
	}

	public IQBOReviewValue[] getReview(int startNum, int endNum,String provinceCode) throws Exception {

		StringBuffer sb = new StringBuffer();
		Map<String, String> parameter = new HashMap<String, String>();
		sb.append("select ti.tuan_id,");
		sb.append("               ti.name,");
		sb.append("             ti.main_pic,");
		sb.append("             ti.url,");
		sb.append("              twr.discount,");
		sb.append("              wi.ware_name,");
		sb.append("              ti.start_time,");
		sb.append("             ti.end_time");
		sb.append("         from tuan_info ti, tuan_ware_rlt twr, ware_info_portal wi");
		sb.append("       where ti.is_view = '1'");
		sb.append("         and ti.status <> '0'");
		sb.append("         and wi.is_html_channel = '1'");
		sb.append("         and ti.tuan_id = twr.tuan_id");
		sb.append("         and twr.ware_id = wi.ware_id");
		sb.append("         and sysdate > ti.end_time");
		if(StringUtil.isBlank(provinceCode)){
			sb.append("   and wi.province_code='00' ");
		}else{
			sb.append("   and (wi.province_code='00' or wi.province_code='"+provinceCode+"') ");
		}
		sb.append("      order by ti.end_time desc, ti.tuan_id desc");

		String pageSql = "select * from ( select B.*,rownum as row_index from ( " + sb.toString()
				+ " ) B where rownum <= " + endNum + " ) where row_index > " + startNum;
		logger.info("the method getReview from class TuanWareDataDAOImpl,pageSql==>>" + pageSql);
		return QBOReviewEngine.getBeansFromSql(pageSql, parameter);
	}

	/**
	 * 团购结束总页数
	 * @return
	 * @throws Exception
	 */
	public int getReviewCount(String provinceCode) throws Exception {

		StringBuffer sb = new StringBuffer();
		Map<String, String> parameter = new HashMap<String, String>();
		sb.append("select ti.tuan_id,");
		sb.append("               ti.name,");
		sb.append("             ti.main_pic,");
		sb.append("             ti.url,");
		sb.append("              twr.discount,");
		sb.append("              wi.ware_name,");
		sb.append("              ti.start_time,");
		sb.append("             ti.end_time");
		sb.append("         from tuan_info ti, tuan_ware_rlt twr, ware_info_portal wi");
		sb.append("       where ti.is_view = '1'");
		sb.append("         and ti.status <> '0'");
		sb.append("         and wi.is_html_channel = '1'");
		sb.append("         and ti.tuan_id = twr.tuan_id");
		sb.append("         and twr.ware_id = wi.ware_id");
		sb.append("         and sysdate > ti.end_time");
		if(StringUtil.isBlank(provinceCode)){
			sb.append("   and wi.province_code='00' ");
		}else{
			sb.append("   and (wi.province_code='00' or wi.province_code='"+provinceCode+"') ");
		}
		sb.append("      order by ti.end_time desc, ti.tuan_id desc");
		
		logger.info("the method getReviewCount from class TuanWareDataDAOImpl,getReviewCountSQL==>>" + sb.toString());
		return getCountByBeanSql(sb.toString(), parameter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ngves.asiainfo.core.tuan.dao.interfaces.ITuanWareDataDAO#getTuanWareKindList
	 * (java.lang.String)
	 */
	public IQBOTuanWareKindValue[] getTuanWareKindList(String groupType) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("select distinct wk.ware_kind_id, ");
		sb.append("     wk.kind_name ");
		sb.append(" from tuan_info ti, ");
		sb.append("      tuan_ware_rlt twr,");
		sb.append("      ware_kind wk, ");
		sb.append("      ware_kind_rlt wkr, ");
		sb.append("      ware_info_portal wip  ");
		sb.append("where ti.status = '1'");
		sb.append("  and ti.tuan_id = twr.tuan_id");
		sb.append("  and twr.ware_id = wip.ware_id and twr.ware_id = wkr.ware_id");
		sb.append("  and wkr.ware_kind_id = wk.ware_kind_id");
		sb.append("  and wkr.is_default_kind = '1' and wip.is_html_channel = '1'   ");
		if (!StringUtil.isBlank(groupType)) {
			if (WareParamConstant.TUAN_TYPE_NOW.equals(groupType)) {
				sb.append(" and sysdate between  ti.start_time  and ti.end_time ");
			} else if (WareParamConstant.TUAN_TYPE_FUTURE.equals(groupType)) {
				sb.append(" and sysdate < ti.start_time  ");
			} else {
				sb.append(" and sysdate>ti.end_time ");
			}
		}
		sb.append(" order by  wk.kind_name  ");
		logger.info("getTuanWareKindList sql ==>> " + sb.toString());
		return QBOTuanWareKindEngine.getBeansFromSql(sb.toString(), null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ngves.asiainfo.core.tuan.dao.interfaces.ITuanWareDataDAO#getComingSoon()
	 */
	public IQBOComingSoonValue[] getComingSoon(String provinceCode) throws Exception {
		StringBuffer sql=new StringBuffer("select ti.tuan_id,ti.name, sfi.file_name main_pic, ti.url, ti.start_time, ti.end_time,ti.top_flag, ")
        .append(" twr.discount,ai.ori_integral, ai.cur_integral, wi.ware_name ")
        .append(" from tuan_info ti, tuan_ware_rlt twr, ware_info_portal wi, sys_file_info sfi, activity_integral ai  ")
        .append("  where ti.status = '1' and wi.is_html_channel = '1' and ti.tuan_id = twr.tuan_id and twr.ware_id = wi.ware_id ")
        .append(" 	and twr.ware_id = ai.ware_id  and ai.activity_id=twr.tuan_id and ai.channel='8' and ai.star_level='05' ")
        .append("   and sfi.rlt_id = wi.ware_id and sfi.is_main_pic = '1' and sfi.file_state in('3','4') and sfi.file_type = '0' ")
        .append("   and ti.START_TIME > sysdate");
		if(!StringUtil.isBlank(provinceCode)){
		sql.append("  and (wi.province_code='00'or wi.province_code='"+provinceCode+"')");
		}else{
		sql.append(" and wi.province_code='00'");
		}
		sql.append("  order by ti.tuan_sort,ti.start_time,ti.tuan_id desc ");
		//IQBOComingSoonValue[] cs = QBOComingSoonEngine.getBeans(null, 0, 1, false);
		IQBOComingSoonValue[] cs = QBOComingSoonEngine.getBeansFromSql(sql.toString(), null);
		return cs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ngves.asiainfo.core.tuan.dao.interfaces.ITuanWareDataDAO#getTodayCommend
	 * ()
	 */
	//新增了省网团购之后，要根据礼品的省份进行查询
	public IQBOTodayCommendValue[] getTodayCommend(String provinceCode) throws Exception {
		StringBuffer sql=new StringBuffer(" select ti.tuan_id,ti.name,sfi.file_name main_pic,ti.url,ti.start_time,")
		.append(" ti.end_time, ti.top_flag, twr.discount,")
		.append(" ai.ori_integral, ai.cur_integral, wi.ware_name ")
		.append(" from tuan_info  ti, tuan_ware_rlt  twr, ware_info_portal wi,sys_file_info  sfi, activity_integral ai  ")
		.append("  where ti.status = '1'  and wi.is_html_channel = '1'  and ti.tuan_id = twr.tuan_id ")
		.append(" and twr.ware_id = ai.ware_id  and ai.activity_id=twr.tuan_id and ai.channel='8' and ai.star_level='05' ")
		.append(" and twr.ware_id = wi.ware_id   and sfi.rlt_id = wi.ware_id   and sfi.is_main_pic = '1'")
		.append("  and sfi.file_state in ('3', '4')  and sfi.file_type = '0'  and ti.START_TIME < sysdate")
		.append(" and ti.end_time > sysdate ");
		if(!StringUtil.isBlank(provinceCode)){
			sql.append("  and (wi.province_code='00'or wi.province_code='"+provinceCode+"')");
		}else{
			sql.append(" and wi.province_code='00'");
		}
		sql.append("order by ti.tuan_sort, ti.start_time, ti.tuan_id desc");
		//IQBOTodayCommendValue[] tc = QBOTodayCommendEngine.getBeans(null, 0, 1, false);
		IQBOTodayCommendValue[] tc = QBOTodayCommendEngine.getBeansFromSql(sql.toString(), null);
		return tc;
	}
}
