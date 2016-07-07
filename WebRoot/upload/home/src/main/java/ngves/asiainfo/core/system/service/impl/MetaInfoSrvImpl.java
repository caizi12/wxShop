package ngves.asiainfo.core.system.service.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.system.SystemSrvConstant;
import ngves.asiainfo.core.system.bo.MetaInfoEngine;
import ngves.asiainfo.core.system.dao.interfaces.IMetaInfoDAO;
import ngves.asiainfo.core.system.ivalues.IMetaInfoValue;
import ngves.asiainfo.core.system.service.interfaces.IMetaInfoSrv;
import ngves.asiainfo.util.StringUtil;

/**
 * 首页META信息业务逻辑实现
 * @author shenfl
 *
 */
public class MetaInfoSrvImpl implements IMetaInfoSrv {

    public static final String META_INFO_MODIFIY = "修改";
    
    private IMetaInfoDAO metaInfoDAO;
    
    public void setMetaInfoDAO(IMetaInfoDAO metaInfoDAO) {
        this.metaInfoDAO = metaInfoDAO;
    }

    public IMetaInfoValue queryMetaInfoById(Long metaId) throws Exception {
        return this.metaInfoDAO.queryMetaInfoById(metaId);
    }

    @SuppressWarnings("unchecked")
    public IMetaInfoValue[] queryMetaInfos(String metaDesc, Map param) throws Exception {
        return this.metaInfoDAO.queryMetaInfos(metaDesc, param);
    }
    /**
     * 根据META描述查询
     */
    public IMetaInfoValue[] queryMetaInfoByMetaDesc(String metaDesc,int startIndex,int endIndx) throws Exception{
        
        StringBuffer sql = new StringBuffer();
        Map<String, String> params = new HashMap<String, String>();
        if (!StringUtil.isBlank(metaDesc)) {
            metaDesc = metaDesc.trim();
            sql.append(IMetaInfoValue.S_MetaDesc).append(" LIKE :").append(IMetaInfoValue.S_MetaDesc).append(" ");
            params.put(IMetaInfoValue.S_MetaDesc, "%" + metaDesc + "%");
        }
        //取得所有META记录
        IMetaInfoValue[] metaInfos = this.queryMetaInfos(sql.toString(), params, startIndex, endIndx);
        //活动操作设置
        StringBuffer sb = null;
        for (IMetaInfoValue metaInfo : metaInfos) {
            sb = new StringBuffer();
            sb.append(String.format(SystemSrvConstant.MODIFY_META_INFO_LINK, metaInfo.getMetaId()));
            metaInfo.setBakCol(sb.toString());
            sb = null;
        }
        return metaInfos;
    }
    
    /**
     * 取得首页META记录数
     * @param nagDesc
     * @return
     */
    public int countBymetaDesc(String metaDesc) throws Exception {
        
        StringBuffer sql = new StringBuffer();
        Map<String, String> params = new HashMap<String, String>();
        if (!StringUtil.isBlank(metaDesc)) {
            metaDesc = metaDesc.trim();
            sql.append(IMetaInfoValue.S_MetaDesc).append(" = :").append(IMetaInfoValue.S_MetaDesc).append(
                    " ");
            params.put(IMetaInfoValue.S_MetaDesc, "%" + metaDesc + "%");
        }
        return MetaInfoEngine.getBeansCount(sql.toString(), params);
    }
    /**
     * 分页查询-支持模糊查询
     */
    @SuppressWarnings("unchecked")
    public IMetaInfoValue[] queryMetaInfos(String metaDesc, Map param, int startIndex, int endIndex) throws Exception {
        return this.metaInfoDAO.queryMetaInfos(metaDesc, param, startIndex, endIndex);
    }
    
    /**
     * 更新首页META
     */
    public void updateMetaInfo(IMetaInfoValue metaInfo) throws Exception {
        this.metaInfoDAO.updateMetaInfo(metaInfo);
    }
}
