/**
 * @date:2012-9-14
 *
 * Copyright 2012 asiainfo-linkage, Inc. All rights reserved. 
 * @author:shenfl
 */
package ngves.asiainfo.core.tuan.service.impl;

import java.util.ArrayList;
import java.util.List;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.tuan.bo.QBOTuanWareDataBean;
import ngves.asiainfo.core.tuan.dao.interfaces.ITuanCycleInfoDAO;
import ngves.asiainfo.core.tuan.dao.interfaces.ITuanWareDataDAO;
import ngves.asiainfo.core.tuan.ivalues.IQBOComingSoonValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOReviewValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOTodayCommendValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOTuanWareDataValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOTuanWareKindValue;
import ngves.asiainfo.core.tuan.ivalues.ITuanCycleInfoValue;
import ngves.asiainfo.core.tuan.model.PageBean;
import ngves.asiainfo.core.tuan.service.interfaces.ITuanWareDataSrv;
import ngves.asiainfo.core.tuan.util.TuanInfoUtil;
import ngves.asiainfo.core.ware.WareParamConstant;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TuanWareDataSrvImpl implements ITuanWareDataSrv {

	private static final Log logger = LogFactory.getLog(TuanWareDataSrvImpl.class);
	
	private ITuanWareDataDAO tuanWareDataDAO;

	private ITuanCycleInfoDAO tuanCycleInfoDAO ;
	/**
	 * @param tuanCycleInfoDAO the tuanCycleInfoDAO to set
	 */
	public void setTuanCycleInfoDAO(ITuanCycleInfoDAO tuanCycleInfoDAO) throws Exception {
		this.tuanCycleInfoDAO = tuanCycleInfoDAO;
	}

	/**
	 * @param tuanWareDataDAO
	 *            the tuanWareDataDAO to set
	 */
	public void setTuanWareDataDAO(ITuanWareDataDAO tuanWareDataDAO) throws Exception {
		this.tuanWareDataDAO = tuanWareDataDAO;
	}

	// 今日推荐，分类为全部，排序为默认情况下支持轮转操作
	public IQBOTuanWareDataValue[] getAllTuanWare(String groupType, String kindID, String sortType, String sortWay,
			String starLevel,String provinceCode,String channel) throws Exception {

		IQBOTuanWareDataValue[] values = null;
		List<String> checkValueList = new ArrayList<String>();
		List<IQBOTuanWareDataValue> wareList = new ArrayList<IQBOTuanWareDataValue>();
		// 置顶数据topflag=1
		List<IQBOTuanWareDataValue> topList = new ArrayList<IQBOTuanWareDataValue>();
		// 轮转数据topflag=0
		List<IQBOTuanWareDataValue> cycleList = new ArrayList<IQBOTuanWareDataValue>();
		// 获取原始数据:第二个参数为空，获取所有团购列表,以便页面统计不同小类下礼品的数量
		values = tuanWareDataDAO.getAllTuanWare(groupType, "", sortType, sortWay, starLevel,provinceCode,channel);
		
		//列表页，相同的团购，相同的礼品只能展示一个
		if(values != null && values.length > 0){
			for(IQBOTuanWareDataValue value : values){
				if(!checkValueList.contains(value.getTuanId()+"="+value.getWareId())){
					checkValueList.add(value.getTuanId()+"="+value.getWareId());
					wareList.add(value);
				}
			}
		}
		
		IQBOTuanWareDataValue[] unionValue = null;
		unionValue = new QBOTuanWareDataBean[wareList.size()];
		unionValue = wareList.toArray(unionValue);
		
		//团购汇总页面-今日推荐-类别为小类，排序为默认，原始数据存在
		if (WareParamConstant.TUAN_TYPE_NOW.equals(groupType) && WareParamConstant.TUAN_WARE_ID_ALL.equals(kindID)
				&& WareParamConstant.SORT_TYPE_DEFAULT.equals(sortType) && (wareList != null && wareList.size() > 0)) {
			//原始数据
			for (int i = 0; i < wareList.size(); i++) {
				if (1 == wareList.get(i).getTopFlag()) {
					topList.add(wareList.get(i));
				} else {
					cycleList.add(wareList.get(i));
				}
			}
			
			unionValue = recomputeUnionAlgorithm(topList, cycleList);
		}
		return unionValue;
	}

	/**
	 * <p>
	 * 	1. 原始数据分割置顶数据列表和轮转列表
	 *  2. 对轮转列表进行算法整合处理
	 * </p>
	 * @param values
	 *            原数据,不能为空
	 * @param topList
	 *            置顶数据
	 * @param cycleList
	 *            轮转数据
	 */
	private List<IQBOTuanWareDataValue> recomputeCycleList(List<IQBOTuanWareDataValue> cycleList) throws Exception {

		// 获取轮转配置对象
		ITuanCycleInfoValue tuanCycleInfoValue = tuanCycleInfoDAO.getTuanCycleInfo(
				CoreConstant.ACTIVITY_TUAN_GROUP_TUANALL, CoreConstant.ACTIVITY_TUAN_GROUP_TODATY_RECOMMEND);
		// 获取当前设置轮转个数
		int cycleCount = cycleList.size();
		/**
		 *1. 如果存在轮转礼品并且当前轮转状态为“开”，那么根据轮转算法重新整合cycleList数据。 2.
		 * 满足第一步，重新获取轮转数据的开始和结果索引位置 3. 根据开始和结果索引获取对应整合后数据
		 */
		if (tuanCycleInfoValue.getIsSpell() == 1 && cycleCount > 0) {

			PageBean pageBean = TuanInfoUtil.getSpellIndex((int) tuanCycleInfoValue.getSpellInternalLength(),
					tuanCycleInfoValue.getSpellSatrtTime(), cycleCount, cycleCount);
			logger.info("tuanCycleInfoValue.getIsSpell()=" + tuanCycleInfoValue.getIsSpell() + ",startIndex = "
					+ (pageBean.getStartNum()) + ",endIndex=" + (pageBean.getEndNum()));
			cycleList = recomputeListAlgorithm(cycleList, pageBean.getStartNum() - 1, pageBean.getEndNum() - 1,
					cycleCount);
		}
		return cycleList;
	}

	/**
	 * 
	 * @param values
	 * @param topList
	 * @param cycleList
	 * @return
	 * @throws Exception
	 */
	private IQBOTuanWareDataValue[] recomputeUnionAlgorithm(List<IQBOTuanWareDataValue> topList, List<IQBOTuanWareDataValue> cycleList) throws Exception {

		cycleList = recomputeCycleList(cycleList);

		List<IQBOTuanWareDataValue> unionList = new ArrayList<IQBOTuanWareDataValue>();
		IQBOTuanWareDataValue[] unionValue = null;
		if (topList != null && topList.size() > 0) {
			unionList.addAll(topList);
		}
		if (cycleList != null && cycleList.size() > 0) {
			unionList.addAll(cycleList);
		}
		unionValue = new QBOTuanWareDataBean[unionList.size()];
		unionList.toArray(unionValue);
		return unionValue;
	}
	/**
	 * @param cycleList
	 *            整合前数据(前提不能为空)
	 * @param cycleLen
	 * @param startNum
	 *            cyclist中的开始索引
	 * @param endNum
	 *            cyclist中的结束索引
	 * @return subList 非法的端点值 (fromIndex < 0 || toIndex > size || fromIndex >
	 *         toIndex)。
	 */
	private List<IQBOTuanWareDataValue> recomputeListAlgorithm(List<IQBOTuanWareDataValue> cycleList, int startIndex,
			int endIndex, int cycleLen) {

		if (0 <= startIndex && endIndex <= cycleLen && startIndex <= endIndex) {
			// 整合后结果列表
			List<IQBOTuanWareDataValue> resultList = new ArrayList<IQBOTuanWareDataValue>();

			List<IQBOTuanWareDataValue> beforeList = cycleList.subList(0, startIndex);
			List<IQBOTuanWareDataValue> afterList = cycleList.subList(startIndex, endIndex + 1);
			int afterCount = 0;
			if (afterList != null && afterList.size() > 0) {
				resultList.addAll(0, afterList);
				afterCount = afterList.size();
			}
			if (beforeList != null && beforeList.size() > 0) {
				resultList.addAll(afterCount, beforeList);
			}
			cycleList = resultList;
		}
		return cycleList;
	}


	public IQBOReviewValue[] getReview(int startNum, int endNum,String provinceCode) throws Exception {
		return tuanWareDataDAO.getReview(startNum, endNum,provinceCode);
	}

	public int getReviewCount(String provinceCode) throws Exception {
		return tuanWareDataDAO.getReviewCount(provinceCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seengves.asiainfo.core.tuan.service.interfaces.ITuanWareDataSrv#
	 * getTuanWareKindList(java.lang.String)
	 */
	public IQBOTuanWareKindValue[] getTuanWareKindList(String groupType) throws Exception {
		return tuanWareDataDAO.getTuanWareKindList(groupType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ngves.asiainfo.core.tuan.service.interfaces.ITuanWareDataSrv#getComingSoon
	 * ()
	 */
	public IQBOComingSoonValue[] getComingSoon(String provinceCode) throws Exception {
		return tuanWareDataDAO.getComingSoon(provinceCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ngves.asiainfo.core.tuan.service.interfaces.ITuanWareDataSrv#getTodayCommend
	 * ()
	 */
	public IQBOTodayCommendValue[] getTodayCommend(String provinceCode) throws Exception {
		return tuanWareDataDAO.getTodayCommend(provinceCode);
	}
}
