package cn.frame.platform.sys.weixin.control;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.frame.platform.pay.weixin.WeiXinOauth2Token;
import cn.frame.platform.pay.weixin.util.HttpsRequest;
import cn.frame.platform.sys.weixin.WeixinConstant;

/**
 * 微信素材管理
 * 
 * @author li
 * 
 */

@Controller
@RequestMapping("/weixin/material")
public class MaterialControl {

	private static Logger log = Logger.getLogger(MaterialControl.class);

	/**
	 * 微信公众号菜单维护页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/materialPage")
	public ModelAndView materialPage(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("materialGetParam", WeixinConstant.MATERIAL_GET_PARAM);
		return new ModelAndView("sys/weixin/materialMng", "dataMap", map);
	}


	/**
	 * 微信公众号菜单查询
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getMaterial")
	@ResponseBody
	public static String getMaterial(HttpServletRequest request,HttpServletResponse response) {
		try {
			return MaterialControl.queryMaterialList(request.getParameter("materialParam"));
		} catch (Exception e) {
			log.error("查询微信公众号素材失败", e);
			return "";
		}
	}

 
	/**
	 * 查询公众号素材信息
	 * 
	 * @param paramStr
	 * @return
	 * @throws Exception
	 */
	public static String queryMaterialList(String paramStr) throws Exception {
		if (StringUtils.isBlank(paramStr)) {
			paramStr = WeixinConstant.MATERIAL_GET_PARAM;
		}
		HttpsRequest httpsRequest = new HttpsRequest();
		return httpsRequest.sendPost(WeixinConstant.MATERIAL_GET_URL + WeiXinOauth2Token.getWeixinAccessToken(),
				paramStr);
	}

	public static void main(String[] a) throws Exception {
		MaterialControl.queryMaterialList(null);
	}
}
