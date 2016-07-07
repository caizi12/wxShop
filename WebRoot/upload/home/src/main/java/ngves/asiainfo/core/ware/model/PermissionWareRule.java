/**
 * Copyright (c) 2011 asiainfo-linkage.com
 */
package ngves.asiainfo.core.ware.model;

import java.io.Serializable;
import java.util.List;


/**
 * <p>礼品优惠规则</p>
 * @author shenfl
 *
 */
public class PermissionWareRule implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 8874367750998409010L;

    //基本规则
    private PermissionWareBean permissionWareBaseRule;

    //省份列表
    private List<String> permissionWareRuleProvs;

    //编码类型规则列表
    private List<String> permissionWareTypeCodes;

    public PermissionWareBean getPermissionWareBaseRule() {
        return permissionWareBaseRule;
    }

    public void setPermissionWareBaseRule(PermissionWareBean permissionWareBaseRule) {
        this.permissionWareBaseRule = permissionWareBaseRule;
    }

    public List<String> getPermissionWareRuleProvs() {
        return permissionWareRuleProvs;
    }

    public void setPermissionWareRuleProvs(List<String> permissionWareRuleProvs) {
        this.permissionWareRuleProvs = permissionWareRuleProvs;
    }

    public List<String> getPermissionWareTypeCodes() {
        return permissionWareTypeCodes;
    }

    public void setPermissionWareTypeCodes(List<String> permissionWareTypeCodes) {
        this.permissionWareTypeCodes = permissionWareTypeCodes;
    }

}
