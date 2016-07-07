package ngves.asiainfo.core.system.service.interfaces;

import java.util.Map;

import ngves.asiainfo.core.system.dao.interfaces.IMetaInfoDAO;
import ngves.asiainfo.core.system.ivalues.IMetaInfoValue;

/**
 * 首页META信息业务逻辑接口
 * @author shenfl
 *
 */
public interface IMetaInfoSrv {

    public void setMetaInfoDAO(IMetaInfoDAO metaInfoDAO);
    
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
     * 根据条件查询首页META信息 
     * @param metaDesc       首页META描述
     * @param startIndex
     * @param endIndx
     * @return
     * @throws Exception
     */
    public IMetaInfoValue[] queryMetaInfoByMetaDesc(String metaDesc,int startIndex,int endIndx) throws Exception;
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
    /**
     * 获取首页META信息记录数 
     * @param metaDesc      META描述
     * @return
     * @throws Exception
     */
    public int countBymetaDesc(String metaDesc) throws Exception ;
}
