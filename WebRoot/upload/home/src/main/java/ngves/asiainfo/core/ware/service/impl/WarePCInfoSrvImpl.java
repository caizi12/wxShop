package ngves.asiainfo.core.ware.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ngves.asiainfo.core.ware.WareConstant;
import ngves.asiainfo.core.ware.dao.interfaces.IWarePCInfoDAO;
import ngves.asiainfo.core.ware.ivalues.IBusiWareInfoParentValue;
import ngves.asiainfo.core.ware.ivalues.IQBOAllWareInfoChildValue;
import ngves.asiainfo.core.ware.ivalues.IQBOWareChildInfoValue;
import ngves.asiainfo.core.ware.ivalues.IQBOWareParentInfoValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoParentValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoValue;
import ngves.asiainfo.core.ware.ivalues.IWarePCRltValue;
import ngves.asiainfo.core.ware.service.interfaces.IWarePCInfoSrv;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WarePCInfoSrvImpl implements IWarePCInfoSrv {

	private static Log log = LogFactory.getLog(WarePCInfoSrvImpl.class);

	private IWarePCInfoDAO warePCInfoDAO;

	
	public void setWarePCInfoDAO(IWarePCInfoDAO warePCInfoDAO) throws Exception {
		this.warePCInfoDAO = warePCInfoDAO;
	}
	
//	private List<Object> getQueryCondition(String wareCode, String wareName, String partnerId,
//            String partnerCode, String wareBrand, String wareStatus, String firstKindId, String parentKindId,
//            String kindId, String provinceCode,String wareKindInfoId, String action) throws Exception {
//		
//		List<Object> list = new ArrayList<Object>();
//		
//		StringBuffer condition = new StringBuffer(" 1=1 ");
//		Map<String,String> parameter = new HashMap<String,String>();
//		
//		if (!StringUtil.isBlank(wareCode) && !WareConstant.QUERY_CONDITION_NO_VALUE.equals(wareCode)) {
//            condition.append(" and " + IQBOWareParentInfoValue.S_WareCode).append(" like :").append(
//            		IQBOWareParentInfoValue.S_WareCode);
//            parameter.put(IQBOWareParentInfoValue.S_WareCode, "%" + wareCode.trim() + "%");
//        }
//        if (!StringUtil.isBlank(wareName)) {
//            condition.append(" and " + IQBOWareParentInfoValue.S_WareName).append(" like :").append(
//            		IQBOWareParentInfoValue.S_WareName);
//            parameter.put(IQBOWareParentInfoValue.S_WareName, "%" + wareName.trim() + "%");
//        }
//        if (!StringUtil.isBlank(partnerId) && !WareConstant.QUERY_CONDITION_NO_VALUE.equals(partnerId)) {
//            condition.append(" and " + IQBOWareParentInfoValue.S_PartnerId + "=:partnerId");
//            parameter.put("partnerId", partnerId);
//        }
//        if (!StringUtil.isBlank(partnerCode) && !WareConstant.QUERY_CONDITION_NO_VALUE.equals(partnerCode)) {
//            condition.append(" and " + IQBOWareParentInfoValue.S_PartnerCode + "=:partnerCode");
//            parameter.put("partnerCode", partnerCode);
//        }
//        if (!StringUtil.isBlank(wareBrand) && !WareConstant.QUERY_CONDITION_NO_VALUE.equals(wareBrand)) {
//            condition.append(" and " + IQBOWareParentInfoValue.S_WareBrandId + "= :wareBrandId ");
//            parameter.put("wareBrandId", wareBrand);
//        }
//        if (!StringUtil.isBlank(wareStatus) && !WareConstant.QUERY_CONDITION_NO_VALUE.equals(wareStatus)) {
//            condition.append(" and " + IQBOWareParentInfoValue.S_WareStatus + " in ( " + wareStatus + " )");
//        }
//        if (!StringUtil.isBlank(firstKindId) && !WareConstant.QUERY_CONDITION_NO_VALUE.equals(firstKindId)) {
//            condition.append(" and " + IQBOWareParentInfoValue.S_WareFirstKindId + "=:firstKindId");
//            parameter.put("firstKindId", firstKindId);
//        }
//        if (!StringUtil.isBlank(parentKindId) && !WareConstant.QUERY_CONDITION_NO_VALUE.equals(parentKindId)) {
//            condition.append(" and " + IQBOWareParentInfoValue.S_WareKindParentId + "=:parentKindId");
//            parameter.put("parentKindId", parentKindId);
//        }
//        if (!StringUtil.isBlank(kindId) && !WareConstant.QUERY_CONDITION_NO_VALUE.equals(kindId)) {
//            condition.append(" and " + IQBOWareParentInfoValue.S_WareKindId + "=:kindId");
//            parameter.put("kindId", kindId);
//        }
//        if (!StringUtil.isBlank(provinceCode) && !WareConstant.QUERY_CONDITION_NO_VALUE.equals(provinceCode)) {
//            condition.append(" and " + IQBOWareParentInfoValue.S_ProvinceCode + "=:provinceCode");
//            parameter.put("provinceCode", provinceCode);
//        }
//        if (!StringUtil.isBlank(wareKindInfoId) && !WareConstant.QUERY_CONDITION_NO_VALUE.equals(wareKindInfoId)) {
//			 condition.append(" and " + IQBOWareParentInfoValue.S_WareKindInfoId + "=:wareKindInfoId");
//	         parameter.put("wareKindInfoId", wareKindInfoId);
//       }
//        if(action.equalsIgnoreCase("toexcel")){
//            //子礼品按省市县导出的操作不进行倒序排列	
//        }else{
//            //倒序排列
//            condition.append(" order by last_update_date desc");
//        }
//        //将条件都放到list里面
//        list.add(condition.toString());
//        list.add(parameter);
//		return list;
//	}

	@SuppressWarnings("unchecked")
	public IQBOWareParentInfoValue[] queryAllWareParentInfo(String wareCode, String wareName, String partnerId,
            String partnerCode, String wareBrand, String wareStatus, String firstKindId, String parentKindId,
            String kindId, String provinceCode,String wareKindInfoId, int startNum,int endNum) throws Exception{
		
		List<Object> list = getQueryConditionNew(wareCode,wareName,partnerId,partnerCode,wareBrand,wareStatus,firstKindId,parentKindId,kindId,provinceCode,wareKindInfoId,"query");
		
		IQBOWareParentInfoValue[] values = warePCInfoDAO.getQBOWarePCInfoValue((String)list.get(0), (Map<String,String>)list.get(1), startNum, endNum);
		log.info("query all ware  parent info ...");
		return values;
	}


	/**
	 * 根据子礼品的ID获取对应父礼品的子礼品的相关信息
	 * 
	 * @param wareId
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IQBOWareChildInfoValue[] getWareChildInfoValueById(String wareId, int startIndex, int endIndex) throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String, String> parameter = new HashMap<String, String>();
		
		if(!StringUtil.isBlank(wareId)){
			parameter.put("ware_id", wareId);		
		}
		IQBOWareChildInfoValue[] values = warePCInfoDAO.getWareChildInfoValue(condition.toString(), parameter, startIndex, endIndex);
		return values;
	}
	
	
	public int getWareChildInfoValueCount(String wareId) throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String, String> parameter = new HashMap<String, String>();
		if(!StringUtil.isBlank(wareId)){
			parameter.put("ware_id", wareId);		
		}
		return warePCInfoDAO.getWareChildInfoValueCount(condition.toString(),parameter);
	}

	@SuppressWarnings("unchecked")
	public int queryAllWareParentInfoCount(String wareCode, String wareName, String partnerId, String partnerCode,
			String wareBrand, String wareStatus, String firstKindId, String parentKindId, String kindId,
			String provinceCode,String wareKindInfoId) throws Exception {
		
		List<Object> list = getQueryConditionNew(wareCode,wareName,partnerId,partnerCode,wareBrand,wareStatus,firstKindId,parentKindId,kindId,provinceCode,wareKindInfoId,"query");
		
		int itemNum = warePCInfoDAO.getWareInfoParentValueCount((String)list.get(0), (Map<String,String>)list.get(1));
        return itemNum;
	}
	
	public void saveWarePCInfo(IWarePCRltValue[] rltValues) throws Exception{
		warePCInfoDAO.saveWarePCInfo(rltValues);
	}

	
	public IWareInfoValue[] getWareInfoValueByChildId(long childId) throws Exception {
		IWareInfoValue[]  value = null;
		//获得关联表的信息
		IWarePCRltValue rltVal = getWarePCRltValueByChildId(childId);
		IWarePCRltValue[] rltValues = getWarePCRltValueByParentId(rltVal.getPWareId());
		
		//利用所有子礼品获得礼品的ID，组成查询条件，查询出这些礼品的基本信息
		if(null !=rltValues && rltValues.length > 0){
			StringBuffer condition = new StringBuffer(" 1=1 ");
			Map<String,String> parameter = new HashMap<String,String>();
			StringBuffer ids = new StringBuffer();
			for(int i=0;i<rltValues.length;i++){
				ids.append("'").append(rltValues[i].getCWareId()).append("',");
			}
			condition.append(" and ").append(IWareInfoValue.S_WareId).append(" in (").append(ids.substring(0,ids.length()-1)).append(" )");
			value = warePCInfoDAO.getWareInfoValue(condition.toString(),parameter);
		}
		
		return value;
	}

	public IWareInfoParentValue getWareParentValueByChildId(long childId) throws Exception {
		IWareInfoParentValue value = null;
		//获得关联表的信息
		IWarePCRltValue rltValue = getWarePCRltValueByChildId(childId);
		//利用父礼品ID，查询到父礼品基本信息
		value = warePCInfoDAO.getWareInfoParentById(rltValue.getPWareId());
		return value;
	}


	public IWarePCRltValue getWarePCRltValueByChildId(long childId) throws Exception {
		IWarePCRltValue[] value = null;
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		condition.append(" and ").append(IWarePCRltValue.S_CWareId).append("=:").append(IWarePCRltValue.S_CWareId);
		parameter.put(IWarePCRltValue.S_CWareId, String.valueOf(childId));
		value =  warePCInfoDAO.getWarePCRltValue(condition.toString(), parameter);
		if(null == value || value.length != 1){
			throw new Exception(" there exist wrong items in ware_pc_rlt table,please check the databases.");
		}
		return value[0];
	}

	public IWarePCRltValue[] getWarePCRltValueByParentId(long parentId) throws Exception {
		IWarePCRltValue[] value = null;
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		condition.append(" and ").append(IWarePCRltValue.S_PWareId).append("=:").append(IWarePCRltValue.S_PWareId);
		parameter.put(IWarePCRltValue.S_PWareId, String.valueOf(parentId));
		value =  warePCInfoDAO.getWarePCRltValue(condition.toString(), parameter);
		return value;
	}
	
	
	public void upDownLineWareInfoParent(IWareInfoValue[] wareInfos,String statusOperate)throws Exception{
		if (wareInfos == null || wareInfos.length < 1) {
            throw new Exception(" The IWareInfoValue[] objects is null! please check it.");
        }
		for(int i=0;i<wareInfos.length;i++){
			//如果是子礼品
			if(WareConstant.WARE_TYPE_CHILDREN == wareInfos[i].getWareType()){
				log.debug(wareInfos[i].getWareName()+" is a child ware ， the code is  "+wareInfos[i].getWareCode());
				if(WareConstant.SYS_UP_OPERATE.equals(statusOperate)){
					log.debug("the ware(child ware) request  on-line");
					//上线操作只需要获得父礼品的上下线状态
					IWareInfoParentValue parentValue = getWareParentValueByChildId(wareInfos[i].getWareId());
					//如果父礼品已经上线，跳过;如果父礼品没有上线，父礼品状态为上线
					//对于IS_ONLINE字段，（礼品是否上线：0代表下线，1代表上线）
					if(!WareConstant.SYS_CORE_WARE_STATUS_ONLINE.equals(parentValue.getWareStatus())){
						log.debug("the ware(parent) is not on-line.");
						//为了保证数据的一致性，这里要重置IS_ONLINE 和 WARE_STATUS字段，都设置为上线状态。
						
						/*父礼品的is_online字段是用来表示父礼品的上线状态，考虑到后台子礼品(ware_info)同步到前台(ware_info_portal)定时任务两次执行的时差，
						 * 所以暂定，礼品实时上下线时，并不更改父礼品的is_online状态，而是等到同步礼品中包含子礼品信息时，才将父礼品的IS_ONLINE字段设置成为1
						 * 
						 * 注：在手动执行上下线时，如果父礼品满足上线状态，会将父礼品的状态(WARE_STATUS)更改成为1。
						 * @date 2011/12/12 liuyq
						**/
						parentValue.setIsOnline(WareConstant.SYS_CORE_PARENT_WARE_STATUS_NOT_ONLINE);
						parentValue.setWareStatus(WareConstant.SYS_CORE_WARE_STATUS_ONLINE);
						//设置上线时间 OPEN_DATE
						parentValue.setOpenDate(DateTimeUtil.getNowTimeStamp());
						parentValue.setLastUpdateStaffId(wareInfos[i].getLastUpdateStaffId());
						//保存数据
						warePCInfoDAO.saveWareInfoParentValue(parentValue);
					}
				}else if(WareConstant.SYS_DOWN_OPERATE.equals(statusOperate)){
					log.debug("the ware(child ware) request  off-line");
					//下线操作需要查询其他兄弟姐妹的状态
					//利用子礼品ID，查询出它的兄弟姐妹节点信息(ware_info表)
					//这部分采用core包下面的接口
					IWareInfoValue[] values = getWareInfoValueByChildId(wareInfos[i].getWareId());
					if(null != values && values.length > 0){
						boolean isNeedOffLine = true;
						//Q:对于子礼品待上线、上线、下线的状态判断，子礼品的待上线是否和下线一个待遇？
						//A：子礼品的待上线和下线在父礼品上下线控制这部分，待遇是相同的。
						
						//检查所有兄弟节点的信息
						//如果父礼品有多个子礼品，遍历所有
						for(int j=0;j<values.length;j++){
							//不予考虑本条记录，
							if(wareInfos[i].getWareId() != values[j].getWareId() && 
									WareConstant.SYS_CORE_WARE_STATUS_ONLINE.equals(values[j].getWareStatus())){
								//父礼品不需要下线
								isNeedOffLine = false;
								break;
							}
						}
						
						if(isNeedOffLine){
							log.debug("the ware(parent) need to be off-line.");
							//父礼品需要下线操作
							IWareInfoParentValue parentValue = getWareParentValueByChildId(wareInfos[i].getWareId());
							//如果父礼品已经下线
							if(!(WareConstant.SYS_CORE_PARENT_WARE_STATUS_OFFLINE.equals(parentValue.getIsOnline()) 
									&& WareConstant.SYS_CORE_WARE_STATUS_OFFLINE.equals(parentValue.getWareStatus())) ){
								
								parentValue.setIsOnline(WareConstant.SYS_CORE_PARENT_WARE_STATUS_OFFLINE);
								parentValue.setWareStatus(WareConstant.SYS_CORE_WARE_STATUS_OFFLINE);
								//设置下线时间
								parentValue.setCloseDate(DateTimeUtil.getNowTimeStamp());
								parentValue.setLastUpdateDate(DateTimeUtil.getNowTimeStamp());
								
								parentValue.setLastUpdateStaffId(wareInfos[i].getLastUpdateStaffId());
								//保存数据
								warePCInfoDAO.saveWareInfoParentValue(parentValue);
							}
							
						}else{
							log.debug("the ware(parent) does not need to be off-line.");
						}
					}
				}
			}//end judgment whether the ware is a child ware.
		}//end the loop of the ware_info array which need to be on-line or off-line.
	}// end the function of ware on-line or off-line operation .
	
	public long saveWareInfoParentValue(IWareInfoParentValue wareInfoParentValue) throws Exception {
		long id = warePCInfoDAO.saveWareInfoParentValue(wareInfoParentValue);
    	return id;
	}

	public IBusiWareInfoParentValue[] getBusiWareInfoParentValue(String pWareId) throws Exception {
		Map<String, String> parameter = new HashMap<String, String>();
		StringBuffer condition = new StringBuffer(" 1=1 ");
		condition.append(" and ").append(IBusiWareInfoParentValue.S_WareId).append(" =:").append(IBusiWareInfoParentValue.S_WareId);
		parameter.put(IBusiWareInfoParentValue.S_WareId, pWareId);
		
		IBusiWareInfoParentValue[] values = warePCInfoDAO.getBusiWareInfoParentValue(condition.toString(),parameter);
		
		return values;
	}
	
	public IWareInfoValue[] getChildWareInfo(long wareParentId) throws Exception {
		return warePCInfoDAO.getChildWareInfo(wareParentId);
	}

	@SuppressWarnings("unchecked")
	public IQBOAllWareInfoChildValue[] queryAllWareInfoChild(String wareCode, String wareName, String partnerId,
			String partnerCode, String wareBrand, String wareStatus, String firstKindId, String parentKindId,
			String kindId, String provinceCode,String wareKindInfoId, int startNum, int endNum) throws Exception {
		List<Object> list = getQueryConditionNew(wareCode,wareName,partnerId,partnerCode,wareBrand,wareStatus,firstKindId,parentKindId,kindId,provinceCode,wareKindInfoId,"toexcel");
		IQBOAllWareInfoChildValue[] values = warePCInfoDAO.queryAllWareInfoChild((String)list.get(0), (Map<String,String>)list.get(1), startNum, endNum);
		log.info("query all ware  child info ...");
		return values;
	}

	@SuppressWarnings("unchecked")
	public int queryAllWareInfoChildCount(String wareCode, String wareName, String partnerId, String partnerCode,
			String wareBrand, String wareStatus, String firstKindId, String parentKindId, String kindId,
			String provinceCode,String wareKindInfoId) throws Exception {
		List<Object> list = getQueryConditionNew(wareCode,wareName,partnerId,partnerCode,wareBrand,wareStatus,firstKindId,parentKindId,kindId,provinceCode,wareKindInfoId,"toexcel");
		int itemNum = warePCInfoDAO.getWareInfoChildValueCount((String)list.get(0), (Map<String,String>)list.get(1));
        return itemNum;
	}

	public IWarePCRltValue[] getWareParentId(long wareParentId) throws Exception {
		return warePCInfoDAO.getParentIdFindChildWareInfo(wareParentId);
	}
	//因 getQueryCondition方法其他也有调用，所有新增getQueryConditionNew
	private List<Object> getQueryConditionNew(String wareCode, String wareName, String partnerId,
            String partnerCode, String wareBrand, String wareStatus, String firstKindId, String parentKindId,
            String kindId, String provinceCode,String wareKindInfoId, String action) throws Exception {
		
		List<Object> list = new ArrayList<Object>();
		
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		
		if (!StringUtil.isBlank(wareCode) && !WareConstant.QUERY_CONDITION_NO_VALUE.equals(wareCode)) {
            condition.append(" and " + IQBOWareParentInfoValue.S_WareCode).append(" like :").append(
            		IQBOWareParentInfoValue.S_WareCode);
            parameter.put(IQBOWareParentInfoValue.S_WareCode, "%" + wareCode.trim() + "%");
        }
        if (!StringUtil.isBlank(wareName)) {
            condition.append(" and " + IQBOWareParentInfoValue.S_WareName).append(" like :").append(
            		IQBOWareParentInfoValue.S_WareName);
            parameter.put(IQBOWareParentInfoValue.S_WareName, "%" + wareName.trim() + "%");
        }
        if (!StringUtil.isBlank(partnerId) && !WareConstant.QUERY_CONDITION_NO_VALUE.equals(partnerId)) {
            condition.append(" and " + IQBOWareParentInfoValue.S_PartnerId + "=:partnerId");
            parameter.put("partnerId", partnerId);
        }
        if (!StringUtil.isBlank(partnerCode) && !WareConstant.QUERY_CONDITION_NO_VALUE.equals(partnerCode)) {
            condition.append(" and " + IQBOWareParentInfoValue.S_PartnerCode + "=:partnerCode");
            parameter.put("partnerCode", partnerCode);
        }
        if (!StringUtil.isBlank(wareBrand) && !WareConstant.QUERY_CONDITION_NO_VALUE.equals(wareBrand)) {
            condition.append(" and " + IQBOWareParentInfoValue.S_WareBrandId + "= :wareBrandId ");
            parameter.put("wareBrandId", wareBrand);
        }
        if (!StringUtil.isBlank(wareStatus) && !WareConstant.QUERY_CONDITION_NO_VALUE.equals(wareStatus)) {
            condition.append(" and " + IQBOWareParentInfoValue.S_WareStatus + " in ( " + wareStatus + " )");
        }
        if (!StringUtil.isBlank(firstKindId) && !WareConstant.QUERY_CONDITION_NO_VALUE.equals(firstKindId)) {
            condition.append(" and " + IQBOWareParentInfoValue.S_WareFirstKindId + "=:firstKindId");
            parameter.put("firstKindId", firstKindId);
        }
        if (!StringUtil.isBlank(parentKindId) && !WareConstant.QUERY_CONDITION_NO_VALUE.equals(parentKindId)) {
            condition.append(" and " + IQBOWareParentInfoValue.S_WareKindParentId + "=:parentKindId");
            parameter.put("parentKindId", parentKindId);
        }
        if (!StringUtil.isBlank(kindId) && !WareConstant.QUERY_CONDITION_NO_VALUE.equals(kindId)) {
            condition.append(" and " + IQBOWareParentInfoValue.S_WareKindId + "=:kindId");
            parameter.put("kindId", kindId);
        }
        if (!StringUtil.isBlank(provinceCode) && !WareConstant.QUERY_CONDITION_NO_VALUE.equals(provinceCode)) {
            condition.append(" and " + IQBOWareParentInfoValue.S_ProvinceCode + "=:provinceCode");
            parameter.put("provinceCode", provinceCode);
        }
        if (!StringUtil.isBlank(wareKindInfoId) && !WareConstant.QUERY_CONDITION_NO_VALUE.equals(wareKindInfoId)) {
			 condition.append(" and " + IQBOWareParentInfoValue.S_WareKindInfoId + "=:wareKindInfoId");
	            parameter.put("wareKindInfoId", wareKindInfoId);
       }
        if(action.equalsIgnoreCase("toexcel")){
            //子礼品按省市县导出的操作不进行倒序排列	
        }else{
            //倒序排列
            condition.append(" order by last_update_date desc");
        }
        //将条件都放到list里面
        list.add(condition.toString());
        list.add(parameter);
		return list;
	}
}
