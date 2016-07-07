package ngves.asiainfo.core.tuan.dao.interfaces;

import ngves.asiainfo.core.common.ivalues.IUpdateNotifyInfoValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOComingSoonValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOReviewValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOTodayCommendValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOTuanOrderValue;
import ngves.asiainfo.core.tuan.ivalues.ITuanInfoValue;
import ngves.asiainfo.core.tuan.ivalues.ITuanProvinceValue;

public interface ITuanInfoDAO {

	/**
	 * By sunsj
	 * 
	 * @param tuanName
	 * @return 团购活动信息列表
	 */
	public ITuanInfoValue[] queryTuanInfo(String tuanName, int startIndex, int endIndex);

	/**
	 * By sunsj
	 * 
	 * @param tuanName
	 * @return 团购活动信息总数
	 */
	public int queryTuanInfoCount(String tuanName);

	/**
	 * @author liuyq
	 * @date 2011-07-14 保存团购信息，新增和修改都通过此函数进行
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public long saveTuanInfo(ITuanInfoValue value) throws Exception;

	/**
	 * @author liuyq
	 * @date 2011-07-14 根据团购的Id 获得团购对应生效省份的信息
	 * @param tuanId
	 * @return
	 * @throws Exception
	 */
	public ITuanProvinceValue[] getTuanProvinceValueById(String tuanId) throws Exception;

	/**
	 * By sunsj
	 * 
	 * @param tuanId
	 * @return 根据id返回团购信息
	 */
	public ITuanInfoValue queryTuanById(String tuanId);
	
	/**
	 * 根据团购Id 来获得当前团购礼品对应的库存信息
	 * @param tuanId
	 * @return
	 * @throws Exception
	 * @author luohuan
	 * @date 2012-5-8
	 */
	public long queryTuanHouseWareCount(String tuanId);

	/**
	 * @author liuyq
	 * @date 2011-07-15
	 * @purpose 根据传入的指定名称，判断数据库中是否存在相同名称的记录
	 * @param tuanName
	 * @return 存在相同名称的记录 true 不存在相同名称的记录 false
	 * @throws Exception
	 */
	public boolean isExistSameName(String tuanName) throws Exception;

	/**
	 * By sunsj
	 * 
	 * @return 返回今日推荐团购信息
	 */
	public IQBOTodayCommendValue[] getTodayCommend(int startNum, int endNum) throws Exception;

	/**
	 * By sunsj
	 * 
	 * @return 返回敬请期待
	 */
	public IQBOComingSoonValue[] getComingSoon(int startNum, int endNum) throws Exception;

	/**
	 * By sunsj
	 * 
	 * @return 返回精彩回顾
	 */
	public IQBOReviewValue[] getReview(int startNum, int endNum) throws Exception;

	/**
	 * 更新状态信息
	 * 
	 * @param tuanId
	 * @throws Exception
	 */
	public void updateTuanInfoToEnd(String tuanId) throws Exception;

	/**
	 * 得到所有团购活动的ID
	 * 
	 * @author:shenfl@asiainfo-linkage.com
	 * @return
	 * @throws Exception
	 */
	public ITuanInfoValue[] getStartTuanIds() throws Exception;


    /**
     * 取得所有的团购-前台商城公告显示
     * @return
     * @throws Exception
     * @author:shenfl@asiainfo-linkage.com
     */
    public ITuanInfoValue[] getITuanInfoValues() throws Exception;
    
    public IQBOTuanOrderValue[] queryTuanUserLog(String tuanId, int startIndex, 
			int endIndex) throws Exception ;
    
    public int countTuanUserLog(String tuanId) throws Exception ;
    public long  getTuanHouseWareCount(String tuanId,String wareId) throws Exception;
    
    /**
	 * 团购绑定礼品后发布，将礼品id更新到update_notify_info表中标识为待同步
	 * @param notifyInfos
	 * @throws Exception
	 */
    public void saveNotifyInfo(IUpdateNotifyInfoValue[] notifyInfos) throws Exception;
    
    /**
     * 获取团购轮转信息
     * @param topFlag 是否置顶
     * @param startNum
     * @param endNum
     * @return
     * @throws Exception
     */
    public IQBOTodayCommendValue[] getTodayTuan(String topFlag, int startNum, int endNum) throws Exception;

    /**
     * 取得团购今日推荐的数量。
     * @param startNum
     * @param endNum
     * @return 数量
     * @throws Exception
     */
    public int getTodayCommendCount(int startNum, int endNum) throws Exception;
    
    /**
     * 取得团购下期预告的数量。
     * @param startNum
     * @param endNum
     * @return 数量
     * @throws Exception
     */
    public int getComingSoonCount(int startNum, int endNum) throws Exception;
    
    /**
     * 取得团购往期回顾的数量。
     * @param startNum
     * @param endNum
     * @return 数量
     * @throws Exception
     */
    public int getReviewCount(int startNum, int endNum) throws Exception;
    
    /**
     * 根据分组的名称查询分组总数
     * @param groupCode
     * @param startNum
     * @param endNum
     * @return
     * @throws Exception
     */
    public int getTuanInfoCount(String groupCode) throws Exception;
    
    /*********************************************************************************************/
    /**
	 * 
	 * 
	 * @return 返回今日推荐团购信息
	 */
	public IQBOTodayCommendValue[] getTodayCommend(int startNum, int endNum,String provinceCode,String channel, String userStarLevel) throws Exception;
	/**
	 * 
	 * @return 返回敬请期待
	 */
	public IQBOComingSoonValue[] getComingSoon(int startNum, int endNum,String provinceCode,String channel, String userStarLevel) throws Exception;
	/**
	 *  
	 * 
	 * @return 返回精彩回顾
	 */
	public IQBOReviewValue[] getReview(int startNum, int endNum,String provinceCode) throws Exception;

    
}
