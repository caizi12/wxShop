package cn.frame.platform.entitys;

import java.util.Date;

public class CityInfo {
    private String cityCode;

    private String cityName;

    private String provinceCode;

    private String status;

    private String disOrder;

    private String cityPy;

    private String shortName;

    private String remark;

    private Date createTime;

    private Date updateTime;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
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

    public String getCityPy() {
        return cityPy;
    }

    public void setCityPy(String cityPy) {
        this.cityPy = cityPy;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
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