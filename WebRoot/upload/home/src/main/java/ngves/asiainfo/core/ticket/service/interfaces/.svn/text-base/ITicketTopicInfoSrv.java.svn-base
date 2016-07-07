package ngves.asiainfo.core.ticket.service.interfaces;


import ngves.asiainfo.core.ticket.dao.interfaces.ITicketTopicInfoDAO;
import ngves.asiainfo.core.ticket.ivalues.IQBOTicketTopicInfoValue;
import ngves.asiainfo.core.ticket.ivalues.ITicketTopicInfoValue;

/**
 * 票务类专题业务接口
 * @author WL
 *
 */
public interface ITicketTopicInfoSrv {
	public void setTicketTopicInfoDAO(ITicketTopicInfoDAO ticketTopicInfoDAO);
	/**
	 * 查询所有票务专题页信息
	 * @param startIndex
	 * @param endIndex
	 * @return 票务专题信息
	 * @throws Exception
	 * @author wenglin
	 */
	 public IQBOTicketTopicInfoValue[] queryTicketTopicInfo(int startIndex, int endIndex) throws Exception;
	 public int queryTicketTopicInfoCount() throws Exception;
	 /**
	  * 保存、删除、修改票务专题页信息
	  * @param ticketValue 保存票务专题对象
	  * @param operate 操作标识：根据页面传递的值用以判断(add/update/delete)
	  * @throws Exception
	  * @author wenglin
	  */
	 public void saveTicketInfo(ITicketTopicInfoValue ticketValue,String operate) throws Exception;
 	/**
     * 根据一组、或一个分类标识，获取分类名称,并转换为一行数据(多行结果转换为一行记录,并用逗号隔开)<br/>
     * 例如:wareKindIds 传入为：100000000700065,100000000720065<br/>
     * 	              返回结果：影院通票类（测试）, 在线选座类<br/>
     * 使用wm_concat()函数<br/>
     * @param wareKinds 分类标识
     * @return 分类名称
     * @throws Exception
     * @author wenglin
     */
	 public String getWareKindNameByWareKindId(String wareKindIds)throws Exception;
	/**
	 * 保存票务专题到Memcache缓存中
	 * @param value 保存票务专题对象
	 * @author wenglin
	 */
	public  void setTicketTopicInfoToCache(ITicketTopicInfoValue value) throws Exception;
	/**
	 * 从Memcache缓存中获取票务专题对象
	 * @param value 保存票务专题对象
	 * @author wenglin
	 */
	public  ITicketTopicInfoValue getTicketTopicInfo() throws Exception;
	 
	
	/**根据专题id获取专题信息
	 * @param topicId
	 * @return
	 * @throws Exception
	 */
	public ITicketTopicInfoValue queryTicketTopicInfoByTopicId(String topicId)throws Exception;
	 
}
