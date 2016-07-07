package ngves.asiainfo.core.rushbuy.service.interfaces;

import java.util.HashMap;

import ngves.asiainfo.core.common.dao.interfaces.IClobInfoDAO;
import ngves.asiainfo.core.rushbuy.dao.interfaces.IRushBuyDAO;
import ngves.asiainfo.core.rushbuy.ivalues.IActivityBindRelationValue;
import ngves.asiainfo.core.rushbuy.ivalues.IActivityLimitValue;
import ngves.asiainfo.core.rushbuy.ivalues.IActivityUserLogValue;
import ngves.asiainfo.core.rushbuy.ivalues.IQBOActivityWareInfoValue;

/**
 * 现时抢兑业务实现接口
 * @author zhulin
 *
 */
public interface IRushBuySrv {

    
    public void setRushBuyDAO(IRushBuyDAO rushBuyDAO);
    public void setClobInfoDAO(IClobInfoDAO clobInfoDAO);
    
    /**
	 * 获取首页展示的限时抢兑,规则：<br/>
	 * 在当天开始的活动且在生成首页时该活动还没有结束
	 * @return
	 * @throws Exception
	 */
	public IActivityLimitValue[] getIndexActivitys(HashMap<String,String> paramMap) throws Exception;
    
    /**
     * 取得活动信息，根据活动编号，用于内存加载
     * @param limitId
     * @return
     * @throws Exception
     */
    public IActivityLimitValue[] getActivityLimit()throws Exception;
    
    /**
     * 通过活动ID得到活动问题描述(存储于大字段中)
     * @param activityId
     * @return
     * @throws Exception
     */
    public String getActivityQuestion(long activityId) throws Exception;
    
    /**
     * 根据活动编号，取得绑定的礼品编号信息，用于内存加载
     * @param limitId
     * @return
     * @throws Exception
     */
    public IActivityBindRelationValue[] getWareIdsByActivityId(String activityId) throws Exception;
    
    /**
     * 根据礼品和活动编号取得对应的礼品信息，用于内存加载
     * 
     * 需要starLevel
     * @param wareIdAndLmitId
     * @return
     * @throws Exception
     */
    public IQBOActivityWareInfoValue getAcWareInfo(String wareIdAndActivityId, String starLevel, String channel) throws Exception;
    
    /**
     * 根据礼品和活动编号取得对应的礼品信息，用于内存加载
     * 
     * 不需要starLevel
     * 
     * @param wareIdAndLmitId
     * @return
     * @throws Exception
     */
    public IQBOActivityWareInfoValue getAcWareInfo(String wareIdAndActivityId, String channel) throws Exception;
    /**
     * 修改活动显示状态（是否在前台的往期活动中出现）
     * @param activityId
     * @param isView
     * @return
     * @throws Exception
     */
    public void changeIsView(long activityId, boolean isView) throws Exception;
    
    //修改活动显示状态 增加日志
    public void changeIsView(long activityId, boolean isView, long staffId, String comType, long orgId) throws Exception;
    
    /**
     * 根据抢兑活动ID得到限时抢兑活动信息,没有抢兑问题描述信息,用于加载到缓存
     * @param activityId
     * @return
     * @throws Exception
     */
    public IActivityLimitValue getActivityInfo( long activityId ) throws Exception;
    
    /**
     * 根据抢兑活动ID得到抢兑问题描述信息
     * @param activityId
     * @return
     * @throws Exception
     */
    public String getActivityQuestionById(long activityId ) throws Exception;

    /**
     * 根据手机号和活动号得到用户抢中记录，用以在界面中显示”立即抢兑“还是”重新下单“。
     * @param mobileNumber
     * @param activityId
     * @return
     * @throws Exception
     */
    public IActivityUserLogValue[] getUserLogInfo(String mobileNumber, String activityId) throws Exception;
    /**
     * 得到已经开始的活动ID，加载内容到缓存
     * @return
     * @throws Exception
     */
    public IActivityLimitValue[] getStartActivityIds() throws Exception;
    


}
