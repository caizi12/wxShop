package ngves.asiainfo.core.donated.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ngves.asiainfo.core.common.dao.interfaces.IClobInfoDAO;
import ngves.asiainfo.core.donated.DonatedConstant;
import ngves.asiainfo.core.donated.bo.ActivityObjectsRltBean;
import ngves.asiainfo.core.donated.bo.ActivityObjectsRltEngine;
import ngves.asiainfo.core.donated.bo.DonatedActivityEngine;
import ngves.asiainfo.core.donated.bo.DonatedPicEngine;
import ngves.asiainfo.core.donated.dao.interfaces.IDonatedActivityDAO;
import ngves.asiainfo.core.donated.exception.MgtDonatedException;
import ngves.asiainfo.core.donated.ivalues.IActivityObjectsRltValue;
import ngves.asiainfo.core.donated.ivalues.IActivityWareRltValue;
import ngves.asiainfo.core.donated.ivalues.IDonatedActivityValue;
import ngves.asiainfo.core.donated.ivalues.IDonatedPicValue;
import ngves.asiainfo.core.donated.ivalues.IQBODonatedObjectRltValue;
import ngves.asiainfo.core.donated.ivalues.IQBODonatedWareBindValue;
import ngves.asiainfo.core.donated.ivalues.IQBODonatedWareInfoValue;
import ngves.asiainfo.core.donated.ivalues.IQBOWareObjectRltValue;
import ngves.asiainfo.core.donated.service.interfaces.IDonatedActivitySrv;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.AIException;


public class DonatedActivitySrvImpl implements IDonatedActivitySrv {

	private Log log = LogFactory.getLog(DonatedActivitySrvImpl.class);
	private IDonatedActivityDAO donatedActivityDAO;
	private IClobInfoDAO clobInfoDAO;
	public void setDonatedActivityDAO(IDonatedActivityDAO donatedActivityDAO) throws Exception {
		this.donatedActivityDAO = donatedActivityDAO;
	}

	public void setClobInfoDAO(IClobInfoDAO clobInfoDAO) throws Exception{
		this.clobInfoDAO = clobInfoDAO;
	}

	public IDonatedActivityValue getDonatedActivityById(String donatedActivityId) throws Exception {
		long donatedId = Long.parseLong(donatedActivityId);
		IDonatedActivityValue value  = donatedActivityDAO.getDonatedActivityById(donatedId);
		//从Clob_info表中查询 出对应的富文本信息
		String content = clobInfoDAO.getContent(donatedId, DonatedConstant.DONATED_ACTIVITY_TABLE_NAME);
		value.setDonatedDesc(content);
		return value;
	}

	public long saveNewDonatedActivity(IDonatedActivityValue value) throws Exception {
		//前台保证操作为新增操作，并不涉及到修改操作
		value.setStsToNew();
		long donatedActivityId  = DonatedActivityEngine.getNewId().longValue();
		//设置了最新的ID
		value.setDonatedId(donatedActivityId);
		value.setDonatedName(value.getDonatedName().trim());
		value.setDonatedCode(value.getDonatedCode().trim());
		//设置创建时间
		value.setCreateDate(DateTimeUtil.getNowTimeStamp());
		//创建状态
		value.setStatus(DonatedConstant.DONATED_ACTIVITY_STATUS_CREATE);
		String content = value.getDonatedDesc();
		//不将富文本信息存储到数据表中
		value.setDonatedDesc("");
		donatedActivityId = donatedActivityDAO.saveDonatedActivity(value);
		//将富文本信息存储到Clob数据表中
		clobInfoDAO.saveClobInfo(donatedActivityId, DonatedConstant.DONATED_ACTIVITY_TABLE_NAME, StringUtils.trimToEmpty(content));

		return donatedActivityId;
	}



	public long updateDonatedActivity(IDonatedActivityValue value) throws Exception {
		value.setStsToOld();

		value.setDonatedName(value.getDonatedName().trim());
		value.setDonatedCode(value.getDonatedCode().trim());
		value.setActivityPicId(value.getActivityPicId());
		value.setBeginTime(value.getBeginTime());
		value.setEndTime(value.getEndTime());
		value.setDiliverType(value.getDiliverType());
		value.setDonatedCode(value.getDonatedCode());

		long donatedActivityId = value.getDonatedId();
		String content =  value.getDonatedDesc();
		//捐赠基本信息表中，不保存富文本信息
		value.setDonatedDesc("");
	
		clobInfoDAO.saveClobInfo(donatedActivityId, DonatedConstant.DONATED_ACTIVITY_TABLE_NAME, StringUtils.trimToEmpty(content));

		donatedActivityDAO.saveDonatedActivity(value);
		log.info("modify donated Activity "+value.getAppVersion());
		return value.getAppVersion();
	}

	
	/**
	 * @author luohuan
	 * @return 捐赠活动信息列表
	 * @throws Exception 
	 */
	public IDonatedActivityValue[] queryDonotedActivity(
			String donotedActivityName, int startIndex, int endIndex) throws Exception {
		
		return donatedActivityDAO.queryDonotedActivity(donotedActivityName, startIndex, endIndex);
	}
	/**
	 * @author luohuaa
	 * @return 信息总条数
	 * @throws Exception 
	 */
	public int queryDonotedActCount(String donotedActivityName) throws Exception {
		
		return donatedActivityDAO.queryDonotedActCount(donotedActivityName);
	}

	public long saveDonatedPic(IDonatedPicValue value) throws Exception {
		//新建积分捐赠活动
		value.setStsToNew();
		long id = DonatedPicEngine.getNewId().longValue();
		value.setActivityPicId(id);
		long donatedPicId = donatedActivityDAO.saveDonatedPic(value);
		return donatedPicId;
	}

	public long updateDonatedPic(IDonatedPicValue value) throws Exception {
		//该语句的顺序不能乱
		value.setStsToOld();
		//更新捐赠活动图片操作
		value.setBgcolor(value.getBgcolor());
		value.setBgPic(value.getBgPic());
		value.setBottomPx(value.getBottomPx());
		value.setDescPic(value.getDescPic());
		value.setLeftPx(value.getLeftPx());
		value.setMainPic(value.getMainPic());
		value.setRightPx(value.getRightPx());
		value.setTopPx(value.getTopPx());
		
		long donatedPicId = donatedActivityDAO.saveDonatedPic(value);
		return donatedPicId;
	}

	//删除捐赠活动
	public void delDonatedActy(String donatedId) throws Exception {
		IDonatedActivityValue donatedAct = DonatedActivityEngine.getBean(Long.parseLong(donatedId));
		
		//删除捐赠活动关联的   捐赠活动对象关系 信息
		StringBuffer condition = new StringBuffer(" 1=1 ");
        Map<String,String> parameter = new HashMap<String,String>();
        //从数据为中查出对应的IActivityObjectsRltValue 
        condition.append(" and ").append(IActivityObjectsRltValue.S_ActivityId).append(" LIKE :").append(IActivityObjectsRltValue.S_ActivityId); 
        parameter.put(IActivityObjectsRltValue.S_ActivityId, "%" + donatedAct.getDonatedId() + "%");
        IActivityObjectsRltValue[] actyObjectRlt = donatedActivityDAO.getActivityObjectsRltValue(condition.toString(), parameter);
        if(null != actyObjectRlt && actyObjectRlt.length>0){
        	for(int i=0;i<actyObjectRlt.length;i++){
        		actyObjectRlt[i].delete();
        	   // ActivityObjectsRltEngine.save(actyObjectRlt[i]);
        	}
        	ActivityObjectsRltEngine.save(actyObjectRlt);
        }
        
        //删除与捐赠活动关联的图片信息
        IDonatedPicValue donatedPic = donatedActivityDAO.getDonatedPicValueById(donatedAct.getActivityPicId());
        if(!donatedPic.isNew()){
        	donatedPic.delete();
            DonatedPicEngine.save(donatedPic);
        }
        
        //删除与捐赠活动关联的捐赠说明信息
        clobInfoDAO.deleteClobInfo(donatedAct.getDonatedId(), DonatedConstant.DONATED_ACTIVITY_TABLE_NAME);
        
        //删除捐赠活动
        donatedAct.delete();
		DonatedActivityEngine.save(donatedAct);	
	}
	
	

	//提前结束一个捐赠活动
	public void earlyStopDonated(String donatedId) throws Exception {
		//等待完善
		//同步HP接口

	}

	public boolean isExistSameName(String donatedActivityName) throws Exception {
		boolean isExistSameName = false;
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		if(!StringUtil.isBlank(donatedActivityName)){
			condition.append(" and ").append(IDonatedActivityValue.S_DonatedName).append("=:").append(IDonatedActivityValue.S_DonatedName);
			parameter.put(IDonatedActivityValue.S_DonatedName, donatedActivityName);
		}
		IDonatedActivityValue [] value = donatedActivityDAO.getDonatedActivityValue(condition.toString(),parameter);
		if(null != value && value.length > 0){
			isExistSameName = true;
		}
		//if(null != value && value.length > 1){
		//	throw new MgtDonatedException("there exist the wrong data in table DONATED_ACTIVITY,the same name is "+donatedActivityName+"!");
		//}
		return isExistSameName;
	}

	public IDonatedPicValue getDonatedPicById(String donatedPicId) throws Exception {
		long picId = Long.parseLong(donatedPicId);
		IDonatedPicValue value = donatedActivityDAO.getDonatedPicValueById(picId);
		return value;
	}

	public IQBODonatedObjectRltValue[] queryDonatedObjectInfo(String donatedActivityId) throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String,String> map = new HashMap<String,String>();
		IQBODonatedObjectRltValue[] value = null;
		//如果ID为空，返回空对象
		if(!StringUtil.isBlank(donatedActivityId)){
			condition.append(" AND ").append(IQBODonatedObjectRltValue.S_ActivityId).append("=:").append(IQBODonatedObjectRltValue.S_ActivityId).append(" ");
			map.put(IQBODonatedObjectRltValue.S_ActivityId, donatedActivityId.trim());
			value =donatedActivityDAO.getDonatedObjectRltValue(condition.toString(), map);
		}
		return value;
	}

	public String saveDonatedObjectRltValue(long donatedActivityId,String objectIdArray) throws Exception {
		//TODO 保存函数时，是否要考虑到并发，一个积分捐赠活动donatedActivityID和一个捐赠对象donatedObjectID，两条ID记录的组合应该是唯一的
		
		//如果保存中，对数量的限制不应该只体现在页面中，同时在服务层，对界面中的数据条数进行判断。
		
		/*利用donatedActivityID去数据库中查询，当前捐赠活动已经保存了的记录数oldNum ,同时页面中的数据个数为newNum
		 * 如果oldNum + newNum > 最大数量(暂定10) 那么直接抛出异常 ，Web服务器捕捉到异常信息，提示用户“数据数量已经超过限制或者数据已经更新，请刷新页面”
		 * 
		 * */
		StringBuffer cond = new StringBuffer(" 1=1 ");
		Map<String,String> map = new HashMap<String,String>();
		cond.append(" AND ").append(IQBODonatedObjectRltValue.S_ActivityId).append("=:").append(IQBODonatedObjectRltValue.S_ActivityId);
		map.put(IQBODonatedObjectRltValue.S_ActivityId, String.valueOf(donatedActivityId));
		IQBODonatedObjectRltValue []value = donatedActivityDAO.getDonatedObjectRltValue(cond.toString(), map);
		int oldNum = 0 , newNum = 0;
		if(null != value && value.length > 0 ){
			log.debug(" value.length is "+ value.length);
			oldNum=value.length;
		}
		int i = 0 ;
		List<IActivityObjectsRltValue> list = new ArrayList<IActivityObjectsRltValue>();
		IActivityObjectsRltValue tmpValue = null;
		String []idArray = objectIdArray.split(DonatedConstant.SEPARATE_CHAR_COMMA);
		long objectId = 0L;
		if(null != idArray && idArray.length > 0){
			log.debug("idArray.length" +idArray.length);
			//防止出现0001,00002,,,0003的情况
			//newNum=idArray.length;
			boolean isValid = true;
			for(i=0;i<idArray.length;i++){
				if(!StringUtil.isBlank(idArray[i].trim())){
					objectId = Long.parseLong(idArray[i].trim());
					//判断该条记录是否有效
					for(int j=0;j<value.length;j++){
						if(value[j].getObjectId() == objectId){
							System.out.println("objectId is "+objectId +":"+value[j].getObjectId());
							isValid = false;
							break;
						}
					}
					//只记录有效的数据
					if(isValid){
						tmpValue = new ActivityObjectsRltBean();
						tmpValue.setActivityId(donatedActivityId);
						tmpValue.setObjectId(objectId);
						tmpValue.setRltId(ActivityObjectsRltEngine.getNewId().longValue());
						tmpValue.setStsToNew();
						list.add(tmpValue);
						//只统计有效的数据记录
						newNum++;
					}
					isValid = true;
				}
			}
		}
		//数量超过限制  不准许提交
		if(oldNum + newNum > Integer.parseInt(DonatedConstant.DONATED_OBJECT_RLT_MAX_NUM)){
			// 注意：可能向上抛出NumberFormatException  Action层要做出处理
			//这里可以向上抛出一个异常，表示存在数据异常信息(可能存在并发操作，提示用户数据已经更新，请刷新页面)
			throw new MgtDonatedException(" there occors the exception that the number of items is beyond the limited number 10 ");
		}
	
		StringBuffer idBuffer =  new StringBuffer();
		long activityObjectRltId = 0L;
		//组成一个对象数组，然后存储起来
		if(null!=list && list.size()>0){
			//这里保存数组会更好，但是为了实现更新时的复用，所以暂定采用单个保存的方式
			for(i=0;i<list.size();i++){
				activityObjectRltId = donatedActivityDAO.saveDonatedObjectRltValue(list.get(i));
				idBuffer.append(activityObjectRltId).append(DonatedConstant.SEPARATE_CHAR_COMMA);
			}
			idBuffer.substring(0, idBuffer.length() - DonatedConstant.SEPARATE_CHAR_COMMA.length());
		}
		log.debug("new idAarray is "+idBuffer.toString());
		return idBuffer.toString();
	}

	public String updateDonatedObjectRltValue(IQBODonatedObjectRltValue[] value) throws Exception {
		
		//TODO 更新捐赠活动与捐赠对象关系
		
		//将IQBODonatedObjectRltValue 转换成为 IActivityObjectsRltValue
		//IActivityObjectsRltValue[] rltValue   = convertToActivityObjectRltBean(value);
		String appVersion = "";
		IActivityObjectsRltValue[] rltValue = null;
		if(null != value && value.length > 0){
			rltValue = new ActivityObjectsRltBean[value.length];
			for(int i=0;i<value.length;i++){
				//有可能出现转换异常，抛给Web服务器
				rltValue[i] = new ActivityObjectsRltBean();
				//为新建的对象赋值
				rltValue[i].setRltId(value[i].getRltId());
				rltValue[i].setActivityId(value[i].getActivityId());
				rltValue[i].setDonatedI(value[i].getDonatedI());
				rltValue[i].setDonatedM(value[i].getDonatedM());
				rltValue[i].setDonatedWare(value[i].getDonatedWare());
				rltValue[i].setObjectId(value[i].getObjectId());
				rltValue[i].setAppVersion(value[i].getAppVersion());
				rltValue[i].setObjectSort(value[i].getObjectSort());
				//将IActivityObjectsRltValue 设置为更新
				//注意：更新时，不应该设定app_version字段
				rltValue[i].setStsToOld();
				rltValue[i].setRltId(rltValue[i].getRltId());
				rltValue[i].setActivityId(rltValue[i].getActivityId());
				rltValue[i].setDonatedI(rltValue[i].getDonatedI());
				rltValue[i].setDonatedM(rltValue[i].getDonatedM());
				rltValue[i].setDonatedWare(rltValue[i].getDonatedWare());
				rltValue[i].setObjectId(rltValue[i].getObjectId());
				rltValue[i].setObjectSort(rltValue[i].getObjectSort());
				donatedActivityDAO.saveDonatedObjectRltValue(rltValue[i]);
				appVersion +=rltValue[i].getAppVersion()+DonatedConstant.SEPARATE_CHAR_COMMA;
			}
			if(!StringUtil.isBlank(appVersion)){
				appVersion = appVersion.substring(0, appVersion.length() - DonatedConstant.SEPARATE_CHAR_COMMA.length());
			}
		}

		//分开保存每条记录
		return appVersion;
	}

	public void deleteDonatedObjectRltValue(String idArray) throws Exception {
		// 删除积分捐赠活动与对象的绑定关系
		
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String,String> map = new HashMap<String,String>();
		IActivityObjectsRltValue [] value = null;
		String idStr = "";
		//1、利用ID信息，查询出满足的数据
		if(!StringUtil.isBlank(idArray)){
			StringBuffer idBuffer = new StringBuffer();
			String [] ids = idArray.split(DonatedConstant.SEPARATE_CHAR_COMMA);
			if(null != ids && ids.length > 0){
				for(int i=0;i<ids.length;i++){
					if(!StringUtil.isBlank(ids[i])){
						idBuffer.append("'").append(ids[i]).append("',");
					}
				}
				idStr = idBuffer.substring(0,idBuffer.length()-1);
				log.info("idStr"+idStr);
			}
			condition.append(" AND ").append(IQBODonatedObjectRltValue.S_RltId).append(" in (").append(idStr).append(")");
			value = donatedActivityDAO.getActivityObjectsRltValue(condition.toString(), map);
		}
		//2、删除数据
		if(null != value && value.length > 0){
			for(int i=0;i<value.length;i++){
				value[i].delete();
				//donatedActivityDAO.saveDonatedObjectRltValue(value[i]);
			}
			donatedActivityDAO.saveDonatedObjectRltValue(value);
		}
		
	}
	/**
	 * 将前台QBO的值转换成为单个表的bean，方便存储
	 * @param value
	 * @return
	 * @throws AIException 
	 */
	@SuppressWarnings("unused")
	private IActivityObjectsRltValue [] convertToActivityObjectRltBean(IQBODonatedObjectRltValue[] value) throws AIException{
		IActivityObjectsRltValue[] rltValue = null;
		if(null != value && value.length > 0){
			rltValue = new ActivityObjectsRltBean[value.length];
			for(int i=0;i<value.length;i++){
				//有可能出现转换异常，抛给Web服务器
				rltValue[i] = new ActivityObjectsRltBean();
				rltValue[i].setStsToOld();
				rltValue[i].setRltId(value[i].getRltId());
				rltValue[i].setActivityId(value[i].getActivityId());
				rltValue[i].setDonatedI(value[i].getDonatedI());
				rltValue[i].setDonatedM(value[i].getDonatedM());
				rltValue[i].setDonatedWare(value[i].getDonatedWare());
				rltValue[i].setObjectId(value[i].getObjectId());
				rltValue[i].setAppVersion(value[i].getAppVersion());
				rltValue[i].setObjectSort(value[i].getObjectSort());
			}
		}
		return rltValue;
	}

	public int getDonatedWareInfoCount(String wareCode, String wareName) throws Exception {
		String condition  = getDonatedWareInfoCondition(wareCode,wareName);
		Map<String,String> parameter = new HashMap<String,String>();
		int count = donatedActivityDAO.getDonatedWareInfoCount(condition, parameter);
		return count;
	}

	public IQBODonatedWareInfoValue[] getDonatedWareInfoValue(String wareCode, String wareName, int startIndex,
			int endIndex) throws Exception {
		String condition  = getDonatedWareInfoCondition(wareCode,wareName);
		Map<String,String> parameter = new HashMap<String,String>();
		IQBODonatedWareInfoValue[] value = donatedActivityDAO.getDonatedWareInfoValue(condition, parameter, startIndex, endIndex);
		return value;
	}

	/**
	 * 获得根据礼品名称和礼品编码查询捐赠类型礼品的查询条件
	 * @param wareCode 礼品编码 
	 * @param wareName 礼品名称
	 * @return
	 */
	private String getDonatedWareInfoCondition(String wareCode,String wareName){
		StringBuffer condition = new StringBuffer("  1=1 ");
		if(!StringUtil.isBlank(wareName)){
			condition.append(" and ").append(IQBODonatedWareInfoValue.S_WareName).append(" like '%").append(wareName).append("%' ");
		}
		if(!StringUtil.isBlank(wareCode)){
			condition.append(" and ").append(IQBODonatedWareInfoValue.S_WareCode).append(" like '%").append(wareCode).append("%' ");
		}
		return condition.toString();
	}

	public IQBODonatedWareBindValue[] queryDonatedWareRltInfo(String donatedActivityId) throws Exception {
		IQBODonatedWareBindValue[] value = null;
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		if(!StringUtil.isBlank(donatedActivityId)){
			parameter.put("ACITVITY_ID", donatedActivityId);
			log.info("donatedActivityId"+donatedActivityId);
			value = donatedActivityDAO.getDonatedWareBindValue(condition.toString(), parameter);
		}
		return value;
	}

	public String getWareBindObjectId(long donatedWareId, long donatedActivityId) throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		
		StringBuffer retStrBuffer = new StringBuffer();
		String retStr = "";
		if(0L != donatedWareId && 0L != donatedActivityId){
			condition.append(" and ").append(IQBOWareObjectRltValue.S_WareId).append("=:").append(IQBOWareObjectRltValue.S_WareId);
			parameter.put(IQBOWareObjectRltValue.S_WareId, String.valueOf(donatedWareId));
			condition.append(" and ").append(IQBOWareObjectRltValue.S_ActivityId).append("=:").append(IQBOWareObjectRltValue.S_ActivityId);
			parameter.put(IQBOWareObjectRltValue.S_ActivityId, String.valueOf(donatedActivityId));
		}
		IQBOWareObjectRltValue[] value = donatedActivityDAO.getWareObjectRltValue(condition.toString(), parameter);
		//如果value不为空，并且有数据
		if(null != value && value.length > 0){
			//将与该礼品ID，活动ID都相关的捐赠对象ID拼接成一个字符串，用','(英文半角逗号)分割
			for(int i=0;i<value.length;i++){
				retStrBuffer.append(value[i].getObjectId()).append(DonatedConstant.SEPARATE_CHAR_COMMA);
			}
			//去除最后的逗号
			retStr = retStrBuffer.substring(0, retStrBuffer.length()-DonatedConstant.SEPARATE_CHAR_COMMA.length());
		}
		return retStr;
	}

	public void publishDonatedActivity(long donatedActivityId) throws Exception {
		//1、根据ID查询出捐赠活动
		IDonatedActivityValue value = donatedActivityDAO.getDonatedActivityById(donatedActivityId);
		//2、根据捐赠活动的状态，判断是否可以进行发布
		if(null != value){
			if(DonatedConstant.DONATED_ACTIVITY_STATUS_CREATE == value.getStatus()){
				//3、如果可以发布，发布该活动
				value.setStatus(DonatedConstant.DONATED_ACTIVITY_STATUS_PUBLISH);
				//TODO 生成URL地址
				
				donatedActivityDAO.saveDonatedActivity(value);
			}else{
				throw new MgtDonatedException(" the status of donated activity is not create,can not publish");
			}
		}else{
			throw new MgtDonatedException(" the donated activiyt does not exist.");
		}
	}
	
	public void saveDonatedWareRltInfo(IQBODonatedWareBindValue [] value,long donatedActivityId) throws Exception{
		//1、遍历当前数组，获得礼品ID 和 顺序
		if(null == value || value.length == 0){
			return;
		}
		long wareId = 0L;
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		log.debug("donatedActivityId is :"+donatedActivityId);
		for(int i=0;i<value.length;i++){
			//2、利用礼品ID，捐赠活动ID，查询出所有符合该条件的捐赠对象信息
			wareId = value[i].getWareId();
			log.debug("wareId is "+wareId);
			condition.append("and").append(IActivityWareRltValue.S_DonatedId).append("=:").append(IActivityWareRltValue.S_DonatedId);
			condition.append("and").append(IActivityWareRltValue.S_WareId).append("=:").append(IActivityWareRltValue.S_WareId);
			
			parameter.put(IActivityWareRltValue.S_DonatedId, String.valueOf(donatedActivityId));
			parameter.put(IActivityWareRltValue.S_WareId, String.valueOf(wareId));
			
			IActivityWareRltValue[] objectValue = donatedActivityDAO.getActivityWareRltValue(condition.toString(), parameter);
			
			if(null != objectValue && objectValue.length > 0){
				log.debug("objectValue.length is "+objectValue.length);
				//3、将顺序统一赋值给这些对象
				for(int j=0;j<objectValue.length;j++){
					objectValue[j].setWareSort(value[i].getWareSort());
				}
				donatedActivityDAO.saveActivityWareRltValue(objectValue);
			}
			//重置查询条件
			condition = new StringBuffer(" 1=1 ");
			parameter.clear();
		}
		
	}
}
