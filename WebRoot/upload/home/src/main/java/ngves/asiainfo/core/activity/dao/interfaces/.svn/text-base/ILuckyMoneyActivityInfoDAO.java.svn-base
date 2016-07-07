package ngves.asiainfo.core.activity.dao.interfaces;

import java.util.Map;
import ngves.asiainfo.core.activity.bo.LuckyMoneyActivityInfoBean;
import ngves.asiainfo.core.activity.ivalues.ILuckyMoneyActivityInfoValue;

public interface ILuckyMoneyActivityInfoDAO {
	public ILuckyMoneyActivityInfoValue[] queryLuckyMoneyInfo(String condition, Map<String, Object> parameter)
			throws Exception;

	public ILuckyMoneyActivityInfoValue[] queryLuckyMoneyInfo(String condition, Map<String, Object> parameter,
			int startIndex, int endIndex) throws Exception;

	public int queryLuckyMoneyInfoCount(String condition, Map<String, Object> parameter) throws Exception;

	public void saveLuckyMoneyInfo(LuckyMoneyActivityInfoBean bean)
			throws Exception;
}