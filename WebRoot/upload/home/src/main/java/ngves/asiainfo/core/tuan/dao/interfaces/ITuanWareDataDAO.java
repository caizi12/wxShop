/**
 * @date:2012-9-14
 *
 * Copyright 2012 asiainfo-linkage, Inc. All rights reserved. 
 * @author:shenfl
 */
package ngves.asiainfo.core.tuan.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.tuan.ivalues.IQBOComingSoonValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOReviewValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOTodayCommendValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOTuanWareDataValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOTuanWareKindValue;

public interface ITuanWareDataDAO {

	/**
	 * 
	 * @param beanSql
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public  int getCountByBeanSql(String beanSql,Map<String, String> map) throws Exception ;
	
	/**
	 * 
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public IQBOReviewValue[] getReview(int startNum, int endNum,String provinceCode) throws Exception ;

	
	/**
	 * 团购结束总页数
	 * @return
	 * @throws Exception
	 */
	public int getReviewCount(String provinceCode) throws Exception;
	
	/**
	 * @param groupType
	 */
	public IQBOTuanWareKindValue[] getTuanWareKindList(String groupType) throws Exception ;

	/**
	 *  获取今日推荐团购
	 * 
	 * @throws Exception
	 */
	public IQBOTodayCommendValue[] getTodayCommend(String proviceCode) throws Exception;

	/**
	 * 获取敬请期待
	 * 
	 * @throws Exception
	 */
	public IQBOComingSoonValue[] getComingSoon(String proviceCode) throws Exception;
	
	/**
	 * 取得所有团购列表，不进行分页
	 * @param groupType
	 * @param kindID
	 * @param sortType
	 * @param sortWay
	 * @param userBrand
	 * @return
	 * @throws Exception
	 */
	public IQBOTuanWareDataValue[] getAllTuanWare(String groupType, String kindID, String sortType, String sortWay,
			String userBrand,String provinceCode,String channel) throws Exception;
}
