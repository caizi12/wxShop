package ngves.asiainfo.core.system.dao.impl;

import java.util.Map;

import ngves.asiainfo.core.system.bo.MetaInfoEngine;
import ngves.asiainfo.core.system.dao.interfaces.IMetaInfoDAO;
import ngves.asiainfo.core.system.ivalues.IMetaInfoValue;

/**
 * 首页META信息数据处理
 * @author shenfl
 *
 */
public class MetaInfoDAOImpl implements IMetaInfoDAO {

    public IMetaInfoValue queryMetaInfoById(Long metaId) throws Exception {
        return MetaInfoEngine.getBean(metaId);
    }

    @SuppressWarnings("unchecked")
    public IMetaInfoValue[] queryMetaInfos(String metaDesc, Map param) throws Exception {
        return MetaInfoEngine.getBeans(metaDesc, param);
    }

    @SuppressWarnings("unchecked")
    public IMetaInfoValue[] queryMetaInfos(String metaDesc, Map param, int startIndex, int endIndex) throws Exception {
        return MetaInfoEngine.getBeans(null, metaDesc, param, startIndex, endIndex, false);
    }

    public void updateMetaInfo(IMetaInfoValue metaInfo) throws Exception {
        MetaInfoEngine.save(metaInfo);
    }
}
