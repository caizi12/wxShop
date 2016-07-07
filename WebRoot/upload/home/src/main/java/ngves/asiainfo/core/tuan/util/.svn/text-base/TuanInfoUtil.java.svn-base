package ngves.asiainfo.core.tuan.util;

import java.io.File;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.tuan.TuanConstant;
import ngves.asiainfo.core.tuan.bo.TuanInfoBean;
import ngves.asiainfo.core.tuan.bo.TuanProvinceBean;
import ngves.asiainfo.core.tuan.exception.MgtTuanException;
import ngves.asiainfo.core.tuan.exception.MgtTuanInterException;
import ngves.asiainfo.core.tuan.ivalues.ITuanInfoValue;
import ngves.asiainfo.core.tuan.ivalues.ITuanProvinceValue;
import ngves.asiainfo.core.tuan.ivalues.ITuanWareRLTValue;
import ngves.asiainfo.core.tuan.model.PageBean;
import ngves.asiainfo.core.tuan.model.TuanInfoValueToHP;
import ngves.asiainfo.core.tuan.service.interfaces.ITuanInfoSrv;
import ngves.asiainfo.core.tuan.service.interfaces.ITuanWareRLTSrv;
import ngves.asiainfo.core.ware.ivalues.IWareInfoValue;
import ngves.asiainfo.core.ware.service.interfaces.IWareInfoSrv;
import ngves.asiainfo.interfaces.hp.bean.tuanInfoIncSyn.in.TuanInfoIncSynInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.tuanInfoIncSyn.in.TuanInfoIncSynInItemInfo;
import ngves.asiainfo.interfaces.hp.bean.tuanInfoIncSyn.in.TuanInfoIncSynInItemList;
import ngves.asiainfo.interfaces.hp.bean.tuanInfoIncSyn.out.TuanInfoIncSynOutBizRegReq;
import ngves.asiainfo.interfaces.hp.realtime.TuanInfoIncSynInter;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.AIException;
import com.ai.appframe2.service.ServiceFactory;

/**
 * 
 * @author liuyq
 * @date 2011-07-15
 * @purpose 团购活动中，用到的公用方法
 * @items <li>1、getTuanProvince(province,provinceCheck)将省份信息封装成为对象</li> <li>
 *        2、getTuanInfoStatus(tuanId)根据团购活动ID 获得团购活动当前的状态</li> <li>
 *        3、getTuanInfo(tuanId) 根据团购ID，获得团购的基本信息。</li><li>
 *        4、getTuanImgBasePath() 获得团购图片的根目录的路径。</li><li>
 *        5、synchronousTuanInfoToHP(TuanInfoValueToHP) 将团购信息增量同步给HP。</li>
 */
public class TuanInfoUtil {
	private static transient Log log = LogFactory.getLog(TuanInfoUtil.class);

	/**
	 * @purpose 根据前台获得的省份信息字符串，处理得到团购省份信息的对象数组
	 * @param tuanId
	 *            团购的Id
	 * @param province
	 *            前台获得的省份信息
	 * @param provinceCheck
	 *            省份信息的勾选记录
	 * @return
	 */
	public static ITuanProvinceValue[] getTuanProvince(String tuanId, String province, String provinceCheck) {
		// log.info("getting group buy ProvinceValues...");
		// 将省份信息分隔
		String[] provinceList = province.split(TuanConstant.TUAN_PROVINCE_SPLIT_CODE);
		// 将省份状态信息分隔
		String[] provinceCheckList = provinceCheck.split(TuanConstant.TUAN_PROVINCE_SPLIT_CODE);
		List<ITuanProvinceValue> list = new ArrayList<ITuanProvinceValue>();
		ITuanProvinceValue value = null;
		for (int i = 0; i < provinceList.length; i++) {
			// 省份被选择
			if (TuanConstant.TUAN_PROVINCE_VALID_YES.equals(provinceCheckList[i])) {
				try {
					value = new TuanProvinceBean();
				} catch (AIException e) {
					log.error("exception occors when creating group buy TuanProvince object...",e);
					//e.printStackTrace();
				}
				// 设置团购省份信息状态为 新增
				// ID 由DAO生成
				value.setTuanId(Long.parseLong(tuanId));
				value.setLimitProv(provinceList[i]);
				list.add(value);
			}
		}
		return list.toArray(new ITuanProvinceValue[0]);
	}

	/**
	 * @purpose 根据团购ID，获得当前团购信息可修改的状态
	 * @param tuanId 团购ID
	 * @return
	 * @author liuyq
	 * @date
	 */
	public static String getTuanInfoStatus(String tuanId) {
		// 初始化数值为什么都不能修改
		String retVal = TuanConstant.TUAN_MODIFY_NONE_CAN_MODIFY;
		ITuanInfoValue value = null;
		// 传递过来的tuanId不为空
		if (!StringUtil.isBlank(tuanId)) {
			// 1、利用tuanId到数据库中查询团购信息
			ITuanInfoSrv tuanSrv = (ITuanInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_TUAN_INFO);
			try {
				value = tuanSrv.getTuanInfoById(tuanId);
			} catch (Exception e) {
				log.error("exception occors when getting group buy info ,please contact to adminstrator.",e);
			}
			if (null != value) {
				// 2、取得团购当前运行状态 （活动发布、活动创建、活动停止等）
				// String tuanStatus = value.getStatus();
				// 3、取得团购活动的开始时间与结束时间
				// Timestamp startTime = value.getStartTime();
				// Timestamp endTime = value.getEndTime();
				// 4、取得当前系统时间
				// Timestamp nowTime = DateTimeUtil.getNowTimeStamp();
				// 5、根据系统时间和团购开始时间、团购结束时间来判断团购可修改的状态
				retVal = getTuanModifyStatus(value.getStatus(), value.getStartTime(), value.getEndTime());
			}
		}
		// 6、返回结果（采用TuanConstant常量数据）
		return retVal;
	}

	/**
	 * 根据团购状态、团购开始时间、团购结束时间判断团购当前可修改的状态
	 * 
	 * @param status
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	private static String getTuanModifyStatus(String status, Timestamp startTime, Timestamp endTime) {
		String retVal = "";
		String timeStatus = getTuanTimeStatus(startTime, endTime);
		// log.info("current time of the group buy is " + timeStatus);

		if (TuanConstant.TUAN_STATUS_CREATE.equals(status)
				|| (TuanConstant.TUAN_STATUS_PUBLISH.equals(status) && TuanConstant.TUAN_STATUS_BEFORE_START
						.equals(timeStatus))) {
			// 团购活动修改状态为 全部可以修改
			// 可以全部修改的条件为(任意满足其一即可)：
			// 1、团购活动状态为创建。
			// 2、团购活动状态为发布，同时团购活动还没有开始
			retVal = TuanConstant.TUAN_MODIFY_ALL_CAN_MODIFY;
		} else if (TuanConstant.TUAN_STATUS_PUBLISH.equals(status)
				&& (TuanConstant.TUAN_STATUS_BETWEEN_START_END.equals(timeStatus) || TuanConstant.TUAN_STATUS_AFTER_END
						.equals(timeStatus))) {
			// 团购活动修改状态为部分可以修改
			// 可以部分修改的条件为(任意满足其一即可)：
			// 1、团购活动状态为发布，同时团购活动已经开始而且还没有结束
			// 2、团购活动状态为发布，同时团购活动已经结束
			retVal = TuanConstant.TUAN_MODIFY_PART_CAN_MODIFY;
		} else if (TuanConstant.TUAN_STATUS_STOP.equals(status)
				&& TuanConstant.TUAN_STATUS_AFTER_END.equals(timeStatus)) {
			// 团购活动修改状态为 全部不能修改
			// 条件为：团购活动状态为停止，同时团购活动已经结束
			retVal = TuanConstant.TUAN_MODIFY_NONE_CAN_MODIFY;
		} else {
			retVal = TuanConstant.TUAN_MODIFY_SITUATION_NOT_EXIST;
			log.error("error occors when getting group buy status ");
		}
		return retVal;
	}

	/**
	 * @purpose 根据团购活动的开始时间和结束时间，判断当前时间所处的区间范围
	 * @param startTime
	 *            团购开始时间
	 * @param endTime
	 *            团购结束时间
	 * @return TUAN_STATUS_BEFORE_START before 当前时间在团购开始时间之前
	 *         TUAN_STATUS_BETWEEN_START_END between当前时间在团购开始时间和结束时间之间
	 *         TUAN_STATUS_AFTER_END after 当前时间在团购结束时间之后
	 * 
	 */
	private static String getTuanTimeStatus(Timestamp startTime, Timestamp endTime) {
		Timestamp nowTime = DateTimeUtil.getNowTimeStamp();
		String retVal = "";
		if (nowTime.before(startTime)) {
			// 当前时间在团购开始时间之前
			retVal = TuanConstant.TUAN_STATUS_BEFORE_START;
		} else if (nowTime.after(startTime) && nowTime.before(endTime)) {
			// 当前时间在团购开始时间和结束时间之间
			retVal = TuanConstant.TUAN_STATUS_BETWEEN_START_END;
		} else if (nowTime.after(endTime)) {
			// 当前时间在结束时间之后
			retVal = TuanConstant.TUAN_STATUS_AFTER_END;
		}
		return retVal;
	}

	/**
	 * @purpose 根据团购Id 来获得当前团购活动的状态
	 * @param tuanId
	 * @return 团购的状态（活动创建，活动发布，活动停止）
	 */
	public static String getTuanRunningState(String tuanId) {
		String retVal = "";
		if (!StringUtil.isBlank(tuanId)) {
			ITuanInfoValue value = null;
			ITuanInfoSrv tuanSrv = (ITuanInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_TUAN_INFO);
			try {
				value = tuanSrv.getTuanInfoById(tuanId);
			} catch (Exception e) {
				log.error("exception occors when getting group buy info ,please contact to adminstrator.",e);
			}
			retVal = value.getStatus();
		}
		return retVal;
	}

	/**
	 * @purpose :根据团购id ,来获得当前团购活动的基本信息
	 * @param tuanId
	 * @return
	 */
	public static ITuanInfoValue getTuanInfoById(String tuanId) {
		ITuanInfoValue value = null;
		if (!StringUtil.isBlank(tuanId)) {
			ITuanInfoSrv tuanSrv = (ITuanInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_TUAN_INFO);
			try {
				value = tuanSrv.getTuanInfoById(tuanId);
			} catch (Exception e) {
				log.error("exception occors when getting group buy info ,please contact to adminstrator.",e);
			}
		}
		return value;
	}
	
	/**
	 * @purpose :获得团购图片根目录路径的地址
	 * @return
	 * 		路径地址，例如：/pic/tuan/
	 */
	public static String getTuanImgBasePath(){
		String imgPath = TuanConstant.PIC_TUAN_URL;
		if (imgPath.lastIndexOf("/") < 0 && imgPath.lastIndexOf("\\") < 0)
			imgPath += File.separator;
		String retFilePath = imgPath;
		if (!(retFilePath.endsWith("/") || retFilePath.endsWith("\\")))
			retFilePath = retFilePath + "/";
		retFilePath = retFilePath.replace("\\", "/");
		//log.info(retFilePath);
		return retFilePath;
	}
	
	public static String synchronousTuanInfoToHP(TuanInfoValueToHP value) throws Exception{
		
		String retValue = "";
		String retMsg;
	   // SettleCodeInBizRegReq in = SettleCodeInter.getSettleCodeInBean();
	    TuanInfoIncSynInBizRegReq in  = TuanInfoIncSynInter.getTuanInfoIncSynInBizRegReq();
	    in.setActionID(value.getActionID());
	    in.setActionName(value.getActionName());
	    in.setActionStartTime(value.getActionStartTime());
	    in.setActionEndTime(value.getActionEndTime());
	    in.setMaxParticNum(value.getMaxParticNum());
	    in.setMinParticNum(value.getMinParticNum());
	    in.setOptType(value.getOptType());
	    in.setOptOrderType(value.getOptOrderType());
	    
	    TuanInfoIncSynInItemInfo itemInfo  = in.addNewItemInfo();
	    TuanInfoIncSynInItemList itemList = itemInfo.addNewItemList();
	    itemList.setItemID(value.getItemID());
	    itemList.setMaxItemNum(value.getMaxItemNum());
	    
	    TuanInfoIncSynOutBizRegReq out  =null;
	    try{
			out = TuanInfoIncSynInter.doBusi(in);
			retValue = out.getRejectReason();
			retMsg = out.getErrorMsg();
			log.debug("==>" + retValue);
	        log.debug("==>" + retMsg);
		}catch (Exception e) {
			log.error("Called TuanInfoIncSynInter of HP error:"+e);
			throw new MgtTuanInterException("============ Called TuanInfoIncSynInter of HP Exception!");
	    }
	    return retValue;
	}
	/**
	 * 将TuanWareRLTValue 转换成为 TuanInfoValueToHP 对象
	 * @param tuanWareRlt  <p>团购信息与礼品信息关联表中的数据，该参数主要是用于传递团购活动ID与礼品ID，这部分数据可以从前台获得，也可以从后台拼装获得。</p>
	 * 						<p>如果前台没有获得团购ID与礼品ID信息，可以从后台新建一个对象(new TuanWareRLTBean()),然后将tuanId和wareId赋值进去。</p>
	 * @param tuanInfoValue <p>团购基本信息数据。该项主要对应的是从页面中收集到的团购信息数据，而非从数据库中读取的数据，</p>
	 * 						<p>如果页面中无法获得团购的最新数据，那么可以将参数传递为null。</p>
	 * @param optType  枚举型变量{01:(新增),02:(修改)}
	 * @param optOrderType  订单拆分类型，固定00(达到团兑数量下限即开始拆单)
	 * @return  TuanInfoValueToHP 
	 * @throws Exception 
	 */
	public static TuanInfoValueToHP convertTuanInfoValue(ITuanWareRLTValue tuanWareRlt,ITuanInfoValue tuanInfoValue,String optType,String optOrderType) throws Exception{
		TuanInfoValueToHP value = new TuanInfoValueToHP();
		//利用礼品ID 读取礼品编码
		if(log.isDebugEnabled()){
			log.debug("wareId :"+tuanWareRlt.getWareId());
			log.debug("tuanId :"+tuanWareRlt.getTuanId());
		}
		
		//如果没有传递过来礼品ID参数
		if(0 ==  tuanWareRlt.getWareId()){
			//去数据库中查询与团购tuanId相关的礼品ID(wareID),如果没有，肯定是数据库异常。
			ITuanWareRLTSrv tuanWareRltSrv = (ITuanWareRLTSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_TUANWARERLT_SRV);
			ITuanWareRLTValue tuanWareRltValue = tuanWareRltSrv.getTuanWareRLTById(tuanWareRlt.getTuanId()+"");
			if(null != tuanWareRltValue){
				tuanWareRlt.setWareId(tuanWareRltValue.getWareId());
			}else{
				throw new MgtTuanException("error occors when trying to get items from tuan_ware_rlt  by tuanId.");
			}
		}
		IWareInfoSrv wareInfoSrv = (IWareInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_WARE_INFO);
		IWareInfoValue wareValue  = wareInfoSrv.getBean(tuanWareRlt.getWareId());
		
		//肯定能取到一个礼品的实体bean？但是如果没有记录，就没有礼品编码
		if(null != wareValue && !StringUtil.isBlank(wareValue.getWareCode())){
			if(log.isDebugEnabled()){
				log.debug("wareValue wareCode is :"+wareValue.getWareCode());
			}
			value.setItemID(wareValue.getWareCode());
		}
		
		//利用团Id读取团购基本信息数据
		ITuanInfoSrv tuanInfoSrv = (ITuanInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_TUAN_INFO);
		ITuanInfoValue tuanValue  = new TuanInfoBean();
		if(null == tuanInfoValue){
			//前台不提供数据，那么去数据库中查询最新的数据
			tuanValue = tuanInfoSrv.getTuanInfoById(tuanWareRlt.getTuanId()+"");

		}else{
			//将对象赋值
			tuanValue = tuanInfoValue;
		}
		
		
		if(null!=tuanValue){
			value.setActionStartTime(convertTimestampToStr(tuanValue.getStartTime()));
			value.setActionEndTime(convertTimestampToStr(tuanValue.getEndTime()));
			// 02 + tuanId  为同步给HP的团购ID
			value.setActionID(TuanConstant.TUAN_INFO_SYN_HP_TUAN_ID_PREFIX+tuanValue.getTuanId());
			//同步的为礼品Code，而非礼品ID
			//value.setItemID(tuanWareRlt.getTuanId()+"");
			
			value.setActionName(tuanValue.getName());
			//团购信息表:最低人数限制
			value.setMinParticNum((int) tuanValue.getMinCount());

			//团购信息表:最大团购量  无限制：-1
			int maxParticNum = -1;
			maxParticNum = (int) (tuanValue.getMaxCount() == TuanConstant.TUAN_MAX_AMOUNT_BUY?-1:tuanValue.getMaxCount());
			value.setMaxParticNum(maxParticNum);
		
			//团购信息表:单人最大上限 无限制：-1
			int maxItemNum = -1;
			maxItemNum = (int) (tuanValue.getOneMaxCount() == TuanConstant.TUAN_MAX_AMOUT_SINGLE_BUY?-1:tuanValue.getOneMaxCount());
			value.setMaxItemNum(maxItemNum);
			
			//订单拆分类型，固定数值00(达到团兑数量下限即开始拆单。)
			value.setOptOrderType(optOrderType);
			value.setOptType(optType);
		}
		return value;
	}
	
	
	/**
	 * 将Timestamp 时间转换成为字符串
	 * 例如：2011-8-31 12:51:36 转换成为20110831125136
	 * @param time
	 * @return
	 */
	public static String convertTimestampToStr(Timestamp time){
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return df.format(time);
	}
	
	
	
	/**
	 * 根据团购ID，礼品ID，和页面中团购的基本信息，判断团购信息是否要同步给HP。
	 * @param tuanId 团购ID
	 * @param wareId 礼品ID
	 * @param value  页面中团购的基本信息(如果在绑定礼品页面，那么value =null 标识不用比较)
	 * @return
	 */
	public static boolean isNeedSynTuanInfoToHP(long tuanId,long wareId,ITuanInfoValue value,String actionType){
		boolean needSyn = false;
		ITuanWareRLTSrv tuanWareRltSrv = (ITuanWareRLTSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_TUANWARERLT_SRV);
		ITuanInfoSrv tuanInfoSrv = (ITuanInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_TUAN_INFO);

		//如果wareId ==0，标识发起团购同步的操作为保存团购基本信息，也就是wareId肯定没有变化，所以wareId不用比较
		try {
			ITuanInfoValue tuanValue = tuanInfoSrv.getTuanInfoById(tuanId+"");
			//发出请求判断的操作不是由，绑定并发布按钮触发的
			if( null!=tuanValue){
				//团购活动状态为创建，同时点击了发布按钮，那么发送报文
				if(TuanConstant.ACTION_PUBLISH_TUAN_WARE_BIND.equals(actionType) && TuanConstant.TUAN_STATUS_CREATE.equals(tuanValue.getStatus())){
					needSyn = true;
					//这里直接返回数值不符合规范，以后再做修改。。。
					return needSyn;
				}
				//团购活动都没有发布，那么不发送任何报文
				if(!TuanConstant.TUAN_STATUS_PUBLISH.equals(tuanValue.getStatus())){
					needSyn = false;
					return needSyn;
				}
			}else{
				//如果利用团购ID没有查询到tuan_info表中查询到数据
				throw new MgtTuanException("cann't get instance of tuan_info from databases.");
			}
			if(0 == wareId){
				//比较的数据有：团购开始时间，团购结束时间，团购名称，团购最低人数限制，单人购买上限，总购买上限
				if(!tuanValue.getName().equals(value.getName())
						||!tuanValue.getStartTime().equals(value.getStartTime())
						||!tuanValue.getEndTime().equals(value.getEndTime())
						||tuanValue.getMaxCount() != value.getMaxCount()
						||tuanValue.getMinCount() != value.getMinCount()
						||tuanValue.getOneMaxCount() != value.getOneMaxCount()){
					//上述信息发生了变化，需要进行同步
					needSyn = true;
				}
				//如果value 中数据{}数据一致，那么不进行同步
			}
		} catch (Exception e) {
			log.error("error occors when trying to get tuanInfoValue by tuanId = "+tuanId,e);

		}
		
		//如果value == null 表示团购同步过程为绑定礼品时发生的，所以没必要比较ITuanInfoValue中的数据，
		//只需要比较wareId是否一致就可以。
		if(null == value){
			//如果wareId一致，那么不需要进行同步
			try {
				ITuanWareRLTValue tuanWareRltValue = tuanWareRltSrv.getTuanWareRLTById(tuanId+"");
				log.debug("wareId is :"+wareId);
				//如果wareId不一致，需要同步给HP
				if(null !=tuanWareRltValue ){
					//存在团购与礼品的关联信息
					if( wareId != tuanWareRltValue.getWareId()){
						needSyn = true;
					}else{
						//但是原来的礼品ID与新的礼品ID相同
						needSyn = false;
					}
				}else{
					//不存在礼品与团购的关联信息，所以需要进行同步
					needSyn = true;

				}
			} catch (Exception e) {
				log.error("error occors when trying to get tuanWareRLTValue by tuanId = "+tuanId,e);
			}
		}
		
		return needSyn;
	}
	/**
	 * by luohuan 2012-11-29
	 * 
	 * 根据相应参数，获得轮转的数据的开始索引和结束索引
	 * @param cycle 轮转周期
	 * @param startTime 轮转开始时间
	 * @param count 需要轮转的礼品总条数
	 * @param showCount 展示轮转礼品的条数
	 * @return
	 */
	public static PageBean getSpellIndex(int cycle,Timestamp startTime,int count,int showCount){
    	
		PageBean page = new PageBean();
		int sta = 0; //开始下标
		int end = 0;  //结束下标
		try {
			// 计算 当前系统时间毫秒数 与 轮换开始时间毫秒数 差值
			long countTime = System.currentTimeMillis() - startTime.getTime();
			// 计算当前时间距轮换时间共相差多少小时
			int apartHour = Integer.parseInt(DateTimeUtil.formatTimeDuringHour(countTime)); 
			//轮转已经开始
			if(apartHour >= 0){
				cycle = cycle == 0 ? 1 : cycle; //被除数不能为0
				int result = apartHour / cycle;
				//1、计算起始下标
				if(result < count){ //情况1：result < count
					sta = result  + 1;
				}else{   			//情况2:result >= count
					sta = (result%count)+1;
				}
				//2、计算结束下标
				end  = (sta + showCount)-1;
				if(end >= count){
					end = count;
				}
			}else{
				sta = 1;
				end = Math.min(showCount, count);
			}
			
			page.setStartNum(sta);
			page.setEndNum(end);
		} catch (Exception e) {
			//日志记录
			log.error("this method getSpellIndex error " +
					"cycle:"+cycle+" startTime:"+startTime+" count:"+count+" showCount:"+showCount);
			return null;
		}
		return page;
    }
	
	
	
	public static void main(String[] args) {
		 
		 //测试 getSpellIndex 方法

		int showCount = 3;
		int count = 4;
		int cycle = 1;
		PageBean page = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date date = format.parse("2012-11-29 18:00:00");
			
			page = getSpellIndex( cycle, new Timestamp(date.getTime()), count, showCount);
			
			System.out.println("startIndex>>>"+page.getStartNum()+"  endIndex>>>"+page.getEndNum());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	 }
	
}
