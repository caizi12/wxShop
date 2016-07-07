package ngves.asiainfo.core.ware.model;

import java.io.Serializable;

/**
 * 期刊杂志属性对象
 * @author zhulin
 *
 */
public class MagAttr implements Serializable{
    private static final long serialVersionUID = -652476780041853980L;
    //---杂志类型，当前只分单月刊，奇数双月刊，和偶数双月刊
    private String magType = "";
    //----出刊日----
    private String pubDate = "";
    //---提前出刊时间类型,0-当月出刊，1-提前一个月出刊，2-提前两个月出刊--
    private String beforePubType = "";
    //---期刊截止时间--
    private String magEndDate = "";
    
    public String getMagType() {
        return magType;
    }
    public void setMagType(String magType) {
        this.magType = magType;
    }
    public String getPubDate() {
        return pubDate;
    }
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }
    public String getBeforePubType() {
        return beforePubType;
    }
    public void setBeforePubType(String beforePubType) {
        this.beforePubType = beforePubType;
    }
    public String getMagEndDate() {
        return magEndDate;
    }
    public void setMagEndDate(String magEndDate) {
        this.magEndDate = magEndDate;
    }


}
