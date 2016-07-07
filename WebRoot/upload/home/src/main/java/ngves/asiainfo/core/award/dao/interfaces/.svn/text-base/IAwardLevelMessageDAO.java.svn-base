package ngves.asiainfo.core.award.dao.interfaces;
import ngves.asiainfo.core.award.ivalues.IAwardLevelMessageValue;

/**
 * 档次提示语管理
 * @author xj
 *
 */
public interface IAwardLevelMessageDAO {

	/**
	 * 根据活动ID查找所有档次的提示语信息
	 * @param awardId
	 * @return
	 * @throws Exception
	 */
	public IAwardLevelMessageValue[] findMessageByAwardId(String awardId) throws Exception;
	
	/**
	 * 查找活动对应档次提示语信息
	 * @param awardId（awardId=1，wareCode="" 查询出来默认提示语信息）
	 * @param status(1:启用，0停用)
	 * @return
	 */
	public IAwardLevelMessageValue[] findMessageByAwardId(Long awardId,String  wareCode,String status) throws Exception;

	/**
	 * 批量新增档次对象
	 * @param awardLevelInfoValues
	 * @return
	 * @throws Exception
	 */
    public long addAwardLevelMessageInfos(IAwardLevelMessageValue[] values) throws Exception;
    /**
     * 根据活动id删除提示语信息
     * @param awardId
     * @return
     * @throws Exception
     */
    public void deleteAwardLevelMessageInfos(String  awardId) throws Exception;
    
   /**
    * 根据id查找提示语信息
    * @param messageId
    * @return
    * @throws Exception
    */
    public IAwardLevelMessageValue getMessage(String  messageId) throws Exception;
    
    
   /**
    *批量查找提示语信息
    * @param messageIds
    * @return
    * @throws Exception
    */
     public IAwardLevelMessageValue[] getMessagesByIds(String messageIds) throws Exception;
     
   
}
