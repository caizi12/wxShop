package ngves.asiainfo.core.ware.util;

import java.util.List;

import ngves.asiainfo.core.common.cache.ICacheLoader;
import ngves.asiainfo.core.common.util.KeyUtil;
import ngves.asiainfo.core.ware.model.PermissionWareRuleVo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 规则Memcache
 * @author shenfl
 */
public class PermissionInfoCacheUtil {

    private static transient Log logger = LogFactory.getLog(PermissionWareViewUtil.class);

    public static ICacheLoader<List<PermissionWareRuleVo>> getAcCacheLoader() throws Exception {

        return new PermissionInfoCacheLoader();
    }

    public static class PermissionInfoCacheLoader implements ICacheLoader<List<PermissionWareRuleVo>> {

        public List<PermissionWareRuleVo> findBeansByKey(String key) throws Exception {
            logger.info("PermissionInfoCacheUtil by database:permissionId=" + key);
            String keys[] = KeyUtil.decomposeKey(key);
            List<PermissionWareRuleVo> permissionWareRuleVoList = null;
            if (keys != null && keys.length == 2) {
                String channel = keys[1];
                permissionWareRuleVoList =  PermissionWareViewUtil.createPermissionWareRuleList(channel);
            }
            return permissionWareRuleVoList;
        }
    }
}