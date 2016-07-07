package cn.frame.platform.common.util.json;

import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import cn.frame.platform.common.util.date.DateUtil;
/**
 * 
 * 序列化日期类型为日期字符串
 * 格式化后的格式为： yyyy-MM-dd
 * @author li
 *
 */
public class CustomDateYMDSerializer extends JsonSerializer<Date> {
	@Override
	public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		if(value==null)return;
		String formattedDate = DateUtil.formatDateForTime(value);
		jgen.writeString(formattedDate);
	}
}