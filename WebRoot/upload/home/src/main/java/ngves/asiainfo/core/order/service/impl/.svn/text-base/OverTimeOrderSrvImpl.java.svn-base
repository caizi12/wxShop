package ngves.asiainfo.core.order.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.common.ivalues.IExcelTaskValue;
import ngves.asiainfo.core.common.util.AiHpInterUtil;
import ngves.asiainfo.core.common.util.BusiInfoUtil;
import ngves.asiainfo.core.order.OrderConstant;
import ngves.asiainfo.core.order.bo.OverTimeOrderExaminListBean;
import ngves.asiainfo.core.order.dao.interfaces.IOverTimeOrderDAO;
import ngves.asiainfo.core.order.ivalues.IOverTimeOrderExaminListValue;
import ngves.asiainfo.core.order.service.interfaces.IOverTimeOrderSrv;
import ngves.asiainfo.core.ware.util.IntegralUtil;
import ngves.asiainfo.interfaces.InterConstant;
import ngves.asiainfo.interfaces.hp.ProvinceUtil;
import ngves.asiainfo.interfaces.hp.bean.overTimeOrderAuditResult.in.OverTimeOrderAuditResultInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.overTimeOrderAuditResult.in.OverTimeOrderAuditResultInOrderList;
import ngves.asiainfo.interfaces.hp.bean.overTimeOrderAuditResult.out.OverTimeOrderAuditResultOutBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.overTimeOrderAuditResult.out.OverTimeOrderAuditResultOutDetail;
import ngves.asiainfo.interfaces.hp.bean.overTimeWaitAuditOrderQuery.in.OverTimeWaitAuditOrderQueryInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.overTimeWaitAuditOrderQuery.out.OverTimeWaitAuditOrderQueryOutBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.overTimeWaitAuditOrderQuery.out.OverTimeWaitAuditOrderQueryOutOrderList;
import ngves.asiainfo.interfaces.hp.realtime.OverTimeOrderAuditResultInter;
import ngves.asiainfo.interfaces.hp.realtime.OverTimeWaitAuditOrderQueryInter;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.secframe.bo.orgmodel.SysStaffEngine;
import com.ai.secframe.ivalues.orgmodel.ISysStaffValue;

public class OverTimeOrderSrvImpl implements IOverTimeOrderSrv {
	private static transient Log logger = LogFactory
	.getLog(OverTimeOrderSrvImpl.class);
	private IOverTimeOrderDAO OverTimeOrderDAO;

	public void setOverTimeOrderDAO(IOverTimeOrderDAO OverTimeOrderDAO)
			throws Exception {
		this.OverTimeOrderDAO = OverTimeOrderDAO;
	}

	public int countOrderExcelTaskValues(String staffId, String taskType,
			String taskId, String startTime, String endTime) throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String, String> parameter = new HashMap<String, String>();
		// 员工ID
		if (!StringUtil.isBlank(staffId)) {
			condition.append(" AND ").append(IExcelTaskValue.S_StaffId).append("=:").append(IExcelTaskValue.S_StaffId);
			parameter.put(IExcelTaskValue.S_StaffId, staffId);
		}
		// 员工类型
		if (!StringUtil.isBlank(taskType)) {
			condition.append(" AND ").append(IExcelTaskValue.S_TaskeType).append("=:").append(IExcelTaskValue.S_TaskeType);
			parameter.put(IExcelTaskValue.S_TaskeType, taskType);
		}
		
		// 任务编码
		if (!StringUtil.isBlank(taskId)) {
			condition.append(" AND ").append(IExcelTaskValue.S_ExcelTaskId).append(" like :").append(IExcelTaskValue.S_ExcelTaskId);
			parameter.put(IExcelTaskValue.S_ExcelTaskId, "%"+taskId.trim()+"%");
		}
		
		if (null != startTime && !StringUtil.isBlank(startTime)) {
			condition.append(" and " + IExcelTaskValue.S_CreateDate + ">= to_date('" + startTime
					+ "','yyyy-mm-dd hh24:mi:ss')");
		}

		if (null != endTime && !StringUtil.isBlank(endTime)) {
			condition.append(" and " + IExcelTaskValue.S_CreateDate + " <= to_date('" + endTime
					+ "','yyyy-mm-dd hh24:mi:ss')");
		}
		int num = OverTimeOrderDAO.countExcelTaskValues(condition.toString(), parameter);
	
		return num;
	}

	public int getOverTimeOrderExaminCount(String orderType,
			String businessTypeId, String partnerId, String userProvinceCode,
			String provinceCode, String startDay, String endDay,
			String checkStatus,String warehouseType,String wareHouseId) throws Exception {
		int orderSum = getOverTimeWaitAuditOrderQueryOutBizRegReq(orderType,
				businessTypeId, partnerId, userProvinceCode, provinceCode,
				startDay, endDay, checkStatus, warehouseType,wareHouseId, -9, -9)
				.getOrderSum();
		return orderSum;
	}

	public IOverTimeOrderExaminListValue[] getOverTimeOrderExaminList(
			String orderType, String businessTypeId, String partnerId,
			String userProvinceCode, String provinceCode, String startDay,
			String endDay, String checkStatus,String warehouseType,String wareHouseId,
			int startIndex, int endIndex) throws Exception {

		IOverTimeOrderExaminListValue value[] = null;
		 OverTimeWaitAuditOrderQueryOutBizRegReq out = getOverTimeWaitAuditOrderQueryOutBizRegReq(
				orderType, businessTypeId, partnerId, userProvinceCode,
				provinceCode, startDay, endDay, checkStatus, warehouseType,wareHouseId,
				startIndex, endIndex);
		
		if (!out.getRejectReason().equals(InterConstant.SUCC)
				&& !out.getRejectReason().equals(
						InterConstant.AI_DEDUCT_CODE_ERROR_J0101)
				&& !out.getRejectReason().equals(
						InterConstant.AI_DEDUCT_CODE_ERROR_J0102)) {
			throw new Exception(out.getErrorMsg());

		} else {
			
		OverTimeWaitAuditOrderQueryOutOrderList[] list = out
				.getOrderListArray();

		value = new OverTimeOrderExaminListBean[list.length];
		for (int i = 0; i < value.length; i++) {
			// 创建正常订单详情对象，用来保存对应的超时订单信息
			value[i] = new OverTimeOrderExaminListBean();
			// 订单号
			value[i].setOrderSeq(list[i].getOrderID());
			// 子订单号
			value[i].setSubOrderSeq(list[i].getSubEorderID());
			// 订单类型
			value[i].setOrderType(out.getOrderType());
			// 订单状态
			value[i].setStatus(list[i].getCheckStatus());
			// 超时天数
			value[i].setOutDays(list[i].getOverTimeDay() + "");
			// 用户手机号
			value[i].setUserMobNum(list[i].getMobile());
			// 用户品牌
			value[i].setUserBrand(StringUtil.isBlank(list[i].getStarLevel()) ? AiHpInterUtil.convertToAIMoblieCode(list[i].getUserBrand()) : list[i].getStarLevel());
			// 业务受理手机号
			value[i].setMobNum(list[i].getBMobile());
			// 配送人姓名
			value[i].setSenderName(list[i].getCusName());
			// 签收人姓名
			value[i].setReceName(list[i].getSignName());
		}
		return value;
		}		
	}
	//客户品牌
	protected String getUserBrandName(String  UserBrand)throws Exception {
		if("G".equals(UserBrand)){
			return CoreConstant.GLOBAL_NORMAL_INTEGRAL;
		}
		if("M".equals(UserBrand)){
			return CoreConstant.M_NORMAL_INTEGRAL;
		}
		if("E".equals(UserBrand)){
			return CoreConstant.E_NORMAL_INTEGRAL;
		}
		return null;
		}
	// 获取返回超时订单的报文对象
	protected OverTimeWaitAuditOrderQueryOutBizRegReq getOverTimeWaitAuditOrderQueryOutBizRegReq(
			String orderType, String businessTypeId, String partnerId,
			String userProvinceCode, String provinceCode, String startDay,
			String endDay, String checkStatus,String warehouseType,String wareHouseId, 
			int startNum, int endNum) throws Exception {
		if (startNum == -1 && endNum == -1) {
			startNum = 1;
			endNum = 5000;
		}
		// 获取输入报文对象
		OverTimeWaitAuditOrderQueryInBizRegReq in = OverTimeWaitAuditOrderQueryInter
				.getOutTimeOrderQueryBean();
		in.setOrderType(orderType);
		in.setBusinessType(businessTypeId);
		if (!StringUtil.isBlank(partnerId) && !("-1".equals(partnerId))) {
			in.setPartnerID(partnerId);
		} else {
			in.setPartnerID("");
		}
		if (!StringUtil.isBlank(userProvinceCode)
				&& !("-1".equals(userProvinceCode))) {
			in.setProvince(ProvinceUtil.toHpProvince(userProvinceCode));
		} else {
			in.setProvince("");
		}
		if (!StringUtil.isBlank(provinceCode) && !("-1".equals(provinceCode))) {
			in.setPProvince(ProvinceUtil.toHpProvince(provinceCode));
		} else {
			in.setPProvince("");
		}
		if (!StringUtil.isBlank(startDay)) {
			in.setStartDay(startDay);
		} else {
			in.setStartDay("");
		}
		if (!StringUtil.isBlank(endDay)) {
			in.setEndDay(endDay);
		} else {
			in.setEndDay("");
		}
		if (!StringUtil.isBlank(checkStatus) && !("-1".equals(checkStatus))) {
			in.setCheckStatus(checkStatus);
		} else {
			in.setCheckStatus("");
		}
		in.setIsSendMessage("00");
		if(!StringUtil.isBlank(startNum+"")){
			in.setSRowNum(startNum);
		}
		if(!StringUtil.isBlank(endNum+"")){
			in.setERowNum(endNum);
		}
		
		if (!StringUtil.isBlank(warehouseType) && !("-1".equals(warehouseType))) {
			in.setStoreType(AiHpInterUtil.getHPStoreTypeByAIParaCode(warehouseType));
		} else {
			in.setStoreType("");
		}
		if (!StringUtil.isBlank(wareHouseId) && !("-1".equals(wareHouseId))) {
			in.setStoreID(wareHouseId);
		} else {
			in.setStoreID("");
		}
		return OverTimeWaitAuditOrderQueryInter.doBusi(in);
	}


	public IExcelTaskValue[] queryOrderExcelTaskValues(String staffId,
			String taskType, String taskId, String startTime, String endTime,
			int startIndex, int endIndex) throws Exception {

		logger.info("the taskId is " + taskId + ",the staffId is " + staffId);
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String, String> parameter = new HashMap<String, String>();

		// 员工ID
		if (!StringUtil.isBlank(staffId)) {
			condition.append(" AND ").append(IExcelTaskValue.S_StaffId).append("=:").append(IExcelTaskValue.S_StaffId);
			parameter.put(IExcelTaskValue.S_StaffId, staffId);
		}
		// 员工类型
		if (!StringUtil.isBlank(taskType)) {
			condition.append(" AND ").append(IExcelTaskValue.S_TaskeType).append("=:").append(IExcelTaskValue.S_TaskeType);
			parameter.put(IExcelTaskValue.S_TaskeType, taskType);
		}
		// 任务编码
		if (!StringUtil.isBlank(taskId)) {
			condition.append(" AND ").append(IExcelTaskValue.S_ExcelTaskId).append(" like :").append(IExcelTaskValue.S_ExcelTaskId);
			parameter.put(IExcelTaskValue.S_ExcelTaskId,  "%"+taskId.trim()+"%");
		}
		
		if (null != startTime && !StringUtil.isBlank(startTime)) {
			condition.append(" and " + IExcelTaskValue.S_CreateDate + ">= to_date('" + startTime
					+ "','yyyy-mm-dd hh24:mi:ss')");
		}

		if (null != endTime && !StringUtil.isBlank(endTime)) {
			condition.append(" and " + IExcelTaskValue.S_CreateDate + " <= to_date('" + endTime
					+ "','yyyy-mm-dd hh24:mi:ss')");
		}
		
		// 增加排序选项，先根据任务是否完成排序，再根据创建时间，最后在根据结束时间
		condition.append(" order by create_date desc,end_date desc ");
		IExcelTaskValue[] value = OverTimeOrderDAO.queryExcelTaskValues(condition.toString(), parameter, startIndex, endIndex);
		for (IExcelTaskValue orderValue : value) {
			 if(!StringUtil.isBlank(String.valueOf(orderValue.getStaffId()))){
		    	ISysStaffValue staffValue= SysStaffEngine.getBean(orderValue.getStaffId());
		    	orderValue.setBakCol2((staffValue.getStaffName()));	
		    }	
		}
		return fillHTMLOperationField(value);
		//return null;
	}
	
	/**
	 * 填充操作区域的html代码
	 * 
	 * @param values
	 * @return
	 */
	private IExcelTaskValue[] fillHTMLOperationField(IExcelTaskValue[] values) {
		for (IExcelTaskValue v : values) {

			// 如果状态为 待处理、处理中、处理完成、任务删除
			if (v.getTaskState().equals(CoreConstant.EXCEL_TASK_STATE_WAIT) || v.getTaskState().equals(CoreConstant.EXCEL_TASK_STATE_DOING)
					|| v.getTaskState().equals(CoreConstant.EXCEL_TASK_STATE_DONE) || v.getTaskState().equals(CoreConstant.EXCEL_TASK_STATE_DELETE)) {
				// 处理完成的任务
				if (v.getTaskState().equals(CoreConstant.EXCEL_TASK_STATE_DONE)) {
					v.setBakCol("<a href=\"#\" onclick=\"javascript:businessProcess('BAK_COL','" + v.getExcelTaskId()
							+ "')\">查看导出条件</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"#\" onclick=\"javascript:businessProcess('BAK_COL2','" + v.getFileName()
							+ "')\">下载</a>");
					v.setTaskState(CoreConstant.EXCEL_TASK_STATE_DONE_DESC);
				}
				// 处理中的任务
				if (v.getTaskState().equals(CoreConstant.EXCEL_TASK_STATE_DOING)) {
					v.setBakCol("<a href=\"#\" onclick=\"javascript:businessProcess('BAK_COL','" + v.getExcelTaskId()
							+ "')\">查看导出条件</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
					v.setTaskState(CoreConstant.EXCEL_TASK_STATE_DOING_DESC);
				}
				// 待处理的任务
				if (v.getTaskState().equals(CoreConstant.EXCEL_TASK_STATE_WAIT)) {
					v.setBakCol("<a href=\"#\" onclick=\"javascript:businessProcess('BAK_COL','" + v.getExcelTaskId()
							+ "')\">查看导出条件</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
					v.setTaskState(CoreConstant.EXCEL_TASK_WAIT_DESC);
				}
				// 过期删除的任务
				if (v.getTaskState().equals(CoreConstant.EXCEL_TASK_STATE_DELETE)) {
					v.setBakCol("<a href=\"#\" onclick=\"javascript:businessProcess('BAK_COL','" + v.getExcelTaskId()
							+ "')\">查看导出条件</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
					v.setTaskState(CoreConstant.EXCEL_TASK_STATE_DELETE_DESC);
				}

			} else {
				// 处理时发生异常的任务
				v.setBakCol("<a href=\"#\" onclick=\"javascript:businessProcess('BAK_COL','" + v.getExcelTaskId()
						+ "')\">查看导出条件</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
				v.setTaskState(CoreConstant.EXCEL_TASK_STATE_ERROR_DESC);
			}

		}
		return values;

	}

	public String overTimeOrderExamine(String operType, String sUserID,
			long orgId, String comType, String sCheckTime, String[] orderID,
			String[] subEorderID, String[] mobile, String[] checkStatus,
			String isSendMessage, String comments) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		Map<String, String> mapFailed = new HashMap<String, String>();
		String busiTypeId = "";
		String note = "";
		String noteFail = "";
		int fstateNum = 0;
		int errorBackNum = 0;
		int discreNum = 0;
		int whithoutNum = 0;
		int other=0;
		int prepoststate=0;
		String erro = "";
		OverTimeOrderAuditResultInBizRegReq in = OverTimeOrderAuditResultInter
				.getOutTimeOrderQueryBean();
		logger.info(operType);
		in.setOperType(operType);
		in.setSUserID(sUserID);
		ISysStaffValue staffValue = SysStaffEngine.getBean(Long
				.parseLong(sUserID));
		String sUserName = staffValue.getStaffName();
		in.setSUserName(sUserName);
        	sCheckTime=	DateTimeUtil.format(DateTimeUtil.getNowTimeStamp(),"yyyyMMddHHmmss");
        in.setSCheckTime(sCheckTime);
		in.setOrderSum(orderID.length);
		if (OrderConstant.HEAD_OF_OPERATION_CENTRE.equals(operType)) {
			busiTypeId = "CD";
			note = "超时订单审核成功记录[";
			noteFail = "超时订单审核失败记录[";
		}
		if (OrderConstant.HEAD_OF_CUSTOMER_SERVICE.equals(operType)) {
			busiTypeId = "CS";
			note = "发送超时订单短信成功记录[";
			noteFail = "发送超时订单短信失败记录[";
		}
		OverTimeOrderAuditResultInOrderList list =null;
		for (int i = 0; i < orderID.length; i++) {
			 list = in.addNewOrderList();
			list.setOrderID(orderID[i]);
			list.setSubEorderID(subEorderID[i]);
			list.setMobile(mobile[i]);
			// 超时订单审核
			if (OrderConstant.HEAD_OF_OPERATION_CENTRE.equals(operType)) {
				if (OrderConstant.IS_SEND_MESSAGE.equals(isSendMessage)) {
					list.setCheckStatus(OrderConstant.STATUS_SEND_VAULE);
				} else if (OrderConstant.NOT_SEND_MESSAGE.equals(isSendMessage)) {
					list.setCheckStatus(OrderConstant.STATUS_DONTSEND_VAULE);
				}
				list.setIsSendMessage(isSendMessage);
			}
			// 客服基地超时订单发短信
			if (OrderConstant.HEAD_OF_CUSTOMER_SERVICE.equals(operType)) {
				list.setIsSendMessage(OrderConstant.IS_SEND_MESSAGE);
				list.setCheckStatus(OrderConstant.STATUS_ALREADY_VAULE);
				busiTypeId = "CS";
				note = "发送超时订单短信成功记录[";
				noteFail = "发送超时订单短信失败记录[";
			}
			list.setComments(comments);
			map.put(subEorderID[i], "大订单号：" + list.getOrderID() + "，子订单号："
					+ list.getSubEorderID() + "，审核结果状态："
					+getCheckStatusMap().get(list.getCheckStatus()) + "；");
		}
		OverTimeOrderAuditResultOutBizRegReq out = null;
		out = OverTimeOrderAuditResultInter.doBusi(in);
		
		if (!out.getRejectReason().equals(InterConstant.SUCC)) {
			throw new Exception(out.getErrorMsg());
		} else {
			OverTimeOrderAuditResultOutDetail[] detail = out.getDetailArray();
			for (int i = 0; i < detail.length; i++) {
				// 审核或发送成功
				if (!detail[i].getTradeResCode().equals(InterConstant.SUCC)) {
					if ("J0201".equals(detail[i].getTradeResCode())) {
						fstateNum++;
					}else if ("J0202".equals(detail[i].getTradeResCode())) {
						errorBackNum ++;
					}else if ("J0203".equals(detail[i].getTradeResCode())) {
						discreNum++;
					}else if ("J0204".equals(detail[i].getTradeResCode())) {
						whithoutNum++;
					}else if ("J0205".equals(detail[i].getTradeResCode())) {
						prepoststate ++;
					}else{
						other++;
						}
					map.remove(detail[i].getSubEorderID());
					mapFailed.put(detail[i].getSubEorderID(), "大订单号："
							+ detail[i].getOrderID() + "，子订单号："
							+ detail[i].getSubEorderID() + "，失败原因："
							+ detail[i].getTradeResDesc() + "；");
				}

			}
			if (fstateNum > 0) {
				erro += "当前状态为已为最终状态" + "(" + fstateNum + ")" + ",";
			}
			if (errorBackNum > 0) {
				erro += "反馈状态错误" + "(" + errorBackNum + ")" + ",";
			}
			if (whithoutNum > 0) {
				erro += "无此记录" + "(" + whithoutNum + ")" + ",";
			}
			if (discreNum > 0) {
				erro += "请求报文中的订单数量与实际数量不符" + "(" + discreNum + ")" + ",";
			}
			if (prepoststate > 0) {
				erro += "前置或后置状态错误" + "(" + prepoststate + ")" + ",";
			}
			if (other > 0) {
				erro += "其他错误" + "(" + other + ")" + ",";
			}
			String notes = "";
			logger.info("chenhgg"+map.size());
			if (map.size()>0) {
				for (Entry<String, String> value : map.entrySet()) {
					note += value.getValue();
				}
				note = note.substring(0, note.length() - 1);
				note += "]";
				logger.info("备注1：" + note);
				notes += note;
			}
			if (mapFailed.size()>0) {
				for (Entry<String, String> value : mapFailed.entrySet()) {
					noteFail += value.getValue();
				}
				noteFail = noteFail.substring(0, noteFail.length() - 1);
				noteFail += "]";
				logger.info("备注2：" + noteFail);
				notes += noteFail;
			}
			String opt_type =CoreConstant.BUSI_INFO_OPT_TYPE_CHECK_KIND;
			String opt_obj="超时订单";
			comType=CoreConstant.SYS_PARA_USER_HEAD_COMPANY;
		
			BusiInfoUtil.recordBusiInfo("", busiTypeId, Long.parseLong(sUserID), notes, opt_type, opt_obj, -1, comType, orgId);
			if (!StringUtil.isBlank(erro)) {
				erro=erro.substring(0, erro.length()-1);
				return erro;
			}
		}
		return erro;
	}
	 public static Map<String, String> getCheckStatusMap() throws Exception {
	        Map<String, String> map = new HashMap<String, String>();
	        map.put(OrderConstant.STATUS_PENDING_VAULE,OrderConstant.STATUS_PENDING_NAME);
	        map.put(OrderConstant.STATUS_DONTSEND_VAULE, OrderConstant.STATUS_DONTSEND_NAME);
	        map.put(OrderConstant.STATUS_SEND_VAULE,OrderConstant.STATUS_SEND_NAME);
	        map.put(OrderConstant.STATUS_ALREADY_VAULE, OrderConstant.STATUS_ALREADY_NAME);
	        return map;
	    }
	 public static Map<String, String> getOrderTypeMap() throws Exception {
	        Map<String, String> map = new HashMap<String, String>();
	        map.put(OrderConstant.TYPE_PENDING_VAULE,OrderConstant.TYPE_PENDING_NAME);
	        map.put(OrderConstant.TYPE_ERROR_VAULE, OrderConstant.TYPE_ERROR_NAME);
	        return map;
	    }
	 public static Map<String, String> getBrandTypeMap() throws Exception {
	        Map<String, String> map = new HashMap<String, String>();
	        map.put(OrderConstant.BRAND_E_VAULE,OrderConstant.BRAND_E_NAME);
	        map.put(OrderConstant.BRAND_G_VAULE, OrderConstant.BRAND_G_NAME);
	        map.put(OrderConstant.BRAND_M_VAULE, OrderConstant.BRAND_M_NAME);
	        return map;
	    }
	 public IOverTimeOrderExaminListValue[] getOverTimeOrderExaminListExport(
				String orderType, String businessTypeId, String partnerId,
				String userProvinceCode, String provinceCode, String startDay,
				String endDay, String checkStatus,String warehouseType,String wareHouseId,
				int startIndex, int endIndex) throws Exception {

			IOverTimeOrderExaminListValue value[] = null;
			OverTimeWaitAuditOrderQueryOutBizRegReq out = getOverTimeWaitAuditOrderQueryOutBizRegReq(
					orderType, businessTypeId, partnerId, userProvinceCode,
					provinceCode, startDay, endDay, checkStatus,warehouseType,wareHouseId,
					startIndex, endIndex);
			if (!out.getRejectReason().equals(InterConstant.SUCC)
					&& !out.getRejectReason().equals(
							InterConstant.AI_DEDUCT_CODE_ERROR_J0101)
					&& !out.getRejectReason().equals(
							InterConstant.AI_DEDUCT_CODE_ERROR_J0102)) {
				throw new Exception(out.getErrorMsg());
				
			}else{
			OverTimeWaitAuditOrderQueryOutOrderList[] list = out
					.getOrderListArray();

			value = new OverTimeOrderExaminListBean[list.length];
			for (int i = 0; i < value.length; i++) {
				// 创建正常订单详情对象，用来保存对应的超时订单信息
				value[i] = new OverTimeOrderExaminListBean();
				// 订单号
				value[i].setOrderSeq(list[i].getOrderID());
				// 子订单号
				value[i].setSubOrderSeq(list[i].getSubEorderID());
				// 订单类型
				
				value[i].setOrderType(getOrderTypeMap().get(out.getOrderType()));
				// 订单状态
				value[i].setStatus(getCheckStatusMap().get(list[i].getCheckStatus()));
				// 超时天数
				value[i].setOutDays(list[i].getOverTimeDay() + "");
				// 用户手机号
				value[i].setUserMobNum(list[i].getMobile());
				// 用户品牌
//				value[i].setUserBrand(IntegralUtil.getUserStarOrBrandName(list[i].getUserBrand()));
				value[i].setUserBrand(
						IntegralUtil.getUserStarOrBrandName(          //将获取到的星级/品牌代码转化为文字
								StringUtil.isBlank(list[i].getStarLevel()) ? list[i].getUserBrand() : list[i].getStarLevel()));//判断获取用户星级或是品牌
				// 业务受理手机号
				value[i].setMobNum(list[i].getBMobile());
				// 配送人姓名
				value[i].setSenderName(list[i].getCusName());
				// 签收人姓名
				value[i].setReceName(list[i].getSignName());
			}
			return value;
			}
		}
	 public int getOverTimeOrderExaminCountExport(String orderType,
				String businessTypeId, String partnerId, String userProvinceCode,
				String provinceCode, String startDay, String endDay,
				String checkStatus,String warehouseType,String wareHouseId) throws Exception {
			int orderSum = getOverTimeWaitAuditOrderQueryOutBizRegReq(orderType,
					businessTypeId, partnerId, userProvinceCode, provinceCode,
					startDay, endDay, checkStatus,warehouseType, wareHouseId,-9, -9)
					.getOrderSum();
			logger.info("getOverTimeOrderExaminCountExport:orderSum="+orderSum);
			return orderSum;
		}
}
