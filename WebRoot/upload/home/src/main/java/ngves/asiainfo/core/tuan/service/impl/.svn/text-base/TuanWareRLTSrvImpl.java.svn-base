package ngves.asiainfo.core.tuan.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.common.bo.BusiInfoDetailBean;
import ngves.asiainfo.core.common.bo.BusiInfoEngine;
import ngves.asiainfo.core.common.bo.UpdateNotifyInfoBean;
import ngves.asiainfo.core.common.ivalues.IBusiInfoDetailValue;
import ngves.asiainfo.core.common.ivalues.IUpdateNotifyInfoValue;
import ngves.asiainfo.core.common.util.BusiInfoUtil;
import ngves.asiainfo.core.tuan.TuanConstant;
import ngves.asiainfo.core.tuan.bo.QBOTuanWareIntegralBean;
import ngves.asiainfo.core.tuan.bo.TuanInfoBean;
import ngves.asiainfo.core.tuan.bo.TuanInfoEngine;
import ngves.asiainfo.core.tuan.dao.interfaces.ITuanInfoDAO;
import ngves.asiainfo.core.tuan.dao.interfaces.ITuanWareRLTDAO;
import ngves.asiainfo.core.tuan.exception.MgtTuanException;
import ngves.asiainfo.core.tuan.ivalues.IQBOTuanWareInfoValue;
import ngves.asiainfo.core.tuan.ivalues.IQBOTuanWareIntegralValue;
import ngves.asiainfo.core.tuan.ivalues.ITuanInfoValue;
import ngves.asiainfo.core.tuan.ivalues.ITuanWareRLTValue;
import ngves.asiainfo.core.tuan.model.TuanInfoValueToHP;
import ngves.asiainfo.core.tuan.service.interfaces.ITuanWareRLTSrv;
import ngves.asiainfo.core.tuan.util.TuanInfoUtil;
import ngves.asiainfo.core.ware.bo.ActivityIntegralBean;
import ngves.asiainfo.core.ware.bo.WareInfoEngine;
import ngves.asiainfo.core.ware.dao.interfaces.IActivityIntegralDAO;
import ngves.asiainfo.core.ware.ivalues.IActivityIntegralValue;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.PropertyReader;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;

public class TuanWareRLTSrvImpl implements ITuanWareRLTSrv {
	private Log log = LogFactory.getLog(TuanWareRLTSrvImpl.class);
	private ITuanWareRLTDAO tuanWareRLTDAO;
	private ITuanInfoDAO tuanInfoDAO;

	public void setTuanInfoDAO(ITuanInfoDAO tuanInfoDAO) throws Exception {
		this.tuanInfoDAO = tuanInfoDAO;
	}

	public void setTuanWareRLTDAO(ITuanWareRLTDAO tuanWareRLTDAO) throws Exception {
		this.tuanWareRLTDAO = tuanWareRLTDAO;
	}

	public ITuanWareRLTValue getTuanWareRLTById(String tuanId) throws Exception {
		return tuanWareRLTDAO.getTuanWareRLTById(tuanId);
	}

	public int countTuanWare(String provicne,String wareName) throws Exception {
		StringBuffer condition = new StringBuffer("");
		Map<String, String> parameter = new HashMap<String, String>();
		condition.append(" 1=1 ");
		if (!StringUtil.isBlank(wareName)) {
			wareName = wareName.trim();
			condition.append(" AND ").append(IQBOTuanWareInfoValue.S_WareName + " LIKE :" + IQBOTuanWareInfoValue.S_WareName).append(
					" ");
			parameter.put(IQBOTuanWareInfoValue.S_WareName, "%" + wareName + "%");
		}
		//新增省份条件，如果省份不为空或不为-1 表示查询的是全网或者某个省网否则是全部,
		if (!StringUtil.isBlank(provicne) && !provicne.equals("-1")) {
	            condition.append(" AND ").append(IQBOTuanWareInfoValue.S_ProvinceCode).append("=:").append(
	            		IQBOTuanWareInfoValue.S_ProvinceCode);
	            parameter.put(IQBOTuanWareInfoValue.S_ProvinceCode, provicne);
	        }
		return tuanWareRLTDAO.countTuanWare(condition.toString(), parameter);
	}

	
	public IQBOTuanWareInfoValue[] queryTuanWare(String provicne,String wareName, int startIndex, int endIndex) throws Exception {
		StringBuffer condition = new StringBuffer("");
		Map<String, String> parameter = new HashMap<String, String>();
		condition.append(" 1=1 ");
		if (!StringUtil.isBlank(wareName)) {
			wareName = wareName.trim();
			condition.append(" AND ").append(IQBOTuanWareInfoValue.S_WareName + " LIKE :" + IQBOTuanWareInfoValue.S_WareName).append(
					" ");
			parameter.put(IQBOTuanWareInfoValue.S_WareName, "%" + wareName + "%");
		}
		//新增省份条件，如果省份不为空或不为-1 表示查询的是全网或者某个省网否则是全部,
		if (!StringUtil.isBlank(provicne) && !provicne.equals("-1")) {
	            condition.append(" AND ").append(IQBOTuanWareInfoValue.S_ProvinceCode).append("=:").append(
	            		IQBOTuanWareInfoValue.S_ProvinceCode);
	            parameter.put(IQBOTuanWareInfoValue.S_ProvinceCode, provicne);
	        }
		return tuanWareRLTDAO.queryTuanWare(condition.toString(), parameter, startIndex, endIndex);
	}
    
	
	/**
	 * 这个函数和shenfl@asiainfo-linkage.com书写的ITuanWareRLTValue
	 * getTuanWareRLTById(String tuanId); 功能上有重复。 但是本函数对应于团购活动绑定多个礼品。（需求可不是这样的）
	 */
	public IQBOTuanWareIntegralValue[] queryTuanBindRelationInfo(String tuanId, String starLevel, String channel,String status) throws Exception {
		
		List<String> checkValueList = new ArrayList<String>();
		List<IQBOTuanWareIntegralValue> wareList = new ArrayList<IQBOTuanWareIntegralValue>();
		
		StringBuffer condition = new StringBuffer("");
		Map<String, String> parameter = new HashMap<String, String>();
		IQBOTuanWareIntegralValue [] values = null;
		
		if (!StringUtil.isBlank(tuanId)) {
			tuanId = tuanId.trim();
			condition.append(" 1=1 ");
			condition.append(" and ").append(IQBOTuanWareIntegralValue.S_TuanId + " =:" + IQBOTuanWareIntegralValue.S_TuanId);
			parameter.put(IQBOTuanWareIntegralValue.S_TuanId, tuanId);
			if(!StringUtil.isBlank(starLevel)){
				condition.append(" and ").append(IActivityIntegralValue.S_StarLevel + " =:" + IActivityIntegralValue.S_StarLevel);
	            parameter.put(IActivityIntegralValue.S_StarLevel, starLevel);//默认查询出第一个星级的记录
			}
			if(!StringUtil.isBlank(channel)){
	            condition.append(" and ").append(IActivityIntegralValue.S_Channel + " =:" + IActivityIntegralValue.S_Channel).append(" ");
	            parameter.put(IActivityIntegralValue.S_Channel, channel);
			}
			if(!StringUtil.isBlank(status)){
				condition.append(" and ").append(IQBOTuanWareIntegralValue.S_Status + " =:" + IQBOTuanWareIntegralValue.S_Status).append(" ");
	            parameter.put(IQBOTuanWareIntegralValue.S_Status, status);
			}
			values = tuanWareRLTDAO.queryTuanBindRelationInfo(condition.toString(), parameter);
			
			if(values != null && values.length > 0){
				for(IQBOTuanWareIntegralValue value : values){
					if(!checkValueList.contains(value.getTuanId()+"="+value.getWareId())){
						checkValueList.add(value.getTuanId()+"="+value.getWareId());
						wareList.add(value);
					}
				}
			}
			
		}
		
		IQBOTuanWareIntegralValue[] unionValue = null;
		unionValue = new QBOTuanWareIntegralBean[wareList.size()];
		unionValue = wareList.toArray(unionValue);
		
		// 如果没有团购ID，那么返回空对象
		return unionValue;
	}

	// 团购绑定礼品操作名称，前台选择的操作是
	// delete: 取消团购与礼品的绑定关系
	public static final String ACTION_DELETE_TUAN_WARE_BIND = "delete";
	// publish: 发布团购与礼品的绑定关系 (前台选择了保存并发布)
	public static final String ACTION_PUBLISH_TUAN_WARE_BIND = "publish";
	// view : 保存并预览团购与礼品的绑定关系(前台选择了保存并预览)
	public static final String ACTION_VIEW_TUAN_WARE_BIND = "view";

	/*
	 * 保存团购礼品绑定关系
	 */
	public long saveTuanBindRelationInfo(ITuanWareRLTValue value, String type, String actionType,long staffId) throws Exception {
		// 利用value中的字段来判断 该执行哪些操作
		long tuanWareRltId = 1L;
		// 证明前台礼品绑定列表有数据（新增或更新）
		if (!StringUtil.isBlank(value.getWareId() + "") && value.getWareId() != 0L) {
			// 如果前台选择的是活动发布。那么不仅要处理团购礼品关联表中数据，
			log.debug("Creating the relation between the group buy and ware.");
			if (!StringUtil.isBlank(value.getTuanWareRltId() + "") && 0L != value.getTuanWareRltId()) {
				value.setStsToOld();
			} else {
				value.setStsToNew();
			}
			
			value.setWareId(value.getWareId());
			value.setTuanId(value.getTuanId());
			
		
			value.setBindDate(DateTimeUtil.getNowTimeStamp());
			
			
			//====================================================================================
			//   以下操作为防止“并发”操作，用户可能两个管理员同时操作一条团购记录，如果一个用户已经给一个
			//   团购活动绑定了礼品，那么另外一个用户新增之前就必须去数据库中查询
			//   发现如果是新增操作，并且团购ID相同，那么存在“并发”操作
			//	 解决“并发”问题的方式应该是给数据表新增一个“APP_VERSION”字段。但是考虑到工作量，所以暂时采用
			//   这个方式，以后会更正为“APP_VERSION”方式防止“并发”
			//====================================================================================
			//礼品团购信息保存前，应该进行防止并发操作，应该加入对tuanWareRltId和tuanId的判断
			//如果存在tuanId ,利用tuanId 到数据表Tuan_ware_rlt中查询数据。如果存在数据，同时tuanWareRlt相同，但是礼品wareId不同。那么提示保存失败。
			ITuanWareRLTValue temp  = tuanWareRLTDAO.getTuanWareRLTById(value.getTuanId()+"");
			
			if(ACTION_DELETE_TUAN_WARE_BIND.equals(type)){
				if(null != temp ){//数据库里面存在相同tuanId的数据,同时前台有删除礼品的操作
	//					更新时  有tuanWareRltId tuanId wareId  更新时，
	//					如果tuanWareRltId !=0  同时tuanId 相同，wareId 不同 抛出异常错误
					if( 0 != value.getTuanWareRltId() && value.getTuanWareRltId() == temp.getTuanWareRltId()&& temp.getTuanId() == value.getTuanId() && temp.getWareId() !=value.getWareId()){
						log.warn("there occors concurrent operation, saving group buy infomation  failed. the operation is update.");
						//保存失败，返回-2
						tuanWareRltId = TuanConstant.TUAN_RETVAL_UPDATE_BIND_WARE_CONCURRENT;
						return tuanWareRltId;
					}
				}
			}else{
				if(null !=temp){
//					新增操作时  有tuanId wareId 该操作在并发时会发生。
//					如果 tuanWareRltId ==0 同时存在tuanId 的记录 那么抛出错误
					if( 0 == value.getTuanWareRltId() && temp.getTuanId() == value.getTuanId() ){
						log.warn("there occors concurrent operation, saving group buy infomation  failed. the operation is creation.");
						//并发保存保存失败，返回0
						tuanWareRltId =TuanConstant.TUAN_RETVAL_UPDATE_BIND_WARE_CONCURRENT;
						return tuanWareRltId;
					}
//					更新时  有tuanWareRltId tuanId wareId  更新时，
//					如果tuanWareRltId !=0  同时tuanId 相同，wareId 不同 抛出异常错误
					if( 0 != value.getTuanWareRltId() && value.getTuanWareRltId() == temp.getTuanWareRltId()&& temp.getTuanId() == value.getTuanId() && temp.getWareId() !=value.getWareId()){
						log.warn("there occors concurrent operation, saving group buy infomation  failed. the operation is update.");
						//保存失败，返回-2
						tuanWareRltId = TuanConstant.TUAN_RETVAL_UPDATE_BIND_WARE_CONCURRENT;
						return tuanWareRltId;
					}
				}
			}
//			//====================================================================================
			//   结束防止“并发”操作的代码
			//====================================================================================	
		}
		TuanInfoValueToHP tuanInfoValueToHP = new TuanInfoValueToHP();
		String optType ="";
		String optOrderType ="";
		//默认为成功，对应着两种情况，1、不需要同步团购信息给HP。2、需要同步团购信息给HP，并且已经同步成功。
		String synRetVal = TuanConstant.TUAN_INFO_SYN_HP_SUCC;
		
		//预览操作  肯定是更新操作，
		if(ACTION_VIEW_TUAN_WARE_BIND.equals(actionType)){
			//预览操作，团购状态为发布状态，同时tuanWareRltValue中存在tuanId 和 wareId的数据，并且wareId的数据和原有数据不一样
			boolean isNeedSyn = TuanInfoUtil.isNeedSynTuanInfoToHP(value.getTuanId(), value.getWareId(), null,TuanConstant.ACTION_VIEW_TUAN_WARE_BIND);
			//需要进行同步
			if(true==isNeedSyn){
				//新增的判断条件 @2011-09-20  by liuyq
				//需要同步的时候，应该先判断是否能够读出团购url的配置文件 如果没有读出来，那么抛出异常信息
				//只有读出来团购URL配置项信息，才会进行给HP同步信息
				//genTuanUrl(value.getTuanId()+"");
				
				//修改操作
				optType = TuanConstant.TUAN_INFO_SYN_HP_TUAN_OPT_TYPE_MODIFY;
				//固定00(达到团兑数量下限即开始拆单)
				optOrderType = TuanConstant.TUAN_INFO_SYN_HP_TUAN_OPT_ORDER_TYPE_DEFAULT;
				tuanInfoValueToHP = TuanInfoUtil.convertTuanInfoValue(value,null, optType, optOrderType);
				
				synRetVal = TuanInfoUtil.synchronousTuanInfoToHP(tuanInfoValueToHP);
				if(!TuanConstant.TUAN_INFO_SYN_HP_SUCC.equals(synRetVal)){
					//团购信息同步HP失败
					//返回错误消息
					tuanWareRltId = TuanConstant.TUAN_RETVAL_SYN_HP_FAIL;
					return tuanWareRltId;
				}
			}
		}
		
		
		// 还要更新团购基本信息表
		// 将团购基本信息表中 团购状态更新为"发布状态"
		// 注意：发布时，前台一定有礼品和团购的关联信息。
		if (ACTION_PUBLISH_TUAN_WARE_BIND.equals(actionType)) {
			// 2011年9月份需求，团购二期工程，将团购部分信息同步给HP
			//如果同步信息成功，那么将团购信息状态更改为 团购活动发布 同时更新发部分和发布时间
			
			//将团购信息同步给HP
			//如果同步信息失败，那么返回失败信息，同时团购活动状态不变
			//value.getTuanId()!=0L && value.getWareId()!=0L 表示前台有礼品和团购关联信息
			if(value.getTuanId()!=0L && value.getWareId()!=0L){
				boolean isNeedSyn = TuanInfoUtil.isNeedSynTuanInfoToHP(value.getTuanId(), value.getWareId(), null,TuanConstant.ACTION_PUBLISH_TUAN_WARE_BIND);

				if(true ==  isNeedSyn){
					//新增的判断条件 @2011-09-20  by liuyq
					//需要同步的时候，应该先判断是否能够读出团购url的配置文件 如果没有读出来，那么抛出异常信息
					//只有读出来团购URL配置项信息，才会进行给HP同步信息
					genTuanUrl(value.getTuanId()+"");
					
					
					//利用tuanWareRltId 来判断是否是新增(修改)团购信息。任何团购第一次同步的入口都为点击了“绑定并发布”按钮，
					//应该利用tuan_id 到tuan_ware_rlt表中查询数据，如果存在数据，同时团购状态为发布状态，那么表示是新增数据；否则是修改数据。
					ITuanWareRLTValue tempTuanWareRltValue  = tuanWareRLTDAO.getTuanWareRLTById(value.getTuanId()+"");
					if(null !=tempTuanWareRltValue){
						ITuanInfoValue tempTuanInfoValue = tuanInfoDAO.queryTuanById(value.getTuanId()+"");
						if(null != tempTuanInfoValue){
							log.info("=====>>>"+value.getTuanId());
							log.info("=====>>>stauts: "+tempTuanInfoValue.getStatus());
							if(TuanConstant.TUAN_STATUS_PUBLISH.equals(tempTuanInfoValue.getStatus())){
								//团购活动为发布状态修改操作
								optType = TuanConstant.TUAN_INFO_SYN_HP_TUAN_OPT_TYPE_MODIFY;
							}else if(TuanConstant.TUAN_STATUS_CREATE.equals(tempTuanInfoValue.getStatus())){
								//团购活动的状态不是发布状态，新增操作
								optType = TuanConstant.TUAN_INFO_SYN_HP_TUAN_OPT_TYPE_ADD;
							}else{
								//团购活动状态为停止状态，抛出异常信息
								throw new MgtTuanException("the group buy item "+tempTuanInfoValue.getName()+" has stopped ,can't be published .");
							}
						}else{
							throw new MgtTuanException("cann't get the items from tuan_info table by primary key "+value.getTuanId());
						}
					}else{
						//新增操作
						optType = TuanConstant.TUAN_INFO_SYN_HP_TUAN_OPT_TYPE_ADD;
					}

					//固定00(达到团兑数量下限即开始拆单)
					optOrderType = TuanConstant.TUAN_INFO_SYN_HP_TUAN_OPT_ORDER_TYPE_DEFAULT;
					tuanInfoValueToHP = TuanInfoUtil.convertTuanInfoValue(value,null, optType, optOrderType);
					synRetVal = TuanInfoUtil.synchronousTuanInfoToHP(tuanInfoValueToHP);
				}
				
				//团购信息同步HP成功
				if(TuanConstant.TUAN_INFO_SYN_HP_SUCC.equals(synRetVal)){
					// 1、利用团购ID tuanInfoDAO.queryTuanById(tuanId);查询到团购信息
					ITuanInfoValue tuanInfoValue = tuanInfoDAO.queryTuanById(value.getTuanId() + "");
					// 2、将团购状态设置为 TuanConstant.TUAN_STATUS_PUBLISH ,同时更新发布人和发布时t间
					tuanInfoValue.setStatus(TuanConstant.TUAN_STATUS_PUBLISH);
					tuanInfoValue.setPublishStaff(staffId + "");
				//	tuanInfoValue.setPublishStaff(mgtUserInfo.getPartnerId() + "");
					tuanInfoValue.setPublishDate(DateTimeUtil.getNowTimeStamp());
					tuanInfoValue.setUrl(genTuanUrl(value.getTuanId() + ""));
					// 3、保存团购信息
					long tuanInfoId = tuanInfoDAO.saveTuanInfo(tuanInfoValue);
					if (0 == tuanInfoId) {
						log.warn("an error occors in publishing the group buy function, update group buy infomation from tuan_info table failed. ");
					}
				}else{
			
					//团购信息同步HP失败
					//返回错误消息
					//由于同步失败，有可能是多种原因造成的。这里增加条件判断，使返回的错误信息多元化
					if(TuanConstant.TUAN_INFO_SYN_HP_UPDATE_ERR.equals(synRetVal)){
						tuanWareRltId = TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G702;
					}else if(TuanConstant.TUAN_INFO_SYN_HP_OTHER_ERR.equals(synRetVal)){
						tuanWareRltId = TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G703;
					}else if(TuanConstant.TUAN_INFO_SYN_HP_NEW_ENDTIME_BEFORE_STARTTIME.equals(synRetVal)){
						tuanWareRltId = TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G704;
					}else if(TuanConstant.TUAN_INFO_SYN_HP_NEW_STARTTIME_AFTER_CURRTIME.equals(synRetVal)){
						tuanWareRltId = TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G705;
					}else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_FINISHED.equals(synRetVal)){
						tuanWareRltId = TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G706;
					}else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_STARTED_MODIFY_LIMITED.equals(synRetVal)){
						tuanWareRltId = TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G707;
					}else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_STARTED_DELETE_LIMITED.equals(synRetVal)){
						tuanWareRltId = TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G708;
					}else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_NO_WAREID.equals(synRetVal)){
						tuanWareRltId = TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G709;
					}else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_NO_TUANID.equals(synRetVal)){
						tuanWareRltId = TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G710;
					}else{
						tuanWareRltId = TuanConstant.TUAN_RETVAL_SYN_HP_FAIL;
					}
					return tuanWareRltId;
				}
			}
		}
		//前台有删除礼品的操作
		if (ACTION_DELETE_TUAN_WARE_BIND.equals(type)) {
			// 根据value中的tuanId 进行团购礼品绑定信息删除操作
			// 团购活动原来有绑定的礼品，但是后来在修改的时候，删除了该绑定的礼品。
			// log.info("The operation that trying to delete the relation of the group buy and ware is running.");
			//防止删除时并发操作。
			ITuanWareRLTValue temp  = tuanWareRLTDAO.getTuanWareRLTById(value.getTuanId()+"");
			//如果团购活动执行了删除操作，那么，会去数据库里面校验，如果当前团购活动的礼品已经被删除，那么就提示数据已经更新，请刷新页面
			if(null == temp){
				log.warn("there occors concurrent operation, saving group buy infomation  failed.");
				//并发保存保存失败，返回0
				tuanWareRltId =TuanConstant.TUAN_RETVAL_UPDATE_BIND_WARE_CONCURRENT;
				return tuanWareRltId;
			}else{
	
				tuanWareRLTDAO.deleteBindTuanWareInfoById(value.getTuanId() + "");
			}
		}
	
		// 证明前台礼品绑定列表有数据（新增或更新）
		if (!StringUtil.isBlank(value.getWareId() + "") && value.getWareId() != 0L) {
			// 调用 dao对应的save方法，
			tuanWareRltId = tuanWareRLTDAO.saveBindTuanWareInfo(value);
		}
		
		return tuanWareRltId;
	}
	
	/**
	 * 验证是否绑定短信模板
	 */
	public void tuanSmsTemp(String tuanId,String wareId) throws Exception{
		int count=tuanWareRLTDAO.tuanSmsTemp(tuanId, wareId);
		if(0==count){
			log.debug("没有绑定短信模板");
			throw new Exception("not banding smstemp");
		}
	}
	
	/**
	 * 验证此礼品是否已保存到TUAN_WARE_RLT
	 */
	public void isTuanWareRlt(String tuanId,String wareId) throws Exception{
		int count=tuanWareRLTDAO.isTuanWareRlt(tuanId, wareId);
		if(0==count){
			log.debug("还未将此礼品保存到TUAN_WARE_RLT");
			throw new Exception("not save tuan_ware_rlt");
		}
	}
	
	/**
     * 保存团购礼品绑定关系,增加日志记录
     */
    public long saveTuanBindRelationInfo(Map<String,Object> in) throws Exception {
    	ITuanWareRLTValue value = (ITuanWareRLTValue)in.get("tuanWareRLT");
    	String type = (String)in.get("type");
    	String actionType = (String)in.get("actionType");
    	long staffId = (Long)in.get("staffId");
    	String comType = (String)in.get("comType");
    	long orgId = (Long)in.get("orgId");
        // 利用value中的字段来判断 该执行哪些操作
        long tuanWareRltId = 1L;
        // 证明前台礼品绑定列表有数据（新增或更新）
        if (!StringUtil.isBlank(value.getWareId() + "") && value.getWareId() != 0L) {
            // 如果前台选择的是活动发布。那么不仅要处理团购礼品关联表中数据，
            log.debug("Creating the relation between the group buy and ware.");
            if (!StringUtil.isBlank(value.getTuanWareRltId() + "") && 0L != value.getTuanWareRltId()) {
                value.setStsToOld();
            } else {
                value.setStsToNew();
            }
            value.setWareId(value.getWareId());
			value.setTuanId(value.getTuanId());
			value.setDiscount(value.getDiscount());
            if(!"".equals(value.getWarePayType())){
            	value.setWarePayType(value.getWarePayType());
            }
            value.setBindDate(DateTimeUtil.getNowTimeStamp());
            
            
            //====================================================================================
            //   以下操作为防止“并发”操作，用户可能两个管理员同时操作一条团购记录，如果一个用户已经给一个
            //   团购活动绑定了礼品，那么另外一个用户新增之前就必须去数据库中查询
            //   发现如果是新增操作，并且团购ID相同，那么存在“并发”操作
            //   解决“并发”问题的方式应该是给数据表新增一个“APP_VERSION”字段。但是考虑到工作量，所以暂时采用
            //   这个方式，以后会更正为“APP_VERSION”方式防止“并发”
            //====================================================================================
            //礼品团购信息保存前，应该进行防止并发操作，应该加入对tuanWareRltId和tuanId的判断
            //如果存在tuanId ,利用tuanId 到数据表Tuan_ware_rlt中查询数据。如果存在数据，同时tuanWareRlt相同，但是礼品wareId不同。那么提示保存失败。
            ITuanWareRLTValue temp  = tuanWareRLTDAO.getTuanWareRLTById(value.getTuanId()+"");
            
            if(ACTION_DELETE_TUAN_WARE_BIND.equals(type)){
                if(null != temp ){//数据库里面存在相同tuanId的数据,同时前台有删除礼品的操作
    //                  更新时  有tuanWareRltId tuanId wareId  更新时，
    //                  如果tuanWareRltId !=0  同时tuanId 相同，wareId 不同 抛出异常错误
                    if( 0 != value.getTuanWareRltId() && value.getTuanWareRltId() == temp.getTuanWareRltId()&& temp.getTuanId() == value.getTuanId() && temp.getWareId() !=value.getWareId()){
                        log.warn("there occors concurrent operation, saving group buy infomation  failed. the operation is update.");
                        //保存失败，返回-2
                        tuanWareRltId = TuanConstant.TUAN_RETVAL_UPDATE_BIND_WARE_CONCURRENT;
                        return tuanWareRltId;
                    }
                }
            }else{
                if(null !=temp){
//                  新增操作时  有tuanId wareId 该操作在并发时会发生。
//                  如果 tuanWareRltId ==0 同时存在tuanId 的记录 那么抛出错误
                    if( 0 == value.getTuanWareRltId() && temp.getTuanId() == value.getTuanId() ){
                        log.warn("there occors concurrent operation, saving group buy infomation  failed. the operation is creation.");
                        //并发保存保存失败，返回0
                        tuanWareRltId =TuanConstant.TUAN_RETVAL_UPDATE_BIND_WARE_CONCURRENT;
                        return tuanWareRltId;
                    }
//                  更新时  有tuanWareRltId tuanId wareId  更新时，
//                  如果tuanWareRltId !=0  同时tuanId 相同，wareId 不同 抛出异常错误
                    if( 0 != value.getTuanWareRltId() && value.getTuanWareRltId() == temp.getTuanWareRltId()&& temp.getTuanId() == value.getTuanId() && temp.getWareId() !=value.getWareId()){
                        log.warn("there occors concurrent operation, saving group buy infomation  failed. the operation is update.");
                        //保存失败，返回-2
                        tuanWareRltId = TuanConstant.TUAN_RETVAL_UPDATE_BIND_WARE_CONCURRENT;
                        return tuanWareRltId;
                    }
                }
            }
//          //====================================================================================
            //   结束防止“并发”操作的代码
            //====================================================================================  
        }
        TuanInfoValueToHP tuanInfoValueToHP = new TuanInfoValueToHP();
        String optType ="";
        String optOrderType ="";
        //默认为成功，对应着两种情况，1、不需要同步团购信息给HP。2、需要同步团购信息给HP，并且已经同步成功。
        String synRetVal = TuanConstant.TUAN_INFO_SYN_HP_SUCC;
        
        //预览操作  肯定是更新操作，
        if(ACTION_VIEW_TUAN_WARE_BIND.equals(actionType)){
            //预览操作，团购状态为发布状态，同时tuanWareRltValue中存在tuanId 和 wareId的数据，并且wareId的数据和原有数据不一样
            boolean isNeedSyn = TuanInfoUtil.isNeedSynTuanInfoToHP(value.getTuanId(), value.getWareId(), null,TuanConstant.ACTION_VIEW_TUAN_WARE_BIND);
            //需要进行同步
            if(true==isNeedSyn){
                
                //修改操作
                optType = TuanConstant.TUAN_INFO_SYN_HP_TUAN_OPT_TYPE_MODIFY;
                //固定00(达到团兑数量下限即开始拆单)
                optOrderType = TuanConstant.TUAN_INFO_SYN_HP_TUAN_OPT_ORDER_TYPE_DEFAULT;
                tuanInfoValueToHP = TuanInfoUtil.convertTuanInfoValue(value,null, optType, optOrderType);
                
                synRetVal = TuanInfoUtil.synchronousTuanInfoToHP(tuanInfoValueToHP);
                if(!TuanConstant.TUAN_INFO_SYN_HP_SUCC.equals(synRetVal)){
                    //团购信息同步HP失败
                    //返回错误消息
                    tuanWareRltId = TuanConstant.TUAN_RETVAL_SYN_HP_FAIL;
                    return tuanWareRltId;
                }
            }
            
            ITuanInfoValue tempTuanInfoValue = tuanInfoDAO.queryTuanById(value.getTuanId()+"");
            IUpdateNotifyInfoValue notifyInfo = null;
            if(null !=tempTuanInfoValue
            		&& TuanConstant.TUAN_STATUS_PUBLISH.equals(tempTuanInfoValue.getStatus())){
            	//团购活动已绑定礼品，并且已发布
            	
            	// 将信息保存到update_notify_info中标识为待同步
                notifyInfo = new UpdateNotifyInfoBean();
            	notifyInfo.setNotifyType(CoreConstant.SYS_PARA_SYN_STATE_WAIT);
            	notifyInfo.setItemId(value.getWareId());
            	notifyInfo.setItemStatus(CoreConstant.SYS_PARA_SYN_STATE_WAIT);
            	notifyInfo.setStatus(CoreConstant.SYS_PARA_SYN_STATE_WAIT);
            	tuanInfoDAO.saveNotifyInfo(new IUpdateNotifyInfoValue[] { notifyInfo });
            }
            
        }
        
        
        // 还要更新团购基本信息表
        // 将团购基本信息表中 团购状态更新为"发布状态"
        // 注意：发布时，前台一定有礼品和团购的关联信息。
        if (ACTION_PUBLISH_TUAN_WARE_BIND.equals(actionType)) {
            // 2011年9月份需求，团购二期工程，将团购部分信息同步给HP
            //如果同步信息成功，那么将团购信息状态更改为 团购活动发布 同时更新发部分和发布时间
            
            //将团购信息同步给HP
            //如果同步信息失败，那么返回失败信息，同时团购活动状态不变
            //value.getTuanId()!=0L && value.getWareId()!=0L 表示前台有礼品和团购关联信息
            if(value.getTuanId()!=0L && value.getWareId()!=0L){

            	
                boolean isNeedSyn = TuanInfoUtil.isNeedSynTuanInfoToHP(value.getTuanId(), value.getWareId(), null,TuanConstant.ACTION_PUBLISH_TUAN_WARE_BIND);

                if(true ==  isNeedSyn){
                    //新增的判断条件 @2011-09-20  by liuyq
                    //需要同步的时候，应该先判断是否能够读出团购url的配置文件 如果没有读出来，那么抛出异常信息
                    //只有读出来团购URL配置项信息，才会进行给HP同步信息
                    genTuanUrl(value.getTuanId()+"");
                    
                    
                    //利用tuanWareRltId 来判断是否是新增(修改)团购信息。任何团购第一次同步的入口都为点击了“绑定并发布”按钮，
                    //应该利用tuan_id 到tuan_ware_rlt表中查询数据，如果存在数据，同时团购状态为发布状态，那么表示是新增数据；否则是修改数据。
                    ITuanWareRLTValue tempTuanWareRltValue  = tuanWareRLTDAO.getTuanWareRLTById(value.getTuanId()+"");
                    if(null !=tempTuanWareRltValue){
                        ITuanInfoValue tempTuanInfoValue = tuanInfoDAO.queryTuanById(value.getTuanId()+"");
                        if(null != tempTuanInfoValue){
                        	if(log.isDebugEnabled()){
                        		  log.debug("=====>>>"+value.getTuanId());
                                  log.debug("=====>>>stauts: "+tempTuanInfoValue.getStatus());
                        	}
                            if(TuanConstant.TUAN_STATUS_PUBLISH.equals(tempTuanInfoValue.getStatus())){
                                //团购活动为发布状态修改操作
                                optType = TuanConstant.TUAN_INFO_SYN_HP_TUAN_OPT_TYPE_MODIFY;
                            }else if(TuanConstant.TUAN_STATUS_CREATE.equals(tempTuanInfoValue.getStatus())){
                                //团购活动的状态不是发布状态，新增操作
                                optType = TuanConstant.TUAN_INFO_SYN_HP_TUAN_OPT_TYPE_ADD;
                            }else{
                                //团购活动状态为停止状态，抛出异常信息
                                throw new MgtTuanException("the group buy item "+tempTuanInfoValue.getName()+" has stopped ,can't be published .");
                            }
                        }else{
                            throw new MgtTuanException("cann't get the items from tuan_info table by primary key "+value.getTuanId());
                        }
                    }else{
                        //新增操作
                        optType = TuanConstant.TUAN_INFO_SYN_HP_TUAN_OPT_TYPE_ADD;
                    }

                    //固定00(达到团兑数量下限即开始拆单)
                    optOrderType = TuanConstant.TUAN_INFO_SYN_HP_TUAN_OPT_ORDER_TYPE_DEFAULT;
                    tuanInfoValueToHP = TuanInfoUtil.convertTuanInfoValue(value,null, optType, optOrderType);
                    synRetVal = TuanInfoUtil.synchronousTuanInfoToHP(tuanInfoValueToHP);
                }
                
                //团购信息同步HP成功
                IUpdateNotifyInfoValue notifyInfo = null;
                if(TuanConstant.TUAN_INFO_SYN_HP_SUCC.equals(synRetVal)){
                    // 1、利用团购ID tuanInfoDAO.queryTuanById(tuanId);查询到团购信息
                    ITuanInfoValue tuanInfoValue = tuanInfoDAO.queryTuanById(value.getTuanId() + "");
                    ITuanInfoValue oldBean = new TuanInfoBean();
                    oldBean.copy(tuanInfoValue);
                    // 2、将团购状态设置为 TuanConstant.TUAN_STATUS_PUBLISH ,同时更新发布人和发布时t间
                    tuanInfoValue.setStatus(TuanConstant.TUAN_STATUS_PUBLISH);
                    tuanInfoValue.setPublishStaff(staffId + "");
                    tuanInfoValue.setPublishDate(DateTimeUtil.getNowTimeStamp());
                    tuanInfoValue.setUrl(genTuanUrl(value.getTuanId() + ""));
                    // 3、保存团购信息
                    long tuanInfoId = tuanInfoDAO.saveTuanInfo(tuanInfoValue);
                    
                    // 4、将信息保存到update_notify_info中标识为待同步
                    notifyInfo = new UpdateNotifyInfoBean();
                	notifyInfo.setNotifyType(CoreConstant.SYS_PARA_SYN_STATE_WAIT);
                	notifyInfo.setItemId(value.getWareId());
                	notifyInfo.setItemStatus(CoreConstant.SYS_PARA_SYN_STATE_WAIT);
                	notifyInfo.setStatus(CoreConstant.SYS_PARA_SYN_STATE_WAIT);
                	tuanInfoDAO.saveNotifyInfo(new IUpdateNotifyInfoValue[] { notifyInfo });
                    
                    long busiInfoId = BusiInfoEngine.getNewId().longValue();
                    BusiInfoUtil.recordBusiInfo(busiInfoId + "", CoreConstant.SYS_PARA_BUSI_TYPE_TUAN_MODIFY, -1,
                            "修改团购活动",CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,"团购ID："+tuanInfoValue.getTuanId()+"；团购名称："+oldBean.getName(),staffId,comType,orgId);
                    BusiInfoUtil.recordBusiDetail(busiInfoId + "", new Object[]{oldBean}, new Object[]{tuanInfoValue}, "TuanId");
                    if (0 == tuanInfoId) {
                        log.warn("an error occors in publishing the group buy function, update group buy infomation from tuan_info table failed. ");
                    }
                }else{
            
                    //团购信息同步HP失败
                    //返回错误消息
                    //由于同步失败，有可能是多种原因造成的。这里增加条件判断，使返回的错误信息多元化
                    if(TuanConstant.TUAN_INFO_SYN_HP_UPDATE_ERR.equals(synRetVal)){
                        tuanWareRltId = TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G702;
                    }else if(TuanConstant.TUAN_INFO_SYN_HP_OTHER_ERR.equals(synRetVal)){
                        tuanWareRltId = TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G703;
                    }else if(TuanConstant.TUAN_INFO_SYN_HP_NEW_ENDTIME_BEFORE_STARTTIME.equals(synRetVal)){
                        tuanWareRltId = TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G704;
                    }else if(TuanConstant.TUAN_INFO_SYN_HP_NEW_STARTTIME_AFTER_CURRTIME.equals(synRetVal)){
                        tuanWareRltId = TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G705;
                    }else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_FINISHED.equals(synRetVal)){
                        tuanWareRltId = TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G706;
                    }else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_STARTED_MODIFY_LIMITED.equals(synRetVal)){
                        tuanWareRltId = TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G707;
                    }else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_STARTED_DELETE_LIMITED.equals(synRetVal)){
                        tuanWareRltId = TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G708;
                    }else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_NO_WAREID.equals(synRetVal)){
                        tuanWareRltId = TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G709;
                    }else if(TuanConstant.TUAN_INFO_SYN_HP_TUAN_NO_TUANID.equals(synRetVal)){
                        tuanWareRltId = TuanConstant.TUAN_RETVAL_SYN_HP_FAIL_G710;
                    }else{
                        tuanWareRltId = TuanConstant.TUAN_RETVAL_SYN_HP_FAIL;
                    }
                    return tuanWareRltId;
                }
            }
        }
        String tuanName = "";
        //前台有删除礼品的操作
        if (ACTION_DELETE_TUAN_WARE_BIND.equals(type)) {
            // 根据value中的tuanId 进行团购礼品绑定信息删除操作
            // 团购活动原来有绑定的礼品，但是后来在修改的时候，删除了该绑定的礼品。
            // log.info("The operation that trying to delete the relation of the group buy and ware is running.");
            //防止删除时并发操作。
            ITuanWareRLTValue temp  = tuanWareRLTDAO.getTuanWareRLTById(value.getTuanId()+"");
            IUpdateNotifyInfoValue tuannotifyInfo = null;
            //如果团购活动执行了删除操作，那么，会去数据库里面校验，如果当前团购活动的礼品已经被删除，那么就提示数据已经更新，请刷新页面
            if(null == temp){
                log.warn("there occors concurrent operation, saving group buy infomation  failed.");
                //并发保存保存失败，返回0
                tuanWareRltId =TuanConstant.TUAN_RETVAL_UPDATE_BIND_WARE_CONCURRENT;
                return tuanWareRltId;
            }else{
                tuanName = WareInfoEngine.getBean(temp.getWareId()).getWareName();
                tuanWareRLTDAO.deleteBindTuanWareInfoById(value.getTuanId() + "");
                
                //当团购活动为已发布的情况下，删除之前绑定的团购礼品后,应恢复被删除的团购礼品在商城门户的积分 2012-11-26 by luohuan
                ITuanInfoValue tuanInfoValue = tuanInfoDAO.queryTuanById(value.getTuanId()+"");
                if(null !=tuanInfoValue && TuanConstant.TUAN_STATUS_PUBLISH.equals(tuanInfoValue.getStatus())){
	                tuannotifyInfo = new UpdateNotifyInfoBean();
	                tuannotifyInfo.setNotifyType(CoreConstant.SYS_PARA_SYN_STATE_WAIT);
	                tuannotifyInfo.setItemId(temp.getWareId());
	                tuannotifyInfo.setItemStatus(CoreConstant.SYS_PARA_SYN_STATE_WAIT);
	                tuannotifyInfo.setStatus(CoreConstant.SYS_PARA_SYN_STATE_WAIT);
	            	tuanInfoDAO.saveNotifyInfo(new IUpdateNotifyInfoValue[] { tuannotifyInfo });
                }
            }
        }
    
        String newTuanName = WareInfoEngine.getBean(value.getWareId()).getWareName();
        if(("").equals(tuanName)){
            tuanName = "空";
        }
        if(null == newTuanName ){
            newTuanName = "空";
        }
        if (!tuanName.equals(newTuanName)) {
            ITuanWareRLTValue temp = tuanWareRLTDAO.getTuanWareRLTById(value.getTuanId() + "");
            if (null == temp) {
                long busiInfoId = BusiInfoEngine.getNewId().longValue();
                BusiInfoUtil.recordBusiInfo(busiInfoId + "", CoreConstant.SYS_PARA_BUSI_TYPE_TUAN_MODIFY, -1,
                        "团购活动绑定礼品", CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY, "团购ID：" + value.getTuanId() + "；团购名称："
                                + TuanInfoEngine.getBean(value.getTuanId()).getName(), staffId, comType, orgId);
                IBusiInfoDetailValue busiInfoDetail = new BusiInfoDetailBean();
                busiInfoDetail.setBusiId(busiInfoId);
                busiInfoDetail.setBusiTable("TuanWareRLT");
                busiInfoDetail.setMainFldName("TuanId");
                busiInfoDetail.setMainFldValue(String.valueOf(value.getTuanId()));
                busiInfoDetail.setFieldName("绑定礼品名称");
                busiInfoDetail.setBeforeValue(tuanName);
                busiInfoDetail.setAfterValue(newTuanName);
                BusiInfoUtil.recordBusiDetail(busiInfoDetail);
            }
        }
        // 证明前台礼品绑定列表有数据（新增或更新）
        if (!StringUtil.isBlank(value.getWareId() + "") && value.getWareId() != 0L) {
            // 调用 dao对应的save方法，
            tuanWareRltId = tuanWareRLTDAO.saveBindTuanWareInfo(in);
        }else{// 删除积分
        	IActivityIntegralDAO activityIntegralDAO = (IActivityIntegralDAO) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_ACTIVITY_INTEGRAL_DAO);
        	IActivityIntegralValue activityIntegral = new ActivityIntegralBean();
        	activityIntegral.setActivityId(value.getTuanId());
        	activityIntegral.setWareId(value.getWareId());
        	activityIntegral.setActivityType(CoreConstant.ACTIVITY_TUAN);
        	activityIntegralDAO.delActivityIntegral(activityIntegral);
        	
        }
        
        return tuanWareRltId;
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
	private String genTuanUrl(String tuanId) throws Exception {
		StringBuffer url = new StringBuffer();
		if (!StringUtil.isBlank(tuanId)) {
			String tuanPortalUrl = PropertyReader.getProperty(TuanConstant.TUAN_PORTAL_URL_KEY);
			if(StringUtil.isBlank(tuanPortalUrl) || "null".equals(tuanPortalUrl)){
				log.error("can't read the mgt parameter.properties files");
				throw new MgtTuanException("can't read the  mgt parameter.properties file,the item of tuan.http.url maybe losing!");
			}
			url.append(tuanPortalUrl).append("/").append(tuanId).append(".html");
		} else {
			url.append("http://jf.10086.cn").append("/").append("pageError.html");
		}
		return url.toString();
	}
	
	/**
	 * @author cuihj
	 * @date 2013-08-20
	 * @purpose 根据礼品ID获取礼品配置的仓库类型
	 * @param wareId 礼品ID
	 * @return
	 * @throws Exception
	 */
	public IQBOTuanWareInfoValue[] queryTuanWareStorageTypeByWareId(String wareId) throws Exception {
		
		StringBuffer condition = new StringBuffer("");
		Map<String, String> parameter = new HashMap<String, String>();
		condition.append(" 1=1 ");
	
		if (!StringUtil.isBlank(wareId)) {
	            condition.append(" AND ").append(IQBOTuanWareInfoValue.S_WareId).append("=:").append(
	            		IQBOTuanWareInfoValue.S_WareId);
	            parameter.put(IQBOTuanWareInfoValue.S_WareId, wareId);
	      }
		return tuanWareRLTDAO.queryTuanWare(condition.toString(), parameter);
	}
}
