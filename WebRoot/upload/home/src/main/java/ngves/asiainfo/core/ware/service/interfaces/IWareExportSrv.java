/**
 * 
 */
package ngves.asiainfo.core.ware.service.interfaces;

import ngves.asiainfo.core.ware.ivalues.IQBOAllWareDescValue;
import ngves.asiainfo.core.ware.dao.interfaces.WareExportDAO;

/**
 * @author admin
 * 
 */
public interface IWareExportSrv {

	public void setWareExportDAO(WareExportDAO wareExportDAO) throws Exception ;
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
	public IQBOAllWareDescValue[] getNewQueryWareInfo( String lstBrand,
			String lstProvinceCode, String lstSupplier,
			String lstWareFirstKind, String lstWareKind, String lstWareParentKind
					, String lstWareStatus, String staffId,
					String warecode, String warename, String comType,String queryStaffId,String wareKindInfoId,int startIndex, int endIndex) throws Exception;

	/**
	 * 查询全部咨询投诉信息
	 * @param value
	 * @return
	 * @throws Exception
	 */
	//public IAllegeInfoValue[] getNewQueryAllegeInfo(CustomExportConditionValue value) throws Exception;
	/**
	 * 礼品业务属性查询，前台页面分页时方法
	 * @param comType
	 * @param lstBrand
	 * @param lstProvinceCode
	 * @param lstSupplier
	 * @param lstWareFirstKind
	 * @param lstWareKind
	 * @param lstWareParentKind
	 * @param lstWareStatus
	 * @param queryStaffId
	 * @param warecode
	 * @param warename
	 	 */
	
	public int countNewQueryWareInfo( String lstBrand,
			String lstProvinceCode, String lstSupplier,
			String lstWareFirstKind, String lstWareKind, String lstWareParentKind
					, String lstWareStatus, String staffId,
					String warecode, String warename,String comType,String queryStaffId,String wareKindInfoId ) throws Exception;

	
	
}
