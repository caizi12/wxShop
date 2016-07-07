package ngves.asiainfo.core.rushbuy.service.impl;
import java.util.HashMap;

import ngves.asiainfo.core.common.dao.interfaces.IClobInfoDAO;
import ngves.asiainfo.core.rushbuy.dao.interfaces.IRushBuyDAO;
import ngves.asiainfo.core.rushbuy.ivalues.IActivityBindRelationValue;
import ngves.asiainfo.core.rushbuy.ivalues.IActivityLimitValue;
import ngves.asiainfo.core.rushbuy.ivalues.IActivityUserLogValue;
import ngves.asiainfo.core.rushbuy.ivalues.IQBOActivityWareInfoValue;
import ngves.asiainfo.core.rushbuy.service.interfaces.IRushBuySrv;
import ngves.asiainfo.util.StringUtil;
/**
 * 现时抢兑业务实现类
 * @author zhulin
 *
 */
public class RushBuySrvImpl implements IRushBuySrv{

    //通过注入方式取得dao的引用
    private IRushBuyDAO rushBuyDAO;
    private IClobInfoDAO clobInfoDAO;
    private String ACTIVITY_TABLE_NAME = "ACTIVITY_LIMIT";
    public void setClobInfoDAO(IClobInfoDAO clobInfoDAO) {
		this.clobInfoDAO = clobInfoDAO;
	}
    
    public IActivityLimitValue[] getIndexActivitys(HashMap<String,String> paramMap) throws Exception {
		return this.rushBuyDAO.getIndexActivitys(paramMap);
	}

	public void setRushBuyDAO(IRushBuyDAO rushBuyDAO) {
        this.rushBuyDAO = rushBuyDAO;
    }
	
	
	/**
	 * 得到已经开始的活动ID，加载内容到缓存
	 */
    public IActivityLimitValue[] getStartActivityIds() throws Exception {
		return rushBuyDAO.getStartActivityIds();
	}


    /**
     * 根据礼品和活动编号取得对应的礼品信息，用于内存加载
     * 
     * 需要starLevel
     * 
     * @param wareIdAndLmitId
     * @return
     * @throws Exception
     */
    public IQBOActivityWareInfoValue getAcWareInfo(String wareIdAndActivityId, String starLevel, String channel) throws Exception {
        if(StringUtil.isBlank(wareIdAndActivityId)) return null;
        String[] wareActivityIds = wareIdAndActivityId.split(",");
        if(wareActivityIds.length != 2){
            return null;
        }
        return rushBuyDAO.getActivityWareInfo(wareActivityIds[0], wareActivityIds[1], starLevel, channel);
    }
    
    /**
     * 根据礼品和活动编号取得对应的礼品信息，用于内存加载
     * 
     * 无需starLevel
     * 
     * @param wareIdAndLmitId
     * @return
     * @throws Exception
     */
    public IQBOActivityWareInfoValue getAcWareInfo(String wareIdAndActivityId, String channel) throws Exception {
        if(StringUtil.isBlank(wareIdAndActivityId)) return null;
        String[] wareActivityIds = wareIdAndActivityId.split(",");
        if(wareActivityIds.length != 2){
            return null;
        }
        return rushBuyDAO.getActivityWareInfo(wareActivityIds[0], wareActivityIds[1], channel);
    }

    public void changeIsView(long activityId, boolean isView) throws Exception {
        rushBuyDAO.changeIsView(activityId, isView);
    }
    //限时抢兑是否显示增加日志
    public void changeIsView(long activityId, boolean isView,long staffId, String comType, long orgId) throws Exception {
        rushBuyDAO.changeIsView(activityId, isView, staffId, comType, orgId);
    }

    /**
     * 取得活动信息，根据活动编号，用于内存加载
     * @param limitId
     * @return
     * @<p>修改活动说明字段的加载方式</p>
     * @throws Exception
     */
    public IActivityLimitValue[] getActivityLimit() throws Exception {
    	
    	IActivityLimitValue[] activityInfos = rushBuyDAO.getActivityLimit();
//    	for(IActivityLimitValue value : activityInfos) {
//    		
//    		value.setActivityQuestion(clobInfoDAO.getContent(value.getActivityId(), ACTIVITY_TABLE_NAME));
//    		
//    	}
        return activityInfos;
    }
    
    /**
     * 通过活动ID得到存储于大字段中活动问题描述
     */
    public String getActivityQuestion(long activityId) throws Exception {
    	return clobInfoDAO.getContent(activityId, ACTIVITY_TABLE_NAME);
    }

    /**
     * 根据活动编号，取得绑定的礼品编号信息，用于内存加载
     * @param limitId
     * @return
     * @throws Exception
     */
    public IActivityBindRelationValue[] getWareIdsByActivityId(String activityId) throws Exception {
        if(StringUtil.isBlank(activityId)) return null;
        return rushBuyDAO.getAcBindReInfos(activityId);
    }
    
    public IActivityLimitValue getActivityInfo( long activityId ) throws Exception {
    	return rushBuyDAO.getActivityLimitById(activityId);
    }
    
    public String getActivityQuestionById(long activityId ) throws Exception {
    	return clobInfoDAO.getContent(activityId, ACTIVITY_TABLE_NAME);
    }

    public IActivityUserLogValue[] getUserLogInfo(String mobileNumber, String activityId) throws Exception{
        return rushBuyDAO.getUserLogInfo(mobileNumber, activityId);
    }
}

