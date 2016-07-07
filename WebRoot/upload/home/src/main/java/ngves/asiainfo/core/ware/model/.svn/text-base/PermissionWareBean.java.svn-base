/**
 * Copyright (c) 2012 asiainfo-linkage.com
 */
package ngves.asiainfo.core.ware.model;

import java.io.Serializable;

/**
 * <p>封装基本规则</p>
 * @author shenfl
 *
 */
public class PermissionWareBean implements Serializable {

    private static final long serialVersionUID = -5310431613337628345L;

    //优惠礼品ID
    private long wareId;

    //优惠礼品名称
    private String wareName;
    //规则ID
    private long permissionId;

    //优惠礼品统一积分
    private long WareGmeValue;

    //当前规则支持的兑换渠道： 8-0001  WEB渠道   4-0002  短信渠道  2-0003  CRM渠道-营业厅 1-0004  WAP渠道  2-0005  CRM渠道-10086 16-1001 合作商-浦发
    private String exchangeChannel;

    //前规则支持优惠类型： 00-仅支持普通兑换01-支持优惠兑换及普通兑换   02-仅支持优惠兑换
    private String supportType;

    //支持手机品牌
    private String supportMobileBrand;
    //礼品范围
    private String ItemScope;
    
    public String getItemScope() {
        return ItemScope;
    }

    public void setItemScope(String itemScope) {
        ItemScope = itemScope;
    }

    public String getSupportMobileBrand() {
        return supportMobileBrand;
    }

    public void setSupportMobileBrand(String supportMobileBrand) {
        this.supportMobileBrand = supportMobileBrand;
    }

    public String getWareName() {
        return wareName;
    }

    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

    public String getSupportType() {
        return supportType;
    }

    public void setSupportType(String supportType) {
        this.supportType = supportType;
    }

    public String getExchangeChannel() {
        return exchangeChannel;
    }

    public void setExchangeChannel(String exchangeChannel) {
        this.exchangeChannel = exchangeChannel;
    }

    public long getWareGmeValue() {
        return WareGmeValue;
    }

    public void setWareGmeValue(long wareGmeValue) {
        WareGmeValue = wareGmeValue;
    }

    public long getWareId() {
        return wareId;
    }

    public void setWareId(long wareId) {
        this.wareId = wareId;
    }

    public long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(long permissionId) {
        this.permissionId = permissionId;
    }
}
