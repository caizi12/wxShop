/**
 * 
 */
package ngves.asiainfo.core.common.service.interfaces;

import java.sql.Timestamp;

import ngves.asiainfo.core.common.dao.interfaces.IBaseInfoSynDAO;
import ngves.asiainfo.core.common.ivalues.IBaseInfoSynValue;
import ngves.asiainfo.core.common.model.PointGrantQueryBean;
import ngves.asiainfo.core.common.model.PointQueryInfoBean;
import ngves.asiainfo.core.common.model.PointUseQueryBean;

/**
 * @author asiainfo
 * 
 */
public interface IBaseInfoSynSrv {

	public void setBaseInfoSynDAO(IBaseInfoSynDAO baseInfoSynDAO) throws Exception;

	/**
	 * 增加一条新的
	 * @param infoType
	 * @param infoId
	 * @throws Exception
	 */
	public void addSynInfo(String infoType, long infoId, String infoState) throws Exception;

	/**
	 * 用于新增物流配送关系的同步记录。 将配送关系生效时间存放在 “SYN_END_TIME” 字段。
	 * 
	 * @param infoType
	 * @param infoId
	 * @param infoState
	 * @param validDate
	 * @throws Exception
	 */
	public void addSynInfo(String infoType, long infoId, String infoState, Timestamp validDate) throws Exception;

	/**
	 * 根据数据项的类型和数据的类型，从base_info_syn 中查询数据
	 * 
	 * @param infoType
	 * @param infoState
	 * @return 如果没有数据 返回null 如果有数据，返回对象数组
	 * @throws Exception
	 */
	public IBaseInfoSynValue[] getBaseInfoSynValueByType(String infoType, String infoState) throws Exception;
	
	/**
	 * 用户明细积分查询
	 * @param orgID
	 * @param orgName
	 * @param mobileNum
	 * @return
	 * @throws Exception
	 */
	public PointQueryInfoBean getPointQueryDesc(String orgID,String orgName,String mobileNum) throws Exception;
	/**
	 * 用户发放积分查询
	 * @param orgID
	 * @param orgName
	 * @param mobileNum
	 * @return
	 */
	public PointGrantQueryBean getPointGrantQueryInfo(String orgID,String orgName,String mobileNum,String searchDateType)
		throws Exception;
	
	/**
	 * 用户使用积分查询
	 * @param orgID
	 * @param orgName
	 * @param mobileNum
	 * @param searchDateType
	 * @return
	 * @throws Exception
	 */
	public PointUseQueryBean getPointUseQueryInfo(String orgID,String orgName,String mobileNum,String searchDateType)
		throws Exception;
	
}
