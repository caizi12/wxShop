package ngves.asiainfo.core.floor.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.floor.ivalues.INavbarKindInfoValue;
/**
 *门户导航二三级栏目
 *
 */
public interface INavbarKindInfoDAO {
	public INavbarKindInfoValue[] queryNavbarKindInfoListForPage(Map<String, Object> param,int startNum,int endNum) throws Exception;
	public INavbarKindInfoValue[] queryNavbarKindInfoList(Map<String, Object> param) throws Exception;
	public void saveNavbarKindInfos(INavbarKindInfoValue[] values) throws Exception;
	public void saveNavbarKindInfo(INavbarKindInfoValue value) throws Exception;
	public int queryNavbarKindInfoCount(Map<String, Object> param) throws Exception;
	public long getNewId() throws Exception;

	/**
	 * 根据navbar_id查询信息
	 * @throws Exception
	 */
	public INavbarKindInfoValue[] getNavbarKindInfoValueBynavbarId(long navbard) throws Exception;
	/**
	 * 根据navbar_kind_id查询信息
	 * @throws Exception
	 */
	public INavbarKindInfoValue getNavbarKindInfoValueBynavbarKindId(long navbardkind) throws Exception;
	/**
	 * 根据parent_navbar查询信息
	 * @throws Exception
	 */
	public INavbarKindInfoValue[] getNavbarKindInfoValueByparentNavbar(long parentnavbar) throws Exception;
	/**
	 * 获取一级类目信息FORAPP
	 * @throws Exception
	 */
	public INavbarKindInfoValue[] getOneNavbarKindInfoForApp() throws Exception ;

	/**
	 * 根据parent_navbar查询信息FORAPP
	 * @throws Exception
	 */
	public INavbarKindInfoValue[] getValueByparentNavbarForApp(long parentnavbar) throws Exception;
	/**
	 * 获取一级类目信息FORWEB
	 * @throws Exception
	 */
	public INavbarKindInfoValue[] getOneNavbarKindInfoForWeb(boolean bIshome) throws Exception ;
	/**
	 * 根据parent_navbar查询信息
	 * @throws Exception
	 */
	public INavbarKindInfoValue[] getValueByparentNavbarForWeb(long parentnavbar,boolean bIshome) throws Exception;

}
