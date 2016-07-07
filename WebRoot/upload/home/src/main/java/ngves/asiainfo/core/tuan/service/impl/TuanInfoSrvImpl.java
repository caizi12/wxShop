package ngves.asiainfo.core.tuan.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.common.bo.BusiInfoEngine;
import ngves.asiainfo.core.common.util.BusiInfoUtil;
import ngves.asiainfo.core.tuan.TuanConstant;
import ngves.asiainfo.core.tuan.bo.QBOComingSoonBean;
import ngves.asiainfo.core.tuan.bo.QBOReviewBean;
import ngves.asiainfo.core.tuan.bo.QBOTodayCommendBean;
import ngves.asiainfo.core.tuan.bo.TuanInfoBean;
import ngves.asiainfo.core.tuan.bo.TuanInfoEngine;
import ngves.asiainfo.core.tuan.bo.TuanWareRLTBean;
import ngves.asiainfo.core.tuan.dao.interfaces.ITuanInfoDAO;
import ngves.asiainfo.core.tuan.dao.interfaces.ITuanProvinceDAO;
import ngves.asiainfo.core.tuan.exception.MgtTuanException;
import ngves.asiainfo.core.tuan.ivalues.IQBOComingSoonValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOReviewValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOTodayCommendValue;
import ngves.asiainfo.core.tuan.ivalues.ITuanCycleInfoValue;
import ngves.asiainfo.core.tuan.ivalues.ITuanInfoValue;
import ngves.asiainfo.core.tuan.ivalues.ITuanProvinceValue;
import ngves.asiainfo.core.tuan.ivalues.ITuanWareRLTValue;
import ngves.asiainfo.core.tuan.model.PageBean;
import ngves.asiainfo.core.tuan.model.TuanInfoValueToHP;
import ngves.asiainfo.core.tuan.service.interfaces.ITuanCycleInfoSrv;
import ngves.asiainfo.core.tuan.service.interfaces.ITuanInfoSrv;
import ngves.asiainfo.core.tuan.service.interfaces.ITuanWareRLTSrv;
import ngves.asiainfo.core.tuan.util.TuanInfoUtil;
import ngves.asiainfo.core.ware.ivalues.IWareInfoValue;
import ngves.asiainfo.core.ware.service.interfaces.IWareInfoSrv;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;

public class TuanInfoSrvImpl implements ITuanInfoSrv {
	private Log log = LogFactory.getLog(TuanInfoSrvImpl.class);

	private ITuanInfoDAO tuanInfoDAO;
	private ITuanProvinceDAO tuanProvinceDAO;

	public void setTuanInfoDAO(ITuanInfoDAO tuanInfoDAO) throws Exception {
		this.tuanInfoDAO = tuanInfoDAO;
	}

	public void setTuanProvinceDAO(ITuanProvinceDAO tuanProvinceDAO) throws Exception {
		this.tuanProvinceDAO = tuanProvinceDAO;
	}
	

	public ITuanInfoValue[] queryTuanInfo(String tuanName, int startIndex, int endIndex) throws Exception {
		ITuanInfoValue[]  values =  tuanInfoDAO.queryTuanInfo(tuanName, startIndex, endIndex);
		return fillTuanInfoHTMLOperationField(values);
	}

	protected ITuanInfoValue[] fillTuanInfoHTMLOperationField(ITuanInfoValue[] values) throws Exception{

		//如果有数据
		if(null != values && values.length > 0 ){
			StringBuffer operationHtml = new StringBuffer();;
			
			final String VIEW_TUAN_INFO_LINK = "<a href=\"#\" onclick=\"viewTuanInfo(%s)\" >活动查看</a>&nbsp;&nbsp;";
			final String MODIFY_TUAN_INFO_LINK = "<a href=\"#\" onclick=\"modifyTuanInfo(%s)\" >活动修改</a>&nbsp;&nbsp;";
			final String BIND_WARE_TUAN_INFO_LINK = "<a href=\"#\" onclick=\"wareBind(%s)\" >绑定礼品</a>&nbsp;&nbsp;";
			//礼品查看的链接
			final String VIEW_WARE_TUAN_INFO_LINK = "<a href=\"#\" onclick=\"wareCheck(%s)\" >礼品查看</a>&nbsp;&nbsp;";
			
			final String IS_VIEW_TUAN_INFO_LINK = "<a data-isView='%s' href='#' onclick='setVisible(this, %s);return false;'>%s</a>&nbsp;&nbsp";
			//final String IS_VIEW_NO_TUAN_INFO_LINK = "<a href=\"#\" onclick=\"setVisible(%s)\" >在商城不显示</a>&nbsp;&nbsp;";
			//final String IS_VIEW_YES_TUAN_INFO_LINK = "<a href=\"#\" onclick=\"setVisible(%s)\" >在商场显示</a>&nbsp;&nbsp;";

			final String ORDER_LIST_TUAN_INFO_LINK = "<a href=\"#\" onclick=\"checkOrder(%s)\" >团购名单</a>&nbsp;&nbsp;";
			final String STOP_TUAN_INFO_LINK = "<a href=\"#\" onclick=\"stopTuan(%s)\" >活动停止</a>&nbsp;&nbsp;";
			
			long tuanId = 0L;
			//遍历整个数组集合
			for(int i=0;i<values.length;i++){
				tuanId = values[i].getTuanId() ;
				
				String isView  = values[i].getIsView();
				//如果团购活动的状态是前台不显示，那么链接上应该写“在商场显示”
				String label = !TuanConstant.TUAN_IS_VIEW_YES.equals(isView)?"在商城显示":"在商城不显示";
					
				if(TuanConstant.TUAN_STATUS_CREATE.equals(values[i].getStatus())){
					//1、活动创建
					//活动查看/活动修改/绑定礼品/在商城不显示
					operationHtml
					.append(String.format(VIEW_TUAN_INFO_LINK,String.valueOf(tuanId)))
					.append(String.format(MODIFY_TUAN_INFO_LINK, String.valueOf(tuanId)))
					.append(String.format(BIND_WARE_TUAN_INFO_LINK, String.valueOf(tuanId)))
					.append(String.format(IS_VIEW_TUAN_INFO_LINK, isView,tuanId,label));

				}else if(TuanConstant.TUAN_STATUS_PUBLISH.equals(values[i].getStatus())){
					//2、活动发布
						
						if(DateTimeUtil.getDefaultSysDate().before(values[i].getStartTime())){
							//a 活动未开始
							//活动查看/活动修改/绑定礼品/在商城不显示
							operationHtml
							.append(String.format(VIEW_TUAN_INFO_LINK,String.valueOf(tuanId)))
							.append(String.format(MODIFY_TUAN_INFO_LINK, String.valueOf(tuanId)))
							.append(String.format(BIND_WARE_TUAN_INFO_LINK, String.valueOf(tuanId)))
							.append(String.format(IS_VIEW_TUAN_INFO_LINK, isView,tuanId,label));

						}else if(DateTimeUtil.getDefaultSysDate().after(values[i].getStartTime()) 
								&& DateTimeUtil.getDefaultSysDate().before(values[i].getEndTime())){
							//b 活动进行中
							//活动查看/活动修改/礼品查看/在商城不显示/团购名单/活动停止
							operationHtml
							.append(String.format(VIEW_TUAN_INFO_LINK,String.valueOf(tuanId)))
							.append(String.format(MODIFY_TUAN_INFO_LINK, String.valueOf(tuanId)))
							// 礼品查看的链接应该修正
							.append(String.format(VIEW_WARE_TUAN_INFO_LINK, String.valueOf(tuanId)))
							.append(String.format(IS_VIEW_TUAN_INFO_LINK, isView,tuanId,label))
							.append(String.format(ORDER_LIST_TUAN_INFO_LINK, String.valueOf(tuanId)))
							.append(String.format(STOP_TUAN_INFO_LINK, String.valueOf(tuanId)));
							
						}else if(DateTimeUtil.getDefaultSysDate().after(values[i].getEndTime())){
							//c 活动已经结束
							//活动查看/礼品查看/在商城不显示/团购名单
							operationHtml
							.append(String.format(VIEW_TUAN_INFO_LINK,String.valueOf(tuanId)))
							.append(String.format(VIEW_WARE_TUAN_INFO_LINK, String.valueOf(tuanId)))
							.append(String.format(IS_VIEW_TUAN_INFO_LINK, isView,tuanId,label))
							.append(String.format(ORDER_LIST_TUAN_INFO_LINK, String.valueOf(tuanId)));
						}else{
							throw new MgtTuanException("indeterminated  tuan begin time and end time ,please check it from tuan_info table.");
						}
				}else if(TuanConstant.TUAN_STATUS_STOP.equals(values[i].getStatus())){
					//3、活动停止
					//活动查看/礼品查看/在商城不显示/团购名单
					operationHtml
					.append(String.format(VIEW_TUAN_INFO_LINK,String.valueOf(tuanId)))
					.append(String.format(VIEW_WARE_TUAN_INFO_LINK, String.valueOf(tuanId)))
					.append(String.format(IS_VIEW_TUAN_INFO_LINK, isView,tuanId,label))
					.append(String.format(ORDER_LIST_TUAN_INFO_LINK, String.valueOf(tuanId)));
				}else{
					throw new MgtTuanException("indeterminated  tuan status ,please check it from tuan_info table.");
				}
				
				values[i].setBakCol(operationHtml.toString());
				operationHtml = new StringBuffer();
			}
		}
		
		return values;
	}
	public int queryTuanInfoCount(String tuanName) {
		return tuanInfoDAO.queryTuanInfoCount(tuanName);
	}

	public ITuanInfoValue getTuanInfoById(String tuanId) throws Exception {
		return tuanInfoDAO.queryTuanById(tuanId);
	}
	
	
	/**
	 * 获得当前团购礼品对应的库存信息
	 */
	public long getTuanHouseWareCount(String tuanId,String wareId) throws Exception {
		return tuanInfoDAO.getTuanHouseWareCount(tuanId, wareId);
	}
	/**
	 * 这个函数的实现已经被移动到TuanProvinceDAO
	 */
	public ITuanProvinceValue[] getTuanProvinceInfoByTuanId(String tuanId) throws Exception {
		return tuanProvinceDAO.queryTuanProvinceById(tuanId);
	}

	public long saveTuanInfo(ITuanInfoValue value, String province, String provinceCheck,long staffId) throws Exception {
		// 如果是新增团购活动，生成团购ID，并将团购活动中涉及的不生效省份信息都添加到数据库中
		long tuanId = 0L;
		if (value.isNew()) {
			tuanId = TuanInfoEngine.getNewId().longValue();
			value.setTuanId(tuanId);
			value.setStatus(TuanConstant.TUAN_STATUS_CREATE);
			//如果单人购买上限没有填写，而总购买上限填写，那么单人购买上限 = 总购买上限	
			if (0 == value.getOneMaxCount()) {
				if(0 != value.getMaxCount()){
					value.setOneMaxCount(value.getMaxCount());
				}else{
					// 单人购买上限，如果不填写，默认是99999999
					value.setOneMaxCount(TuanConstant.TUAN_MAX_AMOUT_SINGLE_BUY);
				}
			}
			// 总购买上限，如果不填写，默认是99999999
			if (0 == value.getMaxCount()) {
				value.setMaxCount(TuanConstant.TUAN_MAX_AMOUNT_BUY);
			}
			// 创建时间
			value.setCreateDate(DateTimeUtil.getNowTimeStamp());
			value.setTopFlag(TuanConstant.DFAULT_TOP_FLAG);
			//URL 地址由后面的发布按钮时生成，这里填写空数值。
			// URL地址
			//value.setUrl(genTuanUrl(value.getTuanId() + ""));
			value.setUrl("  ");
			value.setRecordStaff(staffId + "");
			value.setStsToNew();
		}
		// 如果省份信息选择时，选择支持所有省份，就不向省份信息表中添加数据
		// 如果选择不支持所有省份，就要将不支持次团购的省份信息记录到数据表中
		if (TuanConstant.TUAN_IS_ALL_PROV_NO.equals(value.getIsAllProv())) {
			// log.info("不支持所有省份,将团购活动对应的省份信息添加到数据表"
			ITuanProvinceValue[] proviceValue = TuanInfoUtil.getTuanProvince(value.getTuanId() + "", province,
					provinceCheck);
			tuanProvinceDAO.addTuanProvince(proviceValue);
		}
		//新增团购的时候，不涉及任何同步HP操作。因为这时候，团购还没有发布。
		tuanId = tuanInfoDAO.saveTuanInfo(value);
		// log.info("经过DAO后的ID为"+tuanId);
		return tuanId;
	}

	public void setVisible(String tuanId, String visible) throws Exception {
		if (StringUtil.isBlank(tuanId) || StringUtil.isBlank(visible)) {
			throw new Exception("invalid tuan http parameter!");
		}
		ITuanInfoValue activity = tuanInfoDAO.queryTuanById(tuanId);
		activity.setStsToOld();
		if (visible.equals(CoreConstant.IS_VIEW_TRUE)) {
			activity.setIsView(CoreConstant.IS_VIEW_FALSE);
		} else {
			activity.setIsView(CoreConstant.IS_VIEW_TRUE);
		}
		tuanInfoDAO.saveTuanInfo(activity);// 复用lyq的代码
	}
	
	public void setVisible(String tuanId, String visible,long staffId, String comType,long orgId) throws Exception{
	    if (StringUtil.isBlank(tuanId) || StringUtil.isBlank(visible)) {
            throw new Exception("invalid tuan http parameter!");
        }
        ITuanInfoValue activity = tuanInfoDAO.queryTuanById(tuanId);
        activity.setStsToOld();
        ITuanInfoValue oldBean = new TuanInfoBean();
        oldBean.copy(activity);
        
        if (visible.equals(CoreConstant.IS_VIEW_TRUE)) {
            activity.setIsView(CoreConstant.IS_VIEW_FALSE);
        } else {
            activity.setIsView(CoreConstant.IS_VIEW_TRUE);
        }
        tuanInfoDAO.saveTuanInfo(activity);// 复用lyq的代码
        long busiInfoId = BusiInfoEngine.getNewId().longValue();
        BusiInfoUtil.recordBusiInfo(busiInfoId + "", CoreConstant.SYS_PARA_BUSI_TYPE_TUAN_MODIFY, -1,
                "是否显示团购活动",CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,"团购ID："+activity.getTuanId()+"；团购名称："+oldBean.getName(),staffId,comType,orgId);
        BusiInfoUtil.recordBusiDetail(busiInfoId + "", new Object[]{oldBean}, new Object[]{activity}, "TuanId");
	}

	public String stopTuan(String tuanId) throws Exception {
		if (StringUtil.isBlank(tuanId)) {
			throw new Exception("invalid tuan http parameter!");
		}
		ITuanInfoValue activity = tuanInfoDAO.queryTuanById(tuanId);
		//hp报文返回信息
		String message = null;
		//调hp接口停止团购活动，成功继续，失败返回错误信息
		//先得到当前时间
		Timestamp currTimestamp = DateTimeUtil.getDefaultSysDate();
		//创建报文对象
		TuanInfoValueToHP value = new TuanInfoValueToHP();
		
		//团购信息表:最大团购量  无限制：-1
		int maxParticNum = -1;
		maxParticNum = (int) (activity.getMaxCount() == TuanConstant.TUAN_MAX_AMOUNT_BUY?-1:activity.getMaxCount());
		value.setMaxParticNum(maxParticNum);
		//团购信息表:单人最大上限 无限制：-1
		int maxItemNum = -1;
		maxItemNum = (int) (activity.getOneMaxCount() == TuanConstant.TUAN_MAX_AMOUT_SINGLE_BUY?-1:activity.getOneMaxCount());
		value.setMaxItemNum(maxItemNum);

		//填写报文信息
		value.setOptType(TuanConstant.TUAN_INFO_SYN_HP_TUAN_OPT_TYPE_MODIFY);
		value.setActionID(TuanConstant.TUAN_INFO_SYN_HP_TUAN_ID_PREFIX+tuanId);
		value.setActionName(activity.getName());
		value.setOptOrderType(TuanConstant.TUAN_INFO_SYN_HP_TUAN_OPT_ORDER_TYPE_DEFAULT);
		value.setActionStartTime(TuanInfoUtil.convertTimestampToStr(activity.getStartTime()));
		value.setActionEndTime(TuanInfoUtil.convertTimestampToStr(currTimestamp));
		value.setMinParticNum(Long.valueOf(activity.getMinCount()).intValue());
		//value.setMaxParticNum(Long.valueOf(activity.getMaxCount()).intValue());
		//value.setMaxItemNum(Long.valueOf(activity.getOneMaxCount()).intValue());
		//利用礼品ID 读取礼品编码
		ITuanWareRLTSrv tuanWareRltSrv = (ITuanWareRLTSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_TUANWARERLT_SRV);
		ITuanWareRLTValue tuanWareRlt = tuanWareRltSrv.getTuanWareRLTById(tuanId);
		IWareInfoSrv wareInfoSrv = (IWareInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_WARE_INFO);
		IWareInfoValue wareValue  = wareInfoSrv.getBean(tuanWareRlt.getWareId());
		value.setItemID(wareValue.getWareCode());
		//发送hp报文
		try {
			message = TuanInfoUtil.synchronousTuanInfoToHP(value);
		} catch (Exception e) {
			return CoreConstant.SYS_MSG_TUAN_INFO_SYN_HP_UPDATE_ERR;
		}
		log.debug("------return message-----"+message+"-------------------------------");
		if(message.trim().equalsIgnoreCase(TuanConstant.TUAN_INFO_SYN_HP_SUCC)){
			activity.setStsToOld();
			activity.setEndTime(currTimestamp);
			activity.setStatus(TuanConstant.TUAN_INFO_STATUS_STOP);
			// 复用lyq的代码
			try {
				tuanInfoDAO.saveTuanInfo(activity);
			} catch (Exception e) {
				log.debug("stop tuan info failed in saving !!! "+e);
				return TuanConstant.TUAN_INFO_MODIFY_FAILURE;
			}
			return TuanConstant.TUAN_INFO_MODIFY_SUCCESS;
		}else if(TuanConstant.TUAN_INFO_SYN_HP_UPDATE_ERR.equals(message)){
				return CoreConstant.SYS_MSG_TUAN_INFO_SYN_HP_UPDATE_ERR;
		}else if(TuanConstant.TUAN_INFO_SYN_HP_OTHER_ERR.equals(message)){
				return CoreConstant.SYS_MSG_TUAN_INFO_SYN_HP_OTHER_ERR;
		}else if(TuanConstant.TUAN_INFO_SYN_HP_NEW_ENDTIME_BEFORE_STARTTIME.equals(message)){
				return CoreConstant.SYS_MSG_TUAN_INFO_SYN_HP_NEW_ENDTIME_BEFORE_STARTTIME;
		}else if(TuanConstant.TUAN_INFO_SYN_HP_NEW_STARTTIME_AFTER_CURRTIME.equals(message)){
				return CoreConstant.SYS_MSG_TUAN_INFO_SYN_HP_NEW_STARTTIME_AFTER_CURRTIME;
		}else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_FINISHED.equals(message)){
				return CoreConstant.SYS_MSG_TUAN_INFO_SYN_HP_TUAN_FINISHED;
		}else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_STARTED_MODIFY_LIMITED.equals(message)){
				return CoreConstant.SYS_MSG_TUAN_INFO_SYN_HP_TUAN_STARTED_MODIFY_LIMITED;
		}else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_STARTED_DELETE_LIMITED.equals(message)){
				return CoreConstant.SYS_MSG_TUAN_INFO_SYN_HP_TUAN_STARTED_DELETE_LIMITED;
		}else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_NO_WAREID.equals(message)){
				return CoreConstant.SYS_MSG_TUAN_INFO_SYN_HP_TUAN_NO_WAREID;
		}else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_NO_TUANID.equals(message)){
				return CoreConstant.SYS_MSG_TUAN_INFO_SYN_HP_TUAN_NO_TUANID;
		}else{
				return CoreConstant.SYS_MSG_TUAN_INFO_SYN_HP_UPDATE_ERR;
		}
		
		
		

	}
	//停止团购活动时增加日志记录
	public String stopTuan(String tuanId, long staffId, String comType, long orgId) throws Exception {
        if (StringUtil.isBlank(tuanId)) {
            throw new Exception("invalid tuan http parameter!");
        }
        ITuanInfoValue activity = tuanInfoDAO.queryTuanById(tuanId);
        
        ITuanInfoValue oldBean = new TuanInfoBean();
        oldBean.copy(activity);
        //hp报文返回信息
        String message = null;
        //调hp接口停止团购活动，成功继续，失败返回错误信息
        //先得到当前时间
        Timestamp currTimestamp = DateTimeUtil.getDefaultSysDate();
        //创建报文对象
        TuanInfoValueToHP value = new TuanInfoValueToHP();
        
        //团购信息表:最大团购量  无限制：-1
        int maxParticNum = -1;
        maxParticNum = (int) (activity.getMaxCount() == TuanConstant.TUAN_MAX_AMOUNT_BUY?-1:activity.getMaxCount());
        value.setMaxParticNum(maxParticNum);
        //团购信息表:单人最大上限 无限制：-1
        int maxItemNum = -1;
        maxItemNum = (int) (activity.getOneMaxCount() == TuanConstant.TUAN_MAX_AMOUT_SINGLE_BUY?-1:activity.getOneMaxCount());
        value.setMaxItemNum(maxItemNum);

        //填写报文信息
        value.setOptType(TuanConstant.TUAN_INFO_SYN_HP_TUAN_OPT_TYPE_MODIFY);
        value.setActionID(TuanConstant.TUAN_INFO_SYN_HP_TUAN_ID_PREFIX+tuanId);
        value.setActionName(activity.getName());
        value.setOptOrderType(TuanConstant.TUAN_INFO_SYN_HP_TUAN_OPT_ORDER_TYPE_DEFAULT);
        value.setActionStartTime(TuanInfoUtil.convertTimestampToStr(activity.getStartTime()));
        value.setActionEndTime(TuanInfoUtil.convertTimestampToStr(currTimestamp));
        value.setMinParticNum(Long.valueOf(activity.getMinCount()).intValue());
        //value.setMaxParticNum(Long.valueOf(activity.getMaxCount()).intValue());
        //value.setMaxItemNum(Long.valueOf(activity.getOneMaxCount()).intValue());
        //利用礼品ID 读取礼品编码
        ITuanWareRLTSrv tuanWareRltSrv = (ITuanWareRLTSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_TUANWARERLT_SRV);
        ITuanWareRLTValue tuanWareRlt = tuanWareRltSrv.getTuanWareRLTById(tuanId);
        IWareInfoSrv wareInfoSrv = (IWareInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_WARE_INFO);
        IWareInfoValue wareValue  = wareInfoSrv.getBean(tuanWareRlt.getWareId());
        value.setItemID(wareValue.getWareCode());
        //发送hp报文
        try {
            message = TuanInfoUtil.synchronousTuanInfoToHP(value);
        } catch (Exception e) {
            return CoreConstant.SYS_MSG_TUAN_INFO_SYN_HP_UPDATE_ERR;
        }
        log.debug("------return message-----"+message+"-------------------------------");
        if(message.trim().equalsIgnoreCase(TuanConstant.TUAN_INFO_SYN_HP_SUCC)){
            activity.setStsToOld();
            activity.setEndTime(currTimestamp);
            activity.setStatus(TuanConstant.TUAN_INFO_STATUS_STOP);
            
            long busiInfoId = BusiInfoEngine.getNewId().longValue();
            BusiInfoUtil.recordBusiInfo(busiInfoId + "", CoreConstant.SYS_PARA_BUSI_TYPE_TUAN_MODIFY, -1,
                   "停止团购活动",CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,"团购ID："+activity.getTuanId()+"；团购名称："+oldBean.getName(),staffId,comType,orgId);
            BusiInfoUtil.recordBusiDetail(busiInfoId + "", new Object[]{oldBean}, new Object[]{activity}, "TuanId");
            // 复用lyq的代码
            try {
                tuanInfoDAO.saveTuanInfo(activity);
            } catch (Exception e) {
                log.debug("stop tuan info failed in saving !!! "+e);
                return TuanConstant.TUAN_INFO_MODIFY_FAILURE;
            }
            return TuanConstant.TUAN_INFO_MODIFY_SUCCESS;
        }else if(TuanConstant.TUAN_INFO_SYN_HP_UPDATE_ERR.equals(message)){
                return CoreConstant.SYS_MSG_TUAN_INFO_SYN_HP_UPDATE_ERR;
        }else if(TuanConstant.TUAN_INFO_SYN_HP_OTHER_ERR.equals(message)){
                return CoreConstant.SYS_MSG_TUAN_INFO_SYN_HP_OTHER_ERR;
        }else if(TuanConstant.TUAN_INFO_SYN_HP_NEW_ENDTIME_BEFORE_STARTTIME.equals(message)){
                return CoreConstant.SYS_MSG_TUAN_INFO_SYN_HP_NEW_ENDTIME_BEFORE_STARTTIME;
        }else if(TuanConstant.TUAN_INFO_SYN_HP_NEW_STARTTIME_AFTER_CURRTIME.equals(message)){
                return CoreConstant.SYS_MSG_TUAN_INFO_SYN_HP_NEW_STARTTIME_AFTER_CURRTIME;
        }else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_FINISHED.equals(message)){
                return CoreConstant.SYS_MSG_TUAN_INFO_SYN_HP_TUAN_FINISHED;
        }else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_STARTED_MODIFY_LIMITED.equals(message)){
                return CoreConstant.SYS_MSG_TUAN_INFO_SYN_HP_TUAN_STARTED_MODIFY_LIMITED;
        }else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_STARTED_DELETE_LIMITED.equals(message)){
                return CoreConstant.SYS_MSG_TUAN_INFO_SYN_HP_TUAN_STARTED_DELETE_LIMITED;
        }else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_NO_WAREID.equals(message)){
                return CoreConstant.SYS_MSG_TUAN_INFO_SYN_HP_TUAN_NO_WAREID;
        }else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_NO_TUANID.equals(message)){
                return CoreConstant.SYS_MSG_TUAN_INFO_SYN_HP_TUAN_NO_TUANID;
        }else{
                return CoreConstant.SYS_MSG_TUAN_INFO_SYN_HP_UPDATE_ERR;
        }
    }

	public String isNameConflict(String tuanName) throws Exception {
		boolean isExistName = false;
		String retVal = "";
		isExistName = tuanInfoDAO.isExistSameName(tuanName);
		if (false == isExistName) {
			retVal = TuanConstant.TUAN_NAME_CONFLICT_NO;
		} else {
			retVal = TuanConstant.TUAN_NAME_CONFLICT_YES;
		}
		return retVal;
	}

	public int countTuanUserLog(String tuanId) throws Exception {
		return 0;
	}

	public IQBOTodayCommendValue[] getTodayCommend(int startNum, int endNum) throws Exception {
		return tuanInfoDAO.getTodayCommend(startNum, endNum);
	}

	public IQBOComingSoonValue[] getComingSoon(int startNum, int endNum) throws Exception {
		return tuanInfoDAO.getComingSoon(startNum, endNum);
	}

	public IQBOReviewValue[] getReview(int startNum, int endNum) throws Exception {
		return tuanInfoDAO.getReview(startNum, endNum);
	}
	
	public ITuanInfoValue[] getTuanGroupInfo(String groupCode, int startNum, int endNum) throws Exception{
		// String topink = "<a href=\"#\" onclick=\"setTuanTop('id')\" >置顶</a>";
		ITuanInfoValue[] value = null;
		if(CoreConstant.ACTIVITY_TUAN_GROUP_TODATY_RECOMMEND.equals(groupCode)){
			IQBOTodayCommendValue[] tempValue = getTodayCommend(startNum, endNum);
			value = new TuanInfoBean[tempValue.length];
			if(tempValue.length <= 0)
				return value;
			for(int i=0; i<tempValue.length; i++){
				String topLink = null;
				TuanInfoBean bean = new TuanInfoBean();
				bean.setTuanId(tempValue[i].getTuanId());
				bean.setName(tempValue[i].getName());
				bean.setStartTime(tempValue[i].getStartTime());
				bean.setEndTime(tempValue[i].getEndTime());
				bean.setTopFlag(tempValue[i].getTopFlag());
				if(0 == tempValue[i].getTopFlag()){
					topLink = "<a href=\"#\" onclick=\"setTuanTop('"+tempValue[i].getTuanId()+
						"', '"+tempValue[i].getTopFlag()+"')\" >置顶</a>";
				} else {
					topLink = "<a href=\"#\" onclick=\"setTuanTop('"+tempValue[i].getTuanId()+
						"', '"+tempValue[i].getTopFlag()+"')\" >不置顶</a>";
				}
				bean.setBakCol(topLink);
				value[i] = bean;
			}
		} else if(CoreConstant.ACTIVITY_TUAN_GROUP_NEXT_ISSUE.equals(groupCode)){
			IQBOComingSoonValue[] tempValue = getComingSoon(startNum, endNum);
			value = new TuanInfoBean[tempValue.length];
			if(tempValue.length <= 0)
				return value;
			for(int i=0; i<tempValue.length; i++){
				String topLink = null;
				TuanInfoBean bean = new TuanInfoBean();
				bean.setTuanId(tempValue[i].getTuanId());
				bean.setName(tempValue[i].getName());
				bean.setStartTime(tempValue[i].getStartTime());
				bean.setEndTime(tempValue[i].getEndTime());
				bean.setTopFlag(tempValue[i].getTopFlag());
				if(0 == tempValue[i].getTopFlag()){
					topLink = "<a href=\"#\" onclick=\"setTuanTop('"+tempValue[i].getTuanId()+
						"', '"+tempValue[i].getTopFlag()+"')\" >置顶</a>";
				} else {
					topLink = "<a href=\"#\" onclick=\"setTuanTop('"+tempValue[i].getTuanId()+
						"', '"+tempValue[i].getTopFlag()+"')\" >不置顶</a>";
				}
				bean.setBakCol(topLink);
				value[i] = bean;
			}
		} else if(CoreConstant.ACTIVITY_TUAN_GROUP_OLD_TIMEY.equals(groupCode)){
			IQBOReviewValue[] tempValue = getReview(startNum, endNum);
			value = new TuanInfoBean[tempValue.length];
			if(tempValue.length <= 0)
				return value;
			for(int i=0; i<tempValue.length; i++){
				String topLink = null;
				TuanInfoBean bean = new TuanInfoBean();
				bean.setTuanId(tempValue[i].getTuanId());
				bean.setName(tempValue[i].getName());
				bean.setStartTime(tempValue[i].getStartTime());
				bean.setEndTime(tempValue[i].getEndTime());
				bean.setTopFlag(tempValue[i].getTopFlag());
				if(0 == tempValue[i].getTopFlag()){
					topLink = "<a href=\"#\" onclick=\"setTuanTop('"+tempValue[i].getTuanId()+
						"', '"+tempValue[i].getTopFlag()+"')\" >置顶</a>";
				} else {
					topLink = "<a href=\"#\" onclick=\"setTuanTop('"+tempValue[i].getTuanId()+
						"', '"+tempValue[i].getTopFlag()+"')\" >不置顶</a>";
				}
				bean.setBakCol(topLink);
				value[i] = bean;
			}
		}
		return value;
	}
	
	public int getTuanGroupInfoCount(String groupCode) throws Exception{
		return tuanInfoDAO.getTuanInfoCount(groupCode);
	}
	
	public void modifyTuanInfo(ITuanInfoValue value) throws Exception{
		tuanInfoDAO.saveTuanInfo(value);
	}
	
	public String getTuanProvinceInfoStrById(String tuanId) throws Exception {
		ITuanProvinceValue[] value = getTuanProvinceInfoByTuanId(tuanId);
		StringBuffer retValBuffer = new StringBuffer();
		String retVal = "";
		if (null != value && value.length != 0) {
			for (int i = 0; i < value.length; i++) {
				retValBuffer.append(value[i].getLimitProv()).append(TuanConstant.TUAN_PROVINCE_SPLIT_CODE);
			}
			// 取消最后面那个','分隔符
			retVal = retValBuffer.substring(0, retValBuffer.length() - 1);
			log.info(retVal);
		}
		return retVal;
	}

	public void updateTuanInfoToEnd(String tuanId) throws Exception {
		tuanInfoDAO.updateTuanInfoToEnd(tuanId);
	}

	/**
	 * 根据制订的团购Id生成 团购URL地址
	 * 
	 * @param tuanId
	 *            团购ID
	 * @return 团购ID对应积分前台的URI地址
	 * @author liuyq
	 * @date 2011-07-14
	 */
	@SuppressWarnings("unused")
	private String genTuanUrl(String tuanId) throws Exception {
		StringBuffer url = new StringBuffer();
		if (!StringUtil.isBlank(tuanId)) {
			url.append(TuanConstant.TUAN_PORTAL_URL).append("/").append(tuanId).append(".html");
		} else {
			url.append("http://jf.10086.cn").append("/").append("pageError.html");
		}
		return url.toString();
	}

	public long modifyTuanInfo(ITuanInfoValue value, String province, String provinceCheck,long staffId) throws Exception {
		// 如果是修改团购活动，将对应团购活动ID的省份信息删除 然后再将省份信息添加
		// 这里不做省份信息的更新操作。
		value.setStsToOld();
		long tuanId = value.getTuanId();
		
		value.setTuanId(value.getTuanId());
		value.setName(value.getName());
		value.setIsAllProv(value.getIsAllProv());
		value.setIsOrderMulti(value.getIsOrderMulti());
		value.setTitleDesc(value.getTitleDesc());
		// value.setUrl(value.getUrl());
		value.setOneMaxCount(value.getOneMaxCount());
		value.setMaxCount(value.getMaxCount());
		//如果单人购买上限没有填写，而总购买上限填写，那么单人购买上限 = 总购买上限	
		if (0 == value.getOneMaxCount()) {
			if(0 != value.getMaxCount()){
				value.setOneMaxCount(value.getMaxCount());
			}else{
				// 单人购买上限，如果不填写，默认是99999999
				value.setOneMaxCount(TuanConstant.TUAN_MAX_AMOUT_SINGLE_BUY);
			}
		}
		// 总购买上限，如果不填写，默认是99999999
		if (0 == value.getMaxCount()) {
			value.setMaxCount(TuanConstant.TUAN_MAX_AMOUNT_BUY);
		}
		value.setIsView(value.getIsView());
		value.setMainPic(value.getMainPic());
		value.setMinCount(value.getMinCount());
		// value.setStatus(value.getStatus());
		value.setStartTime(value.getStartTime());
		value.setEndTime(value.getEndTime());
		value.setRecordStaff(staffId+ "");
		value.setTuanSort(value.getTuanSort());
		//从这里进行分割，如果需要将团购信息同步给HP，并且同步成功
		
		//如果团购ID不为空，且团购活动状态为发布状态，并且有可以同步给HP资料的更新
		long _tuanId = value.getTuanId();
		//不用比较团购活动绑定的礼品信息
		long _wareId = 0;
		String retVal = synTuanInfoToHP(_tuanId, _wareId, value);
		if(TuanConstant.TUAN_INFO_SYN_HP_SUCC.equals(retVal)){
			tuanProvinceDAO.deleteTuanProvinceById(tuanId + "");
			// 如果省份信息选择时，选择支持所有省份，就不向省份信息表中添加数据
			// 如果选择不支持所有省份，就要将不支持次团购的省份信息记录到数据表中
			if (TuanConstant.TUAN_IS_ALL_PROV_NO.equals(value.getIsAllProv())) {
				ITuanProvinceValue[] proviceValue = TuanInfoUtil.getTuanProvince(value.getTuanId() + "", province,
						provinceCheck);
				tuanProvinceDAO.addTuanProvince(proviceValue);
			}
			
			tuanInfoDAO.saveTuanInfo(value);
		}else{
			//同步出错 处理各种错误消息
			if(TuanConstant.TUAN_INFO_SYN_HP_UPDATE_ERR.equals(retVal)){
				value.setAppVersion(TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G702);
			}else if(TuanConstant.TUAN_INFO_SYN_HP_OTHER_ERR.equals(retVal)){
				value.setAppVersion(TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G703);
			}else if(TuanConstant.TUAN_INFO_SYN_HP_NEW_ENDTIME_BEFORE_STARTTIME.equals(retVal)){
				value.setAppVersion(TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G704);
			}else if(TuanConstant.TUAN_INFO_SYN_HP_NEW_STARTTIME_AFTER_CURRTIME.equals(retVal)){
				value.setAppVersion(TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G705);
			}else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_FINISHED.equals(retVal)){
				value.setAppVersion(TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G706);
			}else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_STARTED_MODIFY_LIMITED.equals(retVal)){
				value.setAppVersion(TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G707);
			}else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_STARTED_DELETE_LIMITED.equals(retVal)){
				value.setAppVersion(TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G708);
			}else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_NO_WAREID.equals(retVal)){
				value.setAppVersion(TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G709);
			}else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_NO_TUANID.equals(retVal)){
				value.setAppVersion(TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G710);
			}else{
				value.setAppVersion(TuanConstant.TUAN_RETVAL_SYN_HP_FAIL);
			}
		}
		return value.getAppVersion();
	}
	
	/**
     * 根据制订的团购Id生成 团购URL地址
     * 
     * @param tuanId 团购ID
     *               增加日志，传递用户登录信息    
     * @return 团购ID对应积分前台的URI地址
     * @author sxl
     * @date 2011-09-28
     */
	public long modifyTuanInfo(ITuanInfoValue value, String province, String provinceCheck,long staffId,long StaffId,String ComType,long OrgId) throws Exception {
        // 如果是修改团购活动，将对应团购活动ID的省份信息删除 然后再将省份信息添加
        // 这里不做省份信息的更新操作。
        value.setStsToOld();
        long tuanId = value.getTuanId();
        
        ITuanInfoValue oldValue = tuanInfoDAO.queryTuanById(String.valueOf(tuanId));
        ITuanInfoValue oldBean = new TuanInfoBean();
        oldBean.copy(oldValue);     
        
        value.setTuanId(value.getTuanId());
        value.setName(value.getName());
        value.setIsAllProv(value.getIsAllProv());
        value.setIsOrderMulti(value.getIsOrderMulti());
        value.setTitleDesc(value.getTitleDesc());
        // value.setUrl(value.getUrl());
        value.setOneMaxCount(value.getOneMaxCount());
        value.setMaxCount(value.getMaxCount());
        value.setPayType(value.getPayType());
        if(value.getPayTime()!=0){
        	value.setPayTime(value.getPayTime());
        }
        
        //如果单人购买上限没有填写，而总购买上限填写，那么单人购买上限 = 总购买上限    
        if (0 == value.getOneMaxCount()) {
            if(0 != value.getMaxCount()){
                value.setOneMaxCount(value.getMaxCount());
            }else{
                // 单人购买上限，如果不填写，默认是99999999
                value.setOneMaxCount(TuanConstant.TUAN_MAX_AMOUT_SINGLE_BUY);
            }
        }
        // 总购买上限，如果不填写，默认是99999999
        if (0 == value.getMaxCount()) {
            value.setMaxCount(TuanConstant.TUAN_MAX_AMOUNT_BUY);
        }
        // 如果不填写，默认是99999999
        if(0 == value.getTuanSort()){
        	value.setTuanSort(TuanConstant.TUAN_TUAN_SORT_SINGLE_BUY);
        }
        
        value.setIsView(value.getIsView());
        value.setMainPic(value.getMainPic());
        value.setMinCount(value.getMinCount());
        // value.setStatus(value.getStatus());
        value.setStartTime(value.getStartTime());
        value.setEndTime(value.getEndTime());
        value.setRecordStaff(staffId+ "");
        value.setTuanSort(value.getTuanSort());
        value.setTopFlag(oldValue.getTopFlag());
        //从这里进行分割，如果需要将团购信息同步给HP，并且同步成功
        
        //如果团购ID不为空，且团购活动状态为发布状态，并且有可以同步给HP资料的更新
        long _tuanId = value.getTuanId();
        //不用比较团购活动绑定的礼品信息
        long _wareId = 0;
        String retVal = synTuanInfoToHP(_tuanId, _wareId, value);
        if(TuanConstant.TUAN_INFO_SYN_HP_SUCC.equals(retVal)){
            tuanProvinceDAO.deleteTuanProvinceById(tuanId + "");
            // 如果省份信息选择时，选择支持所有省份，就不向省份信息表中添加数据
            // 如果选择不支持所有省份，就要将不支持次团购的省份信息记录到数据表中
            if (TuanConstant.TUAN_IS_ALL_PROV_NO.equals(value.getIsAllProv())) {
                ITuanProvinceValue[] proviceValue = TuanInfoUtil.getTuanProvince(value.getTuanId() + "", province,
                        provinceCheck);
                tuanProvinceDAO.addTuanProvince(proviceValue);
            }
            
            tuanInfoDAO.saveTuanInfo(value);
            long busiInfoId = BusiInfoEngine.getNewId().longValue();
            BusiInfoUtil.recordBusiInfo(busiInfoId + "", CoreConstant.SYS_PARA_BUSI_TYPE_TUAN_MODIFY, -1,
                    "修改团购活动",CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,"团购ID："+value.getTuanId()+"；团购名称："+oldBean.getName(),StaffId,ComType,OrgId);
            BusiInfoUtil.recordBusiDetail(busiInfoId + "", new Object[]{oldBean}, new Object[]{value}, "TuanId");
            
            
        }else{
            //同步出错 处理各种错误消息
            if(TuanConstant.TUAN_INFO_SYN_HP_UPDATE_ERR.equals(retVal)){
                value.setAppVersion(TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G702);
            }else if(TuanConstant.TUAN_INFO_SYN_HP_OTHER_ERR.equals(retVal)){
                value.setAppVersion(TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G703);
            }else if(TuanConstant.TUAN_INFO_SYN_HP_NEW_ENDTIME_BEFORE_STARTTIME.equals(retVal)){
                value.setAppVersion(TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G704);
            }else if(TuanConstant.TUAN_INFO_SYN_HP_NEW_STARTTIME_AFTER_CURRTIME.equals(retVal)){
                value.setAppVersion(TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G705);
            }else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_FINISHED.equals(retVal)){
                value.setAppVersion(TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G706);
            }else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_STARTED_MODIFY_LIMITED.equals(retVal)){
                value.setAppVersion(TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G707);
            }else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_STARTED_DELETE_LIMITED.equals(retVal)){
                value.setAppVersion(TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G708);
            }else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_NO_WAREID.equals(retVal)){
                value.setAppVersion(TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G709);
            }else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_NO_TUANID.equals(retVal)){
                value.setAppVersion(TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G710);
            }else{
                value.setAppVersion(TuanConstant.TUAN_RETVAL_SYN_HP_FAIL);
            }
        }
        return value.getAppVersion();
    }

	/**
	 * 得到已经开始的活动ID，加载内容到缓存
	 */
	public ITuanInfoValue[] getStartTuanIds() throws Exception {
		return tuanInfoDAO.getStartTuanIds();
	}

    public ITuanInfoValue[] getITuanInfoValues() throws Exception {
        return tuanInfoDAO.getITuanInfoValues();
    }
    
    /**
     * 将团购信息同步给HP
     * @param tuanId
     * @param wareId
     * @param value
     * @return  0000:同步成功  其他表示失败，这里不记录失败原因。
     * @throws Exception
     */
    private String synTuanInfoToHP(long tuanId,long wareId,ITuanInfoValue value) throws Exception{
    	String retVal = TuanConstant.TUAN_INFO_SYN_HP_SUCC;
    	boolean isNeedSyn = TuanInfoUtil.isNeedSynTuanInfoToHP(tuanId, wareId, value,"");
    	String optType ="";
		String optOrderType ="";
		ITuanWareRLTValue tuanWareRlt = new TuanWareRLTBean();
    	if(true == isNeedSyn){
    		tuanWareRlt.setTuanId(tuanId);
    		tuanWareRlt.setWareId(wareId);
    		//团购信息增量类型同步为修改
    		optType = TuanConstant.TUAN_INFO_SYN_HP_TUAN_OPT_TYPE_MODIFY;
    		//默认拆单方式
    		optOrderType = TuanConstant.TUAN_INFO_SYN_HP_TUAN_OPT_ORDER_TYPE_DEFAULT;
    		TuanInfoValueToHP tuanInfoValueToHP = TuanInfoUtil.convertTuanInfoValue(tuanWareRlt,value, optType, optOrderType);
    		retVal = TuanInfoUtil.synchronousTuanInfoToHP(tuanInfoValueToHP);
    	}
    	return retVal;
    }
    
    public IQBOTodayCommendValue[] getTodayTuan(String topFlag, int startNum, int endNum) throws Exception{
    	return tuanInfoDAO.getTodayTuan(topFlag, startNum, endNum);
    }
    
    public String getTuanTypeLog(String showtype)throws Exception{
    	String result="";
    	if(!StringUtil.isBlank(showtype)){
    		if(CoreConstant.ACTIVITY_TUAN_GROUP_MAINPAGE.equals(showtype)){
    			result =" indexTuan Activity ";
    		}else if(CoreConstant.ACTIVITY_TUAN_GROUP_TUANINFO.equals(showtype)){
    			result =" descTuan Activity ";
    		}else if(CoreConstant.ACTIVITY_TUAN_GROUP_TUANALL.equals(showtype)){
    			result =" collectTuan Activity ";
    		}else{}
    	}
    	return result;
    }

    //团购轮转信息步骤Part1 --今日推荐
	public IQBOTodayCommendValue[] getToUnionList(List<IQBOTodayCommendValue> topList,
			List<IQBOTodayCommendValue> cycleList,String showType) throws Exception {
		
		List<IQBOTodayCommendValue> unionList = new ArrayList<IQBOTodayCommendValue>();
		IQBOTodayCommendValue[] unionValue = null;
		
		cycleList = getToSpellTuanlist(cycleList,showType);
		if (topList != null && topList.size() > 0) {
			unionList.addAll(topList);
		}
		if (cycleList != null && cycleList.size() > 0) {
			unionList.addAll(cycleList);
		}
		unionValue = new QBOTodayCommendBean[unionList.size()];
		unionList.toArray(unionValue);
		return unionValue;
	}
	
	//团购轮转信息步骤Part2 --今日推荐
	public List<IQBOTodayCommendValue> getToSpellTuanlist(List<IQBOTodayCommendValue> cycleList, String showType) throws Exception{
		//3.获取轮转周期对象信息
		ITuanCycleInfoSrv cycleSrv = (ITuanCycleInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_TUANCYCLE_INFO);
		ITuanCycleInfoValue tuanCycle = cycleSrv.getTuanCycleInfo(showType , CoreConstant.ACTIVITY_TUAN_GROUP_TODATY_RECOMMEND);
		int cycleCount = cycleList.size();
		/**
		 *1. 如果存在轮转礼品并且当前轮转状态为“开”，那么根据轮转算法重新整合cycleList数据。 
		 *2. 满足第一步，重新获取轮转数据的开始和结果索引位置.
		 *3. 根据开始和结果索引获取对应整合后数据.
		 */
		if (tuanCycle.getIsSpell() == 1 && cycleCount > 0) {

			PageBean pageBean = TuanInfoUtil.getSpellIndex((int) tuanCycle.getSpellInternalLength(),
					tuanCycle.getSpellSatrtTime(), cycleCount, cycleCount);
			
			log.info("The method getToSpellTuanlist() showType="+getTuanTypeLog(showType)+",isSpell=" + tuanCycle.getIsSpell() + ",startIndex = "
					+ (pageBean.getStartNum() - 1) + ",endIndex=" + (pageBean.getEndNum() - 1));

			if (0 <= pageBean.getStartNum() - 1 && pageBean.getEndNum() - 1 <= cycleCount 
					&& pageBean.getStartNum() - 1 <= pageBean.getEndNum() - 1) {
				// 整合后结果列表
				List<IQBOTodayCommendValue> resultList = new ArrayList<IQBOTodayCommendValue>();
				List<IQBOTodayCommendValue> beforeList = cycleList.subList(0, pageBean.getStartNum() - 1);
				List<IQBOTodayCommendValue> afterList = cycleList.subList( pageBean.getStartNum() - 1, pageBean.getEndNum());
				int afterCount = 0;
				if (afterList != null & afterList.size() > 0) {
					resultList.addAll(0, afterList);
					afterCount = afterList.size();
				}
				if (beforeList != null && beforeList.size() > 0) {
					resultList.addAll(afterCount, beforeList);
				}
				cycleList = resultList;
			}
		}
		return cycleList;
	}

	//团购轮转信息步骤Part1 --下期预告
	public IQBOComingSoonValue[] getCsUnionList(List<IQBOComingSoonValue> topList,
			List<IQBOComingSoonValue> cycleList, String showType) throws Exception {
		
		List<IQBOComingSoonValue> unionList = new ArrayList<IQBOComingSoonValue>();
		IQBOComingSoonValue[] unionValue = null;
		
		cycleList = getCsSpellTuanlist(cycleList,showType);
		if (topList != null && topList.size() > 0) {
			unionList.addAll(topList);
		}
		if (cycleList != null && cycleList.size() > 0) {
			unionList.addAll(cycleList);
		}
		unionValue = new QBOComingSoonBean[unionList.size()];
		unionList.toArray(unionValue);
		return unionValue;
	}
	
	//团购轮转信息步骤Part2 --下期预告
	public List<IQBOComingSoonValue> getCsSpellTuanlist(List<IQBOComingSoonValue> cycleList, String showType) throws Exception{
		//3.获取轮转周期对象信息
		ITuanCycleInfoSrv cycleSrv = (ITuanCycleInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_TUANCYCLE_INFO);
		ITuanCycleInfoValue tuanCycle = cycleSrv.getTuanCycleInfo(showType,CoreConstant.ACTIVITY_TUAN_GROUP_NEXT_ISSUE);
		int cycleCount = cycleList.size();
		/**
		 *1. 如果存在轮转礼品并且当前轮转状态为“开”，那么根据轮转算法重新整合cycleList数据。 2.
		 * 满足第一步，重新获取轮转数据的开始和结果索引位置 3. 根据开始和结果索引获取对应整合后数据
		 */
		if (tuanCycle.getIsSpell() == 1 && cycleCount > 0) {

			PageBean pageBean = TuanInfoUtil.getSpellIndex((int) tuanCycle.getSpellInternalLength(),
					tuanCycle.getSpellSatrtTime(), cycleCount, cycleCount);
			log.info("The method getCsSpellTuanlist() showType="+getTuanTypeLog(showType)+",isSpell=" + tuanCycle.getIsSpell() + ",startIndex = "
					+ (pageBean.getStartNum() - 1) + ",endIndex=" + (pageBean.getEndNum() - 1));

			if (0 <= pageBean.getStartNum() - 1 && pageBean.getEndNum() - 1 <= cycleCount 
					&& pageBean.getStartNum() - 1 <= pageBean.getEndNum() - 1) {
				// 整合后结果列表
				List<IQBOComingSoonValue> resultList = new ArrayList<IQBOComingSoonValue>();
				List<IQBOComingSoonValue> beforeList = cycleList.subList(0, pageBean.getStartNum() - 1);
				List<IQBOComingSoonValue> afterList = cycleList.subList( pageBean.getStartNum() - 1, pageBean.getEndNum());
				int afterCount = 0;
				if (afterList != null & afterList.size() > 0) {
					resultList.addAll(0, afterList);
					afterCount = afterList.size();
				}
				if (beforeList != null && beforeList.size() > 0) {
					resultList.addAll(afterCount, beforeList);
				}
				cycleList = resultList;
			}
		}
		return cycleList;
	}

	//团购轮转信息步骤Part1 --精彩回顾
	public IQBOReviewValue[] getOldUnionList(List<IQBOReviewValue> topList, List<IQBOReviewValue> cycleList, String showType)
			throws Exception {
		
		List<IQBOReviewValue> unionList = new ArrayList<IQBOReviewValue>();
		IQBOReviewValue[] unionValue = null;
		
		cycleList = getOldSpellTuanlist(cycleList,showType);
		if (topList != null && topList.size() > 0) {
			unionList.addAll(topList);
		}
		if (cycleList != null && cycleList.size() > 0) {
			unionList.addAll(cycleList);
		}
		unionValue = new QBOReviewBean[unionList.size()];
		unionList.toArray(unionValue);
		return unionValue;
	}
	
	//团购轮转信息步骤Part2 --精彩回顾
	public List<IQBOReviewValue> getOldSpellTuanlist(List<IQBOReviewValue> cycleList, String showType) throws Exception{
		//3.获取轮转周期对象信息
		ITuanCycleInfoSrv cycleSrv = (ITuanCycleInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_TUANCYCLE_INFO);
		ITuanCycleInfoValue tuanCycle = cycleSrv.getTuanCycleInfo(showType,CoreConstant.ACTIVITY_TUAN_GROUP_OLD_TIMEY);
		int cycleCount = cycleList.size();
		/**
		 *1. 如果存在轮转礼品并且当前轮转状态为“开”，那么根据轮转算法重新整合cycleList数据。 2.
		 * 满足第一步，重新获取轮转数据的开始和结果索引位置 3. 根据开始和结果索引获取对应整合后数据
		 */
		if (tuanCycle.getIsSpell() == 1 && cycleCount > 0) {

			PageBean pageBean = TuanInfoUtil.getSpellIndex((int) tuanCycle.getSpellInternalLength(),
					tuanCycle.getSpellSatrtTime(), cycleCount, cycleCount);
			log.info("The method getOldSpellTuanlist() showType="+getTuanTypeLog(showType)+",isSpell=" + tuanCycle.getIsSpell() + ",startIndex = "
					+ (pageBean.getStartNum() - 1) + ",endIndex=" + (pageBean.getEndNum() - 1));

			if (0 <= pageBean.getStartNum() - 1 && pageBean.getEndNum() - 1 <= cycleCount 
					&& pageBean.getStartNum() - 1 <= pageBean.getEndNum() - 1) {
				// 整合后结果列表
				List<IQBOReviewValue> resultList = new ArrayList<IQBOReviewValue>();
				List<IQBOReviewValue> beforeList = cycleList.subList(0, pageBean.getStartNum() - 1);
				List<IQBOReviewValue> afterList = cycleList.subList( pageBean.getStartNum() - 1, pageBean.getEndNum());
				int afterCount = 0;
				if (afterList != null & afterList.size() > 0) {
					resultList.addAll(0, afterList);
					afterCount = afterList.size();
				}
				if (beforeList != null && beforeList.size() > 0) {
					resultList.addAll(afterCount, beforeList);
				}
				cycleList = resultList;
			}
		}
		return cycleList;
	}
	/**********************省网礼品支持团购，新增的查询方法**********************/
	//新增方法
	public IQBOTodayCommendValue[] getTodayCommend(int startNum, int endNum,String provinceCode,String channel, String userStarLevel) throws Exception {
		return tuanInfoDAO.getTodayCommend(startNum, endNum,provinceCode,channel,userStarLevel);
	}
	public IQBOComingSoonValue[] getComingSoon(int startNum, int endNum,String provinceCode,String channel, String userStarLevel) throws Exception {
		return tuanInfoDAO.getComingSoon(startNum, endNum,provinceCode, channel,userStarLevel);
	}
	public IQBOReviewValue[] getReview(int startNum, int endNum,String provinceCode) throws Exception {
		return tuanInfoDAO.getReview(startNum, endNum,provinceCode);
	}
}
