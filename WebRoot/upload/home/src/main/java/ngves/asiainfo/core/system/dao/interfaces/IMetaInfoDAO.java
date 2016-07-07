package ngves.asiainfo.core.system.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.system.ivalues.IMetaInfoValue;

/**
 * 首页META信息管理接口
 * @author shenfl
 *
 */
public interface IMetaInfoDAO {

    /**
     * 修改首页META信息
     * @param metaInfo
     * @throws Exception
     */
    public void updateMetaInfo(IMetaInfoValue metaInfo) throws Exception;
    
    /**
     * 根据条件查询首页META信息
     * @param condition      首页META描述
     * @param param
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public IMetaInfoValue[] queryMetaInfos(String metaDesc ,Map param) throws Exception;
    
    /**
     * 首页META信息的分页查询
     * @param metaDesc
     * @param param
     * @param startIndex
     * @param endIndex
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public IMetaInfoValue[] queryMetaInfos(String metaDesc,Map param,int startIndex,int endIndex) throws Exception;
    
    /**
     * 获取首页META信息对象
     * @param metaId
     * @return
     * @throws Exception
     */
    public IMetaInfoValue queryMetaInfoById(Long metaId) throws Exception;
    
}
