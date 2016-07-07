/**
 * @date:2012-9-14
 *
 * Copyright 2012 asiainfo-linkage, Inc. All rights reserved. 
 * @author:shenfl
 */
package ngves.asiainfo.core.tuan.service.interfaces;

import ngves.asiainfo.core.tuan.dao.interfaces.ITuanCycleInfoDAO;
import ngves.asiainfo.core.tuan.dao.interfaces.ITuanWareDataDAO;
import ngves.asiainfo.core.tuan.ivalues.IQBOComingSoonValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOReviewValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOTodayCommendValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOTuanWareDataValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOTuanWareKindValue;

public interface ITuanWareDataSrv {

	public void setTuanWareDataDAO(ITuanWareDataDAO tuanWareDataDAO) throws Exception;
	public void setTuanCycleInfoDAO(ITuanCycleInfoDAO tuanCycleInfoDAO) throws Exception;
	
	/**
	 * 
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public IQBOReviewValue[] getReview(int startNum, int endNum,String provinceCode) throws Exception ;
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public int getReviewCount(String provinceCode) throws Exception;

	/**
	 * @param groupType
	 */
	public IQBOTuanWareKindValue[] getTuanWareKindList(String groupType) throws Exception;


	/**
	 * 获取今日推荐团购
	 * 
	 * @throws Exception
	 */
	public IQBOTodayCommendValue[] getTodayCommend(String provinceCode) throws Exception;

	/**
	 * 获取敬请期待
	 * 
	 * @throws Exception
	 */
	public IQBOComingSoonValue[] getComingSoon(String provinceCode) throws Exception;
	/**
	 * 取得所有团购列表，不进行分页(新增一个查询条件provinceCode)
	 * @param groupType
	 * @param kindID	
	 * @param sortType
	 * @param sortWay
	 * @param userBrand
	 * @param channel
	 * @return
	 * @throws Exception
	 */
	public IQBOTuanWareDataValue[] getAllTuanWare(String groupType, String kindID, String sortType, String sortWay,
			String starLevel,String provinceCode,String channel) throws Exception ;
}
