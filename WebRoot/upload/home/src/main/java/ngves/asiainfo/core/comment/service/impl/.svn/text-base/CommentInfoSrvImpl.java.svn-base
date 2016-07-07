package ngves.asiainfo.core.comment.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.comment.CommentConstant;
import ngves.asiainfo.core.comment.IQBOCommentInfoValue;
import ngves.asiainfo.core.comment.bo.CommentInfoBean;
import ngves.asiainfo.core.comment.bo.CommentInfoEngine;
import ngves.asiainfo.core.comment.dao.interfaces.ICommentInfoDAO;
import ngves.asiainfo.core.comment.ivalues.ICommentInfoValue;
import ngves.asiainfo.core.comment.ivalues.IFilterWordsInfoValue;
import ngves.asiainfo.core.comment.model.Comment;
import ngves.asiainfo.core.comment.service.interfaces.ICommentFilterSrv;
import ngves.asiainfo.core.comment.service.interfaces.ICommentInfoSrv;
import ngves.asiainfo.core.comment.service.interfaces.IFilterWordsInfoSrv;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;

/**
 * 礼品评论服务实现
 * @author LiuLin
 *
 */
public class CommentInfoSrvImpl implements ICommentInfoSrv {

	private ICommentInfoDAO commentInfoDAO;
	private IFilterWordsInfoSrv filterWordsInfoSrv;
	private static Log logger = LogFactory.getLog(CommentInfoSrvImpl.class);
	private String[] filterWordsInfos = null;
	private ICommentFilterSrv commentFilter = null;

	/* 查询礼品评论信息
	 * @see ngves.asiainfo.core.comment.service.interfaces.ICommentInfoSrv#queryCommentInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int)
	 */
	public ICommentInfoValue[] queryCommentInfo(String wareName, String wareCode, String mobilePhoneNo, String auditFlag,
			String startTime, String endTime, int startIndex, int endIndex) throws Exception {

		ICommentInfoValue[] commentInfoValueTemp;
		logger.info("CommentInfoSrvImpl-queryCommentInfo is running...");
		StringBuffer condition = new StringBuffer();
		Map<String, String> parameter = new HashMap<String, String>();
		condition.append("1=1");
		if (!StringUtil.isBlank(wareName)) {

			condition.append(" AND ").append(ICommentInfoValue.S_WareName).append(" like :").append(
					ICommentInfoValue.S_WareName);
			parameter.put(ICommentInfoValue.S_WareName, "%" + wareName + "%");

		}
		if (!StringUtil.isBlank(wareCode)) {

			condition.append(" AND ").append(ICommentInfoValue.S_WareCode).append(" like :")
					.append(ICommentInfoValue.S_WareCode);
			parameter.put(ICommentInfoValue.S_WareCode, "%" + wareCode + "%");

		}
		if (!StringUtil.isBlank(mobilePhoneNo)) {

			condition.append(" AND ").append(ICommentInfoValue.S_MobilePhoneNo).append("=:").append(
					ICommentInfoValue.S_MobilePhoneNo);
			parameter.put(ICommentInfoValue.S_MobilePhoneNo, mobilePhoneNo);

		}
		if (!StringUtil.isBlank(auditFlag)) {

			condition.append(" AND ").append(ICommentInfoValue.S_AuditFlag).append("=:").append(
					ICommentInfoValue.S_AuditFlag);
			parameter.put(ICommentInfoValue.S_AuditFlag, auditFlag);

		}
		if (!StringUtil.isBlank(startTime)) {
			if (startTime.length() < 12)
				startTime = startTime + " 00:00:00";
			condition.append(" AND ").append(ICommentInfoValue.S_CommentDate).append(
					">=to_date(:startTime ,'yyyy-mm-dd hh24:mi:ss')");
			parameter.put("startTime", startTime);
		}
		if (!StringUtil.isBlank(endTime)) {
			if (endTime.length() < 12)
				endTime = endTime + " 23:59:59";
			condition.append(" AND ").append(ICommentInfoValue.S_CommentDate).append(
					"<=to_date(:endTime ,'yyyy-mm-dd hh24:mi:ss')");
			parameter.put("endTime", endTime);
		}
		condition.append(" order by ").append(ICommentInfoValue.S_CommentDate).append(" desc");
		logger.info("===>condition："+condition.toString());
		logger.info("===>startIndex="+startIndex+" endIndex="+endIndex);
		commentInfoValueTemp = commentInfoDAO.queryCommentInfo(condition.toString(), parameter, startIndex, endIndex);

		
		//过滤礼品评论
		commentInfoValueTemp = commentFilter(commentInfoValueTemp);
		
//		long t1 = System.currentTimeMillis();
//		//将包含过滤词的评论靠前显示
//		List<ICommentInfoValue> commentInfoList = Arrays.asList(commentInfoValueTemp);
//		Collections.sort(commentInfoList, new Comparator<ICommentInfoValue>(){
//			public int compare(ICommentInfoValue o1, ICommentInfoValue o2) {
//				int n1=o1.getCommentOriginal().equals(o1.getBak01())?1:0;
//				int n2=o2.getCommentOriginal().equals(o2.getBak01())?1:0;
//				return n1-n2;
//			}});
//		long t2 = System.currentTimeMillis();
//		if (logger.isInfoEnabled()) {
//			logger.info("sort result use:" + (t2 - t1) + "ms");
//		}
		return commentInfoValueTemp;
	}
	
	/* 查询礼品评论信息
	 * @see ngves.asiainfo.core.comment.service.interfaces.ICommentInfoSrv#queryCommentInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int)
	 */
	public IQBOCommentInfoValue[] queryQBOCommentInfo(String fId, String bigKindId, String kindId, String wareName, String wareCode, String mobilePhoneNo, String auditFlag,
			String startTime, String endTime,String wareKindInfoId, int startIndex, int endIndex) throws Exception {
		
		IQBOCommentInfoValue[] commentInfoValueTemp;
		logger.info("CommentInfoSrvImpl-queryQBOCommentInfo is running...");
		StringBuffer condition = new StringBuffer();
		Map<String, String> parameter = new HashMap<String, String>();
		condition.append("1=1");
		
		if(!StringUtil.isBlank(fId)&&!"-1".equals(fId)){
			condition.append(" AND ").append(IQBOCommentInfoValue.S_WareFirstKindId).append("=:").append(
					IQBOCommentInfoValue.S_WareFirstKindId);
			parameter.put(IQBOCommentInfoValue.S_WareFirstKindId, fId);
		}
		if(!StringUtil.isBlank(bigKindId)&&!"-1".equals(bigKindId)){
			condition.append(" AND ").append(IQBOCommentInfoValue.S_WareKindParentId).append("=:").append(
					IQBOCommentInfoValue.S_WareKindParentId);
			parameter.put(IQBOCommentInfoValue.S_WareKindParentId, bigKindId);
		}
		if(!StringUtil.isBlank(kindId)&&!"-1".equals(kindId)){
			condition.append(" AND ").append(IQBOCommentInfoValue.S_WareKindId).append("=:").append(
					IQBOCommentInfoValue.S_WareKindId);
			parameter.put(IQBOCommentInfoValue.S_WareKindId, kindId);
		}
		if (!StringUtil.isBlank(wareName)) {
			
			condition.append(" AND ").append(IQBOCommentInfoValue.S_WareName).append(" like :").append(
					IQBOCommentInfoValue.S_WareName);
			parameter.put(IQBOCommentInfoValue.S_WareName, "%" + wareName + "%");
			
		}
		if (!StringUtil.isBlank(wareCode)) {
			
			condition.append(" AND ").append(IQBOCommentInfoValue.S_WareCode).append(" like :")
			.append(IQBOCommentInfoValue.S_WareCode);
			parameter.put(IQBOCommentInfoValue.S_WareCode, "%" + wareCode + "%");
			
		}
		if (!StringUtil.isBlank(mobilePhoneNo)) {
			
			condition.append(" AND ").append(IQBOCommentInfoValue.S_MobilePhoneNo).append("=:").append(
					IQBOCommentInfoValue.S_MobilePhoneNo);
			parameter.put(IQBOCommentInfoValue.S_MobilePhoneNo, mobilePhoneNo);
			
		}
		if (!StringUtil.isBlank(auditFlag)) {
			
			condition.append(" AND ").append(IQBOCommentInfoValue.S_AuditFlag).append("=:").append(
					IQBOCommentInfoValue.S_AuditFlag);
			parameter.put(IQBOCommentInfoValue.S_AuditFlag, auditFlag);
			
		}
		if(!StringUtil.isBlank(wareKindInfoId)&&!"-1".equals(wareKindInfoId)){
			condition.append(" AND ").append(IQBOCommentInfoValue.S_WareKindInfoId).append("=:").append(IQBOCommentInfoValue.S_WareKindInfoId);
			parameter.put(IQBOCommentInfoValue.S_WareKindInfoId, wareKindInfoId);
		}
		if (!StringUtil.isBlank(startTime)) {
			if (startTime.length() < 12)
				startTime = startTime + " 00:00:00";
			condition.append(" AND ").append(IQBOCommentInfoValue.S_CommentDate).append(
			">=to_date(:startTime ,'yyyy-mm-dd hh24:mi:ss')");
			parameter.put("startTime", startTime);
		}
		if (!StringUtil.isBlank(endTime)) {
			if (endTime.length() < 12)
				endTime = endTime + " 23:59:59";
			condition.append(" AND ").append(IQBOCommentInfoValue.S_CommentDate).append(
			"<=to_date(:endTime ,'yyyy-mm-dd hh24:mi:ss')");
			parameter.put("endTime", endTime);
		}
		condition.append(" order by ").append(IQBOCommentInfoValue.S_CommentDate).append(" desc");
		logger.info("===>condition："+condition.toString());
		logger.info("===>startIndex="+startIndex+" endIndex="+endIndex);
		commentInfoValueTemp = commentInfoDAO.queryQBOCommentInfo(condition.toString(), parameter, startIndex, endIndex);
		
		
		//过滤礼品评论
		commentInfoValueTemp = commentFilter(commentInfoValueTemp);
		
//		long t1 = System.currentTimeMillis();
//		//将包含过滤词的评论靠前显示
//		List<ICommentInfoValue> commentInfoList = Arrays.asList(commentInfoValueTemp);
//		Collections.sort(commentInfoList, new Comparator<ICommentInfoValue>(){
//			public int compare(ICommentInfoValue o1, ICommentInfoValue o2) {
//				int n1=o1.getCommentOriginal().equals(o1.getBak01())?1:0;
//				int n2=o2.getCommentOriginal().equals(o2.getBak01())?1:0;
//				return n1-n2;
//			}});
//		long t2 = System.currentTimeMillis();
//		if (logger.isInfoEnabled()) {
//			logger.info("sort result use:" + (t2 - t1) + "ms");
//		}
		return commentInfoValueTemp;
	}
	
	public int queryQBOCommentInfoCount(String fId, String bigKindId, String kindId, String wareName, String wareCode, String mobilePhoneNo, String auditFlag,
			String startTime, String endTime,String wareKindInfoId) throws Exception {
		
		logger.info("CommentInfoSrvImpl-queryQBOCommentInfoCount is running...");
		StringBuffer condition = new StringBuffer();
		Map<String, String> parameter = new HashMap<String, String>();
		condition.append("1=1");
		
		if(!StringUtil.isBlank(fId)&&!"-1".equals(fId)){
			condition.append(" AND ").append(IQBOCommentInfoValue.S_WareFirstKindId).append("=:").append(
					IQBOCommentInfoValue.S_WareFirstKindId);
			parameter.put(IQBOCommentInfoValue.S_WareFirstKindId, fId);
		}
		if(!StringUtil.isBlank(bigKindId)&&!"-1".equals(bigKindId)){
			condition.append(" AND ").append(IQBOCommentInfoValue.S_WareKindParentId).append("=:").append(
					IQBOCommentInfoValue.S_WareKindParentId);
			parameter.put(IQBOCommentInfoValue.S_WareKindParentId, bigKindId);
		}
		if(!StringUtil.isBlank(kindId)&&!"-1".equals(kindId)){
			condition.append(" AND ").append(IQBOCommentInfoValue.S_WareKindId).append("=:").append(
					IQBOCommentInfoValue.S_WareKindId);
			parameter.put(IQBOCommentInfoValue.S_WareKindId, kindId);
		}
		if (!StringUtil.isBlank(wareName)) {
			
			condition.append(" AND ").append(IQBOCommentInfoValue.S_WareName).append(" like :").append(
					IQBOCommentInfoValue.S_WareName);
			parameter.put(IQBOCommentInfoValue.S_WareName, "%" + wareName + "%");
			
		}
		if (!StringUtil.isBlank(wareCode)) {
			
			condition.append(" AND ").append(IQBOCommentInfoValue.S_WareCode).append(" like :")
			.append(IQBOCommentInfoValue.S_WareCode);
			parameter.put(IQBOCommentInfoValue.S_WareCode, "%" + wareCode + "%");
			
		}
		if (!StringUtil.isBlank(mobilePhoneNo)) {
			
			condition.append(" AND ").append(IQBOCommentInfoValue.S_MobilePhoneNo).append("=:").append(
					IQBOCommentInfoValue.S_MobilePhoneNo);
			parameter.put(IQBOCommentInfoValue.S_MobilePhoneNo, mobilePhoneNo);
			
		}
		if (!StringUtil.isBlank(auditFlag)) {
			
			condition.append(" AND ").append(IQBOCommentInfoValue.S_AuditFlag).append("=:").append(
					IQBOCommentInfoValue.S_AuditFlag);
			parameter.put(IQBOCommentInfoValue.S_AuditFlag, auditFlag);
			
		}
		if(!StringUtil.isBlank(wareKindInfoId)&&!"-1".equals(wareKindInfoId)){
			condition.append(" AND ").append(IQBOCommentInfoValue.S_WareKindInfoId).append("=:").append(IQBOCommentInfoValue.S_WareKindInfoId);
			parameter.put(IQBOCommentInfoValue.S_WareKindInfoId, wareKindInfoId);
		}
		if (!StringUtil.isBlank(startTime)) {
			if (startTime.length() < 12)
				startTime = startTime + " 00:00:00";
			condition.append(" AND ").append(IQBOCommentInfoValue.S_CommentDate).append(
			">=to_date(:startTime ,'yyyy-mm-dd hh24:mi:ss')");
			parameter.put("startTime", startTime);
		}
		if (!StringUtil.isBlank(endTime)) {
			if (endTime.length() < 12)
				endTime = endTime + " 23:59:59";
			condition.append(" AND ").append(IQBOCommentInfoValue.S_CommentDate).append(
			"<=to_date(:endTime ,'yyyy-mm-dd hh24:mi:ss')");
			parameter.put("endTime", endTime);
		}
		condition.append(" order by ").append(IQBOCommentInfoValue.S_CommentDate).append(" desc");
		logger.info("===>condition："+condition.toString());
		return commentInfoDAO.queryQBOCommentInfoCount(condition.toString(), parameter);
	}


//	/**
//	 * 将包含过滤词的评论靠前显示
//	 * @param commentInfoValueTemp
//	 * @return
//	 * @throws Exception
//	 */
//	private static ICommentInfoValue[] sortCommentArray(ICommentInfoValue[] commentInfoValues) throws Exception {
//		ICommentInfoValue[] commentInfoTemp = new ICommentInfoValue[commentInfoValues.length];
//		boolean[] used = new boolean[commentInfoValues.length];
//		int n = 0;
//		for (int i = 0; i < commentInfoValues.length; i++) {
//			String commentOriginal = commentInfoValues[i].getCommentOriginal();
//			String commentFiltered = commentInfoValues[i].getBak01();
//			if (!commentFiltered.equals(commentOriginal)) {
//				commentInfoTemp[n++] = commentInfoValues[i];
//				used[i] = true;
//			}
//		}
//		for (int i = 0; i < commentInfoValues.length; i++) {
//			if (!used[i]) {
//				commentInfoTemp[n++] = commentInfoValues[i];
//			}
//		}
//		return commentInfoTemp;
//	}

	/**
	 * 过滤礼品评论
	 * @param commentInfoValueTemp
	 * @return
	 * @throws Exception
	 */
	private ICommentInfoValue[] commentFilter(ICommentInfoValue[] commentInfoValueTemp) throws Exception {
		filterWordsInfoSrv = (IFilterWordsInfoSrv) ServiceFactory.getService(CommentConstant.FILTER_WRODS_INFO_SERVICE);
		long t1 = System.currentTimeMillis();
		IFilterWordsInfoValue[] filterWordsInfoValues = filterWordsInfoSrv.queryFilterWordsInfo("", "1", "", "", 0,
				filterWordsInfoSrv.queryFilterInfoCount("", "1", "", ""));
		long t2 = System.currentTimeMillis();
		if (logger.isInfoEnabled()) {
			logger.info("get filter words from db by appframe use:" + (t2 - t1) + "ms");
		}
		filterWordsInfos = new String[filterWordsInfoValues.length];
		for (int i = 0; i < filterWordsInfos.length; i++) {
			filterWordsInfos[i] = filterWordsInfoValues[i].getFilterWord();
		}
		commentFilter = (ICommentFilterSrv) ServiceFactory.getService(CommentConstant.COMMENT_FILTER_SERVICE);
		commentFilter.setFilterWords(filterWordsInfos);
		t1 = System.currentTimeMillis();
		for (ICommentInfoValue commentInfo : commentInfoValueTemp) {
			String commentOriginal = commentInfo.getCommentOriginal();
			String commentFiltered = commentFilter.doFilter(commentOriginal);
			//如果过滤后的评论和评论原文不同，则包含过滤词
			if (!commentFiltered.equals(commentOriginal)) {
				commentInfo.setBak01(commentFiltered);
			} else {
				//不包含过滤词
				commentInfo.setBak01(commentFiltered);
			}
		}
		t2 = System.currentTimeMillis();
		if (logger.isInfoEnabled()) {
			logger.info("filter comment word use:" + (t2 - t1) + "ms");
		}
		return commentInfoValueTemp;
	}
	
	/**
	 * 过滤礼品评论
	 * @param commentInfoValueTemp
	 * @return
	 * @throws Exception
	 */
	private IQBOCommentInfoValue[] commentFilter(IQBOCommentInfoValue[] commentInfoValueTemp) throws Exception {
		filterWordsInfoSrv = (IFilterWordsInfoSrv) ServiceFactory.getService(CommentConstant.FILTER_WRODS_INFO_SERVICE);
		long t1 = System.currentTimeMillis();
		IFilterWordsInfoValue[] filterWordsInfoValues = filterWordsInfoSrv.queryFilterWordsInfo("", "1", "", "", 0,
				filterWordsInfoSrv.queryFilterInfoCount("", "1", "", ""));
		long t2 = System.currentTimeMillis();
		if (logger.isInfoEnabled()) {
			logger.info("get filter words from db by appframe use:" + (t2 - t1) + "ms");
		}
		filterWordsInfos = new String[filterWordsInfoValues.length];
		for (int i = 0; i < filterWordsInfos.length; i++) {
			filterWordsInfos[i] = filterWordsInfoValues[i].getFilterWord();
		}
		commentFilter = (ICommentFilterSrv) ServiceFactory.getService(CommentConstant.COMMENT_FILTER_SERVICE);
		commentFilter.setFilterWords(filterWordsInfos);
		t1 = System.currentTimeMillis();
		for (IQBOCommentInfoValue commentInfo : commentInfoValueTemp) {
			String commentOriginal = commentInfo.getCommentOriginal();
			String commentFiltered = commentFilter.doFilter(commentOriginal);
			//如果过滤后的评论和评论原文不同，则包含过滤词
			if (!commentFiltered.equals(commentOriginal)) {
				commentInfo.setBak01(commentFiltered);
			} else {
				//不包含过滤词
				commentInfo.setBak01(commentFiltered);
			}
		}
		t2 = System.currentTimeMillis();
		if (logger.isInfoEnabled()) {
			logger.info("filter comment word use:" + (t2 - t1) + "ms");
		}
		return commentInfoValueTemp;
	}

	public void setCommentInfoDAO(ICommentInfoDAO commentInfoDAO) {
		this.commentInfoDAO = commentInfoDAO;
	}

	/* 查询礼品评论数量 用于分页
	 * @see ngves.asiainfo.core.comment.service.interfaces.ICommentInfoSrv#queryCommentInfoCount(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public int queryCommentInfoCount(String wareName, String wareCode, String mobilePhoneNo, String auditFlag,
			String startTime, String endTime) throws Exception {
		StringBuffer condition = new StringBuffer();
		HashMap<String, String> parameter = new HashMap<String, String>();
		condition.append("1=1");
		if (!StringUtil.isBlank(wareName)) {

			condition.append(" AND ").append(ICommentInfoValue.S_WareName).append(" like :").append(
					ICommentInfoValue.S_WareName);
			parameter.put(ICommentInfoValue.S_WareName, "%" + wareName + "%");

		}
		if (!StringUtil.isBlank(wareCode)) {

			condition.append(" AND ").append(ICommentInfoValue.S_WareCode).append(" like :")
					.append(ICommentInfoValue.S_WareCode);
			parameter.put(ICommentInfoValue.S_WareCode, "%" + wareCode + "%");

		}
		if (!StringUtil.isBlank(mobilePhoneNo)) {

			condition.append(" AND ").append(ICommentInfoValue.S_MobilePhoneNo).append("=:").append(
					ICommentInfoValue.S_MobilePhoneNo);
			parameter.put(ICommentInfoValue.S_MobilePhoneNo, mobilePhoneNo);

		}
		if (!StringUtil.isBlank(auditFlag)) {

			condition.append(" AND ").append(ICommentInfoValue.S_AuditFlag).append("=:").append(
					ICommentInfoValue.S_AuditFlag);
			parameter.put(ICommentInfoValue.S_AuditFlag, auditFlag);

		}
		if (!StringUtil.isBlank(startTime)) {
			if (startTime.length() < 12)
				startTime = startTime + " 00:00:00";
			condition.append(" AND ").append(ICommentInfoValue.S_CommentDate).append(
					">=to_date(:startTime ,'yyyy-mm-dd hh24:mi:ss')");
			parameter.put("startTime", startTime);
		}
		if (!StringUtil.isBlank(endTime)) {
			if (endTime.length() < 12)
				endTime = endTime + " 23:59:59";
			condition.append(" AND ").append(ICommentInfoValue.S_CommentDate).append(
					"<=to_date(:endTime ,'yyyy-mm-dd hh24:mi:ss')");
			parameter.put("endTime", endTime);
		}
		return commentInfoDAO.queryCommentInfoCount(condition.toString(), parameter);
	}

	/*
	 *  礼品审核通过
	 * @see ngves.asiainfo.core.comment.service.interfaces.ICommentInfoSrv#auditCommentInfo(java.util.ArrayList)
	 */
	public void auditCommentInfoPass(ArrayList<ICommentInfoValue> commentInfoList) throws Exception {
		for (ICommentInfoValue commentInfo : commentInfoList) {
			commentInfo.setAuditFlag(CommentConstant.COMMENT_INFO_AUDIT_PASS);
			commentInfo.setAuditTime(CommentInfoEngine.getSysDate());
			//			commentInfoDAO.updateBussiPartnerInfo(commentInfo);
		}
		//利用缓存批量更新
		commentInfoDAO.updateBussiPartnerInfoBatch((ICommentInfoValue[]) commentInfoList
				.toArray(new ICommentInfoValue[commentInfoList.size()]));
	}

	/* 礼品审核不通过
	 * @see ngves.asiainfo.core.comment.service.interfaces.ICommentInfoSrv#auditCommentInfoRejectPass(java.util.ArrayList)
	 */
	public void auditCommentInfoRejectPass(ArrayList<ICommentInfoValue> commentInfoList) throws Exception {
		for (ICommentInfoValue commentInfo : commentInfoList) {
			commentInfo.setAuditFlag(CommentConstant.COMMENT_INFO_AUDIT_REJECT_PASS);
			commentInfo.setAuditTime(CommentInfoEngine.getSysDate());
			//			commentInfoDAO.updateBussiPartnerInfo(commentInfo);
		}
		//利用缓存批量更新
		commentInfoDAO.updateBussiPartnerInfoBatch((ICommentInfoValue[]) commentInfoList
				.toArray(new ICommentInfoValue[commentInfoList.size()]));
	}

	/**
	 * 根据id查询评论待审核信息 用于更新审核状态时 从数据库查询礼品评论信息
	 * @param bussId
	 * @return
	 * @throws Exception
	 */
	public ICommentInfoValue queryCommentInfoByCommentId(String commentId) throws Exception {

		StringBuffer condition = new StringBuffer();
		Map<String, String> parameter = new HashMap<String, String>();
		condition.append("1=1");
		ICommentInfoValue[] commentInfoList = null;
		ICommentInfoValue commentInfoTemp = null;

		condition.append(" AND ").append(ICommentInfoValue.S_CommentId).append("=:").append(
				ICommentInfoValue.S_CommentId);
		parameter.put(ICommentInfoValue.S_CommentId, commentId);

		commentInfoList = commentInfoDAO.queryCommentInfo(condition.toString(), parameter);
		if (commentInfoList != null && commentInfoList.length > 0) {
			commentInfoTemp = commentInfoList[0];
		}
		return commentInfoTemp;
	}

	/* 保存礼品评论
	 * @see ngves.asiainfo.core.comment.service.interfaces.ICommentInfoSrv#saveCommentInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public void saveCommentInfo(String wareId, String pWareId, String wareCode, String wareName,
			String commentOriginal, String mobileNo, String voteValue) throws Exception {
		logger.info("CommentInfoSrvImpl-saveCommentInfo is running");
		CommentInfoBean commentInfo = new CommentInfoBean();
		long commentId = CommentInfoEngine.getNewId().longValue();
		commentInfo.setCommentId(commentId);
		commentInfo.setWareId(Long.parseLong(wareId));
		commentInfo.setWareName(wareName);
		commentInfo.setWareCode(wareCode);
		commentInfo.setPWareId(Long.parseLong(pWareId));
		commentInfo.setMobilePhoneNo(mobileNo);
		commentInfo.setCommentOriginal(commentOriginal);
		commentInfo.setCommentValue(Integer.parseInt(voteValue));
		commentInfo.setCommentDate(CommentInfoEngine.getSysDate());
		commentInfoDAO.saveCommentInfo(commentInfo);
	}

	/**
	 * 根据礼品ID获取审核能过的礼品评论
	 */
	public ICommentInfoValue[] getPassCommentInfoByWareId(String wareId, int startIndex, int endIndex) throws Exception {
		return queryCommentInfo("", wareId, "", "1", "", "", startIndex, endIndex);
	}

	/**
	 * 根据礼品ID获取审核能过的礼品评论
	 */
	public int queryPassCommentInfoCount(String wareId) throws Exception {
		return queryCommentInfoCount("", wareId, "", "1", "", "");
	}

	/**
	 * 
	 * 根据礼品ID获取 审核通过 的礼品评论
	 */
	public Comment[] getAllComment(String wareId, int startIndex, int endIndex) throws Exception {
		return commentInfoDAO.getAllCommentInfo(wareId, startIndex, endIndex);
	}

	/**
	 * 
	 * 根据礼品ID获取 审核通过 的礼品评论的总条数
	 */
	public int getAllCommentInfoCount(String wareId) throws Exception {
		return commentInfoDAO.getAllCommentInfoCount(wareId);
	}

	/**
	 * 
	 * 保存礼品评论
	 */
	public long saveComment(Comment comentInfo) throws Exception {

		return commentInfoDAO.saveComment(comentInfo);
	}

	/** 
	 * 以IBatis方式 获取数据 根据父礼品ID获取 审核通过 的礼品评论
	 * @see ngves.asiainfo.core.comment.service.interfaces.ICommentInfoSrv#getAllCommentByPwareId(java.lang.String, int, int)
	 */
	public Comment[] getAllCommentByPwareId(String pWareId, int startIndex, int endIndex) throws Exception {
		Comment[] result= commentInfoDAO.getAllCommentInfoByPwareId(pWareId, startIndex, endIndex);
		for (int i = 0; i < result.length; i++) {
			result[i].setCommentOriginal(result[i].getCommentOriginal().replaceAll("\n", " ").replaceAll("  ", " "));
		}
		return result;
	}

	/**
	 * 门户使用iBatis获取数据 根据父礼品ID得到审核通过的礼品评论总条数
	 * @see ngves.asiainfo.core.comment.service.interfaces.ICommentInfoSrv#getAllCommentInfoCountByPwareId(java.lang.String)
	 */
	public int getAllCommentInfoCountByPwareId(String pWareId) throws Exception {

		return commentInfoDAO.getAllCommentInfoCountByPwareId(pWareId);
	}

	/** 以IBatis方式 获取数据 根据手机号获取 的礼品评论（包含通过和未通过的）
	 * @see ngves.asiainfo.core.comment.service.interfaces.ICommentInfoSrv#getAllCommentByMobileNo(java.lang.String)
	 */
	public Comment[] getAllCommentByMobileNo(String mobileNo) throws Exception {
		// TODO Auto-generated method stub
		Comment[] result= commentInfoDAO.getAllCommentByMobileNo(mobileNo);
		for (int i = 0; i < result.length; i++) {
			result[i].setCommentOriginal(result[i].getCommentOriginal().replaceAll("\n", " ").replaceAll("  ", " "));
		}
		return result;
	}

}
