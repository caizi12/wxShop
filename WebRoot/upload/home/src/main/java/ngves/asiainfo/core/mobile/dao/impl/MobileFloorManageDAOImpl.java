package ngves.asiainfo.core.mobile.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.mobile.bo.MobileFloorInfoEngine;
import ngves.asiainfo.core.mobile.bo.MobileFloorRltEngine;
import ngves.asiainfo.core.mobile.dao.interfaces.IMobileFloorManageDAO;
import ngves.asiainfo.core.mobile.ivalues.IMobileFloorInfoValue;
import ngves.asiainfo.core.mobile.ivalues.IMobileFloorRltValue;
import ngves.asiainfo.core.smsformwork.util.SmsFormworkUtils;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 触屏版首页楼层推荐管理DAO层实现
 * @author yeqh
 * 2014-12-28
 */
public class MobileFloorManageDAOImpl implements IMobileFloorManageDAO {
	private static Log logger = LogFactory.getLog(MobileFloorManageDAOImpl.class);

	/**
	 * 根据楼层名称查询楼层信息
	 * 如果为空查询所有未被删除的楼层信息
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public IMobileFloorInfoValue[] getMobileFloorInfo(String floorName, int startIndex, int endIndex) throws Exception {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		
		if(!StringUtil.isBlank(floorName)){
			//汉字的模糊查询一定要注意下划线转义的问题
			floorName = SmsFormworkUtils.delUnderline(floorName);
			condition.append(" AND ").append(IMobileFloorInfoValue.S_FloorName).append(" LIKE :").append(IMobileFloorInfoValue.S_FloorName);
			parameter.put(IMobileFloorInfoValue.S_FloorName, "%" + floorName + "%");
			condition.append("  ESCAPE '\\' ");
		}
		condition.append(" AND IS_DELETED <> '1' ");
		condition.append(" ORDER BY FLOOR_ID DESC ");
		
		return MobileFloorInfoEngine.getBeans(null, condition.toString(), parameter, startIndex, endIndex, false);
	}

	/**
	 * 根据楼层名称查询楼层信息
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public IMobileFloorInfoValue[] getMobileFloorInfoByFloorName(String floorName) throws Exception {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		
		if(!StringUtil.isBlank(floorName)){
			//汉字的模糊查询一定要注意下划线转义的问题
			floorName = SmsFormworkUtils.delUnderline(floorName);
			condition.append(" AND ").append(IMobileFloorInfoValue.S_FloorName).append(" = :").append(IMobileFloorInfoValue.S_FloorName);
			parameter.put(IMobileFloorInfoValue.S_FloorName, floorName);
		}
		condition.append(" AND IS_DELETED <> '1' ");
		
		return MobileFloorInfoEngine.getBeans(condition.toString(), parameter);
	}
	
	/**
	 * 通过floorId查询楼层信息
	 * @throws Exception
	 */
	public IMobileFloorInfoValue getMobileFloorInfoByFloorId(String floorId) throws Exception {
		return MobileFloorInfoEngine.getBean(Long.parseLong(floorId));
	}

	/**
	 * 根据楼层名称查询楼层信息数量
	 * 如果为空查询所有未被删除的楼层信息数量
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public int getMobileFloorInfoCount(String floorName) throws Exception {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		
		if(!StringUtil.isBlank(floorName)){
			//汉字的模糊查询一定要注意下划线转义的问题
			floorName = SmsFormworkUtils.delUnderline(floorName);
			condition.append(" AND ").append(IMobileFloorInfoValue.S_FloorName).append(" LIKE :").append(IMobileFloorInfoValue.S_FloorName);
			parameter.put(IMobileFloorInfoValue.S_FloorName, "%" + floorName + "%");
			condition.append("  ESCAPE '\\' ");
		}
		condition.append(" AND IS_DELETED <> '1' ");
		
		return MobileFloorInfoEngine.getBeansCount(condition.toString(), parameter) ;
	}

	/**
	 * 保存楼层信息
	 * @throws Exception
	 */
	public void saveMobileFloorInfo(IMobileFloorInfoValue value) throws Exception {
		long id = value.getFloorId();
		if(id == 0){
			value.setFloorId(MobileFloorInfoEngine.getNewId().longValue());
		}
		MobileFloorInfoEngine.save(value);
	}
	
	
	/**
	 * 批量保存楼层关系信息s
	 * @param floorRltValue
	 * @throws Exception
	 */
	public void saveBatchMobileFloorRlt(IMobileFloorRltValue[] floorRltValues) throws Exception{
		for(IMobileFloorRltValue floorRltValue: floorRltValues){
			long id = floorRltValue.getFloorRltId();
			if(id == 0){
				floorRltValue.setFloorRltId(MobileFloorRltEngine.getNewId().longValue());
			}
		}
		MobileFloorRltEngine.saveBatch(floorRltValues);
	}


	/**
	 * 通过楼层id获得绑定的楼层关系信息
	 * @param floorId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public IMobileFloorRltValue[] getFloorRltByFloorId(String floorId) throws Exception {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		
		if(!StringUtil.isBlank(floorId)){
			condition.append(" AND ").append(IMobileFloorRltValue.S_FloorId).append("=:").append(IMobileFloorRltValue.S_FloorId);
			parameter.put(IMobileFloorRltValue.S_FloorId, floorId);
		}
		condition.append(" AND IS_DELETE <> '1'  ORDER BY INDEX_ID ASC ");
		
		return MobileFloorRltEngine.getBeans(condition.toString(), parameter);
	}
	
	/**
	 * 通过floorRltId获得绑定的楼层关系信息
	 * @param floorId
	 * @return
	 * @throws Exception
	 */
	public IMobileFloorRltValue getFloorRltInfoByFloorId(String floorRltId) throws Exception {
		return MobileFloorRltEngine.getBean(Long.parseLong(floorRltId));
	}


	/**
	 * 获取首页展示的楼层基本信息
	 * @param showChannel 支持展示渠道
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public IMobileFloorInfoValue[] getFloorInfoByShowChannel(String showChannel) throws Exception {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		//首页展示
		condition.append(" AND IS_SHOW = '1' ");
		//不删除
		condition.append(" AND IS_DELETED <> '1' ");
		
		//查询显示渠道是否包含指定渠道
		if(!StringUtil.isBlank(showChannel)){
			condition.append(" AND INSTR( ").append(IMobileFloorInfoValue.S_ShowChannel).append(" , ").append(showChannel).append(" )>0 ");
		}
		
		condition.append(" ORDER BY  ").append(IMobileFloorInfoValue.S_SortId);
		return MobileFloorInfoEngine.getBeans(condition.toString(), parameter);
	}
	
	
	/**
	 * 预览首页展示需要展示的楼层信息
	 * @param floorId 预览附加的楼层
	 * @return
	 * @throws Exception
	 */
	public IMobileFloorInfoValue[] getPreviewFloorInfo(String floorId)throws Exception {
		
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		condition.append(" AND is_show = 1 AND is_deleted = 0  OR  floor_id = ").append(floorId);
		condition.append(" ORDER BY sort_id ASC ");
		if(logger.isDebugEnabled())
			logger.debug("current sql for getPreviewFloorInfo is "+condition.toString());
		
		return MobileFloorInfoEngine.getBeans(condition.toString(), null);
	}

}
