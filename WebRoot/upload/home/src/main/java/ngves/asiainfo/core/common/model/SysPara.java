package ngves.asiainfo.core.common.model;

import java.io.Serializable;

public class SysPara implements Serializable {
private static final long serialVersionUID = 1L;
    
    private String text = null;
    
    private String value = null;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
