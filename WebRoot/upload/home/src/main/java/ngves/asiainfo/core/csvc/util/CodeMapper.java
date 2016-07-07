package ngves.asiainfo.core.csvc.util;

import ngves.asiainfo.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

public class CodeMapper {
    private Map<String, String> aMapper = new HashMap<String, String>();
    private Map<String, String> bMapper = new HashMap<String, String>();
    
    private Map<String,String> nameMapper = new HashMap<String, String>();

    private String defaultACode = null;
    private String defaultBCode = null;

    public CodeMapper() {
        this.defaultACode = null;
        this.defaultBCode = null;
    }

    public CodeMapper(String defaultACode, String defaultBCode) {
        this.defaultACode = defaultACode;
        this.defaultBCode = defaultBCode;
    }

    public void register(String name, String aCode, String bCode) {
        if (aCode != null) {
            aMapper.put(aCode, bCode);
            //将配送方式类型的名称存储在映射表中
            nameMapper.put(aCode, name);
        }
        if (bCode != null) {
            bMapper.put(bCode, aCode);
        }
    }

    /**
      * 根据B编码获得A编码，如果没有，返回默认值
     * @param bCode
     * @return
     */
    public String getACodeByBCode(String bCode) {
        return getOrDefault(bCode, bMapper, defaultACode);
    }

    /**
     * 根据A编码获得B编码，如果没有，返回默认值
     * @param aCode
     * @return
     */
    public String getBCodeByACode(String aCode) {
        return getOrDefault(aCode, aMapper, defaultBCode);
    }

    /**
     * 根据A编码来获得名称，要求A编码不能为空，否则返回空值
     * @param aCode
     * @return
     */
    public String getNameByACode(String aCode){
    	return getOrDefault(aCode,nameMapper,defaultACode);
    }
    private String getOrDefault(String code, Map<String, String> mapper, String defaultValue) {
        if (StringUtil.isBlank(code)) {
            return defaultValue;
        }
        String ret = mapper.get(code);
        if (StringUtil.isBlank(ret)) {
            return defaultValue;
        }
        return ret;
    }
}