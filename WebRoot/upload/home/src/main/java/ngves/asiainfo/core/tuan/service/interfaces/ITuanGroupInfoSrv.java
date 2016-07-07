package ngves.asiainfo.core.tuan.service.interfaces;

import java.util.Map;

import ngves.asiainfo.core.tuan.dao.interfaces.ITuanGroupInfoDAO;
import ngves.asiainfo.core.tuan.ivalues.ITuanGroupInfoValue;

public interface ITuanGroupInfoSrv {

	public void setTuanGroupInfoDAO(ITuanGroupInfoDAO tuanGroupInfoDAO);

	/**
	 * 根据团购分组ID查找对象
	 * @param tuanGroupId
	 * @return
	 * @throws Exception
	 */
	public ITuanGroupInfoValue findById(Long tuanGroupId) throws Exception;

	/**
	 * 新增一个分组对象
	 * @param tuanGroupValue
	 * @return
	 * @throws Exception
	 */
    public long addTuanGroup(ITuanGroupInfoValue tuanGroupValue) throws Exception;

    /**
     * 修改一个对象
     * @param tuanGroupValue
     * @return
     * @throws Exception
     */
    public long updateTuanGroup(ITuanGroupInfoValue tuanGroupValue) throws Exception;

    /**
     * 删除一个对象
     * @param tuanGroupId
     * @return
     * @throws Exception
     */
    public boolean removeTuanGruop(long tuanGroupId) throws Exception;

    /**
     * 查询团购分组所有对象
     * @param condition
     * @param params
     * @param startIndex
     * @param endIndex
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public ITuanGroupInfoValue[] queryTuanGroupInfo(String condition, Map params, int startIndex, int endIndex) throws Exception;

	/**
	 * 查找团购分组对象（带条件，还分页）
	 * @param groupType
	 * @param groupName
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
    public ITuanGroupInfoValue[] findAllByTitle(String groupType,String groupName, int startIndex, int endIndex) throws Exception;

	/**
	 * 查找团购分组对象总条数
	 * @param groupType
	 * @param groupName
	 * @return
	 * @throws Exception
	 */
    public int countByTitle(String groupType,String groupName) throws Exception;

    /**
     * 获取所有对象
     * @return
     * @throws Exception
     */
    public ITuanGroupInfoValue[] findAlltuanGroup() throws Exception;
    
    /**
     * 根据团购分组Code 分组类别 查询分组对象
     * @return
     * @throws Exception
     */
    public ITuanGroupInfoValue findTuanGroup(String groupCode,String groupType) throws Exception;
    
    /**
     * 根据团购分组类别 查询分组对象
     * @return
     * @throws Exception
     */
    public ITuanGroupInfoValue[] findTuanGroupType(String groupType) throws Exception;

}
