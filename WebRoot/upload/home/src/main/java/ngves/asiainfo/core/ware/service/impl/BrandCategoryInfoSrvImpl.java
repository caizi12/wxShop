package ngves.asiainfo.core.ware.service.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.common.bo.BusiInfoEngine;
import ngves.asiainfo.core.common.util.BusiInfoUtil;
import ngves.asiainfo.core.ware.WareConstant;
import ngves.asiainfo.core.ware.bo.BrandCategoryInfoBean;
import ngves.asiainfo.core.ware.dao.interfaces.IBrandCategoryInfoDAO;
import ngves.asiainfo.core.ware.ivalues.IBrandCategoryInfoValue;
import ngves.asiainfo.core.ware.service.interfaces.IBrandCategoryInfoSrv;
import ngves.asiainfo.util.DateTimeUtil;

public class BrandCategoryInfoSrvImpl implements IBrandCategoryInfoSrv {

	private IBrandCategoryInfoDAO brandCategoryInfoDAO;

	public void saveBrandCategoryInfo(IBrandCategoryInfoValue value) throws Exception {
		value.setIsSpell(value.getIsSpell());
		brandCategoryInfoDAO.saveBrandCategoryInfo(value);
	}
	
	
	public void saveBrandCategoryInfo(IBrandCategoryInfoValue newBean, long staffId, String comType, long orgId,
			String isSpell, String spellLength, String cycleNum) throws Exception {

		//记录日志对象
		IBrandCategoryInfoValue oldBean = new BrandCategoryInfoBean();
		oldBean.copy(newBean);

		newBean.setStsToOld();
		//确定轮换为开
		if(isSpell.equals(WareConstant.BRAND_SPELL_SWITCH)){
			newBean.setSpellSatrtTime(DateTimeUtil.getNowTimeStamp());//轮换开始时间
			newBean.setIsSpell(Long.valueOf(isSpell)); 				//是否轮换
			newBean.setSpellInternalLength(Long.valueOf(spellLength));//轮换周期
			newBean.setCycleNum(Long.valueOf(cycleNum));//轮换个数
		}else{
			newBean.setSpellSatrtTime(DateTimeUtil.getNowTimeStamp());//轮换开始时间 :空
			newBean.setIsSpell(Long.valueOf(0)); 						//是否轮换 : 0
			newBean.setSpellInternalLength(Long.valueOf(0));			//轮换周期 : 0
			newBean.setCycleNum(Long.valueOf(0));                       //轮换个数 ：0
		}
		
		newBean.setIsSpell(newBean.getIsSpell());
		brandCategoryInfoDAO.saveBrandCategoryInfo(newBean);

		// 记录轮转日志
		long busiId = BusiInfoUtil.recordBusiInfo(BusiInfoEngine.getNewId().longValue() + "",
				CoreConstant.SYS_PARA_BUSI_TYPE_WARE_SHOW_TYPE_BRAND_RECYLE_MOFIFY, -1, "", CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY_KIND,
				"品牌推荐ID：" + newBean.getCategoryId() + ";品牌推荐名称：" + newBean.getBrandShowName(), staffId, comType, orgId);
		
		BusiInfoUtil.recordBusiDetail(busiId + "", new Object[] { oldBean }, new Object[] { newBean }, "CategoryId");
	}
	public void setBrandCategoryInfoDAO(IBrandCategoryInfoDAO brandCategoryInfoDAO) throws Exception {
		this.brandCategoryInfoDAO = brandCategoryInfoDAO;
	}

	public IBrandCategoryInfoValue getBrandCategoryValueById(long id) throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		IBrandCategoryInfoValue[] value  = null;
		if(0!=id){
			condition.append(" and ").append(IBrandCategoryInfoValue.S_BrandShowId).append("=:").append(IBrandCategoryInfoValue.S_BrandShowId);
			parameter.put(IBrandCategoryInfoValue.S_BrandShowId, String.valueOf(id));
			value = brandCategoryInfoDAO.getBrandCategoryInfo(condition.toString(), parameter);
		}
		return value==null?null:value[0];
	}

}
