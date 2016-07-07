package ngves.asiainfo.core.award.dao.interfaces;
import ngves.asiainfo.core.award.ivalues.IAwardLevelInfoValue;
import ngves.asiainfo.core.award.ivalues.IQBOAwardLevelRLTWareValue;
import ngves.asiainfo.core.award.ivalues.IQBOWareQueryInfoValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoPortalValue;
/**
 * 活动管理第二步（中奖档次管理）
 * @author xj
 *
 */
public interface IAwardLevelInfoDAO {

	/**
	 * 根据活动ID查找所有档次的基本信息
	 * @param awardId
	 * @return
	 * @throws Exception
	 */
	public IAwardLevelInfoValue[] findByAwardId(Long awardId) throws Exception;

	/**
	 * 批量新增档次对象
	 * @param awardLevelInfoValues
	 * @return
	 * @throws Exception
	 */
    public long addAwardLevelInfos(IAwardLevelInfoValue[] awardLevelInfoValues) throws Exception;

    /**
     * 批量修改档次对象
     * @param awardLevelInfoValues
     * @return
     * @throws Exception
     */
    public long updateAwardLevelInfos(IAwardLevelInfoValue[] awardLevelInfoValues) throws Exception;

    /**
     * 根据活动id删除档次基本信息
     * @param awardId
     * @return
     * @throws Exception
     */
    public void deleteAwardLevelInfos(String  awardId) throws Exception;
    /**
     * 查询所有可选礼品信息
     * @param wareName
     * @param startIndex
     * @param endIndex
     * @return
     * @throws Exception
     */ 
    public IQBOWareQueryInfoValue[] findAllWareInfosByWareName(String awardId,String wareName,int startIndex, int endIndex) throws Exception;

	/**
	 * 查询所有可选礼品信息总记录数
	 * @param wareName
	 * @return
	 * @throws Exception
	 */
    public int countWareInfosByWareName(String awardId,String wareName) throws Exception;
    
    
    /**
	 * 根据活动ID查找所有档次的基本信息
	 * @param AwardLevelId
	 * @return
	 * @throws Exception
	 */
	public IQBOAwardLevelRLTWareValue[] findAllLevelInfosByAwardId(String awardId) throws Exception;
	
    /**
     *根据活动ID查询 状态为展示的档次
     * @param awardId
     * @return
     * @throws Exception
     */
    public IWareInfoPortalValue[] getShowLevelAwardById(String awardId) throws Exception;
    
    /**
     * 根据礼品ID获取单个礼品对应的最大库存量
     * @param wareId
     * @return
     * @throws Exception
     */
    public   long  getHouseWareCountByWareId(Long wareId)throws Exception;
    
    /**
	 * 根据礼品wareCode查找抽奖档次信息
	 * @param wareCode
	 * @return
	 * @throws Exception
	 */
	public IAwardLevelInfoValue queryWareName(String wareCode) throws Exception;
}
