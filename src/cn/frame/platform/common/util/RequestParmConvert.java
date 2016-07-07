package cn.frame.platform.common.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import cn.frame.platform.common.base.DataGridModel;

/**
 * 转换requestParameters到Map中,实现自动封装请求的参数
 * @date 2012-09-24 20:10:58
 * @author llliang
 *
 */
public class RequestParmConvert {
	
	/**
	 * 获取request中的数据转换到Map中
	 *  元素name属性做为key值
	 * @param HttpServletRequest request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> intropectToMap(HttpServletRequest request) {
		Enumeration e = request.getParameterNames();
		Map<String, Object> parmMap = new HashMap<String, Object>();
		String name =null;
		while (e.hasMoreElements()) {
			name= (String) e.nextElement();
			parmMap.put(name, request.getParameter(name));
		}
		return parmMap;
	}


	 /**
	  * 获取request中的数据转换到DataGridModel中
	  * @param request
	  * @param dataGrid
	  * @return
	  */
	@SuppressWarnings("unchecked")
	public static DataGridModel intropectToDataGrid(HttpServletRequest request,DataGridModel dataGrid) {
		//每页条数
		if(StringUtils.isNotEmpty(request.getParameter("rows"))){
			dataGrid.setPagesize(Integer.valueOf(request.getParameter("rows")));
		}
		dataGrid.setQueryMap(intropectToMap(request));
		return dataGrid;
	}
	
}
