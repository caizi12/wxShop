package ngves.asiainfo.core.rushbuy.service.interfaces;

import ngves.asiainfo.core.rushbuy.dao.interfaces.IActivityLimitGroupDAO;
import ngves.asiainfo.core.rushbuy.ivalues.IActivityLimitGroupValue;
import ngves.asiainfo.core.rushbuy.ivalues.IActivityLimitValue;
import ngves.asiainfo.core.rushbuy.ivalues.IQBOFinishedActivityLimitGroupValue;

import java.util.Map;

/* 限时抢兑活动分组管理 */
public interface IActivityLimitGroupSrv {
    public void setActivityLimitGroupDAO(IActivityLimitGroupDAO activityLimitGroupDAO);

    public IActivityLimitGroupValue findById(Long id) throws Exception;

    public long create(IActivityLimitGroupValue activityLimitGroupValue) throws Exception;

    public long update(IActivityLimitGroupValue activityLimitGroupValue) throws Exception;

    public boolean remove(long groupId) throws Exception;

    @SuppressWarnings("unchecked")
    public IActivityLimitGroupValue[] query(String condition, Map params, int startIndex, int endIndex) throws Exception;

    public IActivityLimitGroupValue[] findAllByTitle(String title, int startIndex, int endIndex) throws Exception;

    public int countByTitle(String title) throws Exception;

    public IQBOFinishedActivityLimitGroupValue[] findAllFinishedActivityLimitGroups() throws Exception;

   /**
     * 得到指定分组下的已结束的抢兑活动列表
     * @param groupId 分组id
     * @return 活动列表
     * @throws Exception 异常
     */
    public IActivityLimitValue[] findAllFinishedActivityInGroup(long groupId) throws Exception;
    
    /**
     * 获取所有限时抢兑的分组-用于下拉菜单的选择
     * @return
     * @throws Exception
     */
    public IActivityLimitGroupValue[] findAllActivityGroup() throws Exception;
}
