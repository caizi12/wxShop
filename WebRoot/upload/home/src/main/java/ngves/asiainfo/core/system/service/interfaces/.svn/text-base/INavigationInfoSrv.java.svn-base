package ngves.asiainfo.core.system.service.interfaces;

import java.util.Map;

import ngves.asiainfo.core.system.dao.interfaces.INavigationInfoDAO;
import ngves.asiainfo.core.system.ivalues.INavigationInfoValue;

/**
 * 导航标签service接口
 * @author shenfl
 *
 */
public interface INavigationInfoSrv {

    public void setNavigationInfoDAO(INavigationInfoDAO navigationInfoDAO);
    
    /**
     * 增加导航页签
     * @param navigationInfo 导航页签
     * @return               导航记录数
     * @throws Exception
     */
    public void saveNavigationInfo(INavigationInfoValue navigationInfo ) throws Exception;
    
    /**
     * 删除单个导航页签
     * @param navigationInfo
     * @throws Exception
     */
    public void deleteNavigationInfo(INavigationInfoValue navigationInfo) throws Exception;
    
    /**
     * 删除多个导航页签一
     * @param navigationInfo
     * @throws Exception
     */
    public void deleteNavigationInfos(INavigationInfoValue[] navigationInfo) throws Exception;
    
    /**
     * 删除多个导航页签二
     * @param navigationInfo
     * @throws Exception
     */
    public void deleteNavigationInfos(String[] navIdes) throws Exception;
    
    
    
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
    public INavigationInfoValue[] queryNavigationInfoValues(String condition, Map param) throws Exception;
    
    /**
     * 导航标签分页查询
     * @param navigationDesc   导航描述
     * @param param            参数
     * @return                 导航标签记录
     * @param startIndex
     * @param endIndex
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public INavigationInfoValue[] queryNavigationInfoValues(String navigationDesc, Map param, int startIndex, int endIndex) throws Exception;
    
    /**
     * 导航标签标识获取导航标签
     * @param navigationInfoId 导航标识
     * @return                 导航页签对象
     * @throws Exception
     */
    public INavigationInfoValue queryNavigationInfoValueById(Long navigationInfoId) throws Exception;
    /**
     * 查询导航查询
     * @param navDesc
     * @param startIndex
     * @param endIndex
     * @return
     * @throws Exception
     */
    public INavigationInfoValue[] findAllNavInfosByNavDesc(String navDesc,int startIndex,int endIndex) throws Exception;
    
    /**
     * 根据条件查询记录数(模糊查询)
     * @param navDesc
     * @return
     * @throws Exception
     */
    public int countByNavDesc(String navDesc) throws Exception ;
    /**
     * 根据条件查询记录数(精确查询)
     * @param navDesc
     * @return
     * @throws Exception
     */
    public int countByNavDescEqual(String navDesc) throws Exception ;
}
