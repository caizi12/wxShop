package ngves.asiainfo.core.activity.dao.impl;

import java.util.Map;
import ngves.asiainfo.core.SqlMapSessionTemplate;
import ngves.asiainfo.core.activity.bo.LuckyMoneyActivityInfoBean;
import ngves.asiainfo.core.activity.bo.LuckyMoneyActivityInfoEngine;
import ngves.asiainfo.core.activity.dao.interfaces.ILuckyMoneyActivityInfoDAO;
import ngves.asiainfo.core.activity.ivalues.ILuckyMoneyActivityInfoValue;

public class LuckyMoneyActivityInfoDAOImpl extends SqlMapSessionTemplate implements ILuckyMoneyActivityInfoDAO {
	public ILuckyMoneyActivityInfoValue[] queryLuckyMoneyInfo(String condition, Map<String, Object> parameter)
			throws Exception {
		return LuckyMoneyActivityInfoEngine.getBeans(condition, parameter);
	}

	public ILuckyMoneyActivityInfoValue[] queryLuckyMoneyInfo(String condition, Map<String, Object> parameter,
			int startIndex, int endIndex) throws Exception {
		return LuckyMoneyActivityInfoEngine.getBeans(null, condition, parameter, startIndex, endIndex, false);
	}

	public int queryLuckyMoneyInfoCount(String condition, Map<String, Object> parameter) throws Exception {
		return LuckyMoneyActivityInfoEngine.getBeansCount(condition, parameter);
	}

	public void saveLuckyMoneyInfo(LuckyMoneyActivityInfoBean luckyMoneyInfo) throws Exception {
		long id = luckyMoneyInfo.getLuckyId();
		if (id == 0L) {
			luckyMoneyInfo.setLuckyId(LuckyMoneyActivityInfoEngine.getNewId().longValue());
		}
		LuckyMoneyActivityInfoEngine.save(luckyMoneyInfo);
	}
}