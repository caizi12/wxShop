package ngves.asiainfo.core.floor.service.interfaces;

import java.util.Map;

import ngves.asiainfo.core.floor.dao.interfaces.INavbarKindInfoDAO;
import ngves.asiainfo.core.floor.ivalues.INavbarKindInfoValue;

/**
 * 门户导航二三级栏目管理
 */
public interface INavbarKindInfoSrv {
	
	public void setNavbarKindInfoDAO(INavbarKindInfoDAO navbarKindInfoDAO) ;

	public INavbarKindInfoValue[] queryNavbarKindInfoList(Map<String, Object> param) throws Exception;
	/**
	 * 批量保存
	 * @throws Exception
	 */
	public void saveNavbarKindInfos(INavbarKindInfoValue[] values,INavbarKindInfoValue[] oldvalues,INavbarKindInfoValue[] newvalues,String type,long staffId,String comType,long orgId) throws Exception;
	/**
	 * 保存
	 * @throws Exception
	 */
	public void saveNavbarKindInfo(INavbarKindInfoValue value,INavbarKindInfoValue oldvalue,String type,long staffId,String comType,long orgId) throws Exception;
	/**
	 * 获取单页数据
	 * @throws Exception
	 */
	public INavbarKindInfoValue[] queryNavbarKindInfoListForPage(String kindName,int $STARTROWINDEX, int $ENDROWINDEX) throws Exception;
	/**
	 * 获取个数
	 * @throws Exception
	 */
	public int queryNavbarKindInfoCount(String kindName) throws Exception;
	/**
	 * 获取序列
	 * @throws Exception
	 */
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
	public INavbarKindInfoValue getNavbarKindInfoValueBynavbarKindId(long navbardkind) throws Exception ;
	
	/**
	 * 根据parent_navbar查询信息
	 * @throws Exception
	 */
	public INavbarKindInfoValue[] getNavbarKindInfoValueByparentNavbar(long parentNavbar) throws Exception ;
	
	/**
	 * 获取一级类目信息FORAPP
	 * @throws Exception
	 */
	public INavbarKindInfoValue[] getOneNavbarKindInfoForApp() throws Exception ;
	
	/**
	 * 根据parent_navbar查询信息
	 * @throws Exception
	 */
	public INavbarKindInfoValue[] getValueByparentNavbarForApp(long parentNavbar) throws Exception ;
	
	/**
	 * 获取一级类目信息FORWEB
	 * @throws Exception
	 */
	public INavbarKindInfoValue[] getOneNavbarKindInfoForWeb(boolean bIshome) throws Exception ;
	
	/**
	 * 根据parent_navbar查询信息FORWeb
	 * @throws Exception
	 */
	public INavbarKindInfoValue[] getValueByparentNavbarForWeb(long parentNavbar,boolean bIshome) throws Exception ;
	
	
}
