package cn.frame.platform.entitys;

import java.util.Date;

public class MemberRecomendInfo {
    private Integer recomendRelationId;

    private Integer recomendMemberId;

    private Integer memberId;

    private String recomendType;

    private String remark;

    private Date createTime;

    private Date updateTime;

    public Integer getRecomendRelationId() {
        return recomendRelationId;
    }

    public void setRecomendRelationId(Integer recomendRelationId) {
        this.recomendRelationId = recomendRelationId;
    }

    public Integer getRecomendMemberId() {
        return recomendMemberId;
    }

    public void setRecomendMemberId(Integer recomendMemberId) {
        this.recomendMemberId = recomendMemberId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getRecomendType() {
        return recomendType;
    }

    public void setRecomendType(String recomendType) {
        this.recomendType = recomendType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}