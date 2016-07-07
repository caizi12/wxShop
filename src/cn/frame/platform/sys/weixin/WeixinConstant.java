package cn.frame.platform.sys.weixin;

import cn.frame.platform.pay.weixin.PayConstant;

/**
 * 微信常量类
 * 
 * @author li
 * 
 */
public class WeixinConstant {
	

	/**
	 * 获取微信access_token URL
	 */
	public static final String WEIXIN_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
			+ PayConstant.appID + "&secret=" + PayConstant.AppSecret;

	/**
	 * 二维码生成URL （post）
	 */
	public static final String QM_CODE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";

	/**
	 * 微信永久二维码生成发送请求数据
	 */
	public static final String QM_PARAM_DATA = "{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \"SCENE_STR\"}}}";
	
	/**
	 * 微信公众号菜创建菜单url
	 */
	public static final String MENU_CREATE_URL="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
	
	/**
	 * 微信公众号删除菜单url
	 */
	public static final String MENU_DELETE_URL="https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=";
	
	/**
	 * 微信公众号查询菜单url
	 */
	public static final String MENU_GET_URL="https://api.weixin.qq.com/cgi-bin/menu/get?access_token=";
	
	/**
	 * 微信公众号素材查询菜单url
	 */
	public static final String MATERIAL_GET_URL="https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=";
	 
	/**
	 * 微信公众号素材查询post参数-默认按图文类型 
	 */
	public static final String MATERIAL_GET_PARAM="{\"type\":\"news\",\"offset\":0,\"count\":20 }";
	
	/**
	 * 
	 * 扫描微信二维码事件,用户注册，eventKey接收
	 */
	public static final String EVENT_KEY_SCAN_QR_REGISTER="QR1000_";
	
	/**
	 * 
	 * 回复微信消息，msg_type值类型，news：图文类消息
	 */
	public static final String REPLY_MSG_TYPE_NEWS="news";
	
	/**
	 * 微信二维码下载地址
	 */
	public static final String QR_CODE_DOWNLOAD_URL="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";
}
