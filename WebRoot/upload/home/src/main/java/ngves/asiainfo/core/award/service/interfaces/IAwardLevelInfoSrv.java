package ngves.asiainfo.core.award.service.interfaces;

import ngves.asiainfo.core.award.dao.interfaces.IAwardInfoDAO;
import ngves.asiainfo.core.award.dao.interfaces.IAwardLevelInfoDAO;
import ngves.asiainfo.core.award.dao.interfaces.IAwardLevelMessageDAO;
import ngves.asiainfo.core.award.ivalues.IAwardLevelInfoValue;
import ngves.asiainfo.core.award.ivalues.IAwardLevelMessageValue;
import ngves.asiainfo.core.award.ivalues.IQBOAwardLevelRLTWareValue;
import ngves.asiainfo.core.award.ivalues.IQBOWareQueryInfoValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoPortalValue;
/**
 * 中奖档次管理
 * @author xj
 *
 */
public interface IAwardLevelInfoSrv {
   
	public void setAwardInfoDAO(IAwardInfoDAO awardInfoDAO) throws Exception;
	
	public void setAwardLevelInfoDAO(IAwardLevelInfoDAO awardLevelInfoDAO);
	
	public void setAwardLevelMessageDAO(IAwardLevelMessageDAO awardLevelMessageDAO);
	

	/**
	 * 根据活动ID查找所有档次的基本信息
	 * @param AwardLevelId
	 * @return
	 * @throws Exception
	 */
	public IAwardLevelInfoValue[] findAllByAwardId(String awardId) throws Exception;

    
    /**
     * 批量修改档次对象
     * @param awardLevelInfoValues
     * @return
     * @throws Exception
     */
    public long updateAwardLevelInfos(IAwardLevelInfoValue[] awardLevelInfoValues) throws Exception;

    /**
     * 根据活动id删除档次对象
     * @param awardId
     * @throws Exception
     */
    public void deleteAwardLevelInfos(String awardId) throws Exception;
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
    /***
     * 根据活动查找所有档次的基本信息（关联礼品表作查询）
     * @param awardId
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
    public   long  getHouseWareCountByWareId(String wareId)throws Exception;

    /**
     * 查找提示语信息(查询默认提示语信息，awardId=1l，wareCode传空)
     * @param awardId
     * @param wareCode
     * @param  status(1:启用,0:停用)
     * @return
     * @throws Exception
     */
    public   IAwardLevelMessageValue[]  getDefaultMessage(Long awardId,String wareCode,String status)throws Exception;



	/**
	 * 批量新增档次对象
	 * @param 
	 * @return
	 * @throws Exception
	 * param档次基本信息
	 */
    public long addAwardLevelInfos(String[] param, long staffId, String comType, long orgId)throws Exception;


    
    /**
	 * 记录导出excel日志
	 * @param conditionExcel 导出条件
	 * @param fileName 文件名称
	 * @throws Exception
	 */


    public void recordExcel(String conditionExcel, long staffId, String comType, long orgId) throws Exception;
}
