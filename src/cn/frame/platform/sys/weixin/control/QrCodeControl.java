package cn.frame.platform.sys.weixin.control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.frame.platform.pay.weixin.WeiXinOauth2Token;
import cn.frame.platform.pay.weixin.util.HttpsRequest;
import cn.frame.platform.sys.weixin.WeixinConstant;

/**
 * 二维码生成control
 * 
 * @author li
 * 
 */

@Controller
@RequestMapping("/weixin/qr")
public class QrCodeControl {

	@SuppressWarnings("unchecked")
	@RequestMapping("/createQrPage")
	public ModelAndView createQmPage() {

		Map map = new HashMap();
		return new ModelAndView("sys/qr/createQR", "dictMap", map);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/createQrCode")
	@ResponseBody
	public String createQrCode() {
		try {
			String access_token =  WeiXinOauth2Token.getWeixinAccessToken();
			if (access_token != null) {

				HttpsRequest request = new HttpsRequest();
				return request.sendPost(WeixinConstant.QM_CODE_URL+access_token,
					   WeixinConstant.QM_PARAM_DATA.replace("SCENE_STR", WeixinConstant.EVENT_KEY_SCAN_QR_REGISTER+"100000"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// true:允许输入空值，false:不能为空值
	}
}
