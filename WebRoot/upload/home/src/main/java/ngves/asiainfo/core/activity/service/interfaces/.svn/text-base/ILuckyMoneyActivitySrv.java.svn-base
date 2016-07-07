package ngves.asiainfo.core.activity.service.interfaces;

import java.util.Map;
import net.sf.json.JSONObject;
import ngves.asiainfo.core.activity.bo.LuckyMoneyActivityInfoBean;
import ngves.asiainfo.core.activity.dao.interfaces.ILuckyMoneyActivityInfoDAO;
import ngves.asiainfo.core.activity.ivalues.ILuckyMoneyActivityInfoValue;
/**
* 2015年3月6号结束
* 
* @author 宋鲁振
*
*/
@Deprecated
public interface ILuckyMoneyActivitySrv {
	public void setLuckyMoneyActivityDAO(ILuckyMoneyActivityInfoDAO luckyMoneyActivityInfoDAO);

	public ILuckyMoneyActivityInfoValue[] queryLuckyMoneyInfo(String condition, Map<String, Object> parameter)
			throws Exception;

	public ILuckyMoneyActivityInfoValue[] queryLuckyMoneyInfo(String condition, Map<String, Object> parameter, int start,
			int end) throws Exception;

	public int queryLuckyMoneyInfoCount(String condition, Map<String, Object> parameter) throws Exception;

	public void saveLuckyMoneyInfo(LuckyMoneyActivityInfoBean paramLuckyMoneyActivityInfoBean) throws Exception;

	public JSONObject getLuckyMoney(String paramString1, String paramString2, String paramString3, String paramString4) throws Exception;
}