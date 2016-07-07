package ngves.asiainfo.core.tuan.service.interfaces;

import java.util.List;

import ngves.asiainfo.core.tuan.dao.interfaces.ITuanInfoDAO;
import ngves.asiainfo.core.tuan.dao.interfaces.ITuanProvinceDAO;
import ngves.asiainfo.core.tuan.ivalues.IQBOComingSoonValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOReviewValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOTodayCommendValue;
import ngves.asiainfo.core.tuan.ivalues.ITuanInfoValue;
import ngves.asiainfo.core.tuan.ivalues.ITuanProvinceValue;

public interface ITuanInfoSrv {

	public void setTuanInfoDAO(ITuanInfoDAO tuanInfoDAO) throws Exception;

	public void setTuanProvinceDAO(ITuanProvinceDAO tuanProvinceDAO) throws Exception;
	
	/**
	 * By sunsj
	 * 
	 * @param tuanName
	 * @return 团购活动信息列表
	 * @throws Exception 
	 */
	public ITuanInfoValue[] queryTuanInfo(String tuanName, int startIndex, int endIndex) throws Exception;

	/**
	 * By sunsj
	 * 
	 * @param tuanName
	 * @return 团购活动信息总数
	 */
	public int queryTuanInfoCount(String tuanName);

	/**
	 * 保存团购信息
	 * 
	 * @param value
	 *            团购信息
	 * @param province
	 *            省份信息
	 * @param provinceCheck
	 *            省份选择信息
	 * @param staffId
	 * 			  操作人员Id
	 * @return
	 * @throws Exception
	 * @author liuyq
	 * @date 2011-07-14
	 */
	public long saveTuanInfo(ITuanInfoValue value, String province, String provinceCheck,long staffId) throws Exception;

	/**
	 * 根据团购Id 获得团购信息
	 * 
	 * @param tuanId
	 * @return
	 * @throws Exception
	 * @author liuyq
	 * @date 2011-07-14
	 */
	public ITuanInfoValue getTuanInfoById(String tuanId) throws Exception;

	/**
	 * 团购发布-库存验证
	 * @param tuanId
	 * @param wareId
	 * @return
	 * @throws Exception
	 */
	public long  getTuanHouseWareCount(String tuanId,String wareId) throws Exception ;

	/**
	 * 根据团购Id 获得团购对应的省份信息
	 * 
	 * @param tuanId
	 * @return
	 * @throws Exception
	 * @author liuyq
	 * @date 2011-07-14
	 */
	public ITuanProvinceValue[] getTuanProvinceInfoByTuanId(String tuanId) throws Exception;

	/**
	 * By sunsj
	 * 
	 * @param tuanId
	 * @param visible
	 * @throws Exception
	 *             设置在商城是否显示
	 */
	public void setVisible(String tuanId, String visible) throws Exception;
	
	//设置在商城是否显示时增加日志记录
	public void setVisible(String tuanId, String visible,long staffId, String comType,long orgId) throws Exception;

	/**
	 * By sunsj
	 * 
	 * @param tuanId
	 *            停止活动
	 * @throws Exception
	 */
	public String stopTuan(String tuanId) throws Exception;
	
	public String stopTuan(String tuanId, long staffId, String comType, long orgId) throws Exception;

	/**
	 * 根据传入的团购名称，判断是否有相同名称的团购活动存在
	 * 
	 * @purpose
	 * @param tuanName
	 *            团购活动名称
	 * @return 存在相同名称的团购活动 1 TuanConstant.TUAN_NAME_CONFILICT_YES 不存在相同名称的团购活动 0
	 *         TuanConstant.TUAN_NAME_CONFILICT_NO
	 * @throws Exception
	 * @author liuyq
	 * @date 2011-07-15
	 */
	public String isNameConflict(String tuanName) throws Exception;

	/**
	 * By sunsj 获取今日推荐团购
	 * 
	 * @throws Exception
	 */
	public IQBOTodayCommendValue[] getTodayCommend(int startNum, int endNum) throws Exception;

	/**
	 * By sunsj 获取敬请期待
	 * 
	 * @throws Exception
	 */
	public IQBOComingSoonValue[] getComingSoon(int startNum, int endNum) throws Exception;

	/**
	 * By sunsj 获取精彩回顾
	 * 
	 * @throws Exception
	 */
	public IQBOReviewValue[] getReview(int startNum, int endNum) throws Exception;
	
	/**
	 * 获取团购‘今日推荐’轮转数据
	 * @param topList 置顶集合
	 * @param cycleList 轮转集合
	 * @param showType 展示类型 00团购首页 01团购详情页 02团购汇总页
	 * @return
	 * @throws Exception
	 */
	public IQBOTodayCommendValue[] getToUnionList(List<IQBOTodayCommendValue> topList, List<IQBOTodayCommendValue> cycleList,String showType) throws Exception;
	
	/**
	 * 获取团购‘下期预告’轮转数据
	 * @param topList 置顶集合
	 * @param cycleList 轮转集合
	 * @param showType 展示类型 00团购首页 01团购详情页 02团购汇总页
	 * @return
	 * @throws Exception
	 */
	public IQBOComingSoonValue[] getCsUnionList(List<IQBOComingSoonValue> topList, List<IQBOComingSoonValue> cycleList,String showType) throws Exception;
	
	/**
	 * 获取团购‘精彩回顾’轮转数据
	 * @param topList 置顶集合
	 * @param cycleList 轮转集合
	 * @param showType 展示类型 00团购首页 01团购详情页 02团购汇总页
	 * @return
	 * @throws Exception
	 */
	public IQBOReviewValue[] getOldUnionList(List<IQBOReviewValue> topList, List<IQBOReviewValue> cycleList,String showType) throws Exception;
	
	

	/**
	 * @author liuyq
	 * @purpose 根据团购Id，获得团购活动限制省份的字符串对象，返回结果利用','分隔
	 * @param tuanId
	 * @return 例如：hl,bj,sh,sx,jl
	 * @throws Exception
	 */
	public String getTuanProvinceInfoStrById(String tuanId) throws Exception;

	/**
	 * 团购结束更新status=2
	 * 
	 * @param tuanId
	 * @throws Exception
	 */
	public void updateTuanInfoToEnd(String tuanId) throws Exception;

	/**
	 * 修改团购活动
	 * 
	 * @param value
	 * @param province
	 * @param provinceCheck
	 * @param staffId 登录用户的Id 
	 * @return
	 * @throws Exception
	 */
	public long modifyTuanInfo(ITuanInfoValue value, String province, String provinceCheck,long staffId) throws Exception;

	/**
	 * 修改团购信息时，记录日志，需要传递用户的登录信息
	 * @param value
	 * @param province
	 * @param provinceCheck
	 * @param staffId
	 * @param StaffId
	 * @param ComType
	 * @param OrgId
	 * @return
	 * @throws Exception
	 */
	public long modifyTuanInfo(ITuanInfoValue value, String province, String provinceCheck,long staffId,long StaffId,String ComType,long OrgId) throws Exception;
	/**
	 * 得到所有团购活动的ID
	 * 
	 * @author:shenfl@asiainfo-linkage.com
	 * @return
	 * @throws Exception
	 */
	public ITuanInfoValue[] getStartTuanIds() throws Exception;


    public ITuanInfoValue[] getITuanInfoValues() throws Exception;
    
    /**
     * 通过分组名称查询团购信息
     * @param groupCode
     * @param startNum
     * @param endNum
     * @return 团购信息数组
     * @throws Exception
     */
    public ITuanInfoValue[] getTuanGroupInfo(String groupCode, int startNum, int endNum) throws Exception;
    
    /**
     * 通过分组信息查询团购数量
     * @param groupCode
     * @return 数量
     * @throws Exception
     */
    public int getTuanGroupInfoCount(String groupCode) throws Exception;
    
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
     * 修改团购信息
     * @param value
     * @throws Exception
     */
    public void modifyTuanInfo(ITuanInfoValue value) throws Exception;
    
    
    /******************************************************************/
    /**
	 *获取（绑定本省礼品和全网礼品的活动）今日推荐团购
	 * 
	 * @throws Exception
	 */
	public IQBOTodayCommendValue[] getTodayCommend(int startNum, int endNum,String provinceCOde,String channel, String userStarLevel) throws Exception;
	/**
	 *获取下期预告的团购活动
	 * 
	 * @throws Exception
	 */
	public IQBOComingSoonValue[] getComingSoon(int startNum, int endNum,String provinceCode,String channel, String userStarLevel) throws Exception;
	/**
	 * 获取精彩回顾
	 * 
	 * @throws Exception
	 */
	public IQBOReviewValue[] getReview(int startNum, int endNum,String provinceCode) throws Exception;
}
