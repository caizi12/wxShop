/**
 * 
 */
package ngves.asiainfo.core.ware.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.common.util.BusiInfoUtil;
import ngves.asiainfo.core.ware.WareConstant;
import ngves.asiainfo.core.ware.bo.WareUpDownHisBean;
import ngves.asiainfo.core.ware.bo.WareUpDownHisEngine;
import ngves.asiainfo.core.ware.bo.WareUpDownPlanBean;
import ngves.asiainfo.core.ware.bo.WareUpDownVersionBean;
import ngves.asiainfo.core.ware.dao.interfaces.IWareStatusDAO;
import ngves.asiainfo.core.ware.exception.WareUpDownPlanJobException;
import ngves.asiainfo.core.ware.ivalues.IWareInfoValue;
import ngves.asiainfo.core.ware.ivalues.IWareUpDownHisValue;
import ngves.asiainfo.core.ware.ivalues.IWareUpDownPlanValue;
import ngves.asiainfo.core.ware.ivalues.IWareUpDownVersionValue;
import ngves.asiainfo.core.ware.service.interfaces.IWareInfoSrv;
import ngves.asiainfo.core.ware.service.interfaces.IWareStatusSrv;
import ngves.asiainfo.core.ware.util.WareStatusUtil;
import ngves.asiainfo.interfaces.hp.realtime.MessageInter;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.secframe.ivalues.orgmodel.ISysStaffValue;

/**
 * @author asiainfo-linkage
 *
 */
public class WareStatusSrvImpl implements IWareStatusSrv {
	
	private static transient Log log = LogFactory.getLog(WareStatusSrvImpl.class);

	private IWareStatusDAO wareStatusDAO;
	
	/**
	 * @param wareStatusDAO the wareStatusDAO to set
	 */
	public void setWareStatusDAO(IWareStatusDAO wareStatusDAO) {
		this.wareStatusDAO = wareStatusDAO;
	}

	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.ware.service.interfaces.IWareStatusSrv#cancelPreOperLine(java.lang.String)
	 */
	public void cancelPreOperLine(String wareUpDownPlanId, String opState, long staffId, String comType, long orgId) throws Exception {
		//礼品上下线服务
		// IWareStatusSrv wareStatusSrv = (IWareStatusSrv)
		// ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_SYS_WARE_STATUS_SRV);

		if (StringUtil.isBlank(wareUpDownPlanId)) {
			// ID为空，抛出异常
			throw new WareUpDownPlanJobException("任务唯一标识为空！");
		}
		// 1、利用ID读取上下线任务信息
		IWareUpDownPlanValue value = wareStatusDAO.getWareUpDownPlanValueById(Long.parseLong(wareUpDownPlanId));
		IWareUpDownPlanValue oldBean = new WareUpDownPlanBean();
		oldBean.copy(value);
		// 2、判断上下线任务的状态时否为未处理
		if (WareConstant.SYS_CORE_WARE_UP_DOWN_PLAN_STATUS_UNHANDLED.equals(value.getOpState())) {
			// 2.1 如果是未处理，将状态设置为取消状态
			value.setOpState(opState);
			wareStatusDAO.saveWareUpDownPlanValue(value);
			// 这里需要取消定时任务，只是任务中的一个礼品，需要获得任务所关联的礼品信息
			// 获取员工信息
			ISysStaffValue staff = wareStatusDAO.getSysStaffValue(String.valueOf(value.getOpRltId()));
			ISysStaffValue caneclStaff = wareStatusDAO.getSysStaffValue(String.valueOf(staffId));
			// 获取礼品信息
			IWareInfoValue wareInfo = ((IWareInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_WARE_INFO))
					.getBean(value.getWareId());
			if (WareConstant.SYS_CORE_WARE_UP_DOWN_PLAN_STATUS_AUTO_CANCELED.equals(opState) && staff != null) {
				if (!StringUtil.isBlank(staff.getBillId())) {
					MessageInter.doBusi(staff.getBillId(), WareStatusUtil.getPreSMSContent(wareInfo.getWareName(),
							"定时下线", "系统自动"));
				}
			} else if (WareConstant.SYS_CORE_WARE_UP_DOWN_PLAN_STATUS_MANUAL_CANCELED.equals(opState) && staff != null) {
				if ("0".equals(value.getOpType())) {// 定时上线
					if (!StringUtil.isBlank(staff.getBillId())) {
						MessageInter.doBusi(staff.getBillId(), WareStatusUtil.getPreSMSContent(wareInfo.getWareName(),
								"定时上线", caneclStaff.getStaffName()));
					}
					long busiId = BusiInfoUtil.recordBusiInfo(null, CoreConstant.SYS_PARA_BUSI_TYPE_WARE_PREONLINE, -1,
							"礼品定时上线取消", CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY, "礼品名：" + wareInfo.getWareName()
									+ "  礼品编号：" + wareInfo.getWareCode(), staffId, comType, orgId);
					BusiInfoUtil.recordBusiDetail(busiId + "", new Object[] { oldBean }, new Object[] { value },
							"WareId" + CoreConstant.BUSI_DETAIL_SPLIT + "OpState");
				} else if ("1".equals(value.getOpType())) {// 定时下线
					if (!StringUtil.isBlank(staff.getBillId())) {
						MessageInter.doBusi(staff.getBillId(), WareStatusUtil.getPreSMSContent(wareInfo.getWareName(),
								"定时下线", caneclStaff.getStaffName()));
					}
					long busiId = BusiInfoUtil.recordBusiInfo(null, CoreConstant.SYS_PARA_BUSI_TYPE_WARE_PREDOWNLINE,
							-1, "礼品定时下线取消", CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY, "礼品名：" + wareInfo.getWareName()
									+ "  礼品编号：" + wareInfo.getWareCode(), staffId, comType, orgId);
					BusiInfoUtil.recordBusiDetail(busiId + "", new Object[] { oldBean }, new Object[] { value },
							"WareId" + CoreConstant.BUSI_DETAIL_SPLIT + "OpState");
				} else {
					//throw new WareUpDownPlanJobException("the job which id is " + wareUpDownPlanId
							//+ " opType can not be known :" + value.getOpType());
					log.error("the job which id is " + wareUpDownPlanId + " opType can not be known :" + value.getOpType());
					throw new WareUpDownPlanJobException("任务不能被识别！");
				}
			} else {
				//throw new WareUpDownPlanJobException("the job which id is " +wareUpDownPlanId +" opState can not be known :" + opState);
				log.error("the job which id is " +wareUpDownPlanId +" opState can not be known :" + opState);
				throw new WareUpDownPlanJobException("任务不能被识别！");
			}
		}else{
			//2.2 如果是正在处理或者已处理，抛出异常信息
			throw new WareUpDownPlanJobException("该任务正在处理或者已处理，定时状态已发生改变，请重新查看。");
		}
	}

	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.ware.service.interfaces.IWareStatusSrv#getWareUpDownVersion(java.lang.String)
	 */
	public IWareUpDownVersionValue getWareUpDownVersion(String wareId) throws Exception {
		
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		IWareUpDownVersionValue retValue = null;
		if(!StringUtil.isBlank(wareId)){
			//如果wareId不为空
			condition.append(" and ").append(IWareUpDownVersionValue.S_WareId).append("=:").append(IWareUpDownVersionValue.S_WareId);
			
			parameter.put(IWareUpDownVersionValue.S_WareId, wareId);
		}else{
			//如果wareId为空,new 一个空的抛出异常
			throw new WareUpDownPlanJobException("");
			//retValue = new WareUpDownVersionBean();
		}
		IWareUpDownVersionValue[] values = wareStatusDAO.getWareUpDownVersionValue(condition.toString(), parameter);
		
		if(null != values && values.length > 0){
			//有数据
			retValue = values[0];
		}
		return retValue;

	}

	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.ware.service.interfaces.IWareStatusSrv#saveWareUpDownVersion(ngves.asiainfo.core.ware.ivalues.IWareUpDownVersionValue)
	 */
	public void saveWareUpDownVersion(String wareId,String wareStatus) throws Exception {
		
		IWareUpDownVersionValue value =  new WareUpDownVersionBean();
		value.setStsToNew();
		value.setWareId(Long.parseLong(wareId));
		value.setWareStatus(wareStatus);
		//app_version 初始值为0 还是空
		
		System.out.println(wareId);
		System.out.println(wareStatus);
		
		wareStatusDAO.saveWareUpDownVersionValue(value);

	}

	public void updateWareUpDownVersion(IWareUpDownVersionValue value) throws Exception {
		// TODO Auto-generated method stub
		value.setStsToOld();
		
		value.setWareStatus(value.getWareStatus());
		//value.setAppVersion(value.getAppVersion());
		
		wareStatusDAO.saveWareUpDownVersionValue(value);
	}

	public void saveWareUpDownHis(String wareId, String statusOperate, String statusCause, String note,String ruleId,String operater,String updownCause) throws Exception {
		IWareUpDownHisValue updown = new WareUpDownHisBean();
		updown.setStsToNew();
		//新纪录	 不存在旧的记录
		updown.setWareUpdownHisId(WareUpDownHisEngine.getNewId().longValue());
		//礼品ID
		updown.setWareId(Long.valueOf(wareId));
		//操作类型
		updown.setOperateType(statusOperate);
		//上下线备注
		updown.setNote(note);
		//上下线原因
		if(!StringUtil.isBlank(statusCause)){
			if("人工上线".equals(statusCause)){
				updown.setCause("实时上线");
			}else if("人工下线".equals(statusCause)){
				updown.setCause("实时下线");
			}else{
				updown.setCause(statusCause);
			}
		}
		//上下线时间
		updown.setUpdownTime(DateTimeUtil.getNowTimeStamp());
		//操作人
		updown.setOperater(operater);
		//上下线所选择的原因
		updown.setUpdownCause(updownCause);
		
		if(!StringUtil.isBlank(ruleId)){
			updown.setBakCol1(ruleId);
		}
		//保存礼品上下线历史记录
		wareStatusDAO.saveWareUpDownHisValue(updown);

	}

	public IWareUpDownPlanValue getWareUpDownPlanValueById(String planId) throws Exception {
		
		IWareUpDownPlanValue wareUpDownPlanValue = null;
		if(!StringUtil.isBlank(planId)){
			wareUpDownPlanValue = wareStatusDAO.getWareUpDownPlanValueById(Long.parseLong(planId));
		}
		//如果ID为空 返回空值？
		return wareUpDownPlanValue;
	}

	public void saveWareUpDownPlan(IWareUpDownPlanValue value) throws Exception {
		wareStatusDAO.saveWareUpDownPlanValue(value);		
	}


}
