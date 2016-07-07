package ngves.asiainfo.core.rushbuy.dao.interfaces;

import java.util.HashMap;

import ngves.asiainfo.core.rushbuy.ivalues.IActivityBindRelationValue;
import ngves.asiainfo.core.rushbuy.ivalues.IActivityLimitValue;
import ngves.asiainfo.core.rushbuy.ivalues.IActivityUserLogValue;
import ngves.asiainfo.core.rushbuy.ivalues.IQBOActivityWareInfoValue;


/**
 * 现时抢兑礼品数据持久化层
 * @author zhulin
 *
 */
public interface IRushBuyDAO {
	
	/**
	 * 获取首页展示的限时抢兑,规则：<br/>
	 * 在当天开始的活动且在生成首页时该活动还没有结束
	 * @return
	 * @throws Exception
	 */
	public IActivityLimitValue[] getIndexActivitys(HashMap<String,String> paramMap) throws Exception;
	
	
	/**
	 * 得到开始的活动,用于内存刷新
	 * @return
	 * @throws Exception
	 */
	public IActivityLimitValue[] getStartActivityIds() throws Exception;
    
    /**
     * 取得活动信息，用于内存加载
     * @param limitId
     * @return
     * @throws Exception
     */
    public IActivityLimitValue[] getActivityLimit() throws Exception;
    
    /**
     * 根据活动编号取得绑定礼品信息
     * @param activityId
     * @return
     * @throws Exception
     */
    public IActivityBindRelationValue[] getAcBindReInfos(String activityId) throws Exception;
    
    /**
     * 取得要显示抢兑的礼品信息
     * 礼品基本信息从ware_info表取出
     * 礼品积分信息从activity_bind_relationq取出
     * 
     * 星级体系
     * 
     * @param wareId
     * @return
     * @throws Exception
     */
    public IQBOActivityWareInfoValue getActivityWareInfo(String wareId,String activityId, String starLevel, String channel) throws Exception;
    
    /**
     * 取得要显示抢兑的礼品信息
     * 礼品基本信息从ware_info表取出
     * 礼品积分信息从activity_bind_relationq取出
     * 
     * 指定星级体系
     * 
     * @param wareId
     * @return
     * @throws Exception
     */
    public IQBOActivityWareInfoValue getActivityWareInfo(String wareId, String activityId, String channel) throws Exception;
    /**
     * 修改活动显示状态（是否在前台的往期活动中出现）
     * @param activityId
     * @param isView
     * @return
     * @throws Exception
     */
    public void changeIsView(long activityId, boolean isView) throws Exception;
    
    //修改活动显示状态时增加日志记录
    public void changeIsView(long activityId, boolean isView,long staffId, String comType, long orgId) throws Exception;
    
    /**
     * 根据抢兑活动ID得到限时抢兑活动信息
     * @param activityId
     * @return
     * @throws Exception
     */
    public IActivityLimitValue getActivityLimitById(long activityId) throws Exception;

    /**
     * 根据手机号和活动号得到用户抢中记录，用以在界面中显示”立即抢兑“还是”重新下单“。
     * @param mobileNumber
     * @param activityId
     * @return
     * @throws Exception
     */
    public IActivityUserLogValue[] getUserLogInfo(String mobileNumber, String activityId) throws Exception;
}
