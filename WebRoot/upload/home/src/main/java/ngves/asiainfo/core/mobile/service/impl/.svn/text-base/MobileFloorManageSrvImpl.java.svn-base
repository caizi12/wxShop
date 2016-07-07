package ngves.asiainfo.core.mobile.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.common.bo.BusiInfoEngine;
import ngves.asiainfo.core.common.util.BusiInfoUtil;
import ngves.asiainfo.core.mobile.bo.MobileFloorInfoBean;
import ngves.asiainfo.core.mobile.bo.MobileFloorRltBean;
import ngves.asiainfo.core.mobile.dao.interfaces.IMobileFloorManageDAO;
import ngves.asiainfo.core.mobile.ivalues.IMobileFloorInfoValue;
import ngves.asiainfo.core.mobile.ivalues.IMobileFloorRltValue;
import ngves.asiainfo.core.mobile.model.MobileFloorInfo;
import ngves.asiainfo.core.mobile.model.MobileFloorRlt;
import ngves.asiainfo.core.mobile.model.RecommendFloorInfo;
import ngves.asiainfo.core.mobile.service.interfaces.IMobileFloorManageSrv;
import ngves.asiainfo.core.ware.util.WareCommonUtil;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 触屏版首页楼层推荐管理服务层实现
 * @author yeqh
 * 2014-12-28
 */
public class MobileFloorManageSrvImpl implements IMobileFloorManageSrv {
	
	private static Log logger = LogFactory.getLog(MobileFloorManageSrvImpl.class);
	
	private IMobileFloorManageDAO mobileFloorManageDAO;
	
	public void setMobileFloorManageDAO(IMobileFloorManageDAO mobileFloorManageDAO) throws Exception {
		this.mobileFloorManageDAO = mobileFloorManageDAO;
	}

	/**
	 * 填充操作字段及标识转义
	 */
	private IMobileFloorInfoValue[] fillHTMLOperationField(IMobileFloorInfoValue[] values) throws Exception{
		String channel = "";
		String showTemplateType = "";
		for (IMobileFloorInfoValue value : values) {
			if(CoreConstant.IS_SHOW.equals(value.getIsShow())){
				value.setBakCol1(" <a href=\"#\" onclick=\"updateRow('" + value.getFloorId() + "')\" >修改</a>&nbsp;&nbsp; " +
						" <a href=\"#\" onclick=\"deleteRow('" + value.getFloorId() + "')\" >删除</a>&nbsp;&nbsp;&nbsp;&nbsp;" +
						" <a href=\"#\" onclick=\"showRow('" + value.getFloorId() + "')\" >首页不展示</a>&nbsp;&nbsp;");
			}else{
				value.setBakCol1(" <a href=\"#\" onclick=\"updateRow('" + value.getFloorId() + "')\" >修改</a>&nbsp;&nbsp; " +
						" <a href=\"#\" onclick=\"deleteRow('" + value.getFloorId() + "')\" >删除</a>&nbsp;&nbsp;&nbsp;&nbsp;" +
						" <a href=\"#\" onclick=\"showRow('" + value.getFloorId() + "')\" >首页展示</a>&nbsp;&nbsp;");
			}
			//是否首页展示转义
			value.setIsShow(CoreConstant.IS_SHOW.equals(value.getIsShow())?"是":"否");
			
			//支持渠道转义
			String[] args = value.getShowChannel().split(",");
			for(String arg:args){
				channel += (WareCommonUtil.getViewNameByCode(arg, "SYS_PARA_DATA", "PARA_CODE", "PARA_NAME", ",", ",","PARA_TYPE_ID='1301'")+",");	
			}
			channel = channel.substring(0, channel.length()-1);
			value.setShowChannel(channel);
			
			//模板类型转义
			showTemplateType = WareCommonUtil.getViewNameByCode(value.getShowTemplateType(), "SYS_PARA_DATA", "PARA_CODE", "PARA_NAME", ",", ",","PARA_TYPE_ID='900000000000034'");
			value.setShowTemplateType(showTemplateType);
			
			channel = "";
			showTemplateType = "";
		}
		return values;
	}
	
	/**
	 * 根据楼层名称查询楼层信息
	 * 如果为空查询所有未被删除的楼层信息
	 * @throws Exception
	 */
	public IMobileFloorInfoValue[] getMobileFloorInfo(String floorName, int $STARTROWINDEX, int $ENDROWINDEX) throws Exception {
		IMobileFloorInfoValue[] values = this.mobileFloorManageDAO.getMobileFloorInfo(floorName, $STARTROWINDEX, $ENDROWINDEX);
		return fillHTMLOperationField(values);
	}
	
	/**
	 * 根据楼层名称查询楼层信息
	 * @throws Exception
	 */
	public IMobileFloorInfoValue[] getMobileFloorInfoByFloorName(String floorName) throws Exception {
		IMobileFloorInfoValue[] values = this.mobileFloorManageDAO.getMobileFloorInfoByFloorName(floorName);
		return fillHTMLOperationField(values);
	}

	/**
	 * 通过floorId查询楼层信息
	 * @throws Exception
	 */
	public IMobileFloorInfoValue getMobileFloorInfoByFloorId(String floorId) throws Exception {
		if(StringUtil.isBlank(floorId)){
			throw new Exception(" method getMobileFloorInfoByFloorId's  floorId is null ");
		}
		return this.mobileFloorManageDAO.getMobileFloorInfoByFloorId(floorId);
	}

	
	/**
	 * 根据楼层名称查询楼层信息数量
	 * 如果为空查询所有未被删除的楼层信息数量
	 * @throws Exception
	 */
	public int getMobileFloorInfoCount(String floorName) throws Exception {
		return this.mobileFloorManageDAO.getMobileFloorInfoCount(floorName);
	}

	/**
	 * 保存楼层信息
	 * @param floorId
	 * @param floorName
	 * @param retMapRltInfo
	 * @throws Exception
	 */
	public void saveMobileFloorInfo(String floorId, String floorName, Map<String, String> retMapRltInfo, long staffId, String comType, long orgId) throws Exception {
		IMobileFloorInfoValue oldFloorInfoBean = null;
		IMobileFloorInfoValue floorInfoBean = null;
		boolean isFloorEdit = false;
		if(floorId==null){
			//新建楼层
			floorInfoBean = new MobileFloorInfoBean();
			floorInfoBean.setFloorId(0);
			floorInfoBean.setCreateStartTime(new Timestamp(System.currentTimeMillis()));
			floorInfoBean.setIsShow(CoreConstant.NOT_SHOW);
			floorInfoBean.setIsDeleted(CoreConstant.ENABLE);
		} else {
			//编辑
			isFloorEdit = true;
			floorInfoBean = getMobileFloorInfoByFloorId(floorId);
			oldFloorInfoBean = new MobileFloorInfoBean();
			oldFloorInfoBean.copy(floorInfoBean);
		}
		String sortId = retMapRltInfo.get("sortId");
		String showChannel = retMapRltInfo.get("showChannel");
		String showTemplateType = retMapRltInfo.get("showTemplateType");
		String rltInfo = retMapRltInfo.get("rlt");
		List<Map<String, String>> rltObjsList = getRLTData(rltInfo);
		
		floorInfoBean.setFloorName(floorName);
		floorInfoBean.setSortId(Long.parseLong(sortId));
		floorInfoBean.setShowChannel(showChannel);
		floorInfoBean.setShowTemplateType(showTemplateType);
		
		saveMobileFloorInfo(floorInfoBean);
		
		//存储floor rlt信息
		List<Long> newFloorRltIds = new ArrayList<Long>();
		List<IMobileFloorRltValue> floorRltValues = new ArrayList<IMobileFloorRltValue>();
		for(int i=0;i<rltObjsList.size();i++){
			Map<String, String> rltObjs = rltObjsList.get(i);
			IMobileFloorRltValue frv = null;
			
			long floorRltId = Long.parseLong(rltObjs.get("floorRltId"));
			if(floorRltId==0){
				//新建rlt info
				frv = new MobileFloorRltBean();
				frv.setFloorRltId(floorRltId);
			} else {
				//编辑rlt info
				frv = getFloorRltInfoByFloorId(rltObjs.get("floorRltId"));
			}
			frv.setFloorId(String.valueOf(floorInfoBean.getFloorId()));
			newFloorRltIds.add(floorRltId);
			
			frv.setRecommendId(rltObjs.get("recommendId"));
			frv.setRecommendName(rltObjs.get("recommendName"));
			frv.setRecommendType(rltObjs.get("recommendType"));
			frv.setIndexId(Long.parseLong(rltObjs.get("indexId")));
			frv.setShowChannel(showChannel);
			frv.setShowPicFile(rltObjs.get("showPicFile"));
			frv.setIsDelete(CoreConstant.ENABLE);
			floorRltValues.add(frv);
		}
		
		//编辑时删除已删除的类别rlt info
		if(isFloorEdit){
			IMobileFloorRltValue[] oldFRVs = getFloorRltByFloorId(floorId);
			for(IMobileFloorRltValue value:oldFRVs){
				if(!newFloorRltIds.contains(value.getFloorRltId())){
					value.setIsDelete(CoreConstant.DISABLE);
					floorRltValues.add(value);
				}
			}
		} 
		IMobileFloorRltValue[] values = new IMobileFloorRltValue[floorRltValues.size()];
		saveBatchMobileFloorRlt(floorRltValues.toArray(values));
		
		//记录业务日志信息
		long busiInfoId = BusiInfoEngine.getNewId().longValue();
		if(isFloorEdit){
			BusiInfoUtil.recordBusiInfo(busiInfoId + "", CoreConstant.SYS_PARA_BUSI_TYPE_FLOOR_MODIFY, -1,
		            "修改楼层",CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,"楼层ID："+oldFloorInfoBean.getFloorId()+"；楼层名称："+oldFloorInfoBean.getFloorName(), staffId, comType, orgId);       
		} else {
			BusiInfoUtil.recordBusiInfo(busiInfoId + "", CoreConstant.SYS_PARA_BUSI_TYPE_FLOOR_CREATE, -1,
	                "新建楼层",CoreConstant.BUSI_INFO_OPT_TYPE_ADD,"楼层ID："+floorInfoBean.getFloorId()+"；楼层名称："+floorInfoBean.getFloorName(), staffId, comType, orgId);
		}
    }
	
	/**
	 * 保存楼层信息
	 * @throws Exception
	 */
	public void saveMobileFloorInfo(IMobileFloorInfoValue floorInfoValue) throws Exception {
		if(null == floorInfoValue){
			logger.error(" save objects is null !!! please check");
		}
		this.mobileFloorManageDAO.saveMobileFloorInfo(floorInfoValue);
	}

	/**
	 * 通过楼层id获得绑定的楼层关系信息
	 * @param floorId
	 * @return
	 * @throws Exception
	 */
	public IMobileFloorRltValue[] getFloorRltByFloorId(String floorId) throws Exception {
		return this.mobileFloorManageDAO.getFloorRltByFloorId(floorId);
	}
	
	public IMobileFloorRltValue getFloorRltInfoByFloorId(String floorRltId) throws Exception {
		return this.mobileFloorManageDAO.getFloorRltInfoByFloorId(floorRltId);
	}
	
	/**
	 * 批量保存楼层关系信息
	 * @param floorRltValues
	 * @throws Exception
	 */
	public void saveBatchMobileFloorRlt(IMobileFloorRltValue[] floorRltValues) throws Exception{
		this.mobileFloorManageDAO.saveBatchMobileFloorRlt(floorRltValues);
	}

	/**
	 * 删除楼层信息
	 * @param floorId
	 * @throws Exception
	 */
	public void deleteFloorInfo(String floorId, long staffId, String comType, long orgId) throws Exception {
		if(StringUtil.isBlank(floorId)){
			throw new Exception(" don't deleteFloorInfo because of floorId is null ");
		}
		//1.查询楼层信息
		IMobileFloorInfoValue floorInfo = this.getMobileFloorInfoByFloorId(floorId);
		if(null != floorInfo){
			//2.设置楼层字段（IS_DELETED）为1，保存到库里
			floorInfo.setIsDeleted(CoreConstant.DISABLE);
			this.saveMobileFloorInfo(floorInfo);
			
			//3.查询楼层绑定关系
			IMobileFloorRltValue[] floorRltValues = this.getFloorRltByFloorId(floorId);
			if(null != floorRltValues && floorRltValues.length>0){
				//4.设置楼层绑定关系（IS_DELETED）为1，保存到库里
				for(IMobileFloorRltValue floorRlt:floorRltValues){
					floorRlt.setIsDelete(CoreConstant.DISABLE);
				}
				this.mobileFloorManageDAO.saveBatchMobileFloorRlt(floorRltValues);
			}
			
			//记录业务日志信息
			long busiInfoId = BusiInfoEngine.getNewId().longValue();
			BusiInfoUtil.recordBusiInfo(busiInfoId + "", CoreConstant.SYS_PARA_BUSI_TYPE_FLOOR_DELETE, -1,
	                "删除楼层",CoreConstant.BUSI_INFO_OPT_TYPE_DELETE,"楼层ID："+floorInfo.getFloorId()+"；楼层名称："+floorInfo.getFloorName(), staffId, comType, orgId);
	       
		}else{
			throw new Exception(" don't deleteFloorInfo because of don't get floorInfo. please check db  ");
		}
	}

	/**
	 * 停启用首页展示楼层信息操作
	 * 1. 查询当前楼层是否首页展示，若为展示，则操作
	 * @param floorId
	 * @throws Exception
	 */
	public void showFloorInfo(String floorId) throws Exception {
		if(StringUtil.isBlank(floorId)){
			throw new Exception(" don't showFloorInfo because of floorId is null ");
		}
		//1.查询楼层信息
		IMobileFloorInfoValue floorInfo = this.getMobileFloorInfoByFloorId(floorId);
		if(null != floorInfo){
			//2.设置楼层字段（IS_SHOW），保存到库里
			if(CoreConstant.IS_SHOW.equals(floorInfo.getIsShow())){
				floorInfo.setIsShow(CoreConstant.NOT_SHOW);
			}else if(CoreConstant.NOT_SHOW.equals(floorInfo.getIsShow())){
				floorInfo.setIsShow(CoreConstant.IS_SHOW);
			}else{
				throw new Exception(" illegal operation ! please check ! ");
			}
			this.saveMobileFloorInfo(floorInfo);
		}else{
			throw new Exception(" don't showFloorInfo because of don't get floorInfo. please check db  ");
		}
	}

	/**
	 * 获取触屏版首页展示的所有楼层信息
	 * @param showChannel 支持展示渠道
	 * @return
	 * @throws Exception
	 */
	public List<RecommendFloorInfo> getMobileFloorInfos(String showChannel) throws Exception {
		List<RecommendFloorInfo> recommendFloorInfoList = new ArrayList<RecommendFloorInfo>();
		//1. 获取在指定渠道下的允许展示，且未被删除楼层基本信息
		IMobileFloorInfoValue[] floorBaseInfo = this.getFloorInfoByShowChannel(showChannel);
		
		if(floorBaseInfo.length>0 && null != floorBaseInfo){
			for(int i=0; i<floorBaseInfo.length; ++i){
				RecommendFloorInfo recommendFloorInfo = new RecommendFloorInfo();
				//2. 获取指定楼层下绑定的，且未被删除推荐类别或专题
				IMobileFloorRltValue[] floorRltValues = this.getFloorRltByFloorId(floorBaseInfo[i].getFloorId()+"");
				//3. 封装推荐类别或专题
				recommendFloorInfo.setFloorRlts(this.getMobileFloorRlts(floorRltValues));
				//4. 封装楼层基本信息
				recommendFloorInfo.setFloorInfo(this.getMobileFloorInfo(floorBaseInfo[i]));
				recommendFloorInfoList.add(recommendFloorInfo);
			}
		}
		return recommendFloorInfoList;
	}
	

	/**
	 * 获取首页展示的楼层基本信息
	 * @param showChannel 支持展示渠道
	 * @return
	 * @throws Exception
	 */
	public IMobileFloorInfoValue[] getFloorInfoByShowChannel(String showChannel)throws Exception{
		return this.mobileFloorManageDAO.getFloorInfoByShowChannel(showChannel);
	}
	
	/**
	 * 封装楼层关系
	 * @param floorRltValues
	 * @return
	 * @throws Exception
	 */
	public MobileFloorRlt[] getMobileFloorRlts(IMobileFloorRltValue[] floorRltValues)throws Exception{
		MobileFloorRlt[] mobileFloorRltList = new MobileFloorRlt[floorRltValues.length];
		int count = 0;
		for(IMobileFloorRltValue floorRltValue:floorRltValues){
			MobileFloorRlt mobileFloorRlt = new MobileFloorRlt();
			mobileFloorRlt.setBakCol1(floorRltValue.getBakCol1());
			mobileFloorRlt.setFloorId(floorRltValue.getFloorId());
			mobileFloorRlt.setFloorRltId(floorRltValue.getFloorRltId()+"");
			mobileFloorRlt.setIsDelete(floorRltValue.getIsDelete());
			mobileFloorRlt.setRecommendId(floorRltValue.getRecommendId());
			mobileFloorRlt.setRecommendName(floorRltValue.getRecommendName());
			mobileFloorRlt.setRecommendType(floorRltValue.getRecommendType());
			mobileFloorRlt.setShowChannel(floorRltValue.getShowChannel());
			mobileFloorRlt.setShowPicFile(floorRltValue.getShowPicFile());
			mobileFloorRlt.setIndexId(floorRltValue.getIndexId()+"");
			mobileFloorRltList[count++] = mobileFloorRlt;
		}
		return mobileFloorRltList;
	}
	
	/**
	 * 封装楼层基本信息
	 * @param floorBaseInfo
	 * @return
	 * @throws Exception
	 */
	public MobileFloorInfo getMobileFloorInfo(IMobileFloorInfoValue floorBaseInfo)throws Exception{
		MobileFloorInfo mobileFloorInfo = new MobileFloorInfo();
		mobileFloorInfo.setBakCol1(floorBaseInfo.getBakCol1());
		mobileFloorInfo.setFloorId(floorBaseInfo.getFloorId()+"");
		mobileFloorInfo.setFloorName(floorBaseInfo.getFloorName());
		mobileFloorInfo.setIsDeleted(floorBaseInfo.getIsDeleted());
		mobileFloorInfo.setIsShow(floorBaseInfo.getIsShow());
		mobileFloorInfo.setShowChannel(floorBaseInfo.getShowChannel());
		mobileFloorInfo.setShowTemplateType(floorBaseInfo.getShowTemplateType());
		mobileFloorInfo.setSortId(floorBaseInfo.getSortId()+"");
		return mobileFloorInfo;
	}
	

	private List<Map<String, String>> getRLTData(String rltData) throws Exception {
		List<Map<String, String>> rltObjsList = new ArrayList<Map<String, String>>();
		String[] rltObjs = rltData.split("_&&&_");
		for (String rltObj : rltObjs) {
			String[] paras = rltObj.split("_%_");
			Map<String, String> rltObjMap = new HashMap<String, String>();
			for(String para: paras){
				rltObjMap.put(para.split("_#_")[0], (para.split("_#_")[1] == null ? null : para.split("_#_")[1].trim()));
			}
			rltObjsList.add(rltObjMap);
		}
		return rltObjsList;
	}
	
	/**
	 * 预览首页展示需要展示的楼层信息
	 * @param floorId 预览附加的楼层
	 * @return
	 * @throws Exception
	 */
	public IMobileFloorInfoValue[] getPreviewFloorInfo(String floorId)throws Exception {
		return this.mobileFloorManageDAO.getPreviewFloorInfo(floorId);
	}
	
	
	/**
	 * 预览触屏版首页展示的所有楼层信息
	 * @param floorId 预览附加的楼层
	 * @return
	 * @throws Exception
	 */
	public List<RecommendFloorInfo> getPreviewMobileFloorInfos(String floorId) throws Exception {
		List<RecommendFloorInfo> recommendFloorInfoList = new ArrayList<RecommendFloorInfo>();
		//1. 预览当前楼层及当前首页楼层基本信息
		IMobileFloorInfoValue[] floorBaseInfo = this.getPreviewFloorInfo(floorId);
		
		if(floorBaseInfo.length>0 && null != floorBaseInfo){
			for(int i=0; i<floorBaseInfo.length; ++i){
				RecommendFloorInfo recommendFloorInfo = new RecommendFloorInfo();
				//2. 获取指定楼层下绑定的，且未被删除推荐类别或专题
				IMobileFloorRltValue[] floorRltValues = this.getFloorRltByFloorId(floorBaseInfo[i].getFloorId()+"");
				//3. 封装推荐类别或专题
				recommendFloorInfo.setFloorRlts(this.getMobileFloorRlts(floorRltValues));
				//4. 封装楼层基本信息
				recommendFloorInfo.setFloorInfo(this.getMobileFloorInfo(floorBaseInfo[i]));
				recommendFloorInfoList.add(recommendFloorInfo);
			}
		}
		return recommendFloorInfoList;
	}

}
