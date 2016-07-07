package ngves.asiainfo.core.donated.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ngves.asiainfo.core.donated.DonatedConstant;
import ngves.asiainfo.core.donated.bo.ActivityWareRltBean;
import ngves.asiainfo.core.donated.bo.ActivityWareRltEngine;
import ngves.asiainfo.core.donated.dao.interfaces.IDonatedActivityDAO;
import ngves.asiainfo.core.donated.dao.interfaces.IDonatedObjectDAO;
import ngves.asiainfo.core.donated.ivalues.IActivityObjectsRltValue;
import ngves.asiainfo.core.donated.ivalues.IActivityWareRltValue;
import ngves.asiainfo.core.donated.ivalues.IQBOWareObjectRltValue;
import ngves.asiainfo.core.donated.service.interfaces.IDonatedWareSrv;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DonatedWareSrvImpl implements IDonatedWareSrv {
	private Log log = LogFactory.getLog(DonatedWareSrvImpl.class);

	private IDonatedActivityDAO donatedActivityDAO;
	
	//该变量以后会使用，误删除
	@SuppressWarnings("unused")
	private IDonatedObjectDAO donatedObjectDAO;
	public void setDonatedActivityDAO(IDonatedActivityDAO donatedActivityDAO) throws Exception {
		this.donatedActivityDAO = donatedActivityDAO;
	}

	public void setDonatedObjectDAO(IDonatedObjectDAO donatedObjectDAO) throws Exception {
		this.donatedObjectDAO = donatedObjectDAO;
	}
	
	public void bindDonatedWareRltValue(long donatedActivityId, String wareIdArray) throws Exception {
		StringBuffer condition= new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		
		//业务规则：为捐赠活动绑定礼品，默认将该礼品与所有对象(本活动绑定的对象)绑定
		String[] wareIds = null;
		List<IActivityWareRltValue> list = new ArrayList<IActivityWareRltValue>();
		
		if(!StringUtil.isBlank(wareIdArray)){
			wareIds = wareIdArray.split(DonatedConstant.SEPARATE_CHAR_COMMA);
		}
		
		//查询出所有与捐赠活动绑定的捐赠对象信息
		if(0 != donatedActivityId){
			condition.append(" and ").append(IActivityObjectsRltValue.S_ActivityId).append("=:").append(IActivityObjectsRltValue.S_ActivityId);
			parameter.put(IActivityObjectsRltValue.S_ActivityId, String.valueOf(donatedActivityId));
		}
		IActivityObjectsRltValue [] objArray = donatedActivityDAO.getActivityObjectsRltValue(condition.toString(),parameter);
		//遍历捐赠活动信息，获得捐赠活动ID ,并且前台有礼品信息
		if(null != objArray && objArray.length > 0 && null != wareIds && wareIds.length > 0){
			IActivityWareRltValue tmp  = null;
			for(int i=0;i<objArray.length;i++){
				for(int j=0;j<wareIds.length;j++){
					//如果存在并发操作，该记录已经插入数据库，那么不进行任何操作
					if(!isExistRecode(donatedActivityId,objArray[i].getObjectId(),Long.parseLong(wareIds[j].trim()))){
						//将捐赠对象ID，捐赠礼品ID  新建成为一个bean 保存起来
						tmp = new ActivityWareRltBean();
						tmp.setStsToNew();
						tmp.setRltId(ActivityWareRltEngine.getNewId().longValue());
						tmp.setObjectId(objArray[i].getObjectId());
						tmp.setWareId(Long.parseLong(wareIds[j].trim()));
						//新增的捐赠活动ID
						tmp.setDonatedId(donatedActivityId);
						list.add(tmp);
					}
				}
			}
		}
		donatedActivityDAO.saveActivityWareRltValue((IActivityWareRltValue[])list.toArray(new ActivityWareRltBean[0]));
	}
	

	private boolean isExistRecode(long donatedActivityId,long objectsId,long wareId) throws Exception{
		boolean isExistItem = false;
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		condition.append(" and ").append(IQBOWareObjectRltValue.S_ActivityId).append("=:").append(IQBOWareObjectRltValue.S_ActivityId)
		.append(" and ").append(IQBOWareObjectRltValue.S_ObjectId).append("=:").append(IQBOWareObjectRltValue.S_ObjectId)
		.append(" and ").append(IQBOWareObjectRltValue.S_WareId).append("=:").append(IQBOWareObjectRltValue.S_WareId);
		
		parameter.put(IQBOWareObjectRltValue.S_ActivityId, String.valueOf(donatedActivityId));
		parameter.put(IQBOWareObjectRltValue.S_ObjectId, String.valueOf(objectsId));
		parameter.put(IQBOWareObjectRltValue.S_WareId, String.valueOf(wareId));
		
		IQBOWareObjectRltValue[] value =donatedActivityDAO.getWareObjectRltValue(condition.toString(), parameter);
		if(null != value && value.length > 0){
			log.debug("condition is "+donatedActivityId+":"+objectsId+":"+wareId+",current items length is "+value.length);
			isExistItem = true;
		}
		return isExistItem;
	}
	public void unbindDonatedWareRltValue(long donatedActivityId, String wareIdArray) throws Exception {
		//利用捐赠活动ID和礼品ID，查询出所有活动-对象-礼品的关系信息
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		IQBOWareObjectRltValue[] value = null; 
		//业务规则：为捐赠活动绑定礼品，默认将该礼品与所有对象(本活动绑定的对象)绑定
		String[] wareIds = null;
		StringBuffer wareIdBuffer = new StringBuffer();
		String wareIdsStr = new String(); 
		StringBuffer rltIdbuffer = new StringBuffer();
		String rltIdsStr = new String();
		if(!StringUtil.isBlank(wareIdArray)){
			wareIds = wareIdArray.split(DonatedConstant.SEPARATE_CHAR_COMMA);
			if(null != wareIds && wareIds.length > 0){
				for(int i=0;i<wareIds.length;i++){
					wareIdBuffer.append("'").append(wareIds[i].trim()).append("',");
				}
				wareIdsStr = wareIdBuffer.substring(0,wareIdBuffer.length() - 1);
				log.debug("wareIdsStr is "+wareIdsStr);
			}
		}
		if(0 != donatedActivityId && null != wareIds){
			condition.append(" and ").append(IQBOWareObjectRltValue.S_ActivityId).append("=:").append(IQBOWareObjectRltValue.S_ActivityId);
			parameter.put(IQBOWareObjectRltValue.S_ActivityId, String.valueOf(donatedActivityId));
			condition.append(" and ").append(IQBOWareObjectRltValue.S_WareId).append(" in ( ").append(wareIdsStr).append(" )");
		}
		value = donatedActivityDAO.getWareObjectRltValue(condition.toString(), parameter);
		if(null != value && value.length > 0){
			for(int i=0;i<value.length;i++){
				rltIdbuffer.append("'").append(value[i].getRltId()).append("',");
			}
			rltIdsStr = rltIdbuffer.substring(0,rltIdbuffer.length()-1 );
			log.debug("rltIdsStr is "+rltIdsStr);
		}
		//重置查询条件
		condition = new StringBuffer(" 1=1 ");
		parameter.clear();
		//得到关系信息中的RLT_ID 并拼装成为'10001','10002','10003','10004'
		if(!StringUtil.isBlank(rltIdsStr)){
			condition.append(" and ").append(IActivityWareRltValue.S_RltId).append(" in ( ").append(rltIdsStr).append(" )");
			//parameter.put(IActivityWareRltValue.S_RltId, rltIdsStr);
		}
		//利用RLT_ID 信息，到ActivityWareRLt中查询出满足条件的对象信息
		IActivityWareRltValue [] delValue = donatedActivityDAO.getActivityWareRltValue(condition.toString(), parameter);
		
		//将对象信息设置为删除状态，保存
		if(null != delValue && delValue.length > 0){
			log.debug("the number of deleted items is "+delValue.length);
			for(int i=0;i<delValue.length;i++){
				delValue[i].delete();
			}
		}
		donatedActivityDAO.saveActivityWareRltValue(delValue);
	}

	public String saveWareObjectRltValue(long donatedActivityId, long wareId, String objectIdArray) throws Exception {
		//利用捐赠活动ID，礼品ID，去activity_ware_rlt表中搜寻出所有满足的条件，返回一个数组
		
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		IActivityWareRltValue [] value = null;
		
		if(0!=donatedActivityId && 0!= wareId){
			condition.append(" and ").append(IActivityWareRltValue.S_DonatedId).append("=:").append(IActivityWareRltValue.S_DonatedId);
			parameter.put(IActivityWareRltValue.S_DonatedId, String.valueOf(donatedActivityId));
			condition.append(" and ").append(IActivityWareRltValue.S_WareId).append("=:").append(IActivityWareRltValue.S_WareId);
			parameter.put(IActivityWareRltValue.S_WareId, String.valueOf(wareId));
		}
		value = donatedActivityDAO.getActivityWareRltValue(condition.toString(), parameter);
		
		//删除查询出来的数据
		if(null != value && value.length > 0){
			for(int i=0;i<value.length;i++){
				value[i].delete();
			}
			donatedActivityDAO.saveActivityWareRltValue(value);
		}
		
		//重新添加，数据个数为objectIdArray.split().length();
		if(!StringUtil.isBlank(objectIdArray)){
			String[] objectArray = objectIdArray.split(DonatedConstant.SEPARATE_CHAR_COMMA);
			if(null != objectArray && objectArray.length > 0){
				log.debug("current objectId length is "+ objectArray.length);
				IActivityWareRltValue  tmp = null;
				List<IActivityWareRltValue> list = new ArrayList<IActivityWareRltValue>();
				for(int i=0;i<objectArray.length;i++){
					tmp = new ActivityWareRltBean();
					tmp.setRltId(ActivityWareRltEngine.getNewId().longValue());
					tmp.setObjectId(Long.parseLong(objectArray[i].trim()));
					tmp.setWareId(wareId);
					tmp.setDonatedId(donatedActivityId);
					
					tmp.setStsToNew();
					list.add(tmp);
				}
				donatedActivityDAO.saveActivityWareRltValue((IActivityWareRltValue[])list.toArray(new ActivityWareRltBean[0]));
			}
			
		}
		return null;
	}

	


}
