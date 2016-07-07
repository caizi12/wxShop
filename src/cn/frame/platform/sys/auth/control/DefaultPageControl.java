package cn.frame.platform.sys.auth.control;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DefaultPageControl {
	
	
	/**
	 * 默认页面
	 * @return
	 */
	@RequestMapping("/default")
	public ModelAndView  adminLoginPage(){
		return new ModelAndView("sys/login");
	}
	
	
	/**
	 * 登录后的默认欢迎页面
	 * @return
	 */
	@RequestMapping("/sys/homePage")
	public ModelAndView  adminHomePage(){
		return new ModelAndView("sys/main");
	}

}
