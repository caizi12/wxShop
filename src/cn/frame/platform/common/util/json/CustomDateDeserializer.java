package cn.frame.platform.common.util.json;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import cn.frame.platform.common.util.date.DateUtil;

/**
 * 
 * 反序列化JSON日期字符串为日期类型
 *  
 * @author li
 *
 */
public class CustomDateDeserializer extends JsonDeserializer<Date> {
	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		  JsonToken t = jp.getCurrentToken();
	        if (t == JsonToken.VALUE_NUMBER_INT) {
	            return new java.util.Date(jp.getLongValue());
	        }
	        if (t == JsonToken.VALUE_NULL) {
	            return (java.util.Date) getNullValue();
	        }
	        if (t == JsonToken.VALUE_STRING) {
	            try {
	                 
	                String str = jp.getText().trim();
	                if (str.length() == 0) {
	                    return (Date) getEmptyValue();
	                }
	                return DateUtil.parseDateStrToDate(str);
	            }catch (ParseException e) {
					e.printStackTrace();
				}
	            catch (IllegalArgumentException iae) {
	                throw ctxt.weirdStringException(this.getClass(), "not a valid representation (error: "+iae.getMessage()+")");
	            } 
	        }
	        throw ctxt.mappingException(this.getClass(), t);
	}
 
}