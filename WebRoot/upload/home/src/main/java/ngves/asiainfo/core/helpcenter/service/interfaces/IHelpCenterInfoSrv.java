package ngves.asiainfo.core.helpcenter.service.interfaces;

import java.util.List;

import ngves.asiainfo.core.helpcenter.dao.interfaces.IHelpCenterInfoDAO;
import ngves.asiainfo.core.helpcenter.ivalues.IHelpCenterinfoValue;

/**
 * 帮助中心管理
 * 
 * @author xj
 */
public interface IHelpCenterInfoSrv {

	public void setHelpCenterInfoDAO(IHelpCenterInfoDAO helpCenterInfoDAO)
			throws Exception;

	/**
	 * @param $STARTROWINDEX
	 * @param $ENDROWINDEX
	 * @return 帮助中心管理的信息列表
	 * @throws Exception
	 */
	public IHelpCenterinfoValue[] queryObjectInfo(int startIndex, int endIndex)
			throws Exception;

	/**
	 * 
	 * @return 帮助中心管理的信息总数
	 * @throws Exception
	 */
	public int queryHelpCenterinfoCount() throws Exception;

	/**
	 * 保存帮助中心管理对象
	 * 
	 * @param donatedObjectsValue
	 * @throws Exception
	 */
	public String saveHelpCenterinfo(IHelpCenterinfoValue helpCenterinfoValue,long StaffId,String ComType,long OrgId)
			throws Exception;

	/**
	 * 获取所有帮助中心管理对象
	 * 
	 * @return
	 * @throws Exception
	 */
	public IHelpCenterinfoValue[] getAllIDonatedObjectsValue() throws Exception;

	/**
	 * 通过id获取帮助中心管理对象信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public IHelpCenterinfoValue queryHelpCenterinfoById(String helpId)throws Exception;	
	/**
     * 保存帮助中心子菜单的页面信息
     * @param donatedObjectsValue
     * @throws Exception
     */
    public boolean saveHelpCenterinfoDesc(String objId, String tableName, String desc) throws Exception;
    
    /**
	 * 通过对象id获取页面信息
	 * @param objId
	 * @return
	 * @throws Exception
	 */
	public String getHelpCenterinfoDesc(long objId) throws Exception;
	/**
	 * 修改帮助中心对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String updateHelpCenterinfoDesc(IHelpCenterinfoValue helpCenterinfoValue,long StaffId,String ComType,long OrgId)throws Exception;
	/**
	 * 删除帮助中心对象
	 * @param helpCenterId
	 * @return
	 * @throws Exception
	 */
	public String deleteHelpCenterinfo(Long helpCenterId,String hasChild,long StaffId,String ComType,long OrgId) throws Exception;

	/**
	 * 按顺序查出在门户展示的父菜单，子菜单帮助信息
	 * @return
	 * @throws Exception
	 */
	public List<IHelpCenterinfoValue> queryHelpCenterinfoForPortal() throws Exception;
	
	/**
	 * 查询父菜单下面的所有子菜单
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<IHelpCenterinfoValue> queryHelpCenterinfoByParentId(Long parentId) throws Exception;
	
	/**
	 * 按顺序查出在管理平台展示的父菜单，子菜单帮助信息
	 * @return
	 * @throws Exception
	 */
	public List<IHelpCenterinfoValue> queryHelpCenterinfoForMgt() throws Exception;
	
	
	
}
