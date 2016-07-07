package ngves.asiainfo.core.floor.dao.interfaces;

import ngves.asiainfo.core.floor.ivalues.ITabsAreaInfoValue;

/**
 * 楼层页签区域信息维护接口
 * @author lzq
 *
 */
public interface ITabsAreaInfoDAO {
	/**
	 * 保存楼层页签区域信息
	 * @param tabsAreaInfoValue
	 * @return
	 * @throws Exception
	 */
	public void saveTabsAreaInfo(ITabsAreaInfoValue tabsAreaInfoValue) throws Exception;
    
	/**
	 * 批量保存页签区域
	 * @param tabsAreaInfoValue
	 * @throws Exception
	 */
	public void savTabsAreaInfos(ITabsAreaInfoValue[] tabsAreaInfoValues) throws Exception;
	
	
	 /** 
	 * 根据页签区域id串查询页签区域信息
	 */
	public ITabsAreaInfoValue[] queryTabsAreaInfoByIds(String tabsAreaIds) throws Exception;
	/**
	 * 根据id查询楼层页签区域信息
	 * @param tabsAreaId
	 * @return
	 * @throws Exception
	 */
	public ITabsAreaInfoValue queryTabsAreaInfoById(long tabsAreaId) throws Exception;
   
	 /** 
	 * 根据页签id查询页签区域信息
	 */
	public ITabsAreaInfoValue[] queryTabsAreaInfoByTabsId(long tabsId) throws Exception;
	/***
	 * 获取新标识
	 * @return
	 * @throws Exception
	 */
	public long getNewId() throws Exception;
}
