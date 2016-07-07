package ngves.asiainfo.core.ware.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ngves.asiainfo.core.ware.bo.BusiActivityIntegralBean;
import ngves.asiainfo.core.ware.bo.BusiActivityIntegralEngine;
import ngves.asiainfo.core.ware.dao.interfaces.IBusiActivityIntegralDAO;
import ngves.asiainfo.core.ware.ivalues.IBusiActivityIntegralValue;
import ngves.asiainfo.util.StringUtil;

/**
 * Busi_Activity_Integral活动积分流水表DAO类
 * @author 宋鲁振
 * 
 */
public class BusiActivityIntegralDAOImpl implements IBusiActivityIntegralDAO {

	@Override
	public int getBusiActivityIntegralCount(String condition, Map<String, String> parameter) throws Exception {
	    return BusiActivityIntegralEngine.getBeansCount(condition, parameter);
	}
	@Override
	public IBusiActivityIntegralValue[] getBusiActivityIntegralValue(long wareId, long activityType, long activityID, String starLevel, String channel) throws Exception {
		Map<String, String> parameter = new HashMap<String, String>();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		
		condition.append(IBusiActivityIntegralValue.S_WareId).append(" = :").append(IBusiActivityIntegralValue.S_WareId);
		parameter.put(IBusiActivityIntegralValue.S_WareId, String.valueOf(wareId));
		
		condition.append(IBusiActivityIntegralValue.S_ActivityId).append(" = :").append(IBusiActivityIntegralValue.S_ActivityId);
		parameter.put(IBusiActivityIntegralValue.S_ActivityId, String.valueOf(activityID));
		
		condition.append(IBusiActivityIntegralValue.S_ActivityType).append(" = :").append(IBusiActivityIntegralValue.S_ActivityType);
		parameter.put(IBusiActivityIntegralValue.S_ActivityType, String.valueOf(activityType));
	    
	    
		if(StringUtil.isNotBlank(starLevel)){
			condition.append(" AND ").append(IBusiActivityIntegralValue.S_StarLevel).append(" = :").append(IBusiActivityIntegralValue.S_StarLevel);
			parameter.put(IBusiActivityIntegralValue.S_StarLevel, starLevel);
		}
		if(StringUtil.isNotBlank(channel)){
			condition.append(" AND ").append(IBusiActivityIntegralValue.S_Channel).append(" = :").append(IBusiActivityIntegralValue.S_Channel);
			parameter.put(IBusiActivityIntegralValue.S_Channel, channel);
		}

		return this.getBusiActivityIntegralValue(condition.toString(), parameter);
	}
	@Override
	public IBusiActivityIntegralValue[] getBusiActivityIntegralValue(String condition, Map<String, String> parameter) throws Exception {
	    return BusiActivityIntegralEngine.getBeans(condition, parameter);
	}
	
	@Override
	public IBusiActivityIntegralValue[] getBusiActivityIntegralValue(String condition, Map<String, String> parameter, int startIndex, int endIndex) throws Exception {
	    return BusiActivityIntegralEngine.getBeans(null, condition, parameter, startIndex, endIndex, false);
	}
	
	@Override
	public IBusiActivityIntegralValue getBusiActivityIntegralValueById(
			long id) throws Exception {
	    IBusiActivityIntegralValue value = BusiActivityIntegralEngine.getBean(id);
        return value;
	}
	
	@Override
	public long saveBusiActivityIntegral(IBusiActivityIntegralValue value)
			throws Exception {
	    long id = value.getId();
        if(id == 0){
            value.setId(BusiActivityIntegralEngine.getNewId().longValue());
        }
        BusiActivityIntegralEngine.save(value);
        return id;
	}
	
	@Override
	public void saveBusiActivityIntegral(IBusiActivityIntegralValue[] values)
			throws Exception {
	    long id;
        for(IBusiActivityIntegralValue value: values){
            id = value.getId();
            if(id == 0){
                value.setId(BusiActivityIntegralEngine.getNewId().longValue());
            }
            value.setCreateDate(BusiActivityIntegralEngine.getSysDate());
        }
        BusiActivityIntegralEngine.save(values);
	}
	
	@Override
	public void saveBusiActivityIntegralForAllChannel(long wareId, String activityType, long activityID, String[] starLevels, String[] channels, Long oriIntegral, Long oriPayIntegral, Long oriPayCash, 
			Long curIntegral, Long curPayIntegral, Long curPayCash) throws Exception{
		if(starLevels.length<1||channels.length<1){
			return;
		}
		List<IBusiActivityIntegralValue> list = new ArrayList<IBusiActivityIntegralValue>();
		for(String starLevel: starLevels){
			for(String channel :channels){
				IBusiActivityIntegralValue baiv = new BusiActivityIntegralBean();
				baiv.setWareId(wareId);
				baiv.setStarLevel(starLevel);
				baiv.setChannel(channel);
				baiv.setOriIntegral(oriIntegral);
				baiv.setOriPayCash(oriPayCash);
				baiv.setOriPayIntegral(oriPayIntegral);
				baiv.setCurIntegral(curIntegral);
				baiv.setCurPayCash(curPayCash);
				baiv.setCurPayIntegral(curPayIntegral);
				baiv.setActivityId(activityID);
				baiv.setActivityType(activityType);
				baiv.setCreateDate(new Timestamp(new Date().getTime()));
				list.add(baiv);
			}
		}
		this.saveBusiActivityIntegral((IBusiActivityIntegralValue[])list.toArray());
	}

}
