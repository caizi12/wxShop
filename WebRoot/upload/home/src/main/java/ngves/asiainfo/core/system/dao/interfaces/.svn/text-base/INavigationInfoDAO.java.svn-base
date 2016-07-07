package ngves.asiainfo.core.system.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.system.ivalues.INavigationInfoValue;

/**
 * 导航页签接口
 * @author shenfl
 *
 */
public interface INavigationInfoDAO {


    /**
     * 增加导航页签
     * @param navigationInfo 导航页签
     * @return               导航记录数
     * @throws Exception
     */
    public void saveNavigationInfo(INavigationInfoValue navigationInfo ) throws Exception;
    
    /**
     * 删除导航页签
     * @param navigationInfo
     * @throws Exception
     */
    public void deleteNavigationInfo(INavigationInfoValue navigationInfo) throws Exception;
    
    /**
     * 修改导航页签
     * @param navigationInfo
     * @throws Exception
     */
    public void updateNavigationInfo(INavigationInfoValue navigationInfo) throws Exception;
    
    /**
     * 根据条件查询导航标签
     * @param condition 条件
     * @param param     参数
     * @return          导航标签记录
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public INavigationInfoValue[] queryNavigationInfoValues(String navigationInfoName, Map param) throws Exception;
    
    /**
     * 导航标签分页查询
     * @param condition 条件
     * @param param     参数
     * @return          导航标签记录
     * @param startIndex
     * @param endIndex
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public INavigationInfoValue[] queryNavigationInfoValues(String condition, Map param, int startIndex, int endIndex) throws Exception;
    
    /**
     * 导航标签标识获取导航标签
     * @param navigationInfoId 导航标识
     * @return                 导航页签对象
     * @throws Exception
     */
    public INavigationInfoValue queryNavigationInfoValueById(Long navigationInfoId) throws Exception;
}
