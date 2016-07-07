package ngves.asiainfo.core.floor.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import com.google.gson.Gson;
import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.common.bo.BusiInfoEngine;
import ngves.asiainfo.core.common.util.BusiInfoUtil;
import ngves.asiainfo.core.floor.FloorConstant;
import ngves.asiainfo.core.floor.bo.FloorInfoBean;
import ngves.asiainfo.core.floor.bo.TabsInfoBean;
import ngves.asiainfo.core.floor.dao.interfaces.IFloorInfoDAO;
import ngves.asiainfo.core.floor.dao.interfaces.IFloorSubKindDAO;
import ngves.asiainfo.core.floor.dao.interfaces.IFloorTabsRltDAO;
import ngves.asiainfo.core.floor.dao.interfaces.ITabsAreaInfoDAO;
import ngves.asiainfo.core.floor.dao.interfaces.ITabsInfoDAO;
import ngves.asiainfo.core.floor.domain.FloorSubKindValue;
import ngves.asiainfo.core.floor.domain.TabsAreaInfoValue;
import ngves.asiainfo.core.floor.domain.TabsInfoForFront;
import ngves.asiainfo.core.floor.domain.TabsInfoValue;
import ngves.asiainfo.core.floor.ivalues.IFloorInfoValue;
import ngves.asiainfo.core.floor.ivalues.IFloorSubKindValue;
import ngves.asiainfo.core.floor.ivalues.IFloorTabsRltValue;
import ngves.asiainfo.core.floor.ivalues.ITabsAreaInfoValue;
import ngves.asiainfo.core.floor.ivalues.ITabsInfoValue;
import ngves.asiainfo.core.floor.service.interfaces.IFloorInfoSrv;
import ngves.asiainfo.util.StringUtil;

public class FloorInfoSrvImpl implements IFloorInfoSrv {

	private IFloorInfoDAO floorInfoDAO;
	private IFloorSubKindDAO floorSubKindDAO;
	private IFloorTabsRltDAO floorTabsRltDAO;
	private ITabsAreaInfoDAO tabsAreaInfoDAO;
	private ITabsInfoDAO tabsInfoDAO;
	String floorField = "AdImgHref,BakCol2,BakCol1,TabsNum,FloorId,IsShowSubKind,ModifyDate,FloorImgHref,FloorImgUrl,AdImgUrl,IsContainAd,FloorName,CreateDate,IsHomeStatus,FloorSort,AdBackColor";
	String floorTabsField = "TabsTemplate,ModityDate,BakCol1,CreatDate,TabsName,TabsId";
	public void setFloorInfoDAO(IFloorInfoDAO floorInfoDAO) throws Exception {
		this.floorInfoDAO = floorInfoDAO;
	}

	public void setFloorSubKindDAO(IFloorSubKindDAO floorSubKindDAO) throws Exception {
		this.floorSubKindDAO = floorSubKindDAO;

	}

	public void setFloorTabsRltDAO(IFloorTabsRltDAO floorTabsRltDAO) throws Exception {
		this.floorTabsRltDAO = floorTabsRltDAO;

	}

	public void setTabsAreaInfoDAO(ITabsAreaInfoDAO tabsAreaInfoDAO) throws Exception {
		this.tabsAreaInfoDAO = tabsAreaInfoDAO;

	}

	public void setTabsInfoDAO(ITabsInfoDAO tabsInfoDAO) throws Exception {
		this.tabsInfoDAO = tabsInfoDAO;

	}
	
	/***
	 * 新增层基本信息
	 */
	public long saveFloorInfo(IFloorInfoValue floorInfoValue,String subKindJSON,long staffId, String comType, long orgId) throws Exception {
		long floorId = floorInfoDAO.saveFloorInfo(floorInfoValue);
		//如果楼层子类目设置为显示，则要处理楼层子类目
		if(FloorConstant.FLOOR_IS_SHOW_SUB_KIND.equals(floorInfoValue.getIsShowSubKind())){
			saveFloorSubKind(subKindJSON,floorId+"","",staffId,comType,orgId);
		}
		//记录业务日志信息
		long busiInfoId = BusiInfoEngine.getNewId().longValue();
			BusiInfoUtil.recordBusiInfo(busiInfoId + "", FloorConstant.SYS_PARA_BUSI_TYPE_WEB_FLOOR_CREATE, -1,
	                "新建楼层",CoreConstant.BUSI_INFO_OPT_TYPE_ADD,"楼层ID："+floorId+"；楼层名称："+floorInfoValue.getFloorName(), staffId, comType, orgId);
		
		return floorId;
	}

	/**
	 * 删除楼层
	 */
	public void delFloorInfo(IFloorInfoValue floorInfoValue,long staffId, String comType, long orgId) throws Exception {
		//1.删除楼层子类目
		IFloorSubKindValue[] floorSubKindValues = this.floorSubKindDAO.queryFloorSubKindByFloorId(floorInfoValue
				.getFloorId());
		if (null != floorSubKindValues && floorSubKindValues.length > 0) {
			String delSubKindIds="";
			for (IFloorSubKindValue foorSubKindValue : floorSubKindValues) {
				foorSubKindValue.setStsToOld();
				foorSubKindValue.delete();
				delSubKindIds+=foorSubKindValue.getFloorSubId()+",";
			}
			this.floorSubKindDAO.saveBatchFloorSubKinds(floorSubKindValues);
			//记录业务日志信息
			long busiInfoId = BusiInfoEngine.getNewId().longValue();
				BusiInfoUtil.recordBusiInfo(busiInfoId + "", FloorConstant.SYS_PARA_BUSI_TYPE_WEB_FLOOR_DELETE, -1,
		                "楼层已删除，删除其下关联子类目",CoreConstant.BUSI_INFO_OPT_TYPE_DELETE,"删除的子类目ID为："+delSubKindIds, staffId, comType, orgId);
		}
		//2.解除楼层绑定关系
		IFloorTabsRltValue[] floorTabsRltValues = this.queryFloorTabsByFloorId(floorInfoValue.getFloorId());
		if (null != floorTabsRltValues && floorTabsRltValues.length > 0) {
			StringBuffer delFloorTabsRltIdsBuffer=new StringBuffer("");
			for (IFloorTabsRltValue floorRlt : floorTabsRltValues) {
				floorRlt.setStsToOld();
				floorRlt.delete();
				delFloorTabsRltIdsBuffer.append(floorRlt.getFloorTabsRltId()+",");
			}
			this.floorTabsRltDAO.saveBatchFloorTabsRlts(floorTabsRltValues);
			//记录业务日志信息
			long busiInfoId = BusiInfoEngine.getNewId().longValue();
				BusiInfoUtil.recordBusiInfo(busiInfoId + "", FloorConstant.SYS_PARA_BUSI_TYPE_WEB_FLOOR_DELETE, -1,
		                "楼层已删除，删除其下关联默认页签关系",CoreConstant.BUSI_INFO_OPT_TYPE_DELETE,"删除关系标识为："+delFloorTabsRltIdsBuffer.substring(0,delFloorTabsRltIdsBuffer.length()-1), staffId, comType, orgId);
		}
		floorInfoValue.delete();
		floorInfoDAO.delFloorInfo(floorInfoValue);
		//记录业务日志信息
		long busiInfoId = BusiInfoEngine.getNewId().longValue();
			BusiInfoUtil.recordBusiInfo(busiInfoId + "", FloorConstant.SYS_PARA_BUSI_TYPE_WEB_FLOOR_DELETE, -1,
	                "删除楼层",CoreConstant.BUSI_INFO_OPT_TYPE_DELETE,"楼层ID："+floorInfoValue.getFloorId()+"；楼层名称："+floorInfoValue.getFloorName(), staffId, comType, orgId);
		

	}

	/**
	 * 修改楼层基本信息(维护广告)
	 */
	public long modifyFloorInfo(IFloorInfoValue floorInfoValue,IFloorInfoValue oldValue,long staffId, String comType, long orgId) throws Exception {
		long floorId = floorInfoDAO.saveFloorInfo(floorInfoValue);
		//记录业务日志基本信息
		long busiInfoId = BusiInfoEngine.getNewId().longValue();
		BusiInfoUtil.recordBusiInfo(busiInfoId + "", FloorConstant.SYS_PARA_BUSI_TYPE_WEB_FLOOR_MODIFY, -1,
	            "楼层维护:维护广告信息",CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,"楼层ID："+floorInfoValue.getFloorId()+"；楼层名称："+floorInfoValue.getFloorName(), staffId, comType, orgId);
		//记录业务日志详细信息
		if(null!=oldValue&&0!=oldValue.getFloorId()){			
			BusiInfoUtil.recordBusiDetail(busiInfoId+"", new Object[]{oldValue}, new Object[]{floorInfoValue}, floorField);
		}
		return floorId;
	}
	
	/**
	 * 修改楼层基本信息
	 */
	public long modifyFloorInfo(IFloorInfoValue floorInfoValue,String subKindJSON,String floorInfoId,String delSubKindIds,long staffId, String comType, long orgId) throws Exception {
		//如果楼层基本信息表未做任何更改，就只处理楼层子类目信息
		long floorId=0L;
		if(null==floorInfoValue){
			saveFloorSubKind(subKindJSON, floorInfoId,delSubKindIds,staffId,comType,orgId);
		}else{
			//如果楼层子类目设置为不显示，查询楼层楼层下是否有关联子类目，有的话删除
			if(FloorConstant.FLOOR_IS_NOT_SHOW_SUB_KIND.equals(floorInfoValue.getIsShowSubKind())){
				//查询楼层关联子类目
				IFloorSubKindValue[] floorSubKindValues = this.floorSubKindDAO.queryFloorSubKindByFloorId(floorInfoValue
						.getFloorId());
				if (null != floorSubKindValues && floorSubKindValues.length > 0) {
					StringBuffer delsubIds=new StringBuffer("");
					for (IFloorSubKindValue foorSubKindValue : floorSubKindValues) {
						foorSubKindValue.setStsToOld();
						foorSubKindValue.delete();
						delsubIds.append(foorSubKindValue.getFloorSubId()+",");
					}
					this.floorSubKindDAO.saveBatchFloorSubKinds(floorSubKindValues);
					//记录业务日志信息
					  long busiInfoId = BusiInfoEngine.getNewId().longValue();
					  BusiInfoUtil.recordBusiInfo(busiInfoId + "", FloorConstant.SYS_PARA_BUSI_TYPE_WEB_FLOOR_SUB_DELETE, -1,
					            "楼层是否展示子类目由\"是\"改为\"否\"，删除该楼层下关联中类",CoreConstant.BUSI_INFO_OPT_TYPE_DELETE,"删除的中类ID："+delsubIds.substring(0,delsubIds.length()-1), staffId, comType, orgId); 
				}
				
			}//如果楼层子类目设置为显示，则要处理楼层子类目（子类目有可能新增、修改或删除）
			if(FloorConstant.FLOOR_IS_SHOW_SUB_KIND.equals(floorInfoValue.getIsShowSubKind())){
				saveFloorSubKind(subKindJSON, floorInfoId,delSubKindIds,staffId,comType,orgId);
			}
			//如果楼层广告设置为不显示，则把广告信息置空
			if(FloorConstant.FLOOR_IS_NOT_CONTAIN_AD.equals(floorInfoValue.getIsContainAd())){
				floorInfoValue.setAdImgHref(null);	
				floorInfoValue.setAdImgUrl(null);
			}
			IFloorInfoValue oldValue = queryFloorInfoById(floorInfoValue.getFloorId());
			floorId = floorInfoDAO.saveFloorInfo(floorInfoValue);
			
			//记录业务日志信息
			long busiInfoId = BusiInfoEngine.getNewId().longValue();
			BusiInfoUtil.recordBusiInfo(busiInfoId + "", FloorConstant.SYS_PARA_BUSI_TYPE_WEB_FLOOR_MODIFY, -1,
		            "修改楼层",CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,"楼层ID："+floorInfoValue.getFloorId()+"；楼层名称："+floorInfoValue.getFloorName(), staffId, comType, orgId);
			//记录业务日志信息(详情)
			if(null!=oldValue&&0!=oldValue.getFloorId()){			
				BusiInfoUtil.recordBusiDetail(busiInfoId+"", new Object[]{oldValue}, new Object[]{floorInfoValue}, floorField);
			}
		}
		
	
		return floorId;
	}
	/**
	 * 处理楼层关联中类
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void saveFloorSubKind(String subKindJSON,String floorInfoId,String delSubKindIds,long staffId, String comType, long orgId) throws Exception {
			Gson g = new Gson();
			FloorSubKindValue[] floorSubKindValues = g.fromJson(subKindJSON, FloorSubKindValue[].class);
			IFloorSubKindValue[] iFloorSubKindValues = new IFloorSubKindValue[floorSubKindValues.length];
			FloorSubKindValue.toBeans(floorSubKindValues, iFloorSubKindValues, Long.parseLong(floorInfoId),staffId,comType,orgId);
			//保存关联中类
			saveBatchFloorSubKinds(iFloorSubKindValues);
			//根据id串批量删除中类
			if (StringUtil.isNotBlank(delSubKindIds)) {
			  delFloorSubKinds(delSubKindIds,staffId,comType,orgId);
			}		
	}
	
	
	

	/**
	 * 根据Id查询楼层
	 */
	public IFloorInfoValue queryFloorInfoById(long floorId) throws Exception {
		return floorInfoDAO.queryFloorInfoById(floorId);
	}

	/**
	 * 根据楼层名称查询楼层
	 */
	public IFloorInfoValue[] queryFloorInfosByName(String floorName) throws Exception {
		IFloorInfoValue[] values = floorInfoDAO.queryFloorsByName(floorName);
		if (0 != values.length) {
			for (IFloorInfoValue value : values) {
				value.setIsHomeShow(FloorConstant.FLOOR_IS_HOME_SHOW.equals(value.getIsHomeShow()) ? "是" : "否");
				value.setIsContainAd(FloorConstant.FLOOR_IS_CONTAIN_AD.equals(value.getIsContainAd()) ? "是" : "否");
			}
		}
		return values;
	}

	/**
	 * 根据楼层名称查询楼层
	 */
	public IFloorInfoValue[] queryFloorInfosByName(String floorName, int startNum, int endNum) throws Exception {
		IFloorInfoValue[] values = floorInfoDAO.queryFloorsByName(floorName, startNum, endNum);
		if (0 != values.length) {
			values = fillHTML(values);
		}
		return values;
	}

	/**
	 * 根据楼层名称查询结果总数
	 */
	public int queryFloorInfoByNameCount(String floorName) throws Exception {
		return floorInfoDAO.queryFloorsByNameCount(floorName);
	}

	/**
	 * 填充操作字段及标识转义
	 */
	private IFloorInfoValue[] fillHTML(IFloorInfoValue[] values) throws Exception {

		for (IFloorInfoValue value : values) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(" <a href=\"#\" onclick=\"modifyFloorInfo('" + value.getFloorId()
					+ "')\" >编辑基本信息</a>&nbsp;&nbsp; ");
			buffer.append(" <a href=\"#\" onclick=\"modifyTabInfo('" + value.getFloorId()
					+ "')\" >编辑默认页签</a>&nbsp;&nbsp; ");
			if (value.getTabsNum() > 1) {
				buffer.append("<a href=\"#\" onclick=\"modifyfloorWarTabs('" + value.getFloorId() + "','"
						+ value.getTabsNum() + "','"+value.getIsContainAd()+"')\" >编辑商品页签</a>&nbsp;&nbsp; ");
			}
			if (FloorConstant.FLOOR_IS_CONTAIN_AD.equals(value.getIsContainAd())) {
				buffer.append("<a href=\"#\" onclick=\"modifyAdInfo('" + value.getFloorId()
						+ "')\" >编辑通栏广告</a>&nbsp;&nbsp; ");
			}
			buffer.append("<a href=\"#\" onclick=\"isdelFloorInfo('" + value.getFloorId()
					+ "')\" >删除</a>&nbsp;&nbsp;&nbsp;&nbsp;");
			if (FloorConstant.FLOOR_IS_NOT_HOME_SHOW.equals(value.getIsHomeShow())) {
				buffer.append("<a href=\"#\" onclick=\"modifyIsHomeShow('" + value.getFloorId()
						+ "')\" >在首页展示</a>&nbsp;&nbsp;");
			}
			if (FloorConstant.FLOOR_IS_HOME_SHOW.equals(value.getIsHomeShow())) {
				buffer.append("<a href=\"#\" onclick=\"modifyIsHomeShow('" + value.getFloorId()
						+ "')\" >不在首页展示</a>&nbsp;&nbsp;");
			}
			value.setBakCol1(buffer.toString());
			value.setIsHomeShow(FloorConstant.FLOOR_IS_HOME_SHOW.equals(value.getIsHomeShow()) ? "是" : "否");
			value.setIsContainAd(FloorConstant.FLOOR_IS_CONTAIN_AD.equals(value.getIsContainAd()) ? "是" : "否");
		}
		return values;
	}

	/**
	 * 修改楼层是否在首页展示（当前显示的点击置为不显示，反之亦然）
	 * @param floorId
	 * @throws Exception
	 */
	public void modifyIsHomeShow(String floorId,long staffId, String comType, long orgId) throws Exception {
		if (StringUtil.isBlank(floorId)) {
			throw new Exception(" don't showFloorInfo because of floorId is null ");
		}
		//1.查询楼层信息
		IFloorInfoValue floorInfo = floorInfoDAO.queryFloorInfoById(Long.parseLong(floorId));
		if (null != floorInfo) {
			long busiInfoId=0L;
			IFloorInfoValue oldValue = new FloorInfoBean();
			oldValue.copy(floorInfo);
			if (FloorConstant.FLOOR_IS_HOME_SHOW.equals(floorInfo.getIsHomeShow())) {
				floorInfo.setIsHomeShow(FloorConstant.FLOOR_IS_NOT_HOME_SHOW);
				//记录业务日志基本信息
				   busiInfoId = BusiInfoEngine.getNewId().longValue();
				  BusiInfoUtil.recordBusiInfo(busiInfoId + "", FloorConstant.SYS_PARA_BUSI_TYPE_WEB_FLOOR_MODIFY, -1,
				            "修改楼层是否首页展示:由\"是\"改为了\"否\"",CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,"修改的楼层id："+floorInfo.getFloorId()+"。修改的楼层名称："+floorInfo.getFloorName(), staffId, comType, orgId);
				
			} else if (FloorConstant.FLOOR_IS_NOT_HOME_SHOW.equals(floorInfo.getIsHomeShow())) {
				floorInfo.setIsHomeShow(FloorConstant.FLOOR_IS_HOME_SHOW);
				//记录业务日志基本信息
				   busiInfoId = BusiInfoEngine.getNewId().longValue();
				  BusiInfoUtil.recordBusiInfo(busiInfoId + "", FloorConstant.SYS_PARA_BUSI_TYPE_WEB_FLOOR_MODIFY, -1,
				            "修改楼层是否首页展示:由\"否\"改为了\"是\"",CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,"修改的楼层id："+floorInfo.getFloorId()+"。修改的楼层名称："+floorInfo.getFloorName(), staffId, comType, orgId);
			}
			floorInfoDAO.saveFloorInfo(floorInfo);
			//记录业务日志详细信息
			if(null!=oldValue&&0!=oldValue.getFloorId()){			
				BusiInfoUtil.recordBusiDetail(busiInfoId+"", new Object[]{oldValue}, new Object[]{floorInfo}, floorField);
			}
		} else {
			throw new Exception(" don't modify isShowFloorInfo because of don't get floorInfo. please check db  ");
		}
	}

	/***
	 * 保存楼层推荐绑定（默认页签设置）
	 */
	public long saveFloorTabsRlt(IFloorTabsRltValue floorTabsRltValue,long staffId, String comType, long orgId) throws Exception {
		//判断一个楼层绑定推荐是否在时间上有冲突
		if (floorTabsRltDAO.isTimeConflict(floorTabsRltValue.getBeginTime(), floorTabsRltValue.getEndTime(),
				floorTabsRltValue.getFloorId() + "")) {
			throw new Exception("开始结束时间段内已经存在绑定的推荐信息！");
		}
		long floorTabsRltId = floorTabsRltDAO.saveFloorTabsRlt(floorTabsRltValue);
		//记录业务日志信息
		  long busiInfoId = BusiInfoEngine.getNewId().longValue();
		  BusiInfoUtil.recordBusiInfo(busiInfoId + "", FloorConstant.SYS_PARA_BUSI_TYPE_WEB_FLOOR_TAB_RLT_CREATE, -1,
		            "新增楼层绑定默认页签关系",CoreConstant.BUSI_INFO_OPT_TYPE_ADD,"绑定标识："+floorTabsRltValue.getFloorTabsRltId()+"。页签名字："+floorTabsRltValue.getFloorTabsName(), staffId, comType, orgId); 
		return floorTabsRltId;
	}

	/**
	* 删除页签绑定关系 
	* @param floorInfoValue
	* @throws Exception
	*/
	public void delFloorTabsRlt(IFloorTabsRltValue floorTabsRltValue,long staffId, String comType, long orgId) throws Exception {
		floorTabsRltValue.delete();
		floorTabsRltDAO.delFloorTabsRlt(floorTabsRltValue);
		//记录业务日志信息
		  long busiInfoId = BusiInfoEngine.getNewId().longValue();
		  BusiInfoUtil.recordBusiInfo(busiInfoId + "", FloorConstant.SYS_PARA_BUSI_TYPE_WEB_FLOOR_TAB_RLT_DELETE, -1,
		            "解除楼层绑定默认页签关系",CoreConstant.BUSI_INFO_OPT_TYPE_DELETE,"解除绑定标识："+floorTabsRltValue.getFloorTabsRltId()+"。页签名字："+floorTabsRltValue.getFloorTabsName(), staffId, comType, orgId); 
	}

	/**
	 * 根据id查询绑定页签绑定关系
	 * @param floorTabsId
	 * @return
	 * @throws Exception
	 */
	public IFloorTabsRltValue queryFloorTabsRltById(long floorTabsId) throws Exception {
		return floorTabsRltDAO.queryFloorTabsRltById(floorTabsId);
	}

	/**
	* 根据楼层Id查询楼层绑定推荐
	*/
	public IFloorTabsRltValue[] queryFloorTabsByFloorId(long floorId) throws Exception {
		IFloorTabsRltValue[] floorTabsRltValue = floorTabsRltDAO.queryFloorTabsByFloorId(floorId);
		ITabsInfoValue[] values = queryTabsInfo();
		for (int j = 0; j < floorTabsRltValue.length; j++) {
			for (int i = 0; i < values.length; i++) {
				if (floorTabsRltValue[j].getTabsId() == values[i].getTabsId()) {
					floorTabsRltValue[j].setBakCol1(values[i].getTabsName());
				}
			}
		}
		return floorTabsRltValue;
	}

	/**
	 * 查询楼层关联内容（即页签表）
	 * @return
	 * @throws Exception 
	 */
	public ITabsInfoValue[] queryTabsInfo() throws Exception {
		return floorInfoDAO.queryTabsInfo();
	}

	/**
	 * 保存楼层子类目
	 * @param floorSubKindValue
	 * @return
	 * @throws Exception
	 */
//	public long saveFloorSubKind(IFloorSubKindValue floorSubKindValue) throws Exception {
//		long floorSubId = 0L;
//		if (floorSubKindValue.isNew()) {
//			floorSubId = floorSubKindDAO.getNewId();
//			floorSubKindValue.setFloorSubId(floorSubId);
//			floorSubKindValue.setCreateDate(new Timestamp(System.currentTimeMillis()));
//		}else{
//			floorSubKindValue.setModifyDate(new Timestamp(System.currentTimeMillis()));	
//		}
//		
//		floorSubId = floorSubKindValue.getFloorSubId();
//		floorSubKindDAO.saveFloorSubKind(floorSubKindValue);
//		return floorSubId;
//
//	}

	/***
	 * 批量保存子类目
	 * @param floorSubKindValue
	 * @throws Exception
	 */
	public void saveBatchFloorSubKinds(IFloorSubKindValue[] floorSubKindValues) throws Exception {
		floorSubKindDAO.saveBatchFloorSubKinds(floorSubKindValues);
	}

	/***
	 * 根据id批量删除子类目
	 * @param ids 标识
	 * @throws Exception
	 */
	public void delFloorSubKinds(String floorSubIds,long staffId, String comType, long orgId) throws Exception {
		IFloorSubKindValue [] values=floorSubKindDAO.queryFloorSubKindByIds(floorSubIds.substring(0,floorSubIds.length()-1));
		if(null!=values&&values.length>0){
			StringBuffer Str=new StringBuffer("");
			for(IFloorSubKindValue value:values){
				value.delete();
				Str.append(value.getFloorSubName()+",");
			}
			floorSubKindDAO.saveBatchFloorSubKinds(values);
			//记录业务日志信息
			  long busiInfoId = BusiInfoEngine.getNewId().longValue();
			  BusiInfoUtil.recordBusiInfo(busiInfoId + "", FloorConstant.SYS_PARA_BUSI_TYPE_WEB_FLOOR_SUB_DELETE, -1,
			            "批量删除楼层关联中类",CoreConstant.BUSI_INFO_OPT_TYPE_DELETE,"删除的中类ID："+floorSubIds.substring(0,floorSubIds.length()-1)+"。中类名字："+Str.substring(0,Str.length()-1), staffId, comType, orgId); 
		}
	
	}

	/**
	* 根据标识查询楼层绑定子类目
	*/
	public IFloorSubKindValue queryFloorSubKindById(long floorSubId) throws Exception {
		IFloorSubKindValue floorSubKindValue = floorSubKindDAO.queryFloorSubKindById(floorSubId);
		return floorSubKindValue;
	}

	/**
	* 根据楼层Id查询楼层绑定子类目
	*/
	public IFloorSubKindValue[] queryFloorSubKindByFloorId(long floorInfoId) throws Exception {
		IFloorSubKindValue[] floorSubKindValue = floorSubKindDAO.queryFloorSubKindByFloorId(floorInfoId);
		return floorSubKindValue;
	}
	 /** 
	 * 根据前台展示的楼层查询所有楼层下的子类目
	 */
	public IFloorSubKindValue[] queryFloorSubKindByFloorIds(IFloorInfoValue[] floorInfoValues) throws Exception{
		return floorSubKindDAO.queryFloorSubKindByFloorIds(floorInfoValues);
	}

	/***
	 * 获取新表示
	 */
	public long getSubKindNewId() throws Exception {
		return floorSubKindDAO.getNewId();

	}
	
	/***
	 * 保存页签
	 * @param tabsInfoValue
	 * @return
	 * @throws Exception
	 */
	public long saveTabsInfo(String  tabsInfo,String tabsAreaJson,String delTabsAreaIds,long staffId, String comType, long orgId)throws Exception{
		Gson g = new Gson();
		long tabsId=0;
		TabsInfoValue tabs = g.fromJson(tabsInfo, TabsInfoValue.class);
		if(null!=tabs){
		   if("0".equals(tabs.getTabsId())||null==tabs.getTabsId()){//新增
	        	 ITabsInfoValue tabsInfoValue= new TabsInfoBean();
	        	 g.fromJson(tabsInfo, TabsInfoValue.class).toBean(tabsInfoValue);
	        	 //保存页签信息
	        	 tabsInfoDAO.saveTabsInfo(tabsInfoValue);
	        	 tabsId=tabsInfoValue.getTabsId();
	        	 //记录业务日志信息
	 			  long busiInfoId = BusiInfoEngine.getNewId().longValue();
	 			  BusiInfoUtil.recordBusiInfo(busiInfoId + "", FloorConstant.SYS_PARA_BUSI_TYPE_WEB_FLOOR_TAB_CREATE, -1,
	 			            "新增默认页签",CoreConstant.BUSI_INFO_OPT_TYPE_ADD,"新增的默认页签id："+tabsId+"。新增的默认页签名称："+tabsInfoValue.getTabsName(), staffId, comType, orgId);
	         }else{//修改 
	        	 ITabsInfoValue[] tabsInfoValue =queryTabsById(Long.parseLong(tabs.getTabsId()));
	        	 if(null==tabsInfoValue||0==tabsInfoValue.length){
	        		 return tabsId;
	        	 }else{
	        		 ITabsInfoValue oldValue=new TabsInfoBean();
	        		 oldValue.copy(tabsInfoValue[0]);
	        		 	//保存页签信息
	            	 tabsInfoValue[0].setTabsName(tabs.getTabsName());
	            	 tabsInfoValue[0].setTabsTemplate(tabs.getTabsTemplate());
	            	 tabsInfoValue[0].setModityDate(new Timestamp(new Date().getTime()));
	            	 tabsInfoDAO.saveTabsInfo(tabsInfoValue[0]);
	            	 tabsId=tabsInfoValue[0].getTabsId();
	            	//记录业务日志基本信息
	   			  long busiInfoId = BusiInfoEngine.getNewId().longValue();
	   			  BusiInfoUtil.recordBusiInfo(busiInfoId + "", FloorConstant.SYS_PARA_BUSI_TYPE_WEB_FLOOR_TAB_MODIFY, -1,
	   			            "修改默认页签",CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,"修改的默认页签id："+tabsId, staffId, comType, orgId);
	   			  //记录业务日志详细信息
	   			if(null!=oldValue&&0!=oldValue.getTabsId()){			
	   				BusiInfoUtil.recordBusiDetail(busiInfoId+"", new Object[]{oldValue}, new Object[]{tabsInfoValue[0]}, floorTabsField);
	   			}
	            	 }
	        	 }
		}
         TabsAreaInfoValue[] tabsAreas = g.fromJson(tabsAreaJson, TabsAreaInfoValue[].class);
   		 ITabsAreaInfoValue[] iTabsAreas = new ITabsAreaInfoValue[tabsAreas.length];
   		 TabsAreaInfoValue.toBeans(tabsAreas, iTabsAreas, tabsId,staffId, comType, orgId);
   		 saveTabsAreaInfos(iTabsAreas);
   		 if(null!=delTabsAreaIds&&!"".equals(delTabsAreaIds)){
			delTabsAreaInfosByIds(delTabsAreaIds,staffId, comType, orgId);
		
	      } 
   		return tabsId;
   		}
	/***
	 * 删除页签
	 * @param tabsInfoValue
	 * @return
	 * @throws Exception
	 */
	public void delTabsInfo(ITabsInfoValue tabsInfoValue,long staffId, String comType, long orgId)throws Exception{
		//删除页签区域信息
		ITabsAreaInfoValue[] tabsAreaInfoValues = this.queryTabsAreaInfoByTabsId(tabsInfoValue.getTabsId());
		this.delTabsAreaInfos(tabsAreaInfoValues,staffId,comType,orgId);
		//删除页签
		tabsInfoValue.delete();
		tabsInfoDAO.saveTabsInfo(tabsInfoValue);
		//记录业务日志信息
		  long busiInfoId = BusiInfoEngine.getNewId().longValue();
		  BusiInfoUtil.recordBusiInfo(busiInfoId + "", FloorConstant.SYS_PARA_BUSI_TYPE_WEB_FLOOR_TAB_DELETE, -1,
		            "删除默认页签",CoreConstant.BUSI_INFO_OPT_TYPE_DELETE,"删除的默认页签id："+tabsInfoValue.getTabsId()+"。删除的默认页签名称："+tabsInfoValue.getTabsName(), staffId, comType, orgId); 
		
	
	} 
		
	/***
	 * 根据标识查询楼层默认推荐（页签表）
	 * @param tabsInfoId
	 * @return
	 * @throws Exception
	 */
	public ITabsInfoValue queryTabsInfoByTabsId(long tabsInfoId)throws Exception{
		return tabsInfoDAO.queryTabsInfoById(tabsInfoId);
	} 
	
	/**
	 * 根据id查页签基本能信息
	 */
	public ITabsInfoValue[] queryTabsById(long tabsInfoId) throws Exception{
		return tabsInfoDAO.queryTabsById(tabsInfoId);
	}
	/**
	 * 根据推荐名称模糊查询楼层默认推荐（页签表）
	 */
	public ITabsInfoValue[] queryTabsInfoByName(String tabsName, int satarNum, int endNum) throws Exception {
		return tabsInfoDAO.queryTabsByName(tabsName, satarNum, endNum);
	}

	/**
	* 根据推荐名称模糊查询楼层默认推荐总数（页签表）
	*/
	public int queryTabsInfoByNameCount(String tabsName) throws Exception {
		return tabsInfoDAO.queryTabsByNameCount(tabsName);
	}
	/***
	 * 获取新标识
	 * @return 页签表
	 * @throws Exception
	 */
	public long getTabsInfoNewId() throws Exception{
		return tabsInfoDAO.getNewId();
	}
	
	/***
	 * 保存页签区域信息
	 * @param tabsInfoValue
	 * @return
	 * @throws Exception
	 */
	public long saveTabsAreaInfo(ITabsAreaInfoValue tabsAreaInfoValue)throws Exception{
		long tabsAreaId = 0L;
		if (tabsAreaInfoValue.isNew()) {
			tabsAreaId = tabsAreaInfoDAO.getNewId();
			tabsAreaInfoValue.setTabsAreaId(tabsAreaId);
		}            
		tabsAreaId = tabsAreaInfoValue.getTabsAreaId();
		tabsAreaInfoDAO.saveTabsAreaInfo(tabsAreaInfoValue);
		return tabsAreaId;
	}
	/***
	 * 批量保存页签区域信息
	 * @param tabsInfoValue
	 * @return
	 * @throws Exception
	 */
	public void saveTabsAreaInfos(ITabsAreaInfoValue[] tabsAreaInfoValues)throws Exception{
		tabsAreaInfoDAO.savTabsAreaInfos(tabsAreaInfoValues);
	}
	/***
	 * 批量删除页签区域信息
	 * @param tabsInfoValue
	 * @return
	 * @throws Exception
	 */
	public void delTabsAreaInfos(ITabsAreaInfoValue[] tabsAreaInfoValues,long staffId, String comType, long orgId)throws Exception{
		if(null!=tabsAreaInfoValues){
			StringBuffer tabsIdBuffer=new StringBuffer("");
		    for(ITabsAreaInfoValue value:tabsAreaInfoValues){
		    	value.delete(); 
		    	tabsIdBuffer.append(value.getTabsAreaId()+",");
	          }
			 tabsAreaInfoDAO.savTabsAreaInfos(tabsAreaInfoValues);
			//记录业务日志信息
			  long busiInfoId = BusiInfoEngine.getNewId().longValue();
			  BusiInfoUtil.recordBusiInfo(busiInfoId + "", FloorConstant.SYS_PARA_BUSI_TYPE_WEB_FLOOR_TAB_AREA_DELETE, -1,
			            "默认页签删除，删除其下关联区域信息",CoreConstant.BUSI_INFO_OPT_TYPE_DELETE,"删除的区域id："+tabsIdBuffer.substring(0,tabsIdBuffer.length()-1), staffId, comType, orgId); 
		}	
	} 
	/**
	 * 根据id查询页签区域信息
	 * @param tabsId
	 * @return
	 * @throws Exception
	 */
	public ITabsAreaInfoValue queryTabsAreaInfoById(long tabsAreaId) throws Exception{
		return tabsAreaInfoDAO.queryTabsAreaInfoById(tabsAreaId);
	}
	/***
	 * 根据id批量页签区域
	 * @param ids 标识
	 * @throws Exception
	 */
	public void delTabsAreaInfosByIds(String tabsAreaIds,long staffId, String comType, long orgId) throws Exception {
		ITabsAreaInfoValue [] values=tabsAreaInfoDAO.queryTabsAreaInfoByIds(tabsAreaIds.substring(0,tabsAreaIds.length()-1));
		if(null!=values&&values.length>0){
			for(ITabsAreaInfoValue value:values){
				value.delete();
			}
			tabsAreaInfoDAO.savTabsAreaInfos(values);
			 long busiInfoId = BusiInfoEngine.getNewId().longValue();
		     BusiInfoUtil.recordBusiInfo(busiInfoId + "", FloorConstant.SYS_PARA_BUSI_TYPE_WEB_FLOOR_TAB_AREA_DELETE, -1,
		   "楼层默认页签模版改变。删除多余默认页签区域信息",CoreConstant.BUSI_INFO_OPT_TYPE_DELETE,"删除的默认页签区域id："+tabsAreaIds, staffId, comType, orgId); 
		}
	    
	}
	
	/**
	 * 根据页签id查询页签区域信息
	 * @param tabsId
	 * @return
	 * @throws Exception
	 */
	public ITabsAreaInfoValue[] queryTabsAreaInfoByTabsId(long tabsId) throws Exception{
		return tabsAreaInfoDAO.queryTabsAreaInfoByTabsId(tabsId);
	}
	/***
	 * 获取新标识
	 * @return 页签区域表
	 * @throws Exception
	 */
	public long getTabsAreaInfoNewId() throws Exception{
		return tabsAreaInfoDAO.getNewId();
	}
	
	/**********************************前台开始 ***************************************************/
	/***
	 * 前台楼层展示
	 */
	public IFloorInfoValue[] queryFloorInfosForFront() throws Exception{
		return floorInfoDAO.queryFloorInfosForFront(); 
	}
	/***
	 * 前台楼层默认页签展示（当前时间展示的默认页签）
	 */
	public TabsInfoForFront queryFloorTabsForFront(long floorInfoId) throws Exception{
		//查询当前时间展示的默认页签
		IFloorTabsRltValue[] floorTabsRltValues = floorTabsRltDAO.queryFloorTabsByFloorIdForFront(floorInfoId);
		if(null!=floorTabsRltValues&&0!=floorTabsRltValues.length){
			TabsInfoForFront tabsInfoFront=new TabsInfoForFront();
			//根据关联表的页签id查询默认页签
			ITabsInfoValue tabsInfo=tabsInfoDAO.queryTabsInfoById(floorTabsRltValues[0].getTabsId());
			//根据页签id查询页签区域信息
//			if(null!=tabsInfo){
//			ITabsAreaInfoValue[] tabsAreaInfos=	tabsAreaInfoDAO.queryTabsAreaInfoByTabsId(tabsInfo.getTabsId());
//			tabsInfoFront.setTabsAreaInfoList(Arrays.asList(tabsAreaInfos));
//			}
			tabsInfoFront.setTabsName(floorTabsRltValues[0].getFloorTabsName());
			tabsInfoFront.setTabsTemplate(tabsInfo.getTabsTemplate());
			tabsInfoFront.setTabsId(tabsInfo.getTabsId()+"");
		return tabsInfoFront;	
		}else{
			return null; 
		}
	}

}
