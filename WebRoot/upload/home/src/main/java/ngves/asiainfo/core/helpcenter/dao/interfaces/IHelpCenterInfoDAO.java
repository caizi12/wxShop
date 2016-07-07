package ngves.asiainfo.core.helpcenter.dao.interfaces;

import java.util.List;
import ngves.asiainfo.core.helpcenter.ivalues.IHelpCenterinfoValue;
/**
 * 帮助管理中心信息管理
 * @author xj
 *
 */
public interface IHelpCenterInfoDAO {
	/**
	 * 获取菜单列表
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IHelpCenterinfoValue[] queryHelpCenterInfo(int startIndex, int endIndex) throws Exception;

	/**
	 * 查询所有总的记录条数
	 * 
	 * 
	 * @return 
	 * @throws Exception
	 */
	public int queryHelpCenterInfoCount() throws Exception;

	/**
	 * 查询父菜单下面的所有子菜单
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<IHelpCenterinfoValue> queryHelpCenterinfoByParentId(Long parentId) throws Exception;
	/**
	 * 更新对象信息
	 * 
	 * @param helpCenterinfoValue
	 * @throws Exception
	 */
	public String  updateHelpCenterInfo(IHelpCenterinfoValue helpCenterinfoValue) throws Exception;

	/**
	 * 保存帮助中心信息对象
	 * 
	 * @param helpCenterinfoValue
	 * @throws Exception
	 */
	public String saveHelpCenterinfo(IHelpCenterinfoValue helpCenterinfoValue) throws Exception;

	/**
	 * 获取所有帮助中心信息对象
	 * 
	 * @return
	 * @throws Exception
	 */
	public IHelpCenterinfoValue[] getAllHelpCenterinfoValues() throws Exception;

	/**
	 * 通过id获取帮助中心信息对象的基本信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public IHelpCenterinfoValue queryHelpCenterinfoById(long id) throws Exception;
	
	
	/**
	 * 删除帮助中心信息对象
	 * 
	 * @param helpCenterinfoValue
	 * @throws Exception
	 */
	public String deleteHelpCenterinfo(Long helpCenterId) throws Exception;

	/**
	 * 按顺序查出在门户展示的父菜单，子菜单帮助信息
	 * para isShow 为true时只查询门户展示的信息，false时查询所有信息
	 * @return
	 * @throws Exception
	 */
	public List<IHelpCenterinfoValue> queryHelpCenterinfoForPortal(boolean isShow) throws Exception;
}
