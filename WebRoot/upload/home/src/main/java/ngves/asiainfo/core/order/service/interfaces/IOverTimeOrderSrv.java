package ngves.asiainfo.core.order.service.interfaces;

import ngves.asiainfo.core.common.ivalues.IExcelTaskValue;
import ngves.asiainfo.core.order.dao.interfaces.IOverTimeOrderDAO;
import ngves.asiainfo.core.order.ivalues.IOverTimeOrderExaminListValue;

public interface IOverTimeOrderSrv {
	
	public void setOverTimeOrderDAO(IOverTimeOrderDAO OverTimeOrderDAO)
	throws Exception;

	/**
	 * 获取超时订单审核列表
	 * 
	 * @param orderType
	 * @param businessTypeId
	 * @param partnerId
	 * @param userProvinceCode
	 * @param provinceCode
	 * @param startDay
	 * @param endDay
	 * @param checkStatus
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public IOverTimeOrderExaminListValue[] getOverTimeOrderExaminList(
			String orderType, String businessTypeId, String partnerId,
			String userProvinceCode, String provinceCode, String startDay,
			String endDay, String checkStatus,String warehouseType,String wareHouseId,
			int startIndex, int endIndex) throws Exception;

	/**
	 * 获取超时订单审核列表导出
	 * 
	 * @param orderType
	 * @param businessTypeId
	 * @param partnerId
	 * @param userProvinceCode
	 * @param provinceCode
	 * @param startDay
	 * @param endDay
	 * @param checkStatus
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public IOverTimeOrderExaminListValue[] getOverTimeOrderExaminListExport(
			String orderType, String businessTypeId, String partnerId,
			String userProvinceCode, String provinceCode, String startDay,
			String endDay, String checkStatus,String warehouseType,String wareHouseId,
			int startIndex, int endIndex) throws Exception;

	/**
	 * 获取超时订单审核列表行数
	 * 
	 * @param orderType
	 * @param businessTypeId
	 * @param partnerId
	 * @param userProvinceCode
	 * @param provinceCode
	 * @param startDay
	 * @param endDay
	 * @param checkStatus
	 * @return
	 * @throws Exception
	 */
	public int getOverTimeOrderExaminCount(String orderType,
			String businessTypeId, String partnerId, String userProvinceCode,
			String provinceCode, String startDay, String endDay,
			String checkStatus,String warehouseType,String wareHouseId) throws Exception;
	/**
	 * 获取超时订单审核列表行数导出
	 * 
	 * @param orderType
	 * @param businessTypeId
	 * @param partnerId
	 * @param userProvinceCode
	 * @param provinceCode
	 * @param startDay
	 * @param endDay
	 * @param checkStatus
	 * @return
	 * @throws Exception
	 */
	public int getOverTimeOrderExaminCountExport(String orderType,
			String businessTypeId, String partnerId, String userProvinceCode,
			String provinceCode, String startDay, String endDay,
			String checkStatus,String warehouseTypeValue,String lstWareHouseIdValue) throws Exception;
	
	


	/**
	 * 运营中心超时订单审核或客服基地发短信
	 * @param operType
	 * @param sUserID
	 * @param sUserName
	 * @param sCheckTime
	 * @param OrderID
	 * @param SubEorderID
	 * @param mobile
	 * @param CheckStatus
	 * @param IsSendMessage
	 * @param Comments
	 * @throws Exception
	 */
	public String overTimeOrderExamine(String operType, String sUserID,
			long orgId, String comType, String sCheckTime, String[] orderID,
			String[] subEorderID, String[] mobile, String[] checkStatus,
			String isSendMessage, String comments) throws Exception;


	

	/**
	 * 通过任务id和查询时段查询异步导出任务
	 * 
	 * @param staffId
	 * @param userType
	 * @param taskId
	 * @param startTime
	 * @param endTime
	 * @param startNum
	 * @param endNum
	 * @return
	 * @throws Exception
	 */
	public IExcelTaskValue[] queryOrderExcelTaskValues(String staffId,
			String taskType, String taskId, String startTime, String endTime,
			int startIndex, int endIndex) throws Exception;

	/**
	 * 通过任务id和查询时段查询异步导出任务记录数
	 * 
	 * @param staffId
	 * @param userType
	 * @param taskId
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	public int countOrderExcelTaskValues(String staffId, String taskType,
			String taskId, String startTime, String endTime) throws Exception;
	

}
