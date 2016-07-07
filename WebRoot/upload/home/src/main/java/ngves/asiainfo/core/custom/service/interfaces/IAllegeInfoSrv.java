/**
 * 
 */
package ngves.asiainfo.core.custom.service.interfaces;

import ngves.asiainfo.core.custom.dao.interfaces.IAllegeAssignInfoDAO;
import ngves.asiainfo.core.custom.dao.interfaces.IAllegeInfoDAO;
import ngves.asiainfo.core.custom.ivalues.IAllegeInfoValue;
import ngves.asiainfo.core.custom.ivalues.IQBOPartnerAllegeInfoValue;

/**
 * @author admin
 * 
 */
public interface IAllegeInfoSrv {

	public void setAllegeInfoDAO(IAllegeInfoDAO allegeInfoDAO) throws Exception ;
	public void setAllegeAssignInfoDAO(IAllegeAssignInfoDAO allegeAssignInfoDAO)throws Exception;
	/**
	 * 咨询投诉查询【运营中心/省管理员/省客服使用】
	 * @param orderId  		订单号
	 * @param allegeKind  	客诉类型【咨询/投诉】
	 * @param allegeLevel 	投诉级别
	 * @param partnerId  	合作商ID
	 * @param provinceCode 	客服省份
	 * @param staffId  		登录的员工ID
	 * @param timeSelect 	时段选择
	 * @param startTime		开始时间
	 * @param endTime		结束时间
	 * @param allegeStatus	投诉单状态
	 * @param mobilePhone	手机号
	 * @param overTime		是否超时
	 * @param partnerType	合作商类型
	 * @param sendProvince	配送省份
	 * @param exchangeChannel	兑换渠道
	 * @param acceptOpId		受理人ID
	 * @param allegeSubKind		客诉原因
	 * @param userBrand			用户品牌
	 * @param userLevel			用户级别
	 * @param indictseq			投诉工单号
	 * @param indictStatus		一级客服状态
	 * @param comType 			合作商类型
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IAllegeInfoValue[] getNewQueryAllegeInfo(String orderId, String allegeKind, String allegeLevel,
			String partnerId, String provinceCode, String staffId, String timeSelect, String startTime, String endTime,
			String allegeStatus, String mobilePhone, String overTime, String partnerType,
			String sendProvince, String exchangeChannel, String acceptOpId, String allegeSubKind, String userBrand,
			String userLevel, String indictseq, String indictStatus,String comType, int startIndex, int endIndex) throws Exception;

	/**
	 * 查询全部咨询投诉信息
	 * @param value
	 * @return
	 * @throws Exception
	 */
	//public IAllegeInfoValue[] getNewQueryAllegeInfo(CustomExportConditionValue value) throws Exception;
	/**
	 * 咨询投诉查询，前台页面分页时方法
	 * @param orderId
	 * @param allegeKind
	 * @param allegeLevel
	 * @param partnerId
	 * @param provinceCode
	 * @param staffId
	 * @param timeSelect
	 * @param startTime
	 * @param endTime
	 * @param allegeStatus
	 * @param mobilePhone
	 * @param overTime
	 * @param partnerType
	 * @param sendProvince
	 * @param exchangeChannel
	 * @param acceptOpId
	 * @param allegeSubKind
	 * @param userBrand
	 * @param userLevel
	 * @param indictseq
	 * @param indictStatus
	 * @param comType
	 * @return
	 * @throws Exception
	 */
	public int countNewQueryAllegeInfo(String orderId, String allegeKind, String allegeLevel, String partnerId,
			String provinceCode, String staffId, String timeSelect, String startTime, String endTime,
			String allegeStatus, String mobilePhone, String overTime, String partnerType,
			String sendProvince, String exchangeChannel, String acceptOpId, String allegeSubKind, String userBrand,
			String userLevel, String indictseq, String indictStatus,String comType) throws Exception;

	
	/** 
	 * 咨询投诉查询
	 * @param value
	 * @return
	 * @throws Exception
	 */
	//public int countNewQueryAllegeInfo(CustomExportConditionValue custExpConValue) throws Exception;
	/**
	 * 咨询投诉查询【合作商使用】
	 * @param orderId
	 * @param allegeKind
	 * @param allegeLevel
	 * @param partnerId
	 * @param provinceCode
	 * @param staffId
	 * @param timeSelect
	 * @param startTime
	 * @param endTime
	 * @param allegeStatus
	 * @param mobilePhone
	 * @param overTime
	 * @param partnerType
	 * @param sendProvince
	 * @param exchangeChannel
	 * @param acceptOpId
	 * @param allegeParentKind
	 * @param indictSeq
	 * @param indictStatus
	 * @param comType
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IQBOPartnerAllegeInfoValue[] queryPartnerAllAllegeInfo(String orderId, String allegeKind,
			String allegeLevel, String partnerId, String provinceCode, String staffId, String timeSelect,
			String startTime, String endTime, String allegeStatus, String mobilePhone, String overTime,
			String partnerType, String sendProvince, String exchangeChannel, String acceptOpId,
			String allegeParentKind, String indictSeq, String indictStatus,String comType, int startIndex, int endIndex)
			throws Exception;

	/**
	 * 
	 * @param custExpConValue
	 * @return
	 * @throws Exception
	 */
	/**
	 * 咨询投诉查询，分页时使用
	 * @param orderId
	 * @param allegeKind
	 * @param allegeLevel
	 * @param partnerId
	 * @param provinceCode
	 * @param staffId
	 * @param timeSelect
	 * @param startTime
	 * @param endTime
	 * @param allegeStatus
	 * @param mobilePhone
	 * @param overTime
	 * @param partnerType
	 * @param sendProvince
	 * @param exchangeChannel
	 * @param acceptOpId
	 * @param allegeParentKind
	 * @param indictSeq
	 * @param indictStatus
	 * @param comType
	 * @return
	 * @throws Exception
	 */
	public int countPartnerAllAllegeInfo(String orderId, String allegeKind, String allegeLevel, String partnerId,
			String provinceCode, String staffId, String timeSelect, String startTime, String endTime,
			String allegeStatus, String mobilePhone, String overTime, String partnerType,
			String sendProvince, String exchangeChannel, String acceptOpId, String allegeParentKind, String indictSeq,
			String indictStatus,String comType) throws Exception;
	
	
}
