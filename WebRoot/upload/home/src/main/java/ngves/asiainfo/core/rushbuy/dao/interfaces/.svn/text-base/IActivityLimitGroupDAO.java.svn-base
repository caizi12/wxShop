package ngves.asiainfo.core.rushbuy.dao.interfaces;

import ngves.asiainfo.core.rushbuy.ivalues.IActivityLimitGroupValue;
import ngves.asiainfo.core.rushbuy.ivalues.IActivityLimitValue;
import ngves.asiainfo.core.rushbuy.ivalues.IQBOFinishedActivityLimitGroupValue;

import java.util.Map;

public interface IActivityLimitGroupDAO {
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
     * 获取所有的分组
     * @return
     * @throws Exception
     */
    public IActivityLimitGroupValue[] findAllActivityGroup() throws Exception;
}
