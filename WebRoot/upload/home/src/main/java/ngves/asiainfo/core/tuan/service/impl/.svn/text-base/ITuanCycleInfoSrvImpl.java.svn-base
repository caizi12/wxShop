package ngves.asiainfo.core.tuan.service.impl;

import ngves.asiainfo.core.common.bo.BusiInfoEngine;
import ngves.asiainfo.core.tuan.bo.TuanCycleInfoEngine;
import ngves.asiainfo.core.tuan.dao.interfaces.ITuanCycleInfoDAO;
import ngves.asiainfo.core.tuan.ivalues.ITuanCycleInfoValue;
import ngves.asiainfo.core.tuan.service.interfaces.ITuanCycleInfoSrv;
import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.common.util.BusiInfoUtil;

/**
 * 团购轮转服务实现类
 * @author LIJINZHE
 *
 */
public class ITuanCycleInfoSrvImpl implements ITuanCycleInfoSrv {

	// 注入dao
	private ITuanCycleInfoDAO tuanCycleInfoDAO;

	public void setTuanCycleInfoDAO(ITuanCycleInfoDAO tuanCycleInfoDAO) throws Exception {
		this.tuanCycleInfoDAO = tuanCycleInfoDAO;
	}

	public ITuanCycleInfoValue getTuanCycleInfo(String showType, String groupCode) throws Exception {
    	return tuanCycleInfoDAO.getTuanCycleInfo(showType, groupCode);
    }
    
    public void updateTuanCycleInfo(ITuanCycleInfoValue value, long staffId, String comType, long orgId) throws Exception {
    	ITuanCycleInfoValue oldBean = TuanCycleInfoEngine.getBean(value.getSpellCycleId());
		ITuanCycleInfoValue newBean = value;
		
		long busiInfoId = BusiInfoEngine.getNewId().longValue();
        BusiInfoUtil.recordBusiInfo(
        		busiInfoId + "", 
        		CoreConstant.SYS_PARA_BUSI_TYPE_TUANCYCLE_MODIFY, 
        		-1, 
        		"修改团购轮转信息", 
        		CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,
        		"团购轮转ID： "+oldBean.getSpellCycleId()+"； 展示类型： "+oldBean.getShowType()+"； 活动分组: "+oldBean.getGroupCode(), staffId, comType, orgId);
		BusiInfoUtil.recordBusiDetail(busiInfoId + "", new Object[]{oldBean}, new Object[]{newBean}, "spellCycleId");
    	tuanCycleInfoDAO.updateTuanCycleInfo(value);
    }
}
