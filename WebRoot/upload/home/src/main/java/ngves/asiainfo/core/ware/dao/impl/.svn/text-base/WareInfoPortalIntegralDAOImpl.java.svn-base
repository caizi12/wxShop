package ngves.asiainfo.core.ware.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ngves.asiainfo.core.ware.bo.WareInfoPortalIntegralBean;
import ngves.asiainfo.core.ware.bo.WareInfoPortalIntegralEngine;
import ngves.asiainfo.core.ware.dao.interfaces.IWareInfoPortalIntegralDAO;
import ngves.asiainfo.core.ware.ivalues.IWareInfoPortalIntegralValue;
import ngves.asiainfo.util.StringUtil;

/**
 * Ware_Info_Portal_Integral表DAO层类
 * @author 宋鲁振
 * 
 */
public class WareInfoPortalIntegralDAOImpl implements IWareInfoPortalIntegralDAO {
	@Override
	public IWareInfoPortalIntegralValue[] getWareInfoPortalIntegralValue(String wareId, String starLevel, String channel) throws Exception {
		Map<String, String> parameter = new HashMap<String, String>();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		if(StringUtil.isNotBlank(wareId)){
			condition.append(" AND ").append(IWareInfoPortalIntegralValue.S_WareId).append(" = :").append(IWareInfoPortalIntegralValue.S_WareId);
			parameter.put(IWareInfoPortalIntegralValue.S_WareId, wareId);
		}
		if(StringUtil.isNotBlank(starLevel)){
			condition.append(" AND ").append(IWareInfoPortalIntegralValue.S_StarLevel).append(" = :").append(IWareInfoPortalIntegralValue.S_StarLevel);
			parameter.put(IWareInfoPortalIntegralValue.S_StarLevel, starLevel);
		}
		if(StringUtil.isNotBlank(channel)){
			condition.append(" AND ").append(IWareInfoPortalIntegralValue.S_Channel).append(" = :").append(IWareInfoPortalIntegralValue.S_Channel);
			parameter.put(IWareInfoPortalIntegralValue.S_Channel, channel);
		}

		return this.getWareInfoPortalIntegralValue(condition.toString(), parameter);
	}
	@Override
	public IWareInfoPortalIntegralValue[] getWareInfoPortalIntegralValue(
			String condition, Map<String, String> parameter) throws Exception {
		return WareInfoPortalIntegralEngine.getBeans(condition, parameter);
	}
	@Override
	public IWareInfoPortalIntegralValue[] getWareInfoPortalIntegralValue(
			String condition, Map<String, String> parameter, int startNum,
			int endNum) throws Exception {
	    return WareInfoPortalIntegralEngine.getBeans(null, condition, parameter, startNum, endNum, false);
	}
	@Override
	public IWareInfoPortalIntegralValue getWareInfoPortalIntegralValueById(
			long id) throws Exception {
	    IWareInfoPortalIntegralValue value = WareInfoPortalIntegralEngine.getBean(id);
        return value;
	}
	@Override
	public long saveWareInfoPortalIntegral(IWareInfoPortalIntegralValue value)
			throws Exception {
	    long id = value.getId();
        if(id == 0){
            value.setId(WareInfoPortalIntegralEngine.getNewId().longValue());
        }
        WareInfoPortalIntegralEngine.save(value);
        return id;
	}
	@Override
	public void saveWareInfoPortalIntegral(IWareInfoPortalIntegralValue[] values)
			throws Exception {
	    long id;
        for(IWareInfoPortalIntegralValue value: values){
            id = value.getId();
            if(id == 0){
                value.setId(WareInfoPortalIntegralEngine.getNewId().longValue());
            }
        }
        WareInfoPortalIntegralEngine.save(values);
	}
	
	@Override
	public void saveWareInfoPortalIntegralForAllChannel(long wareId, String[] starLevels, String[] channels, Long oriIntegral, Long oriPayIntegral, Long oriPayCash, 
			Long curIntegral, Long curPayIntegral, Long curPayCash) throws Exception{
		if(starLevels.length<1||channels.length<1){
			return;
		}
		List<IWareInfoPortalIntegralValue> list = new ArrayList<IWareInfoPortalIntegralValue>();
		for(String starLevel: starLevels){
			for(String channel :channels){
				IWareInfoPortalIntegralValue wiiv = new WareInfoPortalIntegralBean();
				wiiv.setWareId(wareId);
				wiiv.setStarLevel(starLevel);
				wiiv.setChannel(channel);
				wiiv.setOriIntegral(oriIntegral);
				wiiv.setOriPayCash(oriPayCash);
				wiiv.setOriPayIntegral(oriPayIntegral);
				wiiv.setCurIntegral(curIntegral);
				wiiv.setCurPayCash(curPayCash);
				wiiv.setCurPayIntegral(curPayIntegral);
				list.add(wiiv);
			}
		}
		this.saveWareInfoPortalIntegral((IWareInfoPortalIntegralValue[])list.toArray());
	}
	@Override
	public IWareInfoPortalIntegralValue getMinIntegralValue(Map<String, String> parameter)
			throws Exception {
		String sql = "select "
		     +"min(wipi.cur_integral) as cur_integral,"
		     +"min(wipi.cur_pay_integral) as cur_pay_integral,"
		     +"min(wipi.cur_pay_cash) as cur_pay_cash "
		+" from ware_info_portal_integral wipi"
		+" where wipi.channel= :CHANNEL "
		    +" and wipi.ware_id = :WARE_ID "
		    +" and wipi.star_level not in ('05','06')";
		IWareInfoPortalIntegralValue[] integralValues = WareInfoPortalIntegralEngine.getBeansFromSql(sql,
				parameter);
		
		if (null != integralValues && integralValues.length > 0) {
			return integralValues[0];
		}
			
		return null;
	}

}
