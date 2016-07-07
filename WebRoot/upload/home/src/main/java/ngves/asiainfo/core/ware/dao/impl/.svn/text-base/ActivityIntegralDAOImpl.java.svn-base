package ngves.asiainfo.core.ware.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.common.util.WareDescUtil;
import ngves.asiainfo.core.ware.bo.ActivityIntegralBean;
import ngves.asiainfo.core.ware.bo.ActivityIntegralEngine;
import ngves.asiainfo.core.ware.bo.BusiActivityIntegralBean;
import ngves.asiainfo.core.ware.dao.interfaces.IActivityIntegralDAO;
import ngves.asiainfo.core.ware.dao.interfaces.IBusiActivityIntegralDAO;
import ngves.asiainfo.core.ware.ivalues.IActivityIntegralValue;
import ngves.asiainfo.core.ware.ivalues.IBusiActivityIntegralValue;
import ngves.asiainfo.util.StringUtil;

import com.ai.appframe2.service.ServiceFactory;

/**
 * Activity_Integral表DAO层类
 * @author 宋鲁振
 * 
 */
public class ActivityIntegralDAOImpl implements IActivityIntegralDAO {

	@Override
	public int getActivityIntegralCount(String condition,
			Map<String, String> parameter) throws Exception {
		return ActivityIntegralEngine.getBeansCount(condition, parameter);
	}
	@Override
	public IActivityIntegralValue[] getActivityIntegralValue(long wareId, long activityType, long activityID, String starLevel, String channel) throws Exception {
		Map<String, String> parameter = new HashMap<String, String>();
		StringBuffer condition = new StringBuffer("");
		condition.append(IActivityIntegralValue.S_WareId).append(" = :").append(IActivityIntegralValue.S_WareId);
		parameter.put(IActivityIntegralValue.S_WareId, String.valueOf(wareId));
		
		condition.append(IActivityIntegralValue.S_ActivityId).append(" = :").append(IActivityIntegralValue.S_ActivityId);
		parameter.put(IActivityIntegralValue.S_ActivityId, String.valueOf(activityID));
		
		condition.append(IActivityIntegralValue.S_ActivityType).append(" = :").append(IActivityIntegralValue.S_ActivityType);
		parameter.put(IActivityIntegralValue.S_ActivityType, String.valueOf(activityType));
		
		if(StringUtil.isNotBlank(starLevel)){
			condition.append(" AND ").append(IActivityIntegralValue.S_StarLevel).append(" = :").append(IActivityIntegralValue.S_StarLevel);
			parameter.put(IActivityIntegralValue.S_StarLevel, starLevel);
		}
		if(StringUtil.isNotBlank(channel)){
			condition.append(" AND ").append(IActivityIntegralValue.S_Channel).append(" = :").append(IActivityIntegralValue.S_Channel);
			parameter.put(IActivityIntegralValue.S_Channel, channel);
		}
		return this.getActivityIntegralValue(condition.toString(), parameter);
	}
	@Override
	public IActivityIntegralValue[] getActivityIntegralValue(
			String condition, Map<String, String> parameter, int startIndex,
			int endIndex) throws Exception {
	    return ActivityIntegralEngine.getBeans(null, condition, parameter, startIndex, endIndex, false);
	}
	
	@Override
	public IActivityIntegralValue[] getActivityIntegralValue(
			String condition, Map<String, String> parameter) throws Exception {
		return ActivityIntegralEngine.getBeans(condition.toString(), parameter);
	}
	
	@Override
	public IActivityIntegralValue getActivityIntegralValueById(
			long id) throws Exception {
		return ActivityIntegralEngine.getBean(id);
	}
	@Override
	public long saveActivityIntegral(IActivityIntegralValue value)
			throws Exception {
	    long id = value.getId();
        if(id == 0){
            value.setId(ActivityIntegralEngine.getNewId().longValue());
        }
        ActivityIntegralEngine.save(value);
        return id;
	}
	@Override
	public void saveActivityIntegral(IActivityIntegralValue[] values)
			throws Exception {
	    long id;
        for(IActivityIntegralValue value: values){
            id = value.getId();
            if(id == 0){
                value.setId(ActivityIntegralEngine.getNewId().longValue());
            }
        }
        ActivityIntegralEngine.save(values);
	}
	
	@Override
	public void saveActivityIntegralForAllChannel(long wareId, String activityType, long activityID, String[] starLevels, String[] channels, Long oriIntegral, Long oriPayIntegral, Long oriPayCash, 
			Long curIntegral, Long curPayIntegral, Long curPayCash) throws Exception{
		if(starLevels.length<1||channels.length<1){
			return;
		}
		List<IActivityIntegralValue> list = new ArrayList<IActivityIntegralValue>();
		for(String starLevel: starLevels){
			for(String channel :channels){
				IActivityIntegralValue baiv = new ActivityIntegralBean();
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
				list.add(baiv);
			}
		}
		this.saveActivityIntegral((IActivityIntegralValue[])list.toArray());
	}
	@Override
	public void saveActivityIntegralForAllChannel(IActivityIntegralValue value) throws Exception{
		String[] starLevels =WareDescUtil.getWareSupportStarLevel(value.getWareId());
		String[] channels =CommnConstant.channels;
		List<IActivityIntegralValue> list = new ArrayList<IActivityIntegralValue>();
		List<IBusiActivityIntegralValue> busilist = new ArrayList<IBusiActivityIntegralValue>();
		
		Map<String, String> parameter = new HashMap<String, String>();
		StringBuffer condition = new StringBuffer("");
		condition.append(IActivityIntegralValue.S_WareId).append(" = :").append(IActivityIntegralValue.S_WareId+" and ");
		parameter.put(IActivityIntegralValue.S_WareId, String.valueOf(value.getWareId()));
		condition.append(IActivityIntegralValue.S_ActivityId).append(" = :").append(IActivityIntegralValue.S_ActivityId+" and ");
		parameter.put(IActivityIntegralValue.S_ActivityId, String.valueOf(value.getActivityId()));
		condition.append(IActivityIntegralValue.S_ActivityType).append(" = :").append(IActivityIntegralValue.S_ActivityType+" ");
		parameter.put(IActivityIntegralValue.S_ActivityType, String.valueOf(value.getActivityType()));
	
		
		IActivityIntegralValue[] oldValue = this.getActivityIntegralValue(condition.toString(),parameter);
		if(null!=oldValue&&oldValue.length>0){
			for(int i=0;i<oldValue.length;i++){
				oldValue[i].setCurIntegral(value.getCurIntegral());
				oldValue[i].setCurPayCash(value.getCurPayCash());
				oldValue[i].setCurPayIntegral(value.getCurPayIntegral());
			}
		}
		for(String starLevel: starLevels){
			for(String channel :channels){
				IActivityIntegralValue baiv = new ActivityIntegralBean();
				IBusiActivityIntegralValue busibaiv = new BusiActivityIntegralBean();
				baiv.setId(value.getId());
				baiv.setWareId(value.getWareId());
				baiv.setStarLevel(starLevel);
				baiv.setChannel(channel);
				baiv.setOriIntegral(value.getOriIntegral());
				baiv.setOriPayCash(value.getOriPayCash());
				baiv.setOriPayIntegral(value.getOriPayIntegral());
				baiv.setCurIntegral(value.getCurIntegral());
				baiv.setCurPayCash(value.getCurPayCash());
				baiv.setCurPayIntegral(value.getCurPayIntegral());
				baiv.setActivityId(value.getActivityId());
				baiv.setActivityType(value.getActivityType());
				list.add(baiv);
				
				busibaiv.setWareId(value.getWareId());
				busibaiv.setStarLevel(starLevel);
				busibaiv.setChannel(channel);
				busibaiv.setOriIntegral(value.getOriIntegral());
				busibaiv.setOriPayCash(value.getOriPayCash());
				busibaiv.setOriPayIntegral(value.getOriPayIntegral());
				busibaiv.setCurIntegral(value.getCurIntegral());
				busibaiv.setCurPayCash(value.getCurPayCash());
				busibaiv.setCurPayIntegral(value.getCurPayIntegral());
				busibaiv.setActivityId(value.getActivityId());
				busibaiv.setActivityType(value.getActivityType());
				busilist.add(busibaiv);
			}
		}
		if(null!=oldValue&&oldValue.length>0){
			this.saveActivityIntegral(oldValue);
		}else{
			this.saveActivityIntegral((IActivityIntegralValue[])list.toArray(new ActivityIntegralBean[0]));
		}
		IBusiActivityIntegralDAO busiActivityIntegralDAO = (IBusiActivityIntegralDAO) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_BUSI_ACTIVITY_INTEGRAL_DAO);
		busiActivityIntegralDAO.saveBusiActivityIntegral((IBusiActivityIntegralValue[])busilist.toArray(new BusiActivityIntegralBean[0]));
	}
	
	public void delActivityIntegral(IActivityIntegralValue value) throws Exception {
		Map<String, String> parameter = new HashMap<String, String>();
		StringBuffer condition = new StringBuffer("");
		condition.append(IActivityIntegralValue.S_ActivityId).append(" = :").append(IActivityIntegralValue.S_ActivityId+" and ");
		parameter.put(IActivityIntegralValue.S_ActivityId, String.valueOf(value.getActivityId()));
		condition.append(IActivityIntegralValue.S_ActivityType).append(" = :").append(IActivityIntegralValue.S_ActivityType+" ");
		parameter.put(IActivityIntegralValue.S_ActivityType, String.valueOf(value.getActivityType()));
		if(0!=value.getWareId()){
			condition.append(" and "+IActivityIntegralValue.S_WareId).append(" = :").append(IActivityIntegralValue.S_WareId+" ");
			parameter.put(IActivityIntegralValue.S_WareId, String.valueOf(value.getWareId()));
		}
		IActivityIntegralValue[] oldValue = this.getActivityIntegralValue(condition.toString(),parameter);
		if(null!=oldValue&&oldValue.length>0){
			for(int i=0;i<oldValue.length;i++){
				oldValue[i].delete();
			}
			this.saveActivityIntegral(oldValue);
		}

		
	}
	public void saveActivityIntegralForAllChannel(IActivityIntegralValue[] values) throws Exception {
		for(int i=0 ; i<values.length;i++){
			this.saveActivityIntegralForAllChannel(values[i]);
		}
	}
	

}
