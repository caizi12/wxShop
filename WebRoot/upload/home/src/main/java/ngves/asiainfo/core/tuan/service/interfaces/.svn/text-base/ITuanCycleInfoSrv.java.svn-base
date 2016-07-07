package ngves.asiainfo.core.tuan.service.interfaces;

import ngves.asiainfo.core.tuan.dao.interfaces.ITuanCycleInfoDAO;
import ngves.asiainfo.core.tuan.ivalues.ITuanCycleInfoValue;

/**
 * 团购轮转服务接口
 * @author LIJINZHE
 *
 */
public interface ITuanCycleInfoSrv {

	/**
	 * 注入到的方法
	 * @param tuanCycleInfoDAO
	 * @throws Exception
	 */
	public void setTuanCycleInfoDAO(ITuanCycleInfoDAO tuanCycleInfoDAO) throws Exception;
	
	/**
	 * 根据参数查询团购轮转信息
	 * @param showType
	 * @param groupCode
	 * @return 团购轮转bean
	 */
	public ITuanCycleInfoValue getTuanCycleInfo(String showType, String groupCode) throws Exception;

	/**
	 * 根据参数更新团购轮转信息
	 * @param showType
	 * @param groupCode
	 */
	public void updateTuanCycleInfo(ITuanCycleInfoValue value, long staffId, String comType, long orgId) throws Exception;
}
