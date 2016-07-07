package ngves.asiainfo.core.ware.service.interfaces;


import ngves.asiainfo.core.ware.dao.interfaces.IWarePCInfoDAO;
import ngves.asiainfo.core.ware.ivalues.IBusiWareInfoParentValue;
import ngves.asiainfo.core.ware.ivalues.IQBOAllWareInfoChildValue;
import ngves.asiainfo.core.ware.ivalues.IQBOWareChildInfoValue;
import ngves.asiainfo.core.ware.ivalues.IQBOWareParentInfoValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoParentValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoValue;
import ngves.asiainfo.core.ware.ivalues.IWarePCRltValue;

/**
 * 父子礼品中的服务信息
 *
 */
public interface IWarePCInfoSrv {

	public void setWarePCInfoDAO(IWarePCInfoDAO warePCInfoDAO)throws Exception;
	
	

	/**
	 * 根据条件查询所有拥有父子礼品关系的礼品信息数据（可分页）
	 * @param wareCode 		礼品编码
	 * @param wareName		礼品名称
	 * @param partnerId
	 * @param partnerCode	合作商编码
	 * @param wareBrand		品牌
	 * @param wareStatus	上下线状态
	 * @param firstKindId
	 * @param parentKindId
	 * @param kindId
	 * @param provinceCode	省份信息
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public IQBOWareParentInfoValue[] queryAllWareParentInfo(String wareCode, String wareName, String partnerId,
            String partnerCode, String wareBrand, String wareStatus, String firstKindId, String parentKindId,
            String kindId, String provinceCode,String wareKindInfoId, int startNum,int endNum) throws Exception;
	
	/**
	 * 根据条件，查询出符合条件的礼品信息的数量
	 * @param wareCode 		礼品编码
	 * @param wareName		礼品名称
	 * @param partnerId
	 * @param partnerCode	合作商编码
	 * @param wareBrand		品牌
	 * @param wareStatus	上下线状态
	 * @param firstKindId
	 * @param parentKindId
	 * @param kindId
	 * @param provinceCode	省份信息
	 * @return
	 * @throws Exception
	 */
	public int queryAllWareParentInfoCount(String wareCode, String wareName, String partnerId,
            String partnerCode, String wareBrand, String wareStatus, String firstKindId, String parentKindId,
            String kindId, String provinceCode,String wareKindInfoId)throws Exception;
	
	/**
	 * 
	 * @param wareId
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IQBOWareChildInfoValue[] getWareChildInfoValueById(String wareId, int startIndex, int endIndex) throws Exception;	
	public int getWareChildInfoValueCount(String wareId) throws Exception ;

	
	/**
	 * 添加礼品的父子关系
	 * @param paretWareId
	 * @param childWareId
	 * @throws Exception
	 */
	public void saveWarePCInfo(IWarePCRltValue[] rltValues) throws Exception;
	
	
	/**
	 * 根据子礼品的ID，获得与之关联的父礼品的基本信息(ware_info_parent)
	 * <p>注意：只能查到已经审核通过的数据，即ware_info_parent表中的数据</p>
	 * @param childId
	 * @return
	 * @throws Exception
	 */
	public IWareInfoParentValue getWareParentValueByChildId(long childId) throws Exception; 
	
	/**
	 * 根据子礼品的ID，获得与之关联父礼品的下属所有子礼品的基本信息(包含它自己)<br>
	 * <p>注意：只能查到已经审核通过的数据，即ware_info表中的数据</p>
	 * @param childId
	 * @return
	 * @throws Exception
	 */
	public IWareInfoValue [] getWareInfoValueByChildId(long childId) throws Exception;
	
	
	/**
	 * 根据子礼品的ID，获得父子礼品关联表中，该子礼品关联的所有数据
	 * @param childId  子礼品的ID
	 * @return
	 * @throws Exception 如果数据量不等于1条，那么抛出数据错误异常
	 */
	public IWarePCRltValue getWarePCRltValueByChildId(long childId) throws Exception;
	
	
	/**
	 * 根据父礼品的ID，获得父子礼品关联表中，该父礼品关联的所有数据
	 * @param parentId 父礼品的ID
	 * @return
	 * @throws Exception 
	 */
	public IWarePCRltValue [] getWarePCRltValueByParentId(long parentId)throws Exception;
	
	/**
	 * 保存父礼品信息,注意只是修改制定的礼品信息属性
	 * @param wareInfoParentValue
	 * @return
	 * @throws Exception
	 */
	public long saveWareInfoParentValue(IWareInfoParentValue wareInfoParentValue) throws Exception;
	
	
	/**
	 * 礼品上下线时，对礼品列表中的子礼品对应的父礼品进行上下线的操作
	 * <pre>
	 * 1、如果有子礼品申请上线操作，那么查询该子礼品对应的父礼品上下线状态，
	 * 		如果父礼品未上线，那么父礼品上线。
	 * 		如果父礼品已经上线，那么跳过本条记录。
	 * 2、如果有子礼品申请下线操作，那么查询该子礼品的兄弟姐妹礼品的状态，
	 * 		如果有兄弟节点的礼品是上线状态，不对父礼品进行任何操作。
	 * 		如果所有兄弟节点的礼品都是下线状态，那么父礼品下线。
	 * </pre>
	 * @param wareInfos 礼品基本信息(ware_info表)
	 * @param statusOperate  礼品上下线操作
	 * <li>0：上线操作</li>
	 * <li>1：下线操作</li>
	 * @throws Exception
	 * 
	 */
	public void upDownLineWareInfoParent(IWareInfoValue[] wareInfos,String statusOperate)throws Exception;

	/**
	 * 查询符合条件的父礼品流水信息
	 * @param pWareId
	 * @return
	 * @throws Exception
	 */
	public IBusiWareInfoParentValue[] getBusiWareInfoParentValue(String pWareId) throws Exception;
		
	/**
	 * 根据父礼品ID获取子礼品信息
	 * @param wareParentId
	 * @return
	 * @throws Exception
	 * 2012-8-14
	 */
	public IWareInfoValue[] getChildWareInfo(long wareParentId) throws Exception;
	
	/**
	 * 查询导出父子礼品（按省市县）
	 */
	public IQBOAllWareInfoChildValue[] queryAllWareInfoChild(String wareCode, String wareName, String partnerId,
            String partnerCode, String wareBrand, String wareStatus, String firstKindId, String parentKindId,
            String kindId, String provinceCode,String wareKindInfoId, int startNum,int endNum) throws Exception;
	
	/**
	 * 查询导出父子礼品（按省市县）数目
	 */
	public int queryAllWareInfoChildCount(String wareCode, String wareName, String partnerId,
            String partnerCode, String wareBrand, String wareStatus, String firstKindId, String parentKindId,
            String kindId, String provinceCode,String wareKindInfoId)throws Exception;
}
