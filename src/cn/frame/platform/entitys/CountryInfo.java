package cn.frame.platform.entitys;

import java.util.Date;

public class CountryInfo {
    private String countyCode;

    private String countyName;

    private String cityCode;

    private String status;

    private String disOrder;

    private String countyPy;

    private String shortName;

    private String countyType;

    private String remark;

    private Date createTime;

    private Date updateTime;

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDisOrder() {
        return disOrder;
    }

    public void setDisOrder(String disOrder) {
        this.disOrder = disOrder;
    }

    public String getCountyPy() {
        return countyPy;
    }

    public void setCountyPy(String countyPy) {
        this.countyPy = countyPy;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getCountyType() {
        return countyType;
    }

    public void setCountyType(String countyType) {
        this.countyType = countyType;
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