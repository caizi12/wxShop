package cn.frame.app.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.frame.platform.common.constant.ProductConstant;
import cn.frame.platform.sys.member.service.ProductInfoSrv;

@Controller
public class IndexControl  {
	
	@Autowired
	private ProductInfoSrv productInfoSrv;

	 /**
	  * 首页
	  * @param request
	  * @param response
	  * @return
	  * @throws Exception
	  */
	@SuppressWarnings("unchecked")
	@RequestMapping("/index")
	public ModelAndView indexPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
 
		Map paraMap=new HashMap();
		
		paraMap.put("isRecomend",ProductConstant.IS_RECOMEND_YES);
		List recomendProduct=productInfoSrv.queryProductInfoForFront(paraMap);
		paraMap.put("recomendProduct", recomendProduct);
 		return new ModelAndView("front/index","paraMap",paraMap);
	}
} 
