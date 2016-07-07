/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.information.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.common.bo.SaleEmailOpenEngine;
import ngves.asiainfo.core.common.ivalues.ISaleEmailOpenValue;
import ngves.asiainfo.core.information.dao.interfaces.ISaleEmailOpenDAO;

/**
 * 营销邮件打开率DAO层的默认实现类
 * @author wzg
 *
 */
public class SaleEmailOpenDAOImpl implements ISaleEmailOpenDAO {

	private static final String GETSALEEMAILOPENCOUNT_SQL = " SELECT COUNT(*) AS SALE_ID FROM ( SELECT DISTINCT(S.USER_EMAIL) FROM SALE_EMAIL_OPEN S "
			+ " WHERE S.SALE_ID = :" + ISaleEmailOpenValue.S_SaleId + " )";

	public int getSaleEmailOpenCount(long saleId) throws Exception {
		Map<String, Long> parameter = new HashMap<String, Long>();
		parameter.put(ISaleEmailOpenValue.S_SaleId, saleId);
		return (int)SaleEmailOpenEngine.getBeansFromSql(GETSALEEMAILOPENCOUNT_SQL, parameter)[0].getSaleId();
	}

	public void savdSaleEmailOpenVale(ISaleEmailOpenValue saleEmailOpenValue) throws Exception {
		if (saleEmailOpenValue.isNew()) {
			saleEmailOpenValue.setOpenId(SaleEmailOpenEngine.getNewId().longValue());
		}
		SaleEmailOpenEngine.save(saleEmailOpenValue);
	}

}
