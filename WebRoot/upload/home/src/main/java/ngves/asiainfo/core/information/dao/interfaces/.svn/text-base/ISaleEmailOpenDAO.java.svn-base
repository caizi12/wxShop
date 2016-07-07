/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.information.dao.interfaces;

import ngves.asiainfo.core.common.ivalues.ISaleEmailOpenValue;

/**
 * 营销邮件打开率DAO层
 * @author wzg
 *
 */
public interface ISaleEmailOpenDAO {
	
	/**
	 * 保存营销邮件打开记录
	 * @param saleEmailOpenValue	营销邮件打开记录
	 * @throws Exception
	 */
	public void savdSaleEmailOpenVale(ISaleEmailOpenValue saleEmailOpenValue) throws Exception;
	
	/**
	 * <p>获取营销邮件打开的总数
	 * <p>统计收到该营销邮件打开的用户数(重复打开算一次)
	 * @param saleId	营销邮件主键
	 * @return
	 * @throws Exception
	 */
	public int getSaleEmailOpenCount(long saleId) throws Exception;
}
