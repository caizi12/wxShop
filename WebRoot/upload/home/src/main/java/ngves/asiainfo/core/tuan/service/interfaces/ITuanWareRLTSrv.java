package ngves.asiainfo.core.tuan.service.interfaces;

import java.util.Map;

import ngves.asiainfo.core.tuan.dao.interfaces.ITuanInfoDAO;
import ngves.asiainfo.core.tuan.dao.interfaces.ITuanWareRLTDAO;
import ngves.asiainfo.core.tuan.ivalues.IQBOTuanWareInfoValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOTuanWareIntegralValue;
import ngves.asiainfo.core.tuan.ivalues.ITuanWareRLTValue;

/**
 * 
 * <p>
 * 团购关联礼品表信息展示 业务逻辑
 * </p>
 * 
 * @author shenfl@asiainfo-linkage.com
 */
public interface ITuanWareRLTSrv {

	public void setTuanWareRLTDAO(ITuanWareRLTDAO tuanWareRLTDAO) throws Exception;

	public void setTuanInfoDAO(ITuanInfoDAO tuanInfoDAO) throws Exception;
	
	public void tuanSmsTemp(String tuanId,String wareId) throws Exception;

	/**
	 * 获取 团购关联礼品表信息
	 * 
	 * @param tuanId
	 * @return
	 * @throws Exception
	 */
	public ITuanWareRLTValue getTuanWareRLTById(String tuanId) throws Exception;
	
	/**
	 * 验证此礼品是否已保存到TUAN_WARE_RLT
	 */
	public void isTuanWareRlt(String tuanId,String wareId) throws Exception;
	
	/**
	 * @author cuihj
	 * @date 2013-08-20
	 * @purpose 根据礼品ID获取礼品配置的仓库类型
	 * @param wareId 礼品ID
	 * @return
	 * @throws Exception
	 */
	public IQBOTuanWareInfoValue[] queryTuanWareStorageTypeByWareId(String wareId) throws Exception;

	/**
	 * @author liuyq
	 * @date 2011-07-18
	 * @purpose 查询团购礼品信息
	 * @param wareName
	 *            礼品名称
	 * @param provicne
	 *            礼品省份
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IQBOTuanWareInfoValue[] queryTuanWare(String provicne,String wareName, int startIndex, int endIndex) throws Exception;
    
	/**
	 * @author liuyq
	 * @date 2011-07-18
	 * @purpose 查询团购礼品信息
	 * @param wareName
	 *            礼品名称
	 * @param provicne
	 *            礼品省份
	 * @return
	 * @throws Exception
	 */
	public int countTuanWare(String provicne,String wareName) throws Exception;

	/**
	 * @author liuyq
	 * @date 2011-07-18
	 * @purpose 根据团购ID查询团购对应的礼品信息
	 * @param tuanId
	 *            团购ID
	 * @return 返回的应该是单一的对象 不应该是数组，这里先这样 为了防止以后一次团购绑定两个礼品（礼品打包）
	 * @throws Exception
	 */
	public IQBOTuanWareIntegralValue[] queryTuanBindRelationInfo(String tuanId, String starLevel, String channel,String status) throws Exception;

	/**
	 * @author liuyq
	 * @date 2011-07-19
	 * @purpose 保存团购礼品关系数据(团购绑定礼品)
	 * @param value
	 * @param type
	 *            ["delete","add","modify"] delete: 标记着要先根据团购ID进行团购和礼品关系删除操作
	 * @param actionType
	 *            ["publish","view"] view: 前台选择的是预览操作
	 *            publish:前台选择的是发布操作(一定要绑定礼品)
	 *            
	 * @param staffId 操作员Id
	 * @throws Exception
	 */
	public long saveTuanBindRelationInfo(ITuanWareRLTValue value, String type, String actionType,long staffId) throws Exception;
    
    //同上，传递mgt中userinfo信息供core中调用
	public long saveTuanBindRelationInfo(Map<String,Object> in) throws Exception;
}
