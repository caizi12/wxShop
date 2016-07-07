package cn.frame.platform.sys.weixin.control;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.frame.platform.pay.weixin.WeiXinOauth2Token;
import cn.frame.platform.pay.weixin.util.HttpsRequest;
import cn.frame.platform.sys.weixin.WeixinConstant;

/**
 * 微信公众号菜单管理
 * 
 * @author li
 * 
 */

@Controller
@RequestMapping("/weixin/menu")
public class WeixinMenuControl {
	private static Logger log = Logger.getLogger(WeixinMenuControl.class);

	/**
	 * 微信公众号菜单维护页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/menuPage")
	public ModelAndView receiveMsg(HttpServletRequest request, HttpServletResponse response) {
		String menuJsonStr=WeixinMenuControl.getMenu();
		Map<String,String> map=new HashMap<String,String>();
		map.put("menuJson", menuJsonStr);
		return new ModelAndView("sys/weixin/weixinMenuMng", "dataMap", map);
	}
	
	/**
	 * 更新微信公众号菜单
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/createMenu")
	@ResponseBody
	public String createMenu(HttpServletRequest request, HttpServletResponse response) {
		try {
			String menuData=request.getParameter("menuData");
			menuData=URLDecoder.decode(menuData,"UTF-8");
			HttpsRequest httpsRequest = new HttpsRequest();
			return httpsRequest.sendPost(WeixinConstant.MENU_CREATE_URL+WeiXinOauth2Token.getWeixinAccessToken(), menuData);
		
		}catch (Exception e) {
			log.error("添加微信公众号菜单失败",e);
			return null;
		}
	}

	
	/**
	 * 微信公众号菜单查询
	 * @param request
	 * @param response
	 * @return
	 */
	public static String getMenu() {
		try {
			HttpsRequest httpsRequest = new HttpsRequest();
			return httpsRequest.sendGet(WeixinConstant.MENU_GET_URL+WeiXinOauth2Token.getWeixinAccessToken());
		
		}catch (Exception e) {
			log.error("查询微信公众号菜单失败",e);
			return null;
		} 
	} 
	
	/**
	 * 删除微信公众号菜单
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/deleteMenu")
	@ResponseBody
	public String deleteMenu(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpsRequest httpsRequest = new HttpsRequest();
			return httpsRequest.sendGet(WeixinConstant.MENU_DELETE_URL+WeiXinOauth2Token.getWeixinAccessToken());
		
		}catch (Exception e) {
			log.error("删除微信公众号菜单失败",e);
			return null;
		} 
	} 
 
}   
