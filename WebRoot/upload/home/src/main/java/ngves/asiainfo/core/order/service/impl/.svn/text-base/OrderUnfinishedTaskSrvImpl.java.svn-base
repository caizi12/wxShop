package ngves.asiainfo.core.order.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.common.service.interfaces.ISysBusiLockInfoSrv;
import ngves.asiainfo.core.order.OrderConstant;
import ngves.asiainfo.core.order.bo.BusiUnfinishedOrderAuditBean;
import ngves.asiainfo.core.order.bo.BusiUnfinishedOrderInfoBean;
import ngves.asiainfo.core.order.dao.interfaces.IOrderAuditBusiInfoDAO;
import ngves.asiainfo.core.order.dao.interfaces.IOrderBusiInfoDAO;
import ngves.asiainfo.core.order.dao.interfaces.IOrderUnfinishedTaskDAO;
import ngves.asiainfo.core.order.ivalues.IBusiUnfinishedOrderAuditValue;
import ngves.asiainfo.core.order.ivalues.IBusiUnfinishedOrderInfoValue;
import ngves.asiainfo.core.order.ivalues.IOrderUnfinishedTaskValue;
import ngves.asiainfo.core.order.service.interfaces.IOrderUnfinishedTaskSrv;
import ngves.asiainfo.interfaces.hp.realtime.MessageInter;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.secframe.bo.orgmodel.SysStaffEngine;
import com.ai.secframe.ivalues.orgmodel.ISysStaffValue;

/**
 * 未完结订单实现类
 * @author fsr 
 * @date  2013-04-24
 */
public class OrderUnfinishedTaskSrvImpl implements IOrderUnfinishedTaskSrv {
	
	private static Log logger = LogFactory.getLog(OrderUnfinishedTaskSrvImpl.class);
	
	public IOrderBusiInfoDAO orderBusiInfoDAO;
	public IOrderUnfinishedTaskDAO orderUnfinishedTaskDAO;
	public IOrderAuditBusiInfoDAO orderAuditBusiInfoDAO;
	
	@SuppressWarnings("unchecked")
	public IOrderUnfinishedTaskValue[] queryTaskList(String taskStatus, String managerStatus,String auditStatus,
			int startNum, int endNum) throws Exception {
		logger.info("OrderUnfinishedTaskSrvImpl.queryTaskList --> the taskStatus is " + taskStatus + ",the managerStatus is" + managerStatus
				+",the auditStatus is " + auditStatus);
		
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map parameter = new HashMap();
		
		// 任务状态
		if (!StringUtil.isBlank(taskStatus)) {
			if(!OrderConstant.QUERY_ALL_VALUE.equals(taskStatus)){
				condition.append(" AND ").append(IOrderUnfinishedTaskValue.S_TaskState).append(" =:").append(IOrderUnfinishedTaskValue.S_TaskState);
				parameter.put(IOrderUnfinishedTaskValue.S_TaskState, taskStatus);
			}else if(OrderConstant.QUERY_ALL_VALUE.equals(taskStatus)&&OrderConstant.FIRST_AUDIT_PAGE_FLAG.equals(auditStatus)){//初审页面
				condition.append(" AND ").append(IOrderUnfinishedTaskValue.S_TaskState).append(" in ('"+OrderConstant.ORDER_UNFINISHED_STATUS_NOTVERIFY
						+"','"+OrderConstant.ORDER_UNFINISHED_STATUS_FIRSTVERIFY+"','"+OrderConstant.ORDER_UNFINISHED_STATUS_NOTFIRSTVERIFY+"')");
			}else if(OrderConstant.QUERY_ALL_VALUE.equals(taskStatus)&&OrderConstant.RE_AUDIT_PAGE_FLAG.equals(auditStatus)){//复审页面
				condition.append(" AND ").append(IOrderUnfinishedTaskValue.S_TaskState).append(" in ('"+OrderConstant.ORDER_UNFINISHED_STATUS_FIRSTVERIFY
						+"','"+OrderConstant.ORDER_UNFINISHED_STATUS_SECONDVERIFY+"','"+OrderConstant.ORDER_UNFINISHED_STATUS_NOTSECONDVERIFY+"')");
			}//待处理页面查询全部,不需要做特殊处理
		}
		// 任务执行状态
		if (!StringUtil.isBlank(managerStatus)) {
			if(!OrderConstant.QUERY_ALL_VALUE.equals(managerStatus)){//初审页面默认为未执行所以不用考虑特殊处理
				condition.append(" AND ").append(IOrderUnfinishedTaskValue.S_ManageState).append(" =:").append(IOrderUnfinishedTaskValue.S_ManageState);
				parameter.put(IOrderUnfinishedTaskValue.S_ManageState, managerStatus);
			}
		}
		condition.append(" AND BAK_COL2 <> '0' "); //不能查询出已被删除的记录
		if(OrderConstant.RE_AUDIT_PAGE_FLAG.equals(auditStatus)){//复审页面按初审时间倒序排列
			condition.append(" ORDER BY FIRST_TIME DESC ");
		}else{
			condition.append(" ORDER BY CREATE_TIME DESC ");
		}
		IOrderUnfinishedTaskValue[] value = orderUnfinishedTaskDAO.getOrderUnfininshedTaskInfo(condition.toString(), parameter, startNum, endNum);
		return fillHTMLOperationField(value,auditStatus);
	}
	
	@SuppressWarnings("unchecked")
	public int queryTaskListCount(String taskStatus, String managerStatus,String auditStatus) throws Exception {
		logger.info("OrderUnfinishedTaskSrvImpl.queryTaskListCount --> the taskStatus is " + taskStatus + ",the managerStatus is " + managerStatus
				+",the auditStatus is " + auditStatus);
		
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map parameter = new HashMap();
		
		// 任务状态
		if (!StringUtil.isBlank(taskStatus)) {
			if(!OrderConstant.QUERY_ALL_VALUE.equals(taskStatus)){
				condition.append(" AND ").append(IOrderUnfinishedTaskValue.S_TaskState).append("=:").append(IOrderUnfinishedTaskValue.S_TaskState);
				parameter.put(IOrderUnfinishedTaskValue.S_TaskState, taskStatus);
			}else if(OrderConstant.QUERY_ALL_VALUE.equals(taskStatus)&&OrderConstant.FIRST_AUDIT_PAGE_FLAG.equals(auditStatus)){//初审页面
				condition.append(" AND ").append(IOrderUnfinishedTaskValue.S_TaskState).append(" in ('"+OrderConstant.ORDER_UNFINISHED_STATUS_NOTVERIFY
						+"','"+OrderConstant.ORDER_UNFINISHED_STATUS_FIRSTVERIFY+"','"+OrderConstant.ORDER_UNFINISHED_STATUS_NOTFIRSTVERIFY+"')");
			}else if(OrderConstant.QUERY_ALL_VALUE.equals(taskStatus)&&OrderConstant.RE_AUDIT_PAGE_FLAG.equals(auditStatus)){//复审页面
				condition.append(" AND ").append(IOrderUnfinishedTaskValue.S_TaskState).append(" in ('"+OrderConstant.ORDER_UNFINISHED_STATUS_FIRSTVERIFY
						+"','"+OrderConstant.ORDER_UNFINISHED_STATUS_SECONDVERIFY+"','"+OrderConstant.ORDER_UNFINISHED_STATUS_NOTSECONDVERIFY+"')");
			}//待处理页面查询全部,不需要做特殊处理
		}
		// 任务执行状态
		if (!StringUtil.isBlank(managerStatus)) {
			if(!OrderConstant.QUERY_ALL_VALUE.equals(managerStatus)){//初审页面默认为未执行所以不用考虑特殊处理
				condition.append(" AND ").append(IOrderUnfinishedTaskValue.S_ManageState).append("=:").append(IOrderUnfinishedTaskValue.S_ManageState);
				parameter.put(IOrderUnfinishedTaskValue.S_ManageState, managerStatus);
			}
		}
		condition.append(" AND BAK_COL2 <> '0' "); //不能查询出已被删除的记录 
		int num = orderUnfinishedTaskDAO.getOrderUnfininshedTaskInfoCount(condition.toString(), parameter);
		return num;
	}

	/**
	 * 保存未完结订单任务信息
	 */
	public void saveTaskInfo(IOrderUnfinishedTaskValue orderUnfinishedTaskValue) throws Exception {
		logger.info("saveTaskInfo the taskid is" + orderUnfinishedTaskValue.getTaskId());
		this.saveTrialTaskInfo(orderUnfinishedTaskValue.getTaskId() + "", 
				OrderConstant.ORDER_UNFINISHED_STATUS_NOTVERIFY, null, orderUnfinishedTaskValue.getOptId(), 
				DateTimeUtil.timeStampToString(orderUnfinishedTaskValue.getCreateTime(), OrderConstant.ORDER_DATE_FORMAT_LONG));
		this.orderUnfinishedTaskDAO.saveTaskInfo(orderUnfinishedTaskValue);
		this.saveOrderUnfinishedTaskBusiInfo(orderUnfinishedTaskValue);
	}
	
	/**
	 * 保存未完结订单的修改记录流水
	 * @param orderUnfinishedTaskValue
	 */
	private void saveOrderUnfinishedTaskBusiInfo(IOrderUnfinishedTaskValue orderUnfinishedTaskValue) throws Exception {
		IBusiUnfinishedOrderInfoValue busiUnfinishedOrderInfoValue =new BusiUnfinishedOrderInfoBean();
		busiUnfinishedOrderInfoValue.setTaskId(orderUnfinishedTaskValue.getTaskId()+"");//任务id
		busiUnfinishedOrderInfoValue.setOptId(orderUnfinishedTaskValue.getOptId());//操作人
		busiUnfinishedOrderInfoValue.setOperTime(orderUnfinishedTaskValue.getCreateTime());//操作时间
		busiUnfinishedOrderInfoValue.setOrderType(orderUnfinishedTaskValue.getOrderType());//订单类型
		busiUnfinishedOrderInfoValue.setEndState(orderUnfinishedTaskValue.getEndState());//完结状态
		busiUnfinishedOrderInfoValue.setBusinessType(orderUnfinishedTaskValue.getBusinessType());//业务类别
		if(orderUnfinishedTaskValue.getBakCol1().equals("1")){
			busiUnfinishedOrderInfoValue.setIsFileChange("1");//文件已修改
		}else{
			busiUnfinishedOrderInfoValue.setIsFileChange("0");//文件未修改
		}
		busiUnfinishedOrderInfoValue.setIsSend(orderUnfinishedTaskValue.getIsSend());//是否发送短信
		busiUnfinishedOrderInfoValue.setIsSettle(orderUnfinishedTaskValue.getIsSettle());//是否结算
		busiUnfinishedOrderInfoValue.setDescInfo(orderUnfinishedTaskValue.getDescInfo());//描述信息
		
		this.orderBusiInfoDAO.saveOrderUnfinishedTaskBusiInfo(busiUnfinishedOrderInfoValue);
	}

	/**
	 * 整体业务操作: 保存审核信息
	 * @param taskId 未完结订单任务
	 * @param status 更改的状态
	 * @param content 审核意见
	 * @param operer 操作人
	 * @param dateTime 时间
	 * @throws Exception
	 */
	public void saveTrialTaskInfo(String taskId, String status, String content, String operer, String dateTime) throws Exception {
		logger.debug("OrderUnfinishedTaskSrvImpl --> saveTrialTaskInfo status:" + status);
		//业务锁服务
		ISysBusiLockInfoSrv busiLockInfoSrv = (ISysBusiLockInfoSrv)ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_SYS_BUSI_LOCK_SRV);
		boolean locked = busiLockInfoSrv.gainBusiLock(taskId, "999",-1);//taskId 与 999 作为唯一主键   形成业务锁。999暂为未完结订单更新任务的业务码
	    try {
            if(locked) {
            	IOrderUnfinishedTaskValue orderUnfinishedTaskValue = this.orderUnfinishedTaskDAO.getOrderTaskById(taskId);
            	if(null != orderUnfinishedTaskValue){
            		if(!isAllowOperate(orderUnfinishedTaskValue.getTaskState(),status)){
 					   throw new Exception(OrderConstant.RET_VALUE_Exception1);
 					}
            		if(StringUtil.isBlank(dateTime)){
            			dateTime = DateTimeUtil.dateToString(DateTimeUtil.getNowDate(), OrderConstant.ORDER_DATE_FORMAT_LONG);
    				}
            		if(orderUnfinishedTaskValue.getTaskState() != null && !"null".equals(orderUnfinishedTaskValue.getTaskState())){//表示存在任务
                		if(OrderConstant.ORDER_UNFINISHED_TASK_DELETE.equals(orderUnfinishedTaskValue.getBakCol2())){//此任务已被删除，不能在进行操作
                			 throw new Exception(OrderConstant.RET_VALUE_Exception1);
                		}
            			orderUnfinishedTaskValue.setTaskState(status);
            			if(OrderConstant.ORDER_UNFINISHED_STATUS_FIRSTVERIFY.equals(status) || OrderConstant.ORDER_UNFINISHED_STATUS_NOTFIRSTVERIFY.equals(status)){
            				orderUnfinishedTaskValue.setFirstTrialId(operer);
            				orderUnfinishedTaskValue.setFirstTrialCode(SessionManager.getUser().getCode());
            				orderUnfinishedTaskValue.setFirstTime(DateTimeUtil.stringToTimestamp(dateTime,OrderConstant.ORDER_DATE_FORMAT_LONG));
            			}else if(OrderConstant.ORDER_UNFINISHED_STATUS_SECONDVERIFY.equals(status) || OrderConstant.ORDER_UNFINISHED_STATUS_NOTSECONDVERIFY.equals(status)){
            				orderUnfinishedTaskValue.setReTrialId(operer);
            				orderUnfinishedTaskValue.setReTrialCode(SessionManager.getUser().getCode());
            				orderUnfinishedTaskValue.setSecondTime(DateTimeUtil.stringToTimestamp(dateTime,OrderConstant.ORDER_DATE_FORMAT_LONG));
            			}
            			this.orderUnfinishedTaskDAO.saveTaskInfo(orderUnfinishedTaskValue);
            			if(OrderConstant.ORDER_UNFINISHED_STATUS_NOTFIRSTVERIFY.equals(status) || OrderConstant.ORDER_UNFINISHED_STATUS_SECONDVERIFY.equals(status)
            					|| OrderConstant.ORDER_UNFINISHED_STATUS_NOTSECONDVERIFY.equals(status)){
            				logger.info("======== OrderUnfinishedTask sendSms start ========");
                            sendSms(orderUnfinishedTaskValue.getOptId(),status,orderUnfinishedTaskValue.getCreateTime().toString(),orderUnfinishedTaskValue.getFileName());
            				logger.info("======== OrderUnfinishedTask sendSms end ==========");
            			}
            		}
 					saveAuditBusi( taskId,  status,  content,  operer,  dateTime);//保存审核流水信息
            	}
            }
        } catch (Exception e ) {
            logger.warn("The system is busy, please try again later!", e);
			throw new Exception(OrderConstant.RET_VALUE_Exception1, e);
        } finally {
           	if (locked) {
           		busiLockInfoSrv.releaseBusiLock(taskId, "999");
           	}
           	logger.info("SysBusiLockInfo  unlocked successfully ");
		}
	}
	
	/**
	 * 初审不通过、审核不通过、审核通过，需要通过短信方式通知新增任务人角色
	 * @param oper
	 * @param status
	 * @param time
	 * @param fileName
	 * @return
	 */
	private boolean sendSms(String oper,String status,String time,String fileName) {
		try {
			String phoneNo = "";
			if(!StringUtil.isBlank(oper)){
			    if(!"SYSTEM".equals(oper)){
					try {
						ISysStaffValue staffValue = SysStaffEngine.getBean(Long.parseLong(oper));
						phoneNo = staffValue.getBillId();//移动电话号码
					} catch (Exception e) {
						logger.info("query staffValue fail "+e);
						return false;
					}
			    }
			}
			if(!StringUtil.isBlank(phoneNo)){
				logger.info("将要发送短信的手机号码为 ：" + phoneNo);
				String statusName = "状态已修改";
				if(OrderConstant.ORDER_UNFINISHED_STATUS_NOTFIRSTVERIFY.equals(status)){
					statusName = OrderConstant.ORDER_UNFINISHED_NAME_NOTFIRSTVERIFY;
				}else if(OrderConstant.ORDER_UNFINISHED_STATUS_SECONDVERIFY.equals(status)){
					statusName = OrderConstant.ORDER_UNFINISHED_NAME_SECONDVERIFY;
				}else if(OrderConstant.ORDER_UNFINISHED_STATUS_NOTSECONDVERIFY.equals(status)){
					statusName = OrderConstant.ORDER_UNFINISHED_NAME_NOTSECONDVERIFY;
				}
				time = DateTimeUtil.timeStampToString(DateTimeUtil.stringToTimestamp(time,OrderConstant.ORDER_DATE_FORMAT_LONG), OrderConstant.ORDER_DATE_FORMAT_LONG);
				String smsInfo = "您于"+time+"提交的未完结订单（"+fileName+"）审核申请"+statusName+"，请登录管理平台查看【中国移动积分计划】";
				logger.info("未完结订单的短信内容为：" + smsInfo);
				return MessageInter.doBusi(phoneNo, smsInfo);//返回发送结果
			}
			return true;
		} catch (Exception e) {
			logger.info("sendSms exception is " + e);
			return false;
		}
	}
	
	/**
	 * 这里做系统的状态判断，防止多人同时操作，对单一对象操作，造成不必要的修改
	 * @param oldStatus 旧状态
	 * @param newStatus 新状态
	 * @throws Exception
	 */
	private boolean isAllowOperate(String oldStatus,String newStatus)  throws Exception {
		if(( oldStatus == null || "null".equals(oldStatus) ) && 
	    		OrderConstant.ORDER_UNFINISHED_STATUS_NOTVERIFY.equals(newStatus) 
	    ){//新增的 
			return true;
		}else if(OrderConstant.ORDER_UNFINISHED_STATUS_DRAFT.equals(oldStatus) && 
	    		OrderConstant.ORDER_UNFINISHED_STATUS_NOTVERIFY.equals(newStatus) 
	    ){ // 00-->01 起草-->带审核
	    	return true;
	    } else if (OrderConstant.ORDER_UNFINISHED_STATUS_NOTVERIFY.equals(oldStatus) && 
				(OrderConstant.ORDER_UNFINISHED_STATUS_DRAFT.equals(newStatus) || OrderConstant.ORDER_UNFINISHED_STATUS_FIRSTVERIFY.equals(newStatus)
						|| OrderConstant.ORDER_UNFINISHED_STATUS_NOTFIRSTVERIFY.equals(newStatus))
			){//01-->00,02,03   待审核-->撤回到起草,初审通过,初审不通过
			return true;
		} else if (OrderConstant.ORDER_UNFINISHED_STATUS_NOTFIRSTVERIFY.equals(oldStatus) && 
					OrderConstant.ORDER_UNFINISHED_STATUS_NOTVERIFY.equals(newStatus)
			){//03-->01 初审不通过-->待审核（修改后）
			return true;
		} else if (OrderConstant.ORDER_UNFINISHED_STATUS_FIRSTVERIFY.equals(oldStatus) &&
				(OrderConstant.ORDER_UNFINISHED_STATUS_SECONDVERIFY.equals(newStatus) ||OrderConstant.ORDER_UNFINISHED_STATUS_NOTSECONDVERIFY.equals(newStatus))
			){//02-->04,05 初审通过-->审核通过,审核不通过
			return true;
		} else if (OrderConstant.ORDER_UNFINISHED_STATUS_NOTSECONDVERIFY.equals(oldStatus) && 
				OrderConstant.ORDER_UNFINISHED_STATUS_NOTVERIFY.equals(newStatus)	
			){//05-->01 审核不通过--> 待审核（修改后）
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 保存审核流水信息
	 * @param taskId 未完结订单任务
	 * @param status 更改的状态
	 * @param content 审核意见
	 * @param operer 操作人
	 * @param dateTime 时间
	 * @throws Exception
	 */
	private void saveAuditBusi(String taskId, String status, String content, String operer, String dateTime) throws Exception {
		IBusiUnfinishedOrderAuditValue busiUnfinishedOrderAuditValue =new BusiUnfinishedOrderAuditBean();
		busiUnfinishedOrderAuditValue.setTaskId(Long.parseLong(taskId));
		busiUnfinishedOrderAuditValue.setStatus(status);//状态
		busiUnfinishedOrderAuditValue.setAuditContent(content);
		busiUnfinishedOrderAuditValue.setOptId(operer);	//操作人	
		if(StringUtil.isBlank(dateTime)){
			busiUnfinishedOrderAuditValue.setAuditTime(new Timestamp(new Date().getTime()));
		}else{
			busiUnfinishedOrderAuditValue.setAuditTime(DateTimeUtil.stringToTimestamp(dateTime,OrderConstant.ORDER_DATE_FORMAT_LONG));
		}
		this.orderAuditBusiInfoDAO.saveBusiUnfinishedOrderAuditValue(busiUnfinishedOrderAuditValue);
	}
	
	/**
	 * 填充操作区域的html代码
	 * @param auditStatus 表示在哪个审核页面的flag
	 * @param values
	 * @return
	 * @throws Exception 
	 */
	private IOrderUnfinishedTaskValue[] fillHTMLOperationField(IOrderUnfinishedTaskValue[] values,String auditStatus) throws Exception {
		for (IOrderUnfinishedTaskValue value : values) {

			if(OrderConstant.MANAGER_PAGE_FLAG.equals(auditStatus)){
				if(OrderConstant.ORDER_UNFINISHED_STATUS_DRAFT.equals(value.getTaskState()) ||
						OrderConstant.ORDER_UNFINISHED_STATUS_NOTFIRSTVERIFY.equals(value.getTaskState()) ||
						OrderConstant.ORDER_UNFINISHED_STATUS_NOTSECONDVERIFY.equals(value.getTaskState()) ){
					value.setOper("<a href=\"#\" onclick=\"javascript:indexControl('SEEMORE','" + value.getTaskId()
							+ "')\">任务详情</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"#\" onclick=\"javascript:indexControl('EDIT','" + value.getTaskId()
							+ "')\">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"#\" onclick=\"javascript:indexControl('DELETE','" + value.getTaskId()
							+ "')\">删除</a>");
				} else if(OrderConstant.ORDER_UNFINISHED_STATUS_NOTVERIFY.equals(value.getTaskState())){
					value.setOper("<a href=\"#\" onclick=\"javascript:indexControl('SEEMORE','" + value.getTaskId()
							+ "')\">任务详情</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"#\" onclick=\"javascript:indexControl('BACK','" + value.getTaskId()
							+ "')\">撤回</a>");
				} else if(OrderConstant.ORDER_UNFINISHED_STATUS_FIRSTVERIFY.equals(value.getTaskState())){
					value.setOper("<a href=\"#\" onclick=\"javascript:indexControl('SEEMORE','" + value.getTaskId()
							+ "')\">任务详情</a>");
				} else if(OrderConstant.ORDER_UNFINISHED_STATUS_SECONDVERIFY.equals(value.getTaskState())){
					StringBuffer strBuf = new StringBuffer();
					strBuf.append("<a href=\"#\" onclick=\"javascript:indexControl('SEEMORE','" + value.getTaskId() + "')\">任务详情</a>");
					if(OrderConstant.ORDER_UNFINISHED_TASK_STATUS_SUCCESS.equals(value.getManageState())){
						strBuf.append("&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"#\" onclick=\"javascript:indexControl('RESULT','" + value.getTaskId()
									+ "')\">任务结果</a>");
					}
					value.setOper(strBuf.toString());
				}
			}else if(OrderConstant.FIRST_AUDIT_PAGE_FLAG.equals(auditStatus)){
				if(OrderConstant.ORDER_UNFINISHED_STATUS_NOTVERIFY.equals(value.getTaskState())){
					value.setOper("<a href=\"#\" onclick=\"javascript:indexControl('SEEMORE','" + value.getTaskId()
							+ "')\">任务详情</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"#\" onclick=\"javascript:indexControl('AUDIT','" + value.getTaskId()
							+ "')\">审核</a>");
				}else if(OrderConstant.ORDER_UNFINISHED_STATUS_NOTFIRSTVERIFY.equals(value.getTaskState()) || 
						OrderConstant.ORDER_UNFINISHED_STATUS_FIRSTVERIFY.equals(value.getTaskState())){
					value.setOper("<a href=\"#\" onclick=\"javascript:indexControl('SEEMORE','" + value.getTaskId()
							+ "')\">任务详情</a>");
				}
			}else if(OrderConstant.RE_AUDIT_PAGE_FLAG.equals(auditStatus)){
				if(OrderConstant.ORDER_UNFINISHED_STATUS_FIRSTVERIFY.equals(value.getTaskState())){
					value.setOper("<a href=\"#\" onclick=\"javascript:indexControl('SEEMORE','" + value.getTaskId()
							+ "')\">任务详情</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"#\" onclick=\"javascript:indexControl('AUDIT','" + value.getTaskId()
							+ "')\">审核</a>");
				}else if(OrderConstant.ORDER_UNFINISHED_STATUS_NOTSECONDVERIFY.equals(value.getTaskState())){
					value.setOper("<a href=\"#\" onclick=\"javascript:indexControl('SEEMORE','" + value.getTaskId()
							+ "')\">任务详情</a>");
				}else if(OrderConstant.ORDER_UNFINISHED_STATUS_SECONDVERIFY.equals(value.getTaskState())){
					StringBuffer strBuf = new StringBuffer();
					strBuf.append("<a href=\"#\" onclick=\"javascript:indexControl('SEEMORE','" + value.getTaskId() + "')\">任务详情</a>");
					if(OrderConstant.ORDER_UNFINISHED_TASK_STATUS_SUCCESS.equals(value.getManageState())){
						strBuf.append("&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"#\" onclick=\"javascript:indexControl('RESULT','" + value.getTaskId()
									+ "')\">任务结果</a>");
					}
					value.setOper(strBuf.toString());
				}
			}			
		}
		return values;
	}
	
	@SuppressWarnings("unchecked")
	public IBusiUnfinishedOrderAuditValue[] queryTaskAuditBusiList(String taskId) throws Exception {
		logger.info("the queryTaskAuditBusiList's taskId is" + taskId);
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map parameter = new HashMap();
		// 任务Id
		if (!StringUtil.isBlank(taskId)) {
			condition.append(" AND ").append(IBusiUnfinishedOrderAuditValue.S_TaskId).append("=:").append(IBusiUnfinishedOrderAuditValue.S_TaskId);
			parameter.put(IBusiUnfinishedOrderAuditValue.S_TaskId, taskId);
		}
		// 增加排序选项，按照创建时间倒序排序
		condition.append(" order by audit_time desc ");
		IBusiUnfinishedOrderAuditValue[] values= this.orderAuditBusiInfoDAO.queryTaskAuditBusiList(condition.toString(), parameter);
		
		for (IBusiUnfinishedOrderAuditValue value : values) {
			if(!StringUtil.isBlank(value.getOptId())){
			    if(!"SYSTEM".equals(value.getOptId())){
			    	ISysStaffValue staffValue= SysStaffEngine.getBean(Long.parseLong(value.getOptId()));
					value.setOptId(staffValue.getStaffName());	
			    }
		    }	
		}
		
		return values;
	}
	
	public void deleteTaskInfo(String taskId) throws Exception{
		IOrderUnfinishedTaskValue value = this.orderUnfinishedTaskDAO.getOrderTaskById(taskId);
		if(!OrderConstant.ORDER_UNFINISHED_STATUS_DRAFT.equals(value.getTaskState())&&
				!OrderConstant.ORDER_UNFINISHED_STATUS_NOTFIRSTVERIFY.equals(value.getTaskState())&&
				!OrderConstant.ORDER_UNFINISHED_STATUS_NOTSECONDVERIFY.equals(value.getTaskState())){
			throw new Exception("can not delete the smsTemplate!");
		}
		if("0".equals(value.getBakCol2())){
			throw new Exception("can not delete the smsTemplate, this's deleted!");
		}
		//value.delete();
		value.setBakCol2("0");//代表已删除 2013-04-28 fsr
		this.orderUnfinishedTaskDAO.saveTaskInfo(value);
	}
	
	public IOrderUnfinishedTaskValue queryTaskResultDetail(String taskId) throws Exception{
		IOrderUnfinishedTaskValue orderUnfinishedTaskValue = orderUnfinishedTaskDAO.getOrderTaskById(taskId);
		setOpera(orderUnfinishedTaskValue);
		return orderUnfinishedTaskValue;
		
	}
	
	private IOrderUnfinishedTaskValue setOpera(IOrderUnfinishedTaskValue orderUnfinishedTaskValue) throws Exception {
		StringBuffer sb = new StringBuffer();
		String succFilePath = "\"" + orderUnfinishedTaskValue.getSuccFilePath() + "\"";
		String failFilePath = "\"" + orderUnfinishedTaskValue.getFailFilePath() + "\"";
		sb.append(String.format("<a href=\'#\' onclick=\'javascript:downLoadFile(%s)'>&nbsp;成功订单&nbsp;</a>", succFilePath));
		sb.append(String.format("<a href=\'#\' onclick=\'javascript:downLoadFile(%s)'>&nbsp;失败订单&nbsp;</a>", failFilePath));
		orderUnfinishedTaskValue.setOper(sb.toString());
		return orderUnfinishedTaskValue;
	}
	
	
	public IOrderUnfinishedTaskValue queryUnfinishedOrderTaskById(String taskId) throws Exception {
		IOrderUnfinishedTaskValue orderUnfinishedTaskValue = this.orderUnfinishedTaskDAO.getOrderTaskById(taskId);
		//orderUnfinishedTaskValue.setDescInfo(java.net.URLEncoder.encode(orderUnfinishedTaskValue.getDescInfo(),"UTF-8"));//前后台加密解密	
		return orderUnfinishedTaskValue;
//		return  this.orderUnfinishedTaskDAO.getOrderTaskById(taskId);
	}
	
	public IOrderBusiInfoDAO getOrderBusiInfoDAO() {
		return orderBusiInfoDAO;
	}

	public void setOrderBusiInfoDAO(IOrderBusiInfoDAO orderBusiInfoDAO) {
		this.orderBusiInfoDAO = orderBusiInfoDAO;
	}

	public IOrderUnfinishedTaskDAO getOrderUnfinishedTaskDAO() {
		return orderUnfinishedTaskDAO;
	}

	public void setOrderUnfinishedTaskDAO(IOrderUnfinishedTaskDAO orderUnfinishedTaskDAO) {
		this.orderUnfinishedTaskDAO = orderUnfinishedTaskDAO;
	}

	public IOrderAuditBusiInfoDAO getOrderAuditBusiInfoDAO() {
		return orderAuditBusiInfoDAO;
	}

	public void setOrderAuditBusiInfoDAO(IOrderAuditBusiInfoDAO orderAuditBusiInfoDAO) {
		this.orderAuditBusiInfoDAO = orderAuditBusiInfoDAO;
	}
}

