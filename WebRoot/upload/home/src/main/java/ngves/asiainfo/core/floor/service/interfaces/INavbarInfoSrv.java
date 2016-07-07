package ngves.asiainfo.core.floor.service.interfaces;

import java.util.Map;

import ngves.asiainfo.core.floor.dao.interfaces.INavbarInfoDAO;
import ngves.asiainfo.core.floor.ivalues.INavbarInfoValue;

/**
 * 门户导航栏目管理
 */
public interface INavbarInfoSrv {
	public void setNavbarInfoDAO(INavbarInfoDAO navbarInfoDAO) ;

	public INavbarInfoValue[] queryNavbarInfoList(Map<String, Object> param) throws Exception;
	/**
	 * 批量保存
	 * @throws Exception
	 */
	public void saveNavbarInfos(INavbarInfoValue[] values,INavbarInfoValue[] oldvalue,String type,long staffId,String comType,long orgId) throws Exception;
	/**
	 * 保存
	 * @throws Exception
	 */
	public void saveNavbarInfo(INavbarInfoValue value,INavbarInfoValue oldvalue,String type,long staffId,String comType,long orgId) throws Exception;
	/**
	 * 获取数据，并拼上一二三级类目信息
	 * @throws Exception
	 */
	public INavbarInfoValue[] queryNavbarInfoListForPage(String navbarName,int $STARTROWINDEX, int $ENDROWINDEX) throws Exception;
	/**
	 * 获取个数
	 * @throws Exception
	 */
	public int queryNavbarInfoCount(String navbarName) throws Exception;
	/**
	 * 获取序列
	 * @throws Exception
	 */
	public long getNewId() throws Exception;
	/**
	 * 根据navbar_id查询信息
	 * @throws Exception
	 */
	public INavbarInfoValue getNavbarInfoValueBynavbarId(long navbard) throws Exception;

}
