package ngves.asiainfo.core.floor.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.floor.ivalues.INavbarInfoValue;
/**
 *门户导航栏目
 *
 */
public interface INavbarInfoDAO {
	public INavbarInfoValue[] queryNavbarInfoListForPage(Map<String, Object> param,int startNum,int endNum) throws Exception;
	public INavbarInfoValue[] queryNavbarInfoList(Map<String, Object> param) throws Exception;
	public void saveNavbarInfos(INavbarInfoValue[] values) throws Exception;
	public void saveNavbarInfo(INavbarInfoValue value) throws Exception;
	public int queryNavbarInfoCount(Map<String, Object> param) throws Exception;
	public long getNewId() throws Exception;
	/**
	 * 根据navbar_id查询信息
	 * @throws Exception
	 */
	public INavbarInfoValue getNavbarInfoValueBynavbarId(long navbard) throws Exception ;
}
