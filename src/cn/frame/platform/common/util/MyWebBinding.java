package cn.frame.platform.common.util;

import java.util.Date;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 * 自定义属性编辑器,可自动把字符串类型日期转换为Date类型。 
 * 字符串应为"2012-10-12、2012-10-12 12:20:20"等标准字符日期格式
 * 
 * @date 2012-11-27 15:50:42
 * @author llliang
 * 
 */
public class MyWebBinding implements WebBindingInitializer {

	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(Date.class, new DateConvertEditor());  
	}
}
