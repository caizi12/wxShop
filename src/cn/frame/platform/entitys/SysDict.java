package cn.frame.platform.entitys;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import cn.frame.platform.common.util.json.CustomDateDeserializer;
import cn.frame.platform.common.util.json.CustomDateSerializer;

public class SysDict {
	
	public SysDict(){};
	
    private Integer dictId;

    private String dictName;
    
    private String dictValue;

    private String dictType;

    private Integer dictTypeId;
    
    private String dictCategory;

    private String status;

    private String sort;

    private String note;

    private Date createDate;

    private Date updateDate;

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictValue() {
		return dictValue;
	}

	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}

	public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public Integer getDictTypeId() {
        return dictTypeId;
    }

    public void setDictTypeId(Integer dictTypeId) {
        this.dictTypeId = dictTypeId;
    }
    
    
    public String getDictCategory() {
		return dictCategory;
	}

	public void setDictCategory(String dictCategory) {
		this.dictCategory = dictCategory;
	}

	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @JsonSerialize(using=CustomDateSerializer.class)
    public Date getCreateDate() {
        return createDate;
    }
    @JsonDeserialize(using=CustomDateDeserializer.class)
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @JsonSerialize(using=CustomDateSerializer.class)
    public Date getUpdateDate() {
        return updateDate;
    }

    @JsonDeserialize(using=CustomDateDeserializer.class)
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}